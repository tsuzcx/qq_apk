import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageForTofuAioMiniProfile;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class agwz
{
  private static ArrayMap<Class<? extends MessageRecord>, Integer> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private static ArrayMap<Class<? extends ChatMessage>, ahbm> b;
  protected ajzo a;
  protected Context a;
  private SparseArray<ahbl> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  protected SessionInfo a;
  protected AIOAnimationConatiner a;
  protected QQAppInterface a;
  private Set<afxi> jdField_a_of_type_JavaUtilSet;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForNewGrayTips.class, Integer.valueOf(15));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForSafeGrayTips.class, Integer.valueOf(15));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForIncompatibleGrayTips.class, Integer.valueOf(15));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForNearbyMarketGrayTips.class, Integer.valueOf(15));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopEffectPic.class, Integer.valueOf(80));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevPtt.class, Integer.valueOf(33));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPtt.class, Integer.valueOf(2));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForVideo.class, Integer.valueOf(11));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForLocationShare.class, Integer.valueOf(113));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMarketFace.class, Integer.valueOf(12));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForRichState.class, Integer.valueOf(13));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStory.class, Integer.valueOf(67));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTribeShortVideo.class, Integer.valueOf(89));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopPobing.class, Integer.valueOf(77));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopNotification.class, Integer.valueOf(28));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFunnyFace.class, Integer.valueOf(19));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQzoneFeed.class, Integer.valueOf(21));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPLNews.class, Integer.valueOf(79));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMedalNews.class, Integer.valueOf(86));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForConfessCard.class, Integer.valueOf(92));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForConfessNews.class, Integer.valueOf(91));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopConfess.class, Integer.valueOf(97));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForEnterTroop.class, Integer.valueOf(22));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMyEnterTroop.class, Integer.valueOf(23));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForShakeWindow.class, Integer.valueOf(26));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopUnreadTips.class, Integer.valueOf(27));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForSplitLineTips.class, Integer.valueOf(70));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevShortVideo.class, Integer.valueOf(35));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevLittleVideo.class, Integer.valueOf(45));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForColorRing.class, Integer.valueOf(31));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopFee.class, Integer.valueOf(44));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeviceSingleStruct.class, Integer.valueOf(34));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQWalletTips.class, Integer.valueOf(15));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeviceText.class, Integer.valueOf(39));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(ShareHotChatGrayTips.class, Integer.valueOf(15));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeliverGiftTips.class, Integer.valueOf(15));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForArkFlashChat.class, Integer.valueOf(76));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForCmGameTips.class, Integer.valueOf(100));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForReplyText.class, Integer.valueOf(50));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForApproval.class, Integer.valueOf(52));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForVIPDonate.class, Integer.valueOf(58));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFoldMsgGrayTips.class, Integer.valueOf(57));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPokeEmo.class, Integer.valueOf(96));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStoryComment.class, Integer.valueOf(68));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopStory.class, Integer.valueOf(73));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForScribble.class, Integer.valueOf(75));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStoryFeed.class, Integer.valueOf(87));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTimDouFuGuide.class, Integer.valueOf(85));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForCommonHobbyForAIOShow.class, Integer.valueOf(94));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForLimitChatTopic.class, Integer.valueOf(102));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForStarLeague.class, Integer.valueOf(101));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFuDai.class, Integer.valueOf(104));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForBirthdayNotice.class, Integer.valueOf(108));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForAIOStoryVideo.class, Integer.valueOf(109));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuIntimateAnniversary.class, Integer.valueOf(115));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuBaseProfile.class, Integer.valueOf(116));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuNicePics.class, Integer.valueOf(117));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuAioMiniProfile.class, Integer.valueOf(118));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQCircleIceBreak.class, Integer.valueOf(119));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQCircleFeed.class, Integer.valueOf(120));
    b = new ArrayMap();
    b.put(MessageForText.class, new agxa());
    b.put(MessageForTroopGift.class, new agyb());
    b.put(MessageForGrayTips.class, new agym());
    b.put(MessageForPic.class, new agyx());
    b.put(MessageForFile.class, new agzi());
    b.put(MessageForPubAccount.class, new agzt());
    b.put(MessageForTroopSign.class, new ahae());
    b.put(MessageForStructing.class, new ahap());
    b.put(MessageForLongMsg.class, new ahba());
    b.put(MessageForMixedMsg.class, new agxb());
    b.put(MessageForTroopFile.class, new agxm());
    agxt localagxt = new agxt();
    b.put(MessageForShortVideo.class, localagxt);
    b.put(MessageForLightVideo.class, localagxt);
    b.put(MessageForDanceMachine.class, localagxt);
    b.put(MessageForBlessPTV.class, localagxt);
    b.put(MessageForQQWalletMsg.class, new agxu());
    b.put(MessageForDeviceFile.class, new agxv());
    b.put(MessageForArkApp.class, new agxw());
    b.put(MessageForArkBabyqReply.class, new agxx());
    b.put(MessageForApollo.class, new agxy());
    b.put(MessageForTroopReward.class, new agxz());
    b.put(MessageForPoke.class, new agya());
    b.put(MessageForUniteGrayTip.class, new agyc());
    b.put(MessageForHiBoom.class, new agyd());
  }
  
  public agwz(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(61, new agye(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(65, new agyf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new agyg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new agyh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(24, new agyi(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new agyj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(33, new agyk(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(15, new agyl(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new agyn(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new agyo(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(7, new agyp(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(8, new agyq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new agyr(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(114, new agys(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new agyt(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(113, new agyu(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new agyv(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new agyw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new agyy(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(16, new agyz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(22, new agza(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(23, new agzb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(17, new agzc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(18, new agzd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(21, new agze(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(108, new agzf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(79, new agzg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(86, new agzh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(94, new agzj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(91, new agzk(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(92, new agzl(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(97, new agzm(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new agzn(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(62, new agzo(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(96, new agzp(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(27, new agzq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(70, new agzr(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(28, new agzs(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(29, new agzu(this));
    Object localObject = new agzv(this);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(38, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(40, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(41, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(46, new agzw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(103, new agzx(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(31, new agzy(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(32, new agzz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(90, new ahaa(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new ahab(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(48, new ahac(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(49, new ahad(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(35, new ahaf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(45, new ahag(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(34, new ahah(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(36, new ahai(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(37, new ahaj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new ahak(this));
    localObject = new ahal(this);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(42, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(66, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(56, new aham(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(88, new ahan(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(100, new ahao(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(47, new ahaq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(81, new ahar(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(112, new ahas(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(76, new ahat(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(50, new ahau(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(52, new ahav(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(58, new ahaw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(57, new ahax(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(63, new ahay(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(64, new ahaz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(67, new ahbb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(89, new ahbc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(77, new ahbd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(68, new ahbe(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(71, new ahbf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(84, new ahbg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new ahbh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(78, new ahbi(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(75, new ahbj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(80, new ahbk(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(87, new agxc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(85, new agxd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(93, new agxe(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(102, new agxf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(101, new agxg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(104, new agxh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(109, new agxi(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(110, new agxj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(111, new agxk(this));
    localObject = new agxl(this);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(19, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(0, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(115, new agxn(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(116, new agxo(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(117, new agxp(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(118, new agxq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(119, new agxr(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(120, new agxs(this));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, @Nullable ChatMessage paramChatMessage)
  {
    int i;
    if (paramChatMessage == null)
    {
      QLog.e("ItemBuilderFactory", 1, "message is null");
      i = 0;
    }
    int j;
    do
    {
      return i;
      if (!b.containsKey(paramChatMessage.getClass())) {
        break;
      }
      j = ((ahbm)b.get(paramChatMessage.getClass())).a(paramQQAppInterface, paramChatMessage);
      i = j;
    } while (j != -1);
    if (jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramChatMessage.getClass())) {
      return ((Integer)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramChatMessage.getClass())).intValue();
    }
    return 0;
  }
  
  protected afxi a(afxi paramafxi, BaseAdapter paramBaseAdapter)
  {
    if (((paramafxi instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof afwy)))
    {
      paramBaseAdapter = (afwy)paramBaseAdapter;
      ((BaseBubbleBuilder)paramafxi).a(paramBaseAdapter.a);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramafxi);
    return paramafxi;
  }
  
  public afxi a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: message = " + paramChatMessage);
    }
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return ((ahbl)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).b(paramChatMessage, paramBaseAdapter);
    }
    return ((ahbl)this.jdField_a_of_type_AndroidUtilSparseArray.get(0)).b(paramChatMessage, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((afxi)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwz
 * JD-Core Version:    0.7.0.1
 */