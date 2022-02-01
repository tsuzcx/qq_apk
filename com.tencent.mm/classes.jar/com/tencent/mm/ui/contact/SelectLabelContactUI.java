package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> PYm;
  private int PYo;
  private HashSet<String> jVV;
  private String label;
  
  private void ani()
  {
    AppMethodBeat.i(38034);
    if ((u.hasAttr(this.PYo, 64)) && (this.jVV.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755921) + "(" + this.jVV.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(38034);
      return;
    }
    updateOptionMenuText(1, getString(2131755921));
    enableOptionMenu(1, false);
    AppMethodBeat.o(38034);
  }
  
  private void bnC(String paramString)
  {
    AppMethodBeat.i(38035);
    if (u.hasAttr(this.PYo, 16384))
    {
      localIntent = new Intent();
      localIntent.putExtra("Select_Contact", paramString);
      setResult(-1, localIntent);
      finish();
      AppMethodBeat.o(38035);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this, ChattingUI.class);
    localIntent.putExtra("Chat_User", paramString);
    localIntent.putExtra("finish_direct", true);
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38035);
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234090);
    int i = getContentLV().getHeaderViewsCount();
    paramView = gUP();
    Object localObject = paramView.anH(paramInt - i);
    if (localObject == null)
    {
      AppMethodBeat.o(234090);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(234090);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    Log.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { localObject });
    if (u.hasAttr(this.PYo, 64))
    {
      if ((!this.PYm.contains(localObject)) && (!this.jVV.contains(localObject)) && (u.hasAttr(this.PYo, 131072)) && (this.PYm.size() + this.jVV.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        h.d(getContext(), getString(2131765131, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(234090);
        return;
      }
      if (!this.PYm.contains(localObject))
      {
        if (!this.jVV.contains(localObject)) {
          break label254;
        }
        this.jVV.remove(localObject);
      }
      for (;;)
      {
        ani();
        paramView.notifyDataSetChanged();
        AppMethodBeat.o(234090);
        return;
        label254:
        this.jVV.add(localObject);
      }
    }
    bnC((String)localObject);
    AppMethodBeat.o(234090);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38037);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.jVV.contains(parama.contact.field_username);
      AppMethodBeat.o(38037);
      return bool;
    }
    AppMethodBeat.o(38037);
    return false;
  }
  
  protected final void amZ()
  {
    AppMethodBeat.i(38031);
    super.amZ();
    this.label = getIntent().getStringExtra("label");
    this.PYo = getIntent().getIntExtra("list_attr", 0);
    this.jVV = new HashSet();
    this.PYm = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.PYm.addAll(Util.stringsToList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.jVV.addAll(Util.stringsToList(str.split(",")));
    }
    AppMethodBeat.o(38031);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38038);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.PYm.contains(parama.contact.field_username);
      AppMethodBeat.o(38038);
      return bool;
    }
    AppMethodBeat.o(38038);
    return false;
  }
  
  protected final boolean bmA()
  {
    return false;
  }
  
  protected final String bmB()
  {
    return this.label;
  }
  
  protected final q bmC()
  {
    AppMethodBeat.i(38036);
    Object localObject = com.tencent.mm.plugin.label.a.a.ecg().aCH(this.label);
    localObject = new i(this, u.hasAttr(this.PYo, 64), com.tencent.mm.plugin.label.a.a.ecg().aCK((String)localObject));
    AppMethodBeat.o(38036);
    return localObject;
  }
  
  protected final o bmD()
  {
    return null;
  }
  
  protected final boolean bmz()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38032);
    super.onCreate(paramBundle);
    if (u.hasAttr(this.PYo, 64)) {
      addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38030);
          paramAnonymousMenuItem = new ArrayList(SelectLabelContactUI.a(SelectLabelContactUI.this));
          Log.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[] { paramAnonymousMenuItem.toString() });
          SelectLabelContactUI.a(SelectLabelContactUI.this, Util.listToString(paramAnonymousMenuItem, ","));
          AppMethodBeat.o(38030);
          return true;
        }
      }, null, t.b.OGU);
    }
    ani();
    AppMethodBeat.o(38032);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI
 * JD-Core Version:    0.7.0.1
 */