package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;

public final class d
  extends q
  implements n.b
{
  private Cursor iCz;
  private String nxJ;
  private int wQm;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(34092);
    ac.i("MicroMsg.RecentConversationAdapter", "create!");
    this.nxJ = paramString;
    WN();
    AppMethodBeat.o(34092);
  }
  
  public final void WN()
  {
    AppMethodBeat.i(34093);
    ac.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    this.iCz = af.aCZ().Bm(this.nxJ);
    this.wQm = 0;
    AppMethodBeat.o(34093);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(34097);
    WN();
    notifyDataSetChanged();
    AppMethodBeat.o(34097);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(34096);
    super.finish();
    ac.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    AppMethodBeat.o(34096);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34094);
    int i = this.iCz.getCount();
    AppMethodBeat.o(34094);
    return i + 1;
  }
  
  public final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(34095);
    Object localObject = null;
    if (paramInt == this.wQm)
    {
      localObject = new h(paramInt);
      ((h)localObject).header = this.Iwg.getActivity().getResources().getString(2131763003);
    }
    for (;;)
    {
      AppMethodBeat.o(34095);
      return localObject;
      if ((paramInt > this.wQm) && (this.iCz.moveToPosition(paramInt - this.wQm - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.al.a.a locala1 = new com.tencent.mm.al.a.a();
        locala1.convertFrom(this.iCz);
        localObject = locala;
        if (locala.nxq == -1L)
        {
          locala.nxq = locala1.field_bizChatId;
          localObject = af.aCY().bd(locala1.field_bizChatId);
          if (((c)localObject).isGroup())
          {
            locala.iCd = ((c)localObject).field_chatName;
            locala.gIf = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (bs.aj(locala.iCd)) {
              locala.iCd = this.Iwg.getActivity().getResources().getString(2131762623);
            }
            localObject = locala;
            if (!bs.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = af.aDa().dP(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.iCd = ((k)localObject).field_userName;
              locala.gIf = ((k)localObject).field_headImageUrl;
              locala.username = ((k)localObject).field_brandUserName;
            }
          }
        }
      }
      else
      {
        ac.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */