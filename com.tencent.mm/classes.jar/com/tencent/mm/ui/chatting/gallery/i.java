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
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

public final class i
  extends a
  implements d.a, t.a, am.a
{
  private d gEB;
  private HashMap<String, j.a> vvE = new HashMap();
  private boolean vvF = false;
  
  public i(c paramc)
  {
    super(paramc);
    o.Sr().a(this, Looper.getMainLooper());
    this.gEB = new d();
  }
  
  private void a(com.tencent.mm.modelvideo.s params, k paramk)
  {
    if (params == null) {
      return;
    }
    u.oc(params.getFileName());
    paramk.cGG().vxe.setVisibility(0);
    paramk.cGG().vxe.setProgress(u.g(params));
    o.Sr().a(this, Looper.getMainLooper());
  }
  
  private static void a(k paramk, boolean paramBoolean)
  {
    if (paramk == null) {
      return;
    }
    paramk.cGG().vxe.setVisibility(8);
    if (paramBoolean)
    {
      paramk.cGG().vxc.setVisibility(8);
      ((View)paramk.cGG().vxb).setVisibility(0);
      return;
    }
    paramk.cGG().vxc.setVisibility(0);
    ((View)paramk.cGG().vxb).setVisibility(8);
  }
  
  private boolean a(j.a parama)
  {
    if (parama == null) {
      return false;
    }
    o.Sr().a(this);
    if (this.vtH.vtJ.getCurrentItem() == parama.pos)
    {
      parama = Hi(parama.pos);
      if (parama != null) {
        parama.cGG().vxe.setVisibility(8);
      }
      return true;
    }
    this.vtH.Hq(parama.pos);
    return false;
  }
  
  private void b(bi parambi, k paramk)
  {
    if (this.vvF) {
      return;
    }
    paramk.cGG().vxf.setVisibility(8);
    o.Sr();
    String str = com.tencent.mm.modelvideo.t.nS(parambi.field_imgPath);
    if (parambi.cvx())
    {
      Toast.makeText(this.vtH.vtJ, R.l.video_fail_or_clean, 0).show();
      return;
    }
    if ((str == null) || (!e.bK(str)))
    {
      Toast.makeText(this.vtH.vtJ, R.l.video_fail_or_clean, 0).show();
      return;
    }
    this.vtH.vtJ.mController.uMN.getWindow().addFlags(128);
    Boolean localBoolean = (Boolean)paramk.vwZ.get(str);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ((View)paramk.cGG().vxb).setTag(str);
      paramk.cGG().vxd.setVisibility(8);
      paramk.cGG().vxb.stop();
      if (this.vtH.vtJ.ia(parambi.field_msgId) != 3) {
        break label334;
      }
      paramk.cGG().vxb.setMute(true);
      paramk.cGG().vxb.setVideoPath(str);
      if (paramk.cGG().vxb.s(this.vtH.vtJ.mController.uMN, false)) {
        break label350;
      }
      paramk.cGG().vxd.setVisibility(0);
      paramk.cGG().vxd.setOnClickListener(new i.1(this, paramk));
      ((View)paramk.cGG().vxb).setVisibility(8);
      paramk.cGG().vxc.setVisibility(0);
    }
    for (;;)
    {
      y.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
      this.gEB.a(this);
      ((View)paramk.cGG().vxb).setVisibility(0);
      return;
      label334:
      paramk.cGG().vxb.setMute(false);
      break;
      label350:
      ((View)paramk.cGG().vxb).setVisibility(0);
      paramk.cGG().vxc.setVisibility(8);
    }
  }
  
  public final void Hy(int paramInt)
  {
    bi localbi = this.vtH.GW(paramInt);
    k localk = Hi(paramInt);
    if ((localbi == null) || (localk == null)) {}
    com.tencent.mm.modelvideo.s locals;
    do
    {
      return;
      locals = u.oe(localbi.field_imgPath);
    } while (locals == null);
    if (localbi.field_isSend == 0)
    {
      if ((locals.status == 113) || (locals.status == 111) || (locals.status == 112))
      {
        a(locals, localk);
        return;
      }
      if (locals.status == 198)
      {
        a(locals, localk);
        return;
      }
    }
    b(localbi, localk);
  }
  
  public final void a(t.a.a parama)
  {
    Object localObject = parama.fileName;
    if ((ah.bl((String)localObject)) || (this.vvE == null)) {}
    do
    {
      return;
      bi localbi;
      int i;
      while ((i < ((k)localObject).cGH().vxe.getMax()) || (!a(parama)))
      {
        do
        {
          do
          {
            do
            {
              do
              {
                parama = (j.a)this.vvE.get(localObject);
              } while (parama == null);
              localbi = parama.bFH;
            } while ((localbi == null) || (localbi.field_imgPath == null) || (!localbi.field_imgPath.equals(localObject)));
            localObject = u.oe(localbi.field_imgPath);
          } while (localObject == null);
          if ((!localbi.cvx()) && (((com.tencent.mm.modelvideo.s)localObject).status != 198)) {
            break;
          }
        } while (!a(parama));
        Toast.makeText(this.vtH.vtJ, R.l.video_fail_or_clean, 0).show();
        return;
        i = u.g((com.tencent.mm.modelvideo.s)localObject);
        localObject = Hi(parama.pos);
        if ((this.vtH.vtJ.getCurrentItem() != parama.pos) || (localObject == null)) {
          break;
        }
        ((k)localObject).cGG().vxe.setVisibility(0);
        ((k)localObject).cGG().vxe.setProgress(i);
      }
      b(localbi, (k)localObject);
      return;
    } while (localObject != null);
  }
  
  public final boolean a(k paramk, bi parambi, int paramInt)
  {
    super.a(paramk, parambi, paramInt);
    o.Sr();
    Object localObject1 = BackwardSupportUtil.b.e(com.tencent.mm.modelvideo.t.nT(parambi.field_imgPath), 1.0F);
    if (this.vvE != null) {
      this.vvE.put(parambi.field_imgPath, new j.a(parambi, paramInt));
    }
    a(paramk, false);
    ((View)paramk.cGG().vxb).setVisibility(8);
    paramk.cGG().vxc.setImageBitmap((Bitmap)localObject1);
    paramk.cGG().vxc.setVisibility(0);
    paramk.cGG().vxf.setVisibility(8);
    localObject1 = u.oe(parambi.field_imgPath);
    paramk.vxf.setTag(localObject1);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label190;
      }
      paramk.kfj.setVisibility(8);
    }
    for (;;)
    {
      if ((paramk.cGG().vxb instanceof VideoSightView)) {
        n.a(paramk.kfj, (VideoSightView)paramk.cGG().vxb);
      }
      return true;
      localObject2 = ((com.tencent.mm.modelvideo.s)localObject1).eHQ;
      break;
      label190:
      if (ah.bl(((bwa)localObject2).dSP))
      {
        y.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
        localObject1 = ((bwa)localObject2).dSS;
        localObject2 = ((bwa)localObject2).dST;
        if ((!bk.bl((String)localObject1)) && (!bk.bl((String)localObject2)))
        {
          paramk.kfj.setText((CharSequence)localObject1);
          paramk.kfj.setVisibility(0);
          paramk.kfj.setTag(parambi);
        }
        else
        {
          paramk.kfj.setVisibility(8);
        }
      }
      else
      {
        paramk.kfj.setVisibility(0);
        paramk.kfj.setText(this.vtH.vtJ.getString(R.l.sns_ad_sight_full, new Object[] { Integer.valueOf(((bwa)localObject2).sWK) }));
        Object localObject3 = this.vtH.vtJ.getString(R.l.sns_ad_sight_full);
        localObject1 = localObject3;
        if (((bwa)localObject2).sWK / 60 > 0) {
          localObject1 = (String)localObject3 + this.vtH.vtJ.getString(R.l.sns_ad_sight_full_m, new Object[] { Integer.valueOf(((bwa)localObject2).sWK / 60) });
        }
        localObject3 = localObject1;
        if (((bwa)localObject2).sWK % 60 > 0) {
          localObject3 = (String)localObject1 + this.vtH.vtJ.getString(R.l.sns_ad_sight_full_s, new Object[] { Integer.valueOf(((bwa)localObject2).sWK % 60) });
        }
        localObject1 = (String)localObject3 + this.vtH.vtJ.getString(R.l.sns_ad_sight_full_end);
        paramk.kfj.setText((CharSequence)localObject1);
        paramk.kfj.setTag(parambi);
      }
    }
  }
  
  public final void cGd()
  {
    SparseArray localSparseArray = this.vtH.uZw;
    int i = 0;
    while (i < localSparseArray.size())
    {
      int j = localSparseArray.keyAt(i);
      if ((localSparseArray.get(j) != null) && (((View)localSparseArray.get(j)).getTag() != null))
      {
        k localk = (k)((View)localSparseArray.get(j)).getTag();
        if ((localk.vxa != null) && (localk.cGG().vxa.getVisibility() == 0))
        {
          localk.cGG().vxb.setVideoCallback(null);
          if ((((View)localk.cGG().vxb).getVisibility() == 0) && (localk != null))
          {
            a(localk, false);
            if (localk.cGG().vxb != null) {
              localk.cGG().vxb.stop();
            }
            y.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
            this.gEB.bH(false);
            this.vtH.vtJ.mController.uMN.getWindow().clearFlags(128);
          }
        }
      }
      i += 1;
    }
  }
  
  public final void detach()
  {
    cGd();
    this.vtH.vtJ.mController.uMN.getWindow().clearFlags(128);
    this.vvF = true;
    super.detach();
    this.vvE.clear();
    this.vvE = null;
    o.Sr().a(this);
    y.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
    this.gEB.bH(true);
  }
  
  public final boolean tC()
  {
    if (this.vtH == null) {}
    k localk;
    do
    {
      return false;
      localk = this.vtH.cFV();
    } while ((localk == null) || (localk.vxa == null) || (localk.cGG().vxa.getVisibility() != 0));
    a(localk, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i
 * JD-Core Version:    0.7.0.1
 */