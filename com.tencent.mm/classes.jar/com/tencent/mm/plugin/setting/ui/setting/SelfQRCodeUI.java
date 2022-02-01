package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.vfs.o;
import java.io.File;

@com.tencent.mm.kernel.i
public class SelfQRCodeUI
  extends MMSecDataActivity
  implements com.tencent.mm.ak.i
{
  private static final String PATH;
  private ImageView CYP = null;
  private byte[] CYQ = null;
  private boolean CZB = false;
  private LinearLayout CZC;
  private b CZD;
  private ProgressDialog gtM = null;
  private Bitmap iKs = null;
  private ImageView nnL = null;
  private TextView pvG = null;
  private long qAb;
  private String userName = "";
  private TextView vIf = null;
  
  static
  {
    AppMethodBeat.i(73978);
    PATH = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(73978);
  }
  
  private void Xo(int paramInt)
  {
    AppMethodBeat.i(73970);
    if (this.CZB) {}
    for (int i = Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(66561, null));; i = 0)
    {
      Object localObject;
      if (ab.Iy(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755998);
        this.gtM = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131765181), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(256480);
            com.tencent.mm.kernel.g.azz().a(this.dAK);
            if ((ab.Iw(SelfQRCodeUI.d(SelfQRCodeUI.this))) || (com.tencent.mm.al.g.Ng(SelfQRCodeUI.d(SelfQRCodeUI.this)))) {
              SelfQRCodeUI.this.finish();
            }
            AppMethodBeat.o(256480);
          }
        });
        AppMethodBeat.o(73970);
        return;
        localObject = new com.tencent.mm.bc.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(73972);
    if (com.tencent.mm.plugin.setting.c.jRu.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73972);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131760879, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(73972);
      return;
    }
    this.CYQ = parama.eSN();
    this.iKs = BitmapUtil.decodeByteArray(this.CYQ);
    if ((ab.Iw(this.userName)) || (com.tencent.mm.al.g.Ng(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.eSO();
      if (!Util.isNullOrNil(paramString)) {
        ((TextView)findViewById(2131306405)).setText(paramString);
      }
    }
    for (;;)
    {
      this.CYP.setImageBitmap(this.iKs);
      AppMethodBeat.o(73972);
      return;
      if (this.CZB)
      {
        paramString = parama.eSP();
        parama = (TextView)findViewById(2131309171);
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
  
  public static void eSM()
  {
    AppMethodBeat.i(73973);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 14L, 1L, true);
    AppMethodBeat.o(73973);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496227;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73969);
    this.userName = getIntent().getStringExtra("from_userName");
    if (Util.isNullOrNil(this.userName)) {
      this.userName = z.aTY();
    }
    if (z.aTY().equals(this.userName)) {
      this.CZB = true;
    }
    Object localObject1;
    Object localObject2;
    if (ab.Iw(this.userName))
    {
      setMMTitle(2131765568);
      ((TextView)findViewById(2131306405)).setText("");
      enableOptionMenu(false);
      this.CZC = ((LinearLayout)findViewById(2131306390));
      this.CYP = ((ImageView)findViewById(2131307592));
      this.nnL = ((ImageView)findViewById(2131302292));
      this.pvG = ((TextView)findViewById(2131305431));
      this.vIf = ((TextView)findViewById(2131299679));
      this.CZC.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(73954);
          SelfQRCodeUI.b(SelfQRCodeUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int i = at.fromDPToPix(SelfQRCodeUI.this.getContext(), 500);
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
      if ((!ab.Iw(this.userName)) && (!com.tencent.mm.al.g.Ng(this.userName))) {
        break label471;
      }
      Xo(1);
      a.b.c(this.nnL, this.userName);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
      this.pvG.setSingleLine(false);
      this.pvG.setMaxLines(3);
      if (!ab.Iz(this.userName)) {
        break label445;
      }
      localObject2 = getResources().getDrawable(2131691298);
      this.pvG.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label287:
      if (localObject1 == null) {
        break label459;
      }
      localObject2 = ((ax)localObject1).field_nickname;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.userName).field_displayname;
      }
      this.pvG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, this.pvG.getTextSize()));
      label351:
      this.vIf.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
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
      if (com.tencent.mm.al.g.Ng(this.userName))
      {
        setMMTitle(2131758744);
        ((TextView)findViewById(2131306405)).setText(2131758745);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(2131765556);
      break;
      label445:
      this.pvG.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label287;
      label459:
      this.pvG.setVisibility(8);
      break label351;
      label471:
      localObject2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(42, null);
      localObject1 = getString(2131755837);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label521:
        Log.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.iKs != null) {
          break label813;
        }
        Log.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        Xo(1);
      }
      for (;;)
      {
        a.b.c(this.nnL, z.aTY());
        localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(4, null);
        Log.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.pvG.setText(com.tencent.mm.pluginsdk.ui.span.l.e(this, (CharSequence)localObject1, com.tencent.mm.cb.a.aG(getContext(), 2131165482)));
        localObject2 = bz.aWj();
        localObject1 = Util.nullAsNil(((bz)localObject2).getProvince());
        localObject2 = Util.nullAsNil(((bz)localObject2).getCity());
        localObject1 = aa.It((String)localObject1) + " " + (String)localObject2;
        Log.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.vIf.setText((CharSequence)localObject1);
        switch (Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.pvG.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.l(this, 2131690428), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          as.bjx((String)localObject2);
          break label521;
          label813:
          this.CYP.setImageBitmap(this.iKs);
        }
      }
      this.pvG.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.l(this, 2131690427), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73966);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.CZD = new b(this);
    this.CZD.start();
    com.tencent.mm.kernel.g.azz().a(168, this);
    com.tencent.mm.kernel.g.azz().a(890, this);
    initView();
    this.CYP.post(new Runnable()
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
    paramBundle = SecDataUIC.CWq;
    paramBundle = (chc)SecDataUIC.a.b(this, 3, chc.class);
    if ((paramBundle != null) && ("launch_type_my_qrcode".equals(paramBundle.Mmm)))
    {
      paramBundle = new ks();
      paramBundle.elF = 3L;
      paramBundle.eXj = 1L;
      paramBundle.bfK();
      com.tencent.mm.util.b localb = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a(paramBundle);
    }
    AppMethodBeat.o(73966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73967);
    com.tencent.mm.kernel.g.azz().b(168, this);
    com.tencent.mm.kernel.g.azz().b(890, this);
    if (this.CZD != null) {
      this.CZD.stop();
    }
    if ((this.iKs != null) && (!this.iKs.isRecycled()))
    {
      Log.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.iKs.toString() });
      this.iKs.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(73967);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73968);
    super.onResume();
    if ((ab.Iw(this.userName)) || (com.tencent.mm.al.g.Ng(this.userName)))
    {
      AppMethodBeat.o(73968);
      return;
    }
    View localView = findViewById(2131307595);
    this.qAb = z.aUd();
    Log.d("MicroMsg.SelfQRCodeNewUI", (this.qAb & 0x2) + ",extstatus:" + this.qAb);
    if ((this.qAb & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.CYP.setAlpha(0.1F);
      findViewById(2131307594).setOnClickListener(new SelfQRCodeUI.10(this));
      AppMethodBeat.o(73968);
      return;
    }
    localView.setVisibility(8);
    this.CYP.setAlpha(1.0F);
    AppMethodBeat.o(73968);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(73971);
    Log.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if ((paramq instanceof com.tencent.mm.bc.a))
    {
      a(paramInt1, paramInt2, paramString, new SelfQRCodeUI.4(this, (com.tencent.mm.bc.a)paramq));
      AppMethodBeat.o(73971);
      return;
    }
    if ((paramq instanceof com.tencent.mm.openim.b.g))
    {
      paramq = (brn)((d)((com.tencent.mm.openim.b.g)paramq).getReqResp()).iLL.iLR;
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] eSN()
        {
          return this.CZG;
        }
        
        public final String eSO()
        {
          return this.lIF;
        }
        
        public final String eSP()
        {
          return this.lIF;
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
    public abstract byte[] eSN();
    
    public abstract String eSO();
    
    public abstract String eSP();
  }
  
  public final class b
    extends FileObserver
  {
    private MMActivity CZH;
    private String CZI;
    
    public b(MMActivity paramMMActivity)
    {
      super(8);
      AppMethodBeat.i(73962);
      this.CZH = paramMMActivity;
      AppMethodBeat.o(73962);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      AppMethodBeat.i(73963);
      if ((paramString != null) && (paramInt == 8) && ((this.CZI == null) || (!paramString.equalsIgnoreCase(this.CZI))))
      {
        this.CZI = paramString;
        paramString = new o(SelfQRCodeUI.bUk() + paramString);
        FileProviderHelper.getUriForFile(SelfQRCodeUI.this.getContext(), paramString);
        SelfQRCodeUI.eSM();
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