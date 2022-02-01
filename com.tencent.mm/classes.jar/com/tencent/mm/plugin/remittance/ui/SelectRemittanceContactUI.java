package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.hq;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ar;
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
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
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
  private View KIU;
  private List<String> OpY;
  private List<String> Ote;
  private int fromScene;
  private List<String> lMF;
  private String title;
  
  private static List<String> SA(String paramString)
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
    if (!au.bwE(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(z.bAM());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(68349);
      return localObject;
    }
    try
    {
      localObject = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK().Jy(paramString);
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
  
  private void a(final String paramString, final ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(68346);
    yj(17);
    k.a(this, getString(a.i.wallet_select_conversation_no_include_all_user, new Object[] { Integer.valueOf(paramInt) }), "", getString(a.i.wallet_select_conversation_next_pay), getString(a.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68332);
        Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ok");
        SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, paramString, paramArrayList);
        AppMethodBeat.o(68332);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(288961);
        Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() cancel");
        AppMethodBeat.o(288961);
      }
    });
    AppMethodBeat.o(68346);
  }
  
  private void aUj(String paramString)
  {
    AppMethodBeat.i(68345);
    Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { paramString });
    if (bVC())
    {
      if (!au.bwE(paramString))
      {
        if (this.Ote.contains(paramString))
        {
          if (this.Ote.size() == 1)
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
        gNc();
        AppMethodBeat.o(68345);
        return;
      }
      localObject = SA(paramString);
      if (!cv((List)localObject))
      {
        gNc();
        Log.e("MicroMsg.SelectRemittanceContactUI", "self no in chatroom(%s)", new Object[] { paramString });
        AppMethodBeat.o(68345);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Ote.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)localObject).contains(str)) {
          localArrayList.add(str);
        }
      }
      if (localArrayList.size() == 0)
      {
        gNc();
        AppMethodBeat.o(68345);
        return;
      }
      if (localArrayList.size() == this.Ote.size())
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
  
  private void b(final String paramString1, final ArrayList<String> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(68348);
    Log.i("MicroMsg.SelectRemittanceContactUI", "showLaunchComfirmDialog()");
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = getString(a.i.launch_aa_default_title);
    }
    ((j)com.tencent.mm.kernel.h.ax(j.class)).a(getController(), paramString1, getString(a.i.aa_dialog_sub_title) + str, getString(a.i.aa_dialog_ok_text), new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(288962);
        if (paramAnonymousBoolean)
        {
          SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, paramString1, paramArrayList);
          SelectRemittanceContactUI.yj(12);
          AppMethodBeat.o(288962);
          return;
        }
        SelectRemittanceContactUI.yj(13);
        AppMethodBeat.o(288962);
      }
    });
    yj(11);
    AppMethodBeat.o(68348);
  }
  
  private boolean bVC()
  {
    return this.fromScene == 3;
  }
  
  private static boolean cv(List<String> paramList)
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
    } while (!Util.isEqual((String)paramList.next(), z.bAM()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(68350);
      return bool;
    }
  }
  
  private void gNc()
  {
    AppMethodBeat.i(68347);
    yj(16);
    k.a(this, getString(a.i.wallet_select_conversation_no_include_self), "", getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(288959);
        Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick()");
        AppMethodBeat.o(288959);
      }
    });
    AppMethodBeat.o(68347);
  }
  
  public static void yj(int paramInt)
  {
    AppMethodBeat.i(68351);
    hq localhq = new hq();
    localhq.iOO = paramInt;
    localhq.bMH();
    AppMethodBeat.o(68351);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(289035);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      Log.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramAdapterView = new Intent();
      if ((this.fromScene == 1) || (this.fromScene == 3))
      {
        paramAdapterView.putExtra("list_attr", w.R(new int[] { w.affn, 16384, 64, 4096, 262144 }));
        paramAdapterView.putExtra("min_limit_num", 1);
        paramAdapterView.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        paramAdapterView.putExtra("titile", getString(a.i.wallet_select_create_chatroom_title));
        paramAdapterView.putExtra("without_openim", true);
      }
      for (;;)
      {
        c.d(this, ".ui.contact.SelectContactUI", paramAdapterView, 1);
        overridePendingTransition(a.a.push_up_in, a.a.fast_faded_out);
        AppMethodBeat.o(289035);
        return;
        paramInt = w.R(new int[] { 16, 1, 2, 4, 16384 });
        paramAdapterView.putExtra("list_type", 0);
        paramAdapterView.putExtra("list_attr", paramInt);
        paramAdapterView.putExtra("titile", getString(a.i.remittance_select_receiver_title));
        paramAdapterView.putExtra("sub_title", getString(a.i.wallet_wechat_authenticate_safely));
      }
    }
    paramAdapterView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(289035);
      return;
    }
    paramView = paramAdapterView.contact;
    if (paramView == null)
    {
      AppMethodBeat.o(289035);
      return;
    }
    paramAdapterView = paramView.field_username;
    if ((au.bwP(paramAdapterView)) || (au.bwO(paramAdapterView)))
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "username[%s] is openime || oepnimechatroom", new Object[] { Util.nullAs(paramAdapterView, "null") });
      paramView = MMApplicationContext.getContext();
      if (au.bwP(paramAdapterView)) {}
      for (paramAdapterView = paramView.getString(a.i.wallet_select_conversation_no_support_openim_chatroom);; paramAdapterView = paramView.getString(a.i.wallet_select_conversation_no_support_openim))
      {
        k.a(this, paramAdapterView, "", getString(a.i.welcome_i_know), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68330);
            Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ");
            AppMethodBeat.o(68330);
          }
        });
        AppMethodBeat.o(289035);
        return;
      }
    }
    aUj(paramView.field_username);
    if ((jyE() instanceof h))
    {
      paramInt -= getContentLV().getHeaderViewsCount();
      paramAdapterView = (h)jyE();
      Log.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramAdapterView.OpW < 0) {
        break label547;
      }
      if (paramAdapterView.OpX >= 0) {
        break label526;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        com.tencent.mm.plugin.report.service.h.OAn.b(13721, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
      }
      AppMethodBeat.o(289035);
      return;
      label526:
      if ((paramInt > paramAdapterView.OpW) && (paramInt < paramAdapterView.OpX)) {
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
    if (this.KIU == null)
    {
      localView = View.inflate(this, a.g.select_conversation_header, null);
      this.KIU = localView.findViewById(a.f.content);
      localTextView = (TextView)localView.findViewById(a.f.tip_tv);
      if ((this.fromScene != 1) && (this.fromScene != 3)) {
        break label107;
      }
      localTextView.setText(a.i.wallet_select_conversation_create);
    }
    for (;;)
    {
      localView.setAccessibilityDelegate(new View.AccessibilityDelegate()
      {
        public final void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
        {
          AppMethodBeat.i(288968);
          super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
          paramAnonymousAccessibilityNodeInfo.setClassName(TextView.class.getName());
          paramAnonymousAccessibilityNodeInfo.setContentDescription(SelectRemittanceContactUI.this.getString(a.i.wallet_select_conversation_create));
          AppMethodBeat.o(288968);
        }
      });
      paramListView.addHeaderView(localView);
      this.KIU.setVisibility(paramInt);
      AppMethodBeat.o(68341);
      return;
      label107:
      localTextView.setText(a.i.remittance_go_select_contact);
    }
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(68335);
    super.aNi();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject = getIntent().getStringExtra("recent_remittance_contact_list");
    Log.v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(localObject)));
    this.OpY = new ArrayList();
    if (!Util.isNullOrNil((String)localObject)) {
      this.OpY = Util.stringsToList(((String)localObject).split(","));
    }
    if (bVC())
    {
      this.title = getIntent().getStringExtra("key_title");
      localObject = getIntent().getStringExtra("key_include_username_list");
      this.Ote = new ArrayList();
      if (!Util.isNullOrNil((String)localObject)) {
        this.Ote = Util.stringsToList(((String)localObject).split(","));
      }
    }
    localObject = new HashSet();
    ((HashSet)localObject).addAll(w.jyV());
    ((HashSet)localObject).addAll(w.jyW());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    this.lMF = new ArrayList();
    this.lMF.addAll((Collection)localObject);
    AppMethodBeat.o(68335);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(68336);
    h localh = new h(this, this.OpY, this.lMF, this.fromScene);
    AppMethodBeat.o(68336);
    return localh;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(68337);
    u localu = new u(this, this.lMF, false, this.scene);
    AppMethodBeat.o(68337);
    return localu;
  }
  
  public final boolean bVx()
  {
    return true;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
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
  
  public final int[] efu()
  {
    if ((this.fromScene == 1) || (this.fromScene == 3)) {
      return new int[] { 131072, 131075 };
    }
    return new int[] { 131072 };
  }
  
  public final void fYZ()
  {
    AppMethodBeat.i(68342);
    super.fYZ();
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
        if (bVC())
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          if (!Util.isNullOrNil(paramIntent)) {
            aUj(paramIntent);
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
    getContentView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(288969);
        SelectRemittanceContactUI.a(SelectRemittanceContactUI.this).findViewById(a.f.top_search_view).sendAccessibilityEvent(128);
        AppMethodBeat.o(288969);
      }
    });
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
      fYZ();
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(289020);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.aa.model.a.class);
    AppMethodBeat.o(289020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI
 * JD-Core Version:    0.7.0.1
 */