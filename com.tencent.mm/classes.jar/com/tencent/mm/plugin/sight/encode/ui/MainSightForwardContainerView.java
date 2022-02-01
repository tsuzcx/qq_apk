package com.tencent.mm.plugin.sight.encode.ui;

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
import com.tencent.mm.R.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.ar.a.h;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightForwardContainerView
  extends RelativeLayout
  implements AdapterView.OnItemClickListener, a
{
  public View KEA;
  public MMFragmentActivity PIA;
  private boolean PIB;
  IListener PIC;
  private boolean PID;
  private MediaPlayer PIE;
  public MainSightSelectContactView PIm;
  public SightCameraView PIn;
  private b PIo;
  public View PIp;
  public View PIq;
  public View PIr;
  private Dialog PIs;
  private boolean PIt;
  public String PIu;
  private boolean PIv;
  public String PIw;
  public float PIx;
  private com.tencent.mm.plugin.sight.encode.a.b PIy;
  private boolean PIz;
  private int cam;
  private boolean mIsPause;
  private boolean qRV;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28713);
    this.PIs = null;
    this.qRV = false;
    this.PIt = true;
    this.PIu = "";
    this.PIv = false;
    this.PIw = "";
    this.cam = 1;
    this.PIx = 1.0F;
    this.mIsPause = false;
    this.PIy = new com.tencent.mm.plugin.sight.encode.a.b();
    this.PIz = false;
    this.PIB = false;
    this.PIC = new MainSightForwardContainerView.5(this, com.tencent.mm.app.f.hfK);
    this.PID = false;
    AppMethodBeat.o(28713);
  }
  
  public final void Dj(boolean paramBoolean)
  {
    AppMethodBeat.i(28726);
    if (paramBoolean)
    {
      this.PIr.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(28726);
      return;
    }
    gZa();
    setIsMute(aGe());
    AppMethodBeat.o(28726);
  }
  
  public final void Dk(boolean paramBoolean)
  {
    AppMethodBeat.i(28718);
    if (this.PIz == paramBoolean)
    {
      AppMethodBeat.o(28718);
      return;
    }
    this.PIz = paramBoolean;
    if (paramBoolean)
    {
      if (this.PIq.getVisibility() == 0)
      {
        AppMethodBeat.o(28718);
        return;
      }
      this.PIn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28708);
          if ((!MainSightForwardContainerView.b(MainSightForwardContainerView.this)) || ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (MainSightForwardContainerView.a(MainSightForwardContainerView.this).PIZ.gZf())))
          {
            MainSightForwardContainerView.c(MainSightForwardContainerView.this);
            AppMethodBeat.o(28708);
            return;
          }
          MainSightForwardContainerView.d(MainSightForwardContainerView.this).setVisibility(0);
          if ((MainSightForwardContainerView.a(MainSightForwardContainerView.this) != null) && (!MainSightForwardContainerView.a(MainSightForwardContainerView.this).gZm()) && (MainSightForwardContainerView.e(MainSightForwardContainerView.this).getVisibility() != 0))
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
    this.PIq.setVisibility(8);
    this.KEA.setVisibility(8);
    AppMethodBeat.o(28718);
  }
  
  public final boolean aGe()
  {
    return !this.PIt;
  }
  
  public final void gYX()
  {
    AppMethodBeat.i(28727);
    this.PIn.setVisibility(0);
    Dk(true);
    AppMethodBeat.o(28727);
  }
  
  public final void gYY()
  {
    AppMethodBeat.i(28728);
    this.PIn.setVisibility(4);
    Dk(false);
    AppMethodBeat.o(28728);
  }
  
  public final void gYZ()
  {
    boolean bool1 = true;
    AppMethodBeat.i(28715);
    Log.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.PIw, Boolean.valueOf(this.PIt), Boolean.valueOf(this.qRV) });
    if (!this.PIn.isPlaying()) {
      this.PIt = true;
    }
    boolean bool2 = this.PIt;
    this.PIn.cN(this.PIw, bool2);
    if (!this.PIt)
    {
      Dk(false);
      this.qRV = true;
      if (this.PIt) {
        break label122;
      }
    }
    for (;;)
    {
      this.PIt = bool1;
      AppMethodBeat.o(28715);
      return;
      Dk(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void gZa()
  {
    AppMethodBeat.i(28725);
    this.PIr.setVisibility(8);
    AppMethodBeat.o(28725);
  }
  
  public final boolean gZb()
  {
    return false;
  }
  
  public final void gZd()
  {
    AppMethodBeat.i(28720);
    if (this.PIs == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!Util.isNullOrNil(this.PIw)) && (!this.PIm.gZm())) {
        break;
      }
      AppMethodBeat.o(28720);
      return;
    }
    Object localObject1 = this.PIm.getSelectedContact();
    com.tencent.mm.plugin.report.service.h.OAn.b(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new MainSightForwardContainerView.6(this, (List)localObject1);
    com.tencent.mm.plugin.sight.encode.a.b localb;
    String str1;
    int i;
    String str2;
    String str3;
    if (((List)localObject1).size() == 1)
    {
      localb = this.PIy;
      str1 = this.PIw;
      i = this.cam;
      str2 = this.PIu;
      str3 = (String)((List)localObject1).get(0);
      if (Util.isNullOrNil(str1))
      {
        Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.PIm.getSelectedContact().size() > 1) || (this.PIo == null)) {
          break label874;
        }
        localObject2 = (String)this.PIm.getSelectedContact().get(0);
        this.PIo.startChattingUI((String)localObject2);
      }
    }
    label874:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.PIA != null) {
          localObject2 = this.PIA.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.PIE = new com.tencent.mm.compatible.b.k();
          this.PIE.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.PIE.setOnCompletionListener(new MainSightForwardContainerView.7(this));
          this.PIE.setLooping(false);
          this.PIE.prepare();
          this.PIE.start();
          jb(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (Util.isNullOrNil(str3))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!y.ZC(str1)) || (y.bEl(str1) <= 0L))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.k.cZ(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.h.short_video_input_file_error));
                  break;
                }
                String str4 = y.bub(str1);
                Log.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!Util.nullAs(str2, "").equals(str4))
                {
                  Log.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.h.baF();
                if (com.tencent.mm.kernel.h.baH().postToWorker(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                Log.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.PIy;
                str1 = this.PIw;
                i = this.cam;
                str2 = this.PIu;
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
                if ((!y.ZC(str1)) || (y.bEl(str1) <= 0L))
                {
                  Log.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.k.cZ(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(a.h.short_video_input_file_error));
                  break;
                }
                str3 = y.bub(str1);
                Log.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!Util.nullAs(str2, "").equals(str3))
                {
                  Log.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.h.baF();
                if (com.tencent.mm.kernel.h.baH().postToWorker(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
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
            com.tencent.mm.plugin.report.service.h.OAn.b(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
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
  
  public final void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(28717);
    if (this.PIv)
    {
      AppMethodBeat.o(28717);
      return;
    }
    this.PIv = true;
    Util.hideVKB(this);
    this.qRV = false;
    this.PIt = true;
    Log.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.PIB = false;
    this.PIn.gZn();
    if ((this.PIo != null) && (paramBoolean)) {
      this.PIo.gZc();
    }
    if (this.PIm != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.PIm;
      localMainSightSelectContactView.PIv = true;
      Util.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.PIZ.gZi();
      localMainSightSelectContactView.PJj.clear();
      localMainSightSelectContactView.PJi.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    gZa();
    Dk(false);
    this.PIu = "";
    this.PIC.dead();
    AppMethodBeat.o(28717);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(28719);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    paramInt -= 1;
    if ((MainSightSelectContactView.ajq(paramInt)) && (this.qRV))
    {
      gYZ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.aWc(this.PIm.yq(paramInt)))
    {
      this.PIm.PIZ.gZg();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
    }
    if (c.aWb(this.PIm.yq(paramInt)))
    {
      String str;
      Object localObject2;
      if (c.PIK)
      {
        this.PIB = true;
        this.PIn.gZn();
        paramAdapterView = this.PIA;
        paramView = com.tencent.mm.plugin.sight.base.f.aMt(this.PIw);
        localObject1 = this.PIw;
        str = this.PIu;
        Log.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { localObject1, paramView });
        if (!y.ZC(paramView)) {
          localObject2 = com.tencent.mm.plugin.sight.base.f.aK((String)localObject1, 320, 240);
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
        if (this.PID)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
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
          com.tencent.mm.plugin.report.service.h.OAn.b(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
    }
    Log.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.PIm;
    label544:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.PJb.getCount()))
    {
      paramAdapterView = this.PIm;
      if (paramAdapterView.PJb != null) {
        paramAdapterView.PJb.notifyDataSetChanged();
      }
      if (aGe()) {
        break label714;
      }
      gYZ();
      if (this.PIm.PIZ.gZf())
      {
        paramAdapterView = this.PIm;
        if (paramAdapterView.PJb.aDt(paramInt) != null) {
          break label801;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.PIm.PIZ.gZg();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/encode/ui/MainSightForwardContainerView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(28719);
      return;
      paramView = paramAdapterView.PJb.aDt(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.PJj.contains(paramView.contact.field_username))
      {
        paramAdapterView.PJj.remove(paramView.contact.field_username);
        label659:
        c.PIK = paramAdapterView.PJj.isEmpty();
        if (paramAdapterView.PJj.isEmpty()) {
          break label708;
        }
      }
      label708:
      for (bool = true;; bool = false)
      {
        c.PIL = bool;
        break;
        paramAdapterView.PJj.add(paramView.contact.field_username);
        break label659;
      }
      label714:
      if (this.PIm.gZm())
      {
        if (this.KEA.getVisibility() != 0) {
          break label544;
        }
        this.KEA.setVisibility(8);
        this.KEA.startAnimation(AnimationUtils.loadAnimation(this.PIA, R.a.fast_faded_out));
        break label544;
      }
      if (this.KEA.getVisibility() == 0) {
        break label544;
      }
      this.KEA.setVisibility(0);
      this.KEA.startAnimation(AnimationUtils.loadAnimation(this.PIA, R.a.fast_faded_in));
      break label544;
      label801:
      if (paramAdapterView.PJb.aDt(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.PJj.contains(paramAdapterView.PJb.aDt(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(28723);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.PIv) && (this.PIm != null))
    {
      Log.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.PIm.gZl();
    }
    AppMethodBeat.o(28723);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(28721);
    if (this.PIB)
    {
      AppMethodBeat.o(28721);
      return;
    }
    this.PIn.setVisibility(0);
    Dk(false);
    this.PIn.gZn();
    this.mIsPause = true;
    AppMethodBeat.o(28721);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(28722);
    int i;
    if (!this.PIv)
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
      this.PIC.dead();
      this.PIC.alive();
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        gYZ();
        this.mIsPause = false;
      }
      AppMethodBeat.o(28722);
      return;
      i = 0;
      break;
      label61:
      this.PIC.dead();
    }
  }
  
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(28724);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.rb(11)) {
      this.PIp.setAlpha(paramFloat);
    }
    for (;;)
    {
      Log.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.PIp.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.PIp.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(28724);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.PIp.startAnimation(localAlphaAnimation);
    }
    this.PIp.setVisibility(0);
    AppMethodBeat.o(28724);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.PIo = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.PID = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28716);
    if (this.PIn == null)
    {
      AppMethodBeat.o(28716);
      return;
    }
    this.PIn.setIsMute(paramBoolean);
    AppMethodBeat.o(28716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */