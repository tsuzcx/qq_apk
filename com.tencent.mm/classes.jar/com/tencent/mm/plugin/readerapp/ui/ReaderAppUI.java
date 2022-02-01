package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html.ImageGetter;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.av.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.brandservice.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.readerapp.c.b;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.m.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.s.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@i
public class ReaderAppUI
  extends MMActivity
{
  private static float density;
  private a<String> BCq;
  private com.tencent.mm.pluginsdk.ui.f BCr;
  private int BCs;
  private int dXa;
  private View kgo;
  private com.tencent.mm.ui.widget.b.a pqr;
  private o.g pso;
  private String yJC;
  private ListView zoc;
  private MMPullDownView zog;
  
  public ReaderAppUI()
  {
    AppMethodBeat.i(102751);
    this.dXa = 0;
    this.yJC = "";
    this.BCr = null;
    this.BCs = 0;
    this.pso = new o.g()
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
            com.tencent.mm.plugin.readerapp.c.g.fi((String)localObject1, ReaderAppUI.a(ReaderAppUI.this));
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.eHI();
            paramAnonymousInt = ReaderAppUI.a(ReaderAppUI.this);
            localObject1 = "delete from " + com.tencent.mm.model.bw.se(paramAnonymousInt) + " where reserved3 = " + com.tencent.mm.storagebase.h.Fl((String)localObject1);
            Log.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
            if (paramAnonymousMenuItem.iFy.execSQL(com.tencent.mm.model.bw.se(paramAnonymousInt), (String)localObject1))
            {
              paramAnonymousMenuItem.si(paramAnonymousInt);
              paramAnonymousMenuItem.doNotify();
            }
          }
          ReaderAppUI.this.refresh();
          AppMethodBeat.o(161679);
          return;
          if (ReaderAppUI.a(ReaderAppUI.this) == 20)
          {
            paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
            paramAnonymousMenuItem = com.tencent.mm.plugin.readerapp.c.g.eHI().al(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
            Object localObject2;
            if (paramAnonymousMenuItem.size() > 0)
            {
              paramAnonymousMenuItem = (bv)paramAnonymousMenuItem.get(0);
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
              ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", s.bdu(paramAnonymousMenuItem.aWd()));
              ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
              localObject2 = ad.JX(paramAnonymousMenuItem.iFs);
              ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
              localObject2 = ad.aVe().G((String)localObject2, true);
              ((ad.b)localObject2).l("prePublishId", "msg_" + paramAnonymousMenuItem.iFs);
              ((ad.b)localObject2).l("preUsername", "newsapp");
              ((ad.b)localObject2).l("preChatName", "newsapp");
              ((ad.b)localObject2).l("preMsgIndex", Integer.valueOf(0));
              ((ad.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
              com.tencent.mm.plugin.readerapp.b.a.jRt.k((Intent)localObject1, ReaderAppUI.this);
            }
            AppMethodBeat.o(161679);
            return;
            if (ReaderAppUI.a(ReaderAppUI.this) == 20)
            {
              paramAnonymousMenuItem = (String)ReaderAppUI.c(ReaderAppUI.this).getItem(paramAnonymousInt);
              localObject1 = com.tencent.mm.plugin.readerapp.c.g.eHI().al(paramAnonymousMenuItem, ReaderAppUI.a(ReaderAppUI.this));
              if (!((List)localObject1).isEmpty())
              {
                Log.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ReaderAppUI.d(ReaderAppUI.this)), Integer.valueOf(((List)localObject1).size()) });
                if (ReaderAppUI.d(ReaderAppUI.this) >= ((List)localObject1).size()) {
                  ReaderAppUI.a(ReaderAppUI.this, 0);
                }
                paramAnonymousMenuItem = (bv)((List)localObject1).get(ReaderAppUI.d(ReaderAppUI.this));
                localObject1 = new cz();
                localObject2 = ad.JX(paramAnonymousMenuItem.iFs);
                ad.b localb = ad.aVe().G((String)localObject2, true);
                localb.l("prePublishId", "msg_" + paramAnonymousMenuItem.iFs);
                localb.l("preUsername", "newsapp");
                localb.l("preChatName", "newsapp");
                localb.l("preMsgIndex", Integer.valueOf(0));
                localb.l("sendAppMsgScene", Integer.valueOf(1));
                ((cz)localObject1).dFZ.sessionId = ((String)localObject2);
                ReaderAppUI.d(ReaderAppUI.this);
                b.a((cz)localObject1, paramAnonymousMenuItem);
                ((cz)localObject1).dFZ.dGf = 7;
                ((cz)localObject1).dFZ.activity = ReaderAppUI.this;
                EventCenter.instance.publish((IEvent)localObject1);
              }
            }
          }
        }
      }
    };
    AppMethodBeat.o(102751);
  }
  
  private PackageInfo aKQ(String paramString)
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
  
  public final View.OnClickListener a(bv parambv, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(102758);
    if (parambv != null)
    {
      String str1 = z.bfG(parambv.getUrl());
      String str2 = z.bfG(paramString);
      String str3 = z.bfG(parambv.getTitle());
      com.tencent.mm.plugin.report.service.h.CyF.a(15413, new Object[] { Integer.valueOf(9), str2, str3, parambv.avy(), parambv.aVZ(), str1, Integer.valueOf(parambv.aWh()), Integer.valueOf(parambv.aWf()) });
    }
    parambv = new ReaderAppUI.2(this, paramInt1, paramString, parambv, paramInt2);
    AppMethodBeat.o(102758);
    return parambv;
  }
  
  public int getLayoutId()
  {
    return 2131496018;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102757);
    try
    {
      this.BCr = new com.tencent.mm.pluginsdk.ui.f(Util.convertStreamToString(getAssets().open("chatting/purecolor_chat.xml")), this);
      this.zoc = ((ListView)findViewById(2131306563));
      this.zog = ((MMPullDownView)findViewById(2131306566));
      this.zog.setIsReturnSuperDispatchWhenCancel(true);
      this.kgo = getLayoutInflater().inflate(2131496022, null);
      this.zoc.addHeaderView(this.kgo);
      ((TextView)findViewById(2131300096)).setText(2131764192);
      this.BCq = new a(this, "");
      this.zoc.setOnScrollListener(this.BCq);
      this.zoc.setAdapter(this.BCq);
      this.zoc.setTranscriptMode(0);
      registerForContextMenu(this.zoc);
      this.pqr = new com.tencent.mm.ui.widget.b.a(this);
      this.pqr.QSv = true;
      if (this.BCq.getCount() == 0)
      {
        Object localObject = new Intent(this, ReaderAppIntroUI.class);
        ((Intent)localObject).putExtra("type", this.dXa);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(102757);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ReaderAppUI", localException, "", new Object[0]);
      }
      this.zog.setOnTopLoadDataListener(new MMPullDownView.g()
      {
        public final boolean cAm()
        {
          AppMethodBeat.i(161680);
          if (ReaderAppUI.c(ReaderAppUI.this).cwg())
          {
            ReaderAppUI.b(ReaderAppUI.this).setSelectionFromTop(0, ReaderAppUI.e(ReaderAppUI.this).getTopHeight());
            AppMethodBeat.o(161680);
            return true;
          }
          int i = ReaderAppUI.c(ReaderAppUI.this).getCount();
          int j = ReaderAppUI.c(ReaderAppUI.this).cwh();
          Log.v("MicroMsg.ReaderAppUI", "onLoadData add count:".concat(String.valueOf(j)));
          ReaderAppUI.c(ReaderAppUI.this).onNotifyChange(null, null);
          int k = ReaderAppUI.c(ReaderAppUI.this).getCount();
          Log.d("MicroMsg.ReaderAppUI", "onTopLoadData nowCount:%d, preCount:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
          if (k > i)
          {
            Log.i("MicroMsg.ReaderAppUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", new Object[] { Integer.valueOf(j + 1), Integer.valueOf(ReaderAppUI.e(ReaderAppUI.this).getTopHeight()) });
            p.a(ReaderAppUI.b(ReaderAppUI.this), j + 1, ReaderAppUI.e(ReaderAppUI.this).getTopHeight(), false);
          }
          AppMethodBeat.o(161680);
          return true;
        }
      });
      this.zog.setTopViewVisible(true);
      this.zog.setAtBottomCallBack(new MMPullDownView.c()
      {
        public final boolean cAl()
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
      this.zog.setAtTopCallBack(new MMPullDownView.d()
      {
        public final boolean cAk()
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
      this.zog.setIsBottomShowAll(true);
      this.BCq.a(new s.a()
      {
        public final void bnE()
        {
          AppMethodBeat.i(161683);
          ReaderAppUI.e(ReaderAppUI.this).setIsTopShowAll(ReaderAppUI.c(ReaderAppUI.this).cwg());
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
      addIconOptionMenu(0, 2131755149, 2131689513, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(161684);
          com.tencent.mm.plugin.readerapp.b.a.jRt.c(new Intent().putExtra("Contact_User", ReaderAppUI.f(ReaderAppUI.this)), ReaderAppUI.this);
          AppMethodBeat.o(161684);
          return true;
        }
      });
      this.zoc.setSelection(this.BCq.getShowCount() - 1 + this.zoc.getHeaderViewsCount());
      AppMethodBeat.o(102757);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102752);
    super.onCreate(paramBundle);
    this.dXa = getIntent().getIntExtra("type", 0);
    Log.i("MicroMsg.ReaderAppUI", "[onCreate] readerType:%s", new Object[] { Integer.valueOf(this.dXa) });
    this.dXa = 20;
    density = com.tencent.mm.cb.a.getDensity(this);
    long l = System.currentTimeMillis();
    initView();
    Log.i("MicroMsg.ReaderAppUI", "[initView] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    this.yJC = bv.sd(this.dXa);
    if ((20 == this.dXa) && (ac.aI("newsapp", null) > 0)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(13440, new Object[] { Integer.valueOf(2) });
    }
    AppMethodBeat.o(102752);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(102753);
    if (this.BCq != null)
    {
      this.BCq.ebf();
      this.BCq.gGV();
    }
    super.onDestroy();
    AppMethodBeat.o(102753);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(102755);
    super.onPause();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().CY("");
    com.tencent.mm.plugin.readerapp.c.g.eHI().remove(this.BCq);
    ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bka(this.yJC);
    AppMethodBeat.o(102755);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102754);
    super.onResume();
    if (this.dXa == 20) {
      setMMTitle(2131761594);
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().CY(this.yJC);
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancelNotification(this.yJC);
      ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bka(this.yJC);
      com.tencent.mm.plugin.readerapp.c.g.eHI().add(this.BCq);
      this.BCq.onNotifyChange(null, null);
      refresh();
      AppMethodBeat.o(102754);
      return;
      setMMTitle(2131761597);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(102756);
    TextView localTextView = (TextView)findViewById(2131300096);
    int i;
    if (this.dXa == 20)
    {
      i = 2131764200;
      localTextView.setText(i);
      if (this.BCq.getCount() != 0) {
        break label97;
      }
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if ((this.zoc != null) && ((this.BCq instanceof a))) {
        this.zoc.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161678);
            ((ReaderAppUI.a)ReaderAppUI.c(ReaderAppUI.this)).hQ(ReaderAppUI.b(ReaderAppUI.this).getFirstVisiblePosition(), ReaderAppUI.b(ReaderAppUI.this).getLastVisiblePosition());
            AppMethodBeat.o(161678);
          }
        });
      }
      AppMethodBeat.o(102756);
      return;
      i = 2131764206;
      break;
      label97:
      localTextView.setVisibility(8);
    }
  }
  
  final class a
    extends a<String>
  {
    private int BCA;
    private int BCB;
    int BCC;
    int BCD;
    int BCE;
    private Html.ImageGetter BCy;
    private int BCz;
    private Context context;
    private int gAZ;
    private int pru;
    private int prv;
    private int prw;
    private int prx;
    private int prz;
    private int qdp;
    
    public a(Context paramContext, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(102732);
      this.BCy = new Html.ImageGetter()
      {
        public final Drawable getDrawable(String paramAnonymousString)
        {
          AppMethodBeat.i(102726);
          int i = Util.getInt(paramAnonymousString, 0);
          paramAnonymousString = ReaderAppUI.this.getResources().getDrawable(i);
          paramAnonymousString.setBounds(0, 0, paramAnonymousString.getIntrinsicWidth(), paramAnonymousString.getIntrinsicHeight());
          AppMethodBeat.o(102726);
          return paramAnonymousString;
        }
      };
      this.BCz = 0;
      this.prx = 0;
      this.prv = 0;
      this.prw = 0;
      this.BCA = 0;
      this.BCB = 0;
      this.BCC = 0;
      this.BCD = 1;
      this.BCE = 2;
      this.context = paramContext;
      this.qdp = 3;
      this.gAZ = com.tencent.mm.plugin.readerapp.c.g.eHI().sg(ReaderAppUI.a(ReaderAppUI.this));
      this.prx = paramContext.getResources().getDimensionPixelSize(2131165586);
      this.prv = paramContext.getResources().getDimensionPixelSize(2131165498);
      this.BCz = paramContext.getResources().getDimensionPixelSize(2131165190);
      this.prw = paramContext.getResources().getDimensionPixelSize(2131165518);
      this.pru = paramContext.getResources().getDimensionPixelSize(2131166065);
      this.prz = paramContext.getResources().getDimensionPixelSize(2131166063);
      int i = com.tencent.mm.cb.a.jn(paramContext);
      int j = com.tencent.mm.cb.a.jo(paramContext);
      if (i < j) {}
      for (;;)
      {
        this.BCA = ((int)((i - (int)(ReaderAppUI.eHJ() * 28.0F)) / 2.35D));
        this.BCB = ((int)((i - ReaderAppUI.eHJ() * 52.0F) / 2.0F) * 4 / 3);
        AppMethodBeat.o(102732);
        return;
        i = j;
      }
    }
    
    private List<bv> Vo(int paramInt)
    {
      AppMethodBeat.i(102739);
      Object localObject = getItem(paramInt);
      localObject = com.tencent.mm.plugin.readerapp.c.g.eHI().al((String)localObject, 20);
      AppMethodBeat.o(102739);
      return localObject;
    }
    
    private static void W(View paramView, int paramInt)
    {
      AppMethodBeat.i(102741);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102741);
    }
    
    private static void X(View paramView, int paramInt)
    {
      AppMethodBeat.i(102742);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.rightMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(102742);
    }
    
    private static e.a a(bv parambv)
    {
      AppMethodBeat.i(238574);
      if (parambv == null)
      {
        AppMethodBeat.o(238574);
        return null;
      }
      e.a locala = new e.a();
      locala.url = parambv.getUrl();
      locala.pmM = 164;
      locala.appId = "wx073f4a4daff0abe8";
      locala.title = parambv.getTitle();
      locala.desc = parambv.getDigest();
      locala.from = "message";
      AppMethodBeat.o(238574);
      return locala;
    }
    
    private void a(a parama, int paramInt, List<bv> paramList)
    {
      AppMethodBeat.i(102743);
      int i = paramList.size();
      if (paramInt == 1) {
        if (Util.isNullOrNil(((bv)paramList.get(0)).aWd()))
        {
          parama.jBI.setVisibility(0);
          X(parama.jBI, this.prv);
        }
      }
      while (paramInt == 1) {
        if (paramInt == i - 1)
        {
          parama.pxo.setPadding(0, this.prv, 0, this.prv);
          AppMethodBeat.o(102743);
          return;
          parama.jBI.setVisibility(8);
          continue;
          parama.jBI.setVisibility(0);
          bv localbv = (bv)paramList.get(paramInt - 1);
          paramList = (bv)paramList.get(paramInt);
          if ((Util.isNullOrNil(localbv.aWd())) || (Util.isNullOrNil(paramList.aWd()))) {
            X(parama.jBI, this.prv);
          } else {
            X(parama.jBI, this.prz);
          }
        }
        else
        {
          parama.pxo.setPadding(0, this.prv, 0, this.prx);
          AppMethodBeat.o(102743);
          return;
        }
      }
      if (paramInt == i - 1)
      {
        parama.pxo.setPadding(0, this.prx, 0, this.prv);
        AppMethodBeat.o(102743);
        return;
      }
      parama.pxo.setPadding(0, this.prx, 0, this.prx);
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
      paramb.BCJ.addView(parama.puO);
      paramb.pxL.add(parama);
      AppMethodBeat.o(102731);
    }
    
    private void a(b paramb, List<bv> paramList, int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(102740);
      a locala = new a();
      locala.puO = View.inflate(this.context, paramInt1, null);
      if (paramInt1 == 2131496032)
      {
        locala.puO.setBackground(ar.c(ReaderAppUI.this.getResources().getDrawable(2131231760), at.jW(ReaderAppUI.this.getContext())));
        locala.hbb = ((TextView)locala.puO.findViewById(2131309195));
        locala.ptE = ((ImageView)locala.puO.findViewById(2131299277));
        locala.pxr = locala.puO.findViewById(2131299279);
        locala.jBI = locala.puO.findViewById(2131309322);
        locala.pxo = locala.puO.findViewById(2131299208);
        a(paramb, locala);
        paramb = (bv)paramList.get(paramInt2);
        a(locala, paramInt2, paramList);
        locala.hbb.setText(paramb.getTitle());
        locala.hbb.setText(paramb.getTitle());
        if (Util.isNullOrNil(paramb.aWd())) {
          break label380;
        }
        locala.ptE.setVisibility(0);
        a(paramb.aWd(), locala.ptE, this.pru, this.pru);
      }
      for (;;)
      {
        paramList = ReaderAppUI.this.a(paramb, ReaderAppUI.a(ReaderAppUI.this), paramInt2, paramString);
        locala.puO.setOnClickListener(paramList);
        paramList = (com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class);
        if (paramList != null)
        {
          paramList.a(paramb.getUrl(), 164, "wx073f4a4daff0abe8", paramb.getTitle(), paramb.getDigest(), "message", 16);
          paramList.cF(paramb.getUrl(), 16);
        }
        AppMethodBeat.o(102740);
        return;
        if (paramInt1 != 2131496031) {
          break;
        }
        locala.puO.setBackground(ar.c(ReaderAppUI.this.getResources().getDrawable(2131231759), at.jW(ReaderAppUI.this.getContext())));
        break;
        label380:
        locala.pxr.setVisibility(8);
      }
    }
    
    private static void a(String paramString, ImageView paramImageView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102744);
      paramString = t.OO(paramString);
      com.tencent.mm.av.a.a locala = q.bcV();
      c.a locala1 = new c.a();
      locala1.jbt = 2131100173;
      locala1.jbf = true;
      locala1 = locala1.dr(paramInt1, paramInt2);
      locala1.jaU = new n();
      locala1.jbC = new com.tencent.mm.pluginsdk.ui.applet.e();
      locala1.fullPath = s.bdu(paramString);
      locala.a(paramString, paramImageView, locala1.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m((byte)0));
      AppMethodBeat.o(102744);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(102736);
      String str = (String)super.getItem(paramInt);
      AppMethodBeat.o(102736);
      return str;
    }
    
    public final void anp()
    {
      AppMethodBeat.i(102735);
      long l = System.currentTimeMillis();
      this.gAZ = com.tencent.mm.plugin.readerapp.c.g.eHI().sg(20);
      setCursor(com.tencent.mm.plugin.readerapp.c.g.eHI().sf(this.qdp));
      Log.i("MicroMsg.ReaderAppUI", "[resetCursor] cost:%sms showCount:%s totalCount:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.qdp), Integer.valueOf(this.gAZ) });
      super.notifyDataSetChanged();
      AppMethodBeat.o(102735);
    }
    
    public final void anq()
    {
      AppMethodBeat.i(102733);
      anp();
      AppMethodBeat.o(102733);
    }
    
    public final boolean cwg()
    {
      return this.qdp >= this.gAZ;
    }
    
    public final int cwh()
    {
      AppMethodBeat.i(102734);
      if (cwg())
      {
        AppMethodBeat.o(102734);
        return 0;
      }
      this.qdp += 3;
      if (this.qdp <= this.gAZ)
      {
        AppMethodBeat.o(102734);
        return 3;
      }
      this.qdp = this.gAZ;
      int i = this.gAZ;
      AppMethodBeat.o(102734);
      return i % 3;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(102737);
      List localList = Vo(paramInt);
      if (Util.isNullOrNil(localList))
      {
        Log.e("MicroMsg.ReaderAppUI", "getItemViewType info is null");
        paramInt = this.BCC;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      if (((bv)localList.get(0)).aWf() == 1) {}
      for (paramInt = 1; (paramInt != 0) && (localList.size() >= 2); paramInt = 0)
      {
        paramInt = this.BCD;
        AppMethodBeat.o(102737);
        return paramInt;
      }
      paramInt = this.BCC;
      AppMethodBeat.o(102737);
      return paramInt;
    }
    
    public final int getShowCount()
    {
      return this.qdp;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102738);
      if (getItemViewType(paramInt) == this.BCD)
      {
        if (paramView == null)
        {
          paramViewGroup = new b();
          paramView = View.inflate(this.context, 2131496029, null);
          paramViewGroup.pwO = ((TextView)paramView.findViewById(2131310463));
          paramViewGroup.gyr = ((ImageView)paramView.findViewById(2131297134));
          paramViewGroup.kcZ = ((TextView)paramView.findViewById(2131305433));
          paramViewGroup.BCM = new c();
          paramViewGroup.BCM.ptQ = paramView.findViewById(2131299284);
          paramViewGroup.BCM.eHK();
          paramViewGroup.BCN = new c();
          paramViewGroup.BCN.ptQ = paramView.findViewById(2131299285);
          paramViewGroup.BCN.eHK();
          paramView.setTag(paramViewGroup);
          localObject2 = Vo(paramInt);
          if ((localObject2 == null) || (((List)localObject2).size() < 2)) {
            break label486;
          }
          paramView.setVisibility(0);
          localObject1 = (bv)((List)localObject2).get(0);
          paramViewGroup.pwO.setText(com.tencent.mm.pluginsdk.i.f.c(this.context, ((bv)localObject1).time, false));
          localObject3 = new c.a();
          ((c.a)localObject3).jbt = 2131231405;
          ((c.a)localObject3).jbe = true;
          ((c.a)localObject3).iaT = true;
          q.bcV().a(((bv)localObject1).aWc(), paramViewGroup.gyr, ((c.a)localObject3).bdv());
          paramViewGroup.kcZ.setText(((bv)localObject1).aWb());
          paramViewGroup.kcZ.getPaint().setFakeBoldText(true);
          if (ReaderAppUI.i(ReaderAppUI.this) != null)
          {
            paramViewGroup.pwO.setTextColor(ReaderAppUI.i(ReaderAppUI.this).Kbq);
            if (!ReaderAppUI.i(ReaderAppUI.this).Kbr) {
              break label461;
            }
            paramViewGroup.pwO.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).Kbs);
            label353:
            if (!ReaderAppUI.i(ReaderAppUI.this).Kbt) {
              break label475;
            }
            paramViewGroup.pwO.setBackgroundResource(2131231646);
            paramViewGroup.pwO.setPadding(this.prx, this.BCz, this.prx, this.BCz);
          }
          label399:
          localObject2 = (bv)((List)localObject2).get(1);
          paramViewGroup.BCM.a((bv)localObject1, paramInt, ((bv)localObject1).getTitle());
          paramViewGroup.BCN.a((bv)localObject2, paramInt, ((bv)localObject1).getTitle());
        }
        for (;;)
        {
          AppMethodBeat.o(102738);
          return paramView;
          paramViewGroup = (b)paramView.getTag();
          break;
          label461:
          paramViewGroup.pwO.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break label353;
          label475:
          paramViewGroup.pwO.setBackgroundColor(0);
          break label399;
          label486:
          paramView.setVisibility(8);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = new b();
        paramView = View.inflate(this.context, 2131496024, null);
        paramViewGroup.pwO = ((TextView)paramView.findViewById(2131306553));
        paramViewGroup.BCJ = ((ViewGroup)paramView.findViewById(2131306548));
        paramViewGroup.kmV = paramView.findViewById(2131297673);
        paramViewGroup.puc = paramView.findViewById(2131299283);
        paramViewGroup.ptS = ((ImageView)paramView.findViewById(2131306101));
        paramViewGroup.BCL = ((ImageView)paramView.findViewById(2131299296));
        paramViewGroup.hbb = ((TextView)paramView.findViewById(2131306554));
        paramViewGroup.BCI = ((ImageView)paramView.findViewById(2131306552));
        paramViewGroup.znW = ((TextView)paramView.findViewById(2131306551));
        paramViewGroup.ptQ = paramView.findViewById(2131309299);
        paramViewGroup.BCK = ((MMNeat7extView)paramView.findViewById(2131309246));
        paramViewGroup.pxL = new ArrayList();
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        localObject1 = paramViewGroup.pxL.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          paramViewGroup.BCJ.removeView(((a)localObject2).puO);
        }
        paramViewGroup = (b)paramView.getTag();
      }
      paramViewGroup.pxL.clear();
      Object localObject1 = Vo(paramInt);
      label923:
      label965:
      int i;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        int k = ((List)localObject1).size();
        localObject2 = (bv)((List)localObject1).get(0);
        paramViewGroup.pwO.setText(com.tencent.mm.pluginsdk.i.f.c(this.context, ((bv)localObject2).time, false));
        if (ReaderAppUI.i(ReaderAppUI.this) != null)
        {
          paramViewGroup.pwO.setTextColor(ReaderAppUI.i(ReaderAppUI.this).Kbq);
          if (ReaderAppUI.i(ReaderAppUI.this).Kbr)
          {
            paramViewGroup.pwO.setShadowLayer(2.0F, 1.2F, 1.2F, ReaderAppUI.i(ReaderAppUI.this).Kbs);
            if (!ReaderAppUI.i(ReaderAppUI.this).Kbt) {
              break label1444;
            }
            paramViewGroup.pwO.setBackgroundResource(2131231646);
            paramViewGroup.pwO.setPadding(this.prx, this.BCz, this.prx, this.BCz);
          }
        }
        else
        {
          localObject3 = ReaderAppUI.this.a((bv)localObject2, ReaderAppUI.a(ReaderAppUI.this), 0, ((bv)localObject2).getTitle());
          paramViewGroup.ptQ.setOnClickListener((View.OnClickListener)localObject3);
          if (k != 1) {
            break label1455;
          }
          bool = true;
          paramViewGroup.hbb.setText(((bv)localObject2).getTitle());
          paramViewGroup.znW.setText(((bv)localObject2).getDigest());
          if (Util.isNullOrNil(((bv)localObject2).aWd())) {
            break label1461;
          }
          i = 1;
          label1003:
          paramViewGroup.BCK.aw(((bv)localObject2).getTitle());
          localObject3 = paramViewGroup.znW;
          if ((bool) && (!Util.isNullOrNil(((bv)localObject2).getDigest()))) {
            break label1467;
          }
        }
        label1444:
        label1455:
        label1461:
        label1467:
        for (int j = 8;; j = 0)
        {
          ((TextView)localObject3).setVisibility(j);
          paramViewGroup.BCL.setVisibility(8);
          if (!bool) {
            break label1473;
          }
          paramViewGroup.ptS.setBackgroundResource(2131231779);
          paramViewGroup.kmV.setVisibility(0);
          paramViewGroup.BCK.setVisibility(8);
          paramViewGroup.hbb.setVisibility(0);
          W(paramViewGroup.ptS, this.BCA);
          W(paramViewGroup.puc, this.BCA);
          if (i == 0) {
            break label1575;
          }
          paramViewGroup.puc.setVisibility(0);
          String str = ((bv)localObject2).aWd();
          localObject3 = paramViewGroup.BCI;
          i = this.BCA;
          localObject4 = new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102727);
              if (!bool)
              {
                paramViewGroup.BCK.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101427));
                paramViewGroup.BCK.setBackgroundResource(2131231265);
              }
              paramViewGroup.BCL.setVisibility(0);
              AppMethodBeat.o(102727);
            }
            
            public final void onStart() {}
          };
          str = t.OO(str);
          float f = ((ImageView)localObject3).getResources().getDimensionPixelSize(2131166068);
          j = com.tencent.mm.cb.a.jn(ReaderAppUI.this.getContext()) - (int)(ReaderAppUI.eHJ() * 28.0F);
          com.tencent.mm.av.a.a locala = q.bcV();
          c.a locala1 = new c.a();
          locala1.jbt = 2131231255;
          locala1.jbf = true;
          locala1.jbv = "2131231240";
          locala1 = locala1.dr(j, i);
          locala1.jaU = new n();
          locala1.jbC = new com.tencent.mm.pluginsdk.ui.applet.e();
          locala1.fullPath = s.bdu(str);
          locala.a(str, (ImageView)localObject3, locala1.bdv(), null, new com.tencent.mm.pluginsdk.ui.applet.m(0, j, i, true, false, f, (m.a)localObject4));
          paramViewGroup.kmV.setBackground(ar.e(ReaderAppUI.this.getResources().getDrawable(2131231753), this.context.getResources().getColor(2131099650)));
          paramViewGroup.kmV.setPadding(this.prv, this.prw, this.prv, this.prv);
          paramViewGroup.ptS.setVisibility(0);
          if (k <= 1) {
            break label1708;
          }
          i = 1;
          while (i < k - 1)
          {
            a(paramViewGroup, (List)localObject1, 2131496032, i, ((bv)localObject2).getTitle());
            i += 1;
          }
          paramViewGroup.pwO.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
          break;
          paramViewGroup.pwO.setBackgroundColor(0);
          break label923;
          bool = false;
          break label965;
          i = 0;
          break label1003;
        }
        label1473:
        paramViewGroup.ptS.setBackgroundResource(2131231781);
        localObject3 = paramViewGroup.kmV;
        if (i != 0) {}
        for (j = 8;; j = 0)
        {
          ((View)localObject3).setVisibility(j);
          paramViewGroup.hbb.setVisibility(8);
          paramViewGroup.BCK.setVisibility(0);
          paramViewGroup.BCK.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100679));
          paramViewGroup.BCK.setBackgroundResource(2131233974);
          paramViewGroup.BCK.getPaint().setFakeBoldText(true);
          break;
        }
        label1575:
        paramViewGroup.puc.setVisibility(8);
        paramViewGroup.hbb.setVisibility(0);
        localObject3 = paramViewGroup.znW;
        if (Util.isNullOrNil(((bv)localObject2).getDigest()))
        {
          i = 8;
          label1613:
          ((TextView)localObject3).setVisibility(i);
          if (!bool) {
            break label1676;
          }
          paramViewGroup.kmV.setBackgroundResource(2131231764);
        }
        for (;;)
        {
          paramViewGroup.kmV.setPadding(this.prv, this.prv, this.prv, this.prv);
          paramViewGroup.ptS.setVisibility(8);
          break;
          i = 0;
          break label1613;
          label1676:
          paramViewGroup.kmV.setBackgroundResource(2131231761);
        }
        a(paramViewGroup, (List)localObject1, 2131496031, k - 1, ((bv)localObject2).getTitle());
        label1708:
        localObject3 = (com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class);
        if (localObject3 != null)
        {
          ((com.tencent.mm.plugin.brandservice.a.e)localObject3).a(((bv)localObject2).getUrl(), 164, "wx073f4a4daff0abe8", ((bv)localObject2).getTitle(), ((bv)localObject2).getDigest(), "message", 8);
          ((com.tencent.mm.plugin.brandservice.a.e)localObject3).cF(((bv)localObject2).getUrl(), 8);
        }
      }
      paramViewGroup.ptQ.setTag(Integer.valueOf(paramInt));
      paramViewGroup.ptQ.setTag(2131306565, Integer.valueOf(0));
      Object localObject2 = ReaderAppUI.h(ReaderAppUI.this);
      Object localObject3 = paramViewGroup.ptQ;
      Object localObject4 = ReaderAppUI.this;
      if (((List)localObject1).size() == 1)
      {
        bool = true;
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        paramViewGroup = paramViewGroup.pxL.iterator();
        i = 1;
        label1863:
        if (!paramViewGroup.hasNext()) {
          break label1989;
        }
        localObject3 = (a)paramViewGroup.next();
        ((a)localObject3).puO.setTag(Integer.valueOf(paramInt));
        ((a)localObject3).puO.setTag(2131306565, Integer.valueOf(i));
        localObject2 = ReaderAppUI.h(ReaderAppUI.this);
        localObject3 = ((a)localObject3).puO;
        localObject4 = ReaderAppUI.this;
        if (((List)localObject1).size() != 1) {
          break label1983;
        }
      }
      label1983:
      for (final boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.ui.widget.b.a)localObject2).a((View)localObject3, ReaderAppUI.a((ReaderAppUI)localObject4, bool), ReaderAppUI.g(ReaderAppUI.this));
        i += 1;
        break label1863;
        bool = false;
        break;
      }
      label1989:
      AppMethodBeat.o(102738);
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return this.BCE;
    }
    
    public final void hQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(102746);
      Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth startPos = %s, endPos = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 > paramInt2)
      {
        AppMethodBeat.o(102746);
        return;
      }
      com.tencent.mm.plugin.brandservice.a.e locale = (com.tencent.mm.plugin.brandservice.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class);
      if (locale == null)
      {
        Log.v("MicroMsg.ReaderAppUI", "checkPreauth WebPrefetcher null");
        AppMethodBeat.o(102746);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      while (paramInt1 <= paramInt2)
      {
        List localList = Vo(paramInt1 - 1);
        if ((localList != null) && (localList.size() > 0))
        {
          localLinkedList.clear();
          e.a locala = a((bv)localList.get(0));
          if (locala != null)
          {
            localLinkedList.add(locala);
            locale.cF(locala.url, 8);
          }
          if (localLinkedList.size() > 0) {
            locale.m(localLinkedList, 8);
          }
          Log.v("MicroMsg.ReaderAppUI", "[TRACE_PREFETCH] checkPreauth authTop = %s", new Object[] { Integer.valueOf(localLinkedList.size()) });
          localLinkedList.clear();
          int i = 1;
          while (i < localList.size())
          {
            locala = a((bv)localList.get(i));
            if (locala != null)
            {
              localLinkedList.add(locala);
              locale.cF(locala.url, 16);
            }
            i += 1;
          }
          if (localLinkedList.size() > 0) {
            locale.m(localLinkedList, 16);
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
        hQ(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition());
      }
      AppMethodBeat.o(102745);
    }
    
    final class a
    {
      TextView hbb;
      View jBI;
      ImageView ptE;
      View puO;
      View pxo;
      View pxr;
      
      a() {}
    }
    
    final class b
    {
      ImageView BCI;
      ViewGroup BCJ;
      MMNeat7extView BCK;
      ImageView BCL;
      ReaderAppUI.a.c BCM;
      ReaderAppUI.a.c BCN;
      ImageView gyr;
      TextView hbb;
      TextView kcZ;
      View kmV;
      View ptQ;
      ImageView ptS;
      View puc;
      TextView pwO;
      List<ReaderAppUI.a.a> pxL;
      TextView znW;
      
      b() {}
    }
    
    final class c
    {
      View BCO;
      View BCP;
      ImageView BCQ;
      ImageView BCR;
      TextView BCS;
      MMNeat7extView pIO;
      View ptQ;
      ImageView puw;
      
      c() {}
      
      final void a(bv parambv, int paramInt, String paramString)
      {
        AppMethodBeat.i(102730);
        paramString = ReaderAppUI.this.a(parambv, ReaderAppUI.a(ReaderAppUI.this), 0, paramString);
        if (this.ptQ == null)
        {
          AppMethodBeat.o(102730);
          return;
        }
        this.ptQ.setOnClickListener(paramString);
        this.ptQ.setTag(Integer.valueOf(paramInt));
        this.ptQ.setTag(2131306565, Integer.valueOf(paramInt));
        ReaderAppUI.h(ReaderAppUI.this).a(this.ptQ, ReaderAppUI.a(ReaderAppUI.this, false), ReaderAppUI.g(ReaderAppUI.this));
        this.pIO.aw(parambv.getTitle());
        paramString = com.tencent.mm.ag.m.rJ(parambv.aWg());
        if (!Util.isNullOrNil(paramString))
        {
          this.BCS.setText(paramString);
          this.BCO.setVisibility(0);
        }
        for (;;)
        {
          this.pIO.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131100679));
          this.BCP.setBackgroundResource(2131233974);
          paramInt = (int)(this.BCS.getTextSize() * 1.7D);
          paramString = this.BCR.getLayoutParams();
          paramString.height = paramInt;
          paramString.width = paramInt;
          this.BCR.setLayoutParams(paramString);
          ReaderAppUI.a.ar(this.puw, ReaderAppUI.a.a(ReaderAppUI.a.this));
          ReaderAppUI.a.a(ReaderAppUI.a.this, parambv.aWd(), this.puw, new m.a()
          {
            public final void onFinish()
            {
              AppMethodBeat.i(102728);
              ReaderAppUI.a.c.this.pIO.setTextColor(ReaderAppUI.this.getContext().getResources().getColor(2131101427));
              ReaderAppUI.a.c.this.BCP.setBackgroundResource(2131235735);
              AppMethodBeat.o(102728);
            }
            
            public final void onStart() {}
          });
          AppMethodBeat.o(102730);
          return;
          this.BCO.setVisibility(8);
        }
      }
      
      final void eHK()
      {
        AppMethodBeat.i(102729);
        if (this.ptQ == null)
        {
          AppMethodBeat.o(102729);
          return;
        }
        this.puw = ((ImageView)this.ptQ.findViewById(2131310462));
        this.BCQ = ((ImageView)this.ptQ.findViewById(2131306101));
        this.pIO = ((MMNeat7extView)this.ptQ.findViewById(2131309246));
        this.BCS = ((TextView)this.ptQ.findViewById(2131309724));
        this.BCR = ((ImageView)this.ptQ.findViewById(2131305958));
        this.BCO = this.ptQ.findViewById(2131305965);
        this.BCP = this.ptQ.findViewById(2131310459);
        AppMethodBeat.o(102729);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI
 * JD-Core Version:    0.7.0.1
 */