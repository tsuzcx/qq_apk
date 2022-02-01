package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FinderBlockListUI
  extends ContactMgrUIBase
{
  private static int Aox = 20;
  private String TTU;
  private LinkedList<FinderContact> XyE;
  private Set<q> XyF;
  private TextView XyG;
  private int type;
  private com.tencent.mm.plugin.finder.storage.aj zAg;
  
  public FinderBlockListUI()
  {
    AppMethodBeat.i(279149);
    this.type = 0;
    this.zAg = null;
    this.XyF = new HashSet();
    AppMethodBeat.o(279149);
  }
  
  private void hVK()
  {
    AppMethodBeat.i(279157);
    this.TTU = getResources().getString(this.zAg.dRw());
    setMMTitle(this.TTU);
    if (this.kGU != null)
    {
      this.kGU.setText(this.zAg.dRy());
      localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      com.tencent.mm.plugin.finder.utils.aj.a(this.kGU, new SpannableString(this.zAg.dRy()));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(286306);
        FinderBlockListUI.this.finish();
        AppMethodBeat.o(286306);
        return false;
      }
    });
    this.XyE = this.zAg.dRB();
    this.unc.clear();
    Object localObject = com.tencent.mm.pluginsdk.j.a.hhV();
    int i = 0;
    while (i < this.XyE.size())
    {
      FinderContact localFinderContact = (FinderContact)this.XyE.get(i);
      if ((localFinderContact != null) && (!((List)localObject).contains(localFinderContact.username))) {
        this.unc.add(localFinderContact.username);
      }
      i += 1;
    }
    AppMethodBeat.o(279157);
  }
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(279154);
    paramo = new a(paramo);
    AppMethodBeat.o(279154);
    return paramo;
  }
  
  public final void awS(int paramInt)
  {
    AppMethodBeat.i(279156);
    Object localObject = this.Xyt.awM(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(279156);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    com.tencent.mm.by.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(279156);
  }
  
  public final void bH(Intent paramIntent)
  {
    AppMethodBeat.i(279163);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(279163);
      return;
    }
    paramIntent = Util.stringsToList(paramIntent.split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(279163);
      return;
    }
    this.XyF.clear();
    int k = com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    int j = 0;
    while (j < paramIntent.size())
    {
      Object localObject = new ArrayList();
      int i = 0;
      while ((j < paramIntent.size()) && (i < k))
      {
        ((List)localObject).add(paramIntent.get(j));
        j += 1;
        i += 1;
      }
      localObject = this.zAg.eM((List)localObject);
      this.XyF.add(localObject);
    }
    this.Xyw = true;
    this.Xyz.aT(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278317);
        Iterator localIterator = FinderBlockListUI.a(FinderBlockListUI.this).iterator();
        while (localIterator.hasNext())
        {
          q localq = (q)localIterator.next();
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(localq);
        }
        AppMethodBeat.o(278317);
      }
    });
    AppMethodBeat.o(279163);
  }
  
  public final void bI(final Intent paramIntent)
  {
    AppMethodBeat.i(279164);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(279164);
      return;
    }
    paramIntent = Util.stringsToList(paramIntent.split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(279164);
      return;
    }
    this.Xyz.b(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(286686);
        ArrayList localArrayList = new ArrayList();
        FinderBlockListUI.this.Xyx = true;
        Iterator localIterator = paramIntent.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if (!Util.isNullOrNil((String)localObject))
          {
            bh.beI();
            localObject = com.tencent.mm.model.c.bbL().RG((String)localObject);
            FinderContact localFinderContact = new FinderContact();
            localFinderContact.username = ((ax)localObject).field_username;
            localFinderContact.coverImgUrl = ((ax)localObject).hDr;
            localArrayList.add(localFinderContact);
          }
        }
        FinderBlockListUI.a(FinderBlockListUI.this, FinderBlockListUI.b(FinderBlockListUI.this).eL(localArrayList));
        AppMethodBeat.o(286686);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(291962);
        Iterator localIterator = FinderBlockListUI.a(FinderBlockListUI.this).iterator();
        while (localIterator.hasNext())
        {
          q localq = (q)localIterator.next();
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(localq);
        }
        AppMethodBeat.o(291962);
      }
    });
    AppMethodBeat.o(279164);
  }
  
  public int getLayoutId()
  {
    return R.i.ejW;
  }
  
  protected final void hVA()
  {
    AppMethodBeat.i(279151);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    if (this.type == 2) {
      localIntent.putExtra("filter_type", "@finder.block.my.liked.android");
    }
    for (;;)
    {
      bJ(localIntent);
      localIntent.putExtra("titile", getResources().getString(R.l.ePd));
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(279151);
      return;
      if (this.type == 1) {
        localIntent.putExtra("filter_type", "@finder.block.his.liked.android");
      }
    }
  }
  
  protected final void hVB()
  {
    AppMethodBeat.i(279153);
    Log.i("MicroMsg.FinderBlockListUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectContactUI");
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("titile", getString(R.l.finder_mod_block_select_user));
    localIntent.putExtra("always_select_contact", Util.listToString(this.unc, ","));
    localIntent.putExtra("list_attr", w.XtK);
    localIntent.putExtra("block_contact", z.bcZ());
    localIntent.putExtra("max_limit_num", Aox);
    localIntent.putExtra("Forbid_SelectChatRoom", true);
    localIntent.putExtra("show_too_many_member", false);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    startActivityForResult(localIntent, 1);
    AppMethodBeat.o(279153);
  }
  
  protected final void hVG()
  {
    AppMethodBeat.i(279158);
    if ((this.Xyt != null) && (this.Xyt.getContactCount() == 0) && (this.XyG != null))
    {
      this.XyG.setVisibility(8);
      AppMethodBeat.o(279158);
      return;
    }
    this.XyG.setVisibility(0);
    AppMethodBeat.o(279158);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279150);
    this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
    if (this.type == 1)
    {
      this.zAg = new ab();
      if (this.zAg == null) {
        finish();
      }
      super.onCreate(paramBundle);
      this.XyG = ((TextView)findViewById(R.h.dXW));
      if (this.XyG != null)
      {
        this.XyG.setText(this.zAg.dRy());
        paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.a(this.XyG, new SpannableString(this.zAg.dRy()));
      }
      if (this.type != 1) {
        break label181;
      }
      this.Xyv = getString(R.l.ePf);
    }
    for (;;)
    {
      d.rE(39);
      hVK();
      hVD();
      AppMethodBeat.o(279150);
      return;
      if (this.type != 2) {
        break;
      }
      this.zAg = new ac();
      break;
      label181:
      if (this.type == 2) {
        this.Xyv = getString(R.l.ePe);
      }
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(279160);
    Log.i("MicroMsg.FinderBlockListUI", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if (paramInt == 4) {
      hVE();
    }
    AppMethodBeat.o(279160);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(279161);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    this.Xyz.dismiss();
    paramString = (com.tencent.mm.modelmulti.c)paramq;
    if (3990 == paramString.getType())
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label358;
      }
      Object localObject;
      if (paramString.op == 1)
      {
        if ((paramString.bnd() != null) && (paramString.bnd().RPN != null))
        {
          localObject = paramString.bnd().RPN.iterator();
          while (((Iterator)localObject).hasNext())
          {
            cyd localcyd = (cyd)((Iterator)localObject).next();
            if ((localcyd.TGC != null) && (!Util.isNullOrNil(localcyd.TGC.UserName)) && (!this.unc.contains(localcyd.TGC.UserName))) {
              this.unc.add(localcyd.TGC.UserName);
            }
          }
        }
        hVE();
      }
      if (paramString.op == 2)
      {
        if ((paramString.bnd() != null) && (paramString.bnd().RPN != null))
        {
          paramString = paramString.bnd().RPN.iterator();
          while (paramString.hasNext())
          {
            localObject = (cyd)paramString.next();
            if ((((cyd)localObject).TGC != null) && (!Util.isNullOrNil(((cyd)localObject).TGC.UserName)) && (this.unc.contains(((cyd)localObject).TGC.UserName))) {
              this.unc.remove(((cyd)localObject).TGC.UserName);
            }
          }
        }
        hVE();
      }
      if (this.XyF.contains(paramq))
      {
        this.XyF.remove(paramq);
        if (this.XyF.isEmpty()) {
          hVH();
        }
      }
    }
    for (;;)
    {
      hVE();
      label358:
      do
      {
        this.Xyw = false;
        this.Xyx = false;
        AppMethodBeat.o(279161);
        return;
      } while (!this.XyF.contains(paramq));
      this.XyF.remove(paramq);
      if (this.XyF.isEmpty()) {
        hVI();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(279159);
    if ((this.Xyt != null) && (this.Xyt.getContactCount() > 0))
    {
      setMMTitle(this.TTU + "(" + this.Xyt.getContactCount() + ")");
      AppMethodBeat.o(279159);
      return;
    }
    setMMTitle(this.TTU);
    AppMethodBeat.o(279159);
  }
  
  final class a
    extends ContactMgrUIBase.a
  {
    public a(o paramo)
    {
      super(paramo);
    }
    
    protected final com.tencent.mm.ui.contact.a.a dm(int paramInt, String paramString)
    {
      AppMethodBeat.i(270247);
      j localj = new j(paramInt);
      localj.header = paramString;
      AppMethodBeat.o(270247);
      return localj;
    }
    
    public final String hVC()
    {
      AppMethodBeat.i(270246);
      if (FinderBlockListUI.c(FinderBlockListUI.this) == 2)
      {
        AppMethodBeat.o(270246);
        return "@finder.block.my.liked.android";
      }
      if (FinderBlockListUI.c(FinderBlockListUI.this) == 1)
      {
        AppMethodBeat.o(270246);
        return "@finder.block.his.liked.android";
      }
      AppMethodBeat.o(270246);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.FinderBlockListUI
 * JD-Core Version:    0.7.0.1
 */