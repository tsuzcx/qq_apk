package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pluginsdk.model.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private DialogInterface.OnClickListener ClA;
  private View.OnClickListener ClB;
  private m ClC;
  private a Clg;
  private Intent Clh;
  private String Cli;
  private Bundle Clj;
  private s Clk;
  private ArrayList<String> Cll;
  private c Clm;
  private c Cln;
  private List<c> Clo;
  private boolean Clp;
  private String Clq;
  private int Clr;
  private int Cls;
  private boolean Clt;
  private boolean Clu;
  private boolean Clv;
  private long Clw;
  private e Clx;
  private AdapterView.OnItemClickListener Cly;
  private DialogInterface.OnClickListener Clz;
  private DialogInterface.OnDismissListener Vc;
  private PackageManager bPb;
  private int cet;
  private String mimeType;
  private int scene;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(109532);
    this.Clh = null;
    this.Cli = null;
    this.Clj = null;
    this.Clk = null;
    this.Cll = null;
    this.scene = 0;
    this.Clm = null;
    this.Cln = new c();
    this.Clp = false;
    this.mimeType = null;
    this.Clt = false;
    this.Clu = false;
    this.Clv = false;
    this.Cly = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(109507);
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).Vo(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).iAV.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).ClK) || ((AppChooserUI.c(AppChooserUI.this).syw) && ((AppChooserUI.c(AppChooserUI.this).yYU) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label262;
            }
            AppChooserUI.b(AppChooserUI.this).ut(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).ClH != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).ClH.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.h.vKh.f(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).ClH.activityInfo.packageName });
          }
          AppMethodBeat.o(109507);
          return;
          label262:
          AppChooserUI.b(AppChooserUI.this).ut(true);
        }
      }
    };
    this.Clz = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109508);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).ClH != null))
        {
          g.afB().afk().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).ClH.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).ClH.activityInfo.packageName, true);
        }
        AppMethodBeat.o(109508);
      }
    };
    this.ClA = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109509);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).ClH != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).ClH.activityInfo.packageName, false);
        }
        AppMethodBeat.o(109509);
      }
    };
    this.ClB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109510);
        ad.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          paramAnonymousView = AppChooserUI.a(AppChooserUI.this).ClE;
          if (paramAnonymousView == AppChooserUI.f.ClP)
          {
            if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).iAV.isShowing()))
            {
              AppChooserUI.a(AppChooserUI.this).ClE = AppChooserUI.f.ClQ;
              AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
            }
            paramAnonymousView = new g.a();
            if (AppChooserUI.f(AppChooserUI.this) == 1)
            {
              paramAnonymousView.Sr("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
              paramAnonymousView.St(AppChooserUI.h(AppChooserUI.this).eve());
              paramAnonymousView.zO(1);
              paramAnonymousView.jc(true);
              f.bQt().a(paramAnonymousView.ofF);
              t.evt();
              t.Ul(AppChooserUI.g(AppChooserUI.this));
              if (AppChooserUI.g(AppChooserUI.this) == 0)
              {
                if (!AppChooserUI.i(AppChooserUI.this)) {
                  break label275;
                }
                com.tencent.mm.plugin.report.service.h.vKh.f(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
              }
            }
            for (;;)
            {
              if (AppChooserUI.g(AppChooserUI.this) == 1) {
                com.tencent.mm.plugin.report.service.h.vKh.f(12809, new Object[] { Integer.valueOf(5), "" });
              }
              AppMethodBeat.o(109510);
              return;
              paramAnonymousView.Sr(AppChooserUI.h(AppChooserUI.this).aGz());
              break;
              label275:
              com.tencent.mm.plugin.report.service.h.vKh.f(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
            }
          }
          if (paramAnonymousView == AppChooserUI.f.ClR)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            ad.i("MicroMsg.AppChooserUI", "installRecommendApp");
            String str = f.bQt().oh(l).path;
            ad.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(str) });
            r.b(paramAnonymousView.getContext(), str, new AppChooserUI.7(paramAnonymousView), false);
          }
        }
        AppMethodBeat.o(109510);
      }
    };
    this.Vc = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109511);
        AppChooserUI.this.finish();
        AppMethodBeat.o(109511);
      }
    };
    this.ClC = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109515);
        ad.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        g.afB().afk().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).ClE = AppChooserUI.f.ClP;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109515);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109514);
        ad.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!bt.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eK(paramAnonymousString)))
        {
          g.afB().afk().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).ClE = AppChooserUI.f.ClR;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(109514);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void mZ(long paramAnonymousLong) {}
      
      public final void na(long paramAnonymousLong) {}
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(109516);
        ad.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        g.afB().afk().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).ClE = AppChooserUI.f.ClP;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109516);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(109513);
        ad.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(109513);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(109512);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        g.afB().afk().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        ad.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(109512);
      }
    };
    AppMethodBeat.o(109532);
  }
  
  private int Vn(int paramInt)
  {
    AppMethodBeat.i(109537);
    if (this.mimeType != null)
    {
      i = this.cet;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(109537);
      return i + paramInt + j;
    }
    int i = this.cet;
    AppMethodBeat.o(109537);
    return i + paramInt;
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(109541);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.bPb.queryIntentActivities(paramIntent, 65536);
    eAB();
    int j = 0;
    int i = 0;
    int k = j;
    if (paramIntent != null)
    {
      k = j;
      if (paramIntent.size() > 0)
      {
        int m = paramIntent.size();
        j = 0;
        k = i;
        if (j < m)
        {
          ad.i("MicroMsg.AppChooserUI", "cpan name:%s", new Object[] { ((ResolveInfo)paramIntent.get(j)).activityInfo.name });
          ResolveInfo localResolveInfo = (ResolveInfo)paramIntent.get(j);
          if (localResolveInfo != null)
          {
            String str = localResolveInfo.activityInfo.packageName;
            if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramArrayList.contains(str))) {
              if (this.Clk.aAD(str))
              {
                this.Cln.ClH = localResolveInfo;
                this.Cln.syw = true;
                if (((paramBoolean) || (!this.Clt)) && ((paramBoolean) || (!this.Cln.syw))) {
                  break label266;
                }
                localArrayList.add(0, this.Cln);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new c(localResolveInfo, this.Clk.a(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.cet != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.Cln);
      if (!this.Clu) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.Cln.ClH == null))
      {
        this.Cln.ClH = new ResolveInfo();
        this.Cln.ClH.activityInfo = new ActivityInfo();
        this.Cln.ClH.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.ClH != null)
        {
          paramArrayList = paramArrayList.ClH.activityInfo.packageName;
          if ((!bt.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.h.vKh.f(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.Cln);
    }
    AppMethodBeat.o(109541);
    return localArrayList;
  }
  
  private Drawable c(ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109543);
    try
    {
      Drawable localDrawable;
      if ((paramResolveInfo.resolvePackageName != null) && (paramResolveInfo.icon != 0))
      {
        localDrawable = d(this.bPb.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = d(this.bPb.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
        if (localDrawable != null)
        {
          ad.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ad.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
      paramResolveInfo = paramResolveInfo.loadIcon(this.bPb);
      AppMethodBeat.o(109543);
    }
    return paramResolveInfo;
  }
  
  private static Drawable d(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(109542);
    try
    {
      paramResources = b.e(paramResources, paramInt);
      AppMethodBeat.o(109542);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      for (;;)
      {
        paramResources = null;
      }
    }
  }
  
  private int eAA()
  {
    return 274496 + this.cet;
  }
  
  private void eAB()
  {
    AppMethodBeat.i(109539);
    t.a locala = this.Clk.evf();
    if (!bt.isNullOrNil(locala.BPo))
    {
      this.Cli = locala.BPo;
      if (locala.BPm > 0) {
        this.Cln.ClJ = getResources().getDrawable(locala.BPm);
      }
      if (locala.BPp <= 0) {
        break label163;
      }
    }
    label163:
    for (this.Cln.ClI = getResources().getString(locala.BPp);; this.Cln.ClI = locala.BPq)
    {
      this.Cln.ClK = true;
      this.Cln.yYU = this.Clt;
      if (this.Clt) {
        this.Cln.syw = true;
      }
      if (this.Clu) {
        this.Cln.ClL = true;
      }
      AppMethodBeat.o(109539);
      return;
      if (locala.BPn <= 0) {
        break;
      }
      this.Cli = getResources().getString(locala.BPn);
      break;
    }
  }
  
  private boolean eAC()
  {
    AppMethodBeat.i(109540);
    ad.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.Clv), Integer.valueOf(this.Clr), Integer.valueOf(this.Cls), Boolean.valueOf(bt.iP(this)) });
    if ((this.Clv) && (this.Clr < this.Cls) && (!bt.iP(this)) && (com.tencent.mm.sdk.platformtools.i.cJR != 1))
    {
      AppMethodBeat.o(109540);
      return true;
    }
    AppMethodBeat.o(109540);
    return false;
  }
  
  private void m(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109538);
    Intent localIntent = new Intent();
    localIntent.putExtra("selectpkg", paramString);
    localIntent.putExtra("isalways", paramBoolean);
    localIntent.putExtra("transferback", this.Clj);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(109538);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(109536);
    super.onBackPressed();
    m(0, null, false);
    AppMethodBeat.o(109536);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109533);
    super.onCreate(paramBundle);
    t.evt();
    t.Ui(this.cet);
    ai.b(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      ad.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      m(0, null, false);
      AppMethodBeat.o(109533);
      return;
    }
    this.Clh = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.cet = ((Intent)localObject).getIntExtra("type", 0);
    this.Clp = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.Clj = ((Intent)localObject).getBundleExtra("transferback");
    this.Cll = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.Clu = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    boolean bool;
    if (g.afw())
    {
      this.Clq = ((String)g.afB().afk().get(Vn(274528), ""));
      if ((TextUtils.isEmpty(this.Clq)) || (!q.t(getContext(), this.Clq)) || ((this.Cll != null) && (!this.Cll.isEmpty()) && (!this.Cll.contains(this.Clq))) || (this.Clp)) {
        break label1291;
      }
      Intent localIntent = new Intent(this.Clh);
      localIntent.setPackage(this.Clq);
      if (!bt.T(this, localIntent)) {
        break label424;
      }
      bool = true;
    }
    for (;;)
    {
      ad.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.scene), this.Clq, this.mimeType, Boolean.valueOf(this.Clp) });
      if ((bool) && (this.scene != 6))
      {
        m(-1, this.Clq, true);
        AppMethodBeat.o(109533);
        return;
        ad.e("MicroMsg.AppChooserUI", "acc not ready");
        m(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label424:
        bool = false;
      }
      else
      {
        this.bPb = getPackageManager();
        this.Clg = new a();
        t.evt();
        this.Clk = t.A(this.cet, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.Clt = this.Clk.gX(getContext());
        this.Clr = ((Integer)g.afB().afk().get(eAA(), Integer.valueOf(0))).intValue();
        t.evt();
        this.Cls = t.Uh(this.cet);
        ad.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.Clt), Integer.valueOf(this.Clr) });
        int i;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.Clv = bool;
          if (this.Clr < this.Cls) {
            break label791;
          }
          i = 1;
          label596:
          this.Clo = a(this.Clh, eAC(), this.Cll);
          if ((i == 0) && (!this.Clt)) {
            g.afB().afk().set(eAA(), Integer.valueOf(this.Clr + 1));
          }
          if (!this.Clt) {
            break label796;
          }
          t.evt();
          t.Uk(this.cet);
          label667:
          if (this.Clo == null) {
            break label814;
          }
        }
        label791:
        label796:
        label814:
        for (int j = this.Clo.size();; j = 0)
        {
          ad.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.Clo == null) || (this.Clo.size() != 1) || ((eAC()) && (!this.Clt))) {
            break label851;
          }
          paramBundle = (c)this.Clo.get(0);
          if (paramBundle == null) {
            break label835;
          }
          if (paramBundle.ClH == null) {
            break label819;
          }
          m(-1, paramBundle.ClH.activityInfo.packageName, false);
          AppMethodBeat.o(109533);
          return;
          bool = false;
          break;
          i = 0;
          break label596;
          if (i != 0) {
            break label667;
          }
          t.evt();
          t.Uj(this.cet);
          break label667;
        }
        label819:
        m(4098, null, false);
        AppMethodBeat.o(109533);
        return;
        label835:
        m(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label851:
        setTitleVisibility(8);
        if ((this.Clo != null) && (!this.Clo.isEmpty()))
        {
          this.Clg.otO = this.Clo;
          this.Clw = ((Long)g.afB().afk().get(Vn(274560), Long.valueOf(0L))).longValue();
          localObject = f.bQt().oh(this.Clw);
          ad.d("MicroMsg.AppChooserUI", "downloadId:" + this.Clw + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (com.tencent.mm.vfs.i.eK(((FileDownloadTaskInfo)localObject).path)) && (this.Clg != null))
          {
            this.Clg.ClE = f.ClR;
            this.Clg.notifyDataSetChanged();
          }
          this.Clx = new e(getContext());
          localObject = this.Clx;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.Clx.ClN = this.Cly;
            this.Clx.ClA = this.ClA;
            this.Clx.ClO = this.Clz;
            this.Clx.nxo = this.Clg;
            this.Clx.Vc = this.Vc;
            paramBundle = this.Clx;
            if (paramBundle.ClN != null) {
              paramBundle.ClM.setOnItemClickListener(paramBundle.ClN);
            }
            if (paramBundle.nxo != null) {
              paramBundle.ClM.setAdapter(paramBundle.nxo);
            }
            paramBundle.iAV = com.tencent.mm.ui.base.h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.ClM, paramBundle.mContext.getString(2131755922), paramBundle.mContext.getString(2131755921), paramBundle.ClA, paramBundle.ClO, 2131100464);
            paramBundle.iAV.setOnDismissListener(paramBundle.Vc);
            paramBundle.iAV.show();
            if ((!this.Clu) && (this.Clt) && (i == 0))
            {
              this.Clm = this.Cln;
              this.Clx.ut(true);
            }
            f.bQt();
            c.a(this.ClC);
            AppMethodBeat.o(109533);
            return;
          }
        }
        m(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label1291:
        bool = false;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109535);
    super.onDestroy();
    f.bQt();
    c.b(this.ClC);
    if (this.Clx != null) {
      this.Clx.iAV.dismiss();
    }
    AppMethodBeat.o(109535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109534);
    super.onResume();
    if ((this.Clu) && (this.Clh != null) && (this.Clk.R(this, this.Clh)))
    {
      ad.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.Clu = false;
      this.Cln.ClL = false;
    }
    this.Clt = this.Clk.gX(getContext());
    this.Clo = a(this.Clh, eAC(), this.Cll);
    if ((this.Clt) && (this.Clm == null) && (!this.Clp))
    {
      this.Clm = this.Cln;
      this.Clx.ut(true);
    }
    if (this.Clg != null)
    {
      this.Clg.otO = this.Clo;
      this.Clg.notifyDataSetChanged();
    }
    AppMethodBeat.o(109534);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    AppChooserUI.f ClE;
    List<AppChooserUI.c> otO;
    
    public a()
    {
      AppMethodBeat.i(109518);
      this.otO = new ArrayList();
      this.ClE = AppChooserUI.f.ClP;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      AppMethodBeat.o(109518);
    }
    
    public final AppChooserUI.c Vo(int paramInt)
    {
      AppMethodBeat.i(109520);
      if (this.otO == null)
      {
        AppMethodBeat.o(109520);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.otO.get(paramInt);
      AppMethodBeat.o(109520);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109522);
      if (this.otO == null)
      {
        AppMethodBeat.o(109522);
        return 0;
      }
      int i = this.otO.size();
      AppMethodBeat.o(109522);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(109521);
      if (Vo(paramInt).ClK)
      {
        AppMethodBeat.o(109521);
        return 1;
      }
      AppMethodBeat.o(109521);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 0;
      AppMethodBeat.i(109519);
      AppChooserUI.c localc = Vo(paramInt);
      label73:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.getContext());
        if (localc.ClK)
        {
          paramInt = 2131493081;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc.ClJ == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc });
          }
          paramViewGroup.st.setImageDrawable(localc.ClJ);
          Object localObject2 = localc.ClI;
          Object localObject1 = localObject2;
          if (AppChooserUI.k(AppChooserUI.this))
          {
            localObject1 = localObject2;
            if (localc.ClH != null)
            {
              localObject1 = localObject2;
              if (localc.ClH.activityInfo.packageName.equals(AppChooserUI.l(AppChooserUI.this)))
              {
                localObject2 = TextUtils.concat(new CharSequence[] { localObject2, AppChooserUI.this.getString(2131755706) });
                localObject1 = localObject2;
                if (AppChooserUI.c(AppChooserUI.this) == null)
                {
                  AppChooserUI.a(AppChooserUI.this, localc);
                  localObject1 = localObject2;
                }
              }
            }
          }
          paramViewGroup.smn.setText((CharSequence)localObject1);
          if ((localc == null) || ((localc.ClK) && (!localc.yYU) && ((!localc.ClK) || (!localc.syw) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc.ClL)) {
            break label554;
          }
          paramViewGroup.ClF.setVisibility(8);
          paramViewGroup.ClG.setVisibility(0);
          localObject1 = paramViewGroup.ClG;
          localObject2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localObject2 instanceof AppChooserUI.c)) {
            break label548;
          }
          localObject2 = (AppChooserUI.c)localObject2;
          if (((((AppChooserUI.c)localObject2).ClH == null) || (localc.ClH == null) || (!((AppChooserUI.c)localObject2).ClH.activityInfo.packageName.equals(localc.ClH.activityInfo.packageName))) && ((!((AppChooserUI.c)localObject2).ClK) || (!localc.ClK))) {
            break label548;
          }
          bool = true;
          label413:
          ((RadioButton)localObject1).setChecked(bool);
          label420:
          if (!localc.ClK) {
            break label740;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label720;
          }
          paramViewGroup.smp.setText(2131762069);
          label448:
          localObject1 = paramViewGroup.smp;
          paramInt = i;
          if (bt.isNullOrNil(AppChooserUI.n(AppChooserUI.this))) {
            paramInt = 8;
          }
          ((TextView)localObject1).setVisibility(paramInt);
        }
      }
      for (;;)
      {
        if ((AppChooserUI.f(AppChooserUI.this) != 6) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).equals(localc))) {
          paramViewGroup.ClG.setChecked(true);
        }
        AppMethodBeat.o(109519);
        return paramView;
        paramInt = 2131493080;
        break;
        paramViewGroup = (AppChooserUI.b)paramView.getTag();
        break label73;
        label548:
        bool = false;
        break label413;
        label554:
        paramViewGroup.ClF.setVisibility(0);
        paramViewGroup.ClG.setVisibility(8);
        paramViewGroup.ClF.setOnClickListener(AppChooserUI.m(AppChooserUI.this));
        if (this.ClE == AppChooserUI.f.ClP)
        {
          if (localc.ClL) {
            paramViewGroup.ClF.setText(2131755827);
          }
          for (;;)
          {
            paramViewGroup.ClF.setEnabled(true);
            break;
            paramViewGroup.ClF.setText(2131755714);
          }
        }
        if (this.ClE == AppChooserUI.f.ClQ)
        {
          paramViewGroup.ClF.setText(2131755720);
          paramViewGroup.ClF.setEnabled(false);
          break label420;
        }
        if (this.ClE != AppChooserUI.f.ClR) {
          break label420;
        }
        if (localc.ClL) {
          paramViewGroup.ClF.setText(2131755908);
        }
        for (;;)
        {
          paramViewGroup.ClF.setEnabled(true);
          break;
          paramViewGroup.ClF.setText(2131755907);
        }
        label720:
        paramViewGroup.smp.setText(bt.nullAsNil(AppChooserUI.n(AppChooserUI.this)));
        break label448;
        label740:
        paramViewGroup.smp.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    TextView ClF;
    RadioButton ClG;
    TextView smn;
    TextView smp;
    ImageView st;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109524);
      this.st = ((ImageView)paramView.findViewById(2131296852));
      this.smn = ((TextView)paramView.findViewById(2131296865));
      this.smp = ((TextView)paramView.findViewById(2131296843));
      this.ClF = ((TextView)paramView.findViewById(2131296875));
      this.ClG = ((RadioButton)paramView.findViewById(2131296871));
      AppMethodBeat.o(109524);
    }
  }
  
  final class c
  {
    ResolveInfo ClH;
    CharSequence ClI;
    Drawable ClJ;
    boolean ClK;
    boolean ClL;
    boolean syw;
    boolean yYU;
    
    public c() {}
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      this.ClH = paramResolveInfo;
      this.ClI = paramCharSequence;
      this.ClK = false;
      this.yYU = true;
      this.ClL = false;
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d() {}
  }
  
  final class e
  {
    DialogInterface.OnClickListener ClA;
    ListViewInScrollView ClM;
    AdapterView.OnItemClickListener ClN;
    DialogInterface.OnClickListener ClO;
    DialogInterface.OnDismissListener Vc;
    public d iAV;
    Context mContext;
    String mTitle;
    BaseAdapter nxo;
    
    public e(Context paramContext)
    {
      AppMethodBeat.i(109527);
      this.mContext = paramContext;
      this.ClM = ((ListViewInScrollView)View.inflate(this.mContext, 2131493079, null));
      AppMethodBeat.o(109527);
    }
    
    public final void ut(boolean paramBoolean)
    {
      AppMethodBeat.i(109528);
      if (this.iAV != null)
      {
        if (!paramBoolean)
        {
          this.iAV.a(2131755922, null);
          this.iAV.b(2131755921, null);
          AppMethodBeat.o(109528);
          return;
        }
        this.iAV.a(2131755922, this.ClA);
        this.iAV.b(2131755921, this.ClO);
      }
      AppMethodBeat.o(109528);
    }
  }
  
  public static enum f
  {
    static
    {
      AppMethodBeat.i(109531);
      ClP = new f("UNINSTALL", 0);
      ClQ = new f("DOWNLOADING", 1);
      ClR = new f("DOWNLOADED", 2);
      ClS = new f[] { ClP, ClQ, ClR };
      AppMethodBeat.o(109531);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */