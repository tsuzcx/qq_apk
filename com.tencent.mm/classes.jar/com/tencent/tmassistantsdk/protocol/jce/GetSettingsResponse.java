package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class GetSettingsResponse
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "GetSettingsResponse";
  static ArrayList<SettingsCfg> cache_settings;
  public int ret = 0;
  public ArrayList<SettingsCfg> settings = null;
  
  static
  {
    AppMethodBeat.i(102307);
    if (!GetSettingsResponse.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102307);
      return;
    }
  }
  
  public GetSettingsResponse() {}
  
  public GetSettingsResponse(int paramInt, ArrayList<SettingsCfg> paramArrayList)
  {
    this.ret = paramInt;
    this.settings = paramArrayList;
  }
  
  public final String className()
  {
    return "jce.GetSettingsResponse";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102302);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(102302);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102302);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102305);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.ret, "ret");
    paramStringBuilder.display(this.settings, "settings");
    AppMethodBeat.o(102305);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102306);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.ret, true);
    paramStringBuilder.displaySimple(this.settings, false);
    AppMethodBeat.o(102306);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102300);
    if (paramObject == null)
    {
      AppMethodBeat.o(102300);
      return false;
    }
    paramObject = (GetSettingsResponse)paramObject;
    if ((JceUtil.equals(this.ret, paramObject.ret)) && (JceUtil.equals(this.settings, paramObject.settings)))
    {
      AppMethodBeat.o(102300);
      return true;
    }
    AppMethodBeat.o(102300);
    return false;
  }
  
  public final String fullClassName()
  {
    return "GetSettingsResponse";
  }
  
  public final int getRet()
  {
    return this.ret;
  }
  
  public final ArrayList<SettingsCfg> getSettings()
  {
    return this.settings;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102301);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102301);
      throw localException1;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("GetSettingsResponse", localException2, "", new Object[0]);
      AppMethodBeat.o(102301);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102304);
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    if (cache_settings == null)
    {
      cache_settings = new ArrayList();
      SettingsCfg localSettingsCfg = new SettingsCfg();
      cache_settings.add(localSettingsCfg);
    }
    this.settings = ((ArrayList)paramJceInputStream.read(cache_settings, 1, false));
    AppMethodBeat.o(102304);
  }
  
  public final void setRet(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public final void setSettings(ArrayList<SettingsCfg> paramArrayList)
  {
    this.settings = paramArrayList;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102303);
    paramJceOutputStream.write(this.ret, 0);
    if (this.settings != null) {
      paramJceOutputStream.write(this.settings, 1);
    }
    AppMethodBeat.o(102303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse
 * JD-Core Version:    0.7.0.1
 */