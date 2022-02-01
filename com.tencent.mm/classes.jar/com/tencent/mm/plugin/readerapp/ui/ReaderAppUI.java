package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.ay.t;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.readerapp.a.b;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.f;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.readerapp.a.h;
import com.tencent.mm.plugin.readerapp.c.b;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.model.w;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.v.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@k
@com.tencent.mm.ui.widget.pulldown.c(0)
public class ReaderAppUI
  extends MMActivity
{
  private static float density;
  private ListView ETt;
  private MMPullDownView ETx;
  private String Env;
  private a<String> Hyu;
  private com.tencent.mm.pluginsdk.ui.f Hyv;
  private int Hyw;
  private int fQM;
  private View mXN;
  private q.g sBv;
  private com.tencent.mm.ui.widget.b.a szq;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(102751);
    this.fQM = 0;
    this.Env = "";
    this.Hyv = null;
    this.Hyw = 0;
    this.sBv = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(161679);
        paramAnonymousInt = paramAnonymousMenuItem.getGroupId();
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(161679);
          return;
          Object localObject1 = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
          if (!Util.isNullOrNil((String)localObject1))
          {
            g.fK((String)localObject1, ReaderAppUI.a(ReaderAppUI.this));
            paramAnonymousMenuItem = g.ftN();
            paramAnonymousInt = ReaderAppUI.a(ReaderAppUI.this);
            localObject1 = "delete from " + bx.vb(paramAnonymousInt) + " where reserved3 = " + com.tencent.mm.storagebase.h.Mi((String)localObject1);
            Log.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
            if (paramAnonymousMenuItem.lvy.execSQL(bx.vb(paramAnonymousInt), (String)localObject1))
            {
              paramAnonymousMenuItem.vf(paramAnonymousInt);
              paramAnonymousMenuItem.doNotify();
            }
          }
          ReaderAppUI.this.bfU();
          AppMethodBeat.o(161679);
          return;
          if (ReaderAppUI.a(ReaderAppUI.this) == 20)
          {
            paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
            paramAnonymousMenuItem = g.ftN().aD(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
            Object localObject2;
            if (paramAnonymousMenuItem.size() > 0)
            {
              paramAnonymousMenuItem = (com.tencent.mm.model.bw)paramAnonymousMenuItem.get(0);
              localObject1 = new k.b();
              ((k.b)localObject1).title = paramAnonymousMenuItem.getTitle();
              ((k.b)localObject1).description = paramAnonymousMenuItem.getDigest();
              ((k.b)localObject1).action = "view";
              ((k.b)localObject1).type = 5;
              ((k.b)localObject1).url = paramAnonymousMenuItem.getUrl();
              localObject2 = k.b.a((k.b)localObject1, null, null);
              localObject1 = new Intent();
              ((Intent)localObject1).putExtra("Retr_Msg_content", (String)localObject2);
              ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
              ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", w.bpO(paramAnonymousMenuItem.bfg()));
              ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
              localObject2 = ad.Rp(paramAnonymousMenuItem.lvs);
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              localObject2 = ad.beh().I((String)localObject2, true);
              ((ad.b)localObject2).k("prePublishId", "msg_" + paramAnonymousMenuItem.lvs);
              ((ad.b)localObject2).k("preUsername", "newsapp");
              ((ad.b)localObject2).k("preChatName", "newsapp");
              ((ad.b)localObject2).k("preMsgIndex", Integer.valueOf(0));
              ((ad.b)localObject2).k("sendAppMsgScene", Integer.valueOf(1));
              com.tencent.mm.plugin.readerapp.b.a.mIG.j((Intent)localObject1, ReaderAppUI.this);
            }
            AppMethodBeat.o(161679);
            return;
            if (ReaderAppUI.a(ReaderAppUI.this) == 20)
            {
              paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
              localObject1 = g.ftN().aD(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
              if (!((List)localObject1).isEmpty())
              {
                Log.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ReaderAppUI.d(ReaderAppUI.this)), Integer.valueOf(((List)localObject1).size()) });
                if (ReaderAppUI.d(ReaderAppUI.this) >= ((List)localObject1).size()) {
                  ReaderAppUI.a(ReaderAppUI.this, 0);
                }
                paramAnonymousMenuItem = (com.tencent.mm.model.bw)((List)localObject1).get(ReaderAppUI.d(ReaderAppUI.this));
                localObject1 = new dd();
                localObject2 = ad.Rp(paramAnonymousMenuItem.lvs);
                ad.b localb = ad.beh().I((String)localObject2, true);
                localb.k("prePublishId", "msg_" + paramAnonymousMenuItem.lvs);
                localb.k("preUsername", "newsapp");
                localb.k("preChatName", "newsapp");
                localb.k("preMsgIndex", Integer.valueOf(0));
                localb.k("sendAppMsgScene", Integer.valueOf(1));
                ((dd)localObject1).fyI.sessionId = ((String)localObject2);
                ReaderAppUI.d(ReaderAppUI.this);
                b.a((dd)localObject1, paramAnonymousMenuItem);
                ((dd)localObject1).fyI.fyP = 7;
                ((dd)localObject1).fyI.activity = ReaderAppUI.this;
                EventCenter.instance.publish((IEvent)localObject1);
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(102751);
  }
  
  private PackageInfo aVr(String paramString)
  {
    AppMethodBeat.i(102759);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(102759);
      return null;
    }
    try
    {
      paramString = getContext().getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(102759);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      Log.printErrStackTrace("MicroMsg.ReaderAppUI", paramString, "", new Object[0]);
      AppMethodBeat.o(102759);
    }
    return null;
  }
  
  public final View.OnClickListener a(com.tencent.mm.model.bw parambw, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(102758);
    if (parambw != null)
    {
      String str1 = ab.aXb(parambw.getUrl());
      String str2 = ab.aXb(paramString);
      String str3 = ab.aXb(parambw.getTitle());
      com.tencent.mm.plugin.report.service.h.IzE.a(15413, new Object[] { Integer.valueOf(9), str2, str3, parambw.aCt(), parambw.bfc(), str1, Integer.valueOf(parambw.bfk()), Integer.valueOf(parambw.bfi()) });
    }
    parambw = new ReaderAppUI.2(this, paramInt1, paramString, parambw, paramInt2);
    AppMethodBeat.o(102758);
    return parambw;
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(102756);
    ScrollView localScrollView = (ScrollView)findViewById(a.e.empty_msg_tip_tv);
    if (this.Hyu.getCount() == 0)
    {
      this.ETx.setVisibility(8);
      localScrollView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.ETt != null) && ((this.Hyu instanceof a))) {
        this.ETt.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161678);
            ((ReaderAppUI.a)ReaderAppUI.c(ReaderAppUI.this)).iV(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition(), ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition());
            AppMethodBeat.o(161678);
          }
        });
      }
      AppMethodBeat.o(102756);
      return;
      localScrollView.setVisibility(8);
      this.ETx.setVisibility(0);
    }
  }
  
  public int getLayoutId()
  {
    return a.f.HxL;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102757);
    try
    {
      this.Hyv = new com.tencent.mm.pluginsdk.ui.f(Util.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
      this.ETt = ((ListView)findViewById(a.e.HxB));
      this.ETx = ((MMPullDownView)findViewById(a.e.HxD));
      this.ETx.setIsReturnSuperDispatchWhenCancel(true);
      this.mXN = getLayoutInflater().inflate(a.f.HxM, null);
      this.ETt.addHeaderView(this.mXN);
      this.Hyu = new a(this, "");
      this.ETt.setOnScrollListener(this.Hyu);
      this.ETt.setAdapter(this.Hyu);
      this.ETt.setTranscriptMode(0);
      registerForContextMenu(this.ETt);
      this.szq = new com.tencent.mm.ui.widget.b.a(this);
      this.szq.Yri = true;
      this.ETx.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean cOM()
        {
          AppMethodBeat.i(161680);
          if (ReaderAppUI.c(ReaderAppUI.this).cJI())
          {
            ReaderAppUI.b(ReaderAppUI.this).setSelectionFromTop(0, ReaderAppUI.e(ReaderAppUI.this).getTopHeight());
            AppMethodBeat.o(161680);
            return true;
          }
          int i = ReaderAppUI.c(ReaderAppUI.this).getCount();
          int j = ReaderAppUI.c(ReaderAppUI.this).cJJ();
          Log.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(j)));
          ReaderAppUI.c(ReaderAppUI.this).onNotifyChange(null, null);
          int k = ReaderAppUI.c(ReaderAppUI.this).getCount();
          Log.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          if (k > i)
          {
            Log.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.e(ReaderAppUI.this).getTopHeight()) });
            r.a(ReaderAppUI.b(ReaderAppUI.this), j + 1, ReaderAppUI.e(ReaderAppUI.this).getTopHeight(), false);
          }
          AppMethodBeat.o(161680);
          return true;
        }
      });
      this.ETx.setTopViewVisible(true);
      this.ETx.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean cOL()
        {
          AppMethodBeat.i(161681);
          View localView = ReaderAppUI.b(ReaderAppUI.this).getChildAt(ReaderAppUI.b(ReaderAppUI.this).getChildCount() - 1);
          if (localView == null)
          {
            AppMethodBeat.o(161681);
            return false;
          }
          if ((localView.getBottom() <= ReaderAppUI.b(ReaderAppUI.this).getHeight()) && (ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition() == ReaderAppUI.b(ReaderAppUI.this).getAdapter().getCount() - 1))
          {
            AppMethodBeat.o(161681);
            return true;
          }
          AppMethodBeat.o(161681);
          return false;
        }
      });
      this.ETx.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean cOK()
        {
          AppMethodBeat.i(161682);
          View localView = ReaderAppUI.b(ReaderAppUI.this).getChildAt(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition());
          if ((localView != null) && (localView.getTop() == 0))
          {
            AppMethodBeat.o(161682);
            return true;
          }
          AppMethodBeat.o(161682);
          return false;
        }
      });
      this.ETx.setIsBottomShowAll(true);
      this.Hyu.a(new v.a()
      {
        public final void bxN()
        {
          AppMethodBeat.i(161683);
          ReaderAppUI.e(ReaderAppUI.this).setIsTopShowAll(ReaderAppUI.c(ReaderAppUI.this).cJI());
          AppMethodBeat.o(161683);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(102724);
          ReaderAppUI.this.finish();
          AppMethodBeat.o(102724);
          return true;
        }
      });
      addIconOptionMenu(0, a.h.actionbar_setting, a.g.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(161684);
          com.tencent.mm.plugin.readerapp.b.a.mIG.c(new Intent().putExtra("Contact_User", ReaderAppUI.f(ReaderAppUI.this)), ReaderAppUI.this);
          AppMethodBeat.o(161684);
          return true;
        }
      });
      this.ETt.setSelection(this.Hyu.getShowCount() - 1 + this.ETt.getHeaderViewsCount());
      AppMethodBeat.o(102757);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102752);
    super.onCreate(paramBundle);
    this.fQM = getIntent().getIntExtra("type", 0);
    Log.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.fQM) });
    this.fQM = 20;
    density = com.tencent.mm.ci.a.getDensity(this);
    long l = System.currentTimeMillis();
    initView();
    Log.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.Env = com.tencent.mm.model.bw.va(this.fQM);
    if ((20 == this.fQM) && (ac.aM("newsapp", null) > 0)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(13440, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(102752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102753);
    if (this.Hyu != null)
    {
      this.Hyu.eKd();
      this.Hyu.hFC();
    }
    super.onDestroy();
    AppMethodBeat.o(102753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(102755);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().JP("");
    g.ftN().remove(this.Hyu);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwz(this.Env);
    AppMethodBeat.o(102755);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102754);
    super.onResume();
    if (this.fQM == 20) {
      setMMTitle(a.h.eHz);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().JP(this.Env);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().hg(this.Env);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().bwz(this.Env);
      g.ftN().add(this.Hyu);
      this.Hyu.onNotifyChange(null, null);
      bfU();
      AppMethodBeat.o(102754);
      return;
      setMMTitle(a.h.HxW);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends a<String>
  {
    private int HyC;
    private int HyD;
    private int HyE;
    int HyF;
    int HyG;
    int HyH;
    private Context context;
    private int jlf;
    private int sAs;
    private int sAt;
    private int sAu;
    private int sAv;
    private int sAx;
    private int tzm;
    
    public a(Context paramContext, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(102732);
      this.HyC = 0;
      this.sAv = 0;
      this.sAt = 0;
      this.sAu = 0;
      this.HyD = 0;
      this.HyE = 0;
      this.HyF = 0;
      this.HyG = 1;
      this.HyH = 2;
      this.context = paramContext;
      this.tzm = 3;
      this.jlf = g.ftN().vd(ReaderAppUI.a(ReaderAppUI.this));
      this.sAv = paramContext.getResources().getDimensionPixelSize(a.c.SmallPadding);
      this.sAt = paramContext.getResources().getDimensionPixelSize(a.c.LargePadding);
      this.HyC = paramContext.getResources().getDimensionPixelSize(a.c.BasicPaddingSize);
      this.sAu = paramContext.getResources().getDimensionPixelSize(a.c.MiddlePadding);
      this.sAs = paramContext.getResources().getDimensionPixelSize(a.c.chatting_item_biz_sub_item_pic_size);
      this.sAx = paramContext.getResources().getDimensionPixelSize(a.c.chatting_item_biz_line_big_padding);
      this$1 = com.tencent.mm.plugin.bizui.a.a.shG;
      int i = com.tencent.mm.plugin.bizui.a.a.eO(paramContext);
      int j = com.tencent.mm.ci.a.ks(paramContext);
      if (i < j) {}
      for (;;)
      {
        this.HyD = ((int)((i - (int)(ReaderAppUI.ftO() * 28.0F)) / 2.35D));
        this.HyE = ((int)((i - ReaderAppUI.ftO() * 52.0F) / 2.0F) * 4 / 3);
        AppMethodBeat.o(102732);
        return;
        i = j;
      }
    }
    
    private static void Y(View paramView, int paramInt)
    {
      AppMethodBeat.i(102741);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102741);
    }
    
    private static void Z(View paramView, int paramInt)
    {
      AppMethodBeat.i(102742);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.rightMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102742);
    }
    
    private static f.a a(com.tencent.mm.model.bw parambw)
    {
      AppMethodBeat.i(246367);
      if (parambw == null)
      {
        AppMethodBeat.o(246367);
        return null;
      }
      f.a locala = new f.a();
      locala.url = parambw.getUrl();
      locala.svv = 164;
      locala.appId = "wx073f4a4daff0abe8";
      locala.title = parambw.getTitle();
      locala.desc = parambw.getDigest();
      locala.from = "message";
      AppMethodBeat.o(246367);
      return locala;
    }
    
    private void a(a parama, int paramInt, List<com.tencent.mm.model.bw> paramList)
    {
      AppMethodBeat.i(102743);
      int i = paramList.size();
      if (paramInt == 1) {
        if (Util.isNullOrNil(((com.tencent.mm.model.bw)paramList.get(0)).bfg()))
        {
          parama.mrE.setVisibility(0);
          Z(parama.mrE, this.sAt);
        }
      }
      while (paramInt == 1) {
        if (paramInt == i - 1)
        {
          parama.vpA.setPadding(0, this.sAt, 0, this.sAt);
          AppMethodBeat.o(102743);
          return;
          parama.mrE.setVisibility(8);
          continue;
          parama.mrE.setVisibility(0);
          com.tencent.mm.model.bw localbw = (com.tencent.mm.model.bw)paramList.get(paramInt - 1);
          paramList = (com.tencent.mm.model.bw)paramList.get(paramInt);
          if ((Util.isNullOrNil(localbw.bfg())) || (Util.isNullOrNil(paramList.bfg()))) {
            Z(parama.mrE, this.sAt);
          } else {
            Z(parama.mrE, this.sAx);
          }
        }
        else
        {
          parama.vpA.setPadding(0, this.sAt, 0, this.sAv);
          AppMethodBeat.o(102743);
          return;
        }
      }
      if (paramInt == i - 1)
      {
        parama.vpA.setPadding(0, this.sAv, 0, this.sAt);
        AppMethodBeat.o(102743);
        return;
      }
      parama.vpA.setPadding(0, this.sAv, 0, this.sAv);
      AppMethodBeat.o(102743);
    }
    
    private static void a(b paramb, a parama)
    {
      AppMethodBeat.i(102731);
      if (paramb == null)
      {
        AppMethodBeat.o(102731);
        return;
      }
      paramb.HyM.addView(parama.sEi);
      paramb.sHn.add(parama);
      AppMethodBeat.o(102731);
    }
    
    private void a(b paramb, List<com.tencent.mm.model.bw> paramList, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(102740);
      a locala = new a();
      locala.sEi = View.inflate(this.context, paramInt1, null);
      if (paramInt1 == a.f.HxQ)
      {
        locala.sEi.setBackground(au.c(ReaderAppUI.this.getResources().getDrawable(a.d.chatting_item_multi_middle), aw.bh(ReaderAppUI.this.getContext(), a.a.item_color_selector)));
        locala.jMg = ((TextView)locala.sEi.findViewById(a.e.title));
        locala.sCR = ((ImageView)locala.sEi.findViewById(a.e.cover));
        locala.sGS = locala.sEi.findViewById(a.e.cover_area);
        locala.mrE = locala.sEi.findViewById(a.e.top_line);
        locala.vpA = locala.sEi.findViewById(a.e.content_ll);
        a(paramb, locala);
        paramb = (com.tencent.mm.model.bw)paramList.get(paramInt2);
        a(locala, paramInt2, paramList);
        locala.jMg.setText(paramb.getTitle());
        locala.jMg.setText(paramb.getTitle());
        if (Util.isNullOrNil(paramb.bfg())) {
          break label386;
        }
        locala.sCR.setVisibility(0);
        a(paramb.bfg(), locala.sCR, this.sAs, this.sAs);
      }
      for (;;)
      {
        paramList = ReaderAppUI.this.a(paramb, ReaderAppUI.a(ReaderAppUI.this), paramInt2, paramString);
        locala.sEi.setOnClickListener(paramList);
        paramList = (com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class);
        if (paramList != null)
        {
          paramList.a(paramb.getUrl(), 164, "wx073f4a4daff0abe8", paramb.getTitle(), paramb.getDigest(), "message", 16);
          paramList.da(paramb.getUrl(), 16);
        }
        AppMethodBeat.o(102740);
        return;
        if (paramInt1 != a.f.HxP) {
          break;
        }
        locala.sEi.setBackground(au.c(ReaderAppUI.this.getResources().getDrawable(a.d.chatting_item_multi_bottom), aw.bh(ReaderAppUI.this.getContext(), a.a.item_color_selector)));
        break;
        label386:
        locala.sGS.setVisibility(8);
      }
    }
    
    private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102744);
      paramString = t.Wm(paramString);
      com.tencent.mm.ay.a.a locala = q.bml();
      c.a locala1 = new c.a();
      locala1.lRS = a.b.chatting_item_biz_default_bg;
      locala1.lRD = true;
      locala1 = locala1.dO(paramInt1, paramInt2);
      locala1.lRs = new com.tencent.mm.pluginsdk.ui.applet.n();
      locala1.lSb = new e();
      locala1.fullPath = w.bpO(paramString);
      locala.a(paramString, paramImageView, locala1.bmL(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte)0));
      AppMethodBeat.o(102744);
    }
    
    private List<com.tencent.mm.model.bw> abW(int paramInt)
    {
      AppMethodBeat.i(102739);
      Object localObject = getItem(paramInt);
      localObject = g.ftN().aD((String)localObject, 20);
      AppMethodBeat.o(102739);
      return localObject;
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(102736);
      String str = (String)super.getItem(paramInt);
      AppMethodBeat.o(102736);
      return str;
    }
    
    public final void atr()
    {
      AppMethodBeat.i(102735);
      long l = System.currentTimeMillis();
      this.jlf = g.ftN().vd(20);
      v(g.ftN().vc(this.tzm));
      Log.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.tzm), Integer.valueOf(this.jlf) });
      super.notifyDataSetChanged();
      AppMethodBeat.o(102735);
    }
    
    public final void ats()
    {
      AppMethodBeat.i(102733);
      atr();
      AppMethodBeat.o(102733);
    }
    
    public final boolean cJI()
    {
      return this.tzm >= this.jlf;
    }
    
    public final int cJJ()
    {
      AppMethodBeat.i(102734);
      if (cJI())
      {
        AppMethodBeat.o(102734);
        return 0;
      }
      this.tzm += 3;
      if (this.tzm <= this.jlf)
      {
        AppMethodBeat.o(102734);
        return 3;
      }
      this.tzm = this.jlf;
      int i = this.jlf;
      AppMethodBeat.o(102734);
      return i % 3;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102737);
      List localList = abW(paramInt);
      if (Util.isNullOrNil(localList))
      {
        Log.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
        paramInt = this.HyF;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      if (((com.tencent.mm.model.bw)localList.get(0)).bfi() == 1) {}
      for (paramInt = 1; (paramInt != 0) && (localList.size() >= 2); paramInt = 0)
      {
        paramInt = this.HyG;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      paramInt = this.HyF;
      AppMethodBeat.o(102737);
      return paramInt;
    }
    
    public final int getShowCount()
    {
      return this.tzm;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102738);
      if (getItemViewType(paramInt) == this.HyG)
      {
        if (paramView == null)
        {
          paramViewGroup = new b();
          paramView = View.inflate(this.context, a.f.HxO, null);
          paramViewGroup.sGk = ((TextView)paramView.findViewById(a.e.HxK));
          paramViewGroup.jiu = ((ImageView)paramView.findViewById(a.e.avatar_iv));
          paramViewGroup.mUy = ((TextView)paramView.findViewById(a.e.nick_name_tv));
          paramViewGroup.HyP = new c();
          paramViewGroup.HyP.sDd = paramView.findViewById(a.e.Hxs);
          paramViewGroup.HyP.ftP();
          paramViewGroup.HyQ = new c();
          paramViewGroup.HyQ.sDd = paramView.findViewById(a.e.Hxt);
          paramViewGroup.HyQ.ftP();
          paramView.setTag(paramViewGroup);
          localObject2 = abW(paramInt);
          if ((localObject2 == null) || (((List)localObject2).size() < 2)) {
            break label486;
          }
          paramView.setVisibility(0);
          localObject1 = (com.tencent.mm.model.bw)((List)localObject2).get(0);
          paramViewGroup.sGk.setText(com.tencent.mm.pluginsdk.j.f.d(this.context, ((com.tencent.mm.model.bw)localObject1).time, false));
          localObject3 = new c.a();
          ((c.a)localObject3).lRS = a.d.brand_default_head;
          ((c.a)localObject3).lRC = true;
          ((c.a)localObject3).kPz = true;
          q.bml().a(((com.tencent.mm.model.bw)localObject1).bff(), paramViewGroup.jiu, ((c.a)localObject3).bmL());
          paramViewGroup.mUy.setText(((com.tencent.mm.model.bw)localObject1).bfe());
          paramViewGroup.mUy.getPaint().setFakeBoldText(true);
          if (ReaderAppUI.i(ReaderAppUI.this) != null)
          {
            paramViewGroup.sGk.setTextColor(ReaderAppUI.i(ReaderAppUI.this).RbV);
            if (!ReaderAppUI.i(ReaderAppUI.this).RbW) {
              break label461;
            }
            paramViewGroup.sGk.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).RbX);
            label353:
            if (!ReaderAppUI.i(ReaderAppUI.this).RbY) {
              break label475;
            }
            paramViewGroup.sGk.setBackgroundResource(a.d.chat_tips_bg);
            paramViewGroup.sGk.setPadding(this.sAv, this.HyC, this.sAv, this.HyC);
          }
          label399:
          localObject2 = (com.tencent.mm.model.bw)((List)localObject2).get(1);
          paramViewGroup.HyP.a((com.tencent.mm.model.bw)localObject1, paramInt, ((com.tencent.mm.model.bw)localObject1).getTitle());
          paramViewGroup.HyQ.a((com.tencent.mm.model.bw)localObject2, paramInt, ((com.tencent.mm.model.bw)localObject1).getTitle());
        }
        for (;;)
        {
          AppMethodBeat.o(102738);
          return paramView;
          paramViewGroup = (b)paramView.getTag();
          break;
          label461:
          paramViewGroup.sGk.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label353;
          label475:
          paramViewGroup.sGk.setBackgroundColor(0);
          break label399;
          label486:
          paramView.setVisibility(8);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new b();
        paramView = View.inflate(this.context, a.f.HxN, null);
        paramViewGroup.sGk = ((TextView)paramView.findViewById(a.e.Hxz));
        paramViewGroup.HyM = ((ViewGroup)paramView.findViewById(a.e.Hxw));
        paramViewGroup.neN = paramView.findViewById(a.e.duA);
        paramViewGroup.sDp = paramView.findViewById(a.e.dCU);
        paramViewGroup.sDf = ((ImageView)paramView.findViewById(a.e.dRn));
        paramViewGroup.HyO = ((ImageView)paramView.findViewById(a.e.dCW));
        paramViewGroup.jMg = ((TextView)paramView.findViewById(a.e.HxA));
        paramViewGroup.HyL = ((ImageView)paramView.findViewById(a.e.Hxy));
        paramViewGroup.ETn = ((TextView)paramView.findViewById(a.e.Hxx));
        paramViewGroup.sDd = paramView.findViewById(a.e.dXU);
        paramViewGroup.HyN = ((MMNeat7extView)paramView.findViewById(a.e.dXy));
        paramViewGroup.sHn = new ArrayList();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.sHn.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          paramViewGroup.HyM.removeView(((a)localObject2).sEi);
        }
        paramViewGroup = (b)paramView.getTag();
      }
      paramViewGroup.sHn.clear();
      Object localObject1 = abW(paramInt);
      label923:
      label965:
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int k = ((List)localObject1).size();
        localObject2 = (com.tencent.mm.model.bw)((List)localObject1).get(0);
        paramViewGroup.sGk.setText(com.tencent.mm.pluginsdk.j.f.d(this.context, ((com.tencent.mm.model.bw)localObject2).time, false));
        if (ReaderAppUI.i(ReaderAppUI.this) != null)
        {
          paramViewGroup.sGk.setTextColor(ReaderAppUI.i(ReaderAppUI.this).RbV);
          if (ReaderAppUI.i(ReaderAppUI.this).RbW)
          {
            paramViewGroup.sGk.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).RbX);
            if (!ReaderAppUI.i(ReaderAppUI.this).RbY) {
              break label1460;
            }
            paramViewGroup.sGk.setBackgroundResource(a.d.chat_tips_bg);
            paramViewGroup.sGk.setPadding(this.sAv, this.HyC, this.sAv, this.HyC);
          }
        }
        else
        {
          localObject3 = ReaderAppUI.this.a((com.tencent.mm.model.bw)localObject2, ReaderAppUI.a(ReaderAppUI.this), 0, ((com.tencent.mm.model.bw)localObject2).getTitle());
          paramViewGroup.sDd.setOnClickListener((View.OnClickListener)localObject3);
          if (k != 1) {
            break label1471;
          }
          bool = true;
          paramViewGroup.jMg.setText(((com.tencent.mm.model.bw)localObject2).getTitle());
          paramViewGroup.ETn.setText(((com.tencent.mm.model.bw)localObject2).getDigest());
          if (Util.isNullOrNil(((com.tencent.mm.model.bw)localObject2).bfg())) {
            break label1477;
          }
          i = 1;
          label1003:
          paramViewGroup.HyN.aL(((com.tencent.mm.model.bw)localObject2).getTitle());
          localObject3 = paramViewGroup.ETn;
          if ((bool) && (!Util.isNullOrNil(((com.tencent.mm.model.bw)localObject2).getDigest()))) {
            break label1483;
          }
        }
        label1460:
        label1471:
        label1477:
        label1483:
        for (int j = 8;; j = 0)
        {
          ((TextView)localObject3).setVisibility(j);
          paramViewGroup.HyO.setVisibility(8);
          if (!bool) {
            break label1489;
          }
          paramViewGroup.sDf.setBackgroundResource(a.d.dng);
          paramViewGroup.neN.setVisibility(0);
          paramViewGroup.HyN.setVisibility(8);
          paramViewGroup.jMg.setVisibility(0);
          Y(paramViewGroup.sDf, this.HyD);
          Y(paramViewGroup.sDp, this.HyD);
          if (i == 0) {
            break label1591;
          }
          paramViewGroup.sDp.setVisibility(0);
          String str = ((com.tencent.mm.model.bw)localObject2).bfg();
          localObject3 = paramViewGroup.HyL;
          i = this.HyD;
          localObject4 = new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(246371);
              if (!bool)
              {
                paramViewGroup.HyN.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.white_text_color));
                paramViewGroup.HyN.setBackgroundResource(a.d.biz_msg_cover_gradient_mask);
              }
              paramViewGroup.HyO.setVisibility(0);
              AppMethodBeat.o(246371);
            }
            
            public final void onStart() {}
          };
          str = t.Wm(str);
          j = a.d.dml;
          int m = a.d.dmo;
          float f = ((ImageView)localObject3).getResources().getDimensionPixelSize(a.c.chatting_item_corners_size);
          Object localObject5 = com.tencent.mm.plugin.bizui.a.a.shG;
          int n = com.tencent.mm.plugin.bizui.a.a.eO(ReaderAppUI.this.getContext()) - (int)(ReaderAppUI.ftO() * 28.0F);
          localObject5 = q.bml();
          c.a locala = new c.a();
          locala.lRS = m;
          locala.lRD = true;
          locala.lRU = String.valueOf(j);
          locala = locala.dO(n, i);
          locala.lRs = new com.tencent.mm.pluginsdk.ui.applet.n();
          locala.lSb = new e();
          locala.fullPath = w.bpO(str);
          ((com.tencent.mm.ay.a.a)localObject5).a(str, (ImageView)localObject3, locala.bmL(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, n, i, true, false, f, (m.a)localObject4));
          paramViewGroup.neN.setBackground(au.e(ReaderAppUI.this.getResources().getDrawable(a.d.chatting_item_multbg_bottom_normal), this.context.getResources().getColor(a.b.BG_2)));
          paramViewGroup.neN.setPadding(this.sAt, this.sAu, this.sAt, this.sAt);
          paramViewGroup.sDf.setVisibility(0);
          if (k <= 1) {
            break label1724;
          }
          i = 1;
          while (i < k - 1)
          {
            a(paramViewGroup, (List)localObject1, a.f.HxQ, i, ((com.tencent.mm.model.bw)localObject2).getTitle());
            i += 1;
          }
          paramViewGroup.sGk.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break;
          paramViewGroup.sGk.setBackgroundColor(0);
          break label923;
          bool = false;
          break label965;
          i = 0;
          break label1003;
        }
        label1489:
        paramViewGroup.sDf.setBackgroundResource(a.d.dnh);
        localObject3 = paramViewGroup.neN;
        if (i != 0) {}
        for (j = 8;; j = 0)
        {
          ((View)localObject3).setVisibility(j);
          paramViewGroup.jMg.setVisibility(8);
          paramViewGroup.HyN.setVisibility(0);
          paramViewGroup.HyN.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.light_grey_text_color));
          paramViewGroup.HyN.setBackgroundResource(a.d.mm_trans);
          paramViewGroup.HyN.getPaint().setFakeBoldText(true);
          break;
        }
        label1591:
        paramViewGroup.sDp.setVisibility(8);
        paramViewGroup.jMg.setVisibility(0);
        localObject3 = paramViewGroup.ETn;
        if (Util.isNullOrNil(((com.tencent.mm.model.bw)localObject2).getDigest()))
        {
          i = 8;
          label1629:
          ((TextView)localObject3).setVisibility(i);
          if (!bool) {
            break label1692;
          }
          paramViewGroup.neN.setBackgroundResource(a.d.Hxr);
        }
        for (;;)
        {
          paramViewGroup.neN.setPadding(this.sAt, this.sAt, this.sAt, this.sAt);
          paramViewGroup.sDf.setVisibility(8);
          break;
          i = 0;
          break label1629;
          label1692:
          paramViewGroup.neN.setBackgroundResource(a.d.chatting_item_multi_top);
        }
        a(paramViewGroup, (List)localObject1, a.f.HxP, k - 1, ((com.tencent.mm.model.bw)localObject2).getTitle());
        label1724:
        localObject3 = (com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.brandservice.a.f)localObject3).a(((com.tencent.mm.model.bw)localObject2).getUrl(), 164, "wx073f4a4daff0abe8", ((com.tencent.mm.model.bw)localObject2).getTitle(), ((com.tencent.mm.model.bw)localObject2).getDigest(), "message", 8);
          ((com.tencent.mm.plugin.brandservice.a.f)localObject3).da(((com.tencent.mm.model.bw)localObject2).getUrl(), 8);
        }
      }
      paramViewGroup.sDd.setTag(Integer.valueOf(paramInt));
      paramViewGroup.sDd.setTag(a.e.HxC, Integer.valueOf(0));
      Object localObject2 = ReaderAppUI.h(ReaderAppUI.this);
      Object localObject3 = paramViewGroup.sDd;
      Object localObject4 = ReaderAppUI.this;
      if (((List)localObject1).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        paramViewGroup = paramViewGroup.sHn.iterator();
        i = 1;
        label1879:
        if (!paramViewGroup.hasNext()) {
          break label2005;
        }
        localObject3 = (a)paramViewGroup.next();
        ((a)localObject3).sEi.setTag(Integer.valueOf(paramInt));
        ((a)localObject3).sEi.setTag(a.e.HxC, Integer.valueOf(i));
        localObject2 = ReaderAppUI.h(ReaderAppUI.this);
        localObject3 = ((a)localObject3).sEi;
        localObject4 = ReaderAppUI.this;
        if (((List)localObject1).size() != 1) {
          break label1999;
        }
      }
      label1999:
      for (final boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        i += 1;
        break label1879;
        bool = false;
        break;
      }
      label2005:
      AppMethodBeat.o(102738);
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return this.HyH;
    }
    
    public final void iV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102746);
      Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth startPos = %s, endPos = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(102746);
        return;
      }
      com.tencent.mm.plugin.brandservice.a.f localf = (com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class);
      if (localf == null)
      {
        Log.v("MicroMsg.ReaderAppUI", "checkPreauth WebPrefetcher null");
        AppMethodBeat.o(102746);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 <= paramInt2)
      {
        List localList = abW(paramInt1 - 1);
        if ((localList != null) && (localList.size() > 0))
        {
          localLinkedList.clear();
          f.a locala = a((com.tencent.mm.model.bw)localList.get(0));
          if (locala != null)
          {
            localLinkedList.add(locala);
            localf.da(locala.url, 8);
          }
          if (localLinkedList.size() > 0) {
            localf.m(localLinkedList, 8);
          }
          Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
          localLinkedList.clear();
          int i = 1;
          while (i < localList.size())
          {
            locala = a((com.tencent.mm.model.bw)localList.get(i));
            if (locala != null)
            {
              localLinkedList.add(locala);
              localf.da(locala.url, 16);
            }
            i += 1;
          }
          if (localLinkedList.size() > 0) {
            localf.m(localLinkedList, 16);
          }
          Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authCommon = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
        }
        paramInt1 += 1;
      }
      AppMethodBeat.o(102746);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(102745);
      super.onScrollStateChanged(paramAbsListView, paramInt);
      if ((paramAbsListView != null) && (paramInt == 0)) {
        iV(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition());
      }
      AppMethodBeat.o(102745);
    }
    
    final class a
    {
      TextView jMg;
      View mrE;
      ImageView sCR;
      View sEi;
      View sGS;
      View vpA;
      
      a() {}
    }
    
    final class b
    {
      TextView ETn;
      ImageView HyL;
      ViewGroup HyM;
      MMNeat7extView HyN;
      ImageView HyO;
      ReaderAppUI.a.c HyP;
      ReaderAppUI.a.c HyQ;
      TextView jMg;
      ImageView jiu;
      TextView mUy;
      View neN;
      View sDd;
      ImageView sDf;
      View sDp;
      TextView sGk;
      List<ReaderAppUI.a.a> sHn;
      
      b() {}
    }
    
    final class c
    {
      View HyR;
      View HyS;
      ImageView HyT;
      ImageView HyU;
      MMNeat7extView HyV;
      TextView HyW;
      ImageView sDJ;
      View sDd;
      
      c() {}
      
      final void a(com.tencent.mm.model.bw parambw, int paramInt, String paramString)
      {
        AppMethodBeat.i(102730);
        paramString = ReaderAppUI.this.a(parambw, ReaderAppUI.a(ReaderAppUI.this), 0, paramString);
        if (this.sDd == null)
        {
          AppMethodBeat.o(102730);
          return;
        }
        this.sDd.setOnClickListener(paramString);
        this.sDd.setTag(Integer.valueOf(paramInt));
        this.sDd.setTag(a.e.HxC, Integer.valueOf(paramInt));
        ReaderAppUI.h(ReaderAppUI.this).a(this.sDd, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.g(ReaderAppUI.this));
        this.HyV.aL(parambw.getTitle());
        paramString = com.tencent.mm.aj.m.uD(parambw.bfj());
        if (!Util.isNullOrNil(paramString))
        {
          this.HyW.setText(paramString);
          this.HyR.setVisibility(0);
        }
        for (;;)
        {
          this.HyV.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.light_grey_text_color));
          this.HyS.setBackgroundResource(a.d.mm_trans);
          paramInt = (int)(this.HyW.getTextSize() * 1.7D);
          paramString = this.HyU.getLayoutParams();
          paramString.height = paramInt;
          paramString.width = paramInt;
          this.HyU.setLayoutParams(paramString);
          ReaderAppUI.a.av(this.sDJ, ReaderAppUI.a.a(ReaderAppUI.a.this));
          ReaderAppUI.a.a(ReaderAppUI.a.this, parambw.bfg(), this.sDJ, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102728);
              ReaderAppUI.a.c.this.HyV.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(a.b.white_text_color));
              ReaderAppUI.a.c.this.HyS.setBackgroundResource(a.d.weishi_cover_gradient_round_mask);
              AppMethodBeat.o(102728);
            }
            
            public final void onStart() {}
          });
          AppMethodBeat.o(102730);
          return;
          this.HyR.setVisibility(8);
        }
      }
      
      final void ftP()
      {
        AppMethodBeat.i(102729);
        if (this.sDd == null)
        {
          AppMethodBeat.o(102729);
          return;
        }
        this.sDJ = ((ImageView)this.sDd.findViewById(a.e.HxJ));
        this.HyT = ((ImageView)this.sDd.findViewById(a.e.dRn));
        this.HyV = ((MMNeat7extView)this.sDd.findViewById(a.e.dXy));
        this.HyW = ((TextView)this.sDd.findViewById(a.e.HxH));
        this.HyU = ((ImageView)this.sDd.findViewById(a.e.Hxu));
        this.HyR = this.sDd.findViewById(a.e.Hxv);
        this.HyS = this.sDd.findViewById(a.e.HxI);
        AppMethodBeat.o(102729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */