package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.a.c;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.af;
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
  private Cursor icq;
  private String mVj;
  private int vGh;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    AppMethodBeat.i(34092);
    ad.i("MicroMsg.RecentConversationAdapter", "create!");
    this.mVj = paramString;
    VP();
    AppMethodBeat.o(34092);
  }
  
  public final void VP()
  {
    AppMethodBeat.i(34093);
    ad.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    this.icq = af.awh().xg(this.mVj);
    this.vGh = 0;
    AppMethodBeat.o(34093);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(34097);
    VP();
    notifyDataSetChanged();
    AppMethodBeat.o(34097);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(34096);
    super.finish();
    ad.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    AppMethodBeat.o(34096);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34094);
    int i = this.icq.getCount();
    AppMethodBeat.o(34094);
    return i + 1;
  }
  
  public final com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(34095);
    Object localObject = null;
    if (paramInt == this.vGh)
    {
      localObject = new h(paramInt);
      ((h)localObject).header = this.GVS.getActivity().getResources().getString(2131763003);
    }
    for (;;)
    {
      AppMethodBeat.o(34095);
      return localObject;
      if ((paramInt > this.vGh) && (this.icq.moveToPosition(paramInt - this.vGh - 1)))
      {
        a locala = new a(paramInt);
        com.tencent.mm.am.a.a locala1 = new com.tencent.mm.am.a.a();
        locala1.convertFrom(this.icq);
        localObject = locala;
        if (locala.mUQ == -1L)
        {
          locala.mUQ = locala1.field_bizChatId;
          localObject = af.awg().bg(locala1.field_bizChatId);
          if (((c)localObject).isGroup())
          {
            locala.ibW = ((c)localObject).field_chatName;
            locala.GgK = ((c)localObject).field_headImageUrl;
            locala.username = ((c)localObject).field_brandUserName;
          }
          for (;;)
          {
            if (bt.ai(locala.ibW)) {
              locala.ibW = this.GVS.getActivity().getResources().getString(2131762623);
            }
            localObject = locala;
            if (!bt.isNullOrNil(locala.username)) {
              break;
            }
            locala.username = locala1.field_brandUserName;
            localObject = locala;
            break;
            localObject = af.awi().ea(((c)localObject).field_bizChatServId);
            if (localObject != null)
            {
              locala.ibW = ((k)localObject).field_userName;
              locala.GgK = ((k)localObject).field_headImageUrl;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */