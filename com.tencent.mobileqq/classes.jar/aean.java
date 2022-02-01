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
import android.text.TextUtils;
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
import com.tencent.mobileqq.activity.BaseChatPie;
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
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.data.MessageForShakeWindow;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
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

public class aean
{
  public static long a;
  private static aeas jdField_a_of_type_Aeas = new aeas();
  public static blir a;
  public static ChatMessage a;
  public static QQToast a;
  public static List<ChatMessage> a;
  private static ConcurrentHashMap<String, aeat> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static blir b;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private static int a(SessionInfo paramSessionInfo, String paramString)
  {
    if ((!army.c().jdField_b_of_type_Boolean) && ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)))
    {
      paramString = bhjx.a(paramString);
      int j = paramString[0];
      int i = j;
      if (paramSessionInfo.jdField_a_of_type_Int == 1) {
        i = j + paramString[1] * 2;
      }
      return i;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 0) {
      return bhjx.a(paramString)[0];
    }
    return paramString.getBytes("utf-8").length;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<String> paramArrayList)
  {
    long l1 = -1L;
    paramArrayList = bdpt.a(paramArrayList);
    if (paramArrayList != null)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      int i = bcpt.jdField_a_of_type_Int;
      bcpt.jdField_a_of_type_Int = i + 1;
      l1 = i;
      paramSessionInfo = bcry.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l1, paramArrayList);
      long l2 = paramSessionInfo.uniseq;
      paramSessionInfo.msgUid = bcsa.a(paramInt);
      l1 = l2;
      if (!aoci.a(paramQQAppInterface, paramSessionInfo, false))
      {
        paramQQAppInterface.a().a(paramSessionInfo);
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
        int j = bhrp.a(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
        a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, l2, true, i * 1000, j, true, 0, 0, true, localMessageForPtt.vipSubBubbleId, localBundle);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramString, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList, paramaeau, false);
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean1, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc 169
    //   8: iconst_2
    //   9: new 171	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   16: ldc 174
    //   18: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 189
    //   29: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 191	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   36: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +1393 -> 1439
    //   49: aload_2
    //   50: iconst_1
    //   51: aload 9
    //   53: invokestatic 203	bcsa:a	(Ljava/lang/String;ZLjava/util/ArrayList;)Ljava/lang/String;
    //   56: astore 14
    //   58: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc 169
    //   66: iconst_2
    //   67: new 171	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   74: ldc 205
    //   76: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   82: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 10
    //   93: getfield 210	aeau:jdField_e_of_type_Long	J
    //   96: lconst_0
    //   97: lcmp
    //   98: ifeq +663 -> 761
    //   101: new 212	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   104: dup
    //   105: invokespecial 213	com/tencent/mobileqq/data/MessageForWantGiftMsg:<init>	()V
    //   108: astore_2
    //   109: aload_2
    //   110: checkcast 212	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   113: aload 10
    //   115: getfield 210	aeau:jdField_e_of_type_Long	J
    //   118: putfield 216	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   121: aload_2
    //   122: checkcast 212	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   125: getstatic 219	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   128: new 171	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   135: aload 10
    //   137: getfield 210	aeau:jdField_e_of_type_Long	J
    //   140: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: ldc 221
    //   145: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 225	com/tencent/mobileqq/data/MessageForWantGiftMsg:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_2
    //   155: sipush -2056
    //   158: putfield 230	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   161: aload_0
    //   162: aload_2
    //   163: aload_1
    //   164: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   167: aload_1
    //   168: getfield 232	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   171: aload_1
    //   172: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   175: invokestatic 235	bcry:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   178: aload_2
    //   179: aload 14
    //   181: putfield 238	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   184: aload_2
    //   185: iload 8
    //   187: invokestatic 101	bcsa:a	(I)J
    //   190: putfield 239	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   193: aload_2
    //   194: iload 5
    //   196: putfield 242	com/tencent/mobileqq/data/ChatMessage:longMsgCount	I
    //   199: aload_2
    //   200: iload 6
    //   202: putfield 245	com/tencent/mobileqq/data/ChatMessage:longMsgIndex	I
    //   205: aload_2
    //   206: iload 7
    //   208: putfield 248	com/tencent/mobileqq/data/ChatMessage:longMsgId	I
    //   211: aload_2
    //   212: iconst_1
    //   213: putfield 251	com/tencent/mobileqq/data/ChatMessage:mAnimFlag	Z
    //   216: aload 10
    //   218: getfield 254	aeau:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   221: ifnull +30 -> 251
    //   224: aload_2
    //   225: ldc_w 256
    //   228: aload 10
    //   230: getfield 254	aeau:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   233: invokevirtual 261	com/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo:toJsonString	()Ljava/lang/String;
    //   236: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_2
    //   240: aconst_null
    //   241: invokestatic 267	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;)V
    //   244: invokestatic 270	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   247: aload_2
    //   248: invokevirtual 271	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   251: aload 10
    //   253: getfield 274	aeau:i	Z
    //   256: ifeq +8 -> 264
    //   259: aload_2
    //   260: iconst_m1
    //   261: putfield 277	com/tencent/mobileqq/data/ChatMessage:mRobotFlag	I
    //   264: aload 10
    //   266: getfield 280	aeau:jdField_g_of_type_Int	I
    //   269: iconst_m1
    //   270: if_icmpeq +18 -> 288
    //   273: aload_2
    //   274: ldc_w 282
    //   277: aload 10
    //   279: getfield 280	aeau:jdField_g_of_type_Int	I
    //   282: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_2
    //   289: instanceof 288
    //   292: ifeq +979 -> 1271
    //   295: aload_2
    //   296: checkcast 288	com/tencent/mobileqq/data/MessageForReplyText
    //   299: astore 14
    //   301: aload 14
    //   303: aload_1
    //   304: getfield 191	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   307: putfield 291	com/tencent/mobileqq/data/MessageForReplyText:msgVia	I
    //   310: aload 14
    //   312: aload 10
    //   314: getfield 293	aeau:jdField_d_of_type_Boolean	Z
    //   317: putfield 296	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   320: aload 14
    //   322: aload 10
    //   324: getfield 298	aeau:jdField_b_of_type_Long	J
    //   327: putfield 301	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   330: aload 14
    //   332: aload 10
    //   334: getfield 303	aeau:jdField_d_of_type_Int	I
    //   337: putfield 306	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   340: aload 14
    //   342: getfield 296	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   345: ifeq +35 -> 380
    //   348: aload 14
    //   350: ldc_w 308
    //   353: aload 14
    //   355: getfield 301	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   358: invokestatic 311	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   361: invokevirtual 312	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload 14
    //   366: ldc_w 314
    //   369: aload 14
    //   371: getfield 306	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   374: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   377: invokevirtual 312	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 9
    //   382: ifnull +10 -> 392
    //   385: aload 14
    //   387: aload 9
    //   389: putfield 318	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   392: aload 10
    //   394: getfield 321	aeau:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   397: invokestatic 326	apdm:a	(Ljava/io/Serializable;)[B
    //   400: invokestatic 331	bhml:a	([B)Ljava/lang/String;
    //   403: astore 9
    //   405: aload 14
    //   407: aload 10
    //   409: getfield 321	aeau:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   412: putfield 334	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   415: aload 14
    //   417: ldc_w 336
    //   420: aload 9
    //   422: invokevirtual 312	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 14
    //   427: aload 14
    //   429: getfield 339	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   432: iconst_1
    //   433: ior
    //   434: putfield 339	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   437: aload 14
    //   439: getfield 334	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   442: invokevirtual 345	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:getSourceMsg	()[B
    //   445: ifnull +17 -> 462
    //   448: aload 14
    //   450: aload 14
    //   452: getfield 334	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   455: aload_0
    //   456: invokevirtual 349	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:unPackSourceMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   459: invokevirtual 352	com/tencent/mobileqq/data/MessageForReplyText:setSourceMessageRecord	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   462: aload 10
    //   464: getfield 353	aeau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   467: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   470: ifne +40 -> 510
    //   473: aload 10
    //   475: getfield 360	aeau:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   478: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +29 -> 510
    //   484: aload 14
    //   486: ldc_w 362
    //   489: aload 10
    //   491: getfield 353	aeau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokevirtual 312	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload 14
    //   499: ldc_w 364
    //   502: aload 10
    //   504: getfield 360	aeau:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   507: invokevirtual 312	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 10
    //   512: getfield 366	aeau:jdField_e_of_type_Int	I
    //   515: ifle +23 -> 538
    //   518: invokestatic 371	agsg:a	()Lagsg;
    //   521: aload_2
    //   522: getfield 372	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   525: aload 10
    //   527: getfield 374	aeau:jdField_c_of_type_Long	J
    //   530: aload 10
    //   532: getfield 366	aeau:jdField_e_of_type_Int	I
    //   535: invokevirtual 377	agsg:a	(JJI)V
    //   538: aload_2
    //   539: getfield 380	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   542: iconst_1
    //   543: if_icmpne +765 -> 1308
    //   546: invokestatic 385	nlj:a	()Lnlj;
    //   549: aload_2
    //   550: invokevirtual 386	nlj:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   553: aload 10
    //   555: getfield 387	aeau:jdField_b_of_type_Boolean	Z
    //   558: ifeq +7 -> 565
    //   561: aload_2
    //   562: invokestatic 390	asam:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   565: aload_2
    //   566: getfield 380	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   569: sipush 1033
    //   572: if_icmpeq +13 -> 585
    //   575: aload_2
    //   576: getfield 380	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   579: sipush 1034
    //   582: if_icmpne +745 -> 1327
    //   585: aload_0
    //   586: aload_2
    //   587: aload_2
    //   588: getfield 393	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   591: aload_2
    //   592: getfield 380	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   595: aload_1
    //   596: getfield 394	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_e_of_type_Int	I
    //   599: invokestatic 399	aqyt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;II)V
    //   602: aload_1
    //   603: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   606: sipush 10007
    //   609: if_icmpne +16 -> 625
    //   612: aload_0
    //   613: aload_2
    //   614: aload_2
    //   615: getfield 393	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   618: aload_2
    //   619: getfield 380	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   622: invokestatic 404	avlm:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Ljava/lang/String;I)V
    //   625: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +58 -> 686
    //   631: ldc 169
    //   633: iconst_2
    //   634: new 171	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 406
    //   644: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload_2
    //   648: getfield 409	com/tencent/mobileqq/data/ChatMessage:time	J
    //   651: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   654: ldc_w 411
    //   657: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_2
    //   661: getfield 414	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   664: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 416
    //   670: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_2
    //   674: getfield 239	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   677: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   680: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: aload 10
    //   688: getfield 419	aeau:f	Z
    //   691: istore 4
    //   693: aload 10
    //   695: getfield 421	aeau:jdField_g_of_type_Boolean	Z
    //   698: ifeq +710 -> 1408
    //   701: iload 4
    //   703: ifeq +662 -> 1365
    //   706: aload_0
    //   707: sipush 166
    //   710: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   713: checkcast 427	axoz
    //   716: aload_0
    //   717: aload_2
    //   718: iconst_0
    //   719: invokevirtual 430	axoz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   722: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +31 -> 756
    //   728: ldc 169
    //   730: iconst_2
    //   731: new 171	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 432
    //   741: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokestatic 184	java/lang/System:currentTimeMillis	()J
    //   747: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   750: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: aload_2
    //   757: getfield 372	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   760: lreturn
    //   761: aload 10
    //   763: getfield 434	aeau:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   766: ifnull +45 -> 811
    //   769: aload_0
    //   770: invokestatic 439	akwu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   773: ifeq +38 -> 811
    //   776: new 441	com/tencent/mobileqq/data/MessageForFoldMsg
    //   779: dup
    //   780: invokespecial 442	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   783: astore_2
    //   784: aload_2
    //   785: checkcast 441	com/tencent/mobileqq/data/MessageForFoldMsg
    //   788: iconst_0
    //   789: aload 10
    //   791: getfield 434	aeau:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload 10
    //   796: getfield 444	aeau:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   799: aload 10
    //   801: getfield 446	aeau:jdField_d_of_type_Long	J
    //   804: iconst_1
    //   805: invokevirtual 450	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;Ljava/lang/String;JZ)V
    //   808: goto -647 -> 161
    //   811: aload 10
    //   813: getfield 321	aeau:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   816: ifnonnull +31 -> 847
    //   819: aload 10
    //   821: getfield 419	aeau:f	Z
    //   824: ifeq +23 -> 847
    //   827: aload_0
    //   828: invokestatic 451	axoz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   831: ifeq +16 -> 847
    //   834: sipush -1051
    //   837: invokestatic 454	bcry:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   840: checkcast 227	com/tencent/mobileqq/data/ChatMessage
    //   843: astore_2
    //   844: goto -683 -> 161
    //   847: aload 10
    //   849: getfield 321	aeau:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   852: ifnull +579 -> 1431
    //   855: sipush -1049
    //   858: istore 12
    //   860: iload 12
    //   862: invokestatic 454	bcry:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   865: checkcast 227	com/tencent/mobileqq/data/ChatMessage
    //   868: astore_2
    //   869: aload_0
    //   870: bipush 51
    //   872: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   875: checkcast 456	anyw
    //   878: astore 15
    //   880: aload 15
    //   882: aload_0
    //   883: invokevirtual 458	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   886: iconst_0
    //   887: invokevirtual 461	anyw:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   890: astore 16
    //   892: aload 16
    //   894: ifnull +56 -> 950
    //   897: aload_2
    //   898: ldc_w 463
    //   901: aload 16
    //   903: invokestatic 468	gc:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)I
    //   906: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   909: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: aload_2
    //   913: ldc_w 470
    //   916: aload 16
    //   918: getfield 475	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   921: invokestatic 478	gc:c	(J)I
    //   924: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   927: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   930: iconst_1
    //   931: aload 16
    //   933: getfield 481	com/tencent/mobileqq/data/ExtensionInfo:magicFont	I
    //   936: if_icmpne +247 -> 1183
    //   939: aload_2
    //   940: ldc_w 483
    //   943: iconst_0
    //   944: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   947: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: aload 15
    //   952: aload_0
    //   953: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   956: invokevirtual 486	anyw:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   959: astore 15
    //   961: aload 15
    //   963: ifnull +175 -> 1138
    //   966: aload 15
    //   968: getstatic 492	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   971: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   974: ifeq +78 -> 1052
    //   977: iconst_1
    //   978: istore_3
    //   979: aload 15
    //   981: getstatic 492	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   984: invokevirtual 502	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   987: iconst_1
    //   988: if_icmpne +5 -> 993
    //   991: iconst_3
    //   992: istore_3
    //   993: aload_2
    //   994: ldc_w 504
    //   997: iload_3
    //   998: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1001: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1004: aload_2
    //   1005: ldc_w 506
    //   1008: aload 15
    //   1010: getstatic 492	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   1013: invokevirtual 509	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1016: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1019: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_2
    //   1023: ldc_w 511
    //   1026: aload 15
    //   1028: getfield 514	com/tencent/mobileqq/data/Friends:bigClubTemplateId	I
    //   1031: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1034: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: aload_2
    //   1038: ldc_w 516
    //   1041: aload 15
    //   1043: getfield 519	com/tencent/mobileqq/data/Friends:bigClubExtTemplateId	I
    //   1046: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1049: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1052: aload 15
    //   1054: getstatic 522	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1057: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1060: ifne +14 -> 1074
    //   1063: aload 15
    //   1065: getstatic 525	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1068: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1071: ifeq +67 -> 1138
    //   1074: aload 15
    //   1076: getstatic 525	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1079: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1082: ifeq +119 -> 1201
    //   1085: sipush 256
    //   1088: istore_3
    //   1089: aload 15
    //   1091: getstatic 525	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1094: invokevirtual 502	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1097: iconst_1
    //   1098: if_icmpne +7 -> 1105
    //   1101: sipush 258
    //   1104: istore_3
    //   1105: aload 15
    //   1107: getstatic 525	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1110: invokevirtual 509	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1113: istore 13
    //   1115: aload_2
    //   1116: ldc_w 527
    //   1119: iload_3
    //   1120: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1123: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload_2
    //   1127: ldc_w 529
    //   1130: iload 13
    //   1132: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1135: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1138: aload 9
    //   1140: ifnull +13 -> 1153
    //   1143: aload_1
    //   1144: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1147: aload 9
    //   1149: aload_2
    //   1150: invokestatic 534	bgme:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1153: iload 12
    //   1155: sipush -1000
    //   1158: if_icmpne +22 -> 1180
    //   1161: aload 10
    //   1163: getfield 537	aeau:h	Z
    //   1166: ifeq +14 -> 1180
    //   1169: aload_2
    //   1170: ldc_w 539
    //   1173: iconst_1
    //   1174: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1177: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1180: goto -1019 -> 161
    //   1183: aload_2
    //   1184: ldc_w 483
    //   1187: aload 16
    //   1189: getfield 542	com/tencent/mobileqq/data/ExtensionInfo:fontEffect	I
    //   1192: invokestatic 286	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1195: invokevirtual 262	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1198: goto -248 -> 950
    //   1201: iconst_1
    //   1202: istore_3
    //   1203: aload 15
    //   1205: getstatic 522	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1208: invokevirtual 502	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1211: iconst_1
    //   1212: if_icmpne +5 -> 1217
    //   1215: iconst_3
    //   1216: istore_3
    //   1217: aload 15
    //   1219: getstatic 522	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1222: invokevirtual 509	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1225: istore 13
    //   1227: goto -112 -> 1115
    //   1230: astore 9
    //   1232: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1235: ifeq -697 -> 538
    //   1238: ldc 169
    //   1240: iconst_2
    //   1241: new 171	java/lang/StringBuilder
    //   1244: dup
    //   1245: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1248: ldc_w 544
    //   1251: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: aload 9
    //   1256: invokevirtual 547	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1259: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1262: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1265: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1268: goto -730 -> 538
    //   1271: aload_2
    //   1272: checkcast 549	com/tencent/mobileqq/data/MessageForText
    //   1275: astore 14
    //   1277: aload 14
    //   1279: aload_1
    //   1280: getfield 191	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   1283: putfield 550	com/tencent/mobileqq/data/MessageForText:msgVia	I
    //   1286: aload 9
    //   1288: ifnull +10 -> 1298
    //   1291: aload 14
    //   1293: aload 9
    //   1295: putfield 551	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   1298: aload 14
    //   1300: aload 10
    //   1302: invokevirtual 555	com/tencent/mobileqq/data/MessageForText:setSendMsgParams	(Laeau;)V
    //   1305: goto -767 -> 538
    //   1308: invokestatic 385	nlj:a	()Lnlj;
    //   1311: getfield 557	nlj:jdField_a_of_type_Boolean	Z
    //   1314: ifeq -761 -> 553
    //   1317: invokestatic 385	nlj:a	()Lnlj;
    //   1320: iconst_0
    //   1321: putfield 557	nlj:jdField_a_of_type_Boolean	Z
    //   1324: goto -771 -> 553
    //   1327: aload_1
    //   1328: getfield 560	com/tencent/mobileqq/activity/aio/SessionInfo:j	Z
    //   1331: ifeq +15 -> 1346
    //   1334: aload_0
    //   1335: aload_2
    //   1336: aload_1
    //   1337: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1340: invokestatic 563	aqyt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1343: goto -741 -> 602
    //   1346: aload_1
    //   1347: getfield 566	com/tencent/mobileqq/activity/aio/SessionInfo:k	Z
    //   1350: ifeq -748 -> 602
    //   1353: aload_0
    //   1354: aload_2
    //   1355: aload_1
    //   1356: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1359: invokestatic 568	aqyt:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1362: goto -760 -> 602
    //   1365: iload 11
    //   1367: ifeq +29 -> 1396
    //   1370: aload_0
    //   1371: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1374: aload_2
    //   1375: invokevirtual 570	com/tencent/imcore/message/QQMessageFacade:c	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1378: goto -656 -> 722
    //   1381: astore_0
    //   1382: ldc_w 572
    //   1385: iconst_1
    //   1386: ldc_w 574
    //   1389: aload_0
    //   1390: invokestatic 577	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1393: goto -671 -> 722
    //   1396: aload_0
    //   1397: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1400: aload_2
    //   1401: aconst_null
    //   1402: invokevirtual 580	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Laocj;)V
    //   1405: goto -683 -> 722
    //   1408: new 582	com/tencent/mobileqq/activity/ChatActivityFacade$13
    //   1411: dup
    //   1412: iload 4
    //   1414: aload_0
    //   1415: aload_2
    //   1416: iload 11
    //   1418: invokespecial 585	com/tencent/mobileqq/activity/ChatActivityFacade$13:<init>	(ZLcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Z)V
    //   1421: bipush 10
    //   1423: aconst_null
    //   1424: iconst_0
    //   1425: invokestatic 591	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1428: goto -706 -> 722
    //   1431: sipush -1000
    //   1434: istore 12
    //   1436: goto -576 -> 860
    //   1439: ldc 221
    //   1441: astore 14
    //   1443: goto -1385 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1446	0	paramQQAppInterface	QQAppInterface
    //   0	1446	1	paramSessionInfo	SessionInfo
    //   0	1446	2	paramString	String
    //   0	1446	3	paramInt1	int
    //   0	1446	4	paramBoolean1	boolean
    //   0	1446	5	paramByte1	byte
    //   0	1446	6	paramByte2	byte
    //   0	1446	7	paramShort	short
    //   0	1446	8	paramInt2	int
    //   0	1446	9	paramArrayList	ArrayList<MessageForText.AtTroopMemberInfo>
    //   0	1446	10	paramaeau	aeau
    //   0	1446	11	paramBoolean2	boolean
    //   858	577	12	i	int
    //   1113	113	13	j	int
    //   56	1386	14	localObject1	Object
    //   878	340	15	localObject2	Object
    //   890	298	16	localExtensionInfo	ExtensionInfo
    // Exception table:
    //   from	to	target	type
    //   392	462	1230	java/lang/Exception
    //   462	510	1230	java/lang/Exception
    //   510	538	1230	java/lang/Exception
    //   706	722	1381	java/lang/Exception
    //   1370	1378	1381	java/lang/Exception
    //   1396	1405	1381	java/lang/Exception
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = beyo.a(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = bcry.a(-20000);
      paramString3.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((aogu)paramQQAppInterface.a(13)).a(paramString3);
      paramQQAppInterface.a().a(paramString3, paramQQAppInterface.getCurrentAccountUin());
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
    paramQQAppInterface = bcry.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.path = paramString;
    paramQQAppInterface.size = 0L;
    paramQQAppInterface.type = 1;
    paramQQAppInterface.isRead = true;
    paramQQAppInterface.serial();
    return paramQQAppInterface;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend start, currenttime:" + System.currentTimeMillis() + " sessionInfo.entrance:" + paramSessionInfo.c);
    }
    if (paramString != null) {}
    for (String str = bcsa.a(paramString, true, paramArrayList);; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 1  currenttime:" + System.currentTimeMillis());
      }
      if (paramaeau.jdField_e_of_type_Long != 0L)
      {
        paramString = new MessageForWantGiftMsg();
        ((MessageForWantGiftMsg)paramString).wantGiftSenderUin = paramaeau.jdField_e_of_type_Long;
        ((MessageForWantGiftMsg)paramString).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramaeau.jdField_e_of_type_Long + "");
        paramString.msgtype = -2056;
      }
      for (;;)
      {
        bcry.a(paramQQAppInterface, paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
        paramString.msg = str;
        paramString.msgUid = bcsa.a(paramInt2);
        paramString.longMsgCount = paramByte1;
        paramString.longMsgIndex = paramByte2;
        paramString.longMsgId = paramShort;
        paramString.mAnimFlag = true;
        if (paramaeau.i) {
          paramString.mRobotFlag = -1;
        }
        paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramaeau.jdField_g_of_type_Int));
        if (!(paramString instanceof MessageForReplyText)) {
          break label732;
        }
        paramQQAppInterface = (MessageForReplyText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.c;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        try
        {
          paramQQAppInterface.saveExtInfoToExtStr("sens_msg_source_msg_info", bhml.a(apdm.a(paramaeau.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo)));
          if ((!TextUtils.isEmpty(paramaeau.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramaeau.jdField_b_of_type_JavaLangString)))
          {
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_msg", paramaeau.jdField_a_of_type_JavaLangString);
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_at_list", paramaeau.jdField_b_of_type_JavaLangString);
          }
          paramQQAppInterface.mSourceMsgInfo = paramaeau.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
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
          break label765;
        }
        nlj.a().a(paramString);
        label373:
        if (paramaeau.jdField_b_of_type_Boolean) {
          asam.a(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramString.time + " senderUin = " + paramString.senderuin + " msgUid = " + paramString.msgUid);
        }
        return paramString;
        if ((paramaeau.jdField_c_of_type_JavaLangString != null) && (akwu.a(paramQQAppInterface)))
        {
          paramString = new MessageForFoldMsg();
          ((MessageForFoldMsg)paramString).init(false, paramaeau.jdField_c_of_type_JavaLangString, paramaeau.jdField_d_of_type_JavaLangString, paramaeau.jdField_d_of_type_Long, true);
        }
        else
        {
          if ((paramaeau.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) || (!paramaeau.f) || (!axoz.a(paramQQAppInterface))) {
            break;
          }
          paramString = (ChatMessage)bcry.a(-1051);
        }
      }
      if (paramaeau.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {}
      for (paramInt1 = -1049;; paramInt1 = -1000)
      {
        paramString = (ChatMessage)bcry.a(paramInt1);
        ExtensionInfo localExtensionInfo = ((anyw)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.c(), false);
        if (localExtensionInfo != null)
        {
          paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(gc.a(localExtensionInfo)));
          paramString.saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(gc.c(localExtensionInfo.uVipFont)));
          if (1 != localExtensionInfo.magicFont) {
            break label675;
          }
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
        }
        for (;;)
        {
          if (paramArrayList != null) {
            bgme.a(paramSessionInfo.jdField_a_of_type_Int, paramArrayList, paramString);
          }
          if ((paramInt1 == -1000) && (paramaeau.h)) {
            paramString.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(1));
          }
          break;
          label675:
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(localExtensionInfo.fontEffect));
        }
        label732:
        paramQQAppInterface = (MessageForText)paramString;
        paramQQAppInterface.msgVia = paramSessionInfo.c;
        if (paramArrayList != null) {
          paramQQAppInterface.atInfoList = paramArrayList;
        }
        paramQQAppInterface.setSendMsgParams(paramaeau);
        break label358;
        label765:
        if (!nlj.a().jdField_a_of_type_Boolean) {
          break label373;
        }
        nlj.a().jdField_a_of_type_Boolean = false;
        break label373;
      }
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau)
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
        if (a(paramaeau, false))
        {
          paramArrayList = b(str, paramArrayList, paramaeau, localArrayList);
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
            if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
              i = Math.abs(localRandom.nextInt());
            }
            return a(paramQQAppInterface, paramSessionInfo, str, -1000, bool, (byte)paramString.size(), (byte)0, s, i, paramArrayList, paramaeau);
          }
        }
        else
        {
          if (a(paramQQAppInterface, paramSessionInfo, str, paramaeau))
          {
            paramArrayList = a(str, paramArrayList, paramaeau, localArrayList);
            paramString = paramArrayList;
            if (!QLog.isColorLevel()) {
              break label512;
            }
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramString = paramArrayList;
            continue;
          }
          paramString = bhjx.a(str, 560, 20, paramArrayList, localArrayList);
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
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (paramSessionInfo != null)
      {
        int i = paramSessionInfo.jdField_a_of_type_Int;
        localObject1 = bcry.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i);
        ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(paramInt2, paramString);
        ((MessageForPtt)localObject1).fileSize = paramInt1;
        ((MessageForPtt)localObject1).itemType = 2;
        if ((!bduh.a(i)) || (!bduh.a(paramQQAppInterface))) {
          break label186;
        }
        paramInt1 = 1;
        ((MessageForPtt)localObject1).sttAbility = paramInt1;
        ((MessageForPtt)localObject1).voiceType = paramInt2;
        ((MessageForPtt)localObject1).longPttVipFlag = bcsa.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        nlj.a().a((MessageRecord)localObject1);
        if ((paramSessionInfo.jdField_a_of_type_Int != 1033) && ((paramSessionInfo.jdField_a_of_type_Int != 1034) || (paramSessionInfo.jdField_e_of_type_Int <= 0))) {
          break label191;
        }
        aqyt.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      ((MessageForPtt)localObject1).serial();
      ((aogu)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
      return localObject1;
      label186:
      paramInt1 = 0;
      break;
      label191:
      if (paramSessionInfo.j) {
        aqyt.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString);
      } else if (paramSessionInfo.k) {
        aqyt.b(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (adak.d(paramSessionInfo.jdField_a_of_type_Int))
    {
      paramQQAppInterface = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!bhnt.b(paramSessionInfo.issend)) {
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
        localObject1 = bcry.a(paramMessageForPtt);
        ((aogu)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
        paramQQAppInterface.a().a((MessageRecord)localObject1, paramQQAppInterface.getCurrentAccountUin());
      }
    }
    return localObject1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    paramString = a(paramQQAppInterface, paramString, paramSessionInfo, paramInt1, paramInt2);
    if (paramString != null)
    {
      paramString.msgVia = paramSessionInfo.c;
      paramQQAppInterface.a().a(paramString, paramQQAppInterface.getCurrentAccountUin());
    }
    while (!QLog.isColorLevel()) {
      return paramString;
    }
    QLog.d("ChatActivityFacade", 2, "createPttMessage null");
    return paramString;
  }
  
  public static AbsShareMsg a(Context paramContext, MessageRecord paramMessageRecord, String paramString)
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
      paramMessageRecord = paramContext.getString(2131690644);
      paramContext = new bdoi(StructMsgForGeneralShare.class).c(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).d(paramContext.getResources().getString(2131693891)).a();
      paramMessageRecord = new bdqs(localArrayList);
      paramMessageRecord.a(new bdqq());
      paramMessageRecord.a(new bdtj(anzj.a(2131700465)));
      paramContext.addItem(paramMessageRecord);
      return paramContext;
    }
    label244:
    String str;
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramString = (MessageForReplyText)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        str = paramString;
        if (behh.a(paramString)) {
          str = behh.d(paramString);
        }
        if (!nlj.a(paramMessageRecord)) {
          break label386;
        }
      }
    }
    for (;;)
    {
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
      break;
      paramString = paramString.msg;
      break label244;
      paramString = (MessageForLongTextMsg)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        label323:
        str = paramString;
        if (behh.a(paramString)) {
          str = behh.d(paramString);
        }
        if (!nlj.a(paramMessageRecord)) {
          break label380;
        }
      }
      for (;;)
      {
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.f * 0.8F), 2, i, str).toString();
        break;
        paramString = paramString.msg;
        break label323;
        label380:
        i = 60;
      }
      label386:
      i = 60;
    }
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
      localObject1 = (String)paramMap.get(adak.c((MessageRecord)localObject3));
      paramString = (String)localObject1;
      if (((ChatMessage)localObject3).istroop == 1) {
        paramString = behh.h((String)localObject1);
      }
      label128:
      if ((TextUtils.isEmpty(paramString)) || (paramString.trim().length() == 0)) {
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
      localObject1 = axpm.a(((ChatMessage)localObject3).senderuin);
      break label185;
      label381:
      if ((localObject3 instanceof MessageForShortVideo))
      {
        if (((ChatMessage)localObject3).msgtype == -2071) {
          paramString = anzj.a(2131700469);
        } else {
          paramString = anzj.a(2131700478);
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
            if (behh.a(paramString)) {
              str = behh.d(paramString);
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
          paramString = anzj.a(2131700486);
          continue;
          paramString = paramContext.getString(2131690644);
          localObject3 = new bdoi(StructMsgForGeneralShare.class).c(35).a(anzj.a(2131700485)).a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).a();
          localObject4 = new bdqs();
          ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
          if ((localChatMessage.istroop == 1) || (localChatMessage.istroop == 3000)) {
            paramContext = anzj.a(2131700466);
          }
          for (;;)
          {
            paramString = paramContext;
            if (TextUtils.isEmpty(paramContext))
            {
              QLog.w("ChatActivityFacade", 1, "generateMultiMsgForwardStructMsg: titleStr is null");
              paramString = anzj.a(2131700482);
            }
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG.Nest", 2, String.format("step.generateStructMsgContent:titleStr = %s,listSize = %d,firstMsg.istroop = %d", new Object[] { paramString, Integer.valueOf(paramList.size()), Integer.valueOf(localChatMessage.istroop) }));
            }
            paramContext = new StructMsgItemTitle(paramString);
            paramContext.f("34");
            paramContext.g("12");
            paramContext.h("2");
            ((bdom)localObject4).a(paramContext);
            paramContext = localArrayList.iterator();
            for (;;)
            {
              if (paramContext.hasNext())
              {
                paramString = (bdol)paramContext.next();
                if ((paramString instanceof bdon))
                {
                  paramMap = (bdon)paramString;
                  paramMap.f("26");
                  paramMap.e("#777777");
                  paramMap.g("12");
                  paramMap.h("4");
                }
                ((bdom)localObject4).a(paramString);
                continue;
                if (localChatMessage.istroop != 0) {
                  break label1404;
                }
                paramString = localChatMessage.senderuin;
                if (TextUtils.equals(localChatMessage.senderuin, localChatMessage.selfuin))
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
                  if (!TextUtils.isEmpty(paramString)) {
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
              if (!TextUtils.equals(paramString, paramMap.senderuin))
              {
                paramBoolean = false;
                if ((localObject2 == null) || (((String)localObject2).trim().length() == 0)) {
                  QLog.d("MultiMsg_TAG", 2, "firstNick is null !!!");
                }
                for (paramString = axpm.a(localChatMessage.senderuin);; paramString = (String)localObject2)
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
                      paramMap = axpm.a((String)localObject1);
                    }
                  }
                  localObject1 = new Paint();
                  ((Paint)localObject1).setTextSize(34.0F);
                  paramContext = a(paramContext, paramString, paramMap, 2, (int)(BaseChatItemLayout.f * 0.7F), 2048, (Paint)localObject1, paramBoolean);
                  break;
                  ((bdom)localObject4).a(new bdqq());
                  paramContext = new bdtj(String.format(anzj.a(2131700463), new Object[] { Integer.valueOf(paramList.size()) }));
                  paramContext.f("26");
                  paramContext.e("#777777");
                  ((bdom)localObject4).a(paramContext);
                  ((AbsShareMsg)localObject3).addItem((bdol)localObject4);
                  ((AbsShareMsg)localObject3).mTSum = paramList.size();
                  if (QLog.isColorLevel())
                  {
                    paramContext = bdqf.b(((AbsShareMsg)localObject3).getXmlBytes());
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
    if (TextUtils.isEmpty(paramString1))
    {
      paramContext = str;
      return paramContext;
    }
    str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = "";
    }
    paramString2 = paramString1 + anzj.a(2131700471) + str + anzj.a(2131700464);
    if (paramBoolean) {
      paramString2 = paramString1 + anzj.a(2131700488);
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
        paramString2 = paramString2 + anzj.a(2131700491);
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
        paramString2 = paramString2 + anzj.a(2131700479);
        paramPaint = paramString2 + paramPaint;
        paramString2 = paramPaint;
        if (paramInt2 < str.length()) {
          paramString2 = paramPaint + "...";
        }
        paramString2 = paramString2 + anzj.a(2131700487);
        break;
      }
    }
    return paramString2;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.c();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
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
      localObject1 = (String)paramMap.get(adak.c((MessageRecord)localObject2));
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label589;
      }
    }
    for (;;)
    {
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = anzj.a(2131700489);
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
          localObject2 = anzj.a(2131700477);
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
            if (behh.a((String)localObject2)) {
              localObject1 = behh.d((String)localObject2);
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
          localObject1 = behh.b(localStringBuilder2.toString());
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
  private static ArrayList<String> a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramArrayList1.add(paramArrayList);
    paramaeau.f = true;
    return localArrayList;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo, boolean paramBoolean, int paramInt)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    Object localObject = anzj.a(2131700484);
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
    Object localObject1 = anzj.a(2131700484);
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
      ((JSONObject)localObject1).put("videoCount", paramStFeed.video.vecVideoUrl.get().size());
      ((JSONObject)localObject1).put("lbsinfo", paramStFeed.poiInfo.get());
      ((JSONObject)localObject1).put("time", paramStFeed.createTime.get());
      ((JSONObject)localObject1).put("type", paramStFeed.type.get());
      ((JSONObject)localObject1).put("version", 2);
      ((JSONObject)localObject1).put("isFirstMsgWithNewFriend", paramBoolean);
      JSONArray localJSONArray = new JSONArray();
      if (paramStFeed.type.get() == 2)
      {
        paramStFeed = paramStFeed.images.get().iterator();
        while (paramStFeed.hasNext())
        {
          localObject2 = (FeedCloudMeta.StImage)paramStFeed.next();
          MessageForQCircleFeed.MediaData localMediaData = new MessageForQCircleFeed.MediaData();
          localMediaData.mediaUrl = ((FeedCloudMeta.StImage)localObject2).picUrl.get();
          localMediaData.type = 2;
          localJSONArray.put(localMediaData.toJson());
        }
      }
      Object localObject2 = new MessageForQCircleFeed.MediaData();
      ((MessageForQCircleFeed.MediaData)localObject2).mediaUrl = paramStFeed.video.playUrl.get();
      ((MessageForQCircleFeed.MediaData)localObject2).type = 3;
      localJSONArray.put(((MessageForQCircleFeed.MediaData)localObject2).toJson());
      ((JSONObject)localObject1).put("mediaDatas", localJSONArray.toString());
      return localObject1;
    }
    catch (JSONException paramStFeed) {}
    return null;
  }
  
  private static short a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, short paramShort, Random paramRandom)
  {
    if (paramBoolean)
    {
      int i = bcpt.jdField_a_of_type_Int;
      bcpt.jdField_a_of_type_Int = i + 1;
      paramShort = (short)(byte)i;
      i = 0;
      for (;;)
      {
        short s = paramShort;
        if (paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, paramShort))
        {
          if (i > 10) {
            s = (short)(byte)paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int);
          }
        }
        else
        {
          paramQQAppInterface.a().a(paramQQAppInterface.getAccount(), paramSessionInfo.jdField_a_of_type_Int, s);
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
    if ((jdField_a_of_type_Blir != null) && (jdField_a_of_type_Blir.isShowing())) {}
    try
    {
      jdField_a_of_type_Blir.dismiss();
      jdField_a_of_type_Blir = null;
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
    ((aggr)paramQQAppInterface.getManager(282)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramInt);
    k(paramQQAppInterface, paramSessionInfo);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Bundle paramBundle)
  {
    paramString4 = nod.a(paramString4, 45, "UTF-8", "...");
    paramString5 = nod.a(paramString5, 90, "UTF-8", "...");
    if (!paramContext.getResources().getString(2131695438).equals(paramString4))
    {
      paramString3 = paramContext.getResources().getString(2131691132) + " " + paramString4;
      paramString6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramString3 = new bdoi(StructMsgForGeneralShare.class).c(32).a(paramString3).d("").a("plugin", "", paramString6, "", "").a();
      paramString6 = bdov.a(2);
      paramString6.a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramString3.addItem(paramString6);
      if ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_Int != 1008) || (!(paramContext instanceof FragmentActivity))) {
        break label521;
      }
      paramContext = ((FragmentActivity)paramContext).getChatFragment();
      if (paramContext == null) {
        break label521;
      }
      paramContext = paramContext.a();
      if ((paramContext == null) || (paramContext.a == null) || (!(paramContext instanceof ainh))) {
        break label521;
      }
    }
    label521:
    for (boolean bool = ((ainh)paramContext).ar;; bool = false)
    {
      if ((paramSessionInfo != null) && ((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 1024) || ((paramSessionInfo.jdField_a_of_type_Int == 0) && (nmd.b(paramSessionInfo.jdField_a_of_type_JavaLangString))) || (bool)))
      {
        paramContext = bcry.a(-1000);
        l = bcrg.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        paramString1 = aeam.f + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
        paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramString1, l, -1000, i, l);
        paramContext.issend = 1;
        paramQQAppInterface.a().a(paramContext, null);
      }
      while (paramSessionInfo == null)
      {
        long l;
        int i;
        return;
        paramString3 = paramContext.getResources().getString(2131691132);
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
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramChatMessage);
      if ((paramChatMessage instanceof MessageForArkApp)) {
        aqcz.a().a(paramChatMessage.uniseq);
      }
      if (((StructLongMessageDownloadProcessor.b(paramChatMessage)) || (StructLongMessageDownloadProcessor.d(paramChatMessage))) && ((paramChatMessage instanceof MessageForStructing))) {
        StructLongMessageDownloadProcessor.a(paramQQAppInterface, ((MessageForStructing)paramChatMessage).uniseq);
      }
      if ((paramChatMessage instanceof MessageForApollo))
      {
        MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
        if (localMessageForApollo != null)
        {
          anfz.a(localMessageForApollo.uniseq, paramQQAppInterface, "del_msg");
          if ((localMessageForApollo.mApolloMessage != null) && ((paramContext instanceof FragmentActivity)))
          {
            paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
            if ((paramContext != null) && (paramContext.a != null)) {
              VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "del_success", ApolloUtil.b(paramContext.a.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForFile))
      {
        paramContext = aunj.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
        paramQQAppInterface.a().b(paramContext.nSessionId);
        bdll.b(paramQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
      }
      if ((paramChatMessage instanceof MessageForLightVideo)) {
        awli.a(paramQQAppInterface, paramChatMessage);
      }
      paramContext = paramChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
      if (QLog.isDebugVersion()) {
        QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramContext + "],targetId[" + paramChatMessage.msgUid + "], hashCode:" + paramChatMessage.hashCode());
      }
      if (TextUtils.isEmpty(paramContext)) {}
    }
    try
    {
      long l = Long.parseLong(paramContext);
      paramQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, l, true);
      ((bhzq)paramQQAppInterface.getManager(235)).a.a(paramChatMessage);
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
  
  public static void a(bhuk parambhuk, Context paramContext, int paramInt)
  {
    if ((!AppSetting.i) && (paramInt == 0)) {}
    while (adak.a(paramInt) == 1032) {
      return;
    }
    parambhuk.a(2131365352, paramContext.getString(2131690639), 2130838934);
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
    label395:
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
      if ((paramBaseChatPie instanceof aijm)) {}
      for (paramBaseChatPie = (aijm)paramBaseChatPie;; paramBaseChatPie = null)
      {
        if (paramBaseChatPie == null) {
          break label395;
        }
        bihn localbihn = bihn.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        boolean bool1 = localbihn.a(paramQQAppInterface);
        boolean bool2 = localbihn.b(paramQQAppInterface);
        boolean bool3 = localbihn.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        if ((i != 0) || (!bool1) || (!bool2) || (!bool3)) {
          break;
        }
        Object localObject = paramQQAppInterface.getApp().getSharedPreferences(bihn.jdField_a_of_type_JavaLangString, 0);
        if (!paramBoolean)
        {
          long l1 = localbihn.a(paramQQAppInterface);
          long l2 = ((SharedPreferences)localObject).getLong(bihn.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, 0L);
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 > l1)) {
            break label271;
          }
        }
        label271:
        aokj localaokj;
        do
        {
          localObject = localbihn.a(paramQQAppInterface);
          if ((!localbihn.c(paramQQAppInterface)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!paramBaseChatPie.S)) {
            break;
          }
          localbihn.a(paramQQAppInterface, 0);
          adak.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4022);
          paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4022, (String)localObject);
          return;
          localaokj = (aokj)paramQQAppInterface.a(86);
        } while (localaokj == null);
        paramBaseChatPie = new AIOSendReq();
        paramBaseChatPie.iSend = 0;
        paramBaseChatPie.sAid = "";
        paramBaseChatPie.sUin = paramQQAppInterface.getCurrentAccountUin();
        paramBaseChatPie.sFriendUin = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localaokj.a(paramBaseChatPie);
        paramBaseChatPie = ((SharedPreferences)localObject).edit();
        paramBaseChatPie.putLong(bihn.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
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
  
  public static void a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    String str = paramSessionInfo.jdField_a_of_type_JavaLangString;
    boolean bool = paramSessionInfo.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentAccountUin());
    bdll.b(paramQQAppInterface, "dc00898", "", "", "0X800A2CE", "0X800A2CE", 0, 0, ChatActivityUtils.b(paramSessionInfo.jdField_a_of_type_Int), "", "", "");
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
        if (TextUtils.isEmpty(((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString)) {
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramSessionInfo.jdField_d_of_type_JavaLangString;
        }
        ((ProfileActivity.AllInOne)localObject).a = aber.a(paramSessionInfo);
        ((ProfileActivity.AllInOne)localObject).f = paramSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1020)) {
          ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 2;
        if (paramSessionInfo.jdField_a_of_type_Int != 0) {
          break label951;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 1;
        if ((paramSessionInfo.jdField_a_of_type_Int != 1001) && (paramSessionInfo.jdField_a_of_type_Int != 1010) && (paramSessionInfo.jdField_a_of_type_Int != 10002)) {
          break label1018;
        }
        localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
        if (paramSessionInfo.jdField_a_of_type_Int != 1001) {
          break label961;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 10;
        localIntent.putExtra("frome_where", 21);
        label242:
        ((ProfileActivity.AllInOne)localObject).a = aber.a(paramSessionInfo);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!bhjx.a(paramQQAppInterface.getCurrentAccountUin(), str)) {
          break label1005;
        }
        localIntent.putExtra("param_mode", 2);
      }
    }
    for (;;)
    {
      paramActivity.startActivityForResult(localIntent, 9009);
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1024)
      {
        nok.a(paramActivity, null, paramSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
        i = 1;
        localObject = null;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10004)
      {
        localObject = new ProfileActivity.AllInOne(str, 94);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 0)
      {
        localObject = new ProfileActivity.AllInOne(str, 70);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1000)
      {
        localObject = new ProfileActivity.AllInOne(str, 22);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1020)
      {
        localObject = new ProfileActivity.AllInOne(str, 58);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1001)
      {
        localObject = new ProfileActivity.AllInOne(str, 42);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10002)
      {
        localObject = new ProfileActivity.AllInOne(str, 86);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1004)
      {
        localObject = new ProfileActivity.AllInOne(str, 47);
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1005)
      {
        localObject = new ProfileActivity.AllInOne(str, 2);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1023)
      {
        localObject = new ProfileActivity.AllInOne(str, 74);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1006)
      {
        localObject = new ProfileActivity.AllInOne(str, 34);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1009)
      {
        localObject = new ProfileActivity.AllInOne(str, 57);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1021)
      {
        localObject = new ProfileActivity.AllInOne(str, 72);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1022)
      {
        localObject = new ProfileActivity.AllInOne(str, 27);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1025)
      {
        localObject = new Intent(paramActivity, ChatSettingActivity.class);
        ((Intent)localObject).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uinname", paramSessionInfo.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
        paramActivity.startActivity((Intent)localObject);
        i = 1;
        localObject = null;
        break;
      }
      if ((paramSessionInfo.jdField_a_of_type_Int == 1037) || (paramSessionInfo.jdField_a_of_type_Int == 1044) || (paramSessionInfo.jdField_a_of_type_Int == 1045))
      {
        localObject = new ProfileActivity.AllInOne(str, 96);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10008)
      {
        localObject = new ProfileActivity.AllInOne(str, 115);
        i = 0;
        break;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 10010)
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
      if (paramSessionInfo.jdField_a_of_type_Int == 1010)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 11;
        break label242;
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 10002) {
        break label242;
      }
      localIntent.putExtra("frome_where", 22);
      break label242;
      label1005:
      localIntent.putExtra("param_mode", 3);
    }
    label1018:
    if (awlm.a(paramSessionInfo))
    {
      i = 0;
      if (paramSessionInfo.c == 20) {
        i = 1;
      }
      ProfileActivity.a(paramActivity, (ProfileActivity.AllInOne)localObject, i, 3);
      return;
    }
    ProfileActivity.b(paramActivity, (ProfileActivity.AllInOne)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (bdoc.a(paramString2) >= 1))
    {
      bdoc.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new beyg();
    paramBundle.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    paramBundle.jdField_c_of_type_JavaLangString = paramString1;
    paramBundle.jdField_a_of_type_Int = paramInt1;
    paramBundle.jdField_b_of_type_Int = 2;
    paramBundle.jdField_a_of_type_Long = paramLong1;
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.i = paramString2;
    paramBundle.jdField_e_of_type_Int = 1002;
    paramBundle.m = paramBoolean3;
    paramBundle.n = paramInt5;
    paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().a(paramString1, paramInt1, paramLong1);
    if ((paramInt1 == 1026) && (QLog.isColorLevel()))
    {
      paramString2 = new StringBuilder().append("uploadPtt,");
      if (paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label246;
      }
    }
    label246:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt))
      {
        paramString1 = (MessageForPtt)paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
      }
      paramQQAppInterface.a().a(paramBundle);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, int paramInt6)
  {
    a(paramQQAppInterface, paramInt1, paramString1, paramString2, paramLong1, paramBoolean1, paramInt2, paramInt3, paramBoolean2, paramInt4, paramInt5, paramBoolean3, paramLong2, paramBundle, paramArrayList, paramString3, paramBoolean4, null, paramInt6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, int paramInt5, boolean paramBoolean3, long paramLong2, Bundle paramBundle, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString3, boolean paramBoolean4, MessageRecord paramMessageRecord, int paramInt6)
  {
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (bdoc.a(paramString2) >= 1))
    {
      bdoc.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new beyg();
    paramBundle.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    paramBundle.jdField_c_of_type_JavaLangString = paramString1;
    paramBundle.jdField_a_of_type_Int = paramInt1;
    paramBundle.jdField_b_of_type_Int = 2;
    paramBundle.jdField_a_of_type_Long = paramLong1;
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.i = paramString2;
    paramBundle.jdField_e_of_type_Int = 1002;
    paramBundle.m = paramBoolean3;
    paramBundle.n = paramInt5;
    if (paramMessageRecord != null)
    {
      paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean4) && (paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
      {
        paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.atInfoList = paramArrayList;
        paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mRobotFlag = 1;
        new bdlq(paramQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_msg_suc").a(new String[] { paramString1, String.valueOf(((MessageForText.AtTroopMemberInfo)paramArrayList.get(0)).uin) }).a();
      }
      if ((paramInt1 == 1026) && (QLog.isColorLevel()))
      {
        paramString2 = new StringBuilder().append("uploadPtt,");
        if (paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          break label382;
        }
      }
    }
    label382:
    for (paramString1 = "mRec is null";; paramString1 = "mRec is not null")
    {
      QLog.i("PttShow", 2, paramString1);
      if ((paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPtt))
      {
        paramString1 = (MessageForPtt)paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramString1.voiceType = paramInt3;
        paramString1.voiceLength = QQRecorder.a(paramInt2);
        paramString1.voiceChangeFlag = paramInt4;
        paramString1.mInputContent = paramString3;
        paramString1.autoToText = paramInt6;
      }
      paramQQAppInterface.a().a(paramBundle);
      return;
      paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().a(paramString1, paramInt1, paramLong1);
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (1024 == paramSessionInfo.jdField_a_of_type_Int) {}
    int i;
    do
    {
      return;
      i = ((anum)paramQQAppInterface.a(2)).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.jdField_a_of_type_JavaLangString + " settingValue:" + i);
      }
    } while ((i != 0) && (i != 3));
    String str;
    if (i == 0)
    {
      i = -7006;
      str = "single_way_friend_add_allow_list";
      label91:
      if (ChatActivityUtils.a(paramContext, paramSessionInfo, str)) {
        break label295;
      }
      Iterator localIterator = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, 0).iterator();
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
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.jdField_a_of_type_JavaLangString + " hasInserted:" + bool);
      }
      if (bool) {
        break;
      }
      ChatActivityUtils.b(paramContext, paramSessionInfo, str);
      paramContext = (MessageForGrayTips)bcry.a(i);
      long l = bcrg.a() + 1L;
      paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, "", l, i, paramSessionInfo.jdField_a_of_type_Int, l);
      paramContext.setTextGravity(17);
      paramContext.isread = true;
      if (aoci.a(paramQQAppInterface, paramContext, false)) {
        break;
      }
      paramQQAppInterface.a().a(paramContext, paramContext.selfuin);
      return;
      i = -2019;
      str = "single_way_friend_list";
      break label91;
      label295:
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
    paramContext.summary = airq.a(paramInt1);
    paramContext.initMsg();
    bcry.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.a().a(paramContext, null);
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
    if (!ahnt.a(paramQQAppInterface, paramSessionInfo))
    {
      if (jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null)
      {
        jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(paramContext, 2131689926, 0);
        ahnp.a().a(3);
        ahnp.a().a(6);
        ahnp.a().a(12);
        ahnp.a().a(15);
        ahnp.a().a(18);
        ahnp.a().a(9);
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
    paramContext.strength = ahnp.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.interactType, paramInt3, -1);
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
      bcry.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      paramContext.initMsg();
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "sendPokeMsg strength:" + paramContext.strength + "." + paramContext);
      }
      paramQQAppInterface.a().a(paramContext, null);
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
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if ((paramContext != null) && (paramContext.isSendFromLocal())) {
      paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramContext.frienduin, paramContext.uniseq));
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = bcry.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, int paramInt)
  {
    boolean bool1 = paramIntent.getBooleanExtra("not_forward", false);
    boolean bool2 = paramIntent.getBooleanExtra("support_multi_forward", false);
    if ((!bool1) && (!bool2)) {
      return;
    }
    if (paramForwardFileInfo.jdField_a_of_type_Int <= 0) {}
    for (;;)
    {
      paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramForwardFileInfo.e(), paramForwardFileInfo.a(), Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString), paramSessionInfo.jdField_a_of_type_Int, paramForwardFileInfo.a(), paramForwardFileInfo.c(), paramInt);
      if (!paramIntent.getBooleanExtra("not_forward", false)) {
        break;
      }
      paramIntent.removeExtra("not_forward");
      paramIntent.getExtras().remove("not_forward");
      return;
      paramInt = paramForwardFileInfo.jdField_a_of_type_Int;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramBoolean, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent, String paramString, ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    if ((paramInt <= 0) && (paramForwardFileInfo != null)) {}
    for (int i = paramForwardFileInfo.jdField_a_of_type_Int;; i = paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatActivityFacade", 1, "forwardForFile");
      }
      if (ForwardUtils.a(paramIntent, paramSessionInfo, paramString, paramQQAppInterface)) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityFacade", 2, "handleForwardEditedPhoto = " + paramString);
        }
      }
      label1332:
      for (;;)
      {
        return;
        if ((paramForwardFileInfo != null) && (paramForwardFileInfo.b() == 10006) && (TextUtils.isEmpty(paramForwardFileInfo.a())))
        {
          a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramInt);
          return;
        }
        if ((!paramIntent.getBooleanExtra("isFromFavorites", false)) && (paramIntent.getBooleanExtra("isFromShare", false)))
        {
          if (!paramIntent.getBooleanExtra("sendMultiple", false))
          {
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, 0L, i);
              return;
            }
            paramQQAppInterface.a().a(paramString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, 0L, i);
          }
        }
        else if (paramIntent.getBooleanExtra("not_forward", false))
        {
          paramString = null;
          if (paramForwardFileInfo != null) {
            paramString = paramQQAppInterface.a().b(paramForwardFileInfo.b());
          }
          String str = paramString;
          if (paramString == null)
          {
            paramString = bmkq.a(paramIntent.getExtras(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
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
            if (paramSessionInfo.jdField_a_of_type_Int == 1)
            {
              paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramForwardFileInfo.c(), i);
            }
            else
            {
              paramQQAppInterface = paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, paramForwardFileInfo.c(), i);
              if (str != null)
              {
                paramQQAppInterface.lastSuccessTime = str.lastSuccessTime;
                continue;
                if (paramSessionInfo.jdField_a_of_type_Int == 1)
                {
                  paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                }
                else if (paramSessionInfo.jdField_a_of_type_Int == 0)
                {
                  paramQQAppInterface.a().b(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                }
                else if (paramSessionInfo.jdField_a_of_type_Int == 3000)
                {
                  paramQQAppInterface.a().c(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                  continue;
                  if (paramSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    if (auog.b(paramForwardFileInfo.a()))
                    {
                      paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString);
                    }
                    else
                    {
                      paramForwardFileInfo.b();
                      paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                      if ((paramContext != null) && (paramContext.peerType == 3000))
                      {
                        paramSessionInfo = paramQQAppInterface.a().a(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.peerType, false);
                        paramSessionInfo.selfUin = paramContext.peerUin;
                        paramQQAppInterface.a().a(paramSessionInfo, 27, paramForwardFileInfo.c(), i);
                      }
                      else
                      {
                        paramQQAppInterface.a().a(3, paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramForwardFileInfo.c(), i);
                      }
                    }
                  }
                  else
                  {
                    paramString = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                    if ((paramString != null) && (paramString.status == 16))
                    {
                      if (paramContext == null) {
                        break;
                      }
                      aunj.a(paramContext.getResources().getString(2131692472));
                      return;
                    }
                    paramContext = paramQQAppInterface.getCurrentAccountUin();
                    if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                      paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                    }
                    if ((paramString != null) && (paramString.peerType == 3000))
                    {
                      paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, paramForwardFileInfo.c(), i);
                      paramContext.selfUin = paramString.peerUin;
                      if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1006) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002) || (paramSessionInfo.jdField_a_of_type_Int == 1006))
                      {
                        paramContext.nOpType = 21;
                        paramQQAppInterface.a().a(paramContext, 21);
                      }
                      for (;;)
                      {
                        paramQQAppInterface.a().c(paramContext);
                        break;
                        if (paramSessionInfo.jdField_a_of_type_Int == 3000)
                        {
                          paramContext.nOpType = 22;
                          paramQQAppInterface.a().a(paramContext, 22);
                        }
                      }
                    }
                    paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, paramForwardFileInfo.c(), i);
                    if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
                      paramContext.nOpType = 28;
                    }
                    paramQQAppInterface.a().a(paramContext);
                    paramQQAppInterface.a().c(paramContext);
                    continue;
                    paramContext = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                    paramQQAppInterface.a().b(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, i);
                    continue;
                    if (paramSessionInfo.jdField_a_of_type_Int == 1)
                    {
                      if (auog.b(paramForwardFileInfo.a()))
                      {
                        paramQQAppInterface.a().a(paramForwardFileInfo.a(), paramSessionInfo.jdField_a_of_type_JavaLangString, 0L, i);
                      }
                      else
                      {
                        paramString = paramQQAppInterface.a().a(paramForwardFileInfo.b());
                        paramContext = paramQQAppInterface.getCurrentAccountUin();
                        if ((paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 1000)) {
                          paramContext = paramSessionInfo.jdField_b_of_type_JavaLangString;
                        }
                        if ((paramString != null) && (paramString.peerType == 3000))
                        {
                          paramContext = paramQQAppInterface.a().a(paramString, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString.peerType, false);
                          paramContext.selfUin = paramString.peerUin;
                          paramQQAppInterface.a().a(paramContext, 27);
                        }
                        else
                        {
                          paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_a_of_type_JavaLangString, i);
                        }
                      }
                    }
                    else
                    {
                      paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, i);
                      continue;
                      paramQQAppInterface.a().a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, i);
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
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, anra paramanra)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: ifnull +50 -> 57
    //   10: aload_3
    //   11: ifnull +46 -> 57
    //   14: aload_3
    //   15: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   18: ifnull +39 -> 57
    //   21: aload_3
    //   22: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   25: getfield 2383	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   28: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +26 -> 57
    //   34: aload_3
    //   35: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   38: getfield 2386	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   41: ifle +17 -> 58
    //   44: aload_3
    //   45: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   48: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   51: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +4 -> 58
    //   57: return
    //   58: aload_0
    //   59: bipush 51
    //   61: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   64: checkcast 456	anyw
    //   67: astore 8
    //   69: aload_0
    //   70: sipush 153
    //   73: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   76: checkcast 2389	amsx
    //   79: astore 11
    //   81: aload_0
    //   82: bipush 71
    //   84: invokevirtual 615	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanud;
    //   87: checkcast 2391	com/tencent/mobileqq/vas/VasExtensionHandler
    //   90: astore_1
    //   91: aload_2
    //   92: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   95: iconst_1
    //   96: if_icmpne +60 -> 156
    //   99: aload_3
    //   100: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   103: getfield 2386	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   106: ifle +50 -> 156
    //   109: aload_3
    //   110: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   113: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   116: aload_0
    //   117: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   120: invokevirtual 1497	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +33 -> 156
    //   126: aload 11
    //   128: aload_3
    //   129: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   132: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   135: invokevirtual 2394	amsx:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   138: astore 9
    //   140: aload 9
    //   142: ifnonnull +818 -> 960
    //   145: aload_1
    //   146: aload_3
    //   147: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   150: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   153: invokevirtual 2396	com/tencent/mobileqq/vas/VasExtensionHandler:b	(Ljava/lang/String;)V
    //   156: aload_3
    //   157: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   160: getfield 2399	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   163: invokestatic 2402	com/tencent/mobileqq/data/ApolloActionData:isAction3DModel	(I)Z
    //   166: istore 7
    //   168: ldc_w 572
    //   171: iconst_1
    //   172: iconst_4
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc_w 2404
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_3
    //   185: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   188: getfield 2399	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   191: invokestatic 991	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: ldc_w 2406
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: iload 7
    //   205: invokestatic 2411	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   208: aastore
    //   209: invokestatic 2414	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   212: new 1634	com/tencent/mobileqq/data/ApolloMessage
    //   215: dup
    //   216: invokespecial 2415	com/tencent/mobileqq/data/ApolloMessage:<init>	()V
    //   219: astore 10
    //   221: iload 7
    //   223: ifeq +940 -> 1163
    //   226: sipush 1024
    //   229: istore 5
    //   231: iload 5
    //   233: istore 4
    //   235: aload_3
    //   236: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   239: getfield 2386	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   242: ifle +857 -> 1099
    //   245: iload 5
    //   247: istore 4
    //   249: aload 10
    //   251: sipush 1454
    //   254: putfield 1636	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   257: iload 5
    //   259: istore 4
    //   261: new 2417	com/tencent/mobileqq/data/Apollo3DMessage
    //   264: dup
    //   265: invokespecial 2418	com/tencent/mobileqq/data/Apollo3DMessage:<init>	()V
    //   268: astore 8
    //   270: aload 8
    //   272: aload_3
    //   273: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   276: getfield 2399	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   279: putfield 2421	com/tencent/mobileqq/data/Apollo3DMessage:actionID_3D	I
    //   282: aload 8
    //   284: aload_3
    //   285: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   288: getfield 2424	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   291: putfield 2427	com/tencent/mobileqq/data/Apollo3DMessage:actionType_3D	I
    //   294: aload 8
    //   296: aload_3
    //   297: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   300: getfield 2383	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   303: putfield 2430	com/tencent/mobileqq/data/Apollo3DMessage:actionName_3D	Ljava/lang/String;
    //   306: aload_0
    //   307: sipush 155
    //   310: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   313: checkcast 2432	annx
    //   316: aload 10
    //   318: getfield 1636	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   321: invokevirtual 2435	annx:a	(I)Lcom/tencent/mobileqq/data/ApolloActionData;
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +814 -> 1140
    //   329: aload_1
    //   330: getfield 2383	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   333: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifne +804 -> 1140
    //   339: aload 10
    //   341: aload_1
    //   342: getfield 2383	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   345: ldc_w 1489
    //   348: invokevirtual 64	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   351: putfield 2438	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   354: aload_3
    //   355: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   358: getfield 2441	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   361: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   364: ifne +36 -> 400
    //   367: aload_2
    //   368: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   371: iconst_1
    //   372: if_icmpeq +13 -> 385
    //   375: aload_2
    //   376: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   379: sipush 3000
    //   382: if_icmpne +18 -> 400
    //   385: aload 10
    //   387: aload_3
    //   388: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   391: getfield 2441	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   394: invokevirtual 2443	java/lang/String:getBytes	()[B
    //   397: putfield 2446	com/tencent/mobileqq/data/ApolloMessage:text	[B
    //   400: aload 11
    //   402: aload_0
    //   403: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   406: invokevirtual 2394	amsx:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   409: astore 9
    //   411: aload 10
    //   413: aload 9
    //   415: getfield 2451	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   418: invokestatic 2453	bhjx:a	(J)I
    //   421: i2l
    //   422: putfield 2456	com/tencent/mobileqq/data/ApolloMessage:sender_ts	J
    //   425: aload 10
    //   427: aload 9
    //   429: getfield 2459	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   432: putfield 2462	com/tencent/mobileqq/data/ApolloMessage:sender_status	I
    //   435: iload 7
    //   437: ifeq +18 -> 455
    //   440: aload 8
    //   442: ifnull +13 -> 455
    //   445: aload 8
    //   447: aload 9
    //   449: getfield 2465	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   452: putfield 2468	com/tencent/mobileqq/data/Apollo3DMessage:senderStatus_3D	I
    //   455: iload 5
    //   457: iconst_1
    //   458: ior
    //   459: bipush 8
    //   461: ior
    //   462: bipush 32
    //   464: ior
    //   465: istore 4
    //   467: aload_3
    //   468: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   471: getfield 2386	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   474: ifle +871 -> 1345
    //   477: aload 10
    //   479: aload_3
    //   480: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   483: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   486: invokestatic 2471	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   489: invokevirtual 2474	java/lang/Long:longValue	()J
    //   492: putfield 2477	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   495: aload 11
    //   497: aload_3
    //   498: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   501: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   504: invokevirtual 2394	amsx:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   507: astore 9
    //   509: aload 10
    //   511: aload 9
    //   513: getfield 2451	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   516: invokestatic 2453	bhjx:a	(J)I
    //   519: i2l
    //   520: putfield 2480	com/tencent/mobileqq/data/ApolloMessage:peer_ts	J
    //   523: aload 10
    //   525: aload 9
    //   527: getfield 2459	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   530: putfield 2483	com/tencent/mobileqq/data/ApolloMessage:peer_status	I
    //   533: iload 7
    //   535: ifeq +18 -> 553
    //   538: aload 8
    //   540: ifnull +13 -> 553
    //   543: aload 8
    //   545: aload 9
    //   547: getfield 2465	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   550: putfield 2486	com/tencent/mobileqq/data/Apollo3DMessage:peerStatus_3D	I
    //   553: iload 4
    //   555: iconst_4
    //   556: ior
    //   557: iconst_2
    //   558: ior
    //   559: bipush 16
    //   561: ior
    //   562: bipush 64
    //   564: ior
    //   565: istore 5
    //   567: iload 5
    //   569: istore 4
    //   571: iload 7
    //   573: ifeq +11 -> 584
    //   576: iload 5
    //   578: sipush 2048
    //   581: ior
    //   582: istore 4
    //   584: aload_3
    //   585: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   588: getfield 2386	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   591: ifne +28 -> 619
    //   594: aload_2
    //   595: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   598: ifne +21 -> 619
    //   601: aload 10
    //   603: aload_3
    //   604: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   607: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   610: invokestatic 2471	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   613: invokevirtual 2474	java/lang/Long:longValue	()J
    //   616: putfield 2477	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   619: iload 4
    //   621: istore 5
    //   623: aload_3
    //   624: getfield 2487	anra:jdField_d_of_type_Int	I
    //   627: iconst_1
    //   628: if_icmpne +11 -> 639
    //   631: iload 4
    //   633: sipush 128
    //   636: ior
    //   637: istore 5
    //   639: aload 10
    //   641: iload 5
    //   643: putfield 2488	com/tencent/mobileqq/data/ApolloMessage:flag	I
    //   646: new 655	java/util/ArrayList
    //   649: dup
    //   650: invokespecial 656	java/util/ArrayList:<init>	()V
    //   653: pop
    //   654: iconst_0
    //   655: ifne +684 -> 1339
    //   658: new 1169	org/json/JSONObject
    //   661: dup
    //   662: invokespecial 1170	org/json/JSONObject:<init>	()V
    //   665: astore 9
    //   667: iload 7
    //   669: ifeq +540 -> 1209
    //   672: aload 8
    //   674: ifnull +535 -> 1209
    //   677: aload_1
    //   678: ifnull +531 -> 1209
    //   681: aload 9
    //   683: ldc_w 2489
    //   686: aload_1
    //   687: getfield 2424	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   690: invokevirtual 1297	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   693: pop
    //   694: aload_3
    //   695: getfield 2490	anra:jdField_e_of_type_Int	I
    //   698: ifle +30 -> 728
    //   701: aload 9
    //   703: ldc_w 2492
    //   706: aload_3
    //   707: getfield 2490	anra:jdField_e_of_type_Int	I
    //   710: invokevirtual 1297	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 9
    //   716: ldc_w 2494
    //   719: aload_3
    //   720: getfield 2496	anra:jdField_a_of_type_Float	F
    //   723: f2d
    //   724: invokevirtual 2499	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload_3
    //   729: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   732: getfield 2502	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   735: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   738: ifne +503 -> 1241
    //   741: aload 9
    //   743: ldc_w 2503
    //   746: aload_3
    //   747: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   750: getfield 2502	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   753: invokevirtual 1176	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 8
    //   759: ifnull +23 -> 782
    //   762: aload 8
    //   764: invokevirtual 2507	com/tencent/mobileqq/data/Apollo3DMessage:getMessageJSONObject	()Lorg/json/JSONObject;
    //   767: astore_1
    //   768: aload_1
    //   769: ifnull +13 -> 782
    //   772: aload 9
    //   774: ldc_w 2509
    //   777: aload_1
    //   778: invokevirtual 1176	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   781: pop
    //   782: aload 9
    //   784: ifnull +13 -> 797
    //   787: aload 10
    //   789: aload 9
    //   791: invokevirtual 1191	org/json/JSONObject:toString	()Ljava/lang/String;
    //   794: putfield 2512	com/tencent/mobileqq/data/ApolloMessage:extStr	Ljava/lang/String;
    //   797: aload_0
    //   798: aload_2
    //   799: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   802: aload_2
    //   803: getfield 232	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   806: aload_2
    //   807: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   810: aload 10
    //   812: invokestatic 2515	bcry:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ApolloMessage;)Lcom/tencent/mobileqq/data/MessageForApollo;
    //   815: astore_1
    //   816: aload_1
    //   817: aload_3
    //   818: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   821: getfield 2502	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   824: putfield 2516	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   827: aload_1
    //   828: aload_3
    //   829: getfield 2490	anra:jdField_e_of_type_Int	I
    //   832: putfield 2519	com/tencent/mobileqq/data/MessageForApollo:audioId	I
    //   835: aload_1
    //   836: aload_3
    //   837: getfield 2496	anra:jdField_a_of_type_Float	F
    //   840: putfield 2521	com/tencent/mobileqq/data/MessageForApollo:audioStartTime	F
    //   843: aload_1
    //   844: aload_3
    //   845: getfield 2522	anra:f	I
    //   848: putfield 2525	com/tencent/mobileqq/data/MessageForApollo:isPlayDefaultAudio	I
    //   851: aload_1
    //   852: aload_3
    //   853: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   856: getfield 2424	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   859: putfield 2526	com/tencent/mobileqq/data/MessageForApollo:actionType	I
    //   862: aload_1
    //   863: aload 8
    //   865: putfield 2529	com/tencent/mobileqq/data/MessageForApollo:mApollo3DMessage	Lcom/tencent/mobileqq/data/Apollo3DMessage;
    //   868: aload_1
    //   869: getfield 2516	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   872: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   875: ifeq +11 -> 886
    //   878: aload_1
    //   879: aload_3
    //   880: getfield 2530	anra:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   883: putfield 2516	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   886: aload_1
    //   887: aload_3
    //   888: getfield 2531	anra:jdField_h_of_type_Int	I
    //   891: putfield 2534	com/tencent/mobileqq/data/MessageForApollo:mSendSrc	I
    //   894: aload_0
    //   895: invokestatic 2539	angi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Langf;
    //   898: astore_2
    //   899: aload_3
    //   900: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   903: getfield 2424	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   906: ifeq +376 -> 1282
    //   909: aload_2
    //   910: ifnull +372 -> 1282
    //   913: aload_0
    //   914: invokestatic 2542	angi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lanfr;
    //   917: ifnonnull +350 -> 1267
    //   920: aload_0
    //   921: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   924: aload_1
    //   925: aconst_null
    //   926: invokevirtual 580	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Laocj;)V
    //   929: ldc_w 572
    //   932: iconst_2
    //   933: new 171	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   940: ldc_w 2544
    //   943: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload_3
    //   947: invokevirtual 2545	anra:toString	()Ljava/lang/String;
    //   950: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 1700	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   959: return
    //   960: aload 8
    //   962: aload_3
    //   963: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   966: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   969: invokevirtual 2546	anyw:b	(Ljava/lang/String;)Z
    //   972: ifne +33 -> 1005
    //   975: invokestatic 2551	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   978: aload 9
    //   980: getfield 2554	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   983: lsub
    //   984: ldc2_w 2555
    //   987: lcmp
    //   988: iflt +17 -> 1005
    //   991: aload_1
    //   992: aload_3
    //   993: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   996: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   999: invokevirtual 2396	com/tencent/mobileqq/vas/VasExtensionHandler:b	(Ljava/lang/String;)V
    //   1002: goto -846 -> 156
    //   1005: aload 8
    //   1007: aload_3
    //   1008: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1011: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1014: invokevirtual 2546	anyw:b	(Ljava/lang/String;)Z
    //   1017: ifeq +27 -> 1044
    //   1020: aload 9
    //   1022: getfield 2554	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   1025: lconst_0
    //   1026: lcmp
    //   1027: ifne +17 -> 1044
    //   1030: aload_1
    //   1031: aload_3
    //   1032: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1035: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1038: invokevirtual 2396	com/tencent/mobileqq/vas/VasExtensionHandler:b	(Ljava/lang/String;)V
    //   1041: goto -885 -> 156
    //   1044: aload 9
    //   1046: getfield 2451	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   1049: aload 9
    //   1051: getfield 2559	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   1054: lcmp
    //   1055: ifeq -899 -> 156
    //   1058: new 655	java/util/ArrayList
    //   1061: dup
    //   1062: iconst_1
    //   1063: invokespecial 2560	java/util/ArrayList:<init>	(I)V
    //   1066: astore 8
    //   1068: aload 8
    //   1070: aload_3
    //   1071: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1074: getfield 2387	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1077: invokestatic 1706	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1080: invokestatic 2563	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1083: invokevirtual 1225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1086: pop
    //   1087: aload_1
    //   1088: aload 8
    //   1090: ldc_w 2565
    //   1093: invokevirtual 2568	com/tencent/mobileqq/vas/VasExtensionHandler:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   1096: goto -940 -> 156
    //   1099: iload 5
    //   1101: istore 4
    //   1103: aload 10
    //   1105: sipush 1450
    //   1108: putfield 1636	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1111: goto -854 -> 257
    //   1114: astore 9
    //   1116: aconst_null
    //   1117: astore 8
    //   1119: aconst_null
    //   1120: astore_1
    //   1121: ldc_w 572
    //   1124: iconst_1
    //   1125: ldc_w 2570
    //   1128: aload 9
    //   1130: invokestatic 577	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1133: iload 4
    //   1135: istore 5
    //   1137: goto -783 -> 354
    //   1140: aload 10
    //   1142: ldc_w 2572
    //   1145: invokevirtual 2443	java/lang/String:getBytes	()[B
    //   1148: putfield 2438	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1151: goto -797 -> 354
    //   1154: astore 9
    //   1156: iload 5
    //   1158: istore 4
    //   1160: goto -39 -> 1121
    //   1163: iload 6
    //   1165: istore 4
    //   1167: aload 10
    //   1169: aload_3
    //   1170: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1173: getfield 2399	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   1176: putfield 1636	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1179: iload 6
    //   1181: istore 4
    //   1183: aload 10
    //   1185: aload_3
    //   1186: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1189: getfield 2383	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   1192: ldc_w 1489
    //   1195: invokevirtual 64	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1198: putfield 2438	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1201: aconst_null
    //   1202: astore_1
    //   1203: aconst_null
    //   1204: astore 8
    //   1206: goto -852 -> 354
    //   1209: aload 9
    //   1211: ldc_w 2489
    //   1214: aload_3
    //   1215: getfield 2378	anra:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1218: getfield 2424	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   1221: invokevirtual 1297	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1224: pop
    //   1225: goto -531 -> 694
    //   1228: astore_0
    //   1229: ldc_w 572
    //   1232: iconst_1
    //   1233: ldc_w 2574
    //   1236: aload_0
    //   1237: invokestatic 577	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1240: return
    //   1241: aload_3
    //   1242: getfield 2530	anra:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1245: invokestatic 359	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1248: ifne -491 -> 757
    //   1251: aload 9
    //   1253: ldc_w 2503
    //   1256: aload_3
    //   1257: getfield 2530	anra:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1260: invokevirtual 1176	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1263: pop
    //   1264: goto -507 -> 757
    //   1267: aload_2
    //   1268: invokevirtual 2579	angf:a	()Lanfx;
    //   1271: astore_0
    //   1272: aload_0
    //   1273: ifnull -1216 -> 57
    //   1276: aload_0
    //   1277: aload_1
    //   1278: invokevirtual 2584	anfx:a	(Lcom/tencent/mobileqq/data/MessageForApollo;)V
    //   1281: return
    //   1282: aload_0
    //   1283: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1286: aload_1
    //   1287: aconst_null
    //   1288: invokevirtual 580	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Laocj;)V
    //   1291: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1294: ifeq -1237 -> 57
    //   1297: ldc_w 572
    //   1300: iconst_2
    //   1301: new 171	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1308: ldc_w 2586
    //   1311: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: aload_3
    //   1315: invokevirtual 2545	anra:toString	()Ljava/lang/String;
    //   1318: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1324: invokestatic 200	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1327: return
    //   1328: astore 9
    //   1330: aconst_null
    //   1331: astore_1
    //   1332: iload 5
    //   1334: istore 4
    //   1336: goto -215 -> 1121
    //   1339: aconst_null
    //   1340: astore 9
    //   1342: goto -675 -> 667
    //   1345: goto -761 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1348	0	paramQQAppInterface	QQAppInterface
    //   0	1348	1	paramContext	Context
    //   0	1348	2	paramSessionInfo	SessionInfo
    //   0	1348	3	paramanra	anra
    //   233	1102	4	i	int
    //   4	1329	5	j	int
    //   1	1179	6	k	int
    //   166	502	7	bool	boolean
    //   67	1138	8	localObject1	Object
    //   138	912	9	localObject2	Object
    //   1114	15	9	localException1	Exception
    //   1154	98	9	localException2	Exception
    //   1328	1	9	localException3	Exception
    //   1340	1	9	localObject3	Object
    //   219	965	10	localApolloMessage	ApolloMessage
    //   79	417	11	localamsx	amsx
    // Exception table:
    //   from	to	target	type
    //   235	245	1114	java/lang/Exception
    //   249	257	1114	java/lang/Exception
    //   261	270	1114	java/lang/Exception
    //   1103	1111	1114	java/lang/Exception
    //   1167	1179	1114	java/lang/Exception
    //   1183	1201	1114	java/lang/Exception
    //   329	354	1154	java/lang/Exception
    //   1140	1151	1154	java/lang/Exception
    //   658	667	1228	java/lang/Throwable
    //   681	694	1228	java/lang/Throwable
    //   694	728	1228	java/lang/Throwable
    //   728	757	1228	java/lang/Throwable
    //   762	768	1228	java/lang/Throwable
    //   772	782	1228	java/lang/Throwable
    //   1209	1225	1228	java/lang/Throwable
    //   1241	1264	1228	java/lang/Throwable
    //   270	325	1328	java/lang/Exception
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
      Toast.makeText(paramContext, paramContext.getString(2131691938), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      biah.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, bhnv.b(paramContext) + "", "", "", "", "");
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
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = bcry.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
      paramQQAppInterface = (axfj)paramQQAppInterface.getManager(14);
      if ((paramQQAppInterface != null) && (paramEmoticon != null))
      {
        paramContext = paramQQAppInterface.a(paramEmoticon);
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            paramSessionInfo = (String)paramContext.next();
            if (!TextUtils.isEmpty(paramSessionInfo))
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
      Toast.makeText(paramContext, paramContext.getString(2131691938), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      biah.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, bhnv.b(paramContext) + "", "", "", "", "");
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
    aeau localaeau = new aeau();
    localaeau.jdField_a_of_type_Boolean = false;
    localaeau.jdField_b_of_type_Boolean = true;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, localaeau);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLoveMessage");
    }
    bdll.b(paramQQAppInterface, "CliOper", "", "", "0X80052A5", "0X80052A5", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    bhmq.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
    if (!bhmi.b(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131694367, 0);
      bhmq.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new azqu();
    paramContext.a(paramString);
    paramContext.d(paramInt);
    paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.c(beya.jdField_d_of_type_Int);
    paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    paramContext.c(paramQQAppInterface.getCurrentAccountUin());
    paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
    paramContext.l(paramSessionInfo.jdField_e_of_type_Int);
    azqk localazqk = azqb.a(2, paramInt);
    localazqk.a(paramContext.a());
    azqb.a(localazqk, paramQQAppInterface);
    ThreadManager.post(new ChatActivityFacade.11(paramString, paramSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131691989, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131717877, 0);
      return;
    }
    ThreadManager.post(new ChatActivityFacade.23(paramSessionInfo, paramQQAppInterface, paramString, paramInt, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((bgsl)paramQQAppInterface.getManager(48)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      QQToast.a(paramQQAppInterface.getApp(), 2131696725, 0).b(paramContext.getTitleBarHeight());
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
    if (bhmi.b(paramString1)) {
      bhmk.a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString, false, paramContext, paramInt2);
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        l1 = a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramString2, paramString3, paramLong, paramInt1);
        paramContext = paramQQAppInterface.a().a(paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download1,uniseq:" + l1 + ",filePath:" + paramString1 + ",forwardImageOrgServerpath:" + paramString2 + ",forwardImageOrgItemId:" + paramLong + ",processor:" + paramContext);
        }
      } while ((paramContext == null) || (!(paramContext instanceof berp)));
      paramContext = (berp)paramContext;
      l2 = paramContext.c();
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "ChatActivity.handleForwardData forwardPic wait for download2,msgId:" + l1 + ",filePath:" + paramString1 + ",get download process status:" + l2);
      }
    } while ((l2 != 2000L) && (l2 != 2001L) && (l2 != 2002L));
    paramQQAppInterface.a().a(l1, paramString4, paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString1, paramString2, paramString3, paramLong, paramInt1);
    paramContext.a().r = paramString4;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new aeau());
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
        biah.a("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
      return;
    }
    bhmq.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!bhmi.b(paramString1))
    {
      ChatActivityUtils.a(paramContext, 2131694367, 0);
      if (paramBoolean1) {
        biah.a("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
      }
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion file not exist or problme: URL = " + paramString1);
      return;
    }
    Object localObject = new azqu();
    ((azqu)localObject).a(paramString1);
    ((azqu)localObject).d(1006);
    ((azqu)localObject).d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((azqu)localObject).c(beya.jdField_d_of_type_Int);
    ((azqu)localObject).e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((azqu)localObject).c(paramQQAppInterface.getCurrentAccountUin());
    ((azqu)localObject).e(paramSessionInfo.jdField_a_of_type_Int);
    ((azqu)localObject).l(paramSessionInfo.jdField_e_of_type_Int);
    azqk localazqk = azqb.a(2, 1006);
    localazqk.a(((azqu)localObject).a());
    localObject = new PicMessageExtraData();
    if (paramBoolean3)
    {
      ((PicMessageExtraData)localObject).imageBizType = 8;
      if (paramBundle != null) {
        ((PicMessageExtraData)localObject).mTemplateId = paramBundle.getString("widgetinfo", "");
      }
      if (TextUtils.isEmpty(paramString3)) {
        break label411;
      }
      ((PicMessageExtraData)localObject).textSummary = ("[" + paramString3 + "]");
    }
    for (;;)
    {
      localazqk.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = ((PicMessageExtraData)localObject);
      azqb.a(localazqk, paramQQAppInterface);
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
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131691127);
      } else {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131691126);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, List<String> paramList)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
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
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(adak.a(str))))
          {
            localObject2 = paramQQAppInterface.a().b(str, 0);
            ChatActivityUtils.a(paramContext, str, 0, "single_way_friend_list");
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
              if (localMessageRecord.msgtype != -2019) {
                continue;
              }
              paramQQAppInterface.a().b(str, localMessageRecord.istroop, localMessageRecord.uniseq);
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
        Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
        l = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int), Long.valueOf(l) }));
        }
        if (paramSessionInfo.jdField_a_of_type_Int == 1036) {
          return;
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.sendReadConfirm_PB", 2, paramQQAppInterface, new Object[0]);
        return;
      }
    } while ((l == -1L) || (l == paramSessionInfo.jdField_a_of_type_Long));
    paramSessionInfo.jdField_a_of_type_Long = l;
    String str = adak.b(paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.a().a(str).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, l);
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
    } while ((localArrayList == null) || (localArrayList.isEmpty()) || (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString)));
    try
    {
      int i = Integer.valueOf(paramIntent.getStringExtra("key_upload_client_key")).intValue();
      long l = a(paramQQAppInterface, paramSessionInfo, i, localArrayList);
      ((aoju)paramQQAppInterface.a(28)).a(i, paramSessionInfo.jdField_a_of_type_JavaLangString, l);
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
    ((Intent)localObject).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("FORWARD_UIN_TYPE", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("SENDER_TROOP_UIN", paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("FORWARD_PEER_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
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
    paramSessionInfo = azqb.a(1009, (Intent)localObject);
    localObject = azqb.a(3, 1009);
    ((azqk)localObject).a(paramSessionInfo);
    ((azqk)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    ((azqk)localObject).jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = paramMessageForPic.picExtraData;
    paramMessageForPic.forwardId.put(localObject, Integer.valueOf(paramInt));
    azqb.a((azqk)localObject, paramQQAppInterface);
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
    ((Intent)localObject).putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject).putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("from_uin", ShortVideoUtils.d(paramMessageForShortVideo));
    ((Intent)localObject).putExtra("from_uin_type", paramMessageForShortVideo.istroop);
    ((Intent)localObject).putExtra("from_session_uin", paramMessageForShortVideo.frienduin);
    ((Intent)localObject).putExtra("from_busi_type", paramMessageForShortVideo.busiType);
    ((Intent)localObject).putExtra("file_send_size", paramMessageForShortVideo.videoFileSize);
    ((Intent)localObject).putExtra("file_send_duration", paramMessageForShortVideo.videoFileTime);
    ((Intent)localObject).putExtra("file_name", paramMessageForShortVideo.videoFileName);
    ((Intent)localObject).putExtra("file_format", paramMessageForShortVideo.videoFileFormat);
    String str = ShortVideoUtils.c(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "Forward menu clicked, videoPath=" + str + ",videoPath = " + str + ", " + paramMessageForShortVideo.toLogString());
    }
    ((Intent)localObject).putExtra("file_send_path", str);
    ((Intent)localObject).putExtra("thumbfile_send_path", ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"));
    ((Intent)localObject).putExtra("file_shortvideo_md5", paramMessageForShortVideo.md5);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
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
        if (paramSessionInfo.jdField_a_of_type_Int != 1) {
          break label696;
        }
        j = 1;
      }
    }
    for (;;)
    {
      alug.a("", "0X80088E4", String.valueOf(j));
      paramSessionInfo = bcwu.a(3, i);
      localObject = bcwu.a(i, localObject, paramSessionInfo);
      if (localObject != null)
      {
        ((bcwz)localObject).jdField_a_of_type_Long = paramMessageForShortVideo.uniseq;
        ((bcwz)localObject).p = paramMessageForShortVideo.forwardID;
        paramSessionInfo.a((bcwz)localObject);
      }
      bcwu.a(paramSessionInfo, paramQQAppInterface);
      return;
      if (i == 2)
      {
        i = 3;
        break;
      }
      i = 0;
      break;
      label696:
      if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
        j = 3;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg)
  {
    a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
    aqca.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 2, 0, 0L, 0L, 0L, "LocationShare", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsStructMsg paramAbsStructMsg)
  {
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (String str1 = paramQQAppInterface.getCurrentAccountUin();; str1 = paramSessionInfo.jdField_b_of_type_JavaLangString)
    {
      String str2 = paramQQAppInterface.getCurrentAccountUin();
      String str3 = paramSessionInfo.jdField_a_of_type_JavaLangString;
      int i = paramSessionInfo.jdField_a_of_type_Int;
      int j = bcpt.jdField_a_of_type_Int;
      bcpt.jdField_a_of_type_Int = j + 1;
      paramSessionInfo = bcry.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      agsg.a().a(paramSessionInfo.uniseq, paramAbsStructMsg.parentUniseq, paramAbsStructMsg.forwardID);
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramSessionInfo, paramString, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()), null, new aeau());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (paramLong != -1L)
    {
      int i = paramSessionInfo.jdField_a_of_type_Int;
      Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong);
      if ((localObject instanceof MessageForPtt))
      {
        localObject = (MessageForPtt)localObject;
        ((MessageForPtt)localObject).url = paramString;
        ((MessageForPtt)localObject).fileSize = paramInt;
        ((MessageForPtt)localObject).isread = false;
        ((MessageForPtt)localObject).itemType = 2;
        ((MessageForPtt)localObject).serial();
        paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong, ((MessageForPtt)localObject).msgData);
        paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, i, paramLong, "extStr", ((MessageForPtt)localObject).extStr);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3)
  {
    if ((paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    a(paramQQAppInterface, paramSessionInfo, aeam.f + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, AbsShareMsg paramAbsShareMsg, String paramString5, String paramString6, String paramString7)
  {
    paramString7 = new ArkAppMessage();
    if (apzu.e) {}
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
        paramString6 = anzj.a(2131700462);
        if ((TextUtils.isEmpty(paramString7.appDesc)) || (paramString7.appDesc.equals(paramString7.appName))) {
          paramString7.appDesc = paramString6;
        }
        switch (paramSessionInfo.jdField_a_of_type_Int)
        {
        case 1000: 
          paramString6 = paramQQAppInterface.getCurrentAccountUin();
          String str1 = paramQQAppInterface.getCurrentAccountUin();
          String str2 = paramSessionInfo.jdField_a_of_type_JavaLangString;
          int i = paramSessionInfo.jdField_a_of_type_Int;
          int j = bcpt.jdField_a_of_type_Int;
          bcpt.jdField_a_of_type_Int = j + 1;
          paramString7.containStructMsg = bcry.a(paramQQAppInterface, str1, str2, paramString6, i, j, paramAbsShareMsg);
          paramString7.promptText = String.format(anzj.a(2131700475), new Object[] { paramString7.appDesc });
          paramString7.from = 1;
          paramString7.metaList = a(paramString5, paramString3, paramString4, paramString1, paramString2);
          paramString1 = new JSONObject();
          paramString1.put("forward", 1);
          paramString1.put("autosize", 1);
          paramString1.put("type", "card");
          paramString7.config = paramString1.toString();
          a(paramQQAppInterface, paramSessionInfo, paramString7, paramAbsShareMsg.forwardID);
          ArkAppCenter.c("sendArkStructMap", "send ark msg is success and arkMsg.metaList=" + paramString7.metaList);
          aqca.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 1, 0, 0L, 0L, 0L, paramString7.appView, "");
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
      paramString6 = paramSessionInfo.jdField_b_of_type_JavaLangString;
      continue;
      ArkAppCenter.c("sendArkStructMap", "sIsArkStructMap is false then send struct msg");
      a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.2(paramQQAppInterface, paramSessionInfo, paramBoolean), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface.a().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal()) {
      paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityFacade", 2, "func tryFetchEmosmKey, app:" + paramQQAppInterface + ",e:" + paramEmoticon);
    }
    if ((paramQQAppInterface == null) || (paramEmoticon == null) || (TextUtils.isEmpty(paramEmoticon.epId)) || (TextUtils.isEmpty(paramEmoticon.eId)) || (!TextUtils.isEmpty(paramEmoticon.encryptKey))) {
      return;
    }
    askd localaskd = (askd)paramQQAppInterface.getManager(43);
    ThreadManager.post(new ChatActivityFacade.19(paramEmoticon, (axfj)paramQQAppInterface.getManager(14), localaskd), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    ((axox)paramQQAppInterface.getManager(372)).a(paramQQAppInterface, paramMessageForArkApp, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      ((MessageHandler)paramQQAppInterface.a(0)).c(Long.valueOf(paramString).longValue());
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, azpp paramazpp)
  {
    paramString = new ChatActivityFacade.1(paramMessageForPtt, paramQQAppInterface, paramString, paramBoolean2, paramazpp, paramInt1, paramInt2);
    if (paramBoolean1)
    {
      paramString.run();
      return;
    }
    paramQQAppInterface.a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, aear paramaear)
  {
    String str = "";
    if (paramString != null) {
      str = bcsa.a(paramString, true, null);
    }
    int i = bcpt.jdField_a_of_type_Int;
    bcpt.jdField_a_of_type_Int = i + 1;
    long l1 = i;
    i = Math.abs(new Random().nextInt());
    int j = (int)bcrg.a();
    paramString = paramQQAppInterface.getCurrentAccountUin();
    long l2 = bcsa.a(i);
    ChatMessage localChatMessage = (ChatMessage)bcry.a(-1000);
    localChatMessage.init(paramString, "", paramString, str, j, -1000, 0, l1);
    localChatMessage.isread = true;
    localChatMessage.msgUid = l2;
    localChatMessage.shmsgseq = bcsa.a(l1, 0);
    localChatMessage.issend = 1;
    if (paramArrayList.size() <= 10) {}
    for (boolean bool = true;; bool = false)
    {
      localChatMessage.needUpdateMsgTag = bool;
      ((aogu)paramQQAppInterface.a(13)).a(localChatMessage);
      ((MessageForText)localChatMessage).msgVia = 0;
      paramQQAppInterface.a().a(paramQQAppInterface, localChatMessage, paramArrayList, paramaear);
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
      if (((i != 0) || (paramList.contains(jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (jdField_a_of_type_Blir != null)) {
        jdField_a_of_type_Blir.dismiss();
      }
      return;
    }
  }
  
  private static boolean a(aeau paramaeau, boolean paramBoolean)
  {
    if (paramaeau.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      byte[] arrayOfByte = paramaeau.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.getSourceMsg();
      if ((arrayOfByte == null) || (arrayOfByte.length < 560)) {
        break label34;
      }
      paramaeau.f = true;
    }
    label34:
    do
    {
      return false;
      if ((paramBoolean) && (paramaeau.f)) {
        return true;
      }
    } while ((paramBoolean) || (paramaeau.f));
    return true;
  }
  
  private static boolean a(SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    return (i == 0) || (i == 3000) || (i == 1);
  }
  
  private static boolean a(SessionInfo paramSessionInfo, String paramString, Bundle paramBundle)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("Unknown Address")))
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
          paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramMessageForLongMsg.frienduin, paramMessageForLongMsg.uniseq));
        }
        paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramMessageForLongMsg.uniseq);
        if (paramMessageForLongMsg.msgtype == -1000)
        {
          paramMessageForLongMsg = bcry.a(paramMessageForLongMsg);
          paramQQAppInterface.a().a(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = bcry.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    agsg.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramArkAppMessage.forwardID);
    if (localMessageForArkApp.istroop == 1) {
      nlj.a().a(localMessageForArkApp);
    }
    localMessageForArkApp.saveExtInfoToExtStr(bcrn.jdField_e_of_type_JavaLangString, "1");
    paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(121);
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
        paramQQAppInterface.a().a(localMessageForArkApp, null);
      }
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage, int paramInt)
  {
    MessageForArkApp localMessageForArkApp = bcry.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    if (paramInt == 0)
    {
      paramInt = paramArkAppMessage.forwardID;
      agsg.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramInt);
      if (localMessageForArkApp.istroop == 1) {
        nlj.a().a(localMessageForArkApp);
      }
      paramArkAppMessage = (ArkAppCenter)paramQQAppInterface.getManager(121);
      if ((paramArkAppMessage == null) || (localMessageForArkApp.ark_app_message == null)) {
        break label161;
      }
      paramArkAppMessage = paramArkAppMessage.a();
      if (paramArkAppMessage == null) {
        break label161;
      }
    }
    label161:
    for (boolean bool = paramArkAppMessage.a(paramQQAppInterface, localMessageForArkApp.ark_app_message.appName, paramSessionInfo, localMessageForArkApp);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, new Object[] { "AAShare.forwardArkMsgOption.isAsyncShareProcess=", Boolean.valueOf(bool) });
      }
      if (!bool) {
        paramQQAppInterface.a().a(localMessageForArkApp, null);
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
    paramSessionInfo = bcry.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkFlashChatMessage);
    if (paramInt == 0) {
      paramInt = paramArkFlashChatMessage.forwardID;
    }
    for (;;)
    {
      agsg.a().a(paramSessionInfo.uniseq, paramArkFlashChatMessage.uniSeq, paramInt);
      if (paramSessionInfo.istroop == 1) {
        nlj.a().a(paramSessionInfo);
      }
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, aocj paramaocj)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramHiBoomMessage, paramaocj, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, aocj paramaocj, int paramInt)
  {
    paramSessionInfo = bcry.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramHiBoomMessage);
    agsg.a().a(paramSessionInfo.uniseq, 0L, paramInt);
    if (paramSessionInfo.istroop == 1) {
      nlj.a().a(paramSessionInfo);
    }
    paramQQAppInterface.a().a(paramSessionInfo, paramaocj);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, aeau paramaeau)
  {
    return (axoz.a(paramQQAppInterface)) && (adak.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) && ((a(paramSessionInfo, paramString) > 560) || (a(paramaeau, true)));
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramaeau == null) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramContext = a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramaeau);
      ThreadManager.post(new ChatActivityFacade.15(paramaeau, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramContext;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    aeau localaeau = new aeau();
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramString = b(paramQQAppInterface, paramSessionInfo, paramString, null, localaeau);
      ThreadManager.post(new ChatActivityFacade.14(localaeau, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramString;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau)
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
        if (a(paramaeau, false))
        {
          localObject = b(str, paramArrayList, paramaeau, localArrayList);
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
          if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramaeau);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramaeau)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramaeau, localArrayList);
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
      paramArrayList = bhjx.a(str, 560, 20, paramArrayList, localArrayList);
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
    if (adak.d(paramSessionInfo.jdField_a_of_type_Int))
    {
      List localList = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)localList.get(i);
          if (!bhnt.b(paramSessionInfo.issend))
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
  
  private static ArrayList<String> b(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    paramaeau = new ArrayList();
    paramaeau.add(paramString);
    paramArrayList1.add(paramArrayList);
    return paramaeau;
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
    int i = bcpt.jdField_a_of_type_Int;
    bcpt.jdField_a_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramSessionInfo = bcry.a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l);
    paramQQAppInterface.a().a(paramSessionInfo, null);
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))) {
      ((FragmentActivity)paramContext).getChatFragment().a().a(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "create new shake message,shmsgseq is:" + paramSessionInfo.shmsgseq + ",msgUid is:" + paramSessionInfo.msgUid + ",time is:" + System.currentTimeMillis());
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, String paramString1, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramInt, -1, paramString1, paramString2, 2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131691989, 0);
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (localMessageRecord == null)
    {
      ChatActivityUtils.a(paramContext, 2131717877, 0);
      return;
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = bcry.a(localMessageRecord);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, new aeau());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
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
    if (paramSessionInfo.jdField_a_of_type_Int != 0)
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
      localFileManagerEntity = paramQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
      if ((localFileManagerEntity == null) && (QLog.isColorLevel())) {
        QLog.w("ChatActivityFacade", 2, "why FileManagerEntity is null?! may be is old data!");
      }
      if (paramChatMessage.isSendFromLocal()) {
        paramQQAppInterface.a().a(paramQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq));
      }
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.getCloudType() != 0) {
          break label139;
        }
        paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
        paramQQAppInterface.a().b(localFileManagerEntity);
        if (localFileManagerEntity.getCloudType() == 0) {
          paramQQAppInterface.a().d(localFileManagerEntity.nSessionId);
        }
        paramQQAppInterface.a().b(localFileManagerEntity.nSessionId);
      }
    }
    label139:
    do
    {
      return;
      paramQQAppInterface.a().a(localFileManagerEntity.nSessionId);
      break;
      if ((paramChatMessage instanceof MessageForDevShortVideo))
      {
        ((DeviceFileHandler)paramQQAppInterface.a(50)).a(0, ((MessageForDevShortVideo)paramChatMessage).fileSessionId, false);
        return;
      }
    } while (!(paramChatMessage instanceof MessageForDevPtt));
    ((DeviceFileHandler)paramQQAppInterface.a(50)).a(0, ((MessageForDevPtt)paramChatMessage).fileSessionId, false);
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
    if (FeedsManager.isShowStatus(paramSessionInfo.jdField_a_of_type_JavaLangString))
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
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return false;
    }
    EmoticonPackage localEmoticonPackage = ((axfj)paramQQAppInterface.getManager(14)).a(paramString);
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
  
  public static long[] b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aeau paramaeau)
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
        if (a(paramaeau, false))
        {
          localObject = b(str, paramArrayList, paramaeau, localArrayList);
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
          if ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)) {
            j = Math.abs(localRandom.nextInt());
          }
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramaeau, true);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramaeau)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramaeau, localArrayList);
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
      paramArrayList = bhjx.a(str, 560, 20, paramArrayList, localArrayList);
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
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, 1, -1, "", "", 0);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, long paramLong)
  {
    paramContext = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (paramContext != null)
    {
      paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
      paramContext = bcry.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ChatActivityFacade", 2, "resendApolloMessage : mr is null.");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
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
        i = paramSessionInfo.jdField_a_of_type_Int;
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
      adak.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4020);
      paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4020, (String)localObject2);
      VasWebviewUtil.reportCommercialDrainage(paramSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_show", "", 1, 0, 0, "", String.valueOf(i), "");
      return;
      localObject2 = (VasExtensionHandler)paramQQAppInterface.a(71);
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
    BeancurdMsg localBeancurdMsg = ((aggr)paramQQAppInterface.getManager(282)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 12);
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
    Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
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
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   没有qzone历史豆腐块,sessionInfo.curFriendUin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + ",sessionInfo.curType=" + paramSessionInfo.jdField_a_of_type_Int + " busiID=" + 2);
      l1 = l2;
      break;
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
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
      if (!bmtd.m()) {
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
    paramQQAppInterface = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
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
    MessageRecord localMessageRecord = bcry.a(-4005);
    long l = bcrg.a();
    localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131693500), l, -4005, paramSessionInfo.jdField_a_of_type_Int, l);
    localMessageRecord.isread = true;
    if (!aoci.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
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
      if (!bmtd.n()) {
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
    localObject2 = paramQQAppInterface.a();
    paramSessionInfo = paramSessionInfo.jdField_a_of_type_JavaLangString;
    paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
    int i = bcpt.jdField_a_of_type_Int;
    bcpt.jdField_a_of_type_Int = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  private static boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    while (bmtd.o()) {
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
    Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
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
      paramQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      paramQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
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
    paramSessionInfo = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2015 });
    if (paramSessionInfo != null)
    {
      paramSessionInfo = paramSessionInfo.iterator();
      while (paramSessionInfo.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramSessionInfo.next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          bhsi.a(paramQQAppInterface.c(), localMessageRecord.frienduin, 0L);
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
    ((aggr)paramQQAppInterface.getManager(282)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 7);
    Object localObject = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, 0, new int[] { -2074 });
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
    a(paramQQAppInterface, paramSessionInfo, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aean
 * JD-Core Version:    0.7.0.1
 */