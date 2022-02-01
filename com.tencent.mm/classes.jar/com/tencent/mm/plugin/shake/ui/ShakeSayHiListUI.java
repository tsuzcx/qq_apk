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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.l;

public class ShakeSayHiListUI
  extends MMActivity
{
  private int AAs;
  private int AAt;
  private cm Djk;
  private int Dlr;
  private b Dls;
  private ListView kde;
  private int limit;
  private long oNJ;
  private o.g plk;
  
  public ShakeSayHiListUI()
  {
    AppMethodBeat.i(28553);
    this.Dlr = 0;
    this.Djk = null;
    this.limit = 0;
    this.AAs = 0;
    this.AAt = 0;
    this.plk = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(28543);
        d.bgP().aEp(String.valueOf(ShakeSayHiListUI.g(ShakeSayHiListUI.this)));
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(28543);
      }
    };
    AppMethodBeat.o(28553);
  }
  
  public int getLayoutId()
  {
    return 2131495207;
  }
  
  public void initView()
  {
    AppMethodBeat.i(28559);
    Object localObject = getLayoutInflater().inflate(2131496131, null);
    this.kde = ((ListView)findViewById(2131307221));
    ((View)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28542);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ShakeSayHiListUI.a(ShakeSayHiListUI.this, ShakeSayHiListUI.a(ShakeSayHiListUI.this) + 8);
        Log.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).XB(ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        if (ShakeSayHiListUI.c(ShakeSayHiListUI.this) <= ShakeSayHiListUI.a(ShakeSayHiListUI.this))
        {
          ShakeSayHiListUI.d(ShakeSayHiListUI.this).removeFooterView(this.AAw);
          Log.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(ShakeSayHiListUI.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28542);
      }
    });
    addTextOptionMenu(0, getString(2131755764), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(28545);
        h.a(ShakeSayHiListUI.this.getContext(), true, ShakeSayHiListUI.this.getString(2131764874), "", ShakeSayHiListUI.this.getString(2131764873), ShakeSayHiListUI.this.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(28544);
            ShakeSayHiListUI.e(ShakeSayHiListUI.this).byC();
            ShakeSayHiListUI.b(ShakeSayHiListUI.this).anp();
            paramAnonymous2DialogInterface = (TextView)ShakeSayHiListUI.this.findViewById(2131300096);
            paramAnonymous2DialogInterface.setText(2131764879);
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
    if (this.AAs == 0)
    {
      TextView localTextView = (TextView)findViewById(2131300096);
      localTextView.setText(2131764879);
      localTextView.setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.AAs > 0) && (this.limit < this.AAs)) {
      this.kde.addFooterView((View)localObject);
    }
    this.Dls = new b(this, this.Djk, this.limit);
    this.Dls.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(28546);
        int i = ShakeSayHiListUI.d(ShakeSayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(28546);
        return i;
      }
    });
    this.Dls.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28547);
        ShakeSayHiListUI.d(ShakeSayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(28547);
      }
    });
    this.Dls.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(28548);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.SayHiListUI", "onItemDel object null");
          AppMethodBeat.o(28548);
          return;
        }
        d.bgP().aEp(paramAnonymousObject.toString());
        ShakeSayHiListUI.b(ShakeSayHiListUI.this).onNotifyChange(null, null);
        AppMethodBeat.o(28548);
      }
    });
    this.kde.setAdapter(this.Dls);
    this.kde.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28549);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousAdapterView = (cl)ShakeSayHiListUI.b(ShakeSayHiListUI.this).getItem(paramAnonymousInt);
        if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.field_content == null))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
        }
        paramAnonymousView = ca.d.bkD(paramAnonymousAdapterView.field_content);
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.dkU);
        ((Intent)localObject).putExtra("Contact_Encryptusername", paramAnonymousView.OqZ);
        ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.fMb);
        ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.nickname);
        ((Intent)localObject).putExtra("Contact_QuanPin", paramAnonymousView.kfR);
        ((Intent)localObject).putExtra("Contact_PyInitial", paramAnonymousView.kfQ);
        ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.fuA);
        ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.signature);
        ((Intent)localObject).putExtra("Contact_Scene", paramAnonymousView.scene);
        ((Intent)localObject).putExtra("Contact_FMessageCard", true);
        ((Intent)localObject).putExtra("Contact_City", paramAnonymousView.getCity());
        ((Intent)localObject).putExtra("Contact_Province", paramAnonymousView.getProvince());
        if (Util.isNullOrNil(paramAnonymousAdapterView.field_sayhicontent)) {}
        for (paramAnonymousAdapterView = ShakeSayHiListUI.this.getString(2131757381);; paramAnonymousAdapterView = paramAnonymousAdapterView.field_sayhicontent)
        {
          ((Intent)localObject).putExtra("Contact_Content", paramAnonymousAdapterView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramAnonymousView.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramAnonymousView.Bge);
          ((Intent)localObject).putExtra("Contact_QQNick", paramAnonymousView.kfS);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramAnonymousView.OqK);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Verify_ticket", paramAnonymousView.wZz);
          ((Intent)localObject).putExtra("Contact_ShowFMessageList", true);
          ((Intent)localObject).putExtra("Contact_Source_FMessage", paramAnonymousView.scene);
          bg.aVF();
          paramAnonymousAdapterView = com.tencent.mm.model.c.aSN().Kn(paramAnonymousView.dkU);
          if ((paramAnonymousAdapterView != null) && ((int)paramAnonymousAdapterView.gMZ >= 0) && (!com.tencent.mm.contact.c.oR(paramAnonymousAdapterView.field_type)))
          {
            paramAnonymousInt = paramAnonymousView.dKy;
            if ((paramAnonymousInt == 0) || (paramAnonymousInt == 2) || (paramAnonymousInt == 5)) {
              ((Intent)localObject).putExtra("User_Verify", true);
            }
            ((Intent)localObject).putExtra("Contact_IsLBSFriend", true);
            ((Intent)localObject).putExtra("Sns_from_Scene", 18);
          }
          com.tencent.mm.plugin.shake.a.jRt.c((Intent)localObject, ShakeSayHiListUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeSayHiListUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28549);
          return;
        }
      }
    });
    localObject = new l(this);
    this.kde.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(28550);
        if (paramAnonymousInt < ShakeSayHiListUI.d(ShakeSayHiListUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
          AppMethodBeat.o(28550);
          return true;
        }
        this.pln.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ShakeSayHiListUI.this, ShakeSayHiListUI.f(ShakeSayHiListUI.this));
        AppMethodBeat.o(28550);
        return true;
      }
    });
    setBackBtn(new ShakeSayHiListUI.9(this));
    setToTop(new ShakeSayHiListUI.10(this));
    AppMethodBeat.o(28559);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28554);
    super.onCreate(paramBundle);
    this.Dlr = getIntent().getIntExtra("IntentSayHiType", 1);
    if (this.Dlr == 1)
    {
      this.Djk = d.bgP();
      setMMTitle(2131764878);
      this.AAt = this.Djk.ctM();
      if (this.AAt != 0) {
        break label161;
      }
    }
    label161:
    for (int i = 8;; i = this.AAt)
    {
      this.limit = i;
      this.AAs = this.Djk.getCount();
      paramBundle = this.Djk;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(28554);
      return;
      setMMTitle(2131764876);
      break;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(28560);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.oNJ = ((cl)this.Dls.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131755778);
    AppMethodBeat.o(28560);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28556);
    this.Dls.ebf();
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
    if (this.Dls.plb != null) {
      this.Dls.plb.ebo();
    }
    AppMethodBeat.o(28557);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(28555);
    super.onResume();
    if (this.AAs != this.Djk.getCount())
    {
      this.AAs = this.Djk.getCount();
      if (this.AAs == 0)
      {
        TextView localTextView = (TextView)findViewById(2131300096);
        localTextView.setText(2131764879);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.Dls.anp();
    }
    this.Dls.notifyDataSetChanged();
    AppMethodBeat.o(28555);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI
 * JD-Core Version:    0.7.0.1
 */