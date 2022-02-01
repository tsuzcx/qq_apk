import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.1;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilderMenuHelper.2;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicJumpActivity;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ahiq
{
  private StructingMsgItemBuilder a;
  
  public ahiq(StructingMsgItemBuilder paramStructingMsgItemBuilder)
  {
    this.a = paramStructingMsgItemBuilder;
  }
  
  private bdnu a(AbsShareMsg paramAbsShareMsg, bdnu parambdnu)
  {
    int i = 0;
    for (;;)
    {
      bdnu localbdnu = parambdnu;
      if (i < paramAbsShareMsg.getItemCount())
      {
        localbdnu = paramAbsShareMsg.getItemByIndex(i);
        if ((TextUtils.isEmpty(localbdnu.aa)) || (Integer.valueOf(localbdnu.aa).intValue() != StructingMsgItemBuilder.c) || ((!(localbdnu instanceof bdro)) && (!(localbdnu instanceof bdrp)))) {}
      }
      else
      {
        return localbdnu;
      }
      i += 1;
    }
  }
  
  private String a(@NonNull bdnv parambdnv, Class paramClass)
  {
    ArrayList localArrayList = parambdnv.a;
    parambdnv = null;
    int i = 0;
    bdnu localbdnu;
    if (i < localArrayList.size())
    {
      localbdnu = (bdnu)localArrayList.get(i);
      if (localbdnu == null) {
        break label161;
      }
      if (localbdnu.getClass().equals(paramClass)) {}
    }
    label161:
    for (;;)
    {
      i += 1;
      break;
      if (StructMsgItemTitle.class.equals(paramClass))
      {
        parambdnv = ((StructMsgItemTitle)localbdnu).b();
      }
      else if (bdsv.class.equals(paramClass))
      {
        parambdnv = ((bdsv)localbdnu).b();
      }
      else if (bdpx.class.equals(paramClass))
      {
        parambdnv = ((bdpx)localbdnu).ac;
      }
      else if (bdsp.class.equals(paramClass))
      {
        parambdnv = ((bdsp)localbdnu).ac;
      }
      else if (bdsk.class.equals(paramClass))
      {
        parambdnv = ((bdsk)localbdnu).ac;
        continue;
        return parambdnv;
      }
    }
  }
  
  private String a(StructMsgForGeneralShare paramStructMsgForGeneralShare, String paramString)
  {
    Object localObject1 = paramString;
    int i;
    if (paramStructMsgForGeneralShare.mIsPAVideoStructMsg) {
      i = 0;
    }
    for (;;)
    {
      localObject1 = paramString;
      if (i < paramStructMsgForGeneralShare.getItemCount())
      {
        localObject1 = paramStructMsgForGeneralShare.getItemByIndex(i);
        if (!(localObject1 instanceof bdrp)) {
          break label142;
        }
        Object localObject2 = ((bdrp)localObject1).a.iterator();
        do
        {
          localObject1 = paramString;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (bdnu)((Iterator)localObject2).next();
        } while (!(localObject1 instanceof bdte));
        localObject2 = (bdte)localObject1;
        paramString = ((bdte)localObject2).ac;
        localObject1 = paramString;
        if (((bdte)localObject2).a())
        {
          omx.a("0X8006601", paramStructMsgForGeneralShare.uinType, omx.a(((bdte)localObject2).v, paramStructMsgForGeneralShare.mSourceName), ((bdte)localObject2).ae, "");
          localObject1 = paramString;
        }
      }
      return localObject1;
      label142:
      i += 1;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString2 != null)
    {
      str = paramString1;
      if (!"".equals(paramString2)) {
        if (paramString1 != null)
        {
          str = paramString1;
          if (!"".equals(paramString1)) {}
        }
        else
        {
          str = paramString2;
        }
      }
    }
    return str;
  }
  
  private void a(Context paramContext, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ThreadManager.post(new StructingMsgItemBuilderMenuHelper.1(this, paramMessageForStructing, paramSessionInfo, paramActivity, paramQQAppInterface, paramContext), 8, null, false);
  }
  
  private void a(Context paramContext1, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext2)
  {
    if (a(paramContext1, paramString, paramMessageForStructing, paramQQAppInterface, paramContext2)) {
      return;
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
      ykv.a(paramQQAppInterface, paramContext2, paramMessageForStructing, "forward");
    }
    Object localObject = new Bundle();
    if ((paramMessageForStructing.structingMsg.source_puin != null) && (!"".equals(paramMessageForStructing.structingMsg.source_puin))) {
      ((Bundle)localObject).putString("source_puin", paramMessageForStructing.structingMsg.source_puin);
    }
    ((Bundle)localObject).putInt("forward_type", -3);
    paramMessageForStructing.structingMsg.mCommentText = null;
    ((Bundle)localObject).putInt("structmsg_service_id", paramMessageForStructing.structingMsg.mMsgServiceID);
    ((Bundle)localObject).putByteArray("stuctmsg_bytes", paramMessageForStructing.structingMsg.getBytes());
    ((Bundle)localObject).putLong("structmsg_uniseq", paramMessageForStructing.uniseq);
    ((Bundle)localObject).putInt("accostType", paramMessageForStructing.structingMsg.sourceAccoutType);
    ((Bundle)localObject).putInt("selection_mode", this.a.b());
    paramContext1 = new Intent();
    paramContext1.putExtras((Bundle)localObject);
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare))
    {
      localObject = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      bdqa localbdqa = ((StructMsgForImageShare)localObject).getFirstImageElement();
      if ((localbdqa != null) && (localbdqa.a()))
      {
        paramContext1.putExtra("key_forward_image_share", true);
        paramContext1.putExtra("key_forward_image_share_appid", Long.toString(((StructMsgForImageShare)localObject).mSourceAppid));
        paramContext1.putExtra("key_forward_image_share_uin_type", ((StructMsgForImageShare)localObject).uinType);
      }
    }
    for (;;)
    {
      aupt.a((Activity)paramContext2, paramContext1, 21);
      paramContext1 = paramMessageForStructing.structingMsg.mMsgUrl;
      bdla.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, paramMessageForStructing.senderuin, paramContext1, Long.toString(paramMessageForStructing.structingMsg.msgId), "");
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      if (paramMessageForStructing.structingMsg.mMsgServiceID == 84) {
        bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8007166", "0X8007166", 0, 0, "", "", "", "");
      }
      if (ahsj.a(paramString)) {
        blrb.a(paramQQAppInterface, "3009", "2", "40053", ahsj.b(paramString), new String[] { "2", "", ahsj.a(paramString) });
      }
      if (!paramMessageForStructing.isMultiMsg) {
        break;
      }
      a("0X8009D66", paramMessageForStructing, paramQQAppInterface);
      return;
      if (((paramMessageForStructing.structingMsg instanceof StructMsgForAudioShare)) || ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)))
      {
        paramContext1.putExtra("key_forward_share", true);
        paramContext1.putExtra("key_forward_share_title", ((AbsShareMsg)paramMessageForStructing.structingMsg).mContentTitle);
        paramContext1.putExtra("key_forward_image_share_uin_type", paramMessageForStructing.structingMsg.uinType);
      }
    }
  }
  
  private void a(bhjq parambhjq, QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (paramAbsStructMsg.hasFlag(8)) {
      afqs.a(afqs.a, parambhjq);
    }
    if (paramMessageForStructing.istroop == 1008) {
      if (!paramAbsStructMsg.hasFlag(32)) {
        afqs.a(afqs.p, parambhjq);
      }
    }
    for (;;)
    {
      afqs.b(paramMessageForStructing, parambhjq);
      return;
      if (!paramAbsStructMsg.hasFlag(1))
      {
        afqs.a(afqs.b, parambhjq);
        continue;
        if (paramAbsStructMsg.mMsgServiceID != 14) {
          if (!paramAbsStructMsg.hasFlag(1))
          {
            afqs.a(afqs.b, parambhjq);
          }
          else if (paramAbsStructMsg.mMsgServiceID == 35)
          {
            afqs.a(afqs.b, parambhjq);
            bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8006625", "0X8006625", 0, 1, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  private void a(bhjq parambhjq, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageForStructing.extraflag != 32768) && (!paramQQAppInterface.getMsgCache().b(paramMessageForStructing)) && (a(paramMessageForStructing, paramAbsStructMsg))) {
      afqs.a(paramMessageForStructing, parambhjq);
    }
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("bFriendCard", true);
      ((JSONObject)localObject).put("jumpUrl", paramAbsShareMsg.mContentCover);
      localObject = ((JSONObject)localObject).toString().getBytes();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localArrayList.add(paramAbsShareMsg.getXml().getBytes());
      bmad.a(null, false, paramAbsShareMsg.mContentTitle, paramAbsShareMsg.mContentSummary, false, 0L, "").b("sBizDataList", localArrayList).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
      bman.a(paramQQAppInterface, 10, 0, paramAbsShareMsg.uinType);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    String str2 = ContactUtils.getBuddyName(paramQQAppInterface, paramQQAppInterface.getAccount(), true);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramAbsShareMsg.mContentSrc;
    }
    bmad.a(paramInt, paramAbsShareMsg.mContentTitle, paramAbsShareMsg.mMsgUrl, paramAbsShareMsg.mSourceName, paramAbsShareMsg.mContentSummary, paramString, str1, paramArrayOfByte, false, 0L).b(paramQQAppInterface, paramChatMessage).a("lCategory", 10L).b("sUin", paramAbsShareMsg.mSourceName).a(paramActivity, paramQQAppInterface.getAccount());
    bman.a(paramQQAppInterface, 8, 0, paramAbsShareMsg.uinType);
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext, AbsShareMsg paramAbsShareMsg, byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramAbsShareMsg.mContentSummary;
    int i;
    if (this.a.a(paramAbsShareMsg))
    {
      localArrayList.add(bmaf.a(true));
      i = paramInt;
      if (!TextUtils.isEmpty(paramAbsShareMsg.mMsgUrl))
      {
        i = paramInt;
        if (paramAbsShareMsg.mMsgUrl.indexOf("action=accountCard") > -1)
        {
          localArrayList.add(paramAbsShareMsg.getXml().getBytes());
          i = 7;
        }
      }
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt == 6) || (paramInt == 7)) {
        bman.a(paramQQAppInterface, 10, 0, paramAbsShareMsg.uinType);
      }
      for (;;)
      {
        bmad.a(paramInt, paramAbsShareMsg.mContentTitle, paramAbsShareMsg.mMsgUrl, paramAbsShareMsg.mSourceName, str1, paramString, paramAbsShareMsg.mContentSrc, paramArrayOfByte, false, 0L).b("sBizDataList", localArrayList).b(paramQQAppInterface, paramChatMessage).a((Activity)paramContext, paramQQAppInterface.getAccount());
        return;
        i = paramInt;
        if (TextUtils.isEmpty(paramAbsShareMsg.mMsgUrl)) {
          break label331;
        }
        i = paramInt;
        if (paramAbsShareMsg.mMsgUrl.indexOf("jq.qq.com") <= -1) {
          break label331;
        }
        localArrayList.add(paramAbsShareMsg.getXml().getBytes());
        i = 6;
        String str2 = this.a.a(paramAbsShareMsg.mContentCover);
        if (TextUtils.isEmpty(str2)) {
          break label331;
        }
        str1 = paramContext.getString(2131697846) + str2;
        paramArrayOfByte = null;
        paramInt = 6;
        break;
        if (becr.a(paramAbsShareMsg.mMsgUrl)) {
          bman.a(paramQQAppInterface, 12, 0, paramAbsShareMsg.uinType);
        } else {
          bman.a(paramQQAppInterface, 8, 0, paramAbsShareMsg.uinType);
        }
      }
      label331:
      paramInt = i;
    }
  }
  
  private void a(ChatMessage paramChatMessage, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg)
  {
    int j = 0;
    int i = j;
    if ((paramAbsShareMsg instanceof StructMsgForImageShare))
    {
      i = j;
      if (!paramMessageForStructing.isSendFromLocal())
      {
        paramMessageForStructing = ((StructMsgForImageShare)paramAbsShareMsg).getFirstImageElement();
        i = paramAbsShareMsg.uinType;
        if ((paramMessageForStructing != null) && (paramMessageForStructing.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null))
        {
          paramQQAppInterface.getPicPreDownloader().a(paramMessageForStructing.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, 2);
          ThreadManager.getFileThreadHandler().post(new StructingMsgItemBuilderMenuHelper.2(this, paramMessageForStructing, i, paramQQAppInterface, paramChatMessage, paramActivity));
        }
        i = 1;
      }
    }
    if (i == 0)
    {
      paramMessageForStructing = bmar.a((StructMsgForImageShare)paramAbsShareMsg);
      if (paramMessageForStructing != null)
      {
        bmad.a(paramMessageForStructing.ae, paramAbsShareMsg.uinType, paramMessageForStructing.ad, paramMessageForStructing.c, paramMessageForStructing.ac, paramMessageForStructing.d).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
        bman.a(paramQQAppInterface, 2, 0, paramAbsShareMsg.uinType);
        bman.a(paramQQAppInterface, 6, 3);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a.a(paramChatMessage);
    if (ahsj.a(paramString)) {
      blrb.a(paramQQAppInterface, "3009", "2", "40053", ahsj.b(paramString), new String[] { "4", "", ahsj.a(paramString) });
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
      ykv.a(paramQQAppInterface, paramContext, paramMessageForStructing, "withdraw");
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, Context paramContext)
  {
    if (("web".equals(paramMessageForStructing.structingMsg.mMsgAction)) && (paramMessageForStructing.structingMsg.mMsgUrl != null)) {
      ((ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramMessageForStructing.structingMsg.mMsgUrl);
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, SessionInfo paramSessionInfo, Activity paramActivity)
  {
    paramAbsShareMsg = (StructMsgForGeneralShare)bdof.a(paramAbsShareMsg.getBytes());
    usj.a(paramAbsShareMsg);
    paramAbsShareMsg.mSourceAction = "web";
    String str = paramSessionInfo.curFriendUin;
    paramAbsShareMsg.mSourceUrl = usj.a(str);
    paramAbsShareMsg.mSourceName = paramSessionInfo.curFriendNick;
    paramAbsShareMsg.source_puin = str;
    paramAbsShareMsg.mSourceIcon = "https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png";
    paramAbsShareMsg.setFlag(0);
    paramSessionInfo = new Bundle();
    paramSessionInfo.putInt("forward_type", -3);
    paramSessionInfo.putInt("structmsg_service_id", paramAbsShareMsg.mMsgServiceID);
    paramSessionInfo.putByteArray("stuctmsg_bytes", paramAbsShareMsg.getBytes());
    paramAbsShareMsg = new Intent();
    paramAbsShareMsg.putExtras(paramSessionInfo);
    aupt.a(paramActivity, paramAbsShareMsg, 21);
  }
  
  private void a(String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    int j = 10;
    paramMessageForStructing = paramMessageForStructing.structingMsg;
    int i = j;
    if (paramMessageForStructing != null) {
      switch (paramMessageForStructing.mMsgServiceID)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, i, 0, "" + i, "", "", "");
      return;
      i = 2;
      continue;
      i = 7;
    }
  }
  
  private void a(String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject1;
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare))
    {
      paramMessageForStructing = (StructMsgForImageShare)paramMessageForStructing.structingMsg;
      localObject1 = paramMessageForStructing.getFirstImageElement();
      if (localObject1 != null)
      {
        localObject1 = ((bdqa)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        localObject2 = URLDrawableHelper.getURL((azkl)localObject1, 1);
        if (localObject2 != null) {}
      }
    }
    while (!ahsj.a(paramString))
    {
      return;
      Object localObject2 = URLDrawable.getDrawable((URL)localObject2, -1, -1, null, null, false);
      ((URLDrawable)localObject2).setTag(localObject1);
      ahsl.a(paramContext, paramQQAppInterface, (URLDrawable)localObject2, ((MessageForPic)localObject1).frienduin, paramContext.getResources().getDimensionPixelSize(2131299080), paramMessageForStructing, null);
    }
    blrb.a(paramQQAppInterface, "3009", "2", "40053", ahsj.b(paramString), new String[] { "1", "", ahsj.a(paramString) });
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if ((paramInt == 86) || (paramInt == 61) || (paramInt == 91) || (paramInt == 97) || (paramInt == 98)) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 == paramInt2) || (paramInt1 == paramInt3);
  }
  
  private boolean a(Context paramContext1, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext2)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare))
    {
      if (!((StructMsgForImageShare)paramMessageForStructing.structingMsg).checkImageSharePic(paramQQAppInterface.getApp())) {
        return true;
      }
    }
    else if (paramMessageForStructing.structingMsg.mMsgServiceID == 35)
    {
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8006624", "0X8006624", 0, 1, 0, "", "", "", "");
      if (!axio.a().a(paramQQAppInterface, paramMessageForStructing.uniseq))
      {
        int i = paramContext1.getResources().getDimensionPixelSize(2131299080);
        QQToast.a(paramContext1, anvx.a(2131713968), 0).b(i);
        return true;
      }
      if (axio.a().b(paramQQAppInterface, paramMessageForStructing.uniseq))
      {
        bhdj.a(paramContext1, 230, null, "选择的消息中，部分图片\\表情等内容可能无法正常转发，是否继续转发？", anvx.a(2131713960), anvx.a(2131713970), new ahir(this, paramMessageForStructing, paramContext2), new ahis(this)).show();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(bhjq parambhjq, MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg, QQAppInterface paramQQAppInterface)
  {
    if (paramAbsStructMsg == null) {}
    do
    {
      return false;
      if (((paramAbsStructMsg instanceof AbsShareMsg)) && (((AbsShareMsg)paramAbsStructMsg).mMsgException))
      {
        afqs.a(afqs.e, parambhjq);
        if (paramMessageForStructing.istroop == 1008) {
          afqs.a(afqs.d, parambhjq);
        }
        afqs.a(afqs.l, parambhjq);
        return true;
      }
      if (a(paramAbsStructMsg.mMsgServiceID))
      {
        afqs.a(afqs.e, parambhjq);
        afqs.a(afqs.l, parambhjq);
        return true;
      }
      if (paramAbsStructMsg.mMsgServiceID == 128)
      {
        afqs.b(paramMessageForStructing, parambhjq);
        afqs.a(paramMessageForStructing, parambhjq);
        afqs.c(paramMessageForStructing, parambhjq);
        bhbu.a("Grp_AIO", "invite", "send_in", 0, 0, new String[0]);
        return true;
      }
      if ((paramAbsStructMsg instanceof StructMsgForHypertext))
      {
        afqs.a(afqs.e, parambhjq);
        afqs.a(afqs.d, parambhjq);
        afqs.a(afqs.l, parambhjq);
        return true;
      }
    } while (!a(paramMessageForStructing, paramAbsStructMsg, paramQQAppInterface, parambhjq));
    return true;
  }
  
  private boolean a(ChatMessage paramChatMessage, AbsStructMsg paramAbsStructMsg, QQAppInterface paramQQAppInterface, bhjq parambhjq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage.isSendFromLocal())
    {
      bool1 = bool2;
      if ((paramAbsStructMsg instanceof AbsShareMsg))
      {
        bool1 = bool2;
        if (((AbsShareMsg)paramAbsStructMsg).isSdkShareMsg()) {
          if (paramChatMessage.extraflag != 32772)
          {
            bool1 = bool2;
            if (paramChatMessage.extraflag != 32768) {}
          }
          else
          {
            if (paramQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq) == null) {
              break label109;
            }
            afqs.a(afqs.n, parambhjq);
          }
        }
      }
    }
    for (;;)
    {
      afqs.a(paramChatMessage, parambhjq);
      afqs.a(afqs.l, parambhjq);
      bool1 = true;
      return bool1;
      label109:
      afqs.a(paramChatMessage, parambhjq);
    }
  }
  
  private boolean a(@NonNull MessageForStructing paramMessageForStructing, @NonNull AbsStructMsg paramAbsStructMsg, boolean paramBoolean)
  {
    boolean bool;
    if (((1008 != paramMessageForStructing.istroop) || (!AppConstants.REMINDER_UIN.equals(paramMessageForStructing.frienduin))) && ((paramAbsStructMsg.mMsgUrl == null) || (!paramAbsStructMsg.mMsgUrl.startsWith("https://ti.qq.com/remind/view.html"))))
    {
      bool = paramBoolean;
      if (paramAbsStructMsg.mMsgUrl != null)
      {
        bool = paramBoolean;
        if (!paramAbsStructMsg.mMsgUrl.startsWith("https://mqq.tenpay.com")) {}
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  private boolean a(AbsStructMsg paramAbsStructMsg, MessageForStructing paramMessageForStructing, Context paramContext)
  {
    bdqa localbdqa = ((StructMsgForImageShare)paramAbsStructMsg).getFirstImageElement();
    if (localbdqa != null)
    {
      MessageForPic localMessageForPic2 = localbdqa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      localMessageForPic1 = localMessageForPic2;
      if (localMessageForPic2 == null)
      {
        if (localbdqa.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null)
        {
          localbdqa.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramAbsStructMsg);
          localbdqa.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare.message = paramMessageForStructing;
        }
        localbdqa.a(paramContext, null, null);
      }
    }
    for (MessageForPic localMessageForPic1 = localbdqa.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;; localMessageForPic1 = null)
    {
      boolean bool = URLDrawableHelper.hasDiskCache(paramContext, localMessageForPic1, 65537);
      if (localMessageForPic1.imageType == 2000) {}
      for (int i = 1; (!bool) && (i == 0); i = 0) {
        return true;
      }
      return false;
    }
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg, boolean paramBoolean)
  {
    paramString = ahsj.b(paramString);
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if (paramString.length > 2)
      {
        String str = paramString[1];
        paramString = paramString[2];
        paramString = ((StructMsgForImageShare)paramAbsShareMsg).getFirstImageElement();
        if (paramString != null)
        {
          if (paramString.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
            paramString.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramAbsShareMsg);
          }
          AIOImageData localAIOImageData = ahsl.a(paramString.a());
          File localFile = localAIOImageData.a(4);
          paramString = localFile;
          if (localFile == null) {
            paramString = localAIOImageData.a(2);
          }
          if (paramString != null) {
            paramString.getAbsolutePath();
          }
        }
        paramString = paramQQAppInterface.getAccount();
        bmad.a(str).c(paramString).a(paramActivity, paramString);
        bman.a(paramQQAppInterface, 7, 0, paramAbsShareMsg.uinType);
        bman.a(paramQQAppInterface, 6, 2);
        bool = true;
      }
    }
    return bool;
  }
  
  private void b(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg)
  {
    if (!TextUtils.isEmpty(paramAbsShareMsg.mMsgActionData))
    {
      String[] arrayOfString1 = paramAbsShareMsg.mMsgActionData.split("&");
      int j = arrayOfString1.length;
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      Object localObject1 = null;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        Object localObject5 = localObject4;
        Object localObject6 = localObject3;
        Object localObject7 = localObject2;
        Object localObject8 = localObject1;
        if (arrayOfString2.length > 1)
        {
          if (!arrayOfString2[0].trim().equals("lat")) {
            break label146;
          }
          localObject8 = arrayOfString2[1];
          localObject7 = localObject2;
          localObject6 = localObject3;
          localObject5 = localObject4;
        }
        for (;;)
        {
          i += 1;
          localObject4 = localObject5;
          localObject3 = localObject6;
          localObject2 = localObject7;
          localObject1 = localObject8;
          break;
          label146:
          if (arrayOfString2[0].trim().equals("lon"))
          {
            localObject7 = arrayOfString2[1];
            localObject5 = localObject4;
            localObject6 = localObject3;
            localObject8 = localObject1;
          }
          else if (arrayOfString2[0].trim().equals("loc"))
          {
            localObject6 = arrayOfString2[1];
            localObject5 = localObject4;
            localObject7 = localObject2;
            localObject8 = localObject1;
          }
          else
          {
            localObject5 = localObject4;
            localObject6 = localObject3;
            localObject7 = localObject2;
            localObject8 = localObject1;
            if (arrayOfString2[0].trim().equals("title"))
            {
              localObject5 = arrayOfString2[1];
              localObject6 = localObject3;
              localObject7 = localObject2;
              localObject8 = localObject1;
            }
          }
        }
      }
      if ((paramAbsShareMsg.mMsgServiceID == 32) && (!TextUtils.isEmpty(localObject1)) && (!TextUtils.isEmpty(localObject2)) && (!TextUtils.isEmpty(localObject3)))
      {
        bmad.a(Float.valueOf(localObject1).floatValue(), Float.valueOf(localObject2).floatValue(), localObject4, localObject3, null).b(paramQQAppInterface, paramChatMessage).a(paramActivity, paramQQAppInterface.getAccount());
        bman.a(paramQQAppInterface, 11, 0, paramAbsShareMsg.uinType);
        bman.a(paramQQAppInterface, 6, 7);
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    AbsShareMsg localAbsShareMsg = (AbsShareMsg)paramMessageForStructing.structingMsg;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    if ((localAbsShareMsg instanceof StructMsgForImageShare))
    {
      bool3 = false;
      bool2 = false;
      if (ahsj.a(paramString))
      {
        bool1 = b(paramString, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg, false);
        if ((!bool1) && (!bool2)) {
          a(paramChatMessage, paramMessageForStructing, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg);
        }
      }
    }
    for (;;)
    {
      if (paramMessageForStructing.isMultiMsg) {
        a("0X8009D67", paramMessageForStructing, paramQQAppInterface);
      }
      return;
      bool1 = bool3;
      if (!ahsj.b(paramString)) {
        break;
      }
      bool2 = a(paramString, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg, false);
      bool1 = bool3;
      break;
      if (((localAbsShareMsg instanceof StructMsgForGeneralShare)) && (localAbsShareMsg.mMsgServiceID == 35))
      {
        paramString = ((FragmentActivity)paramContext).getChatFragment();
        if (paramString != null)
        {
          paramString = paramString.a();
          ((agit)paramString.getHelper(11)).a(paramString, null, (MessageForStructing)paramChatMessage);
        }
      }
      else
      {
        if (localAbsShareMsg.mMsgServiceID != 32) {
          break label209;
        }
        b(paramChatMessage, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg);
      }
    }
    label209:
    byte[] arrayOfByte = bmar.a(localAbsShareMsg.getXmlBytes());
    int j = 0;
    paramString = localAbsShareMsg.mContentCover;
    int i;
    if ((localAbsShareMsg instanceof StructMsgForAudioShare))
    {
      j = 2;
      i = 10;
    }
    for (;;)
    {
      label243:
      if (a(localAbsShareMsg.mMsgServiceID, 14, 84)) {
        a(paramChatMessage, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg);
      }
      for (;;)
      {
        bman.a(paramQQAppInterface, 6, i);
        break;
        if (!(localAbsShareMsg instanceof StructMsgForGeneralShare)) {
          break label362;
        }
        paramString = a((StructMsgForGeneralShare)localAbsShareMsg, paramString);
        i = 2;
        break label243;
        if (localAbsShareMsg.uinType == 1008) {
          a(paramChatMessage, paramQQAppInterface, (Activity)paramContext, localAbsShareMsg, arrayOfByte, j, paramString);
        } else {
          a(paramChatMessage, paramQQAppInterface, paramContext, localAbsShareMsg, arrayOfByte, j, paramString);
        }
      }
      label362:
      i = 2;
    }
  }
  
  private boolean b(MessageForStructing paramMessageForStructing, AbsStructMsg paramAbsStructMsg)
  {
    if (!paramAbsStructMsg.hasFlag(2))
    {
      if (((paramMessageForStructing.istroop != 1008) || (!TextUtils.isEmpty(paramAbsStructMsg.mMsgUrl))) && (paramAbsStructMsg.mMsgServiceID != 81) && (paramAbsStructMsg.mMsgServiceID != 14)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = bool1;
        if (paramAbsStructMsg.mMsgServiceID == 21)
        {
          bool2 = bool1;
          if (paramAbsStructMsg.mMsgActionData != null)
          {
            bool2 = bool1;
            if (paramAbsStructMsg.mMsgActionData.startsWith("mqqwpa://im/chat")) {
              bool2 = false;
            }
          }
        }
        return bool2;
      }
    }
    return false;
  }
  
  private boolean b(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, AbsShareMsg paramAbsShareMsg, boolean paramBoolean)
  {
    String[] arrayOfString = paramAbsShareMsg.mMsgActionData.substring(paramAbsShareMsg.mMsgActionData.indexOf("|") + 1).split("\\|");
    String str1;
    if ((arrayOfString.length >= 8) && ((arrayOfString[7].equals("link")) || (arrayOfString[7].equals("scrawl_link")))) {
      if ((arrayOfString[7].equals("scrawl_link")) && (arrayOfString.length > 8))
      {
        str1 = arrayOfString[8];
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if ((!paramBoolean) && (!TextUtils.isEmpty(paramAbsShareMsg.mMsg_A_ActionData)))
      {
        arrayOfString = paramAbsShareMsg.mMsg_A_ActionData.split("\\|");
        if ((arrayOfString.length >= 8) && (arrayOfString[7].equals("link"))) {
          paramBoolean = true;
        }
      }
      for (;;)
      {
        Object localObject3;
        Object localObject2;
        if (paramBoolean)
        {
          localObject1 = ((StructMsgForImageShare)paramAbsShareMsg).getFirstImageElement();
          if (localObject1 == null) {
            break label621;
          }
          if (((bdqa)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
            ((bdqa)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramAbsShareMsg);
          }
          localObject3 = ahsl.a(((bdqa)localObject1).a());
          localObject2 = ((AIOImageData)localObject3).a(4);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = ((AIOImageData)localObject3).a(2);
          }
          if (localObject1 == null) {
            break label621;
          }
        }
        label621:
        for (Object localObject1 = ((File)localObject1).getAbsolutePath();; localObject1 = null)
        {
          String str2 = arrayOfString[3] + anvx.a(2131713959) + arrayOfString[5] + anvx.a(2131713965);
          localObject3 = "ADTAG=comic.plugin.read&id=" + arrayOfString[0] + "&name=" + URLEncoder.encode(arrayOfString[1]) + "&sectionID=" + arrayOfString[2] + "&sectionName=" + URLEncoder.encode(arrayOfString[3]) + "&pageID=" + arrayOfString[4] + "&page=" + arrayOfString[5] + "&type=" + arrayOfString[6];
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str1)) {
            localObject2 = (String)localObject3 + "&scrawl_link=" + URLEncoder.encode(str1);
          }
          str1 = VipComicJumpActivity.a("comicReadShare", "5123", null, null, "354", null, (String)localObject2);
          new bmad(6).a("nLinkType", 0).b("sTitle", arrayOfString[1]).b("sUrl", str1).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", paramAbsShareMsg.mSourceName).b("sBrief", str2).b("sPath", (String)localObject1).b("sResUrl", paramAbsShareMsg.mSourceUrl).a("lCategory", 1L).a(paramActivity, paramQQAppInterface.getAccount());
          bman.a(paramQQAppInterface, 6, 2);
          bman.a(paramQQAppInterface, 8, 0, paramAbsShareMsg.uinType);
          blrb.a(paramQQAppInterface, "3009", "2", "40053", ahsj.b(paramString), new String[] { "3", "", ahsj.a(paramString) });
          return paramBoolean;
          paramBoolean = false;
          break;
        }
      }
      str1 = null;
      paramBoolean = true;
      continue;
      str1 = null;
    }
  }
  
  private void c(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a.d(paramChatMessage);
    if (ahsj.a(paramString)) {
      blrb.a(paramQQAppInterface, "3009", "2", "40053", ahsj.b(paramString), new String[] { "6", "", ahsj.a(paramString) });
    }
    long l1;
    long l2;
    int i;
    if (paramChatMessage.istroop == 1008)
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      l1 = 0L;
      if (!(paramMessageForStructing.structingMsg instanceof AbsShareMsg)) {
        break label198;
      }
      Object localObject = (AbsShareMsg)paramMessageForStructing.structingMsg;
      l2 = ((AbsShareMsg)localObject).msgId;
      l1 = l2;
      if (!(localObject instanceof StructMsgForGeneralShare)) {
        break label198;
      }
      localObject = (StructMsgForGeneralShare)localObject;
      i = StructMsgForGeneralShare.clickedItemIndex;
    }
    for (;;)
    {
      bdla.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", paramChatMessage.frienduin, "0X80064F7", "0X80064F7", 0, 0, paramString, String.valueOf(l2), String.valueOf(i), "");
      if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
        ykv.a(paramQQAppInterface, paramContext, paramMessageForStructing, "more");
      }
      return;
      label198:
      i = 0;
      l2 = l1;
    }
  }
  
  private void d(ChatMessage paramChatMessage, String paramString, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    admh.b(paramContext, paramQQAppInterface, paramChatMessage);
    if (ahsj.a(paramString)) {
      blrb.a(paramQQAppInterface, "3009", "2", "40053", ahsj.b(paramString), new String[] { "5", "", ahsj.a(paramString) });
    }
    if (paramMessageForStructing.structingMsg.mMsgServiceID == 81) {
      ykv.a(paramQQAppInterface, paramContext, paramMessageForStructing, "delete");
    }
  }
  
  public bhjq a(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    paramafrk = this.a.a();
    Context localContext = this.a.a();
    SessionInfo localSessionInfo = this.a.a;
    MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
    AbsStructMsg localAbsStructMsg = localMessageForStructing.structingMsg;
    boolean bool = false;
    if (a(parambhjq, localMessageForStructing, localAbsStructMsg, paramafrk)) {
      return parambhjq;
    }
    if ((localAbsStructMsg instanceof StructMsgForImageShare))
    {
      if (a(localAbsStructMsg, localMessageForStructing, localContext))
      {
        afqs.a(afqs.l, parambhjq);
        return parambhjq;
      }
      afqs.a(afqs.o, parambhjq);
    }
    if (localAbsStructMsg.fwFlag != 1)
    {
      a(parambhjq, paramafrk, localMessageForStructing, localAbsStructMsg);
      bool = b(localMessageForStructing, localAbsStructMsg);
    }
    for (;;)
    {
      a(parambhjq, localMessageForStructing, localAbsStructMsg, paramafrk);
      if ((localSessionInfo.curType != 1008) || (parambhjq.a() == 0)) {
        afqs.a(afqs.e, parambhjq);
      }
      if ((localAbsStructMsg.mMsgServiceID == 14) || (localAbsStructMsg.mMsgServiceID == 84)) {
        bool = true;
      }
      if (bool) {
        afqs.a(afqs.h, parambhjq);
      }
      afqs.a(afqs.i, parambhjq);
      if ((localAbsStructMsg.mMsgServiceID != 49) && (localAbsStructMsg.mMsgServiceID != 106) && (localAbsStructMsg.mMsgServiceID != 14)) {
        afqs.a(afqs.d, parambhjq);
      }
      if (localAbsStructMsg.mMsgServiceID == 81) {
        ykv.a(paramafrk, localContext, localMessageForStructing, "press");
      }
      afqs.a(afqs.l, parambhjq);
      if (bflj.a(paramChatMessage)) {
        afqs.d(localMessageForStructing, parambhjq);
      }
      afqs.a(afqs.k, parambhjq);
      return parambhjq;
      afqs.b(localMessageForStructing, parambhjq);
    }
  }
  
  public boolean a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    String str = ahsj.a(paramChatMessage);
    MessageForStructing localMessageForStructing = (MessageForStructing)paramChatMessage;
    if (localMessageForStructing.structingMsg == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return false;
      localQQAppInterface = this.a.a();
      Context localContext = this.a.a();
      SessionInfo localSessionInfo = this.a.a;
      if (paramInt == 2131362198)
      {
        a(str, localMessageForStructing, localQQAppInterface, localContext);
        return true;
      }
      if (paramInt == 2131367213)
      {
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "structingMsgItem forward");
        }
        a(paramContext, str, localMessageForStructing, localQQAppInterface, localContext);
        return true;
      }
      if (paramInt == 2131365475)
      {
        d(paramChatMessage, str, localMessageForStructing, localQQAppInterface, localContext);
        return true;
      }
      if (paramInt == 2131371684)
      {
        c(paramChatMessage, str, localMessageForStructing, localQQAppInterface, localContext);
        return true;
      }
      if (paramInt == 2131366456)
      {
        b(paramChatMessage, str, localMessageForStructing, localQQAppInterface, localContext);
        return true;
      }
      if (paramInt == 2131365307)
      {
        a((MessageForStructing)paramChatMessage, localContext);
        return true;
      }
      if (paramInt == 2131371673)
      {
        this.a.d(paramChatMessage);
        return true;
      }
      if (paramInt == 2131367235)
      {
        a(paramContext, (MessageForStructing)paramChatMessage, localQQAppInterface, (Activity)localContext, localSessionInfo);
        return true;
      }
      if (paramInt == 2131371641)
      {
        a(paramChatMessage, str, localMessageForStructing, localQQAppInterface, localContext);
        return true;
      }
    } while (paramInt != 2131364266);
    paramContext = localQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
    if ((paramContext != null) && ((paramContext instanceof BaseTransProcessor))) {
      ((BaseTransProcessor)paramContext).cancel();
    }
    return true;
  }
  
  protected boolean a(@NonNull MessageForStructing paramMessageForStructing, @NonNull AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramMessageForStructing.istroop == 1)
    {
      if ((paramAbsStructMsg.mMsgServiceID != 23) && (paramAbsStructMsg.mMsgServiceID != 19) && (paramAbsStructMsg.mMsgServiceID != 60) && (!anvx.a(2131713969).equals(paramAbsStructMsg.getSourceName())))
      {
        bool1 = bool2;
        if (paramAbsStructMsg.mMsgUrl == null) {
          break label98;
        }
        if (!paramAbsStructMsg.mMsgUrl.startsWith("http://qqweb.qq.com/m/qunactivity"))
        {
          bool1 = bool2;
          if (!paramAbsStructMsg.mMsgUrl.startsWith("https://qqweb.qq.com/m/qunactivity")) {
            break label98;
          }
        }
      }
      bool1 = false;
    }
    label98:
    bool1 = a(paramMessageForStructing, paramAbsStructMsg, bool1);
    if (paramAbsStructMsg.mMsgServiceID == 49) {
      return false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiq
 * JD-Core Version:    0.7.0.1
 */