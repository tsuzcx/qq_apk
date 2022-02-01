package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.m;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.a;
import com.tencent.mm.plugin.topstory.ui.widget.c.a;
import com.tencent.mm.plugin.topstory.ui.widget.d.a;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TopStoryFSVideoUI
  extends MMActivity
  implements com.tencent.mm.plugin.topstory.a.c, com.tencent.mm.plugin.topstory.ui.video.b
{
  private static long Afv = 0L;
  protected View AcI;
  protected ImageView AcJ;
  protected View AcK;
  protected RecyclerView AcN;
  private com.tencent.mm.plugin.topstory.ui.a.a AcU;
  protected int AcW;
  protected long AcX;
  protected long AcY;
  private com.tencent.mm.plugin.topstory.ui.video.l Ada;
  private o Adb;
  private m Adc;
  r Add;
  com.tencent.mm.plugin.topstory.ui.video.n Ade;
  private boolean Adf;
  protected com.tencent.mm.plugin.topstory.ui.widget.d Adg;
  private boolean Adh;
  protected com.tencent.mm.plugin.topstory.ui.widget.b Adi;
  private android.support.v7.widget.aj Adj;
  private com.tencent.mm.ak.g Adn;
  protected i Afj;
  protected h Afk;
  private ProgressDialog Afl;
  private View Afm;
  private View Afn;
  private View Afo;
  private Button Afp;
  View Afq;
  com.tencent.mm.plugin.topstory.ui.widget.c Afr;
  View Afs;
  TopStoryCommentFloatDialog Aft;
  private boolean Afu;
  protected RecyclerView.m fuK;
  private Point gYt;
  protected LinearLayoutManager nlq;
  protected ImageButton vhZ;
  private int videoHeight;
  protected View xuw;
  protected dil zZP;
  
  public TopStoryFSVideoUI()
  {
    AppMethodBeat.i(126353);
    this.fuK = new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(126332);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        if (paramAnonymousInt2 == 0)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(126332);
          return;
        }
        TopStoryFSVideoUI.this.edU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(126332);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(126331);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI$11", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(126331);
          return;
          TopStoryFSVideoUI.this.Afk.b(TopStoryFSVideoUI.this);
        }
      }
    };
    this.AcW = 0;
    this.AcX = -1L;
    this.AcY = -1L;
    this.Adn = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(126341);
        final j localj = (j)paramAnonymousn;
        paramAnonymousn = (die)localj.rr.hvr.hvw;
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.w("MicroMsg.TopStory.TopStoryFSVideoUI", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          t.makeText(TopStoryFSVideoUI.this.getContext(), TopStoryFSVideoUI.this.getString(2131764476), 0).show();
          if (localj.zZN != null)
          {
            paramAnonymousString = localj.zZN;
            if (localj.zZN.FSc) {
              break label173;
            }
          }
          label173:
          for (bool = true;; bool = false)
          {
            paramAnonymousString.FSc = bool;
            ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd error, thumb:" + localj.zZN.FSc);
            TopStoryFSVideoUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(126340);
                com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.edp().b(localj.zZN);
                if ((localh != null) && ((localh instanceof g))) {
                  ((f)localh.edP().getControlBar()).l(localj.zZN);
                }
                AppMethodBeat.o(126340);
              }
            });
            AppMethodBeat.o(126341);
            return;
          }
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("docId", paramAnonymousn.FrN);
          localJSONObject.put("opType", "LIKE");
          if (paramAnonymousn.fZz != 4) {
            break label492;
          }
          bool = true;
          label223:
          localJSONObject.put("isLike", bool);
        }
        catch (JSONException paramAnonymousString)
        {
          label233:
          break label233;
        }
        if (localj.zZN != null)
        {
          paramAnonymousString = localj.zZN;
          if (paramAnonymousn.fZz != 4) {
            break label498;
          }
        }
        label492:
        label498:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousString.FSc = bool;
          ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "setCmtListener onSceneEnd succ, thumb: %s count: %s", new Object[] { Boolean.valueOf(localj.zZN.FSc), Integer.valueOf(localj.zZN.FSh) });
          if (paramAnonymousn.fZz != 4) {
            break label504;
          }
          com.tencent.mm.plugin.topstory.ui.video.h localh = TopStoryFSVideoUI.this.edp().b(localj.zZN);
          paramAnonymousn = null;
          paramAnonymousString = paramAnonymousn;
          if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).zZQ != null)
          {
            paramAnonymousString = paramAnonymousn;
            if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).zZQ.sVF != null)
            {
              paramAnonymousString = paramAnonymousn;
              if (TopStoryFSVideoUI.m(TopStoryFSVideoUI.this).zZQ.sVF.equals(localj.zZN.sVF))
              {
                paramAnonymousString = paramAnonymousn;
                if ((localh instanceof g)) {
                  paramAnonymousString = localh.getWowView();
                }
              }
            }
          }
          if (paramAnonymousString != null)
          {
            TopStoryFSVideoUI.this.a(localj.zZN, paramAnonymousString, true);
            if ((localh instanceof g)) {
              localh.edP().getControlBar().show();
            }
          }
          paramAnonymousString = new jp();
          paramAnonymousString.dle.dlf = localJSONObject.toString();
          paramAnonymousString.dle.dlg = "";
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          break;
          bool = false;
          break label223;
        }
        label504:
        if (localj.ecI().FRf) {
          com.tencent.mm.ui.base.h.c(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.getString(2131764505), "", true);
        }
        for (;;)
        {
          TopStoryFSVideoUI.this.a(localj.zZN, null, false);
          break;
          t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764506, 0).show();
        }
      }
    };
    AppMethodBeat.o(126353);
  }
  
  private void edQ()
  {
    AppMethodBeat.i(126356);
    getWindow().setFlags(201327616, 201327616);
    View localView = getWindow().getDecorView();
    if (com.tencent.mm.compatible.util.d.la(19)) {
      localView.setSystemUiVisibility(2);
    }
    for (;;)
    {
      getWindow().addFlags(128);
      AppMethodBeat.o(126356);
      return;
      localView.setSystemUiVisibility(4102);
    }
  }
  
  private boolean edW()
  {
    return (this.zZP.scene != 36) && (!this.zZP.FRI);
  }
  
  @SuppressLint({"ResourceType"})
  private void edZ()
  {
    AppMethodBeat.i(126371);
    if (this.zZP.ftN) {
      this.AcJ.setBackgroundResource(2131691327);
    }
    for (;;)
    {
      if (this.Add.Aei) {
        this.Add.setMute(this.zZP.ftN);
      }
      AppMethodBeat.o(126371);
      return;
      this.AcJ.setBackgroundResource(2131691328);
    }
  }
  
  private void eev()
  {
    AppMethodBeat.i(126363);
    this.Afn.setVisibility(0);
    this.Afm.setVisibility(0);
    this.Ade.Rx(0);
    AppMethodBeat.o(126363);
  }
  
  private int getSystemVolume()
  {
    AppMethodBeat.i(126368);
    int i = ((AudioManager)getContext().getSystemService("audio")).getStreamVolume(3);
    AppMethodBeat.o(126368);
    return i;
  }
  
  public final boolean Nw()
  {
    return this.zZP.ftN;
  }
  
  public final boolean Rn(int paramInt)
  {
    AppMethodBeat.i(126359);
    this.Afq.setVisibility(8);
    ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo %d", new Object[] { Integer.valueOf(paramInt) });
    try
    {
      int i = this.Afj.getItemCount();
      int j = this.Afj.getFootersCount();
      int k = this.Afj.getHeadersCount();
      if (paramInt >= i - j - k)
      {
        AppMethodBeat.o(126359);
        return false;
      }
      RecyclerView localRecyclerView = this.AcN;
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.Afj.getHeadersCount() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, locala.aeD(), "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      localRecyclerView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localRecyclerView, "com/tencent/mm/plugin/topstory/ui/video/fs/TopStoryFSVideoUI", "tryToPlayPositionVideo", "(I)Z", "Undefined", "smoothScrollToPosition", "(I)V");
      AppMethodBeat.o(126359);
      return true;
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.TopStory.TopStoryFSVideoUI", "tryToPlayPositionVideo Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(126359);
    }
    return false;
  }
  
  public final void Ro(int paramInt)
  {
    this.zZP.FRE = paramInt;
  }
  
  public final void Rp(int paramInt)
  {
    this.zZP.FRH = paramInt;
  }
  
  public final void a(cyv paramcyv) {}
  
  public final void a(dio paramdio)
  {
    AppMethodBeat.i(126360);
    if (this.AcU != null) {
      this.AcU.a(this.zZP, paramdio);
    }
    AppMethodBeat.o(126360);
  }
  
  public final void a(dio paramdio, int paramInt1, int paramInt2) {}
  
  public final void a(dio paramdio, View paramView)
  {
    AppMethodBeat.i(126381);
    int i;
    int j;
    label105:
    boolean bool;
    if (paramdio != null)
    {
      if (!ax.isConnected(this))
      {
        Toast.makeText(getContext(), getString(2131764476), 0).show();
        AppMethodBeat.o(126381);
        return;
      }
      Object localObject = paramdio.sxK;
      if (!paramdio.FSc) {
        break label230;
      }
      i = 5;
      String str1 = System.currentTimeMillis();
      int k = this.zZP.scene;
      String str2 = this.zZP.jKB;
      if (!edq()) {
        break label235;
      }
      j = 318;
      localObject = new j(paramdio, (String)localObject, i, str1, k, str2, j, paramdio.sVF, paramdio.FSd);
      com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
      if (paramdio.FSc) {
        break label243;
      }
      bool = true;
      label154:
      paramdio.FSc = bool;
      if (!paramdio.FSc) {
        break label249;
      }
    }
    label230:
    label235:
    label243:
    label249:
    for (paramdio.FSh += 1;; paramdio.FSh -= 1)
    {
      ((TextView)paramView.findViewById(2131307017)).setText(com.tencent.mm.plugin.topstory.ui.d.Rk(paramdio.FSh));
      ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onWowBtnClick thumb:" + paramdio.FSc);
      AppMethodBeat.o(126381);
      return;
      i = 4;
      break;
      j = 317;
      break label105;
      bool = false;
      break label154;
    }
  }
  
  public final void a(final dio paramdio, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(126384);
    ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onLikeSceneEnd vid:%s, thumb:%s", new Object[] { paramdio.sVF, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if ((this.Afq.getVisibility() == 0) && (this.Afr != null) && (this.Afr.hhd != null) && (this.Afr.hhd.equals(paramdio.sVF))) {
        this.Afq.setVisibility(8);
      }
      AppMethodBeat.o(126384);
      return;
    }
    Object localObject = System.currentTimeMillis();
    String str1 = paramdio.sxK;
    String str2 = paramdio.title;
    String str3 = this.zZP.jKB;
    int j = this.zZP.scene;
    if (edq()) {}
    for (int i = 318;; i = 317)
    {
      localObject = new com.tencent.mm.plugin.topstory.a.c.f((String)localObject, str1, "", "", "", "", str2, str3, j, i, paramdio.sVF, paramdio.FSd);
      this.Afq.setVisibility(0);
      this.Afr = new com.tencent.mm.plugin.topstory.ui.widget.c(this.Afs, new c.a()
      {
        public final void a(com.tencent.mm.plugin.topstory.a.c.f paramAnonymousf)
        {
          AppMethodBeat.i(126345);
          TopStoryFSVideoUI.this.Aft.a(paramAnonymousf, new TopStoryCommentFloatDialog.a()
          {
            public final void eex()
            {
              AppMethodBeat.i(126344);
              TopStoryFSVideoUI.this.Afq.setVisibility(8);
              AppMethodBeat.o(126344);
            }
            
            public final void onDismiss()
            {
              AppMethodBeat.i(126343);
              TopStoryFSVideoUI.this.Add.dOc();
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126343);
            }
          }, (int)TopStoryFSVideoUI.this.zZP.FRz, paramdio.FRR);
          if (TopStoryFSVideoUI.this.Add.een()) {
            TopStoryFSVideoUI.this.Add.crK();
          }
          AppMethodBeat.o(126345);
        }
      }, (com.tencent.mm.plugin.topstory.a.c.f)localObject, paramdio.sVF);
      this.Afq.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126346);
          if (TopStoryFSVideoUI.this.Afq.getVisibility() == 0) {
            TopStoryFSVideoUI.this.Afq.setVisibility(8);
          }
          AppMethodBeat.o(126346);
        }
      }, 2000L);
      this.Afr.a(paramView, true, 0);
      AppMethodBeat.o(126384);
      return;
    }
  }
  
  public final void a(dio paramdio, com.tencent.mm.plugin.topstory.ui.video.f paramf, int paramInt) {}
  
  public final void as(final View paramView, final int paramInt)
  {
    AppMethodBeat.i(126372);
    if (this.Add.een())
    {
      this.Add.crK();
      this.Adf = true;
    }
    dio localdio = this.Ade.Rw(paramInt);
    this.Adg = new com.tencent.mm.plugin.topstory.ui.widget.d(getContext(), localdio, new d.a()
    {
      public final void e(dio paramAnonymousdio)
      {
        AppMethodBeat.i(126333);
        if (paramAnonymousdio.FSe != null) {
          TopStoryFSVideoUI.this.at(paramView, paramInt);
        }
        TopStoryFSVideoUI.this.Adg.dismiss();
        AppMethodBeat.o(126333);
      }
      
      public final void f(dio paramAnonymousdio)
      {
        AppMethodBeat.i(126334);
        p localp = p.Aee;
        p.a(TopStoryFSVideoUI.this, TopStoryFSVideoUI.this.edh(), paramAnonymousdio);
        TopStoryFSVideoUI.this.Adg.dismiss();
        AppMethodBeat.o(126334);
      }
      
      public final void g(dio paramAnonymousdio)
      {
        AppMethodBeat.i(164128);
        if (com.tencent.mm.util.c.fwW())
        {
          String str1 = com.tencent.mm.plugin.topstory.ui.d.bp(paramAnonymousdio.sVF, paramAnonymousdio.FRO);
          str1 = TopStoryFSVideoUI.this.edg() + str1 + ".mp4";
          String str2 = "/sdcard/video/" + paramAnonymousdio.title + ".mp4";
          if (com.tencent.mm.vfs.i.eA("/sdcard/video/")) {
            com.tencent.mm.vfs.i.aSh("/sdcard/video/");
          }
          com.tencent.mm.vfs.i.lZ(str1, str2);
          Toast.makeText(TopStoryFSVideoUI.this, "copy success " + paramAnonymousdio.title, 0).show();
        }
        AppMethodBeat.o(164128);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126335);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "more popupWindow dismiss");
        if (TopStoryFSVideoUI.e(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.f(TopStoryFSVideoUI.this);
          if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
          {
            AppMethodBeat.o(126335);
            return;
          }
          TopStoryFSVideoUI.this.Add.dOc();
          try
          {
            ((f)TopStoryFSVideoUI.this.Add.Aeh.getControlBar()).bjC();
            AppMethodBeat.o(126335);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126335);
      }
    });
    this.Adg.a(paramView, true, 0, 0);
    try
    {
      ((f)this.Add.Aeh.getControlBar()).bOg();
      AppMethodBeat.o(126372);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126372);
    }
  }
  
  public final void at(View paramView, final int paramInt)
  {
    AppMethodBeat.i(126373);
    this.Adh = true;
    final dio localdio = this.Ade.Rw(paramInt);
    this.Adi = new com.tencent.mm.plugin.topstory.ui.widget.b(getContext(), localdio, new com.tencent.mm.plugin.topstory.ui.widget.b.a()
    {
      public final void i(Set<aij> paramAnonymousSet)
      {
        AppMethodBeat.i(126336);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow commit");
        t.makeText(TopStoryFSVideoUI.this.getContext(), 2131764471, 0).show();
        com.tencent.mm.plugin.topstory.a.i.a(TopStoryFSVideoUI.this.edh(), localdio, paramAnonymousSet, TopStoryFSVideoUI.this.Ade.eee());
        TopStoryFSVideoUI.this.Add.stopPlay();
        TopStoryFSVideoUI.this.Ade.Rv(paramInt);
        if (TopStoryFSVideoUI.this.Ade.eee() == 0)
        {
          TopStoryFSVideoUI.this.finish();
          AppMethodBeat.o(126336);
          return;
        }
        TopStoryFSVideoUI.this.Afj.cl(paramInt + TopStoryFSVideoUI.this.Afj.getHeadersCount());
        TopStoryFSVideoUI.this.AcN.a(0, 3, null);
        AppMethodBeat.o(126336);
      }
      
      public final void onDismiss()
      {
        AppMethodBeat.i(126337);
        ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "popupWindow dismiss");
        if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this))
        {
          TopStoryFSVideoUI.this.Add.dOc();
          TopStoryFSVideoUI.h(TopStoryFSVideoUI.this);
          try
          {
            ((f)TopStoryFSVideoUI.this.Add.Aeh.getControlBar()).bjC();
            AppMethodBeat.o(126337);
            return;
          }
          catch (Exception localException) {}
        }
        AppMethodBeat.o(126337);
      }
    });
    this.Adi.a(paramView, true, 0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 16));
    try
    {
      ((f)this.Add.Aeh.getControlBar()).bOg();
      AppMethodBeat.o(126373);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(126373);
    }
  }
  
  public final void axQ(final String paramString)
  {
    AppMethodBeat.i(126375);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126339);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        if (TopStoryFSVideoUI.k(TopStoryFSVideoUI.this) != null)
        {
          TopStoryFSVideoUI.k(TopStoryFSVideoUI.this).dismiss();
          TopStoryFSVideoUI.l(TopStoryFSVideoUI.this);
        }
        TopStoryFSVideoUI.a(TopStoryFSVideoUI.this, paramString);
        AppMethodBeat.o(126339);
      }
    });
    AppMethodBeat.o(126375);
  }
  
  public final void axR(String paramString)
  {
    this.zZP.FRG = paramString;
  }
  
  public final void cWw() {}
  
  public final MMActivity cYC()
  {
    return this;
  }
  
  protected final void edU()
  {
    int i = 1;
    AppMethodBeat.i(126355);
    this.Afk.a(this);
    this.AcW = this.nlq.jY();
    int j = this.nlq.getItemCount();
    if ((this.AcX <= 0L) || (bs.aO(this.AcX) >= 50L))
    {
      this.AcX = bs.Gn();
      if (this.Ade.AdP == 1) {
        break label161;
      }
      if ((this.AcW < j - 1) || (this.Ade.rRR) || (bs.aO(this.AcY) < 50L)) {
        break label195;
      }
    }
    for (;;)
    {
      if (!edW()) {
        i = 0;
      }
      if (i != 0)
      {
        this.Afn.setVisibility(0);
        this.Afm.setVisibility(0);
        this.Ade.Rx(this.Ade.eee());
      }
      AppMethodBeat.o(126355);
      return;
      label161:
      if ((j - this.AcW > 3) || (this.Ade.rRR) || (bs.aO(this.AcY) < 50L)) {
        label195:
        i = 0;
      }
    }
  }
  
  public final void edb()
  {
    AppMethodBeat.i(126357);
    this.xuw.animate().alpha(0.0F).setDuration(200L).setStartDelay(1800L);
    this.Afq.setVisibility(8);
    AppMethodBeat.o(126357);
  }
  
  public final void edc()
  {
    AppMethodBeat.i(126358);
    this.xuw.animate().cancel();
    this.xuw.setAlpha(1.0F);
    AppMethodBeat.o(126358);
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.l ede()
  {
    return this.Ada;
  }
  
  public final o edf()
  {
    return this.Adb;
  }
  
  public final String edg()
  {
    AppMethodBeat.i(126364);
    String str = com.tencent.mm.plugin.topstory.a.h.axH(this.zZP.qox);
    AppMethodBeat.o(126364);
    return str;
  }
  
  public final dil edh()
  {
    return this.zZP;
  }
  
  public final m edi()
  {
    return this.Adc;
  }
  
  public final r edj()
  {
    return this.Add;
  }
  
  public final Point edk()
  {
    AppMethodBeat.i(126367);
    if (this.gYt == null) {
      this.gYt = com.tencent.mm.ui.aj.cl(this);
    }
    Point localPoint = this.gYt;
    AppMethodBeat.o(126367);
    return localPoint;
  }
  
  public final android.support.v7.widget.aj edl()
  {
    return this.Adj;
  }
  
  public final int edm()
  {
    return this.zZP.FRE;
  }
  
  public final boolean edn()
  {
    return this.zZP.scene != 36;
  }
  
  public final boolean edo()
  {
    return this.zZP.scene != 326;
  }
  
  public final e edp()
  {
    return this.Afj;
  }
  
  public final boolean edq()
  {
    return this.zZP.FRz == 100203L;
  }
  
  public final void edr()
  {
    AppMethodBeat.i(126380);
    edQ();
    AppMethodBeat.o(126380);
  }
  
  public final int eds()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.n edt()
  {
    return this.Ade;
  }
  
  public final String edu()
  {
    if (this.zZP.FRG == null) {
      return "";
    }
    return this.zZP.FRG;
  }
  
  public final int edv()
  {
    return this.zZP.FRH;
  }
  
  public final void edw()
  {
    AppMethodBeat.i(126382);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126342);
        i locali = TopStoryFSVideoUI.this.Afj;
        int i = locali.getFootersCount();
        int j = locali.getItemCount();
        locali.edz();
        locali.ar(j - i, i);
        AppMethodBeat.o(126342);
      }
    });
    AppMethodBeat.o(126382);
  }
  
  public final int edx()
  {
    AppMethodBeat.i(126383);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pRC, 0);
    AppMethodBeat.o(126383);
    return i;
  }
  
  public final void eew()
  {
    AppMethodBeat.i(126370);
    if (this.zZP.ftN)
    {
      this.zZP.ftN = false;
      if (getSystemVolume() == 0) {
        com.tencent.mm.compatible.b.a.b((AudioManager)getContext().getSystemService("audio"), 3, 1);
      }
    }
    for (;;)
    {
      edZ();
      edc();
      edb();
      AppMethodBeat.o(126370);
      return;
      this.zZP.ftN = true;
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(126361);
    if (edq())
    {
      AppMethodBeat.o(126361);
      return 1;
    }
    AppMethodBeat.o(126361);
    return 0;
  }
  
  public int getLayoutId()
  {
    return 2131495782;
  }
  
  public final RecyclerView.i getLayoutManager()
  {
    return this.nlq;
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.AcN;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(126365);
    if (this.videoHeight == 0)
    {
      if (edq()) {
        break label49;
      }
      this.videoHeight = (getVideoWidth() * 280 / 496);
    }
    for (;;)
    {
      int i = this.videoHeight;
      AppMethodBeat.o(126365);
      return i;
      label49:
      this.videoHeight = 1280;
      i = edk().y * 3 / 5;
      if (this.videoHeight > i) {
        this.videoHeight = i;
      }
      ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "getVideoHeight %d maxVideoHeight %d", new Object[] { Integer.valueOf(this.videoHeight), Integer.valueOf(i) });
    }
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(126366);
    int i = Math.min(edk().x, edk().y);
    AppMethodBeat.o(126366);
    return i;
  }
  
  public final void hT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126379);
    if (((paramInt2 == 2) || (paramInt2 == 1)) && (this.Afu)) {
      eev();
    }
    this.Add.hW(paramInt1, paramInt2);
    AppMethodBeat.o(126379);
  }
  
  public final boolean isFullscreenMode()
  {
    return false;
  }
  
  public final void m(List<dio> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(126374);
    this.Afj.n(paramList, paramBoolean);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126338);
        TopStoryFSVideoUI.i(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.j(TopStoryFSVideoUI.this).setVisibility(4);
        TopStoryFSVideoUI.this.AcN.a(0, 3, null);
        if (TopStoryFSVideoUI.k(TopStoryFSVideoUI.this) != null)
        {
          TopStoryFSVideoUI.k(TopStoryFSVideoUI.this).dismiss();
          TopStoryFSVideoUI.l(TopStoryFSVideoUI.this);
        }
        AppMethodBeat.o(126338);
      }
    }, 50L);
    AppMethodBeat.o(126374);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(126362);
    p.Aee.a(this, paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && ((this.Ada.ccN()) || (com.tencent.mm.plugin.topstory.a.h.ecw())))
    {
      paramIntent = com.tencent.mm.plugin.topstory.ui.video.list.d.c(this);
      if (paramIntent != null) {
        paramIntent.sd(false);
      }
    }
    AppMethodBeat.o(126362);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126354);
    if (Build.VERSION.SDK_INT >= 28) {
      customfixStatusbar(true);
    }
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra("key_context");
    this.zZP = new dil();
    try
    {
      this.zZP.parseFrom(paramBundle);
      this.Ade = new com.tencent.mm.plugin.topstory.ui.video.n();
      this.Ade.Acd = this;
      this.Adc = new m();
      this.Adc.d(this);
      this.Adb = new o();
      this.Adb.d(this);
      this.Add = new r();
      this.Add.d(this);
      this.Ada = new com.tencent.mm.plugin.topstory.ui.video.l();
      this.Afk = new h();
      if (this.zZP.FRA != null) {
        this.Ade.h(this.zZP.FRA);
      }
      this.AcU = new com.tencent.mm.plugin.topstory.ui.a.a(new com.tencent.mm.plugin.topstory.ui.a.b(this));
      this.AcU.aa(8, this.zZP.qox);
      this.AcU.SO(getResources().getString(2131764472));
      if (getSupportActionBar() != null)
      {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
        getSupportActionBar().hide();
      }
      if (this.zZP.FRC) {
        this.Ada.AdF = true;
      }
      edQ();
      this.xuw = findViewById(2131305918);
      this.AcI = findViewById(2131302622);
      this.AcK = findViewById(2131302462);
      this.AcJ = ((ImageView)findViewById(2131302624));
      this.vhZ = ((ImageButton)findViewById(2131297026));
      this.vhZ.getDrawable().setColorFilter(getResources().getColor(2131099828), PorterDuff.Mode.SRC_ATOP);
      this.vhZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126329);
          TopStoryFSVideoUI.a(TopStoryFSVideoUI.this);
          AppMethodBeat.o(126329);
        }
      });
      this.AcI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(126347);
          TopStoryFSVideoUI.this.eew();
          AppMethodBeat.o(126347);
        }
      });
      this.AcI.setVisibility(8);
      this.Afo = findViewById(2131300313);
      this.Afp = ((Button)findViewById(2131304375));
      this.AcN = ((RecyclerView)findViewById(2131306389));
      this.AcN.a(this.fuK);
      this.nlq = new LinearLayoutManager();
      this.AcN.setLayoutManager(this.nlq);
      this.Adj = android.support.v7.widget.aj.e(this.nlq);
      this.Afj = new i(this);
      paramBundle = this.Afj;
      View localView = LayoutInflater.from(this).inflate(2131495794, null);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.Afn = localView.findViewById(2131300203);
      this.Afm = localView.findViewById(2131300207);
      paramBundle.fp(localView);
      this.AcN.setAdapter(this.Afj);
      new b().j(this.AcN);
      if (edW()) {
        if (this.Ada.isConnected())
        {
          eev();
          this.Afu = false;
          if ((this.zZP.scene != 21) && (this.zZP.FRB == null)) {
            this.Afl = com.tencent.mm.ui.base.h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(126348);
                TopStoryFSVideoUI.this.finish();
                AppMethodBeat.o(126348);
              }
            });
          }
          this.Afj.Afz = true;
          this.Afo.setVisibility(8);
          if ((this.Ada.eeb()) && (com.tencent.mm.plugin.topstory.a.h.ecw()) && (System.currentTimeMillis() - Afv > 86400000L))
          {
            Toast.makeText(this, 2131764483, 0).show();
            Afv = System.currentTimeMillis();
          }
          this.Afq = findViewById(2131299128);
          this.Afs = findViewById(2131299129);
          this.Afq.setVisibility(8);
          this.Afq.setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
            {
              AppMethodBeat.i(126349);
              if (TopStoryFSVideoUI.this.Afq.getVisibility() == 0)
              {
                float f1 = paramAnonymousMotionEvent.getX();
                float f2 = paramAnonymousMotionEvent.getY();
                if (TopStoryFSVideoUI.g(TopStoryFSVideoUI.this.Afs, f1, f2))
                {
                  ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "touch in mContentViewNotFull");
                  AppMethodBeat.o(126349);
                  return false;
                }
                TopStoryFSVideoUI.this.Afq.setVisibility(8);
              }
              AppMethodBeat.o(126349);
              return false;
            }
          });
          this.Aft = ((TopStoryCommentFloatDialog)findViewById(2131298520));
          this.Aft.setVisibility(8);
          this.Aft.m(this);
          getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
          {
            public final void onSystemUiVisibilityChange(int paramAnonymousInt)
            {
              AppMethodBeat.i(126350);
              TopStoryFSVideoUI.b(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126350);
            }
          });
          if (edq())
          {
            this.vhZ.setImageResource(2131691314);
            if (com.tencent.mm.ui.aj.aG(this))
            {
              int i = com.tencent.mm.ui.aj.aF(this);
              paramBundle = (RelativeLayout.LayoutParams)this.xuw.getLayoutParams();
              paramBundle.topMargin = (i + com.tencent.mm.cc.a.fromDPToPix(this, 12));
              this.xuw.setLayoutParams(paramBundle);
            }
          }
          this.AcK.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(126351);
              TopStoryFSVideoUI.c(TopStoryFSVideoUI.this);
              AppMethodBeat.o(126351);
            }
          });
          com.tencent.mm.kernel.g.agi().a(2802, this.Adn);
          AppMethodBeat.o(126354);
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        finish();
        continue;
        Toast.makeText(this, 2131762228, 1).show();
        this.Afu = true;
        continue;
        this.Afn.setVisibility(4);
        this.Afm.setVisibility(4);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126376);
    com.tencent.mm.plugin.topstory.a.i.a(this.zZP, getActivityBrowseTimeMs(), this.Ade.Rw(this.zZP.FRE));
    com.tencent.mm.kernel.g.agi().b(2802, this.Adn);
    this.Ade.onUIDestroy();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.zZP);
    this.Add.onUIDestroy();
    this.Ada.onUIDestroy();
    this.Adb.onUIDestroy();
    this.Adc.onUIDestroy();
    this.Aft.fxG.close();
    com.tencent.mm.plugin.websearch.api.a.a.lA(16);
    if (this.AcU != null) {
      this.AcU.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(126376);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(126369);
    if ((paramInt == 4) && (this.Aft.getVisibility() == 0))
    {
      this.Aft.hide();
      AppMethodBeat.o(126369);
      return true;
    }
    if ((paramInt == 25) && (paramKeyEvent.getAction() == 0))
    {
      ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_DOWN %d", new Object[] { Integer.valueOf(getSystemVolume()) });
      dil localdil = this.zZP;
      if (getSystemVolume() <= 1)
      {
        localdil.ftN = bool;
        edZ();
      }
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(126369);
      return bool;
      bool = false;
      break;
      if ((paramInt == 24) && (paramKeyEvent.getAction() == 0))
      {
        ac.i("MicroMsg.TopStory.TopStoryFSVideoUI", "onKeyDown KEYCODE_VOLUME_UP %d", new Object[] { Integer.valueOf(getSystemVolume()) });
        this.zZP.ftN = false;
        edZ();
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(126378);
    super.onPause();
    this.Add.onUIPause();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
    this.Aft.onPause();
    com.tencent.mm.plugin.websearch.api.a.a.lA(15);
    if (this.AcU != null) {
      this.AcU.bcY();
    }
    AppMethodBeat.o(126378);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126377);
    super.onResume();
    edQ();
    edZ();
    ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
    this.Add.onUIResume();
    this.Ada.xlf = com.tencent.mm.plugin.topstory.ui.video.l.dPZ();
    this.Aft.onResume();
    com.tencent.mm.plugin.websearch.api.a.a.lA(14);
    if (this.AcU != null) {
      this.AcU.bcX();
    }
    AppMethodBeat.o(126377);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.TopStoryFSVideoUI
 * JD-Core Version:    0.7.0.1
 */