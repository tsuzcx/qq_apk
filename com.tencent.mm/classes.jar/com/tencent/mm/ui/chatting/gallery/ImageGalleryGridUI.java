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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.px;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.f.a.sy.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.f.c.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.vfs.u;
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
  implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, com.tencent.mm.aj.z, l.b
{
  private long DlT;
  private Animation JtL;
  private GridView KOC;
  public int WRQ;
  g WRR;
  private WeakReference<g.a> WRS;
  private Boolean WRT;
  private Boolean WRU;
  private TextView WRV;
  private TextView WRW;
  private Runnable WRX;
  private Runnable WRY;
  Runnable WRZ;
  public View WSa;
  private View WSb;
  private int WSc;
  private View WSd;
  private View WSe;
  private View WSf;
  private View WSg;
  protected MMHandler handler;
  private boolean mIsPause;
  public long syu;
  private boolean tMW;
  private IListener tNl;
  private String talker;
  public boolean wIf;
  private boolean wQx;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(35964);
    this.WRX = new Runnable()
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
    this.WRY = new Runnable()
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
    this.tNl = new IListener() {};
    this.wQx = false;
    this.tMW = false;
    this.DlT = 0L;
    this.WRZ = new Runnable()
    {
      @TargetApi(12)
      public final void run()
      {
        AppMethodBeat.i(35961);
        if (ImageGalleryGridUI.this.WSa != null)
        {
          ImageGalleryGridUI.this.WSa.setVisibility(8);
          ImageGalleryGridUI.this.WSa = null;
        }
        AppMethodBeat.o(35961);
      }
    };
    this.WSa = null;
    this.WSc = -1;
    this.mIsPause = true;
    AppMethodBeat.o(35964);
  }
  
  private boolean a(ca paramca, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35976);
    if ((!paramca.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35976);
      return false;
    }
    Log.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    paramca = new Intent("android.intent.action.MAIN", null);
    paramca.addCategory("android.intent.category.LAUNCHER");
    paramca.addFlags(268435456);
    paramca.setClassName("com.tencent.mobileqq", bF(getContext(), "com.tencent.mobileqq"));
    paramca.putExtra("platformId", "wechat");
    bh.beI();
    paramg = com.tencent.mm.model.c.aHp().b(9, null);
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
        paramca.putExtra("tencent_gif", paramg);
        label287:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramca = new com.tencent.mm.hellhoundlib.b.a().bm(paramca);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramca.aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramca.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35976);
            return true;
            paramg = paramg;
            Log.printErrStackTrace("MicroMsg.GalleryGridUI", paramg, "", new Object[0]);
          }
        }
        catch (Exception paramca)
        {
          break label287;
        }
      }
    }
  }
  
  private void aP(View paramView, int paramInt)
  {
    AppMethodBeat.i(35982);
    if (this.WRR == null)
    {
      AppMethodBeat.o(35982);
      return;
    }
    Log.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.syu);
    localIntent.putExtra("key_is_biz_chat", this.wIf);
    localIntent.putExtra("intent.key.with.footer", true);
    ca localca = (ca)this.WRR.getItem(paramInt);
    if (localca == null)
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
    localIntent.putExtra("img_gallery_msg_id", localca.field_msgId).putExtra("img_gallery_msg_svr_id", localca.field_msgSvrId).putExtra("img_gallery_talker", localca.field_talker).putExtra("img_gallery_chatroom_name", localca.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(0, 0);
      AppMethodBeat.o(35982);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  @TargetApi(11)
  private void awc(int paramInt)
  {
    AppMethodBeat.i(35972);
    handleIntent(getIntent());
    setMMTitle(getString(R.l.eol));
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
    this.WSb = findViewById(R.h.dML);
    Object localObject = findViewById(R.h.dGF);
    this.WSd = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(R.h.trans_btn);
    this.WSe = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(R.h.save_btn);
    this.WSf = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(R.h.del_btn);
    this.WSg = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.WRV = ((TextView)findViewById(R.h.album_tips_bar));
    this.WRW = ((TextView)findViewById(R.h.dqK));
    if (paramInt == 0)
    {
      this.KOC = ((GridView)findViewById(R.h.dIJ));
      this.KOC.setOnItemClickListener(this);
      this.KOC.setNumColumns(3);
      localObject = new ca();
      if (this.wIf) {
        ((ca)localObject).EH(this.syu);
      }
      this.WRR = new g(this, (ca)localObject, this.talker);
      if (this.WRR.getCount() == 0)
      {
        this.WRW.setVisibility(0);
        AppMethodBeat.o(35972);
        return;
      }
      this.WRW.setVisibility(8);
      this.KOC.setAdapter(this.WRR);
      hRI();
    }
    for (;;)
    {
      this.KOC.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable tNY;
        
        private void lU(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35957);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.tNY);
            if (ImageGalleryGridUI.b(ImageGalleryGridUI.this).getVisibility() != 0)
            {
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.getContext(), R.a.fast_faded_in);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).setVisibility(0);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).startAnimation(localAnimation);
              AppMethodBeat.o(35957);
            }
          }
          else
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.tNY);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.tNY, 256L);
          }
          AppMethodBeat.o(35957);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(35959);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (ca)paramAnonymousAbsListView.WRR.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.hWZ().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            AppMethodBeat.o(35959);
            return;
            localObject = new Date(((et)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(35958);
          if (1 == paramAnonymousInt) {
            lU(true);
          }
          for (;;)
          {
            com.tencent.mm.ay.q.bml().onScrollStateChanged(paramAnonymousInt);
            AppMethodBeat.o(35958);
            return;
            if (paramAnonymousInt == 0) {
              lU(false);
            }
          }
        }
      });
      AppMethodBeat.o(35972);
      return;
      if (this.WRR != null)
      {
        this.WRR.notifyDataSetChanged();
        hRI();
      }
    }
  }
  
  private static String bF(Context paramContext, String paramString)
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
        Log.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35977);
    return paramContext;
  }
  
  private void c(dd paramdd)
  {
    AppMethodBeat.i(35991);
    paramdd.fyI.activity = this;
    paramdd.fyI.fyP = 45;
    EventCenter.instance.publish(paramdd);
    if ((paramdd.fyJ.ret == -2) || (paramdd.fyJ.ret > 0))
    {
      AppMethodBeat.o(35991);
      return;
    }
    if (paramdd.fyJ.ret <= 0)
    {
      dlQ();
      if (14 != paramdd.fyI.type)
      {
        Log.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(35991);
        return;
      }
      if (paramdd.fyI.fyL == null)
      {
        Log.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(35991);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(11142, new Object[] { Integer.valueOf(paramdd.fyI.fyL.SAQ), Integer.valueOf(paramdd.fyI.fyL.JCD), Integer.valueOf(paramdd.fyI.fyL.SAR), Integer.valueOf(paramdd.fyI.fyL.xzT), Integer.valueOf(paramdd.fyI.fyL.SAS), Integer.valueOf(paramdd.fyI.fyL.SAT), Integer.valueOf(paramdd.fyI.fyL.SAU), Integer.valueOf(paramdd.fyI.fyL.fileCount), Integer.valueOf(paramdd.fyI.fyL.SAV), Integer.valueOf(paramdd.fyI.fyL.SAW), Integer.valueOf(paramdd.fyI.fyL.SAX), Integer.valueOf(paramdd.fyI.fyL.SAY), Integer.valueOf(paramdd.fyI.fyL.SAZ), Integer.valueOf(paramdd.fyI.fyL.SBa), Integer.valueOf(paramdd.fyI.fyL.SBb) });
    }
    AppMethodBeat.o(35991);
  }
  
  private String cS(ca paramca)
  {
    AppMethodBeat.i(35978);
    String str = Util.nullAs(this.talker, "");
    boolean bool = ab.Lj(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(35978);
      return str;
    }
    if (bool)
    {
      paramca = bq.RL(paramca.field_content);
      if ((paramca == null) || (paramca.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(35978);
      return paramca;
      paramca = str;
    }
  }
  
  private void cT(ca paramca)
  {
    AppMethodBeat.i(35981);
    if (!hRJ())
    {
      w.g(getContext(), null);
      AppMethodBeat.o(35981);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", paramca.field_msgId);
    paramca = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramca.aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramca.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35981);
  }
  
  private void dlP()
  {
    AppMethodBeat.i(35985);
    setMMTitle(getString(R.l.eGb, new Object[] { Integer.valueOf(l.a.hRO().wQK.size()) }));
    l.a.hRO().wQL = true;
    if (this.WRR == null)
    {
      AppMethodBeat.o(35985);
      return;
    }
    if (this.JtL == null) {
      this.JtL = AnimationUtils.loadAnimation(this, R.a.push_up_in);
    }
    this.WRR.dlP();
    this.WSb.setVisibility(0);
    this.WSb.startAnimation(this.JtL);
    this.WSd.setEnabled(false);
    this.WSe.setEnabled(false);
    this.WSf.setEnabled(false);
    this.WSg.setEnabled(false);
    this.WSc = this.KOC.getPaddingBottom();
    this.KOC.setPadding(this.KOC.getPaddingLeft(), this.KOC.getPaddingTop(), this.KOC.getPaddingRight(), com.tencent.mm.ci.a.aY(getContext(), R.f.SmallListHeight));
    com.tencent.mm.plugin.report.service.h.IzE.a(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.eFW), this);
    AppMethodBeat.o(35985);
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.o(paramString, true, false);
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
      Log.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
      AppMethodBeat.o(35979);
    }
    return null;
  }
  
  private void hRI()
  {
    AppMethodBeat.i(35973);
    int i = this.KOC.getFirstVisiblePosition();
    int j = this.KOC.getLastVisiblePosition();
    int k = this.WRQ;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(35973);
      return;
    }
    this.KOC.setSelection(k);
    AppMethodBeat.o(35973);
  }
  
  private boolean hRJ()
  {
    AppMethodBeat.i(35980);
    long l1 = this.DlT;
    long l2 = System.currentTimeMillis();
    this.DlT = l2;
    if (l1 + 30000L < l2)
    {
      bh.beI();
      this.tMW = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.tMW;
    AppMethodBeat.o(35980);
    return bool;
  }
  
  private void hRK()
  {
    AppMethodBeat.i(35986);
    if ((!l.a.hRO().wQK.isEmpty()) && (l.a.hRO().wQL)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.WSd.setEnabled(true);
      this.WSe.setEnabled(true);
      this.WSf.setEnabled(true);
      this.WSg.setEnabled(true);
      AppMethodBeat.o(35986);
      return;
    }
    this.WSd.setEnabled(false);
    this.WSe.setEnabled(false);
    this.WSf.setEnabled(false);
    this.WSg.setEnabled(false);
    AppMethodBeat.o(35986);
  }
  
  private void handleIntent(Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(35969);
    if (paramIntent.getIntExtra("kintent_intent_source", 0) == 1) {}
    for (;;)
    {
      this.WRT = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.WRQ = paramIntent.getIntExtra("kintent_image_index", 0);
      this.wIf = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.syu = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.WRU = Boolean.TRUE;
      AppMethodBeat.o(35969);
      return;
      bool = false;
    }
  }
  
  private static void kg(List<ca> paramList)
  {
    AppMethodBeat.i(35989);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.Wwh, a.d.Wwm, localca, 0);
    }
    AppMethodBeat.o(35989);
  }
  
  private static List<ca> kl(List<ca> paramList)
  {
    AppMethodBeat.i(35990);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      if ((!f.cJ(localca)) && (!f.cK(localca)) && (!f.cM(localca))) {
        localArrayList.add(localca);
      }
    }
    AppMethodBeat.o(35990);
    return localArrayList;
  }
  
  public final void H(Bundle paramBundle) {}
  
  public final void a(z.a parama) {}
  
  public final void b(z.a parama) {}
  
  public final boolean bbA()
  {
    return true;
  }
  
  public final boolean bbB()
  {
    return false;
  }
  
  public final boolean bbC()
  {
    return false;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35994);
    if (parama == z.a.lqr)
    {
      this.WRR.atr();
      this.WRR.notifyDataSetChanged();
    }
    dlQ();
    AppMethodBeat.o(35994);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35993);
    if ((this.WRR != null) && (this.mIsPause)) {
      this.WRR.WRJ = true;
    }
    hRK();
    AppMethodBeat.o(35993);
  }
  
  public final void dlQ()
  {
    AppMethodBeat.i(35987);
    l.a.hRO().wQL = false;
    setMMTitle(getString(R.l.eol));
    if (this.WRR == null)
    {
      AppMethodBeat.o(35987);
      return;
    }
    this.WRR.notifyDataSetChanged();
    if (this.WSc >= 0) {
      this.KOC.setPadding(this.KOC.getPaddingLeft(), this.KOC.getPaddingTop(), this.KOC.getPaddingRight(), this.WSc);
    }
    this.WSb.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.eFX), this);
    AppMethodBeat.o(35987);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35974);
    super.finish();
    l.a.hRO().detach();
    AppMethodBeat.o(35974);
  }
  
  public boolean fromFullScreenActivity()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return R.i.dIJ;
  }
  
  public final void hRL()
  {
    AppMethodBeat.i(35992);
    if ((this.WRR != null) && (this.mIsPause)) {
      this.WRR.WRJ = true;
    }
    setMMTitle(getString(R.l.eGb, new Object[] { Integer.valueOf(l.a.hRO().wQK.size()) }));
    hRK();
    AppMethodBeat.o(35992);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(35971);
    if (l.a.hRO().wQL)
    {
      dlQ();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.WRT.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.WRQ >= 0) {
      aP(null, this.WRQ);
    }
    finish();
    AppMethodBeat.o(35971);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(35988);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if (l.a.hRO().wQK.isEmpty())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    boolean bool = ab.Lj(this.talker);
    Object localObject2 = l.a.hRO().wQK;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == R.h.del_btn)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((ca)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.c(this, getString(R.l.exL), "", getString(R.l.eBd), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35962);
          Log.i("MicroMsg.GalleryGridUI", "delete message");
          j.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.dlQ();
          AppMethodBeat.o(35962);
        }
      }, null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
      if (paramView.getId() == R.h.dGF)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 18L, 1L, true);
        final dd localdd = new dd();
        if (com.tencent.mm.pluginsdk.model.l.a(getContext(), localdd, this.talker, (List)localObject2, false))
        {
          c(localdd);
          kg((List)localObject2);
        }
        else
        {
          if (((List)localObject2).size() > 1)
          {
            AppCompatActivity localAppCompatActivity = getContext();
            if (localdd.fyI.fyO >= 0)
            {
              paramView = getContext().getString(R.l.favorite_fail_recordtype_error);
              label375:
              if (localdd.fyI.fyO < 0) {
                break label448;
              }
            }
            label448:
            for (localObject1 = getContext().getString(R.l.confirm_dialog_ok);; localObject1 = getContext().getString(R.l.plugin_favorite_opt))
            {
              com.tencent.mm.ui.base.h.c(localAppCompatActivity, paramView, "", (String)localObject1, getContext().getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(35963);
                  if ((localdd.fyI.type == 14) && (localdd.fyI.fyK.syG.size() == 0))
                  {
                    ImageGalleryGridUI.this.dlQ();
                    AppMethodBeat.o(35963);
                    return;
                  }
                  ImageGalleryGridUI.a(ImageGalleryGridUI.this, localdd);
                  ImageGalleryGridUI.km(this.pzd);
                  AppMethodBeat.o(35963);
                }
              }, null);
              break;
              paramView = getContext().getString(R.l.favorite_fail_record_expired_bigfile);
              break label375;
            }
          }
          com.tencent.mm.ui.base.h.p(getContext(), localdd.fyI.fyO, 0);
        }
      }
      else if (paramView.getId() == R.h.trans_btn)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 19L, 1L, true);
        com.tencent.mm.ui.chatting.l.a(this, (List)localObject2, bool, this.talker, this);
        dlQ();
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(11627, new Object[] { Integer.valueOf(3) });
        paramView = kl((List)localObject2);
        if (paramView.size() != ((List)localObject2).size())
        {
          com.tencent.mm.ui.base.h.a(getContext(), R.l.eFY, R.l.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35951);
              f.f(ImageGalleryGridUI.this.getContext(), paramView);
              ImageGalleryGridUI.this.dlQ();
              AppMethodBeat.o(35951);
            }
          }, null);
        }
        else
        {
          localObject1 = (ca)paramView.get(0);
          if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((ca)localObject1).erk()))
          {
            localObject2 = ((et)localObject1).field_content;
            paramView = null;
            if (localObject2 != null) {
              paramView = k.b.aG((String)localObject2, ((et)localObject1).field_reserved);
            }
            if ((paramView != null) && (paramView.type == 6)) {
              cT((ca)localObject1);
            }
          }
          else
          {
            f.f(this, (List)localObject2);
            dlQ();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35965);
    super.onCreate(paramBundle);
    this.wQx = true;
    this.handler = new MMHandler();
    awc(0);
    EventCenter.instance.addListener(this.tNl);
    AppMethodBeat.o(35965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35966);
    this.handler.removeCallbacks(this.WRY);
    this.handler = null;
    com.tencent.mm.ay.q.bml().onScrollStateChanged(0);
    EventCenter.instance.removeListener(this.tNl);
    super.onDestroy();
    AppMethodBeat.o(35966);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35975);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    ca localca = (ca)this.WRR.getItem(paramInt);
    paramAdapterView = localca.field_content;
    if (paramAdapterView != null) {}
    label265:
    label274:
    label1049:
    label1058:
    label3747:
    for (paramAdapterView = k.b.aG(paramAdapterView, localca.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6)) {
        cT(localca);
      }
      Object localObject2;
      Object localObject3;
      label192:
      label611:
      label765:
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35975);
          return;
          if ((paramAdapterView != null) && (paramAdapterView.type == 3))
          {
            localObject1 = com.tencent.mm.pluginsdk.model.app.q.V(paramAdapterView.url, "message");
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.V(paramAdapterView.llW, "message");
            localObject3 = getPackageInfo(getContext(), paramAdapterView.appId);
            if (localObject3 == null)
            {
              paramView = null;
              if (localObject3 != null) {
                break label265;
              }
            }
            long l;
            for (paramInt = 0;; paramInt = ((PackageInfo)localObject3).versionCode)
            {
              localObject3 = paramAdapterView.appId;
              paramLong = localca.field_msgId;
              l = localca.field_msgSvrId;
              if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
                break label274;
              }
              Log.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
              break;
              paramView = ((PackageInfo)localObject3).versionName;
              break label192;
            }
            if (NetStatusUtil.isMobile(getContext()))
            {
              paramAdapterView = (AdapterView<?>)localObject1;
              if (localObject2 != null)
              {
                if (((String)localObject2).length() > 0) {
                  break label553;
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
              paramAdapterView = cS(localca);
              ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
              ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
              if (localca != null) {
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
              }
              ((Intent)localObject1).putExtra("preChatName", this.talker);
              ((Intent)localObject1).putExtra("preChatTYPE", ac.aN(paramAdapterView, this.talker));
              ((Intent)localObject1).putExtra("preMsgIndex", 0);
              com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
              break;
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
              if (ab.Lj(this.talker))
              {
                paramView = "groupmessage";
                localObject3 = com.tencent.mm.pluginsdk.model.app.q.V((String)localObject1, paramView);
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
                if (Util.isNullOrNil(paramView)) {
                  break label1033;
                }
                ((Intent)localObject1).putExtra("shortUrl", paramView);
                if (localObject2 != null) {
                  break label1049;
                }
                paramView = null;
                ((Intent)localObject1).putExtra("version_name", paramView);
                if (localObject2 != null) {
                  break label1058;
                }
              }
              for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
              {
                ((Intent)localObject1).putExtra("version_code", paramInt);
                if (!Util.isNullOrNil(paramAdapterView.fUd))
                {
                  ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.fUd);
                  ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.fUe);
                }
                ((Intent)localObject1).putExtra("msg_id", localca.field_msgId);
                ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localca.field_msgSvrId));
                ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
                ((Intent)localObject1).putExtra("geta8key_username", this.talker);
                paramAdapterView = cS(localca);
                ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
                ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localca.field_msgSvrId));
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
                ((Intent)localObject1).putExtra("preChatName", this.talker);
                ((Intent)localObject1).putExtra("preChatTYPE", ac.aN(paramAdapterView, this.talker));
                ((Intent)localObject1).putExtra("preMsgIndex", 0);
                com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
                break;
                paramView = "singlemessage";
                break label611;
                ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
                break label765;
                paramView = ((PackageInfo)localObject2).versionName;
                break label772;
              }
            }
          }
          else if ((paramAdapterView != null) && (paramAdapterView.type == 19))
          {
            paramView = new Intent();
            paramView.putExtra("message_id", localca.field_msgId);
            paramView.putExtra("record_xml", paramAdapterView.lmA);
            com.tencent.mm.by.c.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
          }
          else if ((paramAdapterView != null) && (paramAdapterView.type == 24))
          {
            paramView = new px();
            paramView.fOD.context = getContext();
            paramView.fOD.msgId = localca.field_msgId;
            paramView.fOD.fOE = paramAdapterView.lmA;
            EventCenter.instance.publish(paramView);
          }
          else
          {
            Object localObject4;
            boolean bool;
            if ((paramAdapterView != null) && (paramAdapterView.type == 7))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.app.h.o(paramAdapterView.appId, false, false);
              if (localObject2 != null)
              {
                localObject1 = this.talker;
                paramView = (View)localObject1;
                if (ab.Lj((String)localObject1)) {
                  paramView = bq.RL(localca.field_content);
                }
                paramLong = localca.field_msgSvrId;
                if ((localObject2 != null) && (com.tencent.mm.pluginsdk.model.app.q.u(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName)))
                {
                  paramInt = 3;
                  if (paramAdapterView.type != 2) {
                    break label1679;
                  }
                  paramInt = 4;
                  localObject3 = new sy();
                  ((sy)localObject3).fSn.context = getContext();
                  ((sy)localObject3).fSn.scene = 1;
                  ((sy)localObject3).fSn.appid = paramAdapterView.appId;
                  localObject4 = ((sy)localObject3).fSn;
                  if (localObject2 != null) {
                    break label1692;
                  }
                  localObject1 = null;
                  ((sy.a)localObject4).packageName = ((String)localObject1);
                  ((sy)localObject3).fSn.msgType = paramAdapterView.type;
                  ((sy)localObject3).fSn.fLi = paramView;
                  ((sy)localObject3).fSn.fSo = paramInt;
                  ((sy)localObject3).fSn.mediaTagName = paramAdapterView.mediaTagName;
                  ((sy)localObject3).fSn.fNu = paramLong;
                  ((sy)localObject3).fSn.fSp = "";
                  ((sy)localObject3).fSn.fvd = this.talker;
                  EventCenter.instance.publish((IEvent)localObject3);
                  paramView = com.tencent.mm.plugin.game.api.b.a.evu();
                  if ((com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2)) || (paramView == null)) {
                    break label1794;
                  }
                  if (Util.isNullOrNil(((y)localObject2).hrJ)) {
                    break label1702;
                  }
                  bool = r.cw(getContext(), ((y)localObject2).hrJ);
                  Log.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((y)localObject2).hrJ, Boolean.valueOf(bool) });
                  if (!bool) {
                    break label1702;
                  }
                  paramInt = 1;
                }
                for (;;)
                {
                  if (paramInt != 0) {
                    break label1797;
                  }
                  if ((paramAdapterView.fvr != null) && (paramAdapterView.fvr.length() != 0)) {
                    break label2098;
                  }
                  paramView = localca.field_content;
                  paramAdapterView = paramView;
                  if (localca.field_isSend == 0)
                  {
                    paramInt = localca.field_isSend;
                    paramAdapterView = paramView;
                    if (!this.wIf)
                    {
                      paramAdapterView = paramView;
                      if (ab.Lj(this.talker))
                      {
                        paramAdapterView = paramView;
                        if (paramView != null)
                        {
                          paramAdapterView = paramView;
                          if (paramInt == 0) {
                            paramAdapterView = bq.RM(paramView);
                          }
                        }
                      }
                    }
                  }
                  paramView = k.b.OQ(paramAdapterView);
                  localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
                  if ((localObject1 == null) || (!com.tencent.mm.pluginsdk.model.app.q.u(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName))) {
                    break label2049;
                  }
                  if (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_status != 3) {
                    break label1799;
                  }
                  Log.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
                  break;
                  paramInt = 6;
                  break label1280;
                  if (paramAdapterView.type != 5) {
                    break label1290;
                  }
                  paramInt = 1;
                  break label1290;
                  localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName;
                  break label1347;
                  localObject1 = new ji();
                  ((ji)localObject1).fGD.actionCode = 2;
                  ((ji)localObject1).fGD.scene = 1;
                  ((ji)localObject1).fGD.appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
                  ((ji)localObject1).fGD.context = getContext();
                  EventCenter.instance.publish((IEvent)localObject1);
                  new Intent();
                  getContext();
                  paramView.ao(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId, 1, 1);
                  paramInt = 1;
                  continue;
                  paramInt = 0;
                }
                continue;
                if (!com.tencent.mm.pluginsdk.model.app.q.c(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                {
                  Log.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName });
                  Toast.makeText(getContext(), getString(R.l.game_launch_fail_alert, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, null) }), 1).show();
                }
                else if (!a(localca, (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                {
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.fvr != null) && (paramView.fvr.length() > 0))
                  {
                    paramAdapterView = com.tencent.mm.pluginsdk.model.app.ao.ctZ().bpR(paramView.fvr);
                    if (paramAdapterView != null) {
                      break label2041;
                    }
                  }
                  for (paramAdapterView = null;; paramAdapterView = paramAdapterView.field_fileFullPath)
                  {
                    ((WXAppExtendObject)localObject2).filePath = paramAdapterView;
                    paramAdapterView = new WXMediaMessage();
                    paramAdapterView.sdkVer = 637992960;
                    paramAdapterView.mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                    paramAdapterView.title = paramView.title;
                    paramAdapterView.description = paramView.description;
                    paramAdapterView.messageAction = paramView.messageAction;
                    paramAdapterView.messageExt = paramView.messageExt;
                    paramAdapterView.thumbData = u.aY(com.tencent.mm.ay.q.bmh().VW(localca.field_imgPath), 0, -1);
                    new au(this).a(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramAdapterView, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_openId);
                    break;
                  }
                  paramAdapterView = com.tencent.mm.pluginsdk.model.app.q.Z(getContext(), paramView.appId, "message");
                  paramView = new Intent();
                  paramView.putExtra("rawUrl", paramAdapterView);
                  com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                  continue;
                  if (!this.tMW)
                  {
                    w.g(getContext(), null);
                  }
                  else
                  {
                    paramAdapterView = new Intent();
                    paramAdapterView.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    paramAdapterView.putExtra("app_msg_id", localca.field_msgId);
                    startActivityForResult(paramAdapterView, 210);
                  }
                }
              }
            }
            else
            {
              int i;
              if ((localca.dlR()) || (localca.hwG()) || (localca.dlT()) || (localca.hzF()))
              {
                if ((paramAdapterView == null) || (Util.isNullOrNil(paramAdapterView.lor)))
                {
                  i = 0;
                  if (i != 0)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(35975);
                  }
                }
                else
                {
                  localObject1 = localca.field_imgPath;
                  localObject3 = new Intent();
                  ((Intent)localObject3).putExtra("KFromTimeLine", false);
                  ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.lor);
                  ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.low);
                  ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
                  ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localca.field_msgId);
                  ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.los);
                  ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.lov);
                  ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.lou);
                  ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
                  localObject2 = localca.field_talker;
                  bool = ab.Lj((String)localObject2);
                  if (bool)
                  {
                    localObject1 = bq.RL(localca.field_content);
                    ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.lox);
                    ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.loy);
                    ((Intent)localObject3).putExtra("KSta_SourceType", 1);
                    if (!bool) {
                      break label2596;
                    }
                    i = a.b.Wwe.value;
                    ((Intent)localObject3).putExtra("KSta_Scene", i);
                    ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
                    ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
                    ((Intent)localObject3).putExtra("KSta_MsgId", localca.field_msgSvrId);
                    ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.fUk);
                    if (bool) {
                      ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", v.Pu((String)localObject2));
                    }
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vuU, 0) <= 0) {
                      break label2607;
                    }
                    com.tencent.mm.by.c.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
                    Log.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    localObject1 = localObject2;
                    break label2411;
                    i = a.b.Wwd.value;
                    break label2460;
                    com.tencent.mm.by.c.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
                  }
                }
                aP(paramView, paramInt);
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 15))
              {
                localObject1 = paramAdapterView.lmD;
                paramView = (View)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auk(paramAdapterView.url);
                }
                if (TextUtils.isEmpty(paramView))
                {
                  paramView = new Intent();
                  paramView.putExtra("geta8key_username", com.tencent.mm.model.z.bcZ());
                  paramView.putExtra("rawUrl", paramAdapterView.url);
                  com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                }
                else
                {
                  Log.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                  paramAdapterView = new Intent();
                  paramAdapterView.putExtra("extra_id", paramView);
                  paramAdapterView.putExtra("preceding_scence", 123);
                  paramAdapterView.putExtra("download_entrance_scene", 23);
                  com.tencent.mm.by.c.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
                  com.tencent.mm.plugin.report.service.h.IzE.a(10993, new Object[] { Integer.valueOf(2), paramView });
                }
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 26))
              {
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.loo;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cS(localca));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.ilh);
                  ((Intent)localObject4).putExtra("topic_id", paramInt);
                  ((Intent)localObject4).putExtra("topic_name", paramView);
                  ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
                  ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
                  ((Intent)localObject4).putExtra("extra_scence", 23);
                  com.tencent.mm.by.c.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
                }
                else
                {
                  Log.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
              }
              else
              {
                if ((paramAdapterView == null) || (paramAdapterView.type != 27)) {
                  break;
                }
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.loo;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                i = paramAdapterView.pageType;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cS(localca));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.ilh);
                  ((Intent)localObject4).putExtra("set_id", paramInt);
                  ((Intent)localObject4).putExtra("set_title", paramView);
                  ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
                  ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("headurl", (String)localObject3);
                  ((Intent)localObject4).putExtra("pageType", i);
                  com.tencent.mm.by.c.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
                }
                else
                {
                  Log.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
              }
            }
          }
        }
        Log.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localca.field_talker, Long.valueOf(localca.field_msgId), Integer.valueOf(localca.getType()), Util.secPrint(localca.field_content) });
      } while ((paramAdapterView.url == null) || (paramAdapterView.url.equals("")) || (paramAdapterView.url == null) || (paramAdapterView.url.equals("")));
      label553:
      label1347:
      label2041:
      localObject1 = paramAdapterView.url;
      label1702:
      label2098:
      label2411:
      if (ab.Lj(this.talker))
      {
        paramView = "groupmessage";
        localObject3 = com.tencent.mm.pluginsdk.model.app.q.V((String)localObject1, paramView);
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
        if (Util.isNullOrNil(paramView)) {
          break label3722;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        label3452:
        if (localObject2 != null) {
          break label3738;
        }
        paramView = null;
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3747;
        }
      }
      label2596:
      label2607:
      label3298:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!Util.isNullOrNil(paramAdapterView.fUd))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.fUd);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.fUe);
        }
        ((Intent)localObject1).putExtra("msg_id", localca.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localca.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", com.tencent.mm.model.z.bcZ());
        ((Intent)localObject1).putExtra("pre_username", cS(localca));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localca.field_msgSvrId));
        paramAdapterView = cS(localca);
        paramView = com.tencent.mm.model.z.bcZ();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", ac.aN(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.by.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        break;
        paramView = "singlemessage";
        break label3298;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3452;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3459;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35984);
    if (paramMenuItem.getTitle().equals(getString(R.l.eFX)))
    {
      l.a.hRO().clear();
      dlP();
    }
    for (;;)
    {
      AppMethodBeat.o(35984);
      return false;
      dlQ();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(35970);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    awc(1);
    AppMethodBeat.o(35970);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35968);
    l.a.hRO().wQM.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(35968);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(35983);
    Object localObject1 = (g.a)this.WRS.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(35983);
      return true;
    }
    Object localObject2 = ((g.a)localObject1).wRg.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(35983);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((g.a)localObject1).wRg.getMeasuredWidth();
    int j = ((g.a)localObject1).wRg.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((g.a)localObject1).wRi.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((g.a)localObject1).wRi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((g.a)localObject1).wRi;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.WSa = ((View)localObject1);
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35960);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.WSk.animate().setDuration(500L).alpha(0.0F).withEndAction(ImageGalleryGridUI.this.WRZ).withLayer().setInterpolator(this.WSl);
            AppMethodBeat.o(35960);
            return;
          }
          if (ImageGalleryGridUI.this.handler == null)
          {
            AppMethodBeat.o(35960);
            return;
          }
          this.WSk.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.WSl);
          ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.WRZ, 500L);
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
    l.a.hRO().a(this);
    this.mIsPause = false;
    if (this.wQx)
    {
      if (!l.a.hRO().wQL) {
        break label143;
      }
      dlP();
    }
    for (;;)
    {
      this.handler.postDelayed(this.WRY, 300L);
      super.onResume();
      if (this.WRR != null)
      {
        this.WRR.WRJ = true;
        g localg = this.WRR;
        if (localg.WRJ) {
          localg.notifyDataSetChanged();
        }
        if (l.a.hRO().wQL) {
          setMMTitle(getString(R.l.eGb, new Object[] { Integer.valueOf(l.a.hRO().wQK.size()) }));
        }
      }
      this.wQx = false;
      hRK();
      AppMethodBeat.o(35967);
      return;
      label143:
      dlQ();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */