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
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightForwardContainerView
  extends RelativeLayout
  implements AdapterView.OnItemClickListener, a
{
  private int atW;
  private boolean mIsPause;
  private boolean mIsPlaying;
  public MMFragmentActivity nbm;
  public View vKs;
  private boolean zkA;
  public String zkB;
  private boolean zkC;
  public String zkD;
  public float zkE;
  private com.tencent.mm.plugin.sight.encode.a.b zkF;
  private boolean zkG;
  private boolean zkH;
  private com.tencent.mm.sdk.b.c zkI;
  private boolean zkJ;
  private MediaPlayer zkK;
  public MainSightSelectContactView zkt;
  public SightCameraView zku;
  private b zkv;
  public View zkw;
  public View zkx;
  public View zky;
  private Dialog zkz;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28713);
    this.zkz = null;
    this.mIsPlaying = false;
    this.zkA = true;
    this.zkB = "";
    this.zkC = false;
    this.zkD = "";
    this.atW = 1;
    this.zkE = 1.0F;
    this.mIsPause = false;
    this.zkF = new com.tencent.mm.plugin.sight.encode.a.b();
    this.zkG = false;
    this.zkH = false;
    this.zkI = new com.tencent.mm.sdk.b.c() {};
    this.zkJ = false;
    AppMethodBeat.o(28713);
  }
  
  public final boolean Pd()
  {
    return !this.zkA;
  }
  
  public final void dUb()
  {
    AppMethodBeat.i(28727);
    this.zku.setVisibility(0);
    rn(true);
    AppMethodBeat.o(28727);
  }
  
  public final void dUc()
  {
    AppMethodBeat.i(28728);
    this.zku.setVisibility(4);
    rn(false);
    AppMethodBeat.o(28728);
  }
  
  public final void dUd()
  {
    boolean bool1 = true;
    AppMethodBeat.i(28715);
    ae.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.zkD, Boolean.valueOf(this.zkA), Boolean.valueOf(this.mIsPlaying) });
    if (!this.zku.isPlaying()) {
      this.zkA = true;
    }
    boolean bool2 = this.zkA;
    this.zku.bM(this.zkD, bool2);
    if (!this.zkA)
    {
      rn(false);
      this.mIsPlaying = true;
      if (this.zkA) {
        break label122;
      }
    }
    for (;;)
    {
      this.zkA = bool1;
      AppMethodBeat.o(28715);
      return;
      rn(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void dUe()
  {
    AppMethodBeat.i(28725);
    this.zky.setVisibility(8);
    AppMethodBeat.o(28725);
  }
  
  public final void dUg()
  {
    AppMethodBeat.i(28720);
    if (this.zkz == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!bu.isNullOrNil(this.zkD)) && (!this.zkt.dUp())) {
        break;
      }
      AppMethodBeat.o(28720);
      return;
    }
    Object localObject1 = this.zkt.getSelectedContact();
    com.tencent.mm.plugin.report.service.g.yxI.f(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new b.a()
    {
      public final void onError(int paramAnonymousInt)
      {
        AppMethodBeat.i(28711);
        if ((this.zkN.size() <= 1) || (-1 == paramAnonymousInt)) {
          com.tencent.mm.ui.base.h.cm(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(2131763075));
        }
        AppMethodBeat.o(28711);
      }
    };
    com.tencent.mm.plugin.sight.encode.a.b localb;
    String str1;
    int i;
    String str2;
    String str3;
    if (((List)localObject1).size() == 1)
    {
      localb = this.zkF;
      str1 = this.zkD;
      i = this.atW;
      str2 = this.zkB;
      str3 = (String)((List)localObject1).get(0);
      if (bu.isNullOrNil(str1))
      {
        ae.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.zkt.getSelectedContact().size() > 1) || (this.zkv == null)) {
          break label874;
        }
        localObject2 = (String)this.zkt.getSelectedContact().get(0);
        this.zkv.startChattingUI((String)localObject2);
      }
    }
    label874:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.nbm != null) {
          localObject2 = this.nbm.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.zkK = new k();
          this.zkK.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.zkK.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
          {
            public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
            {
              AppMethodBeat.i(28712);
              if (paramAnonymousMediaPlayer != null) {
                paramAnonymousMediaPlayer.release();
              }
              AppMethodBeat.o(28712);
            }
          });
          this.zkK.setLooping(false);
          this.zkK.prepare();
          this.zkK.start();
          rm(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (bu.isNullOrNil(str3))
                {
                  ae.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!o.fB(str1)) || (o.aZR(str1) <= 0L))
                {
                  ae.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cm(ak.getContext(), ak.getContext().getString(2131763664));
                  break;
                }
                String str4 = o.aRh(str1);
                ae.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!bu.bI(str2, "").equals(str4))
                {
                  ae.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.g.ajS();
                if (com.tencent.mm.kernel.g.ajU().aw(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                ae.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.zkF;
                str1 = this.zkD;
                i = this.atW;
                str2 = this.zkB;
                if (bu.isNullOrNil(str1))
                {
                  ae.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((localObject1 == null) || (((List)localObject1).isEmpty()))
                {
                  ae.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!o.fB(str1)) || (o.aZR(str1) <= 0L))
                {
                  ae.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cm(ak.getContext(), ak.getContext().getString(2131763664));
                  break;
                }
                str3 = o.aRh(str1);
                ae.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!bu.bI(str2, "").equals(str3))
                {
                  ae.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.g.ajS();
                if (com.tencent.mm.kernel.g.ajU().aw(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
                  break;
                }
                ae.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
              }
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.MainSightContainerView", localIOException, "", new Object[0]);
            continue;
            com.tencent.mm.plugin.report.service.g.yxI.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    paramInt -= 1;
    if ((MainSightSelectContactView.Qe(paramInt)) && (this.mIsPlaying))
    {
      dUd();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.ayQ(this.zkt.rq(paramInt)))
    {
      this.zkt.zlf.dUj();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.ayP(this.zkt.rq(paramInt)))
    {
      String str;
      Object localObject2;
      if (c.zkQ)
      {
        this.zkH = true;
        this.zku.dUq();
        paramAdapterView = this.nbm;
        paramView = e.arQ(this.zkD);
        localObject1 = this.zkD;
        str = this.zkB;
        ae.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { localObject1, paramView });
        if (!o.fB(paramView)) {
          localObject2 = e.aw((String)localObject1, 320, 240);
        }
      }
      try
      {
        com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject2, 60, Bitmap.CompressFormat.JPEG, paramView, true);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("KSightPath", (String)localObject1);
        ((Intent)localObject2).putExtra("KSightThumbPath", paramView);
        ((Intent)localObject2).putExtra("sight_md5", str);
        ((Intent)localObject2).putExtra("KSightDraftEntrance", false);
        ((Intent)localObject2).putExtra("Ksnsupload_source", 0);
        ((Intent)localObject2).putExtra("KSnsPostManu", true);
        ((Intent)localObject2).putExtra("KTouchCameraTime", bu.aRi());
        com.tencent.mm.br.d.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject2, 5985);
        if (this.zkJ)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28719);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
          ae.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
          continue;
          com.tencent.mm.plugin.report.service.g.yxI.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
    }
    ae.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.zkt;
    label544:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.zlh.getCount()))
    {
      paramAdapterView = this.zkt;
      if (paramAdapterView.zlh != null) {
        paramAdapterView.zlh.notifyDataSetChanged();
      }
      if (Pd()) {
        break label714;
      }
      dUd();
      if (this.zkt.zlf.dUi())
      {
        paramAdapterView = this.zkt;
        if (paramAdapterView.zlh.aeW(paramInt) != null) {
          break label801;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.zkt.zlf.dUj();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
      paramView = paramAdapterView.zlh.aeW(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.zlp.contains(paramView.contact.field_username))
      {
        paramAdapterView.zlp.remove(paramView.contact.field_username);
        label659:
        c.zkQ = paramAdapterView.zlp.isEmpty();
        if (paramAdapterView.zlp.isEmpty()) {
          break label708;
        }
      }
      label708:
      for (bool = true;; bool = false)
      {
        c.zkR = bool;
        break;
        paramAdapterView.zlp.add(paramView.contact.field_username);
        break label659;
      }
      label714:
      if (this.zkt.dUp())
      {
        if (this.vKs.getVisibility() != 0) {
          break label544;
        }
        this.vKs.setVisibility(8);
        this.vKs.startAnimation(AnimationUtils.loadAnimation(this.nbm, 2130772048));
        break label544;
      }
      if (this.vKs.getVisibility() == 0) {
        break label544;
      }
      this.vKs.setVisibility(0);
      this.vKs.startAnimation(AnimationUtils.loadAnimation(this.nbm, 2130772047));
      break label544;
      label801:
      if (paramAdapterView.zlh.aeW(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.zlp.contains(paramAdapterView.zlh.aeW(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(28723);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.zkC) && (this.zkt != null))
    {
      ae.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.zkt.dUo();
    }
    AppMethodBeat.o(28723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(28721);
    if (this.zkH)
    {
      AppMethodBeat.o(28721);
      return;
    }
    this.zku.setVisibility(0);
    rn(false);
    this.zku.dUq();
    this.mIsPause = true;
    AppMethodBeat.o(28721);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(28722);
    int i;
    if (!this.zkC)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      com.tencent.mm.sdk.b.a.IvT.d(this.zkI);
      com.tencent.mm.sdk.b.a.IvT.c(this.zkI);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        dUd();
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
  
  public final void removeListener()
  {
    AppMethodBeat.i(28714);
    com.tencent.mm.sdk.b.a.IvT.d(this.zkI);
    AppMethodBeat.o(28714);
  }
  
  public final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(28726);
    if (paramBoolean)
    {
      this.zky.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(28726);
      return;
    }
    dUe();
    setIsMute(Pd());
    AppMethodBeat.o(28726);
  }
  
  public final void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(28717);
    if (this.zkC)
    {
      AppMethodBeat.o(28717);
      return;
    }
    this.zkC = true;
    bu.hideVKB(this);
    this.mIsPlaying = false;
    this.zkA = true;
    ae.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.zkH = false;
    this.zku.dUq();
    if ((this.zkv != null) && (paramBoolean)) {
      this.zkv.dUf();
    }
    if (this.zkt != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.zkt;
      localMainSightSelectContactView.zkC = true;
      bu.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.zlf.dUl();
      localMainSightSelectContactView.zlp.clear();
      localMainSightSelectContactView.zlo.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    dUe();
    rn(false);
    this.zkB = "";
    removeListener();
    AppMethodBeat.o(28717);
  }
  
  public final void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(28718);
    if (this.zkG == paramBoolean)
    {
      AppMethodBeat.o(28718);
      return;
    }
    this.zkG = paramBoolean;
    if (paramBoolean)
    {
      if (this.zkx.getVisibility() == 0)
      {
        AppMethodBeat.o(28718);
        return;
      }
      this.zku.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28708);
          if ((!MainSightForwardContainerView.b(MainSightForwardContainerView.this)) || ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (MainSightForwardContainerView.a(MainSightForwardContainerView.this).zlf.dUi())))
          {
            MainSightForwardContainerView.c(MainSightForwardContainerView.this);
            AppMethodBeat.o(28708);
            return;
          }
          MainSightForwardContainerView.d(MainSightForwardContainerView.this).setVisibility(0);
          if ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (!MainSightForwardContainerView.a(MainSightForwardContainerView.this).dUp()) && (MainSightForwardContainerView.e(MainSightForwardContainerView.this).getVisibility() != 0))
          {
            MainSightForwardContainerView.e(MainSightForwardContainerView.this).setVisibility(0);
            MainSightForwardContainerView.e(MainSightForwardContainerView.this).startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.f(MainSightForwardContainerView.this), 2130772047));
          }
          AppMethodBeat.o(28708);
        }
      }, 100L);
      AppMethodBeat.o(28718);
      return;
    }
    this.zkx.setVisibility(8);
    this.vKs.setVisibility(8);
    AppMethodBeat.o(28718);
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(28724);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.lA(11)) {
      this.zkw.setAlpha(paramFloat);
    }
    for (;;)
    {
      ae.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.zkw.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.zkw.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(28724);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.zkw.startAnimation(localAlphaAnimation);
    }
    this.zkw.setVisibility(0);
    AppMethodBeat.o(28724);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.zkv = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.zkJ = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28716);
    if (this.zku == null)
    {
      AppMethodBeat.o(28716);
      return;
    }
    this.zku.setIsMute(paramBoolean);
    AppMethodBeat.o(28716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */