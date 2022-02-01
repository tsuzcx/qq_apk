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
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.re.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.alb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.at;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.vfs.o;
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
  private GridView ArG;
  private long Kks;
  private Runnable KlA;
  private Runnable KlB;
  Runnable KlC;
  public View KlD;
  private View KlE;
  private int KlF;
  private View KlG;
  private View KlH;
  private View KlI;
  private View KlJ;
  public int Klt;
  c Klu;
  private WeakReference<c.a> Klv;
  private Boolean Klw;
  private Boolean Klx;
  private TextView Kly;
  private TextView Klz;
  protected aq handler;
  private boolean mIsPause;
  private com.tencent.mm.sdk.b.c oZE;
  private boolean oZq;
  public long oex;
  public boolean rCv;
  private boolean rKv;
  private String talker;
  private Animation zjp;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(35964);
    this.KlA = new Runnable()
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
    this.KlB = new Runnable()
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
    this.oZE = new com.tencent.mm.sdk.b.c() {};
    this.rKv = false;
    this.oZq = false;
    this.Kks = 0L;
    this.KlC = new Runnable()
    {
      @TargetApi(12)
      public final void run()
      {
        AppMethodBeat.i(35961);
        if (ImageGalleryGridUI.this.KlD != null)
        {
          ImageGalleryGridUI.this.KlD.setVisibility(8);
          ImageGalleryGridUI.this.KlD = null;
        }
        AppMethodBeat.o(35961);
      }
    };
    this.KlD = null;
    this.KlF = -1;
    this.mIsPause = true;
    AppMethodBeat.o(35964);
  }
  
  private boolean a(bv parambv, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35976);
    if ((!parambv.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35976);
      return false;
    }
    ae.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    parambv = new Intent("android.intent.action.MAIN", null);
    parambv.addCategory("android.intent.category.LAUNCHER");
    parambv.addFlags(268435456);
    parambv.setClassName("com.tencent.mobileqq", bc(getContext(), "com.tencent.mobileqq"));
    parambv.putExtra("platformId", "wechat");
    bc.aCg();
    paramg = com.tencent.mm.model.c.ajA().get(9, null);
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
        parambv.putExtra("tencent_gif", paramg);
        label287:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            parambv = new com.tencent.mm.hellhoundlib.b.a().bc(parambv);
            com.tencent.mm.hellhoundlib.a.a.a(this, parambv.ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)parambv.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35976);
            return true;
            paramg = paramg;
            ae.printErrStackTrace("MicroMsg.GalleryGridUI", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambv)
        {
          break label287;
        }
      }
    }
  }
  
  private void aF(View paramView, int paramInt)
  {
    AppMethodBeat.i(35982);
    if (this.Klu == null)
    {
      AppMethodBeat.o(35982);
      return;
    }
    ae.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.oex);
    localIntent.putExtra("key_is_biz_chat", this.rCv);
    localIntent.putExtra("intent.key.with.footer", true);
    bv localbv = (bv)this.Klu.getItem(paramInt);
    if (localbv == null)
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
    localIntent.putExtra("img_gallery_msg_id", localbv.field_msgId).putExtra("img_gallery_msg_svr_id", localbv.field_msgSvrId).putExtra("img_gallery_talker", localbv.field_talker).putExtra("img_gallery_chatroom_name", localbv.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(0, 0);
      AppMethodBeat.o(35982);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  @TargetApi(11)
  private void aeo(int paramInt)
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
    this.KlE = findViewById(2131302456);
    Object localObject = findViewById(2131299762);
    this.KlG = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131306059);
    this.KlH = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131304281);
    this.KlI = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131298954);
    this.KlJ = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.Kly = ((TextView)findViewById(2131296624));
    this.Klz = ((TextView)findViewById(2131296596));
    if (paramInt == 0)
    {
      this.ArG = ((GridView)findViewById(2131300936));
      this.ArG.setOnItemClickListener(this);
      this.ArG.setNumColumns(3);
      localObject = new bv();
      if (this.rCv) {
        ((bv)localObject).qO(this.oex);
      }
      this.Klu = new c(this, (bv)localObject, this.talker);
      if (this.Klu.getCount() == 0)
      {
        this.Klz.setVisibility(0);
        AppMethodBeat.o(35972);
        return;
      }
      this.Klz.setVisibility(8);
      this.ArG.setAdapter(this.Klu);
      fJV();
    }
    for (;;)
    {
      this.ArG.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable paq;
        
        private void jF(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35957);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.paq);
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
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.paq);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.paq, 256L);
          }
          AppMethodBeat.o(35957);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(35959);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (bv)paramAnonymousAbsListView.Klu.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.fNX().a((Date)localObject, paramAnonymousAbsListView))
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
            jF(true);
          }
          for (;;)
          {
            com.tencent.mm.av.q.aJb().cp(paramAnonymousInt);
            AppMethodBeat.o(35958);
            return;
            if (paramAnonymousInt == 0) {
              jF(false);
            }
          }
        }
      });
      AppMethodBeat.o(35972);
      return;
      if (this.Klu != null)
      {
        this.Klu.notifyDataSetChanged();
        fJV();
      }
    }
  }
  
  private static String bc(Context paramContext, String paramString)
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
        ae.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35977);
    return paramContext;
  }
  
  private void c(cw paramcw)
  {
    AppMethodBeat.i(35991);
    paramcw.doL.activity = this;
    paramcw.doL.doR = 45;
    com.tencent.mm.sdk.b.a.IvT.l(paramcw);
    if ((paramcw.doM.ret == -2) || (paramcw.doM.ret > 0))
    {
      AppMethodBeat.o(35991);
      return;
    }
    if (paramcw.doM.ret <= 0)
    {
      cyF();
      if (14 != paramcw.doL.type)
      {
        ae.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(35991);
        return;
      }
      if (paramcw.doL.doO == null)
      {
        ae.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(35991);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(11142, new Object[] { Integer.valueOf(paramcw.doL.doO.GCt), Integer.valueOf(paramcw.doL.doO.GCu), Integer.valueOf(paramcw.doL.doO.GCv), Integer.valueOf(paramcw.doL.doO.tRD), Integer.valueOf(paramcw.doL.doO.GCw), Integer.valueOf(paramcw.doL.doO.GCx), Integer.valueOf(paramcw.doL.doO.GCy), Integer.valueOf(paramcw.doL.doO.fileCount), Integer.valueOf(paramcw.doL.doO.GCz), Integer.valueOf(paramcw.doL.doO.GCA), Integer.valueOf(paramcw.doL.doO.GCB), Integer.valueOf(paramcw.doL.doO.GCC), Integer.valueOf(paramcw.doL.doO.GCD), Integer.valueOf(paramcw.doL.doO.GCE), Integer.valueOf(paramcw.doL.doO.GCF) });
    }
    AppMethodBeat.o(35991);
  }
  
  private String cg(bv parambv)
  {
    AppMethodBeat.i(35978);
    String str = bu.bI(this.talker, "");
    boolean bool = x.wb(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(35978);
      return str;
    }
    if (bool)
    {
      parambv = bl.BM(parambv.field_content);
      if ((parambv == null) || (parambv.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(35978);
      return parambv;
      parambv = str;
    }
  }
  
  private void ch(bv parambv)
  {
    AppMethodBeat.i(35981);
    if (!fJW())
    {
      t.g(getContext(), null);
      AppMethodBeat.o(35981);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", parambv.field_msgId);
    parambv = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, parambv.ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)parambv.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35981);
  }
  
  private void cyE()
  {
    AppMethodBeat.i(35985);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fKb().rKI.size()) }));
    h.a.fKb().rKJ = true;
    if (this.Klu == null)
    {
      AppMethodBeat.o(35985);
      return;
    }
    if (this.zjp == null) {
      this.zjp = AnimationUtils.loadAnimation(this, 2130772108);
    }
    this.Klu.cyE();
    this.KlE.setVisibility(0);
    this.KlE.startAnimation(this.zjp);
    this.KlG.setEnabled(false);
    this.KlH.setEnabled(false);
    this.KlI.setEnabled(false);
    this.KlJ.setEnabled(false);
    this.KlF = this.ArG.getPaddingBottom();
    this.ArG.setPadding(this.ArG.getPaddingLeft(), this.ArG.getPaddingTop(), this.ArG.getPaddingRight(), com.tencent.mm.cb.a.ax(getContext(), 2131165567));
    com.tencent.mm.plugin.report.service.g.yxI.f(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), this);
    AppMethodBeat.o(35985);
  }
  
  private void fJV()
  {
    AppMethodBeat.i(35973);
    int i = this.ArG.getFirstVisiblePosition();
    int j = this.ArG.getLastVisiblePosition();
    int k = this.Klt;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(35973);
      return;
    }
    this.ArG.setSelection(k);
    AppMethodBeat.o(35973);
  }
  
  private boolean fJW()
  {
    AppMethodBeat.i(35980);
    long l1 = this.Kks;
    long l2 = System.currentTimeMillis();
    this.Kks = l2;
    if (l1 + 30000L < l2)
    {
      bc.aCg();
      this.oZq = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.oZq;
    AppMethodBeat.o(35980);
    return bool;
  }
  
  private void fJX()
  {
    AppMethodBeat.i(35986);
    if ((!h.a.fKb().rKI.isEmpty()) && (h.a.fKb().rKJ)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.KlG.setEnabled(true);
      this.KlH.setEnabled(true);
      this.KlI.setEnabled(true);
      this.KlJ.setEnabled(true);
      AppMethodBeat.o(35986);
      return;
    }
    this.KlG.setEnabled(false);
    this.KlH.setEnabled(false);
    this.KlI.setEnabled(false);
    this.KlJ.setEnabled(false);
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
      ae.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
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
      this.Klw = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.Klt = paramIntent.getIntExtra("kintent_image_index", 0);
      this.rCv = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.oex = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.Klx = Boolean.TRUE;
      AppMethodBeat.o(35969);
      return;
      bool = false;
    }
  }
  
  private static void im(List<bv> paramList)
  {
    AppMethodBeat.i(35989);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.JRS, a.d.JRX, localbv, 0);
    }
    AppMethodBeat.o(35989);
  }
  
  private static List<bv> iq(List<bv> paramList)
  {
    AppMethodBeat.i(35990);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bv localbv = (bv)paramList.next();
      if ((!b.bX(localbv)) && (!b.bY(localbv)) && (!b.ca(localbv))) {
        localArrayList.add(localbv);
      }
    }
    AppMethodBeat.o(35990);
    return localArrayList;
  }
  
  public final void a(z.a parama) {}
  
  public final boolean azv()
  {
    return true;
  }
  
  public final boolean azw()
  {
    return false;
  }
  
  public final boolean azx()
  {
    return false;
  }
  
  public final void b(z.a parama) {}
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35994);
    if (parama == z.a.hGK)
    {
      this.Klu.ZD();
      this.Klu.notifyDataSetChanged();
    }
    cyF();
    AppMethodBeat.o(35994);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35993);
    if ((this.Klu != null) && (this.mIsPause)) {
      this.Klu.Klm = true;
    }
    fJX();
    AppMethodBeat.o(35993);
  }
  
  public final void cyF()
  {
    AppMethodBeat.i(35987);
    h.a.fKb().rKJ = false;
    setMMTitle(getString(2131755258));
    if (this.Klu == null)
    {
      AppMethodBeat.o(35987);
      return;
    }
    this.Klu.notifyDataSetChanged();
    if (this.KlF >= 0) {
      this.ArG.setPadding(this.ArG.getPaddingLeft(), this.ArG.getPaddingTop(), this.ArG.getPaddingRight(), this.KlF);
    }
    this.KlE.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), this);
    AppMethodBeat.o(35987);
  }
  
  public final void fJY()
  {
    AppMethodBeat.i(35992);
    if ((this.Klu != null) && (this.mIsPause)) {
      this.Klu.Klm = true;
    }
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fKb().rKI.size()) }));
    fJX();
    AppMethodBeat.o(35992);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35974);
    super.finish();
    h.a.fKb().detach();
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
    if (h.a.fKb().rKJ)
    {
      cyF();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.Klw.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.Klt >= 0) {
      aF(null, this.Klt);
    }
    finish();
    AppMethodBeat.o(35971);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(35988);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    if (h.a.fKb().rKI.isEmpty())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    boolean bool = x.wb(this.talker);
    Object localObject2 = h.a.fKb().rKI;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131298954)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((bv)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.e(this, getString(2131757553), "", getString(2131758038), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35962);
          ae.i("MicroMsg.GalleryGridUI", "delete message");
          j.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.cyF();
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
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 18L, 1L, true);
        final cw localcw = new cw();
        if (com.tencent.mm.pluginsdk.model.i.a(getContext(), localcw, this.talker, (List)localObject2, false))
        {
          c(localcw);
          im((List)localObject2);
        }
        else
        {
          if (((List)localObject2).size() > 1)
          {
            AppCompatActivity localAppCompatActivity = getContext();
            if (localcw.doL.doQ >= 0)
            {
              paramView = getContext().getString(2131758899);
              label375:
              if (localcw.doL.doQ < 0) {
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
                  if ((localcw.doL.type == 14) && (localcw.doL.doN.oeJ.size() == 0))
                  {
                    ImageGalleryGridUI.this.cyF();
                    AppMethodBeat.o(35963);
                    return;
                  }
                  ImageGalleryGridUI.a(ImageGalleryGridUI.this, localcw);
                  ImageGalleryGridUI.ir(this.gww);
                  AppMethodBeat.o(35963);
                }
              }, null);
              break;
              paramView = getContext().getString(2131758898);
              break label375;
            }
          }
          com.tencent.mm.ui.base.h.l(getContext(), localcw.doL.doQ, 0);
        }
      }
      else if (paramView.getId() == 2131306059)
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 19L, 1L, true);
        l.a(this, (List)localObject2, bool, this.talker, this);
        cyF();
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(11627, new Object[] { Integer.valueOf(3) });
        paramView = iq((List)localObject2);
        if (paramView.size() != ((List)localObject2).size())
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131759799, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35951);
              b.f(ImageGalleryGridUI.this.getContext(), paramView);
              ImageGalleryGridUI.this.cyF();
              AppMethodBeat.o(35951);
            }
          }, null);
        }
        else
        {
          localObject1 = (bv)paramView.get(0);
          if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((bv)localObject1).cVH()))
          {
            localObject2 = ((ei)localObject1).field_content;
            paramView = null;
            if (localObject2 != null) {
              paramView = k.b.aB((String)localObject2, ((ei)localObject1).field_reserved);
            }
            if ((paramView != null) && (paramView.type == 6)) {
              ch((bv)localObject1);
            }
          }
          else
          {
            b.f(this, (List)localObject2);
            cyF();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35965);
    super.onCreate(paramBundle);
    this.rKv = true;
    this.handler = new aq();
    aeo(0);
    com.tencent.mm.sdk.b.a.IvT.c(this.oZE);
    AppMethodBeat.o(35965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35966);
    this.handler.removeCallbacks(this.KlB);
    this.handler = null;
    com.tencent.mm.av.q.aJb().cp(0);
    com.tencent.mm.sdk.b.a.IvT.d(this.oZE);
    super.onDestroy();
    AppMethodBeat.o(35966);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35975);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    bv localbv = (bv)this.Klu.getItem(paramInt);
    paramAdapterView = localbv.field_content;
    if (paramAdapterView != null) {}
    label265:
    label274:
    label1049:
    label1692:
    label2460:
    label3744:
    for (paramAdapterView = k.b.aB(paramAdapterView, localbv.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6)) {
        ch(localbv);
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
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(paramAdapterView.hCB, "message");
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
              paramLong = localbv.field_msgId;
              l = localbv.field_msgSvrId;
              if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
                break label274;
              }
              ae.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
              break;
              paramView = ((PackageInfo)localObject3).versionName;
              break label192;
            }
            if (az.isMobile(getContext()))
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
              paramAdapterView = cg(localbv);
              ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
              ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
              if (localbv != null) {
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
              }
              ((Intent)localObject1).putExtra("preChatName", this.talker);
              ((Intent)localObject1).putExtra("preChatTYPE", com.tencent.mm.model.y.aH(paramAdapterView, this.talker));
              ((Intent)localObject1).putExtra("preMsgIndex", 0);
              com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
              if (x.wb(this.talker))
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
                if (bu.isNullOrNil(paramView)) {
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
                if (!bu.isNullOrNil(paramAdapterView.dIt))
                {
                  ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dIt);
                  ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dIu);
                }
                ((Intent)localObject1).putExtra("msg_id", localbv.field_msgId);
                ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbv.field_msgSvrId));
                ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
                ((Intent)localObject1).putExtra("geta8key_username", this.talker);
                paramAdapterView = cg(localbv);
                ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
                ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbv.field_msgSvrId));
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
                ((Intent)localObject1).putExtra("preChatName", this.talker);
                ((Intent)localObject1).putExtra("preChatTYPE", com.tencent.mm.model.y.aH(paramAdapterView, this.talker));
                ((Intent)localObject1).putExtra("preMsgIndex", 0);
                com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
            paramView.putExtra("message_id", localbv.field_msgId);
            paramView.putExtra("record_xml", paramAdapterView.hDg);
            com.tencent.mm.br.d.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
          }
          else if ((paramAdapterView != null) && (paramAdapterView.type == 24))
          {
            paramView = new oi();
            paramView.dDm.context = getContext();
            paramView.dDm.msgId = localbv.field_msgId;
            paramView.dDm.dDn = paramAdapterView.hDg;
            com.tencent.mm.sdk.b.a.IvT.l(paramView);
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
                if (x.wb((String)localObject1)) {
                  paramView = bl.BM(localbv.field_content);
                }
                paramLong = localbv.field_msgSvrId;
                if ((localObject2 != null) && (com.tencent.mm.pluginsdk.model.app.q.s(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName)))
                {
                  paramInt = 3;
                  if (paramAdapterView.type != 2) {
                    break label1679;
                  }
                  paramInt = 4;
                  localObject3 = new re();
                  ((re)localObject3).dGN.context = getContext();
                  ((re)localObject3).dGN.scene = 1;
                  ((re)localObject3).dGN.dwb = paramAdapterView.appId;
                  localObject4 = ((re)localObject3).dGN;
                  if (localObject2 != null) {
                    break label1692;
                  }
                  localObject1 = null;
                  ((re.a)localObject4).packageName = ((String)localObject1);
                  ((re)localObject3).dGN.msgType = paramAdapterView.type;
                  ((re)localObject3).dGN.dzZ = paramView;
                  ((re)localObject3).dGN.dGO = paramInt;
                  ((re)localObject3).dGN.mediaTagName = paramAdapterView.mediaTagName;
                  ((re)localObject3).dGN.dCd = paramLong;
                  ((re)localObject3).dGN.dGP = "";
                  ((re)localObject3).dGN.dlj = this.talker;
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
                  paramView = com.tencent.mm.plugin.game.api.b.a.cZq();
                  if ((com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2)) || (paramView == null)) {
                    break label1794;
                  }
                  if (bu.isNullOrNil(((com.tencent.mm.g.c.y)localObject2).eJi)) {
                    break label1702;
                  }
                  bool = com.tencent.mm.pluginsdk.model.app.r.bQ(getContext(), ((com.tencent.mm.g.c.y)localObject2).eJi);
                  ae.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((com.tencent.mm.g.c.y)localObject2).eJi, Boolean.valueOf(bool) });
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
                  if ((paramAdapterView.dlu != null) && (paramAdapterView.dlu.length() != 0)) {
                    break label2098;
                  }
                  paramView = localbv.field_content;
                  paramAdapterView = paramView;
                  if (localbv.field_isSend == 0)
                  {
                    paramInt = localbv.field_isSend;
                    paramAdapterView = paramView;
                    if (!this.rCv)
                    {
                      paramAdapterView = paramView;
                      if (x.wb(this.talker))
                      {
                        paramAdapterView = paramView;
                        if (paramView != null)
                        {
                          paramAdapterView = paramView;
                          if (paramInt == 0) {
                            paramAdapterView = bl.BN(paramView);
                          }
                        }
                      }
                    }
                  }
                  paramView = k.b.zb(paramAdapterView);
                  localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, true, false);
                  if ((localObject1 == null) || (!com.tencent.mm.pluginsdk.model.app.q.s(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName))) {
                    break label2049;
                  }
                  if (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_status != 3) {
                    break label1799;
                  }
                  ae.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
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
                  localObject1 = new id();
                  ((id)localObject1).dvK.actionCode = 2;
                  ((id)localObject1).dvK.scene = 1;
                  ((id)localObject1).dvK.appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
                  ((id)localObject1).dvK.context = getContext();
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
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
                  ae.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName });
                  Toast.makeText(getContext(), getString(2131759894, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, null) }), 1).show();
                }
                else if (!a(localbv, (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                {
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.dlu != null) && (paramView.dlu.length() > 0))
                  {
                    paramAdapterView = ao.bJV().aMZ(paramView.dlu);
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
                    paramAdapterView.thumbData = o.bb(com.tencent.mm.av.q.aIX().FO(localbv.field_imgPath), 0, -1);
                    new at(this).a(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramAdapterView, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_openId);
                    break;
                  }
                  paramAdapterView = com.tencent.mm.pluginsdk.model.app.q.M(getContext(), paramView.appId, "message");
                  paramView = new Intent();
                  paramView.putExtra("rawUrl", paramAdapterView);
                  com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                  continue;
                  if (!this.oZq)
                  {
                    t.g(getContext(), null);
                  }
                  else
                  {
                    paramAdapterView = new Intent();
                    paramAdapterView.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    paramAdapterView.putExtra("app_msg_id", localbv.field_msgId);
                    startActivityForResult(paramAdapterView, 210);
                  }
                }
              }
            }
            else
            {
              int i;
              if ((localbv.cyG()) || (localbv.ftg()) || (localbv.cyI()) || (localbv.fvK()))
              {
                if ((paramAdapterView == null) || (bu.isNullOrNil(paramAdapterView.hET)))
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
                  localObject1 = localbv.field_imgPath;
                  localObject3 = new Intent();
                  ((Intent)localObject3).putExtra("KFromTimeLine", false);
                  ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.hET);
                  ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.hEY);
                  ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
                  ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localbv.field_msgId);
                  ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.hEU);
                  ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.hEX);
                  ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.hEW);
                  ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
                  localObject2 = localbv.field_talker;
                  bool = x.wb((String)localObject2);
                  if (bool)
                  {
                    localObject1 = bl.BM(localbv.field_content);
                    ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.hEZ);
                    ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.hFa);
                    ((Intent)localObject3).putExtra("KSta_SourceType", 1);
                    if (!bool) {
                      break label2596;
                    }
                    i = a.b.JRP.value;
                    ((Intent)localObject3).putExtra("KSta_Scene", i);
                    ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
                    ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
                    ((Intent)localObject3).putExtra("KSta_MsgId", localbv.field_msgSvrId);
                    ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.dIA);
                    if (bool) {
                      ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.r.zC((String)localObject2));
                    }
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxf, 0) <= 0) {
                      break label2607;
                    }
                    com.tencent.mm.br.d.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
                    ae.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    localObject1 = localObject2;
                    break label2411;
                    i = a.b.JRO.value;
                    break label2460;
                    com.tencent.mm.br.d.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
                  }
                }
                aF(paramView, paramInt);
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 15))
              {
                localObject1 = paramAdapterView.hDj;
                paramView = (View)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acp(paramAdapterView.url);
                }
                if (TextUtils.isEmpty(paramView))
                {
                  paramView = new Intent();
                  paramView.putExtra("geta8key_username", v.aAC());
                  paramView.putExtra("rawUrl", paramAdapterView.url);
                  com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                }
                else
                {
                  ae.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                  paramAdapterView = new Intent();
                  paramAdapterView.putExtra("extra_id", paramView);
                  paramAdapterView.putExtra("preceding_scence", 123);
                  paramAdapterView.putExtra("download_entrance_scene", 23);
                  com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
                  com.tencent.mm.plugin.report.service.g.yxI.f(10993, new Object[] { Integer.valueOf(2), paramView });
                }
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 26))
              {
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.hEQ;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cg(localbv));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.fmn);
                  ((Intent)localObject4).putExtra("topic_id", paramInt);
                  ((Intent)localObject4).putExtra("topic_name", paramView);
                  ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
                  ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
                  ((Intent)localObject4).putExtra("extra_scence", 23);
                  com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
                }
                else
                {
                  ae.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
              }
              else
              {
                if ((paramAdapterView == null) || (paramAdapterView.type != 27)) {
                  break;
                }
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.hEQ;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                i = paramAdapterView.pageType;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cg(localbv));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.fmn);
                  ((Intent)localObject4).putExtra("set_id", paramInt);
                  ((Intent)localObject4).putExtra("set_title", paramView);
                  ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
                  ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("headurl", (String)localObject3);
                  ((Intent)localObject4).putExtra("pageType", i);
                  com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
                }
                else
                {
                  ae.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
              }
            }
          }
        }
        ae.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localbv.field_talker, Long.valueOf(localbv.field_msgId), Integer.valueOf(localbv.getType()), localbv.field_content });
      } while ((paramAdapterView.url == null) || (paramAdapterView.url.equals("")) || (paramAdapterView.url == null) || (paramAdapterView.url.equals("")));
      label553:
      label1347:
      label2041:
      localObject1 = paramAdapterView.url;
      label1058:
      label1702:
      label2098:
      label2411:
      if (x.wb(this.talker))
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
        if (bu.isNullOrNil(paramView)) {
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
        if (!bu.isNullOrNil(paramAdapterView.dIt))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dIt);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dIu);
        }
        ((Intent)localObject1).putExtra("msg_id", localbv.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbv.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", v.aAC());
        ((Intent)localObject1).putExtra("pre_username", cg(localbv));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbv.field_msgSvrId));
        paramAdapterView = cg(localbv);
        paramView = v.aAC();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", com.tencent.mm.model.y.aH(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
      h.a.fKb().clear();
      cyE();
    }
    for (;;)
    {
      AppMethodBeat.o(35984);
      return false;
      cyF();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(35970);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    aeo(1);
    AppMethodBeat.o(35970);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35968);
    h.a.fKb().rKK.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(35968);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(35983);
    Object localObject1 = (c.a)this.Klv.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(35983);
      return true;
    }
    Object localObject2 = ((c.a)localObject1).rKW.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(35983);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((c.a)localObject1).rKW.getMeasuredWidth();
    int j = ((c.a)localObject1).rKW.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((c.a)localObject1).rKY.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((c.a)localObject1).rKY.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((c.a)localObject1).rKY;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.KlD = ((View)localObject1);
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35960);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.KlN.animate().setDuration(500L).alpha(0.0F).withEndAction(ImageGalleryGridUI.this.KlC).withLayer().setInterpolator(this.KlO);
            AppMethodBeat.o(35960);
            return;
          }
          if (ImageGalleryGridUI.this.handler == null)
          {
            AppMethodBeat.o(35960);
            return;
          }
          this.KlN.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.KlO);
          ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.KlC, 500L);
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
    h.a.fKb().a(this);
    this.mIsPause = false;
    if (this.rKv)
    {
      if (!h.a.fKb().rKJ) {
        break label143;
      }
      cyE();
    }
    for (;;)
    {
      this.handler.postDelayed(this.KlB, 300L);
      super.onResume();
      if (this.Klu != null)
      {
        this.Klu.Klm = true;
        c localc = this.Klu;
        if (localc.Klm) {
          localc.notifyDataSetChanged();
        }
        if (h.a.fKb().rKJ) {
          setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.fKb().rKI.size()) }));
        }
      }
      this.rKv = false;
      fJX();
      AppMethodBeat.o(35967);
      return;
      label143:
      cyF();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void v(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */