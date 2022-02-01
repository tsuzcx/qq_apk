package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.c;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.api.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class s
  extends u
{
  private p.a XsV;
  private List<String> Xtt;
  private MMHandler handler;
  private Cursor mNt;
  private String query;
  private String syN;
  
  public s(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, false, 0);
    AppMethodBeat.i(102864);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Xtt = null;
    this.syN = paramString;
    Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
    ata();
    AppMethodBeat.o(102864);
  }
  
  private void ata()
  {
    AppMethodBeat.i(102866);
    Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
    this.query = null;
    clearCache();
    AppMethodBeat.o(102866);
  }
  
  public final void a(p.a parama)
  {
    this.XsV = parama;
  }
  
  protected final boolean c(com.tencent.mm.ui.contact.a.a parama)
  {
    return true;
  }
  
  public final void dE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102865);
    if (this.XsV != null) {
      this.XsV.g(paramString, getCount(), paramBoolean);
    }
    AppMethodBeat.o(102865);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(102869);
    super.finish();
    Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
    ata();
    AppMethodBeat.o(102869);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(102867);
    if (this.mNt == null)
    {
      AppMethodBeat.o(102867);
      return 0;
    }
    int i = this.mNt.getCount();
    AppMethodBeat.o(102867);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(102868);
    com.tencent.mm.ui.bizchat.a locala = null;
    c localc;
    if ((paramInt >= 0) && (this.mNt.moveToPosition(paramInt)))
    {
      locala = new com.tencent.mm.ui.bizchat.a(paramInt);
      localc = new c();
      localc.convertFrom(this.mNt);
      if (locala.syu == -1L)
      {
        locala.syu = localc.field_bizChatLocalId;
        if (!localc.bjM()) {
          break label156;
        }
        locala.mMY = localc.field_chatName;
        locala.kLW = localc.field_headImageUrl;
        locala.username = localc.field_brandUserName;
        if (Util.isNullOrNil(locala.mMY)) {
          locala.mMY = this.XsW.getActivity().getResources().getString(a.h.select_contact_room_head_name);
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
      k localk = ((l)h.ae(l.class)).gm(localc.field_bizChatServId);
      if (localk == null) {
        break;
      }
      locala.mMY = localk.field_userName;
      locala.kLW = localk.field_headImageUrl;
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