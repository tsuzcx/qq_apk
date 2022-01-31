package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

final class SnsUIAction$5$1
  implements View.OnDragListener
{
  SnsUIAction$5$1(SnsUIAction.5 param5) {}
  
  public final boolean onDrag(View paramView, DragEvent paramDragEvent)
  {
    int i = 0;
    boolean bool2 = true;
    AppMethodBeat.i(145641);
    int j = paramDragEvent.getAction();
    boolean bool1;
    switch (j)
    {
    default: 
      ab.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
      bool1 = false;
    }
    for (;;)
    {
      AppMethodBeat.o(145641);
      return bool1;
      ab.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[] { Integer.valueOf(j) });
      bool1 = bool2;
      continue;
      ab.i("MicroMsg.SnsActivity", "ACTION_DROP");
      paramDragEvent = paramDragEvent.getClipData();
      bool1 = bool2;
      if (paramDragEvent != null)
      {
        j = paramDragEvent.getItemCount();
        paramView = new ArrayList();
        if (i < j)
        {
          Object localObject = paramDragEvent.getItemAt(i);
          if (localObject == null) {
            ab.e("MicroMsg.SnsActivity", "item == null");
          }
          for (;;)
          {
            i += 1;
            break;
            if (((ClipData.Item)localObject).getIntent() != null)
            {
              SnsUIAction.a(this.sbi.sbh).startActivity(((ClipData.Item)localObject).getIntent());
            }
            else if (((ClipData.Item)localObject).getUri() != null)
            {
              localObject = new o(SnsUIAction.a(this.sbi.sbh), ((ClipData.Item)localObject).getUri());
              if ((((o)localObject).fileType != 0) && (((o)localObject).filePath != null)) {}
              switch (((o)localObject).fileType)
              {
              default: 
                break;
              case 3: 
                paramView.add(((o)localObject).filePath);
                continue;
                ab.e("MicroMsg.SnsActivity", "get file path failed");
              }
            }
          }
        }
        if (paramView.size() < 0)
        {
          ab.e("MicroMsg.SnsActivity", "no image file available");
          AppMethodBeat.o(145641);
          return true;
        }
        paramDragEvent = new Intent(SnsUIAction.a(this.sbi.sbh), SnsUploadUI.class);
        paramDragEvent.putExtra("KSnsPostManu", true);
        paramDragEvent.putExtra("KTouchCameraTime", bo.aox());
        paramDragEvent.putStringArrayListExtra("sns_kemdia_path_list", paramView);
        paramDragEvent.setAction("android.intent.action.SEND");
        paramDragEvent.addCategory("android.intent.category.DEFAULT");
        paramDragEvent.addFlags(268435456);
        paramDragEvent.putExtra("android.intent.extra.TEXT", "");
        paramDragEvent.putExtra("Ksnsupload_empty_img", true);
        if (SnsUIAction.b(this.sbi.sbh)) {
          paramDragEvent.putExtra("Ksnsupload_source", 11);
        }
        paramDragEvent.setType("image/*");
        SnsUIAction.a(this.sbi.sbh).startActivity(paramDragEvent);
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.5.1
 * JD-Core Version:    0.7.0.1
 */