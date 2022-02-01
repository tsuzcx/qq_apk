package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.ce.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.d.a.a;
import com.tencent.mm.plugin.d.a.c;
import com.tencent.mm.plugin.d.a.d;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.model.aa;
import com.tencent.mm.pluginsdk.model.aa.a;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.pluginsdk.model.z;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private a Yqa;
  private Intent Yqb;
  private String Yqc;
  private Bundle Yqd;
  private z Yqe;
  private ArrayList<String> Yqf;
  private c Yqg;
  private c Yqh;
  private List<c> Yqi;
  private boolean Yqj;
  private String Yqk;
  private int Yql;
  private int Yqm;
  private boolean Yqn;
  private boolean Yqo;
  private boolean Yqp;
  private long Yqq;
  private e Yqr;
  private AdapterView.OnItemClickListener Yqs;
  private DialogInterface.OnClickListener Yqt;
  private DialogInterface.OnClickListener Yqu;
  private View.OnClickListener Yqv;
  private m Yqw;
  private int ekA;
  private DialogInterface.OnDismissListener mOnDismissListener;
  private PackageManager mPackageManager;
  private String mimeType;
  private int scene;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(109532);
    this.Yqb = null;
    this.Yqc = null;
    this.Yqd = null;
    this.Yqe = null;
    this.Yqf = null;
    this.scene = 0;
    this.Yqg = null;
    this.Yqh = new c();
    this.Yqj = false;
    this.mimeType = null;
    this.Yqn = false;
    this.Yqo = false;
    this.Yqp = false;
    this.Yqs = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(109507);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.a(AppChooserUI.this).axa(paramAnonymousInt));
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).qkG.isShowing()))
          {
            if ((AppChooserUI.c(AppChooserUI.this) == null) || (!AppChooserUI.c(AppChooserUI.this).YqE) || ((AppChooserUI.c(AppChooserUI.this).JEC) && ((AppChooserUI.c(AppChooserUI.this).TXb) || (AppChooserUI.d(AppChooserUI.this) >= AppChooserUI.e(AppChooserUI.this))))) {
              break label325;
            }
            AppChooserUI.b(AppChooserUI.this).Kg(false);
          }
        }
        for (;;)
        {
          if (((AppChooserUI.f(AppChooserUI.this) == 6) || (AppChooserUI.g(AppChooserUI.this) == 2)) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).YqB != null))
          {
            AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).YqB.activityInfo.packageName, false);
            com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(4), AppChooserUI.c(AppChooserUI.this).YqB.activityInfo.packageName });
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(109507);
          return;
          label325:
          AppChooserUI.b(AppChooserUI.this).Kg(true);
        }
      }
    };
    this.Yqt = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109508);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).YqB != null))
        {
          com.tencent.mm.kernel.h.baE().ban().B(AppChooserUI.a(AppChooserUI.this, 274528), AppChooserUI.c(AppChooserUI.this).YqB.activityInfo.packageName);
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).YqB.activityInfo.packageName, true);
        }
        AppMethodBeat.o(109508);
      }
    };
    this.Yqu = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(109509);
        if ((AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).YqB != null)) {
          AppChooserUI.a(AppChooserUI.this, AppChooserUI.c(AppChooserUI.this).YqB.activityInfo.packageName, false);
        }
        AppMethodBeat.o(109509);
      }
    };
    this.Yqv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109510);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        Log.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          paramAnonymousView = AppChooserUI.a(AppChooserUI.this).Yqy;
          if (paramAnonymousView != AppChooserUI.f.YqJ) {
            break label605;
          }
          if ((AppChooserUI.b(AppChooserUI.this) != null) && (AppChooserUI.b(AppChooserUI.this).qkG.isShowing())) {
            AppChooserUI.b(AppChooserUI.this).qkG.dismiss();
          }
          if (Util.isNullOrNil(AppChooserUI.h(AppChooserUI.this).iHM())) {
            break label288;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", AppChooserUI.h(AppChooserUI.this).iHM());
          com.tencent.mm.br.c.b(AppChooserUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          aa.iIe();
          aa.avM(AppChooserUI.g(AppChooserUI.this));
          if (AppChooserUI.g(AppChooserUI.this) == 0)
          {
            if (!AppChooserUI.i(AppChooserUI.this)) {
              break label569;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(11168, new Object[] { Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          }
          label234:
          if (AppChooserUI.g(AppChooserUI.this) == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.b(12809, new Object[] { Integer.valueOf(5), "" });
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109510);
          return;
          label288:
          localObject = new Intent();
          ((Intent)localObject).setClassName(AppChooserUI.this.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI");
          ((Intent)localObject).putExtra("task_name", AppChooserUI.h(AppChooserUI.this).iHN());
          ((Intent)localObject).putExtra("task_download_type", 1);
          aa.a locala = AppChooserUI.h(AppChooserUI.this).iHO();
          paramAnonymousView = AppChooserUI.h(AppChooserUI.this).iHN();
          if (locala.XRN > 0)
          {
            paramAnonymousView = AppChooserUI.this.getResources().getString(locala.XRN);
            label386:
            ((Intent)localObject).putExtra("title", paramAnonymousView);
            ((Intent)localObject).putExtra("icon_res_id", locala.XRK);
            if (AppChooserUI.f(AppChooserUI.this) != 1) {
              break label548;
            }
            ((Intent)localObject).putExtra("task_url", "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375");
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("fileType", 1);
            ((Intent)localObject).putExtra("package_name", AppChooserUI.h(AppChooserUI.this).getPackageName());
            paramAnonymousView = AppChooserUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/pluginsdk/ui/tools/AppChooserUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            if (Util.isNullOrNil(locala.XRO)) {
              break label386;
            }
            paramAnonymousView = locala.XRO;
            break label386;
            label548:
            ((Intent)localObject).putExtra("task_url", AppChooserUI.h(AppChooserUI.this).bTD());
          }
          label569:
          com.tencent.mm.plugin.report.service.h.OAn.b(11168, new Object[] { Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(AppChooserUI.this)) });
          break label234;
          label605:
          if (paramAnonymousView == AppChooserUI.f.YqL)
          {
            paramAnonymousView = AppChooserUI.this;
            long l = AppChooserUI.j(AppChooserUI.this);
            Log.i("MicroMsg.AppChooserUI", "installRecommendApp");
            localObject = com.tencent.mm.plugin.downloader.model.f.duv().kS(l).path;
            Log.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[] { String.valueOf(localObject) });
            v.b(paramAnonymousView.getContext(), (String)localObject, new AppChooserUI.7(paramAnonymousView), false);
          }
        }
      }
    };
    this.mOnDismissListener = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(109511);
        AppChooserUI.this.finish();
        AppMethodBeat.o(109511);
      }
    };
    this.Yqw = new m()
    {
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3) {}
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109514);
        Log.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
        if ((!Util.isNullOrNil(paramAnonymousString)) && (y.ZC(paramAnonymousString)))
        {
          com.tencent.mm.kernel.h.baE().ban().B(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
          if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
          {
            AppChooserUI.a(AppChooserUI.this).Yqy = AppChooserUI.f.YqL;
            AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
          }
        }
        AppMethodBeat.o(109514);
      }
      
      public final void c(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(109515);
        Log.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.h.baE().ban().B(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).Yqy = AppChooserUI.f.YqJ;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109515);
      }
      
      public final void jF(long paramAnonymousLong)
      {
        AppMethodBeat.i(109513);
        Log.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        AppMethodBeat.o(109513);
      }
      
      public final void jG(long paramAnonymousLong)
      {
        AppMethodBeat.i(109516);
        Log.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
        com.tencent.mm.kernel.h.baE().ban().B(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
        if (AppChooserUI.a(AppChooserUI.this) != null)
        {
          AppChooserUI.a(AppChooserUI.this).Yqy = AppChooserUI.f.YqJ;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(109516);
      }
      
      public final void jH(long paramAnonymousLong) {}
      
      public final void v(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(109512);
        AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
        com.tencent.mm.kernel.h.baE().ban().B(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        Log.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
        AppMethodBeat.o(109512);
      }
      
      public final void w(long paramAnonymousLong, String paramAnonymousString) {}
    };
    AppMethodBeat.o(109532);
  }
  
  private List<c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(109541);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.mPackageManager.queryIntentActivities(paramIntent, 65536);
    iNQ();
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
              if (this.Yqe.bpt(str))
              {
                this.Yqh.YqB = localResolveInfo;
                this.Yqh.JEC = true;
                if (((paramBoolean) || (!this.Yqn)) && ((paramBoolean) || (!this.Yqh.JEC))) {
                  break label266;
                }
                localArrayList.add(0, this.Yqh);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new c(localResolveInfo, this.Yqe.c(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.ekA != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.Yqh);
      if (!this.Yqo) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.Yqh.YqB == null))
      {
        this.Yqh.YqB = new ResolveInfo();
        this.Yqh.YqB.activityInfo = new ActivityInfo();
        this.Yqh.YqB.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (c)localArrayList.get(i);
        if (paramArrayList.YqB != null)
        {
          paramArrayList = paramArrayList.YqB.activityInfo.packageName;
          if ((!Util.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.h.OAn.b(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.Yqh);
    }
    AppMethodBeat.o(109541);
    return localArrayList;
  }
  
  private int awZ(int paramInt)
  {
    AppMethodBeat.i(109537);
    if (this.mimeType != null)
    {
      i = this.ekA;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(109537);
      return i + paramInt + j;
    }
    int i = this.ekA;
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
        localDrawable = f(this.mPackageManager.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          AppMethodBeat.o(109543);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = f(this.mPackageManager.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
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
      paramResolveInfo = paramResolveInfo.loadIcon(this.mPackageManager);
      AppMethodBeat.o(109543);
    }
    return paramResolveInfo;
  }
  
  private static Drawable f(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(109542);
    try
    {
      paramResources = d.g(paramResources, paramInt);
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
  
  private int iNP()
  {
    return 274496 + this.ekA;
  }
  
  private void iNQ()
  {
    AppMethodBeat.i(109539);
    aa.a locala = this.Yqe.iHO();
    if (!Util.isNullOrNil(locala.XRM))
    {
      this.Yqc = locala.XRM;
      if (locala.XRK > 0) {
        this.Yqh.YqD = getResources().getDrawable(locala.XRK);
      }
      if (locala.XRN <= 0) {
        break label163;
      }
    }
    label163:
    for (this.Yqh.YqC = getResources().getString(locala.XRN);; this.Yqh.YqC = locala.XRO)
    {
      this.Yqh.YqE = true;
      this.Yqh.TXb = this.Yqn;
      if (this.Yqn) {
        this.Yqh.JEC = true;
      }
      if (this.Yqo) {
        this.Yqh.YqF = true;
      }
      AppMethodBeat.o(109539);
      return;
      if (locala.XRL <= 0) {
        break;
      }
      this.Yqc = getResources().getString(locala.XRL);
      break;
    }
  }
  
  private boolean iNR()
  {
    AppMethodBeat.i(109540);
    Log.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.Yqp), Integer.valueOf(this.Yql), Integer.valueOf(this.Yqm), Boolean.valueOf(Util.isOverseasUser(this)) });
    if ((this.Yqp) && (this.Yql < this.Yqm) && (!Util.isOverseasUser(this)) && (ChannelUtil.channelId != 1))
    {
      AppMethodBeat.o(109540);
      return true;
    }
    AppMethodBeat.o(109540);
    return false;
  }
  
  private void o(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109538);
    Intent localIntent = new Intent();
    localIntent.putExtra("selectpkg", paramString);
    localIntent.putExtra("isalways", paramBoolean);
    localIntent.putExtra("transferback", this.Yqd);
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
    o(0, null, false);
    AppMethodBeat.o(109536);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109533);
    super.onCreate(paramBundle);
    aa.iIe();
    aa.avJ(this.ekA);
    aw.g(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      Log.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      o(0, null, false);
      AppMethodBeat.o(109533);
      return;
    }
    this.Yqb = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.ekA = ((Intent)localObject).getIntExtra("type", 0);
    this.Yqj = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.Yqd = ((Intent)localObject).getBundleExtra("transferback");
    this.Yqf = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.Yqo = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    boolean bool;
    if (com.tencent.mm.kernel.h.baz())
    {
      this.Yqk = ((String)com.tencent.mm.kernel.h.baE().ban().d(awZ(274528), ""));
      if ((TextUtils.isEmpty(this.Yqk)) || (!u.y(getContext(), this.Yqk)) || ((this.Yqf != null) && (!this.Yqf.isEmpty()) && (!this.Yqf.contains(this.Yqk))) || (this.Yqj)) {
        break label1291;
      }
      Intent localIntent = new Intent(this.Yqb);
      localIntent.setPackage(this.Yqk);
      if (!Util.isIntentAvailable(this, localIntent)) {
        break label424;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppChooserUI", "isAlwaysUseOption %b, scene %d, mDefaultAppPackageName %s, mimeType %s, isOpenWay %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.scene), this.Yqk, this.mimeType, Boolean.valueOf(this.Yqj) });
      if ((bool) && (this.scene != 6))
      {
        o(-1, this.Yqk, true);
        AppMethodBeat.o(109533);
        return;
        Log.e("MicroMsg.AppChooserUI", "acc not ready");
        o(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label424:
        bool = false;
      }
      else
      {
        this.mPackageManager = getPackageManager();
        this.Yqa = new a();
        aa.iIe();
        this.Yqe = aa.F(this.ekA, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.Yqn = this.Yqe.ln(getContext());
        this.Yql = ((Integer)com.tencent.mm.kernel.h.baE().ban().d(iNP(), Integer.valueOf(0))).intValue();
        aa.iIe();
        this.Yqm = aa.avI(this.ekA);
        Log.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.Yqn), Integer.valueOf(this.Yql) });
        int i;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.Yqp = bool;
          if (this.Yql < this.Yqm) {
            break label791;
          }
          i = 1;
          label596:
          this.Yqi = a(this.Yqb, iNR(), this.Yqf);
          if ((i == 0) && (!this.Yqn)) {
            com.tencent.mm.kernel.h.baE().ban().B(iNP(), Integer.valueOf(this.Yql + 1));
          }
          if (!this.Yqn) {
            break label796;
          }
          aa.iIe();
          aa.avL(this.ekA);
          label667:
          if (this.Yqi == null) {
            break label814;
          }
        }
        label791:
        label796:
        label814:
        for (int j = this.Yqi.size();; j = 0)
        {
          Log.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.Yqi == null) || (this.Yqi.size() != 1) || ((iNR()) && (!this.Yqn))) {
            break label851;
          }
          paramBundle = (c)this.Yqi.get(0);
          if (paramBundle == null) {
            break label835;
          }
          if (paramBundle.YqB == null) {
            break label819;
          }
          o(-1, paramBundle.YqB.activityInfo.packageName, false);
          AppMethodBeat.o(109533);
          return;
          bool = false;
          break;
          i = 0;
          break label596;
          if (i != 0) {
            break label667;
          }
          aa.iIe();
          aa.avK(this.ekA);
          break label667;
        }
        label819:
        o(4098, null, false);
        AppMethodBeat.o(109533);
        return;
        label835:
        o(4097, null, false);
        AppMethodBeat.o(109533);
        return;
        label851:
        setTitleVisibility(8);
        if ((this.Yqi != null) && (!this.Yqi.isEmpty()))
        {
          this.Yqa.xGG = this.Yqi;
          this.Yqq = ((Long)com.tencent.mm.kernel.h.baE().ban().d(awZ(274560), Long.valueOf(0L))).longValue();
          localObject = com.tencent.mm.plugin.downloader.model.f.duv().kS(this.Yqq);
          Log.d("MicroMsg.AppChooserUI", "downloadId:" + this.Yqq + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (y.ZC(((FileDownloadTaskInfo)localObject).path)) && (this.Yqa != null))
          {
            this.Yqa.Yqy = f.YqL;
            this.Yqa.notifyDataSetChanged();
          }
          this.Yqr = new e(getContext());
          localObject = this.Yqr;
          if (paramBundle != null) {}
          for (((e)localObject).mTitle = paramBundle.toString();; ((e)localObject).mTitle = null)
          {
            this.Yqr.YqH = this.Yqs;
            this.Yqr.Yqu = this.Yqu;
            this.Yqr.YqI = this.Yqt;
            this.Yqr.wyr = this.Yqa;
            this.Yqr.mOnDismissListener = this.mOnDismissListener;
            paramBundle = this.Yqr;
            if (paramBundle.YqH != null) {
              paramBundle.YqG.setOnItemClickListener(paramBundle.YqH);
            }
            if (paramBundle.wyr != null) {
              paramBundle.YqG.setAdapter(paramBundle.wyr);
            }
            paramBundle.qkG = k.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.YqG, paramBundle.mContext.getString(a.f.app_use_once), paramBundle.mContext.getString(a.f.app_use_always), paramBundle.Yqu, paramBundle.YqI, a.a.green_text_color);
            paramBundle.qkG.setOnDismissListener(paramBundle.mOnDismissListener);
            paramBundle.qkG.show();
            if ((!this.Yqo) && (this.Yqn) && (i == 0))
            {
              this.Yqg = this.Yqh;
              this.Yqr.Kg(true);
            }
            com.tencent.mm.plugin.downloader.model.f.duv();
            com.tencent.mm.plugin.downloader.model.c.a(this.Yqw);
            AppMethodBeat.o(109533);
            return;
          }
        }
        o(4097, null, false);
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
    com.tencent.mm.plugin.downloader.model.f.duv();
    com.tencent.mm.plugin.downloader.model.c.b(this.Yqw);
    if (this.Yqr != null) {
      this.Yqr.qkG.dismiss();
    }
    AppMethodBeat.o(109535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109534);
    super.onResume();
    if ((this.Yqo) && (this.Yqb != null) && (this.Yqe.aO(this, this.Yqb)))
    {
      Log.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.Yqo = false;
      this.Yqh.YqF = false;
    }
    this.Yqn = this.Yqe.ln(getContext());
    this.Yqi = a(this.Yqb, iNR(), this.Yqf);
    if ((this.Yqn) && (this.Yqg == null) && (!this.Yqj))
    {
      this.Yqg = this.Yqh;
      this.Yqr.Kg(true);
    }
    if (this.Yqa != null)
    {
      this.Yqa.xGG = this.Yqi;
      this.Yqa.notifyDataSetChanged();
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
    AppChooserUI.f Yqy;
    List<AppChooserUI.c> xGG;
    
    public a()
    {
      AppMethodBeat.i(109518);
      this.xGG = new ArrayList();
      this.Yqy = AppChooserUI.f.YqJ;
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
      AppMethodBeat.o(109518);
    }
    
    public final AppChooserUI.c axa(int paramInt)
    {
      AppMethodBeat.i(109520);
      if (this.xGG == null)
      {
        AppMethodBeat.o(109520);
        return null;
      }
      AppChooserUI.c localc = (AppChooserUI.c)this.xGG.get(paramInt);
      AppMethodBeat.o(109520);
      return localc;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(109522);
      if (this.xGG == null)
      {
        AppMethodBeat.o(109522);
        return 0;
      }
      int i = this.xGG.size();
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
      if (axa(paramInt).YqE)
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
      AppChooserUI.c localc = axa(paramInt);
      label74:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.getContext());
        if (localc.YqE)
        {
          paramInt = a.d.app_choose_list_recommand_item;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc.YqD == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc });
          }
          paramViewGroup.dyS.setImageDrawable(localc.YqD);
          Object localObject2 = localc.YqC;
          Object localObject1 = localObject2;
          if (AppChooserUI.k(AppChooserUI.this))
          {
            localObject1 = localObject2;
            if (localc.YqB != null)
            {
              localObject1 = localObject2;
              if (localc.YqB.activityInfo.packageName.equals(AppChooserUI.l(AppChooserUI.this)))
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
          paramViewGroup.ukP.setText((CharSequence)localObject1);
          if ((localc == null) || ((localc.YqE) && (!localc.TXb) && ((!localc.YqE) || (!localc.JEC) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc.YqF)) {
            break label558;
          }
          paramViewGroup.Yqz.setVisibility(8);
          paramViewGroup.YqA.setVisibility(0);
          localObject1 = paramViewGroup.YqA;
          localObject2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localObject2 instanceof AppChooserUI.c)) {
            break label552;
          }
          localObject2 = (AppChooserUI.c)localObject2;
          if (((((AppChooserUI.c)localObject2).YqB == null) || (localc.YqB == null) || (!((AppChooserUI.c)localObject2).YqB.activityInfo.packageName.equals(localc.YqB.activityInfo.packageName))) && ((!((AppChooserUI.c)localObject2).YqE) || (!localc.YqE))) {
            break label552;
          }
          bool = true;
          label415:
          ((RadioButton)localObject1).setChecked(bool);
          label422:
          if (!localc.YqE) {
            break label744;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label724;
          }
          paramViewGroup.FcR.setText(a.f.qq_browser_desc_for_wb);
          label451:
          localObject1 = paramViewGroup.FcR;
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
          paramViewGroup.YqA.setChecked(true);
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
        paramViewGroup.Yqz.setVisibility(0);
        paramViewGroup.YqA.setVisibility(8);
        paramViewGroup.Yqz.setOnClickListener(AppChooserUI.m(AppChooserUI.this));
        if (this.Yqy == AppChooserUI.f.YqJ)
        {
          if (localc.YqF) {
            paramViewGroup.Yqz.setText(a.f.app_need_to_update);
          }
          for (;;)
          {
            paramViewGroup.Yqz.setEnabled(true);
            break;
            paramViewGroup.Yqz.setText(a.f.app_download);
          }
        }
        if (this.Yqy == AppChooserUI.f.YqK)
        {
          paramViewGroup.Yqz.setText(a.f.app_downloading);
          paramViewGroup.Yqz.setEnabled(false);
          break label422;
        }
        if (this.Yqy != AppChooserUI.f.YqL) {
          break label422;
        }
        if (localc.YqF) {
          paramViewGroup.Yqz.setText(a.f.app_to_update);
        }
        for (;;)
        {
          paramViewGroup.Yqz.setEnabled(true);
          break;
          paramViewGroup.Yqz.setText(a.f.app_to_install);
        }
        label724:
        paramViewGroup.FcR.setText(Util.nullAsNil(AppChooserUI.n(AppChooserUI.this)));
        break label451;
        label744:
        paramViewGroup.FcR.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class b
  {
    TextView FcR;
    RadioButton YqA;
    TextView Yqz;
    ImageView dyS;
    TextView ukP;
    
    public b(View paramView)
    {
      AppMethodBeat.i(109524);
      this.dyS = ((ImageView)paramView.findViewById(a.c.app_icon));
      this.ukP = ((TextView)paramView.findViewById(a.c.app_name));
      this.FcR = ((TextView)paramView.findViewById(a.c.app_desc));
      this.Yqz = ((TextView)paramView.findViewById(a.c.app_status));
      this.YqA = ((RadioButton)paramView.findViewById(a.c.app_radio));
      AppMethodBeat.o(109524);
    }
  }
  
  final class c
  {
    boolean JEC;
    boolean TXb;
    ResolveInfo YqB;
    CharSequence YqC;
    Drawable YqD;
    boolean YqE;
    boolean YqF;
    
    public c() {}
    
    public c(ResolveInfo paramResolveInfo, CharSequence paramCharSequence)
    {
      this.YqB = paramResolveInfo;
      this.YqC = paramCharSequence;
      this.YqE = false;
      this.TXb = true;
      this.YqF = false;
    }
  }
  
  final class d
    extends AsyncTask<AppChooserUI.c, Void, AppChooserUI.c>
  {
    d() {}
  }
  
  final class e
  {
    ListViewInScrollView YqG;
    AdapterView.OnItemClickListener YqH;
    DialogInterface.OnClickListener YqI;
    DialogInterface.OnClickListener Yqu;
    Context mContext;
    DialogInterface.OnDismissListener mOnDismissListener;
    String mTitle;
    public e qkG;
    BaseAdapter wyr;
    
    public e(Context paramContext)
    {
      AppMethodBeat.i(109527);
      this.mContext = paramContext;
      this.YqG = ((ListViewInScrollView)View.inflate(this.mContext, a.d.app_choose_layout, null));
      AppMethodBeat.o(109527);
    }
    
    public final void Kg(boolean paramBoolean)
    {
      AppMethodBeat.i(109528);
      if (this.qkG != null)
      {
        if (!paramBoolean)
        {
          this.qkG.a(a.f.app_use_once, null);
          this.qkG.b(a.f.app_use_always, null);
          AppMethodBeat.o(109528);
          return;
        }
        this.qkG.a(a.f.app_use_once, this.Yqu);
        this.qkG.b(a.f.app_use_always, this.YqI);
      }
      AppMethodBeat.o(109528);
    }
  }
  
  public static enum f
  {
    static
    {
      AppMethodBeat.i(109531);
      YqJ = new f("UNINSTALL", 0);
      YqK = new f("DOWNLOADING", 1);
      YqL = new f("DOWNLOADED", 2);
      YqM = new f[] { YqJ, YqK, YqL };
      AppMethodBeat.o(109531);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */