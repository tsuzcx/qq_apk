package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI
  extends MMBaseSelectContactUI
{
  private ArrayList<String> afiI;
  private List<String> lMF;
  
  public SnsAddressUI()
  {
    AppMethodBeat.i(253052);
    this.afiI = new ArrayList();
    AppMethodBeat.o(253052);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(38056);
    String str;
    if (this.afiI.size() == 0)
    {
      str = String.format("%s", new Object[] { getString(R.l.app_ok) });
      updateOptionMenuText(1, str);
      if (this.afiI.size() < 0) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(1, bool);
      AppMethodBeat.o(38056);
      return;
      str = String.format("%s(%d/%d)", new Object[] { getString(R.l.app_ok), Integer.valueOf(this.afiI.size()), Integer.valueOf(as.acHp) });
      break;
    }
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253074);
    paramAdapterView = jyE();
    paramView = paramAdapterView.aDt(paramInt - getContentLV().getHeaderViewsCount());
    if (paramView == null)
    {
      AppMethodBeat.o(253074);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(253074);
      return;
    }
    Log.i("MicroMsg.SnsAddressUI", "ClickUser=%s", new Object[] { paramView.contact.field_username });
    paramView = paramView.contact.field_username;
    iKA();
    if (this.afiI.contains(paramView))
    {
      this.afiI.remove(paramView);
      this.KOt.bqG(paramView);
    }
    for (;;)
    {
      aNr();
      paramAdapterView.notifyDataSetChanged();
      AppMethodBeat.o(253074);
      return;
      if (this.afiI.size() < as.acHp)
      {
        this.afiI.add(paramView);
        this.KOt.bqG(paramView);
      }
      else
      {
        Toast.makeText(this, R.l.sns_max_select_at, 0).show();
        Log.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", new Object[] { Integer.valueOf(as.acHp) });
      }
    }
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(38059);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.afiI.contains(parama.contact.field_username);
      AppMethodBeat.o(38059);
      return bool;
    }
    AppMethodBeat.o(38059);
    return false;
  }
  
  protected final void aLa(String paramString)
  {
    AppMethodBeat.i(38058);
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(this.afiI);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    localIntent.putExtra("list_attr", w.R(new int[] { 16384, 64 }));
    startActivityForResult(localIntent, 3);
    AppMethodBeat.o(38058);
  }
  
  protected final void aNi()
  {
    AppMethodBeat.i(38050);
    super.aNi();
    this.lMF = new ArrayList();
    Object localObject = Util.stringsToList(Util.nullAs(getIntent().getStringExtra("Block_list"), "").split(","));
    HashSet localHashSet = w.jyV();
    localHashSet.addAll((Collection)localObject);
    this.lMF.addAll(localHashSet);
    this.lMF.addAll(w.jyW());
    localObject = Util.nullAs(getIntent().getStringExtra("Select_Contact"), "");
    if (!Util.isNullOrNil((String)localObject)) {
      this.afiI.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    AppMethodBeat.o(38050);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(38060);
    if (paramInt == 1)
    {
      this.afiI.remove(paramString);
      jyE().notifyDataSetChanged();
      aNr();
    }
    AppMethodBeat.o(38060);
  }
  
  protected final r bVA()
  {
    AppMethodBeat.i(38054);
    Object localObject = new c.a();
    ((c.a)localObject).afbY = true;
    ((c.a)localObject).afch = true;
    ((c.a)localObject).customHeader = getString(R.l.gqL);
    ((c.a)localObject).afci = Util.nullAs(getIntent().getStringExtra("Add_get_from_sns"), "");
    ((c.a)localObject).afau = "@all.contact.without.chatroom.openim.openimfavour.snsblack.black.socialblack";
    localObject = new c(this, this.lMF, true, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38054);
    return localObject;
  }
  
  protected final p bVB()
  {
    AppMethodBeat.i(38055);
    u localu = new u(this, this.lMF, true, this.scene);
    AppMethodBeat.o(38055);
    return localu;
  }
  
  protected final boolean bVx()
  {
    return false;
  }
  
  protected final boolean bVy()
  {
    return true;
  }
  
  protected final String bVz()
  {
    AppMethodBeat.i(38053);
    String str = Util.nullAs(getIntent().getStringExtra("Add_address_titile"), "");
    AppMethodBeat.o(38053);
    return str;
  }
  
  public final int[] efu()
  {
    return new int[] { 131072 };
  }
  
  protected final boolean gaC()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(253067);
    super.initView();
    getContentLV().setBackgroundResource(R.e.default_background_color);
    String str = getIntent().getStringExtra("address_ui_sub_title");
    Object localObject;
    if (!Util.isNullOrNil(str))
    {
      localObject = (TextView)findViewById(a.e.subtitle_tip);
      if (localObject != null)
      {
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setVisibility(0);
      }
    }
    str = getIntent().getStringExtra("footer_tip");
    if (!Util.isNullOrNil(str))
    {
      localObject = LayoutInflater.from(this).inflate(R.i.gll, null);
      ((TextView)((View)localObject).findViewById(R.h.footer_txt)).setText(str);
      getContentLV().addFooterView((View)localObject);
    }
    AppMethodBeat.o(253067);
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
        if (this.afiI.add(localObject)) {
          this.KOt.bqG(localObject);
        }
        paramInt1 += 1;
      }
      aNr();
      jyE().notifyDataSetChanged();
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
    }, null, y.b.adEJ);
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
    paramBundle = this.afiI.iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      this.KOt.bqG(str);
    }
    this.KOt.setOnContactDeselectListener(new MultiSelectContactView.c()
    {
      public final void ad(int paramAnonymousInt, String paramAnonymousString)
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
    aNr();
    AppMethodBeat.o(38051);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(253093);
    super.onDestroy();
    e.xfd.a("SnsPublishProcess", "atPageStaytime_", Long.valueOf(getActivityBrowseTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
    AppMethodBeat.o(253093);
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