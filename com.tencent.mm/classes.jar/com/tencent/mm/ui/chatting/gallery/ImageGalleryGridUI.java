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
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qj.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
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
  public int GAW;
  c GAX;
  private WeakReference<c.a> GAY;
  private Boolean GAZ;
  private Boolean GBa;
  private TextView GBb;
  private TextView GBc;
  private Runnable GBd;
  private Runnable GBe;
  Runnable GBf;
  public View GBg;
  private View GBh;
  private int GBi;
  private View GBj;
  private View GBk;
  private View GBl;
  private View GBm;
  private long GzW;
  protected com.tencent.mm.sdk.platformtools.ap handler;
  private boolean mIsPause;
  public long mUQ;
  private com.tencent.mm.sdk.b.c nMH;
  private boolean nMt;
  public boolean qbB;
  private boolean qjI;
  private String talker;
  private Animation wtf;
  private GridView xwj;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(35964);
    this.GBd = new Runnable()
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
    this.GBe = new Runnable()
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
    this.nMH = new com.tencent.mm.sdk.b.c() {};
    this.qjI = false;
    this.nMt = false;
    this.GzW = 0L;
    this.GBf = new Runnable()
    {
      @TargetApi(12)
      public final void run()
      {
        AppMethodBeat.i(35961);
        if (ImageGalleryGridUI.this.GBg != null)
        {
          ImageGalleryGridUI.this.GBg.setVisibility(8);
          ImageGalleryGridUI.this.GBg = null;
        }
        AppMethodBeat.o(35961);
      }
    };
    this.GBg = null;
    this.GBi = -1;
    this.mIsPause = true;
    AppMethodBeat.o(35964);
  }
  
  @TargetApi(11)
  private void Zj(int paramInt)
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
    this.GBh = findViewById(2131302456);
    Object localObject = findViewById(2131299762);
    this.GBj = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131306059);
    this.GBk = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131304281);
    this.GBl = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131298954);
    this.GBm = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.GBb = ((TextView)findViewById(2131296624));
    this.GBc = ((TextView)findViewById(2131296596));
    if (paramInt == 0)
    {
      this.xwj = ((GridView)findViewById(2131300936));
      this.xwj.setOnItemClickListener(this);
      this.xwj.setNumColumns(3);
      localObject = new bl();
      if (this.qbB) {
        ((bl)localObject).kZ(this.mUQ);
      }
      this.GAX = new c(this, (bl)localObject, this.talker);
      if (this.GAX.getCount() == 0)
      {
        this.GBc.setVisibility(0);
        AppMethodBeat.o(35972);
        return;
      }
      this.GBc.setVisibility(8);
      this.xwj.setAdapter(this.GAX);
      eZu();
    }
    for (;;)
    {
      this.xwj.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable nNr;
        
        private void iS(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35957);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.nNr);
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
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.nNr);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.nNr, 256L);
          }
          AppMethodBeat.o(35957);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(35959);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (bl)paramAnonymousAbsListView.GAX.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.fcX().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            AppMethodBeat.o(35959);
            return;
            localObject = new Date(((du)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(35958);
          if (1 == paramAnonymousInt) {
            iS(true);
          }
          for (;;)
          {
            o.ayJ().cq(paramAnonymousInt);
            AppMethodBeat.o(35958);
            return;
            if (paramAnonymousInt == 0) {
              iS(false);
            }
          }
        }
      });
      AppMethodBeat.o(35972);
      return;
      if (this.GAX != null)
      {
        this.GAX.notifyDataSetChanged();
        eZu();
      }
    }
  }
  
  private boolean a(bl parambl, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35976);
    if ((!parambl.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35976);
      return false;
    }
    ad.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    parambl = new Intent("android.intent.action.MAIN", null);
    parambl.addCategory("android.intent.category.LAUNCHER");
    parambl.addFlags(268435456);
    parambl.setClassName("com.tencent.mobileqq", aW(getContext(), "com.tencent.mobileqq"));
    parambl.putExtra("platformId", "wechat");
    az.arV();
    paramg = com.tencent.mm.model.c.afk().get(9, null);
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
        parambl.putExtra("tencent_gif", paramg);
        label299:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            parambl = new com.tencent.mm.hellhoundlib.b.a().bd(parambl);
            com.tencent.mm.hellhoundlib.a.a.a(this, parambl.adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)parambl.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35976);
            return true;
            paramg = paramg;
            ad.printErrStackTrace("MicroMsg.GalleryGridUI", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambl)
        {
          break label299;
        }
      }
    }
  }
  
  private void aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(35982);
    if (this.GAX == null)
    {
      AppMethodBeat.o(35982);
      return;
    }
    ad.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.mUQ);
    localIntent.putExtra("key_is_biz_chat", this.qbB);
    localIntent.putExtra("intent.key.with.footer", true);
    bl localbl = (bl)this.GAX.getItem(paramInt);
    if (localbl == null)
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
    localIntent.putExtra("img_gallery_msg_id", localbl.field_msgId).putExtra("img_gallery_msg_svr_id", localbl.field_msgSvrId).putExtra("img_gallery_talker", localbl.field_talker).putExtra("img_gallery_chatroom_name", localbl.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(0, 0);
      AppMethodBeat.o(35982);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private static String aW(Context paramContext, String paramString)
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
        break label102;
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
  
  private String bX(bl parambl)
  {
    AppMethodBeat.i(35978);
    String str = bt.by(this.talker, "");
    boolean bool = w.pF(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(35978);
      return str;
    }
    if (bool)
    {
      parambl = bi.uf(parambl.field_content);
      if ((parambl == null) || (parambl.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(35978);
      return parambl;
      parambl = str;
    }
  }
  
  private void bY(bl parambl)
  {
    AppMethodBeat.i(35981);
    if (!eZv())
    {
      t.g(getContext(), null);
      AppMethodBeat.o(35981);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", parambl.field_msgId);
    parambl = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, parambl.adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)parambl.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35981);
  }
  
  private void c(cs paramcs)
  {
    AppMethodBeat.i(35991);
    paramcs.deQ.activity = this;
    paramcs.deQ.deW = 45;
    com.tencent.mm.sdk.b.a.ESL.l(paramcs);
    if ((paramcs.deR.ret == -2) || (paramcs.deR.ret > 0))
    {
      AppMethodBeat.o(35991);
      return;
    }
    if (paramcs.deR.ret <= 0)
    {
      cjL();
      if (14 != paramcs.deQ.type)
      {
        ad.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(35991);
        return;
      }
      if (paramcs.deQ.deT == null)
      {
        ad.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(35991);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(11142, new Object[] { Integer.valueOf(paramcs.deQ.deT.DiS), Integer.valueOf(paramcs.deQ.deT.DiT), Integer.valueOf(paramcs.deQ.deT.DiU), Integer.valueOf(paramcs.deQ.deT.rBj), Integer.valueOf(paramcs.deQ.deT.DiV), Integer.valueOf(paramcs.deQ.deT.DiW), Integer.valueOf(paramcs.deQ.deT.DiX), Integer.valueOf(paramcs.deQ.deT.fileCount), Integer.valueOf(paramcs.deQ.deT.DiY), Integer.valueOf(paramcs.deQ.deT.DiZ), Integer.valueOf(paramcs.deQ.deT.Dja), Integer.valueOf(paramcs.deQ.deT.Djb), Integer.valueOf(paramcs.deQ.deT.Djc), Integer.valueOf(paramcs.deQ.deT.Djd), Integer.valueOf(paramcs.deQ.deT.Dje) });
    }
    AppMethodBeat.o(35991);
  }
  
  private void cjK()
  {
    AppMethodBeat.i(35985);
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.eZA().qjT.size()) }));
    h.a.eZA().qjU = true;
    if (this.GAX == null)
    {
      AppMethodBeat.o(35985);
      return;
    }
    if (this.wtf == null) {
      this.wtf = AnimationUtils.loadAnimation(this, 2130772108);
    }
    this.GAX.cjK();
    this.GBh.setVisibility(0);
    this.GBh.startAnimation(this.wtf);
    this.GBj.setEnabled(false);
    this.GBk.setEnabled(false);
    this.GBl.setEnabled(false);
    this.GBm.setEnabled(false);
    this.GBi = this.xwj.getPaddingBottom();
    this.xwj.setPadding(this.xwj.getPaddingLeft(), this.xwj.getPaddingTop(), this.xwj.getPaddingRight(), com.tencent.mm.cd.a.ao(getContext(), 2131165567));
    com.tencent.mm.plugin.report.service.h.vKh.f(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759767), this);
    AppMethodBeat.o(35985);
  }
  
  private void eZu()
  {
    AppMethodBeat.i(35973);
    int i = this.xwj.getFirstVisiblePosition();
    int j = this.xwj.getLastVisiblePosition();
    int k = this.GAW;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(35973);
      return;
    }
    this.xwj.setSelection(k);
    AppMethodBeat.o(35973);
  }
  
  private boolean eZv()
  {
    AppMethodBeat.i(35980);
    long l1 = this.GzW;
    long l2 = System.currentTimeMillis();
    this.GzW = l2;
    if (l1 + 30000L < l2)
    {
      az.arV();
      this.nMt = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.nMt;
    AppMethodBeat.o(35980);
    return bool;
  }
  
  private void eZw()
  {
    AppMethodBeat.i(35986);
    if ((!h.a.eZA().qjT.isEmpty()) && (h.a.eZA().qjU)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.GBj.setEnabled(true);
      this.GBk.setEnabled(true);
      this.GBl.setEnabled(true);
      this.GBm.setEnabled(true);
      AppMethodBeat.o(35986);
      return;
    }
    this.GBj.setEnabled(false);
    this.GBk.setEnabled(false);
    this.GBl.setEnabled(false);
    this.GBm.setEnabled(false);
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.j(paramString, true, false);
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
  
  private static void hD(List<bl> paramList)
  {
    AppMethodBeat.i(35989);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bl localbl = (bl)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.Gjw, a.d.GjB, localbl, 0);
    }
    AppMethodBeat.o(35989);
  }
  
  private static List<bl> hH(List<bl> paramList)
  {
    AppMethodBeat.i(35990);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bl localbl = (bl)paramList.next();
      if ((!b.bO(localbl)) && (!b.bP(localbl)) && (!b.bR(localbl))) {
        localArrayList.add(localbl);
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
      this.GAZ = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.GAW = paramIntent.getIntExtra("kintent_image_index", 0);
      this.qbB = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.mUQ = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.GBa = Boolean.TRUE;
      AppMethodBeat.o(35969);
      return;
      bool = false;
    }
  }
  
  public final void a(z.a parama) {}
  
  public final boolean apE()
  {
    return true;
  }
  
  public final void b(z.a parama) {}
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35994);
    if (parama == z.a.gLi)
    {
      this.GAX.Wd();
      this.GAX.notifyDataSetChanged();
    }
    cjL();
    AppMethodBeat.o(35994);
  }
  
  public final void cjL()
  {
    AppMethodBeat.i(35987);
    h.a.eZA().qjU = false;
    setMMTitle(getString(2131755258));
    if (this.GAX == null)
    {
      AppMethodBeat.o(35987);
      return;
    }
    this.GAX.notifyDataSetChanged();
    if (this.GBi >= 0) {
      this.xwj.setPadding(this.xwj.getPaddingLeft(), this.xwj.getPaddingTop(), this.xwj.getPaddingRight(), this.GBi);
    }
    this.GBh.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131759768), this);
    AppMethodBeat.o(35987);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35993);
    if ((this.GAX != null) && (this.mIsPause)) {
      this.GAX.GAP = true;
    }
    eZw();
    AppMethodBeat.o(35993);
  }
  
  public final void eZx()
  {
    AppMethodBeat.i(35992);
    if ((this.GAX != null) && (this.mIsPause)) {
      this.GAX.GAP = true;
    }
    setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.eZA().qjT.size()) }));
    eZw();
    AppMethodBeat.o(35992);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35974);
    super.finish();
    h.a.eZA().detach();
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
    if (h.a.eZA().qjU)
    {
      cjL();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.GAZ.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.GAW >= 0) {
      aB(null, this.GAW);
    }
    finish();
    AppMethodBeat.o(35971);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(35988);
    if (h.a.eZA().qjT.isEmpty())
    {
      AppMethodBeat.o(35988);
      return;
    }
    boolean bool = w.pF(this.talker);
    Object localObject2 = h.a.eZA().qjT;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131298954)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((bl)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131757553), "", getString(2131758038), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35962);
          ad.i("MicroMsg.GalleryGridUI", "delete message");
          com.tencent.mm.ui.chatting.i.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.cjL();
          AppMethodBeat.o(35962);
        }
      }, null);
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131299762)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 18L, 1L, true);
      final cs localcs = new cs();
      if (com.tencent.mm.pluginsdk.model.i.a(getContext(), localcs, this.talker, (List)localObject2, false))
      {
        c(localcs);
        hD((List)localObject2);
        AppMethodBeat.o(35988);
        return;
      }
      if (((List)localObject2).size() > 1)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        if (localcs.deQ.deV >= 0)
        {
          paramView = getContext().getString(2131758899);
          if (localcs.deQ.deV < 0) {
            break label373;
          }
        }
        label373:
        for (localObject1 = getContext().getString(2131757560);; localObject1 = getContext().getString(2131761941))
        {
          com.tencent.mm.ui.base.h.d(localAppCompatActivity, paramView, "", (String)localObject1, getContext().getString(2131757558), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35963);
              if ((localcs.deQ.type == 14) && (localcs.deQ.deS.mVb.size() == 0))
              {
                ImageGalleryGridUI.this.cjL();
                AppMethodBeat.o(35963);
                return;
              }
              ImageGalleryGridUI.a(ImageGalleryGridUI.this, localcs);
              ImageGalleryGridUI.hI(this.krN);
              AppMethodBeat.o(35963);
            }
          }, null);
          AppMethodBeat.o(35988);
          return;
          paramView = getContext().getString(2131758898);
          break;
        }
      }
      com.tencent.mm.ui.base.h.j(getContext(), localcs.deQ.deV, 0);
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131306059)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 19L, 1L, true);
      k.a(this, (List)localObject2, bool, this.talker, this);
      cjL();
      AppMethodBeat.o(35988);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11627, new Object[] { Integer.valueOf(3) });
    paramView = hH((List)localObject2);
    if (paramView.size() != ((List)localObject2).size())
    {
      com.tencent.mm.ui.base.h.a(getContext(), 2131759799, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35951);
          b.f(ImageGalleryGridUI.this.getContext(), paramView);
          ImageGalleryGridUI.this.cjL();
          AppMethodBeat.o(35951);
        }
      }, null);
      AppMethodBeat.o(35988);
      return;
    }
    Object localObject1 = (bl)paramView.get(0);
    if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((bl)localObject1).cxB()))
    {
      localObject2 = ((du)localObject1).field_content;
      paramView = null;
      if (localObject2 != null) {
        paramView = k.b.ar((String)localObject2, ((du)localObject1).field_reserved);
      }
      if ((paramView != null) && (paramView.type == 6)) {
        bY((bl)localObject1);
      }
      AppMethodBeat.o(35988);
      return;
    }
    b.f(this, (List)localObject2);
    cjL();
    AppMethodBeat.o(35988);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35965);
    super.onCreate(paramBundle);
    this.qjI = true;
    this.handler = new com.tencent.mm.sdk.platformtools.ap();
    Zj(0);
    com.tencent.mm.sdk.b.a.ESL.c(this.nMH);
    AppMethodBeat.o(35965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35966);
    this.handler.removeCallbacks(this.GBe);
    this.handler = null;
    o.ayJ().cq(0);
    com.tencent.mm.sdk.b.a.ESL.d(this.nMH);
    super.onDestroy();
    AppMethodBeat.o(35966);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35975);
    bl localbl = (bl)this.GAX.getItem(paramInt);
    paramAdapterView = localbl.field_content;
    if (paramAdapterView != null) {}
    for (paramAdapterView = k.b.ar(paramAdapterView, localbl.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6))
      {
        bY(localbl);
        AppMethodBeat.o(35975);
        return;
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramAdapterView != null) && (paramAdapterView.type == 3))
      {
        localObject1 = com.tencent.mm.pluginsdk.model.app.q.O(paramAdapterView.url, "message");
        localObject2 = com.tencent.mm.pluginsdk.model.app.q.O(paramAdapterView.gHd, "message");
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
          paramLong = localbl.field_msgId;
          l = localbl.field_msgSvrId;
          if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
            break label208;
          }
          ad.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
          AppMethodBeat.o(35975);
          return;
          paramView = ((PackageInfo)localObject3).versionName;
          break;
        }
        label208:
        if (ay.isMobile(getContext()))
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
          paramAdapterView = bX(localbl);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
          if (localbl != null) {
            ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          }
          ((Intent)localObject1).putExtra("preChatName", this.talker);
          ((Intent)localObject1).putExtra("preChatTYPE", x.aw(paramAdapterView, this.talker));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(35975);
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
          if (!w.pF(this.talker)) {
            break label968;
          }
          paramView = "groupmessage";
          localObject3 = com.tencent.mm.pluginsdk.model.app.q.O((String)localObject1, paramView);
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
          if (!bt.isNullOrNil(paramAdapterView.dxz))
          {
            ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dxz);
            ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dxA);
          }
          ((Intent)localObject1).putExtra("msg_id", localbl.field_msgId);
          ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbl.field_msgSvrId));
          ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
          ((Intent)localObject1).putExtra("geta8key_username", this.talker);
          paramAdapterView = bX(localbl);
          ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
          ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbl.field_msgSvrId));
          ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
          ((Intent)localObject1).putExtra("preChatName", this.talker);
          ((Intent)localObject1).putExtra("preChatTYPE", x.aw(paramAdapterView, this.talker));
          ((Intent)localObject1).putExtra("preMsgIndex", 0);
          com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          AppMethodBeat.o(35975);
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
        paramView.putExtra("message_id", localbl.field_msgId);
        paramView.putExtra("record_xml", paramAdapterView.gHI);
        com.tencent.mm.bs.d.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 24))
      {
        paramView = new nq();
        paramView.dsK.context = getContext();
        paramView.dsK.msgId = localbl.field_msgId;
        paramView.dsK.dsL = paramAdapterView.gHI;
        com.tencent.mm.sdk.b.a.ESL.l(paramView);
        AppMethodBeat.o(35975);
        return;
      }
      label1240:
      Object localObject4;
      label1297:
      boolean bool;
      if ((paramAdapterView != null) && (paramAdapterView.type == 7))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.h.j(paramAdapterView.appId, false, false);
        if (localObject2 != null)
        {
          localObject1 = this.talker;
          paramView = (View)localObject1;
          if (w.pF((String)localObject1)) {
            paramView = bi.uf(localbl.field_content);
          }
          paramLong = localbl.field_msgSvrId;
          if ((localObject2 != null) && (com.tencent.mm.pluginsdk.model.app.q.t(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName)))
          {
            paramInt = 3;
            if (paramAdapterView.type != 2) {
              break label1635;
            }
            paramInt = 4;
            localObject3 = new qj();
            ((qj)localObject3).dvV.context = getContext();
            ((qj)localObject3).dvV.scene = 1;
            ((qj)localObject3).dvV.dlB = paramAdapterView.appId;
            localObject4 = ((qj)localObject3).dvV;
            if (localObject2 != null) {
              break label1648;
            }
            localObject1 = null;
            ((qj.a)localObject4).packageName = ((String)localObject1);
            ((qj)localObject3).dvV.msgType = paramAdapterView.type;
            ((qj)localObject3).dvV.dpv = paramView;
            ((qj)localObject3).dvV.dvW = paramInt;
            ((qj)localObject3).dvV.mediaTagName = paramAdapterView.mediaTagName;
            ((qj)localObject3).dvV.drA = paramLong;
            ((qj)localObject3).dvV.dvX = "";
            ((qj)localObject3).dvV.dbt = this.talker;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
            paramView = com.tencent.mm.plugin.game.api.b.a.cBi();
            if ((com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2)) || (paramView == null)) {
              break label1750;
            }
            if (bt.isNullOrNil(((y)localObject2).eom)) {
              break label1658;
            }
            bool = r.bK(getContext(), ((y)localObject2).eom);
            ad.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((y)localObject2).eom, Boolean.valueOf(bool) });
            if (!bool) {
              break label1658;
            }
            paramInt = 1;
          }
          for (;;)
          {
            if (paramInt == 0)
            {
              if ((paramAdapterView.dbA == null) || (paramAdapterView.dbA.length() == 0))
              {
                paramView = localbl.field_content;
                paramAdapterView = paramView;
                if (localbl.field_isSend == 0)
                {
                  paramInt = localbl.field_isSend;
                  paramAdapterView = paramView;
                  if (!this.qbB)
                  {
                    paramAdapterView = paramView;
                    if (w.pF(this.talker))
                    {
                      paramAdapterView = paramView;
                      if (paramView != null)
                      {
                        paramAdapterView = paramView;
                        if (paramInt == 0) {
                          paramAdapterView = bi.ug(paramView);
                        }
                      }
                    }
                  }
                }
                paramView = k.b.rx(paramAdapterView);
                localObject1 = com.tencent.mm.pluginsdk.model.app.h.j(paramView.appId, true, false);
                if ((localObject1 != null) && (com.tencent.mm.pluginsdk.model.app.q.t(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName)))
                {
                  if (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_status == 3)
                  {
                    ad.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
                    AppMethodBeat.o(35975);
                    return;
                    paramInt = 6;
                    break;
                    label1635:
                    if (paramAdapterView.type != 5) {
                      break label1240;
                    }
                    paramInt = 1;
                    break label1240;
                    label1648:
                    localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName;
                    break label1297;
                    label1658:
                    localObject1 = new ho();
                    ((ho)localObject1).dlk.actionCode = 2;
                    ((ho)localObject1).dlk.scene = 1;
                    ((ho)localObject1).dlk.appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
                    ((ho)localObject1).dlk.context = getContext();
                    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
                    new Intent();
                    getContext();
                    paramView.ag(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId, 1, 1);
                    paramInt = 1;
                    continue;
                    label1750:
                    paramInt = 0;
                    continue;
                  }
                  if (!com.tencent.mm.pluginsdk.model.app.q.b(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                  {
                    ad.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName });
                    Toast.makeText(getContext(), getString(2131759894, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, null) }), 1).show();
                    AppMethodBeat.o(35975);
                    return;
                  }
                  if (a(localbl, (com.tencent.mm.pluginsdk.model.app.g)localObject1)) {
                    break label2060;
                  }
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.dbA != null) && (paramView.dbA.length() > 0))
                  {
                    paramAdapterView = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(paramView.dbA);
                    if (paramAdapterView != null) {
                      break label2006;
                    }
                  }
                  label2006:
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
                    paramAdapterView.thumbData = com.tencent.mm.vfs.i.aR(o.ayF().yg(localbl.field_imgPath), 0, -1);
                    new as(this).a(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramAdapterView, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_openId);
                    AppMethodBeat.o(35975);
                    return;
                  }
                }
                paramAdapterView = com.tencent.mm.pluginsdk.model.app.q.K(getContext(), paramView.appId, "message");
                paramView = new Intent();
                paramView.putExtra("rawUrl", paramAdapterView);
                com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                label2060:
                AppMethodBeat.o(35975);
                return;
              }
              if (!this.nMt)
              {
                t.g(getContext(), null);
                AppMethodBeat.o(35975);
                return;
              }
              paramAdapterView = new Intent();
              paramAdapterView.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              paramAdapterView.putExtra("app_msg_id", localbl.field_msgId);
              startActivityForResult(paramAdapterView, 210);
            }
          }
        }
        AppMethodBeat.o(35975);
        return;
      }
      int i;
      if ((localbl.cjM()) || (localbl.eJO()) || (localbl.cjO()) || (localbl.eMb()))
      {
        if ((paramAdapterView == null) || (bt.isNullOrNil(paramAdapterView.gJv)))
        {
          i = 0;
          if (i != 0) {
            AppMethodBeat.o(35975);
          }
        }
        else
        {
          localObject1 = localbl.field_imgPath;
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("KFromTimeLine", false);
          ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.gJv);
          ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.gJA);
          ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
          ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localbl.field_msgId);
          ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.gJw);
          ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.gJz);
          ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.gJy);
          ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
          localObject2 = localbl.field_talker;
          bool = w.pF((String)localObject2);
          if (bool)
          {
            localObject1 = bi.uf(localbl.field_content);
            label2372:
            ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.gJB);
            ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.gJC);
            ((Intent)localObject3).putExtra("KSta_SourceType", 1);
            if (!bool) {
              break label2558;
            }
            i = a.b.Gjt.value;
            label2421:
            ((Intent)localObject3).putExtra("KSta_Scene", i);
            ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
            ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
            ((Intent)localObject3).putExtra("KSta_MsgId", localbl.field_msgSvrId);
            ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.dxG);
            if (bool) {
              ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.q.rY((String)localObject2));
            }
            if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pjp, 0) <= 0) {
              break label2569;
            }
            com.tencent.mm.bs.d.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
            ad.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
          }
          for (;;)
          {
            i = 1;
            break;
            localObject1 = localObject2;
            break label2372;
            label2558:
            i = a.b.Gjs.value;
            break label2421;
            label2569:
            com.tencent.mm.bs.d.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
          }
        }
        aB(paramView, paramInt);
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 15))
      {
        localObject1 = paramAdapterView.gHL;
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TG(paramAdapterView.url);
        }
        if (TextUtils.isEmpty(paramView))
        {
          paramView = new Intent();
          paramView.putExtra("geta8key_username", u.aqG());
          paramView.putExtra("rawUrl", paramAdapterView.url);
          com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          AppMethodBeat.o(35975);
          return;
        }
        ad.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("extra_id", paramView);
        paramAdapterView.putExtra("preceding_scence", 123);
        paramAdapterView.putExtra("download_entrance_scene", 23);
        com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
        com.tencent.mm.plugin.report.service.h.vKh.f(10993, new Object[] { Integer.valueOf(2), paramView });
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 26))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.gJt;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", bX(localbl));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.eOT);
          ((Intent)localObject4).putExtra("topic_id", paramInt);
          ((Intent)localObject4).putExtra("topic_name", paramView);
          ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
          ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
          ((Intent)localObject4).putExtra("extra_scence", 23);
          com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
          AppMethodBeat.o(35975);
          return;
        }
        ad.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        AppMethodBeat.o(35975);
        return;
      }
      if ((paramAdapterView != null) && (paramAdapterView.type == 27))
      {
        paramInt = paramAdapterView.tid;
        paramView = paramAdapterView.gJt;
        localObject1 = paramAdapterView.desc;
        localObject2 = paramAdapterView.iconUrl;
        localObject3 = paramAdapterView.secondUrl;
        i = paramAdapterView.pageType;
        if (paramInt != 0)
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("geta8key_username", bX(localbl));
          ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.eOT);
          ((Intent)localObject4).putExtra("set_id", paramInt);
          ((Intent)localObject4).putExtra("set_title", paramView);
          ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
          ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
          ((Intent)localObject4).putExtra("headurl", (String)localObject3);
          ((Intent)localObject4).putExtra("pageType", i);
          com.tencent.mm.bs.d.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
          AppMethodBeat.o(35975);
          return;
        }
        ad.i("MicroMsg.GalleryGridUI", "topic id is zero.");
        AppMethodBeat.o(35975);
        return;
      }
      ad.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localbl.field_talker, Long.valueOf(localbl.field_msgId), Integer.valueOf(localbl.getType()), localbl.field_content });
      if ((paramAdapterView.url != null) && (!paramAdapterView.url.equals("")) && (paramAdapterView.url != null) && (!paramAdapterView.url.equals("")))
      {
        localObject1 = paramAdapterView.url;
        if (!w.pF(this.talker)) {
          break label3710;
        }
        paramView = "groupmessage";
        localObject3 = com.tencent.mm.pluginsdk.model.app.q.O((String)localObject1, paramView);
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
          break label3717;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        label3443:
        if (localObject2 != null) {
          break label3733;
        }
        paramView = null;
        label3450:
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3742;
        }
      }
      label3717:
      label3733:
      label3742:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!bt.isNullOrNil(paramAdapterView.dxz))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.dxz);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.dxA);
        }
        ((Intent)localObject1).putExtra("msg_id", localbl.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localbl.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", u.aqG());
        ((Intent)localObject1).putExtra("pre_username", bX(localbl));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localbl.field_msgSvrId));
        paramAdapterView = bX(localbl);
        paramView = u.aqG();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", x.aw(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.bs.d.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        AppMethodBeat.o(35975);
        return;
        label3710:
        paramView = "singlemessage";
        break;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3443;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3450;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35984);
    if (paramMenuItem.getTitle().equals(getString(2131759768)))
    {
      h.a.eZA().clear();
      cjK();
    }
    for (;;)
    {
      AppMethodBeat.o(35984);
      return false;
      cjL();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(35970);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    Zj(1);
    AppMethodBeat.o(35970);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35968);
    h.a.eZA().qjV.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(35968);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(35983);
    Object localObject1 = (c.a)this.GAY.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(35983);
      return true;
    }
    Object localObject2 = ((c.a)localObject1).qkg.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(35983);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((c.a)localObject1).qkg.getMeasuredWidth();
    int j = ((c.a)localObject1).qkg.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((c.a)localObject1).qki.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((c.a)localObject1).qki.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((c.a)localObject1).qki;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.GBg = ((View)localObject1);
      this.handler.postDelayed(new ImageGalleryGridUI.7(this, (View)localObject1, (TimeInterpolator)localObject2), 700L);
    }
    AppMethodBeat.o(35983);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(35967);
    h.a.eZA().a(this);
    this.mIsPause = false;
    if (this.qjI)
    {
      if (!h.a.eZA().qjU) {
        break label143;
      }
      cjK();
    }
    for (;;)
    {
      this.handler.postDelayed(this.GBe, 300L);
      super.onResume();
      if (this.GAX != null)
      {
        this.GAX.GAP = true;
        c localc = this.GAX;
        if (localc.GAP) {
          localc.notifyDataSetChanged();
        }
        if (h.a.eZA().qjU) {
          setMMTitle(getString(2131759814, new Object[] { Integer.valueOf(h.a.eZA().qjT.size()) }));
        }
      }
      this.qjI = false;
      eZw();
      AppMethodBeat.o(35967);
      return;
      label143:
      cjL();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */