package com.tencent.mm.ui.f.a;

import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a$1
  implements Runnable
{
  public a$1(a parama, String paramString1, Bundle paramBundle, String paramString2, a.a parama1) {}
  
  public final void run()
  {
    try
    {
      String str = this.vVI.vVC.a(this.vVD, this.vVE, this.vVF);
      this.vVG.pW(str);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      this.vVG.a(localFileNotFoundException);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.vVG.a(localMalformedURLException);
      return;
    }
    catch (IOException localIOException)
    {
      this.vVG.b(localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.f.a.a.1
 * JD-Core Version:    0.7.0.1
 */