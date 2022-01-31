import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.VideoConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.23;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import org.json.JSONObject;

public class afnq
  extends aepl
{
  private long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131719631);
  protected boolean a;
  
  public afnq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
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
      str = alud.a(2131705714) + paramString + alud.a(2131705715);
      if (!paramBoolean) {
        break label130;
      }
    }
    label130:
    for (int i = alud.a(2131705719).length();; i = alud.a(2131705718).length())
    {
      int j = paramString.length();
      paramString = new SpannableString(str);
      paramString.setSpan(new afoa(this), i, i + j, 33);
      return paramString;
      str = alud.a(2131705725) + paramString + alud.a(2131705722);
      break;
    }
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
    paramString1.setSpan(new afom(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void a(ChatMessage paramChatMessage, aepm paramaepm, View paramView)
  {
    aspt.a(paramChatMessage, paramaepm, paramView);
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    int i = 0;
    int j = 0;
    Object localObject1 = null;
    String str1 = null;
    String str2 = null;
    int m = 0;
    String str3 = null;
    String str4 = null;
    int k = 0;
    String str6 = null;
    long l = 0L;
    do
    {
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(paramString);
        if (!((JSONObject)localObject2).has("sens_msg_id")) {
          continue;
        }
        i = ((JSONObject)localObject2).getInt("sens_msg_id");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (((JSONObject)localObject2).has("sens_msg_attr")) {
        j = ((JSONObject)localObject2).getInt("sens_msg_attr");
      }
      paramString = (String)localObject1;
      if (((JSONObject)localObject2).has("sens_msg_status")) {
        paramString = ((JSONObject)localObject2).getString("sens_msg_status");
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (String str5 = "0";; str5 = paramString)
      {
        if (((JSONObject)localObject2).has("sens_msg_phoe")) {
          str1 = ((JSONObject)localObject2).getString("sens_msg_phoe");
        }
        if (((JSONObject)localObject2).has("sens_msg_senderuin")) {
          str2 = ((JSONObject)localObject2).getString("sens_msg_senderuin");
        }
        if (((JSONObject)localObject2).has("sens_msg_peeruin")) {
          str3 = ((JSONObject)localObject2).getString("sens_msg_peeruin");
        }
        if (((JSONObject)localObject2).has("sens_msg_nickname")) {
          str4 = ((JSONObject)localObject2).getString("sens_msg_nickname");
        }
        if (((JSONObject)localObject2).has("sens_msg_istroop")) {
          k = ((JSONObject)localObject2).getInt("sens_msg_istroop");
        }
        if (((JSONObject)localObject2).has("sens_msg_troopuin")) {
          str6 = ((JSONObject)localObject2).getString("sens_msg_troopuin");
        }
        if (((JSONObject)localObject2).has("sens_msg_uniseq")) {
          l = ((JSONObject)localObject2).getLong("sens_msg_uniseq");
        }
        if (((JSONObject)localObject2).has("sens_msg_sessiontype")) {
          m = ((JSONObject)localObject2).getInt("sens_msg_sessiontype");
        }
        if (((JSONObject)localObject2).has("sens_msg_default_wording")) {}
        for (localObject2 = ((JSONObject)localObject2).getString("sens_msg_default_wording");; localObject2 = null)
        {
          localObject1 = null;
          paramString = null;
          Object localObject3 = (Bundle)bdfc.a().a("SensMsgTipsCfg", "TailWording", i, j);
          if (localObject3 != null)
          {
            localObject1 = ((Bundle)localObject3).getString("0");
            paramString = ((Bundle)localObject3).getString("1");
          }
          Bundle localBundle = (Bundle)bdfc.a().a("SensMsgTipsCfg", "Action", i, j);
          Object localObject4 = paramString;
          localObject3 = localObject1;
          if (localBundle != null)
          {
            Iterator localIterator = localBundle.keySet().iterator();
            for (;;)
            {
              localObject4 = paramString;
              localObject3 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (String)localIterator.next();
              localObject4 = localBundle.getBundle((String)localObject3).getString("Name");
              String str7 = "$" + (String)localObject3;
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                if (((String)localObject1).contains(str7)) {
                  localObject3 = ((String)localObject1).replace(str7, (CharSequence)localObject4);
                }
              }
              localObject1 = localObject3;
              if (paramString != null)
              {
                localObject1 = localObject3;
                if (paramString.contains(str7))
                {
                  paramString = paramString.replace(str7, (CharSequence)localObject4);
                  localObject1 = localObject3;
                }
              }
            }
          }
          paramString = (String)localObject4;
          if (str5.equalsIgnoreCase("0")) {
            paramString = (String)localObject3;
          }
          localObject1 = paramString;
          if (i == 2)
          {
            localObject1 = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              localObject1 = paramString;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = localObject2;
              }
            }
            ThreadManager.post(new GrayTipsItemBuilder.23(this, str6, k, l, (String)localObject1), 5, null, false);
          }
          paramString = new SpannableString((CharSequence)localObject1);
          if (localBundle != null)
          {
            localObject2 = localBundle.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = localBundle.getBundle((String)((Iterator)localObject2).next());
              str5 = ((Bundle)localObject4).getString("Type");
              localObject3 = ((Bundle)localObject4).getString("Name");
              if ((((String)localObject1).indexOf((String)localObject3) >= 0) && ((!str5.equalsIgnoreCase("makePhoneCall")) || (!TextUtils.isEmpty(str1))))
              {
                localObject4 = new afos(this, str5, str2, i, j, str1, (Bundle)localObject4, str3, k, l, str4, m, str6);
                int i1 = ((String)localObject1).indexOf((String)localObject3);
                int n = i1;
                if (i1 < 0) {
                  n = 0;
                }
                paramString.setSpan(localObject4, n, ((String)localObject3).length() + n, 33);
              }
            }
          }
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
    } while (i > 0);
  }
  
  private void c(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.msg)) || (paramTextView == null)) {}
    int i;
    do
    {
      return;
      int j = paramMessageRecord.msg.indexOf(alud.a(2131705721));
      i = j;
      if (j < 0) {
        i = paramMessageRecord.msg.indexOf(alud.a(2131705705));
      }
    } while (i < 0);
    SpannableString localSpannableString = new SpannableString(new SpannableString(paramMessageRecord.msg));
    localSpannableString.setSpan(new afpi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  private void d(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = alud.a(2131705716);; paramString = paramString + alud.a(2131705713))
    {
      String str = alud.a(2131705704);
      Object localObject = alud.a(2131705703);
      localObject = new SpannableString(paramString + str + (String)localObject);
      ((SpannableString)localObject).setSpan(new afor(this), paramString.length(), (paramString + str).length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  private void e(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  private void f(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131691892);
    int i = ((String)localObject).indexOf(paramTextView.getResources().getString(2131720910));
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new afoj(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void g(TextView paramTextView)
  {
    Object localObject = BaseApplicationImpl.getContext().getString(2131721205);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131721206);
    int j = ((String)localObject).length() + str.indexOf(alud.a(2131705706));
    int i = j;
    if (j < 0) {
      i = 20;
    }
    localObject = new SpannableString(new SpannableString((String)localObject + str));
    ((SpannableString)localObject).setSpan(new afot(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void h(TextView paramTextView) {}
  
  private void i(TextView paramTextView)
  {
    Object localObject = alud.a(2131705707);
    int j = ((String)localObject).indexOf("Q");
    int i = j;
    if (j < 0) {
      i = 11;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new afou(this), i, j + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  protected aepm a()
  {
    return new afpd(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    afpd localafpd = (afpd)paramaepm;
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558817, null);
      localafpd.b = ((TextView)paramView.findViewById(2131367292));
      localObject = localafpd.b.getLayoutParams();
      localView = paramView;
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        localView = paramView;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != BaseChatItemLayout.x)
        {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = BaseChatItemLayout.x;
          localView = paramView;
        }
      }
    }
    localafpd.b.setMovementMethod(null);
    localafpd.b.setTextColor(localView.getResources().getColorStateList(2131167166));
    Object localObject = paramMessageRecord.msg;
    int i;
    switch (paramMessageRecord.msgtype)
    {
    default: 
      localafpd.b.setText((CharSequence)localObject);
    case -1002: 
    case -1001: 
      for (;;)
      {
        if ((paramMessageRecord instanceof MessageForGrayTips))
        {
          i = ((MessageForGrayTips)paramMessageRecord).getTextGravity();
          localafpd.b.setGravity(i);
          label652:
          a((ChatMessage)paramMessageRecord, paramaepm, localView);
          localafpd.b.setOnTouchListener(paramaetk);
          localafpd.b.setOnLongClickListener(paramaetk);
          localafpd.b.setMovementMethod(benv.a());
          return localView;
          paramView = null;
          if ((paramMessageRecord instanceof MessageForSafeGrayTips))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
            }
            paramView = (MessageForSafeGrayTips)paramMessageRecord;
          }
          a(paramView, localafpd.b);
          continue;
          if ((localObject != null) && (((String)localObject).length() > 0) && (((String)localObject).charAt(0) == '\026'))
          {
            paramView = ((String)localObject).split("\\|");
            label772:
            if ((paramView == null) || (paramView.length <= 0)) {
              break label4081;
            }
          }
        }
      }
    }
    label1072:
    label1114:
    label3181:
    label4081:
    for (paramView = paramView[0].trim();; paramView = (View)localObject)
    {
      localafpd.b.setText(paramView);
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      if ((paramView != null) && (paramView.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131696305))))
      {
        paramLinearLayout = bdne.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        if (!paramLinearLayout.getBoolean(VideoConstants.l, false))
        {
          localObject = new SpannableStringBuilder(localafpd.b.getText().toString());
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-12541697), 0, 8, 33);
          localafpd.b.setText((CharSequence)localObject);
          localObject = new afnr(this, paramMessageRecord.uniseq);
          localafpd.b.setClickable(true);
          localafpd.b.setOnClickListener((View.OnClickListener)localObject);
          paramLinearLayout.edit().putLong("qav_score_msg_uniseq", paramMessageRecord.uniseq).commit();
        }
      }
      if (paramView == null) {
        break;
      }
      boolean bool1 = paramView.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131696175));
      boolean bool2 = paramView.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131721328));
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "MessageRecord.MSG_TYPE_TEXT_VIDEO isEqualNotAccept:=" + bool1 + ",isEqualNetWorkBroken:=" + bool2);
      }
      if ((!bool1) && (!bool2)) {
        break;
      }
      if (bool1)
      {
        i = 1;
        paramView = new SpannableStringBuilder(localafpd.b.getText().toString());
        paramLinearLayout = new ForegroundColorSpan(-12541697);
        if (!bool1) {
          break label1188;
        }
        j = 8;
        if (!bool1) {
          break label1195;
        }
      }
      for (int k = 14;; k = 15)
      {
        paramView.setSpan(paramLinearLayout, j, k, 33);
        localafpd.b.setText(paramView);
        paramView = new afoi(this, paramMessageRecord, i);
        localafpd.b.setClickable(true);
        localafpd.b.setOnClickListener(paramView);
        break;
        paramView = null;
        break label772;
        i = 2;
        break label1072;
        j = 9;
        break label1114;
      }
      paramView = new bamp((CharSequence)localObject, 1);
      localafpd.b.setText(paramView);
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      if (paramMessageRecord.istroop == 0)
      {
        e(localafpd.b, (String)localObject);
        break;
      }
      paramView = null;
      if ((paramMessageRecord instanceof MessageForGrayTips))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
      }
      if (paramView != null)
      {
        localafpd.b.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localafpd.b));
        localafpd.b.setClickable(true);
        localafpd.b.setFocusable(true);
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        break;
      }
      localafpd.b.setText((CharSequence)localObject);
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      localafpd.b.setText(a((String)localObject, true));
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      localafpd.b.setText(a((String)localObject, false));
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      paramView = null;
      if ((paramMessageRecord instanceof MessageForGrayTips))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
      }
      if (paramView != null)
      {
        localafpd.b.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localafpd.b));
        localafpd.b.setClickable(true);
        localafpd.b.setFocusable(true);
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        break;
      }
      localafpd.b.setText((CharSequence)localObject);
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      paramView = String.format((String)localObject, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
      localafpd.b.setText(paramView);
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      localafpd.b.setText(a((CharSequence)localObject));
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      paramView = BaseApplicationImpl.getContext().getString(2131692514) + "\"" + (String)localObject + "\"";
      localafpd.b.setText(paramView);
      break;
      localafpd.b.setText((CharSequence)localObject);
      break;
      paramView = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      paramLinearLayout = paramView.getString("renewal_tail_click_text", null);
      i = paramView.getInt("renewal_tail_action", -1);
      int j = paramView.getInt("renewal_tail_tip_exit", -1);
      String str1 = paramView.getString("renewal_tail_activity_url", null);
      k = paramView.getInt("renewal_tail_item_id", -1);
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "MSG_TYPE_RENEWAL_TAIL_TIP, action=" + i + ", msg=" + (String)localObject + ", clickText=" + paramLinearLayout + ", expireFlag=" + j + ", activityUrl=" + str1);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramLinearLayout)))
      {
        paramView = arrr.a((String)localObject, paramLinearLayout, new afov(this, i, k, str1, j));
        localafpd.b.setText(paramView);
      }
      for (;;)
      {
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        localafpd.b.setHighlightColor(17170445);
        break;
        QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP msg or clickText empty");
      }
      a(localafpd.b);
      break;
      b(localafpd.b);
      break;
      g(localafpd.b);
      break;
      localafpd.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131721203));
      break;
      c(localafpd.b);
      break;
      a(localafpd.b, (String)localObject);
      break;
      paramView = arrr.a(BaseApplicationImpl.getContext().getString(2131698671), BaseApplicationImpl.getContext().getString(2131698670), new afow(this));
      localafpd.b.setText(paramView);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setHighlightColor(17170445);
      break;
      paramLinearLayout = this.jdField_a_of_type_AndroidContentContext.getString(2131698717);
      paramView = paramLinearLayout;
      if (!((String)localObject).contains(paramLinearLayout)) {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131698680);
      }
      paramView = arrr.a((String)localObject, paramView, new afox(this));
      localafpd.b.setText(paramView);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setHighlightColor(17170445);
      break;
      paramView = arrr.a((String)localObject, this.jdField_a_of_type_AndroidContentContext.getString(2131690763), new afoy(this, paramMessageRecord.getExtInfoFromExtStr("bat_process_tips_last_file_type")));
      localafpd.b.setText(paramView);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setHighlightColor(17170445);
      break;
      paramView = arrr.a((String)localObject, this.jdField_a_of_type_AndroidContentContext.getString(2131692784), new afoz(this));
      localafpd.b.setText(paramView);
      paramView = ((String)localObject).replace("TIM", "t i m");
      localafpd.b.setContentDescription(paramView);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setHighlightColor(17170445);
      break;
      d(localafpd.b, paramMessageRecord.extStr);
      break;
      paramView = ((MessageForGrayTips)paramMessageRecord).getExtInfoFromExtStr("approval_subtype");
      paramLinearLayout = this.jdField_a_of_type_AndroidContentContext.getString(2131690217);
      localObject = new SpannableString(paramLinearLayout);
      ((SpannableString)localObject).setSpan(new afpa(this, paramView), 0, paramLinearLayout.length(), 33);
      localafpd.b.setHighlightColor(17170445);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setText((CharSequence)localObject);
      break;
      i = paramMessageRecord.extraflag;
      j = ((String)localObject).indexOf(paramMessageRecord.extStr);
      paramView = new SpannableString((CharSequence)localObject);
      paramView.setSpan(new afpb(this, i), j, paramMessageRecord.extStr.length() + j, 33);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setText(paramView);
      break;
      b(localafpd.b, paramMessageRecord);
      break;
      f(localafpd.b);
      break;
      paramView = ((String)localObject).split("\\|");
      if (paramView.length != 5) {
        break;
      }
      a(localafpd.b, paramView[0], paramView[1], Integer.parseInt(paramView[2]), paramView[3], paramView[4]);
      break;
      d(localafpd.b);
      break;
      i(localafpd.b);
      break;
      paramView = paramMessageRecord.msg;
      if (paramView == null) {
        break;
      }
      b(localafpd.b, paramView);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView msgtype:-5000 istroop:" + paramMessageRecord.istroop + " msg:" + bdeu.a((String)localObject));
      }
      if (!(paramMessageRecord instanceof MessageForNewGrayTips)) {
        break;
      }
      paramView = (MessageForNewGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramView.buildTextView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localafpd.b);
      break;
      h(localafpd.b);
      break;
      if (!(paramMessageRecord instanceof MessageForIncompatibleGrayTips)) {
        break;
      }
      paramView = (MessageForIncompatibleGrayTips)paramMessageRecord;
      localObject = paramView.url;
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
      }
      paramLinearLayout = new SpannableString(paramView.msg);
      localObject = new afns(this, (String)localObject);
      paramLinearLayout.setSpan(new ForegroundColorSpan(2131167101), paramView.linkStart, paramView.linkEnd, 33);
      paramLinearLayout.setSpan(localObject, paramView.linkStart, paramView.linkEnd, 33);
      localafpd.b.setText(paramLinearLayout);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setHighlightColor(17170445);
      break;
      paramView = null;
      if ((paramMessageRecord instanceof MessageForGrayTips))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MSG_TYPE_CONFIGURABLE_GRAY_TIPS");
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
      }
      if (paramView != null)
      {
        localafpd.b.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localafpd.b));
        localafpd.b.setClickable(true);
        localafpd.b.setFocusable(true);
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        break;
      }
      localafpd.b.setText((CharSequence)localObject);
      break;
      e(localafpd.b);
      break;
      c(localafpd.b, (String)localObject);
      break;
      a(localafpd.b, paramMessageRecord);
      break;
      if ((paramMessageRecord instanceof MessageForNearbyMarketGrayTips))
      {
        paramView = ((MessageForNearbyMarketGrayTips)paramMessageRecord).getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        localafpd.b.setText(paramView);
        if (!auuc.a(paramMessageRecord, "isFaceScoreGrayTips")) {
          break;
        }
        if (auuc.a(paramMessageRecord, "isFaceScoreSecondMember"))
        {
          paramView = "2";
          if (!auuc.a(paramMessageRecord, "isFaceScoreSpecialLike")) {
            break label3181;
          }
        }
        for (paramLinearLayout = "2";; paramLinearLayout = "1")
        {
          auuc.a("exp_grey", paramMessageRecord.frienduin, new String[] { paramView, "", "", paramLinearLayout });
          break;
          paramView = "1";
          break label3123;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("GrayTipsItemBuilder", 2, "nearby market gray tips msg is not validate");
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramLinearLayout = alud.a(2131705701);
      paramView = arrr.a(paramView.msg + paramLinearLayout, paramLinearLayout, new afnt(this));
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramLinearLayout = alud.a(2131705709);
      paramView = arrr.a(paramView.msg + paramLinearLayout, paramLinearLayout, new afnw(this));
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramLinearLayout = alud.a(2131705712);
      paramView = arrr.a(paramView.msg + paramLinearLayout + alud.a(2131705702), paramLinearLayout, new afnx(this));
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForQQWalletTips)) {
        break;
      }
      ((MessageForQQWalletTips)paramMessageRecord).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localafpd.b);
      break;
      localafpd.b.setText((CharSequence)localObject);
      localafpd.b.setOnTouchListener(paramaetk);
      localafpd.b.setOnLongClickListener(paramaetk);
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      localafpd.b.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localafpd.b));
      localafpd.b.setClickable(true);
      localafpd.b.setFocusable(true);
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      if (!(paramMessageRecord instanceof ShareHotChatGrayTips)) {
        break;
      }
      paramView = ((ShareHotChatGrayTips)paramMessageRecord).getHighlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
      localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
      localafpd.b.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForDeliverGiftTips)) {
        break;
      }
      ((MessageForDeliverGiftTips)paramMessageRecord).buildDeliverGiftTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localafpd.b);
      break;
      a(paramMessageRecord, localafpd.b);
      break;
      paramLinearLayout = bdzy.a();
      str1 = paramLinearLayout.a(paramMessageRecord.isSend(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      String str2 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_open_url");
      String str3 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_keyword");
      paramView = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_highlight");
      i = ((String)localObject).indexOf(paramView);
      paramView.length();
      if (i == -1) {
        paramView = "";
      }
      for (;;)
      {
        paramView = arrr.a((String)localObject, paramView, new afny(this, str2, str1, paramMessageRecord, str3, paramLinearLayout));
        localafpd.b.setText(paramView);
        if (e) {
          localafpd.b.setContentDescription(paramView);
        }
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        localafpd.b.setHighlightColor(17170445);
        break;
        paramView = bdzx.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        i = ((String)localObject).indexOf(paramView);
        paramView.length();
        if (i == -1) {}
        paramView = arrr.a((String)localObject, paramView, new afnz(this));
        localafpd.b.setText(paramView);
        if (e) {
          localafpd.b.setContentDescription(paramView);
        }
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        localafpd.b.setHighlightColor(17170445);
        VasWebviewUtil.reportVipKeywords("", "2", "", "", "", "", "", "", "", "");
        break;
        if (!(paramMessageRecord instanceof MessageForGrayTips)) {
          break;
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
        localafpd.b.setText(paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localafpd.b));
        localafpd.b.setClickable(true);
        localafpd.b.setFocusable(true);
        localafpd.b.setMovementMethod(LinkMovementMethod.getInstance());
        break;
        c(localafpd.b, paramMessageRecord);
        break;
        localafpd.b.setGravity(19);
        break label652;
      }
    }
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
        } while ((paramView == null) || (!(paramView instanceof afpd)));
        paramView = (afpd)paramView;
        paramChatMessage = (MessageForQQWalletTips)paramChatMessage;
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramView.b == null));
      paramChatMessage.buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.b);
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  void a(TextView paramTextView)
  {
    paramTextView.setText(BaseApplicationImpl.getContext().getString(2131720223));
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131720223));
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
            int n;
            int j;
            boolean bool2;
            try
            {
              localObject3 = new bankcode_info.BankcodeCtrlInfo();
              j = k;
              ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(bdhe.a((String)localObject5));
              i = k;
              j = k;
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.has())
              {
                j = k;
                i = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.get();
              }
              j = i;
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).fromuin_phonenum.has())
              {
                j = i;
                paramMessageRecord = ((bankcode_info.BankcodeCtrlInfo)localObject3).fromuin_phonenum.get();
              }
            }
            catch (Exception localException4)
            {
              MessageRecord localMessageRecord2;
              int i1;
              int i3;
              int i2;
              Object localObject1;
              Object localObject5;
              Object localObject3;
              int m;
              boolean bool1;
              boolean bool3;
              k = 0;
              localMessageRecord1 = null;
              paramMessageRecord = null;
              localObject2 = null;
              int i = j;
              j = k;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_url.has()) {
                localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_url.get();
              }
            }
            catch (Exception localException5)
            {
              j = 0;
              localMessageRecord1 = null;
              localObject6 = null;
              localObject2 = paramMessageRecord;
              paramMessageRecord = localObject6;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_md5.has()) {
                localObject2 = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_md5.get();
              }
              m = i1;
            }
            catch (Exception localException6)
            {
              j = 0;
              localObject6 = null;
              localObject2 = paramMessageRecord;
              paramMessageRecord = localObject6;
              continue;
              bool2 = false;
              continue;
              String str = "0";
              continue;
              k = j;
              continue;
              k = 0;
              continue;
            }
            try
            {
              localObject5 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_attr");
              m = i1;
              bool1 = TextUtils.isEmpty((CharSequence)localObject5);
              if (bool1) {
                continue;
              }
              try
              {
                k = Integer.parseInt((String)localObject5);
                localObject3 = localObject2;
                j = k;
                localObject2 = localObject1;
                localObject1 = localObject3;
                if (j != 20) {
                  break label1033;
                }
                bool1 = true;
                localObject3 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_need_mask");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  bool1 = Boolean.parseBoolean((String)localObject3);
                }
                if ((n == 0) && (bool1)) {
                  break label1033;
                }
                localObject3 = "1";
                bool3 = false;
                bool1 = false;
                bool2 = bool3;
                try
                {
                  localObject5 = paramTextView.getTag(2131376437);
                  if (localObject5 != null)
                  {
                    bool2 = bool3;
                    bool1 = ((Boolean)localObject5).booleanValue();
                  }
                  bool2 = bool1;
                  localObject5 = paramTextView.getTag(2131376436);
                  if (localObject5 == null) {
                    break label1027;
                  }
                  bool2 = bool1;
                  bool3 = ((Boolean)localObject5).booleanValue();
                  bool2 = bool3;
                }
                catch (Exception localException7)
                {
                  Object localObject4;
                  localException7.printStackTrace();
                  bool3 = false;
                  bool1 = bool2;
                  bool2 = bool3;
                  continue;
                }
                if ((!bool1) && (((String)localObject3).equalsIgnoreCase("0")))
                {
                  azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Mask", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131376437, Boolean.valueOf(true));
                }
                if ((!bool2) && (((String)localObject3).equalsIgnoreCase("1")))
                {
                  azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Show", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131376436, Boolean.valueOf(true));
                }
                bdfc.a().a(null, "SensMsgTipsCfg", (String)localObject2, (String)localObject1);
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("sens_msg_id", i);
                  ((JSONObject)localObject1).put("sens_msg_attr", j);
                  ((JSONObject)localObject1).put("sens_msg_status", localObject3);
                  ((JSONObject)localObject1).put("sens_msg_phoe", paramMessageRecord);
                  ((JSONObject)localObject1).put("sens_msg_senderuin", localMessageRecord2.senderuin);
                  ((JSONObject)localObject1).put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                  ((JSONObject)localObject1).put("sens_msg_peeruin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
                  ((JSONObject)localObject1).put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
                  ((JSONObject)localObject1).put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
                  ((JSONObject)localObject1).put("sens_msg_istroop", localMessageRecord2.istroop);
                  ((JSONObject)localObject1).put("sens_msg_uniseq", localMessageRecord2.uniseq);
                  a(((JSONObject)localObject1).toString(), paramTextView);
                  return;
                }
                catch (Exception paramTextView)
                {
                  paramTextView.printStackTrace();
                  return;
                }
                localException1 = localException1;
                localException1.printStackTrace();
              }
              catch (Exception localException2)
              {
                m = i1;
                localException2.printStackTrace();
                k = i2;
                continue;
              }
              localException3.printStackTrace();
            }
            catch (Exception localException3)
            {
              j = m;
              localObject5 = localObject2;
              localObject2 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject5;
            }
            localObject4 = localException1;
            localObject5 = localObject2;
            MessageRecord localMessageRecord1 = paramMessageRecord;
            Object localObject2 = localObject4;
            paramMessageRecord = (MessageRecord)localObject5;
            continue;
            int k = i2;
            m = i1;
            if (((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.has())
            {
              m = i1;
              localObject4 = ((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.get().iterator();
              j = i3;
              k = j;
              m = j;
              if (((Iterator)localObject4).hasNext())
              {
                m = j;
                localObject5 = (bankcode_info.BankcodeElem)((Iterator)localObject4).next();
                m = j;
                if (((bankcode_info.BankcodeElem)localObject5).bankcode_attr.has())
                {
                  m = j;
                  k = ((bankcode_info.BankcodeElem)localObject5).bankcode_attr.get();
                  if (k > j)
                  {
                    j = k;
                    continue;
                  }
                }
                Object localObject6;
                n = 0;
              }
            }
          }
        }
        localMessageRecord2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, l1);
      } while (localMessageRecord2 == null);
      paramMessageRecord = localMessageRecord2.getExtInfoFromExtStr("sens_msg_confirmed");
      if ((TextUtils.isEmpty(paramMessageRecord)) || (!paramMessageRecord.equalsIgnoreCase("1"))) {
        break label1053;
      }
      n = 1;
      k = -1;
      i1 = 0;
      i3 = 0;
      i2 = 0;
      paramMessageRecord = null;
      localObject1 = null;
      localObject2 = null;
      localObject5 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty((CharSequence)localObject5));
    j = k;
  }
  
  void a(TextView paramTextView, String paramString)
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
          break label209;
        }
        str2 = localObject[0].split("\\=")[1];
      }
      if (!str2.equals("1")) {
        break label217;
      }
      paramString = localObject[0];
      str1 = paramTextView.getResources().getString(2131720910);
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
          i = paramString.indexOf(paramTextView.getResources().getString(2131720910));
        }
        for (;;)
        {
          if ((localObject == null) || (((String)localObject).trim().length() == 0) || (i < 0))
          {
            paramTextView.setText(paramString);
            return;
            label209:
            str2 = "1";
            break;
            label217:
            if (!str2.equals("2")) {
              break label307;
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
          paramString = new SpannableString(paramString);
          paramString.setSpan(new afof(this), i, ((String)localObject).length() + i, 33);
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
      label307:
      paramString = null;
    }
  }
  
  void a(MessageForSafeGrayTips paramMessageForSafeGrayTips, TextView paramTextView)
  {
    bdfc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SensMsgTipsCfg");
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
          bdfc.a().a(null, "SensMsgTipsCfg", null, null);
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("sens_msg_id", 2);
            localJSONObject.put("sens_msg_attr", i);
            localJSONObject.put("sens_msg_status", "0");
            localJSONObject.put("sens_msg_phoe", str1);
            localJSONObject.put("sens_msg_fromname", str2);
            localJSONObject.put("sens_msg_senderuin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localJSONObject.put("sens_msg_peeruin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
            localJSONObject.put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
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
  
  public bdpk[] a(View paramView)
  {
    return new bdpi().a();
  }
  
  void b(TextView paramTextView)
  {
    SpannableString localSpannableString = arrr.a(BaseApplicationImpl.getContext().getString(2131720221), BaseApplicationImpl.getContext().getString(2131720222), new afob(this));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setContentDescription(localSpannableString);
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsItemBuilder", 2, "handleSingleWayFriendAddAllowTipsItem hasReportAddAllowShow：" + this.jdField_a_of_type_Boolean + "  this:" + this);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800994B", "0X800994B", 0, 0, "", "", "", "");
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
    String str = alud.a(2131705724);
    SpannableString localSpannableString = new SpannableString(paramMessageRecord + str);
    localSpannableString.setSpan(new afpe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), paramMessageRecord.length(), (paramMessageRecord + str).length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void b(TextView paramTextView, String paramString)
  {
    int j = paramString.indexOf(alud.a(2131705708)) - 1;
    int k = paramString.indexOf(alud.a(2131705723)) + 1;
    int i = j;
    if (j < 0) {
      i = 10;
    }
    paramString = new SpannableString(paramString);
    paramString.setSpan(new afpf(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), i, k, 33);
    paramString.setSpan(new ForegroundColorSpan(-12541697), i, k, 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString);
  }
  
  void c(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131698871);
    String str = paramTextView.getResources().getString(2131720910);
    int i = ((String)localObject).indexOf(str);
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new afoc(this), i, str.length() + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void c(TextView paramTextView, String paramString)
  {
    paramTextView.setClickable(true);
    paramTextView.setText("" + "" + paramString);
  }
  
  public void d(TextView paramTextView)
  {
    Object localObject = alud.a(2131705720);
    int j = ((String)localObject).indexOf(alud.a(2131705711));
    int i = j;
    if (j < 0) {
      i = 10;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new afpg(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void e(TextView paramTextView)
  {
    Object localObject = alud.a(2131705710);
    String str = "为TA设置特别消息提示音," + (String)localObject;
    int i = "为TA设置特别消息提示音,".length();
    int j = ((String)localObject).length() + i;
    localObject = new SpannableString(str);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-15036176), i, j, 33);
    ((SpannableString)localObject).setSpan(new afph(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), 0, j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnq
 * JD-Core Version:    0.7.0.1
 */