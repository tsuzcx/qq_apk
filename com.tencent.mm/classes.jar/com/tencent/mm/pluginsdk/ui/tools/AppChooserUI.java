package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Context;
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
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private DialogInterface.OnDismissListener NX;
  private PackageManager bmC;
  private String mimeType;
  private int scene;
  private int wdA;
  private boolean wdB;
  private boolean wdC;
  private boolean wdD;
  private long wdE;
  private AppChooserUI.e wdF;
  private AdapterView.OnItemClickListener wdG;
  private DialogInterface.OnClickListener wdH;
  private DialogInterface.OnClickListener wdI;
  private View.OnClickListener wdJ;
  private m wdK;
  private AppChooserUI.a wdn;
  private Intent wdo;
  private int wdp;
  private String wdq;
  private Bundle wdr;
  private q wds;
  private ArrayList<String> wdt;
  private AppChooserUI.c wdu;
  private AppChooserUI.c wdv;
  private List<AppChooserUI.c> wdw;
  private boolean wdx;
  private String wdy;
  private int wdz;
  
  public AppChooserUI()
  {
    AppMethodBeat.i(125879);
    this.wdo = null;
    this.wdq = null;
    this.wdr = null;
    this.wds = null;
    this.wdt = null;
    this.scene = 0;
    this.wdu = null;
    this.wdv = new AppChooserUI.c(this);
    this.wdx = false;
    this.mimeType = null;
    this.wdB = false;
    this.wdC = false;
    this.wdD = false;
    this.wdG = new AppChooserUI.1(this);
    this.wdH = new AppChooserUI.2(this);
    this.wdI = new AppChooserUI.3(this);
    this.wdJ = new AppChooserUI.4(this);
    this.NX = new AppChooserUI.5(this);
    this.wdK = new AppChooserUI.6(this);
    AppMethodBeat.o(125879);
  }
  
  private int Mt(int paramInt)
  {
    AppMethodBeat.i(125884);
    if (this.mimeType != null)
    {
      i = this.wdp;
      int j = this.mimeType.hashCode();
      AppMethodBeat.o(125884);
      return i + paramInt + j;
    }
    int i = this.wdp;
    AppMethodBeat.o(125884);
    return i + paramInt;
  }
  
  private List<AppChooserUI.c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(125888);
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.bmC.queryIntentActivities(paramIntent, 65536);
    dps();
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
          ab.i("MicroMsg.AppChooserUI", "cpan name:%s", new Object[] { ((ResolveInfo)paramIntent.get(j)).activityInfo.name });
          ResolveInfo localResolveInfo = (ResolveInfo)paramIntent.get(j);
          if (localResolveInfo != null)
          {
            String str = localResolveInfo.activityInfo.packageName;
            if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramArrayList.contains(str))) {
              if (this.wds.alg(str))
              {
                this.wdv.wdP = localResolveInfo;
                this.wdv.nKJ = true;
                if (((paramBoolean) || (!this.wdB)) && ((paramBoolean) || (!this.wdv.nKJ))) {
                  break label266;
                }
                localArrayList.add(0, this.wdv);
                i = 1;
              }
            }
          }
          label266:
          for (;;)
          {
            j += 1;
            break;
            localArrayList.add(new AppChooserUI.c(this, localResolveInfo, this.wds.a(getContext(), localResolveInfo)));
          }
        }
      }
    }
    if ((paramBoolean) && (k == 0))
    {
      if ((this.wdp != 0) || (this.mimeType == null)) {
        break label537;
      }
      localArrayList.add(0, this.wdv);
      if (!this.wdC) {
        break label504;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if (((this.scene == 4) || (this.scene == 8)) && (this.wdv.wdP == null))
      {
        this.wdv.wdP = new ResolveInfo();
        this.wdv.wdP.activityInfo = new ActivityInfo();
        this.wdv.wdP.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (AppChooserUI.c)localArrayList.get(i);
        if (paramArrayList.wdP != null)
        {
          paramArrayList = paramArrayList.wdP.activityInfo.packageName;
          if ((!bo.isNullOrNil(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label504:
      com.tencent.mm.plugin.report.service.h.qsU.e(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label537:
      localArrayList.add(0, this.wdv);
    }
    AppMethodBeat.o(125888);
    return localArrayList;
  }
  
  private Drawable c(ResolveInfo paramResolveInfo)
  {
    AppMethodBeat.i(125890);
    try
    {
      Drawable localDrawable;
      if ((paramResolveInfo.resolvePackageName != null) && (paramResolveInfo.icon != 0))
      {
        localDrawable = d(this.bmC.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null)
        {
          AppMethodBeat.o(125890);
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = d(this.bmC.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
        if (localDrawable != null)
        {
          ab.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(125890);
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      ab.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
      paramResolveInfo = paramResolveInfo.loadIcon(this.bmC);
      AppMethodBeat.o(125890);
    }
    return paramResolveInfo;
  }
  
  private static Drawable d(Resources paramResources, int paramInt)
  {
    AppMethodBeat.i(125889);
    try
    {
      paramResources = b.e(paramResources, paramInt);
      AppMethodBeat.o(125889);
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
  
  private void dps()
  {
    AppMethodBeat.i(125886);
    r.a locala = this.wds.dkY();
    if (!bo.isNullOrNil(locala.vKK))
    {
      this.wdq = locala.vKK;
      if (locala.vKI > 0) {
        this.wdv.wdR = getResources().getDrawable(locala.vKI);
      }
      if (locala.vKL <= 0) {
        break label163;
      }
    }
    label163:
    for (this.wdv.wdQ = getResources().getString(locala.vKL);; this.wdv.wdQ = locala.vKM)
    {
      this.wdv.wdS = true;
      this.wdv.tqS = this.wdB;
      if (this.wdB) {
        this.wdv.nKJ = true;
      }
      if (this.wdC) {
        this.wdv.wdT = true;
      }
      AppMethodBeat.o(125886);
      return;
      if (locala.vKJ <= 0) {
        break;
      }
      this.wdq = getResources().getString(locala.vKJ);
      break;
    }
  }
  
  private boolean dpt()
  {
    AppMethodBeat.i(125887);
    ab.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.wdD), Integer.valueOf(this.wdz), Integer.valueOf(this.wdA), Boolean.valueOf(bo.hl(this)) });
    if ((this.wdD) && (this.wdz < this.wdA) && (!bo.hl(this)) && (com.tencent.mm.sdk.platformtools.g.bWu != 1))
    {
      AppMethodBeat.o(125887);
      return true;
    }
    AppMethodBeat.o(125887);
    return false;
  }
  
  private void i(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125885);
    Intent localIntent = new Intent();
    localIntent.putExtra("selectpkg", paramString);
    localIntent.putExtra("isalways", paramBoolean);
    localIntent.putExtra("transferback", this.wdr);
    setResult(paramInt, localIntent);
    finish();
    AppMethodBeat.o(125885);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(125883);
    super.onBackPressed();
    i(0, null, false);
    AppMethodBeat.o(125883);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125880);
    super.onCreate(paramBundle);
    r.dlm();
    r.Lw(this.wdp);
    af.a(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      ab.w("ChooseActivity", "Target is not an intent: ".concat(String.valueOf(paramBundle)));
      i(0, null, false);
      AppMethodBeat.o(125880);
      return;
    }
    this.wdo = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.wdp = ((Intent)localObject).getIntExtra("type", 0);
    this.wdx = ((Intent)localObject).getBooleanExtra("openWay", false);
    this.wdr = ((Intent)localObject).getBundleExtra("transferback");
    this.wdt = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.wdC = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    int i;
    if (com.tencent.mm.kernel.g.RG())
    {
      this.wdy = ((String)com.tencent.mm.kernel.g.RL().Ru().get(Mt(274528), ""));
      if ((TextUtils.isEmpty(this.wdy)) || (!p.u(getContext(), this.wdy)) || ((this.wdt != null) && (!this.wdt.isEmpty()) && (!this.wdt.contains(this.wdy))) || (this.wdx)) {
        break label1242;
      }
      Intent localIntent = new Intent(this.wdo);
      localIntent.setPackage(this.wdy);
      if (!bo.k(this, localIntent)) {
        break label368;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (this.scene != 6))
      {
        i(-1, this.wdy, true);
        AppMethodBeat.o(125880);
        return;
        ab.e("MicroMsg.AppChooserUI", "acc not ready");
        i(4097, null, false);
        AppMethodBeat.o(125880);
        return;
        label368:
        i = 0;
      }
      else
      {
        this.bmC = getPackageManager();
        this.wdn = new AppChooserUI.a(this);
        r.dlm();
        this.wds = r.B(this.wdp, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.wdB = this.wds.fL(getContext());
        this.wdz = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(274496 + this.wdp, Integer.valueOf(0))).intValue();
        r.dlm();
        this.wdA = r.Lv(this.wdp);
        ab.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.wdB), Integer.valueOf(this.wdz) });
        boolean bool;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.wdD = bool;
          if (this.wdz < this.wdA) {
            break label742;
          }
          i = 1;
          label543:
          this.wdw = a(this.wdo, dpt(), this.wdt);
          if ((i == 0) && (!this.wdB)) {
            com.tencent.mm.kernel.g.RL().Ru().set(274496 + this.wdp, Integer.valueOf(this.wdz + 1));
          }
          if (!this.wdB) {
            break label747;
          }
          r.dlm();
          r.Ly(this.wdp);
          label618:
          if (this.wdw == null) {
            break label765;
          }
        }
        label742:
        label747:
        label765:
        for (int j = this.wdw.size();; j = 0)
        {
          ab.i("MicroMsg.AppChooserUI", "mResolveListData size %d", new Object[] { Integer.valueOf(j) });
          if ((this.wdw == null) || (this.wdw.size() != 1) || ((dpt()) && (!this.wdB))) {
            break label802;
          }
          paramBundle = (AppChooserUI.c)this.wdw.get(0);
          if (paramBundle == null) {
            break label786;
          }
          if (paramBundle.wdP == null) {
            break label770;
          }
          i(-1, paramBundle.wdP.activityInfo.packageName, false);
          AppMethodBeat.o(125880);
          return;
          bool = false;
          break;
          i = 0;
          break label543;
          if (i != 0) {
            break label618;
          }
          r.dlm();
          r.Lx(this.wdp);
          break label618;
        }
        label770:
        i(4098, null, false);
        AppMethodBeat.o(125880);
        return;
        label786:
        i(4097, null, false);
        AppMethodBeat.o(125880);
        return;
        label802:
        setTitleVisibility(8);
        if ((this.wdw != null) && (!this.wdw.isEmpty()))
        {
          this.wdn.lee = this.wdw;
          this.wdE = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(Mt(274560), Long.valueOf(0L))).longValue();
          localObject = f.bjl().iA(this.wdE);
          ab.d("MicroMsg.AppChooserUI", "downloadId:" + this.wdE + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (com.tencent.mm.a.e.cN(((FileDownloadTaskInfo)localObject).path)) && (this.wdn != null))
          {
            this.wdn.wdM = AppChooserUI.f.wdZ;
            this.wdn.notifyDataSetChanged();
          }
          this.wdF = new AppChooserUI.e(this, getContext());
          localObject = this.wdF;
          if (paramBundle != null) {}
          for (((AppChooserUI.e)localObject).mTitle = paramBundle.toString();; ((AppChooserUI.e)localObject).mTitle = null)
          {
            this.wdF.wdV = this.wdG;
            this.wdF.wdI = this.wdI;
            this.wdF.wdW = this.wdH;
            this.wdF.krV = this.wdn;
            this.wdF.NX = this.NX;
            paramBundle = this.wdF;
            if (paramBundle.wdV != null) {
              paramBundle.wdU.setOnItemClickListener(paramBundle.wdV);
            }
            if (paramBundle.krV != null) {
              paramBundle.wdU.setAdapter(paramBundle.krV);
            }
            paramBundle.gNn = com.tencent.mm.ui.base.h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.wdU, paramBundle.mContext.getString(2131297099), paramBundle.mContext.getString(2131297098), paramBundle.wdI, paramBundle.wdW, 2131690139);
            paramBundle.gNn.setOnDismissListener(paramBundle.NX);
            paramBundle.gNn.show();
            if ((!this.wdC) && (this.wdB) && (i == 0))
            {
              this.wdu = this.wdv;
              this.wdF.pv(true);
            }
            f.bjl();
            com.tencent.mm.plugin.downloader.model.c.a(this.wdK);
            AppMethodBeat.o(125880);
            return;
          }
        }
        i(4097, null, false);
        AppMethodBeat.o(125880);
        return;
        label1242:
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125882);
    super.onDestroy();
    f.bjl();
    com.tencent.mm.plugin.downloader.model.c.b(this.wdK);
    if (this.wdF != null) {
      this.wdF.gNn.dismiss();
    }
    AppMethodBeat.o(125882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125881);
    super.onResume();
    if ((this.wdC) && (this.wdo != null) && (this.wds.F(this, this.wdo)))
    {
      ab.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.wdC = false;
      this.wdv.wdT = false;
    }
    this.wdB = this.wds.fL(getContext());
    this.wdw = a(this.wdo, dpt(), this.wdt);
    if ((this.wdB) && (this.wdu == null) && (!this.wdx))
    {
      this.wdu = this.wdv;
      this.wdF.pv(true);
    }
    if (this.wdn != null)
    {
      this.wdn.lee = this.wdw;
      this.wdn.notifyDataSetChanged();
    }
    AppMethodBeat.o(125881);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */