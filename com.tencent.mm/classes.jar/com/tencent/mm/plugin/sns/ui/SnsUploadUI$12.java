package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

final class SnsUploadUI$12
  implements Runnable
{
  SnsUploadUI$12(SnsUploadUI paramSnsUploadUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(99582);
    View.OnDragListener local1 = new View.OnDragListener()
    {
      public final boolean onDrag(View paramAnonymousView, DragEvent paramAnonymousDragEvent)
      {
        AppMethodBeat.i(99581);
        Object localObject1 = new b();
        ((b)localObject1).bd(paramAnonymousView);
        ((b)localObject1).bd(paramAnonymousDragEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((b)localObject1).ahq());
        boolean bool = false;
        int i = paramAnonymousDragEvent.getAction();
        switch (i)
        {
        default: 
          ad.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
          AppMethodBeat.o(99581);
          return bool;
          bool = true;
          ad.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
          continue;
          ad.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
          paramAnonymousView = paramAnonymousDragEvent.getClipData();
          if (paramAnonymousView != null)
          {
            int j = paramAnonymousView.getItemCount();
            paramAnonymousDragEvent = new ArrayList();
            i = 0;
            if (i < j)
            {
              Object localObject2 = paramAnonymousView.getItemAt(i);
              if (localObject2 == null) {
                ad.e("MicroMsg.SnsUploadUI", "item == null");
              }
              for (;;)
              {
                i += 1;
                break;
                if (((ClipData.Item)localObject2).getIntent() != null)
                {
                  localObject1 = SnsUploadUI.12.this.Ape;
                  localObject2 = ((ClipData.Item)localObject2).getIntent();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((SnsUploadUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else if (((ClipData.Item)localObject2).getUri() != null)
                {
                  localObject1 = new r(SnsUploadUI.12.this.Ape.getContext(), ((ClipData.Item)localObject2).getUri());
                  if ((((r)localObject1).fileType != 0) && (((r)localObject1).filePath != null)) {}
                  switch (((r)localObject1).fileType)
                  {
                  default: 
                    break;
                  case 3: 
                    paramAnonymousDragEvent.add(((r)localObject1).filePath);
                    continue;
                    ad.e("MicroMsg.SnsUploadUI", "get file path failed");
                  }
                }
              }
            }
            if (paramAnonymousDragEvent.size() < 0)
            {
              ad.e("MicroMsg.SnsUploadUI", "no image file available");
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(99581);
              return true;
            }
            ((an)SnsUploadUI.f(SnsUploadUI.12.this.Ape)).c(paramAnonymousDragEvent, 0, false);
            bool = true;
          }
          else
          {
            bool = true;
          }
        }
      }
    };
    if (SnsUploadUI.g(this.Ape) != null) {
      SnsUploadUI.g(this.Ape).setOnDragListener(local1);
    }
    AppMethodBeat.o(99582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.12
 * JD-Core Version:    0.7.0.1
 */