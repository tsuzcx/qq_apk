package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingUI;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private int afhe;
  private String title;
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253279);
    paramAdapterView = jyE().aDt(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(253279);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(253279);
      return;
    }
    paramAdapterView = paramAdapterView.contact.field_username;
    Log.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { paramAdapterView });
    paramView = new Intent();
    if (w.hasAttr(this.afhe, 16384))
    {
      paramView.putExtra("Select_Contact", paramAdapterView);
      setResult(-1, paramView);
      finish();
      AppMethodBeat.o(253279);
      return;
    }
    if (w.hasAttr(this.afhe, 32768))
    {
      paramView.putExtra("Contact_User", paramAdapterView);
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 20);
      c.b(this, "profile", ".ui.ContactInfoUI", paramView, 1);
      AppMethodBeat.o(253279);
      return;
    }
    paramView.setClass(this, ChattingUI.class);
    paramView.putExtra("Chat_User", paramAdapterView);
    paramView.putExtra("finish_direct", true);
    paramAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramAdapterView.aYi(), "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramAdapterView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectSpecialContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(253279);
  }
  
  protected final void aNi()
  {
    AppMethodBeat.i(38040);
    super.aNi();
    this.title = getIntent().getStringExtra("titile");
    this.afhe = getIntent().getIntExtra("list_attr", 0);
    AppMethodBeat.o(38040);
  }
  
  protected final r bVA()
  {
    AppMethodBeat.i(38042);
    al localal = new al(this, getIntent().getStringExtra("filter_type"));
    AppMethodBeat.o(38042);
    return localal;
  }
  
  protected final p bVB()
  {
    return null;
  }
  
  protected final boolean bVx()
  {
    return false;
  }
  
  protected final boolean bVy()
  {
    return false;
  }
  
  protected final String bVz()
  {
    return this.title;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(253289);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(253289);
      return;
    }
    jyF().aNm();
    AppMethodBeat.o(253289);
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