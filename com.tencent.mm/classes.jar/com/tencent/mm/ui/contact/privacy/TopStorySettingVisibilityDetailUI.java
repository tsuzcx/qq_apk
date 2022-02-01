package com.tencent.mm.ui.contact.privacy;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.a.c.i;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class TopStorySettingVisibilityDetailUI
  extends ContactMgrUIBase
  implements com.tencent.mm.am.h
{
  protected long Qtd;
  protected String Rya;
  protected List<String> TKK;
  private Set<i> TKM;
  protected List<String> aflq;
  protected Set<String> aflt;
  protected String md5;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(253374);
    this.TKK = new ArrayList();
    this.aflq = new ArrayList();
    this.aflt = new HashSet();
    this.Rya = "";
    this.md5 = "";
    this.TKM = new HashSet();
    AppMethodBeat.o(253374);
  }
  
  private void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(253400);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus");
    if ((parami == null) || (parami.TJa == null) || (parami.TJb == null))
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus， netScene is null.");
      AppMethodBeat.o(253400);
      return;
    }
    int i = 0;
    if (i < parami.TJa.size())
    {
      String str = (String)parami.TJa.get(i);
      if (!Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus，snsTagId is %s,  name is %s, .", new Object[] { Long.valueOf(this.Qtd), str });
        if (this.Qtd != 1L) {
          break label214;
        }
        if (((Integer)parami.TJb.get(i)).intValue() != 3) {
          break label167;
        }
        this.xtu.remove(str);
        this.TKK.remove(str);
      }
      for (;;)
      {
        i += 1;
        break;
        label167:
        if (((Integer)parami.TJb.get(i)).intValue() == 4)
        {
          this.xtu.add(str);
          this.TKK.add(str);
          continue;
          label214:
          if (this.Qtd == 2L) {
            if (((Integer)parami.TJb.get(i)).intValue() == 1)
            {
              this.xtu.remove(str);
              this.TKK.remove(str);
            }
            else if (((Integer)parami.TJb.get(i)).intValue() == 2)
            {
              this.xtu.add(str);
              this.TKK.add(str);
            }
          }
        }
      }
    }
    jzN();
    jzA();
    if (paramBoolean) {
      jzE();
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus, snsTamd5gName: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.xtu, this.TKK });
    AppMethodBeat.o(253400);
  }
  
  private void jzN()
  {
    AppMethodBeat.i(253386);
    this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
    if (this.Qtd == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.hMM().TIs.clear();
      com.tencent.mm.plugin.topstory.a.b.a.hMM().TIs.addAll(this.xtu);
      com.tencent.mm.plugin.topstory.a.b.a.hMM().hMO();
      AppMethodBeat.o(253386);
      return;
    }
    com.tencent.mm.plugin.topstory.a.b.a.hMM().Dig.clear();
    com.tencent.mm.plugin.topstory.a.b.a.hMM().Dig.addAll(this.xtu);
    com.tencent.mm.plugin.topstory.a.b.a.hMM().hMN();
    AppMethodBeat.o(253386);
  }
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(253469);
    paramo = new a(paramo);
    AppMethodBeat.o(253469);
    return paramo;
  }
  
  public final void aDz(int paramInt)
  {
    AppMethodBeat.i(253475);
    Object localObject = this.afkK.aDt(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(253475);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(253475);
  }
  
  protected final void aMl()
  {
    AppMethodBeat.i(253498);
    if ((this.afkK != null) && (this.afkK.getContactCount() > 0))
    {
      setMMTitle(this.Rya + "(" + this.afkK.getContactCount() + ")");
      AppMethodBeat.o(253498);
      return;
    }
    setMMTitle(this.Rya);
    AppMethodBeat.o(253498);
  }
  
  public final void ck(Intent paramIntent)
  {
    AppMethodBeat.i(253488);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact.");
    String str1 = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact %s", new Object[] { str1 });
    if (str1 == null)
    {
      AppMethodBeat.o(253488);
      return;
    }
    Object localObject = Util.stringsToList(str1.split(","));
    if (localObject == null)
    {
      AppMethodBeat.o(253488);
      return;
    }
    String str2 = paramIntent.getStringExtra("App_MsgId");
    com.tencent.mm.kernel.h.baF();
    paramIntent = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
    str1 = z.bAM();
    if ((!Util.isNullOrNil(str2)) && (str2.equals("fromSns"))) {
      localObject = ((List)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      str2 = (String)((Iterator)localObject).next();
      if ((!this.xtu.contains(str2)) && (!str1.equals(str2)))
      {
        d.rs(paramIntent.JE(str2).field_type);
        this.xtu.add(str2);
        continue;
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str2 = (String)((Iterator)localObject).next();
          if ((!this.xtu.contains(str2)) && (!str1.equals(str2)) && (d.rs(paramIntent.JE(str2).field_type))) {
            this.xtu.add(str2);
          }
        }
      }
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact tagList = %s.", new Object[] { this.xtu });
    this.afkM = true;
    jzO();
    if (this.TKM.size() > 0) {
      this.afkP.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(253456);
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact, cancel.");
          Iterator localIterator = TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            i locali = (i)localIterator.next();
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(locali, 0);
            TopStorySettingVisibilityDetailUI localTopStorySettingVisibilityDetailUI = TopStorySettingVisibilityDetailUI.this;
            if (i == TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).size() - 1) {}
            for (boolean bool = true;; bool = false)
            {
              TopStorySettingVisibilityDetailUI.a(localTopStorySettingVisibilityDetailUI, locali, bool);
              i += 1;
              break;
            }
          }
          AppMethodBeat.o(253456);
        }
      });
    }
    AppMethodBeat.o(253488);
  }
  
  public final void cl(final Intent paramIntent)
  {
    AppMethodBeat.i(253494);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onRemoveContact %s", new Object[] { paramIntent });
    paramIntent = Util.stringsToList(paramIntent.split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(253494);
      return;
    }
    this.afkP.b(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(253443);
        com.tencent.mm.kernel.h.baF();
        String str1 = Util.nullAs((String)com.tencent.mm.kernel.h.baE().ban().d(2, null), "");
        int i = 0;
        while (i < paramIntent.size())
        {
          String str2 = (String)paramIntent.get(i);
          if ((!Util.isNullOrNil((String)paramIntent.get(i))) && (!str1.equals(paramIntent.get(i)))) {
            TopStorySettingVisibilityDetailUI.this.xtu.remove(str2);
          }
          i += 1;
        }
        TopStorySettingVisibilityDetailUI.this.afkN = true;
        TopStorySettingVisibilityDetailUI.this.jzO();
        AppMethodBeat.o(253443);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253453);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onRemoveContact, cancel.");
        Iterator localIterator = TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          i locali = (i)localIterator.next();
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(locali, 0);
          TopStorySettingVisibilityDetailUI localTopStorySettingVisibilityDetailUI = TopStorySettingVisibilityDetailUI.this;
          if (i == TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).size() - 1) {}
          for (boolean bool = true;; bool = false)
          {
            TopStorySettingVisibilityDetailUI.a(localTopStorySettingVisibilityDetailUI, locali, bool);
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(253453);
      }
    });
    AppMethodBeat.o(253494);
  }
  
  public void initView()
  {
    AppMethodBeat.i(253479);
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(253450);
        TopStorySettingVisibilityDetailUI.this.finish();
        AppMethodBeat.o(253450);
        return true;
      }
    });
    AppMethodBeat.o(253479);
  }
  
  protected final void jzO()
  {
    AppMethodBeat.i(253509);
    Object localObject1 = this.Rya + " " + Util.listToString(this.xtu, ",");
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "writeNow newMd5 = %s, md5 = %s, origList = %s.", new Object[] { localObject1, this.md5, this.TKK });
    if ((((String)localObject1).equals(this.md5)) && (this.Qtd != 0L))
    {
      AppMethodBeat.o(253509);
      return;
    }
    jzN();
    localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.xtu.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.TKK.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.Qtd == 1L) {
          ((List)localObject2).add(Integer.valueOf(3));
        } else {
          ((List)localObject2).add(Integer.valueOf(1));
        }
      }
    }
    localObject3 = this.TKK.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.xtu.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.Qtd == 1L) {
          ((List)localObject2).add(Integer.valueOf(4));
        } else {
          ((List)localObject2).add(Integer.valueOf(2));
        }
      }
    }
    this.TKM.clear();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      int j = 0;
      while ((i < ((List)localObject1).size()) && (j < 50))
      {
        ((List)localObject3).add((String)((List)localObject1).get(i));
        ((List)localObject4).add((Integer)((List)localObject2).get(i));
        i += 1;
        j += 1;
      }
      localObject3 = new i((List)localObject3, (List)localObject4);
      this.TKM.add(localObject3);
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.TKM.size()) });
    this.TKK.clear();
    this.TKK.addAll(this.xtu);
    if (this.TKM.size() == 0)
    {
      this.afkP.dismiss();
      AppMethodBeat.o(253509);
      return;
    }
    localObject1 = this.TKM.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (i)((Iterator)localObject1).next();
      com.tencent.mm.kernel.h.baD().mCm.a((p)localObject2, 0);
    }
    AppMethodBeat.o(253509);
  }
  
  protected final void jzw()
  {
    AppMethodBeat.i(253449);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    localIntent.putExtra("titile", getResources().getString(R.l.gRF));
    if (this.Qtd == 1L) {
      localIntent.putExtra("filter_type", "@tophistory.unlike.android");
    }
    for (;;)
    {
      cm(localIntent);
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(253449);
      return;
      if (this.Qtd == 2L) {
        localIntent.putExtra("filter_type", "@tophistory.black.android");
      }
    }
  }
  
  protected final void jzx()
  {
    AppMethodBeat.i(253459);
    String str = Util.listToString(this.xtu, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.gRC));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("KBlockOpenImFav", true);
    localIntent.putExtra("show_too_many_member", false);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    localIntent.putExtra("list_attr", w.affo);
    localIntent.putExtra("always_select_contact", str);
    if (this.Qtd == 1L) {}
    for (int i = 1;; i = 2)
    {
      localIntent.putExtra("topstory_import_type", i);
      com.tencent.mm.br.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
      AppMethodBeat.o(253459);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253440);
    this.Qtd = getIntent().getIntExtra("k_topstory_type", 0);
    super.onCreate(paramBundle);
    if (this.Qtd == 1L) {}
    Object localObject;
    for (this.Rya = getString(R.l.gRQ);; this.Rya = getString(R.l.gRD))
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, before md5: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.xtu, this.TKK });
      paramBundle = getIntent().getStringExtra("k_topstory_user_list");
      if (Util.isNullOrNil(paramBundle)) {
        break;
      }
      this.TKK = Util.stringsToList(paramBundle.split(","));
      paramBundle = this.TKK.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (String)paramBundle.next();
        if ((!Util.isNullOrNil((String)localObject)) && (!this.xtu.contains(localObject))) {
          this.xtu.add(localObject);
        }
      }
    }
    this.aflq.clear();
    com.tencent.mm.kernel.h.baF();
    paramBundle = Util.nullAs((String)com.tencent.mm.kernel.h.baE().ban().d(2, null), "");
    String str;
    int i;
    if (this.Qtd == 1L)
    {
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzA().h("@tophistory.unlike.android", "", null);
      while (((Cursor)localObject).moveToNext())
      {
        str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        this.aflq.add(str);
      }
      ((Cursor)localObject).close();
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, localContactTagList: %s.", new Object[] { this.aflq });
      i = 0;
      while (i < this.aflq.size())
      {
        localObject = (String)this.aflq.get(i);
        if ((!Util.isNullOrNil((String)localObject)) && (!this.xtu.contains(localObject)))
        {
          bh.bCz();
          ab.x(com.tencent.mm.model.c.bzA().JE((String)localObject));
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList tag no container db tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      i = 0;
      while (i < this.xtu.size())
      {
        localObject = (String)this.xtu.get(i);
        if (!Util.isNullOrNil((String)localObject))
        {
          bh.bCz();
          ab.w(com.tencent.mm.model.c.bzA().JE((String)localObject));
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList db no container tag tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      if (this.xtu.contains(paramBundle))
      {
        this.xtu.remove(paramBundle);
        bh.bCz();
        ab.x(com.tencent.mm.model.c.bzA().JE(paramBundle));
      }
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, after md5: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.xtu, this.TKK });
      initView();
      com.tencent.mm.kernel.h.aZW().a(2859, this);
      enableOptionMenu(false);
      this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
      if (this.Qtd != 1L) {
        break label909;
      }
    }
    label909:
    for (this.afkL = getString(R.l.gRO);; this.afkL = getString(R.l.gRP))
    {
      jzz();
      AppMethodBeat.o(253440);
      return;
      if (this.Qtd != 2L) {
        break;
      }
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzA().h("@tophistory.black.android", "", null);
      while (((Cursor)localObject).moveToNext())
      {
        str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        this.aflq.add(str);
      }
      ((Cursor)localObject).close();
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, localContactTagList: %s.", new Object[] { this.aflq });
      i = 0;
      while (i < this.aflq.size())
      {
        localObject = (String)this.aflq.get(i);
        if ((!Util.isNullOrNil((String)localObject)) && (!this.xtu.contains(localObject)))
        {
          bh.bCz();
          ab.v(com.tencent.mm.model.c.bzA().JE((String)localObject));
        }
        i += 1;
      }
      i = 0;
      while (i < this.xtu.size())
      {
        localObject = (String)this.xtu.get(i);
        if (!Util.isNullOrNil((String)localObject))
        {
          bh.bCz();
          ab.u(com.tencent.mm.model.c.bzA().JE((String)localObject));
        }
        i += 1;
      }
      if (!this.xtu.contains(paramBundle)) {
        break;
      }
      this.xtu.remove(paramBundle);
      bh.bCz();
      ab.v(com.tencent.mm.model.c.bzA().JE(paramBundle));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(253462);
    com.tencent.mm.kernel.h.aZW().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(253462);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(253514);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onNotifyChange, event: %s, stg: %s, obj: %s.", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
    if (paramInt == 4) {
      jzA();
    }
    AppMethodBeat.o(253514);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(253522);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    boolean bool;
    if ((paramp instanceof i))
    {
      paramString = (i)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool = true;
        if (!bool) {
          break label653;
        }
        paramInt1 = paramString.hMV().BaseResponse.Idd;
        if (paramInt1 == 0) {
          break label653;
        }
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd ret:%s", new Object[] { Integer.valueOf(paramInt1) });
        bool = false;
      }
    }
    label646:
    label653:
    for (;;)
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd succ:%s", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramString.oQk += 1;
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd, netScene.retryTimes: %s.", new Object[] { Integer.valueOf(paramString.oQk) });
        if (paramString.oQk < 2)
        {
          i locali = new i(paramString);
          com.tencent.mm.kernel.h.baD().mCm.a(locali, 0);
          this.TKM.add(locali);
        }
      }
      else
      {
        label182:
        if (!this.TKM.contains(paramp)) {
          break label646;
        }
        this.TKM.remove(paramp);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.TKM.size()) });
        if (!bool) {
          break label568;
        }
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseSuccessContactStatus");
        if (paramString == null) {
          break label568;
        }
        paramInt1 = 0;
        label254:
        if (paramInt1 >= paramString.TJa.size()) {
          break label532;
        }
        paramp = (String)paramString.TJa.get(paramInt1);
        if (!Util.isNullOrNil(paramp))
        {
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseSuccessContactStatus，snsTagId is %s,  name is %s, .", new Object[] { Long.valueOf(this.Qtd), paramp });
          if (this.Qtd != 1L) {
            break label449;
          }
          bh.bCz();
          paramp = com.tencent.mm.model.c.bzA().JE(paramp);
          if (((Integer)paramString.TJb.get(paramInt1)).intValue() != 3) {
            break label421;
          }
          ab.w(paramp);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break label254;
        bool = false;
        break;
        a(paramString, true);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd, isAddingContact: %s, isRemovingContact: %s.", new Object[] { Boolean.valueOf(this.afkM), Boolean.valueOf(this.afkN) });
        break label182;
        label421:
        if (((Integer)paramString.TJb.get(paramInt1)).intValue() == 4)
        {
          ab.x(paramp);
          continue;
          label449:
          if (this.Qtd == 2L)
          {
            bh.bCz();
            paramp = com.tencent.mm.model.c.bzA().JE(paramp);
            if (((Integer)paramString.TJb.get(paramInt1)).intValue() == 1) {
              ab.u(paramp);
            } else if (((Integer)paramString.TJb.get(paramInt1)).intValue() == 2) {
              ab.v(paramp);
            }
          }
        }
      }
      label532:
      jzA();
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus, snsTamd5gName: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.xtu, this.TKK });
      label568:
      if (this.TKM.isEmpty())
      {
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", " onSceneEnd, isEmpty, isAddingContact: %s, isRemovingContact: %s, succ : %s.", new Object[] { Boolean.valueOf(this.afkM), Boolean.valueOf(this.afkN), Boolean.valueOf(bool) });
        this.afkP.dismiss();
        this.afkN = false;
        this.afkM = false;
        if (bool) {
          jzD();
        }
      }
      AppMethodBeat.o(253522);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends ContactMgrUIBase.a
  {
    public a(o paramo)
    {
      super(paramo);
    }
    
    public final String jzy()
    {
      if (TopStorySettingVisibilityDetailUI.this.Qtd == 1L) {
        return "@tophistory.unlike.android";
      }
      return "@tophistory.black.android";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.TopStorySettingVisibilityDetailUI
 * JD-Core Version:    0.7.0.1
 */