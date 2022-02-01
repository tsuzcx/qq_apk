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
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

@i
public class SelfQRCodeUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private static final String PATH;
  private ProgressDialog fpP = null;
  private Bitmap gTB = null;
  private ImageView kXS = null;
  private TextView mZh = null;
  private long nXu;
  private TextView qLh = null;
  private String userName = "";
  private boolean weP = false;
  private LinearLayout weQ;
  private b weR;
  private ImageView wea = null;
  private byte[] web = null;
  
  static
  {
    AppMethodBeat.i(73978);
    PATH = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(73978);
  }
  
  private void Ly(int paramInt)
  {
    AppMethodBeat.i(73970);
    if (this.weP) {}
    for (int i = bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(66561, null));; i = 0)
    {
      Object localObject;
      if (com.tencent.mm.model.w.sn(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755906);
        this.fpP = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131763030), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(186522);
            com.tencent.mm.kernel.g.aeS().a(this.cZL);
            if ((com.tencent.mm.model.w.sl(SelfQRCodeUI.d(SelfQRCodeUI.this))) || (com.tencent.mm.am.f.wL(SelfQRCodeUI.d(SelfQRCodeUI.this)))) {
              SelfQRCodeUI.this.finish();
            }
            AppMethodBeat.o(186522);
          }
        });
        AppMethodBeat.o(73970);
        return;
        localObject = new com.tencent.mm.bd.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(73972);
    if (com.tencent.mm.plugin.setting.b.hYu.b(getContext(), paramInt1, paramInt2, paramString))
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
    this.web = parama.dnG();
    this.gTB = com.tencent.mm.sdk.platformtools.f.cl(this.web);
    if ((com.tencent.mm.model.w.sl(this.userName)) || (com.tencent.mm.am.f.wL(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.dnH();
      if (!bt.isNullOrNil(paramString)) {
        ((TextView)findViewById(2131303626)).setText(paramString);
      }
    }
    for (;;)
    {
      this.wea.setImageBitmap(this.gTB);
      AppMethodBeat.o(73972);
      return;
      if (this.weP)
      {
        paramString = parama.dnI();
        parama = (TextView)findViewById(2131305888);
        View localView = (View)parama.getParent();
        if (!bt.isNullOrNil(paramString))
        {
          parama.setText(paramString);
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(186519);
              SelfQRCodeUI.h(SelfQRCodeUI.this);
              AppMethodBeat.o(186519);
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
  
  public static void dnF()
  {
    AppMethodBeat.i(73973);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 14L, 1L, true);
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
    if (bt.isNullOrNil(this.userName)) {
      this.userName = u.aqG();
    }
    if (u.aqG().equals(this.userName)) {
      this.weP = true;
    }
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.model.w.sl(this.userName))
    {
      setMMTitle(2131763386);
      ((TextView)findViewById(2131303626)).setText("");
      enableOptionMenu(false);
      this.weQ = ((LinearLayout)findViewById(2131303612));
      this.wea = ((ImageView)findViewById(2131304554));
      this.kXS = ((ImageView)findViewById(2131300718));
      this.mZh = ((TextView)findViewById(2131302858));
      this.qLh = ((TextView)findViewById(2131299151));
      this.weQ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(73954);
          SelfQRCodeUI.b(SelfQRCodeUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
          int i = ao.fromDPToPix(SelfQRCodeUI.this.getContext(), 500);
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
      if ((!com.tencent.mm.model.w.sl(this.userName)) && (!com.tencent.mm.am.f.wL(this.userName))) {
        break label473;
      }
      Ly(1);
      a.b.c(this.kXS, this.userName);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.userName);
      this.mZh.setSingleLine(false);
      this.mZh.setMaxLines(3);
      if (!com.tencent.mm.model.w.so(this.userName)) {
        break label447;
      }
      localObject2 = getResources().getDrawable(2131691000);
      this.mZh.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label288:
      if (localObject1 == null) {
        break label461;
      }
      localObject2 = ((au)localObject1).field_nickname;
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tI(this.userName).field_displayname;
      }
      this.mZh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, this.mZh.getTextSize()));
      label352:
      this.qLh.setVisibility(8);
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
      if (com.tencent.mm.am.f.wL(this.userName))
      {
        setMMTitle(2131758446);
        ((TextView)findViewById(2131303626)).setText(2131758447);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(2131763374);
      break;
      label447:
      this.mZh.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label288;
      label461:
      this.mZh.setVisibility(8);
      break label352;
      label473:
      localObject2 = (String)com.tencent.mm.kernel.g.afB().afk().get(42, null);
      localObject1 = getString(2131755760);
      if (!bt.isNullOrNil((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label523:
        ad.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.gTB != null) {
          break label817;
        }
        ad.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        Ly(1);
      }
      for (;;)
      {
        a.b.c(this.kXS, u.aqG());
        localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(4, null);
        ad.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.mZh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, com.tencent.mm.cd.a.ao(getContext(), 2131165466)));
        localObject2 = bs.asB();
        localObject1 = bt.nullAsNil(((bs)localObject2).getProvince());
        localObject2 = bt.nullAsNil(((bs)localObject2).getCity());
        localObject1 = v.sj((String)localObject1) + " " + (String)localObject2;
        ad.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.qLh.setText((CharSequence)localObject1);
        switch (bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.mZh.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cd.a.l(this, 2131690323), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.g.afB().afk().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          af.aHK((String)localObject2);
          break label523;
          label817:
          this.wea.setImageBitmap(this.gTB);
        }
      }
      this.mZh.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cd.a.l(this, 2131690322), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73966);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.weR = new b(this);
    this.weR.start();
    com.tencent.mm.kernel.g.aeS().a(168, this);
    com.tencent.mm.kernel.g.aeS().a(890, this);
    initView();
    this.wea.post(new Runnable()
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
    com.tencent.mm.kernel.g.aeS().b(168, this);
    com.tencent.mm.kernel.g.aeS().b(890, this);
    if (this.weR != null) {
      this.weR.stop();
    }
    if ((this.gTB != null) && (!this.gTB.isRecycled()))
    {
      ad.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.gTB.toString() });
      this.gTB.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(73967);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73968);
    super.onResume();
    if ((com.tencent.mm.model.w.sl(this.userName)) || (com.tencent.mm.am.f.wL(this.userName)))
    {
      AppMethodBeat.o(73968);
      return;
    }
    View localView = findViewById(2131304557);
    this.nXu = u.aqL();
    ad.d("MicroMsg.SelfQRCodeNewUI", (this.nXu & 0x2) + ",extstatus:" + this.nXu);
    if ((this.nXu & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.wea.setAlpha(0.1F);
      findViewById(2131304556).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73957);
          d.O(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
          AppMethodBeat.o(73957);
        }
      });
      AppMethodBeat.o(73968);
      return;
    }
    localView.setVisibility(8);
    this.wea.setAlpha(1.0F);
    AppMethodBeat.o(73968);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73971);
    ad.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if ((paramn instanceof com.tencent.mm.bd.a))
    {
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] dnG()
        {
          return this.weT.hpQ;
        }
        
        public final String dnH()
        {
          return this.weT.hpO;
        }
        
        public final String dnI()
        {
          return this.weT.hpP;
        }
      });
      AppMethodBeat.o(73971);
      return;
    }
    if ((paramn instanceof com.tencent.mm.openim.b.g))
    {
      paramn = (axf)((com.tencent.mm.al.b)((com.tencent.mm.openim.b.g)paramn).getReqResp()).gUT.gUX;
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] dnG()
        {
          return this.weU;
        }
        
        public final String dnH()
        {
          return this.jFF;
        }
        
        public final String dnI()
        {
          return this.jFF;
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
    public abstract byte[] dnG();
    
    public abstract String dnH();
    
    public abstract String dnI();
  }
  
  public final class b
    extends FileObserver
  {
    private MMActivity weV;
    private String weW;
    
    public b(MMActivity paramMMActivity)
    {
      super(8);
      AppMethodBeat.i(73962);
      this.weV = paramMMActivity;
      AppMethodBeat.o(73962);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      AppMethodBeat.i(73963);
      if ((paramString != null) && (paramInt == 8) && ((this.weW == null) || (!paramString.equalsIgnoreCase(this.weW))))
      {
        this.weW = paramString;
        paramString = new com.tencent.mm.vfs.e(SelfQRCodeUI.bQU() + paramString);
        m.a(SelfQRCodeUI.this.getContext(), paramString);
        SelfQRCodeUI.dnF();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */