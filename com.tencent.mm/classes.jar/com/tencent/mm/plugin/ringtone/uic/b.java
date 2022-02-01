package com.tencent.mm.plugin.ringtone.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "hideVkb", "Landroidx/lifecycle/MutableLiveData;", "", "getHideVkb", "()Landroidx/lifecycle/MutableLiveData;", "setHideVkb", "(Landroidx/lifecycle/MutableLiveData;)V", "mCalledType", "", "mRingtoneEntranceChannel", "getMRingtoneEntranceChannel", "()I", "setMRingtoneEntranceChannel", "(I)V", "mUserName", "goToMoreRingtoneUI", "", "initRingtoneSelectListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "checkAddDefault", "isSettingGlobalRingtone", "onChoiceRingtone", "info", "playInfo", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPlayRingtone", "item", "id", "", "play", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  int OED;
  public int OEE;
  public x<Boolean> OEF;
  private final String TAG;
  String luk;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273319);
    this.TAG = "MicroMsg.RingtoneDataUIC";
    this.OED = 1;
    this.OEE = 1;
    this.luk = "";
    this.OEF = new x();
    AppMethodBeat.o(273319);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.ringtone.b.e> BP(boolean paramBoolean)
  {
    AppMethodBeat.i(273379);
    Object localObject = new ArrayList();
    if ((gOP()) && (paramBoolean)) {
      ((ArrayList)localObject).add(new com.tencent.mm.plugin.ringtone.b.e(com.tencent.mm.plugin.ringtone.b.b.gOv()));
    }
    localObject = new WxRecyclerAdapter((g)new b(this), (ArrayList)localObject, true);
    ((WxRecyclerAdapter)localObject).bf(true);
    ((i)localObject).agOe = ((i.c)new a(this));
    AppMethodBeat.o(273379);
    return localObject;
  }
  
  public final boolean gOP()
  {
    return this.OED == 1;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(273370);
    super.onCreate(paramBundle);
    this.OED = getIntent().getIntExtra("ringtone_caller", 1);
    String str = getIntent().getStringExtra("exclusvie_name");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    this.luk = paramBundle;
    this.OEE = getIntent().getIntExtra("channel", 0);
    if (((CharSequence)this.luk).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.e(this.TAG, "not pass exclusive ringtone name, default my username");
        paramBundle = com.tencent.mm.model.z.bAM();
        s.s(paramBundle, "getUsernameFromUserInfo()");
        this.luk = paramBundle;
      }
      Log.i(this.TAG, s.X("userName:", this.luk));
      AppMethodBeat.o(273370);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273388);
    super.onDestroy();
    com.tencent.mm.plugin.ringtone.l.a locala = com.tencent.mm.plugin.ringtone.l.a.OFQ;
    com.tencent.mm.plugin.ringtone.l.a.gPd();
    AppMethodBeat.o(273388);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneDataUIC$initRingtoneSelectListAdapter$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    a(b paramb) {}
    
    private static final void a(RecyclerView.a parama, int paramInt, b paramb, View paramView)
    {
      AppMethodBeat.i(273226);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneDataUIC$initRingtoneSelectListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      s.u(parama, "$adapter");
      s.u(paramb, "this$0");
      paramView = com.tencent.mm.plugin.ringtone.d.b.tK(((com.tencent.mm.plugin.ringtone.b.e)((List)((WxRecyclerAdapter)parama).data).get(paramInt)).bZA());
      aa localaa;
      if (paramView != null)
      {
        localObject1 = (com.tencent.mm.plugin.ringtone.b.e)((List)((WxRecyclerAdapter)parama).data).get(paramInt);
        s.u(localObject1, "info");
        s.u(paramView, "playInfo");
        localObject2 = new Intent();
        localaa = ((com.tencent.mm.plugin.ringtone.b.e)localObject1).OCa;
        ((Intent)localObject2).putExtra("exclusvie_name", paramb.luk);
        if (localaa.vhJ == 100) {
          kotlinx.coroutines.j.a(paramb.getLifecycleScope(), null, null, (m)new b.c(paramb, (com.tencent.mm.plugin.ringtone.b.e)localObject1, (Intent)localObject2, null), 3);
        }
      }
      else
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/uic/RingtoneDataUIC$initRingtoneSelectListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(273226);
        return;
      }
      com.tencent.mm.protocal.protobuf.a.z localz = new com.tencent.mm.protocal.protobuf.a.z();
      localz.abaj = 0;
      if (localaa.vhJ == 1)
      {
        parama = localaa.acjr;
        if (parama == null)
        {
          paramInt = 60000;
          label267:
          localz.abak = paramInt;
          label273:
          parama = localaa.acjs;
          if (parama != null) {
            break label413;
          }
          parama = null;
          label285:
          localz.acji = parama;
          parama = localaa.acjr;
          if (parama != null) {
            break label421;
          }
        }
      }
      label413:
      label421:
      for (parama = null;; parama = parama.acjj)
      {
        localz.acjh = parama;
        localz.vhJ = localaa.vhJ;
        parama = w.a((Context)paramb.getContext(), (CharSequence)paramb.getContext().getResources().getString(b.f.setting_loading), false, 3, null);
        if (parama != null) {
          parama.show();
        }
        kotlinx.coroutines.j.a(paramb.getLifecycleScope(), null, null, (m)new b.d(localz, paramb, paramView, parama, (com.tencent.mm.plugin.ringtone.b.e)localObject1, (Intent)localObject2, null), 3);
        break;
        paramInt = (int)parama.acjm;
        break label267;
        localz.abak = ((int)paramView.mEndTime);
        break label273;
        parama = parama.aciR;
        break label285;
      }
    }
    
    private static final void b(RecyclerView.a parama, int paramInt)
    {
      AppMethodBeat.i(273236);
      s.u(parama, "$adapter");
      parama.t(paramInt, Boolean.FALSE);
      AppMethodBeat.o(273236);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneDataUIC$initRingtoneSelectListAdapter$adapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    b(b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(273227);
      Log.i(b.b(this.OEG), s.X("getItemConvert, type:", Integer.valueOf(paramInt)));
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.ringtone.b.f();
      AppMethodBeat.o(273227);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(b paramb, com.tencent.mm.plugin.ringtone.b.e parame, Intent paramIntent, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273234);
      paramObject = (kotlin.d.d)new c(this.OEG, this.OEH, this.OEI, paramd);
      AppMethodBeat.o(273234);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273225);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273225);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (!s.p(b.c(this.OEG), com.tencent.mm.model.z.bAM())) {
          break label228;
        }
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        Object localObject = (e)com.tencent.mm.ui.component.k.d(this.OEG.getActivity()).q(e.class);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        h localh = new h(kotlin.d.a.b.au(paramObject));
        kotlin.d.d locald = (kotlin.d.d)localh;
        kotlinx.coroutines.j.a(((e)localObject).getLifecycleScope(), null, null, (m)new e.b((e)localObject, locald, null), 3);
        localObject = localh.kli();
        if (localObject == kotlin.d.a.a.aiwj) {
          s.u(paramObject, "frame");
        }
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(273225);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      if (((Boolean)paramObject).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(bool) {});
        label228:
        paramObject = ah.aiuX;
        AppMethodBeat.o(273225);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    boolean YF;
    Object Ze;
    int label;
    
    d(com.tencent.mm.protocal.protobuf.a.z paramz, b paramb, com.tencent.mm.plugin.ringtone.g.d paramd, w paramw, com.tencent.mm.plugin.ringtone.b.e parame, Intent paramIntent, kotlin.d.d<? super d> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273258);
      paramObject = (kotlin.d.d)new d(this.OEJ, this.OEG, this.OEK, this.OEL, this.OEH, this.OEI, paramd);
      AppMethodBeat.o(273258);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(273255);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      final com.tencent.mm.plugin.ringtone.b.e locale;
      Object localObject1;
      Object localObject5;
      Object localObject6;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273255);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject2 = this.OEJ;
        paramObject = this.OEG;
        localObject3 = this.OEK;
        localObject4 = this.OEL;
        locale = this.OEH;
        localObject1 = this.OEI;
        if (!s.p(b.c(paramObject), com.tencent.mm.model.z.bAM()))
        {
          localObject5 = com.tencent.mm.ui.component.k.aeZF;
          localObject5 = (c)com.tencent.mm.ui.component.k.d(paramObject.getActivity()).q(c.class);
          localObject6 = b.c(paramObject);
          this.L$0 = paramObject;
          this.Uf = localObject3;
          this.VC = localObject4;
          this.VD = locale;
          this.Ze = localObject1;
          this.label = 1;
          h localh = new h(kotlin.d.a.b.au(this));
          kotlin.d.d locald = (kotlin.d.d)localh;
          kotlinx.coroutines.j.a(((c)localObject5).getLifecycleScope(), null, null, (m)new c.b((com.tencent.mm.protocal.protobuf.a.z)localObject2, (String)localObject6, locald, null), 3);
          localObject5 = localh.kli();
          if (localObject5 == kotlin.d.a.a.aiwj) {
            s.u(this, "frame");
          }
          if (localObject5 != locala) {
            break label889;
          }
          AppMethodBeat.o(273255);
          return locala;
        }
        break;
      case 1: 
        localObject2 = (Intent)this.Ze;
        locale = (com.tencent.mm.plugin.ringtone.b.e)this.VD;
        localObject5 = (w)this.VC;
        localObject3 = (com.tencent.mm.plugin.ringtone.g.d)this.Uf;
        localObject4 = (b)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject4;
        localObject4 = localObject1;
        localObject1 = localObject5;
      }
      for (;;)
      {
        final boolean bool = ((Boolean)localObject4).booleanValue();
        if (bool)
        {
          localObject4 = com.tencent.mm.plugin.ringtone.d.OBx;
          localObject5 = b.c(paramObject);
          this.L$0 = paramObject;
          this.Uf = localObject3;
          this.VC = localObject1;
          this.VD = locale;
          this.Ze = localObject2;
          this.YF = bool;
          this.label = 2;
          if (((com.tencent.mm.plugin.ringtone.d)localObject4).a((String)localObject5, (com.tencent.mm.plugin.ringtone.g.d)localObject3, this) == locala)
          {
            AppMethodBeat.o(273255);
            return locala;
            bool = this.YF;
            localObject2 = (Intent)this.Ze;
            locale = (com.tencent.mm.plugin.ringtone.b.e)this.VD;
            localObject1 = (w)this.VC;
            localObject3 = (com.tencent.mm.plugin.ringtone.g.d)this.Uf;
            localObject4 = (b)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            paramObject = localObject4;
            com.tencent.mm.plugin.ringtone.d.a(b.c(paramObject), (com.tencent.mm.plugin.ringtone.g.d)localObject3);
          }
        }
        for (;;)
        {
          if (bool) {}
          for (bool = true;; bool = false)
          {
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a((w)localObject1, bool, paramObject, locale, (Intent)localObject2));
            paramObject = ah.aiuX;
            AppMethodBeat.o(273255);
            return paramObject;
          }
          localObject4 = com.tencent.mm.ui.component.k.aeZF;
          localObject4 = (e)com.tencent.mm.ui.component.k.d(paramObject.getActivity()).q(e.class);
          this.L$0 = paramObject;
          this.Uf = localObject3;
          this.VC = locale;
          this.VD = localObject1;
          this.label = 3;
          localObject5 = new h(kotlin.d.a.b.au(this));
          localObject6 = (kotlin.d.d)localObject5;
          kotlinx.coroutines.j.a(((e)localObject4).getLifecycleScope(), null, null, (m)new e.d((com.tencent.mm.protocal.protobuf.a.z)localObject2, (kotlin.d.d)localObject6, null), 3);
          localObject4 = ((h)localObject5).kli();
          if (localObject4 == kotlin.d.a.a.aiwj) {
            s.u(this, "frame");
          }
          if (localObject4 == locala)
          {
            AppMethodBeat.o(273255);
            return locala;
            localObject1 = (Intent)this.VD;
            locale = (com.tencent.mm.plugin.ringtone.b.e)this.VC;
            localObject2 = (com.tencent.mm.plugin.ringtone.g.d)this.Uf;
            localObject4 = (b)this.L$0;
            ResultKt.throwOnFailure(paramObject);
            localObject3 = paramObject;
            paramObject = localObject4;
            localObject4 = localObject3;
          }
          for (;;)
          {
            bool = ((Boolean)localObject4).booleanValue();
            if (bool)
            {
              localObject3 = com.tencent.mm.plugin.ringtone.d.OBx;
              this.L$0 = paramObject;
              this.Uf = localObject2;
              this.VC = locale;
              this.VD = localObject1;
              this.YF = bool;
              this.label = 4;
              if (((com.tencent.mm.plugin.ringtone.d)localObject3).a("", (com.tencent.mm.plugin.ringtone.g.d)localObject2, this) == locala)
              {
                AppMethodBeat.o(273255);
                return locala;
                bool = this.YF;
                localObject1 = (Intent)this.VD;
                locale = (com.tencent.mm.plugin.ringtone.b.e)this.VC;
                localObject2 = (com.tencent.mm.plugin.ringtone.g.d)this.Uf;
                localObject3 = (b)this.L$0;
                ResultKt.throwOnFailure(paramObject);
                paramObject = localObject3;
                label818:
                localObject3 = com.tencent.mm.model.z.bAM();
                s.s(localObject3, "getUsernameFromUserInfo()");
                com.tencent.mm.plugin.ringtone.d.a((String)localObject3, (com.tencent.mm.plugin.ringtone.g.d)localObject2);
              }
            }
            for (;;)
            {
              if (bool) {}
              for (bool = true;; bool = false)
              {
                com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(bool, paramObject, locale, (Intent)localObject1));
                break;
              }
              break label818;
            }
            localObject2 = localObject3;
          }
          break;
        }
        label889:
        localObject2 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject5;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(w paramw, boolean paramBoolean, b paramb, com.tencent.mm.plugin.ringtone.b.e parame, Intent paramIntent)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(boolean paramBoolean, b paramb, com.tencent.mm.plugin.ringtone.b.e parame, Intent paramIntent)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.b
 * JD-Core Version:    0.7.0.1
 */