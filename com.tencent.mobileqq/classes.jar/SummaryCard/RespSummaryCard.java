package SummaryCard;

import QQService.PrivilegeBaseInfo;
import QQService.VipBaseInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class RespSummaryCard
  extends JceStruct
{
  static int cache_eAddOption;
  static Map<String, String> cache_mapQzoneEx;
  static AlbumInfo cache_oLatestPhotos = new AlbumInfo();
  static AddFrdSrcInfo cache_stAddFrdSrcInfo;
  static QQApolloInfo cache_stApollo;
  static BindPhoneInfo cache_stBindPhoneInfo;
  static TCampusCircleInfo cache_stCampusCircleInfo;
  static TCoverInfo cache_stCoverInfo;
  static DateCard cache_stDateCard;
  static VipBaseInfo cache_stDiamonds;
  static TEIMInfo cache_stEimInfo;
  static GiftInfo cache_stGiftInfo;
  static HeartInfo cache_stHeartInfo;
  static InterestTagInfo cache_stInterestTag;
  static TMedalWallInfo cache_stMedalWallInfo;
  static TNearbyGodInfo cache_stNearbyGodInfo;
  static TNowBroadcastInfo cache_stNowBroadcastInfo;
  static OlympicInfo cache_stOlympicInfo;
  static PanSocialInfo cache_stPanSocialInfo;
  static PrivilegeBaseInfo cache_stPrivInfo;
  static QCallInfo cache_stQCallInfo;
  static TQimInfo cache_stQimInfo;
  static QiqiVideoInfo cache_stQiqiVideoInfo;
  static TTimInfo cache_stTimInfo;
  static UserFeed cache_stUserFeed;
  static TVideoHeadInfo cache_stVideoHeadInfo;
  static QQVideoInfo cache_stVideoInfo;
  static VipBaseInfo cache_stVipInfo;
  static VoiceInfo cache_stVoiceInfo;
  static WeishiInfo cache_stWeishiInfo;
  static ArrayList<String> cache_vAddQuestion;
  static byte[] cache_vCommLabel;
  static byte[] cache_vExtendCard;
  static byte[] cache_vHotChatInfo;
  static byte[] cache_vLongNickTopicInfo;
  static byte[] cache_vNearbyTaskInfo;
  static byte[] cache_vNowInfo;
  static ArrayList<TPraiseInfo> cache_vPraiseList;
  static byte[] cache_vQzoneCoverInfo;
  static byte[] cache_vResp0x5ebInfo;
  static byte[] cache_vRespCustomLabelInfo;
  static byte[] cache_vRespKandianInfo;
  static byte[] cache_vRespLastGameInfo;
  static byte[] cache_vRespQQStoryInfo;
  static byte[] cache_vRespStarInfo;
  static byte[] cache_vRespTemplateInfo;
  static byte[] cache_vRichSign;
  static byte[] cache_vSeed;
  static byte[] cache_vTempChatSig;
  static byte[] cache_vVisitingCardInfo;
  static ArrayList<byte[]> cache_vvRespServices;
  static ArrayList<byte[]> cache_vvRespServicesBigOrder;
  public byte bAge = 0;
  public short bAvailVoteCnt = 0;
  public short bHaveVotedCnt = 0;
  public byte bSex = 0;
  public byte bValid4Vote = 0;
  public int eAddOption = 101;
  public int i0x6d4Success = 0;
  public int iBirthday = 0;
  public int iContactNotBindQQ = 0;
  public int iFace = 0;
  public int iLastestVoteCount = 0;
  public int iLevel = 0;
  public int iPhotoCount = 0;
  public int iVoteCount = 0;
  public long lCacheControl = 0L;
  public long lUIN = 0L;
  public long lUserFlag = 0L;
  public Map<String, String> mapQzoneEx = null;
  public AlbumInfo oLatestPhotos = null;
  public AddFrdSrcInfo stAddFrdSrcInfo = null;
  public QQApolloInfo stApollo = null;
  public BindPhoneInfo stBindPhoneInfo = null;
  public TCampusCircleInfo stCampusCircleInfo = null;
  public TCoverInfo stCoverInfo = null;
  public DateCard stDateCard = null;
  public VipBaseInfo stDiamonds = null;
  public TEIMInfo stEimInfo = null;
  public GiftInfo stGiftInfo = null;
  public HeartInfo stHeartInfo = null;
  public InterestTagInfo stInterestTag = null;
  public TMedalWallInfo stMedalWallInfo = null;
  public TNearbyGodInfo stNearbyGodInfo = null;
  public TNowBroadcastInfo stNowBroadcastInfo = null;
  public OlympicInfo stOlympicInfo = null;
  public PanSocialInfo stPanSocialInfo = null;
  public PrivilegeBaseInfo stPrivInfo = null;
  public QCallInfo stQCallInfo = null;
  public TQimInfo stQimInfo = null;
  public QiqiVideoInfo stQiqiVideoInfo = null;
  public TTimInfo stTimInfo = null;
  public UserFeed stUserFeed = null;
  public TVideoHeadInfo stVideoHeadInfo = null;
  public QQVideoInfo stVideoInfo = null;
  public VipBaseInfo stVipInfo = null;
  public VoiceInfo stVoiceInfo = null;
  public WeishiInfo stWeishiInfo = null;
  public String strAutoRemark = "";
  public String strCity = "";
  public String strContactName = "";
  public String strCountry = "";
  public String strDiscussName = "";
  public String strEIMBindPhoneNum = "";
  public String strEIMId = "";
  public String strEmail = "";
  public String strGroupName = "";
  public String strGroupNick = "";
  public String strLoginDesc = "";
  public String strMobile = "";
  public String strNick = "";
  public String strPersonal = "";
  public String strProvince = "";
  public String strQzoneFeedsDesc = "";
  public String strQzoneHeader = "";
  public String strRemark = "";
  public String strRespMusicInfo = "";
  public String strShowName = "";
  public String strSign = "";
  public String strSpaceName = "";
  public String strStatus = "";
  public String strVoteLimitedNotice = "";
  public long uAccelerateMultiple = 0L;
  public long uCareer = 0L;
  public long uCurMulType = 0L;
  public long uFriendGroupId = 0L;
  public long uLoginDays = 0L;
  public long uQQMasterLoginDays = 20L;
  public long uRichCardNameVer = 0L;
  public long uSignModifyTime = 0L;
  public long uTemplateId = 0L;
  public long ulFaceAddonId = 0L;
  public long ulShowControl = 0L;
  public ArrayList<String> vAddQuestion = null;
  public byte[] vCommLabel = null;
  public byte[] vExtendCard = null;
  public byte[] vHotChatInfo = null;
  public byte[] vLongNickTopicInfo = null;
  public byte[] vNearbyTaskInfo = null;
  public byte[] vNowInfo = null;
  public ArrayList<TPraiseInfo> vPraiseList = null;
  public byte[] vQzoneCoverInfo = null;
  public byte[] vResp0x5ebInfo = null;
  public byte[] vRespCustomLabelInfo = null;
  public byte[] vRespKandianInfo = null;
  public byte[] vRespLastGameInfo = null;
  public byte[] vRespQQStoryInfo = null;
  public byte[] vRespStarInfo = null;
  public byte[] vRespTemplateInfo = null;
  public byte[] vRichSign = null;
  public byte[] vSeed = null;
  public byte[] vTempChatSig = null;
  public byte[] vVisitingCardInfo = null;
  public ArrayList<byte[]> vvRespServices = null;
  public ArrayList<byte[]> vvRespServicesBigOrder = null;
  
  static
  {
    cache_eAddOption = 0;
    cache_vAddQuestion = new ArrayList();
    cache_vAddQuestion.add("");
    cache_vSeed = (byte[])new byte[1];
    ((byte[])cache_vSeed)[0] = 0;
    cache_stVipInfo = new VipBaseInfo();
    cache_stVoiceInfo = new VoiceInfo();
    cache_vRichSign = (byte[])new byte[1];
    ((byte[])cache_vRichSign)[0] = 0;
    cache_vRespLastGameInfo = (byte[])new byte[1];
    ((byte[])cache_vRespLastGameInfo)[0] = 0;
    cache_vRespTemplateInfo = (byte[])new byte[1];
    ((byte[])cache_vRespTemplateInfo)[0] = 0;
    cache_vRespStarInfo = (byte[])new byte[1];
    ((byte[])cache_vRespStarInfo)[0] = 0;
    cache_stDiamonds = new VipBaseInfo();
    cache_vvRespServices = new ArrayList();
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_vvRespServices.add(localObject);
    cache_stDateCard = new DateCard();
    cache_stQCallInfo = new QCallInfo();
    cache_stGiftInfo = new GiftInfo();
    cache_stPanSocialInfo = new PanSocialInfo();
    cache_stVideoInfo = new QQVideoInfo();
    cache_vTempChatSig = (byte[])new byte[1];
    ((byte[])cache_vTempChatSig)[0] = 0;
    cache_stInterestTag = new InterestTagInfo();
    cache_stUserFeed = new UserFeed();
    cache_stQiqiVideoInfo = new QiqiVideoInfo();
    cache_stPrivInfo = new PrivilegeBaseInfo();
    cache_stApollo = new QQApolloInfo();
    cache_stAddFrdSrcInfo = new AddFrdSrcInfo();
    cache_stBindPhoneInfo = new BindPhoneInfo();
    cache_vVisitingCardInfo = (byte[])new byte[1];
    ((byte[])cache_vVisitingCardInfo)[0] = 0;
    cache_vHotChatInfo = (byte[])new byte[1];
    ((byte[])cache_vHotChatInfo)[0] = 0;
    cache_stOlympicInfo = new OlympicInfo();
    cache_stCoverInfo = new TCoverInfo();
    cache_stNowBroadcastInfo = new TNowBroadcastInfo();
    cache_stEimInfo = new TEIMInfo();
    cache_stVideoHeadInfo = new TVideoHeadInfo();
    cache_stMedalWallInfo = new TMedalWallInfo();
    cache_vvRespServicesBigOrder = new ArrayList();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_vvRespServicesBigOrder.add(localObject);
    cache_vResp0x5ebInfo = (byte[])new byte[1];
    ((byte[])cache_vResp0x5ebInfo)[0] = 0;
    cache_stNearbyGodInfo = new TNearbyGodInfo();
    cache_vRespQQStoryInfo = (byte[])new byte[1];
    ((byte[])cache_vRespQQStoryInfo)[0] = 0;
    cache_vRespCustomLabelInfo = (byte[])new byte[1];
    ((byte[])cache_vRespCustomLabelInfo)[0] = 0;
    cache_vPraiseList = new ArrayList();
    localObject = new TPraiseInfo();
    cache_vPraiseList.add(localObject);
    cache_stCampusCircleInfo = new TCampusCircleInfo();
    cache_stTimInfo = new TTimInfo();
    cache_stQimInfo = new TQimInfo();
    cache_stHeartInfo = new HeartInfo();
    cache_vQzoneCoverInfo = (byte[])new byte[1];
    ((byte[])cache_vQzoneCoverInfo)[0] = 0;
    cache_vNearbyTaskInfo = (byte[])new byte[1];
    ((byte[])cache_vNearbyTaskInfo)[0] = 0;
    cache_vNowInfo = (byte[])new byte[1];
    ((byte[])cache_vNowInfo)[0] = 0;
    cache_vCommLabel = (byte[])new byte[1];
    ((byte[])cache_vCommLabel)[0] = 0;
    cache_vExtendCard = (byte[])new byte[1];
    ((byte[])cache_vExtendCard)[0] = 0;
    cache_mapQzoneEx = new HashMap();
    cache_mapQzoneEx.put("", "");
    cache_vRespKandianInfo = (byte[])new byte[1];
    ((byte[])cache_vRespKandianInfo)[0] = 0;
    cache_stWeishiInfo = new WeishiInfo();
    cache_vLongNickTopicInfo = (byte[])new byte[1];
    ((byte[])cache_vLongNickTopicInfo)[0] = 0;
  }
  
  public RespSummaryCard() {}
  
  public RespSummaryCard(int paramInt1, byte paramByte1, byte paramByte2, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, long paramLong1, String paramString10, AlbumInfo paramAlbumInfo, int paramInt3, int paramInt4, byte paramByte3, String paramString11, String paramString12, String paramString13, long paramLong2, long paramLong3, int paramInt5, int paramInt6, ArrayList<String> paramArrayList, byte[] paramArrayOfByte1, String paramString14, VipBaseInfo paramVipBaseInfo1, String paramString15, VoiceInfo paramVoiceInfo, byte[] paramArrayOfByte2, long paramLong4, byte[] paramArrayOfByte3, long paramLong5, long paramLong6, String paramString16, long paramLong7, long paramLong8, long paramLong9, byte[] paramArrayOfByte4, String paramString17, byte[] paramArrayOfByte5, VipBaseInfo paramVipBaseInfo2, long paramLong10, ArrayList<byte[]> paramArrayList1, String paramString18, DateCard paramDateCard, int paramInt7, QCallInfo paramQCallInfo, GiftInfo paramGiftInfo, PanSocialInfo paramPanSocialInfo, QQVideoInfo paramQQVideoInfo, byte[] paramArrayOfByte6, InterestTagInfo paramInterestTagInfo, UserFeed paramUserFeed, QiqiVideoInfo paramQiqiVideoInfo, PrivilegeBaseInfo paramPrivilegeBaseInfo, QQApolloInfo paramQQApolloInfo, AddFrdSrcInfo paramAddFrdSrcInfo, BindPhoneInfo paramBindPhoneInfo, byte[] paramArrayOfByte7, String paramString19, short paramShort1, short paramShort2, String paramString20, String paramString21, String paramString22, long paramLong11, String paramString23, byte[] paramArrayOfByte8, OlympicInfo paramOlympicInfo, TCoverInfo paramTCoverInfo, TNowBroadcastInfo paramTNowBroadcastInfo, TEIMInfo paramTEIMInfo, TVideoHeadInfo paramTVideoHeadInfo, int paramInt8, TMedalWallInfo paramTMedalWallInfo, ArrayList<byte[]> paramArrayList2, byte[] paramArrayOfByte9, TNearbyGodInfo paramTNearbyGodInfo, byte[] paramArrayOfByte10, byte[] paramArrayOfByte11, ArrayList<TPraiseInfo> paramArrayList3, TCampusCircleInfo paramTCampusCircleInfo, TTimInfo paramTTimInfo, TQimInfo paramTQimInfo, HeartInfo paramHeartInfo, byte[] paramArrayOfByte12, byte[] paramArrayOfByte13, byte[] paramArrayOfByte14, long paramLong12, byte[] paramArrayOfByte15, byte[] paramArrayOfByte16, String paramString24, Map<String, String> paramMap, byte[] paramArrayOfByte17, WeishiInfo paramWeishiInfo, long paramLong13, long paramLong14, byte[] paramArrayOfByte18, int paramInt9)
  {
    this.iFace = paramInt1;
    this.bSex = paramByte1;
    this.bAge = paramByte2;
    this.strNick = paramString1;
    this.strRemark = paramString2;
    this.iLevel = paramInt2;
    this.strProvince = paramString3;
    this.strCity = paramString4;
    this.strSign = paramString5;
    this.strGroupName = paramString6;
    this.strGroupNick = paramString7;
    this.strMobile = paramString8;
    this.strContactName = paramString9;
    this.ulShowControl = paramLong1;
    this.strQzoneFeedsDesc = paramString10;
    this.oLatestPhotos = paramAlbumInfo;
    this.iVoteCount = paramInt3;
    this.iLastestVoteCount = paramInt4;
    this.bValid4Vote = paramByte3;
    this.strCountry = paramString11;
    this.strStatus = paramString12;
    this.strAutoRemark = paramString13;
    this.lCacheControl = paramLong2;
    this.lUIN = paramLong3;
    this.iPhotoCount = paramInt5;
    this.eAddOption = paramInt6;
    this.vAddQuestion = paramArrayList;
    this.vSeed = paramArrayOfByte1;
    this.strDiscussName = paramString14;
    this.stVipInfo = paramVipBaseInfo1;
    this.strShowName = paramString15;
    this.stVoiceInfo = paramVoiceInfo;
    this.vRichSign = paramArrayOfByte2;
    this.uSignModifyTime = paramLong4;
    this.vRespLastGameInfo = paramArrayOfByte3;
    this.lUserFlag = paramLong5;
    this.uLoginDays = paramLong6;
    this.strLoginDesc = paramString16;
    this.uTemplateId = paramLong7;
    this.uQQMasterLoginDays = paramLong8;
    this.ulFaceAddonId = paramLong9;
    this.vRespTemplateInfo = paramArrayOfByte4;
    this.strRespMusicInfo = paramString17;
    this.vRespStarInfo = paramArrayOfByte5;
    this.stDiamonds = paramVipBaseInfo2;
    this.uAccelerateMultiple = paramLong10;
    this.vvRespServices = paramArrayList1;
    this.strSpaceName = paramString18;
    this.stDateCard = paramDateCard;
    this.iBirthday = paramInt7;
    this.stQCallInfo = paramQCallInfo;
    this.stGiftInfo = paramGiftInfo;
    this.stPanSocialInfo = paramPanSocialInfo;
    this.stVideoInfo = paramQQVideoInfo;
    this.vTempChatSig = paramArrayOfByte6;
    this.stInterestTag = paramInterestTagInfo;
    this.stUserFeed = paramUserFeed;
    this.stQiqiVideoInfo = paramQiqiVideoInfo;
    this.stPrivInfo = paramPrivilegeBaseInfo;
    this.stApollo = paramQQApolloInfo;
    this.stAddFrdSrcInfo = paramAddFrdSrcInfo;
    this.stBindPhoneInfo = paramBindPhoneInfo;
    this.vVisitingCardInfo = paramArrayOfByte7;
    this.strVoteLimitedNotice = paramString19;
    this.bHaveVotedCnt = paramShort1;
    this.bAvailVoteCnt = paramShort2;
    this.strEIMBindPhoneNum = paramString20;
    this.strEIMId = paramString21;
    this.strEmail = paramString22;
    this.uCareer = paramLong11;
    this.strPersonal = paramString23;
    this.vHotChatInfo = paramArrayOfByte8;
    this.stOlympicInfo = paramOlympicInfo;
    this.stCoverInfo = paramTCoverInfo;
    this.stNowBroadcastInfo = paramTNowBroadcastInfo;
    this.stEimInfo = paramTEIMInfo;
    this.stVideoHeadInfo = paramTVideoHeadInfo;
    this.iContactNotBindQQ = paramInt8;
    this.stMedalWallInfo = paramTMedalWallInfo;
    this.vvRespServicesBigOrder = paramArrayList2;
    this.vResp0x5ebInfo = paramArrayOfByte9;
    this.stNearbyGodInfo = paramTNearbyGodInfo;
    this.vRespQQStoryInfo = paramArrayOfByte10;
    this.vRespCustomLabelInfo = paramArrayOfByte11;
    this.vPraiseList = paramArrayList3;
    this.stCampusCircleInfo = paramTCampusCircleInfo;
    this.stTimInfo = paramTTimInfo;
    this.stQimInfo = paramTQimInfo;
    this.stHeartInfo = paramHeartInfo;
    this.vQzoneCoverInfo = paramArrayOfByte12;
    this.vNearbyTaskInfo = paramArrayOfByte13;
    this.vNowInfo = paramArrayOfByte14;
    this.uFriendGroupId = paramLong12;
    this.vCommLabel = paramArrayOfByte15;
    this.vExtendCard = paramArrayOfByte16;
    this.strQzoneHeader = paramString24;
    this.mapQzoneEx = paramMap;
    this.vRespKandianInfo = paramArrayOfByte17;
    this.stWeishiInfo = paramWeishiInfo;
    this.uRichCardNameVer = paramLong13;
    this.uCurMulType = paramLong14;
    this.vLongNickTopicInfo = paramArrayOfByte18;
    this.i0x6d4Success = paramInt9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iFace = paramJceInputStream.read(this.iFace, 0, false);
    this.bSex = paramJceInputStream.read(this.bSex, 1, false);
    this.bAge = paramJceInputStream.read(this.bAge, 2, false);
    this.strNick = paramJceInputStream.readString(3, false);
    this.strRemark = paramJceInputStream.readString(4, false);
    this.iLevel = paramJceInputStream.read(this.iLevel, 5, false);
    this.strProvince = paramJceInputStream.readString(6, false);
    this.strCity = paramJceInputStream.readString(7, false);
    this.strSign = paramJceInputStream.readString(8, false);
    this.strGroupName = paramJceInputStream.readString(9, false);
    this.strGroupNick = paramJceInputStream.readString(10, false);
    this.strMobile = paramJceInputStream.readString(11, false);
    this.strContactName = paramJceInputStream.readString(12, false);
    this.ulShowControl = paramJceInputStream.read(this.ulShowControl, 13, false);
    this.strQzoneFeedsDesc = paramJceInputStream.readString(14, false);
    this.oLatestPhotos = ((AlbumInfo)paramJceInputStream.read(cache_oLatestPhotos, 15, false));
    this.iVoteCount = paramJceInputStream.read(this.iVoteCount, 16, false);
    this.iLastestVoteCount = paramJceInputStream.read(this.iLastestVoteCount, 17, false);
    this.bValid4Vote = paramJceInputStream.read(this.bValid4Vote, 18, false);
    this.strCountry = paramJceInputStream.readString(19, false);
    this.strStatus = paramJceInputStream.readString(20, false);
    this.strAutoRemark = paramJceInputStream.readString(21, false);
    this.lCacheControl = paramJceInputStream.read(this.lCacheControl, 22, false);
    this.lUIN = paramJceInputStream.read(this.lUIN, 23, false);
    this.iPhotoCount = paramJceInputStream.read(this.iPhotoCount, 24, false);
    this.eAddOption = paramJceInputStream.read(this.eAddOption, 25, false);
    this.vAddQuestion = ((ArrayList)paramJceInputStream.read(cache_vAddQuestion, 26, false));
    this.vSeed = ((byte[])paramJceInputStream.read(cache_vSeed, 27, false));
    this.strDiscussName = paramJceInputStream.readString(28, false);
    this.stVipInfo = ((VipBaseInfo)paramJceInputStream.read(cache_stVipInfo, 29, false));
    this.strShowName = paramJceInputStream.readString(30, false);
    this.stVoiceInfo = ((VoiceInfo)paramJceInputStream.read(cache_stVoiceInfo, 31, false));
    this.vRichSign = ((byte[])paramJceInputStream.read(cache_vRichSign, 32, false));
    this.uSignModifyTime = paramJceInputStream.read(this.uSignModifyTime, 33, false);
    this.vRespLastGameInfo = ((byte[])paramJceInputStream.read(cache_vRespLastGameInfo, 34, false));
    this.lUserFlag = paramJceInputStream.read(this.lUserFlag, 35, false);
    this.uLoginDays = paramJceInputStream.read(this.uLoginDays, 36, false);
    this.strLoginDesc = paramJceInputStream.readString(37, false);
    this.uTemplateId = paramJceInputStream.read(this.uTemplateId, 38, false);
    this.uQQMasterLoginDays = paramJceInputStream.read(this.uQQMasterLoginDays, 39, false);
    this.ulFaceAddonId = paramJceInputStream.read(this.ulFaceAddonId, 40, false);
    this.vRespTemplateInfo = ((byte[])paramJceInputStream.read(cache_vRespTemplateInfo, 41, false));
    this.strRespMusicInfo = paramJceInputStream.readString(42, false);
    this.vRespStarInfo = ((byte[])paramJceInputStream.read(cache_vRespStarInfo, 43, false));
    this.stDiamonds = ((VipBaseInfo)paramJceInputStream.read(cache_stDiamonds, 44, false));
    this.uAccelerateMultiple = paramJceInputStream.read(this.uAccelerateMultiple, 45, false);
    this.vvRespServices = ((ArrayList)paramJceInputStream.read(cache_vvRespServices, 46, false));
    this.strSpaceName = paramJceInputStream.readString(47, false);
    this.stDateCard = ((DateCard)paramJceInputStream.read(cache_stDateCard, 48, false));
    this.iBirthday = paramJceInputStream.read(this.iBirthday, 49, false);
    this.stQCallInfo = ((QCallInfo)paramJceInputStream.read(cache_stQCallInfo, 50, false));
    this.stGiftInfo = ((GiftInfo)paramJceInputStream.read(cache_stGiftInfo, 51, false));
    this.stPanSocialInfo = ((PanSocialInfo)paramJceInputStream.read(cache_stPanSocialInfo, 52, false));
    this.stVideoInfo = ((QQVideoInfo)paramJceInputStream.read(cache_stVideoInfo, 53, false));
    this.vTempChatSig = ((byte[])paramJceInputStream.read(cache_vTempChatSig, 54, false));
    this.stInterestTag = ((InterestTagInfo)paramJceInputStream.read(cache_stInterestTag, 55, false));
    this.stUserFeed = ((UserFeed)paramJceInputStream.read(cache_stUserFeed, 56, false));
    this.stQiqiVideoInfo = ((QiqiVideoInfo)paramJceInputStream.read(cache_stQiqiVideoInfo, 57, false));
    this.stPrivInfo = ((PrivilegeBaseInfo)paramJceInputStream.read(cache_stPrivInfo, 58, false));
    this.stApollo = ((QQApolloInfo)paramJceInputStream.read(cache_stApollo, 59, false));
    this.stAddFrdSrcInfo = ((AddFrdSrcInfo)paramJceInputStream.read(cache_stAddFrdSrcInfo, 60, false));
    this.stBindPhoneInfo = ((BindPhoneInfo)paramJceInputStream.read(cache_stBindPhoneInfo, 61, false));
    this.vVisitingCardInfo = ((byte[])paramJceInputStream.read(cache_vVisitingCardInfo, 62, false));
    this.strVoteLimitedNotice = paramJceInputStream.readString(63, false);
    this.bHaveVotedCnt = paramJceInputStream.read(this.bHaveVotedCnt, 64, false);
    this.bAvailVoteCnt = paramJceInputStream.read(this.bAvailVoteCnt, 65, false);
    this.strEIMBindPhoneNum = paramJceInputStream.readString(66, false);
    this.strEIMId = paramJceInputStream.readString(67, false);
    this.strEmail = paramJceInputStream.readString(68, false);
    this.uCareer = paramJceInputStream.read(this.uCareer, 69, false);
    this.strPersonal = paramJceInputStream.readString(70, false);
    this.vHotChatInfo = ((byte[])paramJceInputStream.read(cache_vHotChatInfo, 71, false));
    this.stOlympicInfo = ((OlympicInfo)paramJceInputStream.read(cache_stOlympicInfo, 72, false));
    this.stCoverInfo = ((TCoverInfo)paramJceInputStream.read(cache_stCoverInfo, 73, false));
    this.stNowBroadcastInfo = ((TNowBroadcastInfo)paramJceInputStream.read(cache_stNowBroadcastInfo, 74, false));
    this.stEimInfo = ((TEIMInfo)paramJceInputStream.read(cache_stEimInfo, 75, false));
    this.stVideoHeadInfo = ((TVideoHeadInfo)paramJceInputStream.read(cache_stVideoHeadInfo, 78, false));
    this.iContactNotBindQQ = paramJceInputStream.read(this.iContactNotBindQQ, 79, false);
    this.stMedalWallInfo = ((TMedalWallInfo)paramJceInputStream.read(cache_stMedalWallInfo, 80, false));
    this.vvRespServicesBigOrder = ((ArrayList)paramJceInputStream.read(cache_vvRespServicesBigOrder, 81, false));
    this.vResp0x5ebInfo = ((byte[])paramJceInputStream.read(cache_vResp0x5ebInfo, 82, false));
    this.stNearbyGodInfo = ((TNearbyGodInfo)paramJceInputStream.read(cache_stNearbyGodInfo, 83, false));
    this.vRespQQStoryInfo = ((byte[])paramJceInputStream.read(cache_vRespQQStoryInfo, 84, false));
    this.vRespCustomLabelInfo = ((byte[])paramJceInputStream.read(cache_vRespCustomLabelInfo, 85, false));
    this.vPraiseList = ((ArrayList)paramJceInputStream.read(cache_vPraiseList, 86, false));
    this.stCampusCircleInfo = ((TCampusCircleInfo)paramJceInputStream.read(cache_stCampusCircleInfo, 87, false));
    this.stTimInfo = ((TTimInfo)paramJceInputStream.read(cache_stTimInfo, 88, false));
    this.stQimInfo = ((TQimInfo)paramJceInputStream.read(cache_stQimInfo, 89, false));
    this.stHeartInfo = ((HeartInfo)paramJceInputStream.read(cache_stHeartInfo, 90, false));
    this.vQzoneCoverInfo = ((byte[])paramJceInputStream.read(cache_vQzoneCoverInfo, 91, false));
    this.vNearbyTaskInfo = ((byte[])paramJceInputStream.read(cache_vNearbyTaskInfo, 92, false));
    this.vNowInfo = ((byte[])paramJceInputStream.read(cache_vNowInfo, 93, false));
    this.uFriendGroupId = paramJceInputStream.read(this.uFriendGroupId, 94, false);
    this.vCommLabel = ((byte[])paramJceInputStream.read(cache_vCommLabel, 95, false));
    this.vExtendCard = ((byte[])paramJceInputStream.read(cache_vExtendCard, 96, false));
    this.strQzoneHeader = paramJceInputStream.readString(97, false);
    this.mapQzoneEx = ((Map)paramJceInputStream.read(cache_mapQzoneEx, 98, false));
    this.vRespKandianInfo = ((byte[])paramJceInputStream.read(cache_vRespKandianInfo, 99, false));
    this.stWeishiInfo = ((WeishiInfo)paramJceInputStream.read(cache_stWeishiInfo, 100, false));
    this.uRichCardNameVer = paramJceInputStream.read(this.uRichCardNameVer, 101, false);
    this.uCurMulType = paramJceInputStream.read(this.uCurMulType, 102, false);
    this.vLongNickTopicInfo = ((byte[])paramJceInputStream.read(cache_vLongNickTopicInfo, 103, false));
    this.i0x6d4Success = paramJceInputStream.read(this.i0x6d4Success, 104, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iFace, 0);
    paramJceOutputStream.write(this.bSex, 1);
    paramJceOutputStream.write(this.bAge, 2);
    Object localObject = this.strNick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.strRemark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.iLevel, 5);
    localObject = this.strProvince;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.strCity;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.strSign;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.strGroupName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.strGroupNick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.strMobile;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.strContactName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    paramJceOutputStream.write(this.ulShowControl, 13);
    localObject = this.strQzoneFeedsDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 14);
    }
    localObject = this.oLatestPhotos;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
    paramJceOutputStream.write(this.iVoteCount, 16);
    paramJceOutputStream.write(this.iLastestVoteCount, 17);
    paramJceOutputStream.write(this.bValid4Vote, 18);
    localObject = this.strCountry;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 19);
    }
    localObject = this.strStatus;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 20);
    }
    localObject = this.strAutoRemark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
    paramJceOutputStream.write(this.lCacheControl, 22);
    paramJceOutputStream.write(this.lUIN, 23);
    paramJceOutputStream.write(this.iPhotoCount, 24);
    paramJceOutputStream.write(this.eAddOption, 25);
    localObject = this.vAddQuestion;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 26);
    }
    localObject = this.vSeed;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 27);
    }
    localObject = this.strDiscussName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 28);
    }
    localObject = this.stVipInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 29);
    }
    localObject = this.strShowName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 30);
    }
    localObject = this.stVoiceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 31);
    }
    localObject = this.vRichSign;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 32);
    }
    paramJceOutputStream.write(this.uSignModifyTime, 33);
    localObject = this.vRespLastGameInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 34);
    }
    paramJceOutputStream.write(this.lUserFlag, 35);
    paramJceOutputStream.write(this.uLoginDays, 36);
    localObject = this.strLoginDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 37);
    }
    paramJceOutputStream.write(this.uTemplateId, 38);
    paramJceOutputStream.write(this.uQQMasterLoginDays, 39);
    paramJceOutputStream.write(this.ulFaceAddonId, 40);
    localObject = this.vRespTemplateInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 41);
    }
    localObject = this.strRespMusicInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 42);
    }
    localObject = this.vRespStarInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 43);
    }
    localObject = this.stDiamonds;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 44);
    }
    paramJceOutputStream.write(this.uAccelerateMultiple, 45);
    localObject = this.vvRespServices;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 46);
    }
    localObject = this.strSpaceName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 47);
    }
    localObject = this.stDateCard;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 48);
    }
    paramJceOutputStream.write(this.iBirthday, 49);
    localObject = this.stQCallInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 50);
    }
    localObject = this.stGiftInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 51);
    }
    localObject = this.stPanSocialInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 52);
    }
    localObject = this.stVideoInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 53);
    }
    localObject = this.vTempChatSig;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 54);
    }
    localObject = this.stInterestTag;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 55);
    }
    localObject = this.stUserFeed;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 56);
    }
    localObject = this.stQiqiVideoInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 57);
    }
    localObject = this.stPrivInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 58);
    }
    localObject = this.stApollo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 59);
    }
    localObject = this.stAddFrdSrcInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 60);
    }
    localObject = this.stBindPhoneInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 61);
    }
    localObject = this.vVisitingCardInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 62);
    }
    localObject = this.strVoteLimitedNotice;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 63);
    }
    paramJceOutputStream.write(this.bHaveVotedCnt, 64);
    paramJceOutputStream.write(this.bAvailVoteCnt, 65);
    localObject = this.strEIMBindPhoneNum;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 66);
    }
    localObject = this.strEIMId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 67);
    }
    localObject = this.strEmail;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 68);
    }
    paramJceOutputStream.write(this.uCareer, 69);
    localObject = this.strPersonal;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 70);
    }
    localObject = this.vHotChatInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 71);
    }
    localObject = this.stOlympicInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 72);
    }
    localObject = this.stCoverInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 73);
    }
    localObject = this.stNowBroadcastInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 74);
    }
    localObject = this.stEimInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 75);
    }
    localObject = this.stVideoHeadInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 78);
    }
    paramJceOutputStream.write(this.iContactNotBindQQ, 79);
    localObject = this.stMedalWallInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 80);
    }
    localObject = this.vvRespServicesBigOrder;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 81);
    }
    localObject = this.vResp0x5ebInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 82);
    }
    localObject = this.stNearbyGodInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 83);
    }
    localObject = this.vRespQQStoryInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 84);
    }
    localObject = this.vRespCustomLabelInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 85);
    }
    localObject = this.vPraiseList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 86);
    }
    localObject = this.stCampusCircleInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 87);
    }
    localObject = this.stTimInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 88);
    }
    localObject = this.stQimInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 89);
    }
    localObject = this.stHeartInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 90);
    }
    localObject = this.vQzoneCoverInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 91);
    }
    localObject = this.vNearbyTaskInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 92);
    }
    localObject = this.vNowInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 93);
    }
    paramJceOutputStream.write(this.uFriendGroupId, 94);
    localObject = this.vCommLabel;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 95);
    }
    localObject = this.vExtendCard;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 96);
    }
    localObject = this.strQzoneHeader;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 97);
    }
    localObject = this.mapQzoneEx;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 98);
    }
    localObject = this.vRespKandianInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 99);
    }
    localObject = this.stWeishiInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 100);
    }
    paramJceOutputStream.write(this.uRichCardNameVer, 101);
    paramJceOutputStream.write(this.uCurMulType, 102);
    localObject = this.vLongNickTopicInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 103);
    }
    paramJceOutputStream.write(this.i0x6d4Success, 104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.RespSummaryCard
 * JD-Core Version:    0.7.0.1
 */