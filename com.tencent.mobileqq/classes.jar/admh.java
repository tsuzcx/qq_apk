import AccostSvc.EventItem;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import NS_MOBILE_AIONewestFeed.Media_Data;
import NS_MOBILE_AIONewestFeed.NewestFeedInfo;
import NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryRsp;
import NS_QQ_STORY_META.META.StStoryFeed;
import VIP.AIOSendReq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade.1;
import com.tencent.mobileqq.activity.ChatActivityFacade.10;
import com.tencent.mobileqq.activity.ChatActivityFacade.11;
import com.tencent.mobileqq.activity.ChatActivityFacade.12;
import com.tencent.mobileqq.activity.ChatActivityFacade.14;
import com.tencent.mobileqq.activity.ChatActivityFacade.15;
import com.tencent.mobileqq.activity.ChatActivityFacade.16;
import com.tencent.mobileqq.activity.ChatActivityFacade.17;
import com.tencent.mobileqq.activity.ChatActivityFacade.18;
import com.tencent.mobileqq.activity.ChatActivityFacade.19;
import com.tencent.mobileqq.activity.ChatActivityFacade.2;
import com.tencent.mobileqq.activity.ChatActivityFacade.20;
import com.tencent.mobileqq.activity.ChatActivityFacade.21;
import com.tencent.mobileqq.activity.ChatActivityFacade.22;
import com.tencent.mobileqq.activity.ChatActivityFacade.23;
import com.tencent.mobileqq.activity.ChatActivityFacade.3;
import com.tencent.mobileqq.activity.ChatActivityFacade.4;
import com.tencent.mobileqq.activity.ChatActivityFacade.5;
import com.tencent.mobileqq.activity.ChatActivityFacade.6;
import com.tencent.mobileqq.activity.ChatActivityFacade.7;
import com.tencent.mobileqq.activity.ChatActivityFacade.8;
import com.tencent.mobileqq.activity.ChatActivityFacade.9;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import feedcloud.FeedCloudRead.StGetC2CFeedRsp;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;

public class admh
{
  public static long a;
  private static admm jdField_a_of_type_Admm = new admm();
  public static bkzi a;
  public static ChatMessage a;
  public static QQToast a;
  public static List<ChatMessage> a;
  private static ConcurrentHashMap<String, admn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static bkzi b;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private static int a(SessionInfo paramSessionInfo, int paramInt, anvk paramanvk)
  {
    int i;
    if ((paramInt != 1000) && (paramInt != 1004) && (paramInt != 1006) && (paramInt != 1023) && (paramInt != 1022))
    {
      i = paramInt;
      if (paramInt != 10010) {}
    }
    else
    {
      i = paramInt;
      if (paramanvk.b(paramSessionInfo.curFriendUin)) {
        i = 0;
      }
    }
    return i;
  }
  
