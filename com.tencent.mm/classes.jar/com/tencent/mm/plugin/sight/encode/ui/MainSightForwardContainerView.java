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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.sight.encode.a.b.3;
import com.tencent.mm.plugin.sight.encode.a.b.4;
import com.tencent.mm.plugin.sight.encode.a.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  public MMFragmentActivity jdB;
  private int mDuration;
  private boolean mIsPause;
  private boolean mIsPlaying;
  public View ouI;
  public MainSightSelectContactView qVK;
  public SightCameraView qVL;
  private b qVM;
  public View qVN;
  public View qVO;
  public View qVP;
  private Dialog qVQ;
  private boolean qVR;
  public String qVS;
  private boolean qVT;
  public String qVU;
  public float qVV;
  private com.tencent.mm.plugin.sight.encode.a.b qVW;
  private boolean qVX;
  private boolean qVY;
  private com.tencent.mm.sdk.b.c qVZ;
  private boolean qWa;
  private MediaPlayer qWb;
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MainSightForwardContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25043);
    this.qVQ = null;
    this.mIsPlaying = false;
    this.qVR = true;
    this.qVS = "";
    this.qVT = false;
    this.qVU = "";
    this.mDuration = 1;
    this.qVV = 1.0F;
    this.mIsPause = false;
    this.qVW = new com.tencent.mm.plugin.sight.encode.a.b();
    this.qVX = false;
    this.qVY = false;
    this.qVZ = new MainSightForwardContainerView.5(this);
    this.qWa = false;
    AppMethodBeat.o(25043);
  }
  
  public final boolean DP()
  {
    return !this.qVR;
  }
  
  public final void cnc()
  {
    AppMethodBeat.i(25057);
    this.qVL.setVisibility(0);
    kX(true);
    AppMethodBeat.o(25057);
  }
  
  public final void cnd()
  {
    AppMethodBeat.i(25058);
    this.qVL.setVisibility(4);
    kX(false);
    AppMethodBeat.o(25058);
  }
  
  public final void cne()
  {
    boolean bool1 = true;
    AppMethodBeat.i(25045);
    ab.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[] { this.qVU, Boolean.valueOf(this.qVR), Boolean.valueOf(this.mIsPlaying) });
    if (!this.qVL.isPlaying()) {
      this.qVR = true;
    }
    boolean bool2 = this.qVR;
    this.qVL.bm(this.qVU, bool2);
    if (!this.qVR)
    {
      kX(false);
      this.mIsPlaying = true;
      if (this.qVR) {
        break label122;
      }
    }
    for (;;)
    {
      this.qVR = bool1;
      AppMethodBeat.o(25045);
      return;
      kX(true);
      break;
      label122:
      bool1 = false;
    }
  }
  
  public final void cnf()
  {
    AppMethodBeat.i(25055);
    this.qVP.setVisibility(8);
    AppMethodBeat.o(25055);
  }
  
  public final void cnh()
  {
    AppMethodBeat.i(25050);
    if (this.qVQ == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MainSightContainerView", "do send to friend, loadingDialog null %B", new Object[] { Boolean.valueOf(bool) });
      if ((!bo.isNullOrNil(this.qVU)) && (!this.qVK.cnr())) {
        break;
      }
      AppMethodBeat.o(25050);
      return;
    }
    Object localObject1 = this.qVK.getSelectedContact();
    com.tencent.mm.plugin.report.service.h.qsU.e(11443, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(((List)localObject1).size()) });
    Object localObject2 = new MainSightForwardContainerView.6(this, (List)localObject1);
    com.tencent.mm.plugin.sight.encode.a.b localb;
    String str1;
    int i;
    String str2;
    String str3;
    if (((List)localObject1).size() == 1)
    {
      localb = this.qVW;
      str1 = this.qVU;
      i = this.mDuration;
      str2 = this.qVS;
      str3 = (String)((List)localObject1).get(0);
      if (bo.isNullOrNil(str1))
      {
        ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
        com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
        if ((this.qVK.getSelectedContact().size() > 1) || (this.qVM == null)) {
          break label869;
        }
        localObject2 = (String)this.qVK.getSelectedContact().get(0);
        this.qVM.startChattingUI((String)localObject2);
      }
    }
    label869:
    for (bool = false;; bool = true) {
      for (;;)
      {
        if (this.jdB != null) {
          localObject2 = this.jdB.getAssets();
        }
        try
        {
          localObject2 = ((AssetManager)localObject2).openFd("sight_send_song.wav");
          this.qWb = new k();
          this.qWb.setDataSource(((AssetFileDescriptor)localObject2).getFileDescriptor(), ((AssetFileDescriptor)localObject2).getStartOffset(), ((AssetFileDescriptor)localObject2).getLength());
          ((AssetFileDescriptor)localObject2).close();
          this.qWb.setOnCompletionListener(new MainSightForwardContainerView.7(this));
          this.qWb.setLooping(false);
          this.qWb.prepare();
          this.qWb.start();
          kW(bool);
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext()) {
              if (((String)((Iterator)localObject1).next()).toLowerCase().endsWith("@chatroom"))
              {
                com.tencent.mm.plugin.report.service.h.qsU.e(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                continue;
                if (bo.isNullOrNil(str3))
                {
                  ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!e.cN(str1)) || (e.cM(str1) <= 0))
                {
                  ab.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.bO(ah.getContext(), ah.getContext().getString(2131303682));
                  break;
                }
                String str4 = com.tencent.mm.a.g.getMD5(str1);
                ab.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str4 });
                if (!bo.bf(str2, "").equals(str4))
                {
                  ab.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.g.RM();
                if (com.tencent.mm.kernel.g.RO().ac(new b.3(localb, str3, (b.a)localObject2, str1, i)) >= 0) {
                  break;
                }
                ab.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                break;
                localb = this.qVW;
                str1 = this.qVU;
                i = this.mDuration;
                str2 = this.qVS;
                if (bo.isNullOrNil(str1))
                {
                  ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((localObject1 == null) || (((List)localObject1).isEmpty()))
                {
                  ab.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                if ((!e.cN(str1)) || (e.cM(str1) <= 0))
                {
                  ab.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                  com.tencent.mm.ui.base.h.bO(ah.getContext(), ah.getContext().getString(2131303682));
                  break;
                }
                str3 = com.tencent.mm.a.g.getMD5(str1);
                ab.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[] { str2, str3 });
                if (!bo.bf(str2, "").equals(str3))
                {
                  ab.e("MicroMsg.SightRecorderHelper", "error md5, return");
                  com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
                  break;
                }
                com.tencent.mm.kernel.g.RM();
                if (com.tencent.mm.kernel.g.RO().ac(new b.4(localb, str1, (List)localObject1, str2, (b.a)localObject2, i)) >= 0) {
                  break;
                }
                ab.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                com.tencent.mm.plugin.sight.encode.a.b.a((b.a)localObject2, -1);
              }
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MainSightContainerView", localIOException, "", new Object[0]);
            continue;
            com.tencent.mm.plugin.report.service.h.qsU.e(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
          }
          AppMethodBeat.o(25050);
          return;
        }
      }
    }
  }
  
  public int getViewHeight()
  {
    AppMethodBeat.i(25059);
    int i = getHeight();
    if (i <= 0)
    {
      i = getResources().getDisplayMetrics().heightPixels;
      AppMethodBeat.o(25059);
      return i;
    }
    AppMethodBeat.o(25059);
    return i;
  }
  
  public final void kV(boolean paramBoolean)
  {
    AppMethodBeat.i(25056);
    if (paramBoolean)
    {
      this.qVP.setVisibility(0);
      setIsMute(true);
      AppMethodBeat.o(25056);
      return;
    }
    cnf();
    setIsMute(DP());
    AppMethodBeat.o(25056);
  }
  
  public final void kW(boolean paramBoolean)
  {
    AppMethodBeat.i(25047);
    if (this.qVT)
    {
      AppMethodBeat.o(25047);
      return;
    }
    this.qVT = true;
    bo.hideVKB(this);
    this.mIsPlaying = false;
    this.qVR = true;
    ab.d("MicroMsg.MainSightContainerView", "dismiss sight view");
    this.qVY = false;
    this.qVL.cns();
    if ((this.qVM != null) && (paramBoolean)) {
      this.qVM.cng();
    }
    if (this.qVK != null)
    {
      MainSightSelectContactView localMainSightSelectContactView = this.qVK;
      localMainSightSelectContactView.qVT = true;
      bo.hideVKB(localMainSightSelectContactView);
      localMainSightSelectContactView.qWx.cnn();
      localMainSightSelectContactView.qWH.clear();
      localMainSightSelectContactView.qWG.clear();
      localMainSightSelectContactView.mListView.setAdapter(null);
      localMainSightSelectContactView.mListView.clearAnimation();
      localMainSightSelectContactView.setVisibility(8);
    }
    setCameraShadowAlpha(0.85F);
    cnf();
    kX(false);
    this.qVS = "";
    removeListener();
    AppMethodBeat.o(25047);
  }
  
  public final void kX(boolean paramBoolean)
  {
    AppMethodBeat.i(25048);
    if (this.qVX == paramBoolean)
    {
      AppMethodBeat.o(25048);
      return;
    }
    this.qVX = paramBoolean;
    if (paramBoolean)
    {
      if (this.qVO.getVisibility() == 0)
      {
        AppMethodBeat.o(25048);
        return;
      }
      this.qVL.postDelayed(new MainSightForwardContainerView.4(this), 100L);
      AppMethodBeat.o(25048);
      return;
    }
    this.qVO.setVisibility(8);
    this.ouI.setVisibility(8);
    AppMethodBeat.o(25048);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25049);
    paramInt -= 1;
    if ((MainSightSelectContactView.Dw(paramInt)) && (this.mIsPlaying))
    {
      cne();
      AppMethodBeat.o(25049);
      return;
    }
    if (c.Zr(this.qVK.mS(paramInt)))
    {
      this.qVK.qWx.cnl();
      AppMethodBeat.o(25049);
      return;
    }
    if (c.Zq(this.qVK.mS(paramInt)))
    {
      if (c.qWh)
      {
        this.qVY = true;
        this.qVL.cns();
        paramAdapterView = this.jdB;
        paramView = com.tencent.mm.plugin.sight.base.d.TW(this.qVU);
        String str1 = this.qVU;
        String str2 = this.qVS;
        ab.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[] { str1, paramView });
        Object localObject;
        if (!e.cN(paramView)) {
          localObject = com.tencent.mm.plugin.sight.base.d.as(str1, 320, 240);
        }
        try
        {
          com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, 60, Bitmap.CompressFormat.JPEG, paramView, true);
          localObject = new Intent();
          ((Intent)localObject).putExtra("KSightPath", str1);
          ((Intent)localObject).putExtra("KSightThumbPath", paramView);
          ((Intent)localObject).putExtra("sight_md5", str2);
          ((Intent)localObject).putExtra("KSightDraftEntrance", false);
          ((Intent)localObject).putExtra("Ksnsupload_source", 0);
          ((Intent)localObject).putExtra("KSnsPostManu", true);
          ((Intent)localObject).putExtra("KTouchCameraTime", bo.aox());
          com.tencent.mm.bq.d.b(paramAdapterView, "sns", ".ui.SightUploadUI", (Intent)localObject, 5985);
          if (this.qWa)
          {
            com.tencent.mm.plugin.report.service.h.qsU.e(11442, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
            AppMethodBeat.o(25049);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
            ab.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(11442, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        }
      }
      AppMethodBeat.o(25049);
      return;
    }
    ab.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[] { Integer.valueOf(paramInt) });
    paramAdapterView = this.qVK;
    label444:
    boolean bool;
    if ((paramInt < 0) || (paramInt > paramAdapterView.qWz.getCount()))
    {
      paramAdapterView = this.qVK;
      if (paramAdapterView.qWz != null) {
        paramAdapterView.qWz.notifyDataSetChanged();
      }
      if (DP()) {
        break label598;
      }
      cne();
      if (this.qVK.qWx.cnk())
      {
        paramAdapterView = this.qVK;
        if (paramAdapterView.qWz.Qt(paramInt) != null) {
          break label685;
        }
        bool = false;
      }
    }
    for (;;)
    {
      if (bool) {
        this.qVK.qWx.cnl();
      }
      AppMethodBeat.o(25049);
      return;
      paramView = paramAdapterView.qWz.Qt(paramInt);
      if (paramView == null) {
        break;
      }
      if (paramAdapterView.qWH.contains(paramView.contact.field_username))
      {
        paramAdapterView.qWH.remove(paramView.contact.field_username);
        label543:
        c.qWh = paramAdapterView.qWH.isEmpty();
        if (paramAdapterView.qWH.isEmpty()) {
          break label592;
        }
      }
      label592:
      for (bool = true;; bool = false)
      {
        c.qWi = bool;
        break;
        paramAdapterView.qWH.add(paramView.contact.field_username);
        break label543;
      }
      label598:
      if (this.qVK.cnr())
      {
        if (this.ouI.getVisibility() != 0) {
          break label444;
        }
        this.ouI.setVisibility(8);
        this.ouI.startAnimation(AnimationUtils.loadAnimation(this.jdB, 2131034182));
        break label444;
      }
      if (this.ouI.getVisibility() == 0) {
        break label444;
      }
      this.ouI.setVisibility(0);
      this.ouI.startAnimation(AnimationUtils.loadAnimation(this.jdB, 2131034181));
      break label444;
      label685:
      if (paramAdapterView.qWz.Qt(paramInt).contact == null) {
        bool = false;
      } else {
        bool = paramAdapterView.qWH.contains(paramAdapterView.qWz.Qt(paramInt).contact.field_username);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(25053);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (!this.qVT) && (this.qVK != null))
    {
      ab.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.qVK.cnq();
    }
    AppMethodBeat.o(25053);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(25051);
    if (this.qVY)
    {
      AppMethodBeat.o(25051);
      return;
    }
    this.qVL.setVisibility(0);
    kX(false);
    this.qVL.cns();
    this.mIsPause = true;
    AppMethodBeat.o(25051);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(25052);
    int i;
    if (!this.qVT)
    {
      i = 1;
      if (i == 0) {
        break label69;
      }
      com.tencent.mm.sdk.b.a.ymk.d(this.qVZ);
      com.tencent.mm.sdk.b.a.ymk.c(this.qVZ);
    }
    for (;;)
    {
      if (this.mIsPause)
      {
        cne();
        this.mIsPause = false;
      }
      AppMethodBeat.o(25052);
      return;
      i = 0;
      break;
      label69:
      removeListener();
    }
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(25044);
    com.tencent.mm.sdk.b.a.ymk.d(this.qVZ);
    AppMethodBeat.o(25044);
  }
  
  @TargetApi(11)
  public void setCameraShadowAlpha(float paramFloat)
  {
    AppMethodBeat.i(25054);
    paramFloat = Math.min(1.0F, Math.max(0.0F, paramFloat));
    if (com.tencent.mm.compatible.util.d.fv(11)) {
      this.qVN.setAlpha(paramFloat);
    }
    for (;;)
    {
      ab.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[] { Float.valueOf(paramFloat) });
      if (paramFloat > 0.0F) {
        break;
      }
      this.qVN.setVisibility(8);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      this.qVN.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(25054);
      return;
      localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
      localAlphaAnimation.setDuration(0L);
      localAlphaAnimation.setFillAfter(true);
      this.qVN.startAnimation(localAlphaAnimation);
    }
    this.qVN.setVisibility(0);
    AppMethodBeat.o(25054);
  }
  
  public void setIMainSightViewCallback(b paramb)
  {
    this.qVM = paramb;
  }
  
  public void setIsForSns(boolean paramBoolean)
  {
    this.qWa = paramBoolean;
  }
  
  public void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(25046);
    if (this.qVL == null)
    {
      AppMethodBeat.o(25046);
      return;
    }
    this.qVL.setIsMute(paramBoolean);
    AppMethodBeat.o(25046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView
 * JD-Core Version:    0.7.0.1
 */