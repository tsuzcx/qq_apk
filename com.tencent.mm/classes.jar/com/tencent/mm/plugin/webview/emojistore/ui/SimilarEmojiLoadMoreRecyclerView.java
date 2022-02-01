package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.EmojiPanelRecyclerView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class SimilarEmojiLoadMoreRecyclerView
  extends EmojiPanelRecyclerView
{
  private a INA;
  boolean oEn;
  
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
    avQ();
    a(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(77871);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        a.b("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt != 0) || (SimilarEmojiLoadMoreRecyclerView.this.oEn) || (SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager() == null) || (SimilarEmojiLoadMoreRecyclerView.this.getAdapter() == null))
        {
          a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(77871);
          return;
        }
        paramAnonymousInt = ((GridLayoutManager)SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).ku();
        if ((((GridLayoutManager)SimilarEmojiLoadMoreRecyclerView.this.getLayoutManager()).apM + (paramAnonymousInt + 1) >= SimilarEmojiLoadMoreRecyclerView.this.getAdapter().getItemCount()) && (SimilarEmojiLoadMoreRecyclerView.a(SimilarEmojiLoadMoreRecyclerView.this) != null))
        {
          paramAnonymousRecyclerView = SimilarEmojiLoadMoreRecyclerView.a(SimilarEmojiLoadMoreRecyclerView.this);
          SimilarEmojiLoadMoreRecyclerView.this.getAdapter();
          paramAnonymousRecyclerView.gas();
        }
        a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(77871);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210817);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        a.b("com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        a.a(this, "com/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(210817);
      }
    });
    AppMethodBeat.o(77875);
  }
  
  public final boolean gar()
  {
    return this.oEn;
  }
  
  public void setOnLoadingStateChangedListener(a parama)
  {
    this.INA = parama;
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    if (this.oEn == paramBoolean) {
      return;
    }
    this.oEn = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void gas();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SimilarEmojiLoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */