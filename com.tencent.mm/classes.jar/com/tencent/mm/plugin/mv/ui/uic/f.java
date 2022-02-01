package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "chatMaxFooter", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getChatMaxFooter", "()Landroid/view/ViewGroup;", "chatMaxFooter$delegate", "Lkotlin/Lazy;", "commentFooter", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "getCommentFooter", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "commentFooter$delegate", "commentInput", "Landroid/view/View;", "commentRoot", "getCommentRoot", "commentRoot$delegate", "commentView", "isInput", "", "itemView", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "bindView", "", "parent", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "exitInputComment", "startInputComment", "plugin-mv_release"})
public final class f
  extends UIComponent
{
  private final kotlin.f GiL;
  private final kotlin.f GiM;
  private final kotlin.f GiN;
  private View GiO;
  private View GiP;
  private final z GiQ;
  private boolean GiR;
  private final String TAG;
  private View amk;
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(229876);
    this.TAG = "MicroMsg.MusicMvCommentUIC";
    this.GiL = g.ar((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.GiM = g.ar((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.GiN = g.ar((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.GiQ = new z();
    AppMethodBeat.o(229876);
  }
  
  private final ViewGroup fgS()
  {
    AppMethodBeat.i(229864);
    ViewGroup localViewGroup = (ViewGroup)this.GiL.getValue();
    AppMethodBeat.o(229864);
    return localViewGroup;
  }
  
  private final MusicMvCommentFooter fgT()
  {
    AppMethodBeat.i(229866);
    MusicMvCommentFooter localMusicMvCommentFooter = (MusicMvCommentFooter)this.GiM.getValue();
    AppMethodBeat.o(229866);
    return localMusicMvCommentFooter;
  }
  
  private final ViewGroup fgU()
  {
    AppMethodBeat.i(229867);
    ViewGroup localViewGroup = (ViewGroup)this.GiN.getValue();
    AppMethodBeat.o(229867);
    return localViewGroup;
  }
  
  public final void a(View paramView, final com.tencent.mm.plugin.mv.ui.a.b paramb)
  {
    AppMethodBeat.i(229874);
    p.k(paramb, "item");
    Log.i(this.TAG, "bindView: ");
    Object localObject = this.GiO;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(null);
    }
    if (this.GiR) {
      if ((this.amk != null) && ((p.h(this.amk, paramView) ^ true)))
      {
        localObject = this.GiP;
        if (localObject != null)
        {
          localObject = ((View)localObject).getParent();
          localObject = (ViewGroup)localObject;
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.GiP);
          }
          localObject = this.amk;
          if (localObject != null)
          {
            localObject = (ViewGroup)((View)localObject).findViewById(b.e.FXE);
            if (localObject != null) {
              ((ViewGroup)localObject).addView(this.GiP);
            }
          }
          if (paramView == null) {
            break label288;
          }
          localObject = paramView.findViewById(b.e.comment_container);
          label136:
          this.GiP = ((View)localObject);
          localObject = this.GiP;
          if (localObject == null) {
            break label293;
          }
          localObject = ((View)localObject).getParent();
          label155:
          localObject = (ViewGroup)localObject;
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.GiP);
          }
          fgU().addView(this.GiP);
        }
      }
      else
      {
        this.amk = paramView;
        paramView = this.amk;
        if (paramView == null) {
          break label323;
        }
      }
    }
    label288:
    label293:
    label323:
    for (paramView = (TextView)paramView.findViewById(b.e.FWQ);; paramView = null)
    {
      this.GiO = ((View)paramView);
      paramView = this.GiO;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)new a(this));
      }
      fgS().setOnClickListener((View.OnClickListener)new b(this));
      fgT().setOnCommentSendImp((MusicMvCommentFooter.b)new c(this, paramb));
      AppMethodBeat.o(229874);
      return;
      localObject = null;
      break;
      localObject = null;
      break label136;
      localObject = null;
      break label155;
      if (paramView != null) {}
      for (localObject = paramView.findViewById(b.e.comment_container);; localObject = null)
      {
        this.GiP = ((View)localObject);
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229544);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i(f.a(this.GiS), "click comment input");
      f.b(this.GiS);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229544);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226991);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      f.c(this.GiS);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(226991);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$3", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "onCommentSend", "", "toSendText", "", "emojiMd5", "plugin-mv_release"})
  public static final class c
    implements MusicMvCommentFooter.b
  {
    c(com.tencent.mm.plugin.mv.ui.a.b paramb) {}
    
    public final void aSL(String paramString)
    {
      AppMethodBeat.i(225729);
      int i;
      if (paramString != null)
      {
        if (((CharSequence)paramString).length() <= 0) {
          break label59;
        }
        i = 1;
        if (i == 0) {
          break label64;
        }
      }
      for (;;)
      {
        if (paramString != null)
        {
          com.tencent.mm.plugin.mv.model.l locall = com.tencent.mm.plugin.mv.model.l.Gcr;
          com.tencent.mm.plugin.mv.model.l.a(paramString, paramb.GfI);
        }
        f.c(this.GiS);
        AppMethodBeat.o(225729);
        return;
        label59:
        i = 0;
        break;
        label64:
        paramString = null;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<MusicMvCommentFooter>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.f
 * JD-Core Version:    0.7.0.1
 */