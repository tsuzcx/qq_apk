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
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMFragmentActivity;
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
  private int ark;
  public MMFragmentActivity lTx;
  private boolean mIsPause;
  private boolean mIsPlaying;
  public View tns;
  private MediaPlayer wuA;
  public MainSightSelectContactView wuj;
  public SightCameraView wuk;
  private b wul;
  public View wum;
  public View wun;
  public View wuo;
  private Dialog wup;
  private boolean wuq;
  public String wur;
  private boolean wus;
  public String wut;
  public float wuu;
  private com.tencent.mm.plugin.sight.encode.a.b wuv;
  private boolean wuw;
  private boolean wux;
  private com.tencent.mm.sdk.b.c wuy;
  private boolean wuz;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28713);
    this.wup = null;
    this.mIsPlaying = false;
    this.wuq = true;
    this.wur = "";
    this.wus = false;
    this.wut = "";
    this.ark = 1;
    this.wuu = 1.0F;
    this.mIsPause = false;
    this.wuv = new com.tencent.mm.plugin.sight.encode.a.b();
    this.wuw = false;
    this.wux = false;
    this.wuy = new com.tencent.mm.sdk.b.c() {};
    this.wuz = false;
    AppMethodBeat.o(28713);
  }
  
  public final boolean Ny()
  {
    return !this.wuq;
  }
  
  public final void dqT()
  {
    AppMethodBeat.i(28727);
    this.wuk.setVisibility(0);
    pF(true);
    AppMethodBeat.o(28727);
  }
  
  public final void dqU()
  {
    AppMethodBeat.i(28728);
    this.wuk.setVisibility(4);
    pF(false);
    AppMethodBeat.o(28728);
  }
  
  public final void dqV()
  {
    boolean bool1 = true;
    AppMethodBeat.i(28715);
    ad.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.wut, Boolean.valueOf(this.wuq), Boolean.valueOf(this.mIsPlaying) });
    if (!this.wuk.isPlaying()) {
      this.wuq = true;
    }
    boolean bool2 = this.wuq;
    this.wuk.bu(this.wut, bool2);
    if (!this.wuq)
    {
      pF(false);
      this.mIsPlaying = true;
      if (this.wuq) {
        break label122;
      }
    }
    for (;;)
    {
      this.wuq = bool1;
      AppMethodBeat.o(28715);
      return;
      pF(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void dqW()
  {
    AppMethodBeat.i(28725);
    this.wuo.setVisibility(8);
    AppMethodBeat.o(28725);
  }
  
  public final void dqY()
  {
    AppMethodBeat.i(28720);
    if (this.wup == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!bt.isNullOrNil(this.wut)) && (!this.wuj.drh())) {
        break;
      }
      AppMethodBeat.o(28720);
      return;
    }
    Object localObject1 = this.wuj.getSelectedContact();
    com.tencent.mm.plugin.report.service.h.vKh.f(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new b.a()
    {
      public final void onError(int paramAnonymousInt)
      {
        AppMethodBeat.i(28711);
        if ((this.wuD.size() <= 1) || (-1 == paramAnonymousInt)) {
          com.tencent.mm.ui.base.h.cf(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(2131763075));
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
      localb = this.wuv;
      str1 = this.wut;
      i = this.ark;
      str2 = this.wur;
      str3 = (String)((List)localObject1).get(0);
      if (bt.isNullOrNil(str1))
      {
        ad.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.wuj.getSelectedContact().size() > 1) || (this.wul == null)) {
          break label874;
        }
        localObject2 = (String)this.wuj.getSelectedContact().get(0);
        this.wul.startChattingUI((String)localObject2);
      }
    }
    label874:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.lTx != null) {
          localObject2 = this.lTx.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.wuA = new k();
          this.wuA.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.wuA.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
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
          this.wuA.setLooping(false);
          this.wuA.prepare();
          this.wuA.start();
          pE(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.h.vKh.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (bt.isNullOrNil(str3))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!i.eK(str1)) || (i.aMN(str1) <= 0L))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cf(aj.getContext(), aj.getContext().getString(2131763664));
                  break;
                }
                String str4 = i.aEN(str1);
                ad.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!bt.by(str2, "").equals(str4))
                {
                  ad.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                g.afC();
                if (g.afE().ax(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                ad.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.wuv;
                str1 = this.wut;
                i = this.ark;
                str2 = this.wur;
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
                if ((!i.eK(str1)) || (i.aMN(str1) <= 0L))
                {
                  ad.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cf(aj.getContext(), aj.getContext().getString(2131763664));
                  break;
                }
                str3 = i.aEN(str1);
                ad.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!bt.by(str2, "").equals(str3))
                {
                  ad.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                g.afC();
                if (g.afE().ax(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
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
            com.tencent.mm.plugin.report.service.h.vKh.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
    paramInt -= 1;
    if ((MainSightSelectContactView.LU(paramInt)) && (this.mIsPlaying))
    {
      dqV();
      AppMethodBeat.o(28719);
      return;
    }
    if (c.anr(this.wuj.qa(paramInt)))
    {
      this.wuj.wuV.drb();
      AppMethodBeat.o(28719);
      return;
    }
    if (c.anq(this.wuj.qa(paramInt)))
    {
      if (c.wuG)
      {
        this.wux = true;
        this.wuk.dri();
        paramAdapterView = this.lTx;
        paramView = e.ahb(this.wut);
        String str1 = this.wut;
        String str2 = this.wur;
        ad.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { str1, paramView });
        Object localObject;
        if (!i.eK(paramView)) {
          localObject = e.at(str1, 320, 240);
        }
        try
        {
          f.a((Bitmap)localObject, 60, Bitmap.CompressFormat.JPEG, paramView, true);
          localObject = new Intent();
          ((Intent)localObject).putExtra("KSightPath", str1);
          ((Intent)localObject).putExtra("KSightThumbPath", paramView);
          ((Intent)localObject).putExtra("sight_md5", str2);
          ((Intent)localObject).putExtra("KSightDraftEntrance", false);
          ((Intent)localObject).putExtra("Ksnsupload_source", 0);
          ((Intent)localObject).putExtra("KSnsPostManu", true);
          ((Intent)localObject).putExtra("KTouchCameraTime", bt.aGK());
          com.tencent.mm.bs.d.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject, 5985);
          if (this.wuz)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
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
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
      AppMethodBeat.o(28719);
      return;
    }
    ad.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.wuj;
    label445:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.wuX.getCount()))
    {
      paramAdapterView = this.wuj;
      if (paramAdapterView.wuX != null) {
        paramAdapterView.wuX.notifyDataSetChanged();
      }
      if (Ny()) {
        break label599;
      }
      dqV();
      if (this.wuj.wuV.dra())
      {
        paramAdapterView = this.wuj;
        if (paramAdapterView.wuX.ZC(paramInt) != null) {
          break label686;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.wuj.wuV.drb();
      }
      AppMethodBeat.o(28719);
      return;
      paramView = paramAdapterView.wuX.ZC(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.wvf.contains(paramView.contact.field_username))
      {
        paramAdapterView.wvf.remove(paramView.contact.field_username);
        label544:
        c.wuG = paramAdapterView.wvf.isEmpty();
        if (paramAdapterView.wvf.isEmpty()) {
          break label593;
        }
      }
      label593:
      for (bool = true;; bool = false)
      {
        c.wuH = bool;
        break;
        paramAdapterView.wvf.add(paramView.contact.field_username);
        break label544;
      }
      label599:
      if (this.wuj.drh())
      {
        if (this.tns.getVisibility() != 0) {
          break label445;
        }
        this.tns.setVisibility(8);
        this.tns.startAnimation(AnimationUtils.loadAnimation(this.lTx, 2130772048));
        break label445;
      }
      if (this.tns.getVisibility() == 0) {
        break label445;
      }
      this.tns.setVisibility(0);
      this.tns.startAnimation(AnimationUtils.loadAnimation(this.lTx, 2130772047));
      break label445;
      label686:
      if (paramAdapterView.wuX.ZC(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.wvf.contains(paramAdapterView.wuX.ZC(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(28723);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.wus) && (this.wuj != null))
    {
      ad.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.wuj.drg();
    }
    AppMethodBeat.o(28723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(28721);
    if (this.wux)
    {
      AppMethodBeat.o(28721);
      return;
    }
    this.wuk.setVisibility(0);
    pF(false);
    this.wuk.dri();
    this.mIsPause = true;
    AppMethodBeat.o(28721);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(28722);
    int i;
    if (!this.wus)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      com.tencent.mm.sdk.b.a.ESL.d(this.wuy);
      com.tencent.mm.sdk.b.a.ESL.c(this.wuy);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        dqV();
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
  
  public final void pD(boolean paramBoolean)
  {
    AppMethodBeat.i(28726);
    if (paramBoolean)
    {
      this.wuo.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(28726);
      return;
    }
    dqW();
    setIsMute(Ny());
    AppMethodBeat.o(28726);
  }
  
  public final void pE(boolean paramBoolean)
  {
    AppMethodBeat.i(28717);
    if (this.wus)
    {
      AppMethodBeat.o(28717);
      return;
    }
    this.wus = true;
    bt.hideVKB(this);
    this.mIsPlaying = false;
    this.wuq = true;
    ad.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.wux = false;
    this.wuk.dri();
    if ((this.wul != null) && (paramBoolean)) {
      this.wul.dqX();
    }
    if (this.wuj != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.wuj;
      localMainSightSelectContactView.wus = true;
      bt.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.wuV.drd();
      localMainSightSelectContactView.wvf.clear();
      localMainSightSelectContactView.wve.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    dqW();
    pF(false);
    this.wur = "";
    removeListener();
    AppMethodBeat.o(28717);
  }
  
  public final void pF(boolean paramBoolean)
  {
    AppMethodBeat.i(28718);
    if (this.wuw == paramBoolean)
    {
      AppMethodBeat.o(28718);
      return;
    }
    this.wuw = paramBoolean;
    if (paramBoolean)
    {
      if (this.wun.getVisibility() == 0)
      {
        AppMethodBeat.o(28718);
        return;
      }
      this.wuk.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28708);
          if ((!MainSightForwardContainerView.b(MainSightForwardContainerView.this)) || ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (MainSightForwardContainerView.a(MainSightForwardContainerView.this).wuV.dra())))
          {
            MainSightForwardContainerView.c(MainSightForwardContainerView.this);
            AppMethodBeat.o(28708);
            return;
          }
          MainSightForwardContainerView.d(MainSightForwardContainerView.this).setVisibility(0);
          if ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (!MainSightForwardContainerView.a(MainSightForwardContainerView.this).drh()) && (MainSightForwardContainerView.e(MainSightForwardContainerView.this).getVisibility() != 0))
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
    this.wun.setVisibility(8);
    this.tns.setVisibility(8);
    AppMethodBeat.o(28718);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(28714);
    com.tencent.mm.sdk.b.a.ESL.d(this.wuy);
    AppMethodBeat.o(28714);
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(28724);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.lf(11)) {
      this.wum.setAlpha(paramFloat);
    }
    for (;;)
    {
      ad.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.wum.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.wum.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(28724);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.wum.startAnimation(localAlphaAnimation);
    }
    this.wum.setVisibility(0);
    AppMethodBeat.o(28724);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.wul = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.wuz = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28716);
    if (this.wuk == null)
    {
      AppMethodBeat.o(28716);
      return;
    }
    this.wuk.setIsMute(paramBoolean);
    AppMethodBeat.o(28716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */