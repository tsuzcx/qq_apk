package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.p;

public final class d
  extends p
  implements n.b
{
  private Cursor gqa;
  private String jUE;
  private int qoX;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(30242);
    ab.i("MicroMsg.RecentConversationAdapter", "create!");
    this.jUE = paramString;
    Kg();
    AppMethodBeat.o(30242);
  }
  
  private void Kg()
  {
    AppMethodBeat.i(30243);
    ab.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    this.gqa = z.afl().si(this.jUE);
    this.qoX = 0;
    AppMethodBeat.o(30243);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(30247);
    Kg();
    notifyDataSetChanged();
    AppMethodBeat.o(30247);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(30246);
    super.finish();
    ab.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    AppMethodBeat.o(30246);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(30244);
    int i = this.gqa.getCount();
    AppMethodBeat.o(30244);
    return i + 1;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(30245);
    Object localObject = null;
    if (paramInt == this.qoX)
    {
      localObject = new h(paramInt);
      ((h)localObject).mZq = this.Adk.getActivity().getResources().getString(2131303057);
    }
    for (;;)
    {
      AppMethodBeat.o(30245);
      return localObject;
      if ((paramInt > this.qoX) && (this.gqa.moveToPosition(paramInt - this.qoX - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.aj.a.a locala1 = new com.tencent.mm.aj.a.a();
        locala1.convertFrom(this.gqa);
        localObject = locala;
        if (locala.jUy == -1L)
        {
          locala.jUy = locala1.field_bizChatId;
          localObject = z.afk().aG(locala1.field_bizChatId);
          if (((c)localObject).isGroup())
          {
            locala.gpH = ((c)localObject).field_chatName;
            locala.zsU = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (bo.aa(locala.gpH)) {
              locala.gpH = this.Adk.getActivity().getResources().getString(2131302712);
            }
            localObject = locala;
            if (!bo.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = z.afm().df(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.gpH = ((j)localObject).field_userName;
              locala.zsU = ((j)localObject).field_headImageUrl;
              locala.username = ((j)localObject).field_brandUserName;
            }
          }
        }
      }
      else
      {
        ab.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */