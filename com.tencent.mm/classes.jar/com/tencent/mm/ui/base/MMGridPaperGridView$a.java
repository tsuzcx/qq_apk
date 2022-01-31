package com.tencent.mm.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

final class MMGridPaperGridView$a
  extends BaseAdapter
{
  private MMGridPaperGridView$a(MMGridPaperGridView paramMMGridPaperGridView) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(106644);
    if ((MMGridPaperGridView.c(this.zkn) < 0) || (MMGridPaperGridView.a(this.zkn) == null))
    {
      AppMethodBeat.o(106644);
      return 0;
    }
    int i = MMGridPaperGridView.c(this.zkn);
    AppMethodBeat.o(106644);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(106645);
    if (MMGridPaperGridView.a(this.zkn) == null)
    {
      AppMethodBeat.o(106645);
      return null;
    }
    Object localObject = MMGridPaperGridView.a(this.zkn).getItem(MMGridPaperGridView.b(this.zkn) + paramInt);
    AppMethodBeat.o(106645);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(106646);
    if (MMGridPaperGridView.a(this.zkn) == null)
    {
      AppMethodBeat.o(106646);
      return 0L;
    }
    long l = MMGridPaperGridView.a(this.zkn).getItemId(MMGridPaperGridView.b(this.zkn) + paramInt);
    AppMethodBeat.o(106646);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(106642);
    if (MMGridPaperGridView.a(this.zkn) == null)
    {
      AppMethodBeat.o(106642);
      return 0;
    }
    MMGridPaperGridView.a(this.zkn);
    MMGridPaperGridView.b(this.zkn);
    AppMethodBeat.o(106642);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(106647);
    long l = bo.yB();
    int i = MMGridPaperGridView.d(this.zkn);
    boolean bool;
    if (paramView == null)
    {
      bool = true;
      ab.v("MicroMsg.MMGridPaperGridView", "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(bool), paramViewGroup.toString(), Boolean.valueOf(MMGridPaperGridView.e(this.zkn)) });
      if (MMGridPaperGridView.e(this.zkn)) {
        paramView = null;
      }
      if (MMGridPaperGridView.a(this.zkn) != null) {
        break label214;
      }
      paramView = null;
      label104:
      if (paramView == null) {
        break label238;
      }
      bool = true;
      label111:
      Assert.assertTrue(bool);
      if ((-1 == MMGridPaperGridView.f(this.zkn)) || (MMGridPaperGridView.b(this.zkn) + paramInt != MMGridPaperGridView.f(this.zkn))) {
        break label244;
      }
      paramView.setVisibility(4);
    }
    for (;;)
    {
      ab.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(MMGridPaperGridView.f(this.zkn)), Integer.valueOf(MMGridPaperGridView.b(this.zkn) + paramInt) });
      AppMethodBeat.o(106647);
      return paramView;
      bool = false;
      break;
      label214:
      paramView = MMGridPaperGridView.a(this.zkn).d(MMGridPaperGridView.b(this.zkn) + paramInt, paramView);
      break label104;
      label238:
      bool = false;
      break label111;
      label244:
      paramView.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(106643);
    if (MMGridPaperGridView.a(this.zkn) == null)
    {
      AppMethodBeat.o(106643);
      return 1;
    }
    MMGridPaperGridView.a(this.zkn);
    AppMethodBeat.o(106643);
    return 1;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(106641);
    if (MMGridPaperGridView.a(this.zkn) == null)
    {
      AppMethodBeat.o(106641);
      return false;
    }
    MMGridPaperGridView.a(this.zkn);
    MMGridPaperGridView.b(this.zkn);
    AppMethodBeat.o(106641);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView.a
 * JD-Core Version:    0.7.0.1
 */