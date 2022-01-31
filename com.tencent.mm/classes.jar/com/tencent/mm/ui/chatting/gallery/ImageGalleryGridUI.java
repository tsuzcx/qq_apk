package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView<*>;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.t.a;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.or.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@com.tencent.mm.ui.base.a(19)
public class ImageGalleryGridUI
  extends MMActivity
  implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, com.tencent.mm.af.t, h.b
{
  protected ak handler;
  public long jUy;
  private com.tencent.mm.sdk.b.c kFH;
  private boolean kFs;
  private boolean mBY;
  private boolean mIsPause;
  public boolean muT;
  private Animation qUH;
  private GridView rOl;
  private String talker;
  public int zKC;
  d zKD;
  private WeakReference<d.a> zKE;
  private Boolean zKF;
  private Boolean zKG;
  private TextView zKH;
  private TextView zKI;
  private Runnable zKJ;
  private Runnable zKK;
  private long zKL;
  Runnable zKM;
  public View zKN;
  private View zKO;
  private int zKP;
  private View zKQ;
  private View zKR;
  private View zKS;
  private View zKT;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(32049);
    this.zKJ = new ImageGalleryGridUI.1(this);
    this.zKK = new ImageGalleryGridUI.3(this);
    this.kFH = new ImageGalleryGridUI.4(this);
    this.mBY = false;
    this.kFs = false;
    this.zKL = 0L;
    this.zKM = new ImageGalleryGridUI.8(this);
    this.zKN = null;
    this.zKP = -1;
    this.mIsPause = true;
    AppMethodBeat.o(32049);
  }
  
  @TargetApi(11)
  private void Qc(int paramInt)
  {
    AppMethodBeat.i(32057);
    handleIntent(getIntent());
    setMMTitle(getString(2131296524));
    setBackBtn(new ImageGalleryGridUI.5(this));
    this.zKO = findViewById(2131825105);
    Object localObject = findViewById(2131825106);
    this.zKQ = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131824060);
    this.zKR = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131825107);
    this.zKS = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131822840);
    this.zKT = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.zKH = ((TextView)findViewById(2131824062));
    this.zKI = ((TextView)findViewById(2131825104));
    if (paramInt == 0)
    {
      this.rOl = ((GridView)findViewById(2131825103));
      this.rOl.setOnItemClickListener(this);
      this.rOl.setNumColumns(3);
      localObject = new bi();
      if (this.muT) {
        ((bi)localObject).fR(this.jUy);
      }
      this.zKD = new d(this, (bi)localObject, this.talker);
      if (this.zKD.getCount() == 0)
      {
        this.zKI.setVisibility(0);
        AppMethodBeat.o(32057);
        return;
      }
      this.zKI.setVisibility(8);
      this.rOl.setAdapter(this.zKD);
      dKa();
    }
    for (;;)
    {
      this.rOl.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable kGn;
        
        private void gh(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(32042);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.kGn);
            if (ImageGalleryGridUI.b(ImageGalleryGridUI.this).getVisibility() != 0)
            {
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.getContext(), 2131034181);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).setVisibility(0);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).startAnimation(localAnimation);
              AppMethodBeat.o(32042);
            }
          }
          else
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.kGn);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.kGn, 256L);
          }
          AppMethodBeat.o(32042);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(32044);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (bi)paramAnonymousAbsListView.zKD.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.dNj().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            AppMethodBeat.o(32044);
            return;
            localObject = new Date(((dd)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(32043);
          if (1 == paramAnonymousInt) {
            gh(true);
          }
          for (;;)
          {
            o.ahG().bX(paramAnonymousInt);
            AppMethodBeat.o(32043);
            return;
            if (paramAnonymousInt == 0) {
              gh(false);
            }
          }
        }
      });
      AppMethodBeat.o(32057);
      return;
      if (this.zKD != null)
      {
        this.zKD.notifyDataSetChanged();
        dKa();
      }
    }
  }
  
  private boolean a(bi parambi, f paramf)
  {
    AppMethodBeat.i(32061);
    if ((!parambi.field_talker.endsWith("@qqim")) || (!paramf.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(32061);
      return false;
    }
    ab.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    parambi = new Intent("android.intent.action.MAIN", null);
    parambi.addCategory("android.intent.category.LAUNCHER");
    parambi.addFlags(268435456);
    parambi.setClassName("com.tencent.mobileqq", aO(getContext(), "com.tencent.mobileqq"));
    parambi.putExtra("platformId", "wechat");
    aw.aaz();
    paramf = com.tencent.mm.model.c.Ru().get(9, null);
    int i;
    if ((paramf != null) && ((paramf instanceof Integer))) {
      i = ((Integer)paramf).intValue();
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramf = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int k = arrayOfByte.length;
        int j = 0;
        i = 0;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if (i >= paramf.length) {
            break;
          }
          paramf[i] = ((byte)(m ^ paramf[i]));
          j += 1;
          i += 1;
        }
        parambi.putExtra("tencent_gif", paramf);
        label232:
        i = 0;
      }
      catch (UnsupportedEncodingException paramf)
      {
        try
        {
          for (;;)
          {
            startActivity(parambi);
            AppMethodBeat.o(32061);
            return true;
            paramf = paramf;
            ab.printErrStackTrace("MicroMsg.GalleryGridUI", paramf, "", new Object[0]);
          }
        }
        catch (Exception parambi)
        {
          break label232;
        }
      }
    }
  }
  
  private static String aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(32062);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label102;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(32062);
    return paramContext;
  }
  
  private void ao(View paramView, int paramInt)
  {
    AppMethodBeat.i(32067);
    if (this.zKD == null)
    {
      AppMethodBeat.o(32067);
      return;
    }
    ab.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.jUy);
    localIntent.putExtra("key_is_biz_chat", this.muT);
    localIntent.putExtra("intent.key.with.footer", true);
    bi localbi = (bi)this.zKD.getItem(paramInt);
    if (localbi == null)
    {
      AppMethodBeat.o(32067);
      return;
    }
    int j = getResources().getConfiguration().orientation;
    int i = 0;
    paramInt = 0;
    int[] arrayOfInt = new int[2];
    if (paramView != null)
    {
      i = paramView.getWidth();
      paramInt = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    localIntent.addFlags(536870912);
    localIntent.putExtra("img_gallery_msg_id", localbi.field_msgId).putExtra("img_gallery_msg_svr_id", localbi.field_msgSvrId).putExtra("img_gallery_talker", localbi.field_talker).putExtra("img_gallery_chatroom_name", localbi.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      startActivity(localIntent);
      overridePendingTransition(0, 0);
      AppMethodBeat.o(32067);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private void bA(bi parambi)
  {
    AppMethodBeat.i(32066);
    if (!dKb())
    {
      com.tencent.mm.ui.base.t.ii(getContext());
      AppMethodBeat.o(32066);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", parambi.field_msgId);
    startActivity(localIntent);
    AppMethodBeat.o(32066);
  }
  
  private void byh()
  {
    AppMethodBeat.i(32070);
    setMMTitle(getString(2131300316, new Object[] { Integer.valueOf(h.a.dKg().mCl.size()) }));
    h.a.dKg().mCm = true;
    if (this.zKD == null)
    {
      AppMethodBeat.o(32070);
      return;
    }
    if (this.qUH == null) {
      this.qUH = AnimationUtils.loadAnimation(this, 2131034230);
    }
    this.zKD.byh();
    this.zKO.setVisibility(0);
    this.zKO.startAnimation(this.qUH);
    this.zKQ.setEnabled(false);
    this.zKR.setEnabled(false);
    this.zKS.setEnabled(false);
    this.zKT.setEnabled(false);
    this.zKP = this.rOl.getPaddingBottom();
    this.rOl.setPadding(this.rOl.getPaddingLeft(), this.rOl.getPaddingTop(), this.rOl.getPaddingRight(), com.tencent.mm.cb.a.ao(getContext(), 2131427853));
    com.tencent.mm.plugin.report.service.h.qsU.e(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131300277), this);
    AppMethodBeat.o(32070);
  }
  
  private String bz(bi parambi)
  {
    AppMethodBeat.i(32063);
    String str = bo.bf(this.talker, "");
    boolean bool = com.tencent.mm.model.t.lA(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(32063);
      return str;
    }
    if (bool)
    {
      parambi = bf.pu(parambi.field_content);
      if ((parambi == null) || (parambi.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(32063);
      return parambi;
      parambi = str;
    }
  }
  
  private void c(cm paramcm)
  {
    AppMethodBeat.i(32076);
    paramcm.cpR.activity = this;
    paramcm.cpR.cpY = 45;
    com.tencent.mm.sdk.b.a.ymk.l(paramcm);
    if ((paramcm.cpS.ret == -2) || (paramcm.cpS.ret > 0))
    {
      AppMethodBeat.o(32076);
      return;
    }
    if (paramcm.cpS.ret <= 0)
    {
      byi();
      if (14 != paramcm.cpR.type)
      {
        ab.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(32076);
        return;
      }
      if (paramcm.cpR.cpU == null)
      {
        ab.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(32076);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11142, new Object[] { Integer.valueOf(paramcm.cpR.cpU.wVr), Integer.valueOf(paramcm.cpR.cpU.wVs), Integer.valueOf(paramcm.cpR.cpU.wVt), Integer.valueOf(paramcm.cpR.cpU.wVu), Integer.valueOf(paramcm.cpR.cpU.wVv), Integer.valueOf(paramcm.cpR.cpU.wVw), Integer.valueOf(paramcm.cpR.cpU.wVx), Integer.valueOf(paramcm.cpR.cpU.fileCount), Integer.valueOf(paramcm.cpR.cpU.wVy), Integer.valueOf(paramcm.cpR.cpU.wVz), Integer.valueOf(paramcm.cpR.cpU.wVA), Integer.valueOf(paramcm.cpR.cpU.wVB), Integer.valueOf(paramcm.cpR.cpU.wVC), Integer.valueOf(paramcm.cpR.cpU.wVD), Integer.valueOf(paramcm.cpR.cpU.wVE) });
    }
    AppMethodBeat.o(32076);
  }
  
  private void dKa()
  {
    AppMethodBeat.i(32058);
    int i = this.rOl.getFirstVisiblePosition();
    int j = this.rOl.getLastVisiblePosition();
    int k = this.zKC;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(32058);
      return;
    }
    this.rOl.setSelection(k);
    AppMethodBeat.o(32058);
  }
  
  private boolean dKb()
  {
    AppMethodBeat.i(32065);
    long l1 = this.zKL;
    long l2 = System.currentTimeMillis();
    this.zKL = l2;
    if (l1 + 30000L < l2)
    {
      aw.aaz();
      this.kFs = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.kFs;
    AppMethodBeat.o(32065);
    return bool;
  }
  
  private void dKc()
  {
    AppMethodBeat.i(32071);
    if ((!h.a.dKg().mCl.isEmpty()) && (h.a.dKg().mCm)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.zKQ.setEnabled(true);
      this.zKR.setEnabled(true);
      this.zKS.setEnabled(true);
      this.zKT.setEnabled(true);
      AppMethodBeat.o(32071);
      return;
    }
    this.zKQ.setEnabled(false);
    this.zKR.setEnabled(false);
    this.zKS.setEnabled(false);
    this.zKT.setEnabled(false);
    AppMethodBeat.o(32071);
  }
  
  private static void fg(List<bi> paramList)
  {
    AppMethodBeat.i(32074);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.zvl, a.d.zvq, localbi, 0);
    }
    AppMethodBeat.o(32074);
  }
  
  private static List<bi> fj(List<bi> paramList)
  {
    AppMethodBeat.i(32075);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((!c.bq(localbi)) && (!c.br(localbi))) {
        localArrayList.add(localbi);
      }
    }
    AppMethodBeat.o(32075);
    return localArrayList;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(32064);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(32064);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(32064);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
      AppMethodBeat.o(32064);
    }
    return null;
  }
  
  private void handleIntent(Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(32054);
    if (paramIntent.getIntExtra("kintent_intent_source", 0) == 1) {}
    for (;;)
    {
      this.zKF = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.zKC = paramIntent.getIntExtra("kintent_image_index", 0);
      this.muT = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.jUy = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.zKG = Boolean.TRUE;
      AppMethodBeat.o(32054);
      return;
      bool = false;
    }
  }
  
  public final boolean Yr()
  {
    return true;
  }
  
  public final void a(t.a parama) {}
  
  public final void b(t.a parama) {}
  
  public final void byi()
  {
    AppMethodBeat.i(32072);
    h.a.dKg().mCm = false;
    setMMTitle(getString(2131296524));
    if (this.zKD == null)
    {
      AppMethodBeat.o(32072);
      return;
    }
    this.zKD.notifyDataSetChanged();
    if (this.zKP >= 0) {
      this.rOl.setPadding(this.rOl.getPaddingLeft(), this.rOl.getPaddingTop(), this.rOl.getPaddingRight(), this.zKP);
    }
    this.zKO.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131300278), this);
    AppMethodBeat.o(32072);
  }
  
  public final void c(t.a parama)
  {
    AppMethodBeat.i(153849);
    if (parama == t.a.fkd)
    {
      this.zKD.Ku();
      this.zKD.notifyDataSetChanged();
    }
    byi();
    AppMethodBeat.o(153849);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(32078);
    if ((this.zKD != null) && (this.mIsPause)) {
      this.zKD.zKv = true;
    }
    dKc();
    AppMethodBeat.o(32078);
  }
  
  public final void dKd()
  {
    AppMethodBeat.i(32077);
    if ((this.zKD != null) && (this.mIsPause)) {
      this.zKD.zKv = true;
    }
    setMMTitle(getString(2131300316, new Object[] { Integer.valueOf(h.a.dKg().mCl.size()) }));
    dKc();
    AppMethodBeat.o(32077);
  }
  
  public void finish()
  {
    AppMethodBeat.i(32059);
    super.finish();
    h.a.dKg().detach();
    AppMethodBeat.o(32059);
  }
  
  public boolean fromFullScreenActivity()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130969890;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(32056);
    if (h.a.dKg().mCm)
    {
      byi();
      AppMethodBeat.o(32056);
      return;
    }
    if (this.zKF.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(32056);
      return;
    }
    if (this.zKC >= 0) {
      ao(null, this.zKC);
    }
    finish();
    AppMethodBeat.o(32056);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(32073);
    if (h.a.dKg().mCl.isEmpty())
    {
      AppMethodBeat.o(32073);
      return;
    }
    boolean bool = com.tencent.mm.model.t.lA(this.talker);
    Object localObject2 = h.a.dKg().mCl;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      AppMethodBeat.o(32073);
      return;
    }
    if (paramView.getId() == 2131822840)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((bi)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131298494), "", getString(2131298950), getString(2131296888), new ImageGalleryGridUI.9(this, paramView), null);
      AppMethodBeat.o(32073);
      return;
    }
    if (paramView.getId() == 2131825106)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 18L, 1L, true);
      cm localcm = new cm();
      if (com.tencent.mm.pluginsdk.model.g.a(getContext(), localcm, this.talker, (List)localObject2, false))
      {
        c(localcm);
        fg((List)localObject2);
        AppMethodBeat.o(32073);
        return;
      }
      if (((List)localObject2).size() > 1)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        if (localcm.cpR.cpX >= 0)
        {
          paramView = getContext().getString(2131299727);
          if (localcm.cpR.cpX < 0) {
            break label373;
          }
        }
        label373:
        for (localObject1 = getContext().getString(2131298501);; localObject1 = getContext().getString(2131302102))
        {
          com.tencent.mm.ui.base.h.d(localAppCompatActivity, paramView, "", (String)localObject1, getContext().getString(2131298499), new ImageGalleryGridUI.10(this, localcm, (List)localObject2), null);
          AppMethodBeat.o(32073);
          return;
          paramView = getContext().getString(2131299726);
          break;
        }
      }
      com.tencent.mm.ui.base.h.h(getContext(), localcm.cpR.cpX, 0);
      AppMethodBeat.o(32073);
      return;
    }
    if (paramView.getId() == 2131824060)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 19L, 1L, true);
      k.a(this, (List)localObject2, bool, this.talker, this);
      byi();
      AppMethodBeat.o(32073);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(11627, new Object[] { Integer.valueOf(3) });
    paramView = fj((List)localObject2);
    if (paramView.size() != ((List)localObject2).size())
    {
      com.tencent.mm.ui.base.h.a(getContext(), 2131300304, 2131297087, new ImageGalleryGridUI.2(this, paramView), null);
      AppMethodBeat.o(32073);
      return;
    }
    Object localObject1 = (bi)paramView.get(0);
    if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((bi)localObject1).bCn()))
    {
      localObject2 = ((dd)localObject1).field_content;
      paramView = null;
      if (localObject2 != null) {
        paramView = j.b.ab((String)localObject2, ((dd)localObject1).field_reserved);
      }
      if ((paramView != null) && (paramView.type == 6)) {
        bA((bi)localObject1);
      }
      AppMethodBeat.o(32073);
      return;
    }
    c.f(this, (List)localObject2);
    byi();
    AppMethodBeat.o(32073);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32050);
    super.onCreate(paramBundle);
    this.mBY = true;
    this.handler = new ak();
    Qc(0);
    com.tencent.mm.sdk.b.a.ymk.c(this.kFH);
    AppMethodBeat.o(32050);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32051);
    this.handler.removeCallbacks(this.zKK);
    this.handler = null;
    o.ahG().bX(0);
    com.tencent.mm.sdk.b.a.ymk.d(this.kFH);
    super.onDestroy();
    AppMethodBeat.o(32051);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(32060);
    bi localbi = (bi)this.zKD.getItem(paramInt);
    paramAdapterView = localbi.field_content;
    if (paramAdapterView != null) {}
    for (paramAdapterView = j.b.ab(paramAdapterView, localbi.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6))
      {
        bA(localbi);
        AppMethodBeat.o(32060);
        return;
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramAdapterView != null) && (paramAdapterView.type == 3))
      {
        localObject1 = p.H(paramAdapterView.url, "message");
        localObject2 = p.H(paramAdapterView.fgv, "message");
        localObject3 = getPackageInfo(getContext(), paramAdapterView.appId);
        if (localObject3 == null)
        {
          paramView = null;
          if (localObject3 != null) {
            break label199;
          }
        }
        long l;
        label199:
        for (paramInt = 0;; paramInt = ((PackageInfo)localObject3).versionCode)
        {
          localObject3 = paramAdapterView.appId;
          paramLong = localbi.field_msgId;
          l = localbi.field_msgSvrId;
          if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
            break label208;
          }
          ab.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
          AppMethodBeat.o(32060);
          return;
          paramView = ((PackageInfo)localObject3).versionName;
          break;
        }
        label208:
        if (at.isMobile(getContext()))
        {
          paramAdapterView = (AdapterView<?>)localObject1;
          if (localObject2 != null)
          {
            if (((String)localObject2).length() > 0) {
              break label491;
            }
            paramAdapterView = (AdapterView<?>)localObject1;
          }
        }
        for (;;)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("msg_id", paramLong);
          ((Intent)localObject1).putExtra("rawUrl", paramAdapterView);
          ((Intent)localObject1).putExtra("version_name", paramView);
          ((Intent)localObject1).putExtra("version_code", paramInt);
          ((Intent)localObject1).putExtra("usePlugin", true);
          ((Intent)localObject1).putExtra("geta8key_username", this.talker);
          ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(l));
          ((Intent)localObject1).putExtra("KAppId", (String)localObject3);
          paramAdapterView = bz(localbi);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
          if (localbi != null) {
            ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          }
          ((Intent)localObject1).putExtra("preChatName", this.talker);
          ((Intent)localObject1).putExtra("preChatTYPE", u.ah(paramAdapterView, this.talker));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(32060);
          return;
          if (localObject1 != null)
          {
            paramAdapterView = (AdapterView<?>)localObject1;
            if (((String)localObject1).length() > 0) {}
          }
          else
          {
            label491:
            paramAdapterView = (AdapterView<?>)localObject2;
          }
        }
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 5))
      {
        if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
        {
          localObject1 = paramAdapterView.url;
          if (!com.tencent.mm.model.t.lA(this.talker)) {
            break label968;
          }
          paramView = "groupmessage";
          localObject3 = p.H((String)localObject1, paramView);
          paramView = paramAdapterView.url;
          localObject2 = getPackageInfo(getContext(), paramAdapterView.appId);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
          ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
          if ((paramAdapterView.appId != null) && (("wx751a1acca5688ba3".equals(paramAdapterView.appId)) || ("wxfbc915ff7c30e335".equals(paramAdapterView.appId)) || ("wx482a4001c37e2b74".equals(paramAdapterView.appId))))
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("jsapi_args_appid", paramAdapterView.appId);
            ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject3);
          }
          if (bo.isNullOrNil(paramView)) {
            break label975;
          }
          ((Intent)localObject1).putExtra("shortUrl", paramView);
          label703:
          if (localObject2 != null) {
            break label991;
          }
          paramView = null;
          label710:
          ((Intent)localObject1).putExtra("version_name", paramView);
          if (localObject2 != null) {
            break label1000;
          }
        }
        label968:
        label975:
        label991:
        label1000:
        for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
        {
          ((Intent)localObject1).putExtra("version_code", paramInt);
          if (!bo.isNullOrNil(paramAdapterView.cGN))
          {
            ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.cGN);
            ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.cGO);
          }
          ((Intent)localObject1).putExtra("msg_id", localbi.field_msgId);
          ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbi.field_msgSvrId));
          ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
          ((Intent)localObject1).putExtra("geta8key_username", this.talker);
          paramAdapterView = bz(localbi);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbi.field_msgSvrId));
          ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          ((Intent)localObject1).putExtra("preChatName", this.talker);
          ((Intent)localObject1).putExtra("preChatTYPE", u.ah(paramAdapterView, this.talker));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(32060);
          return;
          paramView = "singlemessage";
          break;
          ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
          break label703;
          paramView = ((PackageInfo)localObject2).versionName;
          break label710;
        }
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 19))
      {
        paramView = new Intent();
        paramView.putExtra("message_id", localbi.field_msgId);
        paramView.putExtra("record_xml", paramAdapterView.fhc);
        com.tencent.mm.bq.d.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
        AppMethodBeat.o(32060);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 24))
      {
        paramView = new me();
        paramView.cCl.context = getContext();
        paramView.cCl.cpO = localbi.field_msgId;
        paramView.cCl.cCm = paramAdapterView.fhc;
        com.tencent.mm.sdk.b.a.ymk.l(paramView);
        AppMethodBeat.o(32060);
        return;
      }
      label1239:
      Object localObject4;
      label1296:
      boolean bool;
      if ((paramAdapterView != null) && (paramAdapterView.type == 7))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.g.ca(paramAdapterView.appId, false);
        if (localObject2 != null)
        {
          localObject1 = this.talker;
          paramView = (View)localObject1;
          if (com.tencent.mm.model.t.lA((String)localObject1)) {
            paramView = bf.pu(localbi.field_content);
          }
          paramLong = localbi.field_msgSvrId;
          if ((localObject2 != null) && (p.u(getContext(), ((f)localObject2).field_packageName)))
          {
            paramInt = 3;
            if (paramAdapterView.type != 2) {
              break label1633;
            }
            paramInt = 4;
            localObject3 = new or();
            ((or)localObject3).cFl.context = getContext();
            ((or)localObject3).cFl.scene = 1;
            ((or)localObject3).cFl.cwc = paramAdapterView.appId;
            localObject4 = ((or)localObject3).cFl;
            if (localObject2 != null) {
              break label1646;
            }
            localObject1 = null;
            ((or.a)localObject4).packageName = ((String)localObject1);
            ((or)localObject3).cFl.msgType = paramAdapterView.type;
            ((or)localObject3).cFl.czp = paramView;
            ((or)localObject3).cFl.cFm = paramInt;
            ((or)localObject3).cFl.mediaTagName = paramAdapterView.mediaTagName;
            ((or)localObject3).cFl.cFn = paramLong;
            ((or)localObject3).cFl.cFo = "";
            ((or)localObject3).cFl.cmF = this.talker;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
            paramView = b.a.bEX();
            if ((com.tencent.mm.pluginsdk.model.app.g.a(getContext(), (f)localObject2)) || (paramView == null)) {
              break label1748;
            }
            if (bo.isNullOrNil(((com.tencent.mm.g.c.t)localObject2).djP)) {
              break label1656;
            }
            bool = q.bw(getContext(), ((com.tencent.mm.g.c.t)localObject2).djP);
            ab.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((com.tencent.mm.g.c.t)localObject2).djP, Boolean.valueOf(bool) });
            if (!bool) {
              break label1656;
            }
            paramInt = 1;
          }
          for (;;)
          {
            if (paramInt == 0)
            {
              if ((paramAdapterView.cmN == null) || (paramAdapterView.cmN.length() == 0))
              {
                paramView = localbi.field_content;
                paramAdapterView = paramView;
                if (localbi.field_isSend == 0)
                {
                  paramInt = localbi.field_isSend;
                  paramAdapterView = paramView;
                  if (!this.muT)
                  {
                    paramAdapterView = paramView;
                    if (com.tencent.mm.model.t.lA(this.talker))
                    {
                      paramAdapterView = paramView;
                      if (paramView != null)
                      {
                        paramAdapterView = paramView;
                        if (paramInt == 0) {
                          paramAdapterView = bf.pv(paramView);
                        }
                      }
                    }
                  }
                }
                paramView = j.b.mY(paramAdapterView);
                localObject1 = com.tencent.mm.pluginsdk.model.app.g.ca(paramView.appId, true);
                if ((localObject1 != null) && (p.u(getContext(), ((f)localObject1).field_packageName)))
                {
                  if (((f)localObject1).field_status == 3)
                  {
                    ab.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((f)localObject1).field_packageName);
                    AppMethodBeat.o(32060);
                    return;
                    paramInt = 6;
                    break;
                    label1633:
                    if (paramAdapterView.type != 5) {
                      break label1239;
                    }
                    paramInt = 1;
                    break label1239;
                    label1646:
                    localObject1 = ((f)localObject2).field_packageName;
                    break label1296;
                    label1656:
                    localObject1 = new gu();
                    ((gu)localObject1).cvL.actionCode = 2;
                    ((gu)localObject1).cvL.scene = 1;
                    ((gu)localObject1).cvL.appId = ((f)localObject2).field_appId;
                    ((gu)localObject1).cvL.context = getContext();
                    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
                    new Intent();
                    getContext();
                    paramView.ag(((f)localObject2).field_appId, 1, 1);
                    paramInt = 1;
                    continue;
                    label1748:
                    paramInt = 0;
                    continue;
                  }
                  if (!p.b(getContext(), (f)localObject1))
                  {
                    ab.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((f)localObject1).field_appName });
                    Toast.makeText(getContext(), getString(2131300385, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(getContext(), (f)localObject1, null) }), 1).show();
                    AppMethodBeat.o(32060);
                    return;
                  }
                  if (a(localbi, (f)localObject1)) {
                    break label2058;
                  }
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.cmN != null) && (paramView.cmN.length() > 0))
                  {
                    paramAdapterView = al.aUJ().alo(paramView.cmN);
                    if (paramAdapterView != null) {
                      break label2004;
                    }
                  }
                  label2004:
                  for (paramAdapterView = null;; paramAdapterView = paramAdapterView.field_fileFullPath)
                  {
                    ((WXAppExtendObject)localObject2).filePath = paramAdapterView;
                    paramAdapterView = new WXMediaMessage();
                    paramAdapterView.sdkVer = 620954624;
                    paramAdapterView.mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                    paramAdapterView.title = paramView.title;
                    paramAdapterView.description = paramView.description;
                    paramAdapterView.messageAction = paramView.messageAction;
                    paramAdapterView.messageExt = paramView.messageExt;
                    paramAdapterView.thumbData = e.i(o.ahC().te(localbi.field_imgPath), 0, -1);
                    new ar(this).a(((f)localObject1).field_packageName, paramAdapterView, ((f)localObject1).field_appId, ((f)localObject1).field_openId);
                    AppMethodBeat.o(32060);
                    return;
                  }
                }
                paramAdapterView = p.C(getContext(), paramView.appId, "message");
                paramView = new Intent();
                paramView.putExtra("rawUrl", paramAdapterView);
                com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                label2058:
                AppMethodBeat.o(32060);
                return;
              }
              if (!this.kFs)
              {
                com.tencent.mm.ui.base.t.ii(getContext());
                AppMethodBeat.o(32060);
                return;
              }
              paramAdapterView = new Intent();
              paramAdapterView.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramAdapterView.putExtra("app_msg_id", localbi.field_msgId);
              startActivityForResult(paramAdapterView, 210);
            }
          }
        }
        AppMethodBeat.o(32060);
        return;
      }
      int i;
      if ((localbi.byj()) || (localbi.dvX()) || (localbi.byk()) || (localbi.dxV()))
      {
        if ((paramAdapterView == null) || (bo.isNullOrNil(paramAdapterView.fiO)))
        {
          i = 0;
          if (i != 0) {
            AppMethodBeat.o(32060);
          }
        }
        else
        {
          localObject1 = localbi.field_imgPath;
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("KFromTimeLine", false);
          ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.fiO);
          ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.fiT);
          ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
          ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localbi.field_msgId);
          ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.fiP);
          ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.fiS);
          ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.fiR);
          ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
          localObject2 = localbi.field_talker;
          bool = com.tencent.mm.model.t.lA((String)localObject2);
          if (bool)
          {
            localObject1 = bf.pu(localbi.field_content);
            label2369:
            ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.fiU);
            ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.fiV);
            ((Intent)localObject3).putExtra("KSta_SourceType", 1);
            if (!bool) {
              break label2555;
            }
            i = a.b.zvi.value;
            label2418:
            ((Intent)localObject3).putExtra("KSta_Scene", i);
            ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
            ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
            ((Intent)localObject3).putExtra("KSta_MsgId", localbi.field_msgSvrId);
            ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.cGU);
            if (bool) {
              ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", n.nv((String)localObject2));
            }
            if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRW, 0) <= 0) {
              break label2566;
            }
            com.tencent.mm.bq.d.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
            ab.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
          }
          for (;;)
          {
            i = 1;
            break;
            localObject1 = localObject2;
            break label2369;
            label2555:
            i = a.b.zvh.value;
            break label2418;
            label2566:
            com.tencent.mm.bq.d.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
          }
        }
        ao(paramView, paramInt);
        AppMethodBeat.o(32060);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 15))
      {
        localObject1 = paramAdapterView.fhf;
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().KA(paramAdapterView.url);
        }
        if (TextUtils.isEmpty(paramView))
        {
          paramView = new Intent();
          paramView.putExtra("geta8key_username", r.Zn());
          paramView.putExtra("rawUrl", paramAdapterView.url);
          com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          AppMethodBeat.o(32060);
          return;
        }
        ab.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("extra_id", paramView);
        paramAdapterView.putExtra("preceding_scence", 123);
        paramAdapterView.putExtra("download_entrance_scene", 23);
        com.tencent.mm.bq.d.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
        com.tencent.mm.plugin.report.service.h.qsU.e(10993, new Object[] { Integer.valueOf(2), paramView });
        AppMethodBeat.o(32060);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 26))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.fiM;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", bz(localbi));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.dGR);
          ((Intent)localObject4).putExtra("topic_id", paramInt);
          ((Intent)localObject4).putExtra("topic_name", paramView);
          ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
          ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
          ((Intent)localObject4).putExtra("extra_scence", 23);
          com.tencent.mm.bq.d.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
          AppMethodBeat.o(32060);
          return;
        }
        ab.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        AppMethodBeat.o(32060);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 27))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.fiM;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        i = paramAdapterView.pageType;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", bz(localbi));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.dGR);
          ((Intent)localObject4).putExtra("set_id", paramInt);
          ((Intent)localObject4).putExtra("set_title", paramView);
          ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
          ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("headurl", (String)localObject3);
          ((Intent)localObject4).putExtra("pageType", i);
          com.tencent.mm.bq.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
          AppMethodBeat.o(32060);
          return;
        }
        ab.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        AppMethodBeat.o(32060);
        return;
      }
      ab.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localbi.field_talker, Long.valueOf(localbi.field_msgId), Integer.valueOf(localbi.getType()), localbi.field_content });
      if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")) && (paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
      {
        localObject1 = paramAdapterView.url;
        if (!com.tencent.mm.model.t.lA(this.talker)) {
          break label3707;
        }
        paramView = "groupmessage";
        localObject3 = p.H((String)localObject1, paramView);
        paramView = paramAdapterView.url;
        localObject2 = getPackageInfo(getContext(), paramAdapterView.appId);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
        ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
        if ((paramAdapterView.appId != null) && (("wx751a1acca5688ba3".equals(paramAdapterView.appId)) || ("wxfbc915ff7c30e335".equals(paramAdapterView.appId)) || ("wx482a4001c37e2b74".equals(paramAdapterView.appId))))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("jsapi_args_appid", paramAdapterView.appId);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject3);
        }
        if (bo.isNullOrNil(paramView)) {
          break label3714;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        label3440:
        if (localObject2 != null) {
          break label3730;
        }
        paramView = null;
        label3447:
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3739;
        }
      }
      label3714:
      label3730:
      label3739:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!bo.isNullOrNil(paramAdapterView.cGN))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.cGN);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.cGO);
        }
        ((Intent)localObject1).putExtra("msg_id", localbi.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbi.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", r.Zn());
        ((Intent)localObject1).putExtra("pre_username", bz(localbi));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbi.field_msgSvrId));
        paramAdapterView = bz(localbi);
        paramView = r.Zn();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", u.ah(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        AppMethodBeat.o(32060);
        return;
        label3707:
        paramView = "singlemessage";
        break;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3440;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3447;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(32069);
    if (paramMenuItem.getTitle().equals(getString(2131300278)))
    {
      h.a.dKg().clear();
      byh();
    }
    for (;;)
    {
      AppMethodBeat.o(32069);
      return false;
      byi();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(32055);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    Qc(1);
    AppMethodBeat.o(32055);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(32053);
    h.a.dKg().mCn.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(32053);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(32068);
    Object localObject1 = (d.a)this.zKE.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(32068);
      return true;
    }
    Object localObject2 = ((d.a)localObject1).mCy.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(32068);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((d.a)localObject1).mCy.getMeasuredWidth();
    int j = ((d.a)localObject1).mCy.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(32068);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((d.a)localObject1).mCA.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((d.a)localObject1).mCA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((d.a)localObject1).mCA;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.zKN = ((View)localObject1);
      this.handler.postDelayed(new ImageGalleryGridUI.7(this, (View)localObject1, (TimeInterpolator)localObject2), 700L);
    }
    AppMethodBeat.o(32068);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(32052);
    h.a.dKg().a(this);
    this.mIsPause = false;
    if (this.mBY)
    {
      if (!h.a.dKg().mCm) {
        break label143;
      }
      byh();
    }
    for (;;)
    {
      this.handler.postDelayed(this.zKK, 300L);
      super.onResume();
      if (this.zKD != null)
      {
        this.zKD.zKv = true;
        d locald = this.zKD;
        if (locald.zKv) {
          locald.notifyDataSetChanged();
        }
        if (h.a.dKg().mCm) {
          setMMTitle(getString(2131300316, new Object[] { Integer.valueOf(h.a.dKg().mCl.size()) }));
        }
      }
      this.mBY = false;
      dKc();
      AppMethodBeat.o(32052);
      return;
      label143:
      byi();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */