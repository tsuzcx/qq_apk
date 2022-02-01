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
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.Log;
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
        ((b)localObject1).cH(paramAnonymousView);
        ((b)localObject1).cH(paramAnonymousDragEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", this, ((b)localObject1).aYj());
        boolean bool = false;
        int i = paramAnonymousDragEvent.getAction();
        switch (i)
        {
        default: 
          Log.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
          AppMethodBeat.o(99581);
          return bool;
          bool = true;
          Log.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", new Object[] { Integer.valueOf(i) });
          continue;
          Log.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
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
                Log.e("MicroMsg.SnsUploadUI", "item == null");
              }
              for (;;)
              {
                i += 1;
                break;
                if (((ClipData.Item)localObject2).getIntent() != null)
                {
                  localObject1 = SnsUploadUI.12.this.REd;
                  localObject2 = ((ClipData.Item)localObject2).getIntent();
                  localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((SnsUploadUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                else if (((ClipData.Item)localObject2).getUri() != null)
                {
                  localObject1 = new u(SnsUploadUI.12.this.REd.getContext(), ((ClipData.Item)localObject2).getUri());
                  if ((((u)localObject1).fileType != 0) && (((u)localObject1).filePath != null)) {}
                  switch (((u)localObject1).fileType)
                  {
                  default: 
                    break;
                  case 3: 
                    paramAnonymousDragEvent.add(((u)localObject1).filePath);
                    continue;
                    Log.e("MicroMsg.SnsUploadUI", "get file path failed");
                  }
                }
              }
            }
            if (paramAnonymousDragEvent.size() < 0)
            {
              Log.e("MicroMsg.SnsUploadUI", "no image file available");
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/SnsUploadUI$2$1", "android/view/View$OnDragListener", "onDrag", "(Landroid/view/View;Landroid/view/DragEvent;)Z");
              AppMethodBeat.o(99581);
              return true;
            }
            ((at)SnsUploadUI.b(SnsUploadUI.12.this.REd)).d(paramAnonymousDragEvent, 0, false);
            bool = true;
          }
          else
          {
            bool = true;
          }
        }
      }
    };
    if (SnsUploadUI.g(this.REd) != null) {
      SnsUploadUI.g(this.REd).setOnDragListener(local1);
    }
    AppMethodBeat.o(99582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.12
 * JD-Core Version:    0.7.0.1
 */