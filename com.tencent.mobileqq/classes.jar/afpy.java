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

public class afpy
{
  private static ArrayMap<Class<? extends MessageRecord>, Integer> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private static ArrayMap<Class<? extends ChatMessage>, afug> b;
  protected aiiv a;
  protected Context a;
  private SparseArray<afuf> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  protected SessionInfo a;
  protected AIOAnimationConatiner a;
  protected QQAppInterface a;
  private Set<aeqy> jdField_a_of_type_JavaUtilSet;
  
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
    b = new ArrayMap();
    b.put(MessageForText.class, new afpz());
    b.put(MessageForTroopGift.class, new afqv());
    b.put(MessageForGrayTips.class, new afrg());
    b.put(MessageForPic.class, new afrr());
    b.put(MessageForFile.class, new afsc());
    b.put(MessageForPubAccount.class, new afsn());
    b.put(MessageForTroopSign.class, new afsy());
    b.put(MessageForStructing.class, new aftj());
    b.put(MessageForLongMsg.class, new aftu());
    b.put(MessageForMixedMsg.class, new afqa());
    b.put(MessageForTroopFile.class, new afql());
    afqn localafqn = new afqn();
    b.put(MessageForShortVideo.class, localafqn);
    b.put(MessageForLightVideo.class, localafqn);
    b.put(MessageForDanceMachine.class, localafqn);
    b.put(MessageForBlessPTV.class, localafqn);
    b.put(MessageForQQWalletMsg.class, new afqo());
    b.put(MessageForDeviceFile.class, new afqp());
    b.put(MessageForArkApp.class, new afqq());
    b.put(MessageForArkBabyqReply.class, new afqr());
    b.put(MessageForApollo.class, new afqs());
    b.put(MessageForTroopReward.class, new afqt());
    b.put(MessageForPoke.class, new afqu());
    b.put(MessageForUniteGrayTip.class, new afqw());
    b.put(MessageForHiBoom.class, new afqx());
  }
  
  public afpy(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(61, new afqy(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(65, new afqz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new afra(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new afrb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(24, new afrc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new afrd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(33, new afre(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(15, new afrf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new afrh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new afri(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(7, new afrj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(8, new afrk(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new afrl(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(114, new afrm(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(10, new afrn(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new afro(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(113, new afrp(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new afrq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new afrs(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new afrt(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(16, new afru(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(22, new afrv(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(23, new afrw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(17, new afrx(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(18, new afry(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(21, new afrz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(108, new afsa(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(79, new afsb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(86, new afsd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(94, new afse(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(91, new afsf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(92, new afsg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(97, new afsh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new afsi(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(62, new afsj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(96, new afsk(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(27, new afsl(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(70, new afsm(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(28, new afso(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(29, new afsp(this));
    Object localObject = new afsq(this);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(38, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(40, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(41, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(46, new afsr(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(103, new afss(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(31, new afst(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(32, new afsu(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(90, new afsv(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new afsw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(48, new afsx(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(49, new afsz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(35, new afta(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(45, new aftb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(34, new aftc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(36, new aftd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(37, new afte(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new aftf(this));
    localObject = new aftg(this);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(42, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(66, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(56, new afth(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(88, new afti(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(100, new aftk(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(47, new aftl(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(81, new aftm(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(112, new aftn(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(76, new afto(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(50, new aftp(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(52, new aftq(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(58, new aftr(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(57, new afts(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(63, new aftt(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(64, new aftv(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(67, new aftw(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(89, new aftx(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(77, new afty(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(68, new aftz(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(71, new afua(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(84, new afub(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new afuc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(78, new afud(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(75, new afue(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(80, new afqb(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(87, new afqc(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(85, new afqd(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(93, new afqe(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(102, new afqf(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(101, new afqg(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(104, new afqh(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(109, new afqi(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(110, new afqj(this));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(111, new afqk(this));
    localObject = new afqm(this);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(19, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(0, localObject);
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
      j = ((afug)b.get(paramChatMessage.getClass())).a(paramQQAppInterface, paramChatMessage);
      i = j;
    } while (j != -1);
    if (jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramChatMessage.getClass())) {
      return ((Integer)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramChatMessage.getClass())).intValue();
    }
    return 0;
  }
  
  protected aeqy a(aeqy paramaeqy, BaseAdapter paramBaseAdapter)
  {
    if (((paramaeqy instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof aeqo)))
    {
      paramBaseAdapter = (aeqo)paramBaseAdapter;
      ((BaseBubbleBuilder)paramaeqy).a(paramBaseAdapter.a);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramaeqy);
    return paramaeqy;
  }
  
  public aeqy a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: message = " + paramChatMessage);
    }
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return ((afuf)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).b(paramChatMessage, paramBaseAdapter);
    }
    return ((afuf)this.jdField_a_of_type_AndroidUtilSparseArray.get(0)).b(paramChatMessage, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((aeqy)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpy
 * JD-Core Version:    0.7.0.1
 */