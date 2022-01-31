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

public class adtg
{
  adkn jdField_a_of_type_Adkn;
  adkq jdField_a_of_type_Adkq;
  adkt jdField_a_of_type_Adkt;
  adlg jdField_a_of_type_Adlg;
  adli jdField_a_of_type_Adli;
  adlu jdField_a_of_type_Adlu;
  admc jdField_a_of_type_Admc;
  admj jdField_a_of_type_Admj;
  adml jdField_a_of_type_Adml;
  admo jdField_a_of_type_Admo;
  admz jdField_a_of_type_Admz;
  private adng jdField_a_of_type_Adng;
  private adnj jdField_a_of_type_Adnj;
  adnm jdField_a_of_type_Adnm;
  adns jdField_a_of_type_Adns;
  adnw jdField_a_of_type_Adnw;
  adof jdField_a_of_type_Adof;
  adoj jdField_a_of_type_Adoj;
  adon jdField_a_of_type_Adon;
  ador jdField_a_of_type_Ador;
  adox jdField_a_of_type_Adox;
  adpq jdField_a_of_type_Adpq;
  adqb jdField_a_of_type_Adqb;
  adqg jdField_a_of_type_Adqg;
  adqy jdField_a_of_type_Adqy;
  adta jdField_a_of_type_Adta;
  adtm jdField_a_of_type_Adtm;
  adtp jdField_a_of_type_Adtp;
  adtu jdField_a_of_type_Adtu;
  adtw jdField_a_of_type_Adtw;
  adud jdField_a_of_type_Adud;
  adue jdField_a_of_type_Adue;
  adug jdField_a_of_type_Adug;
  aduw jdField_a_of_type_Aduw;
  adva jdField_a_of_type_Adva;
  advf jdField_a_of_type_Advf;
  advh jdField_a_of_type_Advh;
  advk jdField_a_of_type_Advk;
  advn jdField_a_of_type_Advn;
  advr jdField_a_of_type_Advr;
  advu jdField_a_of_type_Advu;
  adwe jdField_a_of_type_Adwe;
  adwr jdField_a_of_type_Adwr;
  adwy jdField_a_of_type_Adwy;
  adxg jdField_a_of_type_Adxg;
  private adxl jdField_a_of_type_Adxl;
  adxv jdField_a_of_type_Adxv;
  adxx jdField_a_of_type_Adxx;
  adyc jdField_a_of_type_Adyc;
  adyh jdField_a_of_type_Adyh;
  adyt jdField_a_of_type_Adyt;
  adzc jdField_a_of_type_Adzc;
  adzh jdField_a_of_type_Adzh;
  adzs jdField_a_of_type_Adzs;
  aeaz jdField_a_of_type_Aeaz;
  aebc jdField_a_of_type_Aebc;
  aebz jdField_a_of_type_Aebz;
  aeci jdField_a_of_type_Aeci;
  aecn jdField_a_of_type_Aecn;
  aecs jdField_a_of_type_Aecs;
  aeda jdField_a_of_type_Aeda;
  aedd jdField_a_of_type_Aedd;
  aedt jdField_a_of_type_Aedt;
  aedu jdField_a_of_type_Aedu;
  aedx jdField_a_of_type_Aedx;
  aedz jdField_a_of_type_Aedz;
  aeeg jdField_a_of_type_Aeeg;
  aeei jdField_a_of_type_Aeei;
  aeep jdField_a_of_type_Aeep;
  aeer jdField_a_of_type_Aeer;
  aeet jdField_a_of_type_Aeet;
  aeff jdField_a_of_type_Aeff;
  aefi jdField_a_of_type_Aefi;
  protected aggd a;
  amok jdField_a_of_type_Amok;
  protected Context a;
  private aqlo jdField_a_of_type_Aqlo;
  aquu jdField_a_of_type_Aquu;
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
  private Set<acvd> jdField_a_of_type_JavaUtilSet;
  ydx jdField_a_of_type_Ydx;
  yeb jdField_a_of_type_Yeb;
  yeh jdField_a_of_type_Yeh;
  adnw jdField_b_of_type_Adnw;
  adwy jdField_b_of_type_Adwy;
  adwy c;
  
