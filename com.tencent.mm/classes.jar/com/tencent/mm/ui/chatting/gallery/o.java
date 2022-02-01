package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.a;
import com.tencent.mm.modelvideo.aa.a.a;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.y;
import java.util.HashMap;

public final class o
  extends a
  implements d.a, aa.a, MTimerHandler.CallBack
{
  private HashMap<String, p.a> aeCv;
  private boolean aeCw;
  private d vZw;
  
  public o(h paramh)
  {
    super(paramh);
    AppMethodBeat.i(36090);
    this.aeCw = false;
    this.aeCw = false;
    this.aeCv = new HashMap();
    com.tencent.mm.modelvideo.v.bOh().a(this, Looper.getMainLooper());
    this.vZw = new d();
    AppMethodBeat.o(36090);
  }
  
  private void a(z paramz, r paramr)
  {
    AppMethodBeat.i(36094);
    if (paramz == null)
    {
      AppMethodBeat.o(36094);
      return;
    }
    com.tencent.mm.modelvideo.ab.Ql(paramz.getFileName());
    paramr.jwp().aeFm.setVisibility(0);
    paramr.jwp().aeFm.setProgress(com.tencent.mm.modelvideo.ab.g(paramz));
    com.tencent.mm.modelvideo.v.bOh().a(this, Looper.getMainLooper());
    AppMethodBeat.o(36094);
  }
  
  private static void a(r paramr, boolean paramBoolean)
  {
    AppMethodBeat.i(36096);
    if (paramr == null)
    {
      AppMethodBeat.o(36096);
      return;
    }
    paramr.jwp().aeFm.setVisibility(8);
    if (paramBoolean)
    {
      paramr.jwp().aeFk.setVisibility(8);
      ((View)paramr.jwp().aeFj).setVisibility(0);
      AppMethodBeat.o(36096);
      return;
    }
    paramr.jwp().aeFk.setVisibility(0);
    ((View)paramr.jwp().aeFj).setVisibility(8);
    AppMethodBeat.o(36096);
  }
  
  private boolean a(p.a parama)
  {
    AppMethodBeat.i(36098);
    if (parama == null)
    {
      AppMethodBeat.o(36098);
      return false;
    }
    com.tencent.mm.modelvideo.v.bOh().a(this);
    if (this.aeAg.aeAB.getCurrentItem() == parama.pos)
    {
      parama = aCt(parama.pos);
      if (parama != null) {
        parama.jwp().aeFm.setVisibility(8);
      }
      AppMethodBeat.o(36098);
      return true;
    }
    this.aeAg.aCG(parama.pos);
    AppMethodBeat.o(36098);
    return false;
  }
  
  private void b(cc paramcc, final r paramr)
  {
    AppMethodBeat.i(36095);
    if (this.aeCw)
    {
      AppMethodBeat.o(36095);
      return;
    }
    paramr.jwp().aeFn.setVisibility(8);
    com.tencent.mm.modelvideo.v.bOh();
    String str = aa.PX(paramcc.field_imgPath);
    if (paramcc.isClean())
    {
      Toast.makeText(this.aeAg.aeAB, R.l.gXE, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    if ((str == null) || (!y.ZC(str)))
    {
      Toast.makeText(this.aeAg.aeAB, R.l.gXE, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    this.aeAg.aeAB.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramr.aeFh.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramr.jwp().aeFj).setTag(str);
      paramr.jwp().aeFl.setVisibility(8);
      paramr.jwp().aeFj.stop();
      if (this.aeAg.aeAB.An(paramcc.field_msgId) != 3) {
        break label383;
      }
      paramr.jwp().aeFj.setMute(true);
      if ((paramr.jwp().aeFj instanceof VideoSightView)) {
        ((VideoSightView)paramr.jwp().aeFj).setIsAdVideo(h.dl(paramcc));
      }
      paramr.jwp().aeFj.setVideoPath(str);
      if (paramr.jwp().aeFj.P(this.aeAg.aeAB.getContext(), false)) {
        break label399;
      }
      paramr.jwp().aeFl.setVisibility(0);
      paramr.jwp().aeFl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36089);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramr.jwp().aeFj.P(o.this.aeAg.aeAB.getContext(), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36089);
        }
      });
      ((View)paramr.jwp().aeFj).setVisibility(8);
      paramr.jwp().aeFk.setVisibility(0);
    }
    for (;;)
    {
      Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.vZw.a(this);
      ((View)paramr.jwp().aeFj).setVisibility(0);
      AppMethodBeat.o(36095);
      return;
      label383:
      paramr.jwp().aeFj.setMute(false);
      break;
      label399:
      ((View)paramr.jwp().aeFj).setVisibility(0);
      paramr.jwp().aeFk.setVisibility(8);
    }
  }
  
  public final void a(aa.a.a parama)
  {
    AppMethodBeat.i(36100);
    Object localObject = parama.fileName;
    if ((Util.isNullOrNil((String)localObject)) || (this.aeCv == null))
    {
      AppMethodBeat.o(36100);
      return;
    }
    parama = (p.a)this.aeCv.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    cc localcc = parama.hzO;
    if ((localcc == null) || (localcc.field_imgPath == null) || (!localcc.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36100);
      return;
    }
    localObject = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    if ((localcc.isClean()) || (((z)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.aeAg.aeAB, R.l.gXE, 0).show();
      }
      AppMethodBeat.o(36100);
      return;
    }
    int i = com.tencent.mm.modelvideo.ab.g((z)localObject);
    localObject = aCt(parama.pos);
    if ((this.aeAg.aeAB.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((r)localObject).jwp().aeFm.setVisibility(0);
      ((r)localObject).jwp().aeFm.setProgress(i);
    }
    while (i < ((r)localObject).jwq().aeFm.getMax())
    {
      AppMethodBeat.o(36100);
      return;
      if (localObject == null)
      {
        AppMethodBeat.o(36100);
        return;
      }
    }
    if (a(parama)) {
      b(localcc, (r)localObject);
    }
    AppMethodBeat.o(36100);
  }
  
  public final boolean a(r paramr, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(36091);
    super.a(paramr, paramcc, paramInt);
    com.tencent.mm.modelvideo.v.bOh();
    Object localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(aa.PY(paramcc.field_imgPath), 1.0F);
    if (this.aeCv != null) {
      this.aeCv.put(paramcc.field_imgPath, new p.a(paramcc, paramInt));
    }
    a(paramr, false);
    ((View)paramr.jwp().aeFj).setVisibility(8);
    paramr.jwp().aeFk.setImageBitmap((Bitmap)localObject1);
    paramr.jwp().aeFk.setVisibility(0);
    paramr.jwp().aeFn.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
    paramr.aeFn.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramr.AkH.setVisibility(8);
    }
    for (;;)
    {
      if ((paramr.jwp().aeFj instanceof VideoSightView)) {
        com.tencent.mm.pluginsdk.ui.tools.v.a(paramr.AkH, (VideoSightView)paramr.jwp().aeFj);
      }
      AppMethodBeat.o(36091);
      return true;
      localObject2 = ((z)localObject1).pbk;
      break;
      label202:
      if (Util.isNullOrNil(((fjp)localObject2).nTu))
      {
        Log.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((fjp)localObject2).nTx;
        localObject2 = ((fjp)localObject2).nTy;
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          paramr.AkH.setText((CharSequence)localObject1);
          paramr.AkH.setVisibility(0);
          paramr.AkH.setTag(paramcc);
        }
        else
        {
          paramr.AkH.setVisibility(8);
        }
      }
      else
      {
        paramr.AkH.setVisibility(0);
        paramr.AkH.setText(this.aeAg.aeAB.getString(R.l.sns_ad_sight_full, new Object[] { Integer.valueOf(((fjp)localObject2).ZBc) }));
        Object localObject3 = this.aeAg.aeAB.getString(R.l.sns_ad_sight_full);
        localObject1 = localObject3;
        if (((fjp)localObject2).ZBc / 60 > 0) {
          localObject1 = (String)localObject3 + this.aeAg.aeAB.getString(R.l.sns_ad_sight_full_m, new Object[] { Integer.valueOf(((fjp)localObject2).ZBc / 60) });
        }
        localObject3 = localObject1;
        if (((fjp)localObject2).ZBc % 60 > 0) {
          localObject3 = (String)localObject1 + this.aeAg.aeAB.getString(R.l.sns_ad_sight_full_s, new Object[] { Integer.valueOf(((fjp)localObject2).ZBc % 60) });
        }
        localObject1 = (String)localObject3 + this.aeAg.aeAB.getString(R.l.sns_ad_sight_full_end);
        paramr.AkH.setText((CharSequence)localObject1);
        paramr.AkH.setTag(paramcc);
      }
    }
  }
  
  public final void aCN(int paramInt)
  {
    AppMethodBeat.i(36093);
    cc localcc = this.aeAg.aBV(paramInt);
    r localr = aCt(paramInt);
    if ((localcc == null) || (localr == null))
    {
      AppMethodBeat.o(36093);
      return;
    }
    z localz = com.tencent.mm.modelvideo.ab.Qo(localcc.field_imgPath);
    if (localz != null)
    {
      if (localcc.field_isSend == 0)
      {
        if ((localz.status == 113) || (localz.status == 111) || (localz.status == 112))
        {
          a(localz, localr);
          AppMethodBeat.o(36093);
          return;
        }
        if (localz.status == 198)
        {
          a(localz, localr);
          AppMethodBeat.o(36093);
          return;
        }
      }
      b(localcc, localr);
    }
    AppMethodBeat.o(36093);
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final void detach()
  {
    AppMethodBeat.i(36099);
    stopAll();
    this.aeAg.aeAB.getContext().getWindow().clearFlags(128);
    this.aeCw = true;
    super.detach();
    this.aeCv.clear();
    this.aeCv = null;
    com.tencent.mm.modelvideo.v.bOh().a(this);
    Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.vZw.gR(true);
    AppMethodBeat.o(36099);
  }
  
  public final w jvb()
  {
    AppMethodBeat.i(254481);
    Object localObject = this.aeAg.jvd();
    if (localObject == null)
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(254481);
      return null;
    }
    if (((cc)localObject).isClean())
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is cleaned");
      localObject = w.aeGm;
      AppMethodBeat.o(254481);
      return localObject;
    }
    localObject = com.tencent.mm.modelvideo.ab.Qo(((fi)localObject).field_imgPath);
    if ((localObject == null) || (((z)localObject).status == 198))
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, videoInfo is null or failed");
      localObject = w.aeGm;
      AppMethodBeat.o(254481);
      return localObject;
    }
    if (((z)localObject).bOx())
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, downloaded");
      localObject = w.aeGo;
      AppMethodBeat.o(254481);
      return localObject;
    }
    Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, not downloaded");
    localObject = w.aeGn;
    AppMethodBeat.o(254481);
    return localObject;
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(36097);
    if (this.aeAg == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    r localr = this.aeAg.jve();
    if (localr == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localr.aeFi == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localr.jwp().aeFi.getVisibility() != 0)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    a(localr, true);
    AppMethodBeat.o(36097);
    return false;
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(36092);
    SparseArray localSparseArray = this.aeAg.adVc;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        r localr = (r)((View)localSparseArray.get(j)).getTag();
        if ((localr.aeFi != null) && (localr.jwp().aeFi.getVisibility() == 0))
        {
          localr.jwp().aeFj.setVideoCallback(null);
          if ((((View)localr.jwp().aeFj).getVisibility() == 0) && (localr != null))
          {
            a(localr, false);
            if (localr.jwp().aeFj != null) {
              localr.jwp().aeFj.stop();
            }
            Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.vZw.gR(false);
            this.aeAg.aeAB.getContext().getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(36092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.o
 * JD-Core Version:    0.7.0.1
 */