package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI
  extends MMBaseSelectContactUI
{
  private int AeD;
  private String title;
  
  protected final void Kc()
  {
    AppMethodBeat.i(33916);
    super.Kc();
    this.title = getIntent().getStringExtra("titile");
    this.AeD = getIntent().getIntExtra("list_attr", 0);
    AppMethodBeat.o(33916);
  }
  
  protected final boolean apa()
  {
    return false;
  }
  
  protected final boolean apb()
  {
    return false;
  }
  
  protected final String apc()
  {
    return this.title;
  }
  
  protected final p apd()
  {
    AppMethodBeat.i(33918);
    ab localab = new ab(this, getIntent().getStringExtra("filter_type"));
    AppMethodBeat.o(33918);
    return localab;
  }
  
  protected final n ape()
  {
    return null;
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(33917);
    Object localObject = dLW().Qt(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(33917);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(33917);
      return;
    }
    localObject = ((a)localObject).contact.field_username;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[] { localObject });
    Intent localIntent = new Intent();
    if (t.hI(this.AeD, 16384))
    {
      localIntent.putExtra("Select_Contact", (String)localObject);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(33917);
      return;
    }
    if (t.hI(this.AeD, 32768))
    {
      localIntent.putExtra("Contact_User", (String)localObject);
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 20);
      d.b(this, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(33917);
      return;
    }
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", (String)localObject);
    localIntent.putExtra("finish_direct", true);
    startActivity(localIntent);
    finish();
    AppMethodBeat.o(33917);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectSpecialContactUI
 * JD-Core Version:    0.7.0.1
 */