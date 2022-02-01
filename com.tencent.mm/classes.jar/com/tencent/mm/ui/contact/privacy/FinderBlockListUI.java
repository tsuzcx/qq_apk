package com.tencent.mm.ui.contact.privacy;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bx;
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
  private static int FON = 20;
  private ar ECo;
  private String abky;
  private LinkedList<FinderContact> afkU;
  private Set<p> afkV;
  private TextView afkW;
  private int type;
  
  public FinderBlockListUI()
  {
    AppMethodBeat.i(253407);
    this.type = 0;
    this.ECo = null;
    this.afkV = new HashSet();
    AppMethodBeat.o(253407);
  }
  
  private void jzG()
  {
    AppMethodBeat.i(253420);
    this.abky = getResources().getString(this.ECo.ePJ());
    setMMTitle(this.abky);
    if (this.njO != null)
    {
      this.njO.setText(this.ECo.gS(this));
      localObject = av.GiL;
      av.a(this.njO, new SpannableString(this.ECo.gS(this)));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(253355);
        FinderBlockListUI.this.finish();
        AppMethodBeat.o(253355);
        return false;
      }
    });
    this.afkU = this.ECo.ePM();
    this.xtu.clear();
    Object localObject = com.tencent.mm.pluginsdk.platformtools.a.iIW();
    int i = 0;
    while (i < this.afkU.size())
    {
      FinderContact localFinderContact = (FinderContact)this.afkU.get(i);
      if ((localFinderContact != null) && (!((List)localObject).contains(localFinderContact.username))) {
        this.xtu.add(localFinderContact.username);
      }
      i += 1;
    }
    AppMethodBeat.o(253420);
  }
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(253477);
    paramo = new a(paramo);
    AppMethodBeat.o(253477);
    return paramo;
  }
  
  public final void aDz(int paramInt)
  {
    AppMethodBeat.i(253480);
    Object localObject = this.afkK.aDt(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(253480);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    com.tencent.mm.br.c.b(this, "profile", ".ui.ContactInfoUI", localIntent);
    AppMethodBeat.o(253480);
  }
  
  protected final void aMl()
  {
    AppMethodBeat.i(253491);
    if ((this.afkK != null) && (this.afkK.getContactCount() > 0))
    {
      setMMTitle(this.abky + "(" + this.afkK.getContactCount() + ")");
      AppMethodBeat.o(253491);
      return;
    }
    setMMTitle(this.abky);
    AppMethodBeat.o(253491);
  }
  
  public final void ck(Intent paramIntent)
  {
    AppMethodBeat.i(253511);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(253511);
      return;
    }
    paramIntent = Util.stringsToList(paramIntent.split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(253511);
      return;
    }
    this.afkV.clear();
    int k = i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 30);
    int i = 0;
    while (i < paramIntent.size())
    {
      Object localObject = new ArrayList();
      int j = 0;
      while ((i < paramIntent.size()) && (j < k))
      {
        ((List)localObject).add((String)paramIntent.get(i));
        i += 1;
        j += 1;
      }
      localObject = this.ECo.hy((List)localObject);
      this.afkV.add(localObject);
    }
    this.afkM = true;
    this.afkP.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253353);
        Iterator localIterator = FinderBlockListUI.a(FinderBlockListUI.this).iterator();
        while (localIterator.hasNext())
        {
          p localp = (p)localIterator.next();
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(localp);
        }
        AppMethodBeat.o(253353);
      }
    });
    AppMethodBeat.o(253511);
  }
  
  public final void cl(final Intent paramIntent)
  {
    AppMethodBeat.i(253518);
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(253518);
      return;
    }
    paramIntent = Util.stringsToList(paramIntent.split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(253518);
      return;
    }
    this.afkP.b(new Runnable()new Runnable
    {
      public final void run()
      {
        AppMethodBeat.i(253359);
        ArrayList localArrayList = new ArrayList();
        FinderBlockListUI.this.afkN = true;
        Iterator localIterator = paramIntent.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if (!Util.isNullOrNil((String)localObject))
          {
            bh.bCz();
            localObject = com.tencent.mm.model.c.bzA().JE((String)localObject);
            FinderContact localFinderContact = new FinderContact();
            localFinderContact.username = ((az)localObject).field_username;
            localFinderContact.coverImgUrl = ((az)localObject).kam;
            localArrayList.add(localFinderContact);
          }
        }
        FinderBlockListUI.a(FinderBlockListUI.this, FinderBlockListUI.b(FinderBlockListUI.this).hx(localArrayList));
        AppMethodBeat.o(253359);
      }
    }, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253344);
        Iterator localIterator = FinderBlockListUI.a(FinderBlockListUI.this).iterator();
        while (localIterator.hasNext())
        {
          p localp = (p)localIterator.next();
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(localp);
        }
        AppMethodBeat.o(253344);
      }
    });
    AppMethodBeat.o(253518);
  }
  
  public int getLayoutId()
  {
    return R.i.gmZ;
  }
  
  protected final void jzC()
  {
    AppMethodBeat.i(253484);
    if ((this.afkK != null) && (this.afkK.getContactCount() == 0) && (this.afkW != null))
    {
      this.afkW.setVisibility(8);
      AppMethodBeat.o(253484);
      return;
    }
    this.afkW.setVisibility(0);
    AppMethodBeat.o(253484);
  }
  
  protected final void jzw()
  {
    AppMethodBeat.i(253464);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    if (this.type == 2) {
      localIntent.putExtra("filter_type", "@finder.block.my.liked.android");
    }
    for (;;)
    {
      cm(localIntent);
      localIntent.putExtra("titile", getResources().getString(R.l.gRF));
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(253464);
      return;
      if (this.type == 1) {
        localIntent.putExtra("filter_type", "@finder.block.his.liked.android");
      }
    }
  }
  
  protected final void jzx()
  {
    AppMethodBeat.i(253472);
    Log.i("MicroMsg.FinderBlockListUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectContactUI");
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("titile", getString(R.l.finder_mod_block_select_user));
    localIntent.putExtra("always_select_contact", Util.listToString(this.xtu, ","));
    localIntent.putExtra("list_attr", w.affo);
    localIntent.putExtra("block_contact", z.bAM());
    localIntent.putExtra("max_limit_num", FON);
    localIntent.putExtra("Forbid_SelectChatRoom", true);
    localIntent.putExtra("show_too_many_member", false);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    startActivityForResult(localIntent, 1);
    AppMethodBeat.o(253472);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253452);
    this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
    if (this.type == 1)
    {
      this.ECo = new ae();
      if (this.ECo == null) {
        finish();
      }
      super.onCreate(paramBundle);
      this.afkW = ((TextView)findViewById(R.h.gaC));
      if (this.afkW != null)
      {
        this.afkW.setText(this.ECo.gS(this));
        paramBundle = av.GiL;
        av.a(this.afkW, new SpannableString(this.ECo.gS(this)));
      }
      if (this.type != 1) {
        break label183;
      }
      this.afkL = getString(R.l.gRH);
    }
    for (;;)
    {
      d.rG(39);
      jzG();
      jzz();
      AppMethodBeat.o(253452);
      return;
      if (this.type != 2) {
        break;
      }
      this.ECo = new af();
      break;
      label183:
      if (this.type == 2) {
        this.afkL = getString(R.l.gRG);
      }
    }
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(253496);
    Log.i("MicroMsg.FinderBlockListUI", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if (paramInt == 4) {
      jzA();
    }
    AppMethodBeat.o(253496);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(253505);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    this.afkP.dismiss();
    paramString = (com.tencent.mm.modelmulti.h)paramp;
    if (3990 == paramString.getType())
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label358;
      }
      Object localObject;
      if (paramString.op == 1)
      {
        if ((paramString.bKO() != null) && (paramString.bKO().YNb != null))
        {
          localObject = paramString.bKO().YNb.iterator();
          while (((Iterator)localObject).hasNext())
          {
            dpj localdpj = (dpj)((Iterator)localObject).next();
            if ((localdpj.aaWj != null) && (!Util.isNullOrNil(localdpj.aaWj.UserName)) && (!this.xtu.contains(localdpj.aaWj.UserName))) {
              this.xtu.add(localdpj.aaWj.UserName);
            }
          }
        }
        jzA();
      }
      if (paramString.op == 2)
      {
        if ((paramString.bKO() != null) && (paramString.bKO().YNb != null))
        {
          paramString = paramString.bKO().YNb.iterator();
          while (paramString.hasNext())
          {
            localObject = (dpj)paramString.next();
            if ((((dpj)localObject).aaWj != null) && (!Util.isNullOrNil(((dpj)localObject).aaWj.UserName)) && (this.xtu.contains(((dpj)localObject).aaWj.UserName))) {
              this.xtu.remove(((dpj)localObject).aaWj.UserName);
            }
          }
        }
        jzA();
      }
      if (this.afkV.contains(paramp))
      {
        this.afkV.remove(paramp);
        if (this.afkV.isEmpty()) {
          jzD();
        }
      }
    }
    for (;;)
    {
      jzA();
      label358:
      do
      {
        this.afkM = false;
        this.afkN = false;
        AppMethodBeat.o(253505);
        return;
      } while (!this.afkV.contains(paramp));
      this.afkV.remove(paramp);
      if (this.afkV.isEmpty()) {
        jzE();
      }
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
    
    protected final com.tencent.mm.ui.contact.a.a cf(int paramInt, String paramString)
    {
      AppMethodBeat.i(253321);
      j localj = new j(paramInt);
      localj.header = paramString;
      AppMethodBeat.o(253321);
      return localj;
    }
    
    public final String jzy()
    {
      AppMethodBeat.i(253312);
      if (FinderBlockListUI.c(FinderBlockListUI.this) == 2)
      {
        AppMethodBeat.o(253312);
        return "@finder.block.my.liked.android";
      }
      if (FinderBlockListUI.c(FinderBlockListUI.this) == 1)
      {
        AppMethodBeat.o(253312);
        return "@finder.block.his.liked.android";
      }
      AppMethodBeat.o(253312);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.FinderBlockListUI
 * JD-Core Version:    0.7.0.1
 */