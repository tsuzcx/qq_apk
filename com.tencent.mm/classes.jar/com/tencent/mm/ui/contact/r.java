package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class r
  extends s
{
  private o.a KmN;
  private List<String> Kni;
  private ap handler;
  private Cursor iVJ;
  private String nZh;
  private String query;
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    AppMethodBeat.i(102864);
    this.handler = new ap(Looper.getMainLooper());
    this.Kni = null;
    this.nZh = paramString;
    ad.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Zd();
    AppMethodBeat.o(102864);
  }
  
  private void Zd()
  {
    AppMethodBeat.i(102866);
    ad.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    clearCache();
    AppMethodBeat.o(102866);
  }
  
  public final void a(o.a parama)
  {
    this.KmN = parama;
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void cT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102865);
    if (this.KmN != null) {
      this.KmN.y(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102865);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102869);
    super.finish();
    ad.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Zd();
    AppMethodBeat.o(102869);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102867);
    if (this.iVJ == null)
    {
      AppMethodBeat.o(102867);
      return 0;
    }
    int i = this.iVJ.getCount();
    AppMethodBeat.o(102867);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(102868);
    com.tencent.mm.ui.bizchat.a locala = null;
    c localc;
    if ((paramInt >= 0) && (this.iVJ.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.convertFrom(this.iVJ);
      if (locala.nYO == -1L)
      {
        locala.nYO = localc.field_bizChatLocalId;
        if (!localc.isGroup()) {
          break label155;
        }
        locala.iVn = localc.field_chatName;
        locala.hbP = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (bt.ai(locala.iVn)) {
          locala.iVn = this.KmO.getActivity().getResources().getString(2131763000);
        }
        if (bt.isNullOrNil(locala.username)) {
          locala.username = localc.field_brandUserName;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102868);
      return locala;
      label155:
      com.tencent.mm.am.a.k localk = ((com.tencent.mm.api.k)g.ab(com.tencent.mm.api.k.class)).eK(localc.field_bizChatServId);
      if (localk == null) {
        break;
      }
      locala.iVn = localk.field_userName;
      locala.hbP = localk.field_headImageUrl;
      locala.username = localk.field_brandUserName;
      break;
      ad.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r
 * JD-Core Version:    0.7.0.1
 */