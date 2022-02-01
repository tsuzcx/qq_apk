package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "", "spanIndex", "", "width", "height", "(III)V", "foldedAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getFoldedAdapterRef", "()Ljava/lang/ref/WeakReference;", "setFoldedAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "foldedExpose", "", "getFoldedExpose", "()Z", "setFoldedExpose", "(Z)V", "foldedExposeReport", "getFoldedExposeReport", "setFoldedExposeReport", "foldedSessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getFoldedSessionExposeMap", "()Landroid/util/LongSparseArray;", "setFoldedSessionExposeMap", "(Landroid/util/LongSparseArray;)V", "foldedTop", "getFoldedTop", "()I", "setFoldedTop", "(I)V", "globalVisibleBottom", "getGlobalVisibleBottom", "setGlobalVisibleBottom", "globalVisibleTop", "getGlobalVisibleTop", "setGlobalVisibleTop", "getHeight", "setHeight", "getSpanIndex", "visibleTop", "getVisibleTop", "setVisibleTop", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "libmmui_release"})
public final class f
{
  public int LDH;
  public int LDI;
  public int LDJ;
  public int LDK;
  public boolean LDL;
  public boolean LDM;
  public LongSparseArray<h> LDN;
  public WeakReference<WxRecyclerAdapter<?>> LDO;
  public final int LDP;
  public int height;
  public int width;
  
  public f(int paramInt1, int paramInt2, int paramInt3)
  {
    this.LDP = paramInt1;
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
        if ((this.LDP != paramObject.LDP) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (this.LDP * 31 + this.width) * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203981);
    String str = "WxItemShowInfo(spanIndex=" + this.LDP + ", width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(203981);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.f
 * JD-Core Version:    0.7.0.1
 */