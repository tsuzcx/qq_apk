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
import com.tencent.mm.R.a;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.f.a.wa;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.aq.a.h;
import com.tencent.mm.plugin.sight.base.f;
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
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightForwardContainerView
  extends RelativeLayout
  implements AdapterView.OnItemClickListener, a
{
  public View EKB;
  public MainSightSelectContactView JuO;
  public SightCameraView JuP;
  private b JuQ;
  public View JuR;
  public View JuS;
  public View JuT;
  private Dialog JuU;
  private boolean JuV;
  public String JuW;
  private boolean JuX;
  public String JuY;
  public float JuZ;
  private com.tencent.mm.plugin.sight.encode.a.b Jva;
  private boolean Jvb;
  public MMFragmentActivity Jvc;
  private boolean Jvd;
  private IListener Jve;
  private boolean Jvf;
  private MediaPlayer Jvg;
  private int alM;
  private boolean jxX;
  private boolean mIsPause;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28713);
    this.JuU = null;
    this.jxX = false;
    this.JuV = true;
    this.JuW = "";
    this.JuX = false;
    this.JuY = "";
    this.alM = 1;
    this.JuZ = 1.0F;
    this.mIsPause = false;
    this.Jva = new com.tencent.mm.plugin.sight.encode.a.b();
    this.Jvb = false;
    this.Jvd = false;
    this.Jve = new IListener() {};
    this.Jvf = false;
    AppMethodBeat.o(28713);
  }
  
  public final boolean aeg()
  {
    return !this.JuV;
  }
  
  public final void fJe()
  {
    AppMethodBeat.i(28727);
    this.JuP.setVisibility(0);
    yg(true);
    AppMethodBeat.o(28727);
  }
  
  public final void fJf()
  {
    AppMethodBeat.i(28728);
    this.JuP.setVisibility(4);
    yg(false);
    AppMethodBeat.o(28728);
  }
  
  public final void fJg()
  {
    boolean bool1 = true;
    AppMethodBeat.i(28715);
    Log.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.JuY, Boolean.valueOf(this.JuV), Boolean.valueOf(this.jxX) });
    if (!this.JuP.isPlaying()) {
      this.JuV = true;
    }
    boolean bool2 = this.JuV;
    this.JuP.cn(this.JuY, bool2);
    if (!this.JuV)
    {
      yg(false);
      this.jxX = true;
      if (this.JuV) {
        break label122;
      }
    }
    for (;;)
    {
      this.JuV = bool1;
      AppMethodBeat.o(28715);
      return;
      yg(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void fJh()
  {
    AppMethodBeat.i(28725);
    this.JuT.setVisibility(8);
    AppMethodBeat.o(28725);
  }
  
  public final void fJj()
  {
    AppMethodBeat.i(28720);
    if (this.JuU == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!Util.isNullOrNil(this.JuY)) && (!this.JuO.fJs())) {
        break;
      }
      AppMethodBeat.o(28720);
      return;
    }
    Object localObject1 = this.JuO.getSelectedContact();
    com.tencent.mm.plugin.report.service.h.IzE.a(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new b.a()
    {
      public final void kv(int paramAnonymousInt)
      {
        AppMethodBeat.i(28711);
        if ((this.Jvj.size() <= 1) || (-1 == paramAnonymousInt)) {
          com.tencent.mm.ui.base.h.cO(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(R.l.sendrequest_send_fail));
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
      localb = this.Jva;
      str1 = this.JuY;
      i = this.alM;
      str2 = this.JuW;
      str3 = (String)((List)localObject1).get(0);
      if (Util.isNullOrNil(str1))
      {
        Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.JuO.getSelectedContact().size() > 1) || (this.JuQ == null)) {
          break label874;
        }
        localObject2 = (String)this.JuO.getSelectedContact().get(0);
        this.JuQ.startChattingUI((String)localObject2);
      }
    }
    label874:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.Jvc != null) {
          localObject2 = this.Jvc.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.Jvg = new k();
          this.Jvg.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.Jvg.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
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
          this.Jvg.setLooping(false);
          this.Jvg.prepare();
          this.Jvg.start();
          ic(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (Util.isNullOrNil(str3))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!u.agG(str1)) || (u.bBQ(str1) <= 0L))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cO(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.h.short_video_input_file_error));
                  break;
                }
                String str4 = u.buc(str1);
                Log.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!Util.nullAs(str2, "").equals(str4))
                {
                  Log.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.h.aHH();
                if (com.tencent.mm.kernel.h.aHJ().postToWorker(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                Log.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.Jva;
                str1 = this.JuY;
                i = this.alM;
                str2 = this.JuW;
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
                if ((!u.agG(str1)) || (u.bBQ(str1) <= 0L))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.cO(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.h.short_video_input_file_error));
                  break;
                }
                str3 = u.buc(str1);
                Log.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!Util.nullAs(str2, "").equals(str3))
                {
                  Log.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.h.aHH();
                if (com.tencent.mm.kernel.h.aHJ().postToWorker(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
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
            com.tencent.mm.plugin.report.service.h.IzE.a(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(28717);
    if (this.JuX)
    {
      AppMethodBeat.o(28717);
      return;
    }
    this.JuX = true;
    Util.hideVKB(this);
    this.jxX = false;
    this.JuV = true;
    Log.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.Jvd = false;
    this.JuP.fJt();
    if ((this.JuQ != null) && (paramBoolean)) {
      this.JuQ.fJi();
    }
    if (this.JuO != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.JuO;
      localMainSightSelectContactView.JuX = true;
      Util.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.JvB.fJo();
      localMainSightSelectContactView.JvL.clear();
      localMainSightSelectContactView.JvK.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    fJh();
    yg(false);
    this.JuW = "";
    removeListener();
    AppMethodBeat.o(28717);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(28719);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    paramInt -= 1;
    if ((MainSightSelectContactView.aeH(paramInt)) && (this.jxX))
    {
      fJg();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.aYk(this.JuO.yk(paramInt)))
    {
      this.JuO.JvB.fJm();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.aYj(this.JuO.yk(paramInt)))
    {
      String str;
      Object localObject2;
      if (c.Jvm)
      {
        this.Jvd = true;
        this.JuP.fJt();
        paramAdapterView = this.Jvc;
        paramView = f.aPv(this.JuY);
        localObject1 = this.JuY;
        str = this.JuW;
        Log.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { localObject1, paramView });
        if (!u.agG(paramView)) {
          localObject2 = f.aC((String)localObject1, 320, 240);
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
        com.tencent.mm.by.c.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject2, 5985);
        if (this.Jvf)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
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
          com.tencent.mm.plugin.report.service.h.IzE.a(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
    }
    Log.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.JuO;
    label544:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.JvD.getCount()))
    {
      paramAdapterView = this.JuO;
      if (paramAdapterView.JvD != null) {
        paramAdapterView.JvD.notifyDataSetChanged();
      }
      if (aeg()) {
        break label714;
      }
      fJg();
      if (this.JuO.JvB.fJl())
      {
        paramAdapterView = this.JuO;
        if (paramAdapterView.JvD.awM(paramInt) != null) {
          break label801;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.JuO.JvB.fJm();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
      paramView = paramAdapterView.JvD.awM(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.JvL.contains(paramView.contact.field_username))
      {
        paramAdapterView.JvL.remove(paramView.contact.field_username);
        label659:
        c.Jvm = paramAdapterView.JvL.isEmpty();
        if (paramAdapterView.JvL.isEmpty()) {
          break label708;
        }
      }
      label708:
      for (bool = true;; bool = false)
      {
        c.Jvn = bool;
        break;
        paramAdapterView.JvL.add(paramView.contact.field_username);
        break label659;
      }
      label714:
      if (this.JuO.fJs())
      {
        if (this.EKB.getVisibility() != 0) {
          break label544;
        }
        this.EKB.setVisibility(8);
        this.EKB.startAnimation(AnimationUtils.loadAnimation(this.Jvc, R.a.fast_faded_out));
        break label544;
      }
      if (this.EKB.getVisibility() == 0) {
        break label544;
      }
      this.EKB.setVisibility(0);
      this.EKB.startAnimation(AnimationUtils.loadAnimation(this.Jvc, R.a.fast_faded_in));
      break label544;
      label801:
      if (paramAdapterView.JvD.awM(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.JvL.contains(paramAdapterView.JvD.awM(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(28723);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.JuX) && (this.JuO != null))
    {
      Log.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.JuO.fJr();
    }
    AppMethodBeat.o(28723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(28721);
    if (this.Jvd)
    {
      AppMethodBeat.o(28721);
      return;
    }
    this.JuP.setVisibility(0);
    yg(false);
    this.JuP.fJt();
    this.mIsPause = true;
    AppMethodBeat.o(28721);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(28722);
    int i;
    if (!this.JuX)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      EventCenter.instance.removeListener(this.Jve);
      EventCenter.instance.addListener(this.Jve);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        fJg();
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
    EventCenter.instance.removeListener(this.Jve);
    AppMethodBeat.o(28714);
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(28724);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.qV(11)) {
      this.JuR.setAlpha(paramFloat);
    }
    for (;;)
    {
      Log.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.JuR.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.JuR.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(28724);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.JuR.startAnimation(localAlphaAnimation);
    }
    this.JuR.setVisibility(0);
    AppMethodBeat.o(28724);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.JuQ = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.Jvf = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28716);
    if (this.JuP == null)
    {
      AppMethodBeat.o(28716);
      return;
    }
    this.JuP.setIsMute(paramBoolean);
    AppMethodBeat.o(28716);
  }
  
  public final void yf(boolean paramBoolean)
  {
    AppMethodBeat.i(28726);
    if (paramBoolean)
    {
      this.JuT.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(28726);
      return;
    }
    fJh();
    setIsMute(aeg());
    AppMethodBeat.o(28726);
  }
  
  public final void yg(boolean paramBoolean)
  {
    AppMethodBeat.i(28718);
    if (this.Jvb == paramBoolean)
    {
      AppMethodBeat.o(28718);
      return;
    }
    this.Jvb = paramBoolean;
    if (paramBoolean)
    {
      if (this.JuS.getVisibility() == 0)
      {
        AppMethodBeat.o(28718);
        return;
      }
      this.JuP.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28708);
          if ((!MainSightForwardContainerView.b(MainSightForwardContainerView.this)) || ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (MainSightForwardContainerView.a(MainSightForwardContainerView.this).JvB.fJl())))
          {
            MainSightForwardContainerView.c(MainSightForwardContainerView.this);
            AppMethodBeat.o(28708);
            return;
          }
          MainSightForwardContainerView.d(MainSightForwardContainerView.this).setVisibility(0);
          if ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (!MainSightForwardContainerView.a(MainSightForwardContainerView.this).fJs()) && (MainSightForwardContainerView.e(MainSightForwardContainerView.this).getVisibility() != 0))
          {
            MainSightForwardContainerView.e(MainSightForwardContainerView.this).setVisibility(0);
            MainSightForwardContainerView.e(MainSightForwardContainerView.this).startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.f(MainSightForwardContainerView.this), R.a.fast_faded_in));
          }
          AppMethodBeat.o(28708);
        }
      }, 100L);
      AppMethodBeat.o(28718);
      return;
    }
    this.JuS.setVisibility(8);
    this.EKB.setVisibility(8);
    AppMethodBeat.o(28718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */