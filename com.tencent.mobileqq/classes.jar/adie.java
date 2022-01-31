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

public class adie
{
  aczl jdField_a_of_type_Aczl;
  aczo jdField_a_of_type_Aczo;
  aczr jdField_a_of_type_Aczr;
  adae jdField_a_of_type_Adae;
  adag jdField_a_of_type_Adag;
  adas jdField_a_of_type_Adas;
  adba jdField_a_of_type_Adba;
  adbh jdField_a_of_type_Adbh;
  adbj jdField_a_of_type_Adbj;
  adbm jdField_a_of_type_Adbm;
  adbx jdField_a_of_type_Adbx;
  private adce jdField_a_of_type_Adce;
  private adch jdField_a_of_type_Adch;
  adck jdField_a_of_type_Adck;
  adcq jdField_a_of_type_Adcq;
  adcu jdField_a_of_type_Adcu;
  addd jdField_a_of_type_Addd;
  addh jdField_a_of_type_Addh;
  addl jdField_a_of_type_Addl;
  addp jdField_a_of_type_Addp;
  addv jdField_a_of_type_Addv;
  adeo jdField_a_of_type_Adeo;
  adez jdField_a_of_type_Adez;
  adfe jdField_a_of_type_Adfe;
  adfw jdField_a_of_type_Adfw;
  adhy jdField_a_of_type_Adhy;
  adil jdField_a_of_type_Adil;
  adin jdField_a_of_type_Adin;
  adis jdField_a_of_type_Adis;
  adiu jdField_a_of_type_Adiu;
  adjb jdField_a_of_type_Adjb;
  adjc jdField_a_of_type_Adjc;
  adje jdField_a_of_type_Adje;
  adjv jdField_a_of_type_Adjv;
  adjz jdField_a_of_type_Adjz;
  adke jdField_a_of_type_Adke;
  adkg jdField_a_of_type_Adkg;
  adkj jdField_a_of_type_Adkj;
  adkm jdField_a_of_type_Adkm;
  adkq jdField_a_of_type_Adkq;
  adkt jdField_a_of_type_Adkt;
  adle jdField_a_of_type_Adle;
  adlr jdField_a_of_type_Adlr;
  adlz jdField_a_of_type_Adlz;
  admh jdField_a_of_type_Admh;
  private admm jdField_a_of_type_Admm;
  admw jdField_a_of_type_Admw;
  admy jdField_a_of_type_Admy;
  adnd jdField_a_of_type_Adnd;
  adni jdField_a_of_type_Adni;
  adnu jdField_a_of_type_Adnu;
  adod jdField_a_of_type_Adod;
  adoi jdField_a_of_type_Adoi;
  adot jdField_a_of_type_Adot;
  adqa jdField_a_of_type_Adqa;
  adqd jdField_a_of_type_Adqd;
  adra jdField_a_of_type_Adra;
  adrj jdField_a_of_type_Adrj;
  adro jdField_a_of_type_Adro;
  adrt jdField_a_of_type_Adrt;
  adsb jdField_a_of_type_Adsb;
  adse jdField_a_of_type_Adse;
  adsu jdField_a_of_type_Adsu;
  adsv jdField_a_of_type_Adsv;
  adsy jdField_a_of_type_Adsy;
  adta jdField_a_of_type_Adta;
  adth jdField_a_of_type_Adth;
  adtj jdField_a_of_type_Adtj;
  adtq jdField_a_of_type_Adtq;
  adts jdField_a_of_type_Adts;
  adtu jdField_a_of_type_Adtu;
  adug jdField_a_of_type_Adug;
  aduj jdField_a_of_type_Aduj;
  protected afue a;
  alyu jdField_a_of_type_Alyu;
  protected Context a;
  private aprz jdField_a_of_type_Aprz;
  aqas jdField_a_of_type_Aqas;
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
  private Set<ackk> jdField_a_of_type_JavaUtilSet;
  xuu jdField_a_of_type_Xuu;
  xuz jdField_a_of_type_Xuz;
  xve jdField_a_of_type_Xve;
  adcu jdField_b_of_type_Adcu;
  adlz jdField_b_of_type_Adlz;
  adlz c;
  
