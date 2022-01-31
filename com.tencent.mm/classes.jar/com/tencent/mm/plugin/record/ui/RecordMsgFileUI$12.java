package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.io.File;

final class RecordMsgFileUI$12
  implements f.a
{
  RecordMsgFileUI$12(RecordMsgFileUI paramRecordMsgFileUI) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    y.d("MicroMsg.RecordMsgFileUI", g.zH() + " onPrepared");
    RecordMsgFileUI.i(this.nue).setLoop(true);
    RecordMsgFileUI.i(this.nue).start();
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    RecordMsgFileUI.i(this.nue).stop();
    if (RecordMsgFileUI.j(this.nue)) {
      return;
    }
    RecordMsgFileUI.k(this.nue);
    final Bitmap localBitmap = RecordMsgFileUI.l(this.nue).b(RecordMsgFileUI.a(this.nue), RecordMsgFileUI.b(this.nue));
    final String str = RecordMsgFileUI.i(this.nue).getVideoPath();
    b.t(Base64.encodeToString((d.bAW() + "[RecordMsgFileUI] on play sight error, what=" + paramInt1 + ", extra=" + paramInt2 + ", path=" + bk.aM(str, "")).getBytes(), 2), "FullScreenPlaySight");
    ai.d(new Runnable()
    {
      public final void run()
      {
        Object localObject = (ImageView)RecordMsgFileUI.12.this.nue.findViewById(R.h.videoplayer_maskview);
        ((ImageView)localObject).setImageBitmap(localBitmap);
        ((ImageView)localObject).setVisibility(0);
        localObject = new Intent();
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        ((Intent)localObject).setDataAndType(Uri.fromFile(new File(str)), "video/*");
        try
        {
          RecordMsgFileUI.12.this.nue.startActivity(Intent.createChooser((Intent)localObject, RecordMsgFileUI.12.this.nue.getString(R.l.favorite_video)));
          return;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
          h.h(RecordMsgFileUI.12.this.nue.mController.uMN, R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
        }
      }
    });
  }
  
  public final void ug() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI.12
 * JD-Core Version:    0.7.0.1
 */