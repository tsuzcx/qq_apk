package com.tencent.mm.plugin.story.ui.view.gallery;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "", "gallery", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "recyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "pageScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;)V", "hintLayout", "Landroid/view/View;", "hintShowing", "", "scrollListener", "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1;", "showHintRunnable", "Ljava/lang/Runnable;", "cancelHint", "", "checkCancel", "destroy", "Companion", "plugin-story_release"})
public final class e
{
  public static final e.a FFq;
  private static final String TAG = "MicroMsg.GalleryScrollUpCheck";
  boolean FFj;
  private final c FFk;
  private final Runnable FFl;
  private View FFm;
  private final StoryGalleryView FFn;
  private final GalleryRecyclerView FFo;
  private final i FFp;
  
  static
  {
    AppMethodBeat.i(120374);
    FFq = new e.a((byte)0);
    TAG = "MicroMsg.GalleryScrollUpCheck";
    AppMethodBeat.o(120374);
  }
  
  public e(StoryGalleryView paramStoryGalleryView, GalleryRecyclerView paramGalleryRecyclerView, i parami)
  {
    AppMethodBeat.i(120373);
    this.FFn = paramStoryGalleryView;
    this.FFo = paramGalleryRecyclerView;
    this.FFp = parami;
    this.FFk = new c(this);
    paramStoryGalleryView = g.aAh();
    p.g(paramStoryGalleryView, "storage()");
    if (paramStoryGalleryView.azQ().getBoolean(ar.a.Oiv, false))
    {
      this.FFl = ((Runnable)e.1.FFr);
      this.FFp.f((RecyclerView)this.FFo);
      AppMethodBeat.o(120373);
      return;
    }
    this.FFl = ((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(120368);
        int i = com.tencent.mm.cb.a.fromDPToPix(e.d(this.FFs).getContext(), 112);
        View localView = LayoutInflater.from(e.d(this.FFs).getContext()).inflate(2131496623, (ViewGroup)e.d(this.FFs), false);
        e.a(this.FFs, localView);
        Object localObject = localView.findViewById(2131308700);
        p.g(localObject, "layout.findViewById(R.id…tory_scroll_up_hint_icon)");
        ((ImageView)localObject).setImageDrawable(ar.m(e.d(this.FFs).getContext(), 2131689972, -1));
        localObject = new RelativeLayout.LayoutParams(-1, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
        e.d(this.FFs).addView(localView, (ViewGroup.LayoutParams)localObject);
        p.g(localView, "layout");
        localView.setAlpha(0.0F);
        localView.animate().alpha(1.0F).start();
        e.b(this.FFs).smoothScrollBy(0, i);
        e.h(this.FFs);
        AppMethodBeat.o(120368);
      }
    });
    MMHandlerThread.postToMainThreadDelayed(this.FFl, 5000L);
    this.FFo.a((RecyclerView.l)this.FFk);
    AppMethodBeat.o(120373);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(120372);
    MMHandlerThread.removeRunnable(this.FFl);
    this.FFn.removeView(this.FFm);
    this.FFo.b((RecyclerView.l)this.FFk);
    AppMethodBeat.o(120372);
  }
  
  public final void fsn()
  {
    AppMethodBeat.i(120371);
    d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(120371);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-story_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(222925);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(222925);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(120370);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      if ((!e.g(this.FFs)) && (paramInt2 > 0))
      {
        Log.i(e.access$getTAG$cp(), "onScrolled ".concat(String.valueOf(paramInt2)));
        paramRecyclerView = g.aAh();
        p.g(paramRecyclerView, "storage()");
        paramRecyclerView.azQ().set(ar.a.Oiv, Boolean.TRUE);
        this.FFs.fsn();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(120370);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.e
 * JD-Core Version:    0.7.0.1
 */