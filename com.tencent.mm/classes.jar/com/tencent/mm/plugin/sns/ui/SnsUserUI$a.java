package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

class SnsUserUI$a
  extends as.f
{
  private az pfz = null;
  
  SnsUserUI$a(SnsUserUI paramSnsUserUI) {}
  
  public void dX(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SnsUserUI.f(this.pjB)) });
    if ((SnsUserUI.f(this.pjB)) && (paramInt2 == -1))
    {
      g.DQ();
      Object localObject1 = (String)g.DP().Dz().get(ac.a.upU, null);
      if (!bk.bl((String)localObject1))
      {
        g.DQ();
        String str = (String)g.DP().Dz().get(ac.a.upW, "");
        Object localObject2 = new com.tencent.mm.h.b.a.v().uR();
        ((com.tencent.mm.h.b.a.v)localObject2).cie = str;
        ((com.tencent.mm.h.b.a.v)localObject2).QX();
        localObject1 = com.tencent.d.f.e.afK((String)localObject1);
        localObject2 = Parcel.obtain();
        ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
        ((Parcel)localObject2).setDataPosition(0);
        try
        {
          localObject1 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject2);
          ((Intent)localObject1).addFlags(268435456);
          ((Intent)localObject1).setClass(this.pjB, SnsUploadUI.class);
          ((Intent)localObject1).putExtra("KSessionID", str);
          this.pjB.startActivity((Intent)localObject1);
          return;
        }
        catch (Exception localException)
        {
          g.DQ();
          g.DP().Dz().c(ac.a.upU, "");
          g.DQ();
          g.DP().Dz().c(ac.a.upW, "");
        }
      }
      this.pfz = new az(this.pjB);
      this.pfz.phH = new SnsUserUI.a.1(this);
      this.pfz.c(0, this.pjB.mController.uMN.getString(i.j.app_field_pic_video));
      this.pfz.phI = new SnsUserUI.a.2(this);
      this.pfz.bJQ();
      return;
    }
    Intent localIntent = new Intent(this.pjB, SnsGalleryUI.class);
    localIntent.putExtra("sns_gallery_userName", SnsUserUI.c(this.pjB));
    localIntent.putExtra("sns_gallery_is_self", SnsUserUI.f(this.pjB));
    localIntent.putExtra("sns_gallery_localId", paramInt1);
    localIntent.putExtra("sns_source", SnsUserUI.e(this.pjB));
    localIntent.putExtra("sns_gallery_st_time", SnsUserUI.a(this.pjB).pbP);
    localIntent.putExtra("sns_gallery_ed_time", SnsUserUI.a(this.pjB).pbQ);
    if (SnsUserUI.a(this.pjB) != null)
    {
      localIntent.putExtra("sns_gallery_limit_seq", SnsUserUI.a(this.pjB).jKL);
      SnsUserUI.b(this.pjB).h(SnsUserUI.c(this.pjB), SnsUserUI.a(this.pjB).dW(paramInt1, paramInt2));
      localIntent.putExtra("sns_gallery_position", SnsUserUI.a(this.pjB).pbT);
    }
    this.pjB.startActivityForResult(localIntent, 8);
  }
  
  public final void dY(int paramInt1, int paramInt2)
  {
    Object localObject = af.bDF().yt(paramInt1);
    if (localObject == null) {
      return;
    }
    if (((n)localObject).field_type == 15)
    {
      localObject = new Intent(this.pjB, SnsGalleryUI.class);
      ((Intent)localObject).putExtra("sns_gallery_userName", SnsUserUI.c(this.pjB));
      ((Intent)localObject).putExtra("sns_gallery_is_self", SnsUserUI.f(this.pjB));
      ((Intent)localObject).putExtra("sns_gallery_localId", paramInt1);
      ((Intent)localObject).putExtra("sns_source", SnsUserUI.e(this.pjB));
      ((Intent)localObject).putExtra("sns_gallery_st_time", SnsUserUI.a(this.pjB).pbP);
      ((Intent)localObject).putExtra("sns_gallery_ed_time", SnsUserUI.a(this.pjB).pbQ);
      if (SnsUserUI.a(this.pjB) != null)
      {
        ((Intent)localObject).putExtra("sns_gallery_limit_seq", SnsUserUI.a(this.pjB).jKL);
        SnsUserUI.b(this.pjB).h(SnsUserUI.c(this.pjB), SnsUserUI.a(this.pjB).dW(paramInt1, paramInt2));
        ((Intent)localObject).putExtra("sns_gallery_position", SnsUserUI.a(this.pjB).pbT);
      }
      this.pjB.startActivityForResult((Intent)localObject, 8);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.pjB, SnsCommentDetailUI.class);
    localIntent.putExtra("INTENT_TALKER", ((n)localObject).field_userName);
    localIntent.putExtra("INTENT_SNS_LOCAL_ID", com.tencent.mm.plugin.sns.storage.v.al("sns_table_", paramInt1));
    this.pjB.startActivityForResult(localIntent, 12);
  }
  
  public final void dZ(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.SnsUserUI", "onFailLongClick localId:%s position:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    n localn = af.bDF().yt(paramInt1);
    if ((localn != null) && (localn.bDo()) && (localn.bGG())) {
      SnsUserUI.b(this.pjB, paramInt1);
    }
  }
  
  public final void yM(int paramInt)
  {
    n localn = af.bDF().yt(paramInt);
    if (localn == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.pjB, SnsCommentDetailUI.class);
    localIntent.putExtra("INTENT_TALKER", localn.field_userName);
    localIntent.putExtra("INTENT_SNS_LOCAL_ID", com.tencent.mm.plugin.sns.storage.v.al("sns_table_", paramInt));
    this.pjB.startActivityForResult(localIntent, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.a
 * JD-Core Version:    0.7.0.1
 */