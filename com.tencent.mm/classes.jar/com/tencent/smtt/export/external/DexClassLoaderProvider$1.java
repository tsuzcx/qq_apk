package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.TimerTask;

final class DexClassLoaderProvider$1
  extends TimerTask
{
  DexClassLoaderProvider$1(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    AppMethodBeat.i(63721);
    try
    {
      ArrayList localArrayList = new ArrayList(4);
      localArrayList.add(0, this.val$dexName);
      localArrayList.add(1, this.val$dexPath);
      localArrayList.add(2, this.val$optimizedDirectory);
      localArrayList.add(3, this.val$libraryPath);
      Intent localIntent = new Intent(DexClassLoaderProvider.access$000(), DexClassLoaderProviderService.class);
      localIntent.putStringArrayListExtra("dex2oat", localArrayList);
      DexClassLoaderProvider.access$000().startService(localIntent);
      new StringBuilder("shouldUseDexLoaderService(").append(this.val$dexName).append(", ").append(localIntent).append(")");
      AppMethodBeat.o(63721);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      AppMethodBeat.o(63721);
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("after shouldUseDexLoaderService exception: ").append(localThrowable);
      AppMethodBeat.o(63721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider.1
 * JD-Core Version:    0.7.0.1
 */