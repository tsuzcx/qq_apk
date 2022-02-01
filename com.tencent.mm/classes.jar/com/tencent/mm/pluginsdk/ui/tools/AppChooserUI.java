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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private a FiD;
  private Intent FiE;
  private String FiF;
  private Bundle FiG;
  private s FiH;
  private ArrayList<String> FiI;
  private c FiJ;
  private c FiK;
  private List<c> FiL;
  private boolean FiM;
  private String FiN;
  private int FiO;
  private int FiP;
  private boolean FiQ;
  private boolean FiR;
  private boolean FiS;
  private long FiT;
  private e FiU;
  private AdapterView.OnItemClickListener FiV;
  private DialogInterface.OnClickListener FiW;
  private DialogInterface.OnClickListener FiX;
  private View.OnClickListener FiY;
  private m FiZ;
  private DialogInterface.OnDismissListener XM;
  private PackageManager bWW;
  private int clH;
  private String mimeType;
  private int scene;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(109532);
    this.FiE = null;
    this.FiF = null;
    this.FiG = null;
    this.FiH = null;
    this.FiI = null;
    this.scene = 0;
    this.FiJ = null;
    this.FiK = new c();
    this.FiM = false;
    this.mimeType = null;
    this.FiQ = false;
    this.FiR = false;
    this.FiS = false;
    this.FiV = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(109507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).Zt(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).juf.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).Fjh) || ((AppChooserUI.c(AppChooserUI.this).uIY) && ((AppChooserUI.c(AppChooserUI.this).BEO) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label325;
            }
            AppChooserUI.b(AppChooserUI.this).wh(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Fje != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Fje.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).Fje.activityInfo.packageName });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(109507);
          return;
          label325:
          AppChooserUI.b(AppChooserUI.this).wh(true);
        }
      }
    };
    this.FiW = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109508);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Fje != null))
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).Fje.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Fje.activityInfo.packageName, true);
        }
        AppMethodBeat.o(109508);
      }
    };
    this.FiX = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109509);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Fje != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Fje.activityInfo.packageName, false);
        }
        AppMethodBeat.o(109509);
      }
    };
    this.FiY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109510);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          paramAnonymousView = AppChooserUI.a(AppChooserUI.this).Fjb;
          if (paramAnonymousView != AppChooserUI.f.Fjm) {
            break label355;
          }
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).juf.isShowing()))
          {
            AppChooserUI.a(AppChooserUI.this).Fjb = AppChooserUI.f.Fjn;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
          paramAnonymousView = new g.a();
          if (AppChooserUI.f(AppChooserUI.this) != 1) {
            break label302;
          }
          paramAnonymousView.aak("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
          paramAnonymousView.aam(AppChooserUI.h(AppChooserUI.this).eZs());
          paramAnonymousView.Bp(1);
          paramAnonymousView.jQ(true);
          f.ccl().a(paramAnonymousView.pmN);
          t.eZH();
          t.Yq(AppChooserUI.g(AppChooserUI.this));
          if (AppChooserUI.g(AppChooserUI.this) == 0)
          {
            if (!AppChooserUI.i(AppChooserUI.this)) {
              break label319;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          }
          label248:
          if (AppChooserUI.g(AppChooserUI.this) == 1) {
            com.tencent.mm.plugin.report.service.g.yhR.f(12809, new Object[] { Integer.valueOf(5), "" });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109510);
          return;
          label302:
          paramAnonymousView.aak(AppChooserUI.h(AppChooserUI.this).aQx());
          break;
          label319:
          com.tencent.mm.plugin.report.service.g.yhR.f(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          break label248;
          label355:
          if (paramAnonymousView == AppChooserUI.f.Fjo)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            ad.i("MicroMsg.AppChooserUI", "installRecommendApp");
            localObject = f.ccl().tS(l).path;
            ad.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(localObject) });
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
    this.FiZ = new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109515);
        ad.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.g.ajC().ajl().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).Fjb = AppChooserUI.f.Fjm;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109515);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109514);
        ad.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!bt.isNullOrNil(paramAnonymousString)) && (i.fv(paramAnonymousString)))
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).Fjb = AppChooserUI.f.Fjo;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(109514);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(109512);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        com.tencent.mm.kernel.g.ajC().ajl().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        ad.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(109512);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString) {}
      
      public final void sL(long paramAnonymousLong)
      {
        AppMethodBeat.i(109513);
        ad.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(109513);
      }
      
      public final void sM(long paramAnonymousLong)
      {
        AppMethodBeat.i(109516);
        ad.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.g.ajC().ajl().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).Fjb = AppChooserUI.f.Fjm;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109516);
      }
      
      public final void sN(long paramAnonymousLong) {}
    };
    AppMethodBeat.o(109532);
  }
  
  private int Zs(int paramInt)
  {
    AppMethodBeat.i(109537);
    if (this.mimeType != null)
    {
      i = this.clH;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(109537);
      return i + paramInt + j;
    }
    int i = this.clH;
    AppMethodBeat.o(109537);
    return i + paramInt;
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(109541);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.bWW.queryIntentActivities(paramIntent, 65536);
    feX();
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
              if (this.FiH.aLv(str))
              {
                this.FiK.Fje = localResolveInfo;
                this.FiK.uIY = true;
                if (((paramBoolean) || (!this.FiQ)) && ((paramBoolean) || (!this.FiK.uIY))) {
                  break label266;
                }
                localArrayList.add(0, this.FiK);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new c(localResolveInfo, this.FiH.a(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.clH != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.FiK);
      if (!this.FiR) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.FiK.Fje == null))
      {
        this.FiK.Fje = new ResolveInfo();
        this.FiK.Fje.activityInfo = new ActivityInfo();
        this.FiK.Fje.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.Fje != null)
        {
          paramArrayList = paramArrayList.Fje.activityInfo.packageName;
          if ((!bt.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.g.yhR.f(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.FiK);
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
          ad.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ad.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
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
      paramResources = com.tencent.mm.cd.b.e(paramResources, paramInt);
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
  
  private int feW()
  {
    return 274496 + this.clH;
  }
  
  private void feX()
  {
    AppMethodBeat.i(109539);
    t.a locala = this.FiH.eZt();
    if (!bt.isNullOrNil(locala.EMn))
    {
      this.FiF = locala.EMn;
      if (locala.EMl > 0) {
        this.FiK.Fjg = getResources().getDrawable(locala.EMl);
      }
      if (locala.EMo <= 0) {
        break label163;
      }
    }
    label163:
    for (this.FiK.Fjf = getResources().getString(locala.EMo);; this.FiK.Fjf = locala.EMp)
    {
      this.FiK.Fjh = true;
      this.FiK.BEO = this.FiQ;
      if (this.FiQ) {
        this.FiK.uIY = true;
      }
      if (this.FiR) {
        this.FiK.Fji = true;
      }
      AppMethodBeat.o(109539);
      return;
      if (locala.EMm <= 0) {
        break;
      }
      this.FiF = getResources().getString(locala.EMm);
      break;
    }
  }
  
  private boolean feY()
  {
    AppMethodBeat.i(109540);
    ad.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.FiS), Integer.valueOf(this.FiO), Integer.valueOf(this.FiP), Boolean.valueOf(bt.jk(this)) });
    if ((this.FiS) && (this.FiO < this.FiP) && (!bt.jk(this)) && (j.cSc != 1))
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
    localIntent.putExtra("transferback", this.FiG);
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
    t.eZH();
    t.Yn(this.clH);
    al.b(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      ad.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      m(0, null, false);
      AppMethodBeat.o(109533);
      return;
    }
    this.FiE = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.clH = ((Intent)localObject).getIntExtra("type", 0);
    this.FiM = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.FiG = ((Intent)localObject).getBundleExtra("transferback");
    this.FiI = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.FiR = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    boolean bool;
    if (com.tencent.mm.kernel.g.ajx())
    {
      this.FiN = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(Zs(274528), ""));
      if ((TextUtils.isEmpty(this.FiN)) || (!q.s(getContext(), this.FiN)) || ((this.FiI != null) && (!this.FiI.isEmpty()) && (!this.FiI.contains(this.FiN))) || (this.FiM)) {
        break label1291;
      }
      Intent localIntent = new Intent(this.FiE);
      localIntent.setPackage(this.FiN);
      if (!bt.aj(this, localIntent)) {
        break label424;
      }
      bool = true;
    }
    for (;;)
    {
      ad.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.scene), this.FiN, this.mimeType, Boolean.valueOf(this.FiM) });
      if ((bool) && (this.scene != 6))
      {
        m(-1, this.FiN, true);
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
        this.bWW = getPackageManager();
        this.FiD = new a();
        t.eZH();
        this.FiH = t.A(this.clH, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.FiQ = this.FiH.hn(getContext());
        this.FiO = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(feW(), Integer.valueOf(0))).intValue();
        t.eZH();
        this.FiP = t.Ym(this.clH);
        ad.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.FiQ), Integer.valueOf(this.FiO) });
        int i;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.FiS = bool;
          if (this.FiO < this.FiP) {
            break label791;
          }
          i = 1;
          label596:
          this.FiL = a(this.FiE, feY(), this.FiI);
          if ((i == 0) && (!this.FiQ)) {
            com.tencent.mm.kernel.g.ajC().ajl().set(feW(), Integer.valueOf(this.FiO + 1));
          }
          if (!this.FiQ) {
            break label796;
          }
          t.eZH();
          t.Yp(this.clH);
          label667:
          if (this.FiL == null) {
            break label814;
          }
        }
        label791:
        label796:
        label814:
        for (int j = this.FiL.size();; j = 0)
        {
          ad.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.FiL == null) || (this.FiL.size() != 1) || ((feY()) && (!this.FiQ))) {
            break label851;
          }
          paramBundle = (c)this.FiL.get(0);
          if (paramBundle == null) {
            break label835;
          }
          if (paramBundle.Fje == null) {
            break label819;
          }
          m(-1, paramBundle.Fje.activityInfo.packageName, false);
          AppMethodBeat.o(109533);
          return;
          bool = false;
          break;
          i = 0;
          break label596;
          if (i != 0) {
            break label667;
          }
          t.eZH();
          t.Yo(this.clH);
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
        if ((this.FiL != null) && (!this.FiL.isEmpty()))
        {
          this.FiD.pAZ = this.FiL;
          this.FiT = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(Zs(274560), Long.valueOf(0L))).longValue();
          localObject = f.ccl().tS(this.FiT);
          ad.d("MicroMsg.AppChooserUI", "downloadId:" + this.FiT + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (i.fv(((FileDownloadTaskInfo)localObject).path)) && (this.FiD != null))
          {
            this.FiD.Fjb = AppChooserUI.f.Fjo;
            this.FiD.notifyDataSetChanged();
          }
          this.FiU = new e(getContext());
          localObject = this.FiU;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.FiU.Fjk = this.FiV;
            this.FiU.FiX = this.FiX;
            this.FiU.Fjl = this.FiW;
            this.FiU.oDI = this.FiD;
            this.FiU.XM = this.XM;
            paramBundle = this.FiU;
            if (paramBundle.Fjk != null) {
              paramBundle.Fjj.setOnItemClickListener(paramBundle.Fjk);
            }
            if (paramBundle.oDI != null) {
              paramBundle.Fjj.setAdapter(paramBundle.oDI);
            }
            paramBundle.juf = h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.Fjj, paramBundle.mContext.getString(2131755922), paramBundle.mContext.getString(2131755921), paramBundle.FiX, paramBundle.Fjl, 2131100464);
            paramBundle.juf.setOnDismissListener(paramBundle.XM);
            paramBundle.juf.show();
            if ((!this.FiR) && (this.FiQ) && (i == 0))
            {
              this.FiJ = this.FiK;
              this.FiU.wh(true);
            }
            f.ccl();
            c.a(this.FiZ);
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
    f.ccl();
    c.b(this.FiZ);
    if (this.FiU != null) {
      this.FiU.juf.dismiss();
    }
    AppMethodBeat.o(109535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109534);
    super.onResume();
    if ((this.FiR) && (this.FiE != null) && (this.FiH.ah(this, this.FiE)))
    {
      ad.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.FiR = false;
      this.FiK.Fji = false;
    }
    this.FiQ = this.FiH.hn(getContext());
    this.FiL = a(this.FiE, feY(), this.FiI);
    if ((this.FiQ) && (this.FiJ == null) && (!this.FiM))
    {
      this.FiJ = this.FiK;
      this.FiU.wh(true);
    }
    if (this.FiD != null)
    {
      this.FiD.pAZ = this.FiL;
      this.FiD.notifyDataSetChanged();
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
    AppChooserUI.f Fjb;
    List<AppChooserUI.c> pAZ;
    
    public a()
    {
      AppMethodBeat.i(109518);
      this.pAZ = new ArrayList();
      this.Fjb = AppChooserUI.f.Fjm;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      AppMethodBeat.o(109518);
    }
    
    public final AppChooserUI.c Zt(int paramInt)
    {
      AppMethodBeat.i(109520);
      if (this.pAZ == null)
      {
        AppMethodBeat.o(109520);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.pAZ.get(paramInt);
      AppMethodBeat.o(109520);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109522);
      if (this.pAZ == null)
      {
        AppMethodBeat.o(109522);
        return 0;
      }
      int i = this.pAZ.size();
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
      if (Zt(paramInt).Fjh)
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
      AppChooserUI.c localc = Zt(paramInt);
      label73:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.getContext());
        if (localc.Fjh)
        {
          paramInt = 2131493081;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc.Fjg == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc });
          }
          paramViewGroup.vl.setImageDrawable(localc.Fjg);
          Object localObject2 = localc.Fjf;
          Object localObject1 = localObject2;
          if (AppChooserUI.k(AppChooserUI.this))
          {
            localObject1 = localObject2;
            if (localc.Fje != null)
            {
              localObject1 = localObject2;
              if (localc.Fje.activityInfo.packageName.equals(AppChooserUI.l(AppChooserUI.this)))
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
          paramViewGroup.usF.setText((CharSequence)localObject1);
          if ((localc == null) || ((localc.Fjh) && (!localc.BEO) && ((!localc.Fjh) || (!localc.uIY) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc.Fji)) {
            break label554;
          }
          paramViewGroup.Fjc.setVisibility(8);
          paramViewGroup.Fjd.setVisibility(0);
          localObject1 = paramViewGroup.Fjd;
          localObject2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localObject2 instanceof AppChooserUI.c)) {
            break label548;
          }
          localObject2 = (AppChooserUI.c)localObject2;
          if (((((AppChooserUI.c)localObject2).Fje == null) || (localc.Fje == null) || (!((AppChooserUI.c)localObject2).Fje.activityInfo.packageName.equals(localc.Fje.activityInfo.packageName))) && ((!((AppChooserUI.c)localObject2).Fjh) || (!localc.Fjh))) {
            break label548;
          }
          bool = true;
          label413:
          ((RadioButton)localObject1).setChecked(bool);
          label420:
          if (!localc.Fjh) {
            break label740;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label720;
          }
          paramViewGroup.usH.setText(2131762069);
          label448:
          localObject1 = paramViewGroup.usH;
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
          paramViewGroup.Fjd.setChecked(true);
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
        paramViewGroup.Fjc.setVisibility(0);
        paramViewGroup.Fjd.setVisibility(8);
        paramViewGroup.Fjc.setOnClickListener(AppChooserUI.m(AppChooserUI.this));
        if (this.Fjb == AppChooserUI.f.Fjm)
        {
          if (localc.Fji) {
            paramViewGroup.Fjc.setText(2131755827);
          }
          for (;;)
          {
            paramViewGroup.Fjc.setEnabled(true);
            break;
            paramViewGroup.Fjc.setText(2131755714);
          }
        }
        if (this.Fjb == AppChooserUI.f.Fjn)
        {
          paramViewGroup.Fjc.setText(2131755720);
          paramViewGroup.Fjc.setEnabled(false);
          break label420;
        }
        if (this.Fjb != AppChooserUI.f.Fjo) {
          break label420;
        }
        if (localc.Fji) {
          paramViewGroup.Fjc.setText(2131755908);
        }
        for (;;)
        {
          paramViewGroup.Fjc.setEnabled(true);
          break;
          paramViewGroup.Fjc.setText(2131755907);
        }
        label720:
        paramViewGroup.usH.setText(bt.nullAsNil(AppChooserUI.n(AppChooserUI.this)));
        break label448;
        label740:
        paramViewGroup.usH.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    TextView Fjc;
    RadioButton Fjd;
    TextView usF;
    TextView usH;
    ImageView vl;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109524);
      this.vl = ((ImageView)paramView.findViewById(2131296852));
      this.usF = ((TextView)paramView.findViewById(2131296865));
      this.usH = ((TextView)paramView.findViewById(2131296843));
      this.Fjc = ((TextView)paramView.findViewById(2131296875));
      this.Fjd = ((RadioButton)paramView.findViewById(2131296871));
      AppMethodBeat.o(109524);
    }
  }
  
  final class c
  {
    boolean BEO;
    ResolveInfo Fje;
    CharSequence Fjf;
    Drawable Fjg;
    boolean Fjh;
    boolean Fji;
    boolean uIY;
    
    public c() {}
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      this.Fje = paramResolveInfo;
      this.Fjf = paramCharSequence;
      this.Fjh = false;
      this.BEO = true;
      this.Fji = false;
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d() {}
  }
  
  final class e
  {
    DialogInterface.OnClickListener FiX;
    ListViewInScrollView Fjj;
    AdapterView.OnItemClickListener Fjk;
    DialogInterface.OnClickListener Fjl;
    DialogInterface.OnDismissListener XM;
    public d juf;
    Context mContext;
    String mTitle;
    BaseAdapter oDI;
    
    public e(Context paramContext)
    {
      AppMethodBeat.i(109527);
      this.mContext = paramContext;
      this.Fjj = ((ListViewInScrollView)View.inflate(this.mContext, 2131493079, null));
      AppMethodBeat.o(109527);
    }
    
    public final void wh(boolean paramBoolean)
    {
      AppMethodBeat.i(109528);
      if (this.juf != null)
      {
        if (!paramBoolean)
        {
          this.juf.a(2131755922, null);
          this.juf.b(2131755921, null);
          AppMethodBeat.o(109528);
          return;
        }
        this.juf.a(2131755922, this.FiX);
        this.juf.b(2131755921, this.Fjl);
      }
      AppMethodBeat.o(109528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */