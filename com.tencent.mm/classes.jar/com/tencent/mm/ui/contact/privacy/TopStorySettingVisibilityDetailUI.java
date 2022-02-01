package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
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
  implements com.tencent.mm.an.i
{
  protected long JWc;
  protected String KXZ;
  protected List<String> MYc;
  private Set<com.tencent.mm.plugin.topstory.a.c.i> MYe;
  protected List<String> XyZ;
  protected Set<String> Xzc;
  protected String md5;
  
  public TopStorySettingVisibilityDetailUI()
  {
    AppMethodBeat.i(290153);
    this.MYc = new ArrayList();
    this.XyZ = new ArrayList();
    this.Xzc = new HashSet();
    this.KXZ = "";
    this.md5 = "";
    this.MYe = new HashSet();
    AppMethodBeat.o(290153);
  }
  
  private void a(com.tencent.mm.plugin.topstory.a.c.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(290172);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus");
    if ((parami == null) || (parami.MWw == null) || (parami.MWx == null))
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus， netScene is null.");
      AppMethodBeat.o(290172);
      return;
    }
    int i = 0;
    if (i < parami.MWw.size())
    {
      String str = (String)parami.MWw.get(i);
      if (!Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus，snsTagId is %s,  name is %s, .", new Object[] { Long.valueOf(this.JWc), str });
        if (this.JWc != 1L) {
          break label214;
        }
        if (((Integer)parami.MWx.get(i)).intValue() != 3) {
          break label167;
        }
        this.unc.remove(str);
        this.MYc.remove(str);
      }
      for (;;)
      {
        i += 1;
        break;
        label167:
        if (((Integer)parami.MWx.get(i)).intValue() == 4)
        {
          this.unc.add(str);
          this.MYc.add(str);
          continue;
          label214:
          if (this.JWc == 2L) {
            if (((Integer)parami.MWx.get(i)).intValue() == 1)
            {
              this.unc.remove(str);
              this.MYc.remove(str);
            }
            else if (((Integer)parami.MWx.get(i)).intValue() == 2)
            {
              this.unc.add(str);
              this.MYc.add(str);
            }
          }
        }
      }
    }
    hVR();
    hVE();
    if (paramBoolean) {
      hVI();
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus, snsTamd5gName: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.unc, this.MYc });
    AppMethodBeat.o(290172);
  }
  
  private void hVR()
  {
    AppMethodBeat.i(290167);
    this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
    if (this.JWc == 1L)
    {
      com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVO.clear();
      com.tencent.mm.plugin.topstory.a.b.a.gpQ().MVO.addAll(this.unc);
      com.tencent.mm.plugin.topstory.a.b.a.gpQ().gpS();
      AppMethodBeat.o(290167);
      return;
    }
    com.tencent.mm.plugin.topstory.a.b.a.gpQ().Lyy.clear();
    com.tencent.mm.plugin.topstory.a.b.a.gpQ().Lyy.addAll(this.unc);
    com.tencent.mm.plugin.topstory.a.b.a.gpQ().gpR();
    AppMethodBeat.o(290167);
  }
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(290158);
    paramo = new a(paramo);
    AppMethodBeat.o(290158);
    return paramo;
  }
  
  public final void awS(int paramInt)
  {
    AppMethodBeat.i(290160);
    Object localObject = this.Xyt.awM(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(290160);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    com.tencent.mm.by.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(290160);
  }
  
  public final void bH(Intent paramIntent)
  {
    AppMethodBeat.i(290163);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact.");
    String str1 = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact %s", new Object[] { str1 });
    Object localObject = Util.stringsToList(str1.split(","));
    if (localObject == null)
    {
      AppMethodBeat.o(290163);
      return;
    }
    String str2 = paramIntent.getStringExtra("App_MsgId");
    h.aHH();
    paramIntent = ((n)h.ae(n.class)).bbL();
    str1 = z.bcZ();
    if ((!Util.isNullOrNil(str2)) && (str2.equals("fromSns"))) {
      localObject = ((List)localObject).iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      str2 = (String)((Iterator)localObject).next();
      if ((!this.unc.contains(str2)) && (!str1.equals(str2)))
      {
        d.rk(paramIntent.RG(str2).field_type);
        this.unc.add(str2);
        continue;
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          str2 = (String)((Iterator)localObject).next();
          if ((!this.unc.contains(str2)) && (!str1.equals(str2)) && (d.rk(paramIntent.RG(str2).field_type))) {
            this.unc.add(str2);
          }
        }
      }
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact tagList = %s.", new Object[] { this.unc });
    this.Xyw = true;
    hVS();
    if (this.MYe.size() > 0) {
      this.Xyz.aT(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203416);
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onAddContact, cancel.");
          Iterator localIterator = TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            com.tencent.mm.plugin.topstory.a.c.i locali = (com.tencent.mm.plugin.topstory.a.c.i)localIterator.next();
            h.aHH();
            h.aHF().kcd.a(locali, 0);
            TopStorySettingVisibilityDetailUI localTopStorySettingVisibilityDetailUI = TopStorySettingVisibilityDetailUI.this;
            if (i == TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).size() - 1) {}
            for (boolean bool = true;; bool = false)
            {
              TopStorySettingVisibilityDetailUI.a(localTopStorySettingVisibilityDetailUI, locali, bool);
              i += 1;
              break;
            }
          }
          AppMethodBeat.o(203416);
        }
      });
    }
    AppMethodBeat.o(290163);
  }
  
  public final void bI(final Intent paramIntent)
  {
    AppMethodBeat.i(290164);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onRemoveContact %s", new Object[] { paramIntent });
    paramIntent = Util.stringsToList(paramIntent.split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(290164);
      return;
    }
    this.Xyz.b(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(265198);
        h.aHH();
        String str1 = Util.nullAs((String)h.aHG().aHp().b(2, null), "");
        int i = 0;
        while (i < paramIntent.size())
        {
          String str2 = (String)paramIntent.get(i);
          if ((!Util.isNullOrNil((String)paramIntent.get(i))) && (!str1.equals(paramIntent.get(i)))) {
            TopStorySettingVisibilityDetailUI.this.unc.remove(str2);
          }
          i += 1;
        }
        TopStorySettingVisibilityDetailUI.this.Xyx = true;
        TopStorySettingVisibilityDetailUI.this.hVS();
        AppMethodBeat.o(265198);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(291520);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onRemoveContact, cancel.");
        Iterator localIterator = TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          com.tencent.mm.plugin.topstory.a.c.i locali = (com.tencent.mm.plugin.topstory.a.c.i)localIterator.next();
          h.aHH();
          h.aHF().kcd.a(locali, 0);
          TopStorySettingVisibilityDetailUI localTopStorySettingVisibilityDetailUI = TopStorySettingVisibilityDetailUI.this;
          if (i == TopStorySettingVisibilityDetailUI.a(TopStorySettingVisibilityDetailUI.this).size() - 1) {}
          for (boolean bool = true;; bool = false)
          {
            TopStorySettingVisibilityDetailUI.a(localTopStorySettingVisibilityDetailUI, locali, bool);
            i += 1;
            break;
          }
        }
        AppMethodBeat.o(291520);
      }
    });
    AppMethodBeat.o(290164);
  }
  
  protected final void hVA()
  {
    AppMethodBeat.i(290155);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    localIntent.putExtra("titile", getResources().getString(R.l.ePd));
    if (this.JWc == 1L) {
      localIntent.putExtra("filter_type", "@tophistory.unlike.android");
    }
    for (;;)
    {
      bJ(localIntent);
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(290155);
      return;
      if (this.JWc == 2L) {
        localIntent.putExtra("filter_type", "@tophistory.black.android");
      }
    }
  }
  
  protected final void hVB()
  {
    AppMethodBeat.i(290156);
    String str = Util.listToString(this.unc, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.ePa));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("KBlockOpenImFav", true);
    localIntent.putExtra("show_too_many_member", false);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    localIntent.putExtra("list_attr", w.XtK);
    localIntent.putExtra("always_select_contact", str);
    if (this.JWc == 1L) {}
    for (int i = 1;; i = 2)
    {
      localIntent.putExtra("topstory_import_type", i);
      com.tencent.mm.by.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
      AppMethodBeat.o(290156);
      return;
    }
  }
  
  protected final void hVS()
  {
    AppMethodBeat.i(290168);
    Object localObject1 = this.KXZ + " " + Util.listToString(this.unc, ",");
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "writeNow newMd5 = %s, md5 = %s, origList = %s.", new Object[] { localObject1, this.md5, this.MYc });
    if ((((String)localObject1).equals(this.md5)) && (this.JWc != 0L))
    {
      AppMethodBeat.o(290168);
      return;
    }
    hVR();
    localObject1 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.unc.iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.MYc.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.JWc == 1L) {
          ((List)localObject2).add(Integer.valueOf(3));
        } else {
          ((List)localObject2).add(Integer.valueOf(1));
        }
      }
    }
    localObject3 = this.MYc.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if (!this.unc.contains(localObject4))
      {
        ((List)localObject1).add(localObject4);
        if (this.JWc == 1L) {
          ((List)localObject2).add(Integer.valueOf(4));
        } else {
          ((List)localObject2).add(Integer.valueOf(2));
        }
      }
    }
    this.MYe.clear();
    int j = 0;
    while (j < ((List)localObject1).size())
    {
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      int i = 0;
      while ((j < ((List)localObject1).size()) && (i < 50))
      {
        ((List)localObject3).add(((List)localObject1).get(j));
        ((List)localObject4).add(((List)localObject2).get(j));
        j += 1;
        i += 1;
      }
      localObject3 = new com.tencent.mm.plugin.topstory.a.c.i((List)localObject3, (List)localObject4);
      this.MYe.add(localObject3);
    }
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "batch doNetscene, size: %s", new Object[] { Integer.valueOf(this.MYe.size()) });
    this.MYc.clear();
    this.MYc.addAll(this.unc);
    if (this.MYe.size() == 0)
    {
      this.Xyz.dismiss();
      AppMethodBeat.o(290168);
      return;
    }
    localObject1 = this.MYe.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.topstory.a.c.i)((Iterator)localObject1).next();
      h.aHF().kcd.a((q)localObject2, 0);
    }
    AppMethodBeat.o(290168);
  }
  
  public void initView()
  {
    AppMethodBeat.i(290162);
    getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(236958);
        TopStorySettingVisibilityDetailUI.this.finish();
        AppMethodBeat.o(236958);
        return true;
      }
    });
    AppMethodBeat.o(290162);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(290154);
    this.JWc = getIntent().getIntExtra("k_topstory_type", 0);
    super.onCreate(paramBundle);
    if (this.JWc == 1L) {}
    Object localObject;
    for (this.KXZ = getString(R.l.ePo);; this.KXZ = getString(R.l.ePb))
    {
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, before md5: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.unc, this.MYc });
      paramBundle = getIntent().getStringExtra("k_topstory_user_list");
      if (Util.isNullOrNil(paramBundle)) {
        break;
      }
      this.MYc = Util.stringsToList(paramBundle.split(","));
      paramBundle = this.MYc.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (String)paramBundle.next();
        if ((!Util.isNullOrNil((String)localObject)) && (!this.unc.contains(localObject))) {
          this.unc.add(localObject);
        }
      }
    }
    this.XyZ.clear();
    h.aHH();
    paramBundle = Util.nullAs((String)h.aHG().aHp().b(2, null), "");
    String str;
    int i;
    if (this.JWc == 1L)
    {
      bh.beI();
      localObject = com.tencent.mm.model.c.bbL().f("@tophistory.unlike.android", "", null);
      while (((Cursor)localObject).moveToNext())
      {
        str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        this.XyZ.add(str);
      }
      ((Cursor)localObject).close();
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, localContactTagList: %s.", new Object[] { this.XyZ });
      i = 0;
      while (i < this.XyZ.size())
      {
        localObject = (String)this.XyZ.get(i);
        if ((!Util.isNullOrNil((String)localObject)) && (!this.unc.contains(localObject)))
        {
          bh.beI();
          ab.w(com.tencent.mm.model.c.bbL().RG((String)localObject));
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList tag no container db tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      i = 0;
      while (i < this.unc.size())
      {
        localObject = (String)this.unc.get(i);
        if (!Util.isNullOrNil((String)localObject))
        {
          bh.beI();
          ab.v(com.tencent.mm.model.c.bbL().RG((String)localObject));
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList db no container tag tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      if (this.unc.contains(paramBundle))
      {
        this.unc.remove(paramBundle);
        bh.beI();
        ab.w(com.tencent.mm.model.c.bbL().RG(paramBundle));
      }
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, after md5: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.unc, this.MYc });
      initView();
      h.aGY().a(2859, this);
      enableOptionMenu(false);
      this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
      if (this.JWc != 1L) {
        break label909;
      }
    }
    label909:
    for (this.Xyv = getString(R.l.ePm);; this.Xyv = getString(R.l.ePn))
    {
      hVD();
      AppMethodBeat.o(290154);
      return;
      if (this.JWc != 2L) {
        break;
      }
      bh.beI();
      localObject = com.tencent.mm.model.c.bbL().f("@tophistory.black.android", "", null);
      while (((Cursor)localObject).moveToNext())
      {
        str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        this.XyZ.add(str);
      }
      ((Cursor)localObject).close();
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "initBlackList, localContactTagList: %s.", new Object[] { this.XyZ });
      i = 0;
      while (i < this.XyZ.size())
      {
        localObject = (String)this.XyZ.get(i);
        if ((!Util.isNullOrNil((String)localObject)) && (!this.unc.contains(localObject)))
        {
          bh.beI();
          ab.u(com.tencent.mm.model.c.bbL().RG((String)localObject));
        }
        i += 1;
      }
      i = 0;
      while (i < this.unc.size())
      {
        localObject = (String)this.unc.get(i);
        if (!Util.isNullOrNil((String)localObject))
        {
          bh.beI();
          ab.t(com.tencent.mm.model.c.bbL().RG((String)localObject));
        }
        i += 1;
      }
      if (!this.unc.contains(paramBundle)) {
        break;
      }
      this.unc.remove(paramBundle);
      bh.beI();
      ab.u(com.tencent.mm.model.c.bbL().RG(paramBundle));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(290157);
    h.aGY().b(2859, this);
    super.onDestroy();
    AppMethodBeat.o(290157);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(290169);
    Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onNotifyChange, event: %s, stg: %s, obj: %s.", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
    if (paramInt == 4) {
      hVE();
    }
    AppMethodBeat.o(290169);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(290170);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    boolean bool;
    if ((paramq instanceof com.tencent.mm.plugin.topstory.a.c.i))
    {
      paramString = (com.tencent.mm.plugin.topstory.a.c.i)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool = true;
        if (!bool) {
          break label653;
        }
        paramInt1 = paramString.gpZ().BaseResponse.CqV;
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
        paramString.lXi += 1;
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd, netScene.retryTimes: %s.", new Object[] { Integer.valueOf(paramString.lXi) });
        if (paramString.lXi < 2)
        {
          com.tencent.mm.plugin.topstory.a.c.i locali = new com.tencent.mm.plugin.topstory.a.c.i(paramString);
          h.aHF().kcd.a(locali, 0);
          this.MYe.add(locali);
        }
      }
      else
      {
        label182:
        if (!this.MYe.contains(paramq)) {
          break label646;
        }
        this.MYe.remove(paramq);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd netSceneSet remove, size:%s", new Object[] { Integer.valueOf(this.MYe.size()) });
        if (!bool) {
          break label568;
        }
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseSuccessContactStatus");
        if (paramString == null) {
          break label568;
        }
        paramInt1 = 0;
        label254:
        if (paramInt1 >= paramString.MWw.size()) {
          break label532;
        }
        paramq = (String)paramString.MWw.get(paramInt1);
        if (!Util.isNullOrNil(paramq))
        {
          Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseSuccessContactStatus，snsTagId is %s,  name is %s, .", new Object[] { Long.valueOf(this.JWc), paramq });
          if (this.JWc != 1L) {
            break label449;
          }
          bh.beI();
          paramq = com.tencent.mm.model.c.bbL().RG(paramq);
          if (((Integer)paramString.MWx.get(paramInt1)).intValue() != 3) {
            break label421;
          }
          ab.v(paramq);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break label254;
        bool = false;
        break;
        a(paramString, true);
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "onSceneEnd, isAddingContact: %s, isRemovingContact: %s.", new Object[] { Boolean.valueOf(this.Xyw), Boolean.valueOf(this.Xyx) });
        break label182;
        label421:
        if (((Integer)paramString.MWx.get(paramInt1)).intValue() == 4)
        {
          ab.w(paramq);
          continue;
          label449:
          if (this.JWc == 2L)
          {
            bh.beI();
            paramq = com.tencent.mm.model.c.bbL().RG(paramq);
            if (((Integer)paramString.MWx.get(paramInt1)).intValue() == 1) {
              ab.t(paramq);
            } else if (((Integer)paramString.MWx.get(paramInt1)).intValue() == 2) {
              ab.u(paramq);
            }
          }
        }
      }
      label532:
      hVE();
      Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", "updateDataBaseFailContactStatus, snsTamd5gName: %s, tagList: %s, origList : %s.", new Object[] { this.md5, this.unc, this.MYc });
      label568:
      if (this.MYe.isEmpty())
      {
        Log.i("MicroMsg.TopStory.TopStorySettingVisibilityDetailUI", " onSceneEnd, isEmpty, isAddingContact: %s, isRemovingContact: %s, succ : %s.", new Object[] { Boolean.valueOf(this.Xyw), Boolean.valueOf(this.Xyx), Boolean.valueOf(bool) });
        this.Xyz.dismiss();
        this.Xyx = false;
        this.Xyw = false;
        if (bool) {
          hVH();
        }
      }
      AppMethodBeat.o(290170);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(290165);
    if ((this.Xyt != null) && (this.Xyt.getContactCount() > 0))
    {
      setMMTitle(this.KXZ + "(" + this.Xyt.getContactCount() + ")");
      AppMethodBeat.o(290165);
      return;
    }
    setMMTitle(this.KXZ);
    AppMethodBeat.o(290165);
  }
  
  final class a
    extends ContactMgrUIBase.a
  {
    public a(o paramo)
    {
      super(paramo);
    }
    
    public final String hVC()
    {
      if (TopStorySettingVisibilityDetailUI.this.JWc == 1L) {
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