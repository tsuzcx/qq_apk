package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "", "spanIndex", "", "width", "height", "(III)V", "foldedAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getFoldedAdapterRef", "()Ljava/lang/ref/WeakReference;", "setFoldedAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "foldedExpose", "", "getFoldedExpose", "()Z", "setFoldedExpose", "(Z)V", "foldedExposeReport", "getFoldedExposeReport", "setFoldedExposeReport", "foldedSessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getFoldedSessionExposeMap", "()Landroid/util/LongSparseArray;", "setFoldedSessionExposeMap", "(Landroid/util/LongSparseArray;)V", "foldedTop", "getFoldedTop", "()I", "setFoldedTop", "(I)V", "globalVisibleBottom", "getGlobalVisibleBottom", "setGlobalVisibleBottom", "globalVisibleTop", "getGlobalVisibleTop", "setGlobalVisibleTop", "getHeight", "setHeight", "getSpanIndex", "visibleTop", "getVisibleTop", "setVisibleTop", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "libmmui_release"})
public final class f
{
  public int LvA;
  public boolean LvB;
  public boolean LvC;
  public LongSparseArray<h> LvD;
  public WeakReference<WxRecyclerAdapter<?>> LvE;
  public final int LvF;
  public int Lvx;
  public int Lvy;
  public int Lvz;
  public int height;
  public int width;
  
  public f(int paramInt1, int paramInt2, int paramInt3)
  {
    this.LvF = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((this.LvF != paramObject.LvF) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (this.LvF * 31 + this.width) * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186670);
    String str = "WxItemShowInfo(spanIndex=" + this.LvF + ", width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(186670);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.f
 * JD-Core Version:    0.7.0.1
 */