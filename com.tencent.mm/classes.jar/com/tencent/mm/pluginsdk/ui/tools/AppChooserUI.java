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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private a KsA;
  private Intent KsB;
  private String KsC;
  private Bundle KsD;
  private t KsE;
  private ArrayList<String> KsF;
  private c KsG;
  private c KsH;
  private List<c> KsI;
  private boolean KsJ;
  private String KsK;
  private int KsL;
  private int KsM;
  private boolean KsN;
  private boolean KsO;
  private boolean KsP;
  private long KsQ;
  private e KsR;
  private AdapterView.OnItemClickListener KsS;
  private DialogInterface.OnClickListener KsT;
  private DialogInterface.OnClickListener KsU;
  private View.OnClickListener KsV;
  private m KsW;
  private DialogInterface.OnDismissListener XZ;
  private PackageManager chE;
  private int cxE;
  private String mimeType;
  private int scene;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(109532);
    this.KsB = null;
    this.KsC = null;
    this.KsD = null;
    this.KsE = null;
    this.KsF = null;
    this.scene = 0;
    this.KsG = null;
    this.KsH = new c();
    this.KsJ = false;
    this.mimeType = null;
    this.KsN = false;
    this.KsO = false;
    this.KsP = false;
    this.KsS = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(109507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).aiN(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).kvo.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).Kte) || ((AppChooserUI.c(AppChooserUI.this).ynm) && ((AppChooserUI.c(AppChooserUI.this).GwV) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label325;
            }
            AppChooserUI.b(AppChooserUI.this).Ap(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Ktb != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Ktb.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).Ktb.activityInfo.packageName });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(109507);
          return;
          label325:
          AppChooserUI.b(AppChooserUI.this).Ap(true);
        }
      }
    };
    this.KsT = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109508);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Ktb != null))
        {
          g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).Ktb.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Ktb.activityInfo.packageName, true);
        }
        AppMethodBeat.o(109508);
      }
    };
    this.KsU = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109509);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Ktb != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Ktb.activityInfo.packageName, false);
        }
        AppMethodBeat.o(109509);
      }
    };
    this.KsV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109510);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          paramAnonymousView = AppChooserUI.a(AppChooserUI.this).KsY;
          if (paramAnonymousView != AppChooserUI.f.Ktj) {
            break label355;
          }
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).kvo.isShowing()))
          {
            AppChooserUI.a(AppChooserUI.this).KsY = AppChooserUI.f.Ktk;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
          paramAnonymousView = new g.a();
          if (AppChooserUI.f(AppChooserUI.this) != 1) {
            break label302;
          }
          paramAnonymousView.alj("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
          paramAnonymousView.all(AppChooserUI.h(AppChooserUI.this).gmq());
          paramAnonymousView.Fl(1);
          paramAnonymousView.kS(true);
          f.cBv().a(paramAnonymousView.qIY);
          u.gmF();
          u.ahI(AppChooserUI.g(AppChooserUI.this));
          if (AppChooserUI.g(AppChooserUI.this) == 0)
          {
            if (!AppChooserUI.i(AppChooserUI.this)) {
              break label319;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          }
          label248:
          if (AppChooserUI.g(AppChooserUI.this) == 1) {
            com.tencent.mm.plugin.report.service.h.CyF.a(12809, new Object[] { Integer.valueOf(5), "" });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109510);
          return;
          label302:
          paramAnonymousView.alj(AppChooserUI.h(AppChooserUI.this).blB());
          break;
          label319:
          com.tencent.mm.plugin.report.service.h.CyF.a(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          break label248;
          label355:
          if (paramAnonymousView == AppChooserUI.f.Ktl)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            Log.i("MicroMsg.AppChooserUI", "installRecommendApp");
            localObject = f.cBv().Co(l).path;
            Log.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(localObject) });
            r.b(paramAnonymousView.getContext(), (String)localObject, new AppChooserUI.7(paramAnonymousView), false);
          }
        }
      }
    };
    this.XZ = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109511);
        AppChooserUI.this.finish();
        AppMethodBeat.o(109511);
      }
    };
    this.KsW = new m()
    {
      public final void Bd(long paramAnonymousLong)
      {
        AppMethodBeat.i(109513);
        Log.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(109513);
      }
      
      public final void Be(long paramAnonymousLong)
      {
        AppMethodBeat.i(109516);
        Log.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).KsY = AppChooserUI.f.Ktj;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109516);
      }
      
      public final void Bf(long paramAnonymousLong) {}
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109515);
        Log.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).KsY = AppChooserUI.f.Ktj;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109515);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109514);
        Log.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!Util.isNullOrNil(paramAnonymousString)) && (s.YS(paramAnonymousString)))
        {
          g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).KsY = AppChooserUI.f.Ktl;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(109514);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(109512);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        g.aAh().azQ().set(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        Log.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(109512);
      }
      
      public final void l(long paramAnonymousLong, String paramAnonymousString) {}
    };
    AppMethodBeat.o(109532);
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(109541);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.chE.queryIntentActivities(paramIntent, 65536);
    gsb();
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
          Log.i("MicroMsg.AppChooserUI", "cpan name:%s", new Object[] { ((ResolveInfo)paramIntent.get(j)).activityInfo.name });
          ResolveInfo localResolveInfo = (ResolveInfo)paramIntent.get(j);
          if (localResolveInfo != null)
          {
            String str = localResolveInfo.activityInfo.packageName;
            if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramArrayList.contains(str))) {
              if (this.KsE.bdn(str))
              {
                this.KsH.Ktb = localResolveInfo;
                this.KsH.ynm = true;
                if (((paramBoolean) || (!this.KsN)) && ((paramBoolean) || (!this.KsH.ynm))) {
                  break label266;
                }
                localArrayList.add(0, this.KsH);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new c(localResolveInfo, this.KsE.c(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.cxE != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.KsH);
      if (!this.KsO) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.KsH.Ktb == null))
      {
        this.KsH.Ktb = new ResolveInfo();
        this.KsH.Ktb.activityInfo = new ActivityInfo();
        this.KsH.Ktb.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.Ktb != null)
        {
          paramArrayList = paramArrayList.Ktb.activityInfo.packageName;
          if ((!Util.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.h.CyF.a(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.KsH);
    }
    AppMethodBeat.o(109541);
    return localArrayList;
  }
  
  private int aiM(int paramInt)
  {
    AppMethodBeat.i(109537);
    if (this.mimeType != null)
    {
      i = this.cxE;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(109537);
      return i + paramInt + j;
    }
    int i = this.cxE;
    AppMethodBeat.o(109537);
    return i + paramInt;
  }
  
  private Drawable c(ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(109543);
    try
    {
      Drawable localDrawable;
      if ((paramResolveInfo.resolvePackageName != null) && (paramResolveInfo.icon != 0))
      {
        localDrawable = e(this.chE.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = e(this.chE.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
        if (localDrawable != null)
        {
          Log.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
      paramResolveInfo = paramResolveInfo.loadIcon(this.chE);
      AppMethodBeat.o(109543);
    }
    return paramResolveInfo;
  }
  
  private static Drawable e(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(109542);
    try
    {
      paramResources = com.tencent.mm.cc.b.f(paramResources, paramInt);
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
  
  private int gsa()
  {
    return 274496 + this.cxE;
  }
  
  private void gsb()
  {
    AppMethodBeat.i(109539);
    u.a locala = this.KsE.gmr();
    if (!Util.isNullOrNil(locala.JVC))
    {
      this.KsC = locala.JVC;
      if (locala.JVA > 0) {
        this.KsH.Ktd = getResources().getDrawable(locala.JVA);
      }
      if (locala.JVD <= 0) {
        break label163;
      }
    }
    label163:
    for (this.KsH.Ktc = getResources().getString(locala.JVD);; this.KsH.Ktc = locala.JVE)
    {
      this.KsH.Kte = true;
      this.KsH.GwV = this.KsN;
      if (this.KsN) {
        this.KsH.ynm = true;
      }
      if (this.KsO) {
        this.KsH.Ktf = true;
      }
      AppMethodBeat.o(109539);
      return;
      if (locala.JVB <= 0) {
        break;
      }
      this.KsC = getResources().getString(locala.JVB);
      break;
    }
  }
  
  private boolean gsc()
  {
    AppMethodBeat.i(109540);
    Log.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.KsP), Integer.valueOf(this.KsL), Integer.valueOf(this.KsM), Boolean.valueOf(Util.isOverseasUser(this)) });
    if ((this.KsP) && (this.KsL < this.KsM) && (!Util.isOverseasUser(this)) && (ChannelUtil.channelId != 1))
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
    localIntent.putExtra("transferback", this.KsD);
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
    u.gmF();
    u.ahF(this.cxE);
    com.tencent.mm.ui.ao.e(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      Log.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      m(0, null, false);
      AppMethodBeat.o(109533);
      return;
    }
    this.KsB = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.cxE = ((Intent)localObject).getIntExtra("type", 0);
    this.KsJ = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.KsD = ((Intent)localObject).getBundleExtra("transferback");
    this.KsF = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.KsO = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    boolean bool;
    if (g.aAc())
    {
      this.KsK = ((String)g.aAh().azQ().get(aiM(274528), ""));
      if ((TextUtils.isEmpty(this.KsK)) || (!q.s(getContext(), this.KsK)) || ((this.KsF != null) && (!this.KsF.isEmpty()) && (!this.KsF.contains(this.KsK))) || (this.KsJ)) {
        break label1291;
      }
      Intent localIntent = new Intent(this.KsB);
      localIntent.setPackage(this.KsK);
      if (!Util.isIntentAvailable(this, localIntent)) {
        break label424;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.scene), this.KsK, this.mimeType, Boolean.valueOf(this.KsJ) });
      if ((bool) && (this.scene != 6))
      {
        m(-1, this.KsK, true);
        AppMethodBeat.o(109533);
        return;
        Log.e("MicroMsg.AppChooserUI", "acc not ready");
        m(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label424:
        bool = false;
      }
      else
      {
        this.chE = getPackageManager();
        this.KsA = new a();
        u.gmF();
        this.KsE = u.A(this.cxE, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.KsN = this.KsE.in(getContext());
        this.KsL = ((Integer)g.aAh().azQ().get(gsa(), Integer.valueOf(0))).intValue();
        u.gmF();
        this.KsM = u.ahE(this.cxE);
        Log.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.KsN), Integer.valueOf(this.KsL) });
        int i;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.KsP = bool;
          if (this.KsL < this.KsM) {
            break label791;
          }
          i = 1;
          label596:
          this.KsI = a(this.KsB, gsc(), this.KsF);
          if ((i == 0) && (!this.KsN)) {
            g.aAh().azQ().set(gsa(), Integer.valueOf(this.KsL + 1));
          }
          if (!this.KsN) {
            break label796;
          }
          u.gmF();
          u.ahH(this.cxE);
          label667:
          if (this.KsI == null) {
            break label814;
          }
        }
        label791:
        label796:
        label814:
        for (int j = this.KsI.size();; j = 0)
        {
          Log.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.KsI == null) || (this.KsI.size() != 1) || ((gsc()) && (!this.KsN))) {
            break label851;
          }
          paramBundle = (c)this.KsI.get(0);
          if (paramBundle == null) {
            break label835;
          }
          if (paramBundle.Ktb == null) {
            break label819;
          }
          m(-1, paramBundle.Ktb.activityInfo.packageName, false);
          AppMethodBeat.o(109533);
          return;
          bool = false;
          break;
          i = 0;
          break label596;
          if (i != 0) {
            break label667;
          }
          u.gmF();
          u.ahG(this.cxE);
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
        if ((this.KsI != null) && (!this.KsI.isEmpty()))
        {
          this.KsA.qXp = this.KsI;
          this.KsQ = ((Long)g.aAh().azQ().get(aiM(274560), Long.valueOf(0L))).longValue();
          localObject = f.cBv().Co(this.KsQ);
          Log.d("MicroMsg.AppChooserUI", "downloadId:" + this.KsQ + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (s.YS(((FileDownloadTaskInfo)localObject).path)) && (this.KsA != null))
          {
            this.KsA.KsY = f.Ktl;
            this.KsA.notifyDataSetChanged();
          }
          this.KsR = new e(getContext());
          localObject = this.KsR;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.KsR.Kth = this.KsS;
            this.KsR.KsU = this.KsU;
            this.KsR.Kti = this.KsT;
            this.KsR.pXY = this.KsA;
            this.KsR.XZ = this.XZ;
            paramBundle = this.KsR;
            if (paramBundle.Kth != null) {
              paramBundle.Ktg.setOnItemClickListener(paramBundle.Kth);
            }
            if (paramBundle.pXY != null) {
              paramBundle.Ktg.setAdapter(paramBundle.pXY);
            }
            paramBundle.kvo = com.tencent.mm.ui.base.h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.Ktg, paramBundle.mContext.getString(2131756014), paramBundle.mContext.getString(2131756013), paramBundle.KsU, paramBundle.Kti, 2131100566);
            paramBundle.kvo.setOnDismissListener(paramBundle.XZ);
            paramBundle.kvo.show();
            if ((!this.KsO) && (this.KsN) && (i == 0))
            {
              this.KsG = this.KsH;
              this.KsR.Ap(true);
            }
            f.cBv();
            c.a(this.KsW);
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
    f.cBv();
    c.b(this.KsW);
    if (this.KsR != null) {
      this.KsR.kvo.dismiss();
    }
    AppMethodBeat.o(109535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109534);
    super.onResume();
    if ((this.KsO) && (this.KsB != null) && (this.KsE.aw(this, this.KsB)))
    {
      Log.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.KsO = false;
      this.KsH.Ktf = false;
    }
    this.KsN = this.KsE.in(getContext());
    this.KsI = a(this.KsB, gsc(), this.KsF);
    if ((this.KsN) && (this.KsG == null) && (!this.KsJ))
    {
      this.KsG = this.KsH;
      this.KsR.Ap(true);
    }
    if (this.KsA != null)
    {
      this.KsA.qXp = this.KsI;
      this.KsA.notifyDataSetChanged();
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
    AppChooserUI.f KsY;
    List<AppChooserUI.c> qXp;
    
    public a()
    {
      AppMethodBeat.i(109518);
      this.qXp = new ArrayList();
      this.KsY = AppChooserUI.f.Ktj;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      AppMethodBeat.o(109518);
    }
    
    public final AppChooserUI.c aiN(int paramInt)
    {
      AppMethodBeat.i(109520);
      if (this.qXp == null)
      {
        AppMethodBeat.o(109520);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.qXp.get(paramInt);
      AppMethodBeat.o(109520);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109522);
      if (this.qXp == null)
      {
        AppMethodBeat.o(109522);
        return 0;
      }
      int i = this.qXp.size();
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
      if (aiN(paramInt).Kte)
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
      AppChooserUI.c localc = aiN(paramInt);
      label73:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.getContext());
        if (localc.Kte)
        {
          paramInt = 2131493123;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc.Ktd == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc });
          }
          paramViewGroup.vs.setImageDrawable(localc.Ktd);
          Object localObject2 = localc.Ktc;
          Object localObject1 = localObject2;
          if (AppChooserUI.k(AppChooserUI.this))
          {
            localObject1 = localObject2;
            if (localc.Ktb != null)
            {
              localObject1 = localObject2;
              if (localc.Ktb.activityInfo.packageName.equals(AppChooserUI.l(AppChooserUI.this)))
              {
                localObject2 = TextUtils.concat(new CharSequence[] { localObject2, AppChooserUI.this.getString(2131755777) });
                localObject1 = localObject2;
                if (AppChooserUI.c(AppChooserUI.this) == null)
                {
                  AppChooserUI.a(AppChooserUI.this, localc);
                  localObject1 = localObject2;
                }
              }
            }
          }
          paramViewGroup.xVW.setText((CharSequence)localObject1);
          if ((localc == null) || ((localc.Kte) && (!localc.GwV) && ((!localc.Kte) || (!localc.ynm) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc.Ktf)) {
            break label554;
          }
          paramViewGroup.KsZ.setVisibility(8);
          paramViewGroup.Kta.setVisibility(0);
          localObject1 = paramViewGroup.Kta;
          localObject2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localObject2 instanceof AppChooserUI.c)) {
            break label548;
          }
          localObject2 = (AppChooserUI.c)localObject2;
          if (((((AppChooserUI.c)localObject2).Ktb == null) || (localc.Ktb == null) || (!((AppChooserUI.c)localObject2).Ktb.activityInfo.packageName.equals(localc.Ktb.activityInfo.packageName))) && ((!((AppChooserUI.c)localObject2).Kte) || (!localc.Kte))) {
            break label548;
          }
          bool = true;
          label413:
          ((RadioButton)localObject1).setChecked(bool);
          label420:
          if (!localc.Kte) {
            break label740;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label720;
          }
          paramViewGroup.xVY.setText(2131764087);
          label448:
          localObject1 = paramViewGroup.xVY;
          paramInt = i;
          if (Util.isNullOrNil(AppChooserUI.n(AppChooserUI.this))) {
            paramInt = 8;
          }
          ((TextView)localObject1).setVisibility(paramInt);
        }
      }
      for (;;)
      {
        if ((AppChooserUI.f(AppChooserUI.this) != 6) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).equals(localc))) {
          paramViewGroup.Kta.setChecked(true);
        }
        AppMethodBeat.o(109519);
        return paramView;
        paramInt = 2131493122;
        break;
        paramViewGroup = (AppChooserUI.b)paramView.getTag();
        break label73;
        label548:
        bool = false;
        break label413;
        label554:
        paramViewGroup.KsZ.setVisibility(0);
        paramViewGroup.Kta.setVisibility(8);
        paramViewGroup.KsZ.setOnClickListener(AppChooserUI.m(AppChooserUI.this));
        if (this.KsY == AppChooserUI.f.Ktj)
        {
          if (localc.Ktf) {
            paramViewGroup.KsZ.setText(2131755913);
          }
          for (;;)
          {
            paramViewGroup.KsZ.setEnabled(true);
            break;
            paramViewGroup.KsZ.setText(2131755785);
          }
        }
        if (this.KsY == AppChooserUI.f.Ktk)
        {
          paramViewGroup.KsZ.setText(2131755791);
          paramViewGroup.KsZ.setEnabled(false);
          break label420;
        }
        if (this.KsY != AppChooserUI.f.Ktl) {
          break label420;
        }
        if (localc.Ktf) {
          paramViewGroup.KsZ.setText(2131756000);
        }
        for (;;)
        {
          paramViewGroup.KsZ.setEnabled(true);
          break;
          paramViewGroup.KsZ.setText(2131755999);
        }
        label720:
        paramViewGroup.xVY.setText(Util.nullAsNil(AppChooserUI.n(AppChooserUI.this)));
        break label448;
        label740:
        paramViewGroup.xVY.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    TextView KsZ;
    RadioButton Kta;
    ImageView vs;
    TextView xVW;
    TextView xVY;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109524);
      this.vs = ((ImageView)paramView.findViewById(2131296944));
      this.xVW = ((TextView)paramView.findViewById(2131296958));
      this.xVY = ((TextView)paramView.findViewById(2131296935));
      this.KsZ = ((TextView)paramView.findViewById(2131296968));
      this.Kta = ((RadioButton)paramView.findViewById(2131296964));
      AppMethodBeat.o(109524);
    }
  }
  
  final class c
  {
    boolean GwV;
    ResolveInfo Ktb;
    CharSequence Ktc;
    Drawable Ktd;
    boolean Kte;
    boolean Ktf;
    boolean ynm;
    
    public c() {}
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      this.Ktb = paramResolveInfo;
      this.Ktc = paramCharSequence;
      this.Kte = false;
      this.GwV = true;
      this.Ktf = false;
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d() {}
  }
  
  final class e
  {
    DialogInterface.OnClickListener KsU;
    ListViewInScrollView Ktg;
    AdapterView.OnItemClickListener Kth;
    DialogInterface.OnClickListener Kti;
    DialogInterface.OnDismissListener XZ;
    public d kvo;
    Context mContext;
    String mTitle;
    BaseAdapter pXY;
    
    public e(Context paramContext)
    {
      AppMethodBeat.i(109527);
      this.mContext = paramContext;
      this.Ktg = ((ListViewInScrollView)View.inflate(this.mContext, 2131493121, null));
      AppMethodBeat.o(109527);
    }
    
    public final void Ap(boolean paramBoolean)
    {
      AppMethodBeat.i(109528);
      if (this.kvo != null)
      {
        if (!paramBoolean)
        {
          this.kvo.a(2131756014, null);
          this.kvo.b(2131756013, null);
          AppMethodBeat.o(109528);
          return;
        }
        this.kvo.a(2131756014, this.KsU);
        this.kvo.b(2131756013, this.Kti);
      }
      AppMethodBeat.o(109528);
    }
  }
  
  public static enum f
  {
    static
    {
      AppMethodBeat.i(109531);
      Ktj = new f("UNINSTALL", 0);
      Ktk = new f("DOWNLOADING", 1);
      Ktl = new f("DOWNLOADED", 2);
      Ktm = new f[] { Ktj, Ktk, Ktl };
      AppMethodBeat.o(109531);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */