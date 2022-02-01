package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> KLl;
  private int KLn;
  private HashSet<String> iYq;
  private String label;
  
  private void Zv()
  {
    AppMethodBeat.i(38034);
    if ((u.hasAttr(this.KLn, 64)) && (this.iYq.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755835) + "(" + this.iYq.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(38034);
      return;
    }
    updateOptionMenuText(1, getString(2131755835));
    enableOptionMenu(1, false);
    AppMethodBeat.o(38034);
  }
  
  private void aYz(String paramString)
  {
    AppMethodBeat.i(38035);
    if (u.hasAttr(this.KLn, 16384))
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38035);
  }
  
  protected final void Zm()
  {
    AppMethodBeat.i(38031);
    super.Zm();
    this.label = getIntent().getStringExtra("label");
    this.KLn = getIntent().getIntExtra("list_attr", 0);
    this.iYq = new HashSet();
    this.KLl = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bu.isNullOrNil(str)) {
      this.KLl.addAll(bu.U(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bu.isNullOrNil(str)) {
      this.iYq.addAll(bu.U(str.split(",")));
    }
    AppMethodBeat.o(38031);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38037);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.iYq.contains(parama.contact.field_username);
      AppMethodBeat.o(38037);
      return bool;
    }
    AppMethodBeat.o(38037);
    return false;
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
    return this.label;
  }
  
  protected final q aRW()
  {
    AppMethodBeat.i(38036);
    Object localObject = com.tencent.mm.plugin.label.a.a.dig().apo(this.label);
    localObject = new i(this, u.hasAttr(this.KLn, 64), com.tencent.mm.plugin.label.a.a.dig().apr((String)localObject));
    AppMethodBeat.o(38036);
    return localObject;
  }
  
  protected final o aRX()
  {
    return null;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38038);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.KLl.contains(parama.contact.field_username);
      AppMethodBeat.o(38038);
      return bool;
    }
    AppMethodBeat.o(38038);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38032);
    super.onCreate(paramBundle);
    if (u.hasAttr(this.KLn, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38030);
          paramAnonymousMenuItem = new ArrayList(SelectLabelContactUI.a(SelectLabelContactUI.this));
          ae.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[] { paramAnonymousMenuItem.toString() });
          SelectLabelContactUI.a(SelectLabelContactUI.this, bu.m(paramAnonymousMenuItem, ","));
          AppMethodBeat.o(38030);
          return true;
        }
      }, null, s.b.JwA);
    }
    Zv();
    AppMethodBeat.o(38032);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(38033);
    int i = getContentLV().getHeaderViewsCount();
    p localp = fMv();
    Object localObject = localp.aeW(paramInt - i);
    if (localObject == null)
    {
      AppMethodBeat.o(38033);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(38033);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    ae.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { localObject });
    if (u.hasAttr(this.KLn, 64))
    {
      if ((!this.KLl.contains(localObject)) && (!this.iYq.contains(localObject)) && (u.hasAttr(this.KLn, 131072)) && (this.KLl.size() + this.iYq.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        h.d(getContext(), getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(38033);
        return;
      }
      if (!this.KLl.contains(localObject))
      {
        if (!this.iYq.contains(localObject)) {
          break label268;
        }
        this.iYq.remove(localObject);
      }
      for (;;)
      {
        Zv();
        localp.notifyDataSetChanged();
        AppMethodBeat.o(38033);
        return;
        label268:
        this.iYq.add(localObject);
      }
    }
    aYz((String)localObject);
    AppMethodBeat.o(38033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI
 * JD-Core Version:    0.7.0.1
 */