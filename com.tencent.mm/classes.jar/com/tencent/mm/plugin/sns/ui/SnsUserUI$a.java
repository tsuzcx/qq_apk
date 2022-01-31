package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.an;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class SnsUserUI$a
  extends at.f
{
  private ay rYs = null;
  
  SnsUserUI$a(SnsUserUI paramSnsUserUI) {}
  
  public final void EU(int paramInt)
  {
    AppMethodBeat.i(39812);
    n localn = ag.cpf().Ez(paramInt);
    if (localn == null)
    {
      AppMethodBeat.o(39812);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.sce, SnsCommentDetailUI.class);
    localIntent.putExtra("INTENT_TALKER", localn.field_userName);
    localIntent.putExtra("INTENT_SNS_LOCAL_ID", v.aF("sns_table_", paramInt));
    this.sce.startActivityForResult(localIntent, 12);
    AppMethodBeat.o(39812);
  }
  
  public void fJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39810);
    ab.i("MicroMsg.SnsUserUI", "showImg snsinfo snslocalId:%d, pos:%d，mIsSelf:%b ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(SnsUserUI.f(this.sce)) });
    if ((SnsUserUI.f(this.sce)) && (paramInt2 == -1))
    {
      g.RM();
      Object localObject = (String)g.RL().Ru().get(ac.a.yzU, null);
      if (!bo.isNullOrNil((String)localObject))
      {
        g.RM();
        String str = (String)g.RL().Ru().get(ac.a.yzW, "");
        new an().Fo().fS(str).ake();
        localObject = com.tencent.e.f.e.awF((String)localObject);
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall((byte[])localObject, 0, localObject.length);
        localParcel.setDataPosition(0);
        try
        {
          localObject = (Intent)Intent.CREATOR.createFromParcel(localParcel);
          ((Intent)localObject).addFlags(268435456);
          ((Intent)localObject).setClass(this.sce, SnsUploadUI.class);
          ((Intent)localObject).putExtra("KSessionID", str);
          this.sce.startActivity((Intent)localObject);
          AppMethodBeat.o(39810);
          return;
        }
        catch (Exception localException)
        {
          g.RM();
          g.RL().Ru().set(ac.a.yzU, "");
          g.RM();
          g.RL().Ru().set(ac.a.yzW, "");
        }
      }
      this.rYs = new ay(this.sce);
      this.rYs.sao = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(39808);
          paramAnonymousl.e(0, SnsUserUI.a.this.sce.getString(2131296938));
          paramAnonymousl.e(1, SnsUserUI.a.this.sce.getString(2131296945));
          AppMethodBeat.o(39808);
        }
      };
      this.rYs.c(0, this.sce.getContext().getString(2131296943));
      this.rYs.sap = new SnsUserUI.a.2(this);
      this.rYs.cwt();
      AppMethodBeat.o(39810);
      return;
    }
    Intent localIntent = new Intent(this.sce, SnsGalleryUI.class);
    localIntent.putExtra("sns_gallery_userName", SnsUserUI.c(this.sce));
    localIntent.putExtra("sns_gallery_is_self", SnsUserUI.f(this.sce));
    localIntent.putExtra("sns_gallery_localId", paramInt1);
    localIntent.putExtra("sns_source", SnsUserUI.e(this.sce));
    localIntent.putExtra("sns_gallery_st_time", SnsUserUI.a(this.sce).rUz);
    localIntent.putExtra("sns_gallery_ed_time", SnsUserUI.a(this.sce).rUA);
    if (SnsUserUI.a(this.sce) != null)
    {
      localIntent.putExtra("sns_gallery_limit_seq", SnsUserUI.a(this.sce).meP);
      SnsUserUI.b(this.sce).j(SnsUserUI.c(this.sce), SnsUserUI.a(this.sce).fI(paramInt1, paramInt2));
      localIntent.putExtra("sns_gallery_position", SnsUserUI.a(this.sce).rUD);
    }
    this.sce.startActivityForResult(localIntent, 8);
    AppMethodBeat.o(39810);
  }
  
  public final void fK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39811);
    Object localObject = ag.cpf().Ez(paramInt1);
    if (localObject == null)
    {
      AppMethodBeat.o(39811);
      return;
    }
    if (((n)localObject).field_type == 15)
    {
      localObject = new Intent(this.sce, SnsGalleryUI.class);
      ((Intent)localObject).putExtra("sns_gallery_userName", SnsUserUI.c(this.sce));
      ((Intent)localObject).putExtra("sns_gallery_is_self", SnsUserUI.f(this.sce));
      ((Intent)localObject).putExtra("sns_gallery_localId", paramInt1);
      ((Intent)localObject).putExtra("sns_source", SnsUserUI.e(this.sce));
      ((Intent)localObject).putExtra("sns_gallery_st_time", SnsUserUI.a(this.sce).rUz);
      ((Intent)localObject).putExtra("sns_gallery_ed_time", SnsUserUI.a(this.sce).rUA);
      ((Intent)localObject).putExtra("sns_video_scene", 4);
      if (SnsUserUI.a(this.sce) != null)
      {
        ((Intent)localObject).putExtra("sns_gallery_limit_seq", SnsUserUI.a(this.sce).meP);
        SnsUserUI.b(this.sce).j(SnsUserUI.c(this.sce), SnsUserUI.a(this.sce).fI(paramInt1, paramInt2));
        ((Intent)localObject).putExtra("sns_gallery_position", SnsUserUI.a(this.sce).rUD);
      }
      this.sce.startActivityForResult((Intent)localObject, 8);
      AppMethodBeat.o(39811);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.sce, SnsCommentDetailUI.class);
    localIntent.putExtra("INTENT_TALKER", ((n)localObject).field_userName);
    localIntent.putExtra("INTENT_SNS_LOCAL_ID", v.aF("sns_table_", paramInt1));
    this.sce.startActivityForResult(localIntent, 12);
    AppMethodBeat.o(39811);
  }
  
  public final void fL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39813);
    ab.d("MicroMsg.SnsUserUI", "onFailLongClick localId:%s position:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    n localn = ag.cpf().Ez(paramInt1);
    if ((localn != null) && (localn.coN()) && (localn.csJ())) {
      SnsUserUI.b(this.sce, paramInt1);
    }
    AppMethodBeat.o(39813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.a
 * JD-Core Version:    0.7.0.1
 */