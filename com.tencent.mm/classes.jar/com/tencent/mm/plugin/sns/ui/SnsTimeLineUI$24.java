package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.h.h;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

final class SnsTimeLineUI$24
  implements View.OnLongClickListener
{
  SnsTimeLineUI$24(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    if ((SnsTimeLineUI.g(this.pfC) != null) && (SnsTimeLineUI.g(this.pfC).oNC != null)) {
      SnsTimeLineUI.g(this.pfC).oNC.ota.ja(true);
    }
    g.DQ();
    boolean bool = ((Boolean)g.DP().Dz().get(7490, Boolean.valueOf(true))).booleanValue();
    g.DQ();
    paramView = (String)g.DP().Dz().get(ac.a.upV, null);
    Object localObject;
    if (!bk.bl(paramView))
    {
      paramView = com.tencent.d.f.e.afK(paramView);
      localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(paramView, 0, paramView.length);
      ((Parcel)localObject).setDataPosition(0);
      try
      {
        paramView = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject);
        this.pfC.startActivityForResult(paramView, 9);
        return true;
      }
      catch (Exception paramView)
      {
        g.DQ();
        g.DP().Dz().c(ac.a.upV, "");
      }
    }
    if (!bool)
    {
      paramView = new Intent();
      paramView.setClass(this.pfC, SnsUploadUI.class);
      paramView.putExtra("KSnsPostManu", true);
      paramView.putExtra("KTouchCameraTime", bk.UX());
      paramView.putExtra("sns_comment_type", 1);
      paramView.putExtra("Ksnsupload_type", 9);
      localObject = com.tencent.mm.modelsns.b.jd(705);
      ((com.tencent.mm.modelsns.b)localObject).jh(((com.tencent.mm.modelsns.b)localObject).eAJ).nj(System.currentTimeMillis()).jh(((com.tencent.mm.modelsns.b)localObject).eAK).jh(1);
      localObject = f.ozP.b((com.tencent.mm.modelsns.b)localObject);
      ((com.tencent.mm.modelsns.b)localObject).QX();
      ((com.tencent.mm.modelsns.b)localObject).b(paramView, "intent_key_StatisticsOplog");
      this.pfC.startActivityForResult(paramView, 9);
      return true;
    }
    this.pfC.startActivity(new Intent().setClass(this.pfC, SnsLongMsgUI.class));
    g.DQ();
    g.DP().Dz().o(7490, Boolean.valueOf(false));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.24
 * JD-Core Version:    0.7.0.1
 */