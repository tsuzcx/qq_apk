package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.ChattingUI;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private int GXV;
  private String title;
  
  protected final void VL()
  {
    AppMethodBeat.i(38040);
    super.VL();
    this.title = getIntent().getStringExtra("titile");
    this.GXV = getIntent().getIntExtra("list_attr", 0);
    AppMethodBeat.o(38040);
  }
  
  protected final boolean aHt()
  {
    return false;
  }
  
  protected final boolean aHu()
  {
    return false;
  }
  
  protected final String aHv()
  {
    return this.title;
  }
  
  protected final q aHw()
  {
    AppMethodBeat.i(38042);
    ae localae = new ae(this, getIntent().getStringExtra("filter_type"));
    AppMethodBeat.o(38042);
    return localae;
  }
  
  protected final o aHx()
  {
    return null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(38041);
    Object localObject = fbz().ZC(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(38041);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(38041);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    ad.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { localObject });
    Intent localIntent = new Intent();
    if (u.hasAttr(this.GXV, 16384))
    {
      localIntent.putExtra("Select_Contact", (String)localObject);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(38041);
      return;
    }
    if (u.hasAttr(this.GXV, 32768))
    {
      localIntent.putExtra("Contact_User", (String)localObject);
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 20);
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(38041);
      return;
    }
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", (String)localObject);
    localIntent.putExtra("finish_direct", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectSpecialContactUI
 * JD-Core Version:    0.7.0.1
 */