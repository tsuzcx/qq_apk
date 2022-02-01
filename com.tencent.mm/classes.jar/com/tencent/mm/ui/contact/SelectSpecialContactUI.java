package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.ui.chatting.ChattingUI;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private int KLn;
  private String title;
  
  protected final void Zm()
  {
    AppMethodBeat.i(38040);
    super.Zm();
    this.title = getIntent().getStringExtra("titile");
    this.KLn = getIntent().getIntExtra("list_attr", 0);
    AppMethodBeat.o(38040);
  }
  
  protected final boolean aRT()
  {
    return false;
  }
  
  protected final boolean aRU()
  {
    return false;
  }
  
  protected final String aRV()
  {
    return this.title;
  }
  
  protected final q aRW()
  {
    AppMethodBeat.i(38042);
    ae localae = new ae(this, getIntent().getStringExtra("filter_type"));
    AppMethodBeat.o(38042);
    return localae;
  }
  
  protected final o aRX()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(188028);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(188028);
      return;
    }
    fMw().Zq();
    AppMethodBeat.o(188028);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(38041);
    Object localObject = fMv().aeW(paramInt);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { localObject });
    Intent localIntent = new Intent();
    if (u.hasAttr(this.KLn, 16384))
    {
      localIntent.putExtra("Select_Contact", (String)localObject);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(38041);
      return;
    }
    if (u.hasAttr(this.KLn, 32768))
    {
      localIntent.putExtra("Contact_User", (String)localObject);
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 20);
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent, 1);
      AppMethodBeat.o(38041);
      return;
    }
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", (String)localObject);
    localIntent.putExtra("finish_direct", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectSpecialContactUI
 * JD-Core Version:    0.7.0.1
 */