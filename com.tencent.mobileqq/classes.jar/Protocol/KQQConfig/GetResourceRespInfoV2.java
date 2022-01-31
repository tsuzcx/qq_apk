package protocol.KQQConfig;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class GetResourceRespInfoV2
  extends JceStruct
  implements Cloneable
{
  public byte cCanChangeState = 1;
  public byte cDefaultState;
  public byte cPush;
  public byte cStatus;
  public int iPluginType = 64;
  public short sLanType;
  public short sPriority;
  public short sResSubType;
  public String strNewPluginDesc = "";
  public String strNewPluginURL = "";
  public String strPkgName = "";
  public String strResConf = "";
  public String strResDesc = "";
  public String strResName = "";
  public String strResURL_big = "";
  public String strResURL_small = "";
  public long uiNewVer;
  public long uiResId;
  
  static
  {
    if (!GetResourceRespInfoV2.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GetResourceRespInfoV2() {}
  
  public GetResourceRespInfoV2(String paramString1, long paramLong1, short paramShort1, short paramShort2, short paramShort3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte paramByte1, byte paramByte2, long paramLong2, byte paramByte3, byte paramByte4, int paramInt, String paramString7, String paramString8)
  {
    this.strPkgName = paramString1;
    this.uiNewVer = paramLong1;
    this.sResSubType = paramShort1;
    this.sLanType = paramShort2;
    this.sPriority = paramShort3;
    this.strResName = paramString2;
    this.strResDesc = paramString3;
    this.strResURL_big = paramString4;
    this.strResURL_small = paramString5;
    this.strResConf = paramString6;
    this.cDefaultState = paramByte1;
    this.cCanChangeState = paramByte2;
    this.uiResId = paramLong2;
    this.cStatus = paramByte3;
    this.cPush = paramByte4;
    this.iPluginType = paramInt;
    this.strNewPluginDesc = paramString7;
    this.strNewPluginURL = paramString8;
  }
  
  public String className()
  {
    return "KQQConfig.GetResourceRespInfoV2";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.strPkgName, "strPkgName");
    paramStringBuilder.display(this.uiNewVer, "uiNewVer");
    paramStringBuilder.display(this.sResSubType, "sResSubType");
    paramStringBuilder.display(this.sLanType, "sLanType");
    paramStringBuilder.display(this.sPriority, "sPriority");
    paramStringBuilder.display(this.strResName, "strResName");
    paramStringBuilder.display(this.strResDesc, "strResDesc");
    paramStringBuilder.display(this.strResURL_big, "strResURL_big");
    paramStringBuilder.display(this.strResURL_small, "strResURL_small");
    paramStringBuilder.display(this.strResConf, "strResConf");
    paramStringBuilder.display(this.cDefaultState, "cDefaultState");
    paramStringBuilder.display(this.cCanChangeState, "cCanChangeState");
    paramStringBuilder.display(this.uiResId, "uiResId");
    paramStringBuilder.display(this.cStatus, "cStatus");
    paramStringBuilder.display(this.cPush, "cPush");
    paramStringBuilder.display(this.iPluginType, "iPluginType");
    paramStringBuilder.display(this.strNewPluginDesc, "strNewPluginDesc");
    paramStringBuilder.display(this.strNewPluginURL, "strNewPluginURL");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.strPkgName, true);
    paramStringBuilder.displaySimple(this.uiNewVer, true);
    paramStringBuilder.displaySimple(this.sResSubType, true);
    paramStringBuilder.displaySimple(this.sLanType, true);
    paramStringBuilder.displaySimple(this.sPriority, true);
    paramStringBuilder.displaySimple(this.strResName, true);
    paramStringBuilder.displaySimple(this.strResDesc, true);
    paramStringBuilder.displaySimple(this.strResURL_big, true);
    paramStringBuilder.displaySimple(this.strResURL_small, true);
    paramStringBuilder.displaySimple(this.strResConf, true);
    paramStringBuilder.displaySimple(this.cDefaultState, true);
    paramStringBuilder.displaySimple(this.cCanChangeState, true);
    paramStringBuilder.displaySimple(this.uiResId, true);
    paramStringBuilder.displaySimple(this.cStatus, true);
    paramStringBuilder.displaySimple(this.cPush, true);
    paramStringBuilder.displaySimple(this.iPluginType, true);
    paramStringBuilder.displaySimple(this.strNewPluginDesc, true);
    paramStringBuilder.displaySimple(this.strNewPluginURL, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (GetResourceRespInfoV2)paramObject;
    } while ((!JceUtil.equals(this.strPkgName, paramObject.strPkgName)) || (!JceUtil.equals(this.uiNewVer, paramObject.uiNewVer)) || (!JceUtil.equals(this.sResSubType, paramObject.sResSubType)) || (!JceUtil.equals(this.sLanType, paramObject.sLanType)) || (!JceUtil.equals(this.sPriority, paramObject.sPriority)) || (!JceUtil.equals(this.strResName, paramObject.strResName)) || (!JceUtil.equals(this.strResDesc, paramObject.strResDesc)) || (!JceUtil.equals(this.strResURL_big, paramObject.strResURL_big)) || (!JceUtil.equals(this.strResURL_small, paramObject.strResURL_small)) || (!JceUtil.equals(this.strResConf, paramObject.strResConf)) || (!JceUtil.equals(this.cDefaultState, paramObject.cDefaultState)) || (!JceUtil.equals(this.cCanChangeState, paramObject.cCanChangeState)) || (!JceUtil.equals(this.uiResId, paramObject.uiResId)) || (!JceUtil.equals(this.cStatus, paramObject.cStatus)) || (!JceUtil.equals(this.cPush, paramObject.cPush)) || (!JceUtil.equals(this.iPluginType, paramObject.iPluginType)) || (!JceUtil.equals(this.strNewPluginDesc, paramObject.strNewPluginDesc)) || (!JceUtil.equals(this.strNewPluginURL, paramObject.strNewPluginURL)));
    return true;
  }
  
  public String fullClassName()
  {
    return "protocol.KQQConfig.GetResourceRespInfoV2";
  }
  
  public byte getCCanChangeState()
  {
    return this.cCanChangeState;
  }
  
  public byte getCDefaultState()
  {
    return this.cDefaultState;
  }
  
  public byte getCPush()
  {
    return this.cPush;
  }
  
  public byte getCStatus()
  {
    return this.cStatus;
  }
  
  public int getIPluginType()
  {
    return this.iPluginType;
  }
  
  public short getSLanType()
  {
    return this.sLanType;
  }
  
  public short getSPriority()
  {
    return this.sPriority;
  }
  
  public short getSResSubType()
  {
    return this.sResSubType;
  }
  
  public String getStrNewPluginDesc()
  {
    return this.strNewPluginDesc;
  }
  
  public String getStrNewPluginURL()
  {
    return this.strNewPluginURL;
  }
  
  public String getStrPkgName()
  {
    return this.strPkgName;
  }
  
  public String getStrResConf()
  {
    return this.strResConf;
  }
  
  public String getStrResDesc()
  {
    return this.strResDesc;
  }
  
  public String getStrResName()
  {
    return this.strResName;
  }
  
  public String getStrResURL_big()
  {
    return this.strResURL_big;
  }
  
  public String getStrResURL_small()
  {
    return this.strResURL_small;
  }
  
  public long getUiNewVer()
  {
    return this.uiNewVer;
  }
  
  public long getUiResId()
  {
    return this.uiResId;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPkgName = paramJceInputStream.readString(1, true);
    this.uiNewVer = paramJceInputStream.read(this.uiNewVer, 2, true);
    this.sResSubType = paramJceInputStream.read(this.sResSubType, 3, true);
    this.sLanType = paramJceInputStream.read(this.sLanType, 4, true);
    this.sPriority = paramJceInputStream.read(this.sPriority, 5, true);
    this.strResName = paramJceInputStream.readString(6, true);
    this.strResDesc = paramJceInputStream.readString(7, true);
    this.strResURL_big = paramJceInputStream.readString(8, true);
    this.strResURL_small = paramJceInputStream.readString(9, true);
    this.strResConf = paramJceInputStream.readString(10, true);
    this.cDefaultState = paramJceInputStream.read(this.cDefaultState, 11, true);
    this.cCanChangeState = paramJceInputStream.read(this.cCanChangeState, 12, true);
    this.uiResId = paramJceInputStream.read(this.uiResId, 13, false);
    this.cStatus = paramJceInputStream.read(this.cStatus, 14, false);
    this.cPush = paramJceInputStream.read(this.cPush, 15, false);
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 16, false);
    this.strNewPluginDesc = paramJceInputStream.readString(17, false);
    this.strNewPluginURL = paramJceInputStream.readString(18, false);
  }
  
  public void setCCanChangeState(byte paramByte)
  {
    this.cCanChangeState = paramByte;
  }
  
  public void setCDefaultState(byte paramByte)
  {
    this.cDefaultState = paramByte;
  }
  
  public void setCPush(byte paramByte)
  {
    this.cPush = paramByte;
  }
  
  public void setCStatus(byte paramByte)
  {
    this.cStatus = paramByte;
  }
  
  public void setIPluginType(int paramInt)
  {
    this.iPluginType = paramInt;
  }
  
  public void setSLanType(short paramShort)
  {
    this.sLanType = paramShort;
  }
  
  public void setSPriority(short paramShort)
  {
    this.sPriority = paramShort;
  }
  
  public void setSResSubType(short paramShort)
  {
    this.sResSubType = paramShort;
  }
  
  public void setStrNewPluginDesc(String paramString)
  {
    this.strNewPluginDesc = paramString;
  }
  
  public void setStrNewPluginURL(String paramString)
  {
    this.strNewPluginURL = paramString;
  }
  
  public void setStrPkgName(String paramString)
  {
    this.strPkgName = paramString;
  }
  
  public void setStrResConf(String paramString)
  {
    this.strResConf = paramString;
  }
  
  public void setStrResDesc(String paramString)
  {
    this.strResDesc = paramString;
  }
  
  public void setStrResName(String paramString)
  {
    this.strResName = paramString;
  }
  
  public void setStrResURL_big(String paramString)
  {
    this.strResURL_big = paramString;
  }
  
  public void setStrResURL_small(String paramString)
  {
    this.strResURL_small = paramString;
  }
  
  public void setUiNewVer(long paramLong)
  {
    this.uiNewVer = paramLong;
  }
  
  public void setUiResId(long paramLong)
  {
    this.uiResId = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPkgName, 1);
    paramJceOutputStream.write(this.uiNewVer, 2);
    paramJceOutputStream.write(this.sResSubType, 3);
    paramJceOutputStream.write(this.sLanType, 4);
    paramJceOutputStream.write(this.sPriority, 5);
    paramJceOutputStream.write(this.strResName, 6);
    paramJceOutputStream.write(this.strResDesc, 7);
    paramJceOutputStream.write(this.strResURL_big, 8);
    paramJceOutputStream.write(this.strResURL_small, 9);
    paramJceOutputStream.write(this.strResConf, 10);
    paramJceOutputStream.write(this.cDefaultState, 11);
    paramJceOutputStream.write(this.cCanChangeState, 12);
    paramJceOutputStream.write(this.uiResId, 13);
    paramJceOutputStream.write(this.cStatus, 14);
    paramJceOutputStream.write(this.cPush, 15);
    paramJceOutputStream.write(this.iPluginType, 16);
    if (this.strNewPluginDesc != null) {
      paramJceOutputStream.write(this.strNewPluginDesc, 17);
    }
    if (this.strNewPluginURL != null) {
      paramJceOutputStream.write(this.strNewPluginURL, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceRespInfoV2
 * JD-Core Version:    0.7.0.1
 */