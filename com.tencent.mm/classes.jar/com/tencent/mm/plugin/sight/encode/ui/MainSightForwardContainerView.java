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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
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
  public MMFragmentActivity mWg;
  public View vyo;
  private MediaPlayer yUA;
  public MainSightSelectContactView yUj;
  public SightCameraView yUk;
  private b yUl;
  public View yUm;
  public View yUn;
  public View yUo;
  private Dialog yUp;
  private boolean yUq;
  public String yUr;
  private boolean yUs;
  public String yUt;
  public float yUu;
  private com.tencent.mm.plugin.sight.encode.a.b yUv;
  private boolean yUw;
  private boolean yUx;
  private com.tencent.mm.sdk.b.c yUy;
  private boolean yUz;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28713);
    this.yUp = null;
    this.mIsPlaying = false;
    this.yUq = true;
    this.yUr = "";
    this.yUs = false;
    this.yUt = "";
    this.atW = 1;
    this.yUu = 1.0F;
    this.mIsPause = false;
    this.yUv = new com.tencent.mm.plugin.sight.encode.a.b();
    this.yUw = false;
    this.yUx = false;
    this.yUy = new MainSightForwardContainerView.5(this);
    this.yUz = false;
    AppMethodBeat.o(28713);
  }
  
  public final boolean Pf()
  {
    return !this.yUq;
  }
  
  public final void dQE()
  {
    AppMethodBeat.i(28727);
    this.yUk.setVisibility(0);
    rg(true);
    AppMethodBeat.o(28727);
  }
  
  public final void dQF()
  {
    AppMethodBeat.i(28728);
    this.yUk.setVisibility(4);
    rg(false);
    AppMethodBeat.o(28728);
  }
  
  public final void dQG()
  {
    boolean bool1 = true;
    AppMethodBeat.i(28715);
    ad.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.yUt, Boolean.valueOf(this.yUq), Boolean.valueOf(this.mIsPlaying) });
    if (!this.yUk.isPlaying()) {
      this.yUq = true;
    }
    boolean bool2 = this.yUq;
    this.yUk.bI(this.yUt, bool2);
    if (!this.yUq)
    {
      rg(false);
      this.mIsPlaying = true;
      if (this.yUq) {
        break label122;
      }
    }
    for (;;)
    {
      this.yUq = bool1;
      AppMethodBeat.o(28715);
      return;
      rg(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void dQH()
  {
    AppMethodBeat.i(28725);
    this.yUo.setVisibility(8);
    AppMethodBeat.o(28725);
  }
  
  public final void dQJ()
  {
    AppMethodBeat.i(28720);
    if (this.yUp == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!bt.isNullOrNil(this.yUt)) && (!this.yUj.dQS())) {
        break;
      }
      AppMethodBeat.o(28720);
      return;
    }
    Object localObject1 = this.yUj.getSelectedContact();
    com.tencent.mm.plugin.report.service.g.yhR.f(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new MainSightForwardContainerView.6(this, (List)localObject1);
    com.tencent.mm.plugin.sight.encode.a.b localb;
    String str1;
    int i;
    String str2;
    String str3;
    if (((List)localObject1).size() == 1)
    {
      localb = this.yUv;
      str1 = this.yUt;
      i = this.atW;
      str2 = this.yUr;
      str3 = (String)((List)localObject1).get(0);
      if (bt.isNullOrNil(str1))
      {
        ad.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.yUj.getSelectedContact().size() > 1) || (this.yUl == null)) {
          break label873;
        }
        localObject2 = (String)this.yUj.getSelectedContact().get(0);
        this.yUl.startChattingUI((String)localObject2);
      }
    }
    label873:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.mWg != null) {
          localObject2 = this.mWg.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.yUA = new k();
          this.yUA.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.yUA.setOnCompletionListener(new MainSightForwardContainerView.7(this));
          this.yUA.setLooping(false);
          this.yUA.prepare();
          this.yUA.start();
          rf(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.g.yhR.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (bt.isNullOrNil(str3))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!i.fv(str1)) || (i.aYo(str1) <= 0L))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  h.cl(aj.getContext(), aj.getContext().getString(2131763664));
                  break;
                }
                String str4 = i.aPK(str1);
                ad.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!bt.bI(str2, "").equals(str4))
                {
                  ad.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.g.ajD();
                if (com.tencent.mm.kernel.g.ajF().ay(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                ad.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.yUv;
                str1 = this.yUt;
                i = this.atW;
                str2 = this.yUr;
                if (bt.isNullOrNil(str1))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((localObject1 == null) || (((List)localObject1).isEmpty()))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!i.fv(str1)) || (i.aYo(str1) <= 0L))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  h.cl(aj.getContext(), aj.getContext().getString(2131763664));
                  break;
                }
                str3 = i.aPK(str1);
                ad.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!bt.bI(str2, "").equals(str3))
                {
                  ad.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.g.ajD();
                if (com.tencent.mm.kernel.g.ajF().ay(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
                  break;
                }
                ad.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
              }
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.MainSightContainerView", localIOException, "", new Object[0]);
            continue;
            com.tencent.mm.plugin.report.service.g.yhR.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    paramInt -= 1;
    if ((MainSightSelectContactView.Px(paramInt)) && (this.mIsPlaying))
    {
      dQG();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.axA(this.yUj.rn(paramInt)))
    {
      this.yUj.yUV.dQM();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.axz(this.yUj.rn(paramInt)))
    {
      String str;
      Object localObject2;
      if (c.yUG)
      {
        this.yUx = true;
        this.yUk.dQT();
        paramAdapterView = this.mWg;
        paramView = e.aqL(this.yUt);
        localObject1 = this.yUt;
        str = this.yUr;
        ad.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { localObject1, paramView });
        if (!i.fv(paramView)) {
          localObject2 = e.av((String)localObject1, 320, 240);
        }
      }
      try
      {
        com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, 60, Bitmap.CompressFormat.JPEG, paramView, true);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("KSightPath", (String)localObject1);
        ((Intent)localObject2).putExtra("KSightThumbPath", paramView);
        ((Intent)localObject2).putExtra("sight_md5", str);
        ((Intent)localObject2).putExtra("KSightDraftEntrance", false);
        ((Intent)localObject2).putExtra("Ksnsupload_source", 0);
        ((Intent)localObject2).putExtra("KSnsPostManu", true);
        ((Intent)localObject2).putExtra("KTouchCameraTime", bt.aQJ());
        com.tencent.mm.bs.d.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject2, 5985);
        if (this.yUz)
        {
          com.tencent.mm.plugin.report.service.g.yhR.f(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(28719);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
          ad.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
          continue;
          com.tencent.mm.plugin.report.service.g.yhR.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
    }
    ad.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.yUj;
    label544:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.yUX.getCount()))
    {
      paramAdapterView = this.yUj;
      if (paramAdapterView.yUX != null) {
        paramAdapterView.yUX.notifyDataSetChanged();
      }
      if (Pf()) {
        break label714;
      }
      dQG();
      if (this.yUj.yUV.dQL())
      {
        paramAdapterView = this.yUj;
        if (paramAdapterView.yUX.aen(paramInt) != null) {
          break label801;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.yUj.yUV.dQM();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
      paramView = paramAdapterView.yUX.aen(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.yVf.contains(paramView.contact.field_username))
      {
        paramAdapterView.yVf.remove(paramView.contact.field_username);
        label659:
        c.yUG = paramAdapterView.yVf.isEmpty();
        if (paramAdapterView.yVf.isEmpty()) {
          break label708;
        }
      }
      label708:
      for (bool = true;; bool = false)
      {
        c.yUH = bool;
        break;
        paramAdapterView.yVf.add(paramView.contact.field_username);
        break label659;
      }
      label714:
      if (this.yUj.dQS())
      {
        if (this.vyo.getVisibility() != 0) {
          break label544;
        }
        this.vyo.setVisibility(8);
        this.vyo.startAnimation(AnimationUtils.loadAnimation(this.mWg, 2130772048));
        break label544;
      }
      if (this.vyo.getVisibility() == 0) {
        break label544;
      }
      this.vyo.setVisibility(0);
      this.vyo.startAnimation(AnimationUtils.loadAnimation(this.mWg, 2130772047));
      break label544;
      label801:
      if (paramAdapterView.yUX.aen(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.yVf.contains(paramAdapterView.yUX.aen(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(28723);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.yUs) && (this.yUj != null))
    {
      ad.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.yUj.dQR();
    }
    AppMethodBeat.o(28723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(28721);
    if (this.yUx)
    {
      AppMethodBeat.o(28721);
      return;
    }
    this.yUk.setVisibility(0);
    rg(false);
    this.yUk.dQT();
    this.mIsPause = true;
    AppMethodBeat.o(28721);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(28722);
    int i;
    if (!this.yUs)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      com.tencent.mm.sdk.b.a.IbL.d(this.yUy);
      com.tencent.mm.sdk.b.a.IbL.c(this.yUy);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        dQG();
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
  
  public final void re(boolean paramBoolean)
  {
    AppMethodBeat.i(28726);
    if (paramBoolean)
    {
      this.yUo.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(28726);
      return;
    }
    dQH();
    setIsMute(Pf());
    AppMethodBeat.o(28726);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(28714);
    com.tencent.mm.sdk.b.a.IbL.d(this.yUy);
    AppMethodBeat.o(28714);
  }
  
  public final void rf(boolean paramBoolean)
  {
    AppMethodBeat.i(28717);
    if (this.yUs)
    {
      AppMethodBeat.o(28717);
      return;
    }
    this.yUs = true;
    bt.hideVKB(this);
    this.mIsPlaying = false;
    this.yUq = true;
    ad.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.yUx = false;
    this.yUk.dQT();
    if ((this.yUl != null) && (paramBoolean)) {
      this.yUl.dQI();
    }
    if (this.yUj != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.yUj;
      localMainSightSelectContactView.yUs = true;
      bt.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.yUV.dQO();
      localMainSightSelectContactView.yVf.clear();
      localMainSightSelectContactView.yVe.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    dQH();
    rg(false);
    this.yUr = "";
    removeListener();
    AppMethodBeat.o(28717);
  }
  
  public final void rg(boolean paramBoolean)
  {
    AppMethodBeat.i(28718);
    if (this.yUw == paramBoolean)
    {
      AppMethodBeat.o(28718);
      return;
    }
    this.yUw = paramBoolean;
    if (paramBoolean)
    {
      if (this.yUn.getVisibility() == 0)
      {
        AppMethodBeat.o(28718);
        return;
      }
      this.yUk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28708);
          if ((!MainSightForwardContainerView.b(MainSightForwardContainerView.this)) || ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (MainSightForwardContainerView.a(MainSightForwardContainerView.this).yUV.dQL())))
          {
            MainSightForwardContainerView.c(MainSightForwardContainerView.this);
            AppMethodBeat.o(28708);
            return;
          }
          MainSightForwardContainerView.d(MainSightForwardContainerView.this).setVisibility(0);
          if ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (!MainSightForwardContainerView.a(MainSightForwardContainerView.this).dQS()) && (MainSightForwardContainerView.e(MainSightForwardContainerView.this).getVisibility() != 0))
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
    this.yUn.setVisibility(8);
    this.vyo.setVisibility(8);
    AppMethodBeat.o(28718);
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(28724);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.ly(11)) {
      this.yUm.setAlpha(paramFloat);
    }
    for (;;)
    {
      ad.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.yUm.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.yUm.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(28724);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.yUm.startAnimation(localAlphaAnimation);
    }
    this.yUm.setVisibility(0);
    AppMethodBeat.o(28724);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.yUl = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.yUz = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28716);
    if (this.yUk == null)
    {
      AppMethodBeat.o(28716);
      return;
    }
    this.yUk.setIsMute(paramBoolean);
    AppMethodBeat.o(28716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */