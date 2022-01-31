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
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class i
  extends a
  implements d.a, t.a, ap.a
{
  private d idF;
  private HashMap<String, j.a> zLG;
  private boolean zLH;
  
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(32177);
    this.zLH = false;
    this.zLH = false;
    this.zLG = new HashMap();
    o.alE().a(this, Looper.getMainLooper());
    this.idF = new d();
    AppMethodBeat.o(32177);
  }
  
  private void a(s params, k paramk)
  {
    AppMethodBeat.i(32181);
    if (params == null)
    {
      AppMethodBeat.o(32181);
      return;
    }
    com.tencent.mm.modelvideo.u.vp(params.getFileName());
    paramk.dKO().zNo.setVisibility(0);
    paramk.dKO().zNo.setProgress(com.tencent.mm.modelvideo.u.g(params));
    o.alE().a(this, Looper.getMainLooper());
    AppMethodBeat.o(32181);
  }
  
  private static void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(32183);
    if (paramk == null)
    {
      AppMethodBeat.o(32183);
      return;
    }
    paramk.dKO().zNo.setVisibility(8);
    if (paramBoolean)
    {
      paramk.dKO().zNm.setVisibility(8);
      ((View)paramk.dKO().zNl).setVisibility(0);
      AppMethodBeat.o(32183);
      return;
    }
    paramk.dKO().zNm.setVisibility(0);
    ((View)paramk.dKO().zNl).setVisibility(8);
    AppMethodBeat.o(32183);
  }
  
  private boolean a(j.a parama)
  {
    AppMethodBeat.i(32185);
    if (parama == null)
    {
      AppMethodBeat.o(32185);
      return false;
    }
    o.alE().a(this);
    if (this.zJI.zJK.getCurrentItem() == parama.pos)
    {
      parama = PP(parama.pos);
      if (parama != null) {
        parama.dKO().zNo.setVisibility(8);
      }
      AppMethodBeat.o(32185);
      return true;
    }
    this.zJI.PX(parama.pos);
    AppMethodBeat.o(32185);
    return false;
  }
  
  private void b(bi parambi, k paramk)
  {
    AppMethodBeat.i(32182);
    if (this.zLH)
    {
      AppMethodBeat.o(32182);
      return;
    }
    paramk.dKO().zNp.setVisibility(8);
    o.alE();
    String str = t.vf(parambi.field_imgPath);
    if (parambi.dyc())
    {
      Toast.makeText(this.zJI.zJK, 2131304516, 0).show();
      AppMethodBeat.o(32182);
      return;
    }
    if ((str == null) || (!com.tencent.mm.vfs.e.cN(str)))
    {
      Toast.makeText(this.zJI.zJK, 2131304516, 0).show();
      AppMethodBeat.o(32182);
      return;
    }
    this.zJI.zJK.getContext().getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramk.zNj.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramk.dKO().zNl).setTag(str);
      paramk.dKO().zNn.setVisibility(8);
      paramk.dKO().zNl.stop();
      if (this.zJI.zJK.oM(parambi.field_msgId) != 3) {
        break label354;
      }
      paramk.dKO().zNl.setMute(true);
      paramk.dKO().zNl.setVideoPath(str);
      if (paramk.dKO().zNl.w(this.zJI.zJK.getContext(), false)) {
        break label370;
      }
      paramk.dKO().zNn.setVisibility(0);
      paramk.dKO().zNn.setOnClickListener(new i.1(this, paramk));
      ((View)paramk.dKO().zNl).setVisibility(8);
      paramk.dKO().zNm.setVisibility(0);
    }
    for (;;)
    {
      ab.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.idF.a(this);
      ((View)paramk.dKO().zNl).setVisibility(0);
      AppMethodBeat.o(32182);
      return;
      label354:
      paramk.dKO().zNl.setMute(false);
      break;
      label370:
      ((View)paramk.dKO().zNl).setVisibility(0);
      paramk.dKO().zNm.setVisibility(8);
    }
  }
  
  public final void Dm()
  {
    AppMethodBeat.i(32179);
    SparseArray localSparseArray = this.zJI.znN;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        k localk = (k)((View)localSparseArray.get(j)).getTag();
        if ((localk.zNk != null) && (localk.dKO().zNk.getVisibility() == 0))
        {
          localk.dKO().zNl.setVideoCallback(null);
          if ((((View)localk.dKO().zNl).getVisibility() == 0) && (localk != null))
          {
            a(localk, false);
            if (localk.dKO().zNl != null) {
              localk.dKO().zNl.stop();
            }
            ab.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.idF.cJ(false);
            this.zJI.zJK.getContext().getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(32179);
  }
  
  public final void Qf(int paramInt)
  {
    AppMethodBeat.i(32180);
    bi localbi = this.zJI.Pz(paramInt);
    k localk = PP(paramInt);
    if ((localbi == null) || (localk == null))
    {
      AppMethodBeat.o(32180);
      return;
    }
    s locals = com.tencent.mm.modelvideo.u.vr(localbi.field_imgPath);
    if (locals != null)
    {
      if (localbi.field_isSend == 0)
      {
        if ((locals.status == 113) || (locals.status == 111) || (locals.status == 112))
        {
          a(locals, localk);
          AppMethodBeat.o(32180);
          return;
        }
        if (locals.status == 198)
        {
          a(locals, localk);
          AppMethodBeat.o(32180);
          return;
        }
      }
      b(localbi, localk);
    }
    AppMethodBeat.o(32180);
  }
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(32187);
    Object localObject = parama.fileName;
    if ((ah.isNullOrNil((String)localObject)) || (this.zLG == null))
    {
      AppMethodBeat.o(32187);
      return;
    }
    parama = (j.a)this.zLG.get(localObject);
    if (parama == null)
    {
      AppMethodBeat.o(32187);
      return;
    }
    bi localbi = parama.cmQ;
    if ((localbi == null) || (localbi.field_imgPath == null) || (!localbi.field_imgPath.equals(localObject)))
    {
      AppMethodBeat.o(32187);
      return;
    }
    localObject = com.tencent.mm.modelvideo.u.vr(localbi.field_imgPath);
    if (localObject == null)
    {
      AppMethodBeat.o(32187);
      return;
    }
    if ((localbi.dyc()) || (((s)localObject).status == 198))
    {
      if (a(parama)) {
        Toast.makeText(this.zJI.zJK, 2131304516, 0).show();
      }
      AppMethodBeat.o(32187);
      return;
    }
    int i = com.tencent.mm.modelvideo.u.g((s)localObject);
    localObject = PP(parama.pos);
    if ((this.zJI.zJK.getCurrentItem() == parama.pos) && (localObject != null))
    {
      ((k)localObject).dKO().zNo.setVisibility(0);
      ((k)localObject).dKO().zNo.setProgress(i);
    }
    while (i < ((k)localObject).dKP().zNo.getMax())
    {
      AppMethodBeat.o(32187);
      return;
      if (localObject == null)
      {
        AppMethodBeat.o(32187);
        return;
      }
    }
    if (a(parama)) {
      b(localbi, (k)localObject);
    }
    AppMethodBeat.o(32187);
  }
  
  public final boolean a(k paramk, bi parambi, int paramInt)
  {
    AppMethodBeat.i(32178);
    super.a(paramk, parambi, paramInt);
    o.alE();
    Object localObject1 = BackwardSupportUtil.b.k(t.vg(parambi.field_imgPath), 1.0F);
    if (this.zLG != null) {
      this.zLG.put(parambi.field_imgPath, new j.a(parambi, paramInt));
    }
    a(paramk, false);
    ((View)paramk.dKO().zNl).setVisibility(8);
    paramk.dKO().zNm.setImageBitmap((Bitmap)localObject1);
    paramk.dKO().zNm.setVisibility(0);
    paramk.dKO().zNp.setVisibility(8);
    localObject1 = com.tencent.mm.modelvideo.u.vr(parambi.field_imgPath);
    paramk.zNp.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label202;
      }
      paramk.mzS.setVisibility(8);
    }
    for (;;)
    {
      if ((paramk.dKO().zNl instanceof VideoSightView)) {
        p.a(paramk.mzS, (VideoSightView)paramk.dKO().zNl);
      }
      AppMethodBeat.o(32178);
      return true;
      localObject2 = ((s)localObject1).fXG;
      break;
      label202:
      if (ah.isNullOrNil(((cii)localObject2).fiO))
      {
        ab.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((cii)localObject2).fiR;
        localObject2 = ((cii)localObject2).fiS;
        if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil((String)localObject2)))
        {
          paramk.mzS.setText((CharSequence)localObject1);
          paramk.mzS.setVisibility(0);
          paramk.mzS.setTag(parambi);
        }
        else
        {
          paramk.mzS.setVisibility(8);
        }
      }
      else
      {
        paramk.mzS.setVisibility(0);
        paramk.mzS.setText(this.zJI.zJK.getString(2131303756, new Object[] { Integer.valueOf(((cii)localObject2).wUJ) }));
        Object localObject3 = this.zJI.zJK.getString(2131303756);
        localObject1 = localObject3;
        if (((cii)localObject2).wUJ / 60 > 0) {
          localObject1 = (String)localObject3 + this.zJI.zJK.getString(2131303758, new Object[] { Integer.valueOf(((cii)localObject2).wUJ / 60) });
        }
        localObject3 = localObject1;
        if (((cii)localObject2).wUJ % 60 > 0) {
          localObject3 = (String)localObject1 + this.zJI.zJK.getString(2131303759, new Object[] { Integer.valueOf(((cii)localObject2).wUJ % 60) });
        }
        localObject1 = (String)localObject3 + this.zJI.zJK.getString(2131303757);
        paramk.mzS.setText((CharSequence)localObject1);
        paramk.mzS.setTag(parambi);
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(32186);
    Dm();
    this.zJI.zJK.getContext().getWindow().clearFlags(128);
    this.zLH = true;
    super.detach();
    this.zLG.clear();
    this.zLG = null;
    o.alE().a(this);
    ab.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.idF.cJ(true);
    AppMethodBeat.o(32186);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(32184);
    if (this.zJI == null)
    {
      AppMethodBeat.o(32184);
      return false;
    }
    k localk = this.zJI.dJY();
    if (localk == null)
    {
      AppMethodBeat.o(32184);
      return false;
    }
    if (localk.zNk == null)
    {
      AppMethodBeat.o(32184);
      return false;
    }
    if (localk.dKO().zNk.getVisibility() != 0)
    {
      AppMethodBeat.o(32184);
      return false;
    }
    a(localk, true);
    AppMethodBeat.o(32184);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i
 * JD-Core Version:    0.7.0.1
 */