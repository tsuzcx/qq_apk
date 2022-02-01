package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;

public final class d
  extends q
  implements MStorageEx.IOnStorageChange
{
  private int CuC;
  private Cursor jWh;
  private String ppO;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(34092);
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    this.ppO = paramString;
    and();
    AppMethodBeat.o(34092);
  }
  
  public final void and()
  {
    AppMethodBeat.i(34093);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    this.jWh = ag.bak().NB(this.ppO);
    this.CuC = 0;
    AppMethodBeat.o(34093);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(34096);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    AppMethodBeat.o(34096);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34094);
    int i = this.jWh.getCount();
    AppMethodBeat.o(34094);
    return i + 1;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(34097);
    and();
    notifyDataSetChanged();
    AppMethodBeat.o(34097);
  }
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(34095);
    Object localObject = null;
    if (paramInt == this.CuC)
    {
      localObject = new h(paramInt);
      ((h)localObject).header = this.PWg.getActivity().getResources().getString(2131765140);
    }
    for (;;)
    {
      AppMethodBeat.o(34095);
      return localObject;
      if ((paramInt > this.CuC) && (this.jWh.moveToPosition(paramInt - this.CuC - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.al.a.a locala1 = new com.tencent.mm.al.a.a();
        locala1.convertFrom(this.jWh);
        localObject = locala;
        if (locala.ppv == -1L)
        {
          locala.ppv = locala1.field_bizChatId;
          localObject = ag.baj().bs(locala1.field_bizChatId);
          if (((c)localObject).isGroup())
          {
            locala.jVL = ((c)localObject).field_chatName;
            locala.hXq = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (Util.isNullOrNil(locala.jVL)) {
              locala.jVL = this.PWg.getActivity().getResources().getString(2131764705);
            }
            localObject = locala;
            if (!Util.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = ag.bal().fB(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.jVL = ((k)localObject).field_userName;
              locala.hXq = ((k)localObject).field_headImageUrl;
              locala.username = ((k)localObject).field_brandUserName;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */