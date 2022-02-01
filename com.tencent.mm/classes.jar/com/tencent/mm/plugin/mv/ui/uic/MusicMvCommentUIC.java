package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.a.e.a;
import com.tencent.mm.plugin.mv.a.k;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "chatMaxFooter", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getChatMaxFooter", "()Landroid/view/ViewGroup;", "chatMaxFooter$delegate", "Lkotlin/Lazy;", "commentFooter", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "getCommentFooter", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "commentFooter$delegate", "commentInput", "Landroid/view/View;", "commentRoot", "getCommentRoot", "commentRoot$delegate", "commentView", "isInput", "", "itemView", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "bindView", "", "parent", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "exitInputComment", "startInputComment", "plugin-mv_release"})
public final class MusicMvCommentUIC
  extends UIComponent
{
  private final f Atg;
  private final f Ath;
  private final f Ati;
  private View Atj;
  private View Atk;
  private final c Atl;
  private boolean Atm;
  private final String TAG;
  private View aus;
  
  public MusicMvCommentUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257106);
    this.TAG = "MicroMsg.MusicMvCommentUIC";
    this.Atg = kotlin.g.ah((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.Ath = kotlin.g.ah((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.Ati = kotlin.g.ah((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.Atl = new c();
    AppMethodBeat.o(257106);
  }
  
  private final ViewGroup evL()
  {
    AppMethodBeat.i(257102);
    ViewGroup localViewGroup = (ViewGroup)this.Atg.getValue();
    AppMethodBeat.o(257102);
    return localViewGroup;
  }
  
  private final MusicMvCommentFooter evM()
  {
    AppMethodBeat.i(257103);
    MusicMvCommentFooter localMusicMvCommentFooter = (MusicMvCommentFooter)this.Ath.getValue();
    AppMethodBeat.o(257103);
    return localMusicMvCommentFooter;
  }
  
  private final ViewGroup evN()
  {
    AppMethodBeat.i(257104);
    ViewGroup localViewGroup = (ViewGroup)this.Ati.getValue();
    AppMethodBeat.o(257104);
    return localViewGroup;
  }
  
  public final void a(View paramView, final com.tencent.mm.plugin.mv.ui.a.b paramb)
  {
    AppMethodBeat.i(257105);
    p.h(paramb, "item");
    Log.i(this.TAG, "bindView: ");
    Object localObject = this.Atj;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(null);
    }
    if (this.Atm) {
      if ((this.aus != null) && ((p.j(this.aus, paramView) ^ true)))
      {
        localObject = this.Atk;
        if (localObject != null)
        {
          localObject = ((View)localObject).getParent();
          localObject = (ViewGroup)localObject;
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.Atk);
          }
          localObject = this.aus;
          if (localObject != null)
          {
            localObject = (ViewGroup)((View)localObject).findViewById(2131304669);
            if (localObject != null) {
              ((ViewGroup)localObject).addView(this.Atk);
            }
          }
          if (paramView == null) {
            break label285;
          }
          localObject = paramView.findViewById(2131298933);
          label134:
          this.Atk = ((View)localObject);
          localObject = this.Atk;
          if (localObject == null) {
            break label290;
          }
          localObject = ((View)localObject).getParent();
          label153:
          localObject = (ViewGroup)localObject;
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.Atk);
          }
          evN().addView(this.Atk);
        }
      }
      else
      {
        this.aus = paramView;
        paramView = this.aus;
        if (paramView == null) {
          break label319;
        }
      }
    }
    label285:
    label290:
    label319:
    for (paramView = (TextView)paramView.findViewById(2131298949);; paramView = null)
    {
      this.Atj = ((View)paramView);
      paramView = this.Atj;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)new a(this));
      }
      evL().setOnClickListener((View.OnClickListener)new b(this));
      evM().setOnCommentSendImp((MusicMvCommentFooter.b)new c(this, paramb));
      AppMethodBeat.o(257105);
      return;
      localObject = null;
      break;
      localObject = null;
      break label134;
      localObject = null;
      break label153;
      if (paramView != null) {}
      for (localObject = paramView.findViewById(2131298933);; localObject = null)
      {
        this.Atk = ((View)localObject);
        break;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(MusicMvCommentUIC paramMusicMvCommentUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257096);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i(MusicMvCommentUIC.a(this.Atn), "click comment input");
      MusicMvCommentUIC.b(this.Atn);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257096);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(MusicMvCommentUIC paramMusicMvCommentUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257097);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      MusicMvCommentUIC.c(this.Atn);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257097);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$3", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "onCommentSend", "", "toSendText", "", "emojiMd5", "plugin-mv_release"})
  public static final class c
    implements MusicMvCommentFooter.b
  {
    c(com.tencent.mm.plugin.mv.ui.a.b paramb) {}
    
    public final void aIq(String paramString)
    {
      AppMethodBeat.i(257098);
      int i;
      if (paramString != null)
      {
        if (((CharSequence)paramString).length() <= 0) {
          break label438;
        }
        i = 1;
        if (i == 0) {
          break label443;
        }
      }
      for (;;)
      {
        if (paramString != null)
        {
          Object localObject = com.tencent.mm.ui.component.a.PRN;
          MusicMvChattingUIC localMusicMvChattingUIC = (MusicMvChattingUIC)com.tencent.mm.ui.component.a.b(this.Atn.getActivity()).get(MusicMvChattingUIC.class);
          e locale = paramb.ArY;
          p.h(paramString, "toSendText");
          p.h(locale, "musicMv");
          localObject = localMusicMvChattingUIC.AqO;
          if ((localObject != null) && (!Util.isNullOrNil(paramString)))
          {
            csk localcsk = new csk();
            csi localcsi = new csi();
            localcsi.type = 1;
            localcsi.Mxp = new csl();
            csl localcsl = localcsi.Mxp;
            if (localcsl != null) {
              localcsl.text = paramString;
            }
            localcsk.BcW = String.valueOf(cl.aWA());
            localcsk.MwX = ((String)localObject);
            localcsk.Mxt = z.aUa();
            localcsk.Mxr = localcsi;
            localcsk.createtime = ((int)(System.currentTimeMillis() / 1000L));
            paramString = e.ApR;
            paramString = e.a.a(locale);
            if (paramString != null)
            {
              localcsk.Mxv = paramString.id;
              localcsk.LGs = paramString.objectNonceId;
              paramString = paramString.contact;
              if (paramString != null)
              {
                localObject = paramString.nickname;
                paramString = (String)localObject;
                if (localObject != null) {}
              }
              else
              {
                paramString = "";
              }
              localcsk.Mxw = paramString;
            }
            Log.i("MicroMsg.Mv.MusicMvChattingUIC", "postLiveMsg msg.objectId:" + localcsk.Mxv + " msg.objectNonceId:" + localcsk.LGs);
            paramString = localMusicMvChattingUIC.Ata;
            if (paramString != null) {
              com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)paramString);
            }
            paramString = com.tencent.mm.ui.component.a.PRN;
            localMusicMvChattingUIC.Ata = new com.tencent.mm.plugin.mv.a.a.l(localcsk, ((MusicMvDataUIC)com.tencent.mm.ui.component.a.b(localMusicMvChattingUIC.getActivity()).get(MusicMvDataUIC.class)).Aqo, localMusicMvChattingUIC.getActivity().hashCode());
            com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localMusicMvChattingUIC.Ata);
            paramString = com.tencent.mm.ui.component.a.PRN;
            paramString = com.tencent.mm.ui.component.a.b(localMusicMvChattingUIC.getActivity()).get(MusicMvDataUIC.class);
            p.g(paramString, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
            paramString = (MusicMvDataUIC)paramString;
            localObject = k.Aql;
            k.b((Context)localMusicMvChattingUIC.getContext(), paramString.Aqo, locale, 1, 0L);
          }
        }
        MusicMvCommentUIC.c(this.Atn);
        AppMethodBeat.o(257098);
        return;
        label438:
        i = 0;
        break;
        label443:
        paramString = null;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MusicMvCommentFooter>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ViewGroup>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvCommentUIC
 * JD-Core Version:    0.7.0.1
 */