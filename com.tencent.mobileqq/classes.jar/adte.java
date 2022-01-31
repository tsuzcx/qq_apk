import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
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
import com.tencent.mobileqq.data.MessageForLongTextMsg;
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
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class adte
{
  adkl jdField_a_of_type_Adkl;
  adko jdField_a_of_type_Adko;
  adkr jdField_a_of_type_Adkr;
  adle jdField_a_of_type_Adle;
  adlg jdField_a_of_type_Adlg;
  adls jdField_a_of_type_Adls;
  adma jdField_a_of_type_Adma;
  admh jdField_a_of_type_Admh;
  admj jdField_a_of_type_Admj;
  admm jdField_a_of_type_Admm;
  admx jdField_a_of_type_Admx;
  private adne jdField_a_of_type_Adne;
  private adnh jdField_a_of_type_Adnh;
  adnk jdField_a_of_type_Adnk;
  adnq jdField_a_of_type_Adnq;
  adnu jdField_a_of_type_Adnu;
  adod jdField_a_of_type_Adod;
  adoh jdField_a_of_type_Adoh;
  adol jdField_a_of_type_Adol;
  adop jdField_a_of_type_Adop;
  adov jdField_a_of_type_Adov;
  adpo jdField_a_of_type_Adpo;
  adpz jdField_a_of_type_Adpz;
  adqe jdField_a_of_type_Adqe;
  adqw jdField_a_of_type_Adqw;
  adsy jdField_a_of_type_Adsy;
  adtk jdField_a_of_type_Adtk;
  adtn jdField_a_of_type_Adtn;
  adts jdField_a_of_type_Adts;
  adtu jdField_a_of_type_Adtu;
  adub jdField_a_of_type_Adub;
  aduc jdField_a_of_type_Aduc;
  adue jdField_a_of_type_Adue;
  aduu jdField_a_of_type_Aduu;
  aduy jdField_a_of_type_Aduy;
  advd jdField_a_of_type_Advd;
  advf jdField_a_of_type_Advf;
  advi jdField_a_of_type_Advi;
  advl jdField_a_of_type_Advl;
  advp jdField_a_of_type_Advp;
  advs jdField_a_of_type_Advs;
  adwc jdField_a_of_type_Adwc;
  adwp jdField_a_of_type_Adwp;
  adww jdField_a_of_type_Adww;
  adxe jdField_a_of_type_Adxe;
  private adxj jdField_a_of_type_Adxj;
  adxt jdField_a_of_type_Adxt;
  adxv jdField_a_of_type_Adxv;
  adya jdField_a_of_type_Adya;
  adyf jdField_a_of_type_Adyf;
  adyr jdField_a_of_type_Adyr;
  adza jdField_a_of_type_Adza;
  adzf jdField_a_of_type_Adzf;
  adzq jdField_a_of_type_Adzq;
  aeax jdField_a_of_type_Aeax;
  aeba jdField_a_of_type_Aeba;
  aebx jdField_a_of_type_Aebx;
  aecg jdField_a_of_type_Aecg;
  aecl jdField_a_of_type_Aecl;
  aecq jdField_a_of_type_Aecq;
  aecy jdField_a_of_type_Aecy;
  aedb jdField_a_of_type_Aedb;
  aedr jdField_a_of_type_Aedr;
  aeds jdField_a_of_type_Aeds;
  aedv jdField_a_of_type_Aedv;
  aedx jdField_a_of_type_Aedx;
  aeee jdField_a_of_type_Aeee;
  aeeg jdField_a_of_type_Aeeg;
  aeen jdField_a_of_type_Aeen;
  aeep jdField_a_of_type_Aeep;
  aeer jdField_a_of_type_Aeer;
  aefd jdField_a_of_type_Aefd;
  aefg jdField_a_of_type_Aefg;
  protected aggb a;
  amoj jdField_a_of_type_Amoj;
  protected Context a;
  private aqlq jdField_a_of_type_Aqlq;
  aquw jdField_a_of_type_Aquw;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  protected SessionInfo a;
  protected AIOAnimationConatiner a;
  ApolloItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder;
  FlashPicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder;
  LightVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder;
  QQStoryItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder;
  ScribbleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder;
  ShortVideoRealItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder;
  StructingMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
  TribeShortVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder;
  protected QQAppInterface a;
  private Set<acuz> jdField_a_of_type_JavaUtilSet;
  ydu jdField_a_of_type_Ydu;
  ydy jdField_a_of_type_Ydy;
  yee jdField_a_of_type_Yee;
  adnu jdField_b_of_type_Adnu;
  adww jdField_b_of_type_Adww;
  adww c;
  
  public adte(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int j = 15;
    int i;
    if ((paramChatMessage instanceof MessageForText)) {
      if ((paramChatMessage instanceof MessageForLongTextMsg)) {
        i = 63;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return i;
                    if ((paramChatMessage instanceof MessageForWantGiftMsg)) {
                      return 72;
                    }
                    if (((MessageForText)paramChatMessage).locationUrl != null) {
                      return 10;
                    }
                    if ((paramChatMessage.vipBubbleID != 100000L) || (paramChatMessage.isSend())) {
                      break label1321;
                    }
                    return 9;
                    if ((paramChatMessage instanceof MessageForTroopGift))
                    {
                      if (paramChatMessage.isSend()) {
                        return 48;
                      }
                      return 49;
                    }
                    if ((paramChatMessage instanceof MessageForWantGiftMsg)) {
                      return 72;
                    }
                    if (!(paramChatMessage instanceof MessageForGrayTips)) {
                      break;
                    }
                    i = j;
                  } while (paramChatMessage.msgtype != -3016);
                  return 93;
                  i = j;
                } while ((paramChatMessage instanceof MessageForNewGrayTips));
                i = j;
              } while ((paramChatMessage instanceof MessageForSafeGrayTips));
              i = j;
            } while ((paramChatMessage instanceof MessageForIncompatibleGrayTips));
            i = j;
          } while ((paramChatMessage instanceof MessageForNearbyMarketGrayTips));
          if ((paramChatMessage instanceof MessageForTroopEffectPic)) {
            return 80;
          }
          if ((paramChatMessage instanceof MessageForPic))
          {
            if (((MessageForPic)paramChatMessage).isMixed) {
              return 24;
            }
            if (ajyi.a(paramChatMessage)) {
              return 42;
            }
            if (ajwb.a(paramChatMessage)) {
              return 66;
            }
            return 1;
          }
          if ((paramChatMessage instanceof MessageForDevPtt)) {
            return 33;
          }
          if ((paramChatMessage instanceof MessageForPtt)) {
            return 2;
          }
          if ((paramChatMessage instanceof MessageForFile)) {
            return aoyp.a(paramQQAppInterface, paramChatMessage);
          }
          if ((paramChatMessage instanceof MessageForVideo)) {
            return 11;
          }
          if ((paramChatMessage instanceof MessageForLocationShare)) {
            return 113;
          }
          if ((paramChatMessage instanceof MessageForMarketFace)) {
            return 12;
          }
          if ((paramChatMessage instanceof MessageForRichState)) {
            return 13;
          }
          if ((paramChatMessage instanceof MessageForPubAccount))
          {
            paramQQAppInterface = ((MessageForPubAccount)paramChatMessage).mPAMessage;
            if ((paramQQAppInterface != null) && (paramQQAppInterface.items != null) && (paramQQAppInterface.items.size() != 0))
            {
              if (((PAMessage.Item)paramQQAppInterface.items.get(0)).cover != null)
              {
                if (paramQQAppInterface.items.size() == 1) {
                  return 6;
                }
                if (paramQQAppInterface.items.size() < 2) {
                  break;
                }
                return 7;
              }
              return 8;
            }
            return 0;
          }
          if ((paramChatMessage instanceof MessageForQQStory)) {
            return 67;
          }
          if ((paramChatMessage instanceof MessageForTribeShortVideo)) {
            return 89;
          }
          if ((paramChatMessage instanceof MessageForTroopPobing)) {
            return 77;
          }
          if ((paramChatMessage instanceof MessageForTroopSign))
          {
            if (TextUtils.isEmpty(((MessageForTroopSign)paramChatMessage).dynamicSource)) {
              return 71;
            }
            return 84;
          }
          if ((paramChatMessage instanceof MessageForTroopNotification)) {
            return 28;
          }
          if ((paramChatMessage instanceof MessageForStructing))
          {
            if ((((MessageForStructing)paramChatMessage).structingMsg instanceof StructMsgSubImageVideo)) {
              return 111;
            }
            return 5;
          }
          if ((paramChatMessage instanceof MessageForFunnyFace)) {
            return 19;
          }
          if (((paramChatMessage instanceof MessageForLongMsg)) && (paramChatMessage.msgtype != -1036)) {
            return 17;
          }
          if (((paramChatMessage instanceof MessageForMixedMsg)) || ((paramChatMessage != null) && (paramChatMessage.msgtype == -1036))) {
            return 18;
          }
          if ((paramChatMessage instanceof MessageForQzoneFeed)) {
            return 21;
          }
          if ((paramChatMessage instanceof MessageForPLNews)) {
            return 79;
          }
          if ((paramChatMessage instanceof MessageForMedalNews)) {
            return 86;
          }
          if ((paramChatMessage instanceof MessageForConfessCard)) {
            return 92;
          }
          if ((paramChatMessage instanceof MessageForConfessNews)) {
            return 91;
          }
          if ((paramChatMessage instanceof MessageForTroopConfess)) {
            return 97;
          }
          if ((paramChatMessage instanceof MessageForActivity)) {
            return 16;
          }
          if ((paramChatMessage instanceof MessageForEnterTroop)) {
            return 22;
          }
          if ((paramChatMessage instanceof MessageForMyEnterTroop)) {
            return 23;
          }
          if ((paramChatMessage instanceof MessageForTroopFile)) {
            return aoyp.a(paramQQAppInterface, paramChatMessage);
          }
          if ((paramChatMessage instanceof MessageForShakeWindow)) {
            return 26;
          }
          if ((paramChatMessage instanceof MessageForTroopUnreadTips)) {
            return 27;
          }
          if ((paramChatMessage instanceof MessageForSplitLineTips)) {
            return 70;
          }
          if ((paramChatMessage instanceof MessageForDevShortVideo)) {
            return 35;
          }
          if ((paramChatMessage instanceof MessageForDevLittleVideo)) {
            return 45;
          }
          if ((paramChatMessage instanceof MessageForShortVideo))
          {
            if ((paramChatMessage instanceof MessageForLightVideo)) {
              return 103;
            }
            switch (((MessageForShortVideo)paramChatMessage).busiType)
            {
            default: 
              return 29;
            case 0: 
              return 29;
            case 1: 
              return 38;
            case 2: 
              return 46;
            case 1007: 
              return 40;
            }
            return 41;
          }
          if ((paramChatMessage instanceof MessageForColorRing)) {
            return 31;
          }
          if ((paramChatMessage instanceof MessageForQQWalletMsg))
          {
            if (ahiv.a((MessageForQQWalletMsg)paramChatMessage)) {
              return 32;
            }
            return 90;
          }
          if ((paramChatMessage instanceof MessageForTroopFee)) {
            return 44;
          }
          if ((paramChatMessage instanceof MessageForDeviceFile))
          {
            paramQQAppInterface = (MessageForDeviceFile)paramChatMessage;
            if (paramQQAppInterface.nFileMsgType == 2) {
              return 36;
            }
            if (paramQQAppInterface.nFileMsgType != 1) {
              break;
            }
            return 37;
          }
          if ((paramChatMessage instanceof MessageForDeviceSingleStruct)) {
            return 34;
          }
          i = j;
        } while ((paramChatMessage instanceof MessageForQQWalletTips));
        if ((paramChatMessage instanceof MessageForDeviceText)) {
          return 39;
        }
        i = j;
      } while ((paramChatMessage instanceof ShareHotChatGrayTips));
      i = j;
    } while ((paramChatMessage instanceof MessageForDeliverGiftTips));
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramQQAppInterface = (MessageForArkApp)paramChatMessage;
      paramChatMessage = new ArkAppMessage.Config();
      paramChatMessage.fromString(paramQQAppInterface.ark_app_message.config);
      if ((paramChatMessage.type != null) && (paramChatMessage.type.equals("multiple"))) {
        return 112;
      }
      if ((paramChatMessage.type != null) && (paramChatMessage.type.equals("card"))) {
        return 81;
      }
      return 47;
    }
    if ((paramChatMessage instanceof MessageForArkBabyqReply))
    {
      paramQQAppInterface = (MessageForArkBabyqReply)paramChatMessage;
      if ((paramQQAppInterface.mArkBabyqReplyCardList == null) || (paramQQAppInterface.mArkBabyqReplyCardList.size() <= 0)) {
        return 83;
      }
      return 82;
    }
    if ((paramChatMessage instanceof MessageForArkFlashChat)) {
      return 76;
    }
    if ((paramChatMessage instanceof MessageForApollo))
    {
      if (ApolloGameUtil.a(paramChatMessage, paramQQAppInterface) == ApolloGameUtil.c) {
        return 88;
      }
      return 56;
    }
    if ((paramChatMessage instanceof MessageForCmGameTips)) {
      return 100;
    }
    if ((paramChatMessage instanceof MessageForReplyText)) {
      return 50;
    }
    if ((paramChatMessage instanceof MessageForApproval)) {
      return 52;
    }
    if ((paramChatMessage instanceof MessageForTroopReward))
    {
      if (paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
        return 59;
      }
      return 60;
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {
      return 58;
    }
    if ((paramChatMessage instanceof MessageForFoldMsgGrayTips)) {
      return 57;
    }
    if ((paramChatMessage instanceof MessageForPoke))
    {
      paramQQAppInterface = (MessageForPoke)paramChatMessage;
      if ((paramQQAppInterface.interactType == 126) && (!adwj.a(paramQQAppInterface.minVersion))) {
        return 0;
      }
      return 62;
    }
    if ((paramChatMessage instanceof MessageForPokeEmo)) {
      return 96;
    }
    if ((paramChatMessage instanceof MessageForUniteGrayTip))
    {
      paramQQAppInterface = ((MessageForUniteGrayTip)paramChatMessage).tipParam;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b == 655384)) {
        return 110;
      }
      return 64;
    }
    if ((paramChatMessage instanceof MessageForQQStoryComment)) {
      return 68;
    }
    if ((paramChatMessage instanceof MessageForTroopStory)) {
      return 73;
    }
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      if (aqxj.a(paramQQAppInterface).a()) {
        return 78;
      }
      return 0;
    }
    if ((paramChatMessage instanceof MessageForScribble)) {
      return 75;
    }
    if ((paramChatMessage instanceof MessageForQQStoryFeed)) {
      return 87;
    }
    if ((paramChatMessage instanceof MessageForTimDouFuGuide)) {
      return 85;
    }
    if ((paramChatMessage instanceof MessageForCommonHobbyForAIOShow)) {
      return 94;
    }
    if ((paramChatMessage instanceof MessageForLimitChatTopic)) {
      return 102;
    }
    if ((paramChatMessage instanceof MessageForStarLeague)) {
      return 101;
    }
    if ((paramChatMessage instanceof MessageForFuDai)) {
      return 104;
    }
    if ((paramChatMessage instanceof MessageForBirthdayNotice)) {
      return 108;
    }
    if ((paramChatMessage instanceof MessageForAIOStoryVideo)) {
      return 109;
    }
    label1321:
    return 0;
  }
  
  protected acuz a(acuz paramacuz, BaseAdapter paramBaseAdapter)
  {
    if (((paramacuz instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof acup)))
    {
      paramBaseAdapter = (acup)paramBaseAdapter;
      ((BaseBubbleBuilder)paramacuz).a(paramBaseAdapter.a);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramacuz);
    return paramacuz;
  }
  
  public acuz a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: message = " + paramChatMessage);
    }
    switch (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage))
    {
    case 4: 
    case 14: 
    case 19: 
    case 20: 
    case 25: 
    case 30: 
    case 43: 
    case 51: 
    case 53: 
    case 54: 
    case 55: 
    case 59: 
    case 60: 
    case 69: 
    case 74: 
    case 82: 
    case 83: 
    case 95: 
    case 98: 
    case 99: 
    case 105: 
    case 106: 
    case 107: 
    default: 
      if (this.jdField_a_of_type_Aebx == null) {
        this.jdField_a_of_type_Aebx = new aebx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aebx, paramBaseAdapter);
    case 61: 
      if (this.jdField_a_of_type_Adww == null) {
        this.jdField_a_of_type_Adww = aoyp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 61, paramChatMessage);
      }
      return a(this.jdField_a_of_type_Adww, paramBaseAdapter);
    case 65: 
      if (this.c == null) {
        this.c = aoyp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 65, paramChatMessage);
      }
      return a(this.c, paramBaseAdapter);
    case 3: 
      if (this.jdField_b_of_type_Adww == null) {
        this.jdField_b_of_type_Adww = aoyp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 3, paramChatMessage);
      }
      return a(this.jdField_b_of_type_Adww, paramBaseAdapter);
    case 1: 
      if (this.jdField_a_of_type_Advs == null) {
        this.jdField_a_of_type_Advs = new advs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Advs, paramBaseAdapter);
    case 24: 
      if (this.jdField_a_of_type_Adle == null) {
        this.jdField_a_of_type_Adle = new adle(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adle, paramBaseAdapter);
    case 2: 
      if (this.jdField_a_of_type_Adwp == null) {
        this.jdField_a_of_type_Adwp = new adwp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Adwp, paramBaseAdapter);
    case 33: 
      if (this.jdField_a_of_type_Yee == null) {
        this.jdField_a_of_type_Yee = new yee(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePttItemBuilder");
      }
      return a(this.jdField_a_of_type_Yee, paramBaseAdapter);
    case 15: 
      if (this.jdField_a_of_type_Adqw == null) {
        this.jdField_a_of_type_Adqw = new adqw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adqw, paramBaseAdapter);
    case 72: 
      if (this.jdField_a_of_type_Aeer == null) {
        this.jdField_a_of_type_Aeer = new aeer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeer, paramBaseAdapter);
    case 6: 
      if (this.jdField_a_of_type_Advi == null) {
        this.jdField_a_of_type_Advi = new advi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advi, paramBaseAdapter);
    case 7: 
      if (this.jdField_a_of_type_Advf == null) {
        this.jdField_a_of_type_Advf = new advf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advf, paramBaseAdapter);
    case 8: 
      if (this.jdField_a_of_type_Advl == null) {
        this.jdField_a_of_type_Advl = new advl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advl, paramBaseAdapter);
    case 5: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder = new StructingMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, paramBaseAdapter);
    case 10: 
      if (this.jdField_a_of_type_Adtn == null) {
        this.jdField_a_of_type_Adtn = new adtn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adtn, paramBaseAdapter);
    case 11: 
      if (this.jdField_a_of_type_Aefg == null) {
        this.jdField_a_of_type_Aefg = new aefg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aefg, paramBaseAdapter);
    case 113: 
      if (this.jdField_a_of_type_Adts == null) {
        this.jdField_a_of_type_Adts = new adts(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adts, paramBaseAdapter);
    case 13: 
      if (this.jdField_a_of_type_Adyr == null) {
        this.jdField_a_of_type_Adyr = new adyr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adyr, paramBaseAdapter);
    case 9: 
      if (this.jdField_a_of_type_Aecg == null) {
        this.jdField_a_of_type_Aecg = new aecg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aecg, paramBaseAdapter);
    case 12: 
      if (this.jdField_a_of_type_Adue == null) {
        this.jdField_a_of_type_Adue = new adue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adue, paramBaseAdapter);
    case 16: 
      if (this.jdField_a_of_type_Adko == null) {
        this.jdField_a_of_type_Adko = new adko(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adko, paramBaseAdapter);
    case 22: 
      if (this.jdField_a_of_type_Adov == null) {
        this.jdField_a_of_type_Adov = new adov(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adov, paramBaseAdapter);
    case 23: 
      if (this.jdField_a_of_type_Advd == null) {
        this.jdField_a_of_type_Advd = new advd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advd, paramBaseAdapter);
    case 17: 
      if (this.jdField_a_of_type_Adtu == null) {
        this.jdField_a_of_type_Adtu = new adtu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adtu, paramBaseAdapter);
    case 18: 
      if (this.jdField_a_of_type_Aduy == null) {
        this.jdField_a_of_type_Aduy = new aduy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aduy, paramBaseAdapter);
    case 21: 
      if (this.jdField_a_of_type_Adya == null) {
        this.jdField_a_of_type_Adya = new adya(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: qzoneFeedItemBuilder = " + this.jdField_a_of_type_Adya);
      }
      return a(this.jdField_a_of_type_Adya, paramBaseAdapter);
    case 108: 
      if (this.jdField_a_of_type_Adnh == null) {
        this.jdField_a_of_type_Adnh = new adnh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: mBirthDayNoticeItemBuilder = " + this.jdField_a_of_type_Adnh);
      }
      return a(this.jdField_a_of_type_Adnh, paramBaseAdapter);
    case 79: 
      if (this.jdField_a_of_type_Advp == null) {
        this.jdField_a_of_type_Advp = new advp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advp, paramBaseAdapter);
    case 86: 
      if (this.jdField_a_of_type_Aduu == null) {
        this.jdField_a_of_type_Aduu = new aduu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aduu, paramBaseAdapter);
    case 94: 
      if (this.jdField_a_of_type_Adnq == null) {
        this.jdField_a_of_type_Adnq = new adnq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adnq, paramBaseAdapter);
    case 91: 
      if (this.jdField_a_of_type_Adnu == null) {
        this.jdField_a_of_type_Adnu = new adnu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adnu, paramBaseAdapter);
    case 92: 
      if (this.jdField_b_of_type_Adnu == null) {
        this.jdField_b_of_type_Adnu = new adnu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_b_of_type_Adnu, paramBaseAdapter);
    case 97: 
      if (this.jdField_a_of_type_Amoj == null) {
        this.jdField_a_of_type_Amoj = new amoj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Amoj, paramBaseAdapter);
    case 26: 
      if (this.jdField_a_of_type_Adza == null) {
        this.jdField_a_of_type_Adza = new adza(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adza, paramBaseAdapter);
    case 62: 
      paramChatMessage = (MessageForPoke)paramChatMessage;
      if (this.jdField_a_of_type_Adqe == null) {
        this.jdField_a_of_type_Adqe = new adqe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adqe, paramBaseAdapter);
    case 96: 
      paramChatMessage = (MessageForPokeEmo)paramChatMessage;
      if (this.jdField_a_of_type_Adwc == null) {
        this.jdField_a_of_type_Adwc = new adwc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adwc, paramBaseAdapter);
    case 27: 
      if (this.jdField_a_of_type_Aeep == null) {
        this.jdField_a_of_type_Aeep = new aeep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aeep, paramBaseAdapter);
    case 70: 
      if (this.jdField_a_of_type_Aedv == null) {
        this.jdField_a_of_type_Aedv = new aedv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aedv, paramBaseAdapter);
    case 28: 
      if (this.jdField_a_of_type_Aeba == null) {
        this.jdField_a_of_type_Aeba = new aeba(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeba, paramBaseAdapter);
    case 29: 
      if (this.jdField_a_of_type_Adzf == null) {
        this.jdField_a_of_type_Adzf = new adzf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adzf, paramBaseAdapter);
    case 38: 
    case 40: 
    case 41: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder = new ShortVideoRealItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder, paramBaseAdapter);
    case 46: 
      if (this.jdField_a_of_type_Adzq == null) {
        this.jdField_a_of_type_Adzq = new adzq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adzq, paramBaseAdapter);
    case 103: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder = new LightVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder, paramBaseAdapter);
    case 31: 
      if (this.jdField_a_of_type_Aecl == null) {
        this.jdField_a_of_type_Aecl = new aecl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aecl, paramBaseAdapter);
    case 32: 
      if (this.jdField_a_of_type_Adxt == null) {
        this.jdField_a_of_type_Adxt = new adxt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adxt, paramBaseAdapter);
    case 90: 
      if (this.jdField_a_of_type_Adxv == null) {
        this.jdField_a_of_type_Adxv = new adxv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adxv, paramBaseAdapter);
    case 44: 
      if (this.jdField_a_of_type_Aedb == null) {
        this.jdField_a_of_type_Aedb = new aedb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aedb, paramBaseAdapter);
    case 48: 
      if (this.jdField_a_of_type_Aeds == null) {
        this.jdField_a_of_type_Aeds = new aeds(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Aeds, paramBaseAdapter);
    case 49: 
      if (this.jdField_a_of_type_Aedr == null) {
        this.jdField_a_of_type_Aedr = new aedr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Aedr, paramBaseAdapter);
    case 35: 
      if (this.jdField_a_of_type_Ydy == null) {
        this.jdField_a_of_type_Ydy = new ydy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Ydy, paramBaseAdapter);
    case 45: 
      if (this.jdField_a_of_type_Ydu == null) {
        this.jdField_a_of_type_Ydu = new ydu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Ydu, paramBaseAdapter);
    case 34: 
      if (this.jdField_a_of_type_Adol == null) {
        this.jdField_a_of_type_Adol = new adol(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceSingleItemBuilder");
      }
      return a(this.jdField_a_of_type_Adol, paramBaseAdapter);
    case 36: 
      if (this.jdField_a_of_type_Adoh == null) {
        this.jdField_a_of_type_Adoh = new adoh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePicItemBuilder");
      }
      return a(this.jdField_a_of_type_Adoh, paramBaseAdapter);
    case 37: 
      if (this.jdField_a_of_type_Adod == null) {
        this.jdField_a_of_type_Adod = new adod(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceFileItemBuilder");
      }
      return a(this.jdField_a_of_type_Adod, paramBaseAdapter);
    case 39: 
      if (this.jdField_a_of_type_Adop == null) {
        this.jdField_a_of_type_Adop = new adop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adop, paramBaseAdapter);
    case 42: 
    case 66: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder = new FlashPicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder, paramBaseAdapter);
    case 56: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder = new ApolloItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder, paramBaseAdapter);
    case 88: 
      if (this.jdField_a_of_type_Adkr == null) {
        this.jdField_a_of_type_Adkr = new adkr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adkr, paramBaseAdapter);
    case 100: 
      if (this.jdField_a_of_type_Adnk == null) {
        this.jdField_a_of_type_Adnk = new adnk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adnk, paramBaseAdapter);
    case 47: 
      int j = 1;
      int i = j;
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        paramChatMessage = (MessageForArkApp)paramChatMessage;
        ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
        i = j;
        if (paramChatMessage.ark_app_message != null)
        {
          localConfig.fromString(paramChatMessage.ark_app_message.config);
          i = j;
          if (localConfig.showSender != null)
          {
            i = j;
            if (localConfig.showSender.intValue() == 0) {
              i = 0;
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1038))
      {
        if (this.jdField_a_of_type_Admj == null) {
          this.jdField_a_of_type_Admj = new admj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        }
        return a(this.jdField_a_of_type_Admj, paramBaseAdapter);
      }
      if ((i == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
      {
        if (this.jdField_a_of_type_Adma == null) {
          this.jdField_a_of_type_Adma = new adma(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        }
        return a(this.jdField_a_of_type_Adma, paramBaseAdapter);
      }
      if (this.jdField_a_of_type_Adls == null) {
        this.jdField_a_of_type_Adls = new adls(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adls, paramBaseAdapter);
    case 81: 
      if (this.jdField_a_of_type_Admm == null) {
        this.jdField_a_of_type_Admm = new admm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admm, paramBaseAdapter);
    case 112: 
      if (this.jdField_a_of_type_Admh == null) {
        this.jdField_a_of_type_Admh = new admh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admh, paramBaseAdapter);
    case 76: 
      if (this.jdField_a_of_type_Admx == null) {
        this.jdField_a_of_type_Admx = new admx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admx, paramBaseAdapter);
    case 50: 
      if (this.jdField_a_of_type_Adyf == null) {
        this.jdField_a_of_type_Adyf = new adyf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adyf, paramBaseAdapter);
    case 52: 
      if (this.jdField_a_of_type_Adlg == null) {
        this.jdField_a_of_type_Adlg = new adlg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adlg, paramBaseAdapter);
    case 58: 
      if (this.jdField_a_of_type_Aefd == null) {
        this.jdField_a_of_type_Aefd = new aefd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aefd, paramBaseAdapter);
    case 57: 
      if (this.jdField_a_of_type_Adpz == null) {
        this.jdField_a_of_type_Adpz = new adpz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adpz, paramBaseAdapter);
    case 63: 
      if (this.jdField_a_of_type_Adub == null) {
        this.jdField_a_of_type_Adub = new adub(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adub, paramBaseAdapter);
    case 64: 
      if (this.jdField_a_of_type_Aquw == null) {
        this.jdField_a_of_type_Aquw = new aquw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aquw, paramBaseAdapter);
    case 67: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder = new QQStoryItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder, paramBaseAdapter);
    case 89: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder = new TribeShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder, paramBaseAdapter);
    case 77: 
      if (this.jdField_a_of_type_Aedx == null) {
        this.jdField_a_of_type_Aedx = new aedx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aedx, paramBaseAdapter);
    case 68: 
      if (this.jdField_a_of_type_Adxe == null) {
        this.jdField_a_of_type_Adxe = new adxe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adxe, paramBaseAdapter);
    case 71: 
      if (this.jdField_a_of_type_Aeee == null) {
        this.jdField_a_of_type_Aeee = new aeee(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeee, paramBaseAdapter);
    case 84: 
      if (this.jdField_a_of_type_Aeeg == null) {
        this.jdField_a_of_type_Aeeg = new aeeg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Aeeg, paramBaseAdapter);
    case 73: 
      if (this.jdField_a_of_type_Aeen == null) {
        this.jdField_a_of_type_Aeen = new aeen(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeen, paramBaseAdapter);
    case 78: 
      if (this.jdField_a_of_type_Adsy == null) {
        this.jdField_a_of_type_Adsy = new adsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adsy, paramBaseAdapter);
    case 75: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder = new ScribbleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder, paramBaseAdapter);
    case 80: 
      if (this.jdField_a_of_type_Aecy == null) {
        this.jdField_a_of_type_Aecy = new aecy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aecy, paramBaseAdapter);
    case 87: 
      if (this.jdField_a_of_type_Adxj == null) {
        this.jdField_a_of_type_Adxj = new adxj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adxj, paramBaseAdapter);
    case 85: 
      if (this.jdField_a_of_type_Aecq == null) {
        this.jdField_a_of_type_Aecq = new aecq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aecq, paramBaseAdapter);
    case 93: 
      if (this.jdField_a_of_type_Adpo == null) {
        this.jdField_a_of_type_Adpo = new adpo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_Adpo;
    case 102: 
      if (this.jdField_a_of_type_Adtk == null)
      {
        this.jdField_a_of_type_Adtk = new adtk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_Adtk);
      }
      return this.jdField_a_of_type_Adtk;
    case 101: 
      if (this.jdField_a_of_type_Aeax == null) {
        this.jdField_a_of_type_Aeax = new aeax(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Aeax;
    case 104: 
      if (this.jdField_a_of_type_Aqlq == null) {
        this.jdField_a_of_type_Aqlq = new aqlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aqlq, paramBaseAdapter);
    case 109: 
      if (this.jdField_a_of_type_Adkl == null) {
        this.jdField_a_of_type_Adkl = new adkl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adkl, paramBaseAdapter);
    case 110: 
      if (this.jdField_a_of_type_Aduc == null) {
        this.jdField_a_of_type_Aduc = new aduc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aduc, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Adne == null) {
      this.jdField_a_of_type_Adne = new adne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return a(this.jdField_a_of_type_Adne, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((acuz)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adte
 * JD-Core Version:    0.7.0.1
 */