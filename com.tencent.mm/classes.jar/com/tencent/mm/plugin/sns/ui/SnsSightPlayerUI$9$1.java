package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.e;

final class SnsSightPlayerUI$9$1
  implements Runnable
{
  SnsSightPlayerUI$9$1(SnsSightPlayerUI.9 param9, Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    Object localObject = (ImageView)this.pdo.pdk.findViewById(i.f.videoplayer_maskview);
    if (localObject != null)
    {
      ((ImageView)localObject).setImageBitmap(this.nui);
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setDataAndType(e.aeP(this.gBs), "video/*");
    try
    {
      this.pdo.pdk.mController.uMN.startActivity(Intent.createChooser((Intent)localObject, this.pdo.pdk.mController.uMN.getString(i.j.favorite_video)));
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
      h.h(this.pdo.pdk.mController.uMN, i.j.favorite_no_match_msg, i.j.favorite_no_match_title);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.9.1
 * JD-Core Version:    0.7.0.1
 */