package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI
  extends MMBaseSelectContactUI
{
  private List<String> dru;
  private HashSet<String> eXT;
  
  private void xU()
  {
    String str;
    if (this.eXT.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(R.l.app_ok) });
      updateOptionMenuText(1, str);
      if (this.eXT.size() < 0) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(R.l.app_ok), Integer.valueOf(this.eXT.size()), Integer.valueOf(ab.unw) });
      break;
    }
  }
  
  protected final void Ha(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.eXT);
    localIntent.putExtra("always_select_contact", bk.c(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", s.v(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return true;
  }
  
  protected final String VE()
  {
    return bk.aM(getIntent().getStringExtra("Add_address_titile"), "");
  }
  
  protected final o VF()
  {
    c.a locala = new c.a();
    locala.vJK = true;
    locala.vJR = true;
    locala.vJT = getString(R.l.address_near_contact_catalog_name);
    locala.vJS = bk.aM(getIntent().getStringExtra("Add_get_from_sns"), "");
    locala.vIs = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    return new c(this, this.dru, true, locala);
  }
  
  protected final m VG()
  {
    return new q(this, this.dru, true, this.scene);
  }
  
  public final boolean a(a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final int[] bgw()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean bhB()
  {
    return true;
  }
  
  public final void jP(int paramInt)
  {
    n localn = cHE();
    Object localObject = localn.HK(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null) {}
    while (((a)localObject).dnp == null) {
      return;
    }
    y.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { ((a)localObject).dnp.field_username });
    localObject = ((a)localObject).dnp.field_username;
    cHK();
    if (this.eXT.contains(localObject))
    {
      this.eXT.remove(localObject);
      this.mbR.Wv((String)localObject);
    }
    for (;;)
    {
      xU();
      localn.notifyDataSetChanged();
      return;
      if (this.eXT.size() < ab.unw)
      {
        this.eXT.add(localObject);
        this.mbR.Wv((String)localObject);
      }
      else
      {
        Toast.makeText(this, R.l.sns_max_select_at, 0).show();
        y.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(ab.unw) });
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (bk.bl(paramIntent))
    {
      y.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
      return;
    }
    y.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
    paramIntent = paramIntent.split(",");
    paramInt2 = paramIntent.length;
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      Object localObject = paramIntent[paramInt1];
      if (this.eXT.add(localObject)) {
        this.mbR.Wv(localObject);
      }
      paramInt1 += 1;
    }
    xU();
    cHE().notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.SnsAddressUI", "Create!");
    a(1, getString(R.l.app_ok), new SnsAddressUI.1(this), s.b.uNx);
    setBackBtn(new SnsAddressUI.2(this));
    paramBundle = this.eXT.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.mbR.Wv(str);
    }
    this.mbR.setOnContactDeselectListener(new SnsAddressUI.3(this));
    xU();
  }
  
  public final void pw(String paramString)
  {
    this.eXT.remove(paramString);
    cHE().notifyDataSetChanged();
    xU();
  }
  
  protected final void xK()
  {
    super.xK();
    this.dru = new ArrayList();
    Object localObject = bk.G(bk.aM(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = s.cHO();
    localHashSet.addAll((Collection)localObject);
    this.dru.addAll(localHashSet);
    this.dru.addAll(s.cHP());
    this.eXT = new HashSet();
    localObject = bk.aM(getIntent().getStringExtra("Select_Contact"), "");
    if (!bk.bl((String)localObject)) {
      this.eXT.addAll(bk.G(((String)localObject).split(",")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI
 * JD-Core Version:    0.7.0.1
 */