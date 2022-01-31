package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s.b;
import java.util.HashSet;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> eXT;
  private String label;
  private HashSet<String> vMY;
  private int vNa;
  
  private void adV(String paramString)
  {
    if (s.fA(this.vNa, 16384))
    {
      localIntent = new Intent();
      localIntent.putExtra("Select_Contact", paramString);
      setResult(-1, localIntent);
      finish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    startActivity(localIntent);
    finish();
  }
  
  private void xU()
  {
    if ((s.fA(this.vNa, 64)) && (this.eXT.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + this.eXT.size() + ")");
      enableOptionMenu(1, true);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_ok));
    enableOptionMenu(1, false);
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    return this.label;
  }
  
  protected final o VF()
  {
    String str = com.tencent.mm.plugin.label.a.a.bdA().Gl(this.label);
    return new h(this, s.fA(this.vNa, 64), com.tencent.mm.plugin.label.a.a.bdA().Go(str));
  }
  
  protected final m VG()
  {
    return null;
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.eXT.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.vMY.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final void jP(int paramInt)
  {
    int i = getContentLV().getHeaderViewsCount();
    n localn = cHE();
    Object localObject = localn.HK(paramInt - i);
    if (localObject == null) {}
    while (((com.tencent.mm.ui.contact.a.a)localObject).dnp == null) {
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).dnp.field_username;
    y.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { localObject });
    if (s.fA(this.vNa, 64))
    {
      if ((!this.vMY.contains(localObject)) && (!this.eXT.contains(localObject)) && (s.fA(this.vNa, 131072)) && (this.vMY.size() + this.eXT.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(R.l.select_contact_num_limit_tips, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), getString(R.l.app_remind), new SelectLabelContactUI.2(this));
        return;
      }
      if (!this.vMY.contains(localObject))
      {
        if (!this.eXT.contains(localObject)) {
          break label237;
        }
        this.eXT.remove(localObject);
      }
      for (;;)
      {
        xU();
        localn.notifyDataSetChanged();
        return;
        label237:
        this.eXT.add(localObject);
      }
    }
    adV((String)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (s.fA(this.vNa, 64)) {
      a(1, getString(R.l.app_ok), new SelectLabelContactUI.1(this), s.b.uNx);
    }
    xU();
  }
  
  protected final void xK()
  {
    super.xK();
    this.label = getIntent().getStringExtra("label");
    this.vNa = getIntent().getIntExtra("list_attr", 0);
    this.eXT = new HashSet();
    this.vMY = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bk.bl(str)) {
      this.vMY.addAll(bk.G(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bk.bl(str)) {
      this.eXT.addAll(bk.G(str.split(",")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI
 * JD-Core Version:    0.7.0.1
 */