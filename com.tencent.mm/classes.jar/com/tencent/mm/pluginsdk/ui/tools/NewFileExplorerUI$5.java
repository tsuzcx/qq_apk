package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.c.a.b;

final class NewFileExplorerUI$5
  implements c.a.b
{
  NewFileExplorerUI$5(NewFileExplorerUI paramNewFileExplorerUI) {}
  
  public final void aSe()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.smS.mController.uMN, NewFileExplorerUI.class);
    localIntent.putExtra("explorer_mode", 1);
    localIntent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.b(this.smS).com());
    localIntent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.b(this.smS).coo());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.b(this.smS).con());
    localIntent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.f(this.smS));
    this.smS.startActivityForResult(localIntent, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI.5
 * JD-Core Version:    0.7.0.1
 */