package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class MMGridPaperGridView
  extends GridView
{
  private int mCount;
  private int mIndex;
  private AdapterView.OnItemClickListener sYO;
  private int zkf;
  private int zkg;
  private int zkh;
  private int zki;
  private boolean zkj;
  private MMGridPaperGridView.a zkk;
  private j zkl;
  private AdapterView.OnItemLongClickListener zkm;
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106649);
    this.zki = -1;
    this.zkj = false;
    this.sYO = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106639);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          ab.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          AppMethodBeat.o(106639);
          return;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        AppMethodBeat.o(106639);
      }
    };
    this.zkm = new MMGridPaperGridView.2(this);
    AppMethodBeat.o(106649);
  }
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106648);
    this.zki = -1;
    this.zkj = false;
    this.sYO = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(106639);
        if (MMGridPaperGridView.a(MMGridPaperGridView.this) == null)
        {
          ab.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
          AppMethodBeat.o(106639);
          return;
        }
        MMGridPaperGridView.a(MMGridPaperGridView.this);
        MMGridPaperGridView.b(MMGridPaperGridView.this);
        AppMethodBeat.o(106639);
      }
    };
    this.zkm = new MMGridPaperGridView.2(this);
    AppMethodBeat.o(106648);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, j paramj)
  {
    boolean bool = true;
    AppMethodBeat.i(106650);
    if (paramj == null) {}
    for (;;)
    {
      ab.i("MicroMsg.MMGridPaperGridView", "index[%d], rows[%d], columns[%d], adapter is null[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
      this.mIndex = paramInt1;
      this.zkf = paramInt2;
      this.zkg = paramInt3;
      this.zkl = paramj;
      this.mCount = (this.zkf * this.zkg);
      this.zkh = (this.mIndex * this.mCount);
      if ((this.zkl != null) && (this.zkl.getCount() - this.zkh < this.mCount)) {
        this.mCount = (this.zkl.getCount() - this.zkh);
      }
      if (getAdapter() == null)
      {
        ab.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
        this.zkk = new MMGridPaperGridView.a(this, (byte)0);
        setAdapter(this.zkk);
      }
      setNumColumns(this.zkg);
      setColumnWidth(3);
      setOnItemClickListener(this.sYO);
      setOnItemLongClickListener(this.zkm);
      AppMethodBeat.o(106650);
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
    AppMethodBeat.i(106651);
    if (this.zkk != null) {
      this.zkk.notifyDataSetChanged();
    }
    AppMethodBeat.o(106651);
  }
  
  public final void setClearMode(boolean paramBoolean)
  {
    this.zkj = paramBoolean;
  }
  
  public final void setHiddenIndex(int paramInt)
  {
    this.zki = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView
 * JD-Core Version:    0.7.0.1
 */