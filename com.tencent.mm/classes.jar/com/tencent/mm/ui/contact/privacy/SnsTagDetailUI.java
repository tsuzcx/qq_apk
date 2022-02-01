package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI
  extends ContactMgrUIBase
  implements i, MStorageEx.IOnStorageChange
{
  protected long JWc;
  protected String KXZ;
  protected List<String> XyZ;
  protected String md5;
  protected int scene;
  
  public SnsTagDetailUI()
  {
    AppMethodBeat.i(215786);
    this.XyZ = new ArrayList();
    this.KXZ = "";
    this.md5 = "";
    this.scene = 0;
    AppMethodBeat.o(215786);
  }
  
  private boolean e(boolean paramBoolean, final Intent paramIntent)
  {
    AppMethodBeat.i(215818);
    Object localObject2 = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if (localObject2 == null)
    {
      AppMethodBeat.o(215818);
      return false;
    }
    paramIntent = aj.fOw();
    Object localObject1 = z.bcZ();
    Log.i("MicroMsg.SnsTagDetailUI", "noSeeHimDataOp , before memBerList: %s, tagList : %s, md5: %s.", new Object[] { localObject2, this.unc, this.md5 });
    String str;
    if (paramBoolean)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if ((d.rk(paramIntent.RG(str).field_type)) && (!((String)localObject1).equals(str)) && (!this.unc.contains(str))) {
          this.unc.add(str);
        }
      }
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if ((d.rk(paramIntent.RG(str).field_type)) && (!((String)localObject1).equals(str)) && (this.unc.contains(str))) {
        this.unc.remove(str);
      }
    }
    if (((this.KXZ + " " + Util.listToString(this.unc, ",")).equals(this.md5)) && (this.JWc != 0L))
    {
      AppMethodBeat.o(215818);
      return false;
    }
    this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
    if (paramBoolean)
    {
      this.Xyw = true;
      paramIntent = new x(3, this.JWc, this.KXZ, this.unc.size(), this.unc, this.scene);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent, 0);
      localObject1 = getContext();
      getString(R.l.app_tip);
      if (!paramBoolean) {
        break label468;
      }
    }
    label468:
    for (int i = R.l.eng;; i = R.l.enk)
    {
      this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject1, getString(i), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(277247);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent);
          SnsTagDetailUI.a(SnsTagDetailUI.this);
          SnsTagDetailUI.this.hVI();
          AppMethodBeat.o(277247);
        }
      });
      AppMethodBeat.o(215818);
      return true;
      this.Xyx = true;
      break;
    }
  }
  
  private boolean f(boolean paramBoolean, Intent paramIntent)
  {
    AppMethodBeat.i(215821);
    paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if (paramIntent == null)
    {
      AppMethodBeat.o(215821);
      return false;
    }
    Object localObject1 = z.bcZ();
    Object localObject2 = aj.fOw();
    if (paramBoolean)
    {
      localObject3 = paramIntent.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if ((d.rk(((bv)localObject2).RG((String)localObject4).field_type)) && (!((String)localObject1).equals(localObject4)) && (!this.unc.contains(localObject4))) {
          this.unc.add(localObject4);
        }
      }
    }
    Object localObject3 = paramIntent.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      if ((d.rk(((bv)localObject2).RG((String)localObject4).field_type)) && (!((String)localObject1).equals(localObject4)) && (this.unc.contains(localObject4))) {
        this.unc.remove(localObject4);
      }
    }
    localObject1 = this.KXZ + " " + Util.listToString(this.unc, ",");
    if ((((String)localObject1).equals(this.md5)) && (this.JWc != 0L))
    {
      AppMethodBeat.o(215821);
      return false;
    }
    this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
    Log.i("MicroMsg.SnsTagDetailUI", "noSeeHimDataOp , md5: %s, tagList : %s, newMd5: %s, add : %s, memBerList: %s..", new Object[] { this.md5, this.unc, localObject1, Boolean.valueOf(paramBoolean), paramIntent });
    localObject3 = fVY();
    localObject1 = new LinkedList();
    localObject2 = new LinkedList();
    Object localObject4 = ((List)localObject3).iterator();
    String str;
    while (((Iterator)localObject4).hasNext())
    {
      str = (String)((Iterator)localObject4).next();
      if (!this.unc.contains(str)) {
        ((List)localObject1).add(str);
      }
    }
    localObject4 = this.unc.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      str = (String)((Iterator)localObject4).next();
      if (!((List)localObject3).contains(str)) {
        ((List)localObject2).add(str);
      }
    }
    if (paramBoolean)
    {
      this.Xyw = true;
      this.Xyz.hVL();
    }
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ab.F((String)((Iterator)localObject3).next(), false);
      }
      this.Xyx = true;
      this.Xyz.hVM();
    }
    localObject3 = ((List)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ab.F((String)((Iterator)localObject3).next(), true);
    }
    hVE();
    Log.i("MicroMsg.SnsTagDetailUI", "noSeeHimDataOp  memBerList: %s, tagList : %s, md5: %s， delContact： %s, addContact: %s.", new Object[] { paramIntent, this.unc, this.md5, localObject1, localObject2 });
    AppMethodBeat.o(215821);
    return true;
  }
  
  private static List<String> fVX()
  {
    AppMethodBeat.i(215803);
    new LinkedList();
    List localList = com.tencent.mm.pluginsdk.j.a.hhW();
    AppMethodBeat.o(215803);
    return localList;
  }
  
  private List<String> fVY()
  {
    AppMethodBeat.i(215806);
    LinkedList localLinkedList = new LinkedList();
    if (this.JWc == 4L)
    {
      localObject = fVX();
      AppMethodBeat.o(215806);
      return localObject;
    }
    com.tencent.mm.plugin.sns.storage.s locals = aj.fOO().Rf(this.JWc);
    Object localObject = localLinkedList;
    if (locals.field_memberList != null)
    {
      localObject = localLinkedList;
      if (!locals.field_memberList.equals("")) {
        localObject = Util.stringsToList(locals.field_memberList.split(","));
      }
    }
    AppMethodBeat.o(215806);
    return localObject;
  }
  
  private void hVO()
  {
    AppMethodBeat.i(215791);
    if (this.JWc == 5L)
    {
      this.XyZ.clear();
      com.tencent.mm.kernel.h.aHH();
      String str1 = Util.nullAs((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null), "");
      bh.beI();
      Object localObject = com.tencent.mm.model.c.bbL().f("@sns.unlike.android", "", null);
      while (((Cursor)localObject).moveToNext())
      {
        String str2 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        this.XyZ.add(str2);
      }
      ((Cursor)localObject).close();
      Log.i("MicroMsg.SnsTagDetailUI", "initTagList before localContactTagList: %s, tagList : %s.", new Object[] { this.XyZ, this.unc });
      int i = 0;
      while (i < this.XyZ.size())
      {
        localObject = (String)this.XyZ.get(i);
        if ((!this.unc.contains(localObject)) && (!Util.isNullOrNil((String)localObject)))
        {
          bh.beI();
          ab.y(com.tencent.mm.model.c.bbL().RG((String)localObject));
          Log.i("MicroMsg.SnsTagDetailUI", "initTagList tag no container db tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      i = 0;
      while (i < this.unc.size())
      {
        localObject = (String)this.unc.get(i);
        if ((!Util.isNullOrNil((String)localObject)) && (!this.XyZ.contains(localObject)))
        {
          bh.beI();
          ab.x(com.tencent.mm.model.c.bbL().RG((String)localObject));
          Log.i("MicroMsg.SnsTagDetailUI", "initTagList db no container tag tagName: %s", new Object[] { localObject });
        }
        i += 1;
      }
      if (this.unc.contains(str1))
      {
        this.unc.remove(str1);
        bh.beI();
        ab.y(com.tencent.mm.model.c.bbL().RG(str1));
      }
      this.Xys.clear();
      this.Xys.addAll(this.unc);
    }
    Log.i("MicroMsg.SnsTagDetailUI", "initTagList after localContactTagList: %s, tagList : %s, orginTagList: %s.", new Object[] { this.XyZ, this.unc, this.Xys });
    AppMethodBeat.o(215791);
  }
  
  private void hVP()
  {
    AppMethodBeat.i(215824);
    Log.i("MicroMsg.SnsTagDetailUI", "updateSuccessData , 1, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.unc, Boolean.valueOf(this.Xyx), Boolean.valueOf(this.Xyw) });
    if ((this.Xyx) && (this.Xyw)) {
      Log.i("MicroMsg.SnsTagDetailUI", "updateSuccessData , error happen.");
    }
    bv localbv = aj.fOw();
    String str1 = z.bcZ();
    if (this.JWc == 5L)
    {
      Object localObject1;
      Object localObject2;
      if (this.Xyx)
      {
        this.Xyx = false;
        localObject1 = this.Xys.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((d.rk(localbv.RG((String)localObject2).field_type)) && (!str1.equals(localObject2)) && (!this.unc.contains(localObject2)))
          {
            bh.beI();
            ab.y(com.tencent.mm.model.c.bbL().RG((String)localObject2));
          }
        }
      }
      if (this.Xyw)
      {
        this.Xyw = false;
        localObject1 = new ArrayList();
        localObject2 = this.unc.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str2 = (String)((Iterator)localObject2).next();
          if ((d.rk(localbv.RG(str2).field_type)) && (!str1.equals(str2)) && (!this.Xys.contains(str2)))
          {
            ((ArrayList)localObject1).add(str2);
            bh.beI();
            ab.x(com.tencent.mm.model.c.bbL().RG(str2));
          }
        }
      }
      this.Xys.clear();
      this.Xys.addAll(this.unc);
      this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
    }
    Log.i("MicroMsg.SnsTagDetailUI", "updateSuccessData , 2, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.unc, Boolean.valueOf(this.Xyx), Boolean.valueOf(this.Xyw) });
    hVE();
    AppMethodBeat.o(215824);
  }
  
  private void hVQ()
  {
    AppMethodBeat.i(215825);
    Log.i("MicroMsg.SnsTagDetailUI", "revertFailData , 1, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.unc, Boolean.valueOf(this.Xyx), Boolean.valueOf(this.Xyw) });
    if ((this.Xyx) && (this.Xyw)) {
      Log.i("MicroMsg.SnsTagDetailUI", "revertFailData , error happen.");
    }
    bv localbv = aj.fOw();
    String str1 = z.bcZ();
    if (this.JWc == 5L)
    {
      Object localObject1;
      Object localObject2;
      if (this.Xyx)
      {
        this.Xyx = false;
        localObject1 = this.Xys.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((d.rk(localbv.RG((String)localObject2).field_type)) && (!str1.equals(localObject2)) && (!this.unc.contains(localObject2))) {
            this.unc.add(localObject2);
          }
        }
      }
      if (this.Xyw)
      {
        this.Xyw = false;
        localObject1 = new ArrayList();
        localObject2 = this.unc.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str2 = (String)((Iterator)localObject2).next();
          if ((d.rk(localbv.RG(str2).field_type)) && (!str1.equals(str2)) && (!this.Xys.contains(str2))) {
            ((ArrayList)localObject1).add(str2);
          }
        }
        this.unc.removeAll((Collection)localObject1);
      }
      this.Xys.clear();
      this.Xys.addAll(this.unc);
      this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
    }
    Log.i("MicroMsg.SnsTagDetailUI", "revertFailData , 2, md5: %s, tagList : %s, isRemovingContact: %s, isAddingContact: %s.", new Object[] { this.md5, this.unc, Boolean.valueOf(this.Xyx), Boolean.valueOf(this.Xyw) });
    hVD();
    AppMethodBeat.o(215825);
  }
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(215795);
    paramo = new a(paramo);
    AppMethodBeat.o(215795);
    return paramo;
  }
  
  public final void awS(int paramInt)
  {
    AppMethodBeat.i(215797);
    Object localObject = this.Xyt.awM(paramInt);
    if ((localObject == null) || (!(localObject instanceof com.tencent.mm.ui.contact.a.f)))
    {
      AppMethodBeat.o(215797);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.f)localObject).username;
    if (this.Xyt.fJk())
    {
      this.Xyt.bAh((String)localObject);
      if (this.Xyt.Eec.size() > 0)
      {
        this.nbe.setText(getString(R.l.enj) + "(" + this.Xyt.Eec.size() + ")");
        this.nbe.setEnabled(true);
        AppMethodBeat.o(215797);
        return;
      }
      this.nbe.setText(getString(R.l.enj));
      this.nbe.setEnabled(false);
      AppMethodBeat.o(215797);
      return;
    }
    if (ab.QL((String)localObject))
    {
      localObject = new Intent(getContext(), AddressUI.class);
      ((Intent)localObject).putExtra("Contact_GroupFilter_Type", "@biz.contact");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/contact/privacy/SnsTagDetailUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/privacy/SnsTagDetailUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(215797);
      return;
    }
    Intent localIntent = new Intent();
    if (this.JWc == 4L) {
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 18);
    }
    for (;;)
    {
      localIntent.putExtra("Contact_User", (String)localObject);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        com.tencent.mm.by.c.b(getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      }
      AppMethodBeat.o(215797);
      return;
      if (this.JWc == 5L) {
        localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 19);
      }
    }
  }
  
  public final void bH(Intent paramIntent)
  {
    AppMethodBeat.i(215811);
    if (this.JWc == 4L)
    {
      f(true, paramIntent);
      AppMethodBeat.o(215811);
      return;
    }
    if (this.JWc == 5L) {
      e(true, paramIntent);
    }
    AppMethodBeat.o(215811);
  }
  
  public final void bI(Intent paramIntent)
  {
    AppMethodBeat.i(215813);
    if (this.JWc == 4L)
    {
      f(false, paramIntent);
      AppMethodBeat.o(215813);
      return;
    }
    if (this.JWc == 5L) {
      e(false, paramIntent);
    }
    AppMethodBeat.o(215813);
  }
  
  protected final void hVA()
  {
    AppMethodBeat.i(215826);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    if (this.JWc == 4L) {
      localIntent.putExtra("filter_type", "@sns.black.android");
    }
    for (;;)
    {
      bJ(localIntent);
      localIntent.putExtra("titile", getResources().getString(R.l.ePd));
      startActivityForResult(localIntent, 2);
      AppMethodBeat.o(215826);
      return;
      if (this.JWc == 5L) {
        localIntent.putExtra("filter_type", "@sns.unlike.android");
      }
    }
  }
  
  protected final void hVB()
  {
    AppMethodBeat.i(215827);
    String str = Util.listToString(this.unc, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.ePa));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("KBlockOpenImFav", true);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.w.XtK);
    localIntent.putExtra("always_select_contact", str);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("filter_type", "@all.contact.without.chatroom.without.openim");
    com.tencent.mm.by.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
    AppMethodBeat.o(215827);
  }
  
  protected final void hVG()
  {
    AppMethodBeat.i(215815);
    if (this.JWc == 4L)
    {
      this.Xyz.dismiss();
      hVH();
    }
    AppMethodBeat.o(215815);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215790);
    this.JWc = getIntent().getLongExtra("k_sns_tag_id", 0L);
    this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(290, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(291, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(293, this);
    if (aj.fOO().fTb().size() == 0)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.sns.model.w(1), 0);
    }
    Log.i("MicroMsg.SnsTagDetailUI", "onCreate snsTagId: %s, scene : %s.", new Object[] { Long.valueOf(this.JWc), Integer.valueOf(this.scene) });
    if (this.JWc == 4L)
    {
      this.KXZ = getString(R.l.ePs);
      if (this.JWc != 4L) {
        break label418;
      }
      this.Xyv = getString(R.l.ePk);
    }
    for (;;)
    {
      if (this.JWc != 0L) {
        break label443;
      }
      Object localObject = getIntent().getStringExtra("k_sns_tag_list");
      this.KXZ = Util.nullAs(getIntent().getStringExtra("k_sns_tag_name"), "");
      paramBundle = aj.fOw();
      String str1 = z.bcZ();
      localObject = Util.stringsToList(((String)localObject).split(","));
      if (localObject == null) {
        break label451;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if ((!this.unc.contains(str2)) && (d.rk(paramBundle.RG(str2).field_type)) && (!str1.equals(str2))) {
          this.unc.add(str2);
        }
      }
      if (this.JWc == 5L)
      {
        this.KXZ = getString(R.l.ePr);
        break;
      }
      this.KXZ = aj.fOO().Rf(this.JWc).field_tagName;
      break;
      label418:
      if (this.JWc == 5L) {
        this.Xyv = getString(R.l.ePl);
      }
    }
    label443:
    this.unc = fVY();
    label451:
    hVO();
    if ((this.KXZ == null) || (this.KXZ.equals("")))
    {
      this.KXZ = getString(i.j.sns_tag_name_unknow);
      this.KXZ = an.bag(getString(i.j.sns_tag_name_unknow));
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(287292);
        SnsTagDetailUI.this.finish();
        AppMethodBeat.o(287292);
        return false;
      }
    });
    if (this.JWc == 0L) {
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
      hVD();
      AppMethodBeat.o(215790);
      return;
      enableOptionMenu(false);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(215793);
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    this.Xyz.dismiss();
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(290, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(291, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(292, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(293, this);
    super.onDestroy();
    AppMethodBeat.o(215793);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(215809);
    Log.i("MicroMsg.SnsTagDetailUI", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if ((this.JWc == 4L) && (paramInt == 4)) {
      hVE();
    }
    if ((this.JWc == 5L) && (paramInt == 4)) {
      hVE();
    }
    AppMethodBeat.o(215809);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(215799);
    super.onResume();
    AppMethodBeat.o(215799);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(215802);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215802);
      return;
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      this.Xyz.dismiss();
      if ((paramq instanceof x))
      {
        Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd 1, md5: %s, tagList : %s.", new Object[] { this.md5, this.unc });
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
          hVP();
          hVH();
        }
        for (;;)
        {
          Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd 2, md5: %s, tagList : %s.", new Object[] { this.md5, this.unc });
          AppMethodBeat.o(215802);
          return;
          hVQ();
          hVI();
        }
        finish();
        AppMethodBeat.o(215802);
        return;
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        this.Xyz.dismiss();
        Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd update form net 1, md5: %s, tagList : %s.", new Object[] { this.md5, this.unc });
        paramString = (com.tencent.mm.plugin.sns.model.w)paramq;
        paramq = new ArrayList();
        if (!Util.isNullOrNil(paramString.QI(this.JWc)))
        {
          paramInt1 = 0;
          while (paramInt1 < paramString.QI(this.JWc).size())
          {
            String str = (String)paramString.QI(this.JWc).get(paramInt1);
            if (str != null) {
              paramq.add(str);
            }
            paramInt1 += 1;
          }
        }
        new LinkedList();
        paramString = this.unc;
        this.unc = fVY();
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            paramq = (String)paramString.next();
            if (!this.unc.contains(paramq)) {
              this.unc.add(paramq);
            }
          }
        }
        hVO();
        this.md5 = (this.KXZ + " " + Util.listToString(this.unc, ","));
        hVE();
        Log.i("MicroMsg.SnsTagDetailUI", "onSceneEnd update form net 2, md5: %s, tagList : %s.", new Object[] { this.md5, this.unc });
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
    AppMethodBeat.i(215801);
    if ((this.Xyt != null) && (this.Xyt.getContactCount() > 0))
    {
      setMMTitle(this.KXZ + "(" + this.Xyt.getContactCount() + ")");
      AppMethodBeat.o(215801);
      return;
    }
    setMMTitle(this.KXZ);
    AppMethodBeat.o(215801);
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
      if (SnsTagDetailUI.this.JWc == 4L) {
        return "@sns.black.android";
      }
      if (SnsTagDetailUI.this.JWc == 5L) {
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