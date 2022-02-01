package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class c
{
  private static final String[] YBw = { "${sdFrom}/MicroMsg/xlog", "${sdTo}/MicroMsg/${accountSalt}/bizmsg", "${sdFrom}/MicroMsg/${accountSalt}/bizmsg", "${sdFrom}/MicroMsg/${accountSalt}/sfs", "${sdTo}/MicroMsg/${accountSalt}/sfs", "${sdFrom}/MicroMsg/wxavideocache", "${sdTo}/MicroMsg/wxavideocache", "${sdFrom}/MicroMsg/wxvideocache", "${sdTo}/MicroMsg/wxvideocache", "${sdTo}/MicroMsg/${accountSalt}/backup", "${sdFrom}/MicroMsg/${accountSalt}/backup", "${dataCache}/cpsafe" };
  
  static void a(h.a parama)
  {
    AppMethodBeat.i(206719);
    Object localObject1 = new FileSystem[YBw.length];
    int i = 0;
    while (i < localObject1.length)
    {
      localObject1[i] = new DeleteAllFileSystem(new NativeFileSystem(YBw[i]));
      i += 1;
    }
    parama.b("@CleanRubbish", new MaintenanceGroup((FileSystem[])localObject1));
    Pattern localPattern = Pattern.compile("[0-9a-f]{32}(temp[0-9]+)?");
    Object localObject2;
    try
    {
      localObject2 = new NativeFileSystem("${sdFrom}/MicroMsg").cp(h.iWH().iWM()).dJ("", false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Collections.emptyList();
      }
      localObject2 = new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        f localf = (f)((Iterator)localObject1).next();
        if (localf.YCj)
        {
          Object localObject3 = localPattern.matcher(localf.name);
          if (((Matcher)localObject3).matches())
          {
            localObject3 = ((Matcher)localObject3).group(1);
            if (((localObject3 != null) && (!((String)localObject3).isEmpty())) || (ab.YFr))
            {
              ((ArrayList)localObject2).add(new DeleteAllFileSystem(new NativeFileSystem("${sdFrom}/MicroMsg/" + localf.name)));
              continue;
              b(parama);
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("VFS.CleanRubbish", localException, "Failed installing wild account cleaner", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(206719);
      return;
      if (!((ArrayList)localObject2).isEmpty()) {
        parama.b("@CleanAbandon", new MaintenanceGroup((Collection)localObject2));
      }
    }
  }
  
  private static void b(h.a parama)
  {
    AppMethodBeat.i(206724);
    Pattern localPattern = Pattern.compile("old_org\\.chromium\\.android_webview_[0-9]+");
    Object localObject2;
    try
    {
      localObject2 = new NativeFileSystem("${dataCache}").cp(h.iWH().iWM()).dJ("", false);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Collections.emptyList();
      }
      localObject2 = new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        f localf = (f)((Iterator)localObject1).next();
        if ((localf.YCj) && (localPattern.matcher(localf.name).matches())) {
          ((ArrayList)localObject2).add(new DeleteAllFileSystem(new NativeFileSystem("${dataCache}/" + localf.name)));
        }
      }
      if (((ArrayList)localObject2).isEmpty()) {
        break label189;
      }
    }
    catch (Exception parama)
    {
      Log.printErrStackTrace("VFS.CleanRubbish", parama, "Failed installing old WebView cache cleaner", new Object[0]);
      AppMethodBeat.o(206724);
      return;
    }
    parama.b("@CleanOldWebViewCache", new MaintenanceGroup((Collection)localObject2));
    label189:
    AppMethodBeat.o(206724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.c
 * JD-Core Version:    0.7.0.1
 */