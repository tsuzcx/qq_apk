package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class r
  extends s
{
  private List<String> KJC;
  private o.a KJh;
  private aq handler;
  private Cursor iYC;
  private String oeQ;
  private String query;
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    AppMethodBeat.i(102864);
    this.handler = new aq(Looper.getMainLooper());
    this.KJC = null;
    this.oeQ = paramString;
    ae.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Zm();
    AppMethodBeat.o(102864);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(102866);
    ae.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    clearCache();
    AppMethodBeat.o(102866);
  }
  
  public final void a(o.a parama)
  {
    this.KJh = parama;
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void cX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102865);
    if (this.KJh != null) {
      this.KJh.y(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102865);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102869);
    super.finish();
    ae.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Zm();
    AppMethodBeat.o(102869);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102867);
    if (this.iYC == null)
    {
      AppMethodBeat.o(102867);
      return 0;
    }
    int i = this.iYC.getCount();
    AppMethodBeat.o(102867);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(102868);
    com.tencent.mm.ui.bizchat.a locala = null;
    c localc;
    if ((paramInt >= 0) && (this.iYC.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.convertFrom(this.iYC);
      if (locala.oex == -1L)
      {
        locala.oex = localc.field_bizChatLocalId;
        if (!localc.isGroup()) {
          break label155;
        }
        locala.iYg = localc.field_chatName;
        locala.heD = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (bu.ah(locala.iYg)) {
          locala.iYg = this.KJi.getActivity().getResources().getString(2131763000);
        }
        if (bu.isNullOrNil(locala.username)) {
          locala.username = localc.field_brandUserName;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102868);
      return locala;
      label155:
      com.tencent.mm.al.a.k localk = ((com.tencent.mm.api.k)g.ab(com.tencent.mm.api.k.class)).eP(localc.field_bizChatServId);
      if (localk == null) {
        break;
      }
      locala.iYg = localk.field_userName;
      locala.heD = localk.field_headImageUrl;
      locala.username = localk.field_brandUserName;
      break;
      ae.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r
 * JD-Core Version:    0.7.0.1
 */