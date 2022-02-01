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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

@i
public class SelfQRCodeUI
  extends MMActivity
  implements f
{
  private static final String PATH;
  private ProgressDialog fMu = null;
  private Bitmap hMs = null;
  private ImageView lZa = null;
  private TextView odU = null;
  private long pek;
  private TextView sBm = null;
  private String userName = "";
  private ImageView yDR = null;
  private byte[] yDS = null;
  private boolean yEG = false;
  private LinearLayout yEH;
  private b yEI;
  
  static
  {
    AppMethodBeat.i(73978);
    PATH = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(73978);
  }
  
  private void Pb(int paramInt)
  {
    AppMethodBeat.i(73970);
    if (this.yEG) {}
    for (int i = com.tencent.mm.sdk.platformtools.bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(66561, null));; i = 0)
    {
      Object localObject;
      if (w.zl(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755906);
        this.fMu = h.b(localAppCompatActivity, getString(2131763030), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(220950);
            com.tencent.mm.kernel.g.aiU().a(this.diy);
            if ((w.zj(SelfQRCodeUI.d(SelfQRCodeUI.this))) || (com.tencent.mm.am.g.DQ(SelfQRCodeUI.d(SelfQRCodeUI.this)))) {
              SelfQRCodeUI.this.finish();
            }
            AppMethodBeat.o(220950);
          }
        });
        AppMethodBeat.o(73970);
        return;
        localObject = new com.tencent.mm.bd.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject, 0);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(73972);
    if (com.tencent.mm.plugin.setting.b.iRH.b(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(73972);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(2131759562, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(73972);
      return;
    }
    this.yDS = parama.dNq();
    this.hMs = com.tencent.mm.sdk.platformtools.g.cr(this.yDS);
    if ((w.zj(this.userName)) || (com.tencent.mm.am.g.DQ(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.dNr();
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString)) {
        ((TextView)findViewById(2131303626)).setText(paramString);
      }
    }
    for (;;)
    {
      this.yDR.setImageBitmap(this.hMs);
      AppMethodBeat.o(73972);
      return;
      if (this.yEG)
      {
        paramString = parama.dNs();
        parama = (TextView)findViewById(2131305888);
        View localView = (View)parama.getParent();
        if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramString))
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
  
  public static void dNp()
  {
    AppMethodBeat.i(73973);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 14L, 1L, true);
    AppMethodBeat.o(73973);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495366;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73969);
    this.userName = getIntent().getStringExtra("from_userName");
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.userName)) {
      this.userName = u.aAm();
    }
    if (u.aAm().equals(this.userName)) {
      this.yEG = true;
    }
    Object localObject1;
    Object localObject2;
    if (w.zj(this.userName))
    {
      setMMTitle(2131763386);
      ((TextView)findViewById(2131303626)).setText("");
      enableOptionMenu(false);
      this.yEH = ((LinearLayout)findViewById(2131303612));
      this.yDR = ((ImageView)findViewById(2131304554));
      this.lZa = ((ImageView)findViewById(2131300718));
      this.odU = ((TextView)findViewById(2131302858));
      this.sBm = ((TextView)findViewById(2131299151));
      this.yEH.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(73954);
          SelfQRCodeUI.b(SelfQRCodeUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int i = aq.fromDPToPix(SelfQRCodeUI.this.getContext(), 500);
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
      if ((!w.zj(this.userName)) && (!com.tencent.mm.am.g.DQ(this.userName))) {
        break label471;
      }
      Pb(1);
      a.b.c(this.lZa, this.userName);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
      this.odU.setSingleLine(false);
      this.odU.setMaxLines(3);
      if (!w.zm(this.userName)) {
        break label445;
      }
      localObject2 = getResources().getDrawable(2131691000);
      this.odU.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label287:
      if (localObject1 == null) {
        break label459;
      }
      localObject2 = ((aw)localObject1).field_nickname;
      localObject1 = localObject2;
      if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2)) {
        localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).azz().AO(this.userName).field_displayname;
      }
      this.odU.setText(k.b(this, (CharSequence)localObject1, this.odU.getTextSize()));
      label351:
      this.sBm.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
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
      if (com.tencent.mm.am.g.DQ(this.userName))
      {
        setMMTitle(2131758446);
        ((TextView)findViewById(2131303626)).setText(2131758447);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(2131763374);
      break;
      label445:
      this.odU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label287;
      label459:
      this.odU.setVisibility(8);
      break label351;
      label471:
      localObject2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(42, null);
      localObject1 = getString(2131755760);
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label521:
        ad.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.hMs != null) {
          break label813;
        }
        ad.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        Pb(1);
      }
      for (;;)
      {
        a.b.c(this.lZa, u.aAm());
        localObject1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(4, null);
        ad.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.odU.setText(k.b(this, (CharSequence)localObject1, com.tencent.mm.cc.a.ax(getContext(), 2131165466)));
        localObject2 = com.tencent.mm.model.bt.aCv();
        localObject1 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((com.tencent.mm.model.bt)localObject2).getProvince());
        localObject2 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(((com.tencent.mm.model.bt)localObject2).getCity());
        localObject1 = v.zh((String)localObject1) + " " + (String)localObject2;
        ad.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.sBm.setText((CharSequence)localObject1);
        switch (com.tencent.mm.sdk.platformtools.bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.odU.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this, 2131690323), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          am.aSX((String)localObject2);
          break label521;
          label813:
          this.yDR.setImageBitmap(this.hMs);
        }
      }
      this.odU.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this, 2131690322), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73966);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.yEI = new b(this);
    this.yEI.start();
    com.tencent.mm.kernel.g.aiU().a(168, this);
    com.tencent.mm.kernel.g.aiU().a(890, this);
    initView();
    this.yDR.post(new Runnable()
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
    AppMethodBeat.o(73966);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73967);
    com.tencent.mm.kernel.g.aiU().b(168, this);
    com.tencent.mm.kernel.g.aiU().b(890, this);
    if (this.yEI != null) {
      this.yEI.stop();
    }
    if ((this.hMs != null) && (!this.hMs.isRecycled()))
    {
      ad.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.hMs.toString() });
      this.hMs.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(73967);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73968);
    super.onResume();
    if ((w.zj(this.userName)) || (com.tencent.mm.am.g.DQ(this.userName)))
    {
      AppMethodBeat.o(73968);
      return;
    }
    View localView = findViewById(2131304557);
    this.pek = u.aAr();
    ad.d("MicroMsg.SelfQRCodeNewUI", (this.pek & 0x2) + ",extstatus:" + this.pek);
    if ((this.pek & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.yDR.setAlpha(0.1F);
      findViewById(2131304556).setOnClickListener(new SelfQRCodeUI.10(this));
      AppMethodBeat.o(73968);
      return;
    }
    localView.setVisibility(8);
    this.yDR.setAlpha(1.0F);
    AppMethodBeat.o(73968);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(73971);
    ad.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if ((paramn instanceof com.tencent.mm.bd.a))
    {
      a(paramInt1, paramInt2, paramString, new SelfQRCodeUI.4(this, (com.tencent.mm.bd.a)paramn));
      AppMethodBeat.o(73971);
      return;
    }
    if ((paramn instanceof com.tencent.mm.openim.b.g))
    {
      paramn = (bfb)((com.tencent.mm.al.b)((com.tencent.mm.openim.b.g)paramn).getReqResp()).hNL.hNQ;
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] dNq()
        {
          return this.yEL;
        }
        
        public final String dNr()
        {
          return this.kAQ;
        }
        
        public final String dNs()
        {
          return this.kAQ;
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
    public abstract byte[] dNq();
    
    public abstract String dNr();
    
    public abstract String dNs();
  }
  
  public final class b
    extends FileObserver
  {
    private MMActivity yEM;
    private String yEN;
    
    public b(MMActivity paramMMActivity)
    {
      super(8);
      AppMethodBeat.i(73962);
      this.yEM = paramMMActivity;
      AppMethodBeat.o(73962);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      AppMethodBeat.i(73963);
      if ((paramString != null) && (paramInt == 8) && ((this.yEN == null) || (!paramString.equalsIgnoreCase(this.yEN))))
      {
        this.yEN = paramString;
        paramString = new com.tencent.mm.vfs.e(SelfQRCodeUI.ccN() + paramString);
        com.tencent.mm.sdk.platformtools.n.a(SelfQRCodeUI.this.getContext(), paramString);
        SelfQRCodeUI.dNp();
        ad.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */