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
import com.tencent.mm.cd.b;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private Bundle DDA;
  private s DDB;
  private ArrayList<String> DDC;
  private c DDD;
  private c DDE;
  private List<c> DDF;
  private boolean DDG;
  private String DDH;
  private int DDI;
  private int DDJ;
  private boolean DDK;
  private boolean DDL;
  private boolean DDM;
  private long DDN;
  private e DDO;
  private AdapterView.OnItemClickListener DDP;
  private DialogInterface.OnClickListener DDQ;
  private DialogInterface.OnClickListener DDR;
  private View.OnClickListener DDS;
  private m DDT;
  private a DDx;
  private Intent DDy;
  private String DDz;
  private DialogInterface.OnDismissListener VX;
  private PackageManager bMJ;
  private int cbq;
  private String mimeType;
  private int scene;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(109532);
    this.DDy = null;
    this.DDz = null;
    this.DDA = null;
    this.DDB = null;
    this.DDC = null;
    this.scene = 0;
    this.DDD = null;
    this.DDE = new c();
    this.DDG = false;
    this.mimeType = null;
    this.DDK = false;
    this.DDL = false;
    this.DDM = false;
    this.DDP = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(109507);
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).Xx(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).jaW.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).DEb) || ((AppChooserUI.c(AppChooserUI.this).tGm) && ((AppChooserUI.c(AppChooserUI.this).AmJ) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label262;
            }
            AppChooserUI.b(AppChooserUI.this).vv(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).DDY != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).DDY.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.h.wUl.f(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).DDY.activityInfo.packageName });
          }
          AppMethodBeat.o(109507);
          return;
          label262:
          AppChooserUI.b(AppChooserUI.this).vv(true);
        }
      }
    };
    this.DDQ = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109508);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).DDY != null))
        {
          g.agR().agA().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).DDY.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).DDY.activityInfo.packageName, true);
        }
        AppMethodBeat.o(109508);
      }
    };
    this.DDR = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109509);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).DDY != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).DDY.activityInfo.packageName, false);
        }
        AppMethodBeat.o(109509);
      }
    };
    this.DDS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109510);
        ac.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          paramAnonymousView = AppChooserUI.a(AppChooserUI.this).DDV;
          if (paramAnonymousView == AppChooserUI.f.DEg)
          {
            if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).jaW.isShowing()))
            {
              AppChooserUI.a(AppChooserUI.this).DDV = AppChooserUI.f.DEh;
              AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
            }
            paramAnonymousView = new g.a();
            if (AppChooserUI.f(AppChooserUI.this) == 1)
            {
              paramAnonymousView.WD("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
              paramAnonymousView.WF(AppChooserUI.h(AppChooserUI.this).eKy());
              paramAnonymousView.AG(1);
              paramAnonymousView.jF(true);
              f.bXJ().a(paramAnonymousView.oJg);
              t.eKN();
              t.Wv(AppChooserUI.g(AppChooserUI.this));
              if (AppChooserUI.g(AppChooserUI.this) == 0)
              {
                if (!AppChooserUI.i(AppChooserUI.this)) {
                  break label275;
                }
                com.tencent.mm.plugin.report.service.h.wUl.f(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
              }
            }
            for (;;)
            {
              if (AppChooserUI.g(AppChooserUI.this) == 1) {
                com.tencent.mm.plugin.report.service.h.wUl.f(12809, new Object[] { Integer.valueOf(5), "" });
              }
              AppMethodBeat.o(109510);
              return;
              paramAnonymousView.WD(AppChooserUI.h(AppChooserUI.this).aNm());
              break;
              label275:
              com.tencent.mm.plugin.report.service.h.wUl.f(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
            }
          }
          if (paramAnonymousView == AppChooserUI.f.DEi)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            ac.i("MicroMsg.AppChooserUI", "installRecommendApp");
            String str = f.bXJ().rT(l).path;
            ac.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(str) });
            r.b(paramAnonymousView.getContext(), str, new AppChooserUI.7(paramAnonymousView), false);
          }
        }
        AppMethodBeat.o(109510);
      }
    };
    this.VX = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109511);
        AppChooserUI.this.finish();
        AppMethodBeat.o(109511);
      }
    };
    this.DDT = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109515);
        ac.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        g.agR().agA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).DDV = AppChooserUI.f.DEg;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109515);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109514);
        ac.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!bs.isNullOrNil(paramAnonymousString)) && (com.tencent.mm.vfs.i.eA(paramAnonymousString)))
        {
          g.agR().agA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).DDV = AppChooserUI.f.DEi;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(109514);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(109516);
        ac.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        g.agR().agA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).DDV = AppChooserUI.f.DEg;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109516);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(109513);
        ac.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(109513);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(109512);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        g.agR().agA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        ac.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(109512);
      }
      
      public final void qN(long paramAnonymousLong) {}
      
      public final void qO(long paramAnonymousLong) {}
    };
    AppMethodBeat.o(109532);
  }
  
  private int Xw(int paramInt)
  {
    AppMethodBeat.i(109537);
    if (this.mimeType != null)
    {
      i = this.cbq;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(109537);
      return i + paramInt + j;
    }
    int i = this.cbq;
    AppMethodBeat.o(109537);
    return i + paramInt;
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(109541);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.bMJ.queryIntentActivities(paramIntent, 65536);
    ePV();
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
          ac.i("MicroMsg.AppChooserUI", "cpan name:%s", new Object[] { ((ResolveInfo)paramIntent.get(j)).activityInfo.name });
          ResolveInfo localResolveInfo = (ResolveInfo)paramIntent.get(j);
          if (localResolveInfo != null)
          {
            String str = localResolveInfo.activityInfo.packageName;
            if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramArrayList.contains(str))) {
              if (this.DDB.aFV(str))
              {
                this.DDE.DDY = localResolveInfo;
                this.DDE.tGm = true;
                if (((paramBoolean) || (!this.DDK)) && ((paramBoolean) || (!this.DDE.tGm))) {
                  break label266;
                }
                localArrayList.add(0, this.DDE);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new c(localResolveInfo, this.DDB.a(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.cbq != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.DDE);
      if (!this.DDL) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.DDE.DDY == null))
      {
        this.DDE.DDY = new ResolveInfo();
        this.DDE.DDY.activityInfo = new ActivityInfo();
        this.DDE.DDY.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.DDY != null)
        {
          paramArrayList = paramArrayList.DDY.activityInfo.packageName;
          if ((!bs.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.h.wUl.f(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.DDE);
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
        localDrawable = d(this.bMJ.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = d(this.bMJ.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
        if (localDrawable != null)
        {
          ac.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ac.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
      paramResolveInfo = paramResolveInfo.loadIcon(this.bMJ);
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
  
  private int ePU()
  {
    return 274496 + this.cbq;
  }
  
  private void ePV()
  {
    AppMethodBeat.i(109539);
    t.a locala = this.DDB.eKz();
    if (!bs.isNullOrNil(locala.DhC))
    {
      this.DDz = locala.DhC;
      if (locala.DhA > 0) {
        this.DDE.DEa = getResources().getDrawable(locala.DhA);
      }
      if (locala.DhD <= 0) {
        break label163;
      }
    }
    label163:
    for (this.DDE.DDZ = getResources().getString(locala.DhD);; this.DDE.DDZ = locala.DhE)
    {
      this.DDE.DEb = true;
      this.DDE.AmJ = this.DDK;
      if (this.DDK) {
        this.DDE.tGm = true;
      }
      if (this.DDL) {
        this.DDE.DEc = true;
      }
      AppMethodBeat.o(109539);
      return;
      if (locala.DhB <= 0) {
        break;
      }
      this.DDz = getResources().getString(locala.DhB);
      break;
    }
  }
  
  private boolean ePW()
  {
    AppMethodBeat.i(109540);
    ac.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.DDM), Integer.valueOf(this.DDI), Integer.valueOf(this.DDJ), Boolean.valueOf(bs.ja(this)) });
    if ((this.DDM) && (this.DDI < this.DDJ) && (!bs.ja(this)) && (com.tencent.mm.sdk.platformtools.i.cGY != 1))
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
    localIntent.putExtra("transferback", this.DDA);
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
    t.eKN();
    t.Ws(this.cbq);
    aj.b(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      ac.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      m(0, null, false);
      AppMethodBeat.o(109533);
      return;
    }
    this.DDy = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.cbq = ((Intent)localObject).getIntExtra("type", 0);
    this.DDG = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.DDA = ((Intent)localObject).getBundleExtra("transferback");
    this.DDC = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.DDL = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    boolean bool;
    if (g.agM())
    {
      this.DDH = ((String)g.agR().agA().get(Xw(274528), ""));
      if ((TextUtils.isEmpty(this.DDH)) || (!q.t(getContext(), this.DDH)) || ((this.DDC != null) && (!this.DDC.isEmpty()) && (!this.DDC.contains(this.DDH))) || (this.DDG)) {
        break label1291;
      }
      Intent localIntent = new Intent(this.DDy);
      localIntent.setPackage(this.DDH);
      if (!bs.ah(this, localIntent)) {
        break label424;
      }
      bool = true;
    }
    for (;;)
    {
      ac.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.scene), this.DDH, this.mimeType, Boolean.valueOf(this.DDG) });
      if ((bool) && (this.scene != 6))
      {
        m(-1, this.DDH, true);
        AppMethodBeat.o(109533);
        return;
        ac.e("MicroMsg.AppChooserUI", "acc not ready");
        m(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label424:
        bool = false;
      }
      else
      {
        this.bMJ = getPackageManager();
        this.DDx = new a();
        t.eKN();
        this.DDB = t.z(this.cbq, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.DDK = this.DDB.hi(getContext());
        this.DDI = ((Integer)g.agR().agA().get(ePU(), Integer.valueOf(0))).intValue();
        t.eKN();
        this.DDJ = t.Wr(this.cbq);
        ac.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.DDK), Integer.valueOf(this.DDI) });
        int i;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.DDM = bool;
          if (this.DDI < this.DDJ) {
            break label791;
          }
          i = 1;
          label596:
          this.DDF = a(this.DDy, ePW(), this.DDC);
          if ((i == 0) && (!this.DDK)) {
            g.agR().agA().set(ePU(), Integer.valueOf(this.DDI + 1));
          }
          if (!this.DDK) {
            break label796;
          }
          t.eKN();
          t.Wu(this.cbq);
          label667:
          if (this.DDF == null) {
            break label814;
          }
        }
        label791:
        label796:
        label814:
        for (int j = this.DDF.size();; j = 0)
        {
          ac.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.DDF == null) || (this.DDF.size() != 1) || ((ePW()) && (!this.DDK))) {
            break label851;
          }
          paramBundle = (c)this.DDF.get(0);
          if (paramBundle == null) {
            break label835;
          }
          if (paramBundle.DDY == null) {
            break label819;
          }
          m(-1, paramBundle.DDY.activityInfo.packageName, false);
          AppMethodBeat.o(109533);
          return;
          bool = false;
          break;
          i = 0;
          break label596;
          if (i != 0) {
            break label667;
          }
          t.eKN();
          t.Wt(this.cbq);
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
        if ((this.DDF != null) && (!this.DDF.isEmpty()))
        {
          this.DDx.oXp = this.DDF;
          this.DDN = ((Long)g.agR().agA().get(Xw(274560), Long.valueOf(0L))).longValue();
          localObject = f.bXJ().rT(this.DDN);
          ac.d("MicroMsg.AppChooserUI", "downloadId:" + this.DDN + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (com.tencent.mm.vfs.i.eA(((FileDownloadTaskInfo)localObject).path)) && (this.DDx != null))
          {
            this.DDx.DDV = f.DEi;
            this.DDx.notifyDataSetChanged();
          }
          this.DDO = new e(getContext());
          localObject = this.DDO;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.DDO.DEe = this.DDP;
            this.DDO.DDR = this.DDR;
            this.DDO.DEf = this.DDQ;
            this.DDO.oao = this.DDx;
            this.DDO.VX = this.VX;
            paramBundle = this.DDO;
            if (paramBundle.DEe != null) {
              paramBundle.DEd.setOnItemClickListener(paramBundle.DEe);
            }
            if (paramBundle.oao != null) {
              paramBundle.DEd.setAdapter(paramBundle.oao);
            }
            paramBundle.jaW = com.tencent.mm.ui.base.h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.DEd, paramBundle.mContext.getString(2131755922), paramBundle.mContext.getString(2131755921), paramBundle.DDR, paramBundle.DEf, 2131100464);
            paramBundle.jaW.setOnDismissListener(paramBundle.VX);
            paramBundle.jaW.show();
            if ((!this.DDL) && (this.DDK) && (i == 0))
            {
              this.DDD = this.DDE;
              this.DDO.vv(true);
            }
            f.bXJ();
            c.a(this.DDT);
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
    f.bXJ();
    c.b(this.DDT);
    if (this.DDO != null) {
      this.DDO.jaW.dismiss();
    }
    AppMethodBeat.o(109535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109534);
    super.onResume();
    if ((this.DDL) && (this.DDy != null) && (this.DDB.af(this, this.DDy)))
    {
      ac.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.DDL = false;
      this.DDE.DEc = false;
    }
    this.DDK = this.DDB.hi(getContext());
    this.DDF = a(this.DDy, ePW(), this.DDC);
    if ((this.DDK) && (this.DDD == null) && (!this.DDG))
    {
      this.DDD = this.DDE;
      this.DDO.vv(true);
    }
    if (this.DDx != null)
    {
      this.DDx.oXp = this.DDF;
      this.DDx.notifyDataSetChanged();
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
    AppChooserUI.f DDV;
    List<AppChooserUI.c> oXp;
    
    public a()
    {
      AppMethodBeat.i(109518);
      this.oXp = new ArrayList();
      this.DDV = AppChooserUI.f.DEg;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      AppMethodBeat.o(109518);
    }
    
    public final AppChooserUI.c Xx(int paramInt)
    {
      AppMethodBeat.i(109520);
      if (this.oXp == null)
      {
        AppMethodBeat.o(109520);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.oXp.get(paramInt);
      AppMethodBeat.o(109520);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109522);
      if (this.oXp == null)
      {
        AppMethodBeat.o(109522);
        return 0;
      }
      int i = this.oXp.size();
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
      if (Xx(paramInt).DEb)
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
      AppChooserUI.c localc = Xx(paramInt);
      label73:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.getContext());
        if (localc.DEb)
        {
          paramInt = 2131493081;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc.DEa == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc });
          }
          paramViewGroup.ts.setImageDrawable(localc.DEa);
          Object localObject2 = localc.DDZ;
          Object localObject1 = localObject2;
          if (AppChooserUI.k(AppChooserUI.this))
          {
            localObject1 = localObject2;
            if (localc.DDY != null)
            {
              localObject1 = localObject2;
              if (localc.DDY.activityInfo.packageName.equals(AppChooserUI.l(AppChooserUI.this)))
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
          paramViewGroup.tug.setText((CharSequence)localObject1);
          if ((localc == null) || ((localc.DEb) && (!localc.AmJ) && ((!localc.DEb) || (!localc.tGm) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc.DEc)) {
            break label554;
          }
          paramViewGroup.DDW.setVisibility(8);
          paramViewGroup.DDX.setVisibility(0);
          localObject1 = paramViewGroup.DDX;
          localObject2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localObject2 instanceof AppChooserUI.c)) {
            break label548;
          }
          localObject2 = (AppChooserUI.c)localObject2;
          if (((((AppChooserUI.c)localObject2).DDY == null) || (localc.DDY == null) || (!((AppChooserUI.c)localObject2).DDY.activityInfo.packageName.equals(localc.DDY.activityInfo.packageName))) && ((!((AppChooserUI.c)localObject2).DEb) || (!localc.DEb))) {
            break label548;
          }
          bool = true;
          label413:
          ((RadioButton)localObject1).setChecked(bool);
          label420:
          if (!localc.DEb) {
            break label740;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label720;
          }
          paramViewGroup.tui.setText(2131762069);
          label448:
          localObject1 = paramViewGroup.tui;
          paramInt = i;
          if (bs.isNullOrNil(AppChooserUI.n(AppChooserUI.this))) {
            paramInt = 8;
          }
          ((TextView)localObject1).setVisibility(paramInt);
        }
      }
      for (;;)
      {
        if ((AppChooserUI.f(AppChooserUI.this) != 6) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).equals(localc))) {
          paramViewGroup.DDX.setChecked(true);
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
        paramViewGroup.DDW.setVisibility(0);
        paramViewGroup.DDX.setVisibility(8);
        paramViewGroup.DDW.setOnClickListener(AppChooserUI.m(AppChooserUI.this));
        if (this.DDV == AppChooserUI.f.DEg)
        {
          if (localc.DEc) {
            paramViewGroup.DDW.setText(2131755827);
          }
          for (;;)
          {
            paramViewGroup.DDW.setEnabled(true);
            break;
            paramViewGroup.DDW.setText(2131755714);
          }
        }
        if (this.DDV == AppChooserUI.f.DEh)
        {
          paramViewGroup.DDW.setText(2131755720);
          paramViewGroup.DDW.setEnabled(false);
          break label420;
        }
        if (this.DDV != AppChooserUI.f.DEi) {
          break label420;
        }
        if (localc.DEc) {
          paramViewGroup.DDW.setText(2131755908);
        }
        for (;;)
        {
          paramViewGroup.DDW.setEnabled(true);
          break;
          paramViewGroup.DDW.setText(2131755907);
        }
        label720:
        paramViewGroup.tui.setText(bs.nullAsNil(AppChooserUI.n(AppChooserUI.this)));
        break label448;
        label740:
        paramViewGroup.tui.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    TextView DDW;
    RadioButton DDX;
    ImageView ts;
    TextView tug;
    TextView tui;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109524);
      this.ts = ((ImageView)paramView.findViewById(2131296852));
      this.tug = ((TextView)paramView.findViewById(2131296865));
      this.tui = ((TextView)paramView.findViewById(2131296843));
      this.DDW = ((TextView)paramView.findViewById(2131296875));
      this.DDX = ((RadioButton)paramView.findViewById(2131296871));
      AppMethodBeat.o(109524);
    }
  }
  
  final class c
  {
    boolean AmJ;
    ResolveInfo DDY;
    CharSequence DDZ;
    Drawable DEa;
    boolean DEb;
    boolean DEc;
    boolean tGm;
    
    public c() {}
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      this.DDY = paramResolveInfo;
      this.DDZ = paramCharSequence;
      this.DEb = false;
      this.AmJ = true;
      this.DEc = false;
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d() {}
  }
  
  final class e
  {
    DialogInterface.OnClickListener DDR;
    ListViewInScrollView DEd;
    AdapterView.OnItemClickListener DEe;
    DialogInterface.OnClickListener DEf;
    DialogInterface.OnDismissListener VX;
    public d jaW;
    Context mContext;
    String mTitle;
    BaseAdapter oao;
    
    public e(Context paramContext)
    {
      AppMethodBeat.i(109527);
      this.mContext = paramContext;
      this.DEd = ((ListViewInScrollView)View.inflate(this.mContext, 2131493079, null));
      AppMethodBeat.o(109527);
    }
    
    public final void vv(boolean paramBoolean)
    {
      AppMethodBeat.i(109528);
      if (this.jaW != null)
      {
        if (!paramBoolean)
        {
          this.jaW.a(2131755922, null);
          this.jaW.b(2131755921, null);
          AppMethodBeat.o(109528);
          return;
        }
        this.jaW.a(2131755922, this.DDR);
        this.jaW.b(2131755921, this.DEf);
      }
      AppMethodBeat.o(109528);
    }
  }
  
  public static enum f
  {
    static
    {
      AppMethodBeat.i(109531);
      DEg = new f("UNINSTALL", 0);
      DEh = new f("DOWNLOADING", 1);
      DEi = new f("DOWNLOADED", 2);
      DEj = new f[] { DEg, DEh, DEi };
      AppMethodBeat.o(109531);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */