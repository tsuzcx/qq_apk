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
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private int asf;
  private boolean mIsPause;
  private boolean mIsPlaying;
  public MMFragmentActivity mvz;
  public View uvL;
  public SightCameraView xFA;
  private b xFB;
  public View xFC;
  public View xFD;
  public View xFE;
  private Dialog xFF;
  private boolean xFG;
  public String xFH;
  private boolean xFI;
  public String xFJ;
  public float xFK;
  private com.tencent.mm.plugin.sight.encode.a.b xFL;
  private boolean xFM;
  private boolean xFN;
  private com.tencent.mm.sdk.b.c xFO;
  private boolean xFP;
  private MediaPlayer xFQ;
  public MainSightSelectContactView xFz;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28713);
    this.xFF = null;
    this.mIsPlaying = false;
    this.xFG = true;
    this.xFH = "";
    this.xFI = false;
    this.xFJ = "";
    this.asf = 1;
    this.xFK = 1.0F;
    this.mIsPause = false;
    this.xFL = new com.tencent.mm.plugin.sight.encode.a.b();
    this.xFM = false;
    this.xFN = false;
    this.xFO = new com.tencent.mm.sdk.b.c() {};
    this.xFP = false;
    AppMethodBeat.o(28713);
  }
  
  public final boolean Nw()
  {
    return !this.xFG;
  }
  
  public final void dFc()
  {
    AppMethodBeat.i(28727);
    this.xFA.setVisibility(0);
    qE(true);
    AppMethodBeat.o(28727);
  }
  
  public final void dFd()
  {
    AppMethodBeat.i(28728);
    this.xFA.setVisibility(4);
    qE(false);
    AppMethodBeat.o(28728);
  }
  
  public final void dFe()
  {
    boolean bool1 = true;
    AppMethodBeat.i(28715);
    ac.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.xFJ, Boolean.valueOf(this.xFG), Boolean.valueOf(this.mIsPlaying) });
    if (!this.xFA.isPlaying()) {
      this.xFG = true;
    }
    boolean bool2 = this.xFG;
    this.xFA.bB(this.xFJ, bool2);
    if (!this.xFG)
    {
      qE(false);
      this.mIsPlaying = true;
      if (this.xFG) {
        break label122;
      }
    }
    for (;;)
    {
      this.xFG = bool1;
      AppMethodBeat.o(28715);
      return;
      qE(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void dFf()
  {
    AppMethodBeat.i(28725);
    this.xFE.setVisibility(8);
    AppMethodBeat.o(28725);
  }
  
  public final void dFh()
  {
    AppMethodBeat.i(28720);
    if (this.xFF == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!bs.isNullOrNil(this.xFJ)) && (!this.xFz.dFq())) {
        break;
      }
      AppMethodBeat.o(28720);
      return;
    }
    Object localObject1 = this.xFz.getSelectedContact();
    com.tencent.mm.plugin.report.service.h.wUl.f(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new b.a()
    {
      public final void onError(int paramAnonymousInt)
      {
        AppMethodBeat.i(28711);
        if ((this.xFT.size() <= 1) || (-1 == paramAnonymousInt)) {
          com.tencent.mm.ui.base.h.cg(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(2131763075));
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
      localb = this.xFL;
      str1 = this.xFJ;
      i = this.asf;
      str2 = this.xFH;
      str3 = (String)((List)localObject1).get(0);
      if (bs.isNullOrNil(str1))
      {
        ac.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.xFz.getSelectedContact().size() > 1) || (this.xFB == null)) {
          break label874;
        }
        localObject2 = (String)this.xFz.getSelectedContact().get(0);
        this.xFB.startChattingUI((String)localObject2);
      }
    }
    label874:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.mvz != null) {
          localObject2 = this.mvz.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.xFQ = new k();
          this.xFQ.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.xFQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
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
          this.xFQ.setLooping(false);
          this.xFQ.prepare();
          this.xFQ.start();
          qD(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.h.wUl.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (bs.isNullOrNil(str3))
                {
                  ac.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!i.eA(str1)) || (i.aSp(str1) <= 0L))
                {
                  ac.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cg(ai.getContext(), ai.getContext().getString(2131763664));
                  break;
                }
                String str4 = i.aKe(str1);
                ac.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!bs.bG(str2, "").equals(str4))
                {
                  ac.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                g.agS();
                if (g.agU().az(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                ac.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.xFL;
                str1 = this.xFJ;
                i = this.asf;
                str2 = this.xFH;
                if (bs.isNullOrNil(str1))
                {
                  ac.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((localObject1 == null) || (((List)localObject1).isEmpty()))
                {
                  ac.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!i.eA(str1)) || (i.aSp(str1) <= 0L))
                {
                  ac.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cg(ai.getContext(), ai.getContext().getString(2131763664));
                  break;
                }
                str3 = i.aKe(str1);
                ac.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!bs.bG(str2, "").equals(str3))
                {
                  ac.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                g.agS();
                if (g.agU().az(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
                  break;
                }
                ac.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
              }
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.MainSightContainerView", localIOException, "", new Object[0]);
            continue;
            com.tencent.mm.plugin.report.service.h.wUl.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
    if ((MainSightSelectContactView.NU(paramInt)) && (this.mIsPlaying))
    {
      dFe();
      AppMethodBeat.o(28719);
      return;
    }
    if (c.asA(this.xFz.qN(paramInt)))
    {
      this.xFz.xGl.dFk();
      AppMethodBeat.o(28719);
      return;
    }
    if (c.asz(this.xFz.qN(paramInt)))
    {
      if (c.xFW)
      {
        this.xFN = true;
        this.xFA.dFr();
        paramAdapterView = this.mvz;
        paramView = e.alW(this.xFJ);
        String str1 = this.xFJ;
        String str2 = this.xFH;
        ac.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { str1, paramView });
        Object localObject;
        if (!i.eA(paramView)) {
          localObject = e.as(str1, 320, 240);
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
          ((Intent)localObject).putExtra("KTouchCameraTime", bs.aNx());
          com.tencent.mm.br.d.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject, 5985);
          if (this.xFP)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
            AppMethodBeat.o(28719);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
            ac.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
      AppMethodBeat.o(28719);
      return;
    }
    ac.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.xFz;
    label445:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.xGn.getCount()))
    {
      paramAdapterView = this.xFz;
      if (paramAdapterView.xGn != null) {
        paramAdapterView.xGn.notifyDataSetChanged();
      }
      if (Nw()) {
        break label599;
      }
      dFe();
      if (this.xFz.xGl.dFj())
      {
        paramAdapterView = this.xFz;
        if (paramAdapterView.xGn.abQ(paramInt) != null) {
          break label686;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.xFz.xGl.dFk();
      }
      AppMethodBeat.o(28719);
      return;
      paramView = paramAdapterView.xGn.abQ(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.xGv.contains(paramView.contact.field_username))
      {
        paramAdapterView.xGv.remove(paramView.contact.field_username);
        label544:
        c.xFW = paramAdapterView.xGv.isEmpty();
        if (paramAdapterView.xGv.isEmpty()) {
          break label593;
        }
      }
      label593:
      for (bool = true;; bool = false)
      {
        c.xFX = bool;
        break;
        paramAdapterView.xGv.add(paramView.contact.field_username);
        break label544;
      }
      label599:
      if (this.xFz.dFq())
      {
        if (this.uvL.getVisibility() != 0) {
          break label445;
        }
        this.uvL.setVisibility(8);
        this.uvL.startAnimation(AnimationUtils.loadAnimation(this.mvz, 2130772048));
        break label445;
      }
      if (this.uvL.getVisibility() == 0) {
        break label445;
      }
      this.uvL.setVisibility(0);
      this.uvL.startAnimation(AnimationUtils.loadAnimation(this.mvz, 2130772047));
      break label445;
      label686:
      if (paramAdapterView.xGn.abQ(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.xGv.contains(paramAdapterView.xGn.abQ(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(28723);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.xFI) && (this.xFz != null))
    {
      ac.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.xFz.dFp();
    }
    AppMethodBeat.o(28723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(28721);
    if (this.xFN)
    {
      AppMethodBeat.o(28721);
      return;
    }
    this.xFA.setVisibility(0);
    qE(false);
    this.xFA.dFr();
    this.mIsPause = true;
    AppMethodBeat.o(28721);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(28722);
    int i;
    if (!this.xFI)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      com.tencent.mm.sdk.b.a.GpY.d(this.xFO);
      com.tencent.mm.sdk.b.a.GpY.c(this.xFO);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        dFe();
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
  
  public final void qC(boolean paramBoolean)
  {
    AppMethodBeat.i(28726);
    if (paramBoolean)
    {
      this.xFE.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(28726);
      return;
    }
    dFf();
    setIsMute(Nw());
    AppMethodBeat.o(28726);
  }
  
  public final void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(28717);
    if (this.xFI)
    {
      AppMethodBeat.o(28717);
      return;
    }
    this.xFI = true;
    bs.hideVKB(this);
    this.mIsPlaying = false;
    this.xFG = true;
    ac.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.xFN = false;
    this.xFA.dFr();
    if ((this.xFB != null) && (paramBoolean)) {
      this.xFB.dFg();
    }
    if (this.xFz != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.xFz;
      localMainSightSelectContactView.xFI = true;
      bs.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.xGl.dFm();
      localMainSightSelectContactView.xGv.clear();
      localMainSightSelectContactView.xGu.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    dFf();
    qE(false);
    this.xFH = "";
    removeListener();
    AppMethodBeat.o(28717);
  }
  
  public final void qE(boolean paramBoolean)
  {
    AppMethodBeat.i(28718);
    if (this.xFM == paramBoolean)
    {
      AppMethodBeat.o(28718);
      return;
    }
    this.xFM = paramBoolean;
    if (paramBoolean)
    {
      if (this.xFD.getVisibility() == 0)
      {
        AppMethodBeat.o(28718);
        return;
      }
      this.xFA.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28708);
          if ((!MainSightForwardContainerView.b(MainSightForwardContainerView.this)) || ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (MainSightForwardContainerView.a(MainSightForwardContainerView.this).xGl.dFj())))
          {
            MainSightForwardContainerView.c(MainSightForwardContainerView.this);
            AppMethodBeat.o(28708);
            return;
          }
          MainSightForwardContainerView.d(MainSightForwardContainerView.this).setVisibility(0);
          if ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (!MainSightForwardContainerView.a(MainSightForwardContainerView.this).dFq()) && (MainSightForwardContainerView.e(MainSightForwardContainerView.this).getVisibility() != 0))
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
    this.xFD.setVisibility(8);
    this.uvL.setVisibility(8);
    AppMethodBeat.o(28718);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(28714);
    com.tencent.mm.sdk.b.a.GpY.d(this.xFO);
    AppMethodBeat.o(28714);
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(28724);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.kZ(11)) {
      this.xFC.setAlpha(paramFloat);
    }
    for (;;)
    {
      ac.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.xFC.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.xFC.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(28724);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.xFC.startAnimation(localAlphaAnimation);
    }
    this.xFC.setVisibility(0);
    AppMethodBeat.o(28724);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.xFB = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.xFP = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28716);
    if (this.xFA == null)
    {
      AppMethodBeat.o(28716);
      return;
    }
    this.xFA.setIsMute(paramBoolean);
    AppMethodBeat.o(28716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */