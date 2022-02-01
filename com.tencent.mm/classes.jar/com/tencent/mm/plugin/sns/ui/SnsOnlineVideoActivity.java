package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.autogen.a.kj;
import com.tencent.mm.autogen.a.yl;
import com.tencent.mm.autogen.a.ym;
import com.tencent.mm.autogen.a.zm;
import com.tencent.mm.autogen.a.zm.a;
import com.tencent.mm.b.p;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ah;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class SnsOnlineVideoActivity
  extends MMActivity
{
  private boolean AlL;
  private RelativeLayout Amd;
  private boolean KTF;
  private SnsInfo PNI;
  private com.tencent.mm.plugin.sns.ui.d.c Rde;
  private long RgS;
  private boolean Rga;
  private int RjS;
  private boolean RnF;
  private Button RnI;
  private float Roh;
  private int Roi;
  private int Roj;
  private OnlineVideoView Rvd;
  private FrameLayout Rve;
  private boolean Rvf;
  private boolean Rvg;
  private boolean Rvh;
  private boolean Rvi;
  private boolean Rvj;
  private String Rvk;
  private LinearLayout Rvl;
  private String Rvm;
  private int Rvn;
  private boolean Rvo;
  private boolean Rvp;
  private boolean Rvq;
  private String fullPath;
  private String hHB;
  private String hYm;
  private dmz ibT;
  private boolean isAnimated;
  private boolean isPreview;
  private boolean lAj;
  private GestureDetector mQj;
  private VelocityTracker mVelocityTracker;
  private ImageView pIB;
  private int scene;
  private String sessionId;
  private String thumbPath;
  u.i vGU;
  private Bundle wAX;
  private com.tencent.mm.ui.tools.f wAY;
  private int wAZ;
  private int wBa;
  private int wBb;
  private int wBc;
  private float x_down;
  private float y_down;
  
  public SnsOnlineVideoActivity()
  {
    AppMethodBeat.i(98958);
    this.AlL = true;
    this.scene = 0;
    this.Rvf = false;
    this.isAnimated = false;
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    this.Rvh = false;
    this.RnF = true;
    this.Rga = false;
    this.Rvi = false;
    this.hYm = "";
    this.sessionId = "";
    this.RgS = 0L;
    this.RjS = 2;
    this.Rvj = false;
    this.x_down = 0.0F;
    this.y_down = 0.0F;
    this.Rvo = false;
    this.Rvp = false;
    this.Rvq = false;
    this.Roh = 1.0F;
    this.Roi = 0;
    this.Roj = 0;
    this.vGU = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        boolean bool = false;
        AppMethodBeat.i(308085);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(308085);
          return;
          paramAnonymousMenuItem = new zm();
          paramAnonymousMenuItem.icB.hId = 2;
          paramAnonymousMenuItem.icB.icC = 17;
          Object localObject = paramAnonymousMenuItem.icB;
          if (SnsOnlineVideoActivity.A(SnsOnlineVideoActivity.this) == 0) {
            bool = true;
          }
          ((zm.a)localObject).icD = bool;
          paramAnonymousMenuItem.icB.hHB = SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem.publish();
          AppMethodBeat.o(308085);
          return;
          localObject = new Intent();
          SnsInfo localSnsInfo = al.hgB().aZL(SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this));
          if (localSnsInfo != null) {
            Log.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + localSnsInfo.getSnsId());
          }
          if (localSnsInfo == null)
          {
            paramAnonymousMenuItem = Integer.valueOf(0);
            ((Intent)localObject).putExtra("k_expose_msg_id", paramAnonymousMenuItem);
            if (localSnsInfo != null) {
              break label305;
            }
          }
          label305:
          for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = localSnsInfo.field_userName)
          {
            ((Intent)localObject).putExtra("k_username", paramAnonymousMenuItem);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(33) }));
            com.tencent.mm.br.c.b(SnsOnlineVideoActivity.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(308085);
            return;
            paramAnonymousMenuItem = localSnsInfo.getSnsId();
            break;
          }
          SnsOnlineVideoActivity.B(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem = new zm();
          paramAnonymousMenuItem.icB.hId = 1;
          paramAnonymousMenuItem.icB.icE = 4097;
          paramAnonymousMenuItem.icB.hHB = SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem.publish();
          AppMethodBeat.o(308085);
          return;
          paramAnonymousMenuItem = al.hgB().aZL(SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this));
          if (paramAnonymousMenuItem == null)
          {
            AppMethodBeat.o(308085);
            return;
          }
          localObject = new Intent();
          if ((paramAnonymousMenuItem.getTimeLine().ContentObj.Zpq == 15) && ((dmz)paramAnonymousMenuItem.getTimeLine().ContentObj.Zpr.get(0) == null))
          {
            Log.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
            AppMethodBeat.o(308085);
            return;
          }
          ((Intent)localObject).putExtra("exdevice_open_scene_type", 2);
          ((Intent)localObject).putExtra("sns_local_id", SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this));
          ((Intent)localObject).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.br.c.g(SnsOnlineVideoActivity.this, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject);
          AppMethodBeat.o(308085);
          return;
          paramAnonymousMenuItem = new zm();
          paramAnonymousMenuItem.icB.hId = 3;
          paramAnonymousMenuItem.icB.hHB = SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this);
          paramAnonymousMenuItem.publish();
        }
      }
    };
    AppMethodBeat.o(98958);
  }
  
  private void baI(String paramString)
  {
    AppMethodBeat.i(307586);
    this.Rvl.setVisibility(0);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.model.a.NIt;
    int i = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
    int j = this.Rvd.getBottomSafeHeight();
    int k = this.Rvd.getVideoViewBottom();
    int m = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    localObject1 = (FrameLayout.LayoutParams)this.Rvl.getLayoutParams();
    if ((i - k > j) && (k > 0))
    {
      ((FrameLayout.LayoutParams)localObject1).setMargins(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 16) + k, m, 0);
      ((FrameLayout.LayoutParams)localObject1).gravity = 8388613;
    }
    TextView localTextView;
    for (;;)
    {
      this.Rvl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localTextView = (TextView)findViewById(b.f.tv_jump_wording);
      if (!TextUtils.isEmpty(paramString)) {
        break label323;
      }
      paramString = j.QFS;
      j.he(this.Rvm, 1);
      paramString = com.tencent.mm.plugin.recordvideo.util.k.ObH;
      localObject1 = com.tencent.mm.plugin.recordvideo.util.k.gLs();
      paramString = (String)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString = com.tencent.mm.cd.a.bt(getContext(), b.j.sns_second_cut_simple_style);
      }
      if (!paramString.contains("X")) {
        break;
      }
      localObject1 = new SpannableString(paramString);
      Object localObject2 = com.tencent.mm.cd.a.m(getContext(), b.e.second_cut_simple_style_icon);
      i = com.tencent.mm.cd.a.br(getContext(), b.d.Edge_1_5_A);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth() * i / ((Drawable)localObject2).getIntrinsicHeight(), i);
      localObject2 = new ImageSpan((Drawable)localObject2, 2);
      i = paramString.indexOf("X");
      ((SpannableString)localObject1).setSpan(localObject2, i, i + 1, 33);
      localTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(307586);
      return;
      ((FrameLayout.LayoutParams)localObject1).setMargins(0, 0, m, j - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40));
    }
    localTextView.setText(paramString);
    AppMethodBeat.o(307586);
    return;
    label323:
    localTextView.setText(paramString);
    AppMethodBeat.o(307586);
  }
  
  private void dmP()
  {
    AppMethodBeat.i(98962);
    if (this.isPreview)
    {
      Log.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
      AppMethodBeat.o(98962);
      return;
    }
    this.Rve.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308113);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, new com.tencent.mm.plugin.sns.ui.d.c(SnsOnlineVideoActivity.this, 4));
        SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this).b(SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this), SnsOnlineVideoActivity.r(SnsOnlineVideoActivity.this));
        SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this).a(SnsOnlineVideoActivity.hpf(), SnsOnlineVideoActivity.t(SnsOnlineVideoActivity.this), null);
        SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this).e(SnsOnlineVideoActivity.this.vGU);
        SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this).bM(new kotlin.g.a.a() {});
        SnsOnlineVideoActivity.s(SnsOnlineVideoActivity.this).dDn();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$9", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(308113);
        return true;
      }
    });
    AppMethodBeat.o(98962);
  }
  
  private String hpd()
  {
    AppMethodBeat.i(307581);
    if ((this.isPreview) || (TextUtils.isEmpty(this.Rvk)))
    {
      AppMethodBeat.o(307581);
      return "";
    }
    Object localObject;
    try
    {
      localObject = new com.tencent.mm.ad.i(this.Rvk);
      String str = ((com.tencent.mm.ad.i)localObject).optString("APP_TYPE");
      localObject = ((com.tencent.mm.ad.i)localObject).optString("MSG_EXT");
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        AppMethodBeat.o(307581);
        return "";
      }
    }
    catch (com.tencent.mm.ad.g localg)
    {
      Log.e("MicroMsg.SnsOnlineVideoActivity", "parse third msgJson error");
      AppMethodBeat.o(307581);
      return "";
    }
    int i = -1;
    switch (localg.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(307581);
        return "";
        if (localg.equals("APP_TYPE_SECOND_CUP")) {
          i = 0;
        }
        break;
      }
    }
    com.tencent.mm.plugin.recordvideo.util.k localk = com.tencent.mm.plugin.recordvideo.util.k.ObH;
    if (!com.tencent.mm.plugin.recordvideo.util.k.gLr())
    {
      AppMethodBeat.o(307581);
      return "";
    }
    this.Rvd.bM(com.tencent.mm.cd.a.fromDPToPix(getContext(), 56), false);
    this.Rvl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98954);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.this).setBackground(com.tencent.mm.cd.a.m(SnsOnlineVideoActivity.this.getContext(), b.e.sns_second_cut_shape_background_press));
        paramAnonymousView = com.tencent.mm.plugin.recordvideo.util.b.Obj;
        final boolean bool = com.tencent.mm.plugin.recordvideo.util.b.D(SnsOnlineVideoActivity.this.getContext(), "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
        if (bool) {}
        for (int i = b.j.app_field_secondcut_jump_tip;; i = b.j.app_field_secondcut_install_tip)
        {
          paramAnonymousView = j.QFS;
          j.he(SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this), 2);
          com.tencent.mm.ui.base.k.a(SnsOnlineVideoActivity.this.getContext(), i, b.j.app_tip, b.j.app_ok, b.j.app_cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(308252);
              Object localObject;
              if (bool)
              {
                paramAnonymous2DialogInterface = com.tencent.mm.plugin.recordvideo.util.l.ObI;
                paramAnonymous2DialogInterface = SnsOnlineVideoActivity.13.this.ryy;
                localObject = com.tencent.mm.plugin.recordvideo.util.k.ObH;
                paramAnonymous2DialogInterface = com.tencent.mm.plugin.recordvideo.util.l.av("moments", paramAnonymous2DialogInterface, com.tencent.mm.plugin.recordvideo.util.k.gLn());
                localObject = com.tencent.mm.plugin.recordvideo.util.l.ObI;
                com.tencent.mm.plugin.recordvideo.util.l.aG(SnsOnlineVideoActivity.this.getContext(), paramAnonymous2DialogInterface);
              }
              for (;;)
              {
                SnsOnlineVideoActivity.this.dmJ();
                paramAnonymous2DialogInterface = j.QFS;
                j.he(SnsOnlineVideoActivity.o(SnsOnlineVideoActivity.this), 3);
                AppMethodBeat.o(308252);
                return;
                paramAnonymous2DialogInterface = com.tencent.mm.plugin.recordvideo.util.b.Obj;
                paramAnonymous2DialogInterface = SnsOnlineVideoActivity.this.getContext();
                localObject = new StringBuilder();
                com.tencent.mm.plugin.recordvideo.util.k localk = com.tencent.mm.plugin.recordvideo.util.k.ObH;
                com.tencent.mm.plugin.recordvideo.util.b.aL(paramAnonymous2DialogInterface, com.tencent.mm.plugin.recordvideo.util.k.gLo() + "1106");
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(308240);
              SnsOnlineVideoActivity.n(SnsOnlineVideoActivity.this).setBackground(com.tencent.mm.cd.a.m(SnsOnlineVideoActivity.this.getContext(), b.e.sns_second_cut_shape_background));
              AppMethodBeat.o(308240);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98954);
          return;
        }
      }
    });
    AppMethodBeat.o(307581);
    return localg;
  }
  
  private void hpe()
  {
    AppMethodBeat.i(98961);
    boolean bool = aw.bg(this);
    int i = aw.bk(this);
    if ((this.KTF) && (bool) && (this.RnI != null) && (this.RnI.getVisibility() == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.RnI.getLayoutParams();
      localMarginLayoutParams.bottomMargin = (i + localMarginLayoutParams.bottomMargin);
      this.RnI.setLayoutParams(localMarginLayoutParams);
    }
    AppMethodBeat.o(98961);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98969);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
      dmJ();
      AppMethodBeat.o(98969);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98969);
    return bool;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(98967);
    if ((this.RnI != null) && (this.RnI.getVisibility() == 0)) {
      this.RnI.setVisibility(8);
    }
    if ((this.Rvl != null) && (this.Rvl.getVisibility() == 0)) {
      this.Rvl.setVisibility(8);
    }
    int k = this.Amd.getWidth();
    int j = this.Amd.getHeight();
    if (this.Roh == 1.0F)
    {
      i = this.Rvd.getVideoVideoMoveMargin();
      this.wAY.afIk = (-(i * 2));
    }
    int i = j;
    if (this.wBb != 0)
    {
      i = j;
      if (this.wBc != 0) {
        i = (int)(k / this.wBb * this.wBc);
      }
    }
    if (this.wAY != null)
    {
      this.wAY.oC(k, i);
      this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
      if (this.Roh != 1.0D)
      {
        int m = this.Rvd.getVideoVideoMoveMargin();
        this.wAY.afIg = (1.0F / this.Roh);
        if ((this.Roi != 0) || (this.Roj != 0))
        {
          j = (int)(this.Amd.getWidth() / 2 * (1.0F - this.Roh));
          k = this.Roi;
          i = (int)(this.Amd.getHeight() / 2 + this.Roj - (i / 2 + m) * this.Roh);
          this.wAY.oE(j + k, i);
        }
      }
      this.wAY.a(this.Rve, this.pIB, new f.c()
      {
        public final void onAnimationEnd()
        {
          AppMethodBeat.i(308068);
          new MMHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(308549);
              Intent localIntent = new Intent();
              localIntent.putExtra("sns_update_preview_video_del", SnsOnlineVideoActivity.y(SnsOnlineVideoActivity.this));
              SnsOnlineVideoActivity.this.setResult(-1, localIntent);
              SnsOnlineVideoActivity.z(SnsOnlineVideoActivity.this);
              SnsOnlineVideoActivity.this.finish();
              SnsOnlineVideoActivity.this.overridePendingTransition(0, 0);
              AppMethodBeat.o(308549);
            }
          });
          AppMethodBeat.o(308068);
        }
        
        public final void onAnimationStart() {}
      }, null);
    }
    AppMethodBeat.o(98967);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_video_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98970);
    Log.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        localObject2 = paramIntent.getStringExtra("custom_send_text");
        localObject3 = Util.stringsToList(((String)localObject1).split(",")).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          String str1 = (String)((Iterator)localObject3).next();
          if (this.scene == 0)
          {
            localObject1 = al.hgB().aZL(this.hHB);
            if (localObject1 != null)
            {
              if (!au.bwE(str1)) {
                break label349;
              }
              localObject4 = new yl();
              ((yl)localObject4).ibM.hQX = t.x((SnsInfo)localObject1);
              ((yl)localObject4).ibM.hES = ((SnsInfo)localObject1).getLocalid();
              ((yl)localObject4).publish();
            }
          }
          label176:
          Object localObject4 = this.PNI.getTimeLine();
          int i = t.aXE(this.fullPath);
          dmz localdmz;
          if (Util.isNullOrNil(this.thumbPath))
          {
            localdmz = this.ibT;
            if (localdmz == null) {
              localObject1 = "";
            }
          }
          for (;;)
          {
            this.thumbPath = ((String)localObject1);
            Log.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, this.fullPath, this.thumbPath, this.ibT.aaTr, Integer.valueOf(this.ibT.RGm), Integer.valueOf(i) });
            com.tencent.mm.plugin.messenger.a.g.gaI().a(this, str1, this.fullPath, this.thumbPath, 43, i, ((TimeLineObject)localObject4).statExtStr, null);
            if (localObject2 != null) {
              com.tencent.mm.plugin.messenger.a.g.gaI().ke((String)localObject2, str1);
            }
            com.tencent.mm.ui.widget.snackbar.b.u(this, getString(b.j.has_send));
            break;
            label349:
            localObject4 = new ym();
            ((ym)localObject4).ibN.hQX = t.x((SnsInfo)localObject1);
            ((ym)localObject4).ibN.hES = ((SnsInfo)localObject1).getLocalid();
            ((ym)localObject4).publish();
            break label176;
            String str2 = as.mg(al.getAccSnsPath(), localdmz.Id);
            localObject1 = str2 + t.d(localdmz);
            boolean bool = y.ZC((String)localObject1);
            Log.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[] { localObject1, Boolean.valueOf(bool) });
            if (!bool)
            {
              localObject1 = str2 + t.m(localdmz);
              Log.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[] { localObject1 });
              continue;
              localObject1 = this.thumbPath;
            }
          }
        }
      }
    }
    else if (4098 == paramInt1)
    {
      Log.i("MicroMsg.SnsOnlineVideoActivity", "REQUEST_CODE_CUT_SAME callback ");
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("key_export_video_path");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          Log.e("MicroMsg.SnsOnlineVideoActivity", "template video path is null");
          finish();
          AppMethodBeat.o(98970);
          return;
        }
      }
    }
    try
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("KSightPath", (String)localObject1);
      localObject3 = com.tencent.mm.plugin.s.a.KOy;
      localObject3 = com.tencent.mm.plugin.s.a.aLb(System.currentTimeMillis());
      BitmapUtil.saveBitmapToImage(com.tencent.mm.plugin.mmsight.d.Pf((String)localObject1), 60, Bitmap.CompressFormat.JPEG, (String)localObject3, true);
      ((Intent)localObject2).putExtra("KSightThumbPath", (String)localObject3);
      ((Intent)localObject2).putExtra("Ksnsupload_type", 14);
      ((Intent)localObject2).putExtra("KSnsVideoTempalteInfo", paramIntent.getByteArrayExtra("key_video_template_info"));
      com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsUploadUI", (Intent)localObject2);
      finish();
      label701:
      Log.i("MicroMsg.SnsOnlineVideoActivity", "REQUEST_CODE_TEMPLATE_VIDEO path:%s", new Object[] { localObject1 });
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(98970);
      return;
    }
    catch (Exception localException)
    {
      break label701;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(98968);
    this.Rvj = true;
    super.onBackPressed();
    AppMethodBeat.o(98968);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98960);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      Log.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
      hpe();
      AppMethodBeat.o(98960);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
      if ((this.RnI != null) && (this.RnI.getVisibility() == 0))
      {
        paramConfiguration = (ViewGroup.MarginLayoutParams)this.RnI.getLayoutParams();
        if (paramConfiguration.bottomMargin != getResources().getDimensionPixelSize(b.d.sns_game_more_button_bottom_margin))
        {
          paramConfiguration.bottomMargin = getResources().getDimensionPixelSize(b.d.sns_game_more_button_bottom_margin);
          this.RnI.setLayoutParams(paramConfiguration);
        }
      }
      AppMethodBeat.o(98960);
      return;
    }
    AppMethodBeat.o(98960);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(98959);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    super.onCreate(paramBundle);
    this.wAX = paramBundle;
    this.thumbPath = getIntent().getStringExtra("intent_thumbpath");
    this.hHB = getIntent().getStringExtra("intent_localid");
    this.scene = getIntent().getIntExtra("intent_from_scene", -1);
    this.isPreview = getIntent().getBooleanExtra("intent_ispreview", false);
    this.lAj = getIntent().getBooleanExtra("intent_ismute", false);
    this.Rvi = getIntent().getBooleanExtra("intent_fromplayingvideo", false);
    this.hYm = getIntent().getStringExtra("intent_fromplayingvideo_tlobjid");
    this.sessionId = getIntent().getStringExtra("intent_session_id");
    this.RgS = getIntent().getLongExtra("intent_session_timestamp", Util.nowMilliSecond());
    this.RjS = getIntent().getIntExtra("sns_video_scene", 2);
    this.Rga = getIntent().getBooleanExtra("KBlockAdd", false);
    this.Rvk = getIntent().getStringExtra("intent_third_sdk_msg");
    this.Rvm = getIntent().getStringExtra("intent_publish_id");
    this.Rvn = getIntent().getIntExtra("intent_bottom_height", 0);
    paramBundle = getIntent().getStringExtra("intent_videopath");
    Log.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[] { this.thumbPath, this.hHB, Integer.valueOf(this.scene), Boolean.valueOf(this.isPreview), Boolean.valueOf(this.lAj), paramBundle });
    if (com.tencent.mm.n.a.aTj()) {
      this.lAj = true;
    }
    if (!this.isPreview) {}
    for (;;)
    {
      try
      {
        this.PNI = al.hgB().aZL(this.hHB);
        this.ibT = ((dmz)this.PNI.getTimeLine().ContentObj.Zpr.get(0));
        this.fullPath = (as.mg(al.getAccSnsPath(), this.ibT.Id) + t.i(this.ibT));
        Log.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[] { this.PNI.getLocalid() });
        try
        {
          if (!com.tencent.mm.compatible.util.d.rb(19)) {
            break label1212;
          }
          if (!this.isPreview) {
            getWindow().setFlags(201327616, 201327616);
          }
          this.KTF = true;
          getWindow().addFlags(128);
        }
        catch (Exception paramBundle)
        {
          int j;
          Log.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "", new Object[0]);
          continue;
          this.Rvd.setVideoScaleType(i.e.XYK);
          continue;
          this.Rvd = ((OnlineVideoView)findViewById(b.f.video_view));
          paramBundle = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          this.sessionId = (new p(com.tencent.mm.kernel.b.getUin()).toString() + "_" + Util.nowMilliSecond());
          this.RgS = Util.nowMilliSecond();
          this.Rvd.setSessionId(this.sessionId);
          this.Rvd.setSessionTimestamp(this.RgS);
          if (this.PNI == null) {
            break label1463;
          }
          this.Rvd.setSnsId(t.uA(this.PNI.field_snsId));
          if ((this.PNI.getTimeLine().ContentObj == null) || (this.PNI.getTimeLine().ContentObj.Zpr == null) || (this.PNI.getTimeLine().ContentObj.Zpr.isEmpty())) {
            break label1463;
          }
          this.Rvd.setFilePath(az.E((dmz)this.PNI.getTimeLine().ContentObj.Zpr.get(0)));
          if ((!aw.jkS()) && (!aw.ato())) {
            break label1488;
          }
          this.Rvd.setVideoScaleType(i.e.XYM);
          continue;
          this.Rvd.setVideoScaleType(i.e.XYK);
          continue;
          if (!paramBundle.equals("APP_TYPE_SECOND_CUP")) {
            continue;
          }
          int i = 0;
          continue;
          baI(null);
          continue;
          paramBundle = this.PNI.getTimeLine();
          if ((paramBundle.videoTemplate != null) && (!TextUtils.isEmpty(paramBundle.videoTemplate.nSg))) {
            break label1564;
          }
          Log.i("MicroMsg.SnsOnlineVideoActivity", "no template info");
          continue;
          if ((paramBundle.videoTemplate.type != null) && (paramBundle.videoTemplate.type.equals("miaojian"))) {
            break label1602;
          }
          Log.i("MicroMsg.SnsOnlineVideoActivity", "not miaojian video");
          continue;
          if (((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getSnsMaasConfig().ip(paramBundle.videoTemplate.abFR)) {
            break label1643;
          }
          Log.i("MicroMsg.SnsOnlineVideoActivity", "do not match condition");
          continue;
          Log.i("MicroMsg.SnsOnlineVideoActivity", "init template info");
          this.Rvd.bM(com.tencent.mm.cd.a.fromDPToPix(getContext(), 56), false);
          Object localObject1 = j.QFS;
          j.l(this.Rvm, 1, paramBundle.videoTemplate.nSg, paramBundle.videoTemplate.musicId);
          baI(getString(b.j.sns_second_cut_same));
          paramBundle = paramBundle.videoTemplate;
          if (paramBundle != null) {
            break label1728;
          }
          Log.e("MicroMsg.SnsOnlineVideoActivity", "video template info is null");
          continue;
          try
          {
            localObject1 = paramBundle.toByteArray();
            this.Rvl.setOnClickListener(new SnsOnlineVideoActivity..ExternalSyntheticLambda0(this, (byte[])localObject1, paramBundle));
          }
          catch (IOException paramBundle)
          {
            Log.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", paramBundle, "to byte array error", new Object[0]);
          }
          continue;
          paramBundle = this.Rvd;
          localObject1 = this.fullPath;
          Object localObject2 = this.thumbPath;
          paramBundle.RgF = ((String)localObject1);
          paramBundle.isPreview = true;
          paramBundle.AlJ.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile((String)localObject2, 1.0F));
          Log.i(paramBundle.TAG, "%d set preview video %s isPreview %b ", new Object[] { Integer.valueOf(paramBundle.hashCode()), localObject1, Boolean.valueOf(paramBundle.isPreview) });
          continue;
          hideTitleView();
          this.Amd.setOnTouchListener(new SnsOnlineVideoActivity.8(this));
          continue;
          this.RnI = ((Button)findViewById(b.f.game_more_button));
          localObject1 = paramBundle.getTimeLine();
          if (localObject1 == null) {
            break label1989;
          }
          for (paramBundle = ((TimeLineObject)localObject1).actionInfo;; paramBundle = null)
          {
            localObject2 = new bo();
            ar.a(this, (bo)localObject2, ((TimeLineObject)localObject1).actionInfo);
            if (!((bo)localObject2).RCf) {
              break label1994;
            }
            this.RnI.setVisibility(0);
            this.RnI.setText(((bo)localObject2).RCg);
            this.RnI.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(308133);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                if (paramBundle.YCC == null)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(308133);
                  return;
                }
                SnsOnlineVideoActivity.p(SnsOnlineVideoActivity.this);
                paramAnonymousView = com.tencent.mm.plugin.sns.d.a.pFo.iz(paramBundle.YCC.oOI);
                int i = 0;
                if (this.Rom.ContentObj.Zpq == 1) {
                  i = 2;
                }
                while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(this.Rom, SnsOnlineVideoActivity.this))
                {
                  com.tencent.mm.plugin.sns.d.a.pFo.a(SnsOnlineVideoActivity.this, paramBundle.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 19, 9, paramBundle.YCC.YCm, this.Rom.Id);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(308133);
                  return;
                  if (this.Rom.ContentObj.Zpq == 3) {
                    i = 5;
                  } else if (this.Rom.ContentObj.Zpq == 15) {
                    i = 38;
                  }
                }
                switch (paramBundle.vhJ)
                {
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(308133);
                  return;
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("rawUrl", paramBundle.Url);
                  com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject, SnsOnlineVideoActivity.this);
                  com.tencent.mm.plugin.sns.d.a.pFo.a(SnsOnlineVideoActivity.this, paramBundle.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 19, 1, paramBundle.YCC.YCm, this.Rom.Id);
                  continue;
                  if (paramBundle.IJG == 1)
                  {
                    localObject = new kj();
                    ((kj)localObject).hLZ.actionCode = 2;
                    ((kj)localObject).hLZ.scene = 3;
                    ((kj)localObject).hLZ.appId = paramBundle.YCC.oOI;
                    ((kj)localObject).hLZ.context = SnsOnlineVideoActivity.this;
                    ((kj)localObject).publish();
                    com.tencent.mm.plugin.sns.d.a.pFo.a(SnsOnlineVideoActivity.this, paramBundle.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 19, 6, paramBundle.YCC.YCm, this.Rom.Id);
                    continue;
                    int j = ar.b(SnsOnlineVideoActivity.this, paramBundle);
                    if (j == 1)
                    {
                      localObject = new kj();
                      ((kj)localObject).hLZ.context = SnsOnlineVideoActivity.this;
                      ((kj)localObject).hLZ.actionCode = 2;
                      ((kj)localObject).hLZ.appId = paramBundle.YCC.oOI;
                      ((kj)localObject).hLZ.messageAction = paramBundle.YCC.YCo;
                      ((kj)localObject).hLZ.messageExt = paramBundle.YCC.YCn;
                      ((kj)localObject).hLZ.scene = 3;
                      ((kj)localObject).publish();
                      com.tencent.mm.plugin.sns.d.a.pFo.a(SnsOnlineVideoActivity.this, paramBundle.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 19, 6, paramBundle.YCC.YCm, this.Rom.Id);
                    }
                    else if (j == 2)
                    {
                      localObject = new kj();
                      ((kj)localObject).hLZ.context = SnsOnlineVideoActivity.this;
                      ((kj)localObject).hLZ.actionCode = 1;
                      ((kj)localObject).hLZ.appId = paramBundle.YCC.oOI;
                      ((kj)localObject).hLZ.messageAction = paramBundle.YCC.YCo;
                      ((kj)localObject).hLZ.messageExt = paramBundle.YCC.YCn;
                      ((kj)localObject).hLZ.scene = 3;
                      ((kj)localObject).publish();
                      com.tencent.mm.plugin.sns.d.a.pFo.a(SnsOnlineVideoActivity.this, paramBundle.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 19, 3, paramBundle.YCC.YCm, this.Rom.Id);
                    }
                  }
                }
              }
            });
            if (getRequestedOrientation() == 0) {
              break;
            }
            hpe();
            break;
          }
          this.RnI.setVisibility(8);
          continue;
        }
        this.wAY = new com.tencent.mm.ui.tools.f(getContext());
        this.Amd = ((RelativeLayout)findViewById(b.f.video_ui_root));
        this.Rve = ((FrameLayout)findViewById(b.f.video_view_container));
        this.Rvd = com.tencent.mm.plugin.sns.ui.video.e.hsu().bbp(this.hYm);
        this.Rvl = ((LinearLayout)findViewById(b.f.sns_ll_jump));
        if (this.Rvd == null)
        {
          this.Rvi = false;
          Log.i("MicroMsg.SnsOnlineVideoActivity", "fromplayingvideo but videoview is null, reset it");
        }
        if (!this.Rvi) {
          break label1270;
        }
        com.tencent.mm.plugin.sns.ui.video.e.hsu().hsv();
        paramBundle = (OnlineVideoView)findViewById(b.f.video_view);
        if (this.Rvd.getParent() != null) {
          ((ViewGroup)this.Rvd.getParent()).removeView(this.Rvd);
        }
        localObject1 = (FrameLayout.LayoutParams)paramBundle.getLayoutParams();
        this.Rve.addView(this.Rvd, (ViewGroup.LayoutParams)localObject1);
        if ((!aw.jkS()) && (!aw.ato())) {
          break;
        }
        this.Rvd.setVideoScaleType(i.e.XYM);
        localObject1 = this.Rvd;
        if (((OnlineVideoView)localObject1).vZw == null) {
          ((OnlineVideoView)localObject1).vZw = new com.tencent.mm.model.d();
        }
        ((OnlineVideoView)localObject1).vZw.a((d.a)localObject1);
        Log.i("MicroMsg.SnsOnlineVideoActivity", "videoView position %s %s", new Object[] { Integer.valueOf(this.Rvd.getCurrentPosition()), Integer.valueOf(this.Rvd.getDuration()) });
        if (this.Rvd.getCurrentPosition() + 500 >= this.Rvd.getDuration()) {
          this.Rvd.bJ(0, true);
        }
        paramBundle.setVisibility(8);
        this.Rvd.bu(this);
        this.Rvd.setScene(this.RjS);
        if (this.PNI == null)
        {
          this.PNI = al.hgB().aZL(this.hHB);
          if (this.PNI != null) {
            this.ibT = ((dmz)this.PNI.getTimeLine().ContentObj.Zpr.get(0));
          }
        }
        else
        {
          i = Math.round(this.ibT.aaTF);
          paramBundle = bq.REM;
          j = bq.getSnsVideoShowSeekBarDurationMs();
          this.Rvd.bM(this.Rvn, true);
          paramBundle = hpd();
          this.Rvd.lE(i * 1000, j);
        }
        switch (paramBundle.hashCode())
        {
        default: 
          i = -1;
          switch (i)
          {
          default: 
            if (this.PNI != null) {
              break label1524;
            }
            Log.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
            if (this.isPreview) {
              break label1773;
            }
            if ((!this.Rvi) && (this.PNI != null)) {
              this.Rvd.a(this.ibT, this.PNI.getLocalid(), this.PNI.getCreateTime());
            }
            this.Rvd.setMute(this.lAj);
            this.pIB = ((ImageView)findViewById(b.f.gallery_bg));
            if (!this.isPreview) {
              break label1856;
            }
            this.Rvd.setOnClickListener(new SnsOnlineVideoActivity.1(this));
            this.mQj = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
            {
              public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(308061);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
                boolean bool = super.onContextClick(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(308061);
                return bool;
              }
              
              public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(308060);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
                boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(308060);
                return bool;
              }
              
              public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(98948);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
                SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, true);
                super.onLongPress(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(98948);
              }
              
              public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
              {
                AppMethodBeat.i(98947);
                paramAnonymousFloat1 = paramAnonymousMotionEvent2.getRawX() - paramAnonymousMotionEvent1.getRawX();
                paramAnonymousFloat2 = paramAnonymousMotionEvent2.getRawY() - paramAnonymousMotionEvent1.getRawY();
                if ((Math.abs(paramAnonymousFloat1) <= SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth()) && (Math.abs(paramAnonymousFloat2) <= SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight()) && (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
                {
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationX(paramAnonymousFloat1);
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(paramAnonymousFloat2);
                }
                AppMethodBeat.o(98947);
                return true;
              }
              
              public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(98949);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
                if (!SnsOnlineVideoActivity.e(SnsOnlineVideoActivity.this)) {
                  SnsOnlineVideoActivity.this.dmJ();
                }
                boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(98949);
                return bool;
              }
            });
            this.Rve.setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(98950);
                paramAnonymousView = SnsOnlineVideoActivity.f(SnsOnlineVideoActivity.this);
                com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMotionEvent);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, locala.aYi(), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$4", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                if (SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this) == null) {
                  SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, VelocityTracker.obtain());
                }
                if (SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this) != null) {
                  SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this).addMovement(paramAnonymousMotionEvent);
                }
                switch (paramAnonymousMotionEvent.getAction() & 0xFF)
                {
                default: 
                case 0: 
                case 1: 
                  for (;;)
                  {
                    AppMethodBeat.o(98950);
                    return false;
                    SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, paramAnonymousMotionEvent.getX());
                    SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, paramAnonymousMotionEvent.getY());
                    if (SnsOnlineVideoActivity.h(SnsOnlineVideoActivity.this))
                    {
                      SnsOnlineVideoActivity.i(SnsOnlineVideoActivity.this);
                      SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, false);
                      continue;
                      if (SnsOnlineVideoActivity.h(SnsOnlineVideoActivity.this))
                      {
                        SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotX(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth() / 2);
                        SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotY(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight() / 2);
                        SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleX(1.0F);
                        SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleY(1.0F);
                        SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationX(0.0F);
                        SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(0.0F);
                        SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this).setAlpha(1.0F);
                        SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, 1.0F);
                        SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, false);
                        SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, false);
                        AppMethodBeat.o(98950);
                        return true;
                      }
                      if ((SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this)))
                      {
                        SnsOnlineVideoActivity.this.dmJ();
                        SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, false);
                        AppMethodBeat.o(98950);
                        return true;
                      }
                      SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, false);
                    }
                  }
                }
                paramAnonymousView = SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this);
                paramAnonymousView.computeCurrentVelocity(1000);
                int i = (int)paramAnonymousView.getXVelocity();
                int j = (int)paramAnonymousView.getYVelocity();
                float f1 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationX();
                float f3 = SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getTranslationY();
                SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, (int)f1);
                SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this, (int)f3);
                Log.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[] { Boolean.valueOf(SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)), Float.valueOf(f1), Float.valueOf(f3), Integer.valueOf(i), Integer.valueOf(j) });
                if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!SnsOnlineVideoActivity.k(SnsOnlineVideoActivity.this))) || (SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)))
                {
                  float f2 = 1.0F - f3 / SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight();
                  f1 = f2;
                  if (f2 > 1.0F) {
                    f1 = 1.0F;
                  }
                  if (((j > 0) && (f1 < SnsOnlineVideoActivity.l(SnsOnlineVideoActivity.this))) || ((j < 0) && (f1 >= 0.5D)))
                  {
                    Log.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[] { Float.valueOf(f1) });
                    SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, f1);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotX(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getWidth() / 2);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setPivotY(SnsOnlineVideoActivity.b(SnsOnlineVideoActivity.this).getHeight() / 2);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleX(f1);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setScaleY(f1);
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setTranslationY(f3);
                    SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this).setAlpha(f1);
                  }
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, true);
                  label776:
                  if (f3 <= 200.0F) {
                    break label870;
                  }
                  SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, false);
                }
                for (;;)
                {
                  if (f3 > 50.0F) {
                    SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).setOnLongClickListener(null);
                  }
                  if (SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this) != null)
                  {
                    SnsOnlineVideoActivity.g(SnsOnlineVideoActivity.this).recycle();
                    SnsOnlineVideoActivity.a(SnsOnlineVideoActivity.this, null);
                  }
                  if (!SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this)) {
                    break;
                  }
                  AppMethodBeat.o(98950);
                  return true;
                  SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this, false);
                  break label776;
                  label870:
                  if (f3 > 10.0F) {
                    SnsOnlineVideoActivity.c(SnsOnlineVideoActivity.this, true);
                  }
                }
              }
            });
            paramBundle = this.PNI;
            if (paramBundle != null) {
              break label1878;
            }
            Log.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
            if (this.isPreview)
            {
              if (!this.Rga) {
                addIconOptionMenu(0, b.j.app_delete, b.i.icons_outlined_delete, new MenuItem.OnMenuItemClickListener()
                {
                  public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
                  {
                    AppMethodBeat.i(98952);
                    com.tencent.mm.ui.base.k.a(SnsOnlineVideoActivity.this, b.j.sns_upload_browse_del, b.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(98951);
                        SnsOnlineVideoActivity.m(SnsOnlineVideoActivity.this);
                        SnsOnlineVideoActivity.this.dmJ();
                        AppMethodBeat.o(98951);
                      }
                    }, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                    });
                    AppMethodBeat.o(98952);
                    return true;
                  }
                });
              }
              setBackBtn(new SnsOnlineVideoActivity.12(this));
            }
            dmP();
            paramBundle = new abi();
            paramBundle.ieT.type = 1;
            paramBundle.publish();
            AppMethodBeat.o(98959);
            return;
          }
          break;
        }
      }
      catch (Exception paramBundle)
      {
        Log.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + paramBundle.toString());
        continue;
      }
      this.fullPath = paramBundle;
      continue;
      label1212:
      if (!this.isPreview) {
        getWindow().setFlags(1024, 1024);
      }
      this.KTF = false;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98966);
    Log.i("MicroMsg.SnsOnlineVideoActivity", "onDestroy fromPlayingVideo %s", new Object[] { Boolean.valueOf(this.Rvi) });
    if (this.Rvi)
    {
      com.tencent.mm.plugin.sns.ui.video.e.hsu().bx(this);
      this.Rvd.onDestroy();
      this.Rvd.hmD();
      if (!this.Rvj) {
        com.tencent.mm.plugin.sns.ui.video.e.hsu().onUIPause();
      }
    }
    try
    {
      for (;;)
      {
        getWindow().clearFlags(128);
        label80:
        super.onDestroy();
        if ((this.PNI != null) && (this.PNI.getTimeLine().ContentObj.Zpr.size() > 0))
        {
          final int i = this.Rvd.getPlayVideoDuration();
          final String str = ((dmz)this.PNI.getTimeLine().ContentObj.Zpr.get(0)).Url;
          final int j = this.PNI.getTimeLine().sightFolded;
          com.tencent.threadpool.h.ahAA.bn(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(98939);
              PInt localPInt = new PInt();
              ab.a(az.a(SnsOnlineVideoActivity.u(SnsOnlineVideoActivity.this), (dmz)SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).getTimeLine().ContentObj.Zpr.get(0)), localPInt, new PInt());
              com.tencent.mm.plugin.report.service.h.OAn.b(15534, new Object[] { str, SnsOnlineVideoActivity.q(SnsOnlineVideoActivity.this).getTimeLine().Id, Integer.valueOf(j), Integer.valueOf(localPInt.value * 1000), Integer.valueOf(i * 1000) });
              AppMethodBeat.o(98939);
            }
          });
        }
        com.tencent.mm.plugin.comm.b.e.xfd.a("SnsPublishProcess", "mediaPreviewPageStaytime_", Long.valueOf(getActivityBrowseTimeMs()), com.tencent.mm.plugin.comm.b.c.xeT);
        AppMethodBeat.o(98966);
        return;
        this.Rvd.onDestroy();
      }
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98965);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    if (this.Rvi)
    {
      ((SnsTimelineVideoView)this.Rvd).hsk();
      if (!this.Rvf)
      {
        Log.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
        if (!this.Rvg) {
          break label116;
        }
        new MMHandler().postDelayed(new SnsOnlineVideoActivity.3(this), 500L);
      }
    }
    for (;;)
    {
      super.onPause();
      com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      AppMethodBeat.o(98965);
      return;
      this.Rvd.onPause();
      break;
      label116:
      new MMHandler().post(new SnsOnlineVideoActivity.4(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98964);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if (this.Rvi) {
      this.Rvd.bcl();
    }
    for (;;)
    {
      this.AlL = false;
      if (this.Rvf) {
        this.Rvf = false;
      }
      super.onResume();
      com.tencent.mm.plugin.ball.f.f.d(true, true, true);
      AppMethodBeat.o(98964);
      return;
      if (!this.AlL) {
        this.Rvd.onResume();
      }
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98963);
    Bundle localBundle = this.wAX;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.wAZ = getIntent().getIntExtra("img_gallery_top", 0);
        this.wBa = getIntent().getIntExtra("img_gallery_left", 0);
        this.wBb = getIntent().getIntExtra("img_gallery_width", 0);
        this.wBc = getIntent().getIntExtra("img_gallery_height", 0);
        if (this.wAY != null) {
          this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
        }
        if (localBundle == null) {
          this.Rve.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(308096);
              SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this).getViewTreeObserver().removeOnPreDrawListener(this);
              if (SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this) != null)
              {
                SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this).setThumbViewScaleType(ImageView.ScaleType.FIT_CENTER);
                SnsOnlineVideoActivity.v(SnsOnlineVideoActivity.this).a(SnsOnlineVideoActivity.d(SnsOnlineVideoActivity.this), SnsOnlineVideoActivity.j(SnsOnlineVideoActivity.this), new f.c()
                {
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(308021);
                    if (!SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this).cFq) {
                      SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this).postDelayed(new SnsOnlineVideoActivity.5.1..ExternalSyntheticLambda0(this), 50L);
                    }
                    if (SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this) != null)
                    {
                      if (SnsOnlineVideoActivity.x(SnsOnlineVideoActivity.this))
                      {
                        SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this).bcl();
                        AppMethodBeat.o(308021);
                        return;
                      }
                      SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this).onResume();
                    }
                    AppMethodBeat.o(308021);
                  }
                  
                  public final void onAnimationStart()
                  {
                    AppMethodBeat.i(308019);
                    SnsOnlineVideoActivity.w(SnsOnlineVideoActivity.this).RgJ.setVisibility(0);
                    AppMethodBeat.o(308019);
                  }
                });
              }
              AppMethodBeat.o(308096);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    AppMethodBeat.o(98963);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity
 * JD-Core Version:    0.7.0.1
 */