package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.api.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class p
  extends q
{
  private String bVk;
  private Cursor eYd;
  private ah handler = new ah(Looper.getMainLooper());
  private String idQ;
  private m.a vLH;
  private List<String> vMa = null;
  
  public p(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    this.idQ = paramString;
    y.i("MicroMsg.MMSearchContactAdapter", "Create!");
    xK();
  }
  
  private void xK()
  {
    y.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.bVk = null;
    clearCache();
  }
  
  public final void a(m.a parama)
  {
    this.vLH = parama;
  }
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    if (this.vLH != null) {
      this.vLH.t(paramString, getCount(), paramBoolean);
    }
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void finish()
  {
    super.finish();
    y.i("MicroMsg.MMSearchContactAdapter", "finish!");
    xK();
  }
  
  public final int getCount()
  {
    if (this.eYd == null) {
      return 0;
    }
    return this.eYd.getCount();
  }
  
  protected final com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    if ((paramInt >= 0) && (this.eYd.moveToPosition(paramInt)))
    {
      com.tencent.mm.ui.bizchat.a locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      c localc = new c();
      localc.d(this.eYd);
      if (locala.idK == -1L)
      {
        locala.idK = localc.field_bizChatLocalId;
        if (!localc.isGroup()) {
          break label144;
        }
        locala.eXK = localc.field_chatName;
        locala.vev = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
      }
      for (;;)
      {
        if (bk.L(locala.eXK)) {
          locala.eXK = this.vLI.getActivity().getResources().getString(a.h.select_contact_room_head_name);
        }
        if (bk.bl(locala.username)) {
          locala.username = localc.field_brandUserName;
        }
        return locala;
        label144:
        j localj = ((h)g.r(h.class)).bY(localc.field_bizChatServId);
        if (localj != null)
        {
          locala.eXK = localj.field_userName;
          locala.vev = localj.field_headImageUrl;
          locala.username = localj.field_brandUserName;
        }
      }
    }
    y.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.p
 * JD-Core Version:    0.7.0.1
 */