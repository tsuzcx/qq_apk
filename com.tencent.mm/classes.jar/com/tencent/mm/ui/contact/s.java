package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.a.c;
import com.tencent.mm.an.a.k;
import com.tencent.mm.api.m;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class s
  extends u
{
  private List<String> afeX;
  private p.a afew;
  private MMHandler handler;
  private Cursor pKb;
  private String query;
  private String vEu;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    AppMethodBeat.i(102864);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.afeX = null;
    this.vEu = paramString;
    Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
    aNi();
    AppMethodBeat.o(102864);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(102866);
    Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    clearCache();
    AppMethodBeat.o(102866);
  }
  
  public final void a(p.a parama)
  {
    this.afew = parama;
  }
  
  protected final boolean d(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void eo(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102865);
    if (this.afew != null) {
      this.afew.h(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102865);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102869);
    super.finish();
    Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
    aNi();
    AppMethodBeat.o(102869);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102867);
    if (this.pKb == null)
    {
      AppMethodBeat.o(102867);
      return 0;
    }
    int i = this.pKb.getCount();
    AppMethodBeat.o(102867);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(102868);
    com.tencent.mm.ui.bizchat.a locala = null;
    c localc;
    if ((paramInt >= 0) && (this.pKb.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.convertFrom(this.pKb);
      if (locala.vEb == -1L)
      {
        locala.vEb = localc.field_bizChatLocalId;
        if (!localc.bHx()) {
          break label156;
        }
        locala.pJG = localc.field_chatName;
        locala.nnS = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (Util.isNullOrNil(locala.pJG)) {
          locala.pJG = this.afex.getActivity().getResources().getString(a.h.select_contact_room_head_name);
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
      label156:
      k localk = ((m)h.ax(m.class)).hM(localc.field_bizChatServId);
      if (localk == null) {
        break;
      }
      locala.pJG = localk.field_userName;
      locala.nnS = localk.field_headImageUrl;
      locala.username = localk.field_brandUserName;
      break;
      Log.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.s
 * JD-Core Version:    0.7.0.1
 */