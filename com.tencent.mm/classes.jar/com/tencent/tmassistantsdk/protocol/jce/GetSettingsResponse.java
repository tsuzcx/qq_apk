package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(76061);
    if (!GetSettingsResponse.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(76061);
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
    AppMethodBeat.i(76056);
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
      AppMethodBeat.o(76056);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(76056);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76059);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.ret, "ret");
    paramStringBuilder.display(this.settings, "settings");
    AppMethodBeat.o(76059);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76060);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.ret, true);
    paramStringBuilder.displaySimple(this.settings, false);
    AppMethodBeat.o(76060);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76054);
    if (paramObject == null)
    {
      AppMethodBeat.o(76054);
      return false;
    }
    paramObject = (GetSettingsResponse)paramObject;
    if ((JceUtil.equals(this.ret, paramObject.ret)) && (JceUtil.equals(this.settings, paramObject.settings)))
    {
      AppMethodBeat.o(76054);
      return true;
    }
    AppMethodBeat.o(76054);
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
    AppMethodBeat.i(76055);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(76055);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("GetSettingsResponse", localException2, "", new Object[0]);
      AppMethodBeat.o(76055);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76058);
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    if (cache_settings == null)
    {
      cache_settings = new ArrayList();
      SettingsCfg localSettingsCfg = new SettingsCfg();
      cache_settings.add(localSettingsCfg);
    }
    this.settings = ((ArrayList)paramJceInputStream.read(cache_settings, 1, false));
    AppMethodBeat.o(76058);
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
    AppMethodBeat.i(76057);
    paramJceOutputStream.write(this.ret, 0);
    if (this.settings != null) {
      paramJceOutputStream.write(this.settings, 1);
    }
    AppMethodBeat.o(76057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse
 * JD-Core Version:    0.7.0.1
 */