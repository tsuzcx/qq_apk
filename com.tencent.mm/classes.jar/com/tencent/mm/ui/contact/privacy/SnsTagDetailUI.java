package com.tencent.mm.ui.contact.privacy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends ContactMgrUIBase
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange
{
  protected long Qtd;
  protected String Rya;
  protected List<String> aflq;
  protected String md5;
  protected int scene;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(253306);
    this.aflq = new ArrayList();
    this.Rya = "";
    this.md5 = "";
    this.scene = 0;
    AppMethodBeat.o(253306);
  }
  
  private boolean e(boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(253337);
    Object localObject2 = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if (localObject2 == null)
    {
      AppMethodBeat.o(253337);
      return false;
    }
    paramIntent = al.hgp();
    Object localObject1 = z.bAM();
    Log.i("MicroMsg.SnsTagDetailUI", "noSeeHimDataOp , before memBerList: %s, tagList : %s, md5: %s.", new Object[] { localObject2, this.xtu, this.md5 });
    String str;
    if (paramBoolean)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if ((!Util.isNullOrNil(str)) && (d.rs(paramIntent.JE(str).field_type)) && (!((String)localObject1).equals(str)) && (!this.xtu.contains(str))) {
          this.xtu.add(str);
        }
      }
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if ((!Util.isNullOrNil(str)) && (d.rs(paramIntent.JE(str).field_type)) && (!((String)localObject1).equals(str)) && (this.xtu.contains(str))) {
        this.xtu.remove(str);
      }
    }
    if (((this.Rya + " " + Util.listToString(this.xtu, ",")).equals(this.md5)) && (this.Qtd != 0L))
    {
      AppMethodBeat.o(253337);
      return false;
    }
    this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
    if (paramBoolean)
    {
      this.afkM = true;
      paramIntent = new x(3, this.Qtd, this.Rya, this.xtu.size(), this.xtu, this.scene);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramIntent, 0);
      localObject1 = getContext();
      getString(R.l.app_tip);
      if (!paramBoolean) {
        break label484;
      }
    }
    label484:
    for (int i = R.l.gqh;; i = R.l.gql)
    {
      this.tipDialog = k.a((Context)localObject1, getString(i), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(253385);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(paramIntent);
          SnsTagDetailUI.a(SnsTagDetailUI.this);
          SnsTagDetailUI.this.jzE();
          AppMethodBeat.o(253385);
        }
      });
      AppMethodBeat.o(253337);
      return true;
      this.afkN = true;
      break;
    }
  }
  
  private boolean f(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(253352);
    paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(253352);
      return false;
    }
    Object localObject1 = z.bAM();
    Object localObject2 = al.hgp();
    if (paramBoolean)
    {
      localObject3 = paramIntent.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if ((!Util.isNullOrNil((String)localObject4)) && (d.rs(((bx)localObject2).JE((String)localObject4).field_type)) && (!((String)localObject1).equals(localObject4)) && (!this.xtu.contains(localObject4))) {
          this.xtu.add(localObject4);
        }
      }
    }
    Object localObject3 = paramIntent.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if ((!Util.isNullOrNil((String)localObject4)) && (d.rs(((bx)localObject2).JE((String)localObject4).field_type)) && (!((String)localObject1).equals(localObject4)) && (this.xtu.contains(localObject4))) {
        this.xtu.remove(localObject4);
      }
    }
    localObject1 = this.Rya + " " + Util.listToString(this.xtu, ",");
    if ((((String)localObject1).equals(this.md5)) && (this.Qtd != 0L))
    {
      AppMethodBeat.o(253352);
      return false;
    }
    this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
    Log.i("MicroMsg.SnsTagDetailUI", "noSeeHimDataOp , md5: %s, tagList : %s, newMd5: %s, add : %s, memBerList: %s..", new Object[] { this.md5, this.xtu, localObject1, Boolean.valueOf(paramBoolean), paramIntent });
    localObject3 = hom();
    localObject1 = new LinkedList();
    localObject2 = new LinkedList();
    Object localObject4 = ((List)localObject3).iterator();
    String str;
    while (((Iterator)localObject4).hasNext())
    {
      str = (String)((Iterator)localObject4).next();
      if (!this.xtu.contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject4 = this.xtu.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      str = (String)((Iterator)localObject4).next();
      if (!((List)localObject3).contains(str)) {
        ((List)localObject2).add(str);
      }
    }
    if (paramBoolean)
    {
      this.afkM = true;
      this.afkP.jzH();
    }
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ab.J((String)((Iterator)localObject3).next(), false);
      }
      this.afkN = true;
      this.afkP.jzI();
    }
    localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ab.J((String)((Iterator)localObject3).next(), true);
    }
    jzA();
    Log.i("MicroMsg.SnsTagDetailUI", "noSeeHimDataOp  memBerList: %s, tagList : %s, md5: %s， delContact： %s, addContact: %s.", new Object[] { paramIntent, this.xtu, this.md5, localObject1, localObject2 });
    AppMethodBeat.o(253352);
    return true;
  }
  
  private static List<String> hol()
  {
    AppMethodBeat.i(253324);
    new LinkedList();
    List localList = com.tencent.mm.pluginsdk.platformtools.a.iIX();
    AppMethodBeat.o(253324);
    return localList;
  }
  
  private List<String> hom()
  {
    AppMethodBeat.i(253329);
    LinkedList localLinkedList = new LinkedList();
    if (this.Qtd == 4L)
    {
      localObject = hol();
      AppMethodBeat.o(253329);
      return localObject;
    }
    ac localac = al.hgI().vl(this.Qtd);
    Object localObject = localac;
    if (localac == null) {
      localObject = new ac();
    }
    if ((((ac)localObject).field_memberList != null) && (!((ac)localObject).field_memberList.equals(""))) {}
    for (localObject = Util.stringsToList(((ac)localObject).field_memberList.split(","));; localObject = localLinkedList)
    {
      AppMethodBeat.o(253329);
      return localObject;
    }
  }
  
  private void jzK()
  {
    AppMethodBeat.i(253318);
    if (this.Qtd == 5L)
    {
      this.aflq.clear();
      com.tencent.mm.kernel.h.baF();
      String str1 = Util.nullAs((String)com.tencent.mm.kernel.h.baE().ban().d(2, null), "");
      bh.bCz();
      Object localObject = com.tencent.mm.model.c.bzA().h("@sns.unlike.android", "", null);
      while (((Cursor)localObject).moveToNext())
      {
        String str2 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        this.aflq.add(str2);
      }
      ((Cursor)localObject).close();
      Log.i("MicroMsg.SnsTagDetailUI", "initTagList before localContactTagList: %s, tagList : %s.", new Object[] { this.aflq, this.xtu });
      int i = 0;
      while (i < this.aflq.size())
      {
        localObject = (String)this.aflq.get(i);
        if ((!this.xtu.contains(localObject)) && (!Util.isNullOrNil((String)localObject)))
        {
          bh.bCz();
          ab.z(com.tencent.mm.model.c.bzA().JE((String)localObject));
          Log.i("MicroMsg.SnsTagDetailUI", "initTagList tag no container db tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      i = 0;
      while (i < this.xtu.size())
      {
        localObject = (String)this.xtu.get(i);
        if ((!Util.isNullOrNil((String)localObject)) && (!this.aflq.contains(localObject)))
        {
          bh.bCz();
          ab.y(com.tencent.mm.model.c.bzA().JE((String)localObject));
          Log.i("MicroMsg.SnsTagDetailUI", "initTagList db no container tag tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      if (this.xtu.contains(str1))
      {
        this.xtu.remove(str1);
        bh.bCz();
        ab.z(com.tencent.mm.model.c.bzA().JE(str1));
      }
      this.afkJ.clear();
      this.afkJ.addAll(this.xtu);
    }
    Log.i("MicroMsg.SnsTagDetailUI", "initTagList after localContactTagList: %s, tagList : %s, orginTagList: %s.", new Object[] { this.aflq, this.xtu, this.afkJ });
    AppMethodBeat.o(253318);
  }
  
  private void jzL()
  {
    AppMethodBeat.i(253364);
    Log.i("MicroMsg.SnsTagDetailUI", "updateSuccessData , 1, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.xtu, Boolean.valueOf(this.afkN), Boolean.valueOf(this.afkM) });
    if ((this.afkN) && (this.afkM)) {
      Log.i("MicroMsg.SnsTagDetailUI", "updateSuccessData , error happen.");
    }
    bx localbx = al.hgp();
    String str1 = z.bAM();
    if (this.Qtd == 5L)
    {
      Object localObject1;
      Object localObject2;
      if (this.afkN)
      {
        this.afkN = false;
        localObject1 = this.afkJ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((!Util.isNullOrNil((String)localObject2)) && (d.rs(localbx.JE((String)localObject2).field_type)) && (!str1.equals(localObject2)) && (!this.xtu.contains(localObject2)))
          {
            bh.bCz();
            ab.z(com.tencent.mm.model.c.bzA().JE((String)localObject2));
          }
        }
      }
      if (this.afkM)
      {
        this.afkM = false;
        localObject1 = new ArrayList();
        localObject2 = this.xtu.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str2 = (String)((Iterator)localObject2).next();
          if ((!Util.isNullOrNil(str2)) && (d.rs(localbx.JE(str2).field_type)) && (!str1.equals(str2)) && (!this.afkJ.contains(str2)))
          {
            ((ArrayList)localObject1).add(str2);
            bh.bCz();
            ab.y(com.tencent.mm.model.c.bzA().JE(str2));
          }
        }
      }
      this.afkJ.clear();
      this.afkJ.addAll(this.xtu);
      this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
    }
    Log.i("MicroMsg.SnsTagDetailUI", "updateSuccessData , 2, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.xtu, Boolean.valueOf(this.afkN), Boolean.valueOf(this.afkM) });
    jzA();
    AppMethodBeat.o(253364);
  }
  
  private void jzM()
  {
    AppMethodBeat.i(253375);
    Log.i("MicroMsg.SnsTagDetailUI", "revertFailData , 1, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.xtu, Boolean.valueOf(this.afkN), Boolean.valueOf(this.afkM) });
    if ((this.afkN) && (this.afkM)) {
      Log.i("MicroMsg.SnsTagDetailUI", "revertFailData , error happen.");
    }
    bx localbx = al.hgp();
    String str1 = z.bAM();
    if (this.Qtd == 5L)
    {
      Object localObject1;
      Object localObject2;
      if (this.afkN)
      {
        this.afkN = false;
        localObject1 = this.afkJ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((!Util.isNullOrNil((String)localObject2)) && (d.rs(localbx.JE((String)localObject2).field_type)) && (!str1.equals(localObject2)) && (!this.xtu.contains(localObject2))) {
            this.xtu.add(localObject2);
          }
        }
      }
      if (this.afkM)
      {
        this.afkM = false;
        localObject1 = new ArrayList();
        localObject2 = this.xtu.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str2 = (String)((Iterator)localObject2).next();
          if ((!Util.isNullOrNil(str2)) && (d.rs(localbx.JE(str2).field_type)) && (!str1.equals(str2)) && (!this.afkJ.contains(str2))) {
            ((ArrayList)localObject1).add(str2);
          }
        }
        this.xtu.removeAll((Collection)localObject1);
      }
      this.afkJ.clear();
      this.afkJ.addAll(this.xtu);
      this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
    }
    Log.i("MicroMsg.SnsTagDetailUI", "revertFailData , 2, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.xtu, Boolean.valueOf(this.afkN), Boolean.valueOf(this.afkM) });
    jzz();
    AppMethodBeat.o(253375);
  }
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(253419);
    paramo = new a(paramo);
    AppMethodBeat.o(253419);
    return paramo;
  }
  
  public final void aDz(int paramInt)
  {
    AppMethodBeat.i(253429);
    Object localObject = this.afkK.aDt(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(253429);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    if (this.afkK.gZe())
    {
      this.afkK.bCa((String)localObject);
      if (this.afkK.JXy.size() > 0)
      {
        this.pYm.setText(getString(R.l.gqk) + "(" + this.afkK.JXy.size() + ")");
        this.pYm.setEnabled(true);
        AppMethodBeat.o(253429);
        return;
      }
      this.pYm.setText(getString(R.l.gqk));
      this.pYm.setEnabled(false);
      AppMethodBeat.o(253429);
      return;
    }
    if (au.bwp((String)localObject))
    {
      localObject = new Intent(getContext(), AddressUI.class);
      ((Intent)localObject).putExtra("Contact_GroupFilter_Type", "@biz.contact");
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/privacy/SnsTagDetailUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/privacy/SnsTagDetailUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253429);
      return;
    }
    Intent localIntent = new Intent();
    if (this.Qtd == 4L) {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
    }
    for (;;)
    {
      localIntent.putExtra("Contact_User", (String)localObject);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        com.tencent.mm.br.c.b(getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      }
      AppMethodBeat.o(253429);
      return;
      if (this.Qtd == 5L) {
        localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
      }
    }
  }
  
  protected final void aMl()
  {
    AppMethodBeat.i(253442);
    if ((this.afkK != null) && (this.afkK.getContactCount() > 0))
    {
      setMMTitle(this.Rya + "(" + this.afkK.getContactCount() + ")");
      AppMethodBeat.o(253442);
      return;
    }
    setMMTitle(this.Rya);
    AppMethodBeat.o(253442);
  }
  
  public final void ck(Intent paramIntent)
  {
    AppMethodBeat.i(253467);
    if (this.Qtd == 4L)
    {
      f(true, paramIntent);
      AppMethodBeat.o(253467);
      return;
    }
    if (this.Qtd == 5L) {
      e(true, paramIntent);
    }
    AppMethodBeat.o(253467);
  }
  
  public final void cl(Intent paramIntent)
  {
    AppMethodBeat.i(253471);
    if (this.Qtd == 4L)
    {
      f(false, paramIntent);
      AppMethodBeat.o(253471);
      return;
    }
    if (this.Qtd == 5L) {
      e(false, paramIntent);
    }
    AppMethodBeat.o(253471);
  }
  
  protected final void jzC()
  {
    AppMethodBeat.i(253476);
    if (this.Qtd == 4L)
    {
      this.afkP.dismiss();
      jzD();
    }
    AppMethodBeat.o(253476);
  }
  
  protected final void jzw()
  {
    AppMethodBeat.i(253481);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    if (this.Qtd == 4L) {
      localIntent.putExtra("filter_type", "@sns.black.android");
    }
    for (;;)
    {
      cm(localIntent);
      localIntent.putExtra("titile", getResources().getString(R.l.gRF));
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(253481);
      return;
      if (this.Qtd == 5L) {
        localIntent.putExtra("filter_type", "@sns.unlike.android");
      }
    }
  }
  
  protected final void jzx()
  {
    AppMethodBeat.i(253486);
    String str = Util.listToString(this.xtu, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.gRC));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("KBlockOpenImFav", true);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.w.affo);
    localIntent.putExtra("always_select_contact", str);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("show_too_many_member", false);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    com.tencent.mm.br.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
    AppMethodBeat.o(253486);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253405);
    this.Qtd = getIntent().getLongExtra("k_sns_tag_id", 0L);
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(290, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(293, this);
    if (al.hgI().hlo().size() == 0)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.sns.model.w(1), 0);
    }
    Log.i("MicroMsg.SnsTagDetailUI", "onCreate snsTagId: %s, scene : %s.", new Object[] { Long.valueOf(this.Qtd), Integer.valueOf(this.scene) });
    if (this.Qtd == 4L)
    {
      this.Rya = getString(R.l.gRU);
      if (this.Qtd != 4L) {
        break label426;
      }
      this.afkL = getString(R.l.gRM);
    }
    for (;;)
    {
      if (this.Qtd != 0L) {
        break label451;
      }
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.Rya = Util.nullAs(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = al.hgp();
      String str1 = z.bAM();
      localObject = Util.stringsToList(((String)localObject).split(","));
      if (localObject == null) {
        break label459;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!Util.isNullOrNil(str2)) && (!this.xtu.contains(str2)) && (d.rs(paramBundle.JE(str2).field_type)) && (!str1.equals(str2))) {
          this.xtu.add(str2);
        }
      }
      if (this.Qtd == 5L)
      {
        this.Rya = getString(R.l.gRT);
        break;
      }
      this.Rya = al.hgI().vl(this.Qtd).field_tagName;
      break;
      label426:
      if (this.Qtd == 5L) {
        this.afkL = getString(R.l.gRN);
      }
    }
    label451:
    this.xtu = hom();
    label459:
    jzK();
    if ((this.Rya == null) || (this.Rya.equals("")))
    {
      this.Rya = getString(b.j.sns_tag_name_unknow);
      this.Rya = ap.aYw(getString(b.j.sns_tag_name_unknow));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(253389);
        SnsTagDetailUI.this.finish();
        AppMethodBeat.o(253389);
        return false;
      }
    });
    if (this.Qtd == 0L) {
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
      jzz();
      AppMethodBeat.o(253405);
      return;
      enableOptionMenu(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(253410);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.afkP.dismiss();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(290, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(291, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(292, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(293, this);
    super.onDestroy();
    AppMethodBeat.o(253410);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(253461);
    Log.i("MicroMsg.SnsTagDetailUI", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if ((this.Qtd == 4L) && (paramInt == 4)) {
      jzA();
    }
    if ((this.Qtd == 5L) && (paramInt == 4)) {
      jzA();
    }
    AppMethodBeat.o(253461);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(253437);
    super.onResume();
    AppMethodBeat.o(253437);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(253454);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(253454);
      return;
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      this.afkP.dismiss();
      if ((paramp instanceof x))
      {
        Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd 1, md5: %s, tagList : %s.", new Object[] { this.md5, this.xtu });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
          jzL();
          jzD();
        }
        for (;;)
        {
          Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd 2, md5: %s, tagList : %s.", new Object[] { this.md5, this.xtu });
          AppMethodBeat.o(253454);
          return;
          jzM();
          jzE();
        }
        finish();
        AppMethodBeat.o(253454);
        return;
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        this.afkP.dismiss();
        Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd update form net 1, md5: %s, tagList : %s.", new Object[] { this.md5, this.xtu });
        paramString = (com.tencent.mm.plugin.sns.model.w)paramp;
        paramp = new ArrayList();
        if (!Util.isNullOrNil(paramString.uO(this.Qtd)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.uO(this.Qtd).size())
          {
            String str = (String)paramString.uO(this.Qtd).get(paramInt1);
            if (str != null) {
              paramp.add(str);
            }
            paramInt1 += 1;
          }
        }
        new LinkedList();
        paramString = this.xtu;
        this.xtu = hom();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramp = (String)paramString.next();
            if (!this.xtu.contains(paramp)) {
              this.xtu.add(paramp);
            }
          }
        }
        jzK();
        this.md5 = (this.Rya + " " + Util.listToString(this.xtu, ","));
        jzA();
        Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd update form net 2, md5: %s, tagList : %s.", new Object[] { this.md5, this.xtu });
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
    
    public final String jzy()
    {
      if (SnsTagDetailUI.this.Qtd == 4L) {
        return "@sns.black.android";
      }
      if (SnsTagDetailUI.this.Qtd == 5L) {
        return "@sns.unlike.android";
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.SnsTagDetailUI
 * JD-Core Version:    0.7.0.1
 */