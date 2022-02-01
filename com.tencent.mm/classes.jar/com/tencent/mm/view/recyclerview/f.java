package com.tencent.mm.view.recyclerview;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "", "spanIndex", "", "width", "height", "(III)V", "foldedAdapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getFoldedAdapterRef", "()Ljava/lang/ref/WeakReference;", "setFoldedAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "foldedExpose", "", "getFoldedExpose", "()Z", "setFoldedExpose", "(Z)V", "foldedExposeReport", "getFoldedExposeReport", "setFoldedExposeReport", "foldedSessionExposeMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getFoldedSessionExposeMap", "()Landroid/util/LongSparseArray;", "setFoldedSessionExposeMap", "(Landroid/util/LongSparseArray;)V", "foldedTop", "getFoldedTop", "()I", "setFoldedTop", "(I)V", "globalVisibleBottom", "getGlobalVisibleBottom", "setGlobalVisibleBottom", "globalVisibleTop", "getGlobalVisibleTop", "setGlobalVisibleTop", "getHeight", "setHeight", "getSpanIndex", "visibleTop", "getVisibleTop", "setVisibleTop", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "libmmui_release"})
public final class f
{
  public int LSk;
  public int LSl;
  public int LSm;
  public int LSn;
  public boolean LSo;
  public boolean LSp;
  public LongSparseArray<h> LSq;
  public WeakReference<WxRecyclerAdapter<?>> LSr;
  public final int LSs;
  public int height;
  public int width;
  
  public f(int paramInt1, int paramInt2, int paramInt3)
  {
    this.LSs = paramInt1;
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
        if ((this.LSs != paramObject.LSs) || (this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return (this.LSs * 31 + this.width) * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193927);
    String str = "WxItemShowInfo(spanIndex=" + this.LSs + ", width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(193927);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.f
 * JD-Core Version:    0.7.0.1
 */