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
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.HexUtil;
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
import org.json.JSONObject;

public class agap
  extends aexf
{
  private long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131718027);
  private Map<Integer, agut> jdField_a_of_type_JavaUtilMap;
  protected boolean a;
  
  public agap(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    b();
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
      str = amtj.a(2131704451) + paramString + amtj.a(2131704452);
      if (!paramBoolean) {
        break label130;
      }
    }
    label130:
    for (int i = amtj.a(2131704456).length();; i = amtj.a(2131704455).length())
    {
      int j = paramString.length();
      paramString = new SpannableString(str);
      paramString.setSpan(new agax(this), i, i + j, 33);
      return paramString;
      str = amtj.a(2131704462) + paramString + amtj.a(2131704459);
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
    paramString1.setSpan(new agbj(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void a(ChatMessage paramChatMessage, aexg paramaexg, View paramView)
  {
    auca.a(paramChatMessage, paramaexg, paramView);
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
          Object localObject3 = (Bundle)bftm.a().a("SensMsgTipsCfg", "TailWording", i, j);
          if (localObject3 != null)
          {
            localObject1 = ((Bundle)localObject3).getString("0");
            paramString = ((Bundle)localObject3).getString("1");
          }
          Bundle localBundle = (Bundle)bftm.a().a("SensMsgTipsCfg", "Action", i, j);
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
                localObject4 = new agbp(this, str5, str2, i, j, str1, (Bundle)localObject4, str3, k, l, str4, m, str6);
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
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1002), new agvx());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1001), new agvy());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1004), new agup());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2030), new agvc());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1013), new agvc());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1018), new agve());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1019), new agvd());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1012), new agvw());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1047), new agvw());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2012), new agvq());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4001), new agux());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3008), new agur());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4005), new agug());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4020), new agvl());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2019), new agvs());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-7006), new agvr());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1026), new agwb());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1027), new agwc());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1014), new agui());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1015), new aguj());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3009), new agvi());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3010), new agvj());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3013), new aguh());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-3014), new agvz());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1016), new agun());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2041), new aguf());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1050), new aguq());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1018), new aguv());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1017), new aguo());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1041), new agvf());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1043), new agvt());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1045), new aguu());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5007), new agvk());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5000), new agva());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5001), new agva());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2037), new agva());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4010), new agvp());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5002), new aguw());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2024), new aguy());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2042), new aguy());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2043), new aguy());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2064), new aguy());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5005), new agvu());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-5006), new aguz());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1046), new agvn());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2027), new agvb());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4505), new agum());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4506), new aguk());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4507), new agul());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2029), new agvh());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2031), new agvm());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2034), new agus());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2049), new agus());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2033), new agvo());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2035), new agwa());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-1048), new agvg());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4021), new agwe());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-4022), new agwd());
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(-2063), new agvv());
  }
  
  private void e(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  protected aexg a()
  {
    return new agcc(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    agcc localagcc = (agcc)paramaexg;
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558895, null);
      localagcc.b = ((TextView)paramView.findViewById(2131367701));
      localObject = localagcc.b.getLayoutParams();
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
    localagcc.b.setMovementMethod(null);
    localagcc.b.setTextColor(localView.getResources().getColorStateList(2131167305));
    String str = paramMessageRecord.msg;
    Object localObject = (agut)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramMessageRecord.msgtype));
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = new agug();
    }
    paramView.a(this, paramMessageRecord, localagcc, paramafce, str, paramLinearLayout, this.jdField_a_of_type_AndroidContentContext);
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      int i = ((MessageForGrayTips)paramMessageRecord).getTextGravity();
      localagcc.b.setGravity(i);
    }
    for (;;)
    {
      a((ChatMessage)paramMessageRecord, paramaexg, localView);
      localagcc.b.setOnTouchListener(paramafce);
      localagcc.b.setOnLongClickListener(paramafce);
      localagcc.b.setMovementMethod(bhbw.a());
      return localView;
      localagcc.b.setGravity(19);
    }
  }
  
  public void a(afce paramafce, agcc paramagcc, String paramString)
  {
    b(paramagcc, paramString);
    paramagcc.b.setOnTouchListener(paramafce);
    paramagcc.b.setOnLongClickListener(paramafce);
  }
  
  public void a(agcc paramagcc)
  {
    SpannableString localSpannableString = aszt.a(BaseApplicationImpl.getContext().getString(2131697758), BaseApplicationImpl.getContext().getString(2131697757), new agar(this));
    paramagcc.b.setText(localSpannableString);
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setHighlightColor(17170445);
  }
  
  public void a(agcc paramagcc, String paramString)
  {
    paramString = paramString.split("\\|");
    if (paramString.length != 5) {
      return;
    }
    a(paramagcc.b, paramString[0], paramString[1], Integer.parseInt(paramString[2]), paramString[3], paramString[4]);
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
        } while ((paramView == null) || (!(paramView instanceof agcc)));
        paramView = (agcc)paramView;
        paramChatMessage = (MessageForQQWalletTips)paramChatMessage;
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramView.b == null));
      paramChatMessage.buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.b);
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  public void a(TextView paramTextView)
  {
    paramTextView.setText(BaseApplicationImpl.getContext().getString(2131718530));
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131718530));
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
              ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(HexUtil.hexStr2Bytes((String)localObject5));
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
                  break label1035;
                }
                bool1 = true;
                localObject3 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_need_mask");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  bool1 = Boolean.parseBoolean((String)localObject3);
                }
                if ((n == 0) && (bool1)) {
                  break label1035;
                }
                localObject3 = "1";
                bool3 = false;
                bool1 = false;
                bool2 = bool3;
                try
                {
                  localObject5 = paramTextView.getTag(2131377129);
                  if (localObject5 != null)
                  {
                    bool2 = bool3;
                    bool1 = ((Boolean)localObject5).booleanValue();
                  }
                  bool2 = bool1;
                  localObject5 = paramTextView.getTag(2131377128);
                  if (localObject5 == null) {
                    break label1029;
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
                  bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Mask", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131377129, Boolean.valueOf(true));
                }
                if ((!bool2) && (((String)localObject3).equalsIgnoreCase("1")))
                {
                  bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Show", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131377128, Boolean.valueOf(true));
                }
                bftm.a().a(null, "SensMsgTipsCfg", (String)localObject2, (String)localObject1);
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("sens_msg_id", i);
                  ((JSONObject)localObject1).put("sens_msg_attr", j);
                  ((JSONObject)localObject1).put("sens_msg_status", localObject3);
                  ((JSONObject)localObject1).put("sens_msg_phoe", paramMessageRecord);
                  ((JSONObject)localObject1).put("sens_msg_senderuin", localMessageRecord2.senderuin);
                  ((JSONObject)localObject1).put("sens_msg_sessiontype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
                  ((JSONObject)localObject1).put("sens_msg_peeruin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
                  ((JSONObject)localObject1).put("sens_msg_nickname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
                  ((JSONObject)localObject1).put("sens_msg_troopuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
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
        localMessageRecord2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(paramMessageRecord.frienduin, paramMessageRecord.istroop, l1);
      } while (localMessageRecord2 == null);
      paramMessageRecord = localMessageRecord2.getExtInfoFromExtStr("sens_msg_confirmed");
      if ((TextUtils.isEmpty(paramMessageRecord)) || (!paramMessageRecord.equalsIgnoreCase("1"))) {
        break label1055;
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
          break label209;
        }
        str2 = localObject[0].split("\\=")[1];
      }
      if (!str2.equals("1")) {
        break label217;
      }
      paramString = localObject[0];
      str1 = paramTextView.getResources().getString(2131719031);
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
          i = paramString.indexOf(paramTextView.getResources().getString(2131719031));
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
          paramString.setSpan(new agbc(this), i, ((String)localObject).length() + i, 33);
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
      label307:
      paramString = null;
    }
  }
  
  public void a(MessageForGrayTips paramMessageForGrayTips, agcc paramagcc)
  {
    paramMessageForGrayTips = paramMessageForGrayTips.getExtInfoFromExtStr("approval_subtype");
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131690101);
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new agby(this, paramMessageForGrayTips), 0, str.length(), 33);
    paramagcc.b.setHighlightColor(17170445);
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setText(localSpannableString);
  }
  
  public void a(MessageForSafeGrayTips paramMessageForSafeGrayTips, TextView paramTextView)
  {
    bftm.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SensMsgTipsCfg");
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
          bftm.a().a(null, "SensMsgTipsCfg", null, null);
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
  
  public void a(MessageRecord paramMessageRecord, afce paramafce, agcc paramagcc, String paramString)
  {
    int i = 2;
    String[] arrayOfString;
    int j;
    if ((paramString != null) && (paramString.length() > 0) && (paramString.charAt(0) == '\026'))
    {
      arrayOfString = paramString.split("\\|");
      String str = paramString;
      if (arrayOfString != null)
      {
        str = paramString;
        if (arrayOfString.length > 0) {
          str = arrayOfString[0].trim();
        }
      }
      a(paramafce, paramagcc, str);
      if ((str != null) && (str.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131695368))))
      {
        paramafce = bfyz.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (!paramafce.getBoolean(lcc.l, false))
        {
          paramString = new SpannableStringBuilder(paramagcc.b.getText().toString());
          paramString.setSpan(new ForegroundColorSpan(-12541697), 0, 8, 33);
          paramagcc.b.setText(paramString);
          paramString = new agav(this, paramMessageRecord.uniseq);
          paramagcc.b.setClickable(true);
          paramagcc.b.setOnClickListener(paramString);
          paramafce.edit().putLong("qav_score_msg_uniseq", paramMessageRecord.uniseq).commit();
        }
      }
      if (str != null)
      {
        boolean bool1 = str.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131695237));
        boolean bool2 = str.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131719500));
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "MessageRecord.MSG_TYPE_TEXT_VIDEO isEqualNotAccept:=" + bool1 + ",isEqualNetWorkBroken:=" + bool2);
        }
        if ((bool1) || (bool2))
        {
          if (bool1) {
            i = 1;
          }
          paramafce = new SpannableStringBuilder(paramagcc.b.getText().toString());
          paramString = new ForegroundColorSpan(-12541697);
          if (!bool1) {
            break label431;
          }
          j = 8;
          label367:
          if (!bool1) {
            break label438;
          }
        }
      }
    }
    label431:
    label438:
    for (int k = 14;; k = 15)
    {
      paramafce.setSpan(paramString, j, k, 33);
      paramagcc.b.setText(paramafce);
      paramMessageRecord = new agaw(this, paramMessageRecord, i);
      paramagcc.b.setClickable(true);
      paramagcc.b.setOnClickListener(paramMessageRecord);
      return;
      arrayOfString = null;
      break;
      j = 9;
      break label367;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, agcc paramagcc)
  {
    if (!(paramMessageRecord instanceof MessageForQQWalletTips)) {
      return;
    }
    ((MessageForQQWalletTips)paramMessageRecord).buildQQWalletTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagcc.b);
  }
  
  public void a(MessageRecord paramMessageRecord, agcc paramagcc, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsItemBuilder", 2, "getItemView msgtype:-5000 istroop:" + paramMessageRecord.istroop + " msg:" + bftf.a(paramString));
    }
    if ((paramMessageRecord instanceof MessageForNewGrayTips))
    {
      paramMessageRecord = (MessageForNewGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0)) {
        paramMessageRecord.buildTextView(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramagcc.b);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, afce paramafce, agcc paramagcc, String paramString)
  {
    if (paramMessageRecord.istroop == 0)
    {
      e(paramagcc.b, paramString);
      return;
    }
    b(paramMessageRecord, paramLinearLayout, paramafce, paramagcc, paramString);
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agcc paramagcc)
  {
    if ((paramMessageRecord instanceof MessageForNearbyMarketGrayTips))
    {
      paramLinearLayout = ((MessageForNearbyMarketGrayTips)paramMessageRecord).getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
      paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagcc.b.setText(paramLinearLayout);
      if (awhm.a(paramMessageRecord, "isFaceScoreGrayTips"))
      {
        if (!awhm.a(paramMessageRecord, "isFaceScoreSecondMember")) {
          break label112;
        }
        paramLinearLayout = "2";
        if (!awhm.a(paramMessageRecord, "isFaceScoreSpecialLike")) {
          break label119;
        }
        paramagcc = "2";
        awhm.a("exp_grey", paramMessageRecord.frienduin, new String[] { paramLinearLayout, "", "", paramagcc });
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
        paramagcc = "1";
      }
    }
    QLog.i("GrayTipsItemBuilder", 2, "nearby market gray tips msg is not validate");
  }
  
  public void a(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agcc paramagcc, String paramString)
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
        paramagcc.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramagcc.b));
        paramagcc.b.setClickable(true);
        paramagcc.b.setFocusable(true);
        paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
      b(paramagcc, paramString);
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
  
  public bgbb[] a(View paramView)
  {
    return new bgaz().a();
  }
  
  public void b(afce paramafce, agcc paramagcc, String paramString)
  {
    paramagcc.b.setText(a(paramString));
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setOnTouchListener(paramafce);
    paramagcc.b.setOnLongClickListener(paramafce);
  }
  
  public void b(agcc paramagcc, String paramString)
  {
    paramagcc.b.setText(paramString);
  }
  
  public void b(TextView paramTextView)
  {
    SpannableString localSpannableString = aszt.a(BaseApplicationImpl.getContext().getString(2131718528), BaseApplicationImpl.getContext().getString(2131718529), new agay(this));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setContentDescription(localSpannableString);
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsItemBuilder", 2, "handleSingleWayFriendAddAllowTipsItem hasReportAddAllowShow：" + this.jdField_a_of_type_Boolean + "  this:" + this);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800994B", "0X800994B", 0, 0, "", "", "", "");
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
    String str = amtj.a(2131704461);
    SpannableString localSpannableString = new SpannableString(paramMessageRecord + str);
    localSpannableString.setSpan(new agcd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), paramMessageRecord.length(), (paramMessageRecord + str).length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void b(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = amtj.a(2131704453);; paramString = paramString + amtj.a(2131704450))
    {
      String str = amtj.a(2131704441);
      Object localObject = amtj.a(2131704440);
      localObject = new SpannableString(paramString + str + (String)localObject);
      ((SpannableString)localObject).setSpan(new agbo(this), paramString.length(), (paramString + str).length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, agcc paramagcc)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = amtj.a(2131704449);
        paramMessageRecord = aszt.a(paramMessageRecord.msg + str + amtj.a(2131704439), str, new agaq(this));
        paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramagcc.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, agcc paramagcc, String paramString)
  {
    int i = paramMessageRecord.extraflag;
    int j = paramString.indexOf(paramMessageRecord.extStr);
    paramString = new SpannableString(paramString);
    paramString.setSpan(new agbw(this, i), j, paramMessageRecord.extStr.length() + j, 33);
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setText(paramString);
  }
  
  public void b(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, afce paramafce, agcc paramagcc, String paramString)
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
        paramagcc.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramagcc.b));
        paramagcc.b.setClickable(true);
        paramagcc.b.setFocusable(true);
        paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
      a(paramafce, paramagcc, paramString);
      return;
    }
  }
  
  public void b(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agcc paramagcc)
  {
    if ((paramMessageRecord instanceof ShareHotChatGrayTips))
    {
      paramMessageRecord = ((ShareHotChatGrayTips)paramMessageRecord).getHighlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
      paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagcc.b.setText(paramMessageRecord);
    }
  }
  
  public void c(afce paramafce, agcc paramagcc, String paramString)
  {
    a(paramafce, paramagcc, String.format(paramString, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick }));
  }
  
  public void c(agcc paramagcc, String paramString)
  {
    SpannableString localSpannableString = aszt.a(paramString, this.jdField_a_of_type_AndroidContentContext.getString(2131692404), new agbz(this));
    paramagcc.b.setText(localSpannableString);
    paramString = paramString.replace("TIM", "t i m");
    paramagcc.b.setContentDescription(paramString);
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setHighlightColor(17170445);
  }
  
  public void c(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131697971);
    String str = paramTextView.getResources().getString(2131719031);
    int i = ((String)localObject).indexOf(str);
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new agaz(this), i, str.length() + i, 33);
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
      int j = paramMessageRecord.msg.indexOf(amtj.a(2131704458));
      i = j;
      if (j < 0) {
        i = paramMessageRecord.msg.indexOf(amtj.a(2131704442));
      }
    } while (i < 0);
    SpannableString localSpannableString = new SpannableString(new SpannableString(paramMessageRecord.msg));
    localSpannableString.setSpan(new agch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public void c(TextView paramTextView, String paramString)
  {
    int j = paramString.indexOf(amtj.a(2131704445)) - 1;
    int k = paramString.indexOf(amtj.a(2131704460)) + 1;
    int i = j;
    if (j < 0) {
      i = 10;
    }
    paramString = new SpannableString(paramString);
    paramString.setSpan(new agce(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin), i, k, 33);
    paramString.setSpan(new ForegroundColorSpan(-12541697), i, k, 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString);
  }
  
  public void c(MessageRecord paramMessageRecord, agcc paramagcc)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = amtj.a(2131704446);
        paramMessageRecord = aszt.a(paramMessageRecord.msg + str, str, new agbf(this));
        paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramagcc.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void c(MessageRecord paramMessageRecord, agcc paramagcc, String paramString)
  {
    paramMessageRecord = aszt.a(paramString, this.jdField_a_of_type_AndroidContentContext.getString(2131690681), new agca(this, paramMessageRecord.getExtInfoFromExtStr("bat_process_tips_last_file_type")));
    paramagcc.b.setText(paramMessageRecord);
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setHighlightColor(17170445);
  }
  
  public void c(MessageRecord paramMessageRecord, LinearLayout paramLinearLayout, agcc paramagcc)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramagcc.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, paramagcc.b));
      paramagcc.b.setClickable(true);
      paramagcc.b.setFocusable(true);
      paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public void d(afce paramafce, agcc paramagcc, String paramString)
  {
    paramagcc.b.setText(a(paramString, false));
    paramagcc.b.setOnTouchListener(paramafce);
    paramagcc.b.setOnLongClickListener(paramafce);
  }
  
  public void d(agcc paramagcc, String paramString)
  {
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131697803);
    String str1 = str2;
    if (!paramString.contains(str2)) {
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131697766);
    }
    paramString = aszt.a(paramString, str1, new agcb(this));
    paramagcc.b.setText(paramString);
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setHighlightColor(17170445);
  }
  
  public void d(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131691645);
    int i = ((String)localObject).indexOf(paramTextView.getResources().getString(2131719031));
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new agbg(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void d(TextView paramTextView, String paramString)
  {
    paramTextView.setClickable(true);
    paramTextView.setText("" + "" + paramString);
  }
  
  public void d(MessageRecord paramMessageRecord, agcc paramagcc)
  {
    if ((paramMessageRecord instanceof MessageForGrayTips))
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0))
      {
        String str = amtj.a(2131704438);
        paramMessageRecord = aszt.a(paramMessageRecord.msg + str, str, new agbs(this));
        paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
        paramagcc.b.setText(paramMessageRecord);
      }
    }
  }
  
  public void d(MessageRecord paramMessageRecord, agcc paramagcc, String paramString)
  {
    bgny localbgny = bgny.a();
    String str2 = localbgny.a(paramMessageRecord.isSend(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
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
      paramMessageRecord = aszt.a(paramString, str1, new agat(this, str3, str2, paramMessageRecord, str4, localbgny));
      paramagcc.b.setText(paramMessageRecord);
      if (e) {
        paramagcc.b.setContentDescription(paramMessageRecord);
      }
      paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagcc.b.setHighlightColor(17170445);
      return;
    }
  }
  
  public void e(afce paramafce, agcc paramagcc, String paramString)
  {
    paramagcc.b.setText(a(paramString, true));
    paramagcc.b.setOnTouchListener(paramafce);
    paramagcc.b.setOnLongClickListener(paramafce);
  }
  
  public void e(agcc paramagcc, String paramString)
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
      paramString = aszt.a(paramString, str1, new agas(this, i, k, str2, j));
      paramagcc.b.setText(paramString);
    }
    for (;;)
    {
      paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagcc.b.setHighlightColor(17170445);
      return;
      QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP msg or clickText empty");
    }
  }
  
  public void e(TextView paramTextView)
  {
    Object localObject = amtj.a(2131704457);
    int j = ((String)localObject).indexOf(amtj.a(2131704448));
    int i = j;
    if (j < 0) {
      i = 10;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new agcf(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void e(MessageRecord paramMessageRecord, agcc paramagcc)
  {
    if ((paramMessageRecord instanceof MessageForIncompatibleGrayTips))
    {
      paramMessageRecord = (MessageForIncompatibleGrayTips)paramMessageRecord;
      Object localObject = paramMessageRecord.url;
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
      }
      SpannableString localSpannableString = new SpannableString(paramMessageRecord.msg);
      localObject = new agbv(this, (String)localObject);
      localSpannableString.setSpan(new ForegroundColorSpan(2131167226), paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
      localSpannableString.setSpan(localObject, paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
      paramagcc.b.setText(localSpannableString);
      paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramagcc.b.setHighlightColor(17170445);
    }
  }
  
  public void f(afce paramafce, agcc paramagcc, String paramString)
  {
    paramString = new QQText(paramString, 1);
    paramagcc.b.setText(paramString);
    paramagcc.b.setOnTouchListener(paramafce);
    paramagcc.b.setOnLongClickListener(paramafce);
  }
  
  public void f(agcc paramagcc, String paramString)
  {
    String str = bgnx.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = paramString.indexOf(str);
    str.length();
    if (i == -1) {}
    paramString = aszt.a(paramString, str, new agau(this));
    paramagcc.b.setText(paramString);
    if (e) {
      paramagcc.b.setContentDescription(paramString);
    }
    paramagcc.b.setMovementMethod(LinkMovementMethod.getInstance());
    paramagcc.b.setHighlightColor(17170445);
    VasWebviewUtil.reportVipKeywords("", "2", "", "", "", "", "", "", "", "");
  }
  
  public void f(TextView paramTextView)
  {
    Object localObject = amtj.a(2131704447);
    String str = "为TA设置特别消息提示音," + (String)localObject;
    int i = "为TA设置特别消息提示音,".length();
    int j = ((String)localObject).length() + i;
    localObject = new SpannableString(str);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-15036176), i, j, 33);
    ((SpannableString)localObject).setSpan(new agcg(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext), 0, j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void f(MessageRecord paramMessageRecord, agcc paramagcc)
  {
    paramMessageRecord = paramMessageRecord.msg;
    if (paramMessageRecord != null) {
      c(paramagcc.b, paramMessageRecord);
    }
  }
  
  public void g(agcc paramagcc, String paramString)
  {
    paramString = aszt.d(paramString);
    b(paramagcc, BaseApplicationImpl.getContext().getString(2131692152) + "\"" + paramString + "\"");
  }
  
  public void g(TextView paramTextView)
  {
    Object localObject = BaseApplicationImpl.getContext().getString(2131719372);
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131719373);
    int j = ((String)localObject).length() + str.indexOf(amtj.a(2131704443));
    int i = j;
    if (j < 0) {
      i = 20;
    }
    localObject = new SpannableString(new SpannableString((String)localObject + str));
    ((SpannableString)localObject).setSpan(new agbq(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void g(MessageRecord paramMessageRecord, agcc paramagcc)
  {
    if (!(paramMessageRecord instanceof MessageForDeliverGiftTips)) {
      return;
    }
    ((MessageForDeliverGiftTips)paramMessageRecord).buildDeliverGiftTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramagcc.b);
  }
  
  public void h(TextView paramTextView) {}
  
  public void i(TextView paramTextView)
  {
    Object localObject = amtj.a(2131704444);
    int j = ((String)localObject).indexOf("Q");
    int i = j;
    if (j < 0) {
      i = 11;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new agbr(this), i, j + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agap
 * JD-Core Version:    0.7.0.1
 */