package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private String title;
  private int vNa;
  
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
    return this.title;
  }
  
  protected final o VF()
  {
    return new aa(this, getIntent().getStringExtra("filter_type"));
  }
  
  protected final m VG()
  {
    return null;
  }
  
  public final void jP(int paramInt)
  {
    Object localObject = cHE().HK(paramInt);
    if (localObject == null) {}
    while (((a)localObject).dnp == null) {
      return;
    }
    localObject = ((a)localObject).dnp.field_username;
    y.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { localObject });
    Intent localIntent = new Intent();
    if (s.fA(this.vNa, 16384))
    {
      localIntent.putExtra("Select_Contact", (String)localObject);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (s.fA(this.vNa, 32768))
    {
      localIntent.putExtra("Contact_User", (String)localObject);
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      finish();
      return;
    }
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", (String)localObject);
    localIntent.putExtra("finish_direct", true);
    startActivity(localIntent);
    finish();
  }
  
  protected final void xK()
  {
    super.xK();
    this.title = getIntent().getStringExtra("titile");
    this.vNa = getIntent().getIntExtra("list_attr", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectSpecialContactUI
 * JD-Core Version:    0.7.0.1
 */