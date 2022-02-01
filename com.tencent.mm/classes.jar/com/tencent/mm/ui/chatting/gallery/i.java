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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class i
  extends a
  implements d.a, t.a, aw.a
{
  private HashMap<String, j.a> Kmw;
  private boolean Kmx;
  private d ozB;
  
  public i(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36090);
    this.Kmx = false;
    this.Kmx = false;
    this.Kmw = new HashMap();
    com.tencent.mm.modelvideo.o.aNh().a(this, Looper.getMainLooper());
    this.ozB = new d();
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
    com.tencent.mm.modelvideo.u.HX(params.getFileName());
    paramk.fKL().KoG.setVisibility(0);
    paramk.fKL().KoG.setProgress(com.tencent.mm.modelvideo.u.g(params));
    com.tencent.mm.modelvideo.o.aNh().a(this, Looper.getMainLooper());
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
    paramk.fKL().KoG.setVisibility(8);
    if (paramBoolean)
    {
      paramk.fKL().KoE.setVisibility(8);
      ((View)paramk.fKL().KoD).setVisibility(0);
      AppMethodBeat.o(36096);
      return;
    }
    paramk.fKL().KoE.setVisibility(0);
    ((View)paramk.fKL().KoD).setVisibility(8);
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
    com.tencent.mm.modelvideo.o.aNh().a(this);
    if (this.Kkv.Kkw.getCurrentItem() == parama.pos)
    {
      parama = aeb(parama.pos);
      if (parama != null) {
        parama.fKL().KoG.setVisibility(8);
      }
      AppMethodBeat.o(36098);
      return true;
    }
    this.Kkv.aej(parama.pos);
    AppMethodBeat.o(36098);
    return false;
  }
  
  private void b(bv parambv, final k paramk)
  {
    AppMethodBeat.i(36095);
    if (this.Kmx)
    {
      AppMethodBeat.o(36095);
      return;
    }
    paramk.fKL().KoH.setVisibility(8);
    com.tencent.mm.modelvideo.o.aNh();
    String str = t.HJ(parambv.field_imgPath);
    if (parambv.fvU())
    {
      Toast.makeText(this.Kkv.Kkw, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    if ((str == null) || (!com.tencent.mm.vfs.o.fB(str)))
    {
      Toast.makeText(this.Kkv.Kkw, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    this.Kkv.Kkw.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramk.KoB.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramk.fKL().KoD).setTag(str);
      paramk.fKL().KoF.setVisibility(8);
      paramk.fKL().KoD.stop();
      if (this.Kkv.Kkw.EL(parambv.field_msgId) != 3) {
        break label381;
      }
      paramk.fKL().KoD.setMute(true);
      if ((paramk.fKL().KoD instanceof VideoSightView)) {
        ((VideoSightView)paramk.fKL().KoD).setIsAdVideo(b.cc(parambv));
      }
      paramk.fKL().KoD.setVideoPath(str);
      if (paramk.fKL().KoD.B(this.Kkv.Kkw.getContext(), false)) {
        break label397;
      }
      paramk.fKL().KoF.setVisibility(0);
      paramk.fKL().KoF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36089);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramk.fKL().KoD.B(i.this.Kkv.Kkw.getContext(), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36089);
        }
      });
      ((View)paramk.fKL().KoD).setVisibility(8);
      paramk.fKL().KoE.setVisibility(0);
    }
    for (;;)
    {
      ae.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.ozB.a(this);
      ((View)paramk.fKL().KoD).setVisibility(0);
      AppMethodBeat.o(36095);
      return;
      label381:
      paramk.fKL().KoD.setMute(false);
      break;
      label397:
      ((View)paramk.fKL().KoD).setVisibility(0);
      paramk.fKL().KoE.setVisibility(8);
    }
  }
  
  public final void OA()
  {
    AppMethodBeat.i(36092);
    SparseArray localSparseArray = this.Kkv.JJH;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        k localk = (k)((View)localSparseArray.get(j)).getTag();
        if ((localk.KoC != null) && (localk.fKL().KoC.getVisibility() == 0))
        {
          localk.fKL().KoD.setVideoCallback(null);
          if ((((View)localk.fKL().KoD).getVisibility() == 0) && (localk != null))
          {
            a(localk, false);
            if (localk.fKL().KoD != null) {
              localk.fKL().KoD.stop();
            }
            ae.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.ozB.ez(false);
            this.Kkv.Kkw.getContext().getWindow().clearFlags(128);
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
    if ((bu.isNullOrNil((String)localObject)) || (this.Kmw == null))
    {
      AppMethodBeat.o(36100);
      return;
    }
    parama = (j.a)this.Kmw.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    bv localbv = parama.dlw;
    if ((localbv == null) || (localbv.field_imgPath == null) || (!localbv.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36100);
      return;
    }
    localObject = com.tencent.mm.modelvideo.u.Ia(localbv.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    if ((localbv.fvU()) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.Kkv.Kkw, 2131764677, 0).show();
      }
      AppMethodBeat.o(36100);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((com.tencent.mm.modelvideo.s)localObject);
    localObject = aeb(parama.pos);
    if ((this.Kkv.Kkw.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((k)localObject).fKL().KoG.setVisibility(0);
      ((k)localObject).fKL().KoG.setProgress(i);
    }
    while (i < ((k)localObject).fKM().KoG.getMax())
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
      b(localbv, (k)localObject);
    }
    AppMethodBeat.o(36100);
  }
  
  public final boolean a(k paramk, bv parambv, int paramInt)
  {
    AppMethodBeat.i(36091);
    super.a(paramk, parambv, paramInt);
    com.tencent.mm.modelvideo.o.aNh();
    Object localObject1 = BackwardSupportUtil.b.p(t.HK(parambv.field_imgPath), 1.0F);
    if (this.Kmw != null) {
      this.Kmw.put(parambv.field_imgPath, new j.a(parambv, paramInt));
    }
    a(paramk, false);
    ((View)paramk.fKL().KoD).setVisibility(8);
    paramk.fKL().KoE.setImageBitmap((Bitmap)localObject1);
    paramk.fKL().KoE.setVisibility(0);
    paramk.fKL().KoH.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
    paramk.KoH.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramk.rIh.setVisibility(8);
    }
    for (;;)
    {
      if ((paramk.fKL().KoD instanceof VideoSightView)) {
        com.tencent.mm.pluginsdk.ui.tools.s.a(paramk.rIh, (VideoSightView)paramk.fKL().KoD);
      }
      AppMethodBeat.o(36091);
      return true;
      localObject2 = ((com.tencent.mm.modelvideo.s)localObject1).ixh;
      break;
      label202:
      if (bu.isNullOrNil(((dld)localObject2).hET))
      {
        ae.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((dld)localObject2).hEW;
        localObject2 = ((dld)localObject2).hEX;
        if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil((String)localObject2)))
        {
          paramk.rIh.setText((CharSequence)localObject1);
          paramk.rIh.setVisibility(0);
          paramk.rIh.setTag(parambv);
        }
        else
        {
          paramk.rIh.setVisibility(8);
        }
      }
      else
      {
        paramk.rIh.setVisibility(0);
        paramk.rIh.setText(this.Kkv.Kkw.getString(2131763759, new Object[] { Integer.valueOf(((dld)localObject2).GBN) }));
        Object localObject3 = this.Kkv.Kkw.getString(2131763759);
        localObject1 = localObject3;
        if (((dld)localObject2).GBN / 60 > 0) {
          localObject1 = (String)localObject3 + this.Kkv.Kkw.getString(2131763761, new Object[] { Integer.valueOf(((dld)localObject2).GBN / 60) });
        }
        localObject3 = localObject1;
        if (((dld)localObject2).GBN % 60 > 0) {
          localObject3 = (String)localObject1 + this.Kkv.Kkw.getString(2131763762, new Object[] { Integer.valueOf(((dld)localObject2).GBN % 60) });
        }
        localObject1 = (String)localObject3 + this.Kkv.Kkw.getString(2131763760);
        paramk.rIh.setText((CharSequence)localObject1);
        paramk.rIh.setTag(parambv);
      }
    }
  }
  
  public final void aAo() {}
  
  public final void aAp() {}
  
  public final void aAq() {}
  
  public final void aAr() {}
  
  public final void aer(int paramInt)
  {
    AppMethodBeat.i(36093);
    bv localbv = this.Kkv.adI(paramInt);
    k localk = aeb(paramInt);
    if ((localbv == null) || (localk == null))
    {
      AppMethodBeat.o(36093);
      return;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Ia(localbv.field_imgPath);
    if (locals != null)
    {
      if (localbv.field_isSend == 0)
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
      b(localbv, localk);
    }
    AppMethodBeat.o(36093);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36099);
    OA();
    this.Kkv.Kkw.getContext().getWindow().clearFlags(128);
    this.Kmx = true;
    super.detach();
    this.Kmw.clear();
    this.Kmw = null;
    com.tencent.mm.modelvideo.o.aNh().a(this);
    ae.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.ozB.ez(true);
    AppMethodBeat.o(36099);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(36097);
    if (this.Kkv == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    k localk = this.Kkv.fJT();
    if (localk == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.KoC == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.fKL().KoC.getVisibility() != 0)
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