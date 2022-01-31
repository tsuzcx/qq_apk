package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.tools.l;

final class ScanTranslationCaptureUI$19
  implements View.OnClickListener
{
  ScanTranslationCaptureUI$19(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("max_select_count", 1);
    paramView.putExtra("query_media_type", 1);
    l.a(this.nNm, 561, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.19
 * JD-Core Version:    0.7.0.1
 */