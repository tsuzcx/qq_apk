package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.tencent.mm.sdk.platformtools.y;

public final class MMGridPaperGridView
  extends GridView
{
  private int mCount;
  private int mIndex;
  private AdapterView.OnItemClickListener pwZ = new MMGridPaperGridView.1(this);
  private int uVM;
  private int uVN;
  private int uVO;
  private int uVP = -1;
  private boolean uVQ = false;
  MMGridPaperGridView.a uVR;
  private j uVS;
  private AdapterView.OnItemLongClickListener uVT = new MMGridPaperGridView.2(this);
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMGridPaperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, j paramj)
  {
    boolean bool = true;
    if (paramj == null) {}
    for (;;)
    {
      y.i("MicroMsg.MMGridPaperGridView", "index[%d], rows[%d], columns[%d], adapter is null[%B]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
      this.mIndex = paramInt1;
      this.uVM = paramInt2;
      this.uVN = paramInt3;
      this.uVS = paramj;
      this.mCount = (this.uVM * this.uVN);
      this.uVO = (this.mIndex * this.mCount);
      if ((this.uVS != null) && (this.uVS.getCount() - this.uVO < this.mCount)) {
        this.mCount = (this.uVS.getCount() - this.uVO);
      }
      if (getAdapter() == null)
      {
        y.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
        this.uVR = new MMGridPaperGridView.a(this, (byte)0);
        setAdapter(this.uVR);
      }
      setNumColumns(this.uVN);
      setColumnWidth(3);
      setOnItemClickListener(this.pwZ);
      setOnItemLongClickListener(this.uVT);
      return;
      bool = false;
    }
  }
  
  public final int getIndex()
  {
    return this.mIndex;
  }
  
  public final void setClearMode(boolean paramBoolean)
  {
    this.uVQ = paramBoolean;
  }
  
  public final void setHiddenIndex(int paramInt)
  {
    this.uVP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMGridPaperGridView
 * JD-Core Version:    0.7.0.1
 */