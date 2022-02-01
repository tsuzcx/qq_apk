package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

final class FindMoreFriendsUI$15
  implements DialogInterface.OnClickListener
{
  FindMoreFriendsUI$15(FindMoreFriendsUI paramFindMoreFriendsUI, MultiProcessMMKV paramMultiProcessMMKV) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(278904);
    this.rSN.putInt("life_mode", paramInt);
    this.rSN.commit();
    AppMethodBeat.o(278904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI.15
 * JD-Core Version:    0.7.0.1
 */