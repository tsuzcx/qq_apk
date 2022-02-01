package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/UpdateBottomMenuHeightAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "height", "", "(I)V", "getHeight", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends BaseStateAction
{
  public final int height;
  
  public m(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof m)) {
        return false;
      }
      paramObject = (m)paramObject;
    } while (this.height == paramObject.height);
    return false;
  }
  
  public final int hashCode()
  {
    return this.height;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250436);
    String str = "UpdateBottomMenuHeightAction(height=" + this.height + ')';
    AppMethodBeat.o(250436);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.m
 * JD-Core Version:    0.7.0.1
 */