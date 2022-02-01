package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI
  extends MMBaseSelectContactUI
{
  private List<String> fSL;
  private HashSet<String> iVx;
  
  private void Zm()
  {
    AppMethodBeat.i(38056);
    String str;
    if (this.iVx.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(2131755835) });
      updateOptionMenuText(1, str);
      if (this.iVx.size() < 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      AppMethodBeat.o(38056);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(2131755835), Integer.valueOf(this.iVx.size()), Integer.valueOf(ak.IpM) });
      break;
    }
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(38060);
    if (paramInt == 1)
    {
      this.iVx.remove(paramString);
      fId().notifyDataSetChanged();
      Zm();
    }
    AppMethodBeat.o(38060);
  }
  
  protected final void Zd()
  {
    AppMethodBeat.i(38050);
    super.Zd();
    this.fSL = new ArrayList();
    Object localObject = bt.U(bt.bI(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = u.fIp();
    localHashSet.addAll((Collection)localObject);
    this.fSL.addAll(localHashSet);
    this.fSL.addAll(u.fIq());
    this.iVx = new HashSet();
    localObject = bt.bI(getIntent().getStringExtra("Select_Contact"), "");
    if (!bt.isNullOrNil((String)localObject)) {
      this.iVx.addAll(bt.U(((String)localObject).split(",")));
    }
    AppMethodBeat.o(38050);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(38059);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.iVx.contains(parama.contact.field_username);
      AppMethodBeat.o(38059);
      return bool;
    }
    AppMethodBeat.o(38059);
    return false;
  }
  
  protected final boolean aRu()
  {
    return false;
  }
  
  protected final boolean aRv()
  {
    return true;
  }
  
  protected final String aRw()
  {
    AppMethodBeat.i(38053);
    String str = bt.bI(getIntent().getStringExtra("Add_address_titile"), "");
    AppMethodBeat.o(38053);
    return str;
  }
  
  protected final q aRx()
  {
    AppMethodBeat.i(38054);
    Object localObject = new c.a();
    ((c.a)localObject).Kkv = true;
    ((c.a)localObject).KkD = true;
    ((c.a)localObject).customHeader = getString(2131755217);
    ((c.a)localObject).KkE = bt.bI(getIntent().getStringExtra("Add_get_from_sns"), "");
    ((c.a)localObject).KiP = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.fSL, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38054);
    return localObject;
  }
  
  protected final o aRy()
  {
    AppMethodBeat.i(38055);
    s locals = new s(this, this.fSL, true, this.scene);
    AppMethodBeat.o(38055);
    return locals;
  }
  
  protected final void apt(String paramString)
  {
    AppMethodBeat.i(38058);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.iVx);
    localIntent.putExtra("always_select_contact", bt.m(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", u.I(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(38058);
  }
  
  public final int[] djJ()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean dlz()
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
        ad.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(38057);
        return;
      }
      ad.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.iVx.add(localObject)) {
          this.vIo.aMx(localObject);
        }
        paramInt1 += 1;
      }
      Zm();
      fId().notifyDataSetChanged();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38051);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.SnsAddressUI", "Create!");
    addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38047);
        paramAnonymousMenuItem = new Intent();
        ArrayList localArrayList = bt.U((String[])SnsAddressUI.a(SnsAddressUI.this).toArray(new String[0]));
        if ((localArrayList == null) || (localArrayList.size() == 0)) {
          paramAnonymousMenuItem.putExtra("Select_Contact", "");
        }
        for (;;)
        {
          SnsAddressUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsAddressUI.this.finish();
          aq.o(new Runnable()
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
          paramAnonymousMenuItem.putExtra("Select_Contact", bt.m(localArrayList, ","));
        }
      }
    }, null, s.b.JbS);
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
    paramBundle = this.iVx.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.vIo.aMx(str);
    }
    this.vIo.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void Q(int paramAnonymousInt, String paramAnonymousString)
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
    Zm();
    AppMethodBeat.o(38051);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(38052);
    p localp = fId();
    Object localObject = localp.aen(paramInt - getContentLV().getHeaderViewsCount());
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
    ad.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    fIk();
    if (this.iVx.contains(localObject))
    {
      this.iVx.remove(localObject);
      this.vIo.aMx((String)localObject);
    }
    for (;;)
    {
      Zm();
      localp.notifyDataSetChanged();
      AppMethodBeat.o(38052);
      return;
      if (this.iVx.size() < ak.IpM)
      {
        this.iVx.add(localObject);
        this.vIo.aMx((String)localObject);
      }
      else
      {
        Toast.makeText(this, 2131763910, 0).show();
        ad.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(ak.IpM) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI
 * JD-Core Version:    0.7.0.1
 */