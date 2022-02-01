package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.chatting.ChattingUI;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private int Iyl;
  private String title;
  
  protected final void WJ()
  {
    AppMethodBeat.i(38040);
    super.WJ();
    this.title = getIntent().getStringExtra("titile");
    this.Iyl = getIntent().getIntExtra("list_attr", 0);
    AppMethodBeat.o(38040);
  }
  
  protected final boolean aOi()
  {
    return false;
  }
  
  protected final boolean aOj()
  {
    return false;
  }
  
  protected final String aOk()
  {
    return this.title;
  }
  
  protected final q aOl()
  {
    AppMethodBeat.i(38042);
    ae localae = new ae(this, getIntent().getStringExtra("filter_type"));
    AppMethodBeat.o(38042);
    return localae;
  }
  
  protected final o aOm()
  {
    return null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(38041);
    Object localObject = frq().abQ(paramInt);
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
    ac.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { localObject });
    Intent localIntent = new Intent();
    if (u.hasAttr(this.Iyl, 16384))
    {
      localIntent.putExtra("Select_Contact", (String)localObject);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(38041);
      return;
    }
    if (u.hasAttr(this.Iyl, 32768))
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectSpecialContactUI
 * JD-Core Version:    0.7.0.1
 */