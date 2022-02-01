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
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.modelvideo.x.a.a;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class m
  extends a
  implements d.a, x.a, MTimerHandler.CallBack
{
  private HashMap<String, n.a> WSS;
  private boolean WST;
  private d sUi;
  
  public m(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(36090);
    this.WST = false;
    this.WST = false;
    this.WSS = new HashMap();
    s.bqB().a(this, Looper.getMainLooper());
    this.sUi = d.bcs();
    AppMethodBeat.o(36090);
  }
  
  private void a(com.tencent.mm.modelvideo.w paramw, p paramp)
  {
    AppMethodBeat.i(36094);
    if (paramw == null)
    {
      AppMethodBeat.o(36094);
      return;
    }
    y.Yh(paramw.getFileName());
    paramp.hSK().WVG.setVisibility(0);
    paramp.hSK().WVG.setProgress(y.g(paramw));
    s.bqB().a(this, Looper.getMainLooper());
    AppMethodBeat.o(36094);
  }
  
  private static void a(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(36096);
    if (paramp == null)
    {
      AppMethodBeat.o(36096);
      return;
    }
    paramp.hSK().WVG.setVisibility(8);
    if (paramBoolean)
    {
      paramp.hSK().WVE.setVisibility(8);
      ((View)paramp.hSK().WVD).setVisibility(0);
      AppMethodBeat.o(36096);
      return;
    }
    paramp.hSK().WVE.setVisibility(0);
    ((View)paramp.hSK().WVD).setVisibility(8);
    AppMethodBeat.o(36096);
  }
  
  private boolean a(n.a parama)
  {
    AppMethodBeat.i(36098);
    if (parama == null)
    {
      AppMethodBeat.o(36098);
      return false;
    }
    s.bqB().a(this);
    if (this.WQM.WQV.getCurrentItem() == parama.pos)
    {
      parama = avN(parama.pos);
      if (parama != null) {
        parama.hSK().WVG.setVisibility(8);
      }
      AppMethodBeat.o(36098);
      return true;
    }
    this.WQM.avX(parama.pos);
    AppMethodBeat.o(36098);
    return false;
  }
  
  private void b(ca paramca, final p paramp)
  {
    AppMethodBeat.i(36095);
    if (this.WST)
    {
      AppMethodBeat.o(36095);
      return;
    }
    paramp.hSK().WVH.setVisibility(8);
    s.bqB();
    String str = com.tencent.mm.modelvideo.x.XT(paramca.field_imgPath);
    if (paramca.Ic())
    {
      Toast.makeText(this.WQM.WQV, R.l.eUF, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    if ((str == null) || (!com.tencent.mm.vfs.u.agG(str)))
    {
      Toast.makeText(this.WQM.WQV, R.l.eUF, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    this.WQM.WQV.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramp.WVB.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramp.hSK().WVD).setTag(str);
      paramp.hSK().WVF.setVisibility(8);
      paramp.hSK().WVD.stop();
      if (this.WQM.WQV.Wc(paramca.field_msgId) != 3) {
        break label383;
      }
      paramp.hSK().WVD.setMute(true);
      if ((paramp.hSK().WVD instanceof VideoSightView)) {
        ((VideoSightView)paramp.hSK().WVD).setIsAdVideo(f.cO(paramca));
      }
      paramp.hSK().WVD.setVideoPath(str);
      if (paramp.hSK().WVD.I(this.WQM.WQV.getContext(), false)) {
        break label399;
      }
      paramp.hSK().WVF.setVisibility(0);
      paramp.hSK().WVF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36089);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramp.hSK().WVD.I(m.this.WQM.WQV.getContext(), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36089);
        }
      });
      ((View)paramp.hSK().WVD).setVisibility(8);
      paramp.hSK().WVE.setVisibility(0);
    }
    for (;;)
    {
      Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.sUi.a(this);
      ((View)paramp.hSK().WVD).setVisibility(0);
      AppMethodBeat.o(36095);
      return;
      label383:
      paramp.hSK().WVD.setMute(false);
      break;
      label399:
      ((View)paramp.hSK().WVD).setVisibility(0);
      paramp.hSK().WVE.setVisibility(8);
    }
  }
  
  public final void a(x.a.a parama)
  {
    AppMethodBeat.i(36100);
    Object localObject = parama.fileName;
    if ((Util.isNullOrNil((String)localObject)) || (this.WSS == null))
    {
      AppMethodBeat.o(36100);
      return;
    }
    parama = (n.a)this.WSS.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    ca localca = parama.fvt;
    if ((localca == null) || (localca.field_imgPath == null) || (!localca.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36100);
      return;
    }
    localObject = y.Yk(localca.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    if ((localca.Ic()) || (((com.tencent.mm.modelvideo.w)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.WQM.WQV, R.l.eUF, 0).show();
      }
      AppMethodBeat.o(36100);
      return;
    }
    int i = y.g((com.tencent.mm.modelvideo.w)localObject);
    localObject = avN(parama.pos);
    if ((this.WQM.WQV.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((p)localObject).hSK().WVG.setVisibility(0);
      ((p)localObject).hSK().WVG.setProgress(i);
    }
    while (i < ((p)localObject).hSL().WVG.getMax())
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
      b(localca, (p)localObject);
    }
    AppMethodBeat.o(36100);
  }
  
  public final boolean a(p paramp, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36091);
    super.a(paramp, paramca, paramInt);
    s.bqB();
    Object localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(com.tencent.mm.modelvideo.x.XU(paramca.field_imgPath), 1.0F);
    if (this.WSS != null) {
      this.WSS.put(paramca.field_imgPath, new n.a(paramca, paramInt));
    }
    a(paramp, false);
    ((View)paramp.hSK().WVD).setVisibility(8);
    paramp.hSK().WVE.setImageBitmap((Bitmap)localObject1);
    paramp.hSK().WVE.setVisibility(0);
    paramp.hSK().WVH.setVisibility(8);
    localObject1 = y.Yk(paramca.field_imgPath);
    paramp.WVH.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramp.wOf.setVisibility(8);
    }
    for (;;)
    {
      if ((paramp.hSK().WVD instanceof VideoSightView)) {
        com.tencent.mm.pluginsdk.ui.tools.w.a(paramp.wOf, (VideoSightView)paramp.hSK().WVD);
      }
      AppMethodBeat.o(36091);
      return true;
      localObject2 = ((com.tencent.mm.modelvideo.w)localObject1).mhZ;
      break;
      label202:
      if (Util.isNullOrNil(((eor)localObject2).lor))
      {
        Log.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((eor)localObject2).lou;
        localObject2 = ((eor)localObject2).lov;
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          paramp.wOf.setText((CharSequence)localObject1);
          paramp.wOf.setVisibility(0);
          paramp.wOf.setTag(paramca);
        }
        else
        {
          paramp.wOf.setVisibility(8);
        }
      }
      else
      {
        paramp.wOf.setVisibility(0);
        paramp.wOf.setText(this.WQM.WQV.getString(R.l.sns_ad_sight_full, new Object[] { Integer.valueOf(((eor)localObject2).SAk) }));
        Object localObject3 = this.WQM.WQV.getString(R.l.sns_ad_sight_full);
        localObject1 = localObject3;
        if (((eor)localObject2).SAk / 60 > 0) {
          localObject1 = (String)localObject3 + this.WQM.WQV.getString(R.l.sns_ad_sight_full_m, new Object[] { Integer.valueOf(((eor)localObject2).SAk / 60) });
        }
        localObject3 = localObject1;
        if (((eor)localObject2).SAk % 60 > 0) {
          localObject3 = (String)localObject1 + this.WQM.WQV.getString(R.l.sns_ad_sight_full_s, new Object[] { Integer.valueOf(((eor)localObject2).SAk % 60) });
        }
        localObject1 = (String)localObject3 + this.WQM.WQV.getString(R.l.sns_ad_sight_full_end);
        paramp.wOf.setText((CharSequence)localObject1);
        paramp.wOf.setTag(paramca);
      }
    }
  }
  
  public final void awe(int paramInt)
  {
    AppMethodBeat.i(36093);
    ca localca = this.WQM.avt(paramInt);
    p localp = avN(paramInt);
    if ((localca == null) || (localp == null))
    {
      AppMethodBeat.o(36093);
      return;
    }
    com.tencent.mm.modelvideo.w localw = y.Yk(localca.field_imgPath);
    if (localw != null)
    {
      if (localca.field_isSend == 0)
      {
        if ((localw.status == 113) || (localw.status == 111) || (localw.status == 112))
        {
          a(localw, localp);
          AppMethodBeat.o(36093);
          return;
        }
        if (localw.status == 198)
        {
          a(localw, localp);
          AppMethodBeat.o(36093);
          return;
        }
      }
      b(localca, localp);
    }
    AppMethodBeat.o(36093);
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void detach()
  {
    AppMethodBeat.i(36099);
    stopAll();
    this.WQM.WQV.getContext().getWindow().clearFlags(128);
    this.WST = true;
    super.detach();
    this.WSS.clear();
    this.WSS = null;
    s.bqB().a(this);
    Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.sUi.fZ(true);
    AppMethodBeat.o(36099);
  }
  
  public final u hRD()
  {
    AppMethodBeat.i(291644);
    Object localObject = this.WQM.hRF();
    if (localObject == null)
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(291644);
      return null;
    }
    if (((ca)localObject).Ic())
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is cleaned");
      localObject = u.WWI;
      AppMethodBeat.o(291644);
      return localObject;
    }
    localObject = y.Yk(((et)localObject).field_imgPath);
    if ((localObject == null) || (((com.tencent.mm.modelvideo.w)localObject).status == 198))
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, videoInfo is null or failed");
      localObject = u.WWI;
      AppMethodBeat.o(291644);
      return localObject;
    }
    if (((com.tencent.mm.modelvideo.w)localObject).bqS())
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, downloaded");
      localObject = u.WWK;
      AppMethodBeat.o(291644);
      return localObject;
    }
    Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, not downloaded");
    localObject = u.WWJ;
    AppMethodBeat.o(291644);
    return localObject;
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(36097);
    if (this.WQM == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    p localp = this.WQM.hRG();
    if (localp == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localp.WVC == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localp.hSK().WVC.getVisibility() != 0)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    a(localp, true);
    AppMethodBeat.o(36097);
    return false;
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(36092);
    SparseArray localSparseArray = this.WQM.WnN;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        p localp = (p)((View)localSparseArray.get(j)).getTag();
        if ((localp.WVC != null) && (localp.hSK().WVC.getVisibility() == 0))
        {
          localp.hSK().WVD.setVideoCallback(null);
          if ((((View)localp.hSK().WVD).getVisibility() == 0) && (localp != null))
          {
            a(localp, false);
            if (localp.hSK().WVD != null) {
              localp.hSK().WVD.stop();
            }
            Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.sUi.fZ(false);
            this.WQM.WQV.getContext().getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(36092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m
 * JD-Core Version:    0.7.0.1
 */