  private static int a(SessionInfo paramSessionInfo, String paramString)
  {
    if ((!arkc.c().jdField_b_of_type_Boolean) && ((paramSessionInfo.curType == 3000) || (paramSessionInfo.curType == 1)))
    {
      paramString = bhbx.a(paramString);
      int j = paramString[0];
      int i = j;
      if (paramSessionInfo.curType == 1) {
        i = j + paramString[1] * 2;
      }
      return i;
    }
    if (paramSessionInfo.curType == 0) {
      return bhbx.a(paramString)[0];
    }
    return paramString.getBytes("utf-8").length;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<String> paramArrayList)
  {
    long l1 = -1L;
    paramArrayList = bdpc.a(paramArrayList);
    if (paramArrayList != null)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      int i = bcpt.a;
      bcpt.a = i + 1;
      l1 = i;
      paramSessionInfo = bcsa.a(paramQQAppInterface, str, paramSessionInfo.curFriendUin, str, paramSessionInfo.curType, l1, paramArrayList);
      long l2 = paramSessionInfo.uniseq;
      paramSessionInfo.msgUid = bcsc.a(paramInt);
      l1 = l2;
      if (!anyv.a(paramQQAppInterface, paramSessionInfo, false))
      {
        paramQQAppInterface.getMessageFacade().addSendMessage(paramSessionInfo);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)a(paramQQAppInterface, paramString, paramSessionInfo, -3, 0);
    long l1 = 0L;
    if (localMessageForPtt != null)
    {
      long l2 = localMessageForPtt.uniseq;
      l1 = l2;
      if (l2 != -1L)
      {
        int i = QQRecorder.a(localMessageForPtt);
        int j = bhhd.a(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
        a(paramQQAppInterface, paramSessionInfo.curType, paramSessionInfo.curFriendUin, paramString, l2, true, i * 1000, j, true, 0, 0, true, localMessageForPtt.vipSubBubbleId, localBundle);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramString, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList, paramadmo, false);
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean1, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc 180
    //   8: iconst_2
    //   9: new 182	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   16: ldc 185
    //   18: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 200
    //   29: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 203	com/tencent/mobileqq/activity/aio/SessionInfo:entrance	I
    //   36: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +1402 -> 1448
    //   49: aload_2
    //   50: iconst_1
    //   51: aload 9
    //   53: invokestatic 215	bcsc:a	(Ljava/lang/String;ZLjava/util/ArrayList;)Ljava/lang/String;
    //   56: astore 15
    //   58: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc 180
    //   66: iconst_2
    //   67: new 182	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   74: ldc 217
    //   76: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   82: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_1
    //   92: getfield 62	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   95: istore_3
    //   96: aload_0
    //   97: getstatic 222	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   100: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   103: checkcast 43	anvk
    //   106: astore 16
    //   108: aload_1
    //   109: iload_3
    //   110: aload 16
    //   112: invokestatic 228	admh:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;ILanvk;)I
    //   115: istore 14
    //   117: aload 10
    //   119: getfield 233	admo:jdField_e_of_type_Long	J
    //   122: lconst_0
    //   123: lcmp
    //   124: ifeq +659 -> 783
    //   127: new 235	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   130: dup
    //   131: invokespecial 236	com/tencent/mobileqq/data/MessageForWantGiftMsg:<init>	()V
    //   134: astore_2
    //   135: aload_2
    //   136: checkcast 235	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   139: aload 10
    //   141: getfield 233	admo:jdField_e_of_type_Long	J
    //   144: putfield 239	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   147: aload_2
    //   148: checkcast 235	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   151: getstatic 242	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   154: new 182	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   161: aload 10
    //   163: getfield 233	admo:jdField_e_of_type_Long	J
    //   166: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: ldc 244
    //   171: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokevirtual 248	com/tencent/mobileqq/data/MessageForWantGiftMsg:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload_2
    //   181: sipush -2056
    //   184: putfield 253	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   187: aload_0
    //   188: aload_2
    //   189: aload_1
    //   190: getfield 41	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   193: aload_1
    //   194: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:troopUin	Ljava/lang/String;
    //   197: iload 14
    //   199: invokestatic 259	bcsa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   202: aload_2
    //   203: aload 15
    //   205: putfield 262	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   208: aload_2
    //   209: iload 8
    //   211: invokestatic 110	bcsc:a	(I)J
    //   214: putfield 263	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   217: aload_2
    //   218: iload 5
    //   220: putfield 266	com/tencent/mobileqq/data/ChatMessage:longMsgCount	I
    //   223: aload_2
    //   224: iload 6
    //   226: putfield 269	com/tencent/mobileqq/data/ChatMessage:longMsgIndex	I
    //   229: aload_2
    //   230: iload 7
    //   232: putfield 272	com/tencent/mobileqq/data/ChatMessage:longMsgId	I
    //   235: aload_2
    //   236: iconst_1
    //   237: putfield 275	com/tencent/mobileqq/data/ChatMessage:mAnimFlag	Z
    //   240: aload 10
    //   242: getfield 278	admo:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   245: ifnull +30 -> 275
    //   248: aload_2
    //   249: ldc_w 280
    //   252: aload 10
    //   254: getfield 278	admo:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   257: invokevirtual 285	com/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo:toJsonString	()Ljava/lang/String;
    //   260: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_2
    //   264: aconst_null
    //   265: invokestatic 291	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;)V
    //   268: invokestatic 294	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   271: aload_2
    //   272: invokevirtual 296	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   275: aload 10
    //   277: getfield 299	admo:i	Z
    //   280: ifeq +8 -> 288
    //   283: aload_2
    //   284: iconst_m1
    //   285: putfield 302	com/tencent/mobileqq/data/ChatMessage:mRobotFlag	I
    //   288: aload 10
    //   290: getfield 305	admo:jdField_g_of_type_Int	I
    //   293: iconst_m1
    //   294: if_icmpeq +18 -> 312
    //   297: aload_2
    //   298: ldc_w 307
    //   301: aload 10
    //   303: getfield 305	admo:jdField_g_of_type_Int	I
    //   306: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   309: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_2
    //   313: instanceof 313
    //   316: ifeq +964 -> 1280
    //   319: aload_2
    //   320: checkcast 313	com/tencent/mobileqq/data/MessageForReplyText
    //   323: astore 15
    //   325: aload 15
    //   327: aload_1
    //   328: getfield 203	com/tencent/mobileqq/activity/aio/SessionInfo:entrance	I
    //   331: putfield 316	com/tencent/mobileqq/data/MessageForReplyText:msgVia	I
    //   334: aload 15
    //   336: aload 10
    //   338: getfield 318	admo:jdField_d_of_type_Boolean	Z
    //   341: putfield 321	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   344: aload 15
    //   346: aload 10
    //   348: getfield 323	admo:jdField_b_of_type_Long	J
    //   351: putfield 326	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   354: aload 15
    //   356: aload 10
    //   358: getfield 328	admo:jdField_d_of_type_Int	I
    //   361: putfield 331	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   364: aload 15
    //   366: getfield 321	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   369: ifeq +35 -> 404
    //   372: aload 15
    //   374: ldc_w 333
    //   377: aload 15
    //   379: getfield 326	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   382: invokestatic 336	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   385: invokevirtual 337	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload 15
    //   390: ldc_w 339
    //   393: aload 15
    //   395: getfield 331	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   398: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   401: invokevirtual 337	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload 9
    //   406: ifnull +10 -> 416
    //   409: aload 15
    //   411: aload 9
    //   413: putfield 343	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   416: aload 10
    //   418: getfield 346	admo:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   421: invokestatic 351	apab:a	(Ljava/io/Serializable;)[B
    //   424: invokestatic 357	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   427: astore 9
    //   429: aload 15
    //   431: aload 10
    //   433: getfield 346	admo:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   436: putfield 360	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   439: aload 15
    //   441: ldc_w 362
    //   444: aload 9
    //   446: invokevirtual 337	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   449: aload 15
    //   451: aload 15
    //   453: getfield 365	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   456: iconst_1
    //   457: ior
    //   458: putfield 365	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   461: aload 15
    //   463: getfield 360	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   466: invokevirtual 371	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:getSourceMsg	()[B
    //   469: ifnull +17 -> 486
    //   472: aload 15
    //   474: aload 15
    //   476: getfield 360	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   479: aload_0
    //   480: invokevirtual 375	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:unPackSourceMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   483: invokevirtual 378	com/tencent/mobileqq/data/MessageForReplyText:setSourceMessageRecord	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   486: aload 10
    //   488: getfield 380	admo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   491: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   494: ifne +40 -> 534
    //   497: aload 10
    //   499: getfield 388	admo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   502: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   505: ifne +29 -> 534
    //   508: aload 15
    //   510: ldc_w 390
    //   513: aload 10
    //   515: getfield 380	admo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   518: invokevirtual 337	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload 15
    //   523: ldc_w 392
    //   526: aload 10
    //   528: getfield 388	admo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   531: invokevirtual 337	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload 10
    //   536: getfield 394	admo:jdField_e_of_type_Int	I
    //   539: ifle +23 -> 562
    //   542: invokestatic 399	agfe:a	()Lagfe;
    //   545: aload_2
    //   546: getfield 400	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   549: aload 10
    //   551: getfield 402	admo:jdField_c_of_type_Long	J
    //   554: aload 10
    //   556: getfield 394	admo:jdField_e_of_type_Int	I
    //   559: invokevirtual 405	agfe:a	(JJI)V
    //   562: aload_2
    //   563: getfield 408	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   566: iconst_1
    //   567: if_icmpne +750 -> 1317
    //   570: invokestatic 413	nty:a	()Lnty;
    //   573: aload_2
    //   574: invokevirtual 414	nty:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   577: aload 10
    //   579: getfield 415	admo:jdField_b_of_type_Boolean	Z
    //   582: ifeq +7 -> 589
    //   585: aload_2
    //   586: invokestatic 418	arxx:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   589: aload_2
    //   590: getfield 408	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   593: sipush 1033
    //   596: if_icmpeq +13 -> 609
    //   599: aload_2
    //   600: getfield 408	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   603: sipush 1034
    //   606: if_icmpne +730 -> 1336
    //   609: aload_0
    //   610: aload_2
    //   611: aload_2
    //   612: getfield 421	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   615: aload_2
    //   616: getfield 408	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   619: aload_1
    //   620: getfield 424	com/tencent/mobileqq/activity/aio/SessionInfo:topicId	I
    //   623: invokestatic 429	aqvh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;II)V
    //   626: iload 14
    //   628: sipush 10007
    //   631: if_icmpne +16 -> 647
    //   634: aload_0
    //   635: aload_2
    //   636: aload_2
    //   637: getfield 421	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   640: aload_2
    //   641: getfield 408	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   644: invokestatic 434	aveb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;I)V
    //   647: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +58 -> 708
    //   653: ldc 180
    //   655: iconst_2
    //   656: new 182	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   663: ldc_w 436
    //   666: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: aload_2
    //   670: getfield 439	com/tencent/mobileqq/data/ChatMessage:time	J
    //   673: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   676: ldc_w 441
    //   679: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload_2
    //   683: getfield 444	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   686: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: ldc_w 446
    //   692: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload_2
    //   696: getfield 263	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   699: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   702: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: aload 10
    //   710: getfield 449	admo:f	Z
    //   713: istore 4
    //   715: aload 10
    //   717: getfield 451	admo:jdField_g_of_type_Boolean	Z
    //   720: ifeq +697 -> 1417
    //   723: iload 4
    //   725: ifeq +649 -> 1374
    //   728: aload_0
    //   729: getstatic 454	com/tencent/mobileqq/app/QQManagerFactory:LONG_TEXT_MSG_MANAGER	I
    //   732: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   735: checkcast 456	axii
    //   738: aload_0
    //   739: aload_2
    //   740: iconst_0
    //   741: invokevirtual 459	axii:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   744: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   747: ifeq +31 -> 778
    //   750: ldc 180
    //   752: iconst_2
    //   753: new 182	java/lang/StringBuilder
    //   756: dup
    //   757: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   760: ldc_w 461
    //   763: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   769: invokevirtual 198	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   772: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: aload_2
    //   779: getfield 400	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   782: lreturn
    //   783: aload 10
    //   785: getfield 463	admo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   788: ifnull +45 -> 833
    //   791: aload_0
    //   792: invokestatic 468	akqe:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   795: ifeq +38 -> 833
    //   798: new 470	com/tencent/mobileqq/data/MessageForFoldMsg
    //   801: dup
    //   802: invokespecial 471	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   805: astore_2
    //   806: aload_2
    //   807: checkcast 470	com/tencent/mobileqq/data/MessageForFoldMsg
    //   810: iconst_0
    //   811: aload 10
    //   813: getfield 463	admo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   816: aload 10
    //   818: getfield 473	admo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   821: aload 10
    //   823: getfield 475	admo:jdField_d_of_type_Long	J
    //   826: iconst_1
    //   827: invokevirtual 479	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;Ljava/lang/String;JZ)V
    //   830: goto -643 -> 187
    //   833: aload 10
    //   835: getfield 346	admo:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   838: ifnonnull +31 -> 869
    //   841: aload 10
    //   843: getfield 449	admo:f	Z
    //   846: ifeq +23 -> 869
    //   849: aload_0
    //   850: invokestatic 480	axii:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   853: ifeq +16 -> 869
    //   856: sipush -1051
    //   859: invokestatic 483	bcsa:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   862: checkcast 250	com/tencent/mobileqq/data/ChatMessage
    //   865: astore_2
    //   866: goto -679 -> 187
    //   869: aload 10
    //   871: getfield 346	admo:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   874: ifnull +566 -> 1440
    //   877: sipush -1049
    //   880: istore 12
    //   882: iload 12
    //   884: invokestatic 483	bcsa:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   887: checkcast 250	com/tencent/mobileqq/data/ChatMessage
    //   890: astore_2
    //   891: aload 16
    //   893: aload_0
    //   894: invokevirtual 486	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   897: iconst_0
    //   898: invokevirtual 489	anvk:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   901: astore 17
    //   903: aload 17
    //   905: ifnull +56 -> 961
    //   908: aload_2
    //   909: ldc_w 491
    //   912: aload 17
    //   914: invokestatic 496	gb:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)I
    //   917: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   920: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload_2
    //   924: ldc_w 498
    //   927: aload 17
    //   929: getfield 503	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   932: invokestatic 506	gb:c	(J)I
    //   935: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   938: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: iconst_1
    //   942: aload 17
    //   944: getfield 509	com/tencent/mobileqq/data/ExtensionInfo:magicFont	I
    //   947: if_icmpne +245 -> 1192
    //   950: aload_2
    //   951: ldc_w 511
    //   954: iconst_0
    //   955: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   958: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   961: aload 16
    //   963: aload_0
    //   964: invokevirtual 91	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   967: invokevirtual 514	anvk:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   970: astore 16
    //   972: aload 16
    //   974: ifnull +175 -> 1149
    //   977: aload 16
    //   979: getstatic 520	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   982: invokevirtual 526	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   985: ifeq +78 -> 1063
    //   988: iconst_1
    //   989: istore_3
    //   990: aload 16
    //   992: getstatic 520	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   995: invokevirtual 530	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   998: iconst_1
    //   999: if_icmpne +5 -> 1004
    //   1002: iconst_3
    //   1003: istore_3
    //   1004: aload_2
    //   1005: ldc_w 532
    //   1008: iload_3
    //   1009: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1012: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1015: aload_2
    //   1016: ldc_w 534
    //   1019: aload 16
    //   1021: getstatic 520	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   1024: invokevirtual 537	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1027: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1030: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload_2
    //   1034: ldc_w 539
    //   1037: aload 16
    //   1039: getfield 542	com/tencent/mobileqq/data/Friends:bigClubTemplateId	I
    //   1042: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1045: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1048: aload_2
    //   1049: ldc_w 544
    //   1052: aload 16
    //   1054: getfield 547	com/tencent/mobileqq/data/Friends:bigClubExtTemplateId	I
    //   1057: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1060: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1063: aload 16
    //   1065: getstatic 550	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1068: invokevirtual 526	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1071: ifne +14 -> 1085
    //   1074: aload 16
    //   1076: getstatic 553	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1079: invokevirtual 526	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1082: ifeq +67 -> 1149
    //   1085: aload 16
    //   1087: getstatic 553	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1090: invokevirtual 526	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1093: ifeq +117 -> 1210
    //   1096: sipush 256
    //   1099: istore_3
    //   1100: aload 16
    //   1102: getstatic 553	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1105: invokevirtual 530	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1108: iconst_1
    //   1109: if_icmpne +7 -> 1116
    //   1112: sipush 258
    //   1115: istore_3
    //   1116: aload 16
    //   1118: getstatic 553	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1121: invokevirtual 537	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1124: istore 13
    //   1126: aload_2
    //   1127: ldc_w 555
    //   1130: iload_3
    //   1131: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1134: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1137: aload_2
    //   1138: ldc_w 557
    //   1141: iload 13
    //   1143: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1146: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1149: aload 9
    //   1151: ifnull +11 -> 1162
    //   1154: iload 14
    //   1156: aload 9
    //   1158: aload_2
    //   1159: invokestatic 562	bgcz:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1162: iload 12
    //   1164: sipush -1000
    //   1167: if_icmpne +22 -> 1189
    //   1170: aload 10
    //   1172: getfield 565	admo:h	Z
    //   1175: ifeq +14 -> 1189
    //   1178: aload_2
    //   1179: ldc_w 567
    //   1182: iconst_1
    //   1183: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1186: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1189: goto -1002 -> 187
    //   1192: aload_2
    //   1193: ldc_w 511
    //   1196: aload 17
    //   1198: getfield 570	com/tencent/mobileqq/data/ExtensionInfo:fontEffect	I
    //   1201: invokestatic 311	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1204: invokevirtual 286	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1207: goto -246 -> 961
    //   1210: iconst_1
    //   1211: istore_3
    //   1212: aload 16
    //   1214: getstatic 550	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1217: invokevirtual 530	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1220: iconst_1
    //   1221: if_icmpne +5 -> 1226
    //   1224: iconst_3
    //   1225: istore_3
    //   1226: aload 16
    //   1228: getstatic 550	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1231: invokevirtual 537	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1234: istore 13
    //   1236: goto -110 -> 1126
    //   1239: astore 9
    //   1241: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1244: ifeq -682 -> 562
    //   1247: ldc 180
    //   1249: iconst_2
    //   1250: new 182	java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   1257: ldc_w 572
    //   1260: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload 9
    //   1265: invokevirtual 575	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1268: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1277: goto -715 -> 562
    //   1280: aload_2
    //   1281: checkcast 577	com/tencent/mobileqq/data/MessageForText
    //   1284: astore 15
    //   1286: aload 15
    //   1288: aload_1
    //   1289: getfield 203	com/tencent/mobileqq/activity/aio/SessionInfo:entrance	I
    //   1292: putfield 578	com/tencent/mobileqq/data/MessageForText:msgVia	I
    //   1295: aload 9
    //   1297: ifnull +10 -> 1307
    //   1300: aload 15
    //   1302: aload 9
    //   1304: putfield 579	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   1307: aload 15
    //   1309: aload 10
    //   1311: invokevirtual 583	com/tencent/mobileqq/data/MessageForText:setSendMsgParams	(Ladmo;)V
    //   1314: goto -752 -> 562
    //   1317: invokestatic 413	nty:a	()Lnty;
    //   1320: getfield 585	nty:jdField_a_of_type_Boolean	Z
    //   1323: ifeq -746 -> 577
    //   1326: invokestatic 413	nty:a	()Lnty;
    //   1329: iconst_0
    //   1330: putfield 585	nty:jdField_a_of_type_Boolean	Z
    //   1333: goto -756 -> 577
    //   1336: aload_1
    //   1337: getfield 588	com/tencent/mobileqq/activity/aio/SessionInfo:isFromFrdRecConfess	Z
    //   1340: ifeq +15 -> 1355
    //   1343: aload_0
    //   1344: aload_2
    //   1345: aload_1
    //   1346: getfield 41	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   1349: invokestatic 591	aqvh:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1352: goto -726 -> 626
    //   1355: aload_1
    //   1356: getfield 594	com/tencent/mobileqq/activity/aio/SessionInfo:isFromGroupRecConfess	Z
    //   1359: ifeq -733 -> 626
    //   1362: aload_0
    //   1363: aload_2
    //   1364: aload_1
    //   1365: getfield 41	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   1368: invokestatic 596	aqvh:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1371: goto -745 -> 626
    //   1374: iload 11
    //   1376: ifeq +29 -> 1405
    //   1379: aload_0
    //   1380: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1383: aload_2
    //   1384: invokevirtual 599	com/tencent/imcore/message/QQMessageFacade:addMsgForForward	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1387: goto -643 -> 744
    //   1390: astore_0
    //   1391: ldc_w 601
    //   1394: iconst_1
    //   1395: ldc_w 603
    //   1398: aload_0
    //   1399: invokestatic 606	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1402: goto -658 -> 744
    //   1405: aload_0
    //   1406: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1409: aload_2
    //   1410: aconst_null
    //   1411: invokevirtual 610	com/tencent/imcore/message/QQMessageFacade:addAndSendMessage	(Lcom/tencent/mobileqq/data/MessageRecord;Lanyz;)V
    //   1414: goto -670 -> 744
    //   1417: new 612	com/tencent/mobileqq/activity/ChatActivityFacade$13
    //   1420: dup
    //   1421: iload 4
    //   1423: aload_0
    //   1424: aload_2
    //   1425: iload 11
    //   1427: invokespecial 615	com/tencent/mobileqq/activity/ChatActivityFacade$13:<init>	(ZLcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Z)V
    //   1430: bipush 10
    //   1432: aconst_null
    //   1433: iconst_0
    //   1434: invokestatic 621	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1437: goto -693 -> 744
    //   1440: sipush -1000
    //   1443: istore 12
    //   1445: goto -563 -> 882
    //   1448: ldc 244
    //   1450: astore 15
    //   1452: goto -1394 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1455	0	paramQQAppInterface	QQAppInterface
    //   0	1455	1	paramSessionInfo	SessionInfo
    //   0	1455	2	paramString	String
    //   0	1455	3	paramInt1	int
    //   0	1455	4	paramBoolean1	boolean
    //   0	1455	5	paramByte1	byte
    //   0	1455	6	paramByte2	byte
    //   0	1455	7	paramShort	short
    //   0	1455	8	paramInt2	int
    //   0	1455	9	paramArrayList	ArrayList<MessageForText.AtTroopMemberInfo>
    //   0	1455	10	paramadmo	admo
    //   0	1455	11	paramBoolean2	boolean
    //   880	564	12	i	int
    //   1124	111	13	j	int
    //   115	1040	14	k	int
    //   56	1395	15	localObject1	Object
    //   106	1121	16	localObject2	Object
    //   901	296	17	localExtensionInfo	ExtensionInfo
    // Exception table:
    //   from	to	target	type
    //   416	486	1239	java/lang/Exception
    //   486	534	1239	java/lang/Exception
    //   534	562	1239	java/lang/Exception
    //   728	744	1390	java/lang/Exception
    //   1379	1387	1390	java/lang/Exception
    //   1405	1414	1390	java/lang/Exception
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = TransfileUtile.makeTransFileProtocolDataForForwardImage(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = bcsa.a(-20000);
      paramString3.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString3);
      paramQQAppInterface.getMessageFacade().addMessage(paramString3, paramQQAppInterface.getCurrentAccountUin());
      return paramString3.uniseq;
    }
    return 0L;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if (paramSessionInfo == null) {}
    while (paramString == null) {
      return null;
    }
    paramQQAppInterface = bcsa.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType);
    paramQQAppInterface.path = paramString;
    paramQQAppInterface.size = 0L;
    paramQQAppInterface.type = 1;
    paramQQAppInterface.isRead = true;
    paramQQAppInterface.serial();
    return paramQQAppInterface;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend start, currenttime:" + System.currentTimeMillis() + " sessionInfo.entrance:" + paramSessionInfo.entrance);
    }
    if (paramString != null) {}
    for (String str = bcsc.a(paramString, true, paramArrayList);; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 1  currenttime:" + System.currentTimeMillis());
      }
      if (paramadmo.jdField_e_of_type_Long != 0L)
      {
        paramString = new MessageForWantGiftMsg();
        ((MessageForWantGiftMsg)paramString).wantGiftSenderUin = paramadmo.jdField_e_of_type_Long;
        ((MessageForWantGiftMsg)paramString).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramadmo.jdField_e_of_type_Long + "");
        paramString.msgtype = -2056;
      }
      for (;;)
      {
        bcsa.a(paramQQAppInterface, paramString, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType);
        paramString.msg = str;
        paramString.msgUid = bcsc.a(paramInt2);
        paramString.longMsgCount = paramByte1;
        paramString.longMsgIndex = paramByte2;
        paramString.longMsgId = paramShort;
        paramString.mAnimFlag = true;
        if (paramadmo.i) {
          paramString.mRobotFlag = -1;
        }
        paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramadmo.jdField_g_of_type_Int));
        if (!(paramString instanceof MessageForReplyText)) {
          break label733;
        }
        paramQQAppInterface = (MessageForReplyText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.entrance;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        try
        {
          paramQQAppInterface.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(apab.a(paramadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo)));
          if ((!android.text.TextUtils.isEmpty(paramadmo.jdField_a_of_type_JavaLangString)) && (!android.text.TextUtils.isEmpty(paramadmo.jdField_b_of_type_JavaLangString)))
          {
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_msg", paramadmo.jdField_a_of_type_JavaLangString);
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_at_list", paramadmo.jdField_b_of_type_JavaLangString);
          }
          paramQQAppInterface.mSourceMsgInfo = paramadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
          paramQQAppInterface.extLong |= 0x1;
        }
        catch (Exception paramQQAppInterface)
        {
          for (;;)
          {
            label358:
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, "Save sourceMsgInfo exception:" + paramQQAppInterface.getMessage());
            }
          }
        }
        if (paramString.istroop != 1) {
          break label766;
        }
        nty.a().a(paramString);
        label373:
        if (paramadmo.jdField_b_of_type_Boolean) {
          arxx.a(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramString.time + " senderUin = " + paramString.senderuin + " msgUid = " + paramString.msgUid);
        }
        return paramString;
        if ((paramadmo.jdField_c_of_type_JavaLangString != null) && (akqe.a(paramQQAppInterface)))
        {
          paramString = new MessageForFoldMsg();
          ((MessageForFoldMsg)paramString).init(false, paramadmo.jdField_c_of_type_JavaLangString, paramadmo.jdField_d_of_type_JavaLangString, paramadmo.jdField_d_of_type_Long, true);
        }
        else
        {
          if ((paramadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) || (!paramadmo.f) || (!axii.a(paramQQAppInterface))) {
            break;
          }
          paramString = (ChatMessage)bcsa.a(-1051);
        }
      }
      if (paramadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {}
      for (paramInt1 = -1049;; paramInt1 = -1000)
      {
        paramString = (ChatMessage)bcsa.a(paramInt1);
        ExtensionInfo localExtensionInfo = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramQQAppInterface.getCurrentUin(), false);
        if (localExtensionInfo != null)
        {
          paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(gb.a(localExtensionInfo)));
          paramString.saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(gb.c(localExtensionInfo.uVipFont)));
          if (1 != localExtensionInfo.magicFont) {
            break label676;
          }
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
        }
        for (;;)
        {
          if (paramArrayList != null) {
            bgcz.a(paramSessionInfo.curType, paramArrayList, paramString);
          }
          if ((paramInt1 == -1000) && (paramadmo.h)) {
            paramString.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
          }
          break;
          label676:
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(localExtensionInfo.fontEffect));
        }
        label733:
        paramQQAppInterface = (MessageForText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.entrance;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        paramQQAppInterface.setSendMsgParams(paramadmo);
        break label358;
        label766:
        if (!nty.a().jdField_a_of_type_Boolean) {
          break label373;
        }
        nty.a().jdField_a_of_type_Boolean = false;
        break label373;
      }
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessage start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    short s = 0;
    Random localRandom = new Random();
    label512:
    for (;;)
    {
      try
      {
        if (a(paramadmo, false))
        {
          paramArrayList = b(str, paramArrayList, paramadmo, localArrayList);
          paramString = paramArrayList;
          if (!QLog.isColorLevel()) {
            break label512;
          }
          QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          paramString = paramArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessage step 2, currenttime:" + System.currentTimeMillis());
          }
          int i = Math.abs(localRandom.nextInt());
          str = (String)paramString.get(0);
          if (localArrayList.size() > 0)
          {
            paramArrayList = (ArrayList)localArrayList.get(0);
            if ((paramSessionInfo.curType == 3000) || (paramSessionInfo.curType == 1)) {
              i = Math.abs(localRandom.nextInt());
            }
            return a(paramQQAppInterface, paramSessionInfo, str, -1000, bool, (byte)paramString.size(), (byte)0, s, i, paramArrayList, paramadmo);
          }
        }
        else
        {
          if (a(paramQQAppInterface, paramSessionInfo, str, paramadmo))
          {
            paramArrayList = a(str, paramArrayList, paramadmo, localArrayList);
            paramString = paramArrayList;
            if (!QLog.isColorLevel()) {
              break label512;
            }
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramString = paramArrayList;
            continue;
          }
          paramString = bhbx.a(str, 560, 20, paramArrayList, localArrayList);
          if (paramString.size() > 1)
          {
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramString.size() + " isDivide = " + bool + " currenttime:" + System.currentTimeMillis());
            }
            s = a(paramQQAppInterface, paramSessionInfo, bool, (short)0, localRandom);
            continue;
          }
          bool = false;
          continue;
        }
        paramArrayList = null;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
    }
  }
  
  public static MessageForPtt a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramSessionInfo != null)
      {
        int i = paramSessionInfo.curType;
        localObject1 = bcsa.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, i);
        ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(paramInt2, paramString);
        ((MessageForPtt)localObject1).fileSize = paramInt1;
        ((MessageForPtt)localObject1).itemType = 2;
        if ((!bdtt.a(i)) || (!bdtt.a(paramQQAppInterface))) {
          break label187;
        }
        paramInt1 = 1;
        ((MessageForPtt)localObject1).sttAbility = paramInt1;
        ((MessageForPtt)localObject1).voiceType = paramInt2;
        ((MessageForPtt)localObject1).longPttVipFlag = bcsc.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        nty.a().a((MessageRecord)localObject1);
        if ((paramSessionInfo.curType != 1033) && ((paramSessionInfo.curType != 1034) || (paramSessionInfo.topicId <= 0))) {
          break label192;
        }
        aqvh.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSessionInfo.topicId);
      }
    }
    for (;;)
    {
      ((MessageForPtt)localObject1).serial();
      ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((MessageRecord)localObject1);
      return localObject1;
      label187:
      paramInt1 = 0;
      break;
      label192:
      if (paramSessionInfo.isFromFrdRecConfess) {
        aqvh.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.curFriendUin);
      } else if (paramSessionInfo.isFromGroupRecConfess) {
        aqvh.b(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.curFriendUin);
      }
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (acnh.d(paramSessionInfo.curType))
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMsgList(paramSessionInfo.curFriendUin, paramSessionInfo.curType);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!bhfj.b(paramSessionInfo.issend)) {
            return paramSessionInfo;
          }
          i -= 1;
        }
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPtt paramMessageForPtt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSessionInfo != null)
    {
      localObject1 = localObject2;
      if (paramMessageForPtt != null)
      {
        localObject1 = bcsa.a(paramMessageForPtt);
        ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((MessageRecord)localObject1);
        paramQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      }
    }
    return localObject1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    paramString = a(paramQQAppInterface, paramString, paramSessionInfo, paramInt1, paramInt2);
    if (paramString != null)
    {
      paramString.msgVia = paramSessionInfo.entrance;
      paramQQAppInterface.getMessageFacade().addMessage(paramString, paramQQAppInterface.getCurrentAccountUin());
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d("ChatActivityFacade", 2, "createPttMessage null");
    return paramString;
  }
  
  public static AbsShareMsg a(Context paramContext, String paramString, List<ChatMessage> paramList, Map<String, String> paramMap, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    String str = "";
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int i;
    label51:
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (paramList.size() >= 4)
    {
      j = 4;
      k = 0;
      i = 4;
      if ((k >= j) || (i <= 0)) {
        break label692;
      }
      localObject2 = new StringBuilder();
      localObject3 = (ChatMessage)paramList.get(k);
      localObject1 = "";
      if (!paramBoolean) {
        break label317;
      }
      localObject1 = (String)paramMap.get(acnh.c((MessageRecord)localObject3));
      paramString = (String)localObject1;
      if (((ChatMessage)localObject3).istroop == 1) {
        paramString = com.tencent.mobileqq.text.TextUtils.removeColorNickCode((String)localObject1);
      }
      label128:
      if ((android.text.TextUtils.isEmpty(paramString)) || (paramString.trim().length() == 0)) {
        break label368;
      }
      localObject1 = paramString;
      if (paramString.length() > 12) {
        localObject1 = paramString.substring(0, 11) + "...";
      }
      label185:
      if (!(localObject3 instanceof MessageForPic)) {
        break label381;
      }
      paramString = ((ChatMessage)localObject3).getSummaryMsg();
    }
    label317:
    label368:
    label1404:
    for (;;)
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":  ");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = new boolean[1];
      localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 3, 46, ((StringBuilder)localObject2).toString(), (boolean[])localObject1).toString()));
      int m = i - 1;
      i = m;
      if (localObject1[0] != 0) {
        i = m - 1;
      }
      k += 1;
      str = paramString;
      break label51;
      j = paramList.size();
      break;
      Object localObject4 = new ArrayList(paramMap.values());
      paramString = (String)localObject1;
      if (localObject4 == null) {
        break label128;
      }
      paramString = (String)localObject1;
      if (((List)localObject4).isEmpty()) {
        break label128;
      }
      paramString = (String)((List)localObject4).get(0);
      break label128;
      localObject1 = axiv.a(((ChatMessage)localObject3).senderuin);
      break label185;
      label381:
      if ((localObject3 instanceof MessageForShortVideo))
      {
        if (((ChatMessage)localObject3).msgtype == -2071) {
          paramString = anvx.a(2131701055);
        } else {
          paramString = anvx.a(2131701064);
        }
      }
      else
      {
        if ((localObject3 instanceof MessageForText))
        {
          paramString = (MessageForText)localObject3;
          if (paramString.sb != null) {}
          for (paramString = paramString.sb.toString();; paramString = paramString.msg)
          {
            str = paramString;
            if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
              str = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
            }
            paramString = str;
            break;
          }
        }
        if ((localObject3 instanceof MessageForQQStoryComment))
        {
          paramString = ((MessageForQQStoryComment)localObject3).comment;
        }
        else if (((localObject3 instanceof MessageForMixedMsg)) || ((localObject3 instanceof MessageForLongMsg)))
        {
          paramString = MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject3).toString();
        }
        else if ((localObject3 instanceof MessageForStructing))
        {
          paramString = ((ChatMessage)localObject3).getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForArkApp))
        {
          paramString = ((MessageForArkApp)localObject3).getSummery();
        }
        else if ((localObject3 instanceof MessageForArkBabyqReply))
        {
          paramString = ((MessageForArkBabyqReply)localObject3).getSummery();
        }
        else if ((localObject3 instanceof MessageForArkFlashChat))
        {
          paramString = ((MessageForArkFlashChat)localObject3).getSummery();
        }
        else if ((localObject3 instanceof MessageForReplyText))
        {
          paramString = (MessageForReplyText)localObject3;
          paramString.parse();
          paramString = paramString.getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForFile))
        {
          paramString = ((MessageForFile)localObject3).getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForTroopFile))
        {
          paramString = ((MessageForTroopFile)localObject3).getSummaryMsg();
        }
        else if ((localObject3 instanceof MessageForPtt))
        {
          paramString = anvx.a(2131701072);
          continue;
          paramString = paramContext.getString(2131690761);
          localObject3 = new bdnr(StructMsgForGeneralShare.class).c(35).a(anvx.a(2131701071)).a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).a();
          localObject4 = new bdqb();
          ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
          if ((localChatMessage.istroop == 1) || (localChatMessage.istroop == 3000)) {
            paramContext = anvx.a(2131701052);
          }
          for (;;)
          {
            paramString = paramContext;
            if (android.text.TextUtils.isEmpty(paramContext))
            {
              QLog.w("ChatActivityFacade", 1, "generateMultiMsgForwardStructMsg: titleStr is null");
              paramString = anvx.a(2131701068);
            }
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG.Nest", 2, String.format("step.generateStructMsgContent:titleStr = %s,listSize = %d,firstMsg.istroop = %d", new Object[] { paramString, Integer.valueOf(paramList.size()), Integer.valueOf(localChatMessage.istroop) }));
            }
            paramContext = new StructMsgItemTitle(paramString);
            paramContext.f("34");
            paramContext.g("12");
            paramContext.h("2");
            ((bdnv)localObject4).a(paramContext);
            paramContext = localArrayList.iterator();
            for (;;)
            {
              if (paramContext.hasNext())
              {
                paramString = (bdnu)paramContext.next();
                if ((paramString instanceof bdnw))
                {
                  paramMap = (bdnw)paramString;
                  paramMap.f("26");
                  paramMap.e("#777777");
                  paramMap.g("12");
                  paramMap.h("4");
                }
                ((bdnv)localObject4).a(paramString);
                continue;
                if (localChatMessage.istroop != 0) {
                  break label1404;
                }
                paramString = localChatMessage.senderuin;
                if (android.text.TextUtils.equals(localChatMessage.senderuin, localChatMessage.selfuin))
                {
                  localObject1 = localChatMessage.frienduin;
                  label1022:
                  localObject2 = (String)paramMap.get(paramString);
                  str = (String)paramMap.get(localObject1);
                  boolean bool = true;
                  paramString = "";
                  i = 0;
                  paramBoolean = bool;
                  if (i >= paramList.size()) {
                    break label1128;
                  }
                  paramMap = (ChatMessage)paramList.get(i);
                  if (!android.text.TextUtils.isEmpty(paramString)) {
                    break label1114;
                  }
                  paramString = paramMap.senderuin;
                }
              }
            }
            for (;;)
            {
              i += 1;
              break label1056;
              localObject1 = localChatMessage.selfuin;
              break label1022;
              if (!android.text.TextUtils.equals(paramString, paramMap.senderuin))
              {
                paramBoolean = false;
                if ((localObject2 == null) || (((String)localObject2).trim().length() == 0)) {
                  QLog.d("MultiMsg_TAG", 2, "firstNick is null !!!");
                }
                for (paramString = axiv.a(localChatMessage.senderuin);; paramString = (String)localObject2)
                {
                  if (str != null)
                  {
                    paramMap = str;
                    if (str.trim().length() != 0) {}
                  }
                  else
                  {
                    paramMap = str;
                    if (!paramBoolean)
                    {
                      QLog.d("MultiMsg_TAG", 2, "!hasOnlyOneSender !!! empty nick for receiver");
                      paramMap = axiv.a((String)localObject1);
                    }
                  }
                  localObject1 = new Paint();
                  ((Paint)localObject1).setTextSize(34.0F);
                  paramContext = a(paramContext, paramString, paramMap, 2, (int)(BaseChatItemLayout.f * 0.7F), 2048, (Paint)localObject1, paramBoolean);
                  break;
                  ((bdnv)localObject4).a(new bdpz());
                  paramContext = new bdsv(String.format(anvx.a(2131701049), new Object[] { Integer.valueOf(paramList.size()) }));
                  paramContext.f("26");
                  paramContext.e("#777777");
                  ((bdnv)localObject4).a(paramContext);
                  ((AbsShareMsg)localObject3).addItem((bdnu)localObject4);
                  ((AbsShareMsg)localObject3).mTSum = paramList.size();
                  if (QLog.isColorLevel())
                  {
                    paramContext = bdpo.b(((AbsShareMsg)localObject3).getXmlBytes());
                    paramString = new StringBuilder().append("generateStructMsgLength = ");
                    if (paramContext != null) {
                      break label1388;
                    }
                  }
                  for (i = 0;; i = paramContext.length)
                  {
                    QLog.d("MultiMsg_TAG", 2, i);
                    return localObject3;
                  }
                }
              }
            }
            paramContext = "";
          }
        }
        else
        {
          paramString = str;
        }
      }
    }
  }
  
  public static StructMsgForGeneralShare a(Context paramContext, MessageRecord paramMessageRecord, String paramString)
  {
    int i = 50;
    if (paramMessageRecord == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord instanceof MessageForMixedMsg))
    {
      paramString = new StringBuilder();
      paramString.append(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, 30, paramString.toString()).toString();
      localArrayList.add(new StructMsgItemTitle(paramMessageRecord));
      paramString = paramMessageRecord;
      if (paramMessageRecord.length() > 30) {
        paramString = paramMessageRecord.substring(0, 30);
      }
      paramMessageRecord = paramContext.getString(2131690761);
      paramContext = (StructMsgForGeneralShare)new bdnr(StructMsgForGeneralShare.class).c(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).d(paramContext.getResources().getString(2131694181)).a();
      paramMessageRecord = new bdqb(localArrayList);
      paramMessageRecord.a(new bdpz());
      paramMessageRecord.a(new bdsv(anvx.a(2131701051)));
      paramContext.addItem(paramMessageRecord);
      return paramContext;
    }
    label247:
    String str;
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramString = (MessageForReplyText)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
        }
        if (!nty.a(paramMessageRecord)) {
          break label389;
        }
      }
    }
    for (;;)
    {
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
      break;
      paramString = paramString.msg;
      break label247;
      paramString = (MessageForLongTextMsg)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        label326:
        str = paramString;
        if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
          str = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol(paramString);
        }
        if (!nty.a(paramMessageRecord)) {
          break label383;
        }
      }
      for (;;)
      {
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
        break;
        paramString = paramString.msg;
        break label326;
        label383:
        i = 60;
      }
      label389:
      i = 60;
    }
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramContext, paramInt1, paramInt2, paramInt3, paramCharSequence, null);
  }
  
  private static CharSequence a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence, boolean[] paramArrayOfBoolean)
  {
    paramContext = paramContext.getResources();
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getDisplayMetrics().density;
    int k = paramCharSequence.length();
    int i = 0;
    int j = i;
    if (i < k)
    {
      float f = Layout.getDesiredWidth(paramCharSequence, 0, i + 1, localTextPaint);
      if ((f > paramInt1) && (paramArrayOfBoolean != null) && (paramArrayOfBoolean.length > 0)) {
        paramArrayOfBoolean[0] = true;
      }
      if (f > paramInt1 * paramInt2) {
        j = i - 1;
      }
    }
    else if (j >= k)
    {
      paramContext = paramCharSequence;
      if (j <= paramInt3) {}
    }
    else
    {
      if (j <= paramInt3) {
        break label171;
      }
    }
    for (;;)
    {
      paramContext = paramCharSequence.subSequence(0, paramInt3).toString() + "…";
      return paramContext;
      i += 1;
      break;
      label171:
      paramInt3 = j;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "adjustTitleByNick() called with: firstNick = [" + paramString1 + "], secondNick = [" + paramString2 + "]");
    }
    String str = "";
    if (android.text.TextUtils.isEmpty(paramString1))
    {
      paramContext = str;
      return paramContext;
    }
    str = paramString2;
    if (android.text.TextUtils.isEmpty(paramString2)) {
      str = "";
    }
    paramString2 = paramString1 + anvx.a(2131701057) + str + anvx.a(2131701050);
    if (paramBoolean) {
      paramString2 = paramString1 + anvx.a(2131701074);
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.getPaint().set(paramPaint);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, -2));
    localTextView.setText(paramString2);
    int i = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(paramInt3, -2147483648);
    localTextView.measure(i, j);
    if (localTextView.getLineCount() > paramInt1)
    {
      paramContext = null;
      paramInt2 = 0;
      label231:
      if (paramInt2 <= paramString1.length())
      {
        paramInt3 = paramInt2;
        label244:
        paramString2 = paramString1.substring(0, paramInt3);
        if (paramInt2 > str.length()) {
          break label403;
        }
      }
      label403:
      for (paramInt3 = paramInt2;; paramInt3 = str.length())
      {
        paramPaint = str.substring(0, paramInt3);
        if (!paramBoolean) {
          break label413;
        }
        paramString2 = paramString2 + anvx.a(2131701077);
        localTextView.setText(paramString2);
        localTextView.measure(i, j);
        paramInt3 = localTextView.getLineCount();
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "adjustTitleByNick() called title=[" + paramString2 + "],lineCount=[" + paramInt3 + "]");
        }
        if (paramInt3 > paramInt1) {
          break;
        }
        paramInt2 += 1;
        paramContext = paramString2;
        break label231;
        paramInt3 = paramString1.length();
        break label244;
      }
      label413:
      if (paramInt2 < paramString1.length()) {
        paramString2 = paramString2 + "...";
      }
      for (;;)
      {
        paramString2 = paramString2 + anvx.a(2131701065);
        paramPaint = paramString2 + paramPaint;
        paramString2 = paramPaint;
        if (paramInt2 < str.length()) {
          paramString2 = paramPaint + "...";
        }
        paramString2 = paramString2 + anvx.a(2131701073);
        break;
      }
    }
    return paramString2;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    paramSessionInfo = paramSessionInfo.curFriendUin;
    return paramString + "_" + paramQQAppInterface + "_" + paramSessionInfo;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("id", paramString1);
    localJSONObject2.put("name", paramString2);
    localJSONObject2.put("address", paramString3);
    localJSONObject2.put("lat", paramString4);
    localJSONObject2.put("lng", paramString5);
    localJSONObject2.put("from", "plusPanel");
    localJSONObject1.put("Location.Search", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  public static String a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    int i = 0;
    int j = 0;
    while ((i < paramString.length()) && (paramString.codePointAt(i) == 0))
    {
      j += 1;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createTextMessageToshow, at info starts with char 0");
      }
      i += 1;
    }
    Object localObject = paramString;
    if (j > 0)
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
          localObject = (MessageForText.AtTroopMemberInfo)paramArrayList.next();
          ((MessageForText.AtTroopMemberInfo)localObject).startPos = ((short)(((MessageForText.AtTroopMemberInfo)localObject).startPos - j));
        } while (((MessageForText.AtTroopMemberInfo)localObject).startPos >= 0);
        if (QLog.isColorLevel()) {
          QLog.e("SendMsgBtn", 2, " createTextMessageToshow error, at info starts with char 0");
        }
        localObject = null;
      }
    }
    else {
      return localObject;
    }
    return paramString.substring(j);
  }
  
  public static String a(List<ChatMessage> paramList, Map<String, String> paramMap)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramMap == null)) {
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i;
    int j;
    label42:
    StringBuilder localStringBuilder2;
    Object localObject2;
    Object localObject1;
    if (paramList.size() >= 4)
    {
      i = 4;
      j = 0;
      if (j >= i) {
        break label583;
      }
      localStringBuilder2 = new StringBuilder();
      localObject2 = (ChatMessage)paramList.get(j);
      localObject1 = (String)paramMap.get(acnh.c((MessageRecord)localObject2));
      if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        break label589;
      }
    }
    for (;;)
    {
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = anvx.a(2131701075);
        localStringBuilder2.append((String)localObject1);
        localStringBuilder2.append(": ");
        localStringBuilder2.append((String)localObject2);
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append("\r\n");
      }
      label234:
      label372:
      do
      {
        for (;;)
        {
          j += 1;
          break label42;
          i = paramList.size();
          break;
          if (!(localObject2 instanceof MessageForShortVideo)) {
            break label234;
          }
          localObject2 = anvx.a(2131701063);
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append((String)localObject2);
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder1.append("\r\n");
        }
        if ((localObject2 instanceof MessageForText))
        {
          localObject2 = (MessageForText)localObject2;
          if (((MessageForText)localObject2).sb != null)
          {
            localObject2 = ((MessageForText)localObject2).sb.toString();
            localStringBuilder2.append((String)localObject1);
            localStringBuilder2.append(": ");
            localStringBuilder2.append((String)localObject2);
            localObject2 = localStringBuilder2.toString();
            localObject1 = localObject2;
            if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject2)) {
              localObject1 = com.tencent.mobileqq.text.TextUtils.Symbol2FavoriteSymbol((String)localObject2);
            }
            if (((String)localObject1).length() <= 16) {
              break label372;
            }
            localStringBuilder1.append(((String)localObject1).substring(0, 16)).append("...");
          }
          for (;;)
          {
            localStringBuilder1.append("\r\n");
            break;
            localObject2 = ((MessageForText)localObject2).msg;
            break label269;
            localStringBuilder1.append((String)localObject1);
          }
        }
        if (((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForLongMsg)))
        {
          localStringBuilder2.append((String)localObject1);
          localStringBuilder2.append(": ");
          localStringBuilder2.append(MessageForMixedMsg.getTextFromMixedMsg((ChatMessage)localObject2));
          localObject1 = com.tencent.mobileqq.text.TextUtils.emoticonToText(localStringBuilder2.toString());
          if (((String)localObject1).length() > 16) {
            localStringBuilder1.append(((String)localObject1).substring(0, 16)).append("...");
          }
          for (;;)
          {
            localStringBuilder1.append("\r\n");
            break;
            localStringBuilder1.append((String)localObject1);
          }
        }
      } while (!(localObject2 instanceof MessageForStructing));
      label269:
      localObject2 = ((ChatMessage)localObject2).getSummaryMsg();
      localStringBuilder2.append((String)localObject1);
      localStringBuilder2.append(": ");
      localStringBuilder2.append((String)localObject2);
      if (((String)localObject2).length() > 16) {
        localStringBuilder1.append(((String)localObject2).substring(0, 16)).append("...");
      }
      for (;;)
      {
        localStringBuilder1.append("\r\n");
        break;
        localStringBuilder1.append((String)localObject2);
      }
      label583:
      return localStringBuilder1.toString();
      label589:
      localObject1 = " ";
    }
  }
  
  @NonNull
  private static ArrayList<String> a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramArrayList1.add(paramArrayList);
    paramadmo.f = true;
    return localArrayList;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo, boolean paramBoolean, int paramInt)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    Object localObject = anvx.a(2131701070);
    paramNewestFeedInfo.strTitle = paramNewestFeedInfo.strTitle.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    paramNewestFeedInfo.strSummary = paramNewestFeedInfo.strSummary.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    paramNewestFeedInfo.strContent = paramNewestFeedInfo.strContent.replaceAll("\\[em\\]e\\d{1,}\\[/em\\]", (String)localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appid", paramNewestFeedInfo.uAppid);
      ((JSONObject)localObject).put("title", paramNewestFeedInfo.strTitle);
      ((JSONObject)localObject).put("actionUrl", paramNewestFeedInfo.strJmpUrl);
      ((JSONObject)localObject).put("content", paramNewestFeedInfo.strContent);
      ((JSONObject)localObject).put("coverImageUrl", paramNewestFeedInfo.strImgUrl);
      ((JSONObject)localObject).put("fromuin", paramNewestFeedInfo.uHostUin);
      ((JSONObject)localObject).put("imageCount", paramNewestFeedInfo.uImgCount);
      ((JSONObject)localObject).put("lbsinfo", paramNewestFeedInfo.strLBSInfo);
      ((JSONObject)localObject).put("summery", paramNewestFeedInfo.strSummary);
      ((JSONObject)localObject).put("time", paramNewestFeedInfo.uTime);
      ((JSONObject)localObject).put("version", 2);
      ((JSONObject)localObject).put("likeNums", paramNewestFeedInfo.uLikeNum);
      ((JSONObject)localObject).put("commentNums", paramNewestFeedInfo.uCommentNum);
      ((JSONObject)localObject).put("isFirstMsgWithNewFriend", paramBoolean);
      ((JSONObject)localObject).put("iGender", paramInt);
      if ((paramNewestFeedInfo.mapEx != null) && (!paramNewestFeedInfo.mapEx.isEmpty())) {
        ((JSONObject)localObject).put("mapExt", new JSONObject(paramNewestFeedInfo.mapEx).toString());
      }
      if ((paramNewestFeedInfo.mediaData != null) && (paramNewestFeedInfo.mediaData.size() > 0))
      {
        JSONArray localJSONArray = new JSONArray();
        paramNewestFeedInfo = paramNewestFeedInfo.mediaData.iterator();
        while (paramNewestFeedInfo.hasNext())
        {
          Media_Data localMedia_Data = (Media_Data)paramNewestFeedInfo.next();
          MessageForQzoneFeed.MediaData localMediaData = new MessageForQzoneFeed.MediaData();
          localMediaData.uType = localMedia_Data.uType;
          localMediaData.strImgUrl = localMedia_Data.strImgUrl;
          localMediaData.extendInfo = localMedia_Data.extendInfo;
          localJSONArray.put(localMediaData.toJson());
        }
        ((JSONObject)localObject).put("mediaDatas", localJSONArray.toString());
      }
      return localObject;
    }
    catch (JSONException paramNewestFeedInfo) {}
    return null;
  }
  
  public static JSONObject a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    if (paramStFeed == null) {
      return null;
    }
    Object localObject1 = anvx.a(2131701070);
    paramStFeed.title.set(paramStFeed.title.get().replaceAll("\\[em\\]e\\d+\\[/em\\]", (String)localObject1));
    paramStFeed.content.set(paramStFeed.content.get().replaceAll("\\[em\\]e\\d+\\[/em\\]", (String)localObject1));
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("feedid", paramStFeed.id.get());
      ((JSONObject)localObject1).put("fromuin", paramStFeed.poster.id.get());
      ((JSONObject)localObject1).put("title", paramStFeed.title.get());
      ((JSONObject)localObject1).put("content", paramStFeed.content.get());
      ((JSONObject)localObject1).put("coverImageUrl", paramStFeed.cover.picUrl.get());
      ((JSONObject)localObject1).put("imageCount", paramStFeed.images.size());
      ((JSONObject)localObject1).put("likeCount", paramStFeed.likeInfo.count.get());
      ((JSONObject)localObject1).put("videoCount", paramStFeed.video.vecVideoUrl.get().size());
      ((JSONObject)localObject1).put("lbsinfo", paramStFeed.poiInfo.get());
      ((JSONObject)localObject1).put("time", paramStFeed.createTime.get());
      ((JSONObject)localObject1).put("type", paramStFeed.type.get());
      ((JSONObject)localObject1).put("version", 2);
      ((JSONObject)localObject1).put("isFirstMsgWithNewFriend", paramBoolean);
      Object localObject2 = new JSONArray();
      if (paramStFeed.type.get() == 2)
      {
        localObject3 = paramStFeed.images.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          FeedCloudMeta.StImage localStImage = (FeedCloudMeta.StImage)((Iterator)localObject3).next();
          MessageForQCircleFeed.MediaData localMediaData = new MessageForQCircleFeed.MediaData();
          localMediaData.mediaUrl = localStImage.picUrl.get();
          localMediaData.type = 2;
          ((JSONArray)localObject2).put(localMediaData.toJson());
        }
      }
      Object localObject3 = new MessageForQCircleFeed.MediaData();
      ((MessageForQCircleFeed.MediaData)localObject3).mediaUrl = paramStFeed.video.playUrl.get();
      ((MessageForQCircleFeed.MediaData)localObject3).type = 3;
      ((JSONArray)localObject2).put(((MessageForQCircleFeed.MediaData)localObject3).toJson());
      ((JSONObject)localObject1).put("mediaDatas", ((JSONArray)localObject2).toString());
      localObject2 = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject2).mergeFrom(paramStFeed.busiData.get().toByteArray());
        ((JSONObject)localObject1).put("pushCount", ((QQCircleFeedBase.StFeedBusiReqData)localObject2).pushList.totalClickCount.get());
        return localObject1;
      }
      catch (InvalidProtocolBufferMicroException paramStFeed)
      {
        for (;;)
        {
          paramStFeed.printStackTrace();
        }
      }
      return null;
    }
    catch (JSONException paramStFeed) {}
  }
  
  private static short a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, short paramShort, Random paramRandom)
  {
    if (paramBoolean)
    {
      int i = bcpt.a;
      bcpt.a = i + 1;
      paramShort = (short)(byte)i;
      i = 0;
      for (;;)
      {
        short s = paramShort;
        if (paramQQAppInterface.getMsgCache().a(paramQQAppInterface.getAccount(), paramSessionInfo.curType, paramShort))
        {
          if (i > 10) {
            s = (short)(byte)paramQQAppInterface.getMsgCache().a(paramQQAppInterface.getAccount(), paramSessionInfo.curType);
          }
        }
        else
        {
          paramQQAppInterface.getMsgCache().a(paramQQAppInterface.getAccount(), paramSessionInfo.curType, s);
          return s;
        }
        paramShort = (short)(byte)Math.abs(paramRandom.nextInt());
        i += 1;
      }
    }
    return paramShort;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "go to dismissActionSheet()!");
    }
    if ((jdField_a_of_type_Bkzi != null) && (jdField_a_of_type_Bkzi.isShowing())) {}
    try
    {
      jdField_a_of_type_Bkzi.dismiss();
      jdField_a_of_type_Bkzi = null;
      if ((b == null) || (!b.isShowing())) {}
    }
    catch (Exception localException1)
    {
      try
      {
        b.dismiss();
        b = null;
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
  
  private static void a(int paramInt, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    ((afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramInt);
    k(paramQQAppInterface, paramSessionInfo);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Bundle paramBundle)
  {
    paramString4 = nwn.a(paramString4, 45, "UTF-8", "...");
    paramString5 = nwn.a(paramString5, 90, "UTF-8", "...");
    if (!paramContext.getResources().getString(2131695829).equals(paramString4))
    {
      paramString3 = paramContext.getResources().getString(2131691256) + " " + paramString4;
      paramString6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramString3 = new bdnr(StructMsgForGeneralShare.class).c(32).a(paramString3).d("").a("plugin", "", paramString6, "", "").a();
      paramString6 = bdoe.a(2);
      paramString6.a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramString3.addItem(paramString6);
      if ((paramSessionInfo == null) || (paramSessionInfo.curType != 1008) || (!(paramContext instanceof FragmentActivity))) {
        break label521;
      }
      paramContext = ((FragmentActivity)paramContext).getChatFragment();
      if (paramContext == null) {
        break label521;
      }
      paramContext = paramContext.a();
      if ((paramContext == null) || (paramContext.sessionInfo == null) || (!(paramContext instanceof aido))) {
        break label521;
      }
    }
    label521:
    for (boolean bool = ((aido)paramContext).A;; bool = false)
    {
      if ((paramSessionInfo != null) && ((paramSessionInfo.curType == 1025) || (paramSessionInfo.curType == 1024) || ((paramSessionInfo.curType == 0) && (nut.b(paramSessionInfo.curFriendUin))) || (bool)))
      {
        paramContext = bcsa.a(-1000);
        l = bcrg.a();
        i = paramSessionInfo.curType;
        paramString1 = admg.jdField_a_of_type_JavaLangString + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
        paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin, paramQQAppInterface.getCurrentAccountUin(), paramString1, l, -1000, i, l);
        paramContext.issend = 1;
        paramQQAppInterface.getMessageFacade().addAndSendMessage(paramContext, null);
      }
      while (paramSessionInfo == null)
      {
        long l;
        int i;
        return;
        paramString3 = paramContext.getResources().getString(2131691256);
        break;
      }
      if (paramBundle != null) {
        paramString3.forwardID = paramBundle.getInt("KEY_MSG_FORWARD_ID");
      }
      if (a(paramSessionInfo, paramString5, paramBundle))
      {
        a(paramQQAppInterface, paramSessionInfo, paramString1, paramString2, paramString4, paramString5, paramString3, paramString7, paramString8, paramString9);
        return;
      }
      a(paramQQAppInterface, paramSessionInfo, paramString3);
      return;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    b(paramQQAppInterface, paramChatMessage);
    if ((((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) && (((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
    {
      ((FragmentActivity)paramContext).getChatFragment().a().startDelAnimAndDelMsg(paramChatMessage);
      if ((paramChatMessage instanceof MessageForArkApp)) {
        apzo.a().a(paramChatMessage.uniseq);
      }
      if (((StructLongMessageDownloadProcessor.isPALongMsg(paramChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(paramChatMessage))) && ((paramChatMessage instanceof MessageForStructing))) {
        StructLongMessageDownloadProcessor.deleteTask(paramQQAppInterface, ((MessageForStructing)paramChatMessage).uniseq);
      }
      if ((paramChatMessage instanceof MessageForApollo))
      {
        MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
        if (localMessageForApollo != null)
        {
          ancb.a(localMessageForApollo.uniseq, paramQQAppInterface, "del_msg");
          if ((localMessageForApollo.mApolloMessage != null) && ((paramContext instanceof FragmentActivity)))
          {
            paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
            if ((paramContext != null) && (paramContext.sessionInfo != null)) {
              VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "del_success", ApolloUtil.b(paramContext.sessionInfo.curType), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForFile))
      {
        paramContext = auea.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
        paramQQAppInterface.getFileManagerEngine().b(paramContext.nSessionId);
        bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
      }
      if ((paramChatMessage instanceof MessageForLightVideo)) {
        awel.a(paramQQAppInterface, paramChatMessage);
      }
      paramContext = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramContext + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
      if (android.text.TextUtils.isEmpty(paramContext)) {}
    }
    try
    {
      long l = Long.parseLong(paramContext);
      paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
      ((bhou)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramChatMessage);
      return;
      ThreadManager.post(new ChatActivityFacade.16(paramQQAppInterface, paramChatMessage), 8, null, true);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        QLog.e("ChatActivityFacade", 1, paramContext.toString());
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, List<ChatMessage> paramList)
  {
    paramQQAppInterface = new ChatActivityFacade.18(paramContext, paramList, paramQQAppInterface);
    paramList = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramList.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramList.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void a(bhjq parambhjq, Context paramContext, int paramInt)
  {
    if ((!AppSetting.i) && (paramInt == 0)) {}
    while (acnh.a(paramInt) == 1032) {
      return;
    }
    parambhjq.a(2131365475, paramContext.getString(2131690756), 2130838986);
  }
  
  public static void a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramSessionInfo.curFriendUin;
    boolean bool = paramSessionInfo.curFriendUin.equals(paramQQAppInterface.getCurrentAccountUin());
    bdla.b(paramQQAppInterface, "dc00898", "", "", "0X800A2CE", "0X800A2CE", 0, 0, ChatActivityUtils.b(paramSessionInfo.curType), "", "", "");
    Object localObject;
    int i;
    label171:
    Intent localIntent;
    if (bool)
    {
      localObject = new ProfileActivity.AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
      i = 0;
      if (i == 0)
      {
        if (android.text.TextUtils.isEmpty(((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString)) {
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramSessionInfo.curFriendNick;
        }
        ((ProfileActivity.AllInOne)localObject).a = aaqo.a(paramSessionInfo);
        ((ProfileActivity.AllInOne)localObject).f = paramSessionInfo.curFriendUin;
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_Int = paramSessionInfo.curType;
        if ((paramSessionInfo.curType == 1000) || (paramSessionInfo.curType == 1020)) {
          ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = paramSessionInfo.troopUin;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 2;
        if (paramSessionInfo.curType != 0) {
          break label951;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 1;
        if ((paramSessionInfo.curType != 1001) && (paramSessionInfo.curType != 1010) && (paramSessionInfo.curType != 10002)) {
          break label1018;
        }
        localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
        if (paramSessionInfo.curType != 1001) {
          break label961;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 10;
        localIntent.putExtra("frome_where", 21);
        label242:
        ((ProfileActivity.AllInOne)localObject).a = aaqo.a(paramSessionInfo);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!bhbx.a(paramQQAppInterface.getCurrentAccountUin(), str)) {
          break label1005;
        }
        localIntent.putExtra("param_mode", 2);
      }
    }
    for (;;)
    {
      paramActivity.startActivityForResult(localIntent, 9009);
      return;
      if (paramSessionInfo.curType == 1024)
      {
        nwu.a(paramActivity, null, paramSessionInfo.curFriendUin, true, -1, true, 2000);
        i = 1;
        localObject = null;
        break;
      }
      if (paramSessionInfo.curType == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 10004)
      {
        localObject = new ProfileActivity.AllInOne(str, 94);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 0)
      {
        localObject = new ProfileActivity.AllInOne(str, 70);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1000)
      {
        localObject = new ProfileActivity.AllInOne(str, 22);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1020)
      {
        localObject = new ProfileActivity.AllInOne(str, 58);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1004)
      {
        localObject = new ProfileActivity.AllInOne(str, 47);
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = paramSessionInfo.troopUin;
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1005)
      {
        localObject = new ProfileActivity.AllInOne(str, 2);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1023)
      {
        localObject = new ProfileActivity.AllInOne(str, 74);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1006)
      {
        localObject = new ProfileActivity.AllInOne(str, 34);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1009)
      {
        localObject = new ProfileActivity.AllInOne(str, 57);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1021)
      {
        localObject = new ProfileActivity.AllInOne(str, 72);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1022)
      {
        localObject = new ProfileActivity.AllInOne(str, 27);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 1025)
      {
        localObject = new Intent(paramActivity, ChatSettingActivity.class);
        ((Intent)localObject).putExtra("uin", paramSessionInfo.curFriendUin);
        ((Intent)localObject).putExtra("uinname", paramSessionInfo.curFriendNick);
        ((Intent)localObject).putExtra("uintype", paramSessionInfo.curType);
        paramActivity.startActivity((Intent)localObject);
        i = 1;
        localObject = null;
        break;
      }
      if ((paramSessionInfo.curType == 1037) || (paramSessionInfo.curType == 1044) || (paramSessionInfo.curType == 1045))
      {
        localObject = new ProfileActivity.AllInOne(str, 96);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 10008)
      {
        localObject = new ProfileActivity.AllInOne(str, 115);
        i = 0;
        break;
      }
      if (paramSessionInfo.curType == 10010)
      {
        localObject = new ProfileActivity.AllInOne(str, 117);
        i = 0;
        break;
      }
      localObject = new ProfileActivity.AllInOne(str, 19);
      i = 0;
      break;
      label951:
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 106;
      break label171;
      label961:
      if (paramSessionInfo.curType == 1010)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 11;
        break label242;
      }
      if (paramSessionInfo.curType != 10002) {
        break label242;
      }
      localIntent.putExtra("frome_where", 22);
      break label242;
      label1005:
      localIntent.putExtra("param_mode", 3);
    }
    label1018:
    if (aweo.a(paramSessionInfo))
    {
      i = 0;
      if (paramSessionInfo.entrance == 20) {
        i = 1;
      }
      ProfileActivity.a(paramActivity, (ProfileActivity.AllInOne)localObject, i, 3);
      return;
    }
    ProfileActivity.b(paramActivity, (ProfileActivity.AllInOne)localObject);
  }
  
  public static void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBaseChatPie != null)
    {
      if (paramQQAppInterface != null) {
        break label27;
      }
      i = 1;
      if (paramSessionInfo != null) {
        break label33;
      }
      label18:
      if ((j | i) == 0) {
        break label39;
      }
    }
    label396:
    for (;;)
    {
      return;
      label27:
      i = 0;
      break;
      label33:
      j = 0;
      break label18;
      label39:
      if ((paramBaseChatPie instanceof agab)) {}
      for (paramBaseChatPie = (agab)paramBaseChatPie;; paramBaseChatPie = null)
      {
        if (paramBaseChatPie == null) {
          break label396;
        }
        bhyh localbhyh = bhyh.a();
        i = paramSessionInfo.curType;
        boolean bool1 = localbhyh.a(paramQQAppInterface);
        boolean bool2 = localbhyh.b(paramQQAppInterface);
        boolean bool3 = localbhyh.a(paramQQAppInterface, paramSessionInfo.curFriendUin);
        if ((i != 0) || (!bool1) || (!bool2) || (!bool3)) {
          break;
        }
        Object localObject = paramQQAppInterface.getApp().getSharedPreferences(bhyh.jdField_a_of_type_JavaLangString, 0);
        if (!paramBoolean)
        {
          long l1 = localbhyh.a(paramQQAppInterface);
          long l2 = ((SharedPreferences)localObject).getLong(bhyh.jdField_b_of_type_JavaLangString + paramSessionInfo.curFriendUin, 0L);
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 > l1)) {
            break label271;
          }
        }
        label271:
        aogl localaogl;
        do
        {
          localObject = localbhyh.a(paramQQAppInterface);
          if ((!localbhyh.c(paramQQAppInterface)) || (android.text.TextUtils.isEmpty((CharSequence)localObject)) || (!paramBaseChatPie.jdField_b_of_type_Boolean)) {
            break;
          }
          localbhyh.a(paramQQAppInterface, 0);
          acnh.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.curType, -4022);
          paramQQAppInterface.getFileManagerDataCenter().a(paramSessionInfo.curFriendUin, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curType, -4022, (String)localObject);
          return;
          localaogl = (aogl)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIP_AIO_SEND_HANDLER);
        } while (localaogl == null);
        paramBaseChatPie = new AIOSendReq();
        paramBaseChatPie.iSend = 0;
        paramBaseChatPie.sAid = "";
        paramBaseChatPie.sUin = paramQQAppInterface.getCurrentAccountUin();
        paramBaseChatPie.sFriendUin = paramSessionInfo.curFriendUin;
        localaogl.a(paramBaseChatPie);
        paramBaseChatPie = ((SharedPreferences)localObject).edit();
        paramBaseChatPie.putLong(bhyh.jdField_b_of_type_JavaLangString + paramSessionInfo.curFriendUin, System.currentTimeMillis());
        if (Build.VERSION.SDK_INT <= 8)
        {
          paramBaseChatPie.commit();
          return;
        }
        paramBaseChatPie.apply();
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (bdnl.a(paramString2) >= 1))
    {
      bdnl.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new TransferRequest();
    paramBundle.mSelfUin = paramQQAppInterface.getAccount();
    paramBundle.mPeerUin = paramString1;
    paramBundle.mUinType = paramInt1;
    paramBundle.mFileType = 2;
    paramBundle.mUniseq = paramLong1;
    paramBundle.mIsUp = true;
    paramBundle.mLocalPath = paramString2;
    paramBundle.mBusiType = 1002;
    paramBundle.mPttCompressFinish = paramBoolean3;
    paramBundle.mPttUploadPanel = paramInt5;
    paramBundle.mRec = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramString1, paramInt1, paramLong1);
    if ((paramInt1 == 1026) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder().append("uploadPtt,");
      if (paramBundle.mRec != null) {
        break label246;
      }
    }
    label246:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.mRec instanceof MessageForPtt))
      {
        paramString1 = (MessageForPtt)paramBundle.mRec;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
      }
      paramQQAppInterface.getTransFileController().transferAsync(paramBundle);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, int paramInt6)
  {
    a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramLong1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramLong2, paramBundle, paramArrayList, paramString3, paramBoolean4, null, paramInt6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord, int paramInt6)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (bdnl.a(paramString2) >= 1))
    {
      bdnl.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new TransferRequest();
    paramBundle.mSelfUin = paramQQAppInterface.getAccount();
    paramBundle.mPeerUin = paramString1;
    paramBundle.mUinType = paramInt1;
    paramBundle.mFileType = 2;
    paramBundle.mUniseq = paramLong1;
    paramBundle.mIsUp = true;
    paramBundle.mLocalPath = paramString2;
    paramBundle.mBusiType = 1002;
    paramBundle.mPttCompressFinish = paramBoolean3;
    paramBundle.mPttUploadPanel = paramInt5;
    if (paramMessageRecord != null)
    {
      paramBundle.mRec = paramMessageRecord;
      if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean4) && (paramBundle.mRec != null))
      {
        paramBundle.mRec.atInfoList = paramArrayList;
        paramBundle.mRec.mRobotFlag = 1;
        new bdlf(paramQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_msg_suc").a(new String[] { paramString1, String.valueOf(((MessageForText.AtTroopMemberInfo)paramArrayList.get(0)).uin) }).a();
      }
      if ((paramInt1 == 1026) && (QLog.isColorLevel()))
      {
        paramString2 = new StringBuilder().append("uploadPtt,");
        if (paramBundle.mRec != null) {
          break label382;
        }
      }
    }
    label382:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.mRec instanceof MessageForPtt))
      {
        paramString1 = (MessageForPtt)paramBundle.mRec;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
        paramString1.mInputContent = paramString3;
        paramString1.autoToText = paramInt6;
      }
      paramQQAppInterface.getTransFileController().transferAsync(paramBundle);
      return;
      paramBundle.mRec = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramString1, paramInt1, paramLong1);
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (1024 == paramSessionInfo.curType) {}
    int i;
    do
    {
      return;
      i = ((anri)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.curFriendUin + " settingValue:" + i);
      }
    } while ((i != 0) && (i != 3));
    String str;
    if (i == 0)
    {
      i = -7006;
      str = "single_way_friend_add_allow_list";
      label93:
      if (ChatActivityUtils.a(paramContext, paramSessionInfo, str)) {
        break label297;
      }
      Iterator localIterator = paramQQAppInterface.getMessageFacade().getMsgList(paramSessionInfo.curFriendUin, 0).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((MessageRecord)localIterator.next()).msgtype != i);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.curFriendUin + " hasInserted:" + bool);
      }
      if (bool) {
        break;
      }
      ChatActivityUtils.b(paramContext, paramSessionInfo, str);
      paramContext = (MessageForGrayTips)bcsa.a(i);
      long l = bcrg.a() + 1L;
      paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin, paramSessionInfo.curFriendUin, "", l, i, paramSessionInfo.curType, l);
      paramContext.setTextGravity(17);
      paramContext.isread = true;
      if (anyv.a(paramQQAppInterface, paramContext, false)) {
        break;
      }
      paramQQAppInterface.getMessageFacade().addMessage(paramContext, paramContext.selfuin);
      return;
      i = -2019;
      str = "single_way_friend_list";
      break label93;
      label297:
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    paramContext = new MessageForPokeEmo();
    paramContext.msgtype = -5018;
    paramContext.isNeedPlayed = false;
    paramContext.pokeemoId = paramInt1;
    paramContext.pokeemoPressCount = paramInt2;
    paramContext.summary = aigs.a(paramInt1);
    paramContext.initMsg();
    bcsa.a(paramQQAppInterface, paramContext, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType);
    paramQQAppInterface.getMessageFacade().addAndSendMessage(paramContext, null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, String.format(" sendPokeEmoMsg.pokeemoID = %d,count = %d,summary = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt1, paramInt2, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    if (!ahcw.a(paramQQAppInterface, paramSessionInfo))
    {
      if (jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null)
      {
        jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(paramContext, 2131689969, 0);
        ahcs.a().a(3);
        ahcs.a().a(6);
        ahcs.a().a(12);
        ahcs.a().a(15);
        ahcs.a().a(18);
        ahcs.a().a(9);
      }
      if (!jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()) {
        jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      }
      return;
    }
    paramContext = new MessageForPoke();
    paramContext.msgtype = -5012;
    paramContext.isPlayed = false;
    paramContext.interactType = paramInt1;
    paramContext.subId = paramInt2;
    paramContext.name = paramString1;
    paramContext.minVersion = paramString2;
    paramContext.strength = ahcs.a().a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramContext.interactType, paramInt3, -1);
    if ((paramInt3 == 3) || (paramInt3 == 4))
    {
      paramInt2 = paramContext.flag;
      if (paramInt3 != 3) {
        break label317;
      }
    }
    label317:
    for (paramInt1 = 8;; paramInt1 = 16)
    {
      paramContext.flag = (paramInt1 | paramInt2);
      paramContext.isPlayed = true;
      bcsa.a(paramQQAppInterface, paramContext, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType);
      paramContext.initMsg();
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "sendPokeMsg strength:" + paramContext.strength + "." + paramContext);
      }
      paramQQAppInterface.getMessageFacade().addAndSendMessage(paramContext, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PokeMsg", 2, "sendPokeMsg type:" + paramContext.interactType + "." + paramContext);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      paramQQAppInterface.getTransFileController().removeProcessor(paramQQAppInterface.getTransFileController().makeKey(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
    paramContext = bcsa.a(paramContext);
    paramQQAppInterface.getMessageFacade().addAndSendMessage(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, int paramInt)
  {
    boolean bool1 = paramIntent.getBooleanExtra("not_forward", false);
    boolean bool2 = paramIntent.getBooleanExtra("support_multi_forward", false);
    if ((!bool1) && (!bool2)) {
      return;
    }
    if (paramForwardFileInfo.a <= 0) {}
    for (;;)
    {
      paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(paramSessionInfo.curFriendUin), paramSessionInfo.curType, paramForwardFileInfo.a(), paramForwardFileInfo.c(), paramInt);
      if (!paramIntent.getBooleanExtra("not_forward", false)) {
        break;
      }
      paramIntent.removeExtra("not_forward");
      paramIntent.getExtras().remove("not_forward");
      return;
      paramInt = paramForwardFileInfo.a;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramBoolean, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    if ((paramInt <= 0) && (paramForwardFileInfo != null)) {}
    for (int i = paramForwardFileInfo.a;; i = paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatActivityFacade", 1, "forwardForFile");
      }
      if (ForwardUtils.handleForwardEditedPhoto(paramIntent, paramSessionInfo, paramString, paramQQAppInterface)) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "handleForwardEditedPhoto = " + paramString);
        }
      }
      label1332:
      for (;;)
      {
        return;
        if ((paramForwardFileInfo != null) && (paramForwardFileInfo.b() == 10006) && (android.text.TextUtils.isEmpty(paramForwardFileInfo.a())))
        {
          a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramInt);
          return;
        }
        if ((!paramIntent.getBooleanExtra("isFromFavorites", false)) && (paramIntent.getBooleanExtra("isFromShare", false)))
        {
          if (!paramIntent.getBooleanExtra("sendMultiple", false))
          {
            if (paramSessionInfo.curType == 1)
            {
              paramQQAppInterface.getFileManagerEngine().a(paramString, paramSessionInfo.curFriendUin, 0L, i);
              return;
            }
            paramQQAppInterface.getFileManagerEngine().a(paramString, paramSessionInfo.troopUin, paramSessionInfo.curFriendUin, paramSessionInfo.curType, true, 0L, i);
          }
        }
        else if (paramIntent.getBooleanExtra("not_forward", false))
        {
          paramString = null;
          if (paramForwardFileInfo != null) {
            paramString = paramQQAppInterface.getFileManagerDataCenter().b(paramForwardFileInfo.b());
          }
          String str = paramString;
          if (paramString == null)
          {
            paramString = bmaf.a(paramIntent.getExtras(), paramSessionInfo.curFriendUin, paramSessionInfo.curType);
            str = paramString;
            if (paramString != null)
            {
              paramForwardFileInfo.b(paramString.nSessionId);
              str = paramString;
            }
          }
          if ((str == null) && (QLog.isColorLevel())) {
            QLog.e("ChatActivityFacade", 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.b() + "]");
          }
          switch (paramForwardFileInfo.b())
          {
          }
          for (;;)
          {
            if ((paramBoolean) || (!paramIntent.getBooleanExtra("not_forward", false))) {
              break label1332;
            }
            paramIntent.removeExtra("not_forward");
            paramIntent.getExtras().remove("not_forward");
            return;
            if (paramSessionInfo.curType == 1)
            {
              paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.curFriendUin, paramForwardFileInfo.c(), i);
            }
            else
            {
              paramQQAppInterface = paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.troopUin, paramSessionInfo.curFriendUin, paramSessionInfo.curType, true, paramForwardFileInfo.c(), i);
              if (str != null)
              {
                paramQQAppInterface.lastSuccessTime = str.lastSuccessTime;
                continue;
                if (paramSessionInfo.curType == 1)
                {
                  paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramSessionInfo.curFriendUin);
                }
                else if (paramSessionInfo.curType == 0)
                {
                  paramQQAppInterface.getFileManagerEngine().b(paramForwardFileInfo.b(), paramSessionInfo.curFriendUin);
                }
                else if (paramSessionInfo.curType == 3000)
                {
                  paramQQAppInterface.getFileManagerEngine().c(paramForwardFileInfo.b(), paramSessionInfo.curFriendUin);
                  continue;
                  if (paramSessionInfo.curType == 1)
                  {
                    if (FileUtil.fileExistsAndNotEmpty(paramForwardFileInfo.a()))
                    {
                      paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.curFriendUin);
                    }
                    else
                    {
                      paramForwardFileInfo.b();
                      paramContext = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                      if ((paramContext != null) && (paramContext.peerType == 3000))
                      {
                        paramSessionInfo = paramQQAppInterface.getFileManagerEngine().a(paramContext, paramSessionInfo.troopUin, paramSessionInfo.curFriendUin, paramContext.peerType, false);
                        paramSessionInfo.selfUin = paramContext.peerUin;
                        paramQQAppInterface.getFileManagerEngine().a(paramSessionInfo, 27, paramForwardFileInfo.c(), i);
                      }
                      else
                      {
                        paramQQAppInterface.getFileManagerEngine().a(3, paramForwardFileInfo.b(), paramSessionInfo.curFriendUin, paramForwardFileInfo.c(), i);
                      }
                    }
                  }
                  else
                  {
                    paramString = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                    if ((paramString != null) && (paramString.status == 16))
                    {
                      if (paramContext == null) {
                        break;
                      }
                      auea.c(paramContext.getResources().getString(2131692622));
                      return;
                    }
                    paramContext = paramQQAppInterface.getCurrentAccountUin();
                    if ((paramSessionInfo.curType == 1004) || (paramSessionInfo.curType == 1000)) {
                      paramContext = paramSessionInfo.troopUin;
                    }
                    if ((paramString != null) && (paramString.peerType == 3000))
                    {
                      paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.curFriendUin, paramSessionInfo.curType, true, paramForwardFileInfo.c(), i);
                      paramContext.selfUin = paramString.peerUin;
                      if ((paramSessionInfo.curType == 0) || (paramSessionInfo.curType == 1006) || (paramSessionInfo.curType == 1004) || (paramSessionInfo.curType == 1000) || (paramSessionInfo.curType == 1001) || (paramSessionInfo.curType == 10002) || (paramSessionInfo.curType == 1006))
                      {
                        paramContext.nOpType = 21;
                        paramQQAppInterface.getFileManagerEngine().a(paramContext, 21);
                      }
                      for (;;)
                      {
                        paramQQAppInterface.getFileManagerDataCenter().c(paramContext);
                        break;
                        if (paramSessionInfo.curType == 3000)
                        {
                          paramContext.nOpType = 22;
                          paramQQAppInterface.getFileManagerEngine().a(paramContext, 22);
                        }
                      }
                    }
                    paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.curFriendUin, paramSessionInfo.curType, true, paramForwardFileInfo.c(), i);
                    if (paramSessionInfo.curType == 3000) {
                      paramContext.nOpType = 28;
                    }
                    paramQQAppInterface.getFileManagerEngine().a(paramContext);
                    paramQQAppInterface.getFileManagerDataCenter().c(paramContext);
                    continue;
                    paramContext = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                    paramQQAppInterface.getFileManagerEngine().b(paramContext, paramSessionInfo.troopUin, paramSessionInfo.curFriendUin, paramSessionInfo.curType, i);
                    continue;
                    if (paramSessionInfo.curType == 1)
                    {
                      if (FileUtil.fileExistsAndNotEmpty(paramForwardFileInfo.a()))
                      {
                        paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.a(), paramSessionInfo.curFriendUin, 0L, i);
                      }
                      else
                      {
                        paramString = paramQQAppInterface.getFileManagerDataCenter().a(paramForwardFileInfo.b());
                        paramContext = paramQQAppInterface.getCurrentAccountUin();
                        if ((paramSessionInfo.curType == 1004) || (paramSessionInfo.curType == 1000)) {
                          paramContext = paramSessionInfo.troopUin;
                        }
                        if ((paramString != null) && (paramString.peerType == 3000))
                        {
                          paramContext = paramQQAppInterface.getFileManagerEngine().a(paramString, paramContext, paramSessionInfo.curFriendUin, paramString.peerType, false);
                          paramContext.selfUin = paramString.peerUin;
                          paramQQAppInterface.getFileManagerEngine().a(paramContext, 27);
                        }
                        else
                        {
                          paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramSessionInfo.curFriendUin, i);
                        }
                      }
                    }
                    else
                    {
                      paramQQAppInterface.getFileManagerEngine().a(paramForwardFileInfo.b(), paramSessionInfo.troopUin, paramSessionInfo.curFriendUin, paramSessionInfo.curType, true, i);
                      continue;
                      paramQQAppInterface.getFileManagerEngine().a(str, paramSessionInfo.curFriendUin, paramSessionInfo.curType, i);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, annl paramannl)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +50 -> 51
    //   4: aload_3
    //   5: ifnull +46 -> 51
    //   8: aload_3
    //   9: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   12: ifnull +39 -> 51
    //   15: aload_3
    //   16: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   19: getfield 2519	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   22: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +26 -> 51
    //   28: aload_3
    //   29: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   32: getfield 2522	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   35: ifle +17 -> 52
    //   38: aload_3
    //   39: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   42: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   45: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +4 -> 52
    //   51: return
    //   52: iconst_0
    //   53: istore 5
    //   55: iconst_0
    //   56: istore 4
    //   58: aload_0
    //   59: getstatic 222	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   62: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   65: checkcast 43	anvk
    //   68: astore 7
    //   70: aload_0
    //   71: getstatic 2526	com/tencent/mobileqq/app/QQManagerFactory:APOLLO_MANAGER	I
    //   74: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   77: checkcast 2528	amme
    //   80: astore 10
    //   82: aload_0
    //   83: getstatic 2531	com/tencent/mobileqq/app/BusinessHandlerFactory:VAS_EXTENSION_HANDLER	I
    //   86: invokevirtual 652	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   89: checkcast 2533	com/tencent/mobileqq/vas/VasExtensionHandler
    //   92: astore_1
    //   93: aload_2
    //   94: getfield 62	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   97: iconst_1
    //   98: if_icmpne +60 -> 158
    //   101: aload_3
    //   102: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   105: getfield 2522	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   108: ifle +50 -> 158
    //   111: aload_3
    //   112: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   115: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   118: aload_0
    //   119: invokevirtual 91	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   122: invokevirtual 1592	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +33 -> 158
    //   128: aload 10
    //   130: aload_3
    //   131: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   134: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   137: invokevirtual 2536	amme:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   140: astore 8
    //   142: aload 8
    //   144: ifnonnull +862 -> 1006
    //   147: aload_1
    //   148: aload_3
    //   149: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   152: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   155: invokevirtual 2538	com/tencent/mobileqq/vas/VasExtensionHandler:b	(Ljava/lang/String;)V
    //   158: aload_3
    //   159: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   162: getfield 2541	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   165: invokestatic 2544	com/tencent/mobileqq/data/ApolloActionData:isAction3DModel	(I)Z
    //   168: istore 6
    //   170: ldc_w 601
    //   173: iconst_1
    //   174: iconst_4
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: ldc_w 2546
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload_3
    //   187: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   190: getfield 2541	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   193: invokestatic 988	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: ldc_w 2548
    //   202: aastore
    //   203: dup
    //   204: iconst_3
    //   205: iload 6
    //   207: invokestatic 2553	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   210: aastore
    //   211: invokestatic 2556	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   214: new 1732	com/tencent/mobileqq/data/ApolloMessage
    //   217: dup
    //   218: invokespecial 2557	com/tencent/mobileqq/data/ApolloMessage:<init>	()V
    //   221: astore 9
    //   223: iload 6
    //   225: ifeq +982 -> 1207
    //   228: aload_3
    //   229: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   232: getfield 2522	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   235: ifle +910 -> 1145
    //   238: aload 9
    //   240: sipush 1454
    //   243: putfield 1734	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   246: new 2559	com/tencent/mobileqq/data/Apollo3DMessage
    //   249: dup
    //   250: invokespecial 2560	com/tencent/mobileqq/data/Apollo3DMessage:<init>	()V
    //   253: astore 7
    //   255: aload 7
    //   257: aload_3
    //   258: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   261: getfield 2541	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   264: putfield 2563	com/tencent/mobileqq/data/Apollo3DMessage:actionID_3D	I
    //   267: aload 7
    //   269: aload_3
    //   270: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   273: getfield 2566	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   276: putfield 2569	com/tencent/mobileqq/data/Apollo3DMessage:actionType_3D	I
    //   279: aload 7
    //   281: aload_3
    //   282: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   285: getfield 2519	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   288: putfield 2572	com/tencent/mobileqq/data/Apollo3DMessage:actionName_3D	Ljava/lang/String;
    //   291: aload_0
    //   292: getstatic 2575	com/tencent/mobileqq/app/QQManagerFactory:APOOLO_DAO_MANAGER	I
    //   295: invokevirtual 226	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   298: checkcast 2577	ankc
    //   301: aload 9
    //   303: getfield 1734	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   306: invokevirtual 2580	ankc:a	(I)Lcom/tencent/mobileqq/data/ApolloActionData;
    //   309: astore_1
    //   310: aload_1
    //   311: ifnull +872 -> 1183
    //   314: aload_1
    //   315: getfield 2519	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   318: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   321: ifne +862 -> 1183
    //   324: aload 9
    //   326: aload_1
    //   327: getfield 2519	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   330: ldc_w 1584
    //   333: invokevirtual 75	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   336: putfield 2583	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   339: sipush 1024
    //   342: istore 4
    //   344: aload_3
    //   345: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   348: getfield 2586	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   351: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +36 -> 390
    //   357: aload_2
    //   358: getfield 62	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   361: iconst_1
    //   362: if_icmpeq +13 -> 375
    //   365: aload_2
    //   366: getfield 62	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   369: sipush 3000
    //   372: if_icmpne +18 -> 390
    //   375: aload 9
    //   377: aload_3
    //   378: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   381: getfield 2586	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   384: invokevirtual 2588	java/lang/String:getBytes	()[B
    //   387: putfield 2591	com/tencent/mobileqq/data/ApolloMessage:text	[B
    //   390: aload 10
    //   392: aload_0
    //   393: invokevirtual 91	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   396: invokevirtual 2536	amme:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   399: astore 8
    //   401: aload 9
    //   403: aload 8
    //   405: getfield 2596	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   408: invokestatic 2598	bhbx:a	(J)I
    //   411: i2l
    //   412: putfield 2601	com/tencent/mobileqq/data/ApolloMessage:sender_ts	J
    //   415: aload 9
    //   417: aload 8
    //   419: getfield 2604	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   422: putfield 2607	com/tencent/mobileqq/data/ApolloMessage:sender_status	I
    //   425: iload 6
    //   427: ifeq +18 -> 445
    //   430: aload 7
    //   432: ifnull +13 -> 445
    //   435: aload 7
    //   437: aload 8
    //   439: getfield 2610	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   442: putfield 2613	com/tencent/mobileqq/data/Apollo3DMessage:senderStatus_3D	I
    //   445: iload 4
    //   447: iconst_1
    //   448: ior
    //   449: bipush 8
    //   451: ior
    //   452: bipush 32
    //   454: ior
    //   455: istore 4
    //   457: aload_3
    //   458: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   461: getfield 2522	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   464: ifle +926 -> 1390
    //   467: aload 9
    //   469: aload_3
    //   470: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   473: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   476: invokestatic 2616	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   479: invokevirtual 2619	java/lang/Long:longValue	()J
    //   482: putfield 2622	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   485: aload 10
    //   487: aload_3
    //   488: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   491: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   494: invokevirtual 2536	amme:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   497: astore 8
    //   499: aload 9
    //   501: aload 8
    //   503: getfield 2596	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   506: invokestatic 2598	bhbx:a	(J)I
    //   509: i2l
    //   510: putfield 2625	com/tencent/mobileqq/data/ApolloMessage:peer_ts	J
    //   513: aload 9
    //   515: aload 8
    //   517: getfield 2604	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   520: putfield 2628	com/tencent/mobileqq/data/ApolloMessage:peer_status	I
    //   523: iload 6
    //   525: ifeq +18 -> 543
    //   528: aload 7
    //   530: ifnull +13 -> 543
    //   533: aload 7
    //   535: aload 8
    //   537: getfield 2610	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   540: putfield 2631	com/tencent/mobileqq/data/Apollo3DMessage:peerStatus_3D	I
    //   543: iload 4
    //   545: iconst_4
    //   546: ior
    //   547: iconst_2
    //   548: ior
    //   549: bipush 16
    //   551: ior
    //   552: bipush 64
    //   554: ior
    //   555: istore 5
    //   557: iload 5
    //   559: istore 4
    //   561: iload 6
    //   563: ifeq +11 -> 574
    //   566: iload 5
    //   568: sipush 2048
    //   571: ior
    //   572: istore 4
    //   574: aload_3
    //   575: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   578: getfield 2522	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   581: ifne +28 -> 609
    //   584: aload_2
    //   585: getfield 62	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   588: ifne +21 -> 609
    //   591: aload 9
    //   593: aload_3
    //   594: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   597: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   600: invokestatic 2616	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   603: invokevirtual 2619	java/lang/Long:longValue	()J
    //   606: putfield 2622	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   609: iload 4
    //   611: istore 5
    //   613: aload_3
    //   614: getfield 2632	annl:jdField_d_of_type_Int	I
    //   617: iconst_1
    //   618: if_icmpne +11 -> 629
    //   621: iload 4
    //   623: sipush 128
    //   626: ior
    //   627: istore 5
    //   629: aload 9
    //   631: iload 5
    //   633: putfield 2633	com/tencent/mobileqq/data/ApolloMessage:flag	I
    //   636: aconst_null
    //   637: astore 8
    //   639: new 693	java/util/ArrayList
    //   642: dup
    //   643: invokespecial 694	java/util/ArrayList:<init>	()V
    //   646: pop
    //   647: iconst_0
    //   648: ifne +12 -> 660
    //   651: new 1211	org/json/JSONObject
    //   654: dup
    //   655: invokespecial 1212	org/json/JSONObject:<init>	()V
    //   658: astore 8
    //   660: iload 6
    //   662: ifeq +583 -> 1245
    //   665: aload 7
    //   667: ifnull +578 -> 1245
    //   670: aload_1
    //   671: ifnull +574 -> 1245
    //   674: aload 8
    //   676: ldc_w 2634
    //   679: aload_1
    //   680: getfield 2566	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   683: invokevirtual 1340	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   686: pop
    //   687: aload_3
    //   688: getfield 2635	annl:jdField_e_of_type_Int	I
    //   691: ifle +30 -> 721
    //   694: aload 8
    //   696: ldc_w 2637
    //   699: aload_3
    //   700: getfield 2635	annl:jdField_e_of_type_Int	I
    //   703: invokevirtual 1340	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   706: pop
    //   707: aload 8
    //   709: ldc_w 2639
    //   712: aload_3
    //   713: getfield 2641	annl:jdField_a_of_type_Float	F
    //   716: f2d
    //   717: invokevirtual 2644	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   720: pop
    //   721: aload_3
    //   722: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   725: getfield 2647	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   728: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   731: ifne +546 -> 1277
    //   734: aload 8
    //   736: ldc_w 2648
    //   739: aload_3
    //   740: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   743: getfield 2647	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   746: invokevirtual 1218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload 7
    //   752: ifnull +23 -> 775
    //   755: aload 7
    //   757: invokevirtual 2652	com/tencent/mobileqq/data/Apollo3DMessage:getMessageJSONObject	()Lorg/json/JSONObject;
    //   760: astore_1
    //   761: aload_1
    //   762: ifnull +13 -> 775
    //   765: aload 8
    //   767: ldc_w 2654
    //   770: aload_1
    //   771: invokevirtual 1218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   774: pop
    //   775: aload_3
    //   776: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   779: ifnull +25 -> 804
    //   782: aload_3
    //   783: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   786: getfield 2657	com/tencent/mobileqq/data/ApolloActionData:isForPlayerAction	I
    //   789: iconst_1
    //   790: if_icmpne +14 -> 804
    //   793: aload 8
    //   795: ldc_w 2659
    //   798: bipush 10
    //   800: invokevirtual 1340	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   803: pop
    //   804: aload 8
    //   806: ifnull +13 -> 819
    //   809: aload 9
    //   811: aload 8
    //   813: invokevirtual 1233	org/json/JSONObject:toString	()Ljava/lang/String;
    //   816: putfield 2662	com/tencent/mobileqq/data/ApolloMessage:extStr	Ljava/lang/String;
    //   819: aload_0
    //   820: aload_2
    //   821: getfield 41	com/tencent/mobileqq/activity/aio/SessionInfo:curFriendUin	Ljava/lang/String;
    //   824: aload_2
    //   825: getfield 256	com/tencent/mobileqq/activity/aio/SessionInfo:troopUin	Ljava/lang/String;
    //   828: aload_2
    //   829: getfield 62	com/tencent/mobileqq/activity/aio/SessionInfo:curType	I
    //   832: aload 9
    //   834: invokestatic 2665	bcsa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ApolloMessage;)Lcom/tencent/mobileqq/data/MessageForApollo;
    //   837: astore_1
    //   838: aload_1
    //   839: aload_3
    //   840: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   843: getfield 2647	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   846: putfield 2666	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   849: aload_1
    //   850: aload_3
    //   851: getfield 2635	annl:jdField_e_of_type_Int	I
    //   854: putfield 2669	com/tencent/mobileqq/data/MessageForApollo:audioId	I
    //   857: aload_1
    //   858: aload_3
    //   859: getfield 2641	annl:jdField_a_of_type_Float	F
    //   862: putfield 2671	com/tencent/mobileqq/data/MessageForApollo:audioStartTime	F
    //   865: aload_1
    //   866: aload_3
    //   867: getfield 2672	annl:f	I
    //   870: putfield 2675	com/tencent/mobileqq/data/MessageForApollo:isPlayDefaultAudio	I
    //   873: aload_1
    //   874: aload_3
    //   875: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   878: getfield 2566	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   881: putfield 2676	com/tencent/mobileqq/data/MessageForApollo:actionType	I
    //   884: aload_1
    //   885: aload 7
    //   887: putfield 2679	com/tencent/mobileqq/data/MessageForApollo:mApollo3DMessage	Lcom/tencent/mobileqq/data/Apollo3DMessage;
    //   890: aload_1
    //   891: getfield 2666	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   894: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   897: ifeq +11 -> 908
    //   900: aload_1
    //   901: aload_3
    //   902: getfield 2680	annl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   905: putfield 2666	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   908: aload_1
    //   909: aload_3
    //   910: getfield 2681	annl:jdField_h_of_type_Int	I
    //   913: putfield 2684	com/tencent/mobileqq/data/MessageForApollo:mSendSrc	I
    //   916: aload_3
    //   917: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   920: ifnull +20 -> 940
    //   923: aload_3
    //   924: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   927: getfield 2657	com/tencent/mobileqq/data/ApolloActionData:isForPlayerAction	I
    //   930: iconst_1
    //   931: if_icmpne +9 -> 940
    //   934: aload_1
    //   935: bipush 10
    //   937: putfield 2687	com/tencent/mobileqq/data/MessageForApollo:msgType	I
    //   940: aload_0
    //   941: invokestatic 2692	anck:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lanch;
    //   944: astore_2
    //   945: aload_3
    //   946: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   949: getfield 2566	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   952: ifeq +366 -> 1318
    //   955: aload_2
    //   956: ifnull +362 -> 1318
    //   959: aload_0
    //   960: invokestatic 2695	anck:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lanbt;
    //   963: ifnonnull +340 -> 1303
    //   966: aload_0
    //   967: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   970: aload_1
    //   971: aconst_null
    //   972: invokevirtual 610	com/tencent/imcore/message/QQMessageFacade:addAndSendMessage	(Lcom/tencent/mobileqq/data/MessageRecord;Lanyz;)V
    //   975: ldc_w 601
    //   978: iconst_2
    //   979: new 182	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   986: ldc_w 2697
    //   989: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: aload_3
    //   993: invokevirtual 2698	annl:toString	()Ljava/lang/String;
    //   996: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: invokestatic 1799	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1005: return
    //   1006: aload 7
    //   1008: aload_3
    //   1009: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1012: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1015: invokevirtual 46	anvk:b	(Ljava/lang/String;)Z
    //   1018: ifne +33 -> 1051
    //   1021: invokestatic 2703	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   1024: aload 8
    //   1026: getfield 2706	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   1029: lsub
    //   1030: ldc2_w 2707
    //   1033: lcmp
    //   1034: iflt +17 -> 1051
    //   1037: aload_1
    //   1038: aload_3
    //   1039: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1042: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1045: invokevirtual 2538	com/tencent/mobileqq/vas/VasExtensionHandler:b	(Ljava/lang/String;)V
    //   1048: goto -890 -> 158
    //   1051: aload 7
    //   1053: aload_3
    //   1054: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1057: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1060: invokevirtual 46	anvk:b	(Ljava/lang/String;)Z
    //   1063: ifeq +27 -> 1090
    //   1066: aload 8
    //   1068: getfield 2706	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   1071: lconst_0
    //   1072: lcmp
    //   1073: ifne +17 -> 1090
    //   1076: aload_1
    //   1077: aload_3
    //   1078: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1081: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1084: invokevirtual 2538	com/tencent/mobileqq/vas/VasExtensionHandler:b	(Ljava/lang/String;)V
    //   1087: goto -929 -> 158
    //   1090: aload 8
    //   1092: getfield 2596	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   1095: aload 8
    //   1097: getfield 2711	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   1100: lcmp
    //   1101: ifeq -943 -> 158
    //   1104: new 693	java/util/ArrayList
    //   1107: dup
    //   1108: iconst_1
    //   1109: invokespecial 2712	java/util/ArrayList:<init>	(I)V
    //   1112: astore 7
    //   1114: aload 7
    //   1116: aload_3
    //   1117: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1120: getfield 2523	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1123: invokestatic 1805	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1126: invokestatic 2715	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1129: invokevirtual 1268	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1132: pop
    //   1133: aload_1
    //   1134: aload 7
    //   1136: ldc_w 2717
    //   1139: invokevirtual 2720	com/tencent/mobileqq/vas/VasExtensionHandler:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   1142: goto -984 -> 158
    //   1145: aload 9
    //   1147: sipush 1450
    //   1150: putfield 1734	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1153: goto -907 -> 246
    //   1156: astore 8
    //   1158: sipush 1024
    //   1161: istore 4
    //   1163: aconst_null
    //   1164: astore_1
    //   1165: aconst_null
    //   1166: astore 7
    //   1168: ldc_w 601
    //   1171: iconst_1
    //   1172: ldc_w 2722
    //   1175: aload 8
    //   1177: invokestatic 606	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1180: goto -836 -> 344
    //   1183: aload 9
    //   1185: ldc_w 2724
    //   1188: invokevirtual 2588	java/lang/String:getBytes	()[B
    //   1191: putfield 2583	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1194: goto -855 -> 339
    //   1197: astore 8
    //   1199: sipush 1024
    //   1202: istore 4
    //   1204: goto -36 -> 1168
    //   1207: aload 9
    //   1209: aload_3
    //   1210: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1213: getfield 2541	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   1216: putfield 1734	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1219: aload 9
    //   1221: aload_3
    //   1222: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1225: getfield 2519	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   1228: ldc_w 1584
    //   1231: invokevirtual 75	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1234: putfield 2583	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1237: aconst_null
    //   1238: astore 7
    //   1240: aconst_null
    //   1241: astore_1
    //   1242: goto -898 -> 344
    //   1245: aload 8
    //   1247: ldc_w 2634
    //   1250: aload_3
    //   1251: getfield 2514	annl:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1254: getfield 2566	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   1257: invokevirtual 1340	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1260: pop
    //   1261: goto -574 -> 687
    //   1264: astore_0
    //   1265: ldc_w 601
    //   1268: iconst_1
    //   1269: ldc_w 2726
    //   1272: aload_0
    //   1273: invokestatic 606	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1276: return
    //   1277: aload_3
    //   1278: getfield 2680	annl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1281: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1284: ifne -534 -> 750
    //   1287: aload 8
    //   1289: ldc_w 2648
    //   1292: aload_3
    //   1293: getfield 2680	annl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1296: invokevirtual 1218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1299: pop
    //   1300: goto -550 -> 750
    //   1303: aload_2
    //   1304: invokevirtual 2731	anch:a	()Lanbz;
    //   1307: astore_0
    //   1308: aload_0
    //   1309: ifnull -1258 -> 51
    //   1312: aload_0
    //   1313: aload_1
    //   1314: invokevirtual 2736	anbz:a	(Lcom/tencent/mobileqq/data/MessageForApollo;)V
    //   1317: return
    //   1318: aload_0
    //   1319: invokevirtual 122	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1322: aload_1
    //   1323: aconst_null
    //   1324: invokevirtual 610	com/tencent/imcore/message/QQMessageFacade:addAndSendMessage	(Lcom/tencent/mobileqq/data/MessageRecord;Lanyz;)V
    //   1327: invokestatic 178	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1330: ifeq -1279 -> 51
    //   1333: ldc_w 601
    //   1336: iconst_2
    //   1337: new 182	java/lang/StringBuilder
    //   1340: dup
    //   1341: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   1344: ldc_w 2738
    //   1347: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: aload_3
    //   1351: invokevirtual 2698	annl:toString	()Ljava/lang/String;
    //   1354: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1360: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1363: return
    //   1364: astore 8
    //   1366: aconst_null
    //   1367: astore_1
    //   1368: sipush 1024
    //   1371: istore 4
    //   1373: goto -205 -> 1168
    //   1376: astore 8
    //   1378: aconst_null
    //   1379: astore 7
    //   1381: aconst_null
    //   1382: astore_1
    //   1383: iload 5
    //   1385: istore 4
    //   1387: goto -219 -> 1168
    //   1390: goto -816 -> 574
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1393	0	paramQQAppInterface	QQAppInterface
    //   0	1393	1	paramContext	Context
    //   0	1393	2	paramSessionInfo	SessionInfo
    //   0	1393	3	paramannl	annl
    //   56	1330	4	i	int
    //   53	1331	5	j	int
    //   168	493	6	bool	boolean
    //   68	1312	7	localObject1	Object
    //   140	956	8	localObject2	Object
    //   1156	20	8	localException1	Exception
    //   1197	91	8	localException2	Exception
    //   1364	1	8	localException3	Exception
    //   1376	1	8	localException4	Exception
    //   221	999	9	localApolloMessage	ApolloMessage
    //   80	406	10	localamme	amme
    // Exception table:
    //   from	to	target	type
    //   228	246	1156	java/lang/Exception
    //   246	255	1156	java/lang/Exception
    //   1145	1153	1156	java/lang/Exception
    //   314	339	1197	java/lang/Exception
    //   1183	1194	1197	java/lang/Exception
    //   651	660	1264	java/lang/Throwable
    //   674	687	1264	java/lang/Throwable
    //   687	721	1264	java/lang/Throwable
    //   721	750	1264	java/lang/Throwable
    //   755	761	1264	java/lang/Throwable
    //   765	775	1264	java/lang/Throwable
    //   775	804	1264	java/lang/Throwable
    //   1245	1261	1264	java/lang/Throwable
    //   1277	1300	1264	java/lang/Throwable
    //   255	310	1364	java/lang/Exception
    //   1207	1237	1376	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131692074), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      bhpl.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.getNetworkType(paramContext) + "", "", "", "", "");
      paramContext = new StringBuilder().append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      if (paramEmoticon.name != null)
      {
        paramQQAppInterface = paramEmoticon.name;
        paramContext = paramContext.append(paramQQAppInterface).append(", epid_eid:");
        if (paramEmoticon.epId == null) {
          break label223;
        }
        paramQQAppInterface = paramEmoticon.epId;
        label176:
        paramContext = paramContext.append(paramQQAppInterface).append("_");
        if (paramEmoticon.eId == null) {
          break label230;
        }
      }
      label223:
      label230:
      for (paramQQAppInterface = paramEmoticon.eId;; paramQQAppInterface = "~")
      {
        QLog.e("ChatActivityFacade", 1, paramQQAppInterface);
        return;
        paramQQAppInterface = "~";
        break;
        paramQQAppInterface = "~";
        break label176;
      }
    }
    ThreadManager.post(new ChatActivityFacade.20(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramInt), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
      paramContext = bcsa.a(paramContext);
      paramQQAppInterface.getMessageFacade().addAndSendMessage(paramContext, null, true);
      paramQQAppInterface = (awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      if ((paramQQAppInterface != null) && (paramEmoticon != null))
      {
        paramContext = paramQQAppInterface.a(paramEmoticon);
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            paramSessionInfo = (String)paramContext.next();
            if (!android.text.TextUtils.isEmpty(paramSessionInfo))
            {
              RecentEmotion localRecentEmotion = new RecentEmotion();
              localRecentEmotion.epId = paramEmoticon.epId;
              localRecentEmotion.eId = paramEmoticon.eId;
              localRecentEmotion.keyword = paramSessionInfo.toLowerCase();
              localRecentEmotion.exposeNum = 0;
              paramQQAppInterface.a(localRecentEmotion);
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ChatActivityFacade", 2, "reSendEmosmMessage : mr is null.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      Toast.makeText(paramContext, "emoticon is null.", 0).show();
      QLog.e("ChatActivityFacade", 1, "sendEmosmMsg emoticon is null:");
      return;
    }
    if (((paramEmoticon.jobType == 0) || (paramEmoticon.jobType == 2) || (paramEmoticon.jobType == 4)) && (!paramEmoticon.hasEncryptKey()))
    {
      Toast.makeText(paramContext, paramContext.getString(2131692074), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      bhpl.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.getNetworkType(paramContext) + "", "", "", "", "");
      paramContext = new StringBuilder().append("sendEmosmMsg emoticon Encrypt Key is null.name:");
      if (paramEmoticon.name != null)
      {
        paramQQAppInterface = paramEmoticon.name;
        paramContext = paramContext.append(paramQQAppInterface).append(", epid_eid:");
        if (paramEmoticon.epId == null) {
          break label223;
        }
        paramQQAppInterface = paramEmoticon.epId;
        label176:
        paramContext = paramContext.append(paramQQAppInterface).append("_");
        if (paramEmoticon.eId == null) {
          break label230;
        }
      }
      label223:
      label230:
      for (paramQQAppInterface = paramEmoticon.eId;; paramQQAppInterface = "~")
      {
        QLog.e("ChatActivityFacade", 1, paramQQAppInterface);
        return;
        paramQQAppInterface = "~";
        break;
        paramQQAppInterface = "~";
        break label176;
      }
    }
    ThreadManager.post(new ChatActivityFacade.21(paramQQAppInterface, paramEmoticon, paramContext, paramSessionInfo, paramStickerInfo), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    admo localadmo = new admo();
    localadmo.jdField_a_of_type_Boolean = false;
    localadmo.jdField_b_of_type_Boolean = true;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, localadmo);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLoveMessage");
    }
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X80052A5", "0X80052A5", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    bheg.a(-1L, paramSessionInfo.curType, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131694682, 0);
      bheg.a(-1L, paramSessionInfo.curType, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new azko();
    paramContext.a(paramString);
    paramContext.d(paramInt);
    paramContext.d(paramSessionInfo.curFriendUin);
    paramContext.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    paramContext.e(paramSessionInfo.troopUin);
    paramContext.c(paramQQAppInterface.getCurrentAccountUin());
    paramContext.e(paramSessionInfo.curType);
    paramContext.l(paramSessionInfo.topicId);
    azke localazke = azjv.a(2, paramInt);
    localazke.a(paramContext.a());
    azjv.a(localazke, paramQQAppInterface);
    ThreadManager.post(new ChatActivityFacade.11(paramString, paramSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131692125, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131718500, 0);
      return;
    }
    ThreadManager.post(new ChatActivityFacade.23(paramSessionInfo, paramQQAppInterface, paramString, paramInt, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.curType == 1) && (((bgkf)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramSessionInfo.curFriendUin, true).jdField_a_of_type_Boolean) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), 2131697134, 0).b(paramContext.getTitleBarHeight());
      return;
    }
    ThreadManager.post(new ChatActivityFacade.22(paramQQAppInterface, paramSessionInfo, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, paramString2, paramString3, paramLong, paramInt, paramString4, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString1)) {
      bheb.a(paramQQAppInterface, paramString1, paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSessionInfo.troopUin, false, paramContext, paramInt2);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramString2, paramString3, paramLong, paramInt1);
        paramContext = paramQQAppInterface.getTransFileController().findProcessor(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof BaseTransProcessor)));
      paramContext = (BaseTransProcessor)paramContext;
      l2 = paramContext.getFileStatus();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    paramQQAppInterface.getTransFileController().startForwardPicTransfer(l1, paramString4, paramQQAppInterface, paramSessionInfo.curType, paramSessionInfo.curFriendUin, paramString1, paramString2, paramString3, paramLong, paramInt1);
    paramContext.getFileMsg().forwardTaskKey = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new admo());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, false, false, paramBoolean, null, null, paramString2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, paramBoolean1, paramBoolean2, false, paramString2, paramStickerInfo, null, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo, String paramString3, Bundle paramBundle)
  {
    if (paramString1 == null)
    {
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion url == null");
      if (paramBoolean1) {
        bhpl.a("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
      return;
    }
    bheg.a(-1L, paramSessionInfo.curType, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      ChatActivityUtils.a(paramContext, 2131694682, 0);
      if (paramBoolean1) {
        bhpl.a("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
      }
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion file not exist or problme: URL = " + paramString1);
      return;
    }
    Object localObject = new azko();
    ((azko)localObject).a(paramString1);
    ((azko)localObject).d(1006);
    ((azko)localObject).d(paramSessionInfo.curFriendUin);
    ((azko)localObject).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
    ((azko)localObject).e(paramSessionInfo.troopUin);
    ((azko)localObject).c(paramQQAppInterface.getCurrentAccountUin());
    ((azko)localObject).e(paramSessionInfo.curType);
    ((azko)localObject).l(paramSessionInfo.topicId);
    azke localazke = azjv.a(2, 1006);
    localazke.a(((azko)localObject).a());
    localObject = new PicMessageExtraData();
    if (paramBoolean3)
    {
      ((PicMessageExtraData)localObject).imageBizType = 8;
      if (paramBundle != null) {
        ((PicMessageExtraData)localObject).mTemplateId = paramBundle.getString("widgetinfo", "");
      }
      if (android.text.TextUtils.isEmpty(paramString3)) {
        break label411;
      }
      ((PicMessageExtraData)localObject).textSummary = ("[" + paramString3 + "]");
    }
    for (;;)
    {
      localazke.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = ((PicMessageExtraData)localObject);
      azjv.a(localazke, paramQQAppInterface);
      if (!paramBoolean1) {
        break;
      }
      ThreadManager.post(new ChatActivityFacade.12(paramString1, paramSessionInfo, paramQQAppInterface), 5, null, false);
      return;
      ((PicMessageExtraData)localObject).imageBizType = 1;
      int i;
      if (paramBoolean2)
      {
        i = 2;
        label364:
        ((PicMessageExtraData)localObject).customFaceType = i;
        if (!paramBoolean2) {
          break label404;
        }
      }
      for (;;)
      {
        ((PicMessageExtraData)localObject).emojiPkgId = paramString2;
        if (paramStickerInfo == null) {
          break;
        }
        ((PicMessageExtraData)localObject).stickerInfo = paramStickerInfo;
        break;
        i = 0;
        break label364;
        label404:
        paramString2 = "";
      }
      label411:
      if (paramBoolean3) {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131691251);
      } else {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131691250);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List<String> paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str = (String)paramList.next();
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {
            continue;
          }
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(acnh.a(str))))
          {
            localObject2 = paramQQAppInterface.getMessageFacade().getMsgList(str, 0);
            ChatActivityUtils.a(paramContext, str, 0, "single_way_friend_list");
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != -2019) {
                continue;
              }
              paramQQAppInterface.getMessageFacade().removeMsgByUniseq(str, localMessageRecord.istroop, localMessageRecord.uniseq);
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l;
    do
    {
      try
      {
        Long.valueOf(paramSessionInfo.curFriendUin).longValue();
        l = paramQQAppInterface.getMessageFacade().getReadConfirmStamp(paramSessionInfo.curFriendUin, paramSessionInfo.curType);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramSessionInfo.curFriendUin, Integer.valueOf(paramSessionInfo.curType), Long.valueOf(l) }));
        }
        if (paramSessionInfo.curType == 1036) {
          return;
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.sendReadConfirm_PB", 2, paramQQAppInterface, new Object[0]);
        return;
      }
    } while ((l == -1L) || (l == paramSessionInfo.mLastReadMsgId));
    paramSessionInfo.mLastReadMsgId = l;
    String str = acnh.b(paramSessionInfo.curType);
    paramQQAppInterface.getMsgHandler().a(str).a(paramSessionInfo.curFriendUin, paramSessionInfo.curType, l);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    if (paramLong > NetConnInfoCenter.getServerTimeMillis())
    {
      QLog.e("ChatActivityFacade.QZoneFeeds", 2, String.format("帖子创建时间：%d,当前取得服务器时间：%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(NetConnInfoCenter.getServerTimeMillis()) }));
      return;
    }
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story帖子创建时间：%d", new Object[] { Long.valueOf(paramLong) }));
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, paramLong).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (paramIntent == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } while ((localArrayList == null) || (localArrayList.isEmpty()) || (android.text.TextUtils.isEmpty(paramSessionInfo.curFriendUin)));
    try
    {
      int i = Integer.valueOf(paramIntent.getStringExtra("key_upload_client_key")).intValue();
      long l = a(paramQQAppInterface, paramSessionInfo, i, localArrayList);
      ((aofw)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_QZONE_UPLOAD_ALBUM_PROGRESS_HANDLER)).a(i, paramSessionInfo.curFriendUin, l);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForPic paramMessageForPic, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramMessageForPic == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("uin", paramSessionInfo.curFriendUin);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.troopUin);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.curType);
    ((Intent)localObject).putExtra("FORWARD_UIN_TYPE", paramSessionInfo.curType);
    ((Intent)localObject).putExtra("SENDER_TROOP_UIN", paramSessionInfo.troopUin);
    ((Intent)localObject).putExtra("FORWARD_PEER_UIN", paramSessionInfo.curFriendUin);
    ((Intent)localObject).putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject).putExtra("forward_image_width", paramMessageForPic.width);
    ((Intent)localObject).putExtra("forward_image_height", paramMessageForPic.height);
    ((Intent)localObject).putExtra("forward_file_size", paramMessageForPic.size);
    ((Intent)localObject).putExtra("forward_image_type", paramMessageForPic.imageType);
    ((Intent)localObject).putExtra("forward_filepath", paramMessageForPic.path);
    paramSessionInfo = paramMessageForPic.frienduin + paramMessageForPic.uniseq + paramMessageForPic.istroop;
    ((Intent)localObject).putExtra("BUSI_TYPE", 1009);
    ((Intent)localObject).putExtra("forward_download_image_task_key", paramSessionInfo);
    ((Intent)localObject).putExtra("forward_download_image_org_uin", paramMessageForPic.frienduin);
    ((Intent)localObject).putExtra("forward_download_image_org_uin_type", paramMessageForPic.istroop);
    ((Intent)localObject).putExtra("forward_download_image_server_path", paramMessageForPic.uuid);
    ((Intent)localObject).putExtra("forward_download_image_item_id", paramMessageForPic.uniseq);
    ((Intent)localObject).putExtra("forward_photo_isSend", paramMessageForPic.issend);
    ((Intent)localObject).putExtra("forward_photo_md5", paramMessageForPic.md5);
    ((Intent)localObject).putExtra("forward_photo_group_fileid", paramMessageForPic.groupFileID);
    ((Intent)localObject).putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", paramMessageForPic.fileSizeFlag);
    paramSessionInfo = azjv.a(1009, (Intent)localObject);
    localObject = azjv.a(3, 1009);
    ((azke)localObject).a(paramSessionInfo);
    ((azke)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    ((azke)localObject).jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = paramMessageForPic.picExtraData;
    paramMessageForPic.forwardId.put(localObject, Integer.valueOf(paramInt));
    azjv.a((azke)localObject, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 2;
    if ((paramQQAppInterface == null) || (paramMessageForShortVideo == null))
    {
      QLog.e("ChatActivityFacade", 1, "forwardPicMsg failed!");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("uin", paramSessionInfo.curFriendUin);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.troopUin);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.curType);
    ((Intent)localObject).putExtra("from_uin", ShortVideoUtils.getFromUinForForward(paramMessageForShortVideo));
    ((Intent)localObject).putExtra("from_uin_type", paramMessageForShortVideo.istroop);
    ((Intent)localObject).putExtra("from_session_uin", paramMessageForShortVideo.frienduin);
    ((Intent)localObject).putExtra("from_busi_type", paramMessageForShortVideo.busiType);
    ((Intent)localObject).putExtra("file_send_size", paramMessageForShortVideo.videoFileSize);
    ((Intent)localObject).putExtra("file_send_duration", paramMessageForShortVideo.videoFileTime);
    ((Intent)localObject).putExtra("file_name", paramMessageForShortVideo.videoFileName);
    ((Intent)localObject).putExtra("file_format", paramMessageForShortVideo.videoFileFormat);
    String str = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "Forward menu clicked, videoPath=" + str + ",videoPath = " + str + ", " + paramMessageForShortVideo.toLogString());
    }
    ((Intent)localObject).putExtra("file_send_path", str);
    ((Intent)localObject).putExtra("thumbfile_send_path", ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg"));
    ((Intent)localObject).putExtra("file_shortvideo_md5", paramMessageForShortVideo.md5);
    if (!android.text.TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
      ((Intent)localObject).putExtra("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
    }
    ((Intent)localObject).putExtra("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    ((Intent)localObject).putExtra("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    ((Intent)localObject).putExtra("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    ((Intent)localObject).putExtra("file_source", paramMessageForShortVideo.fileSource);
    ((Intent)localObject).putExtra("file_uuid", paramMessageForShortVideo.uuid);
    ((Intent)localObject).putExtra("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    ((Intent)localObject).putExtra("support_progressive", paramMessageForShortVideo.supportProgressive);
    ((Intent)localObject).putExtra("file_width", paramMessageForShortVideo.fileWidth);
    ((Intent)localObject).putExtra("file_height", paramMessageForShortVideo.fileHeight);
    ((Intent)localObject).putExtra("from_msg_uniseq", paramMessageForShortVideo.uniseq);
    int i = paramMessageForShortVideo.busiType;
    if (i == 1)
    {
      i = 2;
      ((Intent)localObject).putExtra("special_video_type", paramMessageForShortVideo.specialVideoType);
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        ((Intent)localObject).putExtra("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        ((Intent)localObject).putExtra("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        ((Intent)localObject).putExtra("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        ((Intent)localObject).putExtra("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      ((Intent)localObject).putExtra("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
      ((Intent)localObject).putExtra("widgetinfo", paramMessageForShortVideo.templateId);
      ((Intent)localObject).putExtra("key_camera_material_name", paramMessageForShortVideo.templateName);
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.senderuin.equals(paramQQAppInterface.getAccount())))
      {
        ((Intent)localObject).putExtra("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
        ((Intent)localObject).putExtra("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        if (paramSessionInfo.curType != 1) {
          break label696;
        }
        j = 1;
      }
    }
    for (;;)
    {
      alpt.a("", "0X80088E4", String.valueOf(j));
      paramSessionInfo = bcwz.a(3, i);
      localObject = bcwz.a(i, localObject, paramSessionInfo);
      if (localObject != null)
      {
        ((bcxd)localObject).jdField_a_of_type_Long = paramMessageForShortVideo.uniseq;
        ((bcxd)localObject).p = paramMessageForShortVideo.forwardID;
        paramSessionInfo.a((bcxd)localObject);
      }
      bcwz.a(paramSessionInfo, paramQQAppInterface);
      return;
      if (i == 2)
      {
        i = 3;
        break;
      }
      i = 0;
      break;
      label696:
      if (paramSessionInfo.curType != 3000) {
        j = 3;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg)
  {
    a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
    apyp.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 2, 0, 0L, 0L, 0L, "LocationShare", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramSessionInfo.curType)
    {
    }
    for (String str1 = paramQQAppInterface.getCurrentAccountUin();; str1 = paramSessionInfo.troopUin)
    {
      String str2 = paramQQAppInterface.getCurrentAccountUin();
      String str3 = paramSessionInfo.curFriendUin;
      int i = paramSessionInfo.curType;
      int j = bcpt.a;
      bcpt.a = j + 1;
      paramSessionInfo = bcsa.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      agfe.a().a(paramSessionInfo.uniseq, paramAbsStructMsg.parentUniseq, paramAbsStructMsg.forwardID);
      paramQQAppInterface.getMessageFacade().addAndSendMessage(paramSessionInfo, null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramSessionInfo, paramString, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()), null, new admo());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      int i = paramSessionInfo.curType;
      Object localObject = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramSessionInfo.curFriendUin, i, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramSessionInfo.curFriendUin, i, paramLong, ((MessageForPtt)localObject).msgData);
        paramQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(paramSessionInfo.curFriendUin, i, paramLong, "extStr", ((MessageForPtt)localObject).extStr);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.curFriendUin))) {
      return;
    }
    a(paramQQAppInterface, paramSessionInfo, admg.jdField_a_of_type_JavaLangString + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, AbsShareMsg paramAbsShareMsg, String paramString5, String paramString6, String paramString7)
  {
    paramString7 = new ArkAppMessage();
    if (apwl.e) {}
    for (;;)
    {
      try
      {
        paramString7.appMinVersion = "1.0.0.101";
        paramString7.appName = "com.tencent.map";
        paramString7.appView = "LocationShare";
        paramString6 = ArkAppCacheMgr.getApplicationFromManifest(paramString7.appName, paramString7.appMinVersion);
        if (paramString6 != null)
        {
          paramString7.appDesc = ((String)paramString6.get("desc"));
          paramString7.appMinVersion = ((String)paramString6.get("version"));
        }
        paramString6 = anvx.a(2131701048);
        if ((android.text.TextUtils.isEmpty(paramString7.appDesc)) || (paramString7.appDesc.equals(paramString7.appName))) {
          paramString7.appDesc = paramString6;
        }
        switch (paramSessionInfo.curType)
        {
        case 1000: 
          paramString6 = paramQQAppInterface.getCurrentAccountUin();
          String str1 = paramQQAppInterface.getCurrentAccountUin();
          String str2 = paramSessionInfo.curFriendUin;
          int i = paramSessionInfo.curType;
          int j = bcpt.a;
          bcpt.a = j + 1;
          paramString7.containStructMsg = bcsa.a(paramQQAppInterface, str1, str2, paramString6, i, j, paramAbsShareMsg);
          paramString7.promptText = String.format(anvx.a(2131701061), new Object[] { paramString7.appDesc });
          paramString7.from = 1;
          paramString7.metaList = a(paramString5, paramString3, paramString4, paramString1, paramString2);
          paramString1 = new JSONObject();
          paramString1.put("forward", 1);
          paramString1.put("autosize", 1);
          paramString1.put("type", "card");
          paramString7.config = paramString1.toString();
          a(paramQQAppInterface, paramSessionInfo, paramString7, paramAbsShareMsg.forwardID);
          ArkAppCenter.c("sendArkStructMap", "send ark msg is success and arkMsg.metaList=" + paramString7.metaList);
          apyp.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 1, 0, 0L, 0L, 0L, paramString7.appView, "");
          return;
        }
      }
      catch (Exception paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArkApp", 1, "ChatActivityFacade send arkMapMessage parameter error: " + paramString1.getMessage());
        ArkAppCenter.c("sendArkStructMap", "parameter error and send ark msg is failed then send struct msg");
        a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
        return;
      }
      paramString6 = paramSessionInfo.troopUin;
      continue;
      ArkAppCenter.c("sendArkStructMap", "sIsArkStructMap is false then send struct msg");
      a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo.curType != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.2(paramQQAppInterface, paramSessionInfo, paramBoolean), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      paramQQAppInterface.getTransFileController().removeProcessor(paramQQAppInterface.getTransFileController().makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, app:" + paramQQAppInterface + ",e:" + paramEmoticon);
    }
    if ((paramQQAppInterface == null) || (paramEmoticon == null) || (android.text.TextUtils.isEmpty(paramEmoticon.epId)) || (android.text.TextUtils.isEmpty(paramEmoticon.eId)) || (!android.text.TextUtils.isEmpty(paramEmoticon.encryptKey))) {
      return;
    }
    asih localasih = (asih)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    ThreadManager.post(new ChatActivityFacade.19(paramEmoticon, (awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER), localasih), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    ((axig)paramQQAppInterface.getManager(QQManagerFactory.LONG_ARK_MSG_MANAGER)).a(paramQQAppInterface, paramMessageForArkApp, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).c(Long.valueOf(paramString).longValue());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("ChatActivityFacade", 2, "insertCommonHobbyIfNeeded uin is: " + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString, paramMessageForPtt, paramBoolean1, paramInt1, paramInt2, paramBoolean2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, azjj paramazjj)
  {
    paramString = new ChatActivityFacade.1(paramMessageForPtt, paramQQAppInterface, paramString, paramBoolean2, paramazjj, paramInt1, paramInt2);
    if (paramBoolean1)
    {
      paramString.run();
      return;
    }
    paramQQAppInterface.execute(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, adml paramadml)
  {
    String str = "";
    if (paramString != null) {
      str = bcsc.a(paramString, true, null);
    }
    int i = bcpt.a;
    bcpt.a = i + 1;
    long l1 = i;
    i = Math.abs(new Random().nextInt());
    int j = (int)bcrg.a();
    paramString = paramQQAppInterface.getCurrentAccountUin();
    long l2 = bcsc.a(i);
    ChatMessage localChatMessage = (ChatMessage)bcsa.a(-1000);
    localChatMessage.init(paramString, "", paramString, str, j, -1000, 0, l1);
    localChatMessage.isread = true;
    localChatMessage.msgUid = l2;
    localChatMessage.shmsgseq = bcsc.a(l1, 0);
    localChatMessage.issend = 1;
    if (paramArrayList.size() <= 10) {}
    for (boolean bool = true;; bool = false)
    {
      localChatMessage.needUpdateMsgTag = bool;
      ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localChatMessage);
      ((MessageForText)localChatMessage).msgVia = 0;
      paramQQAppInterface.getMessageFacade().sendBlessMsg(paramQQAppInterface, localChatMessage, paramArrayList, paramadml);
      return;
    }
  }
  
  public static void a(List<ChatMessage> paramList)
  {
    if ((jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (!((ChatMessage)paramList.get(0)).isLongMsg()) {
        break label120;
      }
      Iterator localIterator = paramList.iterator();
      ChatMessage localChatMessage;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)localIterator.next();
      } while ((localChatMessage.shmsgseq != jdField_a_of_type_ComTencentMobileqqDataChatMessage.shmsgseq) || (localChatMessage.msgUid != jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgUid));
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (((i != 0) || (paramList.contains(jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (jdField_a_of_type_Bkzi != null)) {
        jdField_a_of_type_Bkzi.dismiss();
      }
      return;
    }
  }
  
  private static boolean a(admo paramadmo, boolean paramBoolean)
  {
    if (paramadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      byte[] arrayOfByte = paramadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.getSourceMsg();
      if ((arrayOfByte == null) || (arrayOfByte.length < 560)) {
        break label34;
      }
      paramadmo.f = true;
    }
    label34:
    do
    {
      return false;
      if ((paramBoolean) && (paramadmo.f)) {
        return true;
      }
    } while ((paramBoolean) || (paramadmo.f));
    return true;
  }
  
  private static boolean a(SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.curType;
    return (i == 0) || (i == 3000) || (i == 1);
  }
  
  private static boolean a(SessionInfo paramSessionInfo, String paramString, Bundle paramBundle)
  {
    if ((!android.text.TextUtils.isEmpty(paramString)) && (!paramString.equals("Unknown Address")))
    {
      if (paramBundle != null)
      {
        if (paramBundle.getInt("isArk") == 0)
        {
          ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, isArk=0 and sendStructMsg");
          return false;
        }
        if (a(paramSessionInfo))
        {
          ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, session is allowed and sendArkMsg");
          return true;
        }
        ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, session is not allowed and sendStructMsg");
        return false;
      }
      ArkAppCenter.c("sendArkStructMap", "isSendArkMsg, extra is empty and sendStructMsg");
      return false;
    }
    ArkAppCenter.c("sendArkStructMap", "isSendArkMsg,could not find location and sendStructMsg");
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForLongMsg paramMessageForLongMsg)
  {
    paramContext = paramMessageForLongMsg.longMsgFragmentList;
    if ((paramContext == null) || (paramContext.isEmpty())) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      paramMessageForLongMsg = (MessageRecord)paramContext.next();
      if (paramMessageForLongMsg.extraflag == 32768)
      {
        if (paramMessageForLongMsg.isSendFromLocal()) {
          paramQQAppInterface.getTransFileController().removeProcessor(paramQQAppInterface.getTransFileController().makeKey(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == -1000)
        {
          paramMessageForLongMsg = bcsa.a(paramMessageForLongMsg);
          paramQQAppInterface.getMessageFacade().addAndSendMessage(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = bcsa.b(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType, paramArkAppMessage);
    agfe.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramArkAppMessage.forwardID);
    if (localMessageForArkApp.istroop == 1) {
      nty.a().a(localMessageForArkApp);
    }
    localMessageForArkApp.saveExtInfoToExtStr(bcrn.jdField_e_of_type_JavaLangString, "1");
    paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    if ((paramArkAppMessage != null) && (localMessageForArkApp.ark_app_message != null))
    {
      paramArkAppMessage = paramArkAppMessage.a();
      if (paramArkAppMessage == null) {}
    }
    for (boolean bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
      }
      if (!bool) {
        paramQQAppInterface.getMessageFacade().addAndSendMessage(localMessageForArkApp, null);
      }
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage, int paramInt)
  {
    MessageForArkApp localMessageForArkApp = bcsa.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType, paramArkAppMessage);
    if (paramInt == 0)
    {
      paramInt = paramArkAppMessage.forwardID;
      agfe.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramInt);
      if (localMessageForArkApp.istroop == 1) {
        nty.a().a(localMessageForArkApp);
      }
      paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      if ((paramArkAppMessage == null) || (localMessageForArkApp.ark_app_message == null)) {
        break label162;
      }
      paramArkAppMessage = paramArkAppMessage.a();
      if (paramArkAppMessage == null) {
        break label162;
      }
    }
    label162:
    for (boolean bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
      }
      if (!bool) {
        paramQQAppInterface.getMessageFacade().addAndSendMessage(localMessageForArkApp, null);
      }
      return true;
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkFlashChatMessage, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkFlashChatMessage paramArkFlashChatMessage, int paramInt)
  {
    paramSessionInfo = bcsa.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType, paramArkFlashChatMessage);
    if (paramInt == 0) {
      paramInt = paramArkFlashChatMessage.forwardID;
    }
    for (;;)
    {
      agfe.a().a(paramSessionInfo.uniseq, paramArkFlashChatMessage.uniSeq, paramInt);
      if (paramSessionInfo.istroop == 1) {
        nty.a().a(paramSessionInfo);
      }
      paramQQAppInterface.getMessageFacade().addAndSendMessage(paramSessionInfo, null);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, anyz paramanyz)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramHiBoomMessage, paramanyz, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, anyz paramanyz, int paramInt)
  {
    paramSessionInfo = bcsa.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType, paramHiBoomMessage);
    agfe.a().a(paramSessionInfo.uniseq, 0L, paramInt);
    if (paramSessionInfo.istroop == 1) {
      nty.a().a(paramSessionInfo);
    }
    paramQQAppInterface.getMessageFacade().addAndSendMessage(paramSessionInfo, paramanyz);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, admo paramadmo)
  {
    return (axii.a(paramQQAppInterface)) && (acnh.a(paramQQAppInterface, paramSessionInfo.curType, paramSessionInfo.curFriendUin)) && ((a(paramSessionInfo, paramString) > 560) || (a(paramadmo, true)));
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramadmo == null) || (paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.curFriendUin))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramContext = a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramadmo);
      ThreadManager.post(new ChatActivityFacade.15(paramadmo, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramContext;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    admo localadmo = new admo();
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSessionInfo == null) || (android.text.TextUtils.isEmpty(paramSessionInfo.curFriendUin))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramString = b(paramQQAppInterface, paramSessionInfo, paramString, null, localadmo);
      ThreadManager.post(new ChatActivityFacade.14(localadmo, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramString;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool4 = false;
    boolean bool3 = false;
    short s2 = 0;
    Random localRandom = new Random();
    for (;;)
    {
      try
      {
        if (a(paramadmo, false))
        {
          localObject = b(str, paramArrayList, paramadmo, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            bool2 = bool4;
            paramString = (String)localObject;
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
            bool1 = bool3;
            s1 = s2;
          }
          paramString = paramArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2, currenttime:" + System.currentTimeMillis());
          }
          int j = Math.abs(localRandom.nextInt());
          localObject = new long[paramString.size()];
          int i = 0;
          if (i >= paramString.size()) {
            continue;
          }
          str = (String)paramString.get(i);
          if (localArrayList.size() <= i) {
            continue;
          }
          paramArrayList = (ArrayList)localArrayList.get(i);
          if ((paramSessionInfo.curType == 3000) || (paramSessionInfo.curType == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramadmo);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramadmo)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramadmo, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          bool2 = bool4;
          paramString = (String)localObject;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          continue;
          paramArrayList.printStackTrace();
        }
        catch (UnsupportedEncodingException paramArrayList)
        {
          bool1 = bool2;
        }
      }
      catch (UnsupportedEncodingException paramArrayList)
      {
        Object localObject;
        short s1;
        boolean bool2;
        boolean bool1 = false;
        paramString = null;
        continue;
      }
      s1 = 0;
      continue;
      paramArrayList = bhbx.a(str, 560, 20, paramArrayList, localArrayList);
      bool2 = bool4;
      paramString = paramArrayList;
      if (paramArrayList.size() > 1)
      {
        bool1 = true;
        bool2 = bool1;
        paramString = paramArrayList;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          paramString = paramArrayList;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramArrayList.size() + " isDivide = " + bool1 + " currenttime:" + System.currentTimeMillis());
        }
        bool2 = bool1;
        paramString = paramArrayList;
        s1 = a(paramQQAppInterface, paramSessionInfo, bool1, (short)0, localRandom);
      }
      else
      {
        bool1 = false;
        continue;
        paramArrayList = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3, currenttime:" + System.currentTimeMillis());
    }
    return localObject;
  }
  
  private static long b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return 0L;
    }
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(a(paramQQAppInterface, paramSessionInfo, paramString), 0L);
  }
  
  public static MessageRecord b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (acnh.d(paramSessionInfo.curType))
    {
      List localList = paramQQAppInterface.getMessageFacade().getMsgList(paramSessionInfo.curFriendUin, paramSessionInfo.curType);
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)localList.get(i);
          if (!bhfj.b(paramSessionInfo.issend))
          {
            paramQQAppInterface = paramSessionInfo;
            if (paramSessionInfo.msgtype != -1034) {
              return paramQQAppInterface;
            }
          }
          i -= 1;
        }
      }
    }
    paramQQAppInterface = null;
    return paramQQAppInterface;
  }
  
  private static String b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return "";
    }
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getString(a(paramQQAppInterface, paramSessionInfo, "key_request_troop_qcircle_msg_attache_data"), "");
  }
  
  private static ArrayList<String> b(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    paramadmo = new ArrayList();
    paramadmo.add(paramString);
    paramArrayList1.add(paramArrayList);
    return paramadmo;
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = new ChatActivityFacade.17(paramContext, paramChatMessage, paramQQAppInterface);
    paramChatMessage = (InputMethodManager)paramContext.getSystemService("input_method");
    boolean bool = paramChatMessage.isActive();
    if (((paramContext instanceof Activity)) && (bool)) {
      paramChatMessage.hideSoftInputFromWindow(((Activity)paramContext).getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new Handler(paramContext.getMainLooper()).postDelayed(paramQQAppInterface, 60L);
        return;
      }
      paramQQAppInterface.run();
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, 1, -1, "", "", 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131692125, 0);
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
    if (localMessageRecord == null)
    {
      ChatActivityUtils.a(paramContext, 2131718500, 0);
      return;
    }
    paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
    paramContext = bcsa.a(localMessageRecord);
    paramQQAppInterface.getMessageFacade().addAndSendMessage(paramContext, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, new admo());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.curType != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.4(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp, boolean paramBoolean)
  {
    if ((paramAIONewestFeedRsp == null) || (paramAIONewestFeedRsp.uOpuin != Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue()) || (paramAIONewestFeedRsp.uFeedInfos == null) || (paramAIONewestFeedRsp.uFeedInfos.isEmpty())) {
      if ((paramAIONewestFeedRsp != null) && (paramAIONewestFeedRsp.uOpFlag == 1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "newestFeed.uOpFlag==1  需要清理本地缓存");
        }
        l(paramQQAppInterface, paramSessionInfo);
      }
    }
    Object localObject;
    label192:
    long[] arrayOfLong;
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage 没有拉去到feeds信息");
      return;
      String str1;
      if ((paramAIONewestFeedRsp.mapEx != null) && (paramAIONewestFeedRsp.mapEx.containsKey("iGender"))) {
        str1 = (String)paramAIONewestFeedRsp.mapEx.get("iGender");
      }
      int i;
      for (;;)
      {
        try
        {
          i = Integer.parseInt(str1);
          localObject = (NewestFeedInfo)paramAIONewestFeedRsp.uFeedInfos.get(0);
          if (localObject != null) {
            break label192;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "addQzoneFeedMessage feedInfo == null");
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ChatActivityFacade.QZoneFeeds", 1, "gender parse error:", localException);
        }
        i = 1;
      }
      paramAIONewestFeedRsp = new boolean[1];
      arrayOfLong = new long[1];
      String str2 = String.valueOf(((NewestFeedInfo)localObject).uHostUin);
      if (FeedsManager.isShowStatus(str2))
      {
        arrayOfLong[0] = FeedsManager.getToken(str2);
        paramAIONewestFeedRsp[0] = 1;
        FeedsManager.hideStatus(str2);
      }
      localObject = a((NewestFeedInfo)localObject, paramBoolean, i);
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "jsonOb == null");
    return;
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.7(paramQQAppInterface, paramSessionInfo, (JSONObject)localObject, paramBoolean, paramAIONewestFeedRsp, arrayOfLong));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, CLIENT.StGetUserNewestStoryRsp paramStGetUserNewestStoryRsp)
  {
    if (paramStGetUserNewestStoryRsp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " rsp is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, " hasNewStory:" + paramStGetUserNewestStoryRsp.hasNewStory.get());
        }
      } while (paramStGetUserNewestStoryRsp.hasNewStory.get() != 1);
      if (paramStGetUserNewestStoryRsp.vecStoryFeed.isEmpty()) {
        break label144;
      }
      paramStGetUserNewestStoryRsp = (META.StStoryFeed)paramStGetUserNewestStoryRsp.vecStoryFeed.get(0);
      if (paramStGetUserNewestStoryRsp != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "addQzoneStoryFeedMessage storyFeed == null");
    return;
    a(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp.createTime.get());
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.9(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp));
    return;
    label144:
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.10(paramQQAppInterface, paramSessionInfo));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, FeedCloudRead.StGetC2CFeedRsp paramStGetC2CFeedRsp, boolean paramBoolean)
  {
    if ((paramStGetC2CFeedRsp == null) || (paramStGetC2CFeedRsp.vecFeed.isEmpty())) {
      QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 没有拉到feeds信息");
    }
    do
    {
      do
      {
        return;
        paramStGetC2CFeedRsp = (FeedCloudMeta.StFeed)paramStGetC2CFeedRsp.vecFeed.get().get(0);
        if (paramStGetC2CFeedRsp != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ChatActivityFacade.QCircleFeeds", 2, "addQCircleFeedMessageV2 feed == null");
      return;
      paramStGetC2CFeedRsp = a(paramStGetC2CFeedRsp, paramBoolean);
      if (paramStGetC2CFeedRsp != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QCircleFeeds", 2, "jsonOb == null");
    return;
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.8(paramQQAppInterface, paramSessionInfo, paramStGetC2CFeedRsp, paramBoolean));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (!QzoneConfig.isQQCircleShowAIOFeedEntrance())
    {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "insertQCircleNewestFeedIfNeeded: QzoneConfig.isQQCircleShowLebaEntrance()==false");
      return;
    }
    if (paramSessionInfo.curType != 0)
    {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "insertQCircleNewestFeedIfNeeded failed: sessionInfo.curType == AppConstants.VALUE.UIN_TYPE_FRIEND");
      return;
    }
    ThreadManager.post(new ChatActivityFacade.3(paramQQAppInterface, paramSessionInfo, paramBoolean), 5, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localFileManagerEntity = paramQQAppInterface.getFileManagerDataCenter().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w("ChatActivityFacade", 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        paramQQAppInterface.getTransFileController().removeProcessor(paramQQAppInterface.getTransFileController().makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.getCloudType() != 0) {
          break label139;
        }
        paramQQAppInterface.getOnlineFileSessionCenter().a(localFileManagerEntity.nSessionId);
        paramQQAppInterface.getFileManagerDataCenter().b(localFileManagerEntity);
        if (localFileManagerEntity.getCloudType() == 0) {
          paramQQAppInterface.getOnlineFileSessionCenter().d(localFileManagerEntity.nSessionId);
        }
        paramQQAppInterface.getFileManagerEngine().b(localFileManagerEntity.nSessionId);
      }
    }
    label139:
    do
    {
      return;
      paramQQAppInterface.getFileManagerRSCenter().a(localFileManagerEntity.nSessionId);
      break;
      if ((paramChatMessage instanceof MessageForDevShortVideo))
      {
        ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(0, ((MessageForDevShortVideo)paramChatMessage).fileSessionId, false);
        return;
      }
    } while (!(paramChatMessage instanceof MessageForDevPtt));
    ((DeviceFileHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER)).a(0, ((MessageForDevPtt)paramChatMessage).fileSessionId, false);
  }
  
  public static void b(List<ChatMessage> paramList)
  {
    if ((jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (paramList.size() > 0) && (jdField_a_of_type_JavaUtilList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage1 = (ChatMessage)paramList.next();
        if (jdField_a_of_type_JavaUtilList.contains(localChatMessage1))
        {
          jdField_a_of_type_JavaUtilList.remove(localChatMessage1);
        }
        else if (localChatMessage1.isLongMsg())
        {
          Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
            if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
              localIterator.remove();
            }
          }
        }
      }
      if ((jdField_a_of_type_JavaUtilList.size() == 0) && (b != null)) {
        b.dismiss();
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (FeedsManager.isShowStatus(paramSessionInfo.curFriendUin))
    {
      k(paramQQAppInterface, paramSessionInfo);
      j(paramQQAppInterface, paramSessionInfo);
      return true;
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramArkAppMessage, 0);
  }
  
  @TargetApi(9)
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    EmoticonPackage localEmoticonPackage = ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramString);
    if ((localEmoticonPackage == null) || ((localEmoticonPackage.extraFlags & 0x1) <= 0)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "isShowEmotionRewordTips epId = " + paramString);
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("originalEmotionCountSp_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    int i = paramQQAppInterface.getInt(paramString, 0) + 1;
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putInt(paramString, i);
    if (Build.VERSION.SDK_INT <= 8) {
      paramQQAppInterface.commit();
    }
    while (i == 21)
    {
      return true;
      paramQQAppInterface.apply();
    }
    return false;
  }
  
  public static long[] b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, admo paramadmo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow start, currenttime:" + System.currentTimeMillis());
    }
    String str = a(paramString, paramArrayList);
    if (str == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool4 = false;
    boolean bool3 = false;
    short s2 = 0;
    Random localRandom = new Random();
    for (;;)
    {
      try
      {
        if (a(paramadmo, false))
        {
          localObject = b(str, paramArrayList, paramadmo, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            bool2 = bool4;
            paramString = (String)localObject;
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " mSourceMsgInfo:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
            bool1 = bool3;
            s1 = s2;
          }
          paramString = paramArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 2, currenttime:" + System.currentTimeMillis());
          }
          int j = Math.abs(localRandom.nextInt());
          localObject = new long[paramString.size()];
          int i = 0;
          if (i >= paramString.size()) {
            continue;
          }
          str = (String)paramString.get(i);
          if (localArrayList.size() <= i) {
            continue;
          }
          paramArrayList = (ArrayList)localArrayList.get(i);
          if ((paramSessionInfo.curType == 3000) || (paramSessionInfo.curType == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramadmo, true);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramadmo)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramadmo, localArrayList);
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          bool2 = bool4;
          paramString = (String)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          bool2 = bool4;
          paramString = (String)localObject;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
          s1 = s2;
          bool1 = bool3;
          paramArrayList = (ArrayList<MessageForText.AtTroopMemberInfo>)localObject;
          continue;
          paramArrayList.printStackTrace();
        }
        catch (UnsupportedEncodingException paramArrayList)
        {
          bool1 = bool2;
        }
      }
      catch (UnsupportedEncodingException paramArrayList)
      {
        Object localObject;
        short s1;
        boolean bool2;
        boolean bool1 = false;
        paramString = null;
        continue;
      }
      s1 = 0;
      continue;
      paramArrayList = bhbx.a(str, 560, 20, paramArrayList, localArrayList);
      bool2 = bool4;
      paramString = paramArrayList;
      if (paramArrayList.size() > 1)
      {
        bool1 = true;
        bool2 = bool1;
        paramString = paramArrayList;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          paramString = paramArrayList;
          QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " partArray.size() = " + paramArrayList.size() + " isDivide = " + bool1 + " currenttime:" + System.currentTimeMillis());
        }
        bool2 = bool1;
        paramString = paramArrayList;
        s1 = a(paramQQAppInterface, paramSessionInfo, bool1, (short)0, localRandom);
      }
      else
      {
        bool1 = false;
        continue;
        paramArrayList = null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createTextMessageToshow step 3, currenttime:" + System.currentTimeMillis());
    }
    return localObject;
  }
  
  private static long c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return 0L;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_last_story_feed_create_time_for_aio");
    return paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).getLong(paramSessionInfo, 0L);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramLong);
      paramContext = bcsa.a(paramContext);
      paramQQAppInterface.getMessageFacade().addAndSendMessage(paramContext, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ChatActivityFacade", 2, "resendApolloMessage : mr is null.");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.curType != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.5(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  @TargetApi(9)
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ChatActivityFacade", 1, "insertRenewalTailTipMsgIfNeeded app == null");
    }
    int i;
    do
    {
      do
      {
        return;
        i = paramSessionInfo.curType;
      } while ((i != 0) && (i != 1) && (i != 3000) && (i != 1001) && (i != 10002) && (i != 10004) && (i != 1006) && (i != 1004) && (i != 1000) && (i != 10010) && (i != 3));
      localObject1 = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 4);
      if (!paramBoolean)
      {
        long l = ((SharedPreferences)localObject1).getLong("last_pull_individual_expire_info_time", 0L);
        if (System.currentTimeMillis() - l > 86400000L) {
          break;
        }
      }
      i = ((SharedPreferences)localObject1).getInt("renewal_tail_tip_exit", 0);
    } while (i == 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("renewal_tail_tip", "");
    Object localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putInt("renewal_tail_tip_exit", 0);
    if (Build.VERSION.SDK_INT <= 8) {
      ((SharedPreferences.Editor)localObject1).commit();
    }
    for (;;)
    {
      acnh.a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.curType, -4020);
      paramQQAppInterface.getFileManagerDataCenter().a(paramSessionInfo.curFriendUin, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curType, -4020, (String)localObject2);
      VasWebviewUtil.reportCommercialDrainage(paramSessionInfo.curFriendUin, "aio_pay", "aio_show", "", 1, 0, 0, "", String.valueOf(i), "");
      return;
      localObject2 = (VasExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
      if (localObject2 == null) {
        break;
      }
      ((VasExtensionHandler)localObject2).a(1);
      if (Build.VERSION.SDK_INT <= 8)
      {
        ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).commit();
        return;
      }
      ((SharedPreferences)localObject1).edit().putLong("last_pull_individual_expire_info_time", System.currentTimeMillis()).apply();
      return;
      ((SharedPreferences.Editor)localObject1).apply();
    }
  }
  
  private static boolean c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      bool = false;
    }
    long l1;
    long l2;
    do
    {
      return bool;
      l1 = b(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
      l1 = NetConnInfoCenter.getServerTimeMillis() - l1;
      l2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "requestAIOFeedsDiv", 900000);
      if (l1 <= l2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    return false;
  }
  
  private static long d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   start");
    }
    BeancurdMsg localBeancurdMsg = ((afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).a(paramSessionInfo.curFriendUin, paramSessionInfo.curType, 12);
    long l1;
    if (localBeancurdMsg != null) {
      try
      {
        l1 = new JSONObject(localBeancurdMsg.buffer).optLong("time", 0L);
        l2 = l1;
        if (l1 == 0L) {
          l2 = e(paramQQAppInterface, paramSessionInfo);
        }
        return l2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ChatActivityFacade.QZoneFeeds", 1, "", localJSONException);
          l1 = 0L;
        }
      }
    }
    Object localObject = paramQQAppInterface.getMessageFacade().getAllMessages(paramSessionInfo.curFriendUin, 0, new int[] { -2015 });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageForQzoneFeed)((List)localObject).get(((List)localObject).size() - 1);
      if (localObject != null) {
        ((MessageForQzoneFeed)localObject).parse();
      }
    }
    for (long l2 = ((MessageForQzoneFeed)localObject).feedTime;; l2 = 0L)
    {
      l1 = l2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   没有qzone历史豆腐块,sessionInfo.curFriendUin=" + paramSessionInfo.curFriendUin + ",sessionInfo.curType=" + paramSessionInfo.curType + " busiID=" + 2);
      l1 = l2;
      break;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.curType != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.6(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, paramString);
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, NetConnInfoCenter.getServerTimeMillis()).apply();
  }
  
  private static boolean d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      bool = false;
    }
    long l1;
    long l2;
    do
    {
      return bool;
      l1 = b(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_qcircle_feeds_time");
      l1 = NetConnInfoCenter.getServerTimeMillis() - l1;
      l2 = QzoneConfig.getInstance().getConfig("QZoneSetting", "requestAIOQCircleFeedsDiv", 900000);
      if (l1 <= l2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QCircleFeeds", 2, String.format("与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    return false;
  }
  
  private static boolean d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    do
    {
      return false;
      if (!QZoneHelper.hideAioFeeds()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, "wns 下发配置 要隐藏aio feeds，所以也不发请求了");
    return false;
    if (paramBoolean) {
      return c(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  private static long e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().getAllMessages(paramSessionInfo.curFriendUin, 0, new int[] { -2015 });
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(0);
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForQzoneFeed)))
      {
        paramSessionInfo = (MessageForQzoneFeed)paramQQAppInterface;
        paramSessionInfo.parse();
        if (QLog.isColorLevel()) {
          QLog.w("ChatActivityFacade.QZoneFeeds", 2, "获取到最新空间feeds的：" + String.valueOf(paramQQAppInterface) + "：feeds json:" + paramSessionInfo.feedMsg);
        }
        return paramSessionInfo.feedTime;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message record 有误:" + String.valueOf(paramQQAppInterface));
      }
    }
    for (;;)
    {
      return 0L;
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityFacade.QZoneFeeds", 2, "message recode 为空，无法获取发布时间");
      }
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = bcsa.a(-4005);
    long l = bcrg.a();
    localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin, paramSessionInfo.curFriendUin, BaseApplicationImpl.getContext().getString(2131693779), l, -4005, paramSessionInfo.curType, l);
    localMessageRecord.isread = true;
    if (!anyv.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  private static void e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, "key_request_troop_qcircle_msg_attache_data");
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putString(paramSessionInfo, paramString).apply();
  }
  
  private static boolean e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      bool = false;
    }
    long l;
    do
    {
      return bool;
      l = b(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_story_feed_time");
      l = NetConnInfoCenter.getServerTimeMillis() - l;
      if (l <= 900000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  大于等于 下发配置：%d ms,将返回true，可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
    return true;
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, String.format("Story与上一次请求间隔%d ms  小于 下发配置：%d ms,将返回false，触发了频率控制，不可以进行请求", new Object[] { Long.valueOf(l), Long.valueOf(900000L) }));
    }
    return false;
  }
  
  private static boolean e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    do
    {
      return false;
      if (!QzoneConfig.isQQCircleShowLebaEntrance())
      {
        QLog.i("ChatActivityFacade.QCircleFeeds", 2, "isNeedInsertQCircleNewestFeeds==false: 非小世界灰度用户");
        return false;
      }
      if (!QZoneHelper.hideAioQCircleFeeds()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade.QCircleFeeds", 2, "wns 下发配置 要隐藏aio qcircle feeds，所以也不发请求了");
    return false;
    if (paramBoolean) {
      return d(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  public static void f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Object localObject1 = new EventItem(18, null);
    ((EventItem)localObject1).eventType = 538052865;
    Object localObject2 = new JceOutputStream();
    ((JceOutputStream)localObject2).setServerEncoding("utf-8");
    ((EventItem)localObject1).writeTo((JceOutputStream)localObject2);
    localObject1 = new String(((JceOutputStream)localObject2).toByteArray());
    localObject2 = paramQQAppInterface.getMsgHandler();
    paramSessionInfo = paramSessionInfo.curFriendUin;
    paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
    int i = bcpt.a;
    bcpt.a = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  private static boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    while (QZoneHelper.disableAioStoryFeedReq()) {
      return false;
    }
    if (paramBoolean) {
      return e(paramQQAppInterface, paramSessionInfo);
    }
    return true;
  }
  
  private static void i(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {
      return;
    }
    Object localObject = paramQQAppInterface.getMessageFacade().getAllMessages(paramSessionInfo.curFriendUin, 0, new int[] { -2015 });
    label48:
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label165;
      }
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForQzoneFeed)) || (!((MessageForQzoneFeed)localMessageRecord).isOldStructMsg)) {
        break label175;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade.QZoneFeeds", 2, "删除老结构的feeds");
      }
      paramQQAppInterface.getMessageFacade().removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      paramQQAppInterface.getMessageFacade().removeMsgByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      i = 1;
    }
    label165:
    label175:
    for (;;)
    {
      break label48;
      j = 0;
      if (j == 0) {
        break;
      }
      j(paramQQAppInterface, paramSessionInfo);
      return;
    }
  }
  
  private static void j(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0);
    paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
    localSharedPreferences.edit().remove(paramQQAppInterface).apply();
  }
  
  private static void k(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramSessionInfo = paramQQAppInterface.getMessageFacade().getAllMessages(paramSessionInfo.curFriendUin, 0, new int[] { -2015 });
    if (paramSessionInfo != null)
    {
      paramSessionInfo = paramSessionInfo.iterator();
      while (paramSessionInfo.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramSessionInfo.next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.getMessageFacade().removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().removeMsgByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          bhhr.a(paramQQAppInterface.getCurrentUin(), localMessageRecord.frienduin, 0L);
        }
      }
    }
  }
  
  private static void l(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    a(12, paramQQAppInterface, paramSessionInfo);
  }
  
  private static void m(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "hasNewFlag == 1,且storyFeeds.size =0 ,视为后台让客户端，需要清理本地缓存");
    ((afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(paramSessionInfo.curFriendUin, paramSessionInfo.curType, 7);
    Object localObject = paramQQAppInterface.getMessageFacade().getAllMessages(paramSessionInfo.curFriendUin, 0, new int[] { -2074 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.getMessageFacade().removeMsgFromCacheByUniseq(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().removeMsgByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
    a(paramQQAppInterface, paramSessionInfo, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admh
 * JD-Core Version:    0.7.0.1
 */