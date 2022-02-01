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
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class i
  extends a
  implements d.a, t.a, av.a
{
  private HashMap<String, j.a> GBZ;
  private boolean GCa;
  private d nnt;
  
  public i(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36090);
    this.GCa = false;
    this.GCa = false;
    this.GBZ = new HashMap();
    o.aCI().a(this, Looper.getMainLooper());
    this.nnt = new d();
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
    com.tencent.mm.modelvideo.u.Ab(params.getFileName());
    paramk.fab().GDI.setVisibility(0);
    paramk.fab().GDI.setProgress(com.tencent.mm.modelvideo.u.g(params));
    o.aCI().a(this, Looper.getMainLooper());
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
    paramk.fab().GDI.setVisibility(8);
    if (paramBoolean)
    {
      paramk.fab().GDG.setVisibility(8);
      ((View)paramk.fab().GDF).setVisibility(0);
      AppMethodBeat.o(36096);
      return;
    }
    paramk.fab().GDG.setVisibility(0);
    ((View)paramk.fab().GDF).setVisibility(8);
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
    o.aCI().a(this);
    if (this.GzZ.GAa.getCurrentItem() == parama.pos)
    {
      parama = YW(parama.pos);
      if (parama != null) {
        parama.fab().GDI.setVisibility(8);
      }
      AppMethodBeat.o(36098);
      return true;
    }
    this.GzZ.Ze(parama.pos);
    AppMethodBeat.o(36098);
    return false;
  }
  
  private void b(bl parambl, final k paramk)
  {
    AppMethodBeat.i(36095);
    if (this.GCa)
    {
      AppMethodBeat.o(36095);
      return;
    }
    paramk.fab().GDJ.setVisibility(8);
    o.aCI();
    String str = t.zQ(parambl.field_imgPath);
    if (parambl.eMl())
    {
      Toast.makeText(this.GzZ.GAa, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    if ((str == null) || (!com.tencent.mm.vfs.i.eK(str)))
    {
      Toast.makeText(this.GzZ.GAa, 2131764677, 0).show();
      AppMethodBeat.o(36095);
      return;
    }
    this.GzZ.GAa.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramk.GDD.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramk.fab().GDF).setTag(str);
      paramk.fab().GDH.setVisibility(8);
      paramk.fab().GDF.stop();
      if (this.GzZ.GAa.wO(parambl.field_msgId) != 3) {
        break label381;
      }
      paramk.fab().GDF.setMute(true);
      if ((paramk.fab().GDF instanceof VideoSightView)) {
        ((VideoSightView)paramk.fab().GDF).setIsAdVideo(b.bT(parambl));
      }
      paramk.fab().GDF.setVideoPath(str);
      if (paramk.fab().GDF.y(this.GzZ.GAa.getContext(), false)) {
        break label397;
      }
      paramk.fab().GDH.setVisibility(0);
      paramk.fab().GDH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36089);
          paramk.fab().GDF.y(i.this.GzZ.GAa.getContext(), true);
          AppMethodBeat.o(36089);
        }
      });
      ((View)paramk.fab().GDF).setVisibility(8);
      paramk.fab().GDG.setVisibility(0);
    }
    for (;;)
    {
      ad.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.nnt.a(this);
      ((View)paramk.fab().GDF).setVisibility(0);
      AppMethodBeat.o(36095);
      return;
      label381:
      paramk.fab().GDF.setMute(false);
      break;
      label397:
      ((View)paramk.fab().GDF).setVisibility(0);
      paramk.fab().GDG.setVisibility(8);
    }
  }
  
  public final void MV()
  {
    AppMethodBeat.i(36092);
    SparseArray localSparseArray = this.GzZ.Gbm;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        k localk = (k)((View)localSparseArray.get(j)).getTag();
        if ((localk.GDE != null) && (localk.fab().GDE.getVisibility() == 0))
        {
          localk.fab().GDF.setVideoCallback(null);
          if ((((View)localk.fab().GDF).getVisibility() == 0) && (localk != null))
          {
            a(localk, false);
            if (localk.fab().GDF != null) {
              localk.fab().GDF.stop();
            }
            ad.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.nnt.ea(false);
            this.GzZ.GAa.getContext().getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(36092);
  }
  
  public final void Zm(int paramInt)
  {
    AppMethodBeat.i(36093);
    bl localbl = this.GzZ.YE(paramInt);
    k localk = YW(paramInt);
    if ((localbl == null) || (localk == null))
    {
      AppMethodBeat.o(36093);
      return;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.Ae(localbl.field_imgPath);
    if (locals != null)
    {
      if (localbl.field_isSend == 0)
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
      b(localbl, localk);
    }
    AppMethodBeat.o(36093);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(36100);
    Object localObject = parama.fileName;
    if ((bt.isNullOrNil((String)localObject)) || (this.GBZ == null))
    {
      AppMethodBeat.o(36100);
      return;
    }
    parama = (j.a)this.GBZ.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    bl localbl = parama.dbD;
    if ((localbl == null) || (localbl.field_imgPath == null) || (!localbl.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(36100);
      return;
    }
    localObject = com.tencent.mm.modelvideo.u.Ae(localbl.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(36100);
      return;
    }
    if ((localbl.eMl()) || (((com.tencent.mm.modelvideo.s)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.GzZ.GAa, 2131764677, 0).show();
      }
      AppMethodBeat.o(36100);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((com.tencent.mm.modelvideo.s)localObject);
    localObject = YW(parama.pos);
    if ((this.GzZ.GAa.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((k)localObject).fab().GDI.setVisibility(0);
      ((k)localObject).fab().GDI.setProgress(i);
    }
    while (i < ((k)localObject).fac().GDI.getMax())
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
      b(localbl, (k)localObject);
    }
    AppMethodBeat.o(36100);
  }
  
  public final boolean a(k paramk, bl parambl, int paramInt)
  {
    AppMethodBeat.i(36091);
    super.a(paramk, parambl, paramInt);
    o.aCI();
    Object localObject1 = BackwardSupportUtil.b.n(t.zR(parambl.field_imgPath), 1.0F);
    if (this.GBZ != null) {
      this.GBZ.put(parambl.field_imgPath, new j.a(parambl, paramInt));
    }
    a(paramk, false);
    ((View)paramk.fab().GDF).setVisibility(8);
    paramk.fab().GDG.setImageBitmap((Bitmap)localObject1);
    paramk.fab().GDG.setVisibility(0);
    paramk.fab().GDJ.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
    paramk.GDJ.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramk.qhu.setVisibility(8);
    }
    for (;;)
    {
      if ((paramk.fab().GDF instanceof VideoSightView)) {
        com.tencent.mm.pluginsdk.ui.tools.s.a(paramk.qhu, (VideoSightView)paramk.fab().GDF);
      }
      AppMethodBeat.o(36091);
      return true;
      localObject2 = ((com.tencent.mm.modelvideo.s)localObject1).hAq;
      break;
      label202:
      if (bt.isNullOrNil(((czj)localObject2).gJv))
      {
        ad.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((czj)localObject2).gJy;
        localObject2 = ((czj)localObject2).gJz;
        if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2)))
        {
          paramk.qhu.setText((CharSequence)localObject1);
          paramk.qhu.setVisibility(0);
          paramk.qhu.setTag(parambl);
        }
        else
        {
          paramk.qhu.setVisibility(8);
        }
      }
      else
      {
        paramk.qhu.setVisibility(0);
        paramk.qhu.setText(this.GzZ.GAa.getString(2131763759, new Object[] { Integer.valueOf(((czj)localObject2).Dim) }));
        Object localObject3 = this.GzZ.GAa.getString(2131763759);
        localObject1 = localObject3;
        if (((czj)localObject2).Dim / 60 > 0) {
          localObject1 = (String)localObject3 + this.GzZ.GAa.getString(2131763761, new Object[] { Integer.valueOf(((czj)localObject2).Dim / 60) });
        }
        localObject3 = localObject1;
        if (((czj)localObject2).Dim % 60 > 0) {
          localObject3 = (String)localObject1 + this.GzZ.GAa.getString(2131763762, new Object[] { Integer.valueOf(((czj)localObject2).Dim % 60) });
        }
        localObject1 = (String)localObject3 + this.GzZ.GAa.getString(2131763760);
        paramk.qhu.setText((CharSequence)localObject1);
        paramk.qhu.setTag(parambl);
      }
    }
  }
  
  public final void aqt() {}
  
  public final void aqu() {}
  
  public final void aqv() {}
  
  public final void aqw() {}
  
  public final void detach()
  {
    AppMethodBeat.i(36099);
    MV();
    this.GzZ.GAa.getContext().getWindow().clearFlags(128);
    this.GCa = true;
    super.detach();
    this.GBZ.clear();
    this.GBZ = null;
    o.aCI().a(this);
    ad.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.nnt.ea(true);
    AppMethodBeat.o(36099);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(36097);
    if (this.GzZ == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    k localk = this.GzZ.eZs();
    if (localk == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.GDE == null)
    {
      AppMethodBeat.o(36097);
      return false;
    }
    if (localk.fab().GDE.getVisibility() != 0)
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