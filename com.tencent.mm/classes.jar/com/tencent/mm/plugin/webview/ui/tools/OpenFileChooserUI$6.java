package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

final class OpenFileChooserUI$6
  implements Runnable
{
  OpenFileChooserUI$6(OpenFileChooserUI paramOpenFileChooserUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(7454);
    Object localObject1 = new ArrayList();
    int i = OpenFileChooserUI.a(this.vbg, this.val$path);
    if (i == -50002)
    {
      al.d(new OpenFileChooserUI.6.1(this));
      AppMethodBeat.o(7454);
      return;
    }
    Object localObject2;
    if (i == -50006)
    {
      localObject1 = OpenFileChooserUI.t(this.val$path, (List)localObject1);
      OpenFileChooserUI.b(this.vbg, this.val$path);
      localObject2 = OpenFileChooserUI.d(this.vbg);
    }
    while (!bo.isNullOrNil((String)localObject1))
    {
      al.d(new OpenFileChooserUI.6.4(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(7454);
      return;
      if (i == 1)
      {
        String str1 = OpenFileChooserUI.c(this.vbg, this.val$path);
        OpenFileChooserUI.b(this.vbg, this.val$path);
        String str2 = OpenFileChooserUI.d(this.vbg);
        localObject2 = str2;
        localObject1 = str1;
        if (bo.isNullOrNil(str1))
        {
          localObject2 = str2;
          localObject1 = str1;
          if (OpenFileChooserUI.b(this.vbg) == 7)
          {
            localObject2 = str2;
            localObject1 = str1;
            if (OpenFileChooserUI.c(this.vbg) == 2)
            {
              al.d(new OpenFileChooserUI.6.2(this));
              AppMethodBeat.o(7454);
            }
          }
        }
      }
      else
      {
        al.d(new OpenFileChooserUI.6.3(this));
        AppMethodBeat.o(7454);
        return;
      }
    }
    al.d(new OpenFileChooserUI.6.5(this));
    AppMethodBeat.o(7454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6
 * JD-Core Version:    0.7.0.1
 */