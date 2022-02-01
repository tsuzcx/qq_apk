import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.25;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class agtf
  extends afor
{
  private long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131718412);
  private Map<Integer, ahnr> jdField_a_of_type_JavaUtilMap;
  protected boolean a;
  
  public agtf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    b();
  }
  
  private int a(int paramInt, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.msgtail_id.has()) {
      paramInt = paramBankcodeCtrlInfo.msgtail_id.get();
    }
    return paramInt;
  }
  
  private int a(int paramInt, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (Exception paramBankcodeCtrlInfo)
      {
        paramBankcodeCtrlInfo.printStackTrace();
        return paramInt;
      }
      i = paramInt;
    } while (!paramBankcodeCtrlInfo.bankcode_elems.has());
    paramBankcodeCtrlInfo = paramBankcodeCtrlInfo.bankcode_elems.get().iterator();
    label106:
    for (;;)
    {
      i = paramInt;
      if (!paramBankcodeCtrlInfo.hasNext()) {
        break;
      }
      paramString = (bankcode_info.BankcodeElem)paramBankcodeCtrlInfo.next();
      if (paramString.bankcode_attr.has()) {}
      for (i = paramString.bankcode_attr.get();; i = 0)
      {
        if (i <= paramInt) {
          break label106;
        }
        paramInt = i;
        break;
      }
    }
  }
  
  private int a(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_sessiontype")) {
      paramInt = paramJSONObject.getInt("sens_msg_sessiontype");
    }
    return paramInt;
  }
  
  private long a(JSONObject paramJSONObject, long paramLong)
  {
    if (paramJSONObject.has("sens_msg_uniseq")) {
      paramLong = paramJSONObject.getLong("sens_msg_uniseq");
    }
    return paramLong;
  }
  
  @NotNull
  private ClickableSpan a(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString1, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6)
  {
    return new aguf(this, paramString6, paramString1, paramInt1, paramInt2, paramString4, paramBundle, paramString2, paramInt3, paramLong, paramString3, paramInt4, paramString5);
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    Pattern localPattern = Pattern.compile("<a.*?/a>");
    paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
    int i = 0;
    while (paramCharSequence.find(i))
    {
      Object localObject3 = Pattern.compile(">.*?</a>").matcher(paramCharSequence.group());
      Object localObject1 = null;
      while (((Matcher)localObject3).find())
      {
        localObject2 = ((Matcher)localObject3).group().replaceAll(">|</a>", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "标题：" + (String)localObject2);
          localObject1 = localObject2;
        }
      }
      Matcher localMatcher = Pattern.compile("href=.*?>").matcher(paramCharSequence.group());
      Object localObject2 = null;
      while (localMatcher.find())
      {
        localObject3 = localMatcher.group().replaceAll("href=|>", "");
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "网址：" + (String)localObject3);
          localObject2 = localObject3;
        }
      }
      if ((localObject1 != null) && (localObject2 != null))
      {
        localSpannableStringBuilder.replace(paramCharSequence.start(), paramCharSequence.end(), localObject1);
        localSpannableStringBuilder.setSpan(new URLSpan((String)localObject2), paramCharSequence.start(), paramCharSequence.start() + localObject1.length(), 33);
        i = paramCharSequence.start() + localObject1.length();
        paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
        paramCharSequence.reset();
      }
    }
    return localSpannableStringBuilder;
  }
  
  private CharSequence a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramBoolean)
    {
      str = anvx.a(2131704802) + paramString + anvx.a(2131704803);
      if (!paramBoolean) {
        break label130;
      }
    }
    label130:
    for (int i = anvx.a(2131704807).length();; i = anvx.a(2131704806).length())
    {
      int j = paramString.length();
      paramString = new SpannableString(str);
      paramString.setSpan(new agtn(this), i, i + j, 33);
      return paramString;
      str = anvx.a(2131704813) + paramString + anvx.a(2131704810);
      break;
    }
  }
  
  private String a(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if (paramInt1 == 2)
    {
      if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString2))) {}
      for (;;)
      {
        ThreadManager.post(new GrayTipsItemBuilder.25(this, paramString1, paramInt2, paramLong, paramString2), 5, null, false);
        return paramString2;
        paramString2 = paramString3;
      }
    }
    return paramString3;
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private String a(String paramString, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.msgtail_conf_file_md5.has()) {
      paramString = paramBankcodeCtrlInfo.msgtail_conf_file_md5.get();
    }
    return paramString;
  }
  
  private String a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_default_wording")) {
      paramString = paramJSONObject.getString("sens_msg_default_wording");
    }
    return paramString;
  }
  
  private void a(int paramInt)
  {
    int i = 1;
    if (paramInt == 3000) {
      i = 2;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("recv_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
        localJSONObject.put("recv_nick", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
        localJSONObject.put("recv_type", i);
        if (QLog.isColorLevel()) {
          QLog.d("PlusPanel", 2, "click HongBao:params=" + localJSONObject.toString());
        }
        Intent localIntent = new Intent(BaseApplicationImpl.getContext(), SendHbActivity.class);
        localIntent.putExtra("come_from", 2);
        localIntent.putExtra("app_info", "appid#1344242394|bargainor_id#1000030201|channel#graytips");
        localIntent.putExtra("extra_data", localJSONObject.toString());
        localIntent.putExtra("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "makeHongbao", "click", "groupType=" + i, 0, null));
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        return;
        if (paramInt != 1) {
          continue;
        }
        i = 3;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3, String paramString4, int paramInt4, String paramString5, long paramLong, Bundle paramBundle, String paramString6, SpannableString paramSpannableString)
  {
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = paramBundle.getBundle((String)localIterator.next());
        String str2 = ((Bundle)localObject).getString("Type");
        String str1 = ((Bundle)localObject).getString("Name");
        if ((paramString6.indexOf(str1) >= 0) && ((!str2.equalsIgnoreCase("makePhoneCall")) || (!TextUtils.isEmpty(paramString1))))
        {
          localObject = a(paramInt1, paramInt2, paramInt4, paramLong, paramString2, paramInt3, paramString3, paramString4, paramString1, paramString5, (Bundle)localObject, str2);
          int j = paramString6.indexOf(str1);
          int i = j;
          if (j < 0) {
            i = 0;
          }
          paramSpannableString.setSpan(localObject, i, str1.length() + i, 33);
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("Action");
    Object localObject;
    if (!TextUtils.isEmpty(str))
    {
      localObject = str;
      if (!TextUtils.isEmpty(str))
      {
        if (str.startsWith("http://")) {
          break label127;
        }
        paramBundle = "http://" + str;
      }
    }
    for (;;)
    {
      localObject = paramBundle;
      if (paramBundle.contains("?")) {}
      paramBundle = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramBundle.putExtra("url", (String)localObject);
      paramBundle.putExtra("hide_left_button", true);
      paramBundle.putExtra("show_right_close_button", true);
      paramBundle.putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramBundle);
      return;
      label127:
      paramBundle = str;
      if (!str.startsWith("https://")) {
        paramBundle = "https://" + str;
      }
    }
  }
  
  private void a(TextView paramTextView, MessageRecord paramMessageRecord, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("sens_msg_id", paramInt1);
      localJSONObject.put("sens_msg_attr", paramInt2);
      localJSONObject.put("sens_msg_status", paramString2);
      localJSONObject.put("sens_msg_phoe", paramString1);
      localJSONObject.put("sens_msg_senderuin", paramMessageRecord.senderuin);
      localJSONObject.put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      localJSONObject.put("sens_msg_peeruin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      localJSONObject.put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
      localJSONObject.put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
      localJSONObject.put("sens_msg_istroop", paramMessageRecord.istroop);
      localJSONObject.put("sens_msg_uniseq", paramMessageRecord.uniseq);
      a(localJSONObject.toString(), paramTextView);
      return;
    }
    catch (Exception paramTextView)
    {
      paramTextView.printStackTrace();
    }
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt)
  {
    if ((paramString2 == null) || (paramString2.trim().length() == 0) || (paramInt < 0))
    {
      paramTextView.setText(paramString1);
      return;
    }
    paramString1 = new SpannableString(paramString1);
    paramString1.setSpan(new agts(this), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramString1.length() < paramInt)
    {
      paramTextView.setText(new SpannableString(paramString1));
      return;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.insert(paramInt, paramString2);
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(new agtz(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void a(bkzi parambkzi)
  {
    parambkzi.a(new agtv(this, parambkzi));
  }
  
  private void a(ChatMessage paramChatMessage, afos paramafos, View paramView)
  {
    avhu.a(paramChatMessage, paramafos, paramView);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("isShowAd", false);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
    QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP, onClick, url null");
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((paramInt == 1) || (paramInt == 3000)) {
      paramString1 = ContactUtils.getNicknameInSession(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, paramString2);
    }
    paramString2 = new Intent(this.jdField_a_of_type_AndroidContentContext, TransactionActivity.class);
    paramString2.putExtra("come_from", 2);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("targetUin", paramString3);
      localJSONObject.put("targetNickname", paramString1);
      localJSONObject.put("sign", "");
      paramString2.putExtra("extra_data", localJSONObject.toString());
      paramString2.putExtra("app_info", "appid#20000001|bargainor_id#1000026901|channel#graytips");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      if ((paramInt != 1) && (paramInt != 3000)) {
        break label148;
      }
      paramString1 = ContactUtils.getNicknameInSession(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, paramString2);
    }
    label136:
    label148:
    for (int i = 0;; i = paramInt)
    {
      if ((i == 1006) && (paramString3 != null))
      {
        paramString2 = ContactUtils.getUinByPhoneNum(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3);
        if (paramString2 != null) {
          paramString4 = null;
        }
      }
      for (;;)
      {
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
        if (paramInt == 1006) {
          if (paramString5.compareToIgnoreCase("QQCall") != 0) {
            break label136;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ChatActivityUtils.a(localQQAppInterface, localActivity, i, paramString2, paramString1, paramString3, bool, paramString4, true, true, null, "from_internal");
          return;
          paramString3 = null;
          break;
        }
        paramString2 = paramString3;
      }
    }
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    for (;;)
    {
      int i;
      int j;
      String str6;
      String str1;
      String str2;
      String str3;
      String str4;
      int k;
      String str5;
      long l;
      int m;
      String str7;
      Bundle localBundle;
      Object localObject2;
      try
      {
        paramString = new JSONObject(paramString);
        i = d(paramString, 0);
        if (i <= 0) {
          return;
        }
        j = c(paramString, 0);
        str6 = b(g(paramString, null));
        str1 = f(paramString, null);
        str2 = e(paramString, null);
        str3 = d(paramString, null);
        str4 = c(paramString, null);
        k = b(paramString, 0);
        str5 = b(paramString, null);
        l = a(paramString, 0L);
        m = a(paramString, 0);
        str7 = a(paramString, null);
        paramString = (Bundle)bhce.a().a("SensMsgTipsCfg", "TailWording", i, j);
        if (paramString == null) {
          break label419;
        }
        localObject1 = paramString.getString("0");
        paramString = paramString.getString("1");
        localBundle = (Bundle)bhce.a().a("SensMsgTipsCfg", "Action", i, j);
        if (localBundle != null)
        {
          Iterator localIterator = localBundle.keySet().iterator();
          localObject3 = paramString;
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break label333;
          }
          localObject2 = (String)localIterator.next();
          localObject3 = localBundle.getBundle((String)localObject2).getString("Name");
          String str8 = "$" + (String)localObject2;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).contains(str8)) {
              localObject2 = ((String)localObject1).replace(str8, (CharSequence)localObject3);
            }
          }
          if ((paramString == null) || (!paramString.contains(str8))) {
            break label416;
          }
          paramString = paramString.replace(str8, (CharSequence)localObject3);
          localObject1 = localObject2;
          continue;
        }
        localObject2 = localObject1;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      Object localObject3 = paramString;
      label333:
      if (str6.equalsIgnoreCase("0")) {
        localObject3 = localObject2;
      }
      paramString = a(i, k, str5, l, str7, (String)localObject3);
      Object localObject1 = new SpannableString(paramString);
      a(i, j, str1, str2, m, str3, str4, k, str5, l, localBundle, paramString, (SpannableString)localObject1);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject1);
      return;
      label416:
      continue;
      label419:
      paramString = null;
      localObject1 = null;
    }
  }
  
  private boolean a(TextView paramTextView, boolean paramBoolean)
  {
    paramTextView = paramTextView.getTag(2131377402);
    if (paramTextView != null) {
      paramBoolean = ((Boolean)paramTextView).booleanValue();
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramBoolean = Boolean.parseBoolean(paramString);
    }
    return paramBoolean;
  }
  
  private int b(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_istroop")) {
      paramInt = paramJSONObject.getInt("sens_msg_istroop");
    }
    return paramInt;
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    return str;
  }
  
  private String b(String paramString, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.msgtail_conf_file_url.has()) {
      paramString = paramBankcodeCtrlInfo.msgtail_conf_file_url.get();
    }
    return paramString;
  }
  
  private String b(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_troopuin")) {
      paramString = paramJSONObject.getString("sens_msg_troopuin");
    }
    return paramString;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1002), new ahov());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1001), new ahow());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1004), new ahnn());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2030), new ahoa());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1013), new ahoa());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1018), new ahoc());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1019), new ahob());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1012), new ahou());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1047), new ahou());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2012), new ahoo());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4001), new ahnv());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3008), new ahnp());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4005), new ahne());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4020), new ahoj());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2019), new ahoq());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-7006), new ahop());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1026), new ahoz());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1027), new ahpa());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1014), new ahng());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1015), new ahnh());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3009), new ahog());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3010), new ahoh());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3013), new ahnf());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3014), new ahox());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1016), new ahnl());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2041), new ahnd());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1050), new ahno());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1018), new ahnt());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1017), new ahnm());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1041), new ahod());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1043), new ahor());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1045), new ahns());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5007), new ahoi());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5000), new ahny());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5001), new ahny());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2037), new ahny());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4010), new ahon());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5002), new ahnu());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2024), new ahnw());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2042), new ahnw());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2043), new ahnw());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2064), new ahnw());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5005), new ahos());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5006), new ahnx());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1046), new ahol());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2027), new ahnz());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4505), new ahnk());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4506), new ahni());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4507), new ahnj());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2029), new ahof());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2031), new ahok());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2034), new ahnq());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2049), new ahnq());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2033), new ahom());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2035), new ahoy());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1048), new ahoe());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4021), new ahpc());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4022), new ahpb());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2063), new ahot());
  }
  
  private boolean b(TextView paramTextView, boolean paramBoolean)
  {
    paramTextView = paramTextView.getTag(2131377403);
    if (paramTextView != null) {
      paramBoolean = ((Boolean)paramTextView).booleanValue();
    }
    return paramBoolean;
  }
  
  private boolean b(boolean paramBoolean, String paramString)
  {
    boolean bool = paramBoolean;
    if (!TextUtils.isEmpty(paramString))
    {
      bool = paramBoolean;
      if (paramString.equalsIgnoreCase("1")) {
        bool = true;
      }
    }
    return bool;
  }
  
  private int c(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_attr")) {
      paramInt = paramJSONObject.getInt("sens_msg_attr");
    }
    return paramInt;
  }
  
  private String c(String paramString, bankcode_info.BankcodeCtrlInfo paramBankcodeCtrlInfo)
  {
    if (paramBankcodeCtrlInfo.fromuin_phonenum.has()) {
      paramString = paramBankcodeCtrlInfo.fromuin_phonenum.get();
    }
    return paramString;
  }
  
  private String c(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_nickname")) {
      paramString = paramJSONObject.getString("sens_msg_nickname");
    }
    return paramString;
  }
  
  private void c()
  {
    Intent localIntent;
    if (!((gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).c())
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatTextSizeSettingActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_font", "", 1, 0, 0, "", "", "");
      return;
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("individuation_url_type", 40100);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bhnp.a(this.jdField_a_of_type_AndroidContentContext, "font", ""), 4096L, localIntent, false, -1);
    }
  }
  
  private int d(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject.has("sens_msg_id")) {
      paramInt = paramJSONObject.getInt("sens_msg_id");
    }
    return paramInt;
  }
  
  private String d(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_peeruin")) {
      paramString = paramJSONObject.getString("sens_msg_peeruin");
    }
    return paramString;
  }
  
  private void d()
  {
    if (!bhbx.a()) {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131718340), 0).show();
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_widget", "", 1, 0, 0, "", "", "");
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("individuation_url_type", 40100);
      localIntent.putExtra("vasUsePreWebview", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("url", bhnp.a(this.jdField_a_of_type_AndroidContentContext, "pendant", ""));
      localIntent.putExtra("business", 512L);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
      localIntent.putExtra("isShowAd", false);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
  
  private String e(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_senderuin")) {
      paramString = paramJSONObject.getString("sens_msg_senderuin");
    }
    return paramString;
  }
  
  private void e()
  {
    if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
      Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131719330), 0).show();
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_theme", "", 1, 0, 0, "", "", "");
      return;
      if (bhbx.a())
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("individuation_url_type", 40306);
        VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_AndroidContentContext, bhnp.a(this.jdField_a_of_type_AndroidContentContext, "theme", "mvip.gongneng.android.theme.index_dynamic_tab"), 32L, localIntent, true, -1);
      }
      else
      {
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131718340), 0).show();
      }
    }
  }
  
  private void e(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  private void e(MessageRecord paramMessageRecord, agus paramagus, String paramString)
  {
    int i = 2;
    ForegroundColorSpan localForegroundColorSpan;
    int j;
    if (paramString != null)
    {
      boolean bool1 = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131695454));
      boolean bool2 = paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131719952));
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "MessageRecord.MSG_TYPE_TEXT_VIDEO isEqualNotAccept:=" + bool1 + ",isEqualNetWorkBroken:=" + bool2);
      }
      if ((bool1) || (bool2))
      {
        if (bool1) {
          i = 1;
        }
        paramString = new SpannableStringBuilder(paramagus.b.getText().toString());
        localForegroundColorSpan = new ForegroundColorSpan(-12541697);
        if (!bool1) {
          break label200;
        }
        j = 8;
        if (!bool1) {
          break label207;
        }
      }
    }
    label200:
    label207:
    for (int k = 14;; k = 15)
    {
      paramString.setSpan(localForegroundColorSpan, j, k, 33);
      paramagus.b.setText(paramString);
      paramMessageRecord = new agtl(this, paramMessageRecord, i);
      paramagus.b.setClickable(true);
      paramagus.b.setOnClickListener(paramMessageRecord);
      return;
      j = 9;
      break;
    }
  }
  
  private String f(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_phoe")) {
      paramString = paramJSONObject.getString("sens_msg_phoe");
    }
    return paramString;
  }
  
  private void f()
  {
    EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 10, false, "");
    VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_emoji", "", 1, 0, 0, "", "", "");
  }
  
  private void f(MessageRecord paramMessageRecord, agus paramagus, String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131695585))))
    {
      paramString = bhhr.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (!paramString.getBoolean(lch.l, false))
      {
        Object localObject = new SpannableStringBuilder(paramagus.b.getText().toString());
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-12541697), 0, 8, 33);
        paramagus.b.setText((CharSequence)localObject);
        localObject = new agtm(this, paramMessageRecord.uniseq);
        paramagus.b.setClickable(true);
        paramagus.b.setOnClickListener((View.OnClickListener)localObject);
        paramString.edit().putLong("qav_score_msg_uniseq", paramMessageRecord.uniseq).commit();
      }
    }
  }
  
  private String g(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has("sens_msg_status")) {
      paramString = paramJSONObject.getString("sens_msg_status");
    }
    return paramString;
  }
  
  private void g()
  {
    bhnl localbhnl = (bhnl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.INDIVIDUATION_ABTEST_MANAGER);
    if (localbhnl.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      VasWebviewUtil.openIndividuationIndex(this.jdField_a_of_type_AndroidContentContext);
      VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_personality", "", 1, 0, 0, "", "", "");
      return;
      if (!TextUtils.isEmpty(localbhnl.jdField_a_of_type_JavaLangString)) {}
    }
  }
  
  protected afos a()
  {
    return new agus(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    agus localagus = (agus)paramafos;
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558922, null);
      localagus.b = ((TextView)paramView.findViewById(2131367837));
      localObject = localagus.b.getLayoutParams();
      localView = paramView;
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        localView = paramView;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != BaseChatItemLayout.y)
        {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = BaseChatItemLayout.y;
          localView = paramView;
        }
      }
    }
    localagus.b.setMovementMethod(null);
    localagus.b.setTextColor(localView.getResources().getColorStateList(2131167325));
    String str = paramMessageRecord.msg;
    Object localObject = (ahnr)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramMessageRecord.msgtype));
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = new ahne();
    }
    paramView.a(this, paramMessageRecord, localagus, paramaftk, str, paramLinearLayout, this.jdField_a_of_type_AndroidContentContext);
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      int i = ((MessageForGrayTips)paramMessageRecord).getTextGravity();
      localagus.b.setGravity(i);
    }
    for (;;)
    {
      a((ChatMessage)paramMessageRecord, paramafos, localView);
      localagus.b.setOnTouchListener(paramaftk);
      localagus.b.setOnLongClickListener(paramaftk);
      localagus.b.setMovementMethod(bimo.a());
      return localView;
      localagus.b.setGravity(19);
    }
  }
  
  public void a(aftk paramaftk, agus paramagus, String paramString)
  {
    b(paramagus, paramString);
    paramagus.b.setOnTouchListener(paramaftk);
    paramagus.b.setOnLongClickListener(paramaftk);
  }
  
  public void a(agus paramagus)
  {
    SpannableString localSpannableString = auea.a(BaseApplicationImpl.getContext().getString(2131698041), BaseApplicationImpl.getContext().getString(2131698040), new agth(this));
    paramagus.b.setText(localSpannableString);
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setHighlightColor(17170445);
  }
  
  public void a(agus paramagus, String paramString)
  {
    paramString = paramString.split("\\|");
    if (paramString.length != 5) {
      return;
    }
    a(paramagus.b, paramString[0], paramString[1], Integer.parseInt(paramString[2]), paramString[3], paramString[4]);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramInt == 890)
    {
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForQQWalletTips))) {}
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof agus)));
        paramView = (agus)paramView;
        paramChatMessage = (MessageForQQWalletTips)paramChatMessage;
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramView.b == null));
      paramChatMessage.buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.b);
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(TextView paramTextView)
  {
    paramTextView.setText(BaseApplicationImpl.getContext().getString(2131718916));
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131718916));
  }
  
  public void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype != -1046) {}
    do
    {
      do
      {
        return;
        long l1 = -1L;
        try
        {
          long l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("sens_msg_uniseq"));
          l1 = l2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            MessageRecord localMessageRecord;
            boolean bool1;
            Object localObject1;
            String str;
            bankcode_info.BankcodeCtrlInfo localBankcodeCtrlInfo;
            boolean bool2;
            localException1.printStackTrace();
          }
        }
        localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, l1);
      } while (localMessageRecord == null);
      bool1 = b(false, localMessageRecord.getExtInfoFromExtStr("sens_msg_confirmed"));
      i = -1;
      k = 0;
      localObject1 = null;
      str = null;
      localObject5 = localMessageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty((CharSequence)localObject5));
    paramMessageRecord = str;
    localObject3 = localObject1;
    j = i;
    try
    {
      localBankcodeCtrlInfo = new bankcode_info.BankcodeCtrlInfo();
      paramMessageRecord = str;
      localObject3 = localObject1;
      j = i;
      localBankcodeCtrlInfo.mergeFrom(HexUtil.hexStr2Bytes((String)localObject5));
      paramMessageRecord = str;
      localObject3 = localObject1;
      j = i;
      i = a(-1, localBankcodeCtrlInfo);
      paramMessageRecord = str;
      localObject3 = localObject1;
      j = i;
      localObject1 = c(null, localBankcodeCtrlInfo);
      paramMessageRecord = str;
      localObject3 = localObject1;
      j = i;
      str = b(null, localBankcodeCtrlInfo);
      paramMessageRecord = str;
      localObject3 = localObject1;
      j = i;
      localObject5 = a(null, localBankcodeCtrlInfo);
      localObject3 = localObject5;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        label286:
        localObject5 = null;
        i = j;
        localObject2 = localObject3;
        localObject3 = localObject5;
        localException2.printStackTrace();
        localObject4 = paramMessageRecord;
        localObject5 = localObject2;
        j = k;
        paramMessageRecord = localObject3;
        localObject2 = localObject4;
        localObject3 = localObject5;
      }
    }
    try
    {
      j = a(0, localBankcodeCtrlInfo, localMessageRecord.getExtInfoFromExtStr("sens_msg_attr"));
      paramMessageRecord = localObject3;
      localObject3 = localObject1;
      localObject1 = str;
      if (j != 20) {
        break label570;
      }
      bool2 = a(true, localMessageRecord.getExtInfoFromExtStr("sens_msg_need_mask"));
      if ((!bool1) && (bool2)) {
        break label570;
      }
      str = "1";
    }
    catch (Exception localException4)
    {
      paramMessageRecord = (MessageRecord)localObject4;
      localObject4 = localException4;
      break label515;
      localObject4 = "0";
      break label286;
    }
    bool1 = false;
    try
    {
      bool2 = b(paramTextView, false);
      bool1 = bool2;
      bool3 = a(paramTextView, false);
      bool1 = bool2;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Object localObject2;
        localException3.printStackTrace();
        boolean bool3 = false;
      }
    }
    if ((!bool1) && (str.equalsIgnoreCase("0")))
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord.senderuin, "Tips_Show", "Mask", i, j, Long.toString(localMessageRecord.msgUid), Long.toString(localMessageRecord.uniseq), "", "");
      paramTextView.setTag(2131377403, Boolean.valueOf(true));
    }
    if ((!bool3) && (str.equalsIgnoreCase("1")))
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord.senderuin, "Tips_Show", "Show", i, j, Long.toString(localMessageRecord.msgUid), Long.toString(localMessageRecord.uniseq), "", "");
      paramTextView.setTag(2131377402, Boolean.valueOf(true));
    }
    bhce.a().a(null, "SensMsgTipsCfg", (String)localObject1, paramMessageRecord);
    a(paramTextView, localMessageRecord, i, j, localObject3, str);
  }
  
  public void a(TextView paramTextView, String paramString)
  {
    String str1 = null;
    Object localObject;
    String str2;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = paramString.split("\\$");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTipMsg", 2, "splitResult is:" + Arrays.toString((Object[])localObject));
      }
      str2 = "";
      if (localObject.length >= 1)
      {
        if (!localObject[0].startsWith("ver=")) {
          break label193;
        }
        str2 = localObject[0].split("\\=")[1];
      }
      if (!str2.equals("1")) {
        break label201;
      }
      paramString = localObject[0];
      str1 = paramTextView.getResources().getString(2131719436);
    }
    for (;;)
    {
      label126:
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
        int i = paramString.indexOf((String)localObject);
        if ((str2.equals("1")) && (i < 0)) {
          i = paramString.indexOf(paramTextView.getResources().getString(2131719436));
        }
        for (;;)
        {
          a(paramTextView, paramString, (String)localObject, i);
          return;
          label193:
          str2 = "1";
          break;
          label201:
          if (!str2.equals("2")) {
            break label247;
          }
          if (localObject.length >= 3)
          {
            paramString = localObject[1];
            str1 = localObject[2];
            break label126;
          }
          paramString = localObject[1];
          break label126;
        }
      }
      label247:
      paramString = null;
    }
  }
  
  public void a(MessageForGrayTips paramMessageForGrayTips, agus paramagus)
  {
    paramMessageForGrayTips = paramMessageForGrayTips.getExtInfoFromExtStr("approval_subtype");
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131690139);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new aguo(this, paramMessageForGrayTips), 0, str.length(), 33);
    paramagus.b.setHighlightColor(17170445);
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setText(localSpannableString);
  }
  
  public void a(MessageForSafeGrayTips paramMessageForSafeGrayTips, TextView paramTextView)
  {
    bhce.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SensMsgTipsCfg");
    if ((paramMessageForSafeGrayTips == null) || (paramMessageForSafeGrayTips.safeInfo == null)) {
      return;
    }
    int j = 0;
    if (paramMessageForSafeGrayTips.safeInfo.strFromMobile.has()) {}
    for (String str1 = paramMessageForSafeGrayTips.safeInfo.strFromMobile.get();; str1 = null)
    {
      if (paramMessageForSafeGrayTips.safeInfo.strFromName.has()) {}
      for (String str2 = paramMessageForSafeGrayTips.safeInfo.strFromName.get();; str2 = null)
      {
        int i = j;
        if (paramMessageForSafeGrayTips.safeInfo.strMsgTxt.has()) {}
        try
        {
          i = Integer.parseInt(paramMessageForSafeGrayTips.safeInfo.strMsgTxt.get());
          bhce.a().a(null, "SensMsgTipsCfg", null, null);
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("sens_msg_id", 2);
            localJSONObject.put("sens_msg_attr", i);
            localJSONObject.put("sens_msg_status", "0");
            localJSONObject.put("sens_msg_phoe", str1);
            localJSONObject.put("sens_msg_fromname", str2);
            localJSONObject.put("sens_msg_senderuin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            localJSONObject.put("sens_msg_peeruin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
            localJSONObject.put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
            localJSONObject.put("sens_msg_istroop", paramMessageForSafeGrayTips.istroop);
            localJSONObject.put("sens_msg_uniseq", paramMessageForSafeGrayTips.uniseq);
            localJSONObject.put("sens_msg_default_wording", this.jdField_a_of_type_JavaLangString);
            a(localJSONObject.toString(), paramTextView);
            return;
          }
          catch (Exception paramMessageForSafeGrayTips)
          {
            paramMessageForSafeGrayTips.printStackTrace();
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = j;
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, aftk paramaftk, agus paramagus, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramString.charAt(0) == '\026')) {}
    for (String[] arrayOfString = paramString.split("\\|");; arrayOfString = null)
    {
      String str = paramString;
      if (arrayOfString != null)
      {
        str = paramString;
        if (arrayOfString.length > 0) {
          str = arrayOfString[0].trim();
        }
      }
      a(paramaftk, paramagus, str);
      f(paramMessageRecord, paramagus, str);
      e(paramMessageRecord, paramagus, str);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, agus paramagus)
  {
    if (!(paramMessageRecord instanceof MessageForQQWalletTips)) {
      return;
    }
    ((MessageForQQWalletTips)paramMessageRecord).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagus.b);
  }
  
  public void a(MessageRecord paramMessageRecord, agus paramagus, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsItemBuilder", 2, "getItemView msgtype:-5000 istroop:" + paramMessageRecord.istroop + " msg:" + bhbx.a(paramString));
    }
    if ((paramMessageRecord instanceof MessageForNewGrayTips))
    {
      paramMessageRecord = (MessageForNewGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0)) {
        paramMessageRecord.buildTextView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramagus.b);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, aftk paramaftk, agus paramagus, String paramString)
  {
    if (paramMessageRecord.istroop == 0)
    {
      e(paramagus.b, paramString);
      return;
    }
    b(paramMessageRecord, paramLinearLayout, paramaftk, paramagus, paramString);
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agus paramagus)
  {
    if ((paramMessageRecord instanceof MessageForNearbyMarketGrayTips))
    {
      paramLinearLayout = ((MessageForNearbyMarketGrayTips)paramMessageRecord).getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
      paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagus.b.setText(paramLinearLayout);
      if (axno.a(paramMessageRecord, "isFaceScoreGrayTips"))
      {
        if (!axno.a(paramMessageRecord, "isFaceScoreSecondMember")) {
          break label112;
        }
        paramLinearLayout = "2";
        if (!axno.a(paramMessageRecord, "isFaceScoreSpecialLike")) {
          break label119;
        }
        paramagus = "2";
        axno.a("exp_grey", paramMessageRecord.frienduin, new String[] { paramLinearLayout, "", "", paramagus });
      }
    }
    label112:
    label119:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        paramLinearLayout = "1";
        continue;
        paramagus = "1";
      }
    }
    QLog.i("GrayTipsItemBuilder", 2, "nearby market gray tips msg is not validate");
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agus paramagus, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MSG_TYPE_CONFIGURABLE_GRAY_TIPS");
      }
    }
    for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord != null)
      {
        paramagus.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramagus.b));
        paramagus.b.setClickable(true);
        paramagus.b.setFocusable(true);
        paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
      b(paramagus, paramString);
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, TextView paramTextView)
  {
    try
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, false, paramTextView));
      paramTextView.setGravity(3);
      return;
    }
    catch (Exception paramMessageRecord) {}
  }
  
  public bhjs[] a(View paramView)
  {
    return new bhjq().a();
  }
  
  public void b(aftk paramaftk, agus paramagus, String paramString)
  {
    paramagus.b.setText(a(paramString));
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setOnTouchListener(paramaftk);
    paramagus.b.setOnLongClickListener(paramaftk);
  }
  
  public void b(agus paramagus, String paramString)
  {
    paramagus.b.setText(paramString);
  }
  
  public void b(TextView paramTextView)
  {
    SpannableString localSpannableString = auea.a(BaseApplicationImpl.getContext().getString(2131718914), BaseApplicationImpl.getContext().getString(2131718915), new agto(this));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setContentDescription(localSpannableString);
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsItemBuilder", 2, "handleSingleWayFriendAddAllowTipsItem hasReportAddAllowShow：" + this.jdField_a_of_type_Boolean + "  this:" + this);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800994B", "0X800994B", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramMessageRecord.extStr)) {}
    do
    {
      return;
      paramMessageRecord = paramMessageRecord.extStr.split(":");
    } while (paramMessageRecord.length < 2);
    paramMessageRecord = String.format("你当前所在WiFi：%s，%s人正在热聊，", new Object[] { paramMessageRecord[0], paramMessageRecord[1] });
    String str = anvx.a(2131704812);
    SpannableString localSpannableString = new SpannableString(paramMessageRecord + str);
    localSpannableString.setSpan(new agut(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), paramMessageRecord.length(), (paramMessageRecord + str).length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void b(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = anvx.a(2131704804);; paramString = paramString + anvx.a(2131704801))
    {
      String str = anvx.a(2131704792);
      Object localObject = anvx.a(2131704791);
      localObject = new SpannableString(paramString + str + (String)localObject);
      ((SpannableString)localObject).setSpan(new ague(this), paramString.length(), (paramString + str).length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, agus paramagus)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = anvx.a(2131704800);
        paramMessageRecord = auea.a(paramMessageRecord.msg + str + anvx.a(2131704790), str, new agtg(this));
        paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramagus.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, agus paramagus, String paramString)
  {
    int i = paramMessageRecord.extraflag;
    int j = paramString.indexOf(paramMessageRecord.extStr);
    paramString = new SpannableString(paramString);
    paramString.setSpan(new agum(this, i), j, paramMessageRecord.extStr.length() + j, 33);
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setText(paramString);
  }
  
  public void b(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, aftk paramaftk, agus paramagus, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips)) {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
      }
    }
    for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      if (paramMessageRecord != null)
      {
        paramagus.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramagus.b));
        paramagus.b.setClickable(true);
        paramagus.b.setFocusable(true);
        paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
      a(paramaftk, paramagus, paramString);
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agus paramagus)
  {
    if ((paramMessageRecord instanceof ShareHotChatGrayTips))
    {
      paramMessageRecord = ((ShareHotChatGrayTips)paramMessageRecord).getHighlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
      paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagus.b.setText(paramMessageRecord);
    }
  }
  
  public void c(aftk paramaftk, agus paramagus, String paramString)
  {
    a(paramaftk, paramagus, String.format(paramString, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick }));
  }
  
  public void c(agus paramagus, String paramString)
  {
    SpannableString localSpannableString = auea.a(paramString, this.jdField_a_of_type_AndroidContentContext.getString(2131692506), new agup(this));
    paramagus.b.setText(localSpannableString);
    paramString = paramString.replace("TIM", "t i m");
    paramagus.b.setContentDescription(paramString);
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setHighlightColor(17170445);
  }
  
  public void c(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131698255);
    String str = paramTextView.getResources().getString(2131719436);
    int i = ((String)localObject).indexOf(str);
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new agtp(this), i, str.length() + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void c(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.msg)) || (paramTextView == null)) {}
    int i;
    do
    {
      return;
      int j = paramMessageRecord.msg.indexOf(anvx.a(2131704809));
      i = j;
      if (j < 0) {
        i = paramMessageRecord.msg.indexOf(anvx.a(2131704793));
      }
    } while (i < 0);
    SpannableString localSpannableString = new SpannableString(new SpannableString(paramMessageRecord.msg));
    localSpannableString.setSpan(new agux(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void c(TextView paramTextView, String paramString)
  {
    int j = paramString.indexOf(anvx.a(2131704796)) - 1;
    int k = paramString.indexOf(anvx.a(2131704811)) + 1;
    int i = j;
    if (j < 0) {
      i = 10;
    }
    paramString = new SpannableString(paramString);
    paramString.setSpan(new aguu(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), i, k, 33);
    paramString.setSpan(new ForegroundColorSpan(-12541697), i, k, 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString);
  }
  
  public void c(MessageRecord paramMessageRecord, agus paramagus)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = anvx.a(2131704797);
        paramMessageRecord = auea.a(paramMessageRecord.msg + str, str, new agtu(this));
        paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramagus.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void c(MessageRecord paramMessageRecord, agus paramagus, String paramString)
  {
    paramMessageRecord = auea.a(paramString, this.jdField_a_of_type_AndroidContentContext.getString(2131690758), new aguq(this, paramMessageRecord.getExtInfoFromExtStr("bat_process_tips_last_file_type")));
    paramagus.b.setText(paramMessageRecord);
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setHighlightColor(17170445);
  }
  
  public void c(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agus paramagus)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramagus.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramagus.b));
      paramagus.b.setClickable(true);
      paramagus.b.setFocusable(true);
      paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public void d(aftk paramaftk, agus paramagus, String paramString)
  {
    paramagus.b.setText(a(paramString, false));
    paramagus.b.setOnTouchListener(paramaftk);
    paramagus.b.setOnLongClickListener(paramaftk);
  }
  
  public void d(agus paramagus, String paramString)
  {
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131698086);
    String str1 = str2;
    if (!paramString.contains(str2)) {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698049);
    }
    paramString = auea.a(paramString, str1, new agur(this));
    paramagus.b.setText(paramString);
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setHighlightColor(17170445);
  }
  
  public void d(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131691730);
    int i = ((String)localObject).indexOf(paramTextView.getResources().getString(2131719436));
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new agtw(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void d(TextView paramTextView, String paramString)
  {
    paramTextView.setClickable(true);
    paramTextView.setText("" + "" + paramString);
  }
  
  public void d(MessageRecord paramMessageRecord, agus paramagus)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = anvx.a(2131704789);
        paramMessageRecord = auea.a(paramMessageRecord.msg + str, str, new agui(this));
        paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramagus.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void d(MessageRecord paramMessageRecord, agus paramagus, String paramString)
  {
    bhyi localbhyi = bhyi.a();
    String str2 = localbhyi.a(paramMessageRecord.isSend(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    String str3 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_open_url");
    String str4 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_keyword");
    String str1 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_highlight");
    int i = paramString.indexOf(str1);
    str1.length();
    if (i == -1) {
      str1 = "";
    }
    for (;;)
    {
      paramMessageRecord = auea.a(paramString, str1, new agtj(this, str3, str2, paramMessageRecord, str4, localbhyi));
      paramagus.b.setText(paramMessageRecord);
      if (e) {
        paramagus.b.setContentDescription(paramMessageRecord);
      }
      paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagus.b.setHighlightColor(17170445);
      return;
    }
  }
  
  public void e(aftk paramaftk, agus paramagus, String paramString)
  {
    paramagus.b.setText(a(paramString, true));
    paramagus.b.setOnTouchListener(paramaftk);
    paramagus.b.setOnLongClickListener(paramaftk);
  }
  
  public void e(agus paramagus, String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    String str1 = localSharedPreferences.getString("renewal_tail_click_text", null);
    int i = localSharedPreferences.getInt("renewal_tail_action", -1);
    int j = localSharedPreferences.getInt("renewal_tail_tip_exit", -1);
    String str2 = localSharedPreferences.getString("renewal_tail_activity_url", null);
    int k = localSharedPreferences.getInt("renewal_tail_item_id", -1);
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsItemBuilder", 2, "MSG_TYPE_RENEWAL_TAIL_TIP, action=" + i + ", msg=" + paramString + ", clickText=" + str1 + ", expireFlag=" + j + ", activityUrl=" + str2);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)))
    {
      paramString = auea.a(paramString, str1, new agti(this, i, k, str2, j));
      paramagus.b.setText(paramString);
    }
    for (;;)
    {
      paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagus.b.setHighlightColor(17170445);
      return;
      QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP msg or clickText empty");
    }
  }
  
  public void e(TextView paramTextView)
  {
    Object localObject = anvx.a(2131704808);
    int j = ((String)localObject).indexOf(anvx.a(2131704799));
    int i = j;
    if (j < 0) {
      i = 10;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new aguv(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void e(MessageRecord paramMessageRecord, agus paramagus)
  {
    if ((paramMessageRecord instanceof MessageForIncompatibleGrayTips))
    {
      paramMessageRecord = (MessageForIncompatibleGrayTips)paramMessageRecord;
      Object localObject = paramMessageRecord.url;
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
      }
      SpannableString localSpannableString = new SpannableString(paramMessageRecord.msg);
      localObject = new agul(this, (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131167240), paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
      localSpannableString.setSpan(localObject, paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
      paramagus.b.setText(localSpannableString);
      paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagus.b.setHighlightColor(17170445);
    }
  }
  
  public void f(aftk paramaftk, agus paramagus, String paramString)
  {
    paramString = new QQText(paramString, 1);
    paramagus.b.setText(paramString);
    paramagus.b.setOnTouchListener(paramaftk);
    paramagus.b.setOnLongClickListener(paramaftk);
  }
  
  public void f(agus paramagus, String paramString)
  {
    String str = bhyh.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = paramString.indexOf(str);
    str.length();
    if (i == -1) {}
    paramString = auea.a(paramString, str, new agtk(this));
    paramagus.b.setText(paramString);
    if (e) {
      paramagus.b.setContentDescription(paramString);
    }
    paramagus.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagus.b.setHighlightColor(17170445);
    VasWebviewUtil.reportVipKeywords("", "2", "", "", "", "", "", "", "", "");
  }
  
  public void f(TextView paramTextView)
  {
    Object localObject = anvx.a(2131704798);
    String str = "为TA设置特别消息提示音," + (String)localObject;
    int i = "为TA设置特别消息提示音,".length();
    int j = ((String)localObject).length() + i;
    localObject = new SpannableString(str);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-15036176), i, j, 33);
    ((SpannableString)localObject).setSpan(new aguw(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), 0, j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void f(MessageRecord paramMessageRecord, agus paramagus)
  {
    paramMessageRecord = paramMessageRecord.msg;
    if (paramMessageRecord != null) {
      c(paramagus.b, paramMessageRecord);
    }
  }
  
  public void g(agus paramagus, String paramString)
  {
    paramString = auea.d(paramString);
    b(paramagus, BaseApplicationImpl.getContext().getString(2131692242) + "\"" + paramString + "\"");
  }
  
  public void g(TextView paramTextView)
  {
    Object localObject = BaseApplicationImpl.getContext().getString(2131719795);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131719796);
    int j = ((String)localObject).length() + str.indexOf(anvx.a(2131704794));
    int i = j;
    if (j < 0) {
      i = 20;
    }
    localObject = new SpannableString(new SpannableString((String)localObject + str));
    ((SpannableString)localObject).setSpan(new agug(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void g(MessageRecord paramMessageRecord, agus paramagus)
  {
    if (!(paramMessageRecord instanceof MessageForDeliverGiftTips)) {
      return;
    }
    ((MessageForDeliverGiftTips)paramMessageRecord).buildDeliverGiftTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagus.b);
  }
  
  public void h(TextView paramTextView) {}
  
  public void i(TextView paramTextView)
  {
    Object localObject = anvx.a(2131704795);
    int j = ((String)localObject).indexOf("Q");
    int i = j;
    if (j < 0) {
      i = 11;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new aguh(this), i, j + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */