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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.n.d;
import java.io.File;

@i
public class SelfQRCodeUI
  extends MMActivity
  implements f
{
  private static final String PATH;
  private ProgressDialog fOC = null;
  private Bitmap hPl = null;
  private ImageView mdt = null;
  private TextView ojK = null;
  private long pkQ;
  private TextView sMl = null;
  private String userName = "";
  private ImageView yTW = null;
  private byte[] yTX = null;
  private boolean yUL = false;
  private LinearLayout yUM;
  private b yUN;
  
  static
  {
    AppMethodBeat.i(73978);
    PATH = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
    AppMethodBeat.o(73978);
  }
  
  private void PK(int paramInt)
  {
    AppMethodBeat.i(73970);
    if (this.yUL) {}
    for (int i = bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(66561, null));; i = 0)
    {
      Object localObject;
      if (x.zV(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = getContext();
        getString(2131755906);
        this.fOC = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131763030), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(190312);
            com.tencent.mm.kernel.g.ajj().a(this.djA);
            if ((x.zT(SelfQRCodeUI.d(SelfQRCodeUI.this))) || (com.tencent.mm.al.g.Es(SelfQRCodeUI.d(SelfQRCodeUI.this)))) {
              SelfQRCodeUI.this.finish();
            }
            AppMethodBeat.o(190312);
          }
        });
        AppMethodBeat.o(73970);
        return;
        localObject = new com.tencent.mm.bc.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, a parama)
  {
    AppMethodBeat.i(73972);
    if (com.tencent.mm.plugin.setting.c.iUA.b(getContext(), paramInt1, paramInt2, paramString))
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
    this.yTX = parama.dQM();
    this.hPl = com.tencent.mm.sdk.platformtools.h.cu(this.yTX);
    if ((x.zT(this.userName)) || (com.tencent.mm.al.g.Es(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.dQN();
      if (!bu.isNullOrNil(paramString)) {
        ((TextView)findViewById(2131303626)).setText(paramString);
      }
    }
    for (;;)
    {
      this.yTW.setImageBitmap(this.hPl);
      AppMethodBeat.o(73972);
      return;
      if (this.yUL)
      {
        paramString = parama.dQO();
        parama = (TextView)findViewById(2131305888);
        View localView = (View)parama.getParent();
        if (!bu.isNullOrNil(paramString))
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
  
  public static void dQL()
  {
    AppMethodBeat.i(73973);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 14L, 1L, true);
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
    if (bu.isNullOrNil(this.userName)) {
      this.userName = v.aAC();
    }
    if (v.aAC().equals(this.userName)) {
      this.yUL = true;
    }
    Object localObject1;
    Object localObject2;
    if (x.zT(this.userName))
    {
      setMMTitle(2131763386);
      ((TextView)findViewById(2131303626)).setText("");
      enableOptionMenu(false);
      this.yUM = ((LinearLayout)findViewById(2131303612));
      this.yTW = ((ImageView)findViewById(2131304554));
      this.mdt = ((ImageView)findViewById(2131300718));
      this.ojK = ((TextView)findViewById(2131302858));
      this.sMl = ((TextView)findViewById(2131299151));
      this.yUM.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
      if ((!x.zT(this.userName)) && (!com.tencent.mm.al.g.Es(this.userName))) {
        break label471;
      }
      PK(1);
      a.b.c(this.mdt, this.userName);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.userName);
      this.ojK.setSingleLine(false);
      this.ojK.setMaxLines(3);
      if (!x.zW(this.userName)) {
        break label445;
      }
      localObject2 = getResources().getDrawable(2131691000);
      this.ojK.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label287:
      if (localObject1 == null) {
        break label459;
      }
      localObject2 = ((aw)localObject1).field_nickname;
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(this.userName).field_displayname;
      }
      this.ojK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, this.ojK.getTextSize()));
      label351:
      this.sMl.setVisibility(8);
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
      if (com.tencent.mm.al.g.Es(this.userName))
      {
        setMMTitle(2131758446);
        ((TextView)findViewById(2131303626)).setText(2131758447);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(2131763374);
      break;
      label445:
      this.ojK.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label287;
      label459:
      this.ojK.setVisibility(8);
      break label351;
      label471:
      localObject2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(42, null);
      localObject1 = getString(2131755760);
      if (!bu.isNullOrNil((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label521:
        ae.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.hPl != null) {
          break label813;
        }
        ae.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        PK(1);
      }
      for (;;)
      {
        a.b.c(this.mdt, v.aAC());
        localObject1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(4, null);
        ae.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.ojK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, com.tencent.mm.cb.a.ax(getContext(), 2131165466)));
        localObject2 = bv.aCL();
        localObject1 = bu.nullAsNil(((bv)localObject2).getProvince());
        localObject2 = bu.nullAsNil(((bv)localObject2).getCity());
        localObject1 = w.zR((String)localObject1) + " " + (String)localObject2;
        ae.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.sMl.setText((CharSequence)localObject1);
        switch (bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.ojK.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.l(this, 2131690323), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          an.aUy((String)localObject2);
          break label521;
          label813:
          this.yTW.setImageBitmap(this.hPl);
        }
      }
      this.ojK.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.l(this, 2131690322), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73966);
    super.onCreate(paramBundle);
    hideActionbarLine();
    this.yUN = new b(this);
    this.yUN.start();
    com.tencent.mm.kernel.g.ajj().a(168, this);
    com.tencent.mm.kernel.g.ajj().a(890, this);
    initView();
    this.yTW.post(new Runnable()
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
    com.tencent.mm.kernel.g.ajj().b(168, this);
    com.tencent.mm.kernel.g.ajj().b(890, this);
    if (this.yUN != null) {
      this.yUN.stop();
    }
    if ((this.hPl != null) && (!this.hPl.isRecycled()))
    {
      ae.i("MicroMsg.SelfQRCodeNewUI", "bitmap recycle %s", new Object[] { this.hPl.toString() });
      this.hPl.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(73967);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73968);
    super.onResume();
    if ((x.zT(this.userName)) || (com.tencent.mm.al.g.Es(this.userName)))
    {
      AppMethodBeat.o(73968);
      return;
    }
    View localView = findViewById(2131304557);
    this.pkQ = v.aAH();
    ae.d("MicroMsg.SelfQRCodeNewUI", (this.pkQ & 0x2) + ",extstatus:" + this.pkQ);
    if ((this.pkQ & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.yTW.setAlpha(0.1F);
      findViewById(2131304556).setOnClickListener(new SelfQRCodeUI.10(this));
      AppMethodBeat.o(73968);
      return;
    }
    localView.setVisibility(8);
    this.yTW.setAlpha(1.0F);
    AppMethodBeat.o(73968);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(73971);
    ae.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if ((paramn instanceof com.tencent.mm.bc.a))
    {
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] dQM()
        {
          return this.yUP.imz;
        }
        
        public final String dQN()
        {
          return this.yUP.imx;
        }
        
        public final String dQO()
        {
          return this.yUP.imy;
        }
      });
      AppMethodBeat.o(73971);
      return;
    }
    if ((paramn instanceof com.tencent.mm.openim.b.g))
    {
      paramn = (bfr)((com.tencent.mm.ak.b)((com.tencent.mm.openim.b.g)paramn).getReqResp()).hQE.hQJ;
      a(paramInt1, paramInt2, paramString, new a()
      {
        public final byte[] dQM()
        {
          return this.yUQ;
        }
        
        public final String dQN()
        {
          return this.kEf;
        }
        
        public final String dQO()
        {
          return this.kEf;
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
    public abstract byte[] dQM();
    
    public abstract String dQN();
    
    public abstract String dQO();
  }
  
  public final class b
    extends FileObserver
  {
    private MMActivity yUR;
    private String yUS;
    
    public b(MMActivity paramMMActivity)
    {
      super(8);
      AppMethodBeat.i(73962);
      this.yUR = paramMMActivity;
      AppMethodBeat.o(73962);
    }
    
    public final void onEvent(int paramInt, String paramString)
    {
      AppMethodBeat.i(73963);
      if ((paramString != null) && (paramInt == 8) && ((this.yUS == null) || (!paramString.equalsIgnoreCase(this.yUS))))
      {
        this.yUS = paramString;
        paramString = new com.tencent.mm.vfs.k(SelfQRCodeUI.cec() + paramString);
        o.a(SelfQRCodeUI.this.getContext(), paramString);
        SelfQRCodeUI.dQL();
        ae.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
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