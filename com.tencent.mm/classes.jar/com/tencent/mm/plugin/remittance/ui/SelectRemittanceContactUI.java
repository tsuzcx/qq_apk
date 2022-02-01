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
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class SelectRemittanceContactUI
  extends MMBaseSelectContactUI
{
  private List<String> CuD;
  private List<String> Cxk;
  private int fromScene;
  private List<String> gzY;
  private String title;
  private View zjf;
  
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
    if (!ab.Eq(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(z.aTY());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(68349);
      return localObject;
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(paramString);
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
    uZ(17);
    com.tencent.mm.ui.base.h.a(this, getString(2131768307, new Object[] { Integer.valueOf(paramInt) }), "", getString(2131768306), getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  private void aMp(String paramString)
  {
    AppMethodBeat.i(68345);
    Log.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { paramString });
    if (bmE())
    {
      if (!ab.Eq(paramString))
      {
        if (this.Cxk.contains(paramString))
        {
          if (this.Cxk.size() == 1)
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
        eOo();
        AppMethodBeat.o(68345);
        return;
      }
      localObject = SA(paramString);
      if (!aS((List)localObject))
      {
        eOo();
        Log.e("MicroMsg.SelectRemittanceContactUI", "self no in chatroom(%s)", new Object[] { paramString });
        AppMethodBeat.o(68345);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Cxk.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)localObject).contains(str)) {
          localArrayList.add(str);
        }
      }
      if (localArrayList.size() == 0)
      {
        eOo();
        AppMethodBeat.o(68345);
        return;
      }
      if (localArrayList.size() == this.Cxk.size())
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
  
  private static boolean aS(List<String> paramList)
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
    } while (!Util.isEqual((String)paramList.next(), z.aTY()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(68350);
      return bool;
    }
  }
  
  private void b(final String paramString1, final ArrayList<String> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(68348);
    Log.i("MicroMsg.SelectRemittanceContactUI", "showLaunchComfirmDialog()");
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = getString(2131762172);
    }
    ((j)com.tencent.mm.kernel.g.af(j.class)).a(getController(), paramString1, getString(2131755036) + str, getString(2131755035), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(68333);
        if (paramAnonymousBoolean)
        {
          SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, paramString1, paramArrayList);
          SelectRemittanceContactUI.uZ(12);
          AppMethodBeat.o(68333);
          return;
        }
        SelectRemittanceContactUI.uZ(13);
        AppMethodBeat.o(68333);
      }
    });
    uZ(11);
    AppMethodBeat.o(68348);
  }
  
  private boolean bmE()
  {
    return this.fromScene == 3;
  }
  
  private void eOo()
  {
    AppMethodBeat.i(68347);
    uZ(16);
    com.tencent.mm.ui.base.h.a(this, getString(2131768308), "", getString(2131768713), false, new DialogInterface.OnClickListener()
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
  
  public static void uZ(int paramInt)
  {
    AppMethodBeat.i(68351);
    es locales = new es();
    locales.eEr = paramInt;
    locales.bfK();
    AppMethodBeat.o(68351);
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(213843);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      Log.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      paramView = new Intent();
      if ((this.fromScene == 1) || (this.fromScene == 3))
      {
        paramView.putExtra("list_attr", u.Q(new int[] { u.PWR, 16384, 64, 4096, 262144 }));
        paramView.putExtra("min_limit_num", 1);
        paramView.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        paramView.putExtra("titile", getString(2131768313));
        paramView.putExtra("without_openim", true);
      }
      for (;;)
      {
        com.tencent.mm.br.c.c(this, ".ui.contact.SelectContactUI", paramView, 1);
        overridePendingTransition(2130772132, 2130772060);
        AppMethodBeat.o(213843);
        return;
        paramInt = u.Q(new int[] { 16, 1, 2, 4, 16384 });
        paramView.putExtra("list_type", 0);
        paramView.putExtra("list_attr", paramInt);
        paramView.putExtra("titile", getString(2131764598));
        paramView.putExtra("sub_title", getString(2131768388));
      }
    }
    paramView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(213843);
      return;
    }
    Object localObject = paramView.contact;
    if (localObject == null)
    {
      AppMethodBeat.o(213843);
      return;
    }
    paramView = ((ax)localObject).field_username;
    if ((as.bjq(paramView)) || (as.bjp(paramView)))
    {
      Log.i("MicroMsg.SelectRemittanceContactUI", "username[%s] is openime || oepnimechatroom", new Object[] { Util.nullAs(paramView, "null") });
      localObject = MMApplicationContext.getContext();
      if (as.bjq(paramView)) {}
      for (paramView = ((Context)localObject).getString(2131768310);; paramView = ((Context)localObject).getString(2131768309))
      {
        com.tencent.mm.ui.base.h.a(this, paramView, "", getString(2131768713), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68329);
            Log.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ");
            AppMethodBeat.o(68329);
          }
        });
        AppMethodBeat.o(213843);
        return;
      }
    }
    aMp(((ax)localObject).field_username);
    if ((gUP() instanceof g))
    {
      paramInt -= getContentLV().getHeaderViewsCount();
      paramView = (g)gUP();
      Log.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramView.CuB < 0) {
        break label547;
      }
      if (paramView.CuC >= 0) {
        break label526;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        com.tencent.mm.plugin.report.service.h.CyF.a(13721, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
      }
      AppMethodBeat.o(213843);
      return;
      label526:
      if ((paramInt > paramView.CuB) && (paramInt < paramView.CuC)) {
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
    if (this.zjf == null)
    {
      localView = View.inflate(this, 2131496202, null);
      this.zjf = localView.findViewById(2131299180);
      localTextView = (TextView)localView.findViewById(2131309163);
      if ((this.fromScene != 1) && (this.fromScene != 3)) {
        break label95;
      }
      localTextView.setText(2131768304);
    }
    for (;;)
    {
      paramListView.addHeaderView(localView);
      this.zjf.setVisibility(paramInt);
      AppMethodBeat.o(68341);
      return;
      label95:
      localTextView.setText(2131764562);
    }
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(68335);
    super.amZ();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject = getIntent().getStringExtra("recent_remittance_contact_list");
    Log.v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(localObject)));
    this.CuD = new ArrayList();
    if (!Util.isNullOrNil((String)localObject)) {
      this.CuD = Util.stringsToList(((String)localObject).split(","));
    }
    if (bmE())
    {
      this.title = getIntent().getStringExtra("key_title");
      localObject = getIntent().getStringExtra("key_include_username_list");
      this.Cxk = new ArrayList();
      if (!Util.isNullOrNil((String)localObject)) {
        this.Cxk = Util.stringsToList(((String)localObject).split(","));
      }
    }
    localObject = new HashSet();
    ((HashSet)localObject).addAll(u.gVb());
    ((HashSet)localObject).addAll(u.gVc());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    this.gzY = new ArrayList();
    this.gzY.addAll((Collection)localObject);
    AppMethodBeat.o(68335);
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(68340);
    if ((this.fromScene == 1) || (this.fromScene == 3))
    {
      str = getString(2131768311);
      AppMethodBeat.o(68340);
      return str;
    }
    String str = getString(2131764602);
    AppMethodBeat.o(68340);
    return str;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(68336);
    g localg = new g(this, this.CuD, this.gzY, this.fromScene);
    AppMethodBeat.o(68336);
    return localg;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(68337);
    s locals = new s(this, this.gzY, false, this.scene);
    AppMethodBeat.o(68337);
    return locals;
  }
  
  public final boolean bmz()
  {
    return true;
  }
  
  public final int[] egI()
  {
    if ((this.fromScene == 1) || (this.fromScene == 3)) {
      return new int[] { 131072, 131075 };
    }
    return new int[] { 131072 };
  }
  
  public final void egJ()
  {
    AppMethodBeat.i(68342);
    super.egJ();
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
        if (bmE())
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          if (!Util.isNullOrNil(paramIntent)) {
            aMp(paramIntent);
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
      egJ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI
 * JD-Core Version:    0.7.0.1
 */