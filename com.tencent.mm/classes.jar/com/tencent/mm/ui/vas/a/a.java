package com.tencent.mm.ui.vas.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/actionbar/VasActionBarData;", "", "title", "", "mapBackBtnIconColor", "", "backColor", "textColor", "titleTextSize", "", "(Ljava/lang/CharSequence;IIIF)V", "getBackColor", "()I", "getMapBackBtnIconColor", "getTextColor", "getTitle", "()Ljava/lang/CharSequence;", "getTitleTextSize", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final int GBJ;
  private final int afQV;
  private final float afQW;
  private final int textColor;
  private final CharSequence title;
  
  public a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    this.title = paramCharSequence;
    this.afQV = paramInt1;
    this.GBJ = paramInt2;
    this.textColor = paramInt3;
    this.afQW = paramFloat;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(249950);
    if (this == paramObject)
    {
      AppMethodBeat.o(249950);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(249950);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.title, paramObject.title))
    {
      AppMethodBeat.o(249950);
      return false;
    }
    if (this.afQV != paramObject.afQV)
    {
      AppMethodBeat.o(249950);
      return false;
    }
    if (this.GBJ != paramObject.GBJ)
    {
      AppMethodBeat.o(249950);
      return false;
    }
    if (this.textColor != paramObject.textColor)
    {
      AppMethodBeat.o(249950);
      return false;
    }
    if (!s.p(Float.valueOf(this.afQW), Float.valueOf(paramObject.afQW)))
    {
      AppMethodBeat.o(249950);
      return false;
    }
    AppMethodBeat.o(249950);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(249944);
    if (this.title == null) {}
    for (int i = 0;; i = this.title.hashCode())
    {
      int j = this.afQV;
      int k = this.GBJ;
      int m = this.textColor;
      int n = Float.floatToIntBits(this.afQW);
      AppMethodBeat.o(249944);
      return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(249941);
    String str = "VasActionBarData(title=" + this.title + ", mapBackBtnIconColor=" + this.afQV + ", backColor=" + this.GBJ + ", textColor=" + this.textColor + ", titleTextSize=" + this.afQW + ')';
    AppMethodBeat.o(249941);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.vas.a.a
 * JD-Core Version:    0.7.0.1
 */