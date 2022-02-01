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
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class SelectRemittanceContactUI
  extends MMBaseSelectContactUI
{
  private int fromScene;
  private List<String> fzw;
  private String title;
  private View uza;
  private List<String> wQn;
  private List<String> wSQ;
  
  private static List<String> FO(String paramString)
  {
    AppMethodBeat.i(68349);
    if (bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.SelectRemittanceContactUI", "illegal chatroomName");
      paramString = new ArrayList();
      AppMethodBeat.o(68349);
      return paramString;
    }
    Object localObject;
    if (!w.sQ(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(com.tencent.mm.model.u.axw());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(68349);
      return localObject;
    }
    try
    {
      localObject = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xR(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new ArrayList();
      }
      AppMethodBeat.o(68349);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.SelectRemittanceContactUI", "getChatroomMemberList error! %s", new Object[] { paramString.getMessage() });
      paramString = new ArrayList();
      AppMethodBeat.o(68349);
    }
    return paramString;
  }
  
  private void a(final String paramString, final ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(68346);
    qF(17);
    com.tencent.mm.ui.base.h.a(this, getString(2131765854, new Object[] { Integer.valueOf(paramInt) }), "", getString(2131765853), getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68330);
        ac.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ok");
        SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, paramString, paramArrayList);
        AppMethodBeat.o(68330);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68331);
        ac.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() cancel");
        AppMethodBeat.o(68331);
      }
    });
    AppMethodBeat.o(68346);
  }
  
  private static boolean aI(List<String> paramList)
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
    } while (!bs.lr((String)paramList.next(), com.tencent.mm.model.u.axw()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(68350);
      return bool;
    }
  }
  
  private boolean aOn()
  {
    return this.fromScene == 3;
  }
  
  private void ary(String paramString)
  {
    AppMethodBeat.i(68345);
    ac.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { paramString });
    if (aOn())
    {
      if (!w.sQ(paramString))
      {
        if (this.wSQ.contains(paramString))
        {
          if (this.wSQ.size() == 1)
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
        dyE();
        AppMethodBeat.o(68345);
        return;
      }
      localObject = FO(paramString);
      if (!aI((List)localObject))
      {
        dyE();
        ac.e("MicroMsg.SelectRemittanceContactUI", "self no in chatroom(%s)", new Object[] { paramString });
        AppMethodBeat.o(68345);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.wSQ.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)localObject).contains(str)) {
          localArrayList.add(str);
        }
      }
      if (localArrayList.size() == 0)
      {
        dyE();
        AppMethodBeat.o(68345);
        return;
      }
      if (localArrayList.size() == this.wSQ.size())
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
    ac.i("MicroMsg.SelectRemittanceContactUI", "showLaunchComfirmDialog()");
    String str = paramString2;
    if (bs.isNullOrNil(paramString2)) {
      str = getString(2131760652);
    }
    ((i)com.tencent.mm.kernel.g.ab(i.class)).a(getController(), paramString1, getString(2131755032) + str, getString(2131755031), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(68333);
        if (paramAnonymousBoolean)
        {
          SelectRemittanceContactUI.a(SelectRemittanceContactUI.this, paramString1, paramArrayList);
          SelectRemittanceContactUI.qF(12);
          AppMethodBeat.o(68333);
          return;
        }
        SelectRemittanceContactUI.qF(13);
        AppMethodBeat.o(68333);
      }
    });
    qF(11);
    AppMethodBeat.o(68348);
  }
  
  private void dyE()
  {
    AppMethodBeat.i(68347);
    qF(16);
    com.tencent.mm.ui.base.h.a(this, getString(2131765855), "", getString(2131766205), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68332);
        ac.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick()");
        AppMethodBeat.o(68332);
      }
    });
    AppMethodBeat.o(68347);
  }
  
  public static void qF(int paramInt)
  {
    AppMethodBeat.i(68351);
    bq localbq = new bq();
    localbq.dNg = paramInt;
    localbq.aHZ();
    AppMethodBeat.o(68351);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(68335);
    super.WJ();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject = getIntent().getStringExtra("recent_remittance_contact_list");
    ac.v("MicroMsg.SelectRemittanceContactUI", "recent list:".concat(String.valueOf(localObject)));
    this.wQn = new ArrayList();
    if (!bs.isNullOrNil((String)localObject)) {
      this.wQn = bs.S(((String)localObject).split(","));
    }
    if (aOn())
    {
      this.title = getIntent().getStringExtra("key_title");
      localObject = getIntent().getStringExtra("key_include_username_list");
      this.wSQ = new ArrayList();
      if (!bs.isNullOrNil((String)localObject)) {
        this.wSQ = bs.S(((String)localObject).split(","));
      }
    }
    localObject = new HashSet();
    ((HashSet)localObject).addAll(com.tencent.mm.ui.contact.u.frC());
    ((HashSet)localObject).addAll(com.tencent.mm.ui.contact.u.frD());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!bs.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bs.S(str.split(",")));
    }
    this.fzw = new ArrayList();
    this.fzw.addAll((Collection)localObject);
    AppMethodBeat.o(68335);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(68341);
    super.a(paramListView, paramInt);
    View localView;
    TextView localTextView;
    if (this.uza == null)
    {
      localView = View.inflate(this, 2131495341, null);
      this.uza = localView.findViewById(2131298739);
      localTextView = (TextView)localView.findViewById(2131305880);
      if ((this.fromScene != 1) && (this.fromScene != 3)) {
        break label95;
      }
      localTextView.setText(2131765851);
    }
    for (;;)
    {
      paramListView.addHeaderView(localView);
      this.uza.setVisibility(paramInt);
      AppMethodBeat.o(68341);
      return;
      label95:
      localTextView.setText(2131762495);
    }
  }
  
  public final boolean aOi()
  {
    return true;
  }
  
  public final boolean aOj()
  {
    return false;
  }
  
  public final String aOk()
  {
    AppMethodBeat.i(68340);
    if ((this.fromScene == 1) || (this.fromScene == 3))
    {
      str = getString(2131765858);
      AppMethodBeat.o(68340);
      return str;
    }
    String str = getString(2131762535);
    AppMethodBeat.o(68340);
    return str;
  }
  
  public final q aOl()
  {
    AppMethodBeat.i(68336);
    g localg = new g(this, this.wQn, this.fzw, this.fromScene);
    AppMethodBeat.o(68336);
    return localg;
  }
  
  public final o aOm()
  {
    AppMethodBeat.i(68337);
    s locals = new s(this, this.fzw, false, this.scene);
    AppMethodBeat.o(68337);
    return locals;
  }
  
  public final int[] daw()
  {
    if ((this.fromScene == 1) || (this.fromScene == 3)) {
      return new int[] { 131072, 131075 };
    }
    return new int[] { 131072 };
  }
  
  public final void dax()
  {
    AppMethodBeat.i(68342);
    super.dax();
    hideVKB();
    AppMethodBeat.o(68342);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68339);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ac.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        ac.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        if (aOn())
        {
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          if (!bs.isNullOrNil(paramIntent)) {
            ary(paramIntent);
          }
          AppMethodBeat.o(68339);
          return;
          ac.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
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
    ac.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
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
      dax();
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
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(68338);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ac.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      ac.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      localObject1 = new Intent();
      if ((this.fromScene == 1) || (this.fromScene == 3))
      {
        ((Intent)localObject1).putExtra("list_attr", com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.IwO, 16384, 64, 4096, 262144 }));
        ((Intent)localObject1).putExtra("min_limit_num", 1);
        ((Intent)localObject1).putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        ((Intent)localObject1).putExtra("titile", getString(2131765860));
        ((Intent)localObject1).putExtra("without_openim", true);
      }
      for (;;)
      {
        d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject1, 1);
        overridePendingTransition(2130772108, 2130772048);
        AppMethodBeat.o(68338);
        return;
        paramInt = com.tencent.mm.ui.contact.u.I(new int[] { 16, 1, 2, 4, 16384 });
        ((Intent)localObject1).putExtra("list_type", 0);
        ((Intent)localObject1).putExtra("list_attr", paramInt);
        ((Intent)localObject1).putExtra("titile", getString(2131762531));
        ((Intent)localObject1).putExtra("sub_title", getString(2131765935));
      }
    }
    Object localObject1 = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject1 == null)
    {
      AppMethodBeat.o(68338);
      return;
    }
    Object localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact;
    if (localObject2 == null)
    {
      AppMethodBeat.o(68338);
      return;
    }
    localObject1 = ((av)localObject2).field_username;
    if ((com.tencent.mm.storage.ai.aNd((String)localObject1)) || (com.tencent.mm.storage.ai.aNc((String)localObject1)))
    {
      ac.i("MicroMsg.SelectRemittanceContactUI", "username[%s] is openime || oepnimechatroom", new Object[] { bs.bG((String)localObject1, "null") });
      localObject2 = com.tencent.mm.sdk.platformtools.ai.getContext();
      if (com.tencent.mm.storage.ai.aNd((String)localObject1)) {}
      for (localObject1 = ((Context)localObject2).getString(2131765857);; localObject1 = ((Context)localObject2).getString(2131765856))
      {
        com.tencent.mm.ui.base.h.a(this, (String)localObject1, "", getString(2131766205), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(68329);
            ac.i("MicroMsg.SelectRemittanceContactUI", "onDialogClick() ");
            AppMethodBeat.o(68329);
          }
        });
        AppMethodBeat.o(68338);
        return;
      }
    }
    ary(((av)localObject2).field_username);
    if ((frq() instanceof g))
    {
      paramInt -= getContentLV().getHeaderViewsCount();
      localObject1 = (g)frq();
      ac.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[] { Integer.valueOf(paramInt) });
      if (((g)localObject1).wQl < 0) {
        break label547;
      }
      if (((g)localObject1).wQm >= 0) {
        break label526;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        com.tencent.mm.plugin.report.service.h.wUl.f(13721, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
      }
      AppMethodBeat.o(68338);
      return;
      label526:
      if ((paramInt > ((g)localObject1).wQl) && (paramInt < ((g)localObject1).wQm)) {
        paramInt = 1;
      } else {
        label547:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI
 * JD-Core Version:    0.7.0.1
 */