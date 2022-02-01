package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/ScreenSizeUtil;", "", "()V", "get", "Lcom/tencent/mm/ui/ScreenSizeUtil$Size;", "_context", "Landroid/content/Context;", "Size", "wechat-ui-sdk_release"})
public final class af
{
  public static final af HrL;
  
  static
  {
    AppMethodBeat.i(175972);
    HrL = new af();
    AppMethodBeat.o(175972);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/ScreenSizeUtil$Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "wechat-ui-sdk_release"})
  public static final class a
  {
    public final int height;
    public final int width;
    
    public a(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.width * 31 + this.height;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(175970);
      String str = "Size(width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(175970);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.af
 * JD-Core Version:    0.7.0.1
 */