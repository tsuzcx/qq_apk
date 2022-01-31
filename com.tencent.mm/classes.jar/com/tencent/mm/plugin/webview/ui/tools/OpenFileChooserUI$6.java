package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

final class OpenFileChooserUI$6
  implements Runnable
{
  OpenFileChooserUI$6(OpenFileChooserUI paramOpenFileChooserUI, String paramString) {}
  
  public final void run()
  {
    Object localObject1 = new ArrayList();
    int i = OpenFileChooserUI.a(this.rlE, this.dlh);
    if (i == -50002)
    {
      ai.d(new OpenFileChooserUI.6.1(this));
      return;
    }
    Object localObject2;
    if (i == -50006)
    {
      localObject1 = OpenFileChooserUI.r(this.dlh, (List)localObject1);
      OpenFileChooserUI.b(this.rlE, this.dlh);
      localObject2 = OpenFileChooserUI.d(this.rlE);
    }
    while (!bk.bl((String)localObject1))
    {
      ai.d(new OpenFileChooserUI.6.4(this, (String)localObject1, (String)localObject2));
      return;
      if (i == 1)
      {
        String str1 = OpenFileChooserUI.c(this.rlE, this.dlh);
        OpenFileChooserUI.b(this.rlE, this.dlh);
        String str2 = OpenFileChooserUI.d(this.rlE);
        localObject2 = str2;
        localObject1 = str1;
        if (bk.bl(str1))
        {
          localObject2 = str2;
          localObject1 = str1;
          if (OpenFileChooserUI.b(this.rlE) == 7)
          {
            localObject2 = str2;
            localObject1 = str1;
            if (OpenFileChooserUI.c(this.rlE) == 2) {
              ai.d(new OpenFileChooserUI.6.2(this));
            }
          }
        }
      }
      else
      {
        ai.d(new OpenFileChooserUI.6.3(this));
        return;
      }
    }
    ai.d(new OpenFileChooserUI.6.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6
 * JD-Core Version:    0.7.0.1
 */