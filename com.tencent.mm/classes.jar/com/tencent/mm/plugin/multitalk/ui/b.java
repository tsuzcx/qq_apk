package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;

public final class b
  extends r
{
  private String chatroomName;
  private String[] gpZ;
  private Cursor gqa;
  private String query;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(54177);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.E(c.class)).YJ().oY(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.gpZ = bo.er(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(54177);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean)
  {
    AppMethodBeat.i(54178);
    ab.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    if ((!bo.isNullOrNil(this.query)) && (this.gpZ != null)) {
      this.gqa = ((j)g.E(j.class)).YA().a(this.gpZ, "@all.chatroom", this.query, null, null);
    }
    notifyDataSetChanged();
    cp(paramString, true);
    AppMethodBeat.o(54178);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(54180);
    super.finish();
    if (this.gqa != null)
    {
      this.gqa.close();
      this.gqa = null;
    }
    AppMethodBeat.o(54180);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(54181);
    if (this.gqa == null)
    {
      AppMethodBeat.o(54181);
      return 0;
    }
    int i = this.gqa.getCount();
    AppMethodBeat.o(54181);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(54179);
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = null;
    if (this.gqa.moveToPosition(paramInt))
    {
      ad localad = new ad();
      localad.convertFrom(this.gqa);
      locala = new com.tencent.mm.plugin.multitalk.ui.widget.a(paramInt);
      locala.contact = localad;
      locala.Adl = cni();
      locala.query = this.query;
    }
    AppMethodBeat.o(54179);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.b
 * JD-Core Version:    0.7.0.1
 */