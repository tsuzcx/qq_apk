package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.k;
import com.tencent.mm.api.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class r
  extends s
{
  private List<String> PWD;
  private o.a PWf;
  private MMHandler handler;
  private Cursor jWh;
  private String ppO;
  private String query;
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    AppMethodBeat.i(102864);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.PWD = null;
    this.ppO = paramString;
    Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
    amZ();
    AppMethodBeat.o(102864);
  }
  
  private void amZ()
  {
    AppMethodBeat.i(102866);
    Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    clearCache();
    AppMethodBeat.o(102866);
  }
  
  public final void a(o.a parama)
  {
    this.PWf = parama;
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void ds(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102865);
    if (this.PWf != null) {
      this.PWf.B(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102865);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102869);
    super.finish();
    Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
    amZ();
    AppMethodBeat.o(102869);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102867);
    if (this.jWh == null)
    {
      AppMethodBeat.o(102867);
      return 0;
    }
    int i = this.jWh.getCount();
    AppMethodBeat.o(102867);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(102868);
    com.tencent.mm.ui.bizchat.a locala = null;
    c localc;
    if ((paramInt >= 0) && (this.jWh.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.convertFrom(this.jWh);
      if (locala.ppv == -1L)
      {
        locala.ppv = localc.field_bizChatLocalId;
        if (!localc.isGroup()) {
          break label155;
        }
        locala.jVL = localc.field_chatName;
        locala.hXq = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (Util.isNullOrNil(locala.jVL)) {
          locala.jVL = this.PWg.getActivity().getResources().getString(2131765137);
        }
        if (Util.isNullOrNil(locala.username)) {
          locala.username = localc.field_brandUserName;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(102868);
      return locala;
      label155:
      k localk = ((l)g.af(l.class)).fB(localc.field_bizChatServId);
      if (localk == null) {
        break;
      }
      locala.jVL = localk.field_userName;
      locala.hXq = localk.field_headImageUrl;
      locala.username = localk.field_brandUserName;
      break;
      Log.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.r
 * JD-Core Version:    0.7.0.1
 */