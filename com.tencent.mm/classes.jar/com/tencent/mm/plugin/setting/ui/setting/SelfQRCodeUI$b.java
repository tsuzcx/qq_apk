package com.tencent.mm.plugin.setting.ui.setting;

import android.net.Uri;
import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public final class SelfQRCodeUI$b
  extends FileObserver
{
  private MMActivity nSE;
  private String nSF;
  
  public SelfQRCodeUI$b(SelfQRCodeUI paramSelfQRCodeUI, MMActivity paramMMActivity)
  {
    super(SelfQRCodeUI.access$700(), 8);
    this.nSE = paramMMActivity;
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    if ((paramString != null) && (paramInt == 8) && ((this.nSF == null) || (!paramString.equalsIgnoreCase(this.nSF))))
    {
      this.nSF = paramString;
      Uri.fromFile(new File(SelfQRCodeUI.access$700() + paramString));
      SelfQRCodeUI.byL();
      y.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
    }
  }
  
  public final void start()
  {
    super.startWatching();
  }
  
  public final void stop()
  {
    super.stopWatching();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.b
 * JD-Core Version:    0.7.0.1
 */