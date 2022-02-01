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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> KoR;
  private int KoT;
  private HashSet<String> iVx;
  private String label;
  
  private void Zm()
  {
    AppMethodBeat.i(38034);
    if ((u.hasAttr(this.KoT, 64)) && (this.iVx.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755835) + "(" + this.iVx.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(38034);
      return;
    }
    updateOptionMenuText(1, getString(2131755835));
    enableOptionMenu(1, false);
    AppMethodBeat.o(38034);
  }
  
  private void aWY(String paramString)
  {
    AppMethodBeat.i(38035);
    if (u.hasAttr(this.KoT, 16384))
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
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38035);
  }
  
  protected final void Zd()
  {
    AppMethodBeat.i(38031);
    super.Zd();
    this.label = getIntent().getStringExtra("label");
    this.KoT = getIntent().getIntExtra("list_attr", 0);
    this.iVx = new HashSet();
    this.KoR = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil(str)) {
      this.KoR.addAll(bt.U(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bt.isNullOrNil(str)) {
      this.iVx.addAll(bt.U(str.split(",")));
    }
    AppMethodBeat.o(38031);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38037);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.iVx.contains(parama.contact.field_username);
      AppMethodBeat.o(38037);
      return bool;
    }
    AppMethodBeat.o(38037);
    return false;
  }
  
  protected final boolean aRu()
  {
    return false;
  }
  
  protected final boolean aRv()
  {
    return false;
  }
  
  protected final String aRw()
  {
    return this.label;
  }
  
  protected final q aRx()
  {
    AppMethodBeat.i(38036);
    Object localObject = com.tencent.mm.plugin.label.a.a.dfo().aom(this.label);
    localObject = new i(this, u.hasAttr(this.KoT, 64), com.tencent.mm.plugin.label.a.a.dfo().aop((String)localObject));
    AppMethodBeat.o(38036);
    return localObject;
  }
  
  protected final o aRy()
  {
    return null;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38038);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.KoR.contains(parama.contact.field_username);
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
    if (u.hasAttr(this.KoT, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38030);
          paramAnonymousMenuItem = new ArrayList(SelectLabelContactUI.a(SelectLabelContactUI.this));
          ad.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[] { paramAnonymousMenuItem.toString() });
          SelectLabelContactUI.a(SelectLabelContactUI.this, bt.m(paramAnonymousMenuItem, ","));
          AppMethodBeat.o(38030);
          return true;
        }
      }, null, s.b.JbS);
    }
    Zm();
    AppMethodBeat.o(38032);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(38033);
    int i = getContentLV().getHeaderViewsCount();
    p localp = fId();
    Object localObject = localp.aen(paramInt - i);
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
    ad.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { localObject });
    if (u.hasAttr(this.KoT, 64))
    {
      if ((!this.KoR.contains(localObject)) && (!this.iVx.contains(localObject)) && (u.hasAttr(this.KoT, 131072)) && (this.KoR.size() + this.iVx.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        h.d(getContext(), getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(38033);
        return;
      }
      if (!this.KoR.contains(localObject))
      {
        if (!this.iVx.contains(localObject)) {
          break label268;
        }
        this.iVx.remove(localObject);
      }
      for (;;)
      {
        Zm();
        localp.notifyDataSetChanged();
        AppMethodBeat.o(38033);
        return;
        label268:
        this.iVx.add(localObject);
      }
    }
    aWY((String)localObject);
    AppMethodBeat.o(38033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI
 * JD-Core Version:    0.7.0.1
 */