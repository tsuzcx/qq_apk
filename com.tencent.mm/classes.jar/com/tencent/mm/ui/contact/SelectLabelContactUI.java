package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectLabelContactUI
  extends MMBaseSelectContactUI
{
  private HashSet<String> afhc;
  private int afhe;
  private List<String> afiF;
  private String label;
  private HashSet<String> pJQ;
  
  private void aNr()
  {
    AppMethodBeat.i(38034);
    if ((w.hasAttr(this.afhe, 64)) && (this.pJQ.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + this.pJQ.size() + ")");
      enableOptionMenu(1, true);
      AppMethodBeat.o(38034);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_ok));
    enableOptionMenu(1, false);
    AppMethodBeat.o(38034);
  }
  
  private void bCb(String paramString)
  {
    AppMethodBeat.i(38035);
    if (w.hasAttr(this.afhe, 16384))
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
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectLabelContactUI", "handleSelect", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(38035);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252958);
    int i = getContentLV().getHeaderViewsCount();
    paramAdapterView = jyE();
    paramView = paramAdapterView.aDt(paramInt - i);
    if (paramView == null)
    {
      AppMethodBeat.o(252958);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(252958);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[] { paramView });
    if (w.hasAttr(this.afhe, 64))
    {
      if ((!this.afhc.contains(paramView)) && (!this.pJQ.contains(paramView)) && (w.hasAttr(this.afhe, 131072)) && (this.afhc.size() + this.pJQ.size() >= getIntent().getIntExtra("max_limit_num", 2147483647)))
      {
        k.d(getContext(), getString(R.l.gUz, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 2147483647)) }), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(252958);
        return;
      }
      if (!this.afhc.contains(paramView))
      {
        if (!this.pJQ.contains(paramView)) {
          break label246;
        }
        this.pJQ.remove(paramView);
      }
      for (;;)
      {
        aNr();
        paramAdapterView.notifyDataSetChanged();
        AppMethodBeat.o(252958);
        return;
        label246:
        this.pJQ.add(paramView);
      }
    }
    bCb(paramView);
    AppMethodBeat.o(252958);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38037);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.pJQ.contains(parama.contact.field_username);
      AppMethodBeat.o(38037);
      return bool;
    }
    AppMethodBeat.o(38037);
    return false;
  }
  
  protected final void aNi()
  {
    AppMethodBeat.i(38031);
    super.aNi();
    this.label = getIntent().getStringExtra("label");
    this.afhe = getIntent().getIntExtra("list_attr", 0);
    this.pJQ = new HashSet();
    this.afhc = new HashSet();
    this.afiF = new ArrayList();
    String str = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.afhc.addAll(Util.stringsToList(str.split(",")));
    }
    str = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil(str)) {
      this.pJQ.addAll(Util.stringsToList(str.split(",")));
    }
    str = getIntent().getStringExtra("block_contact");
    if (!Util.isNullOrNil(str)) {
      this.afiF.addAll(Util.stringsToList(str.split(",")));
    }
    AppMethodBeat.o(38031);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38038);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.afhc.contains(parama.contact.field_username);
      AppMethodBeat.o(38038);
      return bool;
    }
    AppMethodBeat.o(38038);
    return false;
  }
  
  protected final r bVA()
  {
    AppMethodBeat.i(38036);
    Object localObject = com.tencent.mm.plugin.label.a.a.fTb().aJH(this.label);
    localObject = new i(this, w.hasAttr(this.afhe, 64), com.tencent.mm.plugin.label.a.a.fTb().aJK((String)localObject), this.afiF);
    AppMethodBeat.o(38036);
    return localObject;
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
    return this.label;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38032);
    super.onCreate(paramBundle);
    if (w.hasAttr(this.afhe, 64)) {
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
      }, null, y.b.adEJ);
    }
    aNr();
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