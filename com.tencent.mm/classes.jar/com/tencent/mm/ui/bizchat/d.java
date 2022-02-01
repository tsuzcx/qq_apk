package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.a.c;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.ag;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;

public final class d
  extends q
  implements n.b
{
  private Cursor iVJ;
  private String nZh;
  private int ydU;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(34092);
    ad.i("MicroMsg.RecentConversationAdapter", "create!");
    this.nZh = paramString;
    Zh();
    AppMethodBeat.o(34092);
  }
  
  public final void Zh()
  {
    AppMethodBeat.i(34093);
    ad.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    this.iVJ = ag.aGc().El(this.nZh);
    this.ydU = 0;
    AppMethodBeat.o(34093);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(34097);
    Zh();
    notifyDataSetChanged();
    AppMethodBeat.o(34097);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(34096);
    super.finish();
    ad.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    AppMethodBeat.o(34096);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34094);
    int i = this.iVJ.getCount();
    AppMethodBeat.o(34094);
    return i + 1;
  }
  
  public final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(34095);
    Object localObject = null;
    if (paramInt == this.ydU)
    {
      localObject = new h(paramInt);
      ((h)localObject).header = this.KmO.getActivity().getResources().getString(2131763003);
    }
    for (;;)
    {
      AppMethodBeat.o(34095);
      return localObject;
      if ((paramInt > this.ydU) && (this.iVJ.moveToPosition(paramInt - this.ydU - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.am.a.a locala1 = new com.tencent.mm.am.a.a();
        locala1.convertFrom(this.iVJ);
        localObject = locala;
        if (locala.nYO == -1L)
        {
          locala.nYO = locala1.field_bizChatId;
          localObject = ag.aGb().bd(locala1.field_bizChatId);
          if (((c)localObject).isGroup())
          {
            locala.iVn = ((c)localObject).field_chatName;
            locala.hbP = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (bt.ai(locala.iVn)) {
              locala.iVn = this.KmO.getActivity().getResources().getString(2131762623);
            }
            localObject = locala;
            if (!bt.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = ag.aGd().eK(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.iVn = ((k)localObject).field_userName;
              locala.hbP = ((k)localObject).field_headImageUrl;
              locala.username = ((k)localObject).field_brandUserName;
            }
          }
        }
      }
      else
      {
        ad.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */