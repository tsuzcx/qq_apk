package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI
  extends MMBaseSelectContactUI
{
  private List<String> jkb;
  private HashSet<String> mNi;
  
  private void atk()
  {
    AppMethodBeat.i(38056);
    String str;
    if (this.mNi.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(R.l.app_ok) });
      updateOptionMenuText(1, str);
      if (this.mNi.size() < 0) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      AppMethodBeat.o(38056);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(R.l.app_ok), Integer.valueOf(this.mNi.size()), Integer.valueOf(aq.Vga) });
      break;
    }
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(228398);
    paramView = hUP();
    Object localObject = paramView.awM(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(228398);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(228398);
      return;
    }
    Log.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    hUZ();
    if (this.mNi.contains(localObject))
    {
      this.mNi.remove(localObject);
      this.ETP.bqR((String)localObject);
    }
    for (;;)
    {
      atk();
      paramView.notifyDataSetChanged();
      AppMethodBeat.o(228398);
      return;
      if (this.mNi.size() < aq.Vga)
      {
        this.mNi.add(localObject);
        this.ETP.bqR((String)localObject);
      }
      else
      {
        Toast.makeText(this, R.l.sns_max_select_at, 0).show();
        Log.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(aq.Vga) });
      }
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(38060);
    if (paramInt == 1)
    {
      this.mNi.remove(paramString);
      hUP().notifyDataSetChanged();
      atk();
    }
    AppMethodBeat.o(38060);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(38059);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.mNi.contains(parama.contact.field_username);
      AppMethodBeat.o(38059);
      return bool;
    }
    AppMethodBeat.o(38059);
    return false;
  }
  
  protected final void aOd(String paramString)
  {
    AppMethodBeat.i(38058);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.mNi);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", w.P(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(38058);
  }
  
  protected final void ata()
  {
    AppMethodBeat.i(38050);
    super.ata();
    this.jkb = new ArrayList();
    Object localObject = Util.stringsToList(Util.nullAs(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = w.hVh();
    localHashSet.addAll((Collection)localObject);
    this.jkb.addAll(localHashSet);
    this.jkb.addAll(w.hVi());
    this.mNi = new HashSet();
    localObject = Util.nullAs(getIntent().getStringExtra("Select_Contact"), "");
    if (!Util.isNullOrNil((String)localObject)) {
      this.mNi.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    AppMethodBeat.o(38050);
  }
  
  protected final boolean bwH()
  {
    return false;
  }
  
  protected final boolean bwI()
  {
    return true;
  }
  
  protected final String bwJ()
  {
    AppMethodBeat.i(38053);
    String str = Util.nullAs(getIntent().getStringExtra("Add_address_titile"), "");
    AppMethodBeat.o(38053);
    return str;
  }
  
  protected final r bwK()
  {
    AppMethodBeat.i(38054);
    Object localObject = new c.a();
    ((c.a)localObject).Xqx = true;
    ((c.a)localObject).XqG = true;
    ((c.a)localObject).customHeader = getString(R.l.enK);
    ((c.a)localObject).XqH = Util.nullAs(getIntent().getStringExtra("Add_get_from_sns"), "");
    ((c.a)localObject).XoS = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.jkb, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38054);
    return localObject;
  }
  
  protected final p bwL()
  {
    AppMethodBeat.i(38055);
    u localu = new u(this, this.jkb, true, this.scene);
    AppMethodBeat.o(38055);
    return localu;
  }
  
  public final int[] dvA()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean eRT()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(38057);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38057);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38057);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (Util.isNullOrNil(paramIntent))
      {
        Log.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(38057);
        return;
      }
      Log.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.mNi.add(localObject)) {
          this.ETP.bqR(localObject);
        }
        paramInt1 += 1;
      }
      atk();
      hUP().notifyDataSetChanged();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38051);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SnsAddressUI", "Create!");
    addTextOptionMenu(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38047);
        paramAnonymousMenuItem = new Intent();
        ArrayList localArrayList = Util.stringsToList((String[])SnsAddressUI.a(SnsAddressUI.this).toArray(new String[0]));
        if ((localArrayList == null) || (localArrayList.size() == 0)) {
          paramAnonymousMenuItem.putExtra("Select_Contact", "");
        }
        for (;;)
        {
          SnsAddressUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsAddressUI.this.finish();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38046);
              if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                SnsAddressUI.this.moveTaskToBack(true);
              }
              AppMethodBeat.o(38046);
            }
          }, 100L);
          SnsAddressUI.this.hideVKB();
          AppMethodBeat.o(38047);
          return true;
          paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(localArrayList, ","));
        }
      }
    }, null, w.b.Wao);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38048);
        SnsAddressUI.this.finish();
        if (!SnsAddressUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
          SnsAddressUI.this.moveTaskToBack(true);
        }
        AppMethodBeat.o(38048);
        return true;
      }
    });
    paramBundle = this.mNi.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.ETP.bqR(str);
    }
    this.ETP.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void V(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(38049);
        if ((paramAnonymousInt == 1) && (paramAnonymousString != null))
        {
          SnsAddressUI.a(SnsAddressUI.this).remove(paramAnonymousString);
          SnsAddressUI.b(SnsAddressUI.this);
        }
        AppMethodBeat.o(38049);
      }
    });
    atk();
    AppMethodBeat.o(38051);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI
 * JD-Core Version:    0.7.0.1
 */