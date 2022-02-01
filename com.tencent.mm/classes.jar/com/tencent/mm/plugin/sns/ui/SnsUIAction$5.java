package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

final class SnsUIAction$5
  implements Runnable
{
  SnsUIAction$5(SnsUIAction paramSnsUIAction) {}
  
  public final void run()
  {
    AppMethodBeat.i(99464);
    View.OnDragListener local1 = new View.OnDragListener()
    {
      public final boolean onDrag(View paramAnonymousView, DragEvent paramAnonymousDragEvent)
      {
        AppMethodBeat.i(308229);
        Object localObject1 = new b();
        ((b)localObject1).cH(paramAnonymousView);
        ((b)localObject1).cH(paramAnonymousDragEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUIAction$13$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((b)localObject1).aYj());
        boolean bool = false;
        int i = paramAnonymousDragEvent.getAction();
        switch (i)
        {
        default: 
          Log.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$13$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
          AppMethodBeat.o(308229);
          return bool;
          bool = true;
          Log.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
          continue;
          Log.i("MicroMsg.SnsActivity", "ACTION_DROP");
          paramAnonymousDragEvent = paramAnonymousDragEvent.getClipData();
          if (paramAnonymousDragEvent != null)
          {
            int j = paramAnonymousDragEvent.getItemCount();
            paramAnonymousView = new ArrayList();
            i = 0;
            if (i < j)
            {
              Object localObject2 = paramAnonymousDragEvent.getItemAt(i);
              if (localObject2 == null) {
                Log.e("MicroMsg.SnsActivity", "item == null");
              }
              for (;;)
              {
                i += 1;
                break;
                if (((ClipData.Item)localObject2).getIntent() != null)
                {
                  localObject1 = SnsUIAction.a(SnsUIAction.5.this.RDe);
                  localObject2 = ((ClipData.Item)localObject2).getIntent();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/SnsUIAction$13$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SnsUIAction$13$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else if (((ClipData.Item)localObject2).getUri() != null)
                {
                  localObject1 = new u(SnsUIAction.a(SnsUIAction.5.this.RDe), ((ClipData.Item)localObject2).getUri());
                  if ((((u)localObject1).fileType != 0) && (((u)localObject1).filePath != null)) {}
                  switch (((u)localObject1).fileType)
                  {
                  default: 
                    break;
                  case 3: 
                    paramAnonymousView.add(((u)localObject1).filePath);
                    continue;
                    Log.e("MicroMsg.SnsActivity", "get file path failed");
                  }
                }
              }
            }
            if (paramAnonymousView.size() < 0)
            {
              Log.e("MicroMsg.SnsActivity", "no image file available");
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$13$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(308229);
              return true;
            }
            paramAnonymousDragEvent = new Intent(SnsUIAction.a(SnsUIAction.5.this.RDe), SnsUploadUI.class);
            paramAnonymousDragEvent.putExtra("KSnsPostManu", true);
            paramAnonymousDragEvent.putExtra("KTouchCameraTime", Util.nowSecond());
            paramAnonymousDragEvent.putStringArrayListExtra("sns_kemdia_path_list", paramAnonymousView);
            paramAnonymousDragEvent.setAction("android.intent.action.SEND");
            paramAnonymousDragEvent.addCategory("android.intent.category.DEFAULT");
            paramAnonymousDragEvent.addFlags(268435456);
            paramAnonymousDragEvent.putExtra("android.intent.extra.TEXT", "");
            paramAnonymousDragEvent.putExtra("Ksnsupload_empty_img", true);
            if (SnsUIAction.b(SnsUIAction.5.this.RDe)) {
              paramAnonymousDragEvent.putExtra("Ksnsupload_source", 11);
            }
            paramAnonymousDragEvent.setType("image/*");
            paramAnonymousView = SnsUIAction.a(SnsUIAction.5.this.RDe);
            paramAnonymousDragEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousDragEvent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousDragEvent.aYi(), "com/tencent/mm/plugin/sns/ui/SnsUIAction$13$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousDragEvent.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsUIAction$13$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            bool = true;
          }
          else
          {
            bool = true;
          }
        }
      }
    };
    if (this.RDe.QCY != null) {
      this.RDe.QCY.setOnDragListener(local1);
    }
    AppMethodBeat.o(99464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.5
 * JD-Core Version:    0.7.0.1
 */