  public adtg(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
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
            if (ajyk.a(paramChatMessage)) {
              return 42;
            }
            if (ajwd.a(paramChatMessage)) {
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
            return aoyl.a(paramQQAppInterface, paramChatMessage);
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
            return aoyl.a(paramQQAppInterface, paramChatMessage);
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
            if (ahix.a((MessageForQQWalletMsg)paramChatMessage)) {
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
      if ((paramQQAppInterface.interactType == 126) && (!adwl.a(paramQQAppInterface.minVersion))) {
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
      if (aqxh.a(paramQQAppInterface).a()) {
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
  
  protected acvd a(acvd paramacvd, BaseAdapter paramBaseAdapter)
  {
    if (((paramacvd instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof acut)))
    {
      paramBaseAdapter = (acut)paramBaseAdapter;
      ((BaseBubbleBuilder)paramacvd).a(paramBaseAdapter.a);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramacvd);
    return paramacvd;
  }
  
  public acvd a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
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
      if (this.jdField_a_of_type_Aebz == null) {
        this.jdField_a_of_type_Aebz = new aebz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aebz, paramBaseAdapter);
    case 61: 
      if (this.jdField_a_of_type_Adwy == null) {
        this.jdField_a_of_type_Adwy = aoyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 61, paramChatMessage);
      }
      return a(this.jdField_a_of_type_Adwy, paramBaseAdapter);
    case 65: 
      if (this.c == null) {
        this.c = aoyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 65, paramChatMessage);
      }
      return a(this.c, paramBaseAdapter);
    case 3: 
      if (this.jdField_b_of_type_Adwy == null) {
        this.jdField_b_of_type_Adwy = aoyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 3, paramChatMessage);
      }
      return a(this.jdField_b_of_type_Adwy, paramBaseAdapter);
    case 1: 
      if (this.jdField_a_of_type_Advu == null) {
        this.jdField_a_of_type_Advu = new advu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Advu, paramBaseAdapter);
    case 24: 
      if (this.jdField_a_of_type_Adlg == null) {
        this.jdField_a_of_type_Adlg = new adlg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adlg, paramBaseAdapter);
    case 2: 
      if (this.jdField_a_of_type_Adwr == null) {
        this.jdField_a_of_type_Adwr = new adwr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Adwr, paramBaseAdapter);
    case 33: 
      if (this.jdField_a_of_type_Yeh == null) {
        this.jdField_a_of_type_Yeh = new yeh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePttItemBuilder");
      }
      return a(this.jdField_a_of_type_Yeh, paramBaseAdapter);
    case 15: 
      if (this.jdField_a_of_type_Adqy == null) {
        this.jdField_a_of_type_Adqy = new adqy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adqy, paramBaseAdapter);
    case 72: 
      if (this.jdField_a_of_type_Aeet == null) {
        this.jdField_a_of_type_Aeet = new aeet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeet, paramBaseAdapter);
    case 6: 
      if (this.jdField_a_of_type_Advk == null) {
        this.jdField_a_of_type_Advk = new advk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advk, paramBaseAdapter);
    case 7: 
      if (this.jdField_a_of_type_Advh == null) {
        this.jdField_a_of_type_Advh = new advh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advh, paramBaseAdapter);
    case 8: 
      if (this.jdField_a_of_type_Advn == null) {
        this.jdField_a_of_type_Advn = new advn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advn, paramBaseAdapter);
    case 5: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder = new StructingMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, paramBaseAdapter);
    case 10: 
      if (this.jdField_a_of_type_Adtp == null) {
        this.jdField_a_of_type_Adtp = new adtp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adtp, paramBaseAdapter);
    case 11: 
      if (this.jdField_a_of_type_Aefi == null) {
        this.jdField_a_of_type_Aefi = new aefi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aefi, paramBaseAdapter);
    case 113: 
      if (this.jdField_a_of_type_Adtu == null) {
        this.jdField_a_of_type_Adtu = new adtu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adtu, paramBaseAdapter);
    case 13: 
      if (this.jdField_a_of_type_Adyt == null) {
        this.jdField_a_of_type_Adyt = new adyt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adyt, paramBaseAdapter);
    case 9: 
      if (this.jdField_a_of_type_Aeci == null) {
        this.jdField_a_of_type_Aeci = new aeci(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeci, paramBaseAdapter);
    case 12: 
      if (this.jdField_a_of_type_Adug == null) {
        this.jdField_a_of_type_Adug = new adug(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adug, paramBaseAdapter);
    case 16: 
      if (this.jdField_a_of_type_Adkq == null) {
        this.jdField_a_of_type_Adkq = new adkq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adkq, paramBaseAdapter);
    case 22: 
      if (this.jdField_a_of_type_Adox == null) {
        this.jdField_a_of_type_Adox = new adox(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adox, paramBaseAdapter);
    case 23: 
      if (this.jdField_a_of_type_Advf == null) {
        this.jdField_a_of_type_Advf = new advf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advf, paramBaseAdapter);
    case 17: 
      if (this.jdField_a_of_type_Adtw == null) {
        this.jdField_a_of_type_Adtw = new adtw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adtw, paramBaseAdapter);
    case 18: 
      if (this.jdField_a_of_type_Adva == null) {
        this.jdField_a_of_type_Adva = new adva(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adva, paramBaseAdapter);
    case 21: 
      if (this.jdField_a_of_type_Adyc == null) {
        this.jdField_a_of_type_Adyc = new adyc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: qzoneFeedItemBuilder = " + this.jdField_a_of_type_Adyc);
      }
      return a(this.jdField_a_of_type_Adyc, paramBaseAdapter);
    case 108: 
      if (this.jdField_a_of_type_Adnj == null) {
        this.jdField_a_of_type_Adnj = new adnj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: mBirthDayNoticeItemBuilder = " + this.jdField_a_of_type_Adnj);
      }
      return a(this.jdField_a_of_type_Adnj, paramBaseAdapter);
    case 79: 
      if (this.jdField_a_of_type_Advr == null) {
        this.jdField_a_of_type_Advr = new advr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Advr, paramBaseAdapter);
    case 86: 
      if (this.jdField_a_of_type_Aduw == null) {
        this.jdField_a_of_type_Aduw = new aduw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aduw, paramBaseAdapter);
    case 94: 
      if (this.jdField_a_of_type_Adns == null) {
        this.jdField_a_of_type_Adns = new adns(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adns, paramBaseAdapter);
    case 91: 
      if (this.jdField_a_of_type_Adnw == null) {
        this.jdField_a_of_type_Adnw = new adnw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adnw, paramBaseAdapter);
    case 92: 
      if (this.jdField_b_of_type_Adnw == null) {
        this.jdField_b_of_type_Adnw = new adnw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_b_of_type_Adnw, paramBaseAdapter);
    case 97: 
      if (this.jdField_a_of_type_Amok == null) {
        this.jdField_a_of_type_Amok = new amok(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Amok, paramBaseAdapter);
    case 26: 
      if (this.jdField_a_of_type_Adzc == null) {
        this.jdField_a_of_type_Adzc = new adzc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adzc, paramBaseAdapter);
    case 62: 
      paramChatMessage = (MessageForPoke)paramChatMessage;
      if (this.jdField_a_of_type_Adqg == null) {
        this.jdField_a_of_type_Adqg = new adqg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adqg, paramBaseAdapter);
    case 96: 
      paramChatMessage = (MessageForPokeEmo)paramChatMessage;
      if (this.jdField_a_of_type_Adwe == null) {
        this.jdField_a_of_type_Adwe = new adwe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adwe, paramBaseAdapter);
    case 27: 
      if (this.jdField_a_of_type_Aeer == null) {
        this.jdField_a_of_type_Aeer = new aeer(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aeer, paramBaseAdapter);
    case 70: 
      if (this.jdField_a_of_type_Aedx == null) {
        this.jdField_a_of_type_Aedx = new aedx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aedx, paramBaseAdapter);
    case 28: 
      if (this.jdField_a_of_type_Aebc == null) {
        this.jdField_a_of_type_Aebc = new aebc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aebc, paramBaseAdapter);
    case 29: 
      if (this.jdField_a_of_type_Adzh == null) {
        this.jdField_a_of_type_Adzh = new adzh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adzh, paramBaseAdapter);
    case 38: 
    case 40: 
    case 41: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder = new ShortVideoRealItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder, paramBaseAdapter);
    case 46: 
      if (this.jdField_a_of_type_Adzs == null) {
        this.jdField_a_of_type_Adzs = new adzs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adzs, paramBaseAdapter);
    case 103: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder = new LightVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder, paramBaseAdapter);
    case 31: 
      if (this.jdField_a_of_type_Aecn == null) {
        this.jdField_a_of_type_Aecn = new aecn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aecn, paramBaseAdapter);
    case 32: 
      if (this.jdField_a_of_type_Adxv == null) {
        this.jdField_a_of_type_Adxv = new adxv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adxv, paramBaseAdapter);
    case 90: 
      if (this.jdField_a_of_type_Adxx == null) {
        this.jdField_a_of_type_Adxx = new adxx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adxx, paramBaseAdapter);
    case 44: 
      if (this.jdField_a_of_type_Aedd == null) {
        this.jdField_a_of_type_Aedd = new aedd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aedd, paramBaseAdapter);
    case 48: 
      if (this.jdField_a_of_type_Aedu == null) {
        this.jdField_a_of_type_Aedu = new aedu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Aedu, paramBaseAdapter);
    case 49: 
      if (this.jdField_a_of_type_Aedt == null) {
        this.jdField_a_of_type_Aedt = new aedt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Aedt, paramBaseAdapter);
    case 35: 
      if (this.jdField_a_of_type_Yeb == null) {
        this.jdField_a_of_type_Yeb = new yeb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Yeb, paramBaseAdapter);
    case 45: 
      if (this.jdField_a_of_type_Ydx == null) {
        this.jdField_a_of_type_Ydx = new ydx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Ydx, paramBaseAdapter);
    case 34: 
      if (this.jdField_a_of_type_Adon == null) {
        this.jdField_a_of_type_Adon = new adon(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceSingleItemBuilder");
      }
      return a(this.jdField_a_of_type_Adon, paramBaseAdapter);
    case 36: 
      if (this.jdField_a_of_type_Adoj == null) {
        this.jdField_a_of_type_Adoj = new adoj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePicItemBuilder");
      }
      return a(this.jdField_a_of_type_Adoj, paramBaseAdapter);
    case 37: 
      if (this.jdField_a_of_type_Adof == null) {
        this.jdField_a_of_type_Adof = new adof(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceFileItemBuilder");
      }
      return a(this.jdField_a_of_type_Adof, paramBaseAdapter);
    case 39: 
      if (this.jdField_a_of_type_Ador == null) {
        this.jdField_a_of_type_Ador = new ador(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Ador, paramBaseAdapter);
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
      if (this.jdField_a_of_type_Adkt == null) {
        this.jdField_a_of_type_Adkt = new adkt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adkt, paramBaseAdapter);
    case 100: 
      if (this.jdField_a_of_type_Adnm == null) {
        this.jdField_a_of_type_Adnm = new adnm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adnm, paramBaseAdapter);
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
        if (this.jdField_a_of_type_Adml == null) {
          this.jdField_a_of_type_Adml = new adml(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        }
        return a(this.jdField_a_of_type_Adml, paramBaseAdapter);
      }
      if ((i == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
      {
        if (this.jdField_a_of_type_Admc == null) {
          this.jdField_a_of_type_Admc = new admc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        }
        return a(this.jdField_a_of_type_Admc, paramBaseAdapter);
      }
      if (this.jdField_a_of_type_Adlu == null) {
        this.jdField_a_of_type_Adlu = new adlu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adlu, paramBaseAdapter);
    case 81: 
      if (this.jdField_a_of_type_Admo == null) {
        this.jdField_a_of_type_Admo = new admo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admo, paramBaseAdapter);
    case 112: 
      if (this.jdField_a_of_type_Admj == null) {
        this.jdField_a_of_type_Admj = new admj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admj, paramBaseAdapter);
    case 76: 
      if (this.jdField_a_of_type_Admz == null) {
        this.jdField_a_of_type_Admz = new admz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admz, paramBaseAdapter);
    case 50: 
      if (this.jdField_a_of_type_Adyh == null) {
        this.jdField_a_of_type_Adyh = new adyh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adyh, paramBaseAdapter);
    case 52: 
      if (this.jdField_a_of_type_Adli == null) {
        this.jdField_a_of_type_Adli = new adli(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adli, paramBaseAdapter);
    case 58: 
      if (this.jdField_a_of_type_Aeff == null) {
        this.jdField_a_of_type_Aeff = new aeff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeff, paramBaseAdapter);
    case 57: 
      if (this.jdField_a_of_type_Adqb == null) {
        this.jdField_a_of_type_Adqb = new adqb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adqb, paramBaseAdapter);
    case 63: 
      if (this.jdField_a_of_type_Adud == null) {
        this.jdField_a_of_type_Adud = new adud(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adud, paramBaseAdapter);
    case 64: 
      if (this.jdField_a_of_type_Aquu == null) {
        this.jdField_a_of_type_Aquu = new aquu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aquu, paramBaseAdapter);
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
      if (this.jdField_a_of_type_Aedz == null) {
        this.jdField_a_of_type_Aedz = new aedz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aedz, paramBaseAdapter);
    case 68: 
      if (this.jdField_a_of_type_Adxg == null) {
        this.jdField_a_of_type_Adxg = new adxg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adxg, paramBaseAdapter);
    case 71: 
      if (this.jdField_a_of_type_Aeeg == null) {
        this.jdField_a_of_type_Aeeg = new aeeg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeeg, paramBaseAdapter);
    case 84: 
      if (this.jdField_a_of_type_Aeei == null) {
        this.jdField_a_of_type_Aeei = new aeei(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Aeei, paramBaseAdapter);
    case 73: 
      if (this.jdField_a_of_type_Aeep == null) {
        this.jdField_a_of_type_Aeep = new aeep(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeep, paramBaseAdapter);
    case 78: 
      if (this.jdField_a_of_type_Adta == null) {
        this.jdField_a_of_type_Adta = new adta(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adta, paramBaseAdapter);
    case 75: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder = new ScribbleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder, paramBaseAdapter);
    case 80: 
      if (this.jdField_a_of_type_Aeda == null) {
        this.jdField_a_of_type_Aeda = new aeda(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aeda, paramBaseAdapter);
    case 87: 
      if (this.jdField_a_of_type_Adxl == null) {
        this.jdField_a_of_type_Adxl = new adxl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adxl, paramBaseAdapter);
    case 85: 
      if (this.jdField_a_of_type_Aecs == null) {
        this.jdField_a_of_type_Aecs = new aecs(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aecs, paramBaseAdapter);
    case 93: 
      if (this.jdField_a_of_type_Adpq == null) {
        this.jdField_a_of_type_Adpq = new adpq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_Adpq;
    case 102: 
      if (this.jdField_a_of_type_Adtm == null)
      {
        this.jdField_a_of_type_Adtm = new adtm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_Adtm);
      }
      return this.jdField_a_of_type_Adtm;
    case 101: 
      if (this.jdField_a_of_type_Aeaz == null) {
        this.jdField_a_of_type_Aeaz = new aeaz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Aeaz;
    case 104: 
      if (this.jdField_a_of_type_Aqlo == null) {
        this.jdField_a_of_type_Aqlo = new aqlo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aqlo, paramBaseAdapter);
    case 109: 
      if (this.jdField_a_of_type_Adkn == null) {
        this.jdField_a_of_type_Adkn = new adkn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adkn, paramBaseAdapter);
    case 110: 
      if (this.jdField_a_of_type_Adue == null) {
        this.jdField_a_of_type_Adue = new adue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adue, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Adng == null) {
      this.jdField_a_of_type_Adng = new adng(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return a(this.jdField_a_of_type_Adng, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((acvd)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtg
 * JD-Core Version:    0.7.0.1
 */