package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.b;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;

public final class d
  extends o
  implements m.b
{
  private Cursor eYd;
  private String idQ;
  private int nCS;
  
  public d(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, false);
    y.i("MicroMsg.RecentConversationAdapter", "create!");
    this.idQ = paramString;
    xO();
  }
  
  private void xO()
  {
    y.i("MicroMsg.RecentConversationAdapter", "resetData");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
    this.eYd = z.MB().ln(this.idQ);
    this.nCS = 0;
  }
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    xO();
    notifyDataSetChanged();
  }
  
  public final void finish()
  {
    super.finish();
    y.i("MicroMsg.RecentConversationAdapter", "finish!");
    if (this.eYd != null)
    {
      this.eYd.close();
      this.eYd = null;
    }
  }
  
  public final int getCount()
  {
    return this.eYd.getCount() + 1;
  }
  
  protected final com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    if (paramInt == this.nCS)
    {
      localObject = new g(paramInt);
      ((g)localObject).kDu = this.vLI.getActivity().getResources().getString(R.l.select_conversation_cur);
    }
    a locala;
    com.tencent.mm.ai.a.a locala1;
    do
    {
      return localObject;
      if ((paramInt <= this.nCS) || (!this.eYd.moveToPosition(paramInt - this.nCS - 1))) {
        break;
      }
      locala = new a(paramInt);
      locala1 = new com.tencent.mm.ai.a.a();
      locala1.d(this.eYd);
      localObject = locala;
    } while (locala.idK != -1L);
    locala.idK = locala1.field_bizChatId;
    Object localObject = z.MA().aj(locala1.field_bizChatId);
    if (((c)localObject).isGroup())
    {
      locala.eXK = ((c)localObject).field_chatName;
      locala.vev = ((c)localObject).field_headImageUrl;
      locala.username = ((c)localObject).field_brandUserName;
    }
    for (;;)
    {
      if (bk.L(locala.eXK)) {
        locala.eXK = this.vLI.getActivity().getResources().getString(R.l.room_head_name);
      }
      localObject = locala;
      if (!bk.bl(locala.username)) {
        break;
      }
      locala.username = locala1.field_brandUserName;
      return locala;
      localObject = z.MC().bY(((c)localObject).field_bizChatServId);
      if (localObject != null)
      {
        locala.eXK = ((j)localObject).field_userName;
        locala.vev = ((j)localObject).field_headImageUrl;
        locala.username = ((j)localObject).field_brandUserName;
      }
    }
    y.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.d
 * JD-Core Version:    0.7.0.1
 */