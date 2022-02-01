package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/RecentForwardItemData;", "", "contactUserName", "", "displayNickName", "isSelected", "", "isShowCheckBox", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getContactUserName", "()Ljava/lang/String;", "getDisplayNickName", "()Z", "setSelected", "(Z)V", "setShowCheckBox", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public final String afhk;
  final String afhl;
  public boolean afhm;
  public boolean isSelected;
  
  private ai(String paramString1, String paramString2)
  {
    AppMethodBeat.i(252787);
    this.afhk = paramString1;
    this.afhl = paramString2;
    this.isSelected = false;
    this.afhm = false;
    AppMethodBeat.o(252787);
  }
  
  public ai(String paramString1, String paramString2, char paramChar)
  {
    this(paramString1, paramString2, (byte)0);
    AppMethodBeat.i(252794);
    AppMethodBeat.o(252794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ai
 * JD-Core Version:    0.7.0.1
 */