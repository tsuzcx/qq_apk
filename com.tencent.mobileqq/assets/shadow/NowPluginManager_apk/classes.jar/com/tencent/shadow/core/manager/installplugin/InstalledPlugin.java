package com.tencent.shadow.core.manager.installplugin;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class InstalledPlugin
  implements Serializable
{
  public String UUID;
  public String UUID_NickName;
  public Part pluginLoaderFile;
  public Map<String, PluginPart> plugins = new HashMap();
  public Part runtimeFile;
  
  public Part getPart(String paramString)
  {
    return (Part)this.plugins.get(paramString);
  }
  
  public PluginPart getPlugin(String paramString)
  {
    return (PluginPart)this.plugins.get(paramString);
  }
  
  public boolean hasPart(String paramString)
  {
    return this.plugins.containsKey(paramString);
  }
  
  public static class Part
    implements Serializable
  {
    public File libraryDir;
    public File oDexDir;
    public final File pluginFile;
    public final int pluginType;
    
    Part(int paramInt, File paramFile1, File paramFile2, File paramFile3)
    {
      this.pluginType = paramInt;
      this.oDexDir = paramFile2;
      this.libraryDir = paramFile3;
      this.pluginFile = paramFile1;
    }
  }
  
  public static class PluginPart
    extends InstalledPlugin.Part
  {
    public final String businessName;
    public final String[] dependsOn;
    public final String[] hostWhiteList;
    
    PluginPart(int paramInt, String paramString, File paramFile1, File paramFile2, File paramFile3, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      super(paramFile1, paramFile2, paramFile3);
      this.businessName = paramString;
      this.dependsOn = paramArrayOfString1;
      this.hostWhiteList = paramArrayOfString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.manager.installplugin.InstalledPlugin
 * JD-Core Version:    0.7.0.1
 */