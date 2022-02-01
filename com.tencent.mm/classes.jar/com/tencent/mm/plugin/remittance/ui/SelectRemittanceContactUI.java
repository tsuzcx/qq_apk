package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.b.a.fv;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class SelectRemittanceContactUI
  extends MMBaseSelectContactUI
{
  private View EOv;
  private List<String> Isq;
  private List<String> IvC;
  private int fromScene;
  private List<String> jkb;
  private String title;
  
  private void a(final String paramString, final ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(68346);
    yd(17);
    com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_select_conversation_no_include_all_user, new Object[] { Integer.valueOf(paramInt) }), "", getString(a.i.wallet_select_conversation_next_pay), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68330);
        Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ok");
        SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, paramString, paramArrayList);
        AppMethodBeat.o(68330);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68331);
        Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() cancel");
        AppMethodBeat.o(68331);
      }
    });
    AppMethodBeat.o(68346);
  }
  
  private static boolean aQ(List<String> paramList)
  {
    AppMethodBeat.i(68350);
    if (paramList == null)
    {
      AppMethodBeat.o(68350);
      return false;
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (!Util.isEqual((String)paramList.next(), z.bcZ()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(68350);
      return bool;
    }
  }
  
  private void aWT(String paramString)
  {
    AppMethodBeat.i(68345);
    Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { paramString });
    if (bwM())
    {
      if (!ab.Lj(paramString))
      {
        if (this.IvC.contains(paramString))
        {
          if (this.IvC.size() == 1)
          {
            localObject = this.title;
            localArrayList = new ArrayList();
            localArrayList.add(paramString);
            b(paramString, localArrayList, (String)localObject);
            AppMethodBeat.o(68345);
            return;
          }
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramString);
          a(paramString, (ArrayList)localObject, 1);
          AppMethodBeat.o(68345);
          return;
        }
        fBd();
        AppMethodBeat.o(68345);
        return;
      }
      localObject = aag(paramString);
      if (!aQ((List)localObject))
      {
        fBd();
        Log.e("MicroMsg.SelectRemittanceContactUI", "self no in chatroom(%s)", new Object[] { paramString });
        AppMethodBeat.o(68345);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.IvC.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)localObject).contains(str)) {
          localArrayList.add(str);
        }
      }
      if (localArrayList.size() == 0)
      {
        fBd();
        AppMethodBeat.o(68345);
        return;
      }
      if (localArrayList.size() == this.IvC.size())
      {
        b(paramString, localArrayList, this.title);
        AppMethodBeat.o(68345);
        return;
      }
      a(paramString, localArrayList, localArrayList.size());
      AppMethodBeat.o(68345);
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("Select_Conv_User", paramString);
    setResult(-1, (Intent)localObject);
    finish();
    hideVKB();
    AppMethodBeat.o(68345);
  }
  
  private static List<String> aag(String paramString)
  {
    AppMethodBeat.i(68349);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "illegal chatroomName");
      paramString = new ArrayList();
      AppMethodBeat.o(68349);
      return paramString;
    }
    Object localObject;
    if (!ab.Lj(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(z.bcZ());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(68349);
      return localObject;
    }
    try
    {
      localObject = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().RA(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new ArrayList();
      }
      AppMethodBeat.o(68349);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SelectRemittanceContactUI", "getChatroomMemberList error! %s", new Object[] { paramString.getMessage() });
      paramString = new ArrayList();
      AppMethodBeat.o(68349);
    }
    return paramString;
  }
  
  private void b(final String paramString1, final ArrayList<String> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(68348);
    Log.i("MicroMsg.SelectRemittanceContactUI", "showLaunchComfirmDialog()");
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = getString(a.i.launch_aa_default_title);
    }
    ((j)com.tencent.mm.kernel.h.ae(j.class)).a(getController(), paramString1, getString(a.i.aa_dialog_sub_title) + str, getString(a.i.aa_dialog_ok_text), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(68333);
        if (paramAnonymousBoolean)
        {
          SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, paramString1, paramArrayList);
          SelectRemittanceContactUI.yd(12);
          AppMethodBeat.o(68333);
          return;
        }
        SelectRemittanceContactUI.yd(13);
        AppMethodBeat.o(68333);
      }
    });
    yd(11);
    AppMethodBeat.o(68348);
  }
  
  private boolean bwM()
  {
    return this.fromScene == 3;
  }
  
  private void fBd()
  {
    AppMethodBeat.i(68347);
    yd(16);
    com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_select_conversation_no_include_self), "", getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68332);
        Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick()");
        AppMethodBeat.o(68332);
      }
    });
    AppMethodBeat.o(68347);
  }
  
  public static void yd(int paramInt)
  {
    AppMethodBeat.i(68351);
    fv localfv = new fv();
    localfv.gBN = paramInt;
    localfv.bpa();
    AppMethodBeat.o(68351);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(255949);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      Log.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramView = new Intent();
      if ((this.fromScene == 1) || (this.fromScene == 3))
      {
        paramView.putExtra("list_attr", w.P(new int[] { w.XtJ, 16384, 64, 4096, 262144 }));
        paramView.putExtra("min_limit_num", 1);
        paramView.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        paramView.putExtra("titile", getString(a.i.wallet_select_create_chatroom_title));
        paramView.putExtra("without_openim", true);
      }
      for (;;)
      {
        c.d(this, ".ui.contact.SelectContactUI", paramView, 1);
        overridePendingTransition(a.a.push_up_in, a.a.fast_faded_out);
        AppMethodBeat.o(255949);
        return;
        paramInt = w.P(new int[] { 16, 1, 2, 4, 16384 });
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", paramInt);
        paramView.putExtra("titile", getString(a.i.remittance_select_receiver_title));
        paramView.putExtra("sub_title", getString(a.i.wallet_wechat_authenticate_safely));
      }
    }
    paramView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(255949);
      return;
    }
    Object localObject = paramView.contact;
    if (localObject == null)
    {
      AppMethodBeat.o(255949);
      return;
    }
    paramView = ((ax)localObject).field_username;
    if ((as.bvL(paramView)) || (as.bvK(paramView)))
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "username[%s] is openime || oepnimechatroom", new Object[] { Util.nullAs(paramView, "null") });
      localObject = MMApplicationContext.getContext();
      if (as.bvL(paramView)) {}
      for (paramView = ((Context)localObject).getString(a.i.wallet_select_conversation_no_support_openim_chatroom);; paramView = ((Context)localObject).getString(a.i.wallet_select_conversation_no_support_openim))
      {
        com.tencent.mm.ui.base.h.a(this, paramView, "", getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68329);
            Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ");
            AppMethodBeat.o(68329);
          }
        });
        AppMethodBeat.o(255949);
        return;
      }
    }
    aWT(((ax)localObject).field_username);
    if ((hUP() instanceof g))
    {
      paramInt -= getContentLV().getHeaderViewsCount();
      paramView = (g)hUP();
      Log.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramView.Iso < 0) {
        break label547;
      }
      if (paramView.Isp >= 0) {
        break label526;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        com.tencent.mm.plugin.report.service.h.IzE.a(13721, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
      }
      AppMethodBeat.o(255949);
      return;
      label526:
      if ((paramInt > paramView.Iso) && (paramInt < paramView.Isp)) {
        paramInt = 1;
      } else {
        label547:
        paramInt = 0;
      }
    }
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(68341);
    super.a(paramListView, paramInt);
    View localView;
    TextView localTextView;
    if (this.EOv == null)
    {
      localView = View.inflate(this, a.g.select_conversation_header, null);
      this.EOv = localView.findViewById(a.f.content);
      localTextView = (TextView)localView.findViewById(a.f.tip_tv);
      if ((this.fromScene != 1) && (this.fromScene != 3)) {
        break label95;
      }
      localTextView.setText(a.i.wallet_select_conversation_create);
    }
    for (;;)
    {
      paramListView.addHeaderView(localView);
      this.EOv.setVisibility(paramInt);
      AppMethodBeat.o(68341);
      return;
      label95:
      localTextView.setText(a.i.remittance_go_select_contact);
    }
  }
  
  public final void ata()
  {
    AppMethodBeat.i(68335);
    super.ata();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject = getIntent().getStringExtra("recent_remittance_contact_list");
    Log.v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(localObject)));
    this.Isq = new ArrayList();
    if (!Util.isNullOrNil((String)localObject)) {
      this.Isq = Util.stringsToList(((String)localObject).split(","));
    }
    if (bwM())
    {
      this.title = getIntent().getStringExtra("key_title");
      localObject = getIntent().getStringExtra("key_include_username_list");
      this.IvC = new ArrayList();
      if (!Util.isNullOrNil((String)localObject)) {
        this.IvC = Util.stringsToList(((String)localObject).split(","));
      }
    }
    localObject = new HashSet();
    ((HashSet)localObject).addAll(w.hVh());
    ((HashSet)localObject).addAll(w.hVi());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    this.jkb = new ArrayList();
    this.jkb.addAll((Collection)localObject);
    AppMethodBeat.o(68335);
  }
  
  public final boolean bwH()
  {
    return true;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(68340);
    if ((this.fromScene == 1) || (this.fromScene == 3))
    {
      str = getString(a.i.wallet_select_conversation_title);
      AppMethodBeat.o(68340);
      return str;
    }
    String str = getString(a.i.remittance_title);
    AppMethodBeat.o(68340);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(68336);
    g localg = new g(this, this.Isq, this.jkb, this.fromScene);
    AppMethodBeat.o(68336);
    return localg;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(68337);
    u localu = new u(this, this.jkb, false, this.scene);
    AppMethodBeat.o(68337);
    return localu;
  }
  
  public final int[] dvA()
  {
    if ((this.fromScene == 1) || (this.fromScene == 3)) {
      return new int[] { 131072, 131075 };
    }
    return new int[] { 131072 };
  }
  
  public final void eQp()
  {
    AppMethodBeat.i(68342);
    super.eQp();
    hideVKB();
    AppMethodBeat.o(68342);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68339);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        if (bwM())
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          if (!Util.isNullOrNil(paramIntent)) {
            aWT(paramIntent);
          }
          AppMethodBeat.o(68339);
          return;
          Log.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
        }
        else
        {
          setResult(-1, paramIntent);
          finish();
        }
      }
      else
      {
        AppMethodBeat.o(68339);
        return;
      }
    }
    Log.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(68339);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68334);
    super.onCreate(paramBundle);
    AppMethodBeat.o(68334);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68343);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      AppMethodBeat.o(68343);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(68343);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68344);
    if (paramInt == 4) {
      eQp();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68344);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI
 * JD-Core Version:    0.7.0.1
 */