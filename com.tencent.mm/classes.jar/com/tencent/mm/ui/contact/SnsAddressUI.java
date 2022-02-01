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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI
  extends MMBaseSelectContactUI
{
  private List<String> gzY;
  private HashSet<String> jVV;
  
  private void ani()
  {
    AppMethodBeat.i(38056);
    String str;
    if (this.jVV.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(2131755921) });
      updateOptionMenuText(1, str);
      if (this.jVV.size() < 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      AppMethodBeat.o(38056);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(2131755921), Integer.valueOf(this.jVV.size()), Integer.valueOf(aq.NSd) });
      break;
    }
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234093);
    paramView = gUP();
    Object localObject = paramView.anH(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(234093);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(234093);
      return;
    }
    Log.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    gUW();
    if (this.jVV.contains(localObject))
    {
      this.jVV.remove(localObject);
      this.zoy.bev((String)localObject);
    }
    for (;;)
    {
      ani();
      paramView.notifyDataSetChanged();
      AppMethodBeat.o(234093);
      return;
      if (this.jVV.size() < aq.NSd)
      {
        this.jVV.add(localObject);
        this.zoy.bev((String)localObject);
      }
      else
      {
        Toast.makeText(this, 2131766137, 0).show();
        Log.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(aq.NSd) });
      }
    }
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(38060);
    if (paramInt == 1)
    {
      this.jVV.remove(paramString);
      gUP().notifyDataSetChanged();
      ani();
    }
    AppMethodBeat.o(38060);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(38059);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.jVV.contains(parama.contact.field_username);
      AppMethodBeat.o(38059);
      return bool;
    }
    AppMethodBeat.o(38059);
    return false;
  }
  
  protected final void aDT(String paramString)
  {
    AppMethodBeat.i(38058);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.jVV);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", u.Q(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(38058);
  }
  
  protected final void amZ()
  {
    AppMethodBeat.i(38050);
    super.amZ();
    this.gzY = new ArrayList();
    Object localObject = Util.stringsToList(Util.nullAs(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = u.gVb();
    localHashSet.addAll((Collection)localObject);
    this.gzY.addAll(localHashSet);
    this.gzY.addAll(u.gVc());
    this.jVV = new HashSet();
    localObject = Util.nullAs(getIntent().getStringExtra("Select_Contact"), "");
    if (!Util.isNullOrNil((String)localObject)) {
      this.jVV.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    AppMethodBeat.o(38050);
  }
  
  protected final boolean bmA()
  {
    return true;
  }
  
  protected final String bmB()
  {
    AppMethodBeat.i(38053);
    String str = Util.nullAs(getIntent().getStringExtra("Add_address_titile"), "");
    AppMethodBeat.o(38053);
    return str;
  }
  
  protected final q bmC()
  {
    AppMethodBeat.i(38054);
    Object localObject = new c.a();
    ((c.a)localObject).PTM = true;
    ((c.a)localObject).PTV = true;
    ((c.a)localObject).customHeader = getString(2131755250);
    ((c.a)localObject).PTW = Util.nullAs(getIntent().getStringExtra("Add_get_from_sns"), "");
    ((c.a)localObject).PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.gzY, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38054);
    return localObject;
  }
  
  protected final o bmD()
  {
    AppMethodBeat.i(38055);
    s locals = new s(this, this.gzY, true, this.scene);
    AppMethodBeat.o(38055);
    return locals;
  }
  
  protected final boolean bmz()
  {
    return false;
  }
  
  public final int[] egI()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean eim()
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
        if (this.jVV.add(localObject)) {
          this.zoy.bev(localObject);
        }
        paramInt1 += 1;
      }
      ani();
      gUP().notifyDataSetChanged();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38051);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SnsAddressUI", "Create!");
    addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
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
    }, null, t.b.OGU);
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
    paramBundle = this.jVV.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.zoy.bev(str);
    }
    this.zoy.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
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
    ani();
    AppMethodBeat.o(38051);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI
 * JD-Core Version:    0.7.0.1
 */