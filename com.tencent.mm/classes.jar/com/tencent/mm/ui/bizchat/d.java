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
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.q;

public final class d
  extends q
  implements n.b
{
  private Cursor iYC;
  private String oeQ;
  private int ytL;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(34092);
    ae.i("MicroMsg.RecentConversationAdapter", "create!");
    this.oeQ = paramString;
    Zq();
    AppMethodBeat.o(34092);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(34093);
    ae.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    this.iYC = ag.aGs().EN(this.oeQ);
    this.ytL = 0;
    AppMethodBeat.o(34093);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(34097);
    Zq();
    notifyDataSetChanged();
    AppMethodBeat.o(34097);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(34096);
    super.finish();
    ae.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    AppMethodBeat.o(34096);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34094);
    int i = this.iYC.getCount();
    AppMethodBeat.o(34094);
    return i + 1;
  }
  
  public final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(34095);
    Object localObject = null;
    if (paramInt == this.ytL)
    {
      localObject = new h(paramInt);
      ((h)localObject).header = this.KJi.getActivity().getResources().getString(2131763003);
    }
    for (;;)
    {
      AppMethodBeat.o(34095);
      return localObject;
      if ((paramInt > this.ytL) && (this.iYC.moveToPosition(paramInt - this.ytL - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.al.a.a locala1 = new com.tencent.mm.al.a.a();
        locala1.convertFrom(this.iYC);
        localObject = locala;
        if (locala.oex == -1L)
        {
          locala.oex = locala1.field_bizChatId;
          localObject = ag.aGr().bd(locala1.field_bizChatId);
          if (((c)localObject).isGroup())
          {
            locala.iYg = ((c)localObject).field_chatName;
            locala.heD = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (bu.ah(locala.iYg)) {
              locala.iYg = this.KJi.getActivity().getResources().getString(2131762623);
            }
            localObject = locala;
            if (!bu.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = ag.aGt().eP(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.iYg = ((k)localObject).field_userName;
              locala.heD = ((k)localObject).field_headImageUrl;
              locala.username = ((k)localObject).field_brandUserName;
            }
          }
        }
      }
      else
      {
        ae.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */