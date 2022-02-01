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
import com.tencent.mm.plugin.d.a.a;
import com.tencent.mm.plugin.d.a.c;
import com.tencent.mm.plugin.d.a.d;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.model.y;
import com.tencent.mm.pluginsdk.model.y.a;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private PackageManager RtG;
  private a RtH;
  private Intent RtI;
  private String RtJ;
  private Bundle RtK;
  private x RtL;
  private ArrayList<String> RtM;
  private c RtN;
  private c RtO;
  private List<c> RtP;
  private boolean RtQ;
  private String RtR;
  private int RtS;
  private int RtT;
  private boolean RtU;
  private boolean RtV;
  private boolean RtW;
  private long RtX;
  private e RtY;
  private AdapterView.OnItemClickListener RtZ;
  private DialogInterface.OnClickListener Rua;
  private DialogInterface.OnClickListener Rub;
  private View.OnClickListener Ruc;
  private m Rud;
  private int csG;
  private DialogInterface.OnDismissListener ft;
  private String mimeType;
  private int scene;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(109532);
    this.RtI = null;
    this.RtJ = null;
    this.RtK = null;
    this.RtL = null;
    this.RtM = null;
    this.scene = 0;
    this.RtN = null;
    this.RtO = new c();
    this.RtQ = false;
    this.mimeType = null;
    this.RtU = false;
    this.RtV = false;
    this.RtW = false;
    this.RtZ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(109507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).aqU(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).nnz.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).Rul) || ((AppChooserUI.c(AppChooserUI.this).DNo) && ((AppChooserUI.c(AppChooserUI.this).Nko) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label325;
            }
            AppChooserUI.b(AppChooserUI.this).Eu(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Rui != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Rui.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).Rui.activityInfo.packageName });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(109507);
          return;
          label325:
          AppChooserUI.b(AppChooserUI.this).Eu(true);
        }
      }
    };
    this.Rua = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109508);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Rui != null))
        {
          com.tencent.mm.kernel.h.aHG().aHp().i(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).Rui.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Rui.activityInfo.packageName, true);
        }
        AppMethodBeat.o(109508);
      }
    };
    this.Rub = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109509);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).Rui != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).Rui.activityInfo.packageName, false);
        }
        AppMethodBeat.o(109509);
      }
    };
    this.Ruc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109510);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        y.a locala;
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          paramAnonymousView = AppChooserUI.a(AppChooserUI.this).Ruf;
          if (paramAnonymousView != AppChooserUI.f.Ruq) {
            break label537;
          }
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).nnz.isShowing())) {
            AppChooserUI.b(AppChooserUI.this).nnz.dismiss();
          }
          localObject = new Intent();
          ((Intent)localObject).setClassName(AppChooserUI.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
          ((Intent)localObject).putExtra("task_name", AppChooserUI.h(AppChooserUI.this).hgO());
          locala = AppChooserUI.h(AppChooserUI.this).hgP();
          paramAnonymousView = AppChooserUI.h(AppChooserUI.this).hgO();
          if (locala.QVQ <= 0) {
            break label460;
          }
          paramAnonymousView = AppChooserUI.this.getResources().getString(locala.QVQ);
          ((Intent)localObject).putExtra("title", paramAnonymousView);
          ((Intent)localObject).putExtra("icon_res_id", locala.QVN);
          if (AppChooserUI.f(AppChooserUI.this) != 1) {
            break label480;
          }
          ((Intent)localObject).putExtra("task_url", "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
          label243:
          ((Intent)localObject).putExtra("fileType", 1);
          ((Intent)localObject).putExtra("package_name", AppChooserUI.h(AppChooserUI.this).getPackageName());
          paramAnonymousView = AppChooserUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          y.hhf();
          y.apH(AppChooserUI.g(AppChooserUI.this));
          if (AppChooserUI.g(AppChooserUI.this) == 0)
          {
            if (!AppChooserUI.i(AppChooserUI.this)) {
              break label501;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          }
          label406:
          if (AppChooserUI.g(AppChooserUI.this) == 1) {
            com.tencent.mm.plugin.report.service.h.IzE.a(12809, new Object[] { Integer.valueOf(5), "" });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109510);
          return;
          label460:
          if (Util.isNullOrNil(locala.QVR)) {
            break;
          }
          paramAnonymousView = locala.QVR;
          break;
          label480:
          ((Intent)localObject).putExtra("task_url", AppChooserUI.h(AppChooserUI.this).bvr());
          break label243;
          label501:
          com.tencent.mm.plugin.report.service.h.IzE.a(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          break label406;
          label537:
          if (paramAnonymousView == AppChooserUI.f.Rus)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            Log.i("MicroMsg.AppChooserUI", "installRecommendApp");
            localObject = com.tencent.mm.plugin.downloader.model.f.cPZ().Ix(l).path;
            Log.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(localObject) });
            r.b(paramAnonymousView.getContext(), (String)localObject, new AppChooserUI.7(paramAnonymousView), false);
          }
        }
      }
    };
    this.ft = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109511);
        AppChooserUI.this.finish();
        AppMethodBeat.o(109511);
      }
    };
    this.Rud = new m()
    {
      public final void Hp(long paramAnonymousLong)
      {
        AppMethodBeat.i(109513);
        Log.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(109513);
      }
      
      public final void Hq(long paramAnonymousLong)
      {
        AppMethodBeat.i(109516);
        Log.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.h.aHG().aHp().i(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).Ruf = AppChooserUI.f.Ruq;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109516);
      }
      
      public final void Hr(long paramAnonymousLong) {}
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109515);
        Log.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.h.aHG().aHp().i(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).Ruf = AppChooserUI.f.Ruq;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109515);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109514);
        Log.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!Util.isNullOrNil(paramAnonymousString)) && (u.agG(paramAnonymousString)))
        {
          com.tencent.mm.kernel.h.aHG().aHp().i(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).Ruf = AppChooserUI.f.Rus;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(109514);
      }
      
      public final void m(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(109512);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        com.tencent.mm.kernel.h.aHG().aHp().i(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        Log.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(109512);
      }
      
      public final void n(long paramAnonymousLong, String paramAnonymousString) {}
    };
    AppMethodBeat.o(109532);
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(109541);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.RtG.queryIntentActivities(paramIntent, 65536);
    hna();
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
              if (this.RtL.bpD(str))
              {
                this.RtO.Rui = localResolveInfo;
                this.RtO.DNo = true;
                if (((paramBoolean) || (!this.RtU)) && ((paramBoolean) || (!this.RtO.DNo))) {
                  break label266;
                }
                localArrayList.add(0, this.RtO);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new c(localResolveInfo, this.RtL.c(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.csG != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.RtO);
      if (!this.RtV) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.RtO.Rui == null))
      {
        this.RtO.Rui = new ResolveInfo();
        this.RtO.Rui.activityInfo = new ActivityInfo();
        this.RtO.Rui.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.Rui != null)
        {
          paramArrayList = paramArrayList.Rui.activityInfo.packageName;
          if ((!Util.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.h.IzE.a(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.RtO);
    }
    AppMethodBeat.o(109541);
    return localArrayList;
  }
  
  private int aqT(int paramInt)
  {
    AppMethodBeat.i(109537);
    if (this.mimeType != null)
    {
      i = this.csG;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(109537);
      return i + paramInt + j;
    }
    int i = this.csG;
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
        localDrawable = e(this.RtG.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = e(this.RtG.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
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
      paramResolveInfo = paramResolveInfo.loadIcon(this.RtG);
      AppMethodBeat.o(109543);
    }
    return paramResolveInfo;
  }
  
  private static Drawable e(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(109542);
    try
    {
      paramResources = com.tencent.mm.cj.b.f(paramResources, paramInt);
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
  
  private int hmZ()
  {
    return 274496 + this.csG;
  }
  
  private void hna()
  {
    AppMethodBeat.i(109539);
    y.a locala = this.RtL.hgP();
    if (!Util.isNullOrNil(locala.QVP))
    {
      this.RtJ = locala.QVP;
      if (locala.QVN > 0) {
        this.RtO.Ruk = getResources().getDrawable(locala.QVN);
      }
      if (locala.QVQ <= 0) {
        break label163;
      }
    }
    label163:
    for (this.RtO.Ruj = getResources().getString(locala.QVQ);; this.RtO.Ruj = locala.QVR)
    {
      this.RtO.Rul = true;
      this.RtO.Nko = this.RtU;
      if (this.RtU) {
        this.RtO.DNo = true;
      }
      if (this.RtV) {
        this.RtO.Rum = true;
      }
      AppMethodBeat.o(109539);
      return;
      if (locala.QVO <= 0) {
        break;
      }
      this.RtJ = getResources().getString(locala.QVO);
      break;
    }
  }
  
  private boolean hnb()
  {
    AppMethodBeat.i(109540);
    Log.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.RtW), Integer.valueOf(this.RtS), Integer.valueOf(this.RtT), Boolean.valueOf(Util.isOverseasUser(this)) });
    if ((this.RtW) && (this.RtS < this.RtT) && (!Util.isOverseasUser(this)) && (ChannelUtil.channelId != 1))
    {
      AppMethodBeat.o(109540);
      return true;
    }
    AppMethodBeat.o(109540);
    return false;
  }
  
  private void n(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109538);
    Intent localIntent = new Intent();
    localIntent.putExtra("selectpkg", paramString);
    localIntent.putExtra("isalways", paramBoolean);
    localIntent.putExtra("transferback", this.RtK);
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
    n(0, null, false);
    AppMethodBeat.o(109536);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109533);
    super.onCreate(paramBundle);
    y.hhf();
    y.apE(this.csG);
    ar.e(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      Log.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      n(0, null, false);
      AppMethodBeat.o(109533);
      return;
    }
    this.RtI = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.csG = ((Intent)localObject).getIntExtra("type", 0);
    this.RtQ = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.RtK = ((Intent)localObject).getBundleExtra("transferback");
    this.RtM = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.RtV = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    boolean bool;
    if (com.tencent.mm.kernel.h.aHB())
    {
      this.RtR = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(aqT(274528), ""));
      if ((TextUtils.isEmpty(this.RtR)) || (!q.u(getContext(), this.RtR)) || ((this.RtM != null) && (!this.RtM.isEmpty()) && (!this.RtM.contains(this.RtR))) || (this.RtQ)) {
        break label1291;
      }
      Intent localIntent = new Intent(this.RtI);
      localIntent.setPackage(this.RtR);
      if (!Util.isIntentAvailable(this, localIntent)) {
        break label424;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.scene), this.RtR, this.mimeType, Boolean.valueOf(this.RtQ) });
      if ((bool) && (this.scene != 6))
      {
        n(-1, this.RtR, true);
        AppMethodBeat.o(109533);
        return;
        Log.e("MicroMsg.AppChooserUI", "acc not ready");
        n(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label424:
        bool = false;
      }
      else
      {
        this.RtG = getPackageManager();
        this.RtH = new a();
        y.hhf();
        this.RtL = y.C(this.csG, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.RtU = this.RtL.jq(getContext());
        this.RtS = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(hmZ(), Integer.valueOf(0))).intValue();
        y.hhf();
        this.RtT = y.apD(this.csG);
        Log.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.RtU), Integer.valueOf(this.RtS) });
        int i;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.RtW = bool;
          if (this.RtS < this.RtT) {
            break label791;
          }
          i = 1;
          label596:
          this.RtP = a(this.RtI, hnb(), this.RtM);
          if ((i == 0) && (!this.RtU)) {
            com.tencent.mm.kernel.h.aHG().aHp().i(hmZ(), Integer.valueOf(this.RtS + 1));
          }
          if (!this.RtU) {
            break label796;
          }
          y.hhf();
          y.apG(this.csG);
          label667:
          if (this.RtP == null) {
            break label814;
          }
        }
        label791:
        label796:
        label814:
        for (int j = this.RtP.size();; j = 0)
        {
          Log.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.RtP == null) || (this.RtP.size() != 1) || ((hnb()) && (!this.RtU))) {
            break label851;
          }
          paramBundle = (c)this.RtP.get(0);
          if (paramBundle == null) {
            break label835;
          }
          if (paramBundle.Rui == null) {
            break label819;
          }
          n(-1, paramBundle.Rui.activityInfo.packageName, false);
          AppMethodBeat.o(109533);
          return;
          bool = false;
          break;
          i = 0;
          break label596;
          if (i != 0) {
            break label667;
          }
          y.hhf();
          y.apF(this.csG);
          break label667;
        }
        label819:
        n(4098, null, false);
        AppMethodBeat.o(109533);
        return;
        label835:
        n(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label851:
        setTitleVisibility(8);
        if ((this.RtP != null) && (!this.RtP.isEmpty()))
        {
          this.RtH.uAd = this.RtP;
          this.RtX = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(aqT(274560), Long.valueOf(0L))).longValue();
          localObject = com.tencent.mm.plugin.downloader.model.f.cPZ().Ix(this.RtX);
          Log.d("MicroMsg.AppChooserUI", "downloadId:" + this.RtX + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (u.agG(((FileDownloadTaskInfo)localObject).path)) && (this.RtH != null))
          {
            this.RtH.Ruf = AppChooserUI.f.Rus;
            this.RtH.notifyDataSetChanged();
          }
          this.RtY = new e(getContext());
          localObject = this.RtY;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.RtY.Ruo = this.RtZ;
            this.RtY.Rub = this.Rub;
            this.RtY.Rup = this.Rua;
            this.RtY.ttU = this.RtH;
            this.RtY.ft = this.ft;
            paramBundle = this.RtY;
            if (paramBundle.Ruo != null) {
              paramBundle.Run.setOnItemClickListener(paramBundle.Ruo);
            }
            if (paramBundle.ttU != null) {
              paramBundle.Run.setAdapter(paramBundle.ttU);
            }
            paramBundle.nnz = com.tencent.mm.ui.base.h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.Run, paramBundle.mContext.getString(a.f.app_use_once), paramBundle.mContext.getString(a.f.app_use_always), paramBundle.Rub, paramBundle.Rup, a.a.green_text_color);
            paramBundle.nnz.setOnDismissListener(paramBundle.ft);
            paramBundle.nnz.show();
            if ((!this.RtV) && (this.RtU) && (i == 0))
            {
              this.RtN = this.RtO;
              this.RtY.Eu(true);
            }
            com.tencent.mm.plugin.downloader.model.f.cPZ();
            c.a(this.Rud);
            AppMethodBeat.o(109533);
            return;
          }
        }
        n(4097, null, false);
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
    com.tencent.mm.plugin.downloader.model.f.cPZ();
    c.b(this.Rud);
    if (this.RtY != null) {
      this.RtY.nnz.dismiss();
    }
    AppMethodBeat.o(109535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109534);
    super.onResume();
    if ((this.RtV) && (this.RtI != null) && (this.RtL.aF(this, this.RtI)))
    {
      Log.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.RtV = false;
      this.RtO.Rum = false;
    }
    this.RtU = this.RtL.jq(getContext());
    this.RtP = a(this.RtI, hnb(), this.RtM);
    if ((this.RtU) && (this.RtN == null) && (!this.RtQ))
    {
      this.RtN = this.RtO;
      this.RtY.Eu(true);
    }
    if (this.RtH != null)
    {
      this.RtH.uAd = this.RtP;
      this.RtH.notifyDataSetChanged();
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
    AppChooserUI.f Ruf;
    List<AppChooserUI.c> uAd;
    
    public a()
    {
      AppMethodBeat.i(109518);
      this.uAd = new ArrayList();
      this.Ruf = AppChooserUI.f.Ruq;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      AppMethodBeat.o(109518);
    }
    
    public final AppChooserUI.c aqU(int paramInt)
    {
      AppMethodBeat.i(109520);
      if (this.uAd == null)
      {
        AppMethodBeat.o(109520);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.uAd.get(paramInt);
      AppMethodBeat.o(109520);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109522);
      if (this.uAd == null)
      {
        AppMethodBeat.o(109522);
        return 0;
      }
      int i = this.uAd.size();
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
      if (aqU(paramInt).Rul)
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
      AppChooserUI.c localc = aqU(paramInt);
      label74:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.getContext());
        if (localc.Rul)
        {
          paramInt = a.d.app_choose_list_recommand_item;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc.Ruk == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc });
          }
          paramViewGroup.bFS.setImageDrawable(localc.Ruk);
          Object localObject2 = localc.Ruj;
          Object localObject1 = localObject2;
          if (AppChooserUI.k(AppChooserUI.this))
          {
            localObject1 = localObject2;
            if (localc.Rui != null)
            {
              localObject1 = localObject2;
              if (localc.Rui.activityInfo.packageName.equals(AppChooserUI.l(AppChooserUI.this)))
              {
                localObject2 = TextUtils.concat(new CharSequence[] { localObject2, AppChooserUI.this.getString(a.f.app_default_app) });
                localObject1 = localObject2;
                if (AppChooserUI.c(AppChooserUI.this) == null)
                {
                  AppChooserUI.a(AppChooserUI.this, localc);
                  localObject1 = localObject2;
                }
              }
            }
          }
          paramViewGroup.Dah.setText((CharSequence)localObject1);
          if ((localc == null) || ((localc.Rul) && (!localc.Nko) && ((!localc.Rul) || (!localc.DNo) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc.Rum)) {
            break label558;
          }
          paramViewGroup.Rug.setVisibility(8);
          paramViewGroup.Ruh.setVisibility(0);
          localObject1 = paramViewGroup.Ruh;
          localObject2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localObject2 instanceof AppChooserUI.c)) {
            break label552;
          }
          localObject2 = (AppChooserUI.c)localObject2;
          if (((((AppChooserUI.c)localObject2).Rui == null) || (localc.Rui == null) || (!((AppChooserUI.c)localObject2).Rui.activityInfo.packageName.equals(localc.Rui.activityInfo.packageName))) && ((!((AppChooserUI.c)localObject2).Rul) || (!localc.Rul))) {
            break label552;
          }
          bool = true;
          label415:
          ((RadioButton)localObject1).setChecked(bool);
          label422:
          if (!localc.Rul) {
            break label744;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label724;
          }
          paramViewGroup.zQG.setText(a.f.qq_browser_desc_for_wb);
          label451:
          localObject1 = paramViewGroup.zQG;
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
          paramViewGroup.Ruh.setChecked(true);
        }
        AppMethodBeat.o(109519);
        return paramView;
        paramInt = a.d.app_choose_list_item;
        break;
        paramViewGroup = (AppChooserUI.b)paramView.getTag();
        break label74;
        label552:
        bool = false;
        break label415;
        label558:
        paramViewGroup.Rug.setVisibility(0);
        paramViewGroup.Ruh.setVisibility(8);
        paramViewGroup.Rug.setOnClickListener(AppChooserUI.m(AppChooserUI.this));
        if (this.Ruf == AppChooserUI.f.Ruq)
        {
          if (localc.Rum) {
            paramViewGroup.Rug.setText(a.f.app_need_to_update);
          }
          for (;;)
          {
            paramViewGroup.Rug.setEnabled(true);
            break;
            paramViewGroup.Rug.setText(a.f.app_download);
          }
        }
        if (this.Ruf == AppChooserUI.f.Rur)
        {
          paramViewGroup.Rug.setText(a.f.app_downloading);
          paramViewGroup.Rug.setEnabled(false);
          break label422;
        }
        if (this.Ruf != AppChooserUI.f.Rus) {
          break label422;
        }
        if (localc.Rum) {
          paramViewGroup.Rug.setText(a.f.app_to_update);
        }
        for (;;)
        {
          paramViewGroup.Rug.setEnabled(true);
          break;
          paramViewGroup.Rug.setText(a.f.app_to_install);
        }
        label724:
        paramViewGroup.zQG.setText(Util.nullAsNil(AppChooserUI.n(AppChooserUI.this)));
        break label451;
        label744:
        paramViewGroup.zQG.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    TextView Dah;
    TextView Rug;
    RadioButton Ruh;
    ImageView bFS;
    TextView zQG;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109524);
      this.bFS = ((ImageView)paramView.findViewById(a.c.app_icon));
      this.Dah = ((TextView)paramView.findViewById(a.c.app_name));
      this.zQG = ((TextView)paramView.findViewById(a.c.app_desc));
      this.Rug = ((TextView)paramView.findViewById(a.c.app_status));
      this.Ruh = ((RadioButton)paramView.findViewById(a.c.app_radio));
      AppMethodBeat.o(109524);
    }
  }
  
  final class c
  {
    boolean DNo;
    boolean Nko;
    ResolveInfo Rui;
    CharSequence Ruj;
    Drawable Ruk;
    boolean Rul;
    boolean Rum;
    
    public c() {}
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      this.Rui = paramResolveInfo;
      this.Ruj = paramCharSequence;
      this.Rul = false;
      this.Nko = true;
      this.Rum = false;
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d() {}
  }
  
  final class e
  {
    DialogInterface.OnClickListener Rub;
    ListViewInScrollView Run;
    AdapterView.OnItemClickListener Ruo;
    DialogInterface.OnClickListener Rup;
    DialogInterface.OnDismissListener ft;
    Context mContext;
    String mTitle;
    public d nnz;
    BaseAdapter ttU;
    
    public e(Context paramContext)
    {
      AppMethodBeat.i(109527);
      this.mContext = paramContext;
      this.Run = ((ListViewInScrollView)View.inflate(this.mContext, a.d.app_choose_layout, null));
      AppMethodBeat.o(109527);
    }
    
    public final void Eu(boolean paramBoolean)
    {
      AppMethodBeat.i(109528);
      if (this.nnz != null)
      {
        if (!paramBoolean)
        {
          this.nnz.a(a.f.app_use_once, null);
          this.nnz.b(a.f.app_use_always, null);
          AppMethodBeat.o(109528);
          return;
        }
        this.nnz.a(a.f.app_use_once, this.Rub);
        this.nnz.b(a.f.app_use_always, this.Rup);
      }
      AppMethodBeat.o(109528);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */