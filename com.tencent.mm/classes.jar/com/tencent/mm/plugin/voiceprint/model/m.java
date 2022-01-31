package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac;
import java.io.File;

public final class m
{
  public static String bh(String paramString, boolean paramBoolean)
  {
    String str = ac.dOP;
    y.i("MicroMsg.VoicePrintLogic", "dbCachePath " + str);
    if (str.endsWith(File.separator))
    {
      paramString = str + paramString;
      y.i("MicroMsg.VoicePrintLogic", "genpath " + paramString);
      if (!bk.bl(paramString)) {
        break label114;
      }
      str = null;
    }
    label114:
    do
    {
      do
      {
        return str;
        paramString = str + File.separator + paramString;
        break;
        str = paramString;
      } while (paramBoolean);
      str = paramString;
    } while (!new File(paramString).exists());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.m
 * JD-Core Version:    0.7.0.1
 */