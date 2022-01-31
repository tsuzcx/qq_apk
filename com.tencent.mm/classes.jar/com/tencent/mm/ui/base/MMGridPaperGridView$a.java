package com.tencent.mm.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

final class MMGridPaperGridView$a
  extends BaseAdapter
{
  private MMGridPaperGridView$a(MMGridPaperGridView paramMMGridPaperGridView) {}
  
  public final int getCount()
  {
    if ((MMGridPaperGridView.c(this.uVU) < 0) || (MMGridPaperGridView.a(this.uVU) == null)) {
      return 0;
    }
    return MMGridPaperGridView.c(this.uVU);
  }
  
  public final Object getItem(int paramInt)
  {
    if (MMGridPaperGridView.a(this.uVU) == null) {
      return null;
    }
    return MMGridPaperGridView.a(this.uVU).getItem(MMGridPaperGridView.b(this.uVU) + paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    if (MMGridPaperGridView.a(this.uVU) == null) {
      return 0L;
    }
    return MMGridPaperGridView.a(this.uVU).getItemId(MMGridPaperGridView.b(this.uVU) + paramInt);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l = bk.UZ();
    int i = MMGridPaperGridView.d(this.uVU);
    boolean bool;
    if (paramView == null)
    {
      bool = true;
      y.v("MicroMsg.MMGridPaperGridView", "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(bool), paramViewGroup.toString(), Boolean.valueOf(MMGridPaperGridView.e(this.uVU)) });
      if (MMGridPaperGridView.e(this.uVU)) {
        paramView = null;
      }
      if (MMGridPaperGridView.a(this.uVU) != null) {
        break label204;
      }
      paramView = null;
      label99:
      if (paramView == null) {
        break label228;
      }
      bool = true;
      label106:
      Assert.assertTrue(bool);
      if ((-1 == MMGridPaperGridView.f(this.uVU)) || (MMGridPaperGridView.b(this.uVU) + paramInt != MMGridPaperGridView.f(this.uVU))) {
        break label234;
      }
      paramView.setVisibility(4);
    }
    for (;;)
    {
      y.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(MMGridPaperGridView.f(this.uVU)), Integer.valueOf(MMGridPaperGridView.b(this.uVU) + paramInt) });
      return paramView;
      bool = false;
      break;
      label204:
      paramView = MMGridPaperGridView.a(this.uVU).c(MMGridPaperGridView.b(this.uVU) + paramInt, paramView);
      break label99;
      label228:
      bool = false;
      break label106;
      label234:
      paramView.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return MMGridPaperGridView.a(this.uVU) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView.a
 * JD-Core Version:    0.7.0.1
 */