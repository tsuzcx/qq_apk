package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.a.b;
import com.tencent.mm.ao.a.c;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.a.l;
import com.tencent.mm.ao.af;
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
  private int Isp;
  private Cursor mNt;
  private String syN;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(34092);
    Log.i("MicroMsg.RecentConversationAdapter", "create!");
    this.syN = paramString;
    ate();
    AppMethodBeat.o(34092);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(34093);
    Log.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    this.mNt = af.bjy().UX(this.syN);
    this.Isp = 0;
    AppMethodBeat.o(34093);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(34096);
    super.finish();
    Log.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.mNt != null)
    {
      this.mNt.close();
      this.mNt = null;
    }
    AppMethodBeat.o(34096);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34094);
    int i = this.mNt.getCount();
    AppMethodBeat.o(34094);
    return i + 1;
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(34097);
    ate();
    notifyDataSetChanged();
    AppMethodBeat.o(34097);
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(34095);
    Object localObject = null;
    if (paramInt == this.Isp)
    {
      localObject = new j(paramInt);
      ((j)localObject).header = this.XsW.getActivity().getResources().getString(R.l.eRW);
    }
    for (;;)
    {
      AppMethodBeat.o(34095);
      return localObject;
      if ((paramInt > this.Isp) && (this.mNt.moveToPosition(paramInt - this.Isp - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.ao.a.a locala1 = new com.tencent.mm.ao.a.a();
        locala1.convertFrom(this.mNt);
        localObject = locala;
        if (locala.syu == -1L)
        {
          locala.syu = locala1.field_bizChatId;
          localObject = af.bjx().bF(locala1.field_bizChatId);
          if (((c)localObject).bjM())
          {
            locala.mMY = ((c)localObject).field_chatName;
            locala.kLW = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (Util.isNullOrNil(locala.mMY)) {
              locala.mMY = this.XsW.getActivity().getResources().getString(R.l.eRh);
            }
            localObject = locala;
            if (!Util.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = af.bjz().gm(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.mMY = ((k)localObject).field_userName;
              locala.kLW = ((k)localObject).field_headImageUrl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */