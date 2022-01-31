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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade.1;
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
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
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
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
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
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
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aael
{
  public static long a;
  private static aaeq jdField_a_of_type_Aaeq = new aaeq();
  public static bbmy a;
  public static begr a;
  public static ChatMessage a;
  public static List<ChatMessage> a;
  private static ConcurrentHashMap<String, aaer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public static begr b;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private static int a(SessionInfo paramSessionInfo, String paramString)
  {
    if ((!amix.c().jdField_b_of_type_Boolean) && ((paramSessionInfo.jdField_a_of_type_Int == 3000) || (paramSessionInfo.jdField_a_of_type_Int == 1)))
    {
      paramString = azzz.a(paramString);
      int j = paramString[0];
      int i = j;
      if (paramSessionInfo.jdField_a_of_type_Int == 1) {
        i = j + paramString[1] * 2;
      }
      return i;
    }
    return paramString.getBytes("utf-8").length;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt, ArrayList<String> paramArrayList)
  {
    long l1 = -1L;
    paramArrayList = awvt.a(paramArrayList);
    if (paramArrayList != null)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      int i = avys.jdField_a_of_type_Int;
      avys.jdField_a_of_type_Int = i + 1;
      l1 = i;
      paramSessionInfo = awbi.a(paramQQAppInterface, str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l1, paramArrayList);
      long l2 = paramSessionInfo.uniseq;
      paramSessionInfo.msgUid = awbk.a(paramInt);
      l1 = l2;
      if (!ajml.a(paramQQAppInterface, paramSessionInfo, false))
      {
        paramQQAppInterface.a().b(paramSessionInfo, paramSessionInfo.selfuin);
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
        int j = bahn.a(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", localMessageForPtt.vipBubbleDiyTextId);
        a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, paramString, l2, true, i * 1000, j, true, 0, 0, true, localMessageForPtt.vipSubBubbleId, localBundle);
        l1 = l2;
      }
    }
    return l1;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramString, paramInt1, paramBoolean, paramByte1, paramByte2, paramShort, paramInt2, paramArrayList, paramaaes, false);
  }
  
  /* Error */
  public static long a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean1, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +42 -> 45
    //   6: ldc 172
    //   8: iconst_2
    //   9: new 174	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   16: ldc 177
    //   18: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   24: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   27: ldc 192
    //   29: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: getfield 194	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   36: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_2
    //   46: ifnull +1355 -> 1401
    //   49: aload_2
    //   50: iconst_1
    //   51: aload 9
    //   53: invokestatic 206	awbk:a	(Ljava/lang/String;ZLjava/util/ArrayList;)Ljava/lang/String;
    //   56: astore 14
    //   58: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +30 -> 91
    //   64: ldc 172
    //   66: iconst_2
    //   67: new 174	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   74: ldc 208
    //   76: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   82: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 10
    //   93: getfield 213	aaes:jdField_e_of_type_Long	J
    //   96: lconst_0
    //   97: lcmp
    //   98: ifeq +640 -> 738
    //   101: new 215	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   104: dup
    //   105: invokespecial 216	com/tencent/mobileqq/data/MessageForWantGiftMsg:<init>	()V
    //   108: astore_2
    //   109: aload_2
    //   110: checkcast 215	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   113: aload 10
    //   115: getfield 213	aaes:jdField_e_of_type_Long	J
    //   118: putfield 219	com/tencent/mobileqq/data/MessageForWantGiftMsg:wantGiftSenderUin	J
    //   121: aload_2
    //   122: checkcast 215	com/tencent/mobileqq/data/MessageForWantGiftMsg
    //   125: getstatic 222	com/tencent/mobileqq/data/MessageForWantGiftMsg:GIFT_SENDER_UIN	Ljava/lang/String;
    //   128: new 174	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   135: aload 10
    //   137: getfield 213	aaes:jdField_e_of_type_Long	J
    //   140: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: ldc 224
    //   145: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 228	com/tencent/mobileqq/data/MessageForWantGiftMsg:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_2
    //   155: sipush -2056
    //   158: putfield 233	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   161: aload_0
    //   162: aload_2
    //   163: aload_1
    //   164: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   167: aload_1
    //   168: getfield 235	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   171: aload_1
    //   172: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   175: invokestatic 238	awbi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;Ljava/lang/String;I)V
    //   178: aload_2
    //   179: aload 14
    //   181: putfield 241	com/tencent/mobileqq/data/ChatMessage:msg	Ljava/lang/String;
    //   184: aload_2
    //   185: iload 8
    //   187: invokestatic 101	awbk:a	(I)J
    //   190: putfield 242	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   193: aload_2
    //   194: iload 5
    //   196: putfield 245	com/tencent/mobileqq/data/ChatMessage:longMsgCount	I
    //   199: aload_2
    //   200: iload 6
    //   202: putfield 248	com/tencent/mobileqq/data/ChatMessage:longMsgIndex	I
    //   205: aload_2
    //   206: iload 7
    //   208: putfield 251	com/tencent/mobileqq/data/ChatMessage:longMsgId	I
    //   211: aload_2
    //   212: iconst_1
    //   213: putfield 254	com/tencent/mobileqq/data/ChatMessage:mAnimFlag	Z
    //   216: aload 10
    //   218: getfield 257	aaes:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   221: ifnull +30 -> 251
    //   224: aload_2
    //   225: ldc_w 259
    //   228: aload 10
    //   230: getfield 257	aaes:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo	Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;
    //   233: invokevirtual 264	com/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo:toJsonString	()Ljava/lang/String;
    //   236: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload_2
    //   240: aconst_null
    //   241: invokestatic 270	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/emoticon/EmojiStickerManager$StickerInfo;)V
    //   244: invokestatic 273	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	()Lcom/tencent/mobileqq/emoticon/EmojiStickerManager;
    //   247: aload_2
    //   248: invokevirtual 276	com/tencent/mobileqq/emoticon/EmojiStickerManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   251: aload 10
    //   253: getfield 279	aaes:i	Z
    //   256: ifeq +8 -> 264
    //   259: aload_2
    //   260: iconst_m1
    //   261: putfield 282	com/tencent/mobileqq/data/ChatMessage:mRobotFlag	I
    //   264: aload 10
    //   266: getfield 285	aaes:jdField_g_of_type_Int	I
    //   269: iconst_m1
    //   270: if_icmpeq +18 -> 288
    //   273: aload_2
    //   274: ldc_w 287
    //   277: aload 10
    //   279: getfield 285	aaes:jdField_g_of_type_Int	I
    //   282: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_2
    //   289: instanceof 293
    //   292: ifeq +941 -> 1233
    //   295: aload_2
    //   296: checkcast 293	com/tencent/mobileqq/data/MessageForReplyText
    //   299: astore 14
    //   301: aload 14
    //   303: aload_1
    //   304: getfield 194	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   307: putfield 296	com/tencent/mobileqq/data/MessageForReplyText:msgVia	I
    //   310: aload 14
    //   312: aload 10
    //   314: getfield 298	aaes:jdField_d_of_type_Boolean	Z
    //   317: putfield 301	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   320: aload 14
    //   322: aload 10
    //   324: getfield 303	aaes:jdField_b_of_type_Long	J
    //   327: putfield 306	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   330: aload 14
    //   332: aload 10
    //   334: getfield 308	aaes:jdField_d_of_type_Int	I
    //   337: putfield 311	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   340: aload 14
    //   342: getfield 301	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   345: ifeq +35 -> 380
    //   348: aload 14
    //   350: ldc_w 313
    //   353: aload 14
    //   355: getfield 306	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   358: invokestatic 316	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   361: invokevirtual 317	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload 14
    //   366: ldc_w 319
    //   369: aload 14
    //   371: getfield 311	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   374: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   377: invokevirtual 317	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 9
    //   382: ifnull +10 -> 392
    //   385: aload 14
    //   387: aload 9
    //   389: putfield 323	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   392: aload 10
    //   394: getfield 326	aaes:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   397: invokestatic 331	akhp:a	(Ljava/io/Serializable;)[B
    //   400: invokestatic 336	bach:a	([B)Ljava/lang/String;
    //   403: astore 9
    //   405: aload 14
    //   407: aload 10
    //   409: getfield 326	aaes:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   412: putfield 339	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   415: aload 14
    //   417: ldc_w 341
    //   420: aload 9
    //   422: invokevirtual 317	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: aload 14
    //   427: aload 14
    //   429: getfield 344	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   432: iconst_1
    //   433: ior
    //   434: putfield 344	com/tencent/mobileqq/data/MessageForReplyText:extLong	I
    //   437: aload 14
    //   439: getfield 339	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   442: invokevirtual 350	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:getSourceMsg	()[B
    //   445: ifnull +17 -> 462
    //   448: aload 14
    //   450: aload 14
    //   452: getfield 339	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   455: aload_0
    //   456: invokevirtual 354	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:unPackSourceMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   459: invokevirtual 357	com/tencent/mobileqq/data/MessageForReplyText:setSourceMessageRecord	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   462: aload 10
    //   464: getfield 358	aaes:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   467: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   470: ifne +40 -> 510
    //   473: aload 10
    //   475: getfield 365	aaes:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   478: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +29 -> 510
    //   484: aload 14
    //   486: ldc_w 367
    //   489: aload 10
    //   491: getfield 358	aaes:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   494: invokevirtual 317	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload 14
    //   499: ldc_w 369
    //   502: aload 10
    //   504: getfield 365	aaes:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   507: invokevirtual 317	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload 10
    //   512: getfield 371	aaes:jdField_e_of_type_Int	I
    //   515: ifle +23 -> 538
    //   518: invokestatic 376	acvh:a	()Lacvh;
    //   521: aload_2
    //   522: getfield 377	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   525: aload 10
    //   527: getfield 379	aaes:jdField_c_of_type_Long	J
    //   530: aload 10
    //   532: getfield 371	aaes:jdField_e_of_type_Int	I
    //   535: invokevirtual 382	acvh:a	(JJI)V
    //   538: aload_2
    //   539: getfield 385	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   542: iconst_1
    //   543: if_icmpne +727 -> 1270
    //   546: invokestatic 390	mnf:a	()Lmnf;
    //   549: aload_2
    //   550: invokevirtual 391	mnf:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   553: aload 10
    //   555: getfield 392	aaes:jdField_b_of_type_Boolean	Z
    //   558: ifeq +7 -> 565
    //   561: aload_2
    //   562: invokestatic 395	amvy:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   565: aload_2
    //   566: getfield 385	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   569: sipush 1033
    //   572: if_icmpeq +13 -> 585
    //   575: aload_2
    //   576: getfield 385	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   579: sipush 1034
    //   582: if_icmpne +707 -> 1289
    //   585: aload_0
    //   586: aload_2
    //   587: aload_2
    //   588: getfield 398	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   591: aload_2
    //   592: getfield 385	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   595: aload_1
    //   596: getfield 399	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_e_of_type_Int	I
    //   599: invokestatic 404	alyc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;II)V
    //   602: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq +58 -> 663
    //   608: ldc 172
    //   610: iconst_2
    //   611: new 174	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 406
    //   621: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_2
    //   625: getfield 409	com/tencent/mobileqq/data/ChatMessage:time	J
    //   628: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   631: ldc_w 411
    //   634: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload_2
    //   638: getfield 414	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   641: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: ldc_w 416
    //   647: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: aload_2
    //   651: getfield 242	com/tencent/mobileqq/data/ChatMessage:msgUid	J
    //   654: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   657: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: aload 10
    //   665: getfield 419	aaes:f	Z
    //   668: istore 4
    //   670: aload 10
    //   672: getfield 421	aaes:jdField_g_of_type_Boolean	Z
    //   675: ifeq +695 -> 1370
    //   678: iload 4
    //   680: ifeq +647 -> 1327
    //   683: aload_0
    //   684: sipush 166
    //   687: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   690: checkcast 427	arxo
    //   693: aload_0
    //   694: aload_2
    //   695: iconst_0
    //   696: invokevirtual 430	arxo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   699: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq +31 -> 733
    //   705: ldc 172
    //   707: iconst_2
    //   708: new 174	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   715: ldc_w 432
    //   718: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   724: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   727: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: aload_2
    //   734: getfield 377	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   737: lreturn
    //   738: aload 10
    //   740: getfield 434	aaes:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   743: ifnull +45 -> 788
    //   746: aload_0
    //   747: invokestatic 439	agjk:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   750: ifeq +38 -> 788
    //   753: new 441	com/tencent/mobileqq/data/MessageForFoldMsg
    //   756: dup
    //   757: invokespecial 442	com/tencent/mobileqq/data/MessageForFoldMsg:<init>	()V
    //   760: astore_2
    //   761: aload_2
    //   762: checkcast 441	com/tencent/mobileqq/data/MessageForFoldMsg
    //   765: iconst_0
    //   766: aload 10
    //   768: getfield 434	aaes:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   771: aload 10
    //   773: getfield 444	aaes:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   776: aload 10
    //   778: getfield 446	aaes:jdField_d_of_type_Long	J
    //   781: iconst_1
    //   782: invokevirtual 450	com/tencent/mobileqq/data/MessageForFoldMsg:init	(ZLjava/lang/String;Ljava/lang/String;JZ)V
    //   785: goto -624 -> 161
    //   788: aload 10
    //   790: getfield 326	aaes:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   793: ifnonnull +31 -> 824
    //   796: aload 10
    //   798: getfield 419	aaes:f	Z
    //   801: ifeq +23 -> 824
    //   804: aload_0
    //   805: invokestatic 451	arxo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   808: ifeq +16 -> 824
    //   811: sipush -1051
    //   814: invokestatic 454	awbi:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   817: checkcast 230	com/tencent/mobileqq/data/ChatMessage
    //   820: astore_2
    //   821: goto -660 -> 161
    //   824: aload 10
    //   826: getfield 326	aaes:jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   829: ifnull +564 -> 1393
    //   832: sipush -1049
    //   835: istore 12
    //   837: iload 12
    //   839: invokestatic 454	awbi:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   842: checkcast 230	com/tencent/mobileqq/data/ChatMessage
    //   845: astore_2
    //   846: aload_0
    //   847: bipush 51
    //   849: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   852: checkcast 456	ajjj
    //   855: astore 15
    //   857: aload 15
    //   859: aload_0
    //   860: invokevirtual 458	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   863: iconst_0
    //   864: invokevirtual 461	ajjj:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   867: astore 16
    //   869: aload 16
    //   871: ifnull +56 -> 927
    //   874: aload_2
    //   875: ldc_w 463
    //   878: aload 16
    //   880: invokestatic 468	fv:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)I
    //   883: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   886: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: aload_2
    //   890: ldc_w 470
    //   893: aload 16
    //   895: getfield 475	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   898: invokestatic 478	fv:c	(J)I
    //   901: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   904: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: iconst_1
    //   908: aload 16
    //   910: getfield 481	com/tencent/mobileqq/data/ExtensionInfo:magicFont	I
    //   913: if_icmpne +232 -> 1145
    //   916: aload_2
    //   917: ldc_w 483
    //   920: iconst_0
    //   921: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   924: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   927: aload 15
    //   929: aload_0
    //   930: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   933: invokevirtual 486	ajjj:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   936: astore 15
    //   938: aload 15
    //   940: ifnull +160 -> 1100
    //   943: aload 15
    //   945: getstatic 492	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   948: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   951: ifeq +63 -> 1014
    //   954: iconst_1
    //   955: istore_3
    //   956: aload 15
    //   958: getstatic 492	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   961: invokevirtual 502	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   964: iconst_1
    //   965: if_icmpne +5 -> 970
    //   968: iconst_3
    //   969: istore_3
    //   970: aload_2
    //   971: ldc_w 504
    //   974: iload_3
    //   975: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   978: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   981: aload_2
    //   982: ldc_w 506
    //   985: aload 15
    //   987: getstatic 492	QQService/EVIPSPEC:E_SP_BIGCLUB	LQQService/EVIPSPEC;
    //   990: invokevirtual 509	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   993: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   996: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   999: aload_2
    //   1000: ldc_w 511
    //   1003: aload 15
    //   1005: getfield 514	com/tencent/mobileqq/data/Friends:bigClubTemplateId	I
    //   1008: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1011: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1014: aload 15
    //   1016: getstatic 517	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1019: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1022: ifne +14 -> 1036
    //   1025: aload 15
    //   1027: getstatic 520	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1030: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1033: ifeq +67 -> 1100
    //   1036: aload 15
    //   1038: getstatic 520	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1041: invokevirtual 498	com/tencent/mobileqq/data/Friends:isServiceEnabled	(LQQService/EVIPSPEC;)Z
    //   1044: ifeq +119 -> 1163
    //   1047: sipush 256
    //   1050: istore_3
    //   1051: aload 15
    //   1053: getstatic 520	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1056: invokevirtual 502	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1059: iconst_1
    //   1060: if_icmpne +7 -> 1067
    //   1063: sipush 258
    //   1066: istore_3
    //   1067: aload 15
    //   1069: getstatic 520	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   1072: invokevirtual 509	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1075: istore 13
    //   1077: aload_2
    //   1078: ldc_w 522
    //   1081: iload_3
    //   1082: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1085: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1088: aload_2
    //   1089: ldc_w 524
    //   1092: iload 13
    //   1094: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1097: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1100: aload 9
    //   1102: ifnull +13 -> 1115
    //   1105: aload_1
    //   1106: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   1109: aload 9
    //   1111: aload_2
    //   1112: invokestatic 529	azef:a	(ILjava/util/ArrayList;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   1115: iload 12
    //   1117: sipush -1000
    //   1120: if_icmpne +22 -> 1142
    //   1123: aload 10
    //   1125: getfield 532	aaes:h	Z
    //   1128: ifeq +14 -> 1142
    //   1131: aload_2
    //   1132: ldc_w 534
    //   1135: iconst_1
    //   1136: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1139: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1142: goto -981 -> 161
    //   1145: aload_2
    //   1146: ldc_w 483
    //   1149: aload 16
    //   1151: getfield 537	com/tencent/mobileqq/data/ExtensionInfo:fontEffect	I
    //   1154: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1157: invokevirtual 265	com/tencent/mobileqq/data/ChatMessage:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1160: goto -233 -> 927
    //   1163: iconst_1
    //   1164: istore_3
    //   1165: aload 15
    //   1167: getstatic 517	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1170: invokevirtual 502	com/tencent/mobileqq/data/Friends:getServiceType	(LQQService/EVIPSPEC;)I
    //   1173: iconst_1
    //   1174: if_icmpne +5 -> 1179
    //   1177: iconst_3
    //   1178: istore_3
    //   1179: aload 15
    //   1181: getstatic 517	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   1184: invokevirtual 509	com/tencent/mobileqq/data/Friends:getServiceLevel	(LQQService/EVIPSPEC;)I
    //   1187: istore 13
    //   1189: goto -112 -> 1077
    //   1192: astore 9
    //   1194: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1197: ifeq -659 -> 538
    //   1200: ldc 172
    //   1202: iconst_2
    //   1203: new 174	java/lang/StringBuilder
    //   1206: dup
    //   1207: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1210: ldc_w 539
    //   1213: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload 9
    //   1218: invokevirtual 542	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1221: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1230: goto -692 -> 538
    //   1233: aload_2
    //   1234: checkcast 544	com/tencent/mobileqq/data/MessageForText
    //   1237: astore 14
    //   1239: aload 14
    //   1241: aload_1
    //   1242: getfield 194	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   1245: putfield 545	com/tencent/mobileqq/data/MessageForText:msgVia	I
    //   1248: aload 9
    //   1250: ifnull +10 -> 1260
    //   1253: aload 14
    //   1255: aload 9
    //   1257: putfield 546	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   1260: aload 14
    //   1262: aload 10
    //   1264: invokevirtual 550	com/tencent/mobileqq/data/MessageForText:setSendMsgParams	(Laaes;)V
    //   1267: goto -729 -> 538
    //   1270: invokestatic 390	mnf:a	()Lmnf;
    //   1273: getfield 552	mnf:jdField_a_of_type_Boolean	Z
    //   1276: ifeq -723 -> 553
    //   1279: invokestatic 390	mnf:a	()Lmnf;
    //   1282: iconst_0
    //   1283: putfield 552	mnf:jdField_a_of_type_Boolean	Z
    //   1286: goto -733 -> 553
    //   1289: aload_1
    //   1290: getfield 555	com/tencent/mobileqq/activity/aio/SessionInfo:j	Z
    //   1293: ifeq +15 -> 1308
    //   1296: aload_0
    //   1297: aload_2
    //   1298: aload_1
    //   1299: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1302: invokestatic 558	alyc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1305: goto -703 -> 602
    //   1308: aload_1
    //   1309: getfield 561	com/tencent/mobileqq/activity/aio/SessionInfo:k	Z
    //   1312: ifeq -710 -> 602
    //   1315: aload_0
    //   1316: aload_2
    //   1317: aload_1
    //   1318: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1321: invokestatic 563	alyc:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1324: goto -722 -> 602
    //   1327: iload 11
    //   1329: ifeq +29 -> 1358
    //   1332: aload_0
    //   1333: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1336: aload_2
    //   1337: invokevirtual 565	com/tencent/mobileqq/app/message/QQMessageFacade:b	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1340: goto -641 -> 699
    //   1343: astore_0
    //   1344: ldc_w 567
    //   1347: iconst_1
    //   1348: ldc_w 569
    //   1351: aload_0
    //   1352: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1355: goto -656 -> 699
    //   1358: aload_0
    //   1359: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1362: aload_2
    //   1363: aconst_null
    //   1364: invokevirtual 575	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lajmm;)V
    //   1367: goto -668 -> 699
    //   1370: new 577	com/tencent/mobileqq/activity/ChatActivityFacade$13
    //   1373: dup
    //   1374: iload 4
    //   1376: aload_0
    //   1377: aload_2
    //   1378: iload 11
    //   1380: invokespecial 580	com/tencent/mobileqq/activity/ChatActivityFacade$13:<init>	(ZLcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/ChatMessage;Z)V
    //   1383: bipush 10
    //   1385: aconst_null
    //   1386: iconst_0
    //   1387: invokestatic 586	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1390: goto -691 -> 699
    //   1393: sipush -1000
    //   1396: istore 12
    //   1398: goto -561 -> 837
    //   1401: ldc 224
    //   1403: astore 14
    //   1405: goto -1347 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1408	0	paramQQAppInterface	QQAppInterface
    //   0	1408	1	paramSessionInfo	SessionInfo
    //   0	1408	2	paramString	String
    //   0	1408	3	paramInt1	int
    //   0	1408	4	paramBoolean1	boolean
    //   0	1408	5	paramByte1	byte
    //   0	1408	6	paramByte2	byte
    //   0	1408	7	paramShort	short
    //   0	1408	8	paramInt2	int
    //   0	1408	9	paramArrayList	ArrayList<MessageForText.AtTroopMemberInfo>
    //   0	1408	10	paramaaes	aaes
    //   0	1408	11	paramBoolean2	boolean
    //   835	562	12	i	int
    //   1075	113	13	j	int
    //   56	1348	14	localObject1	Object
    //   855	325	15	localObject2	Object
    //   867	283	16	localExtensionInfo	ExtensionInfo
    // Exception table:
    //   from	to	target	type
    //   392	462	1192	java/lang/Exception
    //   462	510	1192	java/lang/Exception
    //   510	538	1192	java/lang/Exception
    //   683	699	1343	java/lang/Exception
    //   1332	1340	1343	java/lang/Exception
    //   1358	1367	1343	java/lang/Exception
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    if (paramString1 != null)
    {
      paramString1 = axwb.a(paramString1, paramString3, paramString4, paramLong, paramInt2);
      paramString3 = awbi.a(-20000);
      paramString3.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.frienduin = paramString2;
      paramString3.senderuin = paramQQAppInterface.getCurrentAccountUin();
      paramString3.msg = paramString1;
      paramString3.msgtype = -20000;
      paramString3.isread = true;
      paramString3.issend = 1;
      paramString3.istroop = paramInt1;
      ((ajrm)paramQQAppInterface.a(13)).a(paramString3);
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
    paramQQAppInterface = awbi.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.path = paramString;
    paramQQAppInterface.size = 0L;
    paramQQAppInterface.type = 1;
    paramQQAppInterface.isRead = true;
    paramQQAppInterface.serial();
    return paramQQAppInterface;
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, int paramInt1, boolean paramBoolean, byte paramByte1, byte paramByte2, short paramShort, int paramInt2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend start, currenttime:" + System.currentTimeMillis() + " sessionInfo.entrance:" + paramSessionInfo.c);
    }
    if (paramString != null) {}
    for (String str = awbk.a(paramString, true, paramArrayList);; str = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 1  currenttime:" + System.currentTimeMillis());
      }
      if (paramaaes.jdField_e_of_type_Long != 0L)
      {
        paramString = new MessageForWantGiftMsg();
        ((MessageForWantGiftMsg)paramString).wantGiftSenderUin = paramaaes.jdField_e_of_type_Long;
        ((MessageForWantGiftMsg)paramString).saveExtInfoToExtStr(MessageForWantGiftMsg.GIFT_SENDER_UIN, paramaaes.jdField_e_of_type_Long + "");
        paramString.msgtype = -2056;
      }
      for (;;)
      {
        awbi.a(paramQQAppInterface, paramString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
        paramString.msg = str;
        paramString.msgUid = awbk.a(paramInt2);
        paramString.longMsgCount = paramByte1;
        paramString.longMsgIndex = paramByte2;
        paramString.longMsgId = paramShort;
        paramString.mAnimFlag = true;
        if (paramaaes.i) {
          paramString.mRobotFlag = -1;
        }
        paramString.saveExtInfoToExtStr("robot_news_class_id", String.valueOf(paramaaes.jdField_g_of_type_Int));
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
          paramQQAppInterface.saveExtInfoToExtStr("sens_msg_source_msg_info", bach.a(akhp.a(paramaaes.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo)));
          if ((!TextUtils.isEmpty(paramaaes.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramaaes.jdField_b_of_type_JavaLangString)))
          {
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_msg", paramaaes.jdField_a_of_type_JavaLangString);
            paramQQAppInterface.saveExtInfoToExtStr("sens_reply_special_at_list", paramaaes.jdField_b_of_type_JavaLangString);
          }
          paramQQAppInterface.mSourceMsgInfo = paramaaes.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
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
        mnf.a().a(paramString);
        label373:
        if (paramaaes.jdField_b_of_type_Boolean) {
          amvy.a(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " createMsgQueueAndSend step 2 time = " + paramString.time + " senderUin = " + paramString.senderuin + " msgUid = " + paramString.msgUid);
        }
        return paramString;
        if ((paramaaes.jdField_c_of_type_JavaLangString != null) && (agjk.a(paramQQAppInterface)))
        {
          paramString = new MessageForFoldMsg();
          ((MessageForFoldMsg)paramString).init(false, paramaaes.jdField_c_of_type_JavaLangString, paramaaes.jdField_d_of_type_JavaLangString, paramaaes.jdField_d_of_type_Long, true);
        }
        else
        {
          if ((paramaaes.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) || (!paramaaes.f) || (!arxo.a(paramQQAppInterface))) {
            break;
          }
          paramString = (ChatMessage)awbi.a(-1051);
        }
      }
      if (paramaaes.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {}
      for (paramInt1 = -1049;; paramInt1 = -1000)
      {
        paramString = (ChatMessage)awbi.a(paramInt1);
        ExtensionInfo localExtensionInfo = ((ajjj)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.c(), false);
        if (localExtensionInfo != null)
        {
          paramString.saveExtInfoToExtStr("vip_font_id", String.valueOf(fv.a(localExtensionInfo)));
          paramString.saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(fv.c(localExtensionInfo.uVipFont)));
          if (1 != localExtensionInfo.magicFont) {
            break label675;
          }
          paramString.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
        }
        for (;;)
        {
          if (paramArrayList != null) {
            azef.a(paramSessionInfo.jdField_a_of_type_Int, paramArrayList, paramString);
          }
          if ((paramInt1 == -1000) && (paramaaes.h)) {
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
        paramQQAppInterface.setSendMsgParams(paramaaes);
        break label358;
        label765:
        if (!mnf.a().jdField_a_of_type_Boolean) {
          break label373;
        }
        mnf.a().jdField_a_of_type_Boolean = false;
        break label373;
      }
    }
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes)
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
        if (a(paramaaes, false))
        {
          paramArrayList = b(str, paramArrayList, paramaaes, localArrayList);
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
            return a(paramQQAppInterface, paramSessionInfo, str, -1000, bool, (byte)paramString.size(), (byte)0, s, i, paramArrayList, paramaaes);
          }
        }
        else
        {
          if (a(paramQQAppInterface, paramSessionInfo, str, paramaaes))
          {
            paramArrayList = a(str, paramArrayList, paramaaes, localArrayList);
            paramString = paramArrayList;
            if (!QLog.isColorLevel()) {
              break label512;
            }
            QLog.d("SendMsgBtn", 2, " createTextMessage step 1, partAtInfoArrayLists.size() = " + localArrayList.size() + " isLongTextMsg:true, symbolLens:" + str.getBytes("utf-8").length + " currenttime:" + System.currentTimeMillis());
            paramString = paramArrayList;
            continue;
          }
          paramString = azzz.a(str, 560, 20, paramArrayList, localArrayList);
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
        localObject1 = awbi.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i);
        ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(paramInt2, paramString);
        ((MessageForPtt)localObject1).fileSize = paramInt1;
        ((MessageForPtt)localObject1).itemType = 2;
        if ((!axaf.a(i)) || (!axaf.a(paramQQAppInterface))) {
          break label186;
        }
        paramInt1 = 1;
        ((MessageForPtt)localObject1).sttAbility = paramInt1;
        ((MessageForPtt)localObject1).voiceType = paramInt2;
        ((MessageForPtt)localObject1).longPttVipFlag = awbk.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        mnf.a().a((MessageRecord)localObject1);
        if ((paramSessionInfo.jdField_a_of_type_Int != 1033) && ((paramSessionInfo.jdField_a_of_type_Int != 1034) || (paramSessionInfo.jdField_e_of_type_Int <= 0))) {
          break label191;
        }
        alyc.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      ((MessageForPtt)localObject1).serial();
      ((ajrm)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
      return localObject1;
      label186:
      paramInt1 = 0;
      break;
      label191:
      if (paramSessionInfo.j) {
        alyc.a(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString);
      } else if (paramSessionInfo.k) {
        alyc.b(paramQQAppInterface, (MessageRecord)localObject1, paramSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (akbm.c(paramSessionInfo.jdField_a_of_type_Int))
    {
      paramQQAppInterface = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        int i = paramQQAppInterface.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
          if (!bado.b(paramSessionInfo.issend)) {
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
        localObject1 = awbi.a(paramMessageForPtt);
        ((ajrm)paramQQAppInterface.a(13)).a((MessageRecord)localObject1);
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
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, 30, paramString.toString()).toString();
      localArrayList.add(new StructMsgItemTitle(paramMessageRecord));
      paramString = paramMessageRecord;
      if (paramMessageRecord.length() > 30) {
        paramString = paramMessageRecord.substring(0, 30);
      }
      paramMessageRecord = paramContext.getString(2131625153);
      paramContext = new awui(StructMsgForGeneralShare.class).c(35).a(paramString).a(3).a("viewMultiMsg", "", null, null, null).a(paramMessageRecord, null).d(paramContext.getResources().getString(2131628800)).a();
      paramMessageRecord = new awws(localArrayList);
      paramMessageRecord.a(new awwq());
      paramMessageRecord.a(new awzf(ajjy.a(2131635758)));
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
        if (axku.a(paramString)) {
          str = axku.d(paramString);
        }
        if (!mnf.a(paramMessageRecord)) {
          break label386;
        }
      }
    }
    for (;;)
    {
      paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, i, str).toString();
      break;
      paramString = paramString.msg;
      break label244;
      paramString = (MessageForLongTextMsg)paramMessageRecord;
      if (paramString.sb != null)
      {
        paramString = paramString.sb.toString();
        label323:
        str = paramString;
        if (axku.a(paramString)) {
          str = axku.d(paramString);
        }
        if (!mnf.a(paramMessageRecord)) {
          break label380;
        }
      }
      for (;;)
      {
        paramMessageRecord = a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 2, i, str).toString();
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
      localObject1 = (String)paramMap.get(akbm.c((MessageRecord)localObject3));
      paramString = (String)localObject1;
      if (((ChatMessage)localObject3).istroop == 1) {
        paramString = axku.h((String)localObject1);
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
      localArrayList.add(new StructMsgItemTitle(a(paramContext, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.8F), 3, 46, ((StringBuilder)localObject2).toString(), (boolean[])localObject1).toString()));
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
      localObject1 = aryb.a(((ChatMessage)localObject3).senderuin);
      break label185;
      label381:
      if ((localObject3 instanceof MessageForShortVideo))
      {
        if (((ChatMessage)localObject3).msgtype == -2071) {
          paramString = ajjy.a(2131635762);
        } else {
          paramString = ajjy.a(2131635771);
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
            if (axku.a(paramString)) {
              str = axku.d(paramString);
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
          paramString = ajjy.a(2131635779);
          continue;
          paramString = paramContext.getString(2131625153);
          localObject3 = new awui(StructMsgForGeneralShare.class).c(35).a(ajjy.a(2131635778)).a(3).a("viewMultiMsg", "", null, null, null).a(paramString, null).a();
          localObject4 = new awws();
          ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
          if ((localChatMessage.istroop == 1) || (localChatMessage.istroop == 3000)) {
            paramContext = ajjy.a(2131635759);
          }
          for (;;)
          {
            paramString = paramContext;
            if (TextUtils.isEmpty(paramContext))
            {
              QLog.w("ChatActivityFacade", 1, "generateMultiMsgForwardStructMsg: titleStr is null");
              paramString = ajjy.a(2131635775);
            }
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG.Nest", 2, String.format("step.generateStructMsgContent:titleStr = %s,listSize = %d,firstMsg.istroop = %d", new Object[] { paramString, Integer.valueOf(paramList.size()), Integer.valueOf(localChatMessage.istroop) }));
            }
            paramContext = new StructMsgItemTitle(paramString);
            paramContext.f("34");
            paramContext.g("12");
            paramContext.h("2");
            ((awum)localObject4).a(paramContext);
            paramContext = localArrayList.iterator();
            for (;;)
            {
              if (paramContext.hasNext())
              {
                paramString = (awul)paramContext.next();
                if ((paramString instanceof awun))
                {
                  paramMap = (awun)paramString;
                  paramMap.f("26");
                  paramMap.e("#777777");
                  paramMap.g("12");
                  paramMap.h("4");
                }
                ((awum)localObject4).a(paramString);
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
                for (paramString = aryb.a(localChatMessage.senderuin);; paramString = (String)localObject2)
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
                      paramMap = aryb.a((String)localObject1);
                    }
                  }
                  localObject1 = new Paint();
                  ((Paint)localObject1).setTextSize(34.0F);
                  paramContext = a(paramContext, paramString, paramMap, 2, (int)(BaseChatItemLayout.jdField_e_of_type_Int * 0.7F), 2048, (Paint)localObject1, paramBoolean);
                  break;
                  ((awum)localObject4).a(new awwq());
                  paramContext = new awzf(String.format(ajjy.a(2131635756), new Object[] { Integer.valueOf(paramList.size()) }));
                  paramContext.f("26");
                  paramContext.e("#777777");
                  ((awum)localObject4).a(paramContext);
                  ((AbsShareMsg)localObject3).addItem((awul)localObject4);
                  ((AbsShareMsg)localObject3).mTSum = paramList.size();
                  if (QLog.isColorLevel())
                  {
                    paramContext = awwf.b(((AbsShareMsg)localObject3).getXmlBytes());
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
    paramString2 = paramString1 + ajjy.a(2131635764) + str + ajjy.a(2131635757);
    if (paramBoolean) {
      paramString2 = paramString1 + ajjy.a(2131635781);
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
        paramString2 = paramString2 + ajjy.a(2131635784);
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
        paramString2 = paramString2 + ajjy.a(2131635772);
        paramPaint = paramString2 + paramPaint;
        paramString2 = paramPaint;
        if (paramInt2 < str.length()) {
          paramString2 = paramPaint + "...";
        }
        paramString2 = paramString2 + ajjy.a(2131635780);
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
      localObject1 = (String)paramMap.get(akbm.c((MessageRecord)localObject2));
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label589;
      }
    }
    for (;;)
    {
      if ((localObject2 instanceof MessageForPic))
      {
        localObject2 = ajjy.a(2131635782);
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
          localObject2 = ajjy.a(2131635770);
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
            if (axku.a((String)localObject2)) {
              localObject1 = axku.d((String)localObject2);
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
          localObject1 = axku.b(localStringBuilder2.toString());
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
  private static ArrayList<String> a(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramArrayList1.add(paramArrayList);
    paramaaes.f = true;
    return localArrayList;
  }
  
  public static JSONObject a(NewestFeedInfo paramNewestFeedInfo, boolean paramBoolean, int paramInt)
  {
    if (paramNewestFeedInfo == null) {
      return null;
    }
    Object localObject = ajjy.a(2131635777);
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
  
  private static short a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, short paramShort, Random paramRandom)
  {
    if (paramBoolean)
    {
      int i = avys.jdField_a_of_type_Int;
      avys.jdField_a_of_type_Int = i + 1;
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
    if ((jdField_a_of_type_Begr != null) && (jdField_a_of_type_Begr.isShowing())) {}
    try
    {
      jdField_a_of_type_Begr.dismiss();
      jdField_a_of_type_Begr = null;
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
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Bundle paramBundle)
  {
    paramString4 = mpv.a(paramString4, 45, "UTF-8", "...");
    paramString5 = mpv.a(paramString5, 90, "UTF-8", "...");
    if (!paramContext.getResources().getString(2131630691).equals(paramString4))
    {
      paramString3 = paramContext.getResources().getString(2131625719) + " " + paramString4;
      paramString6 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + paramString1 + "&lon=" + paramString2 + "&title=" + paramString4 + "&loc=" + paramString5 + "&dpid=" + paramString6;
      paramString3 = new awui(StructMsgForGeneralShare.class).c(32).a(paramString3).d("").a("plugin", "", paramString6, "", "").a();
      paramString6 = awuv.a(2);
      paramString6.a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramString4, paramString5);
      paramString3.addItem(paramString6);
      if ((paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_Int != 1008) || (!(paramContext instanceof FragmentActivity))) {
        break label521;
      }
      paramContext = ((FragmentActivity)paramContext).getChatFragment();
      if (paramContext == null) {
        break label521;
      }
      paramContext = paramContext.a();
      if ((paramContext == null) || (paramContext.a == null) || (!(paramContext instanceof aegy))) {
        break label521;
      }
    }
    label521:
    for (boolean bool = ((aegy)paramContext).as;; bool = false)
    {
      if ((paramSessionInfo != null) && ((paramSessionInfo.jdField_a_of_type_Int == 1025) || (paramSessionInfo.jdField_a_of_type_Int == 1024) || ((paramSessionInfo.jdField_a_of_type_Int == 0) && (mnz.b(paramSessionInfo.jdField_a_of_type_JavaLangString))) || (bool)))
      {
        paramContext = awbi.a(-1000);
        l = awao.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        paramString1 = aaek.f + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString5 + ")";
        paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramString1, l, -1000, i, l);
        paramContext.issend = 1;
        paramQQAppInterface.a().a(paramContext, null);
      }
      while (paramSessionInfo == null)
      {
        long l;
        int i;
        return;
        paramString3 = paramContext.getResources().getString(2131625719);
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
        alfo.a().a(paramChatMessage.uniseq);
      }
      if (((StructLongMessageDownloadProcessor.b(paramChatMessage)) || (StructLongMessageDownloadProcessor.d(paramChatMessage))) && ((paramChatMessage instanceof MessageForStructing))) {
        StructLongMessageDownloadProcessor.a(paramQQAppInterface, ((MessageForStructing)paramChatMessage).uniseq);
      }
      if ((paramChatMessage instanceof MessageForApollo))
      {
        MessageForApollo localMessageForApollo = (MessageForApollo)paramChatMessage;
        if (localMessageForApollo != null)
        {
          aisc.a(localMessageForApollo.uniseq, paramQQAppInterface, "del_msg");
          if ((localMessageForApollo.mApolloMessage != null) && ((paramContext instanceof FragmentActivity)))
          {
            paramContext = ((FragmentActivity)paramContext).getChatFragment().a();
            if ((paramContext != null) && (paramContext.a != null)) {
              bajr.a(paramQQAppInterface, "cmshow", "Apollo", "del_success", ApolloUtil.b(paramContext.a.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
            }
          }
        }
      }
      if ((paramChatMessage instanceof MessageForFile))
      {
        paramContext = apck.a(paramQQAppInterface, (MessageForFile)paramChatMessage);
        paramQQAppInterface.a().b(paramContext.nSessionId);
        awqx.b(paramQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
      }
      if ((paramChatMessage instanceof MessageForLightVideo)) {
        aqut.a(paramQQAppInterface, paramChatMessage);
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
      ((baov)paramQQAppInterface.getManager(235)).a.a(paramChatMessage);
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
  
  public static void a(bakh parambakh, Context paramContext, int paramInt)
  {
    if ((!AppSetting.i) && (paramInt == 0)) {}
    while (akbm.a(paramInt) == 1032) {
      return;
    }
    parambakh.a(2131299417, paramContext.getString(2131625147), 2130838594);
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
      if ((paramBaseChatPie instanceof aedo)) {}
      for (paramBaseChatPie = (aedo)paramBaseChatPie;; paramBaseChatPie = null)
      {
        if (paramBaseChatPie == null) {
          break label395;
        }
        batf localbatf = batf.a();
        i = paramSessionInfo.jdField_a_of_type_Int;
        boolean bool1 = localbatf.a(paramQQAppInterface);
        boolean bool2 = localbatf.b(paramQQAppInterface);
        boolean bool3 = localbatf.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
        if ((i != 0) || (!bool1) || (!bool2) || (!bool3)) {
          break;
        }
        Object localObject = paramQQAppInterface.getApp().getSharedPreferences(batf.jdField_a_of_type_JavaLangString, 0);
        if (!paramBoolean)
        {
          long l1 = localbatf.a(paramQQAppInterface);
          long l2 = ((SharedPreferences)localObject).getLong(batf.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, 0L);
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 > l1)) {
            break label271;
          }
        }
        label271:
        ajut localajut;
        do
        {
          localObject = localbatf.a(paramQQAppInterface);
          if ((!localbatf.c(paramQQAppInterface)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!paramBaseChatPie.T)) {
            break;
          }
          localbatf.a(paramQQAppInterface, 0);
          akbm.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4022);
          paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4022, (String)localObject);
          return;
          localajut = (ajut)paramQQAppInterface.a(86);
        } while (localajut == null);
        paramBaseChatPie = new AIOSendReq();
        paramBaseChatPie.iSend = 0;
        paramBaseChatPie.sAid = "";
        paramBaseChatPie.sUin = paramQQAppInterface.getCurrentAccountUin();
        paramBaseChatPie.sFriendUin = paramSessionInfo.jdField_a_of_type_JavaLangString;
        localajut.a(paramBaseChatPie);
        paramBaseChatPie = ((SharedPreferences)localObject).edit();
        paramBaseChatPie.putLong(batf.jdField_b_of_type_JavaLangString + paramSessionInfo.jdField_a_of_type_JavaLangString, System.currentTimeMillis());
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
    awqx.b(paramQQAppInterface, "dc00898", "", "", "0X800A2CE", "0X800A2CE", 0, 0, ChatActivityUtils.b(paramSessionInfo.jdField_a_of_type_Int), "", "", "");
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
        ((ProfileActivity.AllInOne)localObject).a = xbq.a(paramSessionInfo);
        ((ProfileActivity.AllInOne)localObject).f = paramSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
        if ((paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1020)) {
          ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = paramSessionInfo.jdField_b_of_type_JavaLangString;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_g_of_type_Int = 2;
        if (paramSessionInfo.jdField_a_of_type_Int != 0) {
          break label885;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 1;
        if ((paramSessionInfo.jdField_a_of_type_Int != 1001) && (paramSessionInfo.jdField_a_of_type_Int != 1010) && (paramSessionInfo.jdField_a_of_type_Int != 10002)) {
          break label952;
        }
        localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
        if (paramSessionInfo.jdField_a_of_type_Int != 1001) {
          break label895;
        }
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 10;
        localIntent.putExtra("frome_where", 21);
        label242:
        ((ProfileActivity.AllInOne)localObject).a = xbq.a(paramSessionInfo);
        localIntent.putExtra("AllInOne", (Parcelable)localObject);
        if (!azzz.a(paramQQAppInterface.getCurrentAccountUin(), str)) {
          break label939;
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
        mqb.a(paramActivity, null, paramSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
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
      if ((paramSessionInfo.jdField_a_of_type_Int == 1037) || (paramSessionInfo.jdField_a_of_type_Int == 1044))
      {
        localObject = new ProfileActivity.AllInOne(str, 96);
        i = 0;
        break;
      }
      localObject = new ProfileActivity.AllInOne(str, 19);
      i = 0;
      break;
      label885:
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 106;
      break label171;
      label895:
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
      label939:
      localIntent.putExtra("param_mode", 3);
    }
    label952:
    if (aqux.a(paramSessionInfo))
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
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (awuc.a(paramString2) >= 1))
    {
      awuc.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new axvt();
    paramBundle.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    paramBundle.jdField_c_of_type_JavaLangString = paramString1;
    paramBundle.jdField_a_of_type_Int = paramInt1;
    paramBundle.jdField_b_of_type_Int = 2;
    paramBundle.jdField_a_of_type_Long = paramLong1;
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.i = paramString2;
    paramBundle.jdField_e_of_type_Int = 1002;
    paramBundle.l = paramBoolean3;
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
    if ((!paramBoolean2) && (!a(paramQQAppInterface, paramString1, paramInt1, paramLong1)) && (!paramBoolean1) && (awuc.a(paramString2) >= 1))
    {
      awuc.a(paramString2, paramQQAppInterface, paramString1, paramLong1, paramInt2, paramInt3, paramLong2, paramBundle);
      return;
    }
    paramBundle = new axvt();
    paramBundle.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    paramBundle.jdField_c_of_type_JavaLangString = paramString1;
    paramBundle.jdField_a_of_type_Int = paramInt1;
    paramBundle.jdField_b_of_type_Int = 2;
    paramBundle.jdField_a_of_type_Long = paramLong1;
    paramBundle.jdField_a_of_type_Boolean = true;
    paramBundle.i = paramString2;
    paramBundle.jdField_e_of_type_Int = 1002;
    paramBundle.l = paramBoolean3;
    paramBundle.n = paramInt5;
    if (paramMessageRecord != null)
    {
      paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if ((paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean4) && (paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
      {
        paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.atInfoList = paramArrayList;
        paramBundle.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mRobotFlag = 1;
        new awrb(paramQQAppInterface).a("dc00899").b("Grp_robot").c("send_msg").d("voice_msg_suc").a(new String[] { paramString1, String.valueOf(((MessageForText.AtTroopMemberInfo)paramArrayList.get(0)).uin) }).a();
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
    if (!ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo)) {}
    label8:
    int i;
    do
    {
      break label8;
      do
      {
        return;
      } while (1024 == paramSessionInfo.jdField_a_of_type_Int);
      i = ((ajfi)paramQQAppInterface.a(2)).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.jdField_a_of_type_JavaLangString + " settingValue:" + i);
      }
    } while ((i != 0) || (ChatActivityUtils.a(paramContext, paramSessionInfo, "single_way_friend_add_allow_list")));
    Iterator localIterator = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, 0).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((MessageRecord)localIterator.next()).msgtype != -7006);
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityFacade", 4, "single way add allow insert " + paramSessionInfo.jdField_a_of_type_JavaLangString + " hasInserted:" + bool);
      }
      if (bool) {
        break;
      }
      ChatActivityUtils.b(paramContext, paramSessionInfo, "single_way_friend_add_allow_list");
      paramContext = awbi.a(-7006);
      long l = awao.a() + 1L;
      paramContext.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, "", l, -7006, paramSessionInfo.jdField_a_of_type_Int, l);
      paramContext.isread = true;
      if (ajml.a(paramQQAppInterface, paramContext, false)) {
        break;
      }
      paramQQAppInterface.a().a(paramContext, paramContext.selfuin);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, String paramString)
  {
    paramContext = new MessageForPokeEmo();
    paramContext.msgtype = -5018;
    paramContext.isNeedPlayed = false;
    paramContext.pokeemoId = paramInt1;
    paramContext.pokeemoPressCount = paramInt2;
    paramContext.summary = aekq.a(paramInt1);
    paramContext.initMsg();
    awbi.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
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
    if (!adll.a(paramQQAppInterface, paramSessionInfo))
    {
      if (jdField_a_of_type_Bbmy == null)
      {
        jdField_a_of_type_Bbmy = bbmy.a(paramContext, 2131624431, 0);
        adlh.a().a(3);
        adlh.a().a(6);
        adlh.a().a(12);
        adlh.a().a(15);
        adlh.a().a(18);
        adlh.a().a(9);
      }
      if (!jdField_a_of_type_Bbmy.c()) {
        jdField_a_of_type_Bbmy.a();
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
    paramContext.strength = adlh.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramContext.interactType, paramInt3, -1);
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
      awbi.a(paramQQAppInterface, paramContext, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
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
    paramContext = awbi.a(paramContext);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ajbx paramajbx)
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
    //   15: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   18: ifnull +39 -> 57
    //   21: aload_3
    //   22: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   25: getfield 2118	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   28: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +26 -> 57
    //   34: aload_3
    //   35: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   38: getfield 2121	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   41: ifle +17 -> 58
    //   44: aload_3
    //   45: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   48: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   51: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +4 -> 58
    //   57: return
    //   58: aload_0
    //   59: bipush 51
    //   61: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   64: checkcast 456	ajjj
    //   67: astore 8
    //   69: aload_0
    //   70: sipush 153
    //   73: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   76: checkcast 2126	aifg
    //   79: astore 11
    //   81: aload_0
    //   82: bipush 71
    //   84: invokevirtual 607	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lajfb;
    //   87: checkcast 2128	baot
    //   90: astore_1
    //   91: aload_2
    //   92: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   95: iconst_1
    //   96: if_icmpne +60 -> 156
    //   99: aload_3
    //   100: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   103: getfield 2121	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   106: ifle +50 -> 156
    //   109: aload_3
    //   110: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   113: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   116: aload_0
    //   117: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   120: invokevirtual 1384	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +33 -> 156
    //   126: aload 11
    //   128: aload_3
    //   129: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   132: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   135: invokevirtual 2131	aifg:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   138: astore 9
    //   140: aload 9
    //   142: ifnonnull +778 -> 920
    //   145: aload_1
    //   146: aload_3
    //   147: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   150: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   153: invokevirtual 2133	baot:b	(Ljava/lang/String;)V
    //   156: aload_3
    //   157: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   160: getfield 2136	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   163: invokestatic 2139	com/tencent/mobileqq/data/ApolloActionData:isAction3DModel	(I)Z
    //   166: istore 7
    //   168: ldc_w 567
    //   171: iconst_1
    //   172: iconst_4
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: ldc_w 2141
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_3
    //   185: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   188: getfield 2136	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   191: invokestatic 981	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: ldc_w 2143
    //   200: aastore
    //   201: dup
    //   202: iconst_3
    //   203: iload 7
    //   205: invokestatic 2148	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   208: aastore
    //   209: invokestatic 2151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   212: new 1521	com/tencent/mobileqq/data/ApolloMessage
    //   215: dup
    //   216: invokespecial 2152	com/tencent/mobileqq/data/ApolloMessage:<init>	()V
    //   219: astore 10
    //   221: iload 7
    //   223: ifeq +900 -> 1123
    //   226: sipush 1024
    //   229: istore 5
    //   231: iload 5
    //   233: istore 4
    //   235: aload_3
    //   236: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   239: getfield 2121	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   242: ifle +817 -> 1059
    //   245: iload 5
    //   247: istore 4
    //   249: aload 10
    //   251: sipush 1454
    //   254: putfield 1523	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   257: iload 5
    //   259: istore 4
    //   261: new 2154	com/tencent/mobileqq/data/Apollo3DMessage
    //   264: dup
    //   265: invokespecial 2155	com/tencent/mobileqq/data/Apollo3DMessage:<init>	()V
    //   268: astore 8
    //   270: aload 8
    //   272: aload_3
    //   273: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   276: getfield 2136	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   279: putfield 2158	com/tencent/mobileqq/data/Apollo3DMessage:actionID_3D	I
    //   282: aload 8
    //   284: aload_3
    //   285: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   288: getfield 2161	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   291: putfield 2164	com/tencent/mobileqq/data/Apollo3DMessage:actionType_3D	I
    //   294: aload 8
    //   296: aload_3
    //   297: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   300: getfield 2118	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   303: putfield 2167	com/tencent/mobileqq/data/Apollo3DMessage:actionName_3D	Ljava/lang/String;
    //   306: aload_0
    //   307: sipush 155
    //   310: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   313: checkcast 2169	aiyu
    //   316: aload 10
    //   318: getfield 1523	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   321: invokevirtual 2172	aiyu:a	(I)Lcom/tencent/mobileqq/data/ApolloActionData;
    //   324: astore_1
    //   325: aload_1
    //   326: ifnull +774 -> 1100
    //   329: aload_1
    //   330: getfield 2118	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   333: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifne +764 -> 1100
    //   339: aload 10
    //   341: aload_1
    //   342: getfield 2118	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   345: ldc_w 1376
    //   348: invokevirtual 64	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   351: putfield 2175	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   354: aload_3
    //   355: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   358: getfield 2178	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   361: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   388: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   391: getfield 2178	com/tencent/mobileqq/data/ApolloActionData:atNickName	Ljava/lang/String;
    //   394: invokevirtual 2180	java/lang/String:getBytes	()[B
    //   397: putfield 2183	com/tencent/mobileqq/data/ApolloMessage:text	[B
    //   400: aload 11
    //   402: aload_0
    //   403: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   406: invokevirtual 2131	aifg:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   409: astore 9
    //   411: aload 10
    //   413: aload 9
    //   415: getfield 2188	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   418: invokestatic 2190	azzz:a	(J)I
    //   421: i2l
    //   422: putfield 2193	com/tencent/mobileqq/data/ApolloMessage:sender_ts	J
    //   425: aload 10
    //   427: aload 9
    //   429: getfield 2196	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   432: putfield 2199	com/tencent/mobileqq/data/ApolloMessage:sender_status	I
    //   435: iload 7
    //   437: ifeq +18 -> 455
    //   440: aload 8
    //   442: ifnull +13 -> 455
    //   445: aload 8
    //   447: aload 9
    //   449: getfield 2202	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   452: putfield 2205	com/tencent/mobileqq/data/Apollo3DMessage:senderStatus_3D	I
    //   455: iload 5
    //   457: iconst_1
    //   458: ior
    //   459: bipush 8
    //   461: ior
    //   462: bipush 32
    //   464: ior
    //   465: istore 4
    //   467: aload_3
    //   468: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   471: getfield 2121	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   474: ifle +816 -> 1290
    //   477: aload 10
    //   479: aload_3
    //   480: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   483: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   486: invokestatic 2208	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   489: invokevirtual 2211	java/lang/Long:longValue	()J
    //   492: putfield 2214	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   495: aload 11
    //   497: aload_3
    //   498: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   501: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   504: invokevirtual 2131	aifg:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   507: astore 9
    //   509: aload 10
    //   511: aload 9
    //   513: getfield 2188	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   516: invokestatic 2190	azzz:a	(J)I
    //   519: i2l
    //   520: putfield 2217	com/tencent/mobileqq/data/ApolloMessage:peer_ts	J
    //   523: aload 10
    //   525: aload 9
    //   527: getfield 2196	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   530: putfield 2220	com/tencent/mobileqq/data/ApolloMessage:peer_status	I
    //   533: iload 7
    //   535: ifeq +18 -> 553
    //   538: aload 8
    //   540: ifnull +13 -> 553
    //   543: aload 8
    //   545: aload 9
    //   547: getfield 2202	com/tencent/mobileqq/data/ApolloBaseInfo:cmshow3dFlag	I
    //   550: putfield 2223	com/tencent/mobileqq/data/Apollo3DMessage:peerStatus_3D	I
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
    //   585: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   588: getfield 2121	com/tencent/mobileqq/data/ApolloActionData:personNum	I
    //   591: ifne +28 -> 619
    //   594: aload_2
    //   595: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   598: ifne +21 -> 619
    //   601: aload 10
    //   603: aload_3
    //   604: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   607: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   610: invokestatic 2208	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   613: invokevirtual 2211	java/lang/Long:longValue	()J
    //   616: putfield 2214	com/tencent/mobileqq/data/ApolloMessage:peer_uin	J
    //   619: iload 4
    //   621: istore 5
    //   623: aload_3
    //   624: getfield 2224	ajbx:jdField_d_of_type_Int	I
    //   627: iconst_1
    //   628: if_icmpne +11 -> 639
    //   631: iload 4
    //   633: sipush 128
    //   636: ior
    //   637: istore 5
    //   639: aload 10
    //   641: iload 5
    //   643: putfield 2225	com/tencent/mobileqq/data/ApolloMessage:flag	I
    //   646: new 646	java/util/ArrayList
    //   649: dup
    //   650: invokespecial 647	java/util/ArrayList:<init>	()V
    //   653: pop
    //   654: iconst_0
    //   655: ifne +629 -> 1284
    //   658: new 1156	org/json/JSONObject
    //   661: dup
    //   662: invokespecial 1157	org/json/JSONObject:<init>	()V
    //   665: astore 9
    //   667: iload 7
    //   669: ifeq +500 -> 1169
    //   672: aload 8
    //   674: ifnull +495 -> 1169
    //   677: aload_1
    //   678: ifnull +491 -> 1169
    //   681: aload 9
    //   683: ldc_w 2226
    //   686: aload_1
    //   687: getfield 2161	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   690: invokevirtual 1284	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   693: pop
    //   694: aload_3
    //   695: getfield 2227	ajbx:jdField_e_of_type_Int	I
    //   698: ifle +30 -> 728
    //   701: aload 9
    //   703: ldc_w 2229
    //   706: aload_3
    //   707: getfield 2227	ajbx:jdField_e_of_type_Int	I
    //   710: invokevirtual 1284	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   713: pop
    //   714: aload 9
    //   716: ldc_w 2231
    //   719: aload_3
    //   720: getfield 2233	ajbx:jdField_a_of_type_Float	F
    //   723: f2d
    //   724: invokevirtual 2236	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload_3
    //   729: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   732: getfield 2239	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   735: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   738: ifne +463 -> 1201
    //   741: aload 9
    //   743: ldc_w 2240
    //   746: aload_3
    //   747: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   750: getfield 2239	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   753: invokevirtual 1163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload 8
    //   759: ifnull +23 -> 782
    //   762: aload 8
    //   764: invokevirtual 2244	com/tencent/mobileqq/data/Apollo3DMessage:getMessageJSONObject	()Lorg/json/JSONObject;
    //   767: astore_1
    //   768: aload_1
    //   769: ifnull +13 -> 782
    //   772: aload 9
    //   774: ldc_w 2246
    //   777: aload_1
    //   778: invokevirtual 1163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   781: pop
    //   782: aload 9
    //   784: ifnull +13 -> 797
    //   787: aload 10
    //   789: aload 9
    //   791: invokevirtual 1178	org/json/JSONObject:toString	()Ljava/lang/String;
    //   794: putfield 2249	com/tencent/mobileqq/data/ApolloMessage:extStr	Ljava/lang/String;
    //   797: aload_0
    //   798: aload_2
    //   799: getfield 86	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   802: aload_2
    //   803: getfield 235	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   806: aload_2
    //   807: getfield 51	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   810: aload 10
    //   812: invokestatic 2252	awbi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ApolloMessage;)Lcom/tencent/mobileqq/data/MessageForApollo;
    //   815: astore_1
    //   816: aload_1
    //   817: aload_3
    //   818: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   821: getfield 2239	com/tencent/mobileqq/data/ApolloActionData:inputText	Ljava/lang/String;
    //   824: putfield 2253	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   827: aload_1
    //   828: aload_3
    //   829: getfield 2227	ajbx:jdField_e_of_type_Int	I
    //   832: putfield 2256	com/tencent/mobileqq/data/MessageForApollo:audioId	I
    //   835: aload_1
    //   836: aload_3
    //   837: getfield 2233	ajbx:jdField_a_of_type_Float	F
    //   840: putfield 2258	com/tencent/mobileqq/data/MessageForApollo:audioStartTime	F
    //   843: aload_1
    //   844: aload_3
    //   845: getfield 2260	ajbx:f	I
    //   848: putfield 2263	com/tencent/mobileqq/data/MessageForApollo:isPlayDefaultAudio	I
    //   851: aload_1
    //   852: aload_3
    //   853: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   856: getfield 2161	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   859: putfield 2264	com/tencent/mobileqq/data/MessageForApollo:actionType	I
    //   862: aload_1
    //   863: aload 8
    //   865: putfield 2267	com/tencent/mobileqq/data/MessageForApollo:mApollo3DMessage	Lcom/tencent/mobileqq/data/Apollo3DMessage;
    //   868: aload_1
    //   869: getfield 2253	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   872: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   875: ifeq +11 -> 886
    //   878: aload_1
    //   879: aload_3
    //   880: getfield 2268	ajbx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   883: putfield 2253	com/tencent/mobileqq/data/MessageForApollo:inputText	Ljava/lang/String;
    //   886: aload_0
    //   887: invokestatic 2273	aisl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laisi;
    //   890: astore_2
    //   891: aload_3
    //   892: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   895: getfield 2161	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   898: ifeq +329 -> 1227
    //   901: aload_2
    //   902: ifnull +325 -> 1227
    //   905: aload_2
    //   906: invokevirtual 2278	aisi:a	()Laisa;
    //   909: astore_0
    //   910: aload_0
    //   911: ifnull -854 -> 57
    //   914: aload_0
    //   915: aload_1
    //   916: invokevirtual 2283	aisa:a	(Lcom/tencent/mobileqq/data/MessageForApollo;)V
    //   919: return
    //   920: aload 8
    //   922: aload_3
    //   923: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   926: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   929: invokevirtual 2284	ajjj:b	(Ljava/lang/String;)Z
    //   932: ifne +33 -> 965
    //   935: invokestatic 2289	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   938: aload 9
    //   940: getfield 2292	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   943: lsub
    //   944: ldc2_w 2293
    //   947: lcmp
    //   948: iflt +17 -> 965
    //   951: aload_1
    //   952: aload_3
    //   953: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   956: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   959: invokevirtual 2133	baot:b	(Ljava/lang/String;)V
    //   962: goto -806 -> 156
    //   965: aload 8
    //   967: aload_3
    //   968: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   971: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   974: invokevirtual 2284	ajjj:b	(Ljava/lang/String;)Z
    //   977: ifeq +27 -> 1004
    //   980: aload 9
    //   982: getfield 2292	com/tencent/mobileqq/data/ApolloBaseInfo:apolloUpdateTime	J
    //   985: lconst_0
    //   986: lcmp
    //   987: ifne +17 -> 1004
    //   990: aload_1
    //   991: aload_3
    //   992: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   995: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   998: invokevirtual 2133	baot:b	(Ljava/lang/String;)V
    //   1001: goto -845 -> 156
    //   1004: aload 9
    //   1006: getfield 2188	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   1009: aload 9
    //   1011: getfield 2297	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   1014: lcmp
    //   1015: ifeq -859 -> 156
    //   1018: new 646	java/util/ArrayList
    //   1021: dup
    //   1022: iconst_1
    //   1023: invokespecial 2298	java/util/ArrayList:<init>	(I)V
    //   1026: astore 8
    //   1028: aload 8
    //   1030: aload_3
    //   1031: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1034: getfield 2124	com/tencent/mobileqq/data/ApolloActionData:peerUin	Ljava/lang/String;
    //   1037: invokestatic 1593	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1040: invokestatic 2301	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1043: invokevirtual 1212	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1046: pop
    //   1047: aload_1
    //   1048: aload 8
    //   1050: ldc_w 2303
    //   1053: invokevirtual 2306	baot:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   1056: goto -900 -> 156
    //   1059: iload 5
    //   1061: istore 4
    //   1063: aload 10
    //   1065: sipush 1450
    //   1068: putfield 1523	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1071: goto -814 -> 257
    //   1074: astore 9
    //   1076: aconst_null
    //   1077: astore 8
    //   1079: aconst_null
    //   1080: astore_1
    //   1081: ldc_w 567
    //   1084: iconst_1
    //   1085: ldc_w 2308
    //   1088: aload 9
    //   1090: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1093: iload 4
    //   1095: istore 5
    //   1097: goto -743 -> 354
    //   1100: aload 10
    //   1102: ldc_w 2310
    //   1105: invokevirtual 2180	java/lang/String:getBytes	()[B
    //   1108: putfield 2175	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1111: goto -757 -> 354
    //   1114: astore 9
    //   1116: iload 5
    //   1118: istore 4
    //   1120: goto -39 -> 1081
    //   1123: iload 6
    //   1125: istore 4
    //   1127: aload 10
    //   1129: aload_3
    //   1130: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1133: getfield 2136	com/tencent/mobileqq/data/ApolloActionData:actionId	I
    //   1136: putfield 1523	com/tencent/mobileqq/data/ApolloMessage:id	I
    //   1139: iload 6
    //   1141: istore 4
    //   1143: aload 10
    //   1145: aload_3
    //   1146: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1149: getfield 2118	com/tencent/mobileqq/data/ApolloActionData:actionName	Ljava/lang/String;
    //   1152: ldc_w 1376
    //   1155: invokevirtual 64	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1158: putfield 2175	com/tencent/mobileqq/data/ApolloMessage:name	[B
    //   1161: aconst_null
    //   1162: astore_1
    //   1163: aconst_null
    //   1164: astore 8
    //   1166: goto -812 -> 354
    //   1169: aload 9
    //   1171: ldc_w 2226
    //   1174: aload_3
    //   1175: getfield 2113	ajbx:jdField_a_of_type_ComTencentMobileqqDataApolloActionData	Lcom/tencent/mobileqq/data/ApolloActionData;
    //   1178: getfield 2161	com/tencent/mobileqq/data/ApolloActionData:actionType	I
    //   1181: invokevirtual 1284	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1184: pop
    //   1185: goto -491 -> 694
    //   1188: astore_0
    //   1189: ldc_w 567
    //   1192: iconst_1
    //   1193: ldc_w 2312
    //   1196: aload_0
    //   1197: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1200: return
    //   1201: aload_3
    //   1202: getfield 2268	ajbx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1205: invokestatic 364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1208: ifne -451 -> 757
    //   1211: aload 9
    //   1213: ldc_w 2240
    //   1216: aload_3
    //   1217: getfield 2268	ajbx:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1220: invokevirtual 1163	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1223: pop
    //   1224: goto -467 -> 757
    //   1227: aload_0
    //   1228: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1231: aload_1
    //   1232: aconst_null
    //   1233: invokevirtual 575	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lajmm;)V
    //   1236: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1239: ifeq -1182 -> 57
    //   1242: ldc_w 567
    //   1245: iconst_2
    //   1246: new 174	java/lang/StringBuilder
    //   1249: dup
    //   1250: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1253: ldc_w 2314
    //   1256: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: aload_3
    //   1260: invokevirtual 2315	ajbx:toString	()Ljava/lang/String;
    //   1263: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: return
    //   1273: astore 9
    //   1275: aconst_null
    //   1276: astore_1
    //   1277: iload 5
    //   1279: istore 4
    //   1281: goto -200 -> 1081
    //   1284: aconst_null
    //   1285: astore 9
    //   1287: goto -620 -> 667
    //   1290: goto -706 -> 584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1293	0	paramQQAppInterface	QQAppInterface
    //   0	1293	1	paramContext	Context
    //   0	1293	2	paramSessionInfo	SessionInfo
    //   0	1293	3	paramajbx	ajbx
    //   233	1047	4	i	int
    //   4	1274	5	j	int
    //   1	1139	6	k	int
    //   166	502	7	bool	boolean
    //   67	1098	8	localObject1	Object
    //   138	872	9	localObject2	Object
    //   1074	15	9	localException1	Exception
    //   1114	98	9	localException2	Exception
    //   1273	1	9	localException3	Exception
    //   1285	1	9	localObject3	Object
    //   219	925	10	localApolloMessage	ApolloMessage
    //   79	417	11	localaifg	aifg
    // Exception table:
    //   from	to	target	type
    //   235	245	1074	java/lang/Exception
    //   249	257	1074	java/lang/Exception
    //   261	270	1074	java/lang/Exception
    //   1063	1071	1074	java/lang/Exception
    //   1127	1139	1074	java/lang/Exception
    //   1143	1161	1074	java/lang/Exception
    //   329	354	1114	java/lang/Exception
    //   1100	1111	1114	java/lang/Exception
    //   658	667	1188	java/lang/Throwable
    //   681	694	1188	java/lang/Throwable
    //   694	728	1188	java/lang/Throwable
    //   728	757	1188	java/lang/Throwable
    //   762	768	1188	java/lang/Throwable
    //   772	782	1188	java/lang/Throwable
    //   1169	1185	1188	java/lang/Throwable
    //   1201	1224	1188	java/lang/Throwable
    //   270	325	1273	java/lang/Exception
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
      label1223:
      for (;;)
      {
        return;
        if ((paramForwardFileInfo != null) && (paramForwardFileInfo.b() == 10006) && (TextUtils.isEmpty(paramForwardFileInfo.a())))
        {
          a(paramQQAppInterface, paramContext, paramSessionInfo, paramIntent, paramString, paramForwardFileInfo, paramInt);
          return;
        }
        if (paramIntent.getBooleanExtra("isFromShare", false))
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
          paramString = paramQQAppInterface.a().b(paramForwardFileInfo.b());
          if ((paramString == null) && (QLog.isColorLevel())) {
            QLog.e("ChatActivityFacade", 2, "there has a Bug!,sissionId[" + paramForwardFileInfo.b() + "]");
          }
          switch (paramForwardFileInfo.b())
          {
          }
          for (;;)
          {
            if ((paramBoolean) || (!paramIntent.getBooleanExtra("not_forward", false))) {
              break label1223;
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
              if (paramString != null)
              {
                paramQQAppInterface.lastSuccessTime = paramString.lastSuccessTime;
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
                    if (apdh.b(paramForwardFileInfo.a()))
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
                      apck.a(paramContext.getResources().getString(2131627218));
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
                    paramQQAppInterface.a().b(paramContext, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
                    continue;
                    if (paramSessionInfo.jdField_a_of_type_Int == 1)
                    {
                      if (apdh.b(paramForwardFileInfo.a()))
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
                    else {
                      paramQQAppInterface.a().a(paramForwardFileInfo.b(), paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, true, i);
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
      Toast.makeText(paramContext, paramContext.getString(2131626670), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      bapm.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, badq.b(paramContext) + "", "", "", "", "");
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
      paramContext = awbi.a(paramContext);
      paramQQAppInterface.a().a(paramContext, null, true);
      paramQQAppInterface = (arnz)paramQQAppInterface.getManager(14);
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
      Toast.makeText(paramContext, paramContext.getString(2131626670), 0).show();
      a(paramQQAppInterface, paramEmoticon);
      bapm.a("emotionType", "emotionActionSend", "2", paramEmoticon.epId, paramEmoticon.eId, badq.b(paramContext) + "", "", "", "", "");
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
    aaes localaaes = new aaes();
    localaaes.jdField_a_of_type_Boolean = false;
    localaaes.jdField_b_of_type_Boolean = true;
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, localaaes);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_bank", 4, "AIO---sendShowLoveMessage");
    }
    awqx.b(paramQQAppInterface, "CliOper", "", "", "0X80052A5", "0X80052A5", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    bacm.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendIMEEXpression");
    if (!bace.b(paramString))
    {
      ChatActivityUtils.a(paramContext, 2131629504, 0);
      bacm.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepared_failed", "ChatActivity.sendIMEEXpression");
      return;
    }
    paramContext = new atqe();
    paramContext.a(paramString);
    paramContext.d(paramInt);
    paramContext.d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.c(axvn.jdField_d_of_type_Int);
    paramContext.e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    paramContext.c(paramQQAppInterface.getCurrentAccountUin());
    paramContext.e(paramSessionInfo.jdField_a_of_type_Int);
    paramContext.l(paramSessionInfo.jdField_e_of_type_Int);
    atpv localatpv = atpl.a(2, paramInt);
    localatpv.a(paramContext.a());
    atpl.a(localatpv, paramQQAppInterface);
    ThreadManager.post(new ChatActivityFacade.11(paramString, paramSessionInfo, paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, int paramInt, long paramLong)
  {
    if (!badq.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131626719, 0);
      return;
    }
    paramSessionInfo = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if (paramSessionInfo == null)
    {
      ChatActivityUtils.a(paramContext, 2131653422, 0);
      return;
    }
    ThreadManager.post(new ChatActivityFacade.23(paramSessionInfo, paramQQAppInterface, paramString, paramInt, paramLong), 10, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, long paramLong)
  {
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) && (((azjh)paramQQAppInterface.getManager(48)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean) && ((paramContext instanceof BaseActivity)))
    {
      paramContext = (BaseActivity)paramContext;
      bbmy.a(paramQQAppInterface.getApp(), 2131631942, 0).b(paramContext.getTitleBarHeight());
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
    if (bace.b(paramString1)) {
      bacg.a(paramQQAppInterface, paramString1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString, false, paramContext, paramInt2);
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
      } while ((paramContext == null) || (!(paramContext instanceof axou)));
      paramContext = (axou)paramContext;
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
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, paramArrayList, new aaes());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean, String paramString2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, false, false, paramBoolean, null, null, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString1, paramBoolean1, paramBoolean2, false, paramString2, paramStickerInfo, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, EmojiStickerManager.StickerInfo paramStickerInfo, String paramString3)
  {
    if (paramString1 == null)
    {
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion url == null");
      if (paramBoolean1) {
        bapm.a("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
      return;
    }
    bacm.a(-1L, paramSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!bace.b(paramString1))
    {
      ChatActivityUtils.a(paramContext, 2131629504, 0);
      if (paramBoolean1) {
        bapm.a("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
      }
      QLog.e("ChatActivityFacade", 1, "sendCustomEmotion file not exist or problme: URL = " + paramString1);
      return;
    }
    Object localObject = new atqe();
    ((atqe)localObject).a(paramString1);
    ((atqe)localObject).d(1006);
    ((atqe)localObject).d(paramSessionInfo.jdField_a_of_type_JavaLangString);
    ((atqe)localObject).c(axvn.jdField_d_of_type_Int);
    ((atqe)localObject).e(paramSessionInfo.jdField_b_of_type_JavaLangString);
    ((atqe)localObject).c(paramQQAppInterface.getCurrentAccountUin());
    ((atqe)localObject).e(paramSessionInfo.jdField_a_of_type_Int);
    ((atqe)localObject).l(paramSessionInfo.jdField_e_of_type_Int);
    atpv localatpv = atpl.a(2, 1006);
    localatpv.a(((atqe)localObject).a());
    localObject = new PicMessageExtraData();
    if (paramBoolean3)
    {
      ((PicMessageExtraData)localObject).imageBizType = 8;
      if (TextUtils.isEmpty(paramString3)) {
        break label391;
      }
      ((PicMessageExtraData)localObject).textSummary = ("[" + paramString3 + "]");
    }
    for (;;)
    {
      localatpv.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = ((PicMessageExtraData)localObject);
      atpl.a(localatpv, paramQQAppInterface);
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
        label344:
        ((PicMessageExtraData)localObject).customFaceType = i;
        if (!paramBoolean2) {
          break label384;
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
        break label344;
        label384:
        paramString2 = "";
      }
      label391:
      if (paramBoolean3) {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131625714);
      } else {
        ((PicMessageExtraData)localObject).textSummary = paramContext.getResources().getString(2131625713);
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
          if ((((JSONObject)localObject2).has("uin")) && (((JSONObject)localObject2).has("type")) && (((JSONObject)localObject2).getString("uin").equals(akbm.a(str))))
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
    long l2;
    Object localObject1;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq;
    label196:
    do
    {
      do
      {
        try
        {
          l1 = Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue();
          l2 = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("ChatActivityFacade,uin: %s, uinType: %d, id: %d", new Object[] { paramSessionInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int), Long.valueOf(l2) }));
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
      } while ((l2 == -1L) || (l2 == paramSessionInfo.jdField_a_of_type_Long));
      paramSessionInfo.jdField_a_of_type_Long = l2;
      localObject1 = "c2c_processor";
      localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        paramSessionInfo = "troop_processor";
        localObject1 = new msg_svc.PbGroupReadedReportReq();
        ((msg_svc.PbGroupReadedReportReq)localObject1).group_code.set(l1);
        ((msg_svc.PbGroupReadedReportReq)localObject1).last_read_seq.set(l2);
        localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject1);
      }
      for (;;)
      {
        paramQQAppInterface.a().a(paramSessionInfo).a(localPbMsgReadedReportReq);
        return;
        if (paramSessionInfo.jdField_a_of_type_Int == 1026)
        {
          paramSessionInfo = "hctopic_processor";
          localObject1 = new msg_svc.PbGroupReadedReportReq();
          ((msg_svc.PbGroupReadedReportReq)localObject1).group_code.set(l1);
          ((msg_svc.PbGroupReadedReportReq)localObject1).last_read_seq.set(l2);
          localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject1);
        }
        else
        {
          if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
            break;
          }
          paramSessionInfo = "disc_processor";
          localObject1 = new msg_svc.PbDiscussReadedReportReq();
          ((msg_svc.PbDiscussReadedReportReq)localObject1).conf_uin.set(l1);
          ((msg_svc.PbDiscussReadedReportReq)localObject1).last_read_seq.set(l2);
          localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject1);
        }
      }
    } while ((!akbm.c(paramSessionInfo.jdField_a_of_type_Int)) || (l2 == 0L));
    if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
      if (paramSessionInfo.f == null) {
        break label548;
      }
    }
    label548:
    for (long l1 = Long.valueOf(paramSessionInfo.f).longValue(); l1 != -1L; l1 = -1L)
    {
      Object localObject2 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).peer_uin.set(l1);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).last_read_time.set((int)l2);
      if (paramSessionInfo.jdField_a_of_type_Int == 1024)
      {
        paramSessionInfo = paramQQAppInterface.a().d(paramSessionInfo.jdField_a_of_type_JavaLangString);
        if (paramSessionInfo != null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + bach.a(paramSessionInfo) + ",length:" + paramSessionInfo.length);
          }
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject2).crm_sig.set(ByteStringMicro.copyFrom(paramSessionInfo));
        }
      }
      paramSessionInfo = new msg_svc.PbC2CReadedReportReq();
      paramSessionInfo.pair_info.add((MessageMicro)localObject2);
      localObject2 = paramQQAppInterface.a().a().a();
      if (localObject2 != null) {
        paramSessionInfo.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localPbMsgReadedReportReq.c2c_read_report.set(paramSessionInfo);
      paramSessionInfo = (SessionInfo)localObject1;
      break label196;
    }
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
      ((ajue)paramQQAppInterface.a(28)).a(i, paramSessionInfo.jdField_a_of_type_JavaLangString, l);
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
    paramSessionInfo = atpl.a(1009, (Intent)localObject);
    localObject = atpl.a(3, 1009);
    ((atpv)localObject).a(paramSessionInfo);
    ((atpv)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramMessageForPic;
    ((atpv)localObject).jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData = paramMessageForPic.picExtraData;
    paramMessageForPic.forwardId.put(localObject, Integer.valueOf(paramInt));
    atpl.a((atpv)localObject, paramQQAppInterface);
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
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.senderuin.equals(paramQQAppInterface.getAccount())))
      {
        ((Intent)localObject).putExtra("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
        ((Intent)localObject).putExtra("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        if (paramSessionInfo.jdField_a_of_type_Int != 1) {
          break label683;
        }
        j = 1;
      }
    }
    for (;;)
    {
      ahhk.a("", "0X80088E4", String.valueOf(j));
      paramSessionInfo = aweg.a(3, i);
      localObject = aweg.a(i, localObject, paramSessionInfo);
      if (localObject != null)
      {
        ((awel)localObject).jdField_a_of_type_Long = paramMessageForShortVideo.uniseq;
        ((awel)localObject).p = paramMessageForShortVideo.forwardID;
        paramSessionInfo.a((awel)localObject);
      }
      aweg.a(paramSessionInfo, paramQQAppInterface);
      return;
      if (i == 2)
      {
        i = 3;
        break;
      }
      i = 0;
      break;
      label683:
      if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
        j = 3;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AbsShareMsg paramAbsShareMsg)
  {
    a(paramQQAppInterface, paramSessionInfo, paramAbsShareMsg);
    alep.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 2, 0, 0L, 0L, 0L, "LocationShare", "");
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
      int j = avys.jdField_a_of_type_Int;
      avys.jdField_a_of_type_Int = j + 1;
      paramSessionInfo = awbi.a(paramQQAppInterface, str2, str3, str1, i, j, paramAbsStructMsg);
      acvh.a().a(paramSessionInfo.uniseq, paramAbsStructMsg.parentUniseq, paramAbsStructMsg.forwardID);
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramSessionInfo, paramString, 1010, false, (byte)1, (byte)0, (short)0, Math.abs(new Random().nextInt()), null, new aaes());
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
    a(paramQQAppInterface, paramSessionInfo, aaek.f + "http://maps.google.com/maps?q=" + paramString1 + "," + paramString2 + "&iwloc=A&hl=zh-CN (" + paramString3 + ")");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, String paramString4, AbsShareMsg paramAbsShareMsg, String paramString5, String paramString6, String paramString7)
  {
    paramString7 = new ArkAppMessage();
    if (alck.e) {}
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
        paramString6 = ajjy.a(2131635755);
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
          int j = avys.jdField_a_of_type_Int;
          avys.jdField_a_of_type_Int = j + 1;
          paramString7.containStructMsg = awbi.a(paramQQAppInterface, str1, str2, paramString6, i, j, paramAbsShareMsg);
          paramString7.promptText = String.format(ajjy.a(2131635768), new Object[] { paramString7.appDesc });
          paramString7.from = 1;
          paramString7.metaList = a(paramString5, paramString3, paramString4, paramString1, paramString2);
          paramString1 = new JSONObject();
          paramString1.put("forward", 1);
          paramString1.put("autosize", 1);
          paramString1.put("type", "card");
          paramString7.config = paramString1.toString();
          b(paramQQAppInterface, paramSessionInfo, paramString7);
          ArkAppCenter.c("sendArkStructMap", "send ark msg is success and arkMsg.metaList=" + paramString7.metaList);
          alep.a(paramQQAppInterface, "com.tencent.map", "AIOArkMapSendMessage", 1, 0, 0L, 0L, 0L, paramString7.appView, "");
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
    anfj localanfj = (anfj)paramQQAppInterface.getManager(43);
    ThreadManager.post(new ChatActivityFacade.19(paramEmoticon, (arnz)paramQQAppInterface.getManager(14), localanfj), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString, paramMessageForPtt, paramBoolean1, paramInt1, paramInt2, paramBoolean2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, MessageForPtt paramMessageForPtt, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, atpa paramatpa)
  {
    paramString = new ChatActivityFacade.1(paramMessageForPtt, paramQQAppInterface, paramString, paramBoolean2, paramatpa, paramInt1, paramInt2);
    if (paramBoolean1)
    {
      paramString.run();
      return;
    }
    paramQQAppInterface.a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<String> paramArrayList, aaep paramaaep)
  {
    String str = "";
    if (paramString != null) {
      str = awbk.a(paramString, true, null);
    }
    int i = avys.jdField_a_of_type_Int;
    avys.jdField_a_of_type_Int = i + 1;
    long l1 = i;
    i = Math.abs(new Random().nextInt());
    int j = (int)awao.a();
    paramString = paramQQAppInterface.getCurrentAccountUin();
    long l2 = awbk.a(i);
    ChatMessage localChatMessage = (ChatMessage)awbi.a(-1000);
    localChatMessage.init(paramString, "", paramString, str, j, -1000, 0, l1);
    localChatMessage.isread = true;
    localChatMessage.msgUid = l2;
    localChatMessage.shmsgseq = awbk.a(l1, 0);
    localChatMessage.issend = 1;
    if (paramArrayList.size() <= 10) {}
    for (boolean bool = true;; bool = false)
    {
      localChatMessage.needUpdateMsgTag = bool;
      ((ajrm)paramQQAppInterface.a(13)).a(localChatMessage);
      ((MessageForText)localChatMessage).msgVia = 0;
      paramQQAppInterface.a().a(paramQQAppInterface, localChatMessage, paramArrayList, paramaaep);
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
      if (((i != 0) || (paramList.contains(jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && (jdField_a_of_type_Begr != null)) {
        jdField_a_of_type_Begr.dismiss();
      }
      return;
    }
  }
  
  private static boolean a(aaes paramaaes, boolean paramBoolean)
  {
    if (paramaaes.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      byte[] arrayOfByte = paramaaes.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.getSourceMsg();
      if ((arrayOfByte == null) || (arrayOfByte.length < 560)) {
        break label34;
      }
      paramaaes.f = true;
    }
    label34:
    do
    {
      return false;
      if ((paramBoolean) && (paramaaes.f)) {
        return true;
      }
    } while ((paramBoolean) || (paramaaes.f));
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
          paramMessageForLongMsg = awbi.a(paramMessageForLongMsg);
          paramQQAppInterface.a().a(paramMessageForLongMsg, null, true);
        }
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = awbi.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    acvh.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramArkAppMessage.forwardID);
    if (localMessageForArkApp.istroop == 1) {
      mnf.a().a(localMessageForArkApp);
    }
    localMessageForArkApp.saveExtInfoToExtStr(awav.jdField_e_of_type_JavaLangString, "1");
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
    MessageForArkApp localMessageForArkApp = awbi.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    if (paramInt == 0)
    {
      paramInt = paramArkAppMessage.forwardID;
      acvh.a().a(localMessageForArkApp.uniseq, paramArkAppMessage.uniSeq, paramInt);
      if (localMessageForArkApp.istroop == 1) {
        mnf.a().a(localMessageForArkApp);
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
    paramSessionInfo = awbi.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkFlashChatMessage);
    if (paramInt == 0) {
      paramInt = paramArkFlashChatMessage.forwardID;
    }
    for (;;)
    {
      acvh.a().a(paramSessionInfo.uniseq, paramArkFlashChatMessage.uniSeq, paramInt);
      if (paramSessionInfo.istroop == 1) {
        mnf.a().a(paramSessionInfo);
      }
      paramQQAppInterface.a().a(paramSessionInfo, null);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, ajmm paramajmm)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramHiBoomMessage, paramajmm, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, HiBoomMessage paramHiBoomMessage, ajmm paramajmm, int paramInt)
  {
    paramSessionInfo = awbi.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramHiBoomMessage);
    acvh.a().a(paramSessionInfo.uniseq, 0L, paramInt);
    if (paramSessionInfo.istroop == 1) {
      mnf.a().a(paramSessionInfo);
    }
    paramQQAppInterface.a().a(paramSessionInfo, paramajmm);
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, aaes paramaaes)
  {
    return (arxo.a(paramQQAppInterface)) && (akbm.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) && ((a(paramSessionInfo, paramString) > 560) || (a(paramaaes, true)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp.istroop == 1) {
      mnf.a().a(paramMessageForArkApp);
    }
    if (paramBoolean) {
      paramQQAppInterface.a().b(paramMessageForArkApp, paramQQAppInterface.getCurrentAccountUin());
    }
    paramMessageForArkApp.mPendantAnimatable = true;
    Object localObject = paramQQAppInterface.a().a().a(paramMessageForArkApp);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
      }
      paramMessageForArkApp.extraflag = 32768;
      paramQQAppInterface.a().a(paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq);
      localObject = paramMessageForArkApp.frienduin;
      int i = paramMessageForArkApp.istroop;
      long l = paramMessageForArkApp.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).notifyUI(MessageHandler.a(paramMessageForArkApp.istroop), false, new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
      return true;
    }
    paramBoolean = ((arxo)paramQQAppInterface.getManager(166)).a(paramQQAppInterface, (byte[])localObject, paramQQAppInterface.getCurrentAccountUin(), paramMessageForArkApp.frienduin, paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq, 1035, new aaem(paramMessageForArkApp, paramQQAppInterface));
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
      }
      arxo.a(paramQQAppInterface, paramMessageForArkApp);
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramString, paramInt, paramLong);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForPtt))) {
      return ((MessageForPtt)paramQQAppInterface).c2cViaOffline;
    }
    return false;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramaaes == null) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramContext = a(paramQQAppInterface, paramSessionInfo, paramString, paramArrayList, paramaaes);
      ThreadManager.post(new ChatActivityFacade.15(paramaaes, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramContext;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramContext;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    aaes localaaes = new aaes();
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " sendMessage start currenttime:" + System.currentTimeMillis());
    }
    if ((paramString == null) || (paramString.length() == 0) || (paramSessionInfo == null) || (TextUtils.isEmpty(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      paramString = b(paramQQAppInterface, paramSessionInfo, paramString, null, localaaes);
      ThreadManager.post(new ChatActivityFacade.14(localaaes, paramQQAppInterface, paramSessionInfo), 8, null, true);
      paramQQAppInterface = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " sendMessage end currenttime:" + System.currentTimeMillis());
    return paramString;
  }
  
  public static long[] a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes)
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
        if (a(paramaaes, false))
        {
          localObject = b(str, paramArrayList, paramaaes, localArrayList);
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
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramaaes);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramaaes)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramaaes, localArrayList);
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
      paramArrayList = azzz.a(str, 560, 20, paramArrayList, localArrayList);
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
    if (akbm.c(paramSessionInfo.jdField_a_of_type_Int))
    {
      List localList = paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int);
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          paramSessionInfo = (MessageRecord)localList.get(i);
          if (!bado.b(paramSessionInfo.issend))
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
  
  private static ArrayList<String> b(String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes, ArrayList<ArrayList<MessageForText.AtTroopMemberInfo>> paramArrayList1)
  {
    paramaaes = new ArrayList();
    paramaaes.add(paramString);
    paramArrayList1.add(paramArrayList);
    return paramaaes;
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
    int i = avys.jdField_a_of_type_Int;
    avys.jdField_a_of_type_Int = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramSessionInfo = awbi.a(str, paramSessionInfo.jdField_a_of_type_JavaLangString, str, paramSessionInfo.jdField_a_of_type_Int, l);
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
    if (!badq.d(BaseApplication.getContext()))
    {
      ChatActivityUtils.a(paramContext, 2131626719, 0);
      return;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    if (localMessageRecord == null)
    {
      ChatActivityUtils.a(paramContext, 2131653422, 0);
      return;
    }
    paramQQAppInterface.a().b(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramLong);
    paramContext = awbi.a(localMessageRecord);
    paramQQAppInterface.a().a(paramContext, null, true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramString, null, new aaes());
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.3(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIONewestFeedRsp paramAIONewestFeedRsp, boolean paramBoolean)
  {
    if ((paramAIONewestFeedRsp == null) || (paramAIONewestFeedRsp.uOpuin != Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue()) || (paramAIONewestFeedRsp.uFeedInfos == null) || (paramAIONewestFeedRsp.uFeedInfos.isEmpty())) {
      if ((paramAIONewestFeedRsp != null) && (paramAIONewestFeedRsp.uOpFlag == 1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade.QZoneFeeds", 2, "newestFeed.uOpFlag==1  需要清理本地缓存");
        }
        n(paramQQAppInterface, paramSessionInfo);
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
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.8(paramQQAppInterface, paramSessionInfo, paramStGetUserNewestStoryRsp));
    return;
    label144:
    ThreadManager.getSubThreadHandler().post(new ChatActivityFacade.9(paramQQAppInterface, paramSessionInfo));
  }
  
  @TargetApi(9)
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
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
      } while ((i != 0) && (i != 1) && (i != 3000) && (i != 1001) && (i != 10002) && (i != 10004) && (i != 1006) && (i != 1004) && (i != 1000) && (i != 3));
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
      akbm.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -4020);
      paramQQAppInterface.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_Int, -4020, (String)localObject2);
      VasWebviewUtil.reportCommercialDrainage(paramSessionInfo.jdField_a_of_type_JavaLangString, "aio_pay", "aio_show", "", 1, 0, 0, "", String.valueOf(i), "");
      return;
      localObject2 = (baot)paramQQAppInterface.a(71);
      if (localObject2 == null) {
        break;
      }
      ((baot)localObject2).a(1);
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
      m(paramQQAppInterface, paramSessionInfo);
      l(paramQQAppInterface, paramSessionInfo);
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
    EmoticonPackage localEmoticonPackage = ((arnz)paramQQAppInterface.getManager(14)).a(paramString);
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
  
  public static long[] b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, aaes paramaaes)
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
        if (a(paramaaes, false))
        {
          localObject = b(str, paramArrayList, paramaaes, localArrayList);
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
          localObject[i] = a(paramQQAppInterface, paramSessionInfo, str, -1000, bool1, (byte)paramString.size(), (byte)i, s1, j, paramArrayList, paramaaes, true);
          i += 1;
          continue;
          if (!a(paramQQAppInterface, paramSessionInfo, str, paramaaes)) {
            continue;
          }
          localObject = a(str, paramArrayList, paramaaes, localArrayList);
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
      paramArrayList = azzz.a(str, 560, 20, paramArrayList, localArrayList);
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
      paramContext = awbi.a(paramContext);
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
    ThreadManager.post(new ChatActivityFacade.4(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  private static void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    paramSessionInfo = a(paramQQAppInterface, paramSessionInfo, paramString);
    paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0).edit().putLong(paramSessionInfo, NetConnInfoCenter.getServerTimeMillis()).apply();
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
  
  private static boolean c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    do
    {
      return false;
      if (!bfpr.m()) {
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
  
  private static long d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityFacade.QZoneFeeds", 2, "getLastFeedsPublishTimeV2   start");
    }
    BeancurdMsg localBeancurdMsg = ((acjz)paramQQAppInterface.getManager(282)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 2);
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
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {}
    do
    {
      return;
      try
      {
        ((MessageHandler)paramQQAppInterface.a(0)).c(Long.valueOf(paramSessionInfo.jdField_a_of_type_JavaLangString).longValue());
        return;
      }
      catch (Exception paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.i("ChatActivityFacade", 2, "insertCommonHobbyIfNeeded uin is: " + paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  private static boolean d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
  
  private static boolean d(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {}
    while (bfpr.n()) {
      return false;
    }
    if (paramBoolean) {
      return d(paramQQAppInterface, paramSessionInfo);
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
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.5(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  public static void f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.post(new ChatActivityFacade.6(paramQQAppInterface, paramSessionInfo), 5, null, true);
  }
  
  public static void g(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    MessageRecord localMessageRecord = awbi.a(-4005);
    long l = awao.a();
    localMessageRecord.init(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getContext().getString(2131628467), l, -4005, paramSessionInfo.jdField_a_of_type_Int, l);
    localMessageRecord.isread = true;
    if (!ajml.a(paramQQAppInterface, localMessageRecord, false)) {
      paramQQAppInterface.a().a(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  public static void h(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
    int i = avys.jdField_a_of_type_Int;
    avys.jdField_a_of_type_Int = i + 1;
    ((MessageHandler)localObject2).a(paramSessionInfo, (String)localObject1, (byte)18, paramQQAppInterface, i, -1L);
  }
  
  private static void k(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
      l(paramQQAppInterface, paramSessionInfo);
      return;
    }
  }
  
  private static void l(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.getApp() == null) || (paramSessionInfo == null)) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("qzone_sp_in_qq", 0);
    paramQQAppInterface = a(paramQQAppInterface, paramSessionInfo, "key_last_req_aio_feeds_time");
    localSharedPreferences.edit().remove(paramQQAppInterface).apply();
  }
  
  private static void m(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
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
          baig.a(paramQQAppInterface.c(), localMessageRecord.frienduin, 0L);
        }
      }
    }
  }
  
  private static void n(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    ((acjz)paramQQAppInterface.getManager(282)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 2);
    m(paramQQAppInterface, paramSessionInfo);
  }
  
  private static void o(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    QLog.i("ChatActivityFacade.QZoneStoryFeeds", 2, "hasNewFlag == 1,且storyFeeds.size =0 ,视为后台让客户端，需要清理本地缓存");
    ((acjz)paramQQAppInterface.getManager(282)).a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, 7);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aael
 * JD-Core Version:    0.7.0.1
 */