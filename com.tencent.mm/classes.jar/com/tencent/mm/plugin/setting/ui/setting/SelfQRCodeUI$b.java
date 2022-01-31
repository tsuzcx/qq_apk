package com.tencent.mm.plugin.setting.ui.setting;

import android.net.Uri;
import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public final class SelfQRCodeUI$b
  extends FileObserver
{
  private MMActivity qGC;
  private String qGD;
  
  public SelfQRCodeUI$b(SelfQRCodeUI paramSelfQRCodeUI, MMActivity paramMMActivity)
  {
    super(SelfQRCodeUI.access$800(), 8);
    AppMethodBeat.i(127023);
    this.qGC = paramMMActivity;
    AppMethodBeat.o(127023);
  }
  
  public final void onEvent(int paramInt, String paramString)
  {
    AppMethodBeat.i(127024);
    if ((paramString != null) && (paramInt == 8) && ((this.qGD == null) || (!paramString.equalsIgnoreCase(this.qGD))))
    {
      this.qGD = paramString;
      Uri.fromFile(new File(SelfQRCodeUI.access$800() + paramString));
      SelfQRCodeUI.cjW();
      ab.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
    }
    AppMethodBeat.o(127024);
  }
  
  public final void start()
  {
    AppMethodBeat.i(127025);
    super.startWatching();
    AppMethodBeat.o(127025);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(127026);
    super.stopWatching();
    AppMethodBeat.o(127026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.b
 * JD-Core Version:    0.7.0.1
 */