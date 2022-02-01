package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class b
  extends s
{
  private String chatroomName;
  private Cursor icq;
  private String[] icr;
  private String query;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(114711);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.ab(c.class)).apV().tL(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.icr = bt.gK(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(114711);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114712);
    ad.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    if ((!bt.isNullOrNil(this.query)) && (this.icr != null)) {
      this.icq = ((k)g.ab(k.class)).apM().a(this.icr, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cI(paramString, true);
    AppMethodBeat.o(114712);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(114714);
    super.finish();
    if (this.icq != null)
    {
      this.icq.close();
      this.icq = null;
    }
    AppMethodBeat.o(114714);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114715);
    if (this.icq == null)
    {
      AppMethodBeat.o(114715);
      return 0;
    }
    int i = this.icq.getCount();
    AppMethodBeat.o(114715);
    return i;
  }
  
  public final a pU(int paramInt)
  {
    AppMethodBeat.i(114713);
    e locale = null;
    if (this.icq.moveToPosition(paramInt))
    {
      af localaf = new af();
      localaf.convertFrom(this.icq);
      locale = new e(paramInt);
      locale.contact = localaf;
      locale.GVT = dqZ();
      locale.query = this.query;
    }
    AppMethodBeat.o(114713);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.b
 * JD-Core Version:    0.7.0.1
 */