package com.tencent.mm.plugin.sns.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/sheet/MenuItem;", "", "nameResId", "", "rawResId", "colorResId", "(III)V", "getColorResId", "()I", "getNameResId", "getRawResId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  final int RUi;
  final int RUj;
  final int RUk;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.RUi = paramInt1;
    this.RUj = paramInt2;
    this.RUk = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.RUi != paramObject.RUi) {
        return false;
      }
      if (this.RUj != paramObject.RUj) {
        return false;
      }
    } while (this.RUk == paramObject.RUk);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.RUi * 31 + this.RUj) * 31 + this.RUk;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(308907);
    String str = "MenuItem(nameResId=" + this.RUi + ", rawResId=" + this.RUj + ", colorResId=" + this.RUk + ')';
    AppMethodBeat.o(308907);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */