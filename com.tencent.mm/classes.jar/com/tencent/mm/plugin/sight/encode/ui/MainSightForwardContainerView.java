package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightForwardContainerView
  extends RelativeLayout
  implements AdapterView.OnItemClickListener, a
{
  private boolean DpA;
  private MediaPlayer DpB;
  public MainSightSelectContactView Dpj;
  public SightCameraView Dpk;
  private b Dpl;
  public View Dpm;
  public View Dpn;
  public View Dpo;
  private Dialog Dpp;
  private boolean Dpq;
  public String Dpr;
  private boolean Dps;
  public String Dpt;
  public float Dpu;
  private com.tencent.mm.plugin.sight.encode.a.b Dpv;
  private boolean Dpw;
  public MMFragmentActivity Dpx;
  private boolean Dpy;
  private IListener Dpz;
  private int atU;
  private boolean gNC;
  private boolean mIsPause;
  public View zfy;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28713);
    this.Dpp = null;
    this.gNC = false;
    this.Dpq = true;
    this.Dpr = "";
    this.Dps = false;
    this.Dpt = "";
    this.atU = 1;
    this.Dpu = 1.0F;
    this.mIsPause = false;
    this.Dpv = new com.tencent.mm.plugin.sight.encode.a.b();
    this.Dpw = false;
    this.Dpy = false;
    this.Dpz = new IListener() {};
    this.DpA = false;
    AppMethodBeat.o(28713);
  }
  
  public final boolean Zx()
  {
    return !this.Dpq;
  }
  
  public final void eWb()
  {
    AppMethodBeat.i(28727);
    this.Dpk.setVisibility(0);
    uI(true);
    AppMethodBeat.o(28727);
  }
  
  public final void eWc()
  {
    AppMethodBeat.i(28728);
    this.Dpk.setVisibility(4);
    uI(false);
    AppMethodBeat.o(28728);
  }
  
  public final void eWd()
  {
    boolean bool1 = true;
    AppMethodBeat.i(28715);
    Log.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.Dpt, Boolean.valueOf(this.Dpq), Boolean.valueOf(this.gNC) });
    if (!this.Dpk.isPlaying()) {
      this.Dpq = true;
    }
    boolean bool2 = this.Dpq;
    this.Dpk.ce(this.Dpt, bool2);
    if (!this.Dpq)
    {
      uI(false);
      this.gNC = true;
      if (this.Dpq) {
        break label122;
      }
    }
    for (;;)
    {
      this.Dpq = bool1;
      AppMethodBeat.o(28715);
      return;
      uI(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void eWe()
  {
    AppMethodBeat.i(28725);
    this.Dpo.setVisibility(8);
    AppMethodBeat.o(28725);
  }
  
  public final void eWg()
  {
    AppMethodBeat.i(28720);
    if (this.Dpp == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!Util.isNullOrNil(this.Dpt)) && (!this.Dpj.eWp())) {
        break;
      }
      AppMethodBeat.o(28720);
      return;
    }
    Object localObject1 = this.Dpj.getSelectedContact();
    com.tencent.mm.plugin.report.service.h.CyF.a(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new MainSightForwardContainerView.6(this, (List)localObject1);
    com.tencent.mm.plugin.sight.encode.a.b localb;
    String str1;
    int i;
    String str2;
    String str3;
    if (((List)localObject1).size() == 1)
    {
      localb = this.Dpv;
      str1 = this.Dpt;
      i = this.atU;
      str2 = this.Dpr;
      str3 = (String)((List)localObject1).get(0);
      if (Util.isNullOrNil(str1))
      {
        Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.Dpj.getSelectedContact().size() > 1) || (this.Dpl == null)) {
          break label873;
        }
        localObject2 = (String)this.Dpj.getSelectedContact().get(0);
        this.Dpl.startChattingUI((String)localObject2);
      }
    }
    label873:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.Dpx != null) {
          localObject2 = this.Dpx.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.DpB = new k();
          this.DpB.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.DpB.setOnCompletionListener(new MainSightForwardContainerView.7(this));
          this.DpB.setLooping(false);
          this.DpB.prepare();
          this.DpB.start();
          rX(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.h.CyF.a(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (Util.isNullOrNil(str3))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!s.YS(str1)) || (s.boW(str1) <= 0L))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131765853));
                  break;
                }
                String str4 = s.bhK(str1);
                Log.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!Util.nullAs(str2, "").equals(str4))
                {
                  Log.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                g.aAi();
                if (g.aAk().postToWorker(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                Log.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.Dpv;
                str1 = this.Dpt;
                i = this.atU;
                str2 = this.Dpr;
                if (Util.isNullOrNil(str1))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((localObject1 == null) || (((List)localObject1).isEmpty()))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!s.YS(str1)) || (s.boW(str1) <= 0L))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cD(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131765853));
                  break;
                }
                str3 = s.bhK(str1);
                Log.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!Util.nullAs(str2, "").equals(str3))
                {
                  Log.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                g.aAi();
                if (g.aAk().postToWorker(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
                  break;
                }
                Log.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
              }
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.MainSightContainerView", localIOException, "", new Object[0]);
            continue;
            com.tencent.mm.plugin.report.service.h.CyF.a(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(28720);
          return;
        }
      }
    }
  }
  
  public int getViewHeight()
  {
    AppMethodBeat.i(28729);
    int i = getHeight();
    if (i <= 0)
    {
      i = getResources().getDisplayMetrics().heightPixels;
      AppMethodBeat.o(28729);
      return i;
    }
    AppMethodBeat.o(28729);
    return i;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(28719);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    paramInt -= 1;
    if ((MainSightSelectContactView.XI(paramInt)) && (this.gNC))
    {
      eWd();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.aNA(this.Dpj.vg(paramInt)))
    {
      this.Dpj.DpW.eWj();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.aNz(this.Dpj.vg(paramInt)))
    {
      String str;
      Object localObject2;
      if (c.DpH)
      {
        this.Dpy = true;
        this.Dpk.eWq();
        paramAdapterView = this.Dpx;
        paramView = e.aFl(this.Dpt);
        localObject1 = this.Dpt;
        str = this.Dpr;
        Log.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { localObject1, paramView });
        if (!s.YS(paramView)) {
          localObject2 = e.az((String)localObject1, 320, 240);
        }
      }
      try
      {
        BitmapUtil.saveBitmapToImage((Bitmap)localObject2, 60, Bitmap.CompressFormat.JPEG, paramView, true);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("KSightPath", (String)localObject1);
        ((Intent)localObject2).putExtra("KSightThumbPath", paramView);
        ((Intent)localObject2).putExtra("sight_md5", str);
        ((Intent)localObject2).putExtra("KSightDraftEntrance", false);
        ((Intent)localObject2).putExtra("Ksnsupload_source", 0);
        ((Intent)localObject2).putExtra("KSnsPostManu", true);
        ((Intent)localObject2).putExtra("KTouchCameraTime", Util.nowSecond());
        com.tencent.mm.br.c.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject2, 5985);
        if (this.DpA)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28719);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
          Log.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
          continue;
          com.tencent.mm.plugin.report.service.h.CyF.a(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
    }
    Log.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.Dpj;
    label544:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.DpY.getCount()))
    {
      paramAdapterView = this.Dpj;
      if (paramAdapterView.DpY != null) {
        paramAdapterView.DpY.notifyDataSetChanged();
      }
      if (Zx()) {
        break label714;
      }
      eWd();
      if (this.Dpj.DpW.eWi())
      {
        paramAdapterView = this.Dpj;
        if (paramAdapterView.DpY.anH(paramInt) != null) {
          break label801;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.Dpj.DpW.eWj();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
      paramView = paramAdapterView.DpY.anH(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.Dqg.contains(paramView.contact.field_username))
      {
        paramAdapterView.Dqg.remove(paramView.contact.field_username);
        label659:
        c.DpH = paramAdapterView.Dqg.isEmpty();
        if (paramAdapterView.Dqg.isEmpty()) {
          break label708;
        }
      }
      label708:
      for (bool = true;; bool = false)
      {
        c.DpI = bool;
        break;
        paramAdapterView.Dqg.add(paramView.contact.field_username);
        break label659;
      }
      label714:
      if (this.Dpj.eWp())
      {
        if (this.zfy.getVisibility() != 0) {
          break label544;
        }
        this.zfy.setVisibility(8);
        this.zfy.startAnimation(AnimationUtils.loadAnimation(this.Dpx, 2130772060));
        break label544;
      }
      if (this.zfy.getVisibility() == 0) {
        break label544;
      }
      this.zfy.setVisibility(0);
      this.zfy.startAnimation(AnimationUtils.loadAnimation(this.Dpx, 2130772059));
      break label544;
      label801:
      if (paramAdapterView.DpY.anH(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.Dqg.contains(paramAdapterView.DpY.anH(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(28723);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.Dps) && (this.Dpj != null))
    {
      Log.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.Dpj.eWo();
    }
    AppMethodBeat.o(28723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(28721);
    if (this.Dpy)
    {
      AppMethodBeat.o(28721);
      return;
    }
    this.Dpk.setVisibility(0);
    uI(false);
    this.Dpk.eWq();
    this.mIsPause = true;
    AppMethodBeat.o(28721);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(28722);
    int i;
    if (!this.Dps)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      EventCenter.instance.removeListener(this.Dpz);
      EventCenter.instance.addListener(this.Dpz);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        eWd();
        this.mIsPause = false;
      }
      AppMethodBeat.o(28722);
      return;
      i = 0;
      break;
      label69:
      removeListener();
    }
  }
  
  public final void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(28717);
    if (this.Dps)
    {
      AppMethodBeat.o(28717);
      return;
    }
    this.Dps = true;
    Util.hideVKB(this);
    this.gNC = false;
    this.Dpq = true;
    Log.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.Dpy = false;
    this.Dpk.eWq();
    if ((this.Dpl != null) && (paramBoolean)) {
      this.Dpl.eWf();
    }
    if (this.Dpj != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.Dpj;
      localMainSightSelectContactView.Dps = true;
      Util.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.DpW.eWl();
      localMainSightSelectContactView.Dqg.clear();
      localMainSightSelectContactView.Dqf.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    eWe();
    uI(false);
    this.Dpr = "";
    removeListener();
    AppMethodBeat.o(28717);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(28714);
    EventCenter.instance.removeListener(this.Dpz);
    AppMethodBeat.o(28714);
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(28724);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.oD(11)) {
      this.Dpm.setAlpha(paramFloat);
    }
    for (;;)
    {
      Log.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.Dpm.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.Dpm.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(28724);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.Dpm.startAnimation(localAlphaAnimation);
    }
    this.Dpm.setVisibility(0);
    AppMethodBeat.o(28724);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.Dpl = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.DpA = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28716);
    if (this.Dpk == null)
    {
      AppMethodBeat.o(28716);
      return;
    }
    this.Dpk.setIsMute(paramBoolean);
    AppMethodBeat.o(28716);
  }
  
  public final void uH(boolean paramBoolean)
  {
    AppMethodBeat.i(28726);
    if (paramBoolean)
    {
      this.Dpo.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(28726);
      return;
    }
    eWe();
    setIsMute(Zx());
    AppMethodBeat.o(28726);
  }
  
  public final void uI(boolean paramBoolean)
  {
    AppMethodBeat.i(28718);
    if (this.Dpw == paramBoolean)
    {
      AppMethodBeat.o(28718);
      return;
    }
    this.Dpw = paramBoolean;
    if (paramBoolean)
    {
      if (this.Dpn.getVisibility() == 0)
      {
        AppMethodBeat.o(28718);
        return;
      }
      this.Dpk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28708);
          if ((!MainSightForwardContainerView.b(MainSightForwardContainerView.this)) || ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (MainSightForwardContainerView.a(MainSightForwardContainerView.this).DpW.eWi())))
          {
            MainSightForwardContainerView.c(MainSightForwardContainerView.this);
            AppMethodBeat.o(28708);
            return;
          }
          MainSightForwardContainerView.d(MainSightForwardContainerView.this).setVisibility(0);
          if ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (!MainSightForwardContainerView.a(MainSightForwardContainerView.this).eWp()) && (MainSightForwardContainerView.e(MainSightForwardContainerView.this).getVisibility() != 0))
          {
            MainSightForwardContainerView.e(MainSightForwardContainerView.this).setVisibility(0);
            MainSightForwardContainerView.e(MainSightForwardContainerView.this).startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.f(MainSightForwardContainerView.this), 2130772059));
          }
          AppMethodBeat.o(28708);
        }
      }, 100L);
      AppMethodBeat.o(28718);
      return;
    }
    this.Dpn.setVisibility(8);
    this.zfy.setVisibility(8);
    AppMethodBeat.o(28718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */