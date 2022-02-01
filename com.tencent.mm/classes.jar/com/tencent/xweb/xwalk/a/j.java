package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.Log;

public final class j
{
  public static List<j.a> ak(File paramFile)
  {
    AppMethodBeat.i(157197);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localBufferedReader = new BufferedReader(new FileReader(paramFile));
      }
      finally
      {
        int i;
        int k;
        Object localObject4;
        j.a locala;
        paramFile = null;
        try
        {
          Log.e("XWalkPluginPatchConfigP", "getPluginPatchConfigList error:".concat(String.valueOf(localObject1)));
          return null;
        }
        finally
        {
          g.d(paramFile);
          AppMethodBeat.o(157197);
        }
      }
      try
      {
        paramFile = localBufferedReader.readLine();
        if (paramFile == null) {
          continue;
        }
        if (paramFile.isEmpty()) {
          continue;
        }
        if (!paramFile.startsWith("ADD:")) {
          continue;
        }
        paramFile = paramFile.substring(4);
        i = 1;
        paramFile = paramFile.split(",");
        k = paramFile.length;
        j = 0;
      }
      finally
      {
        paramFile = localBufferedReader;
        continue;
        j += 1;
        continue;
      }
      if (j < k)
      {
        localObject4 = paramFile[j];
        if ((localObject4 == null) || (localObject4.isEmpty())) {
          break label324;
        }
        locala = new j.a();
        locala.aipT = localObject4;
        locala.type = i;
        if (i == 2) {
          locala.aipS = (locala.aipT + ".patch");
        }
        Log.i("XWalkPluginPatchConfigP", "getPluginPatchConfigList config:" + locala.toString());
        localArrayList.add(locala);
        break label324;
        if (paramFile.startsWith("MOD:"))
        {
          paramFile = paramFile.substring(4);
          i = 2;
        }
        else
        {
          if (!paramFile.startsWith("DEL:")) {
            continue;
          }
          paramFile = paramFile.substring(4);
          i = 3;
        }
      }
    }
    Log.e("XWalkPluginPatchConfigP", "getPluginPatchConfigList unknown flag:".concat(String.valueOf(paramFile)));
    g.d(localBufferedReader);
    AppMethodBeat.o(157197);
    return null;
    g.d(localBufferedReader);
    AppMethodBeat.o(157197);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.j
 * JD-Core Version:    0.7.0.1
 */