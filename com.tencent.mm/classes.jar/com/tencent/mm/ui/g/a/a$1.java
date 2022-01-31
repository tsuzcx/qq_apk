package com.tencent.mm.ui.g.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public final class a$1
  implements Runnable
{
  public a$1(a parama, String paramString1, Bundle paramBundle, String paramString2, a.a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(80293);
    try
    {
      String str = this.AnL.AnG.a(this.AnH, this.val$parameters, this.AnI);
      this.AnJ.xs(str);
      AppMethodBeat.o(80293);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      this.AnJ.a(localFileNotFoundException);
      AppMethodBeat.o(80293);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      this.AnJ.a(localMalformedURLException);
      AppMethodBeat.o(80293);
      return;
    }
    catch (IOException localIOException)
    {
      this.AnJ.c(localIOException);
      AppMethodBeat.o(80293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.a.1
 * JD-Core Version:    0.7.0.1
 */