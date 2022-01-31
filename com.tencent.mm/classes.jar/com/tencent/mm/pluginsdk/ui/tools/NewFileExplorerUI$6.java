package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class NewFileExplorerUI$6
  implements q.a
{
  NewFileExplorerUI$6(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(28180);
    this.wfn.hideVKB();
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.b(this.wfn).dpB());
      localIntent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.b(this.wfn).dpD());
      localIntent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.b(this.wfn).dpC());
      localIntent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.f(this.wfn));
      localIntent.putExtra("with_text_content", paramString);
      this.wfn.setResult(-1, localIntent);
      this.wfn.finish();
    }
    AppMethodBeat.o(28180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.6
 * JD-Core Version:    0.7.0.1
 */