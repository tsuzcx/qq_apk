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
import com.tencent.mm.kernel.e;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private a FBc;
  private Intent FBd;
  private String FBe;
  private Bundle FBf;
  private s FBg;
  private ArrayList<String> FBh;
  private c FBi;
  private c FBj;
  private List<c> FBk;
  private boolean FBl;
  private String FBm;
  private int FBn;
  private int FBo;
  private boolean FBp;
  private boolean FBq;
  private boolean FBr;
  private long FBs;
  private e FBt;
  private AdapterView.OnItemClickListener FBu;
  private DialogInterface.OnClickListener FBv;
  private DialogInterface.OnClickListener FBw;
  private View.OnClickListener FBx;
  private m FBy;
  private DialogInterface.OnDismissListener XM;
  private PackageManager bWW;
  private int clJ;
  private String mimeType;
  private int scene;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(109532);
    this.FBd = null;
    this.FBe = null;
    this.FBf = null;
    this.FBg = null;
    this.FBh = null;
    this.scene = 0;
    this.FBi = null;
    this.FBj = new c();
    this.FBl = false;
    this.mimeType = null;
    this.FBp = false;
    this.FBq = false;
    this.FBr = false;
    this.FBu = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(109507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).ZZ(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).jxa.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).FBG) || ((AppChooserUI.c(AppChooserUI.this).uUL) && ((AppChooserUI.c(AppChooserUI.this).BWm) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label325;
            }
            AppChooserUI.b(AppChooserUI.this).wp(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).FBD != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).FBD.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).FBD.activityInfo.packageName });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(109507);
          return;
          label325:
          AppChooserUI.b(AppChooserUI.this).wp(true);
        }
      }
    };
    this.FBv = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109508);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).FBD != null))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).FBD.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).FBD.activityInfo.packageName, true);
        }
        AppMethodBeat.o(109508);
      }
    };
    this.FBw = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109509);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).FBD != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).FBD.activityInfo.packageName, false);
        }
        AppMethodBeat.o(109509);
      }
    };
    this.FBx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109510);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          paramAnonymousView = AppChooserUI.a(AppChooserUI.this).FBA;
          if (paramAnonymousView != AppChooserUI.f.FBL) {
            break label355;
          }
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).jxa.isShowing()))
          {
            AppChooserUI.a(AppChooserUI.this).FBA = AppChooserUI.f.FBM;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
          paramAnonymousView = new g.a();
          if (AppChooserUI.f(AppChooserUI.this) != 1) {
            break label302;
          }
          paramAnonymousView.abb("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
          paramAnonymousView.abd(AppChooserUI.h(AppChooserUI.this).fdg());
          paramAnonymousView.BB(1);
          paramAnonymousView.jP(true);
          f.cdA().a(paramAnonymousView.ptu);
          t.fdv();
          t.YW(AppChooserUI.g(AppChooserUI.this));
          if (AppChooserUI.g(AppChooserUI.this) == 0)
          {
            if (!AppChooserUI.i(AppChooserUI.this)) {
              break label319;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          }
          label248:
          if (AppChooserUI.g(AppChooserUI.this) == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.f(12809, new Object[] { Integer.valueOf(5), "" });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109510);
          return;
          label302:
          paramAnonymousView.abb(AppChooserUI.h(AppChooserUI.this).aQW());
          break;
          label319:
          com.tencent.mm.plugin.report.service.g.yxI.f(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          break label248;
          label355:
          if (paramAnonymousView == AppChooserUI.f.FBN)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            ae.i("MicroMsg.AppChooserUI", "installRecommendApp");
            localObject = f.cdA().uj(l).path;
            ae.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(localObject) });
            r.b(paramAnonymousView.getContext(), (String)localObject, new AppChooserUI.7(paramAnonymousView), false);
          }
        }
      }
    };
    this.XM = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109511);
        AppChooserUI.this.finish();
        AppMethodBeat.o(109511);
      }
    };
    this.FBy = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109515);
        ae.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.g.ajR().ajA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).FBA = AppChooserUI.f.FBL;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109515);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109514);
        ae.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!bu.isNullOrNil(paramAnonymousString)) && (o.fB(paramAnonymousString)))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).FBA = AppChooserUI.f.FBN;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(109514);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(109512);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        com.tencent.mm.kernel.g.ajR().ajA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        ae.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(109512);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void sY(long paramAnonymousLong)
      {
        AppMethodBeat.i(109513);
        ae.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(109513);
      }
      
      public final void sZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(109516);
        ae.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.g.ajR().ajA().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).FBA = AppChooserUI.f.FBL;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109516);
      }
      
      public final void ta(long paramAnonymousLong) {}
    };
    AppMethodBeat.o(109532);
  }
  
  private int ZY(int paramInt)
  {
    AppMethodBeat.i(109537);
    if (this.mimeType != null)
    {
      i = this.clJ;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(109537);
      return i + paramInt + j;
    }
    int i = this.clJ;
    AppMethodBeat.o(109537);
    return i + paramInt;
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(109541);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.bWW.queryIntentActivities(paramIntent, 65536);
    fiN();
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
          ae.i("MicroMsg.AppChooserUI", "cpan name:%s", new Object[] { ((ResolveInfo)paramIntent.get(j)).activityInfo.name });
          ResolveInfo localResolveInfo = (ResolveInfo)paramIntent.get(j);
          if (localResolveInfo != null)
          {
            String str = localResolveInfo.activityInfo.packageName;
            if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramArrayList.contains(str))) {
              if (this.FBg.aMR(str))
              {
                this.FBj.FBD = localResolveInfo;
                this.FBj.uUL = true;
                if (((paramBoolean) || (!this.FBp)) && ((paramBoolean) || (!this.FBj.uUL))) {
                  break label266;
                }
                localArrayList.add(0, this.FBj);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new c(localResolveInfo, this.FBg.a(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.clJ != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.FBj);
      if (!this.FBq) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.FBj.FBD == null))
      {
        this.FBj.FBD = new ResolveInfo();
        this.FBj.FBD.activityInfo = new ActivityInfo();
        this.FBj.FBD.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.FBD != null)
        {
          paramArrayList = paramArrayList.FBD.activityInfo.packageName;
          if ((!bu.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.g.yxI.f(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.FBj);
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
        localDrawable = d(this.bWW.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = d(this.bWW.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
        if (localDrawable != null)
        {
          ae.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ae.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
      paramResolveInfo = paramResolveInfo.loadIcon(this.bWW);
      AppMethodBeat.o(109543);
    }
    return paramResolveInfo;
  }
  
  private static Drawable d(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(109542);
    try
    {
      paramResources = com.tencent.mm.cc.b.e(paramResources, paramInt);
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
  
  private int fiM()
  {
    return 274496 + this.clJ;
  }
  
  private void fiN()
  {
    AppMethodBeat.i(109539);
    t.a locala = this.FBg.fdh();
    if (!bu.isNullOrNil(locala.FeL))
    {
      this.FBe = locala.FeL;
      if (locala.FeJ > 0) {
        this.FBj.FBF = getResources().getDrawable(locala.FeJ);
      }
      if (locala.FeM <= 0) {
        break label163;
      }
    }
    label163:
    for (this.FBj.FBE = getResources().getString(locala.FeM);; this.FBj.FBE = locala.FeN)
    {
      this.FBj.FBG = true;
      this.FBj.BWm = this.FBp;
      if (this.FBp) {
        this.FBj.uUL = true;
      }
      if (this.FBq) {
        this.FBj.FBH = true;
      }
      AppMethodBeat.o(109539);
      return;
      if (locala.FeK <= 0) {
        break;
      }
      this.FBe = getResources().getString(locala.FeK);
      break;
    }
  }
  
  private boolean fiO()
  {
    AppMethodBeat.i(109540);
    ae.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.FBr), Integer.valueOf(this.FBn), Integer.valueOf(this.FBo), Boolean.valueOf(bu.jq(this)) });
    if ((this.FBr) && (this.FBn < this.FBo) && (!bu.jq(this)) && (k.cSM != 1))
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
    localIntent.putExtra("transferback", this.FBf);
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
    t.fdv();
    t.YT(this.clJ);
    al.b(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      ae.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      m(0, null, false);
      AppMethodBeat.o(109533);
      return;
    }
    this.FBd = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.clJ = ((Intent)localObject).getIntExtra("type", 0);
    this.FBl = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.FBf = ((Intent)localObject).getBundleExtra("transferback");
    this.FBh = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.FBq = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    boolean bool;
    if (com.tencent.mm.kernel.g.ajM())
    {
      this.FBm = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(ZY(274528), ""));
      if ((TextUtils.isEmpty(this.FBm)) || (!q.s(getContext(), this.FBm)) || ((this.FBh != null) && (!this.FBh.isEmpty()) && (!this.FBh.contains(this.FBm))) || (this.FBl)) {
        break label1291;
      }
      Intent localIntent = new Intent(this.FBd);
      localIntent.setPackage(this.FBm);
      if (!bu.aj(this, localIntent)) {
        break label424;
      }
      bool = true;
    }
    for (;;)
    {
      ae.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.scene), this.FBm, this.mimeType, Boolean.valueOf(this.FBl) });
      if ((bool) && (this.scene != 6))
      {
        m(-1, this.FBm, true);
        AppMethodBeat.o(109533);
        return;
        ae.e("MicroMsg.AppChooserUI", "acc not ready");
        m(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label424:
        bool = false;
      }
      else
      {
        this.bWW = getPackageManager();
        this.FBc = new a();
        t.fdv();
        this.FBg = t.A(this.clJ, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.FBp = this.FBg.ht(getContext());
        this.FBn = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(fiM(), Integer.valueOf(0))).intValue();
        t.fdv();
        this.FBo = t.YS(this.clJ);
        ae.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.FBp), Integer.valueOf(this.FBn) });
        int i;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.FBr = bool;
          if (this.FBn < this.FBo) {
            break label791;
          }
          i = 1;
          label596:
          this.FBk = a(this.FBd, fiO(), this.FBh);
          if ((i == 0) && (!this.FBp)) {
            com.tencent.mm.kernel.g.ajR().ajA().set(fiM(), Integer.valueOf(this.FBn + 1));
          }
          if (!this.FBp) {
            break label796;
          }
          t.fdv();
          t.YV(this.clJ);
          label667:
          if (this.FBk == null) {
            break label814;
          }
        }
        label791:
        label796:
        label814:
        for (int j = this.FBk.size();; j = 0)
        {
          ae.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.FBk == null) || (this.FBk.size() != 1) || ((fiO()) && (!this.FBp))) {
            break label851;
          }
          paramBundle = (c)this.FBk.get(0);
          if (paramBundle == null) {
            break label835;
          }
          if (paramBundle.FBD == null) {
            break label819;
          }
          m(-1, paramBundle.FBD.activityInfo.packageName, false);
          AppMethodBeat.o(109533);
          return;
          bool = false;
          break;
          i = 0;
          break label596;
          if (i != 0) {
            break label667;
          }
          t.fdv();
          t.YU(this.clJ);
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
        if ((this.FBk != null) && (!this.FBk.isEmpty()))
        {
          this.FBc.pHD = this.FBk;
          this.FBs = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(ZY(274560), Long.valueOf(0L))).longValue();
          localObject = f.cdA().uj(this.FBs);
          ae.d("MicroMsg.AppChooserUI", "downloadId:" + this.FBs + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (o.fB(((FileDownloadTaskInfo)localObject).path)) && (this.FBc != null))
          {
            this.FBc.FBA = f.FBN;
            this.FBc.notifyDataSetChanged();
          }
          this.FBt = new e(getContext());
          localObject = this.FBt;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.FBt.FBJ = this.FBu;
            this.FBt.FBw = this.FBw;
            this.FBt.FBK = this.FBv;
            this.FBt.oKk = this.FBc;
            this.FBt.XM = this.XM;
            paramBundle = this.FBt;
            if (paramBundle.FBJ != null) {
              paramBundle.FBI.setOnItemClickListener(paramBundle.FBJ);
            }
            if (paramBundle.oKk != null) {
              paramBundle.FBI.setAdapter(paramBundle.oKk);
            }
            paramBundle.jxa = h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.FBI, paramBundle.mContext.getString(2131755922), paramBundle.mContext.getString(2131755921), paramBundle.FBw, paramBundle.FBK, 2131100464);
            paramBundle.jxa.setOnDismissListener(paramBundle.XM);
            paramBundle.jxa.show();
            if ((!this.FBq) && (this.FBp) && (i == 0))
            {
              this.FBi = this.FBj;
              this.FBt.wp(true);
            }
            f.cdA();
            c.a(this.FBy);
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
    f.cdA();
    c.b(this.FBy);
    if (this.FBt != null) {
      this.FBt.jxa.dismiss();
    }
    AppMethodBeat.o(109535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109534);
    super.onResume();
    if ((this.FBq) && (this.FBd != null) && (this.FBg.ah(this, this.FBd)))
    {
      ae.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.FBq = false;
      this.FBj.FBH = false;
    }
    this.FBp = this.FBg.ht(getContext());
    this.FBk = a(this.FBd, fiO(), this.FBh);
    if ((this.FBp) && (this.FBi == null) && (!this.FBl))
    {
      this.FBi = this.FBj;
      this.FBt.wp(true);
    }
    if (this.FBc != null)
    {
      this.FBc.pHD = this.FBk;
      this.FBc.notifyDataSetChanged();
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
    AppChooserUI.f FBA;
    List<AppChooserUI.c> pHD;
    
    public a()
    {
      AppMethodBeat.i(109518);
      this.pHD = new ArrayList();
      this.FBA = AppChooserUI.f.FBL;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      AppMethodBeat.o(109518);
    }
    
    public final AppChooserUI.c ZZ(int paramInt)
    {
      AppMethodBeat.i(109520);
      if (this.pHD == null)
      {
        AppMethodBeat.o(109520);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.pHD.get(paramInt);
      AppMethodBeat.o(109520);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109522);
      if (this.pHD == null)
      {
        AppMethodBeat.o(109522);
        return 0;
      }
      int i = this.pHD.size();
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
      if (ZZ(paramInt).FBG)
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
      AppChooserUI.c localc = ZZ(paramInt);
      label73:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.getContext());
        if (localc.FBG)
        {
          paramInt = 2131493081;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc.FBF == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc });
          }
          paramViewGroup.vl.setImageDrawable(localc.FBF);
          Object localObject2 = localc.FBE;
          Object localObject1 = localObject2;
          if (AppChooserUI.k(AppChooserUI.this))
          {
            localObject1 = localObject2;
            if (localc.FBD != null)
            {
              localObject1 = localObject2;
              if (localc.FBD.activityInfo.packageName.equals(AppChooserUI.l(AppChooserUI.this)))
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
          paramViewGroup.uDY.setText((CharSequence)localObject1);
          if ((localc == null) || ((localc.FBG) && (!localc.BWm) && ((!localc.FBG) || (!localc.uUL) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc.FBH)) {
            break label554;
          }
          paramViewGroup.FBB.setVisibility(8);
          paramViewGroup.FBC.setVisibility(0);
          localObject1 = paramViewGroup.FBC;
          localObject2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localObject2 instanceof AppChooserUI.c)) {
            break label548;
          }
          localObject2 = (AppChooserUI.c)localObject2;
          if (((((AppChooserUI.c)localObject2).FBD == null) || (localc.FBD == null) || (!((AppChooserUI.c)localObject2).FBD.activityInfo.packageName.equals(localc.FBD.activityInfo.packageName))) && ((!((AppChooserUI.c)localObject2).FBG) || (!localc.FBG))) {
            break label548;
          }
          bool = true;
          label413:
          ((RadioButton)localObject1).setChecked(bool);
          label420:
          if (!localc.FBG) {
            break label740;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label720;
          }
          paramViewGroup.uEa.setText(2131762069);
          label448:
          localObject1 = paramViewGroup.uEa;
          paramInt = i;
          if (bu.isNullOrNil(AppChooserUI.n(AppChooserUI.this))) {
            paramInt = 8;
          }
          ((TextView)localObject1).setVisibility(paramInt);
        }
      }
      for (;;)
      {
        if ((AppChooserUI.f(AppChooserUI.this) != 6) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).equals(localc))) {
          paramViewGroup.FBC.setChecked(true);
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
        paramViewGroup.FBB.setVisibility(0);
        paramViewGroup.FBC.setVisibility(8);
        paramViewGroup.FBB.setOnClickListener(AppChooserUI.m(AppChooserUI.this));
        if (this.FBA == AppChooserUI.f.FBL)
        {
          if (localc.FBH) {
            paramViewGroup.FBB.setText(2131755827);
          }
          for (;;)
          {
            paramViewGroup.FBB.setEnabled(true);
            break;
            paramViewGroup.FBB.setText(2131755714);
          }
        }
        if (this.FBA == AppChooserUI.f.FBM)
        {
          paramViewGroup.FBB.setText(2131755720);
          paramViewGroup.FBB.setEnabled(false);
          break label420;
        }
        if (this.FBA != AppChooserUI.f.FBN) {
          break label420;
        }
        if (localc.FBH) {
          paramViewGroup.FBB.setText(2131755908);
        }
        for (;;)
        {
          paramViewGroup.FBB.setEnabled(true);
          break;
          paramViewGroup.FBB.setText(2131755907);
        }
        label720:
        paramViewGroup.uEa.setText(bu.nullAsNil(AppChooserUI.n(AppChooserUI.this)));
        break label448;
        label740:
        paramViewGroup.uEa.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    TextView FBB;
    RadioButton FBC;
    TextView uDY;
    TextView uEa;
    ImageView vl;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109524);
      this.vl = ((ImageView)paramView.findViewById(2131296852));
      this.uDY = ((TextView)paramView.findViewById(2131296865));
      this.uEa = ((TextView)paramView.findViewById(2131296843));
      this.FBB = ((TextView)paramView.findViewById(2131296875));
      this.FBC = ((RadioButton)paramView.findViewById(2131296871));
      AppMethodBeat.o(109524);
    }
  }
  
  final class c
  {
    boolean BWm;
    ResolveInfo FBD;
    CharSequence FBE;
    Drawable FBF;
    boolean FBG;
    boolean FBH;
    boolean uUL;
    
    public c() {}
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      this.FBD = paramResolveInfo;
      this.FBE = paramCharSequence;
      this.FBG = false;
      this.BWm = true;
      this.FBH = false;
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d() {}
  }
  
  final class e
  {
    ListViewInScrollView FBI;
    AdapterView.OnItemClickListener FBJ;
    DialogInterface.OnClickListener FBK;
    DialogInterface.OnClickListener FBw;
    DialogInterface.OnDismissListener XM;
    public d jxa;
    Context mContext;
    String mTitle;
    BaseAdapter oKk;
    
    public e(Context paramContext)
    {
      AppMethodBeat.i(109527);
      this.mContext = paramContext;
      this.FBI = ((ListViewInScrollView)View.inflate(this.mContext, 2131493079, null));
      AppMethodBeat.o(109527);
    }
    
    public final void wp(boolean paramBoolean)
    {
      AppMethodBeat.i(109528);
      if (this.jxa != null)
      {
        if (!paramBoolean)
        {
          this.jxa.a(2131755922, null);
          this.jxa.b(2131755921, null);
          AppMethodBeat.o(109528);
          return;
        }
        this.jxa.a(2131755922, this.FBw);
        this.jxa.b(2131755921, this.FBK);
      }
      AppMethodBeat.o(109528);
    }
  }
  
  public static enum f
  {
    static
    {
      AppMethodBeat.i(109531);
      FBL = new f("UNINSTALL", 0);
      FBM = new f("DOWNLOADING", 1);
      FBN = new f("DOWNLOADED", 2);
      FBO = new f[] { FBL, FBM, FBN };
      AppMethodBeat.o(109531);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */