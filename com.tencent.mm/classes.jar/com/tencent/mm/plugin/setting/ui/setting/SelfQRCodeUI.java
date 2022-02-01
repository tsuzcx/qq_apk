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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

@i
public class SelfQRCodeUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private static final String PATH;
  private ProgressDialog fts = null;
  private Bitmap hua = null;
  private ImageView lzC = null;
  private TextView nBF = null;
  private long oAP;
  private TextView rFT = null;
  private String userName = "";
  private ImageView xpo = null;
  private byte[] xpp = null;
  private boolean xqd = false;
  private LinearLayout xqe;
  private b xqf;
  
  static
  {
    AppMethodBeat.i(73978);
    PATH = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(73978);
  }
  
  private void Ny(int paramInt)
  {
    AppMethodBeat.i(73970);
    if (this.xqd) {}
    for (int i = com.tencent.mm.sdk.platformtools.bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(66561, null));; i = 0)
    {
      Object localObject;
      if (w.wq(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755906);
        this.fts = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131763030), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(190987);
            com.tencent.mm.kernel.g.agi().a(this.cXh);
            if ((w.wo(SelfQRCodeUI.d(SelfQRCodeUI.this))) || (com.tencent.mm.al.f.AR(SelfQRCodeUI.d(SelfQRCodeUI.this)))) {
              SelfQRCodeUI.this.finish();
            }
            AppMethodBeat.o(190987);
          }
        });
        AppMethodBeat.o(73970);
        return;
        localObject = new com.tencent.mm.bc.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(73972);
    if (com.tencent.mm.plugin.setting.b.iyy.b(getContext(), paramInt1, paramInt2, paramString))
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
    this.xpp = parama.dBN();
    this.hua = com.tencent.mm.sdk.platformtools.f.ck(this.xpp);
    if ((w.wo(this.userName)) || (com.tencent.mm.al.f.AR(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.dBO();
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString)) {
        ((TextView)findViewById(2131303626)).setText(paramString);
      }
    }
    for (;;)
    {
      this.xpo.setImageBitmap(this.hua);
      AppMethodBeat.o(73972);
      return;
      if (this.xqd)
      {
        paramString = parama.dBP();
        parama = (TextView)findViewById(2131305888);
        View localView = (View)parama.getParent();
        if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil(paramString))
        {
          parama.setText(paramString);
          localView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(190984);
              SelfQRCodeUI.h(SelfQRCodeUI.this);
              AppMethodBeat.o(190984);
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
  
  public static void dBM()
  {
    AppMethodBeat.i(73973);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 14L, 1L, true);
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
    if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil(this.userName)) {
      this.userName = u.axw();
    }
    if (u.axw().equals(this.userName)) {
      this.xqd = true;
    }
    Object localObject1;
    Object localObject2;
    if (w.wo(this.userName))
    {
      setMMTitle(2131763386);
      ((TextView)findViewById(2131303626)).setText("");
      enableOptionMenu(false);
      this.xqe = ((LinearLayout)findViewById(2131303612));
      this.xpo = ((ImageView)findViewById(2131304554));
      this.lzC = ((ImageView)findViewById(2131300718));
      this.nBF = ((TextView)findViewById(2131302858));
      this.rFT = ((TextView)findViewById(2131299151));
      this.xqe.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
      if ((!w.wo(this.userName)) && (!com.tencent.mm.al.f.AR(this.userName))) {
        break label473;
      }
      Ny(1);
      a.b.c(this.lzC, this.userName);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.userName);
      this.nBF.setSingleLine(false);
      this.nBF.setMaxLines(3);
      if (!w.wr(this.userName)) {
        break label447;
      }
      localObject2 = getResources().getDrawable(2131691000);
      this.nBF.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label288:
      if (localObject1 == null) {
        break label461;
      }
      localObject2 = ((av)localObject1).field_nickname;
      localObject1 = localObject2;
      if (com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject2)) {
        localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xO(this.userName).field_displayname;
      }
      this.nBF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, this.nBF.getTextSize()));
      label352:
      this.rFT.setVisibility(8);
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
      if (com.tencent.mm.al.f.AR(this.userName))
      {
        setMMTitle(2131758446);
        ((TextView)findViewById(2131303626)).setText(2131758447);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(2131763374);
      break;
      label447:
      this.nBF.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label288;
      label461:
      this.nBF.setVisibility(8);
      break label352;
      label473:
      localObject2 = (String)com.tencent.mm.kernel.g.agR().agA().get(42, null);
      localObject1 = getString(2131755760);
      if (!com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label523:
        ac.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.hua != null) {
          break label817;
        }
        ac.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        Ny(1);
      }
      for (;;)
      {
        a.b.c(this.lzC, u.axw());
        localObject1 = (String)com.tencent.mm.kernel.g.agR().agA().get(4, null);
        ac.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.nBF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, com.tencent.mm.cc.a.au(getContext(), 2131165466)));
        localObject2 = com.tencent.mm.model.bs.azs();
        localObject1 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(((com.tencent.mm.model.bs)localObject2).getProvince());
        localObject2 = com.tencent.mm.sdk.platformtools.bs.nullAsNil(((com.tencent.mm.model.bs)localObject2).getCity());
        localObject1 = v.wm((String)localObject1) + " " + (String)localObject2;
        ac.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.rFT.setText((CharSequence)localObject1);
        switch (com.tencent.mm.sdk.platformtools.bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.nBF.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this, 2131690323), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.g.agR().agA().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          ai.aNf((String)localObject2);
          break label523;
          label817:
          this.xpo.setImageBitmap(this.hua);
        }
      }
      this.nBF.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this, 2131690322), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73966);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.xqf = new b(this);
    this.xqf.start();
    com.tencent.mm.kernel.g.agi().a(168, this);
    com.tencent.mm.kernel.g.agi().a(890, this);
    initView();
    this.xpo.post(new Runnable()
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
    com.tencent.mm.kernel.g.agi().b(168, this);
    com.tencent.mm.kernel.g.agi().b(890, this);
    if (this.xqf != null) {
      this.xqf.stop();
    }
    if ((this.hua != null) && (!this.hua.isRecycled()))
    {
      ac.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.hua.toString() });
      this.hua.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(73967);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73968);
    super.onResume();
    if ((w.wo(this.userName)) || (com.tencent.mm.al.f.AR(this.userName)))
    {
      AppMethodBeat.o(73968);
      return;
    }
    View localView = findViewById(2131304557);
    this.oAP = u.axB();
    ac.d("MicroMsg.SelfQRCodeNewUI", (this.oAP & 0x2) + ",extstatus:" + this.oAP);
    if ((this.oAP & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.xpo.setAlpha(0.1F);
      findViewById(2131304556).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(73957);
          d.N(SelfQRCodeUI.this, "setting", ".ui.setting.SettingsAddMeUI");
          AppMethodBeat.o(73957);
        }
      });
      AppMethodBeat.o(73968);
      return;
    }
    localView.setVisibility(8);
    this.xpo.setAlpha(1.0F);
    AppMethodBeat.o(73968);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73971);
    ac.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramn instanceof com.tencent.mm.bc.a))
    {
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] dBN()
        {
          return this.xqh.hQs;
        }
        
        public final String dBO()
        {
          return this.xqh.hQq;
        }
        
        public final String dBP()
        {
          return this.xqh.hQr;
        }
      });
      AppMethodBeat.o(73971);
      return;
    }
    if ((paramn instanceof com.tencent.mm.openim.b.g))
    {
      paramn = (bax)((com.tencent.mm.ak.b)((com.tencent.mm.openim.b.g)paramn).getReqResp()).hvs.hvw;
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] dBN()
        {
          return this.xqi;
        }
        
        public final String dBO()
        {
          return this.kgc;
        }
        
        public final String dBP()
        {
          return this.kgc;
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
    public abstract byte[] dBN();
    
    public abstract String dBO();
    
    public abstract String dBP();
  }
  
  public final class b
    extends FileObserver
  {
    private MMActivity xqj;
    private String xqk;
    
    public b(MMActivity paramMMActivity)
    {
      super(8);
      AppMethodBeat.i(73962);
      this.xqj = paramMMActivity;
      AppMethodBeat.o(73962);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      AppMethodBeat.i(73963);
      if ((paramString != null) && (paramInt == 8) && ((this.xqk == null) || (!paramString.equalsIgnoreCase(this.xqk))))
      {
        this.xqk = paramString;
        paramString = new com.tencent.mm.vfs.e(SelfQRCodeUI.bYj() + paramString);
        m.a(SelfQRCodeUI.this.getContext(), paramString);
        SelfQRCodeUI.dBM();
        ac.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
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