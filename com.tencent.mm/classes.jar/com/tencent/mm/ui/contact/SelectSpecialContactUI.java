package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingUI;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private int PYo;
  private String title;
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234091);
    paramView = gUP().anH(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(234091);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(234091);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { paramView });
    Intent localIntent = new Intent();
    if (u.hasAttr(this.PYo, 16384))
    {
      localIntent.putExtra("Select_Contact", paramView);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(234091);
      return;
    }
    if (u.hasAttr(this.PYo, 32768))
    {
      localIntent.putExtra("Contact_User", paramView);
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 20);
      c.b(this, "profile", ".ui.ContactInfoUI", localIntent, 1);
      AppMethodBeat.o(234091);
      return;
    }
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", paramView);
    localIntent.putExtra("finish_direct", true);
    paramView = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramView.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(234091);
  }
  
  protected final void amZ()
  {
    AppMethodBeat.i(38040);
    super.amZ();
    this.title = getIntent().getStringExtra("titile");
    this.PYo = getIntent().getIntExtra("list_attr", 0);
    AppMethodBeat.o(38040);
  }
  
  protected final boolean bmA()
  {
    return false;
  }
  
  protected final String bmB()
  {
    return this.title;
  }
  
  protected final q bmC()
  {
    AppMethodBeat.i(38042);
    ae localae = new ae(this, getIntent().getStringExtra("filter_type"));
    AppMethodBeat.o(38042);
    return localae;
  }
  
  protected final o bmD()
  {
    return null;
  }
  
  protected final boolean bmz()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(234092);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(234092);
      return;
    }
    gUQ().and();
    AppMethodBeat.o(234092);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectSpecialContactUI
 * JD-Core Version:    0.7.0.1
 */