package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.f;
import com.tencent.mm.b.g;
import com.tencent.mm.bx.b;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdSnsInfo
  extends f
{
  public static final String COL_ID = "rowid";
  public static final String TABLEINDEXHEAD = "serverAdSnsTimeHeadIndex";
  public static final String TABLEINDEXLOCALFLAG = "AdsnsLocalflagIndex";
  public static final String TABLEINDEXMULTI1 = "adsnsMultiIndex1";
  public static final String TABLEINDEXMULTI2 = "adsnsMultiIndex2";
  public static final String TABLEINDEXSOURCE = "serverAdSnsTimeSourceTypeIndex";
  public static final String TABLEINDEXTIME = "serverAdSnsTimeIndex";
  public static final String TABLEINDEXUSERNAME = "serverAdSnsNameIndex";
  public static final String TAG = "MicroMsg.AdSnsInfo";
  protected static Map<String, ADInfo> cacheAdInfo;
  protected static Map<String, ADXml> cacheAdXml;
  protected static IAutoDBItem.MAutoDBInfo info;
  public String contentByteMd5 = null;
  protected int localid;
  
  static
  {
    AppMethodBeat.i(97433);
    info = f.initAutoDBInfo(AdSnsInfo.class);
    cacheAdXml = new ConcurrentHashMap();
    cacheAdInfo = new ConcurrentHashMap();
    AppMethodBeat.o(97433);
  }
  
  public void addSourceFlag(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public ContentValues convertFrom(ContentValues paramContentValues)
  {
    AppMethodBeat.i(306673);
    this.field_snsId = paramContentValues.getAsLong("snsId").longValue();
    this.field_userName = paramContentValues.getAsString("userName");
    this.field_localFlag = paramContentValues.getAsInteger("localFlag").intValue();
    this.field_createTime = paramContentValues.getAsInteger("createTime").intValue();
    this.field_head = paramContentValues.getAsInteger("head").intValue();
    this.field_localPrivate = paramContentValues.getAsInteger("localPrivate").intValue();
    this.field_type = paramContentValues.getAsInteger("type").intValue();
    this.field_sourceType = paramContentValues.getAsInteger("sourceType").intValue();
    this.field_likeFlag = paramContentValues.getAsInteger("likeFlag").intValue();
    this.field_pravited = paramContentValues.getAsInteger("pravited").intValue();
    this.field_stringSeq = paramContentValues.getAsString("stringSeq");
    this.field_content = paramContentValues.getAsByteArray("content");
    this.field_attrBuf = paramContentValues.getAsByteArray("attrBuf");
    this.field_postBuf = paramContentValues.getAsByteArray("postBuf");
    this.field_adinfo = paramContentValues.getAsString("adinfo");
    this.field_adxml = paramContentValues.getAsString("adxml");
    this.field_createAdTime = paramContentValues.getAsInteger("createAdTime").intValue();
    this.field_exposureTime = paramContentValues.getAsInteger("exposureTime").intValue();
    this.field_firstControlTime = paramContentValues.getAsInteger("firstControlTime").intValue();
    this.field_recxml = paramContentValues.getAsString("recxml");
    this.field_subType = paramContentValues.getAsInteger("subType").intValue();
    this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    this.field_atAdinfo = paramContentValues.getAsString("atAdinfo");
    this.field_remindInfoGroup = paramContentValues.getAsByteArray("remindInfoGroup");
    AppMethodBeat.o(306673);
    return paramContentValues;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97430);
    super.convertFrom(paramCursor);
    this.localid = ((int)this.systemRowid);
    AppMethodBeat.o(97430);
  }
  
  public SnsInfo convertToSnsInfo()
  {
    AppMethodBeat.i(97429);
    SnsInfo localSnsInfo = new SnsInfo();
    localSnsInfo.setTimeLine(getTimeLine());
    Log.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[] { Long.valueOf(this.field_snsId) });
    localSnsInfo.setLocalid(this.localid);
    localSnsInfo.setUserName(this.field_userName);
    localSnsInfo.setCreateTime(this.field_createTime);
    localSnsInfo.setLikeFlag(this.field_likeFlag);
    localSnsInfo.setSnsId(this.field_snsId);
    localSnsInfo.field_sourceType = this.field_sourceType;
    localSnsInfo.field_content = this.field_content;
    localSnsInfo.addSourceFlag(2);
    localSnsInfo.addSourceFlag(32);
    localSnsInfo.field_attrBuf = this.field_attrBuf;
    TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
    localTimeLineObject.UserName = this.field_userName;
    localSnsInfo.setPravited(localTimeLineObject.Privated);
    localSnsInfo.setExtFlag();
    localSnsInfo.setTimeLine(localTimeLineObject);
    if (localTimeLineObject.ContentObj != null)
    {
      localSnsInfo.setTypeFlag(localTimeLineObject.ContentObj.Zpq);
      localSnsInfo.setSubTypeFlag(localTimeLineObject.ContentObj.Zps);
    }
    localSnsInfo.setAdSnsInfo(this);
    AppMethodBeat.o(97429);
    return localSnsInfo;
  }
  
  public ADInfo getAdInfo()
  {
    AppMethodBeat.i(97412);
    ADInfo localADInfo;
    if (this.field_adinfo != null)
    {
      if (cacheAdInfo.containsKey(this.field_adinfo))
      {
        localADInfo = (ADInfo)cacheAdInfo.get(this.field_adinfo);
        AppMethodBeat.o(97412);
        return localADInfo;
      }
      localADInfo = new ADInfo(this.field_adinfo);
      cacheAdInfo.put(this.field_adinfo, localADInfo);
    }
    for (;;)
    {
      if (localADInfo == null)
      {
        localADInfo = new ADInfo(null);
        AppMethodBeat.o(97412);
        return localADInfo;
      }
      AppMethodBeat.o(97412);
      return localADInfo;
      localADInfo = null;
    }
  }
  
  public ADXml getAdXml()
  {
    AppMethodBeat.i(97410);
    ADXml localADXml;
    if (this.field_adxml != null)
    {
      if (cacheAdXml.containsKey(this.field_adxml))
      {
        localADXml = (ADXml)cacheAdXml.get(this.field_adxml);
        AppMethodBeat.o(97410);
        return localADXml;
      }
      localADXml = new ADXml(this.field_adxml);
      cacheAdXml.put(this.field_adxml, localADXml);
    }
    for (;;)
    {
      if (localADXml == null)
      {
        localADXml = new ADXml(null);
        AppMethodBeat.o(97410);
        return localADXml;
      }
      AppMethodBeat.o(97410);
      return localADXml;
      localADXml = null;
    }
  }
  
  public ADInfo getAtAdInfo()
  {
    AppMethodBeat.i(97413);
    ADInfo localADInfo;
    if (this.field_atAdinfo != null)
    {
      if (cacheAdInfo.containsKey(this.field_atAdinfo))
      {
        localADInfo = (ADInfo)cacheAdInfo.get(this.field_atAdinfo);
        AppMethodBeat.o(97413);
        return localADInfo;
      }
      localADInfo = new ADInfo(this.field_atAdinfo);
      cacheAdInfo.put(this.field_atAdinfo, localADInfo);
    }
    for (;;)
    {
      if (localADInfo == null)
      {
        localADInfo = new ADInfo(null);
        AppMethodBeat.o(97413);
        return localADInfo;
      }
      AppMethodBeat.o(97413);
      return localADInfo;
      localADInfo = null;
    }
  }
  
  public b getAtFriendRemindInfoSelfInfo()
  {
    AppMethodBeat.i(97426);
    if ((getRemindInfoGroup() != null) && (getRemindInfoGroup().YFa != null) && (getRemindInfoGroup().YFa.abtA != null))
    {
      b localb = getRemindInfoGroup().YFa.abtA.aaxD;
      AppMethodBeat.o(97426);
      return localb;
    }
    AppMethodBeat.o(97426);
    return null;
  }
  
  public b getAtFriendRemindInfoSourceInfo()
  {
    AppMethodBeat.i(97425);
    if ((getRemindInfoGroup() != null) && (getRemindInfoGroup().YFa != null) && (getRemindInfoGroup().YFa.abtz != null))
    {
      b localb = getRemindInfoGroup().YFa.abtz.aaxD;
      AppMethodBeat.o(97425);
      return localb;
    }
    AppMethodBeat.o(97425);
    return null;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public int getExpId()
  {
    AppMethodBeat.i(97417);
    ADXml localADXml = getRecXml();
    if (localADXml == null)
    {
      AppMethodBeat.o(97417);
      return 0;
    }
    int i = localADXml.recExpId;
    AppMethodBeat.o(97417);
    return i;
  }
  
  public String getLocalid()
  {
    AppMethodBeat.i(306659);
    String str = ai.bF("ad_table_", this.localid);
    AppMethodBeat.o(306659);
    return str;
  }
  
  public int getRecSrc()
  {
    AppMethodBeat.i(97415);
    ADXml localADXml = getRecXml();
    if (localADXml == null)
    {
      AppMethodBeat.o(97415);
      return 0;
    }
    int i = localADXml.recSrc;
    AppMethodBeat.o(97415);
    return i;
  }
  
  public ADXml getRecXml()
  {
    AppMethodBeat.i(97411);
    ADXml localADXml;
    if (this.field_recxml != null)
    {
      if (cacheAdXml.containsKey(this.field_recxml))
      {
        localADXml = (ADXml)cacheAdXml.get(this.field_recxml);
        AppMethodBeat.o(97411);
        return localADXml;
      }
      localADXml = new ADXml(this.field_recxml);
      cacheAdXml.put(this.field_recxml, localADXml);
    }
    for (;;)
    {
      if (localADXml == null)
      {
        localADXml = new ADXml(null);
        AppMethodBeat.o(97411);
        return localADXml;
      }
      AppMethodBeat.o(97411);
      return localADXml;
      localADXml = null;
    }
  }
  
  /* Error */
  public cs getRemindInfoGroup()
  {
    // Byte code:
    //   0: ldc_w 409
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 227	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_remindInfoGroup	[B
    //   10: ifnull +63 -> 73
    //   13: new 358	com/tencent/mm/protocal/protobuf/cs
    //   16: dup
    //   17: invokespecial 410	com/tencent/mm/protocal/protobuf/cs:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 227	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_remindInfoGroup	[B
    //   26: invokevirtual 414	com/tencent/mm/protocal/protobuf/cs:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   29: pop
    //   30: ldc_w 409
    //   33: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_1
    //   37: areturn
    //   38: astore_2
    //   39: aconst_null
    //   40: astore_1
    //   41: ldc 32
    //   43: new 416	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 418
    //   50: invokespecial 419	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: aload_2
    //   54: invokevirtual 422	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   57: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: goto -36 -> 30
    //   69: astore_2
    //   70: goto -29 -> 41
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -45 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	AdSnsInfo
    //   20	55	1	localcs	cs
    //   38	16	2	localException1	Exception
    //   69	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	21	38	java/lang/Exception
    //   21	30	69	java/lang/Exception
  }
  
  public String getSnsId()
  {
    AppMethodBeat.i(97428);
    String str = ai.bE("ad_table_", this.field_snsId);
    AppMethodBeat.o(97428);
    return str;
  }
  
  public int getSource()
  {
    AppMethodBeat.i(97416);
    ADXml localADXml = getRecXml();
    if (localADXml == null)
    {
      AppMethodBeat.o(97416);
      return 0;
    }
    int i = localADXml.recSrc;
    AppMethodBeat.o(97416);
    return i;
  }
  
  public TimeLineObject getTimeLine()
  {
    AppMethodBeat.i(97420);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = o.bMJ();
      AppMethodBeat.o(97420);
      return localTimeLineObject1;
    }
    if (this.contentByteMd5 == null) {
      this.contentByteMd5 = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    }
    if (SnsInfo.cacheTimeLine.containsKey(this.contentByteMd5))
    {
      localTimeLineObject1 = (TimeLineObject)SnsInfo.cacheTimeLine.get(this.contentByteMd5);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97420);
        return localTimeLineObject1;
      }
    }
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      SnsInfo.cacheTimeLine.put(this.contentByteMd5, localTimeLineObject1);
      AppMethodBeat.o(97420);
      return localTimeLineObject1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
      TimeLineObject localTimeLineObject2 = o.bMJ();
      AppMethodBeat.o(97420);
      return localTimeLineObject2;
    }
  }
  
  public b getTimelineRemindInfoSelfInfo()
  {
    AppMethodBeat.i(97424);
    if ((getRemindInfoGroup() != null) && (getRemindInfoGroup().YEZ != null) && (getRemindInfoGroup().YEZ.abtA != null))
    {
      b localb = getRemindInfoGroup().YEZ.abtA.aaxD;
      AppMethodBeat.o(97424);
      return localb;
    }
    AppMethodBeat.o(97424);
    return null;
  }
  
  public b getTimelineRemindInfoSourceInfo()
  {
    AppMethodBeat.i(97423);
    if ((getRemindInfoGroup() != null) && (getRemindInfoGroup().YEZ != null) && (getRemindInfoGroup().YEZ.abtz != null))
    {
      b localb = getRemindInfoGroup().YEZ.abtz.aaxD;
      AppMethodBeat.o(97423);
      return localb;
    }
    AppMethodBeat.o(97423);
    return null;
  }
  
  public boolean isExposured()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public boolean isLocalInvisible()
  {
    return (this.field_localFlag & 0x100) > 0;
  }
  
  public boolean isRecExpAd()
  {
    AppMethodBeat.i(97414);
    ADXml localADXml = getAdXml();
    if (localADXml != null)
    {
      boolean bool = localADXml.isRecExpAd();
      AppMethodBeat.o(97414);
      return bool;
    }
    AppMethodBeat.o(97414);
    return false;
  }
  
  public boolean isSourceExist(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public void readFromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(97432);
    if (paramBundle == null)
    {
      AppMethodBeat.o(97432);
      return;
    }
    convertFrom((ContentValues)paramBundle.getParcelable("values"));
    this.localid = paramBundle.getInt("localid");
    AppMethodBeat.o(97432);
  }
  
  public void removeSourceFlag(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setAttrBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97427);
    this.field_attrBuf = paramArrayOfByte;
    this.contentByteMd5 = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97427);
  }
  
  public boolean setContent(String paramString)
  {
    AppMethodBeat.i(97419);
    paramString = o.Pm(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.contentByteMd5 = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97419);
      return true;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AdSnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(97419);
    }
    return false;
  }
  
  public void setExposures()
  {
    this.field_localFlag |= 0x80;
  }
  
  public void setLocalInvisible()
  {
    this.field_localFlag |= 0x100;
  }
  
  public void setLocalVisible()
  {
    this.field_localFlag &= 0xFFFFFEFF;
  }
  
  public void setNotExposured()
  {
    this.field_localFlag &= 0xFFFFFF7F;
  }
  
  public void setRemindInfoGroup(cs paramcs)
  {
    AppMethodBeat.i(97421);
    try
    {
      this.field_remindInfoGroup = paramcs.toByteArray();
      AppMethodBeat.o(97421);
      return;
    }
    catch (Exception paramcs)
    {
      Log.e("MicroMsg.AdSnsInfo", "remindInfo toBytes error! " + paramcs.getMessage());
      AppMethodBeat.o(97421);
    }
  }
  
  public void setSnsId(long paramLong)
  {
    AppMethodBeat.i(306616);
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      setStringSeq(paramLong);
    }
    AppMethodBeat.o(306616);
  }
  
  public void setStringSeq(long paramLong)
  {
    AppMethodBeat.i(306641);
    this.field_stringSeq = t.uA(paramLong);
    this.field_stringSeq = t.aXy(this.field_stringSeq);
    Log.d("MicroMsg.AdSnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
    AppMethodBeat.o(306641);
  }
  
  public void setTimeLine(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97418);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      AppMethodBeat.o(97418);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      Log.printErrStackTrace("MicroMsg.AdSnsInfo", paramTimeLineObject, "", new Object[0]);
      AppMethodBeat.o(97418);
    }
  }
  
  public Bundle writeToBundle()
  {
    AppMethodBeat.i(97431);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.localid);
    AppMethodBeat.o(97431);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdSnsInfo
 * JD-Core Version:    0.7.0.1
 */