package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI
  extends MMBaseSelectContactUI
{
  private List<String> ejc;
  private HashSet<String> gpQ;
  
  private void Km()
  {
    AppMethodBeat.i(33932);
    String str;
    if (this.gpQ.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(2131297018) });
      updateOptionMenuText(1, str);
      if (this.gpQ.size() < 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      AppMethodBeat.o(33932);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(2131297018), Integer.valueOf(this.gpQ.size()), Integer.valueOf(com.tencent.mm.storage.ab.yxn) });
      break;
    }
  }
  
  protected final void Kc()
  {
    AppMethodBeat.i(33926);
    super.Kc();
    this.ejc = new ArrayList();
    Object localObject = bo.P(bo.bf(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = t.dMg();
    localHashSet.addAll((Collection)localObject);
    this.ejc.addAll(localHashSet);
    this.ejc.addAll(t.dMh());
    this.gpQ = new HashSet();
    localObject = bo.bf(getIntent().getStringExtra("Select_Contact"), "");
    if (!bo.isNullOrNil((String)localObject)) {
      this.gpQ.addAll(bo.P(((String)localObject).split(",")));
    }
    AppMethodBeat.o(33926);
  }
  
  protected final void SL(String paramString)
  {
    AppMethodBeat.i(33934);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.gpQ);
    localIntent.putExtra("always_select_contact", bo.d(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", t.F(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(33934);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(33935);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(33935);
      return bool;
    }
    AppMethodBeat.o(33935);
    return false;
  }
  
  protected final boolean apa()
  {
    return false;
  }
  
  protected final boolean apb()
  {
    return true;
  }
  
  protected final String apc()
  {
    AppMethodBeat.i(33929);
    String str = bo.bf(getIntent().getStringExtra("Add_address_titile"), "");
    AppMethodBeat.o(33929);
    return str;
  }
  
  protected final p apd()
  {
    AppMethodBeat.i(33930);
    Object localObject = new c.a();
    ((c.a)localObject).Abg = true;
    ((c.a)localObject).Abn = true;
    ((c.a)localObject).Abp = getString(2131296485);
    ((c.a)localObject).Abo = bo.bf(getIntent().getStringExtra("Add_get_from_sns"), "");
    ((c.a)localObject).zZK = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.ejc, true, (c.a)localObject);
    AppMethodBeat.o(33930);
    return localObject;
  }
  
  protected final n ape()
  {
    AppMethodBeat.i(33931);
    r localr = new r(this, this.ejc, true, this.scene);
    AppMethodBeat.o(33931);
    return localr;
  }
  
  public final int[] bOp()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean bPC()
  {
    return true;
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(33928);
    o localo = dLW();
    Object localObject = localo.Qt(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(33928);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(33928);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    dMc();
    if (this.gpQ.contains(localObject))
    {
      this.gpQ.remove(localObject);
      this.oCs.ama((String)localObject);
    }
    for (;;)
    {
      Km();
      localo.notifyDataSetChanged();
      AppMethodBeat.o(33928);
      return;
      if (this.gpQ.size() < com.tencent.mm.storage.ab.yxn)
      {
        this.gpQ.add(localObject);
        this.oCs.ama((String)localObject);
      }
      else
      {
        Toast.makeText(this, 2131303899, 0).show();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(com.tencent.mm.storage.ab.yxn) });
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(33933);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(33933);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33933);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bo.isNullOrNil(paramIntent))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(33933);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.gpQ.add(localObject)) {
          this.oCs.ama(localObject);
        }
        paramInt1 += 1;
      }
      Km();
      dLW().notifyDataSetChanged();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33927);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SnsAddressUI", "Create!");
    addTextOptionMenu(1, getString(2131297018), new SnsAddressUI.1(this), null, q.b.zby);
    setBackBtn(new SnsAddressUI.2(this));
    paramBundle = this.gpQ.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.oCs.ama(str);
    }
    this.oCs.setOnContactDeselectListener(new SnsAddressUI.3(this));
    Km();
    AppMethodBeat.o(33927);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(33936);
    this.gpQ.remove(paramString);
    dLW().notifyDataSetChanged();
    Km();
    AppMethodBeat.o(33936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI
 * JD-Core Version:    0.7.0.1
 */