  public adie(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public int a(ChatMessage paramChatMessage)
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
                      break label1344;
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
            if (ajke.a(paramChatMessage)) {
              return 42;
            }
            if (ajhz.a(paramChatMessage)) {
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
            return aohr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
            paramChatMessage = ((MessageForPubAccount)paramChatMessage).mPAMessage;
            if ((paramChatMessage != null) && (paramChatMessage.items != null) && (paramChatMessage.items.size() != 0))
            {
              if (((PAMessage.Item)paramChatMessage.items.get(0)).cover != null)
              {
                if (paramChatMessage.items.size() == 1) {
                  return 6;
                }
                if (paramChatMessage.items.size() < 2) {
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
            return aohr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
            if (agwi.a((MessageForQQWalletMsg)paramChatMessage)) {
              return 32;
            }
            return 90;
          }
          if ((paramChatMessage instanceof MessageForTroopFee)) {
            return 44;
          }
          if ((paramChatMessage instanceof MessageForDeviceFile))
          {
            paramChatMessage = (MessageForDeviceFile)paramChatMessage;
            if (paramChatMessage.nFileMsgType == 2) {
              return 36;
            }
            if (paramChatMessage.nFileMsgType != 1) {
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
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
      localConfig.fromString(paramChatMessage.ark_app_message.config);
      if ((localConfig.type != null) && (localConfig.type.equals("multiple"))) {
        return 112;
      }
      if ((localConfig.type != null) && (localConfig.type.equals("card"))) {
        return 81;
      }
      return 47;
    }
    if ((paramChatMessage instanceof MessageForArkBabyqReply))
    {
      paramChatMessage = (MessageForArkBabyqReply)paramChatMessage;
      if ((paramChatMessage.mArkBabyqReplyCardList == null) || (paramChatMessage.mArkBabyqReplyCardList.size() <= 0)) {
        return 83;
      }
      return 82;
    }
    if ((paramChatMessage instanceof MessageForArkFlashChat)) {
      return 76;
    }
    if ((paramChatMessage instanceof MessageForApollo))
    {
      if (ApolloGameUtil.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == ApolloGameUtil.c) {
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
      if (paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
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
      paramChatMessage = (MessageForPoke)paramChatMessage;
      if ((paramChatMessage.interactType == 126) && (!adll.a(paramChatMessage.minVersion))) {
        return 0;
      }
      return 62;
    }
    if ((paramChatMessage instanceof MessageForPokeEmo)) {
      return 96;
    }
    if ((paramChatMessage instanceof MessageForUniteGrayTip))
    {
      paramChatMessage = ((MessageForUniteGrayTip)paramChatMessage).tipParam;
      if ((paramChatMessage != null) && (paramChatMessage.b == 655384)) {
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
      if (aqdf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
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
    label1344:
    return 0;
  }
  
  protected ackk a(ackk paramackk, BaseAdapter paramBaseAdapter)
  {
    if (((paramackk instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof acka)))
    {
      paramBaseAdapter = (acka)paramBaseAdapter;
      ((BaseBubbleBuilder)paramackk).a(paramBaseAdapter.a);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramackk);
    return paramackk;
  }
  
  public ackk a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: message = " + paramChatMessage);
    }
    switch (a(paramChatMessage))
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
      if (this.jdField_a_of_type_Adra == null) {
        this.jdField_a_of_type_Adra = new adra(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adra, paramBaseAdapter);
    case 61: 
      if (this.jdField_a_of_type_Adlz == null) {
        this.jdField_a_of_type_Adlz = aohr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 61, paramChatMessage);
      }
      return a(this.jdField_a_of_type_Adlz, paramBaseAdapter);
    case 65: 
      if (this.c == null) {
        this.c = aohr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 65, paramChatMessage);
      }
      return a(this.c, paramBaseAdapter);
    case 3: 
      if (this.jdField_b_of_type_Adlz == null) {
        this.jdField_b_of_type_Adlz = aohr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, 3, paramChatMessage);
      }
      return a(this.jdField_b_of_type_Adlz, paramBaseAdapter);
    case 1: 
      if (this.jdField_a_of_type_Adkt == null) {
        this.jdField_a_of_type_Adkt = new adkt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adkt, paramBaseAdapter);
    case 24: 
      if (this.jdField_a_of_type_Adae == null) {
        this.jdField_a_of_type_Adae = new adae(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adae, paramBaseAdapter);
    case 2: 
      if (this.jdField_a_of_type_Adlr == null) {
        this.jdField_a_of_type_Adlr = new adlr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Adlr, paramBaseAdapter);
    case 33: 
      if (this.jdField_a_of_type_Xve == null) {
        this.jdField_a_of_type_Xve = new xve(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePttItemBuilder");
      }
      return a(this.jdField_a_of_type_Xve, paramBaseAdapter);
    case 15: 
      if (this.jdField_a_of_type_Adfw == null) {
        this.jdField_a_of_type_Adfw = new adfw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adfw, paramBaseAdapter);
    case 72: 
      if (this.jdField_a_of_type_Adtu == null) {
        this.jdField_a_of_type_Adtu = new adtu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adtu, paramBaseAdapter);
    case 6: 
      if (this.jdField_a_of_type_Adkj == null) {
        this.jdField_a_of_type_Adkj = new adkj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adkj, paramBaseAdapter);
    case 7: 
      if (this.jdField_a_of_type_Adkg == null) {
        this.jdField_a_of_type_Adkg = new adkg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adkg, paramBaseAdapter);
    case 8: 
      if (this.jdField_a_of_type_Adkm == null) {
        this.jdField_a_of_type_Adkm = new adkm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adkm, paramBaseAdapter);
    case 5: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder = new StructingMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, paramBaseAdapter);
    case 10: 
      if (this.jdField_a_of_type_Adin == null) {
        this.jdField_a_of_type_Adin = new adin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adin, paramBaseAdapter);
    case 11: 
      if (this.jdField_a_of_type_Aduj == null) {
        this.jdField_a_of_type_Aduj = new aduj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aduj, paramBaseAdapter);
    case 113: 
      if (this.jdField_a_of_type_Adis == null) {
        this.jdField_a_of_type_Adis = new adis(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adis, paramBaseAdapter);
    case 13: 
      if (this.jdField_a_of_type_Adnu == null) {
        this.jdField_a_of_type_Adnu = new adnu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adnu, paramBaseAdapter);
    case 9: 
      if (this.jdField_a_of_type_Adrj == null) {
        this.jdField_a_of_type_Adrj = new adrj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adrj, paramBaseAdapter);
    case 12: 
      if (this.jdField_a_of_type_Adje == null) {
        this.jdField_a_of_type_Adje = new adje(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adje, paramBaseAdapter);
    case 16: 
      if (this.jdField_a_of_type_Aczo == null) {
        this.jdField_a_of_type_Aczo = new aczo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aczo, paramBaseAdapter);
    case 22: 
      if (this.jdField_a_of_type_Addv == null) {
        this.jdField_a_of_type_Addv = new addv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Addv, paramBaseAdapter);
    case 23: 
      if (this.jdField_a_of_type_Adke == null) {
        this.jdField_a_of_type_Adke = new adke(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adke, paramBaseAdapter);
    case 17: 
      if (this.jdField_a_of_type_Adiu == null) {
        this.jdField_a_of_type_Adiu = new adiu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adiu, paramBaseAdapter);
    case 18: 
      if (this.jdField_a_of_type_Adjz == null) {
        this.jdField_a_of_type_Adjz = new adjz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adjz, paramBaseAdapter);
    case 21: 
      if (this.jdField_a_of_type_Adnd == null) {
        this.jdField_a_of_type_Adnd = new adnd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: qzoneFeedItemBuilder = " + this.jdField_a_of_type_Adnd);
      }
      return a(this.jdField_a_of_type_Adnd, paramBaseAdapter);
    case 108: 
      if (this.jdField_a_of_type_Adch == null) {
        this.jdField_a_of_type_Adch = new adch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: mBirthDayNoticeItemBuilder = " + this.jdField_a_of_type_Adch);
      }
      return a(this.jdField_a_of_type_Adch, paramBaseAdapter);
    case 79: 
      if (this.jdField_a_of_type_Adkq == null) {
        this.jdField_a_of_type_Adkq = new adkq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adkq, paramBaseAdapter);
    case 86: 
      if (this.jdField_a_of_type_Adjv == null) {
        this.jdField_a_of_type_Adjv = new adjv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adjv, paramBaseAdapter);
    case 94: 
      if (this.jdField_a_of_type_Adcq == null) {
        this.jdField_a_of_type_Adcq = new adcq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adcq, paramBaseAdapter);
    case 91: 
      if (this.jdField_a_of_type_Adcu == null) {
        this.jdField_a_of_type_Adcu = new adcu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adcu, paramBaseAdapter);
    case 92: 
      if (this.jdField_b_of_type_Adcu == null) {
        this.jdField_b_of_type_Adcu = new adcu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_b_of_type_Adcu, paramBaseAdapter);
    case 97: 
      if (this.jdField_a_of_type_Alyu == null) {
        this.jdField_a_of_type_Alyu = new alyu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Alyu, paramBaseAdapter);
    case 26: 
      if (this.jdField_a_of_type_Adod == null) {
        this.jdField_a_of_type_Adod = new adod(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adod, paramBaseAdapter);
    case 62: 
      paramChatMessage = (MessageForPoke)paramChatMessage;
      if (this.jdField_a_of_type_Adfe == null) {
        this.jdField_a_of_type_Adfe = new adfe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adfe, paramBaseAdapter);
    case 96: 
      paramChatMessage = (MessageForPokeEmo)paramChatMessage;
      if (this.jdField_a_of_type_Adle == null) {
        this.jdField_a_of_type_Adle = new adle(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adle, paramBaseAdapter);
    case 27: 
      if (this.jdField_a_of_type_Adts == null) {
        this.jdField_a_of_type_Adts = new adts(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adts, paramBaseAdapter);
    case 70: 
      if (this.jdField_a_of_type_Adsy == null) {
        this.jdField_a_of_type_Adsy = new adsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adsy, paramBaseAdapter);
    case 28: 
      if (this.jdField_a_of_type_Adqd == null) {
        this.jdField_a_of_type_Adqd = new adqd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adqd, paramBaseAdapter);
    case 29: 
      if (this.jdField_a_of_type_Adoi == null) {
        this.jdField_a_of_type_Adoi = new adoi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adoi, paramBaseAdapter);
    case 38: 
    case 40: 
    case 41: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder = new ShortVideoRealItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder, paramBaseAdapter);
    case 46: 
      if (this.jdField_a_of_type_Adot == null) {
        this.jdField_a_of_type_Adot = new adot(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adot, paramBaseAdapter);
    case 103: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder = new LightVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder, paramBaseAdapter);
    case 31: 
      if (this.jdField_a_of_type_Adro == null) {
        this.jdField_a_of_type_Adro = new adro(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adro, paramBaseAdapter);
    case 32: 
      if (this.jdField_a_of_type_Admw == null) {
        this.jdField_a_of_type_Admw = new admw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admw, paramBaseAdapter);
    case 90: 
      if (this.jdField_a_of_type_Admy == null) {
        this.jdField_a_of_type_Admy = new admy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admy, paramBaseAdapter);
    case 44: 
      if (this.jdField_a_of_type_Adse == null) {
        this.jdField_a_of_type_Adse = new adse(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adse, paramBaseAdapter);
    case 48: 
      if (this.jdField_a_of_type_Adsv == null) {
        this.jdField_a_of_type_Adsv = new adsv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Adsv, paramBaseAdapter);
    case 49: 
      if (this.jdField_a_of_type_Adsu == null) {
        this.jdField_a_of_type_Adsu = new adsu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Adsu, paramBaseAdapter);
    case 35: 
      if (this.jdField_a_of_type_Xuz == null) {
        this.jdField_a_of_type_Xuz = new xuz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Xuz, paramBaseAdapter);
    case 45: 
      if (this.jdField_a_of_type_Xuu == null) {
        this.jdField_a_of_type_Xuu = new xuu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Xuu, paramBaseAdapter);
    case 34: 
      if (this.jdField_a_of_type_Addl == null) {
        this.jdField_a_of_type_Addl = new addl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceSingleItemBuilder");
      }
      return a(this.jdField_a_of_type_Addl, paramBaseAdapter);
    case 36: 
      if (this.jdField_a_of_type_Addh == null) {
        this.jdField_a_of_type_Addh = new addh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePicItemBuilder");
      }
      return a(this.jdField_a_of_type_Addh, paramBaseAdapter);
    case 37: 
      if (this.jdField_a_of_type_Addd == null) {
        this.jdField_a_of_type_Addd = new addd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceFileItemBuilder");
      }
      return a(this.jdField_a_of_type_Addd, paramBaseAdapter);
    case 39: 
      if (this.jdField_a_of_type_Addp == null) {
        this.jdField_a_of_type_Addp = new addp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Addp, paramBaseAdapter);
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
      if (this.jdField_a_of_type_Aczr == null) {
        this.jdField_a_of_type_Aczr = new aczr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aczr, paramBaseAdapter);
    case 100: 
      if (this.jdField_a_of_type_Adck == null) {
        this.jdField_a_of_type_Adck = new adck(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adck, paramBaseAdapter);
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
        if (this.jdField_a_of_type_Adbj == null) {
          this.jdField_a_of_type_Adbj = new adbj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        }
        return a(this.jdField_a_of_type_Adbj, paramBaseAdapter);
      }
      if ((i == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
      {
        if (this.jdField_a_of_type_Adba == null) {
          this.jdField_a_of_type_Adba = new adba(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        }
        return a(this.jdField_a_of_type_Adba, paramBaseAdapter);
      }
      if (this.jdField_a_of_type_Adas == null) {
        this.jdField_a_of_type_Adas = new adas(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adas, paramBaseAdapter);
    case 81: 
      if (this.jdField_a_of_type_Adbm == null) {
        this.jdField_a_of_type_Adbm = new adbm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adbm, paramBaseAdapter);
    case 112: 
      if (this.jdField_a_of_type_Adbh == null) {
        this.jdField_a_of_type_Adbh = new adbh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adbh, paramBaseAdapter);
    case 76: 
      if (this.jdField_a_of_type_Adbx == null) {
        this.jdField_a_of_type_Adbx = new adbx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adbx, paramBaseAdapter);
    case 50: 
      if (this.jdField_a_of_type_Adni == null) {
        this.jdField_a_of_type_Adni = new adni(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adni, paramBaseAdapter);
    case 52: 
      if (this.jdField_a_of_type_Adag == null) {
        this.jdField_a_of_type_Adag = new adag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adag, paramBaseAdapter);
    case 58: 
      if (this.jdField_a_of_type_Adug == null) {
        this.jdField_a_of_type_Adug = new adug(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adug, paramBaseAdapter);
    case 57: 
      if (this.jdField_a_of_type_Adez == null) {
        this.jdField_a_of_type_Adez = new adez(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adez, paramBaseAdapter);
    case 63: 
      if (this.jdField_a_of_type_Adjb == null) {
        this.jdField_a_of_type_Adjb = new adjb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adjb, paramBaseAdapter);
    case 64: 
      if (this.jdField_a_of_type_Aqas == null) {
        this.jdField_a_of_type_Aqas = new aqas(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aqas, paramBaseAdapter);
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
      if (this.jdField_a_of_type_Adta == null) {
        this.jdField_a_of_type_Adta = new adta(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adta, paramBaseAdapter);
    case 68: 
      if (this.jdField_a_of_type_Admh == null) {
        this.jdField_a_of_type_Admh = new admh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Admh, paramBaseAdapter);
    case 71: 
      if (this.jdField_a_of_type_Adth == null) {
        this.jdField_a_of_type_Adth = new adth(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adth, paramBaseAdapter);
    case 84: 
      if (this.jdField_a_of_type_Adtj == null) {
        this.jdField_a_of_type_Adtj = new adtj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, (aejb)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_Adtj, paramBaseAdapter);
    case 73: 
      if (this.jdField_a_of_type_Adtq == null) {
        this.jdField_a_of_type_Adtq = new adtq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adtq, paramBaseAdapter);
    case 78: 
      if (this.jdField_a_of_type_Adhy == null) {
        this.jdField_a_of_type_Adhy = new adhy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adhy, paramBaseAdapter);
    case 75: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder = new ScribbleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder, paramBaseAdapter);
    case 80: 
      if (this.jdField_a_of_type_Adsb == null) {
        this.jdField_a_of_type_Adsb = new adsb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Adsb, paramBaseAdapter);
    case 87: 
      if (this.jdField_a_of_type_Admm == null) {
        this.jdField_a_of_type_Admm = new admm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Admm, paramBaseAdapter);
    case 85: 
      if (this.jdField_a_of_type_Adrt == null) {
        this.jdField_a_of_type_Adrt = new adrt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adrt, paramBaseAdapter);
    case 93: 
      if (this.jdField_a_of_type_Adeo == null) {
        this.jdField_a_of_type_Adeo = new adeo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_Adeo;
    case 102: 
      if (this.jdField_a_of_type_Adil == null) {
        this.jdField_a_of_type_Adil = new adil(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_Adil;
    case 101: 
      if (this.jdField_a_of_type_Adqa == null) {
        this.jdField_a_of_type_Adqa = new adqa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_Adqa;
    case 104: 
      if (this.jdField_a_of_type_Aprz == null) {
        this.jdField_a_of_type_Aprz = new aprz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_Aprz, paramBaseAdapter);
    case 109: 
      if (this.jdField_a_of_type_Aczl == null) {
        this.jdField_a_of_type_Aczl = new aczl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Aczl, paramBaseAdapter);
    case 110: 
      if (this.jdField_a_of_type_Adjc == null) {
        this.jdField_a_of_type_Adjc = new adjc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_Adjc, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_Adce == null) {
      this.jdField_a_of_type_Adce = new adce(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return a(this.jdField_a_of_type_Adce, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ackk)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adie
 * JD-Core Version:    0.7.0.1
 */