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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.z.a;
import com.tencent.mm.av.i;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.ry.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.vfs.s;
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
  implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, com.tencent.mm.ag.z, h.b
{
  private Animation Dog;
  private GridView EAK;
  private long Pwr;
  public View PxA;
  private View PxB;
  private int PxC;
  private View PxD;
  private View PxE;
  private View PxF;
  private View PxG;
  public int Pxq;
  c Pxr;
  private WeakReference<c.a> Pxs;
  private Boolean Pxt;
  private Boolean Pxu;
  private TextView Pxv;
  private TextView Pxw;
  private Runnable Pxx;
  private Runnable Pxy;
  Runnable Pxz;
  protected MMHandler handler;
  private boolean mIsPause;
  public long ppv;
  private IListener qoC;
  private boolean qoo;
  private String talker;
  public boolean tca;
  private boolean tkg;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(35964);
    this.Pxx = new Runnable()
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
    this.Pxy = new Runnable()
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
    this.qoC = new ImageGalleryGridUI.4(this);
    this.tkg = false;
    this.qoo = false;
    this.Pwr = 0L;
    this.Pxz = new ImageGalleryGridUI.8(this);
    this.PxA = null;
    this.PxC = -1;
    this.mIsPause = true;
    AppMethodBeat.o(35964);
  }
  
  @TargetApi(11)
  private void Rs(int paramInt)
  {
    AppMethodBeat.i(35972);
    handleIntent(getIntent());
    setMMTitle(getString(2131755293));
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
    this.PxB = findViewById(2131304862);
    Object localObject = findViewById(2131300433);
    this.PxD = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131309388);
    this.PxE = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131307209);
    this.PxF = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(2131299448);
    this.PxG = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.Pxv = ((TextView)findViewById(2131296701));
    this.Pxw = ((TextView)findViewById(2131296673));
    if (paramInt == 0)
    {
      this.EAK = ((GridView)findViewById(2131302566));
      this.EAK.setOnItemClickListener(this);
      this.EAK.setNumColumns(3);
      localObject = new ca();
      if (this.tca) {
        ((ca)localObject).yG(this.ppv);
      }
      this.Pxr = new c(this, (ca)localObject, this.talker);
      if (this.Pxr.getCount() == 0)
      {
        this.Pxw.setVisibility(0);
        AppMethodBeat.o(35972);
        return;
      }
      this.Pxw.setVisibility(8);
      this.EAK.setAdapter(this.Pxr);
      gSj();
    }
    for (;;)
    {
      this.EAK.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable qpo;
        
        private void kI(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35957);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.qpo);
            if (ImageGalleryGridUI.b(ImageGalleryGridUI.this).getVisibility() != 0)
            {
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).clearAnimation();
              Animation localAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.getContext(), 2130772059);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).setVisibility(0);
              ImageGalleryGridUI.b(ImageGalleryGridUI.this).startAnimation(localAnimation);
              AppMethodBeat.o(35957);
            }
          }
          else
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.qpo);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.qpo, 256L);
          }
          AppMethodBeat.o(35957);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(35959);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (ca)paramAnonymousAbsListView.Pxr.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.gWr().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            AppMethodBeat.o(35959);
            return;
            localObject = new Date(((eo)localObject).field_createTime);
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(35958);
          if (1 == paramAnonymousInt) {
            kI(true);
          }
          for (;;)
          {
            com.tencent.mm.av.q.bcV().onScrollStateChanged(paramAnonymousInt);
            AppMethodBeat.o(35958);
            return;
            if (paramAnonymousInt == 0) {
              kI(false);
            }
          }
        }
      });
      AppMethodBeat.o(35972);
      return;
      if (this.Pxr != null)
      {
        this.Pxr.notifyDataSetChanged();
        gSj();
      }
    }
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
    paramca.setClassName("com.tencent.mobileqq", bs(getContext(), "com.tencent.mobileqq"));
    paramca.putExtra("platformId", "wechat");
    bg.aVF();
    paramg = com.tencent.mm.model.c.azQ().get(9, null);
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
        label299:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramca = new com.tencent.mm.hellhoundlib.b.a().bl(paramca);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramca.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramca.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35976);
            return true;
            paramg = paramg;
            Log.printErrStackTrace("MicroMsg.GalleryGridUI", paramg, "", new Object[0]);
          }
        }
        catch (Exception paramca)
        {
          break label299;
        }
      }
    }
  }
  
  private void aK(View paramView, int paramInt)
  {
    AppMethodBeat.i(35982);
    if (this.Pxr == null)
    {
      AppMethodBeat.o(35982);
      return;
    }
    Log.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.ppv);
    localIntent.putExtra("key_is_biz_chat", this.tca);
    localIntent.putExtra("intent.key.with.footer", true);
    ca localca = (ca)this.Pxr.getItem(paramInt);
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
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(0, 0);
      AppMethodBeat.o(35982);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private static String bs(Context paramContext, String paramString)
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
        Log.printErrStackTrace("MicroMsg.GalleryGridUI", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35977);
    return paramContext;
  }
  
  private void c(cz paramcz)
  {
    AppMethodBeat.i(35991);
    paramcz.dFZ.activity = this;
    paramcz.dFZ.dGf = 45;
    EventCenter.instance.publish(paramcz);
    if ((paramcz.dGa.ret == -2) || (paramcz.dGa.ret > 0))
    {
      AppMethodBeat.o(35991);
      return;
    }
    if (paramcz.dGa.ret <= 0)
    {
      cWI();
      if (14 != paramcz.dFZ.type)
      {
        Log.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(35991);
        return;
      }
      if (paramcz.dFZ.dGc == null)
      {
        Log.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(35991);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(11142, new Object[] { Integer.valueOf(paramcz.dFZ.dGc.Lyp), Integer.valueOf(paramcz.dFZ.dGc.Lyq), Integer.valueOf(paramcz.dFZ.dGc.Lyr), Integer.valueOf(paramcz.dFZ.dGc.xiP), Integer.valueOf(paramcz.dFZ.dGc.Lys), Integer.valueOf(paramcz.dFZ.dGc.Lyt), Integer.valueOf(paramcz.dFZ.dGc.Lyu), Integer.valueOf(paramcz.dFZ.dGc.fileCount), Integer.valueOf(paramcz.dFZ.dGc.Lyv), Integer.valueOf(paramcz.dFZ.dGc.Lyw), Integer.valueOf(paramcz.dFZ.dGc.Lyx), Integer.valueOf(paramcz.dFZ.dGc.Lyy), Integer.valueOf(paramcz.dFZ.dGc.Lyz), Integer.valueOf(paramcz.dFZ.dGc.LyA), Integer.valueOf(paramcz.dFZ.dGc.LyB) });
    }
    AppMethodBeat.o(35991);
  }
  
  private void cWH()
  {
    AppMethodBeat.i(35985);
    setMMTitle(getString(2131761144, new Object[] { Integer.valueOf(h.a.gSp().tkt.size()) }));
    h.a.gSp().tku = true;
    if (this.Pxr == null)
    {
      AppMethodBeat.o(35985);
      return;
    }
    if (this.Dog == null) {
      this.Dog = AnimationUtils.loadAnimation(this, 2130772132);
    }
    this.Pxr.cWH();
    this.PxB.setVisibility(0);
    this.PxB.startAnimation(this.Dog);
    this.PxD.setEnabled(false);
    this.PxE.setEnabled(false);
    this.PxF.setEnabled(false);
    this.PxG.setEnabled(false);
    this.PxC = this.EAK.getPaddingBottom();
    this.EAK.setPadding(this.EAK.getPaddingLeft(), this.EAK.getPaddingTop(), this.EAK.getPaddingRight(), com.tencent.mm.cb.a.aG(getContext(), 2131165585));
    com.tencent.mm.plugin.report.service.h.CyF.a(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131761092), this);
    AppMethodBeat.o(35985);
  }
  
  private String cw(ca paramca)
  {
    AppMethodBeat.i(35978);
    String str = Util.nullAs(this.talker, "");
    boolean bool = ab.Eq(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(35978);
      return str;
    }
    if (bool)
    {
      paramca = bp.Ks(paramca.field_content);
      if ((paramca == null) || (paramca.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(35978);
      return paramca;
      paramca = str;
    }
  }
  
  private void cx(ca paramca)
  {
    AppMethodBeat.i(35981);
    if (!gSk())
    {
      u.g(getContext(), null);
      AppMethodBeat.o(35981);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", paramca.field_msgId);
    paramca = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramca.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramca.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35981);
  }
  
  private void gSj()
  {
    AppMethodBeat.i(35973);
    int i = this.EAK.getFirstVisiblePosition();
    int j = this.EAK.getLastVisiblePosition();
    int k = this.Pxq;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(35973);
      return;
    }
    this.EAK.setSelection(k);
    AppMethodBeat.o(35973);
  }
  
  private boolean gSk()
  {
    AppMethodBeat.i(35980);
    long l1 = this.Pwr;
    long l2 = System.currentTimeMillis();
    this.Pwr = l2;
    if (l1 + 30000L < l2)
    {
      bg.aVF();
      this.qoo = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.qoo;
    AppMethodBeat.o(35980);
    return bool;
  }
  
  private void gSl()
  {
    AppMethodBeat.i(35986);
    if ((!h.a.gSp().tkt.isEmpty()) && (h.a.gSp().tku)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.PxD.setEnabled(true);
      this.PxE.setEnabled(true);
      this.PxF.setEnabled(true);
      this.PxG.setEnabled(true);
      AppMethodBeat.o(35986);
      return;
    }
    this.PxD.setEnabled(false);
    this.PxE.setEnabled(false);
    this.PxF.setEnabled(false);
    this.PxG.setEnabled(false);
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
  
  private void handleIntent(Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(35969);
    if (paramIntent.getIntExtra("kintent_intent_source", 0) == 1) {}
    for (;;)
    {
      this.Pxt = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.Pxq = paramIntent.getIntExtra("kintent_image_index", 0);
      this.tca = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.Pxu = Boolean.TRUE;
      AppMethodBeat.o(35969);
      return;
      bool = false;
    }
  }
  
  private static void jo(List<ca> paramList)
  {
    AppMethodBeat.i(35989);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.PcW, a.d.Pdb, localca, 0);
    }
    AppMethodBeat.o(35989);
  }
  
  private static List<ca> jt(List<ca> paramList)
  {
    AppMethodBeat.i(35990);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ca localca = (ca)paramList.next();
      if ((!b.cn(localca)) && (!b.co(localca)) && (!b.cq(localca))) {
        localArrayList.add(localca);
      }
    }
    AppMethodBeat.o(35990);
    return localArrayList;
  }
  
  public final void B(Bundle paramBundle) {}
  
  public final void a(z.a parama) {}
  
  public final boolean aSC()
  {
    return true;
  }
  
  public final boolean aSD()
  {
    return false;
  }
  
  public final boolean aSE()
  {
    return false;
  }
  
  public final void b(z.a parama) {}
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35994);
    if (parama == z.a.iAT)
    {
      this.Pxr.anp();
      this.Pxr.notifyDataSetChanged();
    }
    cWI();
    AppMethodBeat.o(35994);
  }
  
  public final void cWI()
  {
    AppMethodBeat.i(35987);
    h.a.gSp().tku = false;
    setMMTitle(getString(2131755293));
    if (this.Pxr == null)
    {
      AppMethodBeat.o(35987);
      return;
    }
    this.Pxr.notifyDataSetChanged();
    if (this.PxC >= 0) {
      this.EAK.setPadding(this.EAK.getPaddingLeft(), this.EAK.getPaddingTop(), this.EAK.getPaddingRight(), this.PxC);
    }
    this.PxB.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(2131761093), this);
    AppMethodBeat.o(35987);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35993);
    if ((this.Pxr != null) && (this.mIsPause)) {
      this.Pxr.Pxj = true;
    }
    gSl();
    AppMethodBeat.o(35993);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35974);
    super.finish();
    h.a.gSp().detach();
    AppMethodBeat.o(35974);
  }
  
  public boolean fromFullScreenActivity()
  {
    return true;
  }
  
  public final void gSm()
  {
    AppMethodBeat.i(35992);
    if ((this.Pxr != null) && (this.mIsPause)) {
      this.Pxr.Pxj = true;
    }
    setMMTitle(getString(2131761144, new Object[] { Integer.valueOf(h.a.gSp().tkt.size()) }));
    gSl();
    AppMethodBeat.o(35992);
  }
  
  public int getLayoutId()
  {
    return 2131495056;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(35971);
    if (h.a.gSp().tku)
    {
      cWI();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.Pxt.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.Pxq >= 0) {
      aK(null, this.Pxq);
    }
    finish();
    AppMethodBeat.o(35971);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(35988);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    if (h.a.gSp().tkt.isEmpty())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    boolean bool = ab.Eq(this.talker);
    Object localObject2 = h.a.gSp().tkt;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == 2131299448)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((ca)((Iterator)localObject1).next()).field_msgId));
      }
      com.tencent.mm.ui.base.h.c(this, getString(2131757780), "", getString(2131758290), getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35962);
          Log.i("MicroMsg.GalleryGridUI", "delete message");
          com.tencent.mm.ui.chatting.j.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.cWI();
          AppMethodBeat.o(35962);
        }
      }, null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
      if (paramView.getId() == 2131300433)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 18L, 1L, true);
        final cz localcz = new cz();
        if (com.tencent.mm.pluginsdk.model.j.a(getContext(), localcz, this.talker, (List)localObject2, false))
        {
          c(localcz);
          jo((List)localObject2);
        }
        else
        {
          if (((List)localObject2).size() > 1)
          {
            AppCompatActivity localAppCompatActivity = getContext();
            if (localcz.dFZ.dGe >= 0)
            {
              paramView = getContext().getString(2131759223);
              label373:
              if (localcz.dFZ.dGe < 0) {
                break label446;
              }
            }
            label446:
            for (localObject1 = getContext().getString(2131757787);; localObject1 = getContext().getString(2131763947))
            {
              com.tencent.mm.ui.base.h.c(localAppCompatActivity, paramView, "", (String)localObject1, getContext().getString(2131757785), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(35963);
                  if ((localcz.dFZ.type == 14) && (localcz.dFZ.dGb.ppH.size() == 0))
                  {
                    ImageGalleryGridUI.this.cWI();
                    AppMethodBeat.o(35963);
                    return;
                  }
                  ImageGalleryGridUI.a(ImageGalleryGridUI.this, localcz);
                  ImageGalleryGridUI.ju(this.hjk);
                  AppMethodBeat.o(35963);
                }
              }, null);
              break;
              paramView = getContext().getString(2131759222);
              break label373;
            }
          }
          com.tencent.mm.ui.base.h.n(getContext(), localcz.dFZ.dGe, 0);
        }
      }
      else if (paramView.getId() == 2131309388)
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 19L, 1L, true);
        l.a(this, (List)localObject2, bool, this.talker, this);
        cWI();
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(11627, new Object[] { Integer.valueOf(3) });
        paramView = jt((List)localObject2);
        if (paramView.size() != ((List)localObject2).size())
        {
          com.tencent.mm.ui.base.h.a(getContext(), 2131761127, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35951);
              b.f(ImageGalleryGridUI.this.getContext(), paramView);
              ImageGalleryGridUI.this.cWI();
              AppMethodBeat.o(35951);
            }
          }, null);
        }
        else
        {
          localObject1 = (ca)paramView.get(0);
          if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((ca)localObject1).dOQ()))
          {
            localObject2 = ((eo)localObject1).field_content;
            paramView = null;
            if (localObject2 != null) {
              paramView = k.b.aD((String)localObject2, ((eo)localObject1).field_reserved);
            }
            if ((paramView != null) && (paramView.type == 6)) {
              cx((ca)localObject1);
            }
          }
          else
          {
            b.f(this, (List)localObject2);
            cWI();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35965);
    super.onCreate(paramBundle);
    this.tkg = true;
    this.handler = new MMHandler();
    Rs(0);
    EventCenter.instance.addListener(this.qoC);
    AppMethodBeat.o(35965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35966);
    this.handler.removeCallbacks(this.Pxy);
    this.handler = null;
    com.tencent.mm.av.q.bcV().onScrollStateChanged(0);
    EventCenter.instance.removeListener(this.qoC);
    super.onDestroy();
    AppMethodBeat.o(35966);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35975);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    ca localca = (ca)this.Pxr.getItem(paramInt);
    paramAdapterView = localca.field_content;
    if (paramAdapterView != null) {}
    label266:
    label275:
    label1050:
    label1059:
    label3753:
    for (paramAdapterView = k.b.aD(paramAdapterView, localca.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6)) {
        cx(localca);
      }
      Object localObject2;
      Object localObject3;
      label192:
      label612:
      label766:
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(35975);
          return;
          if ((paramAdapterView != null) && (paramAdapterView.type == 3))
          {
            localObject1 = com.tencent.mm.pluginsdk.model.app.q.R(paramAdapterView.url, "message");
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.R(paramAdapterView.iwH, "message");
            localObject3 = getPackageInfo(getContext(), paramAdapterView.appId);
            if (localObject3 == null)
            {
              paramView = null;
              if (localObject3 != null) {
                break label266;
              }
            }
            long l;
            for (paramInt = 0;; paramInt = ((PackageInfo)localObject3).versionCode)
            {
              localObject3 = paramAdapterView.appId;
              paramLong = localca.field_msgId;
              l = localca.field_msgSvrId;
              if (((localObject1 != null) && (((String)localObject1).length() != 0)) || ((localObject2 != null) && (((String)localObject2).length() != 0))) {
                break label275;
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
                  break label554;
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
              paramAdapterView = cw(localca);
              ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
              ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
              if (localca != null) {
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
              }
              ((Intent)localObject1).putExtra("preChatName", this.talker);
              ((Intent)localObject1).putExtra("preChatTYPE", ac.aJ(paramAdapterView, this.talker));
              ((Intent)localObject1).putExtra("preMsgIndex", 0);
              com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
              if (ab.Eq(this.talker))
              {
                paramView = "groupmessage";
                localObject3 = com.tencent.mm.pluginsdk.model.app.q.R((String)localObject1, paramView);
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
                  break label1034;
                }
                ((Intent)localObject1).putExtra("shortUrl", paramView);
                if (localObject2 != null) {
                  break label1050;
                }
                paramView = null;
                ((Intent)localObject1).putExtra("version_name", paramView);
                if (localObject2 != null) {
                  break label1059;
                }
              }
              for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
              {
                ((Intent)localObject1).putExtra("version_code", paramInt);
                if (!Util.isNullOrNil(paramAdapterView.eag))
                {
                  ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.eag);
                  ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.eah);
                }
                ((Intent)localObject1).putExtra("msg_id", localca.field_msgId);
                ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localca.field_msgSvrId));
                ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
                ((Intent)localObject1).putExtra("geta8key_username", this.talker);
                paramAdapterView = cw(localca);
                ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
                ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localca.field_msgSvrId));
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
                ((Intent)localObject1).putExtra("preChatName", this.talker);
                ((Intent)localObject1).putExtra("preChatTYPE", ac.aJ(paramAdapterView, this.talker));
                ((Intent)localObject1).putExtra("preMsgIndex", 0);
                com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
                break;
                paramView = "singlemessage";
                break label612;
                ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
                break label766;
                paramView = ((PackageInfo)localObject2).versionName;
                break label773;
              }
            }
          }
          else if ((paramAdapterView != null) && (paramAdapterView.type == 19))
          {
            paramView = new Intent();
            paramView.putExtra("message_id", localca.field_msgId);
            paramView.putExtra("record_xml", paramAdapterView.ixl);
            com.tencent.mm.br.c.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
          }
          else if ((paramAdapterView != null) && (paramAdapterView.type == 24))
          {
            paramView = new pa();
            paramView.dVb.context = getContext();
            paramView.dVb.msgId = localca.field_msgId;
            paramView.dVb.dVc = paramAdapterView.ixl;
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
                if (ab.Eq((String)localObject1)) {
                  paramView = bp.Ks(localca.field_content);
                }
                paramLong = localca.field_msgSvrId;
                if ((localObject2 != null) && (com.tencent.mm.pluginsdk.model.app.q.s(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName)))
                {
                  paramInt = 3;
                  if (paramAdapterView.type != 2) {
                    break label1682;
                  }
                  paramInt = 4;
                  localObject3 = new ry();
                  ((ry)localObject3).dYw.context = getContext();
                  ((ry)localObject3).dYw.scene = 1;
                  ((ry)localObject3).dYw.dNI = paramAdapterView.appId;
                  localObject4 = ((ry)localObject3).dYw;
                  if (localObject2 != null) {
                    break label1695;
                  }
                  localObject1 = null;
                  ((ry.a)localObject4).packageName = ((String)localObject1);
                  ((ry)localObject3).dYw.msgType = paramAdapterView.type;
                  ((ry)localObject3).dYw.dRL = paramView;
                  ((ry)localObject3).dYw.dYx = paramInt;
                  ((ry)localObject3).dYw.mediaTagName = paramAdapterView.mediaTagName;
                  ((ry)localObject3).dYw.dTS = paramLong;
                  ((ry)localObject3).dYw.dYy = "";
                  ((ry)localObject3).dYw.dCw = this.talker;
                  EventCenter.instance.publish((IEvent)localObject3);
                  paramView = com.tencent.mm.plugin.game.api.b.a.dSQ();
                  if ((com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject2)) || (paramView == null)) {
                    break label1797;
                  }
                  if (Util.isNullOrNil(((y)localObject2).fmK)) {
                    break label1705;
                  }
                  bool = r.ck(getContext(), ((y)localObject2).fmK);
                  Log.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((y)localObject2).fmK, Boolean.valueOf(bool) });
                  if (!bool) {
                    break label1705;
                  }
                  paramInt = 1;
                }
                for (;;)
                {
                  if (paramInt != 0) {
                    break label1800;
                  }
                  if ((paramAdapterView.dCK != null) && (paramAdapterView.dCK.length() != 0)) {
                    break label2102;
                  }
                  paramView = localca.field_content;
                  paramAdapterView = paramView;
                  if (localca.field_isSend == 0)
                  {
                    paramInt = localca.field_isSend;
                    paramAdapterView = paramView;
                    if (!this.tca)
                    {
                      paramAdapterView = paramView;
                      if (ab.Eq(this.talker))
                      {
                        paramAdapterView = paramView;
                        if (paramView != null)
                        {
                          paramAdapterView = paramView;
                          if (paramInt == 0) {
                            paramAdapterView = bp.Kt(paramView);
                          }
                        }
                      }
                    }
                  }
                  paramView = k.b.HD(paramAdapterView);
                  localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
                  if ((localObject1 == null) || (!com.tencent.mm.pluginsdk.model.app.q.s(getContext(), ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName))) {
                    break label2053;
                  }
                  if (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_status != 3) {
                    break label1802;
                  }
                  Log.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName);
                  break;
                  paramInt = 6;
                  break label1281;
                  if (paramAdapterView.type != 5) {
                    break label1291;
                  }
                  paramInt = 1;
                  break label1291;
                  localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_packageName;
                  break label1348;
                  localObject1 = new is();
                  ((is)localObject1).dNr.actionCode = 2;
                  ((is)localObject1).dNr.scene = 1;
                  ((is)localObject1).dNr.appId = ((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId;
                  ((is)localObject1).dNr.context = getContext();
                  EventCenter.instance.publish((IEvent)localObject1);
                  new Intent();
                  getContext();
                  paramView.am(((com.tencent.mm.pluginsdk.model.app.g)localObject2).field_appId, 1, 1);
                  paramInt = 1;
                  continue;
                  paramInt = 0;
                }
                continue;
                if (!com.tencent.mm.pluginsdk.model.app.q.b(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                {
                  Log.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName });
                  Toast.makeText(getContext(), getString(2131761232, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, null) }), 1).show();
                }
                else if (!a(localca, (com.tencent.mm.pluginsdk.model.app.g)localObject1))
                {
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.dCK != null) && (paramView.dCK.length() > 0))
                  {
                    paramAdapterView = com.tencent.mm.pluginsdk.model.app.ao.cgO().bdx(paramView.dCK);
                    if (paramAdapterView != null) {
                      break label2045;
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
                    paramAdapterView.thumbData = s.aW(com.tencent.mm.av.q.bcR().Oz(localca.field_imgPath), 0, -1);
                    new au(this).a(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramAdapterView, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_openId);
                    break;
                  }
                  paramAdapterView = com.tencent.mm.pluginsdk.model.app.q.R(getContext(), paramView.appId, "message");
                  paramView = new Intent();
                  paramView.putExtra("rawUrl", paramAdapterView);
                  com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                  continue;
                  if (!this.qoo)
                  {
                    u.g(getContext(), null);
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
              if ((localca.cWJ()) || (localca.gAz()) || (localca.cWL()) || (localca.gDr()))
              {
                if ((paramAdapterView == null) || (Util.isNullOrNil(paramAdapterView.iyZ)))
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
                  ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.iyZ);
                  ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.ize);
                  ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
                  ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localca.field_msgId);
                  ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.iza);
                  ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.izd);
                  ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.izc);
                  ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
                  localObject2 = localca.field_talker;
                  bool = ab.Eq((String)localObject2);
                  if (bool)
                  {
                    localObject1 = bp.Ks(localca.field_content);
                    ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.izf);
                    ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.izg);
                    ((Intent)localObject3).putExtra("KSta_SourceType", 1);
                    if (!bool) {
                      break label2601;
                    }
                    i = a.b.PcT.value;
                    ((Intent)localObject3).putExtra("KSta_Scene", i);
                    ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
                    ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
                    ((Intent)localObject3).putExtra("KSta_MsgId", localca.field_msgSvrId);
                    ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.ean);
                    if (bool) {
                      ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", v.Ie((String)localObject2));
                    }
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rOS, 0) <= 0) {
                      break label2612;
                    }
                    com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
                    Log.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    localObject1 = localObject2;
                    break label2415;
                    i = a.b.PcS.value;
                    break label2464;
                    com.tencent.mm.br.c.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
                  }
                }
                aK(paramView, paramInt);
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 15))
              {
                localObject1 = paramAdapterView.ixo;
                paramView = (View)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramView = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().ams(paramAdapterView.url);
                }
                if (TextUtils.isEmpty(paramView))
                {
                  paramView = new Intent();
                  paramView.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
                  paramView.putExtra("rawUrl", paramAdapterView.url);
                  com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                }
                else
                {
                  Log.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                  paramAdapterView = new Intent();
                  paramAdapterView.putExtra("extra_id", paramView);
                  paramAdapterView.putExtra("preceding_scence", 123);
                  paramAdapterView.putExtra("download_entrance_scene", 23);
                  com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAdapterView);
                  com.tencent.mm.plugin.report.service.h.CyF.a(10993, new Object[] { Integer.valueOf(2), paramView });
                }
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 26))
              {
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.iyW;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cw(localca));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.fQR);
                  ((Intent)localObject4).putExtra("topic_id", paramInt);
                  ((Intent)localObject4).putExtra("topic_name", paramView);
                  ((Intent)localObject4).putExtra("topic_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("topic_icon_url", (String)localObject2);
                  ((Intent)localObject4).putExtra("topic_ad_url", (String)localObject3);
                  ((Intent)localObject4).putExtra("extra_scence", 23);
                  com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiStoreTopicUI", (Intent)localObject4);
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
                paramView = paramAdapterView.iyW;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                i = paramAdapterView.pageType;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", cw(localca));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.fQR);
                  ((Intent)localObject4).putExtra("set_id", paramInt);
                  ((Intent)localObject4).putExtra("set_title", paramView);
                  ((Intent)localObject4).putExtra("set_iconURL", (String)localObject2);
                  ((Intent)localObject4).putExtra("set_desc", (String)localObject1);
                  ((Intent)localObject4).putExtra("headurl", (String)localObject3);
                  ((Intent)localObject4).putExtra("pageType", i);
                  com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", (Intent)localObject4);
                }
                else
                {
                  Log.i("MicroMsg.GalleryGridUI", "topic id is zero.");
                }
              }
            }
          }
        }
        Log.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localca.field_talker, Long.valueOf(localca.field_msgId), Integer.valueOf(localca.getType()), localca.field_content });
      } while ((paramAdapterView.url == null) || (paramAdapterView.url.equals("")) || (paramAdapterView.url == null) || (paramAdapterView.url.equals("")));
      label554:
      label1348:
      label2045:
      localObject1 = paramAdapterView.url;
      label1705:
      label2102:
      label2415:
      if (ab.Eq(this.talker))
      {
        paramView = "groupmessage";
        localObject3 = com.tencent.mm.pluginsdk.model.app.q.R((String)localObject1, paramView);
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
          break label3728;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        if (localObject2 != null) {
          break label3744;
        }
        paramView = null;
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3753;
        }
      }
      label2601:
      label2612:
      label3304:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!Util.isNullOrNil(paramAdapterView.eag))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.eag);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.eah);
        }
        ((Intent)localObject1).putExtra("msg_id", localca.field_msgId);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localca.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
        ((Intent)localObject1).putExtra("pre_username", cw(localca));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localca.field_msgSvrId));
        paramAdapterView = cw(localca);
        paramView = com.tencent.mm.model.z.aTY();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", ac.aJ(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        break;
        paramView = "singlemessage";
        break label3304;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3458;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3465;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35984);
    if (paramMenuItem.getTitle().equals(getString(2131761093)))
    {
      h.a.gSp().clear();
      cWH();
    }
    for (;;)
    {
      AppMethodBeat.o(35984);
      return false;
      cWI();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(35970);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    Rs(1);
    AppMethodBeat.o(35970);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35968);
    h.a.gSp().tkv.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(35968);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(35983);
    Object localObject1 = (c.a)this.Pxs.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(35983);
      return true;
    }
    Object localObject2 = ((c.a)localObject1).tkI.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(35983);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((c.a)localObject1).tkI.getMeasuredWidth();
    int j = ((c.a)localObject1).tkI.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((c.a)localObject1).tkK.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((c.a)localObject1).tkK.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((c.a)localObject1).tkK;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.PxA = ((View)localObject1);
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35960);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.PxK.animate().setDuration(500L).alpha(0.0F).withEndAction(ImageGalleryGridUI.this.Pxz).withLayer().setInterpolator(this.PxL);
            AppMethodBeat.o(35960);
            return;
          }
          if (ImageGalleryGridUI.this.handler == null)
          {
            AppMethodBeat.o(35960);
            return;
          }
          this.PxK.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.PxL);
          ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.Pxz, 500L);
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
    h.a.gSp().a(this);
    this.mIsPause = false;
    if (this.tkg)
    {
      if (!h.a.gSp().tku) {
        break label143;
      }
      cWH();
    }
    for (;;)
    {
      this.handler.postDelayed(this.Pxy, 300L);
      super.onResume();
      if (this.Pxr != null)
      {
        this.Pxr.Pxj = true;
        c localc = this.Pxr;
        if (localc.Pxj) {
          localc.notifyDataSetChanged();
        }
        if (h.a.gSp().tku) {
          setMMTitle(getString(2131761144, new Object[] { Integer.valueOf(h.a.gSp().tkt.size()) }));
        }
      }
      this.tkg = false;
      gSl();
      AppMethodBeat.o(35967);
      return;
      label143:
      cWI();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */