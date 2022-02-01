package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.rg;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.model.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.HashSet;

@com.tencent.mm.kernel.k
public class SelfQRCodeUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h
{
  private static final String nbS;
  private TextView FPg = null;
  private ImageView PoV = null;
  private byte[] PoW = null;
  private boolean PpC = false;
  private LinearLayout PpD;
  private b PpE;
  private ProgressDialog lzP = null;
  private Bitmap orY = null;
  private ImageView ttT = null;
  private String userName = "";
  private TextView vKE = null;
  private long xct;
  
  static
  {
    AppMethodBeat.i(73978);
    nbS = com.tencent.mm.compatible.util.g.aPZ().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(73978);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(73972);
    if (com.tencent.mm.plugin.setting.c.pFo.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73972);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(b.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(73972);
      return;
    }
    this.PoW = parama.gVf();
    this.orY = BitmapUtil.decodeByteArray(this.PoW);
    if ((au.bwE(this.userName)) || (com.tencent.mm.an.g.MB(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.gVg();
      if (!Util.isNullOrNil(paramString)) {
        ((TextView)findViewById(b.f.qrcode_tip)).setText(paramString);
      }
    }
    for (;;)
    {
      this.PoV.setImageBitmap(this.orY);
      AppMethodBeat.o(73972);
      return;
      if (this.PpC)
      {
        paramString = parama.gVh();
        parama = (TextView)findViewById(b.f.tips_banner_tv);
        View localView = (View)parama.getParent();
        if (!Util.isNullOrNil(paramString))
        {
          parama.setText(paramString);
          localView.setOnClickListener(new SelfQRCodeUI.6(this));
          localView.setVisibility(0);
        }
        else
        {
          localView.setVisibility(8);
        }
      }
    }
  }
  
  private void aiT(int paramInt)
  {
    AppMethodBeat.i(73970);
    if (this.PpC) {}
    for (int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(66561, null));; i = 0)
    {
      Object localObject;
      if (au.bwF(this.userName))
      {
        localObject = new i(this.userName);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(b.i.app_tip);
        this.lzP = com.tencent.mm.ui.base.k.a(localAppCompatActivity, getString(b.i.self_qrcode_getting), true, new SelfQRCodeUI.13(this, (com.tencent.mm.am.p)localObject));
        AppMethodBeat.o(73970);
        return;
        localObject = new com.tencent.mm.az.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
      }
    }
  }
  
  public static void gVe()
  {
    AppMethodBeat.i(73973);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 14L, 1L, true);
    AppMethodBeat.o(73973);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return b.g.self_qrcode;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73969);
    this.userName = getIntent().getStringExtra("from_userName");
    if (Util.isNullOrNil(this.userName)) {
      this.userName = z.bAM();
    }
    if (z.bAM().equals(this.userName)) {
      this.PpC = true;
    }
    if (au.bwE(this.userName))
    {
      setMMTitle(b.i.settings_room_qrcode_card);
      ((TextView)findViewById(b.f.qrcode_tip)).setText("");
      enableOptionMenu(false);
      this.PpD = ((LinearLayout)findViewById(b.f.qrcode_bg));
      this.PoV = ((ImageView)findViewById(b.f.self_qrcode_iv));
      this.ttT = ((ImageView)findViewById(b.f.header_icon));
      this.vKE = ((TextView)findViewById(b.f.nick_name));
      this.FPg = ((TextView)findViewById(b.f.district));
      this.PpD.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(73954);
          SelfQRCodeUI.b(SelfQRCodeUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int i = bd.fromDPToPix(SelfQRCodeUI.this.getContext(), 500);
          if (SelfQRCodeUI.b(SelfQRCodeUI.this).getWidth() > i)
          {
            ViewGroup.LayoutParams localLayoutParams = SelfQRCodeUI.b(SelfQRCodeUI.this).getLayoutParams();
            localLayoutParams.width = i;
            SelfQRCodeUI.b(SelfQRCodeUI.this).setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(73954);
          return true;
        }
      });
      if ((!au.bwE(this.userName)) && (!com.tencent.mm.an.g.MB(this.userName))) {
        break label473;
      }
      aiT(1);
      a.b.g(this.ttT, this.userName);
      localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.userName);
      this.vKE.setSingleLine(false);
      this.vKE.setMaxLines(3);
      if (!ab.IG(this.userName)) {
        break label447;
      }
      localObject2 = getResources().getDrawable(b.h.open_im_main_logo);
      this.vKE.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label288:
      if (localObject1 == null) {
        break label461;
      }
      localObject2 = ((az)localObject1).field_nickname;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(this.userName).field_displayname;
      }
      this.vKE.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject1, this.vKE.getTextSize()));
    }
    for (;;)
    {
      this.FPg.setVisibility(8);
      addIconOptionMenu(0, b.h.icons_outlined_more, new SelfQRCodeUI.8(this));
      setBackBtn(new SelfQRCodeUI.9(this));
      AppMethodBeat.o(73969);
      return;
      if (com.tencent.mm.an.g.MB(this.userName))
      {
        setMMTitle(b.i.enterprise_qrcode);
        ((TextView)findViewById(b.f.qrcode_tip)).setText(b.i.enterprise_qrcode_tip);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(b.i.settings_qrcode_card);
      break;
      label447:
      this.vKE.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label288;
      label461:
      this.vKE.setVisibility(8);
    }
    label473:
    Object localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().d(42, null);
    Object localObject1 = getString(b.i.app_field_username);
    if (!Util.isNullOrNil((String)localObject2))
    {
      localObject1 = (String)localObject1 + (String)localObject2;
      label523:
      Log.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
      if (this.orY != null) {
        break label827;
      }
      Log.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
      aiT(1);
      label571:
      a.b.g(this.ttT, z.bAM());
      localObject1 = (String)com.tencent.mm.kernel.h.baE().ban().d(4, null);
      Log.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
      this.vKE.setText(com.tencent.mm.pluginsdk.ui.span.p.d(this, (CharSequence)localObject1, com.tencent.mm.cd.a.br(getContext(), b.d.HintTextSize)));
      localObject2 = cb.bDe();
      localObject1 = Util.nullAsNil(((cb)localObject2).getProvince());
      localObject2 = Util.nullAsNil(((cb)localObject2).getCity());
      localObject1 = aa.IF((String)localObject1) + " " + (String)localObject2;
      Log.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
      this.FPg.setText((CharSequence)localObject1);
      switch (Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(12290, null), 0))
      {
      default: 
        localObject1 = "";
      }
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.setting.ui.a.a)com.tencent.mm.ui.component.k.d(getContext()).q(com.tencent.mm.plugin.setting.ui.a.a.class)).setValue("sex_key", (String)localObject1);
      break;
      localObject2 = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
      localObject1 = (String)localObject1 + (String)localObject2;
      au.bxb((String)localObject2);
      break label523;
      label827:
      this.PoV.setImageBitmap(this.orY);
      break label571;
      this.vKE.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cd.a.m(this, b.h.ic_sex_male), null);
      localObject1 = getResources().getString(b.i.sex_male);
      continue;
      this.vKE.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cd.a.m(this, b.h.ic_sex_female), null);
      localObject1 = getResources().getString(b.i.sex_female);
    }
  }
  
  public boolean isLayoutInDecorView()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73966);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.PpE = new b(this);
    this.PpE.start();
    com.tencent.mm.kernel.h.aZW().a(168, this);
    com.tencent.mm.kernel.h.aZW().a(890, this);
    initView();
    this.PoV.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(73952);
        int i = SelfQRCodeUI.a(SelfQRCodeUI.this).getWidth();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)SelfQRCodeUI.a(SelfQRCodeUI.this).getLayoutParams();
        localLayoutParams.width = i;
        localLayoutParams.height = i;
        SelfQRCodeUI.a(SelfQRCodeUI.this).setLayoutParams(localLayoutParams);
        AppMethodBeat.o(73952);
      }
    });
    paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramBundle = (dgs)a.a.b(this, 3, dgs.class);
    if ((paramBundle != null) && ("launch_type_my_qrcode".equals(paramBundle.aaLL)))
    {
      paramBundle = new rg();
      paramBundle.iUz = 3L;
      paramBundle.jvA = 1L;
      paramBundle.bMH();
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a(paramBundle);
    }
    AppMethodBeat.o(73966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73967);
    com.tencent.mm.kernel.h.aZW().b(168, this);
    com.tencent.mm.kernel.h.aZW().b(890, this);
    if (this.PpE != null) {
      this.PpE.stop();
    }
    if ((this.orY != null) && (!this.orY.isRecycled()))
    {
      Log.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.orY.toString() });
      this.orY.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(73967);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73968);
    super.onResume();
    if ((au.bwE(this.userName)) || (com.tencent.mm.an.g.MB(this.userName)))
    {
      AppMethodBeat.o(73968);
      return;
    }
    View localView = findViewById(b.f.self_qrcode_verify_open_prompt);
    this.xct = z.bAR();
    Log.d("MicroMsg.SelfQRCodeNewUI", (this.xct & 0x2) + ",extstatus:" + this.xct);
    if ((this.xct & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.PoV.setAlpha(0.1F);
      findViewById(b.f.self_qrcode_verify_openBt).setOnClickListener(new SelfQRCodeUI.10(this));
      AppMethodBeat.o(73968);
      return;
    }
    localView.setVisibility(8);
    this.PoV.setAlpha(1.0F);
    AppMethodBeat.o(73968);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(73971);
    Log.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if ((paramp instanceof com.tencent.mm.az.a))
    {
      a(paramInt1, paramInt2, paramString, new SelfQRCodeUI.4(this, (com.tencent.mm.az.a)paramp));
      AppMethodBeat.o(73971);
      return;
    }
    if ((paramp instanceof i))
    {
      paramp = (coo)c.c.b(((com.tencent.mm.am.c)((i)paramp).getReqResp()).otC);
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] gVf()
        {
          return this.PpH;
        }
        
        public final String gVg()
        {
          return this.rHW;
        }
        
        public final String gVh()
        {
          return this.rHW;
        }
      });
    }
    AppMethodBeat.o(73971);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(298764);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.setting.ui.a.a.class);
    AppMethodBeat.o(298764);
  }
  
  static abstract interface a
  {
    public abstract byte[] gVf();
    
    public abstract String gVg();
    
    public abstract String gVh();
  }
  
  public final class b
    extends FileObserver
  {
    private MMActivity PpJ;
    private String PpK;
    
    public b(MMActivity paramMMActivity)
    {
      super(8);
      AppMethodBeat.i(73962);
      this.PpJ = paramMMActivity;
      AppMethodBeat.o(73962);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      AppMethodBeat.i(73963);
      if ((paramString != null) && (paramInt == 8) && ((this.PpK == null) || (!paramString.equalsIgnoreCase(this.PpK))))
      {
        this.PpK = paramString;
        paramString = new u(SelfQRCodeUI.cIl() + paramString);
        FileProviderHelper.getUriForFile(SelfQRCodeUI.this.getContext(), paramString);
        SelfQRCodeUI.gVe();
        Log.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
      }
      AppMethodBeat.o(73963);
    }
    
    public final void start()
    {
      AppMethodBeat.i(73964);
      super.startWatching();
      AppMethodBeat.o(73964);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(73965);
      super.stopWatching();
      AppMethodBeat.o(73965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */