package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fun;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter$UserAuthAppWrapper;", "", "itemType", "", "userAuthApp", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "(ILcom/tencent/mm/protocal/protobuf/UserAuthApp;)V", "getItemType", "()I", "getUserAuthApp", "()Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
final class SettingsAuthUI$b$d
{
  final fun Psu;
  final int itemType;
  
  public SettingsAuthUI$b$d(int paramInt, fun paramfun)
  {
    this.itemType = paramInt;
    this.Psu = paramfun;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(299418);
    if (this == paramObject)
    {
      AppMethodBeat.o(299418);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(299418);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.itemType != paramObject.itemType)
    {
      AppMethodBeat.o(299418);
      return false;
    }
    if (!s.p(this.Psu, paramObject.Psu))
    {
      AppMethodBeat.o(299418);
      return false;
    }
    AppMethodBeat.o(299418);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(299414);
    int j = this.itemType;
    if (this.Psu == null) {}
    for (int i = 0;; i = this.Psu.hashCode())
    {
      AppMethodBeat.o(299414);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(299411);
    String str = "UserAuthAppWrapper(itemType=" + this.itemType + ", userAuthApp=" + this.Psu + ')';
    AppMethodBeat.o(299411);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAuthUI.b.d
 * JD-Core Version:    0.7.0.1
 */