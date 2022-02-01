package com.tencent.mm.plugin.story.ui.view.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a SAH;
  private static final String TAG;
  private View EAj;
  private final StoryGalleryView SAI;
  private final GalleryRecyclerView SAJ;
  private final g SAK;
  boolean SAL;
  private final c SAM;
  private final Runnable SAN;
  
  static
  {
    AppMethodBeat.i(120374);
    SAH = new e.a((byte)0);
    TAG = "MicroMsg.GalleryScrollUpCheck";
    AppMethodBeat.o(120374);
  }
  
  public e(StoryGalleryView paramStoryGalleryView, GalleryRecyclerView paramGalleryRecyclerView, g paramg)
  {
    AppMethodBeat.i(120373);
    this.SAI = paramStoryGalleryView;
    this.SAJ = paramGalleryRecyclerView;
    this.SAK = paramg;
    this.SAM = new c(this);
    if (h.baE().ban().getBoolean(at.a.acYw, false))
    {
      this.SAN = e..ExternalSyntheticLambda1.INSTANCE;
      this.SAK.a((RecyclerView)this.SAJ);
      AppMethodBeat.o(120373);
      return;
    }
    this.SAN = new e..ExternalSyntheticLambda0(this);
    MMHandlerThread.postToMainThreadDelayed(this.SAN, 5000L);
    this.SAJ.a((RecyclerView.l)this.SAM);
    AppMethodBeat.o(120373);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(367717);
    s.u(parame, "this$0");
    int i = com.tencent.mm.cd.a.fromDPToPix(parame.SAI.getContext(), 112);
    View localView = LayoutInflater.from(parame.SAI.getContext()).inflate(a.e.SgZ, (ViewGroup)parame.SAI, false);
    parame.EAj = localView;
    Object localObject = localView.findViewById(a.d.Sga);
    s.s(localObject, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
    ((ImageView)localObject).setImageDrawable(bb.m(parame.SAI.getContext(), a.f.close_icon_nor, -1));
    localObject = new RelativeLayout.LayoutParams(-1, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
    parame.SAI.addView(localView, (ViewGroup.LayoutParams)localObject);
    localView.setAlpha(0.0F);
    localView.animate().alpha(1.0F).start();
    parame.SAJ.br(0, i);
    parame.SAL = true;
    AppMethodBeat.o(367717);
  }
  
  private static final void bvy() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(120372);
    MMHandlerThread.removeRunnable(this.SAN);
    this.SAI.removeView(this.EAj);
    this.SAJ.b((RecyclerView.l)this.SAM);
    AppMethodBeat.o(120372);
  }
  
  public final void hAf()
  {
    AppMethodBeat.i(120371);
    d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(120371);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(e parame) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(367735);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(367735);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(367734);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      if ((!e.h(this.SAO)) && (paramInt2 > 0))
      {
        Log.i(e.access$getTAG$cp(), s.X("onScrolled ", Integer.valueOf(paramInt2)));
        h.baE().ban().set(at.a.acYw, Boolean.TRUE);
        this.SAO.hAf();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(367734);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.e
 * JD-Core Version:    0.7.0.1
 */