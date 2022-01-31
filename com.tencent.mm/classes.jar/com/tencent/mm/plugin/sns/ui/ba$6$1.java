package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.pluginsdk.ui.tools.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class ba$6$1
  implements View.OnDragListener
{
  ba$6$1(ba.6 param6) {}
  
  public final boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    int i = 0;
    boolean bool = true;
    int j = paramDragEvent.getAction();
    switch (j)
    {
    default: 
      y.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
      bool = false;
    }
    do
    {
      return bool;
      y.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[] { Integer.valueOf(j) });
      return true;
      y.i("MicroMsg.SnsActivity", "ACTION_DROP");
      paramDragEvent = paramDragEvent.getClipData();
    } while (paramDragEvent == null);
    j = paramDragEvent.getItemCount();
    paramView = new ArrayList();
    if (i < j)
    {
      Object localObject = paramDragEvent.getItemAt(i);
      if (localObject == null) {
        y.e("MicroMsg.SnsActivity", "item == null");
      }
      for (;;)
      {
        i += 1;
        break;
        if (((ClipData.Item)localObject).getIntent() != null)
        {
          ba.a(this.piG.piF).startActivity(((ClipData.Item)localObject).getIntent());
        }
        else if (((ClipData.Item)localObject).getUri() != null)
        {
          localObject = new m(ba.a(this.piG.piF), ((ClipData.Item)localObject).getUri());
          if ((((m)localObject).fileType != 0) && (((m)localObject).filePath != null)) {}
          switch (((m)localObject).fileType)
          {
          default: 
            break;
          case 3: 
            paramView.add(((m)localObject).filePath);
            continue;
            y.e("MicroMsg.SnsActivity", "get file path failed");
          }
        }
      }
    }
    if (paramView.size() < 0)
    {
      y.e("MicroMsg.SnsActivity", "no image file available");
      return true;
    }
    paramDragEvent = new Intent(ba.a(this.piG.piF), SnsUploadUI.class);
    paramDragEvent.putExtra("KSnsPostManu", true);
    paramDragEvent.putExtra("KTouchCameraTime", bk.UX());
    paramDragEvent.putStringArrayListExtra("sns_kemdia_path_list", paramView);
    paramDragEvent.setAction("android.intent.action.SEND");
    paramDragEvent.addCategory("android.intent.category.DEFAULT");
    paramDragEvent.addFlags(268435456);
    paramDragEvent.putExtra("android.intent.extra.TEXT", "");
    paramDragEvent.putExtra("Ksnsupload_empty_img", true);
    if (ba.b(this.piG.piF)) {
      paramDragEvent.putExtra("Ksnsupload_source", 11);
    }
    paramDragEvent.setType("image/*");
    ba.a(this.piG.piF).startActivity(paramDragEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.6.1
 * JD-Core Version:    0.7.0.1
 */