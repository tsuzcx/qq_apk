package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class i
  extends a
  implements d.a, t.a, au.a
{
  private HashMap<String, j.a> IbT;
  private boolean IbU;
  private d nQt;
  
  public i(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36090);
    this.IbU = false;
    this.IbU = false;
    this.IbT = new HashMap();
    o.aJy().a(this, Looper.getMainLooper());
    this.nQt = new d();
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
    com.tencent.mm.modelvideo.u.Eg(params.getFileName());
    paramk.fpR().IdF.setVisibility(0);
    paramk.fpR().IdF.setProgress(com.tencent.mm.modelvideo.u.g(params));
    o.aJy().a(this, Looper.getMainLooper());
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
    paramk.fpR().IdF.setVisibility(8);
    if (paramBoolean)
    {
      paramk.fpR().IdD.setVisibility(8);
      ((View)paramk.fpR().IdC).setVisibility(0);
      AppMethodBeat.o(36096);
      return;
    }
    paramk.fpR().IdD.setVisibility(0);
    ((View)paramk.fpR().IdC).setVisibility(8);
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
    o.aJy().a(this);
    if (this.HZU.HZV.getCurrentItem() == parama.pos)
    {
      parama = abi(parama.pos);
      if (parama != null) {
        parama.fpR().IdF.setVisibility(8);
      }
      AppMethodBeat.o(36098);
      return true;
    }
    this.HZU.abq(parama.pos);
    AppMethodBeat.o(36098);
    return false;
  }
  
  private void b(bo parambo, final k paramk)
  {
    AppMethodBeat.i(36095);
    if (this.IbU)
    {
      AppMethodBeat.o(36095);
      return;
    }
    paramk.fpR().IdG.setVisibility(8);
    o.aJy();
    String str = t.DV(parambo.field_imgPath);
    if (parambo.fbQ())
    {
      Toast.makeText(this.HZU.HZV, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    if ((str == null) || (!com.tencent.mm.vfs.i.eA(str)))
    {
      Toast.makeText(this.HZU.HZV, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    this.HZU.HZV.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramk.IdA.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramk.fpR().IdC).setTag(str);
      paramk.fpR().IdE.setVisibility(8);
      paramk.fpR().IdC.stop();
      if (this.HZU.HZV.Br(parambo.field_msgId) != 3) {
        break label381;
      }
      paramk.fpR().IdC.setMute(true);
      if ((paramk.fpR().IdC instanceof VideoSightView)) {
        ((VideoSightView)paramk.fpR().IdC).setIsAdVideo(b.bW(parambo));
      }
      paramk.fpR().IdC.setVideoPath(str);
      if (paramk.fpR().IdC.z(this.HZU.HZV.getContext(), false)) {
        break label397;
      }
      paramk.fpR().IdE.setVisibility(0);
      paramk.fpR().IdE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36089);
          paramk.fpR().IdC.z(i.this.HZU.HZV.getContext(), true);
          AppMethodBeat.o(36089);
        }
      });
      ((View)paramk.fpR().IdC).setVisibility(8);
      paramk.fpR().IdD.setVisibility(0);
    }
    for (;;)
    {
      ac.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.nQt.a(this);
      ((View)paramk.fpR().IdC).setVisibility(0);
      AppMethodBeat.o(36095);
      return;
      label381:
      paramk.fpR().IdC.setMute(false);
      break;
      label397:
      ((View)paramk.fpR().IdC).setVisibility(0);
      paramk.fpR().IdD.setVisibility(8);
    }
  }
  
  public final void MT()
  {
    AppMethodBeat.i(36092);
    SparseArray localSparseArray = this.HZU.HBb;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        k localk = (k)((View)localSparseArray.get(j)).getTag();
        if ((localk.IdB != null) && (localk.fpR().IdB.getVisibility() == 0))
        {
          localk.fpR().IdC.setVideoCallback(null);
          if ((((View)localk.fpR().IdC).getVisibility() == 0) && (localk != null))
          {
            a(localk, false);
            if (localk.fpR().IdC != null) {
              localk.fpR().IdC.stop();
            }
            ac.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.nQt.ev(false);
            this.HZU.HZV.getContext().getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(36092);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36100);
    Object localObject = parama.fileName;
    if ((bs.isNullOrNil((String)localObject)) || (this.IbT == null))
    {
      AppMethodBeat.o(36100);
      return;
    }
    parama = (j.a)this.IbT.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    bo localbo = parama.cZc;
    if ((localbo == null) || (localbo.field_imgPath == null) || (!localbo.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36100);
      return;
    }
    localObject = com.tencent.mm.modelvideo.u.Ej(localbo.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    if ((localbo.fbQ()) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.HZU.HZV, 2131764677, 0).show();
      }
      AppMethodBeat.o(36100);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((com.tencent.mm.modelvideo.s)localObject);
    localObject = abi(parama.pos);
    if ((this.HZU.HZV.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((k)localObject).fpR().IdF.setVisibility(0);
      ((k)localObject).fpR().IdF.setProgress(i);
    }
    while (i < ((k)localObject).fpS().IdF.getMax())
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
      b(localbo, (k)localObject);
    }
    AppMethodBeat.o(36100);
  }
  
  public final boolean a(k paramk, bo parambo, int paramInt)
  {
    AppMethodBeat.i(36091);
    super.a(paramk, parambo, paramInt);
    o.aJy();
    Object localObject1 = BackwardSupportUtil.b.n(t.DW(parambo.field_imgPath), 1.0F);
    if (this.IbT != null) {
      this.IbT.put(parambo.field_imgPath, new j.a(parambo, paramInt));
    }
    a(paramk, false);
    ((View)paramk.fpR().IdC).setVisibility(8);
    paramk.fpR().IdD.setImageBitmap((Bitmap)localObject1);
    paramk.fpR().IdD.setVisibility(0);
    paramk.fpR().IdG.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    paramk.IdG.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramk.qPW.setVisibility(8);
    }
    for (;;)
    {
      if ((paramk.fpR().IdC instanceof VideoSightView)) {
        com.tencent.mm.pluginsdk.ui.tools.s.a(paramk.qPW, (VideoSightView)paramk.fpR().IdC);
      }
      AppMethodBeat.o(36091);
      return true;
      localObject2 = ((com.tencent.mm.modelvideo.s)localObject1).iaR;
      break;
      label202:
      if (bs.isNullOrNil(((dev)localObject2).hjV))
      {
        ac.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((dev)localObject2).hjY;
        localObject2 = ((dev)localObject2).hjZ;
        if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil((String)localObject2)))
        {
          paramk.qPW.setText((CharSequence)localObject1);
          paramk.qPW.setVisibility(0);
          paramk.qPW.setTag(parambo);
        }
        else
        {
          paramk.qPW.setVisibility(8);
        }
      }
      else
      {
        paramk.qPW.setVisibility(0);
        paramk.qPW.setText(this.HZU.HZV.getString(2131763759, new Object[] { Integer.valueOf(((dev)localObject2).EBs) }));
        Object localObject3 = this.HZU.HZV.getString(2131763759);
        localObject1 = localObject3;
        if (((dev)localObject2).EBs / 60 > 0) {
          localObject1 = (String)localObject3 + this.HZU.HZV.getString(2131763761, new Object[] { Integer.valueOf(((dev)localObject2).EBs / 60) });
        }
        localObject3 = localObject1;
        if (((dev)localObject2).EBs % 60 > 0) {
          localObject3 = (String)localObject1 + this.HZU.HZV.getString(2131763762, new Object[] { Integer.valueOf(((dev)localObject2).EBs % 60) });
        }
        localObject1 = (String)localObject3 + this.HZU.HZV.getString(2131763760);
        paramk.qPW.setText((CharSequence)localObject1);
        paramk.qPW.setTag(parambo);
      }
    }
  }
  
  public final void aby(int paramInt)
  {
    AppMethodBeat.i(36093);
    bo localbo = this.HZU.aaP(paramInt);
    k localk = abi(paramInt);
    if ((localbo == null) || (localk == null))
    {
      AppMethodBeat.o(36093);
      return;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Ej(localbo.field_imgPath);
    if (locals != null)
    {
      if (localbo.field_isSend == 0)
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
      b(localbo, localk);
    }
    AppMethodBeat.o(36093);
  }
  
  public final void axj() {}
  
  public final void axk() {}
  
  public final void axl() {}
  
  public final void axm() {}
  
  public final void detach()
  {
    AppMethodBeat.i(36099);
    MT();
    this.HZU.HZV.getContext().getWindow().clearFlags(128);
    this.IbU = true;
    super.detach();
    this.IbT.clear();
    this.IbT = null;
    o.aJy().a(this);
    ac.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.nQt.ev(true);
    AppMethodBeat.o(36099);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(36097);
    if (this.HZU == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    k localk = this.HZU.fph();
    if (localk == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.IdB == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.fpR().IdB.getVisibility() != 0)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    a(localk, true);
    AppMethodBeat.o(36097);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i
 * JD-Core Version:    0.7.0.1
 */