package com.tencent.xweb.xwalk.plugin;

import com.tencent.xweb.util.c;
import com.tencent.xweb.util.e;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a
  extends b
{
  public final int a(c.a parama)
  {
    if (c.gR(parama.path, parama.bIW))
    {
      KJ(parama.version);
      return 0;
    }
    parama = new File(parama.path);
    if (parama.exists()) {
      parama.delete();
    }
    e.cTs();
    return -1;
  }
  
  public final String az(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (XWalkEnvironment.getApplicationContext() == null)
    {
      Log.e("XWalkPlugin", "get dir of " + cTE() + " context is null");
      localObject = "";
    }
    while ((localObject == null) || (((String)localObject).isEmpty()))
    {
      return "";
      String str = XWalkEnvironment.getPluginBaseDir() + File.separator + cTE() + "_" + paramInt;
      File localFile = new File(str);
      localObject = str;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        localObject = str;
      }
    }
    if (!paramBoolean) {
      return (String)localObject + File.separator + "xweb_fullscreen_video.js";
    }
    return (String)localObject + File.separator + "patch";
  }
  
  public final String cTE()
  {
    return "FullScreenVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.plugin.a
 * JD-Core Version:    0.7.0.1
 */