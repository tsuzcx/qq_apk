package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.bj.e;
import com.tencent.mm.f.b.a.no;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.io.File;

@k
public class SelfQRCodeUI
  extends MMSecDataActivity
  implements i
{
  private static final String PATH;
  private TextView Apc = null;
  private ImageView Jev = null;
  private byte[] Jew = null;
  private boolean Jfc = false;
  private LinearLayout Jfd;
  private b Jfe;
  private ProgressDialog iXX = null;
  private Bitmap lAx = null;
  private ImageView qps = null;
  private TextView sEX = null;
  private long tZb;
  private String userName = "";
  
  static
  {
    AppMethodBeat.i(73978);
    PATH = com.tencent.mm.compatible.util.g.avF().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(73978);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(73972);
    if (com.tencent.mm.plugin.setting.c.mIH.b(getContext(), paramInt1, paramInt2, paramString))
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
    this.Jew = parama.fFR();
    this.lAx = BitmapUtil.decodeByteArray(this.Jew);
    if ((ab.PO(this.userName)) || (com.tencent.mm.ao.g.UC(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.fFS();
      if (!Util.isNullOrNil(paramString)) {
        ((TextView)findViewById(b.f.qrcode_tip)).setText(paramString);
      }
    }
    for (;;)
    {
      this.Jev.setImageBitmap(this.lAx);
      AppMethodBeat.o(73972);
      return;
      if (this.Jfc)
      {
        paramString = parama.fFT();
        parama = (TextView)findViewById(b.f.tips_banner_tv);
        View localView = (View)parama.getParent();
        if (!Util.isNullOrNil(paramString))
        {
          parama.setText(paramString);
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(264377);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              SelfQRCodeUI.h(SelfQRCodeUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(264377);
            }
          });
          localView.setVisibility(0);
        }
        else
        {
          localView.setVisibility(8);
        }
      }
    }
  }
  
  private void aen(int paramInt)
  {
    AppMethodBeat.i(73970);
    if (this.Jfc) {}
    for (int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(66561, null));; i = 0)
    {
      Object localObject;
      if (ab.PQ(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(b.i.app_tip);
        this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(b.i.self_qrcode_getting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(264740);
            com.tencent.mm.kernel.h.aGY().a(this.ftz);
            if ((ab.PO(SelfQRCodeUI.d(SelfQRCodeUI.this))) || (com.tencent.mm.ao.g.UC(SelfQRCodeUI.d(SelfQRCodeUI.this)))) {
              SelfQRCodeUI.this.finish();
            }
            AppMethodBeat.o(264740);
          }
        });
        AppMethodBeat.o(73970);
        return;
        localObject = new com.tencent.mm.bf.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject, 0);
      }
    }
  }
  
  public static void fFQ()
  {
    AppMethodBeat.i(73973);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 14L, 1L, true);
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
      this.userName = z.bcZ();
    }
    if (z.bcZ().equals(this.userName)) {
      this.Jfc = true;
    }
    Object localObject1;
    Object localObject2;
    if (ab.PO(this.userName))
    {
      setMMTitle(b.i.settings_room_qrcode_card);
      ((TextView)findViewById(b.f.qrcode_tip)).setText("");
      enableOptionMenu(false);
      this.Jfd = ((LinearLayout)findViewById(b.f.qrcode_bg));
      this.Jev = ((ImageView)findViewById(b.f.self_qrcode_iv));
      this.qps = ((ImageView)findViewById(b.f.header_icon));
      this.sEX = ((TextView)findViewById(b.f.nick_name));
      this.Apc = ((TextView)findViewById(b.f.district));
      this.Jfd.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(73954);
          SelfQRCodeUI.b(SelfQRCodeUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int i = aw.fromDPToPix(SelfQRCodeUI.this.getContext(), 500);
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
      if ((!ab.PO(this.userName)) && (!com.tencent.mm.ao.g.UC(this.userName))) {
        break label473;
      }
      aen(1);
      a.b.c(this.qps, this.userName);
      localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.userName);
      this.sEX.setSingleLine(false);
      this.sEX.setMaxLines(3);
      if (!ab.PR(this.userName)) {
        break label447;
      }
      localObject2 = getResources().getDrawable(b.h.open_im_main_logo);
      this.sEX.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label288:
      if (localObject1 == null) {
        break label461;
      }
      localObject2 = ((ax)localObject1).field_nickname;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rx(this.userName).field_displayname;
      }
      this.sEX.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, this.sEX.getTextSize()));
      label352:
      this.Apc.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, b.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73955);
          SelfQRCodeUI.c(SelfQRCodeUI.this);
          AppMethodBeat.o(73955);
          return true;
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(73956);
          SelfQRCodeUI.this.hideVKB();
          SelfQRCodeUI.this.finish();
          AppMethodBeat.o(73956);
          return true;
        }
      });
      AppMethodBeat.o(73969);
      return;
      if (com.tencent.mm.ao.g.UC(this.userName))
      {
        setMMTitle(b.i.enterprise_qrcode);
        ((TextView)findViewById(b.f.qrcode_tip)).setText(b.i.enterprise_qrcode_tip);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(b.i.settings_qrcode_card);
      break;
      label447:
      this.sEX.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label288;
      label461:
      this.sEX.setVisibility(8);
      break label352;
      label473:
      localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(42, null);
      localObject1 = getString(b.i.app_field_username);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label523:
        Log.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.lAx != null) {
          break label817;
        }
        Log.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        aen(1);
      }
      for (;;)
      {
        a.b.c(this.qps, z.bcZ());
        localObject1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(4, null);
        Log.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.sEX.setText(com.tencent.mm.pluginsdk.ui.span.l.d(this, (CharSequence)localObject1, com.tencent.mm.ci.a.aY(getContext(), b.d.HintTextSize)));
        localObject2 = ca.bfn();
        localObject1 = Util.nullAsNil(((ca)localObject2).getProvince());
        localObject2 = Util.nullAsNil(((ca)localObject2).getCity());
        localObject1 = aa.PL((String)localObject1) + " " + (String)localObject2;
        Log.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.Apc.setText((CharSequence)localObject1);
        switch (Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.sEX.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.ci.a.m(this, b.h.ic_sex_male), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          as.bvU((String)localObject2);
          break label523;
          label817:
          this.Jev.setImageBitmap(this.lAx);
        }
      }
      this.sEX.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.ci.a.m(this, b.h.ic_sex_female), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73966);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.Jfe = new b(this);
    this.Jfe.start();
    com.tencent.mm.kernel.h.aGY().a(168, this);
    com.tencent.mm.kernel.h.aGY().a(890, this);
    initView();
    this.Jev.post(new Runnable()
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
    paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramBundle = (cpy)a.a.b(this, 3, cpy.class);
    if ((paramBundle != null) && ("launch_type_my_qrcode".equals(paramBundle.Txg)))
    {
      paramBundle = new no();
      paramBundle.ggN = 3L;
      paramBundle.gZO = 1L;
      paramBundle.bpa();
      com.tencent.mm.util.c localc = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a(paramBundle);
    }
    AppMethodBeat.o(73966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73967);
    com.tencent.mm.kernel.h.aGY().b(168, this);
    com.tencent.mm.kernel.h.aGY().b(890, this);
    if (this.Jfe != null) {
      this.Jfe.stop();
    }
    if ((this.lAx != null) && (!this.lAx.isRecycled()))
    {
      Log.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.lAx.toString() });
      this.lAx.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(73967);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73968);
    super.onResume();
    if ((ab.PO(this.userName)) || (com.tencent.mm.ao.g.UC(this.userName)))
    {
      AppMethodBeat.o(73968);
      return;
    }
    View localView = findViewById(b.f.self_qrcode_verify_open_prompt);
    this.tZb = z.bde();
    Log.d("MicroMsg.SelfQRCodeNewUI", (this.tZb & 0x2) + ",extstatus:" + this.tZb);
    if ((this.tZb & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.Jev.setAlpha(0.1F);
      findViewById(b.f.self_qrcode_verify_openBt).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73957);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.by.c.ad(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SelfQRCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(73957);
        }
      });
      AppMethodBeat.o(73968);
      return;
    }
    localView.setVisibility(8);
    this.Jev.setAlpha(1.0F);
    AppMethodBeat.o(73968);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(73971);
    Log.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if ((paramq instanceof com.tencent.mm.bf.a))
    {
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] fFR()
        {
          return this.Jfg.lYk;
        }
        
        public final String fFS()
        {
          return this.Jfg.lYi;
        }
        
        public final String fFT()
        {
          return this.Jfg.lYj;
        }
      });
      AppMethodBeat.o(73971);
      return;
    }
    if ((paramq instanceof com.tencent.mm.openim.b.g))
    {
      paramq = (bzj)d.c.b(((d)((com.tencent.mm.openim.b.g)paramq).getReqResp()).lBS);
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] fFR()
        {
          return this.Jfh;
        }
        
        public final String fFS()
        {
          return this.oET;
        }
        
        public final String fFT()
        {
          return this.oET;
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
  
  static abstract interface a
  {
    public abstract byte[] fFR();
    
    public abstract String fFS();
    
    public abstract String fFT();
  }
  
  public final class b
    extends FileObserver
  {
    private MMActivity Jfi;
    private String Jfj;
    
    public b(MMActivity paramMMActivity)
    {
      super(8);
      AppMethodBeat.i(73962);
      this.Jfi = paramMMActivity;
      AppMethodBeat.o(73962);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      AppMethodBeat.i(73963);
      if ((paramString != null) && (paramInt == 8) && ((this.Jfj == null) || (!paramString.equalsIgnoreCase(this.Jfj))))
      {
        this.Jfj = paramString;
        paramString = new com.tencent.mm.vfs.q(SelfQRCodeUI.chp() + paramString);
        FileProviderHelper.getUriForFile(SelfQRCodeUI.this.getContext(), paramString);
        SelfQRCodeUI.fFQ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */