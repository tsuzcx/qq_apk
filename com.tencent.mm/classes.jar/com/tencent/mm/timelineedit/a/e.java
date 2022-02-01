package com.tencent.mm.timelineedit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/model/Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "timelinelib_release"}, k=1, mv={1, 1, 15})
public final class e
{
  final int height;
  final int width;
  
  public e(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof e)) {
        break label65;
      }
      paramObject = (e)paramObject;
      if (this.width != paramObject.width) {
        break label67;
      }
      i = 1;
      bool1 = bool2;
      if (i == 0) {
        break label65;
      }
      if (this.height != paramObject.height) {
        break label72;
      }
    }
    label65:
    label67:
    label72:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      i = 0;
      break;
    }
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(232070);
    String str = "Size(width=" + this.width + ", height=" + this.height + ')';
    AppMethodBeat.o(232070);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.e
 * JD-Core Version:    0.7.0.1
 */