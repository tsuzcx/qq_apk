package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingUI;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private int Xvg;
  private String title;
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(281774);
    paramView = hUP().awM(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(281774);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(281774);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { paramView });
    Intent localIntent = new Intent();
    if (w.hasAttr(this.Xvg, 16384))
    {
      localIntent.putExtra("Select_Contact", paramView);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(281774);
      return;
    }
    if (w.hasAttr(this.Xvg, 32768))
    {
      localIntent.putExtra("Contact_User", paramView);
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 20);
      c.b(this, "profile", ".ui.ContactInfoUI", localIntent, 1);
      AppMethodBeat.o(281774);
      return;
    }
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", paramView);
    localIntent.putExtra("finish_direct", true);
    paramView = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aFh(), "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramView.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(281774);
  }
  
  protected final void ata()
  {
    AppMethodBeat.i(38040);
    super.ata();
    this.title = getIntent().getStringExtra("titile");
    this.Xvg = getIntent().getIntExtra("list_attr", 0);
    AppMethodBeat.o(38040);
  }
  
  protected final boolean bwH()
  {
    return false;
  }
  
  protected final boolean bwI()
  {
    return false;
  }
  
  protected final String bwJ()
  {
    return this.title;
  }
  
  protected final r bwK()
  {
    AppMethodBeat.i(38042);
    ag localag = new ag(this, getIntent().getStringExtra("filter_type"));
    AppMethodBeat.o(38042);
    return localag;
  }
  
  protected final p bwL()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(281779);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(281779);
      return;
    }
    hUQ().ate();
    AppMethodBeat.o(281779);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectSpecialContactUI
 * JD-Core Version:    0.7.0.1
 */