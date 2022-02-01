package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.a.ki;
import com.tencent.mm.autogen.a.kj;
import com.tencent.mm.autogen.a.rk;
import com.tencent.mm.autogen.a.un;
import com.tencent.mm.autogen.a.un.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.z.a;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.aw;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.vfs.y;
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
  implements MenuItem.OnMenuItemClickListener, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, AdapterView.OnItemClickListener, com.tencent.mm.message.z, n.b
{
  public boolean Aet;
  private boolean AmZ;
  private long Jfc;
  private Animation PHk;
  private GridView Rop;
  private TextView aeBA;
  private TextView aeBB;
  private Runnable aeBC;
  private Runnable aeBD;
  Runnable aeBE;
  public View aeBF;
  private View aeBG;
  private int aeBH;
  private View aeBI;
  private View aeBJ;
  private View aeBK;
  private View aeBL;
  public int aeBv;
  i aeBw;
  private WeakReference<i.a> aeBx;
  private Boolean aeBy;
  private Boolean aeBz;
  protected MMHandler handler;
  private boolean mIsPause;
  private String talker;
  public long vEb;
  private IListener wQB;
  private boolean wQm;
  
  public ImageGalleryGridUI()
  {
    AppMethodBeat.i(35964);
    this.aeBC = new Runnable()
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
    this.aeBD = new Runnable()
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
    this.wQB = new IListener(f.hfK) {};
    this.AmZ = false;
    this.wQm = false;
    this.Jfc = 0L;
    this.aeBE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(35961);
        if (ImageGalleryGridUI.this.aeBF != null)
        {
          ImageGalleryGridUI.this.aeBF.setVisibility(8);
          ImageGalleryGridUI.this.aeBF = null;
        }
        AppMethodBeat.o(35961);
      }
    };
    this.aeBF = null;
    this.aeBH = -1;
    this.mIsPause = true;
    AppMethodBeat.o(35964);
  }
  
  private boolean a(cc paramcc, g paramg)
  {
    AppMethodBeat.i(35976);
    if ((!paramcc.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35976);
      return false;
    }
    Log.d("MicroMsg.GalleryGridUI", "jacks open QQ");
    paramcc = new Intent("android.intent.action.MAIN", null);
    paramcc.addCategory("android.intent.category.LAUNCHER");
    paramcc.addFlags(268435456);
    paramcc.setClassName("com.tencent.mobileqq", bH(getContext(), "com.tencent.mobileqq"));
    paramcc.putExtra("platformId", "wechat");
    bh.bCz();
    paramg = com.tencent.mm.model.c.ban().d(9, null);
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
        paramcc.putExtra("tencent_gif", paramg);
        label288:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(paramcc);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramcc.aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramcc.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35976);
            return true;
            paramg = paramg;
            Log.printErrStackTrace("MicroMsg.GalleryGridUI", paramg, "", new Object[0]);
          }
        }
        catch (Exception paramcc)
        {
          break label288;
        }
      }
    }
  }
  
  private void aCL(int paramInt)
  {
    AppMethodBeat.i(35972);
    handleIntent(getIntent());
    setMMTitle(getString(R.l.grj));
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
    this.aeBG = findViewById(R.h.fOv);
    Object localObject = findViewById(R.h.fHL);
    this.aeBI = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(R.h.trans_btn);
    this.aeBJ = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(R.h.fVj);
    this.aeBK = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = findViewById(R.h.del_btn);
    this.aeBL = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.aeBA = ((TextView)findViewById(R.h.album_tips_bar));
    this.aeBB = ((TextView)findViewById(R.h.fqY));
    if (paramInt == 0)
    {
      this.Rop = ((GridView)findViewById(R.h.fKe));
      this.Rop.setOnItemClickListener(this);
      this.Rop.setNumColumns(3);
      localObject = new cc();
      if (this.Aet) {
        ((cc)localObject).gY(this.vEb);
      }
      this.aeBw = new i(this, (cc)localObject, this.talker);
      if (this.aeBw.getCount() == 0)
      {
        this.aeBB.setVisibility(0);
        AppMethodBeat.o(35972);
        return;
      }
      this.aeBB.setVisibility(8);
      this.Rop.setAdapter(this.aeBw);
      jvg();
    }
    for (;;)
    {
      this.Rop.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private Runnable wRo;
        
        private void np(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35957);
          if (paramAnonymousBoolean)
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.wRo);
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
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).removeCallbacks(this.wRo);
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).postDelayed(this.wRo, 256L);
          }
          AppMethodBeat.o(35957);
        }
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(35959);
          paramAnonymousAbsListView = ImageGalleryGridUI.this;
          Object localObject = (cc)paramAnonymousAbsListView.aeBw.getItem(paramAnonymousInt1);
          if (localObject == null) {}
          for (paramAnonymousAbsListView = null;; paramAnonymousAbsListView = com.tencent.mm.ui.gridviewheaders.a.jBw().a((Date)localObject, paramAnonymousAbsListView))
          {
            ImageGalleryGridUI.b(ImageGalleryGridUI.this).setText(paramAnonymousAbsListView);
            AppMethodBeat.o(35959);
            return;
            localObject = new Date(((cc)localObject).getCreateTime());
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(35958);
          if (1 == paramAnonymousInt) {
            np(true);
          }
          for (;;)
          {
            r.bKe().onScrollStateChanged(paramAnonymousInt);
            AppMethodBeat.o(35958);
            return;
            if (paramAnonymousInt == 0) {
              np(false);
            }
          }
        }
      });
      AppMethodBeat.o(35972);
      return;
      if (this.aeBw != null)
      {
        this.aeBw.notifyDataSetChanged();
        jvg();
      }
    }
  }
  
  private static String bH(Context paramContext, String paramString)
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
  
  private void bm(View paramView, int paramInt)
  {
    AppMethodBeat.i(35982);
    if (this.aeBw == null)
    {
      AppMethodBeat.o(35982);
      return;
    }
    Log.i("MicroMsg.GalleryGridUI", "[ImageGalleryUI] enter");
    Intent localIntent = new Intent(this, ImageGalleryUI.class);
    localIntent.putExtra("key_biz_chat_id", this.vEb);
    localIntent.putExtra("key_is_biz_chat", this.Aet);
    localIntent.putExtra("intent.key.with.footer", true);
    cc localcc = (cc)this.aeBw.getItem(paramInt);
    if (localcc == null)
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
    localIntent.putExtra("img_gallery_msg_id", localcc.field_msgId).putExtra("img_gallery_msg_svr_id", localcc.field_msgSvrId).putExtra("img_gallery_talker", localcc.field_talker).putExtra("img_gallery_chatroom_name", localcc.field_talker).putExtra("img_gallery_orientation", j);
    if (paramView != null) {
      localIntent.putExtra("img_gallery_width", i).putExtra("img_gallery_height", paramInt).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]).putExtra("img_gallery_enter_from_grid", true);
    }
    for (;;)
    {
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterGallery", "(Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      overridePendingTransition(0, 0);
      AppMethodBeat.o(35982);
      return;
      localIntent.putExtra("img_gallery_back_from_grid", true);
    }
  }
  
  private void c(dn paramdn)
  {
    AppMethodBeat.i(35991);
    paramdn.hDr.activity = this;
    paramdn.hDr.hDy = 45;
    paramdn.publish();
    if ((paramdn.hDs.ret == -2) || (paramdn.hDs.ret > 0))
    {
      AppMethodBeat.o(35991);
      return;
    }
    if (paramdn.hDs.ret <= 0)
    {
      dSG();
      if (14 != paramdn.hDr.type)
      {
        Log.d("MicroMsg.GalleryGridUI", "not record type, do not report");
        AppMethodBeat.o(35991);
        return;
      }
      if (paramdn.hDr.hDu == null)
      {
        Log.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
        AppMethodBeat.o(35991);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11142, new Object[] { Integer.valueOf(paramdn.hDr.hDu.ZBI), Integer.valueOf(paramdn.hDr.hDu.PTe), Integer.valueOf(paramdn.hDr.hDu.ZBJ), Integer.valueOf(paramdn.hDr.hDu.AXs), Integer.valueOf(paramdn.hDr.hDu.ZBK), Integer.valueOf(paramdn.hDr.hDu.ZBL), Integer.valueOf(paramdn.hDr.hDu.ZBM), Integer.valueOf(paramdn.hDr.hDu.ZBN), Integer.valueOf(paramdn.hDr.hDu.ZBO), Integer.valueOf(paramdn.hDr.hDu.ZBP), Integer.valueOf(paramdn.hDr.hDu.ZBQ), Integer.valueOf(paramdn.hDr.hDu.ZBR), Integer.valueOf(paramdn.hDr.hDu.ZBS), Integer.valueOf(paramdn.hDr.hDu.ZBT), Integer.valueOf(paramdn.hDr.hDu.ZBU) });
    }
    AppMethodBeat.o(35991);
  }
  
  private void dSF()
  {
    AppMethodBeat.i(35985);
    setMMTitle(getString(R.l.gIW, new Object[] { Integer.valueOf(n.a.jvm().Ann.size()) }));
    n.a.jvm().Ano = true;
    if (this.aeBw == null)
    {
      AppMethodBeat.o(35985);
      return;
    }
    if (this.PHk == null) {
      this.PHk = AnimationUtils.loadAnimation(this, R.a.push_up_in);
    }
    this.aeBw.dSF();
    this.aeBG.setVisibility(0);
    this.aeBG.startAnimation(this.PHk);
    this.aeBI.setEnabled(false);
    this.aeBJ.setEnabled(false);
    this.aeBK.setEnabled(false);
    this.aeBL.setEnabled(false);
    this.aeBH = this.Rop.getPaddingBottom();
    this.Rop.setPadding(this.Rop.getPaddingLeft(), this.Rop.getPaddingTop(), this.Rop.getPaddingRight(), com.tencent.mm.cd.a.br(getContext(), R.f.SmallListHeight));
    com.tencent.mm.plugin.report.service.h.OAn.b(11627, new Object[] { Integer.valueOf(2) });
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gIR), this);
    AppMethodBeat.o(35985);
  }
  
  private String dp(cc paramcc)
  {
    AppMethodBeat.i(35978);
    String str = Util.nullAs(this.talker, "");
    boolean bool = au.bwE(this.talker);
    if (!bool)
    {
      AppMethodBeat.o(35978);
      return str;
    }
    if (bool)
    {
      paramcc = br.JJ(paramcc.field_content);
      if ((paramcc == null) || (paramcc.length() <= 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(35978);
      return paramcc;
      paramcc = str;
    }
  }
  
  private void dq(cc paramcc)
  {
    AppMethodBeat.i(35981);
    if (!jvh())
    {
      aa.j(getContext(), null);
      AppMethodBeat.o(35981);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
    localIntent.putExtra("app_msg_id", paramcc.field_msgId);
    paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramcc.aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramcc.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "enterAppMsgShow", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35981);
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
      paramString = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
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
      this.aeBy = Boolean.valueOf(bool);
      this.talker = paramIntent.getStringExtra("kintent_talker");
      this.aeBv = paramIntent.getIntExtra("kintent_image_index", 0);
      this.Aet = paramIntent.getBooleanExtra("key_is_biz_chat", false);
      this.vEb = getIntent().getLongExtra("key_biz_chat_id", -1L);
      this.aeBz = Boolean.TRUE;
      AppMethodBeat.o(35969);
      return;
      bool = false;
    }
  }
  
  private void jvg()
  {
    AppMethodBeat.i(35973);
    int i = this.Rop.getFirstVisiblePosition();
    int j = this.Rop.getLastVisiblePosition();
    int k = this.aeBv;
    if ((k >= i) && (k <= j))
    {
      AppMethodBeat.o(35973);
      return;
    }
    this.Rop.setSelection(k);
    AppMethodBeat.o(35973);
  }
  
  private boolean jvh()
  {
    AppMethodBeat.i(35980);
    long l1 = this.Jfc;
    long l2 = System.currentTimeMillis();
    this.Jfc = l2;
    if (l1 + 30000L < l2)
    {
      bh.bCz();
      this.wQm = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = this.wQm;
    AppMethodBeat.o(35980);
    return bool;
  }
  
  private void jvi()
  {
    AppMethodBeat.i(35986);
    if ((!n.a.jvm().Ann.isEmpty()) && (n.a.jvm().Ano)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.aeBI.setEnabled(true);
      this.aeBJ.setEnabled(true);
      this.aeBK.setEnabled(true);
      this.aeBL.setEnabled(true);
      AppMethodBeat.o(35986);
      return;
    }
    this.aeBI.setEnabled(false);
    this.aeBJ.setEnabled(false);
    this.aeBK.setEnabled(false);
    this.aeBL.setEnabled(false);
    AppMethodBeat.o(35986);
  }
  
  private static List<cc> nB(List<cc> paramList)
  {
    AppMethodBeat.i(35990);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cc localcc = (cc)paramList.next();
      if ((!h.df(localcc)) && (!h.dg(localcc)) && (!h.di(localcc))) {
        localArrayList.add(localcc);
      }
    }
    AppMethodBeat.o(35990);
    return localArrayList;
  }
  
  private static void nw(List<cc> paramList)
  {
    AppMethodBeat.i(35989);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cc localcc = (cc)paramList.next();
      com.tencent.mm.ui.chatting.a.a(a.c.aedy, a.d.aedD, localcc, 0);
    }
    AppMethodBeat.o(35989);
  }
  
  public final void O(Bundle paramBundle) {}
  
  public final void a(z.a parama) {}
  
  public final void b(z.a parama) {}
  
  public final boolean bws()
  {
    return true;
  }
  
  public final boolean bwt()
  {
    return false;
  }
  
  public final boolean bwu()
  {
    return false;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(35994);
    if (parama == z.a.nVu)
    {
      this.aeBw.aNy();
      this.aeBw.notifyDataSetChanged();
    }
    dSG();
    AppMethodBeat.o(35994);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(35993);
    if ((this.aeBw != null) && (this.mIsPause)) {
      this.aeBw.aeBo = true;
    }
    jvi();
    AppMethodBeat.o(35993);
  }
  
  public final void dSG()
  {
    AppMethodBeat.i(35987);
    n.a.jvm().Ano = false;
    setMMTitle(getString(R.l.grj));
    if (this.aeBw == null)
    {
      AppMethodBeat.o(35987);
      return;
    }
    this.aeBw.notifyDataSetChanged();
    if (this.aeBH >= 0) {
      this.Rop.setPadding(this.Rop.getPaddingLeft(), this.Rop.getPaddingTop(), this.Rop.getPaddingRight(), this.aeBH);
    }
    this.aeBG.setVisibility(8);
    removeOptionMenu(0);
    addTextOptionMenu(0, getString(R.l.gIS), this);
    AppMethodBeat.o(35987);
  }
  
  public void finish()
  {
    AppMethodBeat.i(35974);
    super.finish();
    n.a.jvm().detach();
    AppMethodBeat.o(35974);
  }
  
  public boolean fromFullScreenActivity()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return R.i.fKe;
  }
  
  public final void jvj()
  {
    AppMethodBeat.i(35992);
    if ((this.aeBw != null) && (this.mIsPause)) {
      this.aeBw.aeBo = true;
    }
    setMMTitle(getString(R.l.gIW, new Object[] { Integer.valueOf(n.a.jvm().Ann.size()) }));
    jvi();
    AppMethodBeat.o(35992);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(35971);
    if (n.a.jvm().Ano)
    {
      dSG();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.aeBy.booleanValue())
    {
      super.onBackPressed();
      AppMethodBeat.o(35971);
      return;
    }
    if (this.aeBv >= 0) {
      bm(null, this.aeBv);
    }
    finish();
    AppMethodBeat.o(35971);
  }
  
  public void onClick(final View paramView)
  {
    AppMethodBeat.i(35988);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if (n.a.jvm().Ann.isEmpty())
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    boolean bool = au.bwE(this.talker);
    Object localObject2 = n.a.jvm().Ann;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
    }
    if (paramView.getId() == R.h.del_btn)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11627, new Object[] { Integer.valueOf(5) });
      paramView = new TreeSet();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(Long.valueOf(((cc)((Iterator)localObject1).next()).field_msgId));
      }
      k.b(this, getString(R.l.gAv), "", getString(R.l.gEg), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(35962);
          Log.i("MicroMsg.GalleryGridUI", "delete message");
          l.a(ImageGalleryGridUI.this, paramView, ImageGalleryGridUI.this);
          ImageGalleryGridUI.this.dSG();
          AppMethodBeat.o(35962);
        }
      }, null);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(35988);
      return;
      if (paramView.getId() == R.h.fHL)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 18L, 1L, true);
        final dn localdn = new dn();
        if (com.tencent.mm.pluginsdk.model.n.a(getContext(), localdn, this.talker, (List)localObject2, false))
        {
          c(localdn);
          nw((List)localObject2);
        }
        else
        {
          if (((List)localObject2).size() > 1)
          {
            AppCompatActivity localAppCompatActivity = getContext();
            if (localdn.hDr.hDx >= 0)
            {
              paramView = getContext().getString(R.l.favorite_fail_recordtype_error);
              label375:
              if (localdn.hDr.hDx < 0) {
                break label448;
              }
            }
            label448:
            for (localObject1 = getContext().getString(R.l.confirm_dialog_ok);; localObject1 = getContext().getString(R.l.plugin_favorite_opt))
            {
              k.b(localAppCompatActivity, paramView, "", (String)localObject1, getContext().getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                {
                  AppMethodBeat.i(35963);
                  if ((localdn.hDr.type == 14) && (localdn.hDr.hDt.vEn.size() == 0))
                  {
                    ImageGalleryGridUI.this.dSG();
                    AppMethodBeat.o(35963);
                    return;
                  }
                  ImageGalleryGridUI.a(ImageGalleryGridUI.this, localdn);
                  ImageGalleryGridUI.nC(this.sEi);
                  AppMethodBeat.o(35963);
                }
              }, null);
              break;
              paramView = getContext().getString(R.l.favorite_fail_record_expired_bigfile);
              break label375;
            }
          }
          k.s(getContext(), localdn.hDr.hDx, 0);
        }
      }
      else if (paramView.getId() == R.h.trans_btn)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 19L, 1L, true);
        com.tencent.mm.ui.chatting.n.a(this, (List)localObject2, bool, this.talker, this);
        dSG();
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11627, new Object[] { Integer.valueOf(3) });
        paramView = nB((List)localObject2);
        if (paramView.size() != ((List)localObject2).size())
        {
          k.a(getContext(), R.l.gIT, R.l.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(35951);
              h.g(ImageGalleryGridUI.this.getContext(), paramView);
              ImageGalleryGridUI.this.dSG();
              AppMethodBeat.o(35951);
            }
          }, null);
        }
        else
        {
          localObject1 = (cc)paramView.get(0);
          if ((((List)localObject2).size() == 1) && (localObject1 != null) && (((cc)localObject1).fxR()))
          {
            localObject2 = ((fi)localObject1).field_content;
            paramView = null;
            if (localObject2 != null) {
              paramView = k.b.aP((String)localObject2, ((fi)localObject1).field_reserved);
            }
            if ((paramView != null) && (paramView.type == 6)) {
              dq((cc)localObject1);
            }
          }
          else
          {
            h.g(this, (List)localObject2);
            dSG();
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35965);
    super.onCreate(paramBundle);
    this.AmZ = true;
    this.handler = new MMHandler();
    aCL(0);
    this.wQB.alive();
    AppMethodBeat.o(35965);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(35966);
    this.handler.removeCallbacks(this.aeBD);
    this.handler = null;
    r.bKe().onScrollStateChanged(0);
    this.wQB.dead();
    super.onDestroy();
    AppMethodBeat.o(35966);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35975);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryGridUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    cc localcc = (cc)this.aeBw.getItem(paramInt);
    paramAdapterView = localcc.field_content;
    if (paramAdapterView != null) {}
    label265:
    label274:
    label553:
    label1075:
    label3765:
    for (paramAdapterView = k.b.aP(paramAdapterView, localcc.field_reserved);; paramAdapterView = null)
    {
      if ((paramAdapterView != null) && (paramAdapterView.type == 6)) {
        dq(localcc);
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
            localObject1 = u.ab(paramAdapterView.url, "message");
            localObject2 = u.ab(paramAdapterView.nRc, "message");
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
              paramLong = localcc.field_msgId;
              l = localcc.field_msgSvrId;
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
              paramAdapterView = dp(localcc);
              ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
              ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(l));
              if (localcc != null) {
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
              }
              ((Intent)localObject1).putExtra("preChatName", this.talker);
              ((Intent)localObject1).putExtra("preChatTYPE", ac.aX(paramAdapterView, this.talker));
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
              if (au.bwE(this.talker))
              {
                paramView = "groupmessage";
                localObject3 = u.ab((String)localObject1, paramView);
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
                  break label1059;
                }
                ((Intent)localObject1).putExtra("shortUrl", paramView);
                if (localObject2 != null) {
                  break label1075;
                }
                paramView = null;
                ((Intent)localObject1).putExtra("version_name", paramView);
                if (localObject2 != null) {
                  break label1084;
                }
              }
              for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
              {
                ((Intent)localObject1).putExtra("version_code", paramInt);
                if (!Util.isNullOrNil(paramAdapterView.iaa))
                {
                  ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.iaa);
                  ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.iab);
                }
                ((Intent)localObject1).putExtra("msg_id", localcc.field_msgId);
                ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localcc.field_msgSvrId));
                ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
                ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
                ((Intent)localObject1).putExtra("thumbUrl", paramAdapterView.thumburl);
                ((Intent)localObject1).putExtra("geta8key_username", this.talker);
                paramAdapterView = dp(localcc);
                ((Intent)localObject1).putExtra("pre_username", paramAdapterView);
                ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localcc.field_msgSvrId));
                ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
                ((Intent)localObject1).putExtra("preChatName", this.talker);
                ((Intent)localObject1).putExtra("preChatTYPE", ac.aX(paramAdapterView, this.talker));
                ((Intent)localObject1).putExtra("preMsgIndex", 0);
                com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
            paramView.putExtra("message_id", localcc.field_msgId);
            paramView.putExtra("record_xml", paramAdapterView.nRF);
            com.tencent.mm.br.c.b(getContext(), "record", ".ui.RecordMsgDetailUI", paramView);
          }
          else if ((paramAdapterView != null) && (paramAdapterView.type == 24))
          {
            paramView = new rk();
            paramView.hUw.context = getContext();
            paramView.hUw.msgId = localcc.field_msgId;
            paramView.hUw.hUx = paramAdapterView.nRF;
            paramView.publish();
          }
          else
          {
            Object localObject4;
            boolean bool;
            if ((paramAdapterView != null) && (paramAdapterView.type == 7))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(paramAdapterView.appId, false, false);
              if (localObject2 != null)
              {
                localObject1 = this.talker;
                paramView = (View)localObject1;
                if (au.bwE((String)localObject1)) {
                  paramView = br.JJ(localcc.field_content);
                }
                paramLong = localcc.field_msgSvrId;
                if ((localObject2 != null) && (u.y(getContext(), ((g)localObject2).field_packageName)))
                {
                  paramInt = 3;
                  if (paramAdapterView.type != 2) {
                    break label1699;
                  }
                  paramInt = 4;
                  localObject3 = new un();
                  ((un)localObject3).hYk.context = getContext();
                  ((un)localObject3).hYk.scene = 1;
                  ((un)localObject3).hYk.appid = paramAdapterView.appId;
                  localObject4 = ((un)localObject3).hYk;
                  if (localObject2 != null) {
                    break label1712;
                  }
                  localObject1 = null;
                  ((un.a)localObject4).packageName = ((String)localObject1);
                  ((un)localObject3).hYk.msgType = paramAdapterView.type;
                  ((un)localObject3).hYk.hQQ = paramView;
                  ((un)localObject3).hYk.hYl = paramInt;
                  ((un)localObject3).hYk.mediaTagName = paramAdapterView.mediaTagName;
                  ((un)localObject3).hYk.hTh = paramLong;
                  ((un)localObject3).hYk.hYm = "";
                  ((un)localObject3).hYk.hzx = this.talker;
                  ((un)localObject3).publish();
                  paramView = b.a.fCn();
                  if ((com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (g)localObject2)) || (paramView == null)) {
                    break label1811;
                  }
                  if (Util.isNullOrNil(((com.tencent.mm.autogen.b.z)localObject2).jOw)) {
                    break label1722;
                  }
                  bool = com.tencent.mm.pluginsdk.model.app.v.cH(getContext(), ((com.tencent.mm.autogen.b.z)localObject2).jOw);
                  Log.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[] { ((com.tencent.mm.autogen.b.z)localObject2).jOw, Boolean.valueOf(bool) });
                  if (!bool) {
                    break label1722;
                  }
                  paramInt = 1;
                }
                for (;;)
                {
                  if (paramInt != 0) {
                    break label1814;
                  }
                  if ((paramAdapterView.hzM != null) && (paramAdapterView.hzM.length() != 0)) {
                    break label2115;
                  }
                  paramView = localcc.field_content;
                  paramAdapterView = paramView;
                  if (localcc.field_isSend == 0)
                  {
                    paramInt = localcc.field_isSend;
                    paramAdapterView = paramView;
                    if (!this.Aet)
                    {
                      paramAdapterView = paramView;
                      if (au.bwE(this.talker))
                      {
                        paramAdapterView = paramView;
                        if (paramView != null)
                        {
                          paramAdapterView = paramView;
                          if (paramInt == 0) {
                            paramAdapterView = br.JK(paramView);
                          }
                        }
                      }
                    }
                  }
                  paramView = k.b.Hf(paramAdapterView);
                  localObject1 = com.tencent.mm.pluginsdk.model.app.h.s(paramView.appId, true, false);
                  if ((localObject1 == null) || (!u.y(getContext(), ((g)localObject1).field_packageName))) {
                    break label2066;
                  }
                  if (((g)localObject1).field_status != 3) {
                    break label1816;
                  }
                  Log.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + ((g)localObject1).field_packageName);
                  break;
                  paramInt = 6;
                  break label1303;
                  if (paramAdapterView.type != 5) {
                    break label1313;
                  }
                  paramInt = 1;
                  break label1313;
                  localObject1 = ((g)localObject2).field_packageName;
                  break label1370;
                  localObject1 = new kj();
                  ((kj)localObject1).hLZ.actionCode = 2;
                  ((kj)localObject1).hLZ.scene = 1;
                  ((kj)localObject1).hLZ.appId = ((g)localObject2).field_appId;
                  ((kj)localObject1).hLZ.context = getContext();
                  ((kj)localObject1).publish();
                  new Intent();
                  getContext();
                  paramView.av(((g)localObject2).field_appId, 1, 1);
                  paramInt = 1;
                  continue;
                  paramInt = 0;
                }
                continue;
                if (!u.b(getContext(), (g)localObject1))
                {
                  Log.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[] { ((g)localObject1).field_appName });
                  Toast.makeText(getContext(), getString(R.l.game_launch_fail_alert, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(getContext(), (g)localObject1, null) }), 1).show();
                }
                else if (!a(localcc, (g)localObject1))
                {
                  localObject2 = new WXAppExtendObject();
                  ((WXAppExtendObject)localObject2).extInfo = paramView.extInfo;
                  if ((paramView.hzM != null) && (paramView.hzM.length() > 0))
                  {
                    paramAdapterView = as.cWJ().bpI(paramView.hzM);
                    if (paramAdapterView != null) {
                      break label2058;
                    }
                  }
                  for (paramAdapterView = null;; paramAdapterView = paramAdapterView.field_fileFullPath)
                  {
                    ((WXAppExtendObject)localObject2).filePath = paramAdapterView;
                    paramAdapterView = new WXMediaMessage();
                    paramAdapterView.sdkVer = 638058496;
                    paramAdapterView.mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
                    paramAdapterView.title = paramView.title;
                    paramAdapterView.description = paramView.description;
                    paramAdapterView.messageAction = paramView.messageAction;
                    paramAdapterView.messageExt = paramView.messageExt;
                    paramAdapterView.thumbData = y.bi(r.bKa().NY(localcc.field_imgPath), 0, -1);
                    new aw(this).a(((g)localObject1).field_packageName, paramAdapterView, ((g)localObject1).field_appId, ((g)localObject1).field_openId);
                    break;
                  }
                  paramAdapterView = u.ad(getContext(), paramView.appId, "message");
                  paramView = new Intent();
                  paramView.putExtra("rawUrl", paramAdapterView);
                  com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", paramView);
                  continue;
                  if (!this.wQm)
                  {
                    aa.j(getContext(), null);
                  }
                  else
                  {
                    paramAdapterView = new Intent();
                    paramAdapterView.setClassName(getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    paramAdapterView.putExtra("app_msg_id", localcc.field_msgId);
                    startActivityForResult(paramAdapterView, 210);
                  }
                }
              }
            }
            else
            {
              int i;
              if ((localcc.dSH()) || (localcc.iYk()) || (localcc.dSJ()) || (localcc.jbK()))
              {
                if ((paramAdapterView == null) || (Util.isNullOrNil(paramAdapterView.nTu)))
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
                  localObject1 = localcc.field_imgPath;
                  localObject3 = new Intent();
                  ((Intent)localObject3).putExtra("KFromTimeLine", false);
                  ((Intent)localObject3).putExtra("KStremVideoUrl", paramAdapterView.nTu);
                  ((Intent)localObject3).putExtra("KThumUrl", paramAdapterView.nTz);
                  ((Intent)localObject3).putExtra("KThumbPath", (String)localObject1);
                  ((Intent)localObject3).putExtra("KMediaId", "fakeid_" + localcc.field_msgId);
                  ((Intent)localObject3).putExtra("KMediaVideoTime", paramAdapterView.nTv);
                  ((Intent)localObject3).putExtra("StremWebUrl", paramAdapterView.nTy);
                  ((Intent)localObject3).putExtra("StreamWording", paramAdapterView.nTx);
                  ((Intent)localObject3).putExtra("KMediaTitle", paramAdapterView.title);
                  localObject2 = localcc.field_talker;
                  bool = au.bwE((String)localObject2);
                  if (bool)
                  {
                    localObject1 = br.JJ(localcc.field_content);
                    ((Intent)localObject3).putExtra("KSta_StremVideoAduxInfo", paramAdapterView.nTA);
                    ((Intent)localObject3).putExtra("KSta_StremVideoPublishId", paramAdapterView.nTB);
                    ((Intent)localObject3).putExtra("KSta_SourceType", 1);
                    if (!bool) {
                      break label2613;
                    }
                    i = a.b.aedv.value;
                    ((Intent)localObject3).putExtra("KSta_Scene", i);
                    ((Intent)localObject3).putExtra("KSta_FromUserName", (String)localObject1);
                    ((Intent)localObject3).putExtra("KSta_ChatName", (String)localObject2);
                    ((Intent)localObject3).putExtra("KSta_MsgId", localcc.field_msgSvrId);
                    ((Intent)localObject3).putExtra("KSta_SnsStatExtStr", paramAdapterView.iah);
                    if (bool) {
                      ((Intent)localObject3).putExtra("KSta_ChatroomMembercount", com.tencent.mm.model.v.getMembersCountByChatRoomName((String)localObject2));
                    }
                    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yHP, 0) <= 0) {
                      break label2624;
                    }
                    com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", (Intent)localObject3);
                    Log.i("MicroMsg.GalleryGridUI", "use new stream video play UI");
                  }
                  for (;;)
                  {
                    i = 1;
                    break;
                    localObject1 = localObject2;
                    break label2428;
                    i = a.b.aedu.value;
                    break label2477;
                    com.tencent.mm.br.c.b(getContext(), "sns", ".ui.VideoAdPlayerUI", (Intent)localObject3);
                  }
                }
                bm(paramView, paramInt);
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 15))
              {
                localObject1 = paramAdapterView.nRI;
                paramView = (View)localObject1;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramView = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aol(paramAdapterView.url);
                }
                if (TextUtils.isEmpty(paramView))
                {
                  paramView = new Intent();
                  paramView.putExtra("geta8key_username", com.tencent.mm.model.z.bAM());
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
                  com.tencent.mm.plugin.report.service.h.OAn.b(10993, new Object[] { Integer.valueOf(2), paramView });
                }
              }
              else if ((paramAdapterView != null) && (paramAdapterView.type == 26))
              {
                paramInt = paramAdapterView.tid;
                paramView = paramAdapterView.nTr;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", dp(localcc));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.kLg);
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
                paramView = paramAdapterView.nTr;
                localObject1 = paramAdapterView.desc;
                localObject2 = paramAdapterView.iconUrl;
                localObject3 = paramAdapterView.secondUrl;
                i = paramAdapterView.pageType;
                if (paramInt != 0)
                {
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("geta8key_username", dp(localcc));
                  ((Intent)localObject4).putExtra("rawUrl", paramAdapterView.kLg);
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
        Log.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[] { localcc.field_talker, Long.valueOf(localcc.field_msgId), Integer.valueOf(localcc.getType()), Util.secPrint(localcc.field_content) });
      } while ((paramAdapterView.url == null) || (paramAdapterView.url.equals("")) || (paramAdapterView.url == null) || (paramAdapterView.url.equals("")));
      label1084:
      label1370:
      label2428:
      localObject1 = paramAdapterView.url;
      label1722:
      label2115:
      if (au.bwE(this.talker))
      {
        paramView = "groupmessage";
        label3315:
        localObject3 = u.ab((String)localObject1, paramView);
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
          break label3765;
        }
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        if (localObject2 != null) {
          break label3781;
        }
        paramView = null;
        ((Intent)localObject1).putExtra("version_name", paramView);
        if (localObject2 != null) {
          break label3790;
        }
      }
      label2613:
      label2624:
      label3781:
      label3790:
      for (paramInt = 0;; paramInt = ((PackageInfo)localObject2).versionCode)
      {
        ((Intent)localObject1).putExtra("version_code", paramInt);
        if (!Util.isNullOrNil(paramAdapterView.iaa))
        {
          ((Intent)localObject1).putExtra("srcUsername", paramAdapterView.iaa);
          ((Intent)localObject1).putExtra("srcDisplayname", paramAdapterView.iab);
        }
        ((Intent)localObject1).putExtra("msg_id", localcc.field_msgId);
        ((Intent)localObject1).putExtra("webpageTitle", paramAdapterView.title);
        ((Intent)localObject1).putExtra("thumbUrl", paramAdapterView.thumburl);
        ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localcc.field_msgSvrId));
        ((Intent)localObject1).putExtra("KAppId", paramAdapterView.appId);
        ((Intent)localObject1).putExtra("geta8key_username", com.tencent.mm.model.z.bAM());
        ((Intent)localObject1).putExtra("pre_username", dp(localcc));
        ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localcc.field_msgSvrId));
        paramAdapterView = dp(localcc);
        paramView = com.tencent.mm.model.z.bAM();
        ((Intent)localObject1).putExtra("preUsername", paramAdapterView);
        ((Intent)localObject1).putExtra("preChatName", paramView);
        ((Intent)localObject1).putExtra("preChatTYPE", ac.aX(paramAdapterView, paramView));
        ((Intent)localObject1).putExtra("preMsgIndex", 0);
        com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        break;
        paramView = "singlemessage";
        break label3315;
        ((Intent)localObject1).putExtra("shortUrl", paramAdapterView.url);
        break label3469;
        paramView = ((PackageInfo)localObject2).versionName;
        break label3476;
      }
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(35984);
    if (paramMenuItem.getTitle().equals(getString(R.l.gIS)))
    {
      n.a.jvm().clear();
      dSF();
    }
    for (;;)
    {
      AppMethodBeat.o(35984);
      return false;
      dSG();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(35970);
    setIntent(paramIntent);
    super.onNewIntent(paramIntent);
    aCL(1);
    AppMethodBeat.o(35970);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(35968);
    n.a.jvm().Anp.remove(this);
    this.mIsPause = true;
    super.onPause();
    AppMethodBeat.o(35968);
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(35983);
    Object localObject1 = (i.a)this.aeBx.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(35983);
      return true;
    }
    Object localObject2 = ((i.a)localObject1).cqj.getViewTreeObserver();
    if (!((ViewTreeObserver)localObject2).isAlive())
    {
      AppMethodBeat.o(35983);
      return true;
    }
    ((ViewTreeObserver)localObject2).removeOnPreDrawListener(this);
    int i = ((i.a)localObject1).cqj.getMeasuredWidth();
    int j = ((i.a)localObject1).cqj.getMeasuredHeight();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(35983);
      return true;
    }
    localObject2 = (RelativeLayout.LayoutParams)((i.a)localObject1).AnL.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).width = i;
    ((ViewGroup.LayoutParams)localObject2).height = j;
    ((i.a)localObject1).AnL.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = ((i.a)localObject1).AnL;
    localObject2 = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 12)
    {
      this.aeBF = ((View)localObject1);
      this.handler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35960);
          if (Build.VERSION.SDK_INT >= 16)
          {
            this.aeBP.animate().setDuration(500L).alpha(0.0F).withEndAction(ImageGalleryGridUI.this.aeBE).withLayer().setInterpolator(this.aeBQ);
            AppMethodBeat.o(35960);
            return;
          }
          if (ImageGalleryGridUI.this.handler == null)
          {
            AppMethodBeat.o(35960);
            return;
          }
          this.aeBP.animate().setDuration(500L).alpha(0.0F).setInterpolator(this.aeBQ);
          ImageGalleryGridUI.this.handler.postDelayed(ImageGalleryGridUI.this.aeBE, 500L);
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
    n.a.jvm().a(this);
    this.mIsPause = false;
    if (this.AmZ)
    {
      if (!n.a.jvm().Ano) {
        break label143;
      }
      dSF();
    }
    for (;;)
    {
      this.handler.postDelayed(this.aeBD, 300L);
      super.onResume();
      if (this.aeBw != null)
      {
        this.aeBw.aeBo = true;
        i locali = this.aeBw;
        if (locali.aeBo) {
          locali.notifyDataSetChanged();
        }
        if (n.a.jvm().Ano) {
          setMMTitle(getString(R.l.gIW, new Object[] { Integer.valueOf(n.a.jvm().Ann.size()) }));
        }
      }
      this.AmZ = false;
      jvi();
      AppMethodBeat.o(35967);
      return;
      label143:
      dSG();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI
 * JD-Core Version:    0.7.0.1
 */