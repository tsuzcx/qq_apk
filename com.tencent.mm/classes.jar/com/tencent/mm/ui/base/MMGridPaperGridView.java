package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class MMGridPaperGridView
  extends GridView
{
  private AdapterView.OnItemClickListener Mgu;
  private int WjV;
  private int WjW;
  private int WjX;
  private int WjY;
  private boolean WjZ;
  private a Wka;
  private j Wkb;
  private AdapterView.OnItemLongClickListener Wkc;
  private int mCount;
  private int mIndex;
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141996);
    this.WjY = -1;
    this.WjZ = false;
    this.Mgu = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141986);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          Log.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          a.a(this, "com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(141986);
          return;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        a.a(this, "com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(141986);
      }
    };
    this.Wkc = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141987);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          Log.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
          AppMethodBeat.o(141987);
          return false;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        AppMethodBeat.o(141987);
        return false;
      }
    };
    AppMethodBeat.o(141996);
  }
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141995);
    this.WjY = -1;
    this.WjZ = false;
    this.Mgu = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141986);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          Log.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          a.a(this, "com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(141986);
          return;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        a.a(this, "com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(141986);
      }
    };
    this.Wkc = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141987);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          Log.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
          AppMethodBeat.o(141987);
          return false;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        AppMethodBeat.o(141987);
        return false;
      }
    };
    AppMethodBeat.o(141995);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(141997);
    if (paramj == null) {}
    for (;;)
    {
      Log.i("MicroMsg.MMGridPaperGridView", "index[%d], rows[%d], columns[%d], adapter is null[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
      this.mIndex = paramInt1;
      this.WjV = paramInt2;
      this.WjW = paramInt3;
      this.Wkb = paramj;
      this.mCount = (this.WjV * this.WjW);
      this.WjX = (this.mIndex * this.mCount);
      if ((this.Wkb != null) && (this.Wkb.getCount() - this.WjX < this.mCount)) {
        this.mCount = (this.Wkb.getCount() - this.WjX);
      }
      if (getAdapter() == null)
      {
        Log.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
        this.Wka = new a((byte)0);
        setAdapter(this.Wka);
      }
      setNumColumns(this.WjW);
      setColumnWidth(3);
      setOnItemClickListener(this.Mgu);
      setOnItemLongClickListener(this.Wkc);
      AppMethodBeat.o(141997);
      return;
      bool = false;
    }
  }
  
  public final int getIndex()
  {
    return this.mIndex;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(141998);
    if (this.Wka != null) {
      this.Wka.notifyDataSetChanged();
    }
    AppMethodBeat.o(141998);
  }
  
  public final void setClearMode(boolean paramBoolean)
  {
    this.WjZ = paramBoolean;
  }
  
  public final void setHiddenIndex(int paramInt)
  {
    this.WjY = paramInt;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(141991);
      if ((MMGridPaperGridView.c(MMGridPaperGridView.this) < 0) || (MMGridPaperGridView.a(MMGridPaperGridView.this) == null))
      {
        AppMethodBeat.o(141991);
        return 0;
      }
      int i = MMGridPaperGridView.c(MMGridPaperGridView.this);
      AppMethodBeat.o(141991);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141992);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        AppMethodBeat.o(141992);
        return null;
      }
      Object localObject = MMGridPaperGridView.a(MMGridPaperGridView.this).getItem(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt);
      AppMethodBeat.o(141992);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(141993);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        AppMethodBeat.o(141993);
        return 0L;
      }
      long l = MMGridPaperGridView.a(MMGridPaperGridView.this).getItemId(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt);
      AppMethodBeat.o(141993);
      return l;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(141989);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        AppMethodBeat.o(141989);
        return 0;
      }
      MMGridPaperGridView.a(MMGridPaperGridView.this);
      MMGridPaperGridView.b(MMGridPaperGridView.this);
      AppMethodBeat.o(141989);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(141994);
      long l = Util.currentTicks();
      int i = MMGridPaperGridView.d(MMGridPaperGridView.this);
      boolean bool;
      if (paramView == null)
      {
        bool = true;
        Log.v("MicroMsg.MMGridPaperGridView", "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(bool), paramViewGroup.toString(), Boolean.valueOf(MMGridPaperGridView.e(MMGridPaperGridView.this)) });
        if (MMGridPaperGridView.e(MMGridPaperGridView.this)) {
          paramView = null;
        }
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) != null) {
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
        if ((-1 == MMGridPaperGridView.f(MMGridPaperGridView.this)) || (MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt != MMGridPaperGridView.f(MMGridPaperGridView.this))) {
          break label244;
        }
        paramView.setVisibility(4);
      }
      for (;;)
      {
        Log.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(MMGridPaperGridView.f(MMGridPaperGridView.this)), Integer.valueOf(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt) });
        AppMethodBeat.o(141994);
        return paramView;
        bool = false;
        break;
        label214:
        paramView = MMGridPaperGridView.a(MMGridPaperGridView.this).e(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt, paramView);
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
      AppMethodBeat.i(141990);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        AppMethodBeat.o(141990);
        return 1;
      }
      MMGridPaperGridView.a(MMGridPaperGridView.this);
      AppMethodBeat.o(141990);
      return 1;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(141988);
      if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
      {
        AppMethodBeat.o(141988);
        return false;
      }
      MMGridPaperGridView.a(MMGridPaperGridView.this);
      MMGridPaperGridView.b(MMGridPaperGridView.this);
      AppMethodBeat.o(141988);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView
 * JD-Core Version:    0.7.0.1
 */