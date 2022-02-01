package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI
  extends MMBaseSelectContactUI
{
  private List<String> fvP;
  private HashSet<String> icg;
  
  private void VV()
  {
    AppMethodBeat.i(38056);
    String str;
    if (this.icg.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(2131755835) });
      updateOptionMenuText(1, str);
      if (this.icg.size() < 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      AppMethodBeat.o(38056);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(2131755835), Integer.valueOf(this.icg.size()), Integer.valueOf(com.tencent.mm.storage.ad.FfG) });
      break;
    }
  }
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(38060);
    if (paramInt == 1)
    {
      this.icg.remove(paramString);
      fbz().notifyDataSetChanged();
      VV();
    }
    AppMethodBeat.o(38060);
  }
  
  protected final void VL()
  {
    AppMethodBeat.i(38050);
    super.VL();
    this.fvP = new ArrayList();
    Object localObject = bt.S(bt.by(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = u.fbL();
    localHashSet.addAll((Collection)localObject);
    this.fvP.addAll(localHashSet);
    this.fvP.addAll(u.fbM());
    this.icg = new HashSet();
    localObject = bt.by(getIntent().getStringExtra("Select_Contact"), "");
    if (!bt.isNullOrNil((String)localObject)) {
      this.icg.addAll(bt.S(((String)localObject).split(",")));
    }
    AppMethodBeat.o(38050);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(38059);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.icg.contains(parama.contact.field_username);
      AppMethodBeat.o(38059);
      return bool;
    }
    AppMethodBeat.o(38059);
    return false;
  }
  
  protected final boolean aHt()
  {
    return false;
  }
  
  protected final boolean aHu()
  {
    return true;
  }
  
  protected final String aHv()
  {
    AppMethodBeat.i(38053);
    String str = bt.by(getIntent().getStringExtra("Add_address_titile"), "");
    AppMethodBeat.o(38053);
    return str;
  }
  
  protected final q aHw()
  {
    AppMethodBeat.i(38054);
    Object localObject = new c.a();
    ((c.a)localObject).GTE = true;
    ((c.a)localObject).GTM = true;
    ((c.a)localObject).customHeader = getString(2131755217);
    ((c.a)localObject).GTN = bt.by(getIntent().getStringExtra("Add_get_from_sns"), "");
    ((c.a)localObject).GRX = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.fvP, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38054);
    return localObject;
  }
  
  protected final o aHx()
  {
    AppMethodBeat.i(38055);
    s locals = new s(this, this.fvP, true, this.scene);
    AppMethodBeat.o(38055);
    return locals;
  }
  
  protected final void afM(String paramString)
  {
    AppMethodBeat.i(38058);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.icg);
    localIntent.putExtra("always_select_contact", bt.n(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", u.I(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(38058);
  }
  
  public final int[] cMQ()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean cOv()
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
      if (bt.isNullOrNil(paramIntent))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(38057);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.icg.add(localObject)) {
          this.twW.aBC(localObject);
        }
        paramInt1 += 1;
      }
      VV();
      fbz().notifyDataSetChanged();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38051);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAddressUI", "Create!");
    addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38047);
        paramAnonymousMenuItem = new Intent();
        ArrayList localArrayList = bt.S((String[])SnsAddressUI.a(SnsAddressUI.this).toArray(new String[0]));
        if ((localArrayList == null) || (localArrayList.size() == 0)) {
          paramAnonymousMenuItem.putExtra("Select_Contact", "");
        }
        for (;;)
        {
          SnsAddressUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsAddressUI.this.finish();
          aq.n(new Runnable()
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
          paramAnonymousMenuItem.putExtra("Select_Contact", bt.n(localArrayList, ","));
        }
      }
    }, null, r.b.FOB);
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
    paramBundle = this.icg.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.twW.aBC(str);
    }
    this.twW.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void N(int paramAnonymousInt, String paramAnonymousString)
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
    VV();
    AppMethodBeat.o(38051);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(38052);
    p localp = fbz();
    Object localObject = localp.ZC(paramInt - getContentLV().getHeaderViewsCount());
    if (localObject == null)
    {
      AppMethodBeat.o(38052);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(38052);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    fbG();
    if (this.icg.contains(localObject))
    {
      this.icg.remove(localObject);
      this.twW.aBC((String)localObject);
    }
    for (;;)
    {
      VV();
      localp.notifyDataSetChanged();
      AppMethodBeat.o(38052);
      return;
      if (this.icg.size() < com.tencent.mm.storage.ad.FfG)
      {
        this.icg.add(localObject);
        this.twW.aBC((String)localObject);
      }
      else
      {
        Toast.makeText(this, 2131763910, 0).show();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(com.tencent.mm.storage.ad.FfG) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI
 * JD-Core Version:    0.7.0.1
 */