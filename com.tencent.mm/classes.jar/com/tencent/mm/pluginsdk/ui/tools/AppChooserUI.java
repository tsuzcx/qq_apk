package com.tencent.mm.pluginsdk.ui.tools;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.d.a.a;
import com.tencent.mm.plugin.d.a.d;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.model.s.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.widget.a.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI
  extends MMActivity
{
  private DialogInterface.OnDismissListener Oj = new AppChooserUI.5(this);
  private PackageManager aVU;
  private String mimeType = null;
  private int scene = 0;
  a skM;
  private Intent skN = null;
  private int skO;
  private String skP = null;
  private Bundle skQ = null;
  private r skR = null;
  private ArrayList<String> skS = null;
  private AppChooserUI.c skT = null;
  private AppChooserUI.c skU = new AppChooserUI.c(this);
  private List<AppChooserUI.c> skV;
  private String skW;
  private int skX;
  private int skY;
  private boolean skZ = false;
  private boolean sla = false;
  private boolean slb = false;
  private long slc;
  private AppChooserUI.e sld;
  private AdapterView.OnItemClickListener sle = new AppChooserUI.1(this);
  private DialogInterface.OnClickListener slf = new AppChooserUI.2(this);
  private DialogInterface.OnClickListener slg = new AppChooserUI.3(this);
  private View.OnClickListener slh = new AppChooserUI.4(this);
  private k sli = new k()
  {
    public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      y.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
      g.DP().Dz().o(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
      if (AppChooserUI.a(AppChooserUI.this) != null)
      {
        AppChooserUI.a(AppChooserUI.this).slk = AppChooserUI.f.slv;
        AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
      }
    }
    
    public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
    {
      y.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", new Object[] { Long.valueOf(paramAnonymousLong), paramAnonymousString });
      if ((!bk.bl(paramAnonymousString)) && (com.tencent.mm.a.e.bK(paramAnonymousString)))
      {
        g.DP().Dz().o(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
        if ((AppChooserUI.a(AppChooserUI.this) != null) && (AppChooserUI.j(AppChooserUI.this) == paramAnonymousLong))
        {
          AppChooserUI.a(AppChooserUI.this).slk = AppChooserUI.f.slx;
          AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
        }
      }
    }
    
    public final void cy(long paramAnonymousLong) {}
    
    public final void cz(long paramAnonymousLong) {}
    
    public final void k(long paramAnonymousLong, String paramAnonymousString) {}
    
    public final void onTaskPaused(long paramAnonymousLong)
    {
      y.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
      g.DP().Dz().o(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(0L));
      if (AppChooserUI.a(AppChooserUI.this) != null)
      {
        AppChooserUI.a(AppChooserUI.this).slk = AppChooserUI.f.slv;
        AppChooserUI.a(AppChooserUI.this).notifyDataSetChanged();
      }
    }
    
    public final void onTaskRemoved(long paramAnonymousLong)
    {
      y.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", new Object[] { Long.valueOf(paramAnonymousLong) });
    }
    
    public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
    {
      AppChooserUI.a(AppChooserUI.this, paramAnonymousLong);
      g.DP().Dz().o(AppChooserUI.a(AppChooserUI.this, 274560), Long.valueOf(AppChooserUI.j(AppChooserUI.this)));
      y.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", new Object[] { String.valueOf(paramAnonymousLong), paramAnonymousString });
    }
  };
  
  private List<AppChooserUI.c> a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramIntent = this.aVU.queryIntentActivities(paramIntent, 65536);
    Object localObject = this.skR.ckt();
    label103:
    int j;
    int i;
    int k;
    if (!bk.bl(((s.a)localObject).rTN))
    {
      this.skP = ((s.a)localObject).rTN;
      if (((s.a)localObject).rTL > 0) {
        this.skU.slp = getResources().getDrawable(((s.a)localObject).rTL);
      }
      if (((s.a)localObject).rTO <= 0) {
        break label385;
      }
      this.skU.slo = getResources().getString(((s.a)localObject).rTO);
      this.skU.slq = true;
      this.skU.pKW = this.skZ;
      if (this.skZ) {
        this.skU.lnq = true;
      }
      if (this.sla) {
        this.skU.slr = true;
      }
      j = 0;
      i = 0;
      k = j;
      if (paramIntent == null) {
        break label437;
      }
      k = j;
      if (paramIntent.size() <= 0) {
        break label437;
      }
      int m = paramIntent.size();
      j = 0;
      label190:
      k = i;
      if (j >= m) {
        break label437;
      }
      y.d("MicroMsg.AppChooserUI", "cpan name:%s", new Object[] { ((ResolveInfo)paramIntent.get(j)).activityInfo.name });
      localObject = (ResolveInfo)paramIntent.get(j);
      if (localObject == null) {
        break label434;
      }
      String str = ((ResolveInfo)localObject).activityInfo.packageName;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (!paramArrayList.contains(str))) {
        break label434;
      }
      if (!this.skR.VJ(str)) {
        break label400;
      }
      this.skU.sln = ((ResolveInfo)localObject);
      this.skU.lnq = true;
      if (((paramBoolean) || (!this.skZ)) && ((paramBoolean) || (!this.skU.lnq))) {
        break label434;
      }
      localArrayList.add(0, this.skU);
      i = 1;
    }
    label385:
    label400:
    label434:
    for (;;)
    {
      j += 1;
      break label190;
      if (((s.a)localObject).rTM <= 0) {
        break;
      }
      this.skP = getResources().getString(((s.a)localObject).rTM);
      break;
      this.skU.slo = ((s.a)localObject).rTP;
      break label103;
      localArrayList.add(new AppChooserUI.c(this, (ResolveInfo)localObject, this.skR.a(this.mController.uMN, (ResolveInfo)localObject)));
    }
    label437:
    if ((paramBoolean) && (k == 0))
    {
      if ((this.skO != 0) || (this.mimeType == null)) {
        break label696;
      }
      localArrayList.add(0, this.skU);
      if (!this.sla) {
        break label663;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11168, new Object[] { Integer.valueOf(2), Integer.valueOf(this.scene) });
    }
    for (;;)
    {
      if ((this.scene == 4) && (this.skU.sln == null))
      {
        this.skU.sln = new ResolveInfo();
        this.skU.sln.activityInfo = new ActivityInfo();
        this.skU.sln.activityInfo.packageName = "com.tencent.mtt";
      }
      paramIntent = new HashSet();
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        paramArrayList = (AppChooserUI.c)localArrayList.get(i);
        if (paramArrayList.sln != null)
        {
          paramArrayList = paramArrayList.sln.activityInfo.packageName;
          if ((!bk.bl(paramArrayList)) && (!paramIntent.add(paramArrayList))) {
            localArrayList.remove(i);
          }
        }
        i -= 1;
      }
      label663:
      com.tencent.mm.plugin.report.service.h.nFQ.f(11168, new Object[] { Integer.valueOf(1), Integer.valueOf(this.scene) });
      continue;
      label696:
      localArrayList.add(0, this.skU);
    }
    return localArrayList;
  }
  
  private static Drawable b(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = com.tencent.mm.cc.a.c(paramResources, paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources) {}
    return null;
  }
  
  private Drawable c(ResolveInfo paramResolveInfo)
  {
    try
    {
      Drawable localDrawable;
      if ((paramResolveInfo.resolvePackageName != null) && (paramResolveInfo.icon != 0))
      {
        localDrawable = b(this.aVU.getResourcesForApplication(paramResolveInfo.resolvePackageName), paramResolveInfo.icon);
        if (localDrawable != null) {
          return localDrawable;
        }
      }
      int i = paramResolveInfo.getIconResource();
      if (i != 0)
      {
        localDrawable = b(this.aVU.getResourcesForApplication(paramResolveInfo.activityInfo.packageName), i);
        if (localDrawable != null)
        {
          y.i("MicroMsg.AppChooserUI", "loadIconForResolveInfo iconRes %d done", new Object[] { Integer.valueOf(i) });
          return localDrawable;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      y.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", new Object[] { localNameNotFoundException });
    }
    return paramResolveInfo.loadIcon(this.aVU);
  }
  
  private boolean coe()
  {
    y.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", new Object[] { Boolean.valueOf(this.slb), Integer.valueOf(this.skX), Integer.valueOf(this.skY), Boolean.valueOf(bk.fV(this)) });
    return (this.slb) && (this.skX < this.skY) && (!bk.fV(this)) && (com.tencent.mm.sdk.platformtools.e.bvj != 1);
  }
  
  private void i(int paramInt, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("selectpkg", paramString);
    localIntent.putExtra("isalways", paramBoolean);
    localIntent.putExtra("transferback", this.skQ);
    setResult(paramInt, localIntent);
    finish();
  }
  
  final int Ev(int paramInt)
  {
    if (this.mimeType != null) {
      return this.skO + paramInt + this.mimeType.hashCode();
    }
    return this.skO + paramInt;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    i(0, null, false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.pluginsdk.model.s.ckE();
    com.tencent.mm.pluginsdk.model.s.DF(this.skO);
    ak.a(getWindow());
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getParcelableExtra("targetintent");
    if (!(paramBundle instanceof Intent))
    {
      y.w("ChooseActivity", "Target is not an intent: " + paramBundle);
      i(0, null, false);
      return;
    }
    this.skN = ((Intent)paramBundle);
    paramBundle = ((Intent)localObject).getStringExtra("title");
    this.skO = ((Intent)localObject).getIntExtra("type", 0);
    this.skQ = ((Intent)localObject).getBundleExtra("transferback");
    this.skS = ((Intent)localObject).getStringArrayListExtra("targetwhitelist");
    this.sla = ((Intent)localObject).getBooleanExtra("needupate", false);
    this.mimeType = ((Intent)localObject).getStringExtra("mimetype");
    this.scene = ((Intent)localObject).getIntExtra("scene", 0);
    int i;
    if (g.DK())
    {
      this.skW = ((String)g.DP().Dz().get(Ev(274528), ""));
      if ((TextUtils.isEmpty(this.skW)) || (!p.o(this.mController.uMN, this.skW)) || ((this.skS != null) && (!this.skS.isEmpty()) && (!this.skS.contains(this.skW)))) {
        break label1140;
      }
      Intent localIntent = new Intent(this.skN);
      localIntent.setPackage(this.skW);
      if (!bk.i(this, localIntent)) {
        break label334;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (this.scene != 6))
      {
        i(-1, this.skW, true);
        return;
        y.e("MicroMsg.AppChooserUI", "acc not ready");
        i(4097, null, false);
        return;
        label334:
        i = 0;
      }
      else
      {
        this.aVU = getPackageManager();
        this.skM = new a();
        com.tencent.mm.pluginsdk.model.s.ckE();
        this.skR = com.tencent.mm.pluginsdk.model.s.u(this.skO, ((Intent)localObject).getBundleExtra("key_recommend_params"));
        this.skZ = this.skR.eL(this.mController.uMN);
        this.skX = ((Integer)g.DP().Dz().get(274496 + this.skO, Integer.valueOf(0))).intValue();
        com.tencent.mm.pluginsdk.model.s.ckE();
        this.skY = com.tencent.mm.pluginsdk.model.s.DE(this.skO);
        y.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", new Object[] { String.valueOf(this.skZ), Integer.valueOf(this.skX) });
        boolean bool;
        if (!((Intent)localObject).getBooleanExtra("not_show_recommend_app", false))
        {
          bool = true;
          this.slb = bool;
          if (this.skX < this.skY) {
            break label666;
          }
          i = 1;
          label510:
          this.skV = a(this.skN, coe(), this.skS);
          if ((i == 0) && (!this.skZ)) {
            g.DP().Dz().o(274496 + this.skO, Integer.valueOf(this.skX + 1));
          }
          if (!this.skZ) {
            break label671;
          }
          com.tencent.mm.pluginsdk.model.s.ckE();
          com.tencent.mm.pluginsdk.model.s.DH(this.skO);
        }
        for (;;)
        {
          if ((this.skV != null) && (this.skV.size() == 1) && ((!coe()) || (this.skZ)))
          {
            paramBundle = (AppChooserUI.c)this.skV.get(0);
            if (paramBundle != null)
            {
              if (paramBundle.sln != null)
              {
                i(-1, paramBundle.sln.activityInfo.packageName, false);
                return;
                bool = false;
                break;
                label666:
                i = 0;
                break label510;
                label671:
                if (i != 0) {
                  continue;
                }
                com.tencent.mm.pluginsdk.model.s.ckE();
                com.tencent.mm.pluginsdk.model.s.DG(this.skO);
                continue;
              }
              i(4098, null, false);
              return;
            }
            i(4097, null, false);
            return;
          }
        }
        setTitleVisibility(8);
        if ((this.skV != null) && (!this.skV.isEmpty()))
        {
          this.skM.iVa = this.skV;
          this.slc = ((Long)g.DP().Dz().get(Ev(274560), Long.valueOf(0L))).longValue();
          localObject = d.aFP().dd(this.slc);
          y.d("MicroMsg.AppChooserUI", "downloadId:" + this.slc + ", status:" + ((FileDownloadTaskInfo)localObject).status);
          if ((3 == ((FileDownloadTaskInfo)localObject).status) && (com.tencent.mm.a.e.bK(((FileDownloadTaskInfo)localObject).path)) && (this.skM != null))
          {
            this.skM.slk = AppChooserUI.f.slx;
            this.skM.notifyDataSetChanged();
          }
          this.sld = new AppChooserUI.e(this, this.mController.uMN);
          localObject = this.sld;
          if (paramBundle != null) {}
          for (((AppChooserUI.e)localObject).mTitle = paramBundle.toString();; ((AppChooserUI.e)localObject).mTitle = null)
          {
            this.sld.slt = this.sle;
            this.sld.slg = this.slg;
            this.sld.slu = this.slf;
            this.sld.iqN = this.skM;
            this.sld.Oj = this.Oj;
            paramBundle = this.sld;
            if (paramBundle.slt != null) {
              paramBundle.sls.setOnItemClickListener(paramBundle.slt);
            }
            if (paramBundle.iqN != null) {
              paramBundle.sls.setAdapter(paramBundle.iqN);
            }
            paramBundle.fvH = com.tencent.mm.ui.base.h.a(paramBundle.mContext, true, paramBundle.mTitle, paramBundle.sls, paramBundle.mContext.getString(a.f.app_use_once), paramBundle.mContext.getString(a.f.app_use_always), paramBundle.slg, paramBundle.slu, a.a.green_text_color);
            paramBundle.fvH.setOnDismissListener(paramBundle.Oj);
            paramBundle.fvH.show();
            if ((!this.sla) && (this.skZ) && (i == 0))
            {
              this.skT = this.skU;
              this.sld.mg(true);
            }
            d.aFP();
            b.a(this.sli);
            return;
          }
        }
        i(4097, null, false);
        return;
        label1140:
        i = 0;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d.aFP();
    b.b(this.sli);
    if (this.sld != null) {
      this.sld.fvH.dismiss();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.sla) && (this.skN != null) && (this.skR.y(this, this.skN)))
    {
      y.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
      this.sla = false;
      this.skU.slr = false;
    }
    this.skZ = this.skR.eL(this.mController.uMN);
    this.skV = a(this.skN, coe(), this.skS);
    if ((this.skZ) && (this.skT == null))
    {
      this.skT = this.skU;
      this.sld.mg(true);
    }
    if (this.skM != null)
    {
      this.skM.iVa = this.skV;
      this.skM.notifyDataSetChanged();
    }
  }
  
  final class a
    extends BaseAdapter
  {
    List<AppChooserUI.c> iVa = new ArrayList();
    AppChooserUI.f slk = AppChooserUI.f.slv;
    
    public a()
    {
      AppChooserUI.a(AppChooserUI.this, AppChooserUI.this.getPackageManager());
    }
    
    public final AppChooserUI.c Ew(int paramInt)
    {
      if (this.iVa == null) {
        return null;
      }
      return (AppChooserUI.c)this.iVa.get(paramInt);
    }
    
    public final int getCount()
    {
      if (this.iVa == null) {
        return 0;
      }
      return this.iVa.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if (Ew(paramInt).slq) {
        return 1;
      }
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 0;
      AppChooserUI.c localc1 = Ew(paramInt);
      label72:
      boolean bool;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(AppChooserUI.this.mController.uMN);
        if (localc1.slq)
        {
          paramInt = a.d.app_choose_list_recommand_item;
          paramView = paramView.inflate(paramInt, null);
          paramViewGroup = new AppChooserUI.b(AppChooserUI.this, paramView);
          paramView.setTag(paramViewGroup);
          if (localc1.slp == null) {
            new AppChooserUI.d(AppChooserUI.this).execute(new AppChooserUI.c[] { localc1 });
          }
          paramViewGroup.leS.setImageDrawable(localc1.slp);
          paramViewGroup.leT.setText(localc1.slo);
          if ((localc1 == null) || ((localc1.slq) && (!localc1.pKW) && ((!localc1.slq) || (!localc1.lnq) || (AppChooserUI.d(AppChooserUI.this) < AppChooserUI.e(AppChooserUI.this)))) || (localc1.slr)) {
            break label438;
          }
          paramViewGroup.sll.setVisibility(8);
          paramViewGroup.slm.setVisibility(0);
          Object localObject = paramViewGroup.slm;
          AppChooserUI.c localc2 = AppChooserUI.c(AppChooserUI.this);
          if (!(localc2 instanceof AppChooserUI.c)) {
            break label432;
          }
          localc2 = (AppChooserUI.c)localc2;
          if (((localc2.sln == null) || (localc1.sln == null) || (!localc2.sln.activityInfo.packageName.equals(localc1.sln.activityInfo.packageName))) && ((!localc2.slq) || (!localc1.slq))) {
            break label432;
          }
          bool = true;
          label300:
          ((RadioButton)localObject).setChecked(bool);
          label307:
          if (!localc1.slq) {
            break label624;
          }
          if (AppChooserUI.f(AppChooserUI.this) != 4) {
            break label604;
          }
          paramViewGroup.leV.setText(a.f.qq_browser_desc_for_wb);
          label336:
          localObject = paramViewGroup.leV;
          paramInt = i;
          if (bk.bl(AppChooserUI.l(AppChooserUI.this))) {
            paramInt = 8;
          }
          ((TextView)localObject).setVisibility(paramInt);
        }
      }
      for (;;)
      {
        if ((AppChooserUI.f(AppChooserUI.this) != 6) && (AppChooserUI.c(AppChooserUI.this) != null) && (AppChooserUI.c(AppChooserUI.this).equals(localc1))) {
          paramViewGroup.slm.setChecked(true);
        }
        return paramView;
        paramInt = a.d.app_choose_list_item;
        break;
        paramViewGroup = (AppChooserUI.b)paramView.getTag();
        break label72;
        label432:
        bool = false;
        break label300;
        label438:
        paramViewGroup.sll.setVisibility(0);
        paramViewGroup.slm.setVisibility(8);
        paramViewGroup.sll.setOnClickListener(AppChooserUI.k(AppChooserUI.this));
        if (this.slk == AppChooserUI.f.slv)
        {
          if (localc1.slr) {
            paramViewGroup.sll.setText(a.f.app_need_to_update);
          }
          for (;;)
          {
            paramViewGroup.sll.setEnabled(true);
            break;
            paramViewGroup.sll.setText(a.f.app_download);
          }
        }
        if (this.slk == AppChooserUI.f.slw)
        {
          paramViewGroup.sll.setText(a.f.app_downloading);
          paramViewGroup.sll.setEnabled(false);
          break label307;
        }
        if (this.slk != AppChooserUI.f.slx) {
          break label307;
        }
        if (localc1.slr) {
          paramViewGroup.sll.setText(a.f.app_to_update);
        }
        for (;;)
        {
          paramViewGroup.sll.setEnabled(true);
          break;
          paramViewGroup.sll.setText(a.f.app_to_install);
        }
        label604:
        paramViewGroup.leV.setText(bk.pm(AppChooserUI.l(AppChooserUI.this)));
        break label336;
        label624:
        paramViewGroup.leV.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI
 * JD-Core Version:    0.7.0.1
 */