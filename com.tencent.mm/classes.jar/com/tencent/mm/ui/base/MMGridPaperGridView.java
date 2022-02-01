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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class MMGridPaperGridView
  extends GridView
{
  private int Hxs;
  private int Hxt;
  private int Hxu;
  private int Hxv;
  private boolean Hxw;
  private a Hxx;
  private j Hxy;
  private AdapterView.OnItemLongClickListener Hxz;
  private int mCount;
  private int mIndex;
  private AdapterView.OnItemClickListener zSC;
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141996);
    this.Hxv = -1;
    this.Hxw = false;
    this.zSC = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141986);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          ac.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          AppMethodBeat.o(141986);
          return;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        AppMethodBeat.o(141986);
      }
    };
    this.Hxz = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141987);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          ac.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
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
    this.Hxv = -1;
    this.Hxw = false;
    this.zSC = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141986);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          ac.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          AppMethodBeat.o(141986);
          return;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        AppMethodBeat.o(141986);
      }
    };
    this.Hxz = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(141987);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          ac.w("MicroMsg.MMGridPaperGridView", "on item long click, but main adapter is null");
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
      ac.i("MicroMsg.MMGridPaperGridView", "index[%d], rows[%d], columns[%d], adapter is null[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
      this.mIndex = paramInt1;
      this.Hxs = paramInt2;
      this.Hxt = paramInt3;
      this.Hxy = paramj;
      this.mCount = (this.Hxs * this.Hxt);
      this.Hxu = (this.mIndex * this.mCount);
      if ((this.Hxy != null) && (this.Hxy.getCount() - this.Hxu < this.mCount)) {
        this.mCount = (this.Hxy.getCount() - this.Hxu);
      }
      if (getAdapter() == null)
      {
        ac.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
        this.Hxx = new a((byte)0);
        setAdapter(this.Hxx);
      }
      setNumColumns(this.Hxt);
      setColumnWidth(3);
      setOnItemClickListener(this.zSC);
      setOnItemLongClickListener(this.Hxz);
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
    if (this.Hxx != null) {
      this.Hxx.notifyDataSetChanged();
    }
    AppMethodBeat.o(141998);
  }
  
  public final void setClearMode(boolean paramBoolean)
  {
    this.Hxw = paramBoolean;
  }
  
  public final void setHiddenIndex(int paramInt)
  {
    this.Hxv = paramInt;
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
      long l = bs.Gn();
      int i = MMGridPaperGridView.d(MMGridPaperGridView.this);
      boolean bool;
      if (paramView == null)
      {
        bool = true;
        ac.v("MicroMsg.MMGridPaperGridView", "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Boolean.valueOf(bool), paramViewGroup.toString(), Boolean.valueOf(MMGridPaperGridView.e(MMGridPaperGridView.this)) });
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
        ac.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", new Object[] { Long.valueOf(bs.aO(l)), Integer.valueOf(MMGridPaperGridView.f(MMGridPaperGridView.this)), Integer.valueOf(MMGridPaperGridView.b(MMGridPaperGridView.this) + paramInt) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView
 * JD-Core Version:    0.7.0.1
 */