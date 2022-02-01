package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class SimilarEmojiLoadMoreRecyclerView
  extends EmojiPanelRecyclerView
{
  private a Ebo;
  boolean nuj;
  
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
    agc();
    a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(197984);
        b localb = new b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        a.b("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(197984);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(77871);
        b localb = new b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        a.b("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt != 0) || (SimilarEmojiLoadMoreRecyclerView.this.nuj) || (SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager() == null) || (SimilarEmojiLoadMoreRecyclerView.this.getAdapter() == null))
        {
          a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(77871);
          return;
        }
        paramAnonymousInt = ((GridLayoutManager)SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).ko();
        if ((((GridLayoutManager)SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).apA + (paramAnonymousInt + 1) >= SimilarEmojiLoadMoreRecyclerView.this.getAdapter().getItemCount()) && (SimilarEmojiLoadMoreRecyclerView.a(SimilarEmojiLoadMoreRecyclerView.this) != null))
        {
          paramAnonymousRecyclerView = SimilarEmojiLoadMoreRecyclerView.a(SimilarEmojiLoadMoreRecyclerView.this);
          SimilarEmojiLoadMoreRecyclerView.this.getAdapter();
          paramAnonymousRecyclerView.eRJ();
        }
        a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(77871);
      }
    });
    AppMethodBeat.o(77875);
  }
  
  public final boolean eRI()
  {
    return this.nuj;
  }
  
  public void setOnLoadingStateChangedListener(a parama)
  {
    this.Ebo = parama;
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    if (this.nuj == paramBoolean) {
      return;
    }
    this.nuj = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eRJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SimilarEmojiLoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */