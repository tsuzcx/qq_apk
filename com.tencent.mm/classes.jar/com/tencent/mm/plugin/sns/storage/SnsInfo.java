package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.hm;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SnsInfo
  extends hm
{
  public static final String COL_ID = "rowid";
  public static final long SECONDS_OF_DAY = 86400L;
  public static final long SECONDS_OF_HOUR = 3600L;
  public static final long SECONDS_OF_MINUTE = 60L;
  public static final String TABLEINDEXHEAD = "serverSnsTimeHeadIndex";
  public static final String TABLEINDEXLOCALFLAG = "snsLocalflagIndex";
  public static final String TABLEINDEXMULTI1 = "snsMultiIndex1";
  public static final String TABLEINDEXMULTI2 = "snsMultiIndex2";
  public static final String TABLEINDEXMULTI3 = "snsMultiIndex3";
  public static final String TABLEINDEXSOURCE = "serverSnsTimeSourceTypeIndex";
  public static final String TABLEINDEXTIME = "serverSnsTimeIndex";
  public static final String TABLEINDEXUSERNAME = "serverSnsNameIndex";
  private static final String TAG = "MicroMsg.SnsInfo";
  protected static Map<String, dna> cacheMediaPost;
  protected static Map<String, TimeLineObject> cacheTimeLine;
  protected static IAutoDBItem.MAutoDBInfo info;
  public int ExtFlag;
  private AdSnsInfo adsnsinfo;
  public String contentByteMd5;
  private boolean isAd;
  public int localid;
  private dna postInfo;
  public String postinfoMd5;
  public CharSequence withTaUsername;
  
  static
  {
    AppMethodBeat.i(97532);
    info = hm.initAutoDBInfo(SnsInfo.class);
    cacheTimeLine = new ConcurrentHashMap();
    cacheMediaPost = new ConcurrentHashMap();
    AppMethodBeat.o(97532);
  }
  
  public SnsInfo()
  {
    this.contentByteMd5 = null;
    this.postinfoMd5 = null;
    this.ExtFlag = 0;
    this.withTaUsername = "";
    this.isAd = false;
    this.postInfo = null;
  }
  
  public SnsInfo(long paramLong)
  {
    AppMethodBeat.i(306521);
    this.contentByteMd5 = null;
    this.postinfoMd5 = null;
    this.ExtFlag = 0;
    this.withTaUsername = "";
    this.isAd = false;
    this.postInfo = null;
    setSnsId(paramLong);
    AppMethodBeat.o(306521);
  }
  
  public static int formatUnixTime(long paramLong)
  {
    AppMethodBeat.i(97502);
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date(1000L * paramLong));
    try
    {
      i = Integer.valueOf(str).intValue();
      AppMethodBeat.o(97502);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsInfo", "error valueOf  ".concat(String.valueOf(str)));
        int i = (int)(paramLong / 86400L);
      }
    }
  }
  
  public static SnsInfo getNewSnsInfo(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97499);
    SnsInfo localSnsInfo = new SnsInfo();
    localSnsInfo.localid = paramSnsInfo.localid;
    localSnsInfo.field_snsId = paramSnsInfo.field_snsId;
    localSnsInfo.field_userName = paramSnsInfo.field_userName;
    localSnsInfo.field_localFlag = paramSnsInfo.field_localFlag;
    localSnsInfo.field_createTime = paramSnsInfo.field_createTime;
    localSnsInfo.field_head = paramSnsInfo.field_head;
    localSnsInfo.field_localPrivate = paramSnsInfo.field_localPrivate;
    localSnsInfo.field_type = paramSnsInfo.field_type;
    localSnsInfo.field_sourceType = paramSnsInfo.field_sourceType;
    localSnsInfo.field_likeFlag = paramSnsInfo.field_likeFlag;
    localSnsInfo.field_pravited = paramSnsInfo.field_pravited;
    localSnsInfo.field_stringSeq = paramSnsInfo.field_stringSeq;
    localSnsInfo.field_content = paramSnsInfo.field_content;
    localSnsInfo.field_attrBuf = paramSnsInfo.field_attrBuf;
    AppMethodBeat.o(97499);
    return localSnsInfo;
  }
  
  public static String getSnsId(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(306531);
    if (paramBoolean)
    {
      str = ai.bE("ad_table_", paramLong);
      AppMethodBeat.o(306531);
      return str;
    }
    String str = ai.bE("sns_table_", paramLong);
    AppMethodBeat.o(306531);
    return str;
  }
  
  public static void release()
  {
    try
    {
      AppMethodBeat.i(97508);
      cacheTimeLine.clear();
      cacheMediaPost.clear();
      AppMethodBeat.o(97508);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void addSourceFlag(int paramInt)
  {
    this.field_sourceType |= paramInt;
  }
  
  public boolean canDeal()
  {
    return this.field_snsId != 0L;
  }
  
  public void cleanPostHolding()
  {
    this.field_localFlag &= 0xFFFFFDFF;
  }
  
  public void cleanWsFoldFlag()
  {
    this.field_localFlag &= 0xFFFFFBFF;
  }
  
  public void clearItemDie()
  {
    this.field_localFlag &= 0xFFFFFFDF;
  }
  
  public ContentValues convertFrom(ContentValues paramContentValues)
  {
    AppMethodBeat.i(306831);
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
    this.field_subType = paramContentValues.getAsInteger("subType").intValue();
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
    AppMethodBeat.o(306831);
    return paramContentValues;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(97507);
    super.convertFrom(paramCursor);
    this.localid = ((int)this.systemRowid);
    AppMethodBeat.o(97507);
  }
  
  public String dumpAd()
  {
    AppMethodBeat.i(306783);
    Object localObject = getAdSnsInfo();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.field_stringSeq);
    localStringBuffer.append(((AdSnsInfo)localObject).field_adxml);
    localStringBuffer.append(" <createtime " + this.field_createTime + ">");
    localStringBuffer.append(" <exposuretime " + ((AdSnsInfo)localObject).field_exposureTime + ">");
    localStringBuffer.append(" <adcreatetime " + ((AdSnsInfo)localObject).field_createAdTime + "> ");
    localStringBuffer.append(((AdSnsInfo)localObject).getTimeLine().ContentDesc);
    localObject = localStringBuffer.toString();
    AppMethodBeat.o(306783);
    return localObject;
  }
  
  public ADInfo getAdInfo()
  {
    AppMethodBeat.i(97514);
    if (this.adsnsinfo == null) {
      this.adsnsinfo = al.hgE().vd(this.field_snsId);
    }
    if (this.adsnsinfo == null)
    {
      localADInfo = new ADInfo(null);
      AppMethodBeat.o(97514);
      return localADInfo;
    }
    ADInfo localADInfo = this.adsnsinfo.getAdInfo();
    AppMethodBeat.o(97514);
    return localADInfo;
  }
  
  public ADInfo getAdInfo(int paramInt)
  {
    AppMethodBeat.i(97516);
    if (paramInt == 2)
    {
      localADInfo = getAtAdInfo();
      AppMethodBeat.o(97516);
      return localADInfo;
    }
    ADInfo localADInfo = getAdInfo();
    AppMethodBeat.o(97516);
    return localADInfo;
  }
  
  public String getAdInfoLink()
  {
    AppMethodBeat.i(97520);
    Object localObject = getAdInfo();
    if (localObject != null)
    {
      localObject = ((ADInfo)localObject).adActionLink;
      AppMethodBeat.o(97520);
      return localObject;
    }
    AppMethodBeat.o(97520);
    return "";
  }
  
  public String getAdLink()
  {
    AppMethodBeat.i(97519);
    Object localObject = getAdXml();
    if (localObject != null)
    {
      localObject = ((ADXml)localObject).adActionLink;
      AppMethodBeat.o(97519);
      return localObject;
    }
    AppMethodBeat.o(97519);
    return "";
  }
  
  public int getAdRecSrc()
  {
    AppMethodBeat.i(97524);
    ADXml localADXml = getAdXml();
    if (localADXml != null)
    {
      int i = localADXml.recSrc;
      AppMethodBeat.o(97524);
      return i;
    }
    AppMethodBeat.o(97524);
    return 0;
  }
  
  public AdSnsInfo getAdSnsInfo()
  {
    AppMethodBeat.i(97522);
    if (this.adsnsinfo == null) {
      this.adsnsinfo = al.hgE().vd(this.field_snsId);
    }
    if (this.adsnsinfo != null)
    {
      this.adsnsinfo.field_createTime = this.field_createTime;
      this.adsnsinfo.field_userName = this.field_userName;
      this.adsnsinfo.field_likeFlag = this.field_likeFlag;
      this.adsnsinfo.field_attrBuf = this.field_attrBuf;
    }
    AdSnsInfo localAdSnsInfo = this.adsnsinfo;
    AppMethodBeat.o(97522);
    return localAdSnsInfo;
  }
  
  public String getAdTitle()
  {
    AppMethodBeat.i(306755);
    Object localObject = getAdXml();
    if (localObject != null)
    {
      localObject = ((ADXml)localObject).adActionTitle;
      AppMethodBeat.o(306755);
      return localObject;
    }
    AppMethodBeat.o(306755);
    return "";
  }
  
  public int getAdType()
  {
    AppMethodBeat.i(97526);
    if (isAd())
    {
      ADXml localADXml = getAdXml();
      TimeLineObject localTimeLineObject = getTimeLine();
      if (localADXml.isLinkAd())
      {
        AppMethodBeat.o(97526);
        return 3;
      }
      if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj.Zpq == 27))
      {
        AppMethodBeat.o(97526);
        return 6;
      }
      if ((localADXml.isCardAd()) || (localADXml.isFullCardAd()))
      {
        if ((localTimeLineObject != null) && (localTimeLineObject.ContentObj.Zpq == 15) && (localTimeLineObject.sightFolded != 1))
        {
          AppMethodBeat.o(97526);
          return 5;
        }
        AppMethodBeat.o(97526);
        return 4;
      }
      if (localADXml.isFinderTopicCard())
      {
        AppMethodBeat.o(97526);
        return 9;
      }
      if (localADXml.isSlideFullCard())
      {
        AppMethodBeat.o(97526);
        return 10;
      }
      if (this.field_type == 1)
      {
        AppMethodBeat.o(97526);
        return 1;
      }
      AppMethodBeat.o(97526);
      return 2;
    }
    AppMethodBeat.o(97526);
    return -1;
  }
  
  /* Error */
  public ADXml getAdXml()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 453
    //   5: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 368	com/tencent/mm/plugin/sns/storage/SnsInfo:adsnsinfo	Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
    //   12: ifnonnull +17 -> 29
    //   15: aload_0
    //   16: invokestatic 374	com/tencent/mm/plugin/sns/model/al:hgE	()Lcom/tencent/mm/plugin/sns/storage/f;
    //   19: aload_0
    //   20: getfield 171	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   23: invokevirtual 380	com/tencent/mm/plugin/sns/storage/f:vd	(J)Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
    //   26: putfield 368	com/tencent/mm/plugin/sns/storage/SnsInfo:adsnsinfo	Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
    //   29: aload_0
    //   30: getfield 368	com/tencent/mm/plugin/sns/storage/SnsInfo:adsnsinfo	Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
    //   33: ifnonnull +22 -> 55
    //   36: new 404	com/tencent/mm/plugin/sns/storage/ADXml
    //   39: dup
    //   40: aconst_null
    //   41: invokespecial 454	com/tencent/mm/plugin/sns/storage/ADXml:<init>	(Ljava/lang/String;)V
    //   44: astore_1
    //   45: ldc_w 453
    //   48: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: areturn
    //   55: aload_0
    //   56: getfield 368	com/tencent/mm/plugin/sns/storage/SnsInfo:adsnsinfo	Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
    //   59: invokevirtual 455	com/tencent/mm/plugin/sns/storage/AdSnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
    //   62: astore_1
    //   63: ldc_w 453
    //   66: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -18 -> 51
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	SnsInfo
    //   44	19	1	localADXml	ADXml
    //   72	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	72	finally
    //   29	51	72	finally
    //   55	69	72	finally
  }
  
  public String getAid()
  {
    AppMethodBeat.i(97517);
    Object localObject = getAdInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(97517);
      return "";
    }
    localObject = ((ADInfo)localObject).aid;
    AppMethodBeat.o(97517);
    return localObject;
  }
  
  public ADInfo getAtAdInfo()
  {
    AppMethodBeat.i(97515);
    if (this.adsnsinfo == null) {
      this.adsnsinfo = al.hgE().vd(this.field_snsId);
    }
    if (this.adsnsinfo == null)
    {
      localADInfo = new ADInfo(null);
      AppMethodBeat.o(97515);
      return localADInfo;
    }
    ADInfo localADInfo = this.adsnsinfo.getAtAdInfo();
    AppMethodBeat.o(97515);
    return localADInfo;
  }
  
  public int getCreateTime()
  {
    return this.field_createTime;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public int getHead()
  {
    return this.field_head;
  }
  
  public int getLikeFlag()
  {
    return this.field_likeFlag;
  }
  
  public int getLocalFlag()
  {
    return this.field_localFlag;
  }
  
  public int getLocalPrivate()
  {
    return this.field_localPrivate;
  }
  
  public String getLocalid()
  {
    AppMethodBeat.i(97504);
    if (isAd())
    {
      str = ai.bE("ad_table_", this.localid);
      AppMethodBeat.o(97504);
      return str;
    }
    String str = ai.bE("sns_table_", this.localid);
    AppMethodBeat.o(97504);
    return str;
  }
  
  public String getPid()
  {
    AppMethodBeat.i(306744);
    Object localObject = getAdInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(306744);
      return "";
    }
    localObject = ((ADInfo)localObject).pId;
    AppMethodBeat.o(306744);
    return localObject;
  }
  
  public byte[] getPostBuf()
  {
    return this.field_postBuf;
  }
  
  public dna getPostInfo()
  {
    AppMethodBeat.i(97497);
    dna localdna1;
    if (this.field_postBuf == null)
    {
      localdna1 = new dna();
      AppMethodBeat.o(97497);
      return localdna1;
    }
    if (this.postinfoMd5 == null) {
      this.postinfoMd5 = g.getMessageDigest(this.field_postBuf);
    }
    if (cacheMediaPost.containsKey(this.postinfoMd5))
    {
      this.postInfo = ((dna)cacheMediaPost.get(this.postinfoMd5));
      if (this.postInfo != null)
      {
        localdna1 = this.postInfo;
        AppMethodBeat.o(97497);
        return localdna1;
      }
    }
    try
    {
      this.postInfo = ((dna)new dna().parseFrom(this.field_postBuf));
      cacheMediaPost.put(this.postinfoMd5, this.postInfo);
      localdna1 = this.postInfo;
      AppMethodBeat.o(97497);
      return localdna1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      dna localdna2 = new dna();
      AppMethodBeat.o(97497);
      return localdna2;
    }
  }
  
  public int getPravited()
  {
    return this.field_pravited;
  }
  
  public String getSnsId()
  {
    AppMethodBeat.i(97501);
    String str = getSnsId(isAd(), this.field_snsId);
    AppMethodBeat.o(97501);
    return str;
  }
  
  public String getSnsInfo()
  {
    AppMethodBeat.i(306592);
    String str = "snsId: " + this.field_stringSeq + " \n  localFlag: " + this.field_localFlag + " #　 \n  type: " + this.field_type + " lp: " + this.field_localPrivate + " \n  isPr: " + this.field_pravited + " head: " + this.field_head + " \n  time: " + this.field_createTime + " \n ";
    AppMethodBeat.o(306592);
    return str;
  }
  
  public int getSourceType()
  {
    return this.field_sourceType;
  }
  
  public String getStringSeq()
  {
    return this.field_stringSeq;
  }
  
  public TimeLineObject getTimeLine()
  {
    AppMethodBeat.i(97509);
    TimeLineObject localTimeLineObject1;
    if (this.field_content == null)
    {
      localTimeLineObject1 = o.bMJ();
      AppMethodBeat.o(97509);
      return localTimeLineObject1;
    }
    if (this.contentByteMd5 == null) {
      this.contentByteMd5 = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    }
    if (cacheTimeLine.containsKey(this.contentByteMd5))
    {
      localTimeLineObject1 = (TimeLineObject)cacheTimeLine.get(this.contentByteMd5);
      if (localTimeLineObject1 != null)
      {
        AppMethodBeat.o(97509);
        return localTimeLineObject1;
      }
    }
    TimeLineObject localTimeLineObject2;
    try
    {
      localTimeLineObject1 = (TimeLineObject)new TimeLineObject().parseFrom(this.field_content);
      if (localTimeLineObject1 == null)
      {
        Log.e("MicroMsg.SnsInfo", "error timeLineObj is null!");
        localTimeLineObject1 = o.bMJ();
        AppMethodBeat.o(97509);
        return localTimeLineObject1;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
      localTimeLineObject2 = o.bMJ();
      AppMethodBeat.o(97509);
      return localTimeLineObject2;
    }
    if (localTimeLineObject2.ContentObj == null)
    {
      Log.e("MicroMsg.SnsInfo", "error timeLineObj.ContentObj is null!");
      localTimeLineObject2 = o.bMJ();
      AppMethodBeat.o(97509);
      return localTimeLineObject2;
    }
    cacheTimeLine.put(this.contentByteMd5, localTimeLineObject2);
    AppMethodBeat.o(97509);
    return localTimeLineObject2;
  }
  
  public String getTraceid()
  {
    AppMethodBeat.i(97518);
    Object localObject = getAdInfo();
    if (localObject == null)
    {
      AppMethodBeat.o(97518);
      return "";
    }
    localObject = ((ADInfo)localObject).traceid;
    AppMethodBeat.o(97518);
    return localObject;
  }
  
  public int getTypeFlag()
  {
    return this.field_type;
  }
  
  public String getUserName()
  {
    return this.field_userName;
  }
  
  public String getUxinfo()
  {
    AppMethodBeat.i(97521);
    Object localObject = getAdInfo();
    if (localObject != null)
    {
      localObject = ((ADInfo)localObject).uxInfo;
      AppMethodBeat.o(97521);
      return localObject;
    }
    AppMethodBeat.o(97521);
    return "";
  }
  
  public boolean isAd()
  {
    AppMethodBeat.i(185991);
    boolean bool = isSourceExist(32);
    AppMethodBeat.o(185991);
    return bool;
  }
  
  public boolean isBreakFrameAd()
  {
    AppMethodBeat.i(306804);
    ADXml localADXml = getAdXml();
    if ((localADXml != null) && (localADXml.isAdBreakFrameVideo()))
    {
      AppMethodBeat.o(306804);
      return true;
    }
    AppMethodBeat.o(306804);
    return false;
  }
  
  public boolean isCardAd()
  {
    AppMethodBeat.i(97528);
    if ((getAdXml() != null) && (getAdXml().isCardAd()))
    {
      AppMethodBeat.o(97528);
      return true;
    }
    AppMethodBeat.o(97528);
    return false;
  }
  
  public boolean isDeadSource()
  {
    return (this.field_sourceType & 0x10E) == 0;
  }
  
  public boolean isDieItem()
  {
    return ((this.field_localFlag & 0x20) > 0) && (this.field_snsId == 0L);
  }
  
  public boolean isExposures()
  {
    return (this.field_localFlag & 0x80) > 0;
  }
  
  public boolean isExtFlag()
  {
    return (this.field_localFlag & 0x2) > 0;
  }
  
  public boolean isFinderAd()
  {
    AppMethodBeat.i(306799);
    if (!isAd())
    {
      AppMethodBeat.o(306799);
      return false;
    }
    ADXml localADXml = getAdXml();
    ADInfo localADInfo = getAdInfo();
    if ((localADXml != null) && (localADXml.adFinderInfo != null) && (localADInfo != null) && (localADInfo.adActionType == 9))
    {
      AppMethodBeat.o(306799);
      return true;
    }
    AppMethodBeat.o(306799);
    return false;
  }
  
  public boolean isFinderTopicCardAd()
  {
    AppMethodBeat.i(306794);
    if ((getAdXml() != null) && (getAdXml().isFinderTopicCard()))
    {
      AppMethodBeat.o(306794);
      return true;
    }
    AppMethodBeat.o(306794);
    return false;
  }
  
  public boolean isFullCardAd()
  {
    AppMethodBeat.i(97529);
    if ((getAdXml() != null) && (getAdXml().isFullCardAd()))
    {
      AppMethodBeat.o(97529);
      return true;
    }
    AppMethodBeat.o(97529);
    return false;
  }
  
  public boolean isGestureAd()
  {
    AppMethodBeat.i(306820);
    ADXml localADXml = getAdXml();
    if ((localADXml != null) && (localADXml.isGestureAd()))
    {
      AppMethodBeat.o(306820);
      return true;
    }
    AppMethodBeat.o(306820);
    return false;
  }
  
  public boolean isInValid()
  {
    return this.field_snsId == 0L;
  }
  
  public boolean isLocalInvisible()
  {
    return (this.field_localFlag & 0x100) > 0;
  }
  
  public boolean isLongPressGestureAd()
  {
    AppMethodBeat.i(306814);
    ADXml localADXml = getAdXml();
    if ((localADXml != null) && (localADXml.isLongPressGestureAd()))
    {
      AppMethodBeat.o(306814);
      return true;
    }
    AppMethodBeat.o(306814);
    return false;
  }
  
  public boolean isNoCopy()
  {
    return (this.field_serverExtFlag & 0x80) > 0;
  }
  
  public boolean isOmittedFailResend()
  {
    return (this.field_localFlag & 0x40) > 0;
  }
  
  public boolean isRecExpAd()
  {
    AppMethodBeat.i(97525);
    ADXml localADXml = getAdXml();
    if (localADXml != null)
    {
      boolean bool = localADXml.isRecExpAd();
      AppMethodBeat.o(97525);
      return bool;
    }
    AppMethodBeat.o(97525);
    return false;
  }
  
  public boolean isShakeAd()
  {
    AppMethodBeat.i(306810);
    ADXml localADXml = getAdXml();
    if ((localADXml != null) && (localADXml.isShakeAd()))
    {
      AppMethodBeat.o(306810);
      return true;
    }
    AppMethodBeat.o(306810);
    return false;
  }
  
  public boolean isSlideFullCardAd()
  {
    AppMethodBeat.i(306796);
    if ((getAdXml() != null) && (getAdXml().isSlideFullCard()))
    {
      AppMethodBeat.o(306796);
      return true;
    }
    AppMethodBeat.o(306796);
    return false;
  }
  
  public boolean isSocialAttitudeAd()
  {
    AppMethodBeat.i(306823);
    ADXml localADXml = getAdXml();
    if ((isFullCardAd()) && (localADXml != null) && (localADXml.adSocialInfo != null))
    {
      AppMethodBeat.o(306823);
      return true;
    }
    AppMethodBeat.o(306823);
    return false;
  }
  
  public boolean isSourceExist(int paramInt)
  {
    return (this.field_sourceType & paramInt) > 0;
  }
  
  public boolean isSphereCardAd()
  {
    AppMethodBeat.i(97530);
    if ((getAdXml() != null) && (getAdXml().isSphereCardAd()))
    {
      AppMethodBeat.o(97530);
      return true;
    }
    AppMethodBeat.o(97530);
    return false;
  }
  
  public boolean isTimeLimit(int paramInt, long paramLong)
  {
    AppMethodBeat.i(306717);
    if (Util.secondsToNow(paramLong / 1000L) > 7200L)
    {
      AppMethodBeat.o(306717);
      return true;
    }
    AppMethodBeat.o(306717);
    return false;
  }
  
  public boolean isTurnCardAd()
  {
    AppMethodBeat.i(97527);
    if ((getTimeLine() != null) && (getTimeLine().ContentObj.Zpq == 27))
    {
      AppMethodBeat.o(97527);
      return true;
    }
    AppMethodBeat.o(97527);
    return false;
  }
  
  public boolean isTwistAd()
  {
    AppMethodBeat.i(306808);
    ADXml localADXml = getAdXml();
    if ((localADXml != null) && (localADXml.isTwistAd()))
    {
      AppMethodBeat.o(306808);
      return true;
    }
    AppMethodBeat.o(306808);
    return false;
  }
  
  public boolean isValid()
  {
    return this.field_snsId != 0L;
  }
  
  public boolean isWaitPost()
  {
    return (this.field_localFlag & 0x10) > 0;
  }
  
  public boolean isWithMe()
  {
    return (this.field_localFlag & 0x1) > 0;
  }
  
  public boolean isWsFold()
  {
    return (this.field_localFlag & 0x400) > 0;
  }
  
  public boolean isWxWork()
  {
    AppMethodBeat.i(306765);
    h.baF();
    Object localObject = ((n)h.ax(n.class)).bzA().bxv(this.field_userName);
    if (localObject == null) {}
    for (localObject = null; (au.bwO(this.field_userName)) && ("3552365301".equals(localObject)); localObject = ((az)localObject).field_openImAppid)
    {
      AppMethodBeat.o(306765);
      return true;
    }
    AppMethodBeat.o(306765);
    return false;
  }
  
  public void printInfo() {}
  
  public void readFromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(306838);
    if (paramBundle == null)
    {
      AppMethodBeat.o(306838);
      return;
    }
    convertFrom((ContentValues)paramBundle.getParcelable("values"));
    this.localid = paramBundle.getInt("localid");
    paramBundle = paramBundle.getBundle("adValues");
    if (paramBundle != null)
    {
      AdSnsInfo localAdSnsInfo = new AdSnsInfo();
      localAdSnsInfo.readFromBundle(paramBundle);
      this.adsnsinfo = localAdSnsInfo;
    }
    AppMethodBeat.o(306838);
  }
  
  public void removeSourceFlag(int paramInt)
  {
    this.field_sourceType &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setAdSnsInfo(AdSnsInfo paramAdSnsInfo)
  {
    this.adsnsinfo = paramAdSnsInfo;
  }
  
  public void setAttrBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97505);
    this.field_attrBuf = paramArrayOfByte;
    this.contentByteMd5 = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
    AppMethodBeat.o(97505);
  }
  
  public boolean setContent(String paramString)
  {
    AppMethodBeat.i(97511);
    paramString = o.Pm(paramString);
    try
    {
      this.field_content = paramString.toByteArray();
      this.contentByteMd5 = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97511);
      return true;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfo", paramString, "", new Object[0]);
      AppMethodBeat.o(97511);
    }
    return false;
  }
  
  public void setCreateTime(int paramInt)
  {
    AppMethodBeat.i(97503);
    if ((paramInt - this.field_createTime < 180) && (paramInt - this.field_createTime >= 0))
    {
      if (this.field_head == 0) {
        setHead(formatUnixTime(this.field_createTime));
      }
      AppMethodBeat.o(97503);
      return;
    }
    this.field_createTime = paramInt;
    setHead(formatUnixTime(paramInt));
    AppMethodBeat.o(97503);
  }
  
  public void setExposures()
  {
    this.field_localFlag |= 0x80;
  }
  
  public void setExtFlag()
  {
    this.field_localFlag |= 0x2;
  }
  
  public void setHead(int paramInt)
  {
    this.field_head = paramInt;
  }
  
  public void setItemDie()
  {
    this.field_localFlag |= 0x20;
  }
  
  public void setLikeFlag(int paramInt)
  {
    this.field_likeFlag = paramInt;
  }
  
  public void setLocalFlag(int paramInt)
  {
    this.field_localFlag = paramInt;
  }
  
  public void setLocalInvisible()
  {
    this.field_localFlag |= 0x100;
  }
  
  public void setLocalPrivate()
  {
    this.field_localPrivate |= 0x1;
  }
  
  public void setLocalVisible()
  {
    this.field_localFlag &= 0xFFFFFEFF;
  }
  
  public void setLocalid(int paramInt)
  {
    this.localid = paramInt;
  }
  
  public void setOmittedFailResend()
  {
    this.field_localFlag |= 0x40;
  }
  
  public void setPostBuf(byte[] paramArrayOfByte)
  {
    this.field_postBuf = paramArrayOfByte;
  }
  
  public void setPostFinish()
  {
    this.field_localFlag &= 0xFFFFFFEF;
  }
  
  public void setPostHolding()
  {
    this.field_localFlag |= 0x200;
  }
  
  public void setPostInfo()
  {
    AppMethodBeat.i(306556);
    try
    {
      setPostBuf(this.postInfo.toByteArray());
      AppMethodBeat.o(306556);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SnsInfo", localException, "", new Object[0]);
      Log.e("MicroMsg.SnsInfo", "toByteArray error");
      AppMethodBeat.o(306556);
    }
  }
  
  public void setPostWaiting()
  {
    this.field_localFlag |= 0x10;
  }
  
  public void setPravited(int paramInt)
  {
    this.field_pravited = paramInt;
  }
  
  public void setSnsId(long paramLong)
  {
    AppMethodBeat.i(97500);
    this.field_snsId = paramLong;
    if (paramLong != 0L) {
      setStringSeq(paramLong);
    }
    AppMethodBeat.o(97500);
  }
  
  public void setStringSeq(long paramLong)
  {
    AppMethodBeat.i(97506);
    this.field_stringSeq = t.uA(paramLong);
    this.field_stringSeq = t.aXy(this.field_stringSeq);
    Log.d("MicroMsg.SnsInfo", paramLong + " stringSeq " + this.field_stringSeq);
    AppMethodBeat.o(97506);
  }
  
  public void setStringSeq(String paramString)
  {
    this.field_stringSeq = paramString;
  }
  
  public void setSubTypeFlag(int paramInt)
  {
    this.field_subType = paramInt;
  }
  
  public void setTimeLine(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(97510);
    try
    {
      this.field_content = paramTimeLineObject.toByteArray();
      this.contentByteMd5 = (g.getMessageDigest(this.field_content) + g.getMessageDigest(this.field_attrBuf));
      AppMethodBeat.o(97510);
      return;
    }
    catch (Exception paramTimeLineObject)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SnsInfo", paramTimeLineObject, "", new Object[0]);
      }
    }
  }
  
  public void setTypeFlag(int paramInt)
  {
    this.field_type = paramInt;
  }
  
  public void setUserName(String paramString)
  {
    this.field_userName = paramString;
  }
  
  public void setWithMe()
  {
    this.field_localFlag |= 0x1;
  }
  
  public void setWsFoldFlag()
  {
    this.field_localFlag |= 0x400;
  }
  
  public void unLocalPrivate()
  {
    this.field_localPrivate = 0;
  }
  
  public void unSetExtFlag()
  {
    this.field_localFlag &= 0xFFFFFFFD;
  }
  
  public void unSetWithMe()
  {
    this.field_localFlag &= 0xFFFFFFFE;
  }
  
  public void unsetOmittedFailResend()
  {
    AppMethodBeat.i(306714);
    if (isOmittedFailResend()) {
      this.field_localFlag &= 0xFFFFFFBF;
    }
    AppMethodBeat.o(306714);
  }
  
  public Bundle writeToBundle()
  {
    AppMethodBeat.i(97531);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("values", super.convertTo());
    localBundle.putInt("localid", this.localid);
    if (getAdSnsInfo() != null) {
      localBundle.putBundle("adValues", getAdSnsInfo().writeToBundle());
    }
    AppMethodBeat.o(97531);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.SnsInfo
 * JD-Core Version:    0.7.0.1
 */