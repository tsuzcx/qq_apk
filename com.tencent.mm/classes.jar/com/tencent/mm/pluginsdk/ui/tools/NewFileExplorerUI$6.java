package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class NewFileExplorerUI$6
  implements q.a
{
  NewFileExplorerUI$6(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.smS.XM();
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.b(this.smS).com());
      localIntent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.b(this.smS).coo());
      localIntent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.b(this.smS).con());
      localIntent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.f(this.smS));
      localIntent.putExtra("with_text_content", paramString);
      this.smS.setResult(-1, localIntent);
      this.smS.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.6
 * JD-Core Version:    0.7.0.1
 */