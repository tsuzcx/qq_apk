package com.tencent.mm.ui.contact.privacy;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.List;

public class ContactMgrOnlyChatUI
  extends ContactMgrUIBase
  implements o
{
  private String TTU;
  
  protected final ContactMgrUIBase.a a(o paramo)
  {
    AppMethodBeat.i(267281);
    paramo = new a(paramo);
    AppMethodBeat.o(267281);
    return paramo;
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void awS(int paramInt)
  {
    AppMethodBeat.i(267282);
    Object localObject = this.Xyt.awM(paramInt);
    if ((localObject == null) || (!(localObject instanceof f)))
    {
      AppMethodBeat.o(267282);
      return;
    }
    localObject = ((f)localObject).username;
    if (this.Xyt.fJk())
    {
      this.Xyt.bAh((String)localObject);
      if (this.Xyt.Eec.size() > 0)
      {
        this.nbe.setText(getString(R.l.enj) + "(" + this.Xyt.Eec.size() + ")");
        this.nbe.setEnabled(true);
        AppMethodBeat.o(267282);
        return;
      }
      this.nbe.setText(getString(R.l.enj));
      this.nbe.setEnabled(false);
      AppMethodBeat.o(267282);
      return;
    }
    if (ab.QL((String)localObject))
    {
      localObject = new Intent(getContext(), AddressUI.class);
      ((Intent)localObject).putExtra("Contact_GroupFilter_Type", "@biz.contact");
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/contact/privacy/ContactMgrOnlyChatUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/privacy/ContactMgrOnlyChatUI", "onListViewItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(267282);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", (String)localObject);
    localIntent.putExtra("Contact_Scene", 3);
    localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 4);
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      com.tencent.mm.by.c.b(getContext(), "profile", ".ui.ContactInfoUI", localIntent);
    }
    AppMethodBeat.o(267282);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void bH(final Intent paramIntent)
  {
    AppMethodBeat.i(267276);
    paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if ((paramIntent == null) || (paramIntent.isEmpty()))
    {
      AppMethodBeat.o(267276);
      return;
    }
    Log.i("MicroMsg.ContactMgrOnlyChatUI", "onAddContact , memBerList: %s, tagList : %s.", new Object[] { paramIntent, this.unc });
    paramIntent = new com.tencent.mm.modelmulti.c(paramIntent, 8388608, 1, this.XuE);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(R.l.eng), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(280918);
        com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent);
        AppMethodBeat.o(280918);
      }
    });
    AppMethodBeat.o(267276);
  }
  
  public final void bI(final Intent paramIntent)
  {
    AppMethodBeat.i(267278);
    paramIntent = Util.stringsToList(paramIntent.getStringExtra("Select_Contact").split(","));
    if ((paramIntent == null) || (paramIntent.isEmpty()))
    {
      AppMethodBeat.o(267278);
      return;
    }
    Log.i("MicroMsg.ContactMgrOnlyChatUI", "onAddContact , memBerList: %s, tagList : %s.", new Object[] { paramIntent, this.unc });
    paramIntent = new com.tencent.mm.modelmulti.c(paramIntent, 8388608, 2, this.XuE);
    com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent, 0);
    AppCompatActivity localAppCompatActivity = getContext();
    getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(R.l.enk), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(275508);
        com.tencent.mm.kernel.h.aHF().kcd.a(paramIntent);
        AppMethodBeat.o(275508);
      }
    });
    AppMethodBeat.o(267278);
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
    return R.i.ejU;
  }
  
  protected final void hVA()
  {
    AppMethodBeat.i(267274);
    Intent localIntent = new Intent(this, SelectPrivacyContactsFromRangeUI.class);
    localIntent.putExtra("intent_status_mgr", true);
    localIntent.putExtra("list_type", 16);
    localIntent.putExtra("filter_type", "@social.black.android");
    localIntent.putExtra("titile", getResources().getString(R.l.ePd));
    bJ(localIntent);
    startActivityForResult(localIntent, 2);
    AppMethodBeat.o(267274);
  }
  
  protected final void hVB()
  {
    AppMethodBeat.i(267275);
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(R.l.ePa));
    localIntent.putExtra("list_type", 1);
    localIntent.putExtra("KBlockOpenImFav", true);
    localIntent.putExtra("without_openim", true);
    localIntent.putExtra("show_too_many_member", false);
    int i = w.P(new int[] { w.P(new int[] { w.XtK, 536870912 }), 131072 });
    localIntent.putExtra("max_limit_num", this.XuF);
    String str = Util.listToString(this.unc, ",");
    localIntent.putExtra("list_attr", i);
    localIntent.putExtra("always_select_contact", str);
    com.tencent.mm.by.c.d(this, ".ui.contact.SelectContactUI", localIntent, 1);
    AppMethodBeat.o(267275);
  }
  
  public final CharSequence hVz()
  {
    AppMethodBeat.i(267271);
    String str = getResources().getString(R.l.ena);
    AppMethodBeat.o(267271);
    return str;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(267272);
    super.onCreate(paramBundle);
    setMMTitle(hVz());
    this.Xyt.ate();
    hVF();
    this.Xyv = getString(R.l.eni);
    this.TTU = getResources().getString(R.l.ena);
    updateTitle();
    AppMethodBeat.o(267272);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(267273);
    super.onDestroy();
    AppMethodBeat.o(267273);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(267280);
    Log.i("MicroMsg.ContactMgrOnlyChatUI", "onNotifyChange: event = " + paramInt + " stg = " + paramMStorageEx + " obj = " + paramObject);
    if (paramInt == 4) {
      hVE();
    }
    AppMethodBeat.o(267280);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(267279);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if (!(paramq instanceof com.tencent.mm.modelmulti.c))
    {
      AppMethodBeat.o(267279);
      return;
    }
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.modelmulti.c localc = (com.tencent.mm.modelmulti.c)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (localc.op == 1) {}
      for (paramInt1 = R.l.enp;; paramInt1 = R.l.ens)
      {
        Toast.makeText(this, getString(paramInt1), 0).show();
        AppMethodBeat.o(267279);
        return;
      }
    }
    if (paramInt2 == -3503)
    {
      paramString = new f.a(this);
      paramString.bBl(Util.nullAs(paramq.getReqResp().getRespObj().getErrMsg(), getString(R.l.enn))).HL(true).bBq(getString(R.l.ePC)).ayp(R.l.ePD);
      paramString.c(new ContactMgrOnlyChatUI.3(this)).show();
      AppMethodBeat.o(267279);
      return;
    }
    f.a locala = new f.a(this);
    if (paramInt2 == -3500) {
      if (localc.op == 1)
      {
        paramInt1 = R.l.eno;
        paramString = getString(paramInt1, new Object[] { Integer.valueOf(localc.bnc()) });
      }
    }
    for (;;)
    {
      paramString = locala.bBl(paramString);
      paramString.Qlf = true;
      paramString.ayp(R.l.app_ok);
      locala.b(new ContactMgrOnlyChatUI.4(this)).show();
      AppMethodBeat.o(267279);
      return;
      paramInt1 = R.l.enr;
      break;
      paramString = paramq.getReqResp().getRespObj().getErrMsg();
      if (Util.isNullOrNil(paramString))
      {
        if (localc.op == 1) {}
        for (paramInt1 = R.l.enn;; paramInt1 = R.l.enq)
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
  
  protected final void updateTitle()
  {
    AppMethodBeat.i(267277);
    if ((this.Xyt != null) && (this.Xyt.getContactCount() > 0))
    {
      setMMTitle(this.TTU + "(" + this.Xyt.getContactCount() + ")");
      AppMethodBeat.o(267277);
      return;
    }
    setMMTitle(this.TTU);
    AppMethodBeat.o(267277);
  }
  
  final class a
    extends ContactMgrUIBase.a
  {
    public a(o paramo)
    {
      super(paramo);
    }
    
    public final void ate()
    {
      AppMethodBeat.i(283851);
      super.ate();
      com.tencent.mm.kernel.h.aHH();
      Cursor localCursor = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().d(null, this.query, "@social.black.android", "", csq());
      ContactMgrOnlyChatUI.this.unc.clear();
      if (localCursor != null)
      {
        int i = 0;
        while (localCursor.moveToPosition(i))
        {
          Log.d("MicroMsg.ContactMgrOnlyChatUI", "create contact item index=%d", new Object[] { Integer.valueOf(i) });
          as localas = new as();
          localas.convertFrom(localCursor);
          ContactMgrOnlyChatUI.this.unc.add(localas.field_username);
          i += 1;
        }
      }
      localCursor.close();
      AppMethodBeat.o(283851);
    }
    
    public final String hVC()
    {
      return "@social.black.android";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.privacy.ContactMgrOnlyChatUI
 * JD-Core Version:    0.7.0.1
 */