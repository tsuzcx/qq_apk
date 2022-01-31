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
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R.a;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.h.a.pv;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.ai.a.h;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMFragmentActivity;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainSightForwardContainerView
  extends RelativeLayout
  implements AdapterView.OnItemClickListener, a
{
  public View lWx;
  private int mDuration = 1;
  private boolean mIsPause = false;
  private boolean mIsPlaying = false;
  public View ohA;
  public View ohB;
  private Dialog ohC = null;
  private boolean ohD = true;
  public String ohE = "";
  private boolean ohF = false;
  public String ohG = "";
  public float ohH = 1.0F;
  private com.tencent.mm.plugin.sight.encode.a.b ohI = new com.tencent.mm.plugin.sight.encode.a.b();
  private boolean ohJ = false;
  public MMFragmentActivity ohK;
  private boolean ohL = false;
  private com.tencent.mm.sdk.b.c ohM = new com.tencent.mm.sdk.b.c() {};
  private boolean ohN = false;
  private MediaPlayer ohO;
  public MainSightSelectContactView ohw;
  public SightCameraView ohx;
  private b ohy;
  public View ohz;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean Bj()
  {
    return !this.ohD;
  }
  
  public final void bBD()
  {
    this.ohx.setVisibility(0);
    iT(true);
  }
  
  public final void bBE()
  {
    this.ohx.setVisibility(4);
    iT(false);
  }
  
  public final void bBF()
  {
    boolean bool1 = true;
    y.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.ohG, Boolean.valueOf(this.ohD), Boolean.valueOf(this.mIsPlaying) });
    if (!this.ohx.isPlaying()) {
      this.ohD = true;
    }
    boolean bool2 = this.ohD;
    this.ohx.aX(this.ohG, bool2);
    if (!this.ohD)
    {
      iT(false);
      this.mIsPlaying = true;
      if (this.ohD) {
        break label110;
      }
    }
    for (;;)
    {
      this.ohD = bool1;
      return;
      iT(true);
      break;
      label110:
      bool1 = false;
    }
  }
  
  public final void bBG()
  {
    this.ohB.setVisibility(8);
  }
  
  public final void bBI()
  {
    if (this.ohC == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!bk.bl(this.ohG)) && (!this.ohw.bBQ())) {
        break;
      }
      return;
    }
    Object localObject1 = this.ohw.getSelectedContact();
    com.tencent.mm.plugin.report.service.h.nFQ.f(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new MainSightForwardContainerView.6(this, (List)localObject1);
    com.tencent.mm.plugin.sight.encode.a.b localb;
    String str1;
    int i;
    String str2;
    String str3;
    if (((List)localObject1).size() == 1)
    {
      localb = this.ohI;
      str1 = this.ohG;
      i = this.mDuration;
      str2 = this.ohE;
      str3 = (String)((List)localObject1).get(0);
      if (bk.bl(str1))
      {
        y.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        label177:
        if ((this.ohw.getSelectedContact().size() > 1) || (this.ohy == null)) {
          break label850;
        }
        localObject2 = (String)this.ohw.getSelectedContact().get(0);
        this.ohy.startChattingUI((String)localObject2);
      }
    }
    label820:
    label850:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.ohK != null) {
          localObject2 = this.ohK.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.ohO = new j();
          this.ohO.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.ohO.setOnCompletionListener(new MainSightForwardContainerView.7(this));
          this.ohO.setLooping(false);
          this.ohO.prepare();
          this.ohO.start();
          iS(bool);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            if (!((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom")) {
              break label820;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
          if (bk.bl(str3))
          {
            y.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
            com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
            break label177;
          }
          if ((!e.bK(str1)) || (e.bJ(str1) <= 0))
          {
            y.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
            com.tencent.mm.ui.base.h.bC(ae.getContext(), ae.getContext().getString(a.h.short_video_input_file_error));
            break label177;
          }
          String str4 = com.tencent.mm.a.g.bQ(str1);
          y.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
          if (!bk.aM(str2, "").equals(str4))
          {
            y.e("MicroMsg.SightRecorderHelper", "error md5, return");
            com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
            break label177;
          }
          com.tencent.mm.kernel.g.DQ();
          if (com.tencent.mm.kernel.g.DS().O(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
            break label177;
          }
          y.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
          com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
          break label177;
          localb = this.ohI;
          str1 = this.ohG;
          i = this.mDuration;
          str2 = this.ohE;
          if (bk.bl(str1))
          {
            y.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
            com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
            break label177;
          }
          if ((localObject1 == null) || (((List)localObject1).isEmpty()))
          {
            y.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
            com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
            break label177;
          }
          if ((!e.bK(str1)) || (e.bJ(str1) <= 0))
          {
            y.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
            com.tencent.mm.ui.base.h.bC(ae.getContext(), ae.getContext().getString(a.h.short_video_input_file_error));
            break label177;
          }
          str3 = com.tencent.mm.a.g.bQ(str1);
          y.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
          if (!bk.aM(str2, "").equals(str3))
          {
            y.e("MicroMsg.SightRecorderHelper", "error md5, return");
            com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
            break label177;
          }
          com.tencent.mm.kernel.g.DQ();
          if (com.tencent.mm.kernel.g.DS().O(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
            break label177;
          }
          y.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
          com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.MainSightContainerView", localIOException, "", new Object[0]);
            continue;
            com.tencent.mm.plugin.report.service.h.nFQ.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
          }
        }
      }
    }
  }
  
  public final void ch()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.ohM);
  }
  
  public int getViewHeight()
  {
    int j = getHeight();
    int i = j;
    if (j <= 0) {
      i = getResources().getDisplayMetrics().heightPixels;
    }
    return i;
  }
  
  public final void iR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ohB.setVisibility(0);
      setIsMute(true);
      return;
    }
    bBG();
    setIsMute(Bj());
  }
  
  public final void iS(boolean paramBoolean)
  {
    if (this.ohF) {
      return;
    }
    this.ohF = true;
    bk.hideVKB(this);
    this.mIsPlaying = false;
    this.ohD = true;
    y.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.ohL = false;
    this.ohx.bBR();
    if ((this.ohy != null) && (paramBoolean)) {
      this.ohy.bBH();
    }
    if (this.ohw != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.ohw;
      localMainSightSelectContactView.ohF = true;
      bk.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.oik.bBM();
      localMainSightSelectContactView.oiu.clear();
      localMainSightSelectContactView.oit.clear();
      localMainSightSelectContactView.Nn.setAdapter(null);
      localMainSightSelectContactView.Nn.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    bBG();
    iT(false);
    this.ohE = "";
    ch();
  }
  
  public final void iT(boolean paramBoolean)
  {
    if (this.ohJ == paramBoolean) {}
    do
    {
      return;
      this.ohJ = paramBoolean;
      if (!paramBoolean) {
        break;
      }
    } while (this.ohA.getVisibility() == 0);
    this.ohx.postDelayed(new MainSightForwardContainerView.4(this), 100L);
    return;
    this.ohA.setVisibility(8);
    this.lWx.setVisibility(8);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= 1;
    if ((MainSightSelectContactView.xw(paramInt)) && (this.mIsPlaying)) {
      bBF();
    }
    label384:
    label414:
    label556:
    label562:
    label693:
    for (;;)
    {
      return;
      if (c.MK(this.ohw.jX(paramInt)))
      {
        this.ohw.oik.bBL();
        return;
      }
      if (c.MJ(this.ohw.jX(paramInt)))
      {
        if (!c.ohU) {
          continue;
        }
        this.ohL = true;
        this.ohx.bBR();
        paramAdapterView = this.ohK;
        paramView = com.tencent.mm.plugin.sight.base.d.ME(this.ohG);
        String str1 = this.ohG;
        String str2 = this.ohE;
        y.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { str1, paramView });
        Object localObject;
        if (!e.bK(paramView)) {
          localObject = com.tencent.mm.plugin.sight.base.d.ab(str1, 320, 240);
        }
        try
        {
          com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject, 60, Bitmap.CompressFormat.JPEG, paramView, true);
          localObject = new Intent();
          ((Intent)localObject).putExtra("KSightPath", str1);
          ((Intent)localObject).putExtra("KSightThumbPath", paramView);
          ((Intent)localObject).putExtra("sight_md5", str2);
          ((Intent)localObject).putExtra("KSightDraftEntrance", false);
          ((Intent)localObject).putExtra("Ksnsupload_source", 0);
          ((Intent)localObject).putExtra("KSnsPostManu", true);
          ((Intent)localObject).putExtra("KTouchCameraTime", bk.UX());
          com.tencent.mm.br.d.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject, 5985);
          if (this.ohN)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.f(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
            y.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
          return;
        }
      }
      y.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
      paramAdapterView = this.ohw;
      boolean bool;
      if ((paramInt < 0) || (paramInt > paramAdapterView.oim.getCount()))
      {
        paramAdapterView = this.ohw;
        if (paramAdapterView.oim != null) {
          paramAdapterView.oim.notifyDataSetChanged();
        }
        if (Bj()) {
          break label562;
        }
        bBF();
        if (!this.ohw.oik.bBK()) {
          break label647;
        }
        paramAdapterView = this.ohw;
        if (paramAdapterView.oim.HK(paramInt) != null) {
          break label649;
        }
        bool = false;
      }
      for (;;)
      {
        if (!bool) {
          break label693;
        }
        this.ohw.oik.bBL();
        return;
        paramView = paramAdapterView.oim.HK(paramInt);
        if (paramView == null) {
          break label384;
        }
        if (paramAdapterView.oiu.contains(paramView.dnp.field_username))
        {
          paramAdapterView.oiu.remove(paramView.dnp.field_username);
          label507:
          c.ohU = paramAdapterView.oiu.isEmpty();
          if (paramAdapterView.oiu.isEmpty()) {
            break label556;
          }
        }
        for (bool = true;; bool = false)
        {
          c.ohV = bool;
          break;
          paramAdapterView.oiu.add(paramView.dnp.field_username);
          break label507;
        }
        if (this.ohw.bBQ())
        {
          if (this.lWx.getVisibility() != 0) {
            break label414;
          }
          this.lWx.setVisibility(8);
          this.lWx.startAnimation(AnimationUtils.loadAnimation(this.ohK, R.a.fast_faded_out));
          break label414;
        }
        if (this.lWx.getVisibility() == 0) {
          break label414;
        }
        this.lWx.setVisibility(0);
        this.lWx.startAnimation(AnimationUtils.loadAnimation(this.ohK, R.a.fast_faded_in));
        break label414;
        break;
        if (paramAdapterView.oim.HK(paramInt).dnp == null) {
          bool = false;
        } else {
          bool = paramAdapterView.oiu.contains(paramAdapterView.oim.HK(paramInt).dnp.field_username);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.ohF) && (this.ohw != null))
    {
      y.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.ohw.bBP();
    }
  }
  
  public final void onPause()
  {
    if (this.ohL) {
      return;
    }
    this.ohx.setVisibility(0);
    iT(false);
    this.ohx.bBR();
    this.mIsPause = true;
  }
  
  public final void onResume()
  {
    int i;
    if (!this.ohF)
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
      com.tencent.mm.sdk.b.a.udP.d(this.ohM);
      com.tencent.mm.sdk.b.a.udP.c(this.ohM);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        bBF();
        this.mIsPause = false;
      }
      return;
      i = 0;
      break;
      label57:
      ch();
    }
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.gF(11)) {
      this.ohz.setAlpha(paramFloat);
    }
    for (;;)
    {
      y.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.ohz.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.ohz.startAnimation(localAlphaAnimation);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.ohz.startAnimation(localAlphaAnimation);
    }
    this.ohz.setVisibility(0);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.ohy = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.ohN = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    if (this.ohx == null) {
      return;
    }
    this.ohx.setIsMute(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */