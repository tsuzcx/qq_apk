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
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;

final class SnsUIAction$7
  implements Runnable
{
  SnsUIAction$7(SnsUIAction paramSnsUIAction) {}
  
  public final void run()
  {
    AppMethodBeat.i(176359);
    View.OnDragListener local1 = new View.OnDragListener()
    {
      public final boolean onDrag(View paramAnonymousView, DragEvent paramAnonymousDragEvent)
      {
        AppMethodBeat.i(176358);
        Object localObject1 = new b();
        ((b)localObject1).bd(paramAnonymousView);
        ((b)localObject1).bd(paramAnonymousDragEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((b)localObject1).ahF());
        boolean bool = false;
        int i = paramAnonymousDragEvent.getAction();
        switch (i)
        {
        default: 
          ae.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
          AppMethodBeat.o(176358);
          return bool;
          bool = true;
          ae.i("MicroMsg.SnsActivity", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
          continue;
          ae.i("MicroMsg.SnsActivity", "ACTION_DROP");
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
                ae.e("MicroMsg.SnsActivity", "item == null");
              }
              for (;;)
              {
                i += 1;
                break;
                if (((ClipData.Item)localObject2).getIntent() != null)
                {
                  localObject1 = SnsUIAction.a(SnsUIAction.7.this.AFv);
                  localObject2 = ((ClipData.Item)localObject2).getIntent();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else if (((ClipData.Item)localObject2).getUri() != null)
                {
                  localObject1 = new r(SnsUIAction.a(SnsUIAction.7.this.AFv), ((ClipData.Item)localObject2).getUri());
                  if ((((r)localObject1).fileType != 0) && (((r)localObject1).filePath != null)) {}
                  switch (((r)localObject1).fileType)
                  {
                  default: 
                    break;
                  case 3: 
                    paramAnonymousView.add(((r)localObject1).filePath);
                    continue;
                    ae.e("MicroMsg.SnsActivity", "get file path failed");
                  }
                }
              }
            }
            if (paramAnonymousView.size() < 0)
            {
              ae.e("MicroMsg.SnsActivity", "no image file available");
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(176358);
              return true;
            }
            paramAnonymousDragEvent = new Intent(SnsUIAction.a(SnsUIAction.7.this.AFv), SnsUploadUI.class);
            paramAnonymousDragEvent.putExtra("KSnsPostManu", true);
            paramAnonymousDragEvent.putExtra("KTouchCameraTime", bu.aRi());
            paramAnonymousDragEvent.putStringArrayListExtra("sns_kemdia_path_list", paramAnonymousView);
            paramAnonymousDragEvent.setAction("android.intent.action.SEND");
            paramAnonymousDragEvent.addCategory("android.intent.category.DEFAULT");
            paramAnonymousDragEvent.addFlags(268435456);
            paramAnonymousDragEvent.putExtra("android.intent.extra.TEXT", "");
            paramAnonymousDragEvent.putExtra("Ksnsupload_empty_img", true);
            if (SnsUIAction.b(SnsUIAction.7.this.AFv)) {
              paramAnonymousDragEvent.putExtra("Ksnsupload_source", 11);
            }
            paramAnonymousDragEvent.setType("image/*");
            paramAnonymousView = SnsUIAction.a(SnsUIAction.7.this.AFv);
            paramAnonymousDragEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousDragEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousDragEvent.ahE(), "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousDragEvent.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsUIAction$15$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            bool = true;
          }
          else
          {
            bool = true;
          }
        }
      }
    };
    if (this.AFv.zIf != null) {
      this.AFv.zIf.setOnDragListener(local1);
    }
    AppMethodBeat.o(176359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUIAction.7
 * JD-Core Version:    0.7.0.1
 */