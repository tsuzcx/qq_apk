package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class r
  extends s
{
  private List<String> IwA;
  private o.a Iwf;
  private ao handler;
  private Cursor iCz;
  private String nxJ;
  private String query;
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    AppMethodBeat.i(102864);
    this.handler = new ao(Looper.getMainLooper());
    this.IwA = null;
    this.nxJ = paramString;
    ac.i("MicroMsg.MMSearchContactAdapter", "Create!");
    WJ();
    AppMethodBeat.o(102864);
  }
  
  private void WJ()
  {
    AppMethodBeat.i(102866);
    ac.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    clearCache();
    AppMethodBeat.o(102866);
  }
  
  public final void a(o.a parama)
  {
    this.Iwf = parama;
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void cO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102865);
    if (this.Iwf != null) {
      this.Iwf.y(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102865);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102869);
    super.finish();
    ac.i("MicroMsg.MMSearchContactAdapter", "finish!");
    WJ();
    AppMethodBeat.o(102869);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102867);
    if (this.iCz == null)
    {
      AppMethodBeat.o(102867);
      return 0;
    }
    int i = this.iCz.getCount();
    AppMethodBeat.o(102867);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(102868);
    com.tencent.mm.ui.bizchat.a locala = null;
    c localc;
    if ((paramInt >= 0) && (this.iCz.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.convertFrom(this.iCz);
      if (locala.nxq == -1L)
      {
        locala.nxq = localc.field_bizChatLocalId;
        if (!localc.isGroup()) {
          break label155;
        }
        locala.iCd = localc.field_chatName;
        locala.gIf = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (bs.aj(locala.iCd)) {
          locala.iCd = this.Iwg.getActivity().getResources().getString(2131763000);
        }
        if (bs.isNullOrNil(locala.username)) {
          locala.username = localc.field_brandUserName;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102868);
      return locala;
      label155:
      com.tencent.mm.al.a.k localk = ((com.tencent.mm.api.k)g.ab(com.tencent.mm.api.k.class)).dP(localc.field_bizChatServId);
      if (localk == null) {
        break;
      }
      locala.iCd = localk.field_userName;
      locala.gIf = localk.field_headImageUrl;
      locala.username = localk.field_brandUserName;
      break;
      ac.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r
 * JD-Core Version:    0.7.0.1
 */