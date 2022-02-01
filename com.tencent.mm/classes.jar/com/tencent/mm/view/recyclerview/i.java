package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "", "spanIndex", "", "width", "height", "(III)V", "foldedAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getFoldedAdapterRef", "()Ljava/lang/ref/WeakReference;", "setFoldedAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "foldedExpose", "", "getFoldedExpose", "()Z", "setFoldedExpose", "(Z)V", "foldedExposeReport", "getFoldedExposeReport", "setFoldedExposeReport", "foldedSessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getFoldedSessionExposeMap", "()Landroid/util/LongSparseArray;", "setFoldedSessionExposeMap", "(Landroid/util/LongSparseArray;)V", "foldedTop", "getFoldedTop", "()I", "setFoldedTop", "(I)V", "globalVisibleBottom", "getGlobalVisibleBottom", "setGlobalVisibleBottom", "globalVisibleTop", "getGlobalVisibleTop", "setGlobalVisibleTop", "getHeight", "setHeight", "getSpanIndex", "visibleTop", "getVisibleTop", "setVisibleTop", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "libmmui_release"})
public final class i
{
  public int Rrb;
  public int Rrc;
  public int Rrd;
  public int Rre;
  public boolean Rrf;
  public boolean Rrg;
  public LongSparseArray<k> Rrh;
  public WeakReference<WxRecyclerAdapter<?>> Rri;
  public final int Rrj;
  public int height;
  public int width;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    this.Rrj = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((this.Rrj != paramObject.Rrj) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (this.Rrj * 31 + this.width) * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205048);
    String str = "WxItemShowInfo(spanIndex=" + this.Rrj + ", width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(205048);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.i
 * JD-Core Version:    0.7.0.1
 */