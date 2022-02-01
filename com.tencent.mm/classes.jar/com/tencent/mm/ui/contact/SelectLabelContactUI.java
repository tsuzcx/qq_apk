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
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> Xve;
  private int Xvg;
  private String label;
  private HashSet<String> mNi;
  
  private void atk()
  {
    AppMethodBeat.i(38034);
    if ((w.hasAttr(this.Xvg, 64)) && (this.mNi.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + this.mNi.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(38034);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_ok));
    enableOptionMenu(1, false);
    AppMethodBeat.o(38034);
  }
  
  private void bAi(String paramString)
  {
    AppMethodBeat.i(38035);
    if (w.hasAttr(this.Xvg, 16384))
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38035);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(237351);
    int i = getContentLV().getHeaderViewsCount();
    paramView = hUP();
    Object localObject = paramView.awM(paramInt - i);
    if (localObject == null)
    {
      AppMethodBeat.o(237351);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(237351);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    Log.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { localObject });
    if (w.hasAttr(this.Xvg, 64))
    {
      if ((!this.Xve.contains(localObject)) && (!this.mNi.contains(localObject)) && (w.hasAttr(this.Xvg, 131072)) && (this.Xve.size() + this.mNi.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        h.d(getContext(), getString(R.l.eRS, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(237351);
        return;
      }
      if (!this.Xve.contains(localObject))
      {
        if (!this.mNi.contains(localObject)) {
          break label255;
        }
        this.mNi.remove(localObject);
      }
      for (;;)
      {
        atk();
        paramView.notifyDataSetChanged();
        AppMethodBeat.o(237351);
        return;
        label255:
        this.mNi.add(localObject);
      }
    }
    bAi((String)localObject);
    AppMethodBeat.o(237351);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38037);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.mNi.contains(parama.contact.field_username);
      AppMethodBeat.o(38037);
      return bool;
    }
    AppMethodBeat.o(38037);
    return false;
  }
  
  protected final void ata()
  {
    AppMethodBeat.i(38031);
    super.ata();
    this.label = getIntent().getStringExtra("label");
    this.Xvg = getIntent().getIntExtra("list_attr", 0);
    this.mNi = new HashSet();
    this.Xve = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.Xve.addAll(Util.stringsToList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.mNi.addAll(Util.stringsToList(str.split(",")));
    }
    AppMethodBeat.o(38031);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38038);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.Xve.contains(parama.contact.field_username);
      AppMethodBeat.o(38038);
      return bool;
    }
    AppMethodBeat.o(38038);
    return false;
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
    return this.label;
  }
  
  protected final r bwK()
  {
    AppMethodBeat.i(38036);
    Object localObject = com.tencent.mm.plugin.label.a.a.eLe().aMO(this.label);
    localObject = new i(this, w.hasAttr(this.Xvg, 64), com.tencent.mm.plugin.label.a.a.eLe().aMR((String)localObject));
    AppMethodBeat.o(38036);
    return localObject;
  }
  
  protected final p bwL()
  {
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38032);
    super.onCreate(paramBundle);
    if (w.hasAttr(this.Xvg, 64)) {
      addTextOptionMenu(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
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
      }, null, w.b.Wao);
    }
    atk();
    AppMethodBeat.o(38032);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI
 * JD-Core Version:    0.7.0.1
 */