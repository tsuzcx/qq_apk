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
  private AdapterView.OnItemClickListener SHR;
  private int adQY;
  private int adQZ;
  private int adRa;
  private int adRb;
  private boolean adRc;
  private a adRd;
  private l adRe;
  private AdapterView.OnItemLongClickListener adRf;
  private int mCount;
  private int mIndex;
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141996);
    this.adRb = -1;
    this.adRc = false;
    this.SHR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141986);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
    this.adRf = new AdapterView.OnItemLongClickListener()
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
        paramAnonymousAdapterView = MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        boolean bool = paramAnonymousAdapterView.fUP();
        AppMethodBeat.o(141987);
        return bool;
      }
    };
    AppMethodBeat.o(141996);
  }
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141995);
    this.adRb = -1;
    this.adRc = false;
    this.SHR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141986);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/MMGridPaperGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
    this.adRf = new AdapterView.OnItemLongClickListener()
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
        paramAnonymousAdapterView = MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        boolean bool = paramAnonymousAdapterView.fUP();
        AppMethodBeat.o(141987);
        return bool;
      }
    };
    AppMethodBeat.o(141995);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, l paraml)
  {
    boolean bool = true;
    AppMethodBeat.i(141997);
    if (paraml == null) {}
    for (;;)
    {
      Log.i("MicroMsg.MMGridPaperGridView", "index[%d], rows[%d], columns[%d], adapter is null[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
      this.mIndex = paramInt1;
      this.adQY = paramInt2;
      this.adQZ = paramInt3;
      this.adRe = paraml;
      this.mCount = (this.adQY * this.adQZ);
      this.adRa = (this.mIndex * this.mCount);
      if ((this.adRe != null) && (this.adRe.getCount() - this.adRa < this.mCount)) {
        this.mCount = (this.adRe.getCount() - this.adRa);
      }
      if (getAdapter() == null)
      {
        Log.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
        this.adRd = new a((byte)0);
        setAdapter(this.adRd);
      }
      setNumColumns(this.adQZ);
      setColumnWidth(3);
      setOnItemClickListener(this.SHR);
      setOnItemLongClickListener(this.adRf);
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
    if (this.adRd != null) {
      this.adRd.notifyDataSetChanged();
    }
    AppMethodBeat.o(141998);
  }
  
  public final void setClearMode(boolean paramBoolean)
  {
    this.adRc = paramBoolean;
  }
  
  public final void setHiddenIndex(int paramInt)
  {
    this.adRb = paramInt;
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
      paramInt = l.jmo();
      AppMethodBeat.o(141989);
      return paramInt;
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
        paramView = MMGridPaperGridView.a(MMGridPaperGridView.this).g(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt, paramView);
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
      int i = l.getViewTypeCount();
      AppMethodBeat.o(141990);
      return i;
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
      boolean bool = l.jmn();
      AppMethodBeat.o(141988);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView
 * JD-Core Version:    0.7.0.1
 */