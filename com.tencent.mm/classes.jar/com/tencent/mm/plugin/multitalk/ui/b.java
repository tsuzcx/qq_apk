package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class b
  extends s
{
  private String chatroomName;
  private Cursor jWh;
  private String[] jWi;
  private String query;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(114711);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.af(c.class)).aSX().Kh(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.jWi = Util.listToStrings(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(114711);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114712);
    Log.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.jWi != null)) {
      this.jWh = ((l)g.af(l.class)).aSN().a(this.jWi, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    ds(paramString, true);
    AppMethodBeat.o(114712);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(114714);
    super.finish();
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    AppMethodBeat.o(114714);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114715);
    if (this.jWh == null)
    {
      AppMethodBeat.o(114715);
      return 0;
    }
    int i = this.jWh.getCount();
    AppMethodBeat.o(114715);
    return i;
  }
  
  public final a va(int paramInt)
  {
    AppMethodBeat.i(114713);
    e locale = null;
    if (this.jWh.moveToPosition(paramInt))
    {
      as localas = new as();
      localas.convertFrom(this.jWh);
      locale = new e(paramInt);
      locale.contact = localas;
      locale.PWh = eWh();
      locale.query = this.query;
    }
    AppMethodBeat.o(114713);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.b
 * JD-Core Version:    0.7.0.1
 */