package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.gq;
import com.tencent.mm.h.a.lp;
import com.tencent.mm.h.a.nr;
import com.tencent.mm.h.a.nr.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.h.c.r;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.aj.a;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@com.tencent.mm.ui.base.a(19)
public class ImageGalleryGridUI
  extends MMActivity
  implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, aj, h.b
{
  protected ah handler;
  public long idK;
  private TextView kId;
  public boolean kax;
  private boolean khG = false;
  private boolean khk = false;
  private boolean mIsPause = true;
  private Animation ogs;
  private String talker;
  private com.tencent.mm.sdk.b.c vqD = new ImageGalleryGridUI.4(this);
  public int vuB;
  private GridView vuC;
  d vuD;
  private WeakReference<d.a> vuE;
  private Boolean vuF;
  private Boolean vuG;
  private TextView vuH;
  private Runnable vuI = new ImageGalleryGridUI.1(this);
  private Runnable vuJ = new ImageGalleryGridUI.3(this);
  private long vuK = 0L;
  Runnable vuL = new ImageGalleryGridUI.8(this);
  public View vuM = null;
  private View vuN;
  private int vuO = -1;
  private View vuP;
  private View vuQ;
  private View vuR;
  private View vuS;
  
  @TargetApi(11)
  private void Hv(int paramInt)
  {
    Object localObject = getIntent();
    if (((Intent)localObject).getIntExtra("kintent_intent_source", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vuF = Boolean.valueOf(bool);
      this.talker = ((Intent)localObject).getStringExtra("kintent_talker");
      this.vuB = ((Intent)localObject).getIntExtra("kintent_image_index", 0);
      this.kax = ((Intent)localObject).getBooleanExtra("key_is_biz_chat", false);
      this.idK = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.vuG = Boolean.valueOf(true);
      setMMTitle(getString(R.l.all_pictures));
      setBackBtn(new ImageGalleryGridUI.5(this));
      this.vuN = findViewById(R.h.more_bottom_root);
      localObject = findViewById(R.h.fav_btn);
      this.vuP = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      localObject = findViewById(R.h.trans_btn);
      this.vuQ = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      localObject = findViewById(R.h.save_btn);
      this.vuR = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      localObject = findViewById(R.h.del_btn);
      this.vuS = ((View)localObject);
      ((View)localObject).setOnClickListener(this);
      this.kId = ((TextView)findViewById(R.h.album_tips_bar));
      this.vuH = ((TextView)findViewById(R.h.album_no_img_tip));
      if (paramInt != 0) {
        break label354;
      }
      this.vuC = ((GridView)findViewById(R.h.image_gallery_grid));
      this.vuC.setOnItemClickListener(this);
      this.vuC.setNumColumns(3);
      localObject = new bi();
      if (this.kax) {
        ((bi)localObject).bh(this.idK);
      }
      this.vuD = new d(this, (bi)localObject, this.talker);
      if (this.vuD.getCount() != 0) {
        break;
      }
      this.vuH.setVisibility(0);
      return;
    }
    this.vuH.setVisibility(8);
    this.vuC.setAdapter(this.vuD);
    cFX();
    for (;;)
    {
      this.vuC.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable khx = new ImageGalleryGridUI.6.1(this);
        
        private void gc(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.khx);
            if (ImageGalleryGridUI.b(ImageGalleryGridUI.this).getVisibility() != 0)
            {
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.uMN, R.a.fast_faded_in);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).setVisibility(0);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).startAnimation(localAnimation);
            }
            return;
          }
          ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.khx);
          ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.khx, 256L);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (bi)paramAnonymousAbsListView.vuD.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.cIz().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            return;
            localObject = new Date(((cs)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          if (1 == paramAnonymousInt) {
            gc(true);
          }
          for (;;)
          {
            o.ON().bR(paramAnonymousInt);
            return;
            if (paramAnonymousInt == 0) {
              gc(false);
            }
          }
        }
      });
      return;
      label354:
      if (this.vuD != null)
      {
        this.vuD.notifyDataSetChanged();
        cFX();
      }
    }
  }
  
  private void V(View paramView, int paramInt)
  {
    if (this.vuD == null) {}
    Intent localIntent;
    bi localbi;
    do
    {
      return;
      localIntent = new Intent(this, ImageGalleryUI.class);
      localIntent.putExtra("key_biz_chat_id", this.idK);
      localIntent.putExtra("key_is_biz_chat", this.kax);
      localIntent.putExtra("intent.key.with.footer", true);
      localbi = (bi)this.vuD.getItem(paramInt);
    } while (localbi == null);
    int j = getResources().getConfiguration().orientation;
    int[] arrayOfInt = new int[2];
    int i;
    if (paramView != null)
    {
      i = paramView.getWidth();
      paramInt = paramView.getHeight();
      paramView.getLocationInWindow(arrayOfInt);
    }
    for (;;)
    {
      localIntent.addFlags(536870912);
      localIntent.putExtra("img_gallery_msg_id", localbi.field_msgId).putExtra("img_gallery_msg_svr_id", localbi.field_msgSvrId).putExtra("img_gallery_talker", localbi.field_talker).putExtra("img_gallery_chatroom_name", localbi.field_talker).putExtra("img_gallery_orientation", j);
      if (paramView != null) {
        localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
      }
      for (;;)
      {
        startActivity(localIntent);
        overridePendingTransition(0, 0);
        return;
        localIntent.putExtra("img_gallery_back_from_grid", true);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private boolean a(bi parambi, f paramf)
  {
    if ((!parambi.field_talker.endsWith("@qqim")) || (!paramf.field_packageName.equals("com.tencent.mobileqq"))) {
      return false;
    }
    y.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    parambi = new Intent("android.intent.action.MAIN", null);
    parambi.addCategory("android.intent.category.LAUNCHER");
    parambi.addFlags(268435456);
    parambi.setClassName("com.tencent.mobileqq", aF(this.mController.uMN, "com.tencent.mobileqq"));
    parambi.putExtra("platformId", "wechat");
    com.tencent.mm.model.au.Hx();
    paramf = com.tencent.mm.model.c.Dz().get(9, null);
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
        label223:
        i = 0;
      }
      catch (UnsupportedEncodingException paramf)
      {
        try
        {
          for (;;)
          {
            startActivity(parambi);
            return true;
            paramf = paramf;
            y.printErrStackTrace("MicroMsg.GalleryGridUI", paramf, "", new Object[0]);
          }
        }
        catch (Exception parambi)
        {
          break label223;
        }
      }
    }
  }
  
  private static String aF(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext != null)
      {
        paramContext = paramContext.activityInfo.name;
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  private void aRO()
  {
    setMMTitle(getString(R.l.gallery_selected_title, new Object[] { Integer.valueOf(h.a.cGc().khB.size()) }));
    h.a.cGc().khC = true;
    if (this.vuD == null) {
      return;
    }
    if (this.ogs == null) {
      this.ogs = AnimationUtils.loadAnimation(this, R.a.push_up_in);
    }
    d locald = this.vuD;
    locald.nHq = false;
    locald.notifyDataSetChanged();
    this.vuN.setVisibility(0);
    this.vuN.startAnimation(this.ogs);
    this.vuP.setEnabled(false);
    this.vuQ.setEnabled(false);
    this.vuR.setEnabled(false);
    this.vuS.setEnabled(false);
    this.vuO = this.vuC.getPaddingBottom();
    this.vuC.setPadding(this.vuC.getPaddingLeft(), this.vuC.getPaddingTop(), this.vuC.getPaddingRight(), com.tencent.mm.cb.a.aa(this.mController.uMN, R.f.SmallListHeight));
    com.tencent.mm.plugin.report.service.h.nFQ.f(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gallery_grid_cancel_selected_option), this);
  }
  
  private String bq(bi parambi)
  {
    String str = bk.aM(this.talker, "");
    boolean bool = com.tencent.mm.model.s.fn(this.talker);
    if (!bool) {
      return str;
    }
    if (bool)
    {
      parambi = bd.iI(parambi.field_content);
      if ((parambi == null) || (parambi.length() <= 0)) {}
    }
    for (;;)
    {
      return parambi;
      parambi = str;
    }
  }
  
  private void br(bi parambi)
  {
    long l1 = this.vuK;
    long l2 = System.currentTimeMillis();
    this.vuK = l2;
    if (l1 + 30000L < l2)
    {
      com.tencent.mm.model.au.Hx();
      this.khG = com.tencent.mm.model.c.isSDCardAvailable();
    }
    if (!this.khG)
    {
      com.tencent.mm.ui.base.s.gM(this.mController.uMN);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(this.mController.uMN, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", parambi.field_msgId);
    startActivity(localIntent);
  }
  
  private void c(cj paramcj)
  {
    paramcj.bIw.activity = this;
    paramcj.bIw.bID = 45;
    com.tencent.mm.sdk.b.a.udP.m(paramcj);
    if ((paramcj.bIx.ret == -2) || (paramcj.bIx.ret > 0)) {}
    while (paramcj.bIx.ret > 0) {
      return;
    }
    aRP();
    if (14 != paramcj.bIw.type)
    {
      y.d("MicroMsg.GalleryGridUI", "not record type, do not report");
      return;
    }
    if (paramcj.bIw.bIz == null)
    {
      y.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11142, new Object[] { Integer.valueOf(paramcj.bIw.bIz.sXr), Integer.valueOf(paramcj.bIw.bIz.sXs), Integer.valueOf(paramcj.bIw.bIz.sXt), Integer.valueOf(paramcj.bIw.bIz.sXu), Integer.valueOf(paramcj.bIw.bIz.sXv), Integer.valueOf(paramcj.bIw.bIz.sXw), Integer.valueOf(paramcj.bIw.bIz.sXx), Integer.valueOf(paramcj.bIw.bIz.sXy), Integer.valueOf(paramcj.bIw.bIz.sXz), Integer.valueOf(paramcj.bIw.bIz.sXA), Integer.valueOf(paramcj.bIw.bIz.sXB), Integer.valueOf(paramcj.bIw.bIz.sXC), Integer.valueOf(paramcj.bIw.bIz.sXD), Integer.valueOf(paramcj.bIw.bIz.sXE), Integer.valueOf(paramcj.bIw.bIz.sXF) });
  }
  
  private void cFX()
  {
    int i = this.vuC.getFirstVisiblePosition();
    int j = this.vuC.getLastVisiblePosition();
    int k = this.vuB;
    if ((k >= i) && (k <= j)) {
      return;
    }
    this.vuC.setSelection(k);
  }
  
  private void cFY()
  {
    if ((!h.a.cGc().khB.isEmpty()) && (h.a.cGc().khC)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.vuP.setEnabled(true);
      this.vuQ.setEnabled(true);
      this.vuR.setEnabled(true);
      this.vuS.setEnabled(true);
      return;
    }
    this.vuP.setEnabled(false);
    this.vuQ.setEnabled(false);
    this.vuR.setEnabled(false);
    this.vuS.setEnabled(false);
  }
  
  private static void dW(List<bi> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.vgo, a.d.vgt, localbi, 0);
    }
  }
  
  private static List<bi> dZ(List<bi> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bi localbi = (bi)paramList.next();
      if ((!c.bg(localbi)) && (!c.bh(localbi))) {
        localArrayList.add(localbi);
      }
    }
    return localArrayList;
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.by(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public final void a(aj.a parama) {}
  
  public final void aRP()
  {
    h.a.cGc().khC = false;
    setMMTitle(getString(R.l.all_pictures));
    if (this.vuD == null) {
      return;
    }
    this.vuD.notifyDataSetChanged();
    if (this.vuO >= 0) {
      this.vuC.setPadding(this.vuC.getPaddingLeft(), this.vuC.getPaddingTop(), this.vuC.getPaddingRight(), this.vuO);
    }
    this.vuN.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gallery_grid_selected_option), this);
  }
  
  public final void b(aj.a parama)
  {
    if (parama == aj.a.vmw)
    {
      this.vuD.yc();
      this.vuD.notifyDataSetChanged();
    }
    aRP();
  }
  
  public final void cDe() {}
  
  public final boolean cDf()
  {
    return true;
  }
  
  public final void cFZ()
  {
    if ((this.vuD != null) && (this.mIsPause)) {
      this.vuD.vuu = true;
    }
    setMMTitle(getString(R.l.gallery_selected_title, new Object[] { Integer.valueOf(h.a.cGc().khB.size()) }));
    cFY();
  }
  
  public final void clear()
  {
    if ((this.vuD != null) && (this.mIsPause)) {
      this.vuD.vuu = true;
    }
    cFY();
  }
  
  protected final boolean czg()
  {
    return true;
  }
  
  public void finish()
  {
    super.finish();
    h.a.cGc().detach();
  }
  
  protected final int getLayoutId()
  {
    return R.i.image_gallery_grid;
  }
  
  public void onBackPressed()
  {
    if (h.a.cGc().khC)
    {
      aRP();
      return;
    }
    if (this.vuF.booleanValue())
    {
      super.onBackPressed();
      return;
    }
    if (this.vuB >= 0) {
      V(null, this.vuB);
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    if (h.a.cGc().khB.isEmpty()) {}
    Object localObject2;
    Object localObject1;
    label357:
    do
    {
      boolean bool;
      do
      {
        return;
        bool = com.tencent.mm.model.s.fn(this.talker);
        localObject2 = h.a.cGc().khB;
      } while ((localObject2 == null) || (((List)localObject2).isEmpty()));
      if (paramView.getId() == R.h.del_btn)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11627, new Object[] { Integer.valueOf(5) });
        paramView = new TreeSet();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramView.add(Long.valueOf(((bi)((Iterator)localObject1).next()).field_msgId));
        }
        com.tencent.mm.ui.base.h.a(this, getString(R.l.confirm_delete), "", getString(R.l.delete_message), getString(R.l.app_cancel), new ImageGalleryGridUI.9(this, paramView), null);
        return;
      }
      if (paramView.getId() == R.h.fav_btn)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 18L, 1L, true);
        final cj localcj = new cj();
        if (com.tencent.mm.pluginsdk.model.g.a(this.mController.uMN, localcj, this.talker, (List)localObject2, false, false))
        {
          c(localcj);
          dW((List)localObject2);
          return;
        }
        if (((List)localObject2).size() > 1)
        {
          AppCompatActivity localAppCompatActivity = this.mController.uMN;
          if (localcj.bIw.bIC >= 0)
          {
            paramView = this.mController.uMN.getString(R.l.favorite_fail_recordtype_error);
            if (localcj.bIw.bIC < 0) {
              break label357;
            }
          }
          for (localObject1 = this.mController.uMN.getString(R.l.confirm_dialog_ok);; localObject1 = this.mController.uMN.getString(R.l.plugin_favorite_opt))
          {
            com.tencent.mm.ui.base.h.a(localAppCompatActivity, paramView, "", (String)localObject1, this.mController.uMN.getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                if ((localcj.bIw.type == 14) && (localcj.bIw.bIy.sXc.size() == 0))
                {
                  ImageGalleryGridUI.this.aRP();
                  return;
                }
                ImageGalleryGridUI.a(ImageGalleryGridUI.this, localcj);
                ImageGalleryGridUI.ea(this.gFL);
              }
            }, null);
            return;
            paramView = this.mController.uMN.getString(R.l.favorite_fail_record_expired_bigfile);
            break;
          }
        }
        com.tencent.mm.ui.base.h.h(this.mController.uMN, localcj.bIw.bIC, 0);
        return;
      }
      if (paramView.getId() == R.h.trans_btn)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 19L, 1L, true);
        l.a(this, (List)localObject2, bool, this.talker, this);
        aRP();
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11627, new Object[] { Integer.valueOf(3) });
      paramView = dZ((List)localObject2);
      if (paramView.size() != ((List)localObject2).size())
      {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, R.l.gallery_save_sight_tips, R.l.app_tip, new ImageGalleryGridUI.2(this, paramView), null);
        return;
      }
      localObject1 = (bi)paramView.get(0);
      if ((((List)localObject2).size() != 1) || (localObject1 == null) || (!((bi)localObject1).aVK())) {
        break;
      }
      localObject2 = ((cs)localObject1).field_content;
      paramView = null;
      if (localObject2 != null) {
        paramView = g.a.M((String)localObject2, ((cs)localObject1).field_reserved);
      }
    } while ((paramView == null) || (paramView.type != 6));
    br((bi)localObject1);
    return;
    c.e(this, (List)localObject2);
    aRP();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.khk = true;
    this.handler = new ah();
    Hv(0);
    com.tencent.mm.sdk.b.a.udP.c(this.vqD);
  }
  
  protected void onDestroy()
  {
    this.handler.removeCallbacks(this.vuJ);
    this.handler = null;
    o.ON().bR(0);
    com.tencent.mm.sdk.b.a.udP.d(this.vqD);
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    bi localbi = (bi)this.vuD.getItem(paramInt);
    paramAdapterView = localbi.field_content;
    if (paramAdapterView != null) {}
    label184:
    label193:
    label1229:
    label2510:
    for (paramAdapterView = g.a.M(paramAdapterView, localbi.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6)) {
        br(localbi);
      }
      Object localObject2;
      Object localObject3;
      label476:
      label1630:
      label1640:
      label2165:
      do
      {
        Object localObject4;
        boolean bool;
        do
        {
          for (;;)
          {
            return;
            if ((paramAdapterView != null) && (paramAdapterView.type == 3))
            {
              localObject1 = p.u(paramAdapterView.url, "message");
              localObject2 = p.u(paramAdapterView.dQu, "message");
              localObject3 = getPackageInfo(this.mController.uMN, paramAdapterView.appId);
              if (localObject3 == null)
              {
                paramView = null;
                if (localObject3 != null) {
                  break label184;
                }
              }
              long l;
              for (paramInt = 0;; paramInt = ((PackageInfo)localObject3).versionCode)
              {
                localObject3 = paramAdapterView.appId;
                paramLong = localbi.field_msgId;
                l = localbi.field_msgSvrId;
                if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
                  break label193;
                }
                y.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                return;
                paramView = ((PackageInfo)localObject3).versionName;
                break;
              }
              if (aq.isMobile(this.mController.uMN))
              {
                paramAdapterView = (AdapterView<?>)localObject1;
                if (localObject2 != null)
                {
                  if (((String)localObject2).length() > 0) {
                    break label476;
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
                paramAdapterView = bq(localbi);
                ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
                ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
                if (localbi != null) {
                  ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
                }
                ((Intent)localObject1).putExtra("preChatName", this.talker);
                ((Intent)localObject1).putExtra("preChatTYPE", t.R(paramAdapterView, this.talker));
                ((Intent)localObject1).putExtra("preMsgIndex", 0);
                com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
                return;
                if (localObject1 != null)
                {
                  paramAdapterView = (AdapterView<?>)localObject1;
                  if (((String)localObject1).length() > 0) {}
                }
                else
                {
                  paramAdapterView = (AdapterView<?>)localObject2;
                }
              }
            }
            if ((paramAdapterView != null) && (paramAdapterView.type == 5))
            {
              if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
              {
                localObject1 = paramAdapterView.url;
                if (com.tencent.mm.model.s.fn(this.talker))
                {
                  paramView = "groupmessage";
                  localObject3 = p.u((String)localObject1, paramView);
                  paramView = paramAdapterView.url;
                  localObject2 = getPackageInfo(this.mController.uMN, paramAdapterView.appId);
                  localObject1 = new Intent();
                  ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
                  ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
                  if ((paramAdapterView.appId != null) && (("wx751a1acca5688ba3".equals(paramAdapterView.appId)) || ("wxfbc915ff7c30e335".equals(paramAdapterView.appId)) || ("wx482a4001c37e2b74".equals(paramAdapterView.appId))))
                  {
                    localObject3 = new Bundle();
                    ((Bundle)localObject3).putString("jsapi_args_appid", paramAdapterView.appId);
                    ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject3);
                  }
                  if (bk.bl(paramView)) {
                    break label960;
                  }
                  ((Intent)localObject1).putExtra("shortUrl", paramView);
                  if (localObject2 != null) {
                    break label976;
                  }
                  paramView = null;
                  ((Intent)localObject1).putExtra("version_name", paramView);
                  if (localObject2 != null) {
                    break label985;
                  }
                }
                for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
                {
                  ((Intent)localObject1).putExtra("version_code", paramInt);
                  if (!bk.bl(paramAdapterView.bYG))
                  {
                    ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.bYG);
                    ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.bYH);
                  }
                  ((Intent)localObject1).putExtra("msg_id", localbi.field_msgId);
                  ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbi.field_msgSvrId));
                  ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
                  ((Intent)localObject1).putExtra("geta8key_username", this.talker);
                  paramAdapterView = bq(localbi);
                  ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
                  ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbi.field_msgSvrId));
                  ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
                  ((Intent)localObject1).putExtra("preChatName", this.talker);
                  ((Intent)localObject1).putExtra("preChatTYPE", t.R(paramAdapterView, this.talker));
                  ((Intent)localObject1).putExtra("preMsgIndex", 0);
                  com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
                  return;
                  paramView = "singlemessage";
                  break;
                  ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
                  break label691;
                  paramView = ((PackageInfo)localObject2).versionName;
                  break label698;
                }
              }
            }
            else
            {
              if ((paramAdapterView != null) && (paramAdapterView.type == 19))
              {
                paramView = new Intent();
                paramView.putExtra("message_id", localbi.field_msgId);
                paramView.putExtra("record_xml", paramAdapterView.dRd);
                com.tencent.mm.br.d.b(this.mController.uMN, "record", ".ui.RecordMsgDetailUI", paramView);
                return;
              }
              if ((paramAdapterView != null) && (paramAdapterView.type == 24))
              {
                paramView = new lp();
                paramView.bUG.context = this.mController.uMN;
                paramView.bUG.bIt = localbi.field_msgId;
                paramView.bUG.bUH = paramAdapterView.dRd;
                com.tencent.mm.sdk.b.a.udP.m(paramView);
                return;
              }
              if ((paramAdapterView == null) || (paramAdapterView.type != 7)) {
                break label2116;
              }
              localObject2 = com.tencent.mm.pluginsdk.model.app.g.by(paramAdapterView.appId, false);
              if ((localObject2 != null) && (((f)localObject2).ZH()))
              {
                localObject1 = this.talker;
                paramView = (View)localObject1;
                if (com.tencent.mm.model.s.fn((String)localObject1)) {
                  paramView = bd.iI(localbi.field_content);
                }
                paramLong = localbi.field_msgSvrId;
                if ((localObject2 != null) && (p.o(this.mController.uMN, ((f)localObject2).field_packageName)))
                {
                  paramInt = 3;
                  if (paramAdapterView.type != 2) {
                    break label1617;
                  }
                  paramInt = 4;
                  localObject3 = new nr();
                  ((nr)localObject3).bXp.context = this.mController.uMN;
                  ((nr)localObject3).bXp.scene = 1;
                  ((nr)localObject3).bXp.bOL = paramAdapterView.appId;
                  localObject4 = ((nr)localObject3).bXp;
                  if (localObject2 != null) {
                    break label1630;
                  }
                  localObject1 = null;
                  ((nr.a)localObject4).packageName = ((String)localObject1);
                  ((nr)localObject3).bXp.msgType = paramAdapterView.type;
                  ((nr)localObject3).bXp.bRO = paramView;
                  ((nr)localObject3).bXp.bXq = paramInt;
                  ((nr)localObject3).bXp.mediaTagName = paramAdapterView.mediaTagName;
                  ((nr)localObject3).bXp.bXr = paramLong;
                  ((nr)localObject3).bXp.bXs = "";
                  com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
                  paramView = a.a.aYi();
                  if ((com.tencent.mm.pluginsdk.model.app.g.a(this.mController.uMN, (f)localObject2)) || (paramView == null)) {
                    break label1739;
                  }
                  if (bk.bl(((r)localObject2).cvE)) {
                    break label1640;
                  }
                  bool = com.tencent.mm.pluginsdk.model.app.q.bk(this.mController.uMN, ((r)localObject2).cvE);
                  y.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((r)localObject2).cvE, Boolean.valueOf(bool) });
                  if (!bool) {
                    break label1640;
                  }
                  paramInt = 1;
                }
                for (;;)
                {
                  if (paramInt != 0) {
                    break label1742;
                  }
                  if ((paramAdapterView.bFE != null) && (paramAdapterView.bFE.length() != 0)) {
                    break label2053;
                  }
                  paramView = localbi.field_content;
                  paramAdapterView = paramView;
                  if (localbi.field_isSend == 0)
                  {
                    paramInt = localbi.field_isSend;
                    paramAdapterView = paramView;
                    if (!this.kax)
                    {
                      paramAdapterView = paramView;
                      if (com.tencent.mm.model.s.fn(this.talker))
                      {
                        paramAdapterView = paramView;
                        if (paramView != null)
                        {
                          paramAdapterView = paramView;
                          if (paramInt == 0) {
                            paramAdapterView = bd.iJ(paramView);
                          }
                        }
                      }
                    }
                  }
                  paramView = g.a.gp(paramAdapterView);
                  localObject1 = com.tencent.mm.pluginsdk.model.app.g.by(paramView.appId, true);
                  if ((localObject1 == null) || (!p.o(this.mController.uMN, ((f)localObject1).field_packageName))) {
                    break label2000;
                  }
                  if (((f)localObject1).field_status != 3) {
                    break label1744;
                  }
                  y.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((f)localObject1).field_packageName);
                  return;
                  paramInt = 6;
                  break;
                  if (paramAdapterView.type != 5) {
                    break label1229;
                  }
                  paramInt = 1;
                  break label1229;
                  localObject1 = ((f)localObject2).field_packageName;
                  break label1289;
                  localObject1 = new gq();
                  ((gq)localObject1).bOu.actionCode = 2;
                  ((gq)localObject1).bOu.scene = 1;
                  ((gq)localObject1).bOu.appId = ((f)localObject2).field_appId;
                  ((gq)localObject1).bOu.context = this.mController.uMN;
                  com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
                  new Intent();
                  localObject1 = this.mController.uMN;
                  paramView.S(((f)localObject2).field_appId, 1, 1);
                  paramInt = 1;
                  continue;
                  paramInt = 0;
                }
              }
            }
          }
          if (!p.b(this.mController.uMN, (f)localObject1))
          {
            y.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((f)localObject1).field_appName });
            Toast.makeText(this.mController.uMN, getString(R.l.game_launch_fail_alert, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(this.mController.uMN, (f)localObject1, null) }), 1).show();
            return;
          }
        } while (a(localbi, (f)localObject1));
        localObject2 = new WXAppExtendObject();
        ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
        if ((paramView.bFE != null) && (paramView.bFE.length() > 0))
        {
          paramAdapterView = ap.avh().VQ(paramView.bFE);
          if (paramAdapterView != null) {
            break label1992;
          }
        }
        for (paramAdapterView = null;; paramAdapterView = paramAdapterView.field_fileFullPath)
        {
          ((WXAppExtendObject)localObject2).filePath = paramAdapterView;
          paramAdapterView = new WXMediaMessage();
          paramAdapterView.sdkVer = 620824064;
          paramAdapterView.mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          paramAdapterView.title = paramView.title;
          paramAdapterView.description = paramView.description;
          paramAdapterView.messageAction = paramView.messageAction;
          paramAdapterView.messageExt = paramView.messageExt;
          paramAdapterView.thumbData = e.c(o.OJ().me(localbi.field_imgPath), 0, -1);
          new com.tencent.mm.ui.chatting.au(this).a(((f)localObject1).field_packageName, paramAdapterView, ((f)localObject1).field_appId, ((f)localObject1).field_openId);
          return;
        }
        paramAdapterView = p.v(this.mController.uMN, paramView.appId, "message");
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramAdapterView);
        com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
        return;
        if (!this.khG)
        {
          com.tencent.mm.ui.base.s.gM(this.mController.uMN);
          return;
        }
        paramAdapterView = new Intent();
        paramAdapterView.setClassName(this.mController.uMN, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
        paramAdapterView.putExtra("app_msg_id", localbi.field_msgId);
        startActivityForResult(paramAdapterView, 210);
        return;
        int i;
        if ((localbi.aRQ()) || (localbi.ctB()) || (localbi.aRR()) || (localbi.cvr()))
        {
          if ((paramAdapterView == null) || (bk.bl(paramAdapterView.dSP)))
          {
            i = 0;
            if (i == 0) {
              V(paramView, paramInt);
            }
          }
          else
          {
            localObject1 = localbi.field_imgPath;
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("IsAd", false);
            ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.dSP);
            ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.dSU);
            ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
            ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localbi.field_msgId);
            ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.dSQ);
            ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.dST);
            ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.dSS);
            ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
            localObject2 = localbi.field_talker;
            bool = com.tencent.mm.model.s.fn((String)localObject2);
            if (!bool) {
              break label2503;
            }
            localObject1 = bd.iI(localbi.field_content);
            ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.dSV);
            ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.dSW);
            ((Intent)localObject3).putExtra("KSta_SourceType", 1);
            if (!bool) {
              break label2510;
            }
          }
          for (i = a.b.vgl.value;; i = a.b.vgk.value)
          {
            ((Intent)localObject3).putExtra("KSta_Scene", i);
            ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
            ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
            ((Intent)localObject3).putExtra("KSta_MsgId", localbi.field_msgSvrId);
            ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.bYN);
            if (bool) {
              ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", m.gM((String)localObject2));
            }
            com.tencent.mm.br.d.b(this.mController.uMN, "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
            i = 1;
            break label2165;
            break;
            localObject1 = localObject2;
            break label2351;
          }
        }
        if ((paramAdapterView != null) && (paramAdapterView.type == 15))
        {
          localObject1 = paramAdapterView.dRg;
          paramView = (View)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Az(paramAdapterView.url);
          }
          if (TextUtils.isEmpty(paramView))
          {
            paramView = new Intent();
            paramView.putExtra("geta8key_username", com.tencent.mm.model.q.Gj());
            paramView.putExtra("rawUrl", paramAdapterView.url);
            com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
            return;
          }
          y.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
          paramAdapterView = new Intent();
          paramAdapterView.putExtra("extra_id", paramView);
          paramAdapterView.putExtra("preceding_scence", 123);
          paramAdapterView.putExtra("download_entrance_scene", 23);
          com.tencent.mm.br.d.b(this.mController.uMN, "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
          com.tencent.mm.plugin.report.service.h.nFQ.f(10993, new Object[] { Integer.valueOf(2), paramView });
          return;
        }
        if ((paramAdapterView != null) && (paramAdapterView.type == 26))
        {
          paramInt = paramAdapterView.tid;
          paramView = paramAdapterView.dSN;
          localObject1 = paramAdapterView.desc;
          localObject2 = paramAdapterView.iconUrl;
          localObject3 = paramAdapterView.secondUrl;
          i = paramAdapterView.pageType;
          if (paramInt != 0)
          {
            localObject4 = new Intent();
            ((Intent)localObject4).putExtra("geta8key_username", bq(localbi));
            ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.cQF);
            ((Intent)localObject4).putExtra("topic_id", paramInt);
            ((Intent)localObject4).putExtra("topic_name", paramView);
            ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
            ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
            ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
            ((Intent)localObject4).putExtra("extra_scence", 23);
            com.tencent.mm.br.d.b(this.mController.uMN, "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
            return;
          }
          y.i("MicroMsg.GalleryGridUI", "topic id is zero.");
          return;
        }
        if ((paramAdapterView != null) && (paramAdapterView.type == 27))
        {
          paramInt = paramAdapterView.tid;
          paramView = paramAdapterView.dSN;
          localObject1 = paramAdapterView.desc;
          localObject2 = paramAdapterView.iconUrl;
          localObject3 = paramAdapterView.secondUrl;
          i = paramAdapterView.pageType;
          if (paramInt != 0)
          {
            localObject4 = new Intent();
            ((Intent)localObject4).putExtra("geta8key_username", bq(localbi));
            ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.cQF);
            ((Intent)localObject4).putExtra("set_id", paramInt);
            ((Intent)localObject4).putExtra("set_title", paramView);
            ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
            ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
            ((Intent)localObject4).putExtra("headurl", (String)localObject3);
            ((Intent)localObject4).putExtra("pageType", i);
            com.tencent.mm.br.d.b(this.mController.uMN, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
            return;
          }
          y.i("MicroMsg.GalleryGridUI", "topic id is zero.");
          return;
        }
        y.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localbi.field_talker, Long.valueOf(localbi.field_msgId), Integer.valueOf(localbi.getType()), localbi.field_content });
      } while ((paramAdapterView.url == null) || (paramAdapterView.url.equals("")) || (paramAdapterView.url == null) || (paramAdapterView.url.equals("")));
      label976:
      label985:
      Object localObject1 = paramAdapterView.url;
      label1617:
      if (com.tencent.mm.model.s.fn(this.talker))
      {
        paramView = "groupmessage";
        localObject3 = p.u((String)localObject1, paramView);
        paramView = paramAdapterView.url;
        localObject2 = getPackageInfo(this.mController.uMN, paramAdapterView.appId);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
        ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
        if ((paramAdapterView.appId != null) && (("wx751a1acca5688ba3".equals(paramAdapterView.appId)) || ("wxfbc915ff7c30e335".equals(paramAdapterView.appId)) || ("wx482a4001c37e2b74".equals(paramAdapterView.appId))))
        {
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("jsapi_args_appid", paramAdapterView.appId);
          ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject3);
        }
        if (bk.bl(paramView)) {
          break label3620;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        if (localObject2 != null) {
          break label3636;
        }
        paramView = null;
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3645;
        }
      }
      label1742:
      label1744:
      label2000:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!bk.bl(paramAdapterView.bYG))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.bYG);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.bYH);
        }
        ((Intent)localObject1).putExtra("msg_id", localbi.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbi.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", com.tencent.mm.model.q.Gj());
        ((Intent)localObject1).putExtra("pre_username", bq(localbi));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbi.field_msgSvrId));
        paramAdapterView = bq(localbi);
        paramView = com.tencent.mm.model.q.Gj();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", t.R(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.br.d.b(this.mController.uMN, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        return;
        paramView = "singlemessage";
        break;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3349;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3356;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getTitle().equals(getString(R.l.gallery_grid_selected_option)))
    {
      h.a.cGc().clear();
      aRO();
    }
    for (;;)
    {
      return false;
      aRP();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    Hv(1);
  }
  
  protected void onPause()
  {
    h localh = h.a.cGc();
    if (this != null) {
      localh.khD.remove(this);
    }
    this.mIsPause = true;
    super.onPause();
  }
  
  public boolean onPreDraw()
  {
    Object localObject1 = (d.a)this.vuE.get();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      int i;
      int j;
      do
      {
        do
        {
          return true;
          localObject2 = ((d.a)localObject1).khQ.getViewTreeObserver();
        } while (!((ViewTreeObserver)localObject2).isAlive());
        ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
        i = ((d.a)localObject1).khQ.getMeasuredWidth();
        j = ((d.a)localObject1).khQ.getMeasuredHeight();
      } while ((i <= 0) || (j <= 0));
      localObject2 = (RelativeLayout.LayoutParams)((d.a)localObject1).khT.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = i;
      ((ViewGroup.LayoutParams)localObject2).height = j;
      ((d.a)localObject1).khT.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = ((d.a)localObject1).khT;
      localObject2 = new DecelerateInterpolator();
    } while (Build.VERSION.SDK_INT < 12);
    this.vuM = ((View)localObject1);
    this.handler.postDelayed(new ImageGalleryGridUI.7(this, (View)localObject1, (TimeInterpolator)localObject2), 700L);
    return true;
  }
  
  protected void onResume()
  {
    h.a.cGc().a(this);
    this.mIsPause = false;
    if (this.khk)
    {
      if (!h.a.cGc().khC) {
        break label131;
      }
      aRO();
    }
    for (;;)
    {
      this.handler.postDelayed(this.vuJ, 300L);
      super.onResume();
      if (this.vuD != null)
      {
        this.vuD.vuu = true;
        d locald = this.vuD;
        if (locald.vuu) {
          locald.notifyDataSetChanged();
        }
        if (h.a.cGc().khC) {
          setMMTitle(getString(R.l.gallery_selected_title, new Object[] { Integer.valueOf(h.a.cGc().khB.size()) }));
        }
      }
      this.khk = false;
      cFY();
      return;
      label131:
      aRP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */