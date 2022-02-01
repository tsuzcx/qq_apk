package com.tencent.mm.plugin.ringtone.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ringtone.PluginRingtone;
import com.tencent.mm.plugin.ringtone.PluginRingtone.a;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.f;
import com.tencent.mm.plugin.ringtone.c.a.b;
import com.tencent.mm.plugin.ringtone.c.a.b.a;
import com.tencent.mm.plugin.ringtone.d.c.b.a;
import com.tencent.mm.plugin.ringtone.widget.b.b;
import com.tencent.mm.protocal.protobuf.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "emptyAddTipsButton", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getEmptyAddTipsButton", "()Landroid/view/View;", "emptyAddTipsButton$delegate", "Lkotlin/Lazy;", "exclusiveRingtoneLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "exclusiveRingtoneList", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getExclusiveRingtoneList", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "exclusiveRingtoneList$delegate", "exclusiveTipLayout", "getExclusiveTipLayout", "exclusiveTipLayout$delegate", "hasExclusiveTv", "getHasExclusiveTv", "hasExclusiveTv$delegate", "newAddTipsButton", "getNewAddTipsButton", "newAddTipsButton$delegate", "ringtoneAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "bindDataSource", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onDeleteRingtone", "username", "", "onDestroy", "onPlayRingtone", "item", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "id", "", "play", "", "onResume", "onStopPlayRingtone", "pickNewPerson", "reInitAdapter", "memberList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "refreshAddUI", "showReplaceRingtone", "exclusive", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  private final kotlin.j OEU;
  private LinearLayoutManager OEV;
  private final kotlin.j OEW;
  private final kotlin.j OEX;
  private final kotlin.j OEY;
  private final kotlin.j OEZ;
  private WxRecyclerAdapter<com.tencent.mm.plugin.ringtone.b.c> OFa;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273402);
    this.OEU = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.OEW = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.OEX = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.OEY = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.OEZ = kotlin.k.cm((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(273402);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(273461);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    Log.i("SimpleUIComponent", "on click add ui link to add new ringtone");
    paramd.gOU();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273461);
  }
  
  private static final void a(d paramd, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(273465);
    kotlin.g.b.s.u(paramd, "this$0");
    params.c(b.b.OGg.ordinal(), (CharSequence)paramd.getContext().getString(b.f.settings_ringtone_replace_exclusive));
    params.a(b.b.OGh.ordinal(), paramd.getContext().getResources().getColor(b.a.Red), (CharSequence)paramd.getContext().getString(b.f.app_delete));
    AppMethodBeat.o(273465);
  }
  
  private static final void a(String paramString, d paramd, com.tencent.mm.plugin.ringtone.b.c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(273473);
    kotlin.g.b.s.u(paramString, "$username");
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(paramc, "$exclusive");
    paramInt = paramMenuItem.getItemId();
    if (paramInt == b.b.OGg.ordinal())
    {
      paramc = com.tencent.mm.plugin.ringtone.d.a.tK(paramc.bZA());
      if ((paramc != null) && (paramc.ODD != null) && (paramc.gOD().fileName != null) && (com.tencent.mm.plugin.au.b.b.a(paramc.gOD()))) {}
      for (boolean bool = true;; bool = false)
      {
        paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
        com.tencent.mm.ui.component.k.d(paramd.getActivity()).q(n.class);
        n.c(paramc, paramString, bool);
        paramc = com.tencent.mm.ui.component.k.aeZF;
        paramInt = ((b)com.tencent.mm.ui.component.k.d(paramd.getActivity()).q(b.class)).OEE;
        paramc = PluginRingtone.OBl;
        PluginRingtone.a.enterRingtoneSelectUI((Activity)paramd.getActivity(), 2, paramString, paramInt);
        AppMethodBeat.o(273473);
        return;
      }
    }
    if ((paramInt == b.b.OGh.ordinal()) && (paramString != null))
    {
      paramc = com.tencent.mm.ui.component.k.aeZF;
      paramd = (c)com.tencent.mm.ui.component.k.d(paramd.getActivity()).q(c.class);
      kotlin.g.b.s.u(paramString, "username");
      paramc = com.tencent.mm.ui.base.w.a((Context)paramd.getContext(), (CharSequence)paramd.getContext().getResources().getString(b.f.delete_loading), false, 3, null);
      if (paramc != null) {
        paramc.show();
      }
      kotlinx.coroutines.j.a(paramd.getLifecycleScope(), null, null, (m)new c.c(paramString, paramd, paramc, null), 3);
    }
    AppMethodBeat.o(273473);
  }
  
  private final void br(ArrayList<com.tencent.mm.plugin.ringtone.b.c> paramArrayList)
  {
    AppMethodBeat.i(273440);
    this.OFa = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new j(this), paramArrayList, true);
    gOQ().a((RecyclerView.l)new k(this));
    paramArrayList = this.OFa;
    if (paramArrayList != null) {
      paramArrayList.agOe = ((i.c)new l(this));
    }
    gOQ().setAdapter((RecyclerView.a)this.OFa);
    AppMethodBeat.o(273440);
  }
  
  private final WxRecyclerView gOQ()
  {
    AppMethodBeat.i(273411);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.OEU.getValue();
    AppMethodBeat.o(273411);
    return localWxRecyclerView;
  }
  
  private final View gOR()
  {
    AppMethodBeat.i(273420);
    View localView = (View)this.OEW.getValue();
    AppMethodBeat.o(273420);
    return localView;
  }
  
  private final View gOS()
  {
    AppMethodBeat.i(273427);
    View localView = (View)this.OEX.getValue();
    AppMethodBeat.o(273427);
    return localView;
  }
  
  private final View gOT()
  {
    AppMethodBeat.i(273430);
    View localView = (View)this.OEZ.getValue();
    AppMethodBeat.o(273430);
    return localView;
  }
  
  private final void gOU()
  {
    AppMethodBeat.i(273450);
    Intent localIntent = new Intent();
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.w.ow(com.tencent.mm.ui.contact.w.affo, 64));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("titile", getString(b.f.settings_exclusive_ringtone_pick_new_person));
    localIntent.putExtra("show_too_many_member", false);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("scene", 6);
    ArrayList localArrayList = new ArrayList();
    Object localObject = com.tencent.mm.plugin.ringtone.d.gOs();
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((com.tencent.mm.plugin.ringtone.g.a)((Iterator)localObject).next()).name;
        if (str == null)
        {
          AppMethodBeat.o(273450);
          return;
        }
        localArrayList.add(str);
      }
    }
    localArrayList.add(z.bAM());
    localIntent.putExtra("block_contact", p.a((Iterable)localArrayList, (CharSequence)",", null, null, 0, null, (kotlin.g.a.b)d.i.OFd, 30));
    com.tencent.mm.br.c.d((Context)getActivity(), ".ui.contact.SelectContactUI", localIntent, 8);
    AppMethodBeat.o(273450);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273540);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 8) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      Object localObject = (CharSequence)paramIntent;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        Log.w("SimpleUIComponent", kotlin.g.b.s.X("empty or null contact: ", paramIntent));
        AppMethodBeat.o(273540);
        return;
      }
      localObject = com.tencent.mm.ui.component.k.aeZF;
      paramInt1 = ((b)com.tencent.mm.ui.component.k.d(getActivity()).q(b.class)).OEE;
      localObject = PluginRingtone.OBl;
      PluginRingtone.a.enterRingtoneSelectUI(getContext(), 2, paramIntent, paramInt1);
    }
    AppMethodBeat.o(273540);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273536);
    super.onDestroy();
    com.tencent.mm.plugin.ringtone.l.a locala = com.tencent.mm.plugin.ringtone.l.a.OFQ;
    com.tencent.mm.plugin.ringtone.l.a.gPd();
    AppMethodBeat.o(273536);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273534);
    super.onResume();
    kotlinx.coroutines.j.a(getLifecycleScope(), null, null, (m)new g(this, null), 3);
    getActivity();
    this.OEV = new LinearLayoutManager();
    gOQ().setLayoutManager((RecyclerView.LayoutManager)this.OEV);
    WxRecyclerView localWxRecyclerView = gOQ();
    h localh = new h();
    localh.bD(2, 10);
    ah localah = ah.aiuX;
    localWxRecyclerView.setRecycledViewPool((RecyclerView.m)localh);
    kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new a(this, null), 3);
    br(new ArrayList());
    AppMethodBeat.o(273534);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(d paramd, kotlin.d.d<? super a> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273259);
      paramObject = (kotlin.d.d)new a(this.OFb, paramd);
      AppMethodBeat.o(273259);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273256);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273256);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = ((c)com.tencent.mm.ui.component.k.d(this.OFb.getActivity()).q(c.class)).OEP;
        if (paramObject != null)
        {
          paramObject = paramObject.OCf;
          if (paramObject != null)
          {
            paramObject = (kotlinx.coroutines.b.g)paramObject;
            kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.OFb);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (paramObject.a(localh, locald) == locala)
            {
              AppMethodBeat.o(273256);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(273256);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<a.b>
    {
      public a(d paramd) {}
      
      public final Object a(a.b paramb, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(273311);
        paramd = (a.b)paramb;
        int i;
        Object localObject1;
        label97:
        Object localObject2;
        if ((paramd instanceof a.b.a)) {
          switch (((a.b.a)paramd).EcS)
          {
          case 2: 
          case 3: 
          default: 
            paramb = d.a(this.OFb);
            if (paramb == null)
            {
              i = 0;
              paramb = ((a.b.a)paramd).OCn;
              if (paramb == null) {
                break label725;
              }
              localObject1 = ((Iterable)paramb).iterator();
            }
            break;
          case 1: 
            for (;;)
            {
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (com.tencent.mm.plugin.ringtone.b.c)((Iterator)localObject1).next();
                paramb = d.a(this.OFb);
                if (paramb == null)
                {
                  paramb = null;
                  label133:
                  if (paramb != null) {
                    break label694;
                  }
                  paramb = d.a(this.OFb);
                  if (paramb == null) {
                    continue;
                  }
                  paramb = (List)paramb.data;
                  if (paramb == null) {
                    continue;
                  }
                  paramb.add(localObject2);
                  continue;
                  d.a(this.OFb, new ArrayList());
                }
              }
            }
          }
        }
        label633:
        label764:
        do
        {
          for (;;)
          {
            d.c(this.OFb);
            paramb = ah.aiuX;
            AppMethodBeat.o(273311);
            return paramb;
            paramb = ((a.b.a)paramd).OCn;
            if (paramb != null)
            {
              paramb = ((Iterable)paramb).iterator();
              while (paramb.hasNext())
              {
                paramd = (com.tencent.mm.plugin.ringtone.b.c)paramb.next();
                Log.i("SimpleUIComponent", "current member  data must be delete " + paramd.OBY.UserName + " and " + paramd.OBY);
                localObject1 = new ArrayList();
                localObject2 = d.a(this.OFb);
                if (localObject2 != null)
                {
                  localObject2 = (List)((WxRecyclerAdapter)localObject2).data;
                  if (localObject2 != null)
                  {
                    localObject2 = ((Iterable)localObject2).iterator();
                    while (((Iterator)localObject2).hasNext())
                    {
                      localObject3 = (com.tencent.mm.plugin.ringtone.b.c)((Iterator)localObject2).next();
                      if (((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA() != paramd.bZA()) {
                        ((ArrayList)localObject1).add(localObject3);
                      } else if (((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg) {
                        d.b(this.OFb);
                      }
                    }
                  }
                }
                d.a(this.OFb, (ArrayList)localObject1);
                localObject1 = d.a(this.OFb);
                if (localObject1 != null)
                {
                  paramd = com.tencent.mm.view.recyclerview.i.c((com.tencent.mm.view.recyclerview.i)localObject1, paramd.bZA());
                  if (paramd != null) {
                    ((com.tencent.mm.view.recyclerview.i)localObject1).fX(paramd.KJ());
                  }
                }
              }
              paramb = ((a.b.a)paramd).OCn;
              if (paramb != null)
              {
                paramd = new ArrayList();
                paramd.addAll((Collection)paramb);
                d.a(this.OFb, paramd);
                paramb = ((Iterable)paramd).iterator();
                while (paramb.hasNext())
                {
                  paramd = (com.tencent.mm.plugin.ringtone.b.c)paramb.next();
                  Log.i("SimpleUIComponent", "current member  data must be init from cache " + paramd.OBY.UserName + " and " + paramd.OBY);
                }
                paramb = d.a(this.OFb);
                if (paramb != null) {
                  paramb.bZE.notifyChanged();
                }
              }
            }
          }
          paramb = (List)paramb.data;
          if (paramb == null)
          {
            i = 0;
            break;
          }
          i = paramb.size();
          break;
          paramb = (List)paramb.data;
          if (paramb == null)
          {
            paramb = null;
            break label133;
          }
          Object localObject3 = ((Iterable)paramb).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramb = ((Iterator)localObject3).next();
            if (((com.tencent.mm.plugin.ringtone.b.c)paramb).bZA() == ((com.tencent.mm.plugin.ringtone.b.c)localObject2).bZA())
            {
              j = 1;
              if (j == 0) {
                break label687;
              }
            }
          }
          for (;;)
          {
            paramb = (com.tencent.mm.plugin.ringtone.b.c)paramb;
            break;
            j = 0;
            break label670;
            break label633;
            paramb = null;
          }
          paramb.hJg = false;
          localObject2 = d.a(this.OFb);
          if (localObject2 == null) {
            break label97;
          }
          ((WxRecyclerAdapter)localObject2).AQ(paramb.bZA());
          break label97;
          paramb = d.a(this.OFb);
          if (paramb == null) {
            break label821;
          }
          paramb = (List)paramb.data;
          if (paramb == null) {
            break label821;
          }
          if (((Collection)paramb).isEmpty()) {
            break label815;
          }
          j = 1;
          if (j != 1) {
            break label821;
          }
          j = 1;
          if (j == 0) {
            break label825;
          }
          paramb = d.a(this.OFb);
        } while (paramb == null);
        label670:
        label687:
        label694:
        label725:
        paramd = ((a.b.a)paramd).OCn;
        label773:
        if (paramd == null) {}
        for (int j = 0;; j = paramd.size())
        {
          paramb.by(i, j);
          break;
          label815:
          j = 0;
          break label764;
          label821:
          j = 0;
          break label773;
          label825:
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<View>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(d paramd, kotlin.d.d<? super g> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(273281);
      paramObject = (kotlin.d.d)new g(this.OFb, paramd);
      AppMethodBeat.o(273281);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273277);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273277);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = ((h)com.tencent.mm.ui.component.k.d(this.OFb.getActivity()).q(h.class)).OFo;
        if (paramObject != null)
        {
          paramObject = paramObject.OCf;
          if (paramObject != null)
          {
            paramObject = (kotlinx.coroutines.b.g)paramObject;
            kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new b(this.OFb);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (paramObject.a(localh, locald) == locala)
            {
              AppMethodBeat.o(273277);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(273277);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements Runnable
    {
      a(c.b.a parama, d paramd) {}
      
      public final void run()
      {
        AppMethodBeat.i(273302);
        long l = this.OFc.id;
        switch (this.OFc.EcS)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(273302);
          return;
          Object localObject1 = d.a(this.OFb);
          if (localObject1 != null)
          {
            localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
            if (localObject1 != null)
            {
              Object localObject2 = (Iterable)localObject1;
              localObject1 = this.OFb;
              localObject2 = ((Iterable)localObject2).iterator();
              Object localObject3;
              WxRecyclerAdapter localWxRecyclerAdapter;
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (com.tencent.mm.plugin.ringtone.b.c)((Iterator)localObject2).next();
                if ((((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg) && (((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA() != l))
                {
                  ((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg = false;
                  localWxRecyclerAdapter = d.a((d)localObject1);
                  if (localWxRecyclerAdapter != null) {
                    localWxRecyclerAdapter.AQ(((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA());
                  }
                }
              }
              AppMethodBeat.o(273302);
              return;
              localObject1 = d.a(this.OFb);
              if (localObject1 != null)
              {
                localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
                if (localObject1 != null)
                {
                  localObject2 = (Iterable)localObject1;
                  localObject1 = this.OFb;
                  localObject2 = ((Iterable)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (com.tencent.mm.plugin.ringtone.b.c)((Iterator)localObject2).next();
                    if (((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA() == l)
                    {
                      ((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg = true;
                      localWxRecyclerAdapter = d.a((d)localObject1);
                      if (localWxRecyclerAdapter != null) {
                        localWxRecyclerAdapter.AQ(((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA());
                      }
                    }
                    else if (((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg)
                    {
                      ((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg = false;
                      localWxRecyclerAdapter = d.a((d)localObject1);
                      if (localWxRecyclerAdapter != null) {
                        localWxRecyclerAdapter.AQ(((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA());
                      }
                    }
                  }
                  AppMethodBeat.o(273302);
                  return;
                  localObject1 = d.a(this.OFb);
                  if (localObject1 != null)
                  {
                    localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
                    if (localObject1 != null)
                    {
                      localObject2 = (Iterable)localObject1;
                      localObject1 = this.OFb;
                      localObject2 = ((Iterable)localObject2).iterator();
                      while (((Iterator)localObject2).hasNext())
                      {
                        localObject3 = (com.tencent.mm.plugin.ringtone.b.c)((Iterator)localObject2).next();
                        if ((((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg) && (((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA() == l))
                        {
                          ((com.tencent.mm.plugin.ringtone.b.c)localObject3).hJg = false;
                          localWxRecyclerAdapter = d.a((d)localObject1);
                          if (localWxRecyclerAdapter != null) {
                            localWxRecyclerAdapter.AQ(((com.tencent.mm.plugin.ringtone.b.c)localObject3).bZA());
                          }
                        }
                        localObject3 = com.tencent.mm.plugin.ringtone.l.a.OFQ;
                        com.tencent.mm.plugin.ringtone.l.a.gPd();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.h<c.b.a>
    {
      public b(d paramd) {}
      
      public final Object a(c.b.a parama, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(273290);
        parama = (c.b.a)parama;
        parama = com.tencent.threadpool.h.ahAA.bk((Runnable)new d.g.a(parama, this.OFb));
        if (parama == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(273290);
          return parama;
        }
        parama = ah.aiuX;
        AppMethodBeat.o(273290);
        return parama;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$onResume$2", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends RecyclerView.m
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.view.recyclerview.g
  {
    j(d paramd) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(273271);
      Log.i("SimpleUIComponent", kotlin.g.b.s.X("getItemConvert, type:", Integer.valueOf(paramInt)));
      Object localObject = new com.tencent.mm.plugin.ringtone.b.d();
      ((com.tencent.mm.plugin.ringtone.b.d)localObject).OBZ = ((com.tencent.mm.plugin.ringtone.b.d.a)new a(this.OFb));
      localObject = (f)localObject;
      AppMethodBeat.o(273271);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$1$getItemConvert$1$1", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConverter$OnRingtoneItemClick;", "onRingtoneControlClick", "", "ringback", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onRingtoneMoreOpClick", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.ringtone.b.d.a
    {
      a(d paramd) {}
      
      private static final void e(d paramd)
      {
        AppMethodBeat.i(273446);
        kotlin.g.b.s.u(paramd, "this$0");
        Object localObject = d.a(paramd);
        if (localObject != null)
        {
          localObject = (List)((WxRecyclerAdapter)localObject).data;
          if (localObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              com.tencent.mm.plugin.ringtone.b.c localc = (com.tencent.mm.plugin.ringtone.b.c)((Iterator)localObject).next();
              localc.hJg = false;
              WxRecyclerAdapter localWxRecyclerAdapter = d.a(paramd);
              if (localWxRecyclerAdapter != null) {
                localWxRecyclerAdapter.AQ(localc.bZA());
              }
            }
          }
        }
        AppMethodBeat.o(273446);
      }
      
      public final void a(com.tencent.mm.plugin.ringtone.b.c paramc, com.tencent.mm.view.recyclerview.j paramj)
      {
        boolean bool2 = true;
        AppMethodBeat.i(273466);
        kotlin.g.b.s.u(paramc, "ringback");
        kotlin.g.b.s.u(paramj, "holder");
        paramc = paramj.mlt;
        if (paramc == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<com.tencent.mm.plugin.ringtone.data.ExclusiveConvertData>");
          AppMethodBeat.o(273466);
          throw paramc;
        }
        paramc = (WxRecyclerAdapter)paramc;
        int j = paramj.KI();
        if ((j < 0) || (j >= paramc.getItemCount() - paramc.agOc.size()))
        {
          Log.e("SimpleUIComponent", kotlin.g.b.s.X("invalid position:", Integer.valueOf(j)));
          AppMethodBeat.o(273466);
          return;
        }
        int i;
        if (((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).hJg)
        {
          paramj = com.tencent.mm.plugin.ringtone.l.a.OFQ;
          com.tencent.mm.plugin.ringtone.l.a.gPd();
          i = 1;
        }
        label545:
        label571:
        for (;;)
        {
          paramj = ((Iterable)paramc.data).iterator();
          while (paramj.hasNext())
          {
            localObject = (com.tencent.mm.plugin.ringtone.b.c)paramj.next();
            if (((com.tencent.mm.plugin.ringtone.b.c)localObject).bZA() != ((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).bZA())
            {
              ((com.tencent.mm.plugin.ringtone.b.c)localObject).hJg = false;
              paramc.AQ(((com.tencent.mm.plugin.ringtone.b.c)localObject).bZA());
              continue;
              paramj = com.tencent.mm.plugin.ringtone.l.a.OFQ;
              i = com.tencent.mm.plugin.ringtone.l.a.gPc();
              if (i != 0) {
                break label571;
              }
              AppMethodBeat.o(273466);
              return;
            }
          }
          paramj = (com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j);
          if (!((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).hJg) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            paramj.hJg = bool1;
            paramj = ((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).OBY.UserName;
            if (paramj != null) {
              break;
            }
            AppMethodBeat.o(273466);
            return;
          }
          Object localObject = com.tencent.mm.plugin.ringtone.d.aUs(paramj);
          if (localObject == null)
          {
            AppMethodBeat.o(273466);
            return;
          }
          if (((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).hJg)
          {
            if ((((com.tencent.mm.plugin.ringtone.g.d)localObject).ODD != null) && (((com.tencent.mm.plugin.ringtone.g.d)localObject).gOD().fileName != null) && (com.tencent.mm.plugin.au.b.b.a(((com.tencent.mm.plugin.ringtone.g.d)localObject).gOD())))
            {
              bool1 = bool2;
              com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
              com.tencent.mm.ui.component.k.d(this.OFb.getActivity()).q(n.class);
              n.a((com.tencent.mm.plugin.ringtone.g.d)localObject, null, bool1);
              localk = com.tencent.mm.ui.component.k.aeZF;
              com.tencent.mm.ui.component.k.d(this.OFb.getActivity()).q(n.class);
              n.a((com.tencent.mm.plugin.ringtone.g.d)localObject, paramj, bool1);
            }
          }
          else
          {
            if (i == 2) {
              break label545;
            }
            d.a(this.OFb, (com.tencent.mm.plugin.ringtone.g.d)localObject, ((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).bZA(), ((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).hJg);
          }
          for (;;)
          {
            paramc.AQ(((com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(j)).bZA());
            AppMethodBeat.o(273466);
            return;
            bool1 = false;
            break;
            com.tencent.threadpool.h.ahAA.o(new d.j.a..ExternalSyntheticLambda0(this.OFb), 200L);
          }
        }
      }
      
      public final void b(com.tencent.mm.plugin.ringtone.b.c paramc, com.tencent.mm.view.recyclerview.j paramj)
      {
        AppMethodBeat.i(273472);
        kotlin.g.b.s.u(paramc, "ringback");
        kotlin.g.b.s.u(paramj, "holder");
        paramc = paramj.mlt;
        if (paramc == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<com.tencent.mm.plugin.ringtone.data.ExclusiveConvertData>");
          AppMethodBeat.o(273472);
          throw paramc;
        }
        paramc = (WxRecyclerAdapter)paramc;
        d.a(this.OFb, (com.tencent.mm.plugin.ringtone.b.c)((List)paramc.data).get(paramj.KI()));
        AppMethodBeat.o(273472);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends RecyclerView.l
  {
    k(d paramd) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(273273);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(273273);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(273264);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (paramInt2 > 0) && (((LinearLayoutManager)paramRecyclerView).Jw() >= ((LinearLayoutManager)paramRecyclerView).getItemCount()))
      {
        paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
        ((c)com.tencent.mm.ui.component.k.d(this.OFb.getActivity()).q(c.class)).aWi();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(273264);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneExclusiveMainUIC$reInitAdapter$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    l(d paramd) {}
    
    private static final void f(d paramd)
    {
      AppMethodBeat.i(273262);
      kotlin.g.b.s.u(paramd, "this$0");
      Object localObject = d.a(paramd);
      if (localObject != null)
      {
        localObject = (List)((WxRecyclerAdapter)localObject).data;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            com.tencent.mm.plugin.ringtone.b.c localc = (com.tencent.mm.plugin.ringtone.b.c)((Iterator)localObject).next();
            localc.hJg = false;
            WxRecyclerAdapter localWxRecyclerAdapter = d.a(paramd);
            if (localWxRecyclerAdapter != null) {
              localWxRecyclerAdapter.AQ(localc.bZA());
            }
          }
        }
      }
      AppMethodBeat.o(273262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.d
 * JD-Core Version:    0.7.0.1
 */