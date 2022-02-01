package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.app.Activity;
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
import android.view.ViewPropertyAnimator;
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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.z;
import com.tencent.mm.ah.z.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.qs.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aib;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.chatting.k;
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
  implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, z, h.b
{
  private long HZR;
  public int IaR;
  c IaS;
  private WeakReference<c.a> IaT;
  private Boolean IaU;
  private Boolean IaV;
  private TextView IaW;
  private TextView IaX;
  private Runnable IaY;
  private Runnable IaZ;
  Runnable Iba;
  public View Ibb;
  private View Ibc;
  private int Ibd;
  private View Ibe;
  private View Ibf;
  private View Ibg;
  private View Ibh;
  protected ao handler;
  private boolean mIsPause;
  public long nxq;
  private com.tencent.mm.sdk.b.c opH;
  private boolean opt;
  public boolean qKh;
  private boolean qSk;
  private String talker;
  private Animation xEv;
  private GridView yIZ;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(35964);
    this.IaY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35950);
        if ((ImageGalleryGridUI.a(ImageGalleryGridUI.this) != null) && (ImageGalleryGridUI.a(ImageGalleryGridUI.this).getVisibility() != 4)) {
          ImageGalleryGridUI.a(ImageGalleryGridUI.this).setVisibility(4);
        }
        AppMethodBeat.o(35950);
      }
    };
    this.IaZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35952);
        if ((ImageGalleryGridUI.a(ImageGalleryGridUI.this) != null) && (ImageGalleryGridUI.a(ImageGalleryGridUI.this).getVisibility() != 0)) {
          ImageGalleryGridUI.a(ImageGalleryGridUI.this).setVisibility(0);
        }
        AppMethodBeat.o(35952);
      }
    };
    this.opH = new com.tencent.mm.sdk.b.c() {};
    this.qSk = false;
    this.opt = false;
    this.HZR = 0L;
    this.Iba = new Runnable()
    {
      @TargetApi(12)
      public final void run()
      {
        AppMethodBeat.i(35961);
        if (ImageGalleryGridUI.this.Ibb != null)
        {
          ImageGalleryGridUI.this.Ibb.setVisibility(8);
          ImageGalleryGridUI.this.Ibb = null;
        }
        AppMethodBeat.o(35961);
      }
    };
    this.Ibb = null;
    this.Ibd = -1;
    this.mIsPause = true;
    AppMethodBeat.o(35964);
  }
  
  private boolean a(bo parambo, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35976);
    if ((!parambo.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35976);
      return false;
    }
    ac.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    parambo = new Intent("android.intent.action.MAIN", null);
    parambo.addCategory("android.intent.category.LAUNCHER");
    parambo.addFlags(268435456);
    parambo.setClassName("com.tencent.mobileqq", aX(getContext(), "com.tencent.mobileqq"));
    parambo.putExtra("platformId", "wechat");
    az.ayM();
    paramg = com.tencent.mm.model.c.agA().get(9, null);
    int i;
    if ((paramg != null) && ((paramg instanceof Integer))) {
      i = ((Integer)paramg).intValue();
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramg = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int k = arrayOfByte.length;
        int j = 0;
        i = 0;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if (i >= paramg.length) {
            break;
          }
          paramg[i] = ((byte)(m ^ paramg[i]));
          j += 1;
          i += 1;
        }
        parambo.putExtra("tencent_gif", paramg);
        label287:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            parambo = new com.tencent.mm.hellhoundlib.b.a().ba(parambo);
            com.tencent.mm.hellhoundlib.a.a.a(this, parambo.aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)parambo.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35976);
            return true;
            paramg = paramg;
            ac.printErrStackTrace("MicroMsg.GalleryGridUI", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambo)
        {
          break label287;
        }
      }
    }
  }
  
  private void aD(View paramView, int paramInt)
  {
    AppMethodBeat.i(35982);
    if (this.IaS == null)
    {
      AppMethodBeat.o(35982);
      return;
    }
    ac.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.nxq);
    localIntent.putExtra("key_is_biz_chat", this.qKh);
    localIntent.putExtra("intent.key.with.footer", true);
    bo localbo = (bo)this.IaS.getItem(paramInt);
    if (localbo == null)
    {
      AppMethodBeat.o(35982);
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
    localIntent.putExtra("img_gallery_msg_id", localbo.field_msgId).putExtra("img_gallery_msg_svr_id", localbo.field_msgSvrId).putExtra("img_gallery_talker", localbo.field_talker).putExtra("img_gallery_chatroom_name", localbo.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      paramView = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(0, 0);
      AppMethodBeat.o(35982);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private static String aX(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35977);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label99;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35977);
    return paramContext;
  }
  
  @TargetApi(11)
  private void abv(int paramInt)
  {
    AppMethodBeat.i(35972);
    handleIntent(getIntent());
    setMMTitle(getString(2131755258));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35954);
        ImageGalleryGridUI.this.onBackPressed();
        AppMethodBeat.o(35954);
        return true;
      }
    });
    this.Ibc = findViewById(2131302456);
    Object localObject = findViewById(2131299762);
    this.Ibe = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131306059);
    this.Ibf = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131304281);
    this.Ibg = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131298954);
    this.Ibh = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.IaW = ((TextView)findViewById(2131296624));
    this.IaX = ((TextView)findViewById(2131296596));
    if (paramInt == 0)
    {
      this.yIZ = ((GridView)findViewById(2131300936));
      this.yIZ.setOnItemClickListener(this);
      this.yIZ.setNumColumns(3);
      localObject = new bo();
      if (this.qKh) {
        ((bo)localObject).oB(this.nxq);
      }
      this.IaS = new c(this, (bo)localObject, this.talker);
      if (this.IaS.getCount() == 0)
      {
        this.IaX.setVisibility(0);
        AppMethodBeat.o(35972);
        return;
      }
      this.IaX.setVisibility(8);
      this.yIZ.setAdapter(this.IaS);
      fpj();
    }
    for (;;)
    {
      this.yIZ.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable oqt;
        
        private void jv(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35957);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.oqt);
            if (ImageGalleryGridUI.b(ImageGalleryGridUI.this).getVisibility() != 0)
            {
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.getContext(), 2130772047);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).setVisibility(0);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).startAnimation(localAnimation);
              AppMethodBeat.o(35957);
            }
          }
          else
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.oqt);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.oqt, 256L);
          }
          AppMethodBeat.o(35957);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(35959);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (bo)paramAnonymousAbsListView.IaS.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.fsS().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            AppMethodBeat.o(35959);
            return;
            localObject = new Date(((dy)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(35958);
          if (1 == paramAnonymousInt) {
            jv(true);
          }
          for (;;)
          {
            o.aFB().cp(paramAnonymousInt);
            AppMethodBeat.o(35958);
            return;
            if (paramAnonymousInt == 0) {
              jv(false);
            }
          }
        }
      });
      AppMethodBeat.o(35972);
      return;
      if (this.IaS != null)
      {
        this.IaS.notifyDataSetChanged();
        fpj();
      }
    }
  }
  
  private void c(cs paramcs)
  {
    AppMethodBeat.i(35991);
    paramcs.dck.activity = this;
    paramcs.dck.dcq = 45;
    com.tencent.mm.sdk.b.a.GpY.l(paramcs);
    if ((paramcs.dcl.ret == -2) || (paramcs.dcl.ret > 0))
    {
      AppMethodBeat.o(35991);
      return;
    }
    if (paramcs.dcl.ret <= 0)
    {
      crs();
      if (14 != paramcs.dck.type)
      {
        ac.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(35991);
        return;
      }
      if (paramcs.dck.dcn == null)
      {
        ac.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(35991);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(11142, new Object[] { Integer.valueOf(paramcs.dck.dcn.EBY), Integer.valueOf(paramcs.dck.dcn.EBZ), Integer.valueOf(paramcs.dck.dcn.ECa), Integer.valueOf(paramcs.dck.dcn.sKb), Integer.valueOf(paramcs.dck.dcn.ECb), Integer.valueOf(paramcs.dck.dcn.ECc), Integer.valueOf(paramcs.dck.dcn.ECd), Integer.valueOf(paramcs.dck.dcn.fileCount), Integer.valueOf(paramcs.dck.dcn.ECe), Integer.valueOf(paramcs.dck.dcn.ECf), Integer.valueOf(paramcs.dck.dcn.ECg), Integer.valueOf(paramcs.dck.dcn.ECh), Integer.valueOf(paramcs.dck.dcn.ECi), Integer.valueOf(paramcs.dck.dcn.ECj), Integer.valueOf(paramcs.dck.dcn.ECk) });
    }
    AppMethodBeat.o(35991);
  }
  
  private String ca(bo parambo)
  {
    AppMethodBeat.i(35978);
    String str = bs.bG(this.talker, "");
    boolean bool = w.sQ(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(35978);
      return str;
    }
    if (bool)
    {
      parambo = bi.yl(parambo.field_content);
      if ((parambo == null) || (parambo.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(35978);
      return parambo;
      parambo = str;
    }
  }
  
  private void cb(bo parambo)
  {
    AppMethodBeat.i(35981);
    if (!fpk())
    {
      t.g(getContext(), null);
      AppMethodBeat.o(35981);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", parambo.field_msgId);
    parambo = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, parambo.aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)parambo.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35981);
  }
  
  private void crr()
  {
    AppMethodBeat.i(35985);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fpp().qSv.size()) }));
    h.a.fpp().qSw = true;
    if (this.IaS == null)
    {
      AppMethodBeat.o(35985);
      return;
    }
    if (this.xEv == null) {
      this.xEv = AnimationUtils.loadAnimation(this, 2130772108);
    }
    this.IaS.crr();
    this.Ibc.setVisibility(0);
    this.Ibc.startAnimation(this.xEv);
    this.Ibe.setEnabled(false);
    this.Ibf.setEnabled(false);
    this.Ibg.setEnabled(false);
    this.Ibh.setEnabled(false);
    this.Ibd = this.yIZ.getPaddingBottom();
    this.yIZ.setPadding(this.yIZ.getPaddingLeft(), this.yIZ.getPaddingTop(), this.yIZ.getPaddingRight(), com.tencent.mm.cc.a.au(getContext(), 2131165567));
    com.tencent.mm.plugin.report.service.h.wUl.f(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), this);
    AppMethodBeat.o(35985);
  }
  
  private void fpj()
  {
    AppMethodBeat.i(35973);
    int i = this.yIZ.getFirstVisiblePosition();
    int j = this.yIZ.getLastVisiblePosition();
    int k = this.IaR;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(35973);
      return;
    }
    this.yIZ.setSelection(k);
    AppMethodBeat.o(35973);
  }
  
  private boolean fpk()
  {
    AppMethodBeat.i(35980);
    long l1 = this.HZR;
    long l2 = System.currentTimeMillis();
    this.HZR = l2;
    if (l1 + 30000L < l2)
    {
      az.ayM();
      this.opt = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.opt;
    AppMethodBeat.o(35980);
    return bool;
  }
  
  private void fpl()
  {
    AppMethodBeat.i(35986);
    if ((!h.a.fpp().qSv.isEmpty()) && (h.a.fpp().qSw)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.Ibe.setEnabled(true);
      this.Ibf.setEnabled(true);
      this.Ibg.setEnabled(true);
      this.Ibh.setEnabled(true);
      AppMethodBeat.o(35986);
      return;
    }
    this.Ibe.setEnabled(false);
    this.Ibf.setEnabled(false);
    this.Ibg.setEnabled(false);
    this.Ibh.setEnabled(false);
    AppMethodBeat.o(35986);
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35979);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(35979);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.h.k(paramString, true, false);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(35979);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ac.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
      AppMethodBeat.o(35979);
    }
    return null;
  }
  
  private static void hQ(List<bo> paramList)
  {
    AppMethodBeat.i(35989);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bo localbo = (bo)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.HJl, a.d.HJq, localbo, 0);
    }
    AppMethodBeat.o(35989);
  }
  
  private static List<bo> hU(List<bo> paramList)
  {
    AppMethodBeat.i(35990);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bo localbo = (bo)paramList.next();
      if ((!b.bR(localbo)) && (!b.bS(localbo)) && (!b.bU(localbo))) {
        localArrayList.add(localbo);
      }
    }
    AppMethodBeat.o(35990);
    return localArrayList;
  }
  
  private void handleIntent(Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(35969);
    if (paramIntent.getIntExtra("kintent_intent_source", 0) == 1) {}
    for (;;)
    {
      this.IaU = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.IaR = paramIntent.getIntExtra("kintent_image_index", 0);
      this.qKh = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.nxq = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.IaV = Boolean.TRUE;
      AppMethodBeat.o(35969);
      return;
      bool = false;
    }
  }
  
  public final void a(z.a parama) {}
  
  public final boolean awt()
  {
    return true;
  }
  
  public final void b(z.a parama) {}
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35994);
    if (parama == z.a.hlI)
    {
      this.IaS.Xb();
      this.IaS.notifyDataSetChanged();
    }
    crs();
    AppMethodBeat.o(35994);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35993);
    if ((this.IaS != null) && (this.mIsPause)) {
      this.IaS.IaK = true;
    }
    fpl();
    AppMethodBeat.o(35993);
  }
  
  public final void crs()
  {
    AppMethodBeat.i(35987);
    h.a.fpp().qSw = false;
    setMMTitle(getString(2131755258));
    if (this.IaS == null)
    {
      AppMethodBeat.o(35987);
      return;
    }
    this.IaS.notifyDataSetChanged();
    if (this.Ibd >= 0) {
      this.yIZ.setPadding(this.yIZ.getPaddingLeft(), this.yIZ.getPaddingTop(), this.yIZ.getPaddingRight(), this.Ibd);
    }
    this.Ibc.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), this);
    AppMethodBeat.o(35987);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35974);
    super.finish();
    h.a.fpp().detach();
    AppMethodBeat.o(35974);
  }
  
  public final void fpm()
  {
    AppMethodBeat.i(35992);
    if ((this.IaS != null) && (this.mIsPause)) {
      this.IaS.IaK = true;
    }
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fpp().qSv.size()) }));
    fpl();
    AppMethodBeat.o(35992);
  }
  
  public boolean fromFullScreenActivity()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131494467;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(35971);
    if (h.a.fpp().qSw)
    {
      crs();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.IaU.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.IaR >= 0) {
      aD(null, this.IaR);
    }
    finish();
    AppMethodBeat.o(35971);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(35988);
    if (h.a.fpp().qSv.isEmpty())
    {
      AppMethodBeat.o(35988);
      return;
    }
    boolean bool = w.sQ(this.talker);
    Object localObject2 = h.a.fpp().qSv;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131298954)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((bo)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131757553), "", getString(2131758038), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35962);
          ac.i("MicroMsg.GalleryGridUI", "delete message");
          com.tencent.mm.ui.chatting.i.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.crs();
          AppMethodBeat.o(35962);
        }
      }, null);
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131299762)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 18L, 1L, true);
      final cs localcs = new cs();
      if (com.tencent.mm.pluginsdk.model.i.a(getContext(), localcs, this.talker, (List)localObject2, false))
      {
        c(localcs);
        hQ((List)localObject2);
        AppMethodBeat.o(35988);
        return;
      }
      if (((List)localObject2).size() > 1)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        if (localcs.dck.dcp >= 0)
        {
          paramView = getContext().getString(2131758899);
          if (localcs.dck.dcp < 0) {
            break label375;
          }
        }
        label375:
        for (localObject1 = getContext().getString(2131757560);; localObject1 = getContext().getString(2131761941))
        {
          com.tencent.mm.ui.base.h.d(localAppCompatActivity, paramView, "", (String)localObject1, getContext().getString(2131757558), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35963);
              if ((localcs.dck.type == 14) && (localcs.dck.dcm.nxC.size() == 0))
              {
                ImageGalleryGridUI.this.crs();
                AppMethodBeat.o(35963);
                return;
              }
              ImageGalleryGridUI.a(ImageGalleryGridUI.this, localcs);
              ImageGalleryGridUI.hV(this.gan);
              AppMethodBeat.o(35963);
            }
          }, null);
          AppMethodBeat.o(35988);
          return;
          paramView = getContext().getString(2131758898);
          break;
        }
      }
      com.tencent.mm.ui.base.h.l(getContext(), localcs.dck.dcp, 0);
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131306059)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 19L, 1L, true);
      k.a(this, (List)localObject2, bool, this.talker, this);
      crs();
      AppMethodBeat.o(35988);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11627, new Object[] { Integer.valueOf(3) });
    paramView = hU((List)localObject2);
    if (paramView.size() != ((List)localObject2).size())
    {
      com.tencent.mm.ui.base.h.a(getContext(), 2131759799, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35951);
          b.f(ImageGalleryGridUI.this.getContext(), paramView);
          ImageGalleryGridUI.this.crs();
          AppMethodBeat.o(35951);
        }
      }, null);
      AppMethodBeat.o(35988);
      return;
    }
    Object localObject1 = (bo)paramView.get(0);
    if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((bo)localObject1).cKN()))
    {
      localObject2 = ((dy)localObject1).field_content;
      paramView = null;
      if (localObject2 != null) {
        paramView = k.b.az((String)localObject2, ((dy)localObject1).field_reserved);
      }
      if ((paramView != null) && (paramView.type == 6)) {
        cb((bo)localObject1);
      }
      AppMethodBeat.o(35988);
      return;
    }
    b.f(this, (List)localObject2);
    crs();
    AppMethodBeat.o(35988);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35965);
    super.onCreate(paramBundle);
    this.qSk = true;
    this.handler = new ao();
    abv(0);
    com.tencent.mm.sdk.b.a.GpY.c(this.opH);
    AppMethodBeat.o(35965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35966);
    this.handler.removeCallbacks(this.IaZ);
    this.handler = null;
    o.aFB().cp(0);
    com.tencent.mm.sdk.b.a.GpY.d(this.opH);
    super.onDestroy();
    AppMethodBeat.o(35966);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35975);
    bo localbo = (bo)this.IaS.getItem(paramInt);
    paramAdapterView = localbo.field_content;
    if (paramAdapterView != null) {}
    for (paramAdapterView = k.b.az(paramAdapterView, localbo.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6))
      {
        cb(localbo);
        AppMethodBeat.o(35975);
        return;
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramAdapterView != null) && (paramAdapterView.type == 3))
      {
        localObject1 = com.tencent.mm.pluginsdk.model.app.q.P(paramAdapterView.url, "message");
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.P(paramAdapterView.hhE, "message");
        localObject3 = getPackageInfo(getContext(), paramAdapterView.appId);
        if (localObject3 == null)
        {
          paramView = null;
          if (localObject3 != null) {
            break label198;
          }
        }
        long l;
        label198:
        for (paramInt = 0;; paramInt = ((PackageInfo)localObject3).versionCode)
        {
          localObject3 = paramAdapterView.appId;
          paramLong = localbo.field_msgId;
          l = localbo.field_msgSvrId;
          if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
            break label207;
          }
          ac.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
          AppMethodBeat.o(35975);
          return;
          paramView = ((PackageInfo)localObject3).versionName;
          break;
        }
        label207:
        if (ax.isMobile(getContext()))
        {
          paramAdapterView = (AdapterView<?>)localObject1;
          if (localObject2 != null)
          {
            if (((String)localObject2).length() > 0) {
              break label490;
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
          paramAdapterView = ca(localbo);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
          if (localbo != null) {
            ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          }
          ((Intent)localObject1).putExtra("preChatName", this.talker);
          ((Intent)localObject1).putExtra("preChatTYPE", x.aE(paramAdapterView, this.talker));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(35975);
          return;
          if (localObject1 != null)
          {
            paramAdapterView = (AdapterView<?>)localObject1;
            if (((String)localObject1).length() > 0) {}
          }
          else
          {
            label490:
            paramAdapterView = (AdapterView<?>)localObject2;
          }
        }
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 5))
      {
        if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
        {
          localObject1 = paramAdapterView.url;
          if (!w.sQ(this.talker)) {
            break label967;
          }
          paramView = "groupmessage";
          localObject3 = com.tencent.mm.pluginsdk.model.app.q.P((String)localObject1, paramView);
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
          if (bs.isNullOrNil(paramView)) {
            break label974;
          }
          ((Intent)localObject1).putExtra("shortUrl", paramView);
          label702:
          if (localObject2 != null) {
            break label990;
          }
          paramView = null;
          label709:
          ((Intent)localObject1).putExtra("version_name", paramView);
          if (localObject2 != null) {
            break label999;
          }
        }
        label967:
        label974:
        label990:
        label999:
        for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
        {
          ((Intent)localObject1).putExtra("version_code", paramInt);
          if (!bs.isNullOrNil(paramAdapterView.dvl))
          {
            ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dvl);
            ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dvm);
          }
          ((Intent)localObject1).putExtra("msg_id", localbo.field_msgId);
          ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbo.field_msgSvrId));
          ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
          ((Intent)localObject1).putExtra("geta8key_username", this.talker);
          paramAdapterView = ca(localbo);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbo.field_msgSvrId));
          ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          ((Intent)localObject1).putExtra("preChatName", this.talker);
          ((Intent)localObject1).putExtra("preChatTYPE", x.aE(paramAdapterView, this.talker));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(35975);
          return;
          paramView = "singlemessage";
          break;
          ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
          break label702;
          paramView = ((PackageInfo)localObject2).versionName;
          break label709;
        }
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 19))
      {
        paramView = new Intent();
        paramView.putExtra("message_id", localbo.field_msgId);
        paramView.putExtra("record_xml", paramAdapterView.hij);
        com.tencent.mm.br.d.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 24))
      {
        paramView = new nz();
        paramView.dqu.context = getContext();
        paramView.dqu.msgId = localbo.field_msgId;
        paramView.dqu.dqv = paramAdapterView.hij;
        com.tencent.mm.sdk.b.a.GpY.l(paramView);
        AppMethodBeat.o(35975);
        return;
      }
      label1239:
      Object localObject4;
      label1296:
      boolean bool;
      if ((paramAdapterView != null) && (paramAdapterView.type == 7))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.k(paramAdapterView.appId, false, false);
        if (localObject2 != null)
        {
          localObject1 = this.talker;
          paramView = (View)localObject1;
          if (w.sQ((String)localObject1)) {
            paramView = bi.yl(localbo.field_content);
          }
          paramLong = localbo.field_msgSvrId;
          if ((localObject2 != null) && (com.tencent.mm.pluginsdk.model.app.q.t(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName)))
          {
            paramInt = 3;
            if (paramAdapterView.type != 2) {
              break label1632;
            }
            paramInt = 4;
            localObject3 = new qs();
            ((qs)localObject3).dtI.context = getContext();
            ((qs)localObject3).dtI.scene = 1;
            ((qs)localObject3).dtI.djj = paramAdapterView.appId;
            localObject4 = ((qs)localObject3).dtI;
            if (localObject2 != null) {
              break label1645;
            }
            localObject1 = null;
            ((qs.a)localObject4).packageName = ((String)localObject1);
            ((qs)localObject3).dtI.msgType = paramAdapterView.type;
            ((qs)localObject3).dtI.dng = paramView;
            ((qs)localObject3).dtI.dtJ = paramInt;
            ((qs)localObject3).dtI.mediaTagName = paramAdapterView.mediaTagName;
            ((qs)localObject3).dtI.dpl = paramLong;
            ((qs)localObject3).dtI.dtK = "";
            ((qs)localObject3).dtI.cYP = this.talker;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
            paramView = com.tencent.mm.plugin.game.api.b.a.cOr();
            if ((com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2)) || (paramView == null)) {
              break label1747;
            }
            if (bs.isNullOrNil(((y)localObject2).eqq)) {
              break label1655;
            }
            bool = r.bL(getContext(), ((y)localObject2).eqq);
            ac.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((y)localObject2).eqq, Boolean.valueOf(bool) });
            if (!bool) {
              break label1655;
            }
            paramInt = 1;
          }
          for (;;)
          {
            if (paramInt == 0)
            {
              if ((paramAdapterView.cZa == null) || (paramAdapterView.cZa.length() == 0))
              {
                paramView = localbo.field_content;
                paramAdapterView = paramView;
                if (localbo.field_isSend == 0)
                {
                  paramInt = localbo.field_isSend;
                  paramAdapterView = paramView;
                  if (!this.qKh)
                  {
                    paramAdapterView = paramView;
                    if (w.sQ(this.talker))
                    {
                      paramAdapterView = paramView;
                      if (paramView != null)
                      {
                        paramAdapterView = paramView;
                        if (paramInt == 0) {
                          paramAdapterView = bi.ym(paramView);
                        }
                      }
                    }
                  }
                }
                paramView = k.b.vA(paramAdapterView);
                localObject1 = com.tencent.mm.pluginsdk.model.app.h.k(paramView.appId, true, false);
                if ((localObject1 != null) && (com.tencent.mm.pluginsdk.model.app.q.t(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName)))
                {
                  if (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_status == 3)
                  {
                    ac.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
                    AppMethodBeat.o(35975);
                    return;
                    paramInt = 6;
                    break;
                    label1632:
                    if (paramAdapterView.type != 5) {
                      break label1239;
                    }
                    paramInt = 1;
                    break label1239;
                    label1645:
                    localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName;
                    break label1296;
                    label1655:
                    localObject1 = new hv();
                    ((hv)localObject1).diT.actionCode = 2;
                    ((hv)localObject1).diT.scene = 1;
                    ((hv)localObject1).diT.appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
                    ((hv)localObject1).diT.context = getContext();
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
                    new Intent();
                    getContext();
                    paramView.af(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId, 1, 1);
                    paramInt = 1;
                    continue;
                    label1747:
                    paramInt = 0;
                    continue;
                  }
                  if (!com.tencent.mm.pluginsdk.model.app.q.b(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                  {
                    ac.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName });
                    Toast.makeText(getContext(), getString(2131759894, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, null) }), 1).show();
                    AppMethodBeat.o(35975);
                    return;
                  }
                  if (a(localbo, (com.tencent.mm.pluginsdk.model.app.g)localObject1)) {
                    break label2056;
                  }
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.cZa != null) && (paramView.cZa.length() > 0))
                  {
                    paramAdapterView = ap.bEO().aGd(paramView.cZa);
                    if (paramAdapterView != null) {
                      break label2002;
                    }
                  }
                  label2002:
                  for (paramAdapterView = null;; paramAdapterView = paramAdapterView.field_fileFullPath)
                  {
                    ((WXAppExtendObject)localObject2).filePath = paramAdapterView;
                    paramAdapterView = new WXMediaMessage();
                    paramAdapterView.sdkVer = 637927424;
                    paramAdapterView.mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                    paramAdapterView.title = paramView.title;
                    paramAdapterView.description = paramView.description;
                    paramAdapterView.messageAction = paramView.messageAction;
                    paramAdapterView.messageExt = paramView.messageExt;
                    paramAdapterView.thumbData = com.tencent.mm.vfs.i.aU(o.aFx().Cl(localbo.field_imgPath), 0, -1);
                    new as(this).a(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramAdapterView, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_openId);
                    AppMethodBeat.o(35975);
                    return;
                  }
                }
                paramAdapterView = com.tencent.mm.pluginsdk.model.app.q.J(getContext(), paramView.appId, "message");
                paramView = new Intent();
                paramView.putExtra("rawUrl", paramAdapterView);
                com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                label2056:
                AppMethodBeat.o(35975);
                return;
              }
              if (!this.opt)
              {
                t.g(getContext(), null);
                AppMethodBeat.o(35975);
                return;
              }
              paramAdapterView = new Intent();
              paramAdapterView.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramAdapterView.putExtra("app_msg_id", localbo.field_msgId);
              startActivityForResult(paramAdapterView, 210);
            }
          }
        }
        AppMethodBeat.o(35975);
        return;
      }
      int i;
      if ((localbo.crt()) || (localbo.eZm()) || (localbo.crv()) || (localbo.fbG()))
      {
        if ((paramAdapterView == null) || (bs.isNullOrNil(paramAdapterView.hjV)))
        {
          i = 0;
          if (i != 0) {
            AppMethodBeat.o(35975);
          }
        }
        else
        {
          localObject1 = localbo.field_imgPath;
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("KFromTimeLine", false);
          ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.hjV);
          ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.hka);
          ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
          ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localbo.field_msgId);
          ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.hjW);
          ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.hjZ);
          ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.hjY);
          ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
          localObject2 = localbo.field_talker;
          bool = w.sQ((String)localObject2);
          if (bool)
          {
            localObject1 = bi.yl(localbo.field_content);
            label2368:
            ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.hkb);
            ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.hkc);
            ((Intent)localObject3).putExtra("KSta_SourceType", 1);
            if (!bool) {
              break label2553;
            }
            i = a.b.HJi.value;
            label2417:
            ((Intent)localObject3).putExtra("KSta_Scene", i);
            ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
            ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
            ((Intent)localObject3).putExtra("KSta_MsgId", localbo.field_msgSvrId);
            ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.dvs);
            if (bool) {
              ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.q.wb((String)localObject2));
            }
            if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pMG, 0) <= 0) {
              break label2564;
            }
            com.tencent.mm.br.d.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
            ac.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
          }
          for (;;)
          {
            i = 1;
            break;
            localObject1 = localObject2;
            break label2368;
            label2553:
            i = a.b.HJh.value;
            break label2417;
            label2564:
            com.tencent.mm.br.d.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
          }
        }
        aD(paramView, paramInt);
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 15))
      {
        localObject1 = paramAdapterView.him;
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XS(paramAdapterView.url);
        }
        if (TextUtils.isEmpty(paramView))
        {
          paramView = new Intent();
          paramView.putExtra("geta8key_username", u.axw());
          paramView.putExtra("rawUrl", paramAdapterView.url);
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          AppMethodBeat.o(35975);
          return;
        }
        ac.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("extra_id", paramView);
        paramAdapterView.putExtra("preceding_scence", 123);
        paramAdapterView.putExtra("download_entrance_scene", 23);
        com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
        com.tencent.mm.plugin.report.service.h.wUl.f(10993, new Object[] { Integer.valueOf(2), paramView });
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 26))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.hjT;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", ca(localbo));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.eSb);
          ((Intent)localObject4).putExtra("topic_id", paramInt);
          ((Intent)localObject4).putExtra("topic_name", paramView);
          ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
          ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
          ((Intent)localObject4).putExtra("extra_scence", 23);
          com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
          AppMethodBeat.o(35975);
          return;
        }
        ac.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 27))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.hjT;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        i = paramAdapterView.pageType;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", ca(localbo));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.eSb);
          ((Intent)localObject4).putExtra("set_id", paramInt);
          ((Intent)localObject4).putExtra("set_title", paramView);
          ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
          ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("headurl", (String)localObject3);
          ((Intent)localObject4).putExtra("pageType", i);
          com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
          AppMethodBeat.o(35975);
          return;
        }
        ac.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        AppMethodBeat.o(35975);
        return;
      }
      ac.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localbo.field_talker, Long.valueOf(localbo.field_msgId), Integer.valueOf(localbo.getType()), localbo.field_content });
      if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")) && (paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
      {
        localObject1 = paramAdapterView.url;
        if (!w.sQ(this.talker)) {
          break label3701;
        }
        paramView = "groupmessage";
        localObject3 = com.tencent.mm.pluginsdk.model.app.q.P((String)localObject1, paramView);
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
        if (bs.isNullOrNil(paramView)) {
          break label3708;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        label3434:
        if (localObject2 != null) {
          break label3724;
        }
        paramView = null;
        label3441:
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3733;
        }
      }
      label3724:
      label3733:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!bs.isNullOrNil(paramAdapterView.dvl))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dvl);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dvm);
        }
        ((Intent)localObject1).putExtra("msg_id", localbo.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbo.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", u.axw());
        ((Intent)localObject1).putExtra("pre_username", ca(localbo));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbo.field_msgSvrId));
        paramAdapterView = ca(localbo);
        paramView = u.axw();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", x.aE(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        AppMethodBeat.o(35975);
        return;
        label3701:
        paramView = "singlemessage";
        break;
        label3708:
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3434;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3441;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35984);
    if (paramMenuItem.getTitle().equals(getString(2131759768)))
    {
      h.a.fpp().clear();
      crr();
    }
    for (;;)
    {
      AppMethodBeat.o(35984);
      return false;
      crs();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(35970);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    abv(1);
    AppMethodBeat.o(35970);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35968);
    h.a.fpp().qSx.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(35968);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(35983);
    Object localObject1 = (c.a)this.IaT.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(35983);
      return true;
    }
    Object localObject2 = ((c.a)localObject1).qSI.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(35983);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((c.a)localObject1).qSI.getMeasuredWidth();
    int j = ((c.a)localObject1).qSI.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((c.a)localObject1).qSK.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((c.a)localObject1).qSK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((c.a)localObject1).qSK;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.Ibb = ((View)localObject1);
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35960);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.Ibl.animate().setDuration(500L).alpha(0.0F).withEndAction(ImageGalleryGridUI.this.Iba).withLayer().setInterpolator(this.Ibm);
            AppMethodBeat.o(35960);
            return;
          }
          if (ImageGalleryGridUI.this.handler == null)
          {
            AppMethodBeat.o(35960);
            return;
          }
          this.Ibl.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.Ibm);
          ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.Iba, 500L);
          AppMethodBeat.o(35960);
        }
      }, 700L);
    }
    AppMethodBeat.o(35983);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(35967);
    h.a.fpp().a(this);
    this.mIsPause = false;
    if (this.qSk)
    {
      if (!h.a.fpp().qSw) {
        break label143;
      }
      crr();
    }
    for (;;)
    {
      this.handler.postDelayed(this.IaZ, 300L);
      super.onResume();
      if (this.IaS != null)
      {
        this.IaS.IaK = true;
        c localc = this.IaS;
        if (localc.IaK) {
          localc.notifyDataSetChanged();
        }
        if (h.a.fpp().qSw) {
          setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fpp().qSv.size()) }));
        }
      }
      this.qSk = false;
      fpl();
      AppMethodBeat.o(35967);
      return;
      label143:
      crs();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */