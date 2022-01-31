package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.api.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class q
  extends r
{
  private List<String> AdC;
  private n.a Adj;
  private Cursor gqa;
  private ak handler;
  private String jUE;
  private String query;
  
  public q(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    AppMethodBeat.i(105225);
    this.handler = new ak(Looper.getMainLooper());
    this.AdC = null;
    this.jUE = paramString;
    ab.i("MicroMsg.MMSearchContactAdapter", "Create!");
    Kc();
    AppMethodBeat.o(105225);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(105227);
    ab.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    clearCache();
    AppMethodBeat.o(105227);
  }
  
  public final void a(n.a parama)
  {
    this.Adj = parama;
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105226);
    if (this.Adj != null) {
      this.Adj.w(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(105226);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(105230);
    super.finish();
    ab.i("MicroMsg.MMSearchContactAdapter", "finish!");
    Kc();
    AppMethodBeat.o(105230);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(105228);
    if (this.gqa == null)
    {
      AppMethodBeat.o(105228);
      return 0;
    }
    int i = this.gqa.getCount();
    AppMethodBeat.o(105228);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(105229);
    com.tencent.mm.ui.bizchat.a locala = null;
    c localc;
    if ((paramInt >= 0) && (this.gqa.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.convertFrom(this.gqa);
      if (locala.jUy == -1L)
      {
        locala.jUy = localc.field_bizChatLocalId;
        if (!localc.isGroup()) {
          break label155;
        }
        locala.gpH = localc.field_chatName;
        locala.zsU = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (bo.aa(locala.gpH)) {
          locala.gpH = this.Adk.getActivity().getResources().getString(2131303054);
        }
        if (bo.isNullOrNil(locala.username)) {
          locala.username = localc.field_brandUserName;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(105229);
      return locala;
      label155:
      j localj = ((i)g.E(i.class)).df(localc.field_bizChatServId);
      if (localj == null) {
        break;
      }
      locala.gpH = localj.field_userName;
      locala.zsU = localj.field_headImageUrl;
      locala.username = localj.field_brandUserName;
      break;
      ab.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.q
 * JD-Core Version:    0.7.0.1
 */