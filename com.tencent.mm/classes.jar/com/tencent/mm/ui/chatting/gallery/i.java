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
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class i
  extends a
  implements d.a, t.a, av.a
{
  private HashMap<String, j.a> JRl;
  private boolean JRm;
  private d ota;
  
  public i(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36090);
    this.JRm = false;
    this.JRm = false;
    this.JRl = new HashMap();
    o.aMJ().a(this, Looper.getMainLooper());
    this.ota = new d();
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
    com.tencent.mm.modelvideo.u.Hv(params.getFileName());
    paramk.fGA().JTg.setVisibility(0);
    paramk.fGA().JTg.setProgress(com.tencent.mm.modelvideo.u.g(params));
    o.aMJ().a(this, Looper.getMainLooper());
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
    paramk.fGA().JTg.setVisibility(8);
    if (paramBoolean)
    {
      paramk.fGA().JTe.setVisibility(8);
      ((View)paramk.fGA().JTd).setVisibility(0);
      AppMethodBeat.o(36096);
      return;
    }
    paramk.fGA().JTe.setVisibility(0);
    ((View)paramk.fGA().JTd).setVisibility(8);
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
    o.aMJ().a(this);
    if (this.JPj.JPk.getCurrentItem() == parama.pos)
    {
      parama = adu(parama.pos);
      if (parama != null) {
        parama.fGA().JTg.setVisibility(8);
      }
      AppMethodBeat.o(36098);
      return true;
    }
    this.JPj.adC(parama.pos);
    AppMethodBeat.o(36098);
    return false;
  }
  
  private void b(bu parambu, final k paramk)
  {
    AppMethodBeat.i(36095);
    if (this.JRm)
    {
      AppMethodBeat.o(36095);
      return;
    }
    paramk.fGA().JTh.setVisibility(8);
    o.aMJ();
    String str = t.Hh(parambu.field_imgPath);
    if (parambu.frT())
    {
      Toast.makeText(this.JPj.JPk, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    if ((str == null) || (!com.tencent.mm.vfs.i.fv(str)))
    {
      Toast.makeText(this.JPj.JPk, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    this.JPj.JPk.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramk.JTb.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramk.fGA().JTd).setTag(str);
      paramk.fGA().JTf.setVisibility(8);
      paramk.fGA().JTd.stop();
      if (this.JPj.JPk.Ej(parambu.field_msgId) != 3) {
        break label381;
      }
      paramk.fGA().JTd.setMute(true);
      if ((paramk.fGA().JTd instanceof VideoSightView)) {
        ((VideoSightView)paramk.fGA().JTd).setIsAdVideo(b.cc(parambu));
      }
      paramk.fGA().JTd.setVideoPath(str);
      if (paramk.fGA().JTd.B(this.JPj.JPk.getContext(), false)) {
        break label397;
      }
      paramk.fGA().JTf.setVisibility(0);
      paramk.fGA().JTf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36089);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramk.fGA().JTd.B(i.this.JPj.JPk.getContext(), true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36089);
        }
      });
      ((View)paramk.fGA().JTd).setVisibility(8);
      paramk.fGA().JTe.setVisibility(0);
    }
    for (;;)
    {
      ad.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.ota.a(this);
      ((View)paramk.fGA().JTd).setVisibility(0);
      AppMethodBeat.o(36095);
      return;
      label381:
      paramk.fGA().JTd.setMute(false);
      break;
      label397:
      ((View)paramk.fGA().JTd).setVisibility(0);
      paramk.fGA().JTe.setVisibility(8);
    }
  }
  
  public final void OC()
  {
    AppMethodBeat.i(36092);
    SparseArray localSparseArray = this.JPj.JoS;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        k localk = (k)((View)localSparseArray.get(j)).getTag();
        if ((localk.JTc != null) && (localk.fGA().JTc.getVisibility() == 0))
        {
          localk.fGA().JTd.setVideoCallback(null);
          if ((((View)localk.fGA().JTd).getVisibility() == 0) && (localk != null))
          {
            a(localk, false);
            if (localk.fGA().JTd != null) {
              localk.fGA().JTd.stop();
            }
            ad.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.ota.ex(false);
            this.JPj.JPk.getContext().getWindow().clearFlags(128);
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
    if ((bt.isNullOrNil((String)localObject)) || (this.JRl == null))
    {
      AppMethodBeat.o(36100);
      return;
    }
    parama = (j.a)this.JRl.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    bu localbu = parama.dku;
    if ((localbu == null) || (localbu.field_imgPath == null) || (!localbu.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36100);
      return;
    }
    localObject = com.tencent.mm.modelvideo.u.Hy(localbu.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    if ((localbu.frT()) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.JPj.JPk, 2131764677, 0).show();
      }
      AppMethodBeat.o(36100);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((com.tencent.mm.modelvideo.s)localObject);
    localObject = adu(parama.pos);
    if ((this.JPj.JPk.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((k)localObject).fGA().JTg.setVisibility(0);
      ((k)localObject).fGA().JTg.setProgress(i);
    }
    while (i < ((k)localObject).fGB().JTg.getMax())
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
      b(localbu, (k)localObject);
    }
    AppMethodBeat.o(36100);
  }
  
  public final boolean a(k paramk, bu parambu, int paramInt)
  {
    AppMethodBeat.i(36091);
    super.a(paramk, parambu, paramInt);
    o.aMJ();
    Object localObject1 = BackwardSupportUtil.b.o(t.Hi(parambu.field_imgPath), 1.0F);
    if (this.JRl != null) {
      this.JRl.put(parambu.field_imgPath, new j.a(parambu, paramInt));
    }
    a(paramk, false);
    ((View)paramk.fGA().JTd).setVisibility(8);
    paramk.fGA().JTe.setImageBitmap((Bitmap)localObject1);
    paramk.fGA().JTe.setVisibility(0);
    paramk.fGA().JTh.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    paramk.JTh.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramk.rzW.setVisibility(8);
    }
    for (;;)
    {
      if ((paramk.fGA().JTd instanceof VideoSightView)) {
        com.tencent.mm.pluginsdk.ui.tools.s.a(paramk.rzW, (VideoSightView)paramk.fGA().JTd);
      }
      AppMethodBeat.o(36091);
      return true;
      localObject2 = ((com.tencent.mm.modelvideo.s)localObject1).iun;
      break;
      label202:
      if (bt.isNullOrNil(((dki)localObject2).hCe))
      {
        ad.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((dki)localObject2).hCh;
        localObject2 = ((dki)localObject2).hCi;
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2)))
        {
          paramk.rzW.setText((CharSequence)localObject1);
          paramk.rzW.setVisibility(0);
          paramk.rzW.setTag(parambu);
        }
        else
        {
          paramk.rzW.setVisibility(8);
        }
      }
      else
      {
        paramk.rzW.setVisibility(0);
        paramk.rzW.setText(this.JPj.JPk.getString(2131763759, new Object[] { Integer.valueOf(((dki)localObject2).Gje) }));
        Object localObject3 = this.JPj.JPk.getString(2131763759);
        localObject1 = localObject3;
        if (((dki)localObject2).Gje / 60 > 0) {
          localObject1 = (String)localObject3 + this.JPj.JPk.getString(2131763761, new Object[] { Integer.valueOf(((dki)localObject2).Gje / 60) });
        }
        localObject3 = localObject1;
        if (((dki)localObject2).Gje % 60 > 0) {
          localObject3 = (String)localObject1 + this.JPj.JPk.getString(2131763762, new Object[] { Integer.valueOf(((dki)localObject2).Gje % 60) });
        }
        localObject1 = (String)localObject3 + this.JPj.JPk.getString(2131763760);
        paramk.rzW.setText((CharSequence)localObject1);
        paramk.rzW.setTag(parambu);
      }
    }
  }
  
  public final void aAa() {}
  
  public final void aAb() {}
  
  public final void adK(int paramInt)
  {
    AppMethodBeat.i(36093);
    bu localbu = this.JPj.ada(paramInt);
    k localk = adu(paramInt);
    if ((localbu == null) || (localk == null))
    {
      AppMethodBeat.o(36093);
      return;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Hy(localbu.field_imgPath);
    if (locals != null)
    {
      if (localbu.field_isSend == 0)
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
      b(localbu, localk);
    }
    AppMethodBeat.o(36093);
  }
  
  public final void azY() {}
  
  public final void azZ() {}
  
  public final void detach()
  {
    AppMethodBeat.i(36099);
    OC();
    this.JPj.JPk.getContext().getWindow().clearFlags(128);
    this.JRm = true;
    super.detach();
    this.JRl.clear();
    this.JRl = null;
    o.aMJ().a(this);
    ad.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.ota.ex(true);
    AppMethodBeat.o(36099);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(36097);
    if (this.JPj == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    k localk = this.JPj.fFM();
    if (localk == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.JTc == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.fGA().JTc.getVisibility() != 0)
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