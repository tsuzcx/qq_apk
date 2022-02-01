package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.List;

public class ContactMgrOnlyChatUI
  extends ContactMgrUIBase
  implements o
{
  private String abky;
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(253395);
    paramo = new a(paramo);
    AppMethodBeat.o(253395);
    return paramo;
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void aDz(int paramInt)
  {
    AppMethodBeat.i(253408);
    Object localObject = this.afkK.aDt(paramInt);
    if ((localObject == null) || (!(localObject instanceof f)))
    {
      AppMethodBeat.o(253408);
      return;
    }
    localObject = ((f)localObject).username;
    if (this.afkK.gZe())
    {
      this.afkK.bCa((String)localObject);
      if (this.afkK.JXy.size() > 0)
      {
        this.pYm.setText(getString(R.l.gqk) + "(" + this.afkK.JXy.size() + ")");
        this.pYm.setEnabled(true);
        AppMethodBeat.o(253408);
        return;
      }
      this.pYm.setText(getString(R.l.gqk));
      this.pYm.setEnabled(false);
      AppMethodBeat.o(253408);
      return;
    }
    if (au.bwp((String)localObject))
    {
      localObject = new Intent(getContext(), AddressUI.class);
      ((Intent)localObject).putExtra("Contact_GroupFilter_Type", "@biz.contact");
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/privacy/ContactMgrOnlyChatUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/privacy/ContactMgrOnlyChatUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(253408);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    localIntent.putExtra("Contact_Scene", 3);
    localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 4);
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      com.tencent.mm.br.c.b(getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    }
    AppMethodBeat.o(253408);
  }
  
  protected final void aMl()
  {
    AppMethodBeat.i(253358);
    if ((this.afkK != null) && (this.afkK.getContactCount() > 0))
    {
      setMMTitle(this.abky + "(" + this.afkK.getContactCount() + ")");
      AppMethodBeat.o(253358);
      return;
    }
    setMMTitle(this.abky);
    AppMethodBeat.o(253358);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void ck(Intent paramIntent)
  {
    AppMethodBeat.i(253348);
    paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if ((paramIntent == null) || (paramIntent.isEmpty()))
    {
      AppMethodBeat.o(253348);
      return;
    }
    Log.i("MicroMsg.ContactMgrOnlyChatUI", "onAddContact , memBerList: %s, tagList : %s.", new Object[] { paramIntent, this.xtu });
    paramIntent = new com.tencent.mm.modelmulti.h(paramIntent, 8388608, 1, this.JXM);
    com.tencent.mm.kernel.h.baD().mCm.a(paramIntent, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(R.l.app_tip);
    this.tipDialog = k.a(localAppCompatActivity, getString(R.l.gqh), true, new ContactMgrOnlyChatUI.1(this, paramIntent));
    AppMethodBeat.o(253348);
  }
  
  public final void cl(Intent paramIntent)
  {
    AppMethodBeat.i(253367);
    paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if ((paramIntent == null) || (paramIntent.isEmpty()))
    {
      AppMethodBeat.o(253367);
      return;
    }
    Log.i("MicroMsg.ContactMgrOnlyChatUI", "onAddContact , memBerList: %s, tagList : %s.", new Object[] { paramIntent, this.xtu });
    paramIntent = new com.tencent.mm.modelmulti.h(paramIntent, 8388608, 2, this.JXM);
    com.tencent.mm.kernel.h.baD().mCm.a(paramIntent, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(R.l.app_tip);
    this.tipDialog = k.a(localAppCompatActivity, getString(R.l.gql), true, new ContactMgrOnlyChatUI.2(this, paramIntent));
    AppMethodBeat.o(253367);
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    return R.i.gmX;
  }
  
  public final CharSequence jzv()
  {
    AppMethodBeat.i(253301);
    String str = getResources().getString(R.l.gqc);
    AppMethodBeat.o(253301);
    return str;
  }
  
  protected final void jzw()
  {
    AppMethodBeat.i(253319);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    localIntent.putExtra("filter_type", "@social.black.android");
    localIntent.putExtra("titile", getResources().getString(R.l.gRF));
    cm(localIntent);
    startActivityForResult(localIntent, 2);
    AppMethodBeat.o(253319);
  }
  
  protected final void jzx()
  {
    AppMethodBeat.i(253326);
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.gRC));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("KBlockOpenImFav", true);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("show_too_many_member", false);
    int i = com.tencent.mm.ui.contact.w.R(new int[] { com.tencent.mm.ui.contact.w.R(new int[] { com.tencent.mm.ui.contact.w.affo, 536870912 }), 131072 });
    localIntent.putExtra("max_limit_num", this.afgD);
    String str = Util.listToString(this.xtu, ",");
    localIntent.putExtra("list_attr", i);
    localIntent.putExtra("always_select_contact", str);
    com.tencent.mm.br.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
    AppMethodBeat.o(253326);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253308);
    super.onCreate(paramBundle);
    setMMTitle(jzv());
    this.afkK.aNm();
    jzB();
    this.afkL = getString(R.l.gqj);
    this.abky = getResources().getString(R.l.gqc);
    aMl();
    AppMethodBeat.o(253308);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(253311);
    super.onDestroy();
    AppMethodBeat.o(253311);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(253390);
    Log.i("MicroMsg.ContactMgrOnlyChatUI", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if (paramInt == 4) {
      jzA();
    }
    AppMethodBeat.o(253390);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(253378);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if (!(paramp instanceof com.tencent.mm.modelmulti.h))
    {
      AppMethodBeat.o(253378);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.modelmulti.h localh = (com.tencent.mm.modelmulti.h)paramp;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (localh.op == 1) {}
      for (paramInt1 = R.l.gqq;; paramInt1 = R.l.gqt)
      {
        Toast.makeText(this, getString(paramInt1), 0).show();
        AppMethodBeat.o(253378);
        return;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new g.a(this);
      paramString.bDE(Util.nullAs(paramp.getReqResp().getRespObj().getErrMsg(), getString(R.l.gqo))).NF(true).bDJ(getString(R.l.gSe)).aEX(R.l.gSf);
      paramString.c(new ContactMgrOnlyChatUI.3(this)).show();
      AppMethodBeat.o(253378);
      return;
    }
    g.a locala = new g.a(this);
    if (paramInt2 == -3500) {
      if (localh.op == 1)
      {
        paramInt1 = R.l.gqp;
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localh.bKN()) });
      }
    }
    for (;;)
    {
      paramString = locala.bDE(paramString);
      paramString.Xdm = true;
      paramString.aEX(R.l.app_ok);
      locala.b(new ContactMgrOnlyChatUI.4(this)).show();
      AppMethodBeat.o(253378);
      return;
      paramInt1 = R.l.gqs;
      break;
      paramString = paramp.getReqResp().getRespObj().getErrMsg();
      if (Util.isNullOrNil(paramString))
      {
        if (localh.op == 1) {}
        for (paramInt1 = R.l.gqo;; paramInt1 = R.l.gqr)
        {
          paramString = getString(paramInt1);
          break;
        }
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
    
    public final void aNm()
    {
      AppMethodBeat.i(253397);
      super.aNm();
      com.tencent.mm.kernel.h.baF();
      Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(null, this.query, "@social.black.android", "", cVa());
      ContactMgrOnlyChatUI.this.xtu.clear();
      if (localCursor != null)
      {
        int i = 0;
        while (localCursor.moveToPosition(i))
        {
          Log.d("MicroMsg.ContactMgrOnlyChatUI", "create contact item index=%d", new Object[] { Integer.valueOf(i) });
          au localau = new au();
          localau.convertFrom(localCursor);
          ContactMgrOnlyChatUI.this.xtu.add(localau.field_username);
          i += 1;
        }
      }
      localCursor.close();
      AppMethodBeat.o(253397);
    }
    
    public final String jzy()
    {
      return "@social.black.android";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.ContactMgrOnlyChatUI
 * JD-Core Version:    0.7.0.1
 */