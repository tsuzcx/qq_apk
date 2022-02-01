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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.al;
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
  private List<String> fUR;
  private HashSet<String> iYq;
  
  private void Zv()
  {
    AppMethodBeat.i(38056);
    String str;
    if (this.iYq.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(2131755835) });
      updateOptionMenuText(1, str);
      if (this.iYq.size() < 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      AppMethodBeat.o(38056);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(2131755835), Integer.valueOf(this.iYq.size()), Integer.valueOf(al.IKg) });
      break;
    }
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(38060);
    if (paramInt == 1)
    {
      this.iYq.remove(paramString);
      fMv().notifyDataSetChanged();
      Zv();
    }
    AppMethodBeat.o(38060);
  }
  
  protected final void Zm()
  {
    AppMethodBeat.i(38050);
    super.Zm();
    this.fUR = new ArrayList();
    Object localObject = bu.U(bu.bI(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = u.fMH();
    localHashSet.addAll((Collection)localObject);
    this.fUR.addAll(localHashSet);
    this.fUR.addAll(u.fMI());
    this.iYq = new HashSet();
    localObject = bu.bI(getIntent().getStringExtra("Select_Contact"), "");
    if (!bu.isNullOrNil((String)localObject)) {
      this.iYq.addAll(bu.U(((String)localObject).split(",")));
    }
    AppMethodBeat.o(38050);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(38059);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.iYq.contains(parama.contact.field_username);
      AppMethodBeat.o(38059);
      return bool;
    }
    AppMethodBeat.o(38059);
    return false;
  }
  
  protected final boolean aRT()
  {
    return false;
  }
  
  protected final boolean aRU()
  {
    return true;
  }
  
  protected final String aRV()
  {
    AppMethodBeat.i(38053);
    String str = bu.bI(getIntent().getStringExtra("Add_address_titile"), "");
    AppMethodBeat.o(38053);
    return str;
  }
  
  protected final q aRW()
  {
    AppMethodBeat.i(38054);
    Object localObject = new c.a();
    ((c.a)localObject).KGP = true;
    ((c.a)localObject).KGX = true;
    ((c.a)localObject).customHeader = getString(2131755217);
    ((c.a)localObject).KGY = bu.bI(getIntent().getStringExtra("Add_get_from_sns"), "");
    ((c.a)localObject).KFj = "@all.contact.without.chatroom.without.openim.without.openimfavour";
    localObject = new c(this, this.fUR, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38054);
    return localObject;
  }
  
  protected final o aRX()
  {
    AppMethodBeat.i(38055);
    s locals = new s(this, this.fUR, true, this.scene);
    AppMethodBeat.o(38055);
    return locals;
  }
  
  protected final void aqy(String paramString)
  {
    AppMethodBeat.i(38058);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.iYq);
    localIntent.putExtra("always_select_contact", bu.m(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", u.J(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(38058);
  }
  
  public final int[] dmI()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean doz()
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
      if (bu.isNullOrNil(paramIntent))
      {
        ae.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(38057);
        return;
      }
      ae.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      paramIntent = paramIntent.split(",");
      paramInt2 = paramIntent.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        Object localObject = paramIntent[paramInt1];
        if (this.iYq.add(localObject)) {
          this.vUs.aNT(localObject);
        }
        paramInt1 += 1;
      }
      Zv();
      fMv().notifyDataSetChanged();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38051);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.SnsAddressUI", "Create!");
    addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38047);
        paramAnonymousMenuItem = new Intent();
        ArrayList localArrayList = bu.U((String[])SnsAddressUI.a(SnsAddressUI.this).toArray(new String[0]));
        if ((localArrayList == null) || (localArrayList.size() == 0)) {
          paramAnonymousMenuItem.putExtra("Select_Contact", "");
        }
        for (;;)
        {
          SnsAddressUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsAddressUI.this.finish();
          ar.o(new Runnable()
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
          paramAnonymousMenuItem.putExtra("Select_Contact", bu.m(localArrayList, ","));
        }
      }
    }, null, s.b.JwA);
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
    paramBundle = this.iYq.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.vUs.aNT(str);
    }
    this.vUs.setOnContactDeselectListener(new MultiSelectContactView.c()
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
    Zv();
    AppMethodBeat.o(38051);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(38052);
    p localp = fMv();
    Object localObject = localp.aeW(paramInt - getContentLV().getHeaderViewsCount());
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
    ae.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { ((a)localObject).contact.field_username });
    localObject = ((a)localObject).contact.field_username;
    fMC();
    if (this.iYq.contains(localObject))
    {
      this.iYq.remove(localObject);
      this.vUs.aNT((String)localObject);
    }
    for (;;)
    {
      Zv();
      localp.notifyDataSetChanged();
      AppMethodBeat.o(38052);
      return;
      if (this.iYq.size() < al.IKg)
      {
        this.iYq.add(localObject);
        this.vUs.aNT((String)localObject);
      }
      else
      {
        Toast.makeText(this, 2131763910, 0).show();
        ae.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(al.IKg) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsAddressUI
 * JD-Core Version:    0.7.0.1
 */