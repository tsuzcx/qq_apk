package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.b;
import com.tencent.mm.an.a.c;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;

public final class d
  extends r
  implements MStorageEx.IOnStorageChange
{
  private int OpX;
  private Cursor pKb;
  private String vEu;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(34092);
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    this.vEu = paramString;
    aNm();
    AppMethodBeat.o(34092);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(34093);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    this.pKb = af.bHi().MW(this.vEu);
    this.OpX = 0;
    AppMethodBeat.o(34093);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(34096);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(34096);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34094);
    int i = this.pKb.getCount();
    AppMethodBeat.o(34094);
    return i + 1;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(34097);
    aNm();
    notifyDataSetChanged();
    AppMethodBeat.o(34097);
  }
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(34095);
    Object localObject = null;
    if (paramInt == this.OpX)
    {
      localObject = new j(paramInt);
      ((j)localObject).header = this.afex.getActivity().getResources().getString(R.l.gUE);
    }
    for (;;)
    {
      AppMethodBeat.o(34095);
      return localObject;
      if ((paramInt > this.OpX) && (this.pKb.moveToPosition(paramInt - this.OpX - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.an.a.a locala1 = new com.tencent.mm.an.a.a();
        locala1.convertFrom(this.pKb);
        localObject = locala;
        if (locala.vEb == -1L)
        {
          locala.vEb = locala1.field_bizChatId;
          localObject = af.bHh().dW(locala1.field_bizChatId);
          if ((localObject != null) && (((c)localObject).bHx()))
          {
            locala.pJG = ((c)localObject).field_chatName;
            locala.nnS = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (Util.isNullOrNil(locala.pJG)) {
              locala.pJG = this.afex.getActivity().getResources().getString(R.l.gTN);
            }
            localObject = locala;
            if (!Util.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            if (localObject != null)
            {
              localObject = af.bHj().hM(((c)localObject).field_bizChatServId);
              if (localObject != null)
              {
                locala.pJG = ((k)localObject).field_userName;
                locala.nnS = ((k)localObject).field_headImageUrl;
                locala.username = ((k)localObject).field_brandUserName;
              }
            }
          }
        }
      }
      else
      {
        Log.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */