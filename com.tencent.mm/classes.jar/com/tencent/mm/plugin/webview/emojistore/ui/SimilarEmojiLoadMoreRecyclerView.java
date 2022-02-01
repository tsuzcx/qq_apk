package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class SimilarEmojiLoadMoreRecyclerView
  extends EmojiPanelRecyclerView
{
  private a WAl;
  boolean uRi;
  
  public SimilarEmojiLoadMoreRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(77872);
    init();
    AppMethodBeat.o(77872);
  }
  
  public SimilarEmojiLoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(77873);
    init();
    AppMethodBeat.o(77873);
  }
  
  public SimilarEmojiLoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77874);
    init();
    AppMethodBeat.o(77874);
  }
  
  private void init()
  {
    AppMethodBeat.i(77875);
    setEnableLongPress(false);
    aVK();
    a(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(294764);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        a.c("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt != 0) || (SimilarEmojiLoadMoreRecyclerView.this.uRi) || (SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager() == null) || (SimilarEmojiLoadMoreRecyclerView.this.getAdapter() == null))
        {
          a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(294764);
          return;
        }
        paramAnonymousInt = ((GridLayoutManager)SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).Jw();
        if ((((GridLayoutManager)SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).bWl + (paramAnonymousInt + 1) >= SimilarEmojiLoadMoreRecyclerView.this.getAdapter().getItemCount()) && (SimilarEmojiLoadMoreRecyclerView.a(SimilarEmojiLoadMoreRecyclerView.this) != null))
        {
          paramAnonymousRecyclerView = SimilarEmojiLoadMoreRecyclerView.a(SimilarEmojiLoadMoreRecyclerView.this);
          SimilarEmojiLoadMoreRecyclerView.this.getAdapter();
          paramAnonymousRecyclerView.isZ();
        }
        a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(294764);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(294770);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        a.c("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(294770);
      }
    });
    AppMethodBeat.o(77875);
  }
  
  public void setOnLoadingStateChangedListener(a parama)
  {
    this.WAl = parama;
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    if (this.uRi == paramBoolean) {
      return;
    }
    this.uRi = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void isZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SimilarEmojiLoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */