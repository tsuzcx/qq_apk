package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class i
  extends a
  implements d.a, t.a, MTimerHandler.CallBack
{
  private HashMap<String, j.a> Pyt;
  private boolean Pyu;
  private d pNk;
  
  public i(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36090);
    this.Pyu = false;
    this.Pyu = false;
    this.Pyt = new HashMap();
    o.bhj().a(this, Looper.getMainLooper());
    this.pNk = new d();
    AppMethodBeat.o(36090);
  }
  
  private void a(com.tencent.mm.modelvideo.s params, k paramk)
  {
    AppMethodBeat.i(36094);
    if (params == null)
    {
      AppMethodBeat.o(36094);
      return;
    }
    com.tencent.mm.modelvideo.u.QK(params.getFileName());
    paramk.gTd().PAJ.setVisibility(0);
    paramk.gTd().PAJ.setProgress(com.tencent.mm.modelvideo.u.g(params));
    o.bhj().a(this, Looper.getMainLooper());
    AppMethodBeat.o(36094);
  }
  
  private static void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(36096);
    if (paramk == null)
    {
      AppMethodBeat.o(36096);
      return;
    }
    paramk.gTd().PAJ.setVisibility(8);
    if (paramBoolean)
    {
      paramk.gTd().PAH.setVisibility(8);
      ((View)paramk.gTd().PAG).setVisibility(0);
      AppMethodBeat.o(36096);
      return;
    }
    paramk.gTd().PAH.setVisibility(0);
    ((View)paramk.gTd().PAG).setVisibility(8);
    AppMethodBeat.o(36096);
  }
  
  private boolean a(j.a parama)
  {
    AppMethodBeat.i(36098);
    if (parama == null)
    {
      AppMethodBeat.o(36098);
      return false;
    }
    o.bhj().a(this);
    if (this.Pwu.Pwv.getCurrentItem() == parama.pos)
    {
      parama = amM(parama.pos);
      if (parama != null) {
        parama.gTd().PAJ.setVisibility(8);
      }
      AppMethodBeat.o(36098);
      return true;
    }
    this.Pwu.amU(parama.pos);
    AppMethodBeat.o(36098);
    return false;
  }
  
  private void b(ca paramca, k paramk)
  {
    AppMethodBeat.i(36095);
    if (this.Pyu)
    {
      AppMethodBeat.o(36095);
      return;
    }
    paramk.gTd().PAK.setVisibility(8);
    o.bhj();
    String str = t.Qw(paramca.field_imgPath);
    if (paramca.gDB())
    {
      Toast.makeText(this.Pwu.Pwv, 2131767070, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    if ((str == null) || (!com.tencent.mm.vfs.s.YS(str)))
    {
      Toast.makeText(this.Pwu.Pwv, 2131767070, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    this.Pwu.Pwv.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramk.PAE.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramk.gTd().PAG).setTag(str);
      paramk.gTd().PAI.setVisibility(8);
      paramk.gTd().PAG.stop();
      if (this.Pwu.Pwv.NQ(paramca.field_msgId) != 3) {
        break label381;
      }
      paramk.gTd().PAG.setMute(true);
      if ((paramk.gTd().PAG instanceof VideoSightView)) {
        ((VideoSightView)paramk.gTd().PAG).setIsAdVideo(b.cs(paramca));
      }
      paramk.gTd().PAG.setVideoPath(str);
      if (paramk.gTd().PAG.E(this.Pwu.Pwv.getContext(), false)) {
        break label397;
      }
      paramk.gTd().PAI.setVisibility(0);
      paramk.gTd().PAI.setOnClickListener(new i.1(this, paramk));
      ((View)paramk.gTd().PAG).setVisibility(8);
      paramk.gTd().PAH.setVisibility(0);
    }
    for (;;)
    {
      Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.pNk.a(this);
      ((View)paramk.gTd().PAG).setVisibility(0);
      AppMethodBeat.o(36095);
      return;
      label381:
      paramk.gTd().PAG.setMute(false);
      break;
      label397:
      ((View)paramk.gTd().PAG).setVisibility(0);
      paramk.gTd().PAH.setVisibility(8);
    }
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36100);
    Object localObject = parama.fileName;
    if ((Util.isNullOrNil((String)localObject)) || (this.Pyt == null))
    {
      AppMethodBeat.o(36100);
      return;
    }
    parama = (j.a)this.Pyt.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    ca localca = parama.dCM;
    if ((localca == null) || (localca.field_imgPath == null) || (!localca.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36100);
      return;
    }
    localObject = com.tencent.mm.modelvideo.u.QN(localca.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    if ((localca.gDB()) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.Pwu.Pwv, 2131767070, 0).show();
      }
      AppMethodBeat.o(36100);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((com.tencent.mm.modelvideo.s)localObject);
    localObject = amM(parama.pos);
    if ((this.Pwu.Pwv.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((k)localObject).gTd().PAJ.setVisibility(0);
      ((k)localObject).gTd().PAJ.setProgress(i);
    }
    while (i < ((k)localObject).gTe().PAJ.getMax())
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
      b(localca, (k)localObject);
    }
    AppMethodBeat.o(36100);
  }
  
  public final boolean a(k paramk, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36091);
    super.a(paramk, paramca, paramInt);
    o.bhj();
    Object localObject1 = BackwardSupportUtil.BitmapFactory.decodeFile(t.Qx(paramca.field_imgPath), 1.0F);
    if (this.Pyt != null) {
      this.Pyt.put(paramca.field_imgPath, new j.a(paramca, paramInt));
    }
    a(paramk, false);
    ((View)paramk.gTd().PAG).setVisibility(8);
    paramk.gTd().PAH.setImageBitmap((Bitmap)localObject1);
    paramk.gTd().PAH.setVisibility(0);
    paramk.gTd().PAK.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    paramk.PAK.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramk.thO.setVisibility(8);
    }
    for (;;)
    {
      if ((paramk.gTd().PAG instanceof VideoSightView)) {
        com.tencent.mm.pluginsdk.ui.tools.u.a(paramk.thO, (VideoSightView)paramk.gTd().PAG);
      }
      AppMethodBeat.o(36091);
      return true;
      localObject2 = ((com.tencent.mm.modelvideo.s)localObject1).jsw;
      break;
      label202:
      if (Util.isNullOrNil(((eeq)localObject2).iyZ))
      {
        Log.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((eeq)localObject2).izc;
        localObject2 = ((eeq)localObject2).izd;
        if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
        {
          paramk.thO.setText((CharSequence)localObject1);
          paramk.thO.setVisibility(0);
          paramk.thO.setTag(paramca);
        }
        else
        {
          paramk.thO.setVisibility(8);
        }
      }
      else
      {
        paramk.thO.setVisibility(0);
        paramk.thO.setText(this.Pwu.Pwv.getString(2131765980, new Object[] { Integer.valueOf(((eeq)localObject2).LxJ) }));
        Object localObject3 = this.Pwu.Pwv.getString(2131765980);
        localObject1 = localObject3;
        if (((eeq)localObject2).LxJ / 60 > 0) {
          localObject1 = (String)localObject3 + this.Pwu.Pwv.getString(2131765982, new Object[] { Integer.valueOf(((eeq)localObject2).LxJ / 60) });
        }
        localObject3 = localObject1;
        if (((eeq)localObject2).LxJ % 60 > 0) {
          localObject3 = (String)localObject1 + this.Pwu.Pwv.getString(2131765983, new Object[] { Integer.valueOf(((eeq)localObject2).LxJ % 60) });
        }
        localObject1 = (String)localObject3 + this.Pwu.Pwv.getString(2131765981);
        paramk.thO.setText((CharSequence)localObject1);
        paramk.thO.setTag(paramca);
      }
    }
  }
  
  public final void aTw() {}
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final void aTz() {}
  
  public final void anb(int paramInt)
  {
    AppMethodBeat.i(36093);
    ca localca = this.Pwu.amt(paramInt);
    k localk = amM(paramInt);
    if ((localca == null) || (localk == null))
    {
      AppMethodBeat.o(36093);
      return;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(localca.field_imgPath);
    if (locals != null)
    {
      if (localca.field_isSend == 0)
      {
        if ((locals.status == 113) || (locals.status == 111) || (locals.status == 112))
        {
          a(locals, localk);
          AppMethodBeat.o(36093);
          return;
        }
        if (locals.status == 198)
        {
          a(locals, localk);
          AppMethodBeat.o(36093);
          return;
        }
      }
      b(localca, localk);
    }
    AppMethodBeat.o(36093);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36099);
    stopAll();
    this.Pwu.Pwv.getContext().getWindow().clearFlags(128);
    this.Pyu = true;
    super.detach();
    this.Pyt.clear();
    this.Pyt = null;
    o.bhj().a(this);
    Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.pNk.fp(true);
    AppMethodBeat.o(36099);
  }
  
  public final p gSe()
  {
    AppMethodBeat.i(233298);
    Object localObject = this.Pwu.gSg();
    if (localObject == null)
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(233298);
      return null;
    }
    if (((ca)localObject).gDB())
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is cleaned");
      localObject = p.PBM;
      AppMethodBeat.o(233298);
      return localObject;
    }
    localObject = com.tencent.mm.modelvideo.u.QN(((eo)localObject).field_imgPath);
    if ((localObject == null) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, videoInfo is null or failed");
      localObject = p.PBM;
      AppMethodBeat.o(233298);
      return localObject;
    }
    if (((com.tencent.mm.modelvideo.s)localObject).bhy())
    {
      Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, downloaded");
      localObject = p.PBO;
      AppMethodBeat.o(233298);
      return localObject;
    }
    Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, not downloaded");
    localObject = p.PBN;
    AppMethodBeat.o(233298);
    return localObject;
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(36097);
    if (this.Pwu == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    k localk = this.Pwu.gSh();
    if (localk == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.PAF == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.gTd().PAF.getVisibility() != 0)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    a(localk, true);
    AppMethodBeat.o(36097);
    return false;
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(36092);
    SparseArray localSparseArray = this.Pwu.OUA;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        k localk = (k)((View)localSparseArray.get(j)).getTag();
        if ((localk.PAF != null) && (localk.gTd().PAF.getVisibility() == 0))
        {
          localk.gTd().PAG.setVideoCallback(null);
          if ((((View)localk.gTd().PAG).getVisibility() == 0) && (localk != null))
          {
            a(localk, false);
            if (localk.gTd().PAG != null) {
              localk.gTd().PAG.stop();
            }
            Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.pNk.fp(false);
            this.Pwu.Pwv.getContext().getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(36092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i
 * JD-Core Version:    0.7.0.1
 */