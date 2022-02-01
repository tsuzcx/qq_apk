package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

public class ShakeSayHiListUI
  extends MMActivity
{
  private ListView iIZ;
  private int limit;
  private long mWU;
  private n.d ntM;
  private int vkh;
  private int vki;
  private int xBG;
  private b xBH;
  private by xzy;
  
  public ShakeSayHiListUI()
  {
    AppMethodBeat.i(28553);
    this.xBG = 0;
    this.xzy = null;
    this.limit = 0;
    this.vkh = 0;
    this.vki = 0;
    this.ntM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28543);
        d.aJg().alc(String.valueOf(ShakeSayHiListUI.g(ShakeSayHiListUI.this)));
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).a(null, null);
        AppMethodBeat.o(28543);
      }
    };
    AppMethodBeat.o(28553);
  }
  
  public int getLayoutId()
  {
    return 2131494580;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28559);
    Object localObject = getLayoutInflater().inflate(2131495281, null);
    this.iIZ = ((ListView)findViewById(2131304293));
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28542);
        ShakeSayHiListUI.a(ShakeSayHiListUI.this, ShakeSayHiListUI.a(ShakeSayHiListUI.this) + 8);
        ac.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).NO(ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        if (ShakeSayHiListUI.c(ShakeSayHiListUI.this) <= ShakeSayHiListUI.a(ShakeSayHiListUI.this))
        {
          ShakeSayHiListUI.d(ShakeSayHiListUI.this).removeFooterView(this.vkl);
          ac.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        }
        AppMethodBeat.o(28542);
      }
    });
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28545);
        h.a(ShakeSayHiListUI.this.getContext(), true, ShakeSayHiListUI.this.getString(2131762787), "", ShakeSayHiListUI.this.getString(2131762786), ShakeSayHiListUI.this.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28544);
            ShakeSayHiListUI.e(ShakeSayHiListUI.this).aZf();
            ShakeSayHiListUI.b(ShakeSayHiListUI.this).Xb();
            paramAnonymous2DialogInterface = (TextView)ShakeSayHiListUI.this.findViewById(2131299468);
            paramAnonymous2DialogInterface.setText(2131762792);
            paramAnonymous2DialogInterface.setVisibility(0);
            ShakeSayHiListUI.this.enableOptionMenu(false);
            AppMethodBeat.o(28544);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        });
        AppMethodBeat.o(28545);
        return true;
      }
    });
    if (this.vkh == 0)
    {
      TextView localTextView = (TextView)findViewById(2131299468);
      localTextView.setText(2131762792);
      localTextView.setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.vkh > 0) && (this.limit < this.vkh)) {
      this.iIZ.addFooterView((View)localObject);
    }
    this.xBH = new b(this, this.xzy, this.limit);
    this.xBH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dy(View paramAnonymousView)
      {
        AppMethodBeat.i(28546);
        int i = ShakeSayHiListUI.d(ShakeSayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(28546);
        return i;
      }
    });
    this.xBH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28547);
        ShakeSayHiListUI.d(ShakeSayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(28547);
      }
    });
    this.xBH.a(new MMSlideDelView.f()
    {
      public final void cN(Object paramAnonymousObject)
      {
        AppMethodBeat.i(28548);
        if (paramAnonymousObject == null)
        {
          ac.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(28548);
          return;
        }
        d.aJg().alc(paramAnonymousObject.toString());
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).a(null, null);
        AppMethodBeat.o(28548);
      }
    });
    this.iIZ.setAdapter(this.xBH);
    this.iIZ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28549);
        paramAnonymousAdapterView = (bx)ShakeSayHiListUI.b(ShakeSayHiListUI.this).getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.field_content == null))
        {
          AppMethodBeat.o(28549);
          return;
        }
        paramAnonymousView = bo.d.aOn(paramAnonymousAdapterView.field_content);
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousView.zTO);
        localIntent.putExtra("Contact_Encryptusername", paramAnonymousView.GZm);
        localIntent.putExtra("Contact_Alias", paramAnonymousView.eNf);
        localIntent.putExtra("Contact_Nick", paramAnonymousView.nickname);
        localIntent.putExtra("Contact_QuanPin", paramAnonymousView.iLM);
        localIntent.putExtra("Contact_PyInitial", paramAnonymousView.iLL);
        localIntent.putExtra("Contact_Sex", paramAnonymousView.exL);
        localIntent.putExtra("Contact_Signature", paramAnonymousView.signature);
        localIntent.putExtra("Contact_Scene", paramAnonymousView.scene);
        localIntent.putExtra("Contact_FMessageCard", true);
        localIntent.putExtra("Contact_City", paramAnonymousView.getCity());
        localIntent.putExtra("Contact_Province", paramAnonymousView.getProvince());
        if (bs.isNullOrNil(paramAnonymousAdapterView.field_sayhicontent)) {}
        for (paramAnonymousAdapterView = ShakeSayHiListUI.this.getString(2131757177);; paramAnonymousAdapterView = paramAnonymousAdapterView.field_sayhicontent)
        {
          localIntent.putExtra("Contact_Content", paramAnonymousAdapterView);
          localIntent.putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          localIntent.putExtra("Contact_Uin", paramAnonymousView.vLk);
          localIntent.putExtra("Contact_QQNick", paramAnonymousView.iLN);
          localIntent.putExtra("Contact_Mobile_MD5", paramAnonymousView.GYX);
          localIntent.putExtra("User_From_Fmessage", true);
          localIntent.putExtra("Contact_from_msgType", 37);
          localIntent.putExtra("Verify_ticket", paramAnonymousView.sBi);
          localIntent.putExtra("Contact_ShowFMessageList", true);
          localIntent.putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          az.ayM();
          paramAnonymousAdapterView = c.awB().aNt(paramAnonymousView.zTO);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.fLJ >= 0) && (!com.tencent.mm.n.b.ln(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.dgL;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              localIntent.putExtra("User_Verify", true);
            }
            localIntent.putExtra("Contact_IsLBSFriend", true);
            localIntent.putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.shake.a.iyx.c(localIntent, ShakeSayHiListUI.this);
          AppMethodBeat.o(28549);
          return;
        }
      }
    });
    localObject = new com.tencent.mm.ui.tools.l(this);
    this.iIZ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28550);
        if (paramAnonymousInt < ShakeSayHiListUI.d(ShakeSayHiListUI.this).getHeaderViewsCount())
        {
          ac.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(28550);
          return true;
        }
        this.ntP.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeSayHiListUI.this, ShakeSayHiListUI.f(ShakeSayHiListUI.this));
        AppMethodBeat.o(28550);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28551);
        ShakeSayHiListUI.this.hideVKB();
        ShakeSayHiListUI.this.finish();
        AppMethodBeat.o(28551);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28552);
        paramAnonymousView = ShakeSayHiListUI.d(ShakeSayHiListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$9", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(28552);
      }
    });
    AppMethodBeat.o(28559);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28554);
    super.onCreate(paramBundle);
    this.xBG = getIntent().getIntExtra("IntentSayHiType", 1);
    if (this.xBG == 1)
    {
      this.xzy = d.aJg();
      setMMTitle(2131762791);
      this.vki = this.xzy.bQe();
      if (this.vki != 0) {
        break label161;
      }
    }
    label161:
    for (int i = 8;; i = this.vki)
    {
      this.limit = i;
      this.vkh = this.xzy.getCount();
      paramBundle = this.xzy;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(28554);
      return;
      setMMTitle(2131762789);
      break;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28560);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.mWU = ((bx)this.xBH.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755707);
    AppMethodBeat.o(28560);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28556);
    this.xBH.cVi();
    super.onDestroy();
    AppMethodBeat.o(28556);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28558);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(28558);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(28557);
    super.onPause();
    if (this.xBH.ntD != null) {
      this.xBH.ntD.cVr();
    }
    AppMethodBeat.o(28557);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28555);
    super.onResume();
    if (this.vkh != this.xzy.getCount())
    {
      this.vkh = this.xzy.getCount();
      if (this.vkh == 0)
      {
        TextView localTextView = (TextView)findViewById(2131299468);
        localTextView.setText(2131762792);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.xBH.Xb();
    }
    this.xBH.notifyDataSetChanged();
    AppMethodBeat.o(28555);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI
 * JD-Core Version:    0.7.0.1
 */