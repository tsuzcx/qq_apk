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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.g.a.rd.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
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
  private GridView Aat;
  private long JPg;
  public int JQi;
  c JQj;
  private WeakReference<c.a> JQk;
  private Boolean JQl;
  private Boolean JQm;
  private TextView JQn;
  private TextView JQo;
  private Runnable JQp;
  private Runnable JQq;
  Runnable JQr;
  public View JQs;
  private View JQt;
  private int JQu;
  private View JQv;
  private View JQw;
  private View JQx;
  private View JQy;
  protected ap handler;
  private boolean mIsPause;
  public long nYO;
  private boolean oSO;
  private com.tencent.mm.sdk.b.c oTc;
  private boolean rCk;
  public boolean ruj;
  private String talker;
  private Animation yTf;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(35964);
    this.JQp = new Runnable()
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
    this.JQq = new Runnable()
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
    this.oTc = new com.tencent.mm.sdk.b.c() {};
    this.rCk = false;
    this.oSO = false;
    this.JPg = 0L;
    this.JQr = new Runnable()
    {
      @TargetApi(12)
      public final void run()
      {
        AppMethodBeat.i(35961);
        if (ImageGalleryGridUI.this.JQs != null)
        {
          ImageGalleryGridUI.this.JQs.setVisibility(8);
          ImageGalleryGridUI.this.JQs = null;
        }
        AppMethodBeat.o(35961);
      }
    };
    this.JQs = null;
    this.JQu = -1;
    this.mIsPause = true;
    AppMethodBeat.o(35964);
  }
  
  private boolean a(bu parambu, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35976);
    if ((!parambu.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35976);
      return false;
    }
    ad.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    parambu = new Intent("android.intent.action.MAIN", null);
    parambu.addCategory("android.intent.category.LAUNCHER");
    parambu.addFlags(268435456);
    parambu.setClassName("com.tencent.mobileqq", ba(getContext(), "com.tencent.mobileqq"));
    parambu.putExtra("platformId", "wechat");
    ba.aBQ();
    paramg = com.tencent.mm.model.c.ajl().get(9, null);
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
        parambu.putExtra("tencent_gif", paramg);
        label287:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            parambu = new com.tencent.mm.hellhoundlib.b.a().bc(parambu);
            com.tencent.mm.hellhoundlib.a.a.a(this, parambu.ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)parambu.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35976);
            return true;
            paramg = paramg;
            ad.printErrStackTrace("MicroMsg.GalleryGridUI", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambu)
        {
          break label287;
        }
      }
    }
  }
  
  private void aF(View paramView, int paramInt)
  {
    AppMethodBeat.i(35982);
    if (this.JQj == null)
    {
      AppMethodBeat.o(35982);
      return;
    }
    ad.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.nYO);
    localIntent.putExtra("key_is_biz_chat", this.ruj);
    localIntent.putExtra("intent.key.with.footer", true);
    bu localbu = (bu)this.JQj.getItem(paramInt);
    if (localbu == null)
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
    localIntent.putExtra("img_gallery_msg_id", localbu.field_msgId).putExtra("img_gallery_msg_svr_id", localbu.field_msgSvrId).putExtra("img_gallery_talker", localbu.field_talker).putExtra("img_gallery_chatroom_name", localbu.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(0, 0);
      AppMethodBeat.o(35982);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  @TargetApi(11)
  private void adH(int paramInt)
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
    this.JQt = findViewById(2131302456);
    Object localObject = findViewById(2131299762);
    this.JQv = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131306059);
    this.JQw = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131304281);
    this.JQx = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131298954);
    this.JQy = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.JQn = ((TextView)findViewById(2131296624));
    this.JQo = ((TextView)findViewById(2131296596));
    if (paramInt == 0)
    {
      this.Aat = ((GridView)findViewById(2131300936));
      this.Aat.setOnItemClickListener(this);
      this.Aat.setNumColumns(3);
      localObject = new bu();
      if (this.ruj) {
        ((bu)localObject).qB(this.nYO);
      }
      this.JQj = new c(this, (bu)localObject, this.talker);
      if (this.JQj.getCount() == 0)
      {
        this.JQo.setVisibility(0);
        AppMethodBeat.o(35972);
        return;
      }
      this.JQo.setVisibility(8);
      this.Aat.setAdapter(this.JQj);
      fFO();
    }
    for (;;)
    {
      this.Aat.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable oTO;
        
        private void jG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35957);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.oTO);
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
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.oTO);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.oTO, 256L);
          }
          AppMethodBeat.o(35957);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(35959);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (bu)paramAnonymousAbsListView.JQj.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.fJG().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            AppMethodBeat.o(35959);
            return;
            localObject = new Date(((ei)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(35958);
          if (1 == paramAnonymousInt) {
            jG(true);
          }
          for (;;)
          {
            com.tencent.mm.aw.q.aIJ().cp(paramAnonymousInt);
            AppMethodBeat.o(35958);
            return;
            if (paramAnonymousInt == 0) {
              jG(false);
            }
          }
        }
      });
      AppMethodBeat.o(35972);
      return;
      if (this.JQj != null)
      {
        this.JQj.notifyDataSetChanged();
        fFO();
      }
    }
  }
  
  private static String ba(Context paramContext, String paramString)
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
        ad.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35977);
    return paramContext;
  }
  
  private void c(cv paramcv)
  {
    AppMethodBeat.i(35991);
    paramcv.dnG.activity = this;
    paramcv.dnG.dnM = 45;
    com.tencent.mm.sdk.b.a.IbL.l(paramcv);
    if ((paramcv.dnH.ret == -2) || (paramcv.dnH.ret > 0))
    {
      AppMethodBeat.o(35991);
      return;
    }
    if (paramcv.dnH.ret <= 0)
    {
      cxe();
      if (14 != paramcv.dnG.type)
      {
        ad.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(35991);
        return;
      }
      if (paramcv.dnG.dnJ == null)
      {
        ad.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(35991);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(11142, new Object[] { Integer.valueOf(paramcv.dnG.dnJ.GjK), Integer.valueOf(paramcv.dnG.dnJ.GjL), Integer.valueOf(paramcv.dnG.dnJ.GjM), Integer.valueOf(paramcv.dnG.dnJ.tGM), Integer.valueOf(paramcv.dnG.dnJ.GjN), Integer.valueOf(paramcv.dnG.dnJ.GjO), Integer.valueOf(paramcv.dnG.dnJ.GjP), Integer.valueOf(paramcv.dnG.dnJ.fileCount), Integer.valueOf(paramcv.dnG.dnJ.GjQ), Integer.valueOf(paramcv.dnG.dnJ.GjR), Integer.valueOf(paramcv.dnG.dnJ.GjS), Integer.valueOf(paramcv.dnG.dnJ.GjT), Integer.valueOf(paramcv.dnG.dnJ.GjU), Integer.valueOf(paramcv.dnG.dnJ.GjV), Integer.valueOf(paramcv.dnG.dnJ.GjW) });
    }
    AppMethodBeat.o(35991);
  }
  
  private String cg(bu parambu)
  {
    AppMethodBeat.i(35978);
    String str = bt.bI(this.talker, "");
    boolean bool = w.vF(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(35978);
      return str;
    }
    if (bool)
    {
      parambu = bj.Bk(parambu.field_content);
      if ((parambu == null) || (parambu.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(35978);
      return parambu;
      parambu = str;
    }
  }
  
  private void ch(bu parambu)
  {
    AppMethodBeat.i(35981);
    if (!fFP())
    {
      t.g(getContext(), null);
      AppMethodBeat.o(35981);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", parambu.field_msgId);
    parambu = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, parambu.ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)parambu.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35981);
  }
  
  private void cxd()
  {
    AppMethodBeat.i(35985);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fFU().rCx.size()) }));
    h.a.fFU().rCy = true;
    if (this.JQj == null)
    {
      AppMethodBeat.o(35985);
      return;
    }
    if (this.yTf == null) {
      this.yTf = AnimationUtils.loadAnimation(this, 2130772108);
    }
    this.JQj.cxd();
    this.JQt.setVisibility(0);
    this.JQt.startAnimation(this.yTf);
    this.JQv.setEnabled(false);
    this.JQw.setEnabled(false);
    this.JQx.setEnabled(false);
    this.JQy.setEnabled(false);
    this.JQu = this.Aat.getPaddingBottom();
    this.Aat.setPadding(this.Aat.getPaddingLeft(), this.Aat.getPaddingTop(), this.Aat.getPaddingRight(), com.tencent.mm.cc.a.ax(getContext(), 2131165567));
    com.tencent.mm.plugin.report.service.g.yhR.f(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), this);
    AppMethodBeat.o(35985);
  }
  
  private void fFO()
  {
    AppMethodBeat.i(35973);
    int i = this.Aat.getFirstVisiblePosition();
    int j = this.Aat.getLastVisiblePosition();
    int k = this.JQi;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(35973);
      return;
    }
    this.Aat.setSelection(k);
    AppMethodBeat.o(35973);
  }
  
  private boolean fFP()
  {
    AppMethodBeat.i(35980);
    long l1 = this.JPg;
    long l2 = System.currentTimeMillis();
    this.JPg = l2;
    if (l1 + 30000L < l2)
    {
      ba.aBQ();
      this.oSO = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.oSO;
    AppMethodBeat.o(35980);
    return bool;
  }
  
  private void fFQ()
  {
    AppMethodBeat.i(35986);
    if ((!h.a.fFU().rCx.isEmpty()) && (h.a.fFU().rCy)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.JQv.setEnabled(true);
      this.JQw.setEnabled(true);
      this.JQx.setEnabled(true);
      this.JQy.setEnabled(true);
      AppMethodBeat.o(35986);
      return;
    }
    this.JQv.setEnabled(false);
    this.JQw.setEnabled(false);
    this.JQx.setEnabled(false);
    this.JQy.setEnabled(false);
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.m(paramString, true, false);
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
      ad.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
      AppMethodBeat.o(35979);
    }
    return null;
  }
  
  private void handleIntent(Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(35969);
    if (paramIntent.getIntExtra("kintent_intent_source", 0) == 1) {}
    for (;;)
    {
      this.JQl = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.JQi = paramIntent.getIntExtra("kintent_image_index", 0);
      this.ruj = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.nYO = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.JQm = Boolean.TRUE;
      AppMethodBeat.o(35969);
      return;
      bool = false;
    }
  }
  
  private static void ic(List<bu> paramList)
  {
    AppMethodBeat.i(35989);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bu localbu = (bu)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.Jxc, a.d.Jxh, localbu, 0);
    }
    AppMethodBeat.o(35989);
  }
  
  private static List<bu> ig(List<bu> paramList)
  {
    AppMethodBeat.i(35990);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bu localbu = (bu)paramList.next();
      if ((!b.bX(localbu)) && (!b.bY(localbu)) && (!b.ca(localbu))) {
        localArrayList.add(localbu);
      }
    }
    AppMethodBeat.o(35990);
    return localArrayList;
  }
  
  public final void a(z.a parama) {}
  
  public final boolean azg()
  {
    return true;
  }
  
  public final boolean azh()
  {
    return false;
  }
  
  public final void b(z.a parama) {}
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35994);
    if (parama == z.a.hDS)
    {
      this.JQj.Zu();
      this.JQj.notifyDataSetChanged();
    }
    cxe();
    AppMethodBeat.o(35994);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35993);
    if ((this.JQj != null) && (this.mIsPause)) {
      this.JQj.JQb = true;
    }
    fFQ();
    AppMethodBeat.o(35993);
  }
  
  public final void cxe()
  {
    AppMethodBeat.i(35987);
    h.a.fFU().rCy = false;
    setMMTitle(getString(2131755258));
    if (this.JQj == null)
    {
      AppMethodBeat.o(35987);
      return;
    }
    this.JQj.notifyDataSetChanged();
    if (this.JQu >= 0) {
      this.Aat.setPadding(this.Aat.getPaddingLeft(), this.Aat.getPaddingTop(), this.Aat.getPaddingRight(), this.JQu);
    }
    this.JQt.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), this);
    AppMethodBeat.o(35987);
  }
  
  public final void fFR()
  {
    AppMethodBeat.i(35992);
    if ((this.JQj != null) && (this.mIsPause)) {
      this.JQj.JQb = true;
    }
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fFU().rCx.size()) }));
    fFQ();
    AppMethodBeat.o(35992);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35974);
    super.finish();
    h.a.fFU().detach();
    AppMethodBeat.o(35974);
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
    if (h.a.fFU().rCy)
    {
      cxe();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.JQl.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.JQi >= 0) {
      aF(null, this.JQi);
    }
    finish();
    AppMethodBeat.o(35971);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(35988);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    if (h.a.fFU().rCx.isEmpty())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    boolean bool = w.vF(this.talker);
    Object localObject2 = h.a.fFU().rCx;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131298954)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((bu)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.e(this, getString(2131757553), "", getString(2131758038), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35962);
          ad.i("MicroMsg.GalleryGridUI", "delete message");
          com.tencent.mm.ui.chatting.i.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.cxe();
          AppMethodBeat.o(35962);
        }
      }, null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
      if (paramView.getId() == 2131299762)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 18L, 1L, true);
        final cv localcv = new cv();
        if (com.tencent.mm.pluginsdk.model.i.a(getContext(), localcv, this.talker, (List)localObject2, false))
        {
          c(localcv);
          ic((List)localObject2);
        }
        else
        {
          if (((List)localObject2).size() > 1)
          {
            AppCompatActivity localAppCompatActivity = getContext();
            if (localcv.dnG.dnL >= 0)
            {
              paramView = getContext().getString(2131758899);
              label375:
              if (localcv.dnG.dnL < 0) {
                break label448;
              }
            }
            label448:
            for (localObject1 = getContext().getString(2131757560);; localObject1 = getContext().getString(2131761941))
            {
              com.tencent.mm.ui.base.h.e(localAppCompatActivity, paramView, "", (String)localObject1, getContext().getString(2131757558), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(35963);
                  if ((localcv.dnG.type == 14) && (localcv.dnG.dnI.nZa.size() == 0))
                  {
                    ImageGalleryGridUI.this.cxe();
                    AppMethodBeat.o(35963);
                    return;
                  }
                  ImageGalleryGridUI.a(ImageGalleryGridUI.this, localcv);
                  ImageGalleryGridUI.ih(this.gtP);
                  AppMethodBeat.o(35963);
                }
              }, null);
              break;
              paramView = getContext().getString(2131758898);
              break label375;
            }
          }
          com.tencent.mm.ui.base.h.l(getContext(), localcv.dnG.dnL, 0);
        }
      }
      else if (paramView.getId() == 2131306059)
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 19L, 1L, true);
        k.a(this, (List)localObject2, bool, this.talker, this);
        cxe();
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(11627, new Object[] { Integer.valueOf(3) });
        paramView = ig((List)localObject2);
        if (paramView.size() != ((List)localObject2).size())
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131759799, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35951);
              b.f(ImageGalleryGridUI.this.getContext(), paramView);
              ImageGalleryGridUI.this.cxe();
              AppMethodBeat.o(35951);
            }
          }, null);
        }
        else
        {
          localObject1 = (bu)paramView.get(0);
          if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((bu)localObject1).cTc()))
          {
            localObject2 = ((ei)localObject1).field_content;
            paramView = null;
            if (localObject2 != null) {
              paramView = k.b.aA((String)localObject2, ((ei)localObject1).field_reserved);
            }
            if ((paramView != null) && (paramView.type == 6)) {
              ch((bu)localObject1);
            }
          }
          else
          {
            b.f(this, (List)localObject2);
            cxe();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35965);
    super.onCreate(paramBundle);
    this.rCk = true;
    this.handler = new ap();
    adH(0);
    com.tencent.mm.sdk.b.a.IbL.c(this.oTc);
    AppMethodBeat.o(35965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35966);
    this.handler.removeCallbacks(this.JQq);
    this.handler = null;
    com.tencent.mm.aw.q.aIJ().cp(0);
    com.tencent.mm.sdk.b.a.IbL.d(this.oTc);
    super.onDestroy();
    AppMethodBeat.o(35966);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35975);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    bu localbu = (bu)this.JQj.getItem(paramInt);
    paramAdapterView = localbu.field_content;
    if (paramAdapterView != null) {}
    label265:
    label274:
    label1049:
    label1692:
    label2460:
    label3744:
    for (paramAdapterView = k.b.aA(paramAdapterView, localbu.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6)) {
        ch(localbu);
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
            localObject1 = com.tencent.mm.pluginsdk.model.app.q.Q(paramAdapterView.url, "message");
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(paramAdapterView.hzN, "message");
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
              paramLong = localbu.field_msgId;
              l = localbu.field_msgSvrId;
              if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
                break label274;
              }
              ad.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
              break;
              paramView = ((PackageInfo)localObject3).versionName;
              break label192;
            }
            if (ay.isMobile(getContext()))
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
              paramAdapterView = cg(localbu);
              ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
              ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
              if (localbu != null) {
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
              }
              ((Intent)localObject1).putExtra("preChatName", this.talker);
              ((Intent)localObject1).putExtra("preChatTYPE", x.aG(paramAdapterView, this.talker));
              ((Intent)localObject1).putExtra("preMsgIndex", 0);
              com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
              if (w.vF(this.talker))
              {
                paramView = "groupmessage";
                localObject3 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject1, paramView);
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
                if (bt.isNullOrNil(paramView)) {
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
                if (!bt.isNullOrNil(paramAdapterView.dHo))
                {
                  ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dHo);
                  ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dHp);
                }
                ((Intent)localObject1).putExtra("msg_id", localbu.field_msgId);
                ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbu.field_msgSvrId));
                ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
                ((Intent)localObject1).putExtra("geta8key_username", this.talker);
                paramAdapterView = cg(localbu);
                ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
                ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbu.field_msgSvrId));
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
                ((Intent)localObject1).putExtra("preChatName", this.talker);
                ((Intent)localObject1).putExtra("preChatTYPE", x.aG(paramAdapterView, this.talker));
                ((Intent)localObject1).putExtra("preMsgIndex", 0);
                com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
            paramView.putExtra("message_id", localbu.field_msgId);
            paramView.putExtra("record_xml", paramAdapterView.hAs);
            com.tencent.mm.bs.d.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
          }
          else if ((paramAdapterView != null) && (paramAdapterView.type == 24))
          {
            paramView = new oh();
            paramView.dCh.context = getContext();
            paramView.dCh.msgId = localbu.field_msgId;
            paramView.dCh.dCi = paramAdapterView.hAs;
            com.tencent.mm.sdk.b.a.IbL.l(paramView);
          }
          else
          {
            Object localObject4;
            boolean bool;
            if ((paramAdapterView != null) && (paramAdapterView.type == 7))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.app.h.m(paramAdapterView.appId, false, false);
              if (localObject2 != null)
              {
                localObject1 = this.talker;
                paramView = (View)localObject1;
                if (w.vF((String)localObject1)) {
                  paramView = bj.Bk(localbu.field_content);
                }
                paramLong = localbu.field_msgSvrId;
                if ((localObject2 != null) && (com.tencent.mm.pluginsdk.model.app.q.s(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName)))
                {
                  paramInt = 3;
                  if (paramAdapterView.type != 2) {
                    break label1679;
                  }
                  paramInt = 4;
                  localObject3 = new rd();
                  ((rd)localObject3).dFI.context = getContext();
                  ((rd)localObject3).dFI.scene = 1;
                  ((rd)localObject3).dFI.duW = paramAdapterView.appId;
                  localObject4 = ((rd)localObject3).dFI;
                  if (localObject2 != null) {
                    break label1692;
                  }
                  localObject1 = null;
                  ((rd.a)localObject4).packageName = ((String)localObject1);
                  ((rd)localObject3).dFI.msgType = paramAdapterView.type;
                  ((rd)localObject3).dFI.dyU = paramView;
                  ((rd)localObject3).dFI.dFJ = paramInt;
                  ((rd)localObject3).dFI.mediaTagName = paramAdapterView.mediaTagName;
                  ((rd)localObject3).dFI.dAY = paramLong;
                  ((rd)localObject3).dFI.dFK = "";
                  ((rd)localObject3).dFI.dkh = this.talker;
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                  paramView = com.tencent.mm.plugin.game.api.b.a.cWM();
                  if ((com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2)) || (paramView == null)) {
                    break label1794;
                  }
                  if (bt.isNullOrNil(((y)localObject2).eHz)) {
                    break label1702;
                  }
                  bool = r.bP(getContext(), ((y)localObject2).eHz);
                  ad.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((y)localObject2).eHz, Boolean.valueOf(bool) });
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
                  if ((paramAdapterView.dks != null) && (paramAdapterView.dks.length() != 0)) {
                    break label2098;
                  }
                  paramView = localbu.field_content;
                  paramAdapterView = paramView;
                  if (localbu.field_isSend == 0)
                  {
                    paramInt = localbu.field_isSend;
                    paramAdapterView = paramView;
                    if (!this.ruj)
                    {
                      paramAdapterView = paramView;
                      if (w.vF(this.talker))
                      {
                        paramAdapterView = paramView;
                        if (paramView != null)
                        {
                          paramAdapterView = paramView;
                          if (paramInt == 0) {
                            paramAdapterView = bj.Bl(paramView);
                          }
                        }
                      }
                    }
                  }
                  paramView = k.b.yr(paramAdapterView);
                  localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, true, false);
                  if ((localObject1 == null) || (!com.tencent.mm.pluginsdk.model.app.q.s(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName))) {
                    break label2049;
                  }
                  if (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_status != 3) {
                    break label1799;
                  }
                  ad.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
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
                  localObject1 = new ic();
                  ((ic)localObject1).duF.actionCode = 2;
                  ((ic)localObject1).duF.scene = 1;
                  ((ic)localObject1).duF.appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
                  ((ic)localObject1).duF.context = getContext();
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
                  new Intent();
                  getContext();
                  paramView.aj(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId, 1, 1);
                  paramInt = 1;
                  continue;
                  paramInt = 0;
                }
                continue;
                if (!com.tencent.mm.pluginsdk.model.app.q.b(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                {
                  ad.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName });
                  Toast.makeText(getContext(), getString(2131759894, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, null) }), 1).show();
                }
                else if (!a(localbu, (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                {
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.dks != null) && (paramView.dks.length() > 0))
                  {
                    paramAdapterView = ao.bIX().aLD(paramView.dks);
                    if (paramAdapterView != null) {
                      break label2041;
                    }
                  }
                  for (paramAdapterView = null;; paramAdapterView = paramAdapterView.field_fileFullPath)
                  {
                    ((WXAppExtendObject)localObject2).filePath = paramAdapterView;
                    paramAdapterView = new WXMediaMessage();
                    paramAdapterView.sdkVer = 637928960;
                    paramAdapterView.mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                    paramAdapterView.title = paramView.title;
                    paramAdapterView.description = paramView.description;
                    paramAdapterView.messageAction = paramView.messageAction;
                    paramAdapterView.messageExt = paramView.messageExt;
                    paramAdapterView.thumbData = com.tencent.mm.vfs.i.aY(com.tencent.mm.aw.q.aIF().Fm(localbu.field_imgPath), 0, -1);
                    new as(this).a(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramAdapterView, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_openId);
                    break;
                  }
                  paramAdapterView = com.tencent.mm.pluginsdk.model.app.q.M(getContext(), paramView.appId, "message");
                  paramView = new Intent();
                  paramView.putExtra("rawUrl", paramAdapterView);
                  com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                  continue;
                  if (!this.oSO)
                  {
                    t.g(getContext(), null);
                  }
                  else
                  {
                    paramAdapterView = new Intent();
                    paramAdapterView.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    paramAdapterView.putExtra("app_msg_id", localbu.field_msgId);
                    startActivityForResult(paramAdapterView, 210);
                  }
                }
              }
            }
            else
            {
              int i;
              if ((localbu.cxf()) || (localbu.fpi()) || (localbu.cxh()) || (localbu.frK()))
              {
                if ((paramAdapterView == null) || (bt.isNullOrNil(paramAdapterView.hCe)))
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
                  localObject1 = localbu.field_imgPath;
                  localObject3 = new Intent();
                  ((Intent)localObject3).putExtra("KFromTimeLine", false);
                  ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.hCe);
                  ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.hCj);
                  ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
                  ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localbu.field_msgId);
                  ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.hCf);
                  ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.hCi);
                  ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.hCh);
                  ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
                  localObject2 = localbu.field_talker;
                  bool = w.vF((String)localObject2);
                  if (bool)
                  {
                    localObject1 = bj.Bk(localbu.field_content);
                    ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.hCk);
                    ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.hCl);
                    ((Intent)localObject3).putExtra("KSta_SourceType", 1);
                    if (!bool) {
                      break label2596;
                    }
                    i = a.b.JwZ.value;
                    ((Intent)localObject3).putExtra("KSta_Scene", i);
                    ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
                    ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
                    ((Intent)localObject3).putExtra("KSta_MsgId", localbu.field_msgSvrId);
                    ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.dHv);
                    if (bool) {
                      ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.q.yS((String)localObject2));
                    }
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qqx, 0) <= 0) {
                      break label2607;
                    }
                    com.tencent.mm.bs.d.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
                    ad.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    localObject1 = localObject2;
                    break label2411;
                    i = a.b.JwY.value;
                    break label2460;
                    com.tencent.mm.bs.d.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
                  }
                }
                aF(paramView, paramInt);
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 15))
              {
                localObject1 = paramAdapterView.hAv;
                paramView = (View)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aby(paramAdapterView.url);
                }
                if (TextUtils.isEmpty(paramView))
                {
                  paramView = new Intent();
                  paramView.putExtra("geta8key_username", u.aAm());
                  paramView.putExtra("rawUrl", paramAdapterView.url);
                  com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                }
                else
                {
                  ad.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                  paramAdapterView = new Intent();
                  paramAdapterView.putExtra("extra_id", paramView);
                  paramAdapterView.putExtra("preceding_scence", 123);
                  paramAdapterView.putExtra("download_entrance_scene", 23);
                  com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
                  com.tencent.mm.plugin.report.service.g.yhR.f(10993, new Object[] { Integer.valueOf(2), paramView });
                }
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 26))
              {
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.hCc;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cg(localbu));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.fkq);
                  ((Intent)localObject4).putExtra("topic_id", paramInt);
                  ((Intent)localObject4).putExtra("topic_name", paramView);
                  ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
                  ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
                  ((Intent)localObject4).putExtra("extra_scence", 23);
                  com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
                }
                else
                {
                  ad.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
              }
              else
              {
                if ((paramAdapterView == null) || (paramAdapterView.type != 27)) {
                  break;
                }
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.hCc;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                i = paramAdapterView.pageType;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cg(localbu));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.fkq);
                  ((Intent)localObject4).putExtra("set_id", paramInt);
                  ((Intent)localObject4).putExtra("set_title", paramView);
                  ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
                  ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("headurl", (String)localObject3);
                  ((Intent)localObject4).putExtra("pageType", i);
                  com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
                }
                else
                {
                  ad.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
              }
            }
          }
        }
        ad.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localbu.field_talker, Long.valueOf(localbu.field_msgId), Integer.valueOf(localbu.getType()), localbu.field_content });
      } while ((paramAdapterView.url == null) || (paramAdapterView.url.equals("")) || (paramAdapterView.url == null) || (paramAdapterView.url.equals("")));
      label553:
      label1347:
      label2041:
      localObject1 = paramAdapterView.url;
      label1058:
      label1702:
      label2098:
      label2411:
      if (w.vF(this.talker))
      {
        paramView = "groupmessage";
        localObject3 = com.tencent.mm.pluginsdk.model.app.q.Q((String)localObject1, paramView);
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
        if (bt.isNullOrNil(paramView)) {
          break label3719;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        label3449:
        if (localObject2 != null) {
          break label3735;
        }
        paramView = null;
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3744;
        }
      }
      label2596:
      label2607:
      label3295:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!bt.isNullOrNil(paramAdapterView.dHo))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dHo);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dHp);
        }
        ((Intent)localObject1).putExtra("msg_id", localbu.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbu.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", u.aAm());
        ((Intent)localObject1).putExtra("pre_username", cg(localbu));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbu.field_msgSvrId));
        paramAdapterView = cg(localbu);
        paramView = u.aAm();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", x.aG(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        break;
        paramView = "singlemessage";
        break label3295;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3449;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3456;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35984);
    if (paramMenuItem.getTitle().equals(getString(2131759768)))
    {
      h.a.fFU().clear();
      cxd();
    }
    for (;;)
    {
      AppMethodBeat.o(35984);
      return false;
      cxe();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(35970);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    adH(1);
    AppMethodBeat.o(35970);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35968);
    h.a.fFU().rCz.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(35968);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(35983);
    Object localObject1 = (c.a)this.JQk.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(35983);
      return true;
    }
    Object localObject2 = ((c.a)localObject1).rCL.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(35983);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((c.a)localObject1).rCL.getMeasuredWidth();
    int j = ((c.a)localObject1).rCL.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((c.a)localObject1).rCN.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((c.a)localObject1).rCN.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((c.a)localObject1).rCN;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.JQs = ((View)localObject1);
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35960);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.JQC.animate().setDuration(500L).alpha(0.0F).withEndAction(ImageGalleryGridUI.this.JQr).withLayer().setInterpolator(this.JQD);
            AppMethodBeat.o(35960);
            return;
          }
          if (ImageGalleryGridUI.this.handler == null)
          {
            AppMethodBeat.o(35960);
            return;
          }
          this.JQC.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.JQD);
          ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.JQr, 500L);
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
    h.a.fFU().a(this);
    this.mIsPause = false;
    if (this.rCk)
    {
      if (!h.a.fFU().rCy) {
        break label143;
      }
      cxd();
    }
    for (;;)
    {
      this.handler.postDelayed(this.JQq, 300L);
      super.onResume();
      if (this.JQj != null)
      {
        this.JQj.JQb = true;
        c localc = this.JQj;
        if (localc.JQb) {
          localc.notifyDataSetChanged();
        }
        if (h.a.fFU().rCy) {
          setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fFU().rCx.size()) }));
        }
      }
      this.rCk = false;
      fFQ();
      AppMethodBeat.o(35967);
      return;
      label143:
      cxe();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void u(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */