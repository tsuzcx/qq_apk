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
import com.tencent.mm.g.c.av;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> Iyj;
  private int Iyl;
  private HashSet<String> iCn;
  private String label;
  
  private void WT()
  {
    AppMethodBeat.i(38034);
    if ((u.hasAttr(this.Iyl, 64)) && (this.iCn.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755835) + "(" + this.iCn.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(38034);
      return;
    }
    updateOptionMenuText(1, getString(2131755835));
    enableOptionMenu(1, false);
    AppMethodBeat.o(38034);
  }
  
  private void aRa(String paramString)
  {
    AppMethodBeat.i(38035);
    if (u.hasAttr(this.Iyl, 16384))
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38035);
  }
  
  protected final void WJ()
  {
    AppMethodBeat.i(38031);
    super.WJ();
    this.label = getIntent().getStringExtra("label");
    this.Iyl = getIntent().getIntExtra("list_attr", 0);
    this.iCn = new HashSet();
    this.Iyj = new HashSet();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!bs.isNullOrNil(str)) {
      this.Iyj.addAll(bs.S(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!bs.isNullOrNil(str)) {
      this.iCn.addAll(bs.S(str.split(",")));
    }
    AppMethodBeat.o(38031);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38037);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.iCn.contains(parama.contact.field_username);
      AppMethodBeat.o(38037);
      return bool;
    }
    AppMethodBeat.o(38037);
    return false;
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
    return this.label;
  }
  
  protected final q aOl()
  {
    AppMethodBeat.i(38036);
    Object localObject = com.tencent.mm.plugin.label.a.a.cWd().ajA(this.label);
    localObject = new i(this, u.hasAttr(this.Iyl, 64), com.tencent.mm.plugin.label.a.a.cWd().ajD((String)localObject));
    AppMethodBeat.o(38036);
    return localObject;
  }
  
  protected final o aOm()
  {
    return null;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38038);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.Iyj.contains(parama.contact.field_username);
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
    if (u.hasAttr(this.Iyl, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(38030);
          paramAnonymousMenuItem = new ArrayList(SelectLabelContactUI.a(SelectLabelContactUI.this));
          ac.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new Object[] { paramAnonymousMenuItem.toString() });
          SelectLabelContactUI.a(SelectLabelContactUI.this, bs.n(paramAnonymousMenuItem, ","));
          AppMethodBeat.o(38030);
          return true;
        }
      }, null, s.b.Hom);
    }
    WT();
    AppMethodBeat.o(38032);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(38033);
    int i = getContentLV().getHeaderViewsCount();
    p localp = frq();
    Object localObject = localp.abQ(paramInt - i);
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
    ac.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { localObject });
    if (u.hasAttr(this.Iyl, 64))
    {
      if ((!this.Iyj.contains(localObject)) && (!this.iCn.contains(localObject)) && (u.hasAttr(this.Iyl, 131072)) && (this.Iyj.size() + this.iCn.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        h.d(getContext(), getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(38033);
        return;
      }
      if (!this.Iyj.contains(localObject))
      {
        if (!this.iCn.contains(localObject)) {
          break label268;
        }
        this.iCn.remove(localObject);
      }
      for (;;)
      {
        WT();
        localp.notifyDataSetChanged();
        AppMethodBeat.o(38033);
        return;
        label268:
        this.iCn.add(localObject);
      }
    }
    aRa((String)localObject);
    AppMethodBeat.o(38033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectLabelContactUI
 * JD-Core Version:    0.7.0.1
 */