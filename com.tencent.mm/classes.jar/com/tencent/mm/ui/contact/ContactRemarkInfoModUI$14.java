package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;

final class ContactRemarkInfoModUI$14
  implements MStorageEx.IOnStorageChange
{
  ContactRemarkInfoModUI$14(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(272533);
    Log.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
    ContactRemarkInfoModUI.d(this.XrY);
    AppMethodBeat.o(272533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.14
 * JD-Core Version:    0.7.0.1
 */