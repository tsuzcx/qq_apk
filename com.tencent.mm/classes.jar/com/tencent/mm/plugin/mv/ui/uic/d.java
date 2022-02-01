package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.model.l;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "chatMaxFooter", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getChatMaxFooter", "()Landroid/view/ViewGroup;", "chatMaxFooter$delegate", "Lkotlin/Lazy;", "commentFooter", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "getCommentFooter", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "commentFooter$delegate", "commentInput", "Landroid/view/View;", "commentRoot", "getCommentRoot", "commentRoot$delegate", "commentView", "isInput", "", "itemView", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "bindView", "", "parent", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "exitInputComment", "startInputComment", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
{
  private final j MdL;
  private final j MdM;
  private final j MdN;
  private View MdO;
  private View MdP;
  private final x MdQ;
  private boolean MdR;
  private final String TAG;
  private View caK;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287674);
    this.TAG = "MicroMsg.MusicMvCommentUIC";
    this.MdL = k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    this.MdM = k.cm((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.MdN = k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.MdQ = new x();
    AppMethodBeat.o(287674);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(287710);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    Log.i(paramd.TAG, "click comment input");
    paramd.MdR = true;
    paramView = paramd.caK;
    if (paramView != null) {
      paramd.MdQ.ix(paramView).A(ar.setOf(new Integer[] { Integer.valueOf(b.e.LRV), Integer.valueOf(b.e.geW), Integer.valueOf(b.e.LSK), Integer.valueOf(b.e.LSX), Integer.valueOf(b.e.LUZ) }));
    }
    paramd.gqz().setVisibility(0);
    paramd.gqA().setVisibility(0);
    paramd.gqz().setAlpha(0.0F);
    paramd.gqz().animate().alpha(1.0F).setDuration(200L).start();
    paramView = paramd.MdP;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView != null) {
        paramView.removeView(paramd.MdP);
      }
      paramd.gqB().addView(paramd.MdP);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287710);
      return;
    }
  }
  
  private static final void b(d paramd, View paramView)
  {
    AppMethodBeat.i(287720);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.gqC();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287720);
  }
  
  private final MusicMvCommentFooter gqA()
  {
    AppMethodBeat.i(287687);
    MusicMvCommentFooter localMusicMvCommentFooter = (MusicMvCommentFooter)this.MdM.getValue();
    AppMethodBeat.o(287687);
    return localMusicMvCommentFooter;
  }
  
  private final ViewGroup gqB()
  {
    AppMethodBeat.i(287690);
    ViewGroup localViewGroup = (ViewGroup)this.MdN.getValue();
    AppMethodBeat.o(287690);
    return localViewGroup;
  }
  
  private final void gqC()
  {
    AppMethodBeat.i(287699);
    this.MdR = false;
    this.MdQ.restore();
    gqz().setVisibility(8);
    gqA().setVisibility(8);
    Object localObject = this.MdP;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).getParent())
    {
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.MdP);
      }
      localObject = this.caK;
      if (localObject != null)
      {
        localObject = (ViewGroup)((View)localObject).findViewById(b.e.LTd);
        if (localObject != null) {
          ((ViewGroup)localObject).addView(this.MdP);
        }
      }
      AppMethodBeat.o(287699);
      return;
    }
  }
  
  private final ViewGroup gqz()
  {
    AppMethodBeat.i(287679);
    ViewGroup localViewGroup = (ViewGroup)this.MdL.getValue();
    AppMethodBeat.o(287679);
    return localViewGroup;
  }
  
  public final void a(View paramView, final com.tencent.mm.plugin.mv.ui.a.b paramb)
  {
    AppMethodBeat.i(287756);
    s.u(paramb, "item");
    Log.i(this.TAG, "bindView: ");
    Object localObject = this.MdO;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(null);
    }
    if (this.MdR) {
      if ((this.caK != null) && (!s.p(this.caK, paramView)))
      {
        localObject = this.MdP;
        if (localObject == null)
        {
          localObject = null;
          localObject = (ViewGroup)localObject;
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.MdP);
          }
          localObject = this.caK;
          if (localObject != null)
          {
            localObject = (ViewGroup)((View)localObject).findViewById(b.e.LTd);
            if (localObject != null) {
              ((ViewGroup)localObject).addView(this.MdP);
            }
          }
          if (paramView != null) {
            break label266;
          }
          localObject = null;
          label128:
          this.MdP = ((View)localObject);
          localObject = this.MdP;
          if (localObject != null) {
            break label277;
          }
          localObject = null;
          label144:
          localObject = (ViewGroup)localObject;
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.MdP);
          }
          gqB().addView(this.MdP);
        }
      }
      else
      {
        this.caK = paramView;
        paramView = this.caK;
        if (paramView != null) {
          break label310;
        }
      }
    }
    label266:
    label277:
    label310:
    for (paramView = null;; paramView = (TextView)paramView.findViewById(b.e.LSe))
    {
      this.MdO = ((View)paramView);
      paramView = this.MdO;
      if (paramView != null) {
        paramView.setOnClickListener(new d..ExternalSyntheticLambda0(this));
      }
      gqz().setOnClickListener(new d..ExternalSyntheticLambda1(this));
      gqA().setOnCommentSendImp((MusicMvCommentFooter.b)new a(this, paramb));
      AppMethodBeat.o(287756);
      return;
      localObject = ((View)localObject).getParent();
      break;
      localObject = paramView.findViewById(b.e.comment_container);
      break label128;
      localObject = ((View)localObject).getParent();
      break label144;
      if (paramView == null) {}
      for (localObject = null;; localObject = paramView.findViewById(b.e.comment_container))
      {
        this.MdP = ((View)localObject);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$3", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "onCommentSend", "", "toSendText", "", "emojiMd5", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements MusicMvCommentFooter.b
  {
    a(d paramd, com.tencent.mm.plugin.mv.ui.a.b paramb) {}
    
    public final void aPG(String paramString)
    {
      AppMethodBeat.i(288111);
      int i;
      if (paramString != null)
      {
        if (((CharSequence)paramString).length() <= 0) {
          break label62;
        }
        i = 1;
        if (i == 0) {
          break label67;
        }
      }
      for (;;)
      {
        if (paramString != null)
        {
          com.tencent.mm.plugin.mv.ui.a.b localb = paramb;
          l locall = l.LXJ;
          l.a(paramString, localb.MaX);
        }
        d.a(this.MdS);
        AppMethodBeat.o(288111);
        return;
        label62:
        i = 0;
        break;
        label67:
        paramString = null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<MusicMvCommentFooter>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ViewGroup>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.d
 * JD-Core Version:    0.7.0.1
 */