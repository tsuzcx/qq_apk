import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.LimitChatTopicItemBuilder.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.LabelTextView;
import com.tencent.mobileqq.limitchat.TopicTextView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class afpx
  extends aekw
  implements View.OnClickListener
{
  private HashSet<Long> a;
  
  public afpx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(10);
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<afpy> paramList)
  {
    paramLinearLayout.removeAllViews();
    int j = bdkf.b(8.0F);
    int k = bdkf.b(2.0F);
    int m = bdkf.b(8.0F);
    int n = bdkf.b(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(bdkf.b(12));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    afpy localafpy;
    if (i < i1)
    {
      localafpy = (afpy)paramList.get(i);
      if (TextUtils.isEmpty(localafpy.jdField_a_of_type_JavaLangCharSequence)) {
        break label307;
      }
      int i2 = (int)(((Paint)localObject).measureText(localafpy.jdField_a_of_type_JavaLangCharSequence.toString()) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(localafpy);
        paramInt = paramInt - i2 - n;
      }
    }
    label307:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localafpy);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (afpy)localArrayList.get(paramInt);
        paramList = new LabelTextView(this.jdField_a_of_type_AndroidContentContext);
        paramList.setParam(((afpy)localObject).jdField_a_of_type_Int, ((afpy)localObject).b, j);
        paramList.setTextSize(12);
        paramList.setText(((afpy)localObject).jdField_a_of_type_JavaLangCharSequence);
        paramList.setPadding(m, k, m, k);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        if (paramInt != 0) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = n;
        }
        paramLinearLayout.addView(paramList, (ViewGroup.LayoutParams)localObject);
        paramInt += 1;
      }
      return localArrayList.size();
    }
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(bdkf.a(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  private String a(String paramString)
  {
    return paramString.replaceAll("\n", " ").trim();
  }
  
  private void a(afpz paramafpz, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = paramafpz.jdField_c_of_type_AndroidViewView;
    int i;
    ArrayList localArrayList;
    Object localObject2;
    if (paramBoolean2)
    {
      i = -14474461;
      ((View)localObject1).setBackgroundDrawable(a(16, i));
      localArrayList = new ArrayList();
      if (!(this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof aelz)) {
        break label1797;
      }
      localObject1 = ((aelz)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a;
      if (localObject1 == null) {
        break label1797;
      }
      localObject2 = ((bcws)localObject1).b(1, paramString, 6);
      if (localObject2 != null) {
        break label1282;
      }
      if (((bcws)localObject1).a()) {
        break label1797;
      }
      ((bcws)localObject1).a(paramString, 1, true);
      localObject1 = null;
    }
    for (;;)
    {
      label102:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = bdda.b();
      }
      paramafpz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      paramafpz.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692343));
      localObject2 = paramJSONObject.optString("age");
      int k = paramJSONObject.optInt("gender");
      label186:
      label216:
      Object localObject3;
      label240:
      int j;
      if ((k == 1) || (k == 2))
      {
        if (k == 1)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131694190);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1318;
          }
          localObject2 = (String)localObject1 + " ";
          localObject3 = new SpannableString((CharSequence)localObject2);
          if (k != 1) {
            break label1348;
          }
          i = Color.parseColor("#3300CAFC");
          if (k != 1) {
            break label1359;
          }
          j = Color.parseColor("#02B2DD");
          label253:
          if (k != 1) {
            break label1370;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844641);
          label273:
          k = bdkf.a(11.0F);
          ((Drawable)localObject2).setBounds(0, 0, k, k);
          ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject2, 1), 0, ((String)localObject1).length(), 17);
          localObject1 = new afpy();
          ((afpy)localObject1).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject3);
          ((afpy)localObject1).jdField_a_of_type_Int = i;
          ((afpy)localObject1).b = j;
          localArrayList.add(localObject1);
        }
      }
      else
      {
        long l = paramJSONObject.optLong("popular");
        if (l > 0L)
        {
          i = bdkf.a(11.0F);
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844642);
          ((Drawable)localObject1).setBounds(0, 0, i, i);
          localObject2 = new ImageSpan((Drawable)localObject1, 1);
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getString(2131694190);
          localObject1 = new SpannableString((String)localObject3 + " " + l);
          ((SpannableString)localObject1).setSpan(localObject2, 0, ((String)localObject3).length(), 17);
          localObject2 = new afpy();
          ((afpy)localObject2).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
          ((afpy)localObject2).jdField_a_of_type_Int = Color.parseColor("#338173FF");
          ((afpy)localObject2).b = Color.parseColor("#8173FF");
          localArrayList.add(localObject2);
        }
        i = paramJSONObject.optInt("matchTagId");
        j = aqcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
        if (j != 0) {
          break label1388;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131699258);
        label559:
        String str1 = paramJSONObject.optString("city");
        String str2 = paramJSONObject.optString("constellation");
        j = 0;
        localObject2 = null;
        Object localObject4 = paramJSONObject.optJSONArray("shcoolInfos");
        localObject3 = localObject2;
        i = j;
        if (localObject4 != null)
        {
          localObject3 = localObject2;
          i = j;
          if (((JSONArray)localObject4).length() > 0)
          {
            localObject4 = ((JSONArray)localObject4).optJSONObject(0);
            localObject3 = localObject2;
            i = j;
            if (localObject4 != null)
            {
              if (((JSONObject)localObject4).optLong("shcool_state") != 2L) {
                break label1456;
              }
              i = 1;
              label660:
              localObject3 = ((JSONObject)localObject4).optString("shcool_name");
            }
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(str2)) {
          localObject2 = (String)localObject1 + " | " + str2;
        }
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str1)) {
          localObject1 = (String)localObject2 + " | " + str1;
        }
        paramafpz.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        localObject1 = paramafpz.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean2) {
          break label1462;
        }
        j = -1315851;
        label775:
        ((TextView)localObject1).setTextColor(j);
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label1486;
        }
        paramafpz.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        localObject1 = paramafpz.jdField_b_of_type_AndroidWidgetImageView;
        if (i == 0) {
          break label1470;
        }
        i = 2130844698;
        label815:
        ((ImageView)localObject1).setImageResource(i);
        localObject1 = paramafpz.jdField_c_of_type_AndroidWidgetTextView;
        if (!paramBoolean2) {
          break label1478;
        }
        i = -1315851;
        label838:
        ((TextView)localObject1).setTextColor(i);
        label845:
        localObject1 = paramJSONObject.optJSONArray("personalTags");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
          localArrayList.addAll(aqcw.a(this.jdField_a_of_type_AndroidContentContext, (JSONArray)localObject1));
        }
        if ((localArrayList == null) || (localArrayList.isEmpty())) {
          break label1538;
        }
        i = bdkf.a() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298021) * 2 - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298022) * 2;
        j = a(i, paramafpz.jdField_a_of_type_AndroidWidgetLinearLayout, localArrayList);
        if (j <= 0) {
          break label1526;
        }
        paramafpz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (j >= localArrayList.size()) {
          break label1514;
        }
        i = a(i, paramafpz.jdField_b_of_type_AndroidWidgetLinearLayout, localArrayList.subList(j, localArrayList.size()));
        localObject1 = paramafpz.jdField_b_of_type_AndroidWidgetLinearLayout;
        if (i <= 0) {
          break label1507;
        }
        i = 0;
        label1007:
        ((LinearLayout)localObject1).setVisibility(i);
        label1014:
        localObject1 = paramJSONObject.optString("declaration");
        localObject2 = paramJSONObject.optString("signWords");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1559;
        }
        paramafpz.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new baig(bjwp.d(a((String)localObject1)), 3, 24));
        label1066:
        localObject1 = paramJSONObject.optString("voiceUrl");
        i = paramJSONObject.optInt("voiceDuration");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1608;
        }
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
        label1101:
        if (!paramBoolean1) {
          break label1752;
        }
        paramafpz.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localObject1 = paramafpz.jdField_d_of_type_AndroidViewView;
        if (!paramBoolean2) {
          break label1725;
        }
        i = -14474461;
        label1128:
        ((View)localObject1).setBackgroundDrawable(a(16, i));
        localObject1 = paramafpz.jdField_d_of_type_AndroidWidgetTextView;
        if (!paramBoolean2) {
          break label1744;
        }
        i = -1712591883;
        label1157:
        ((TextView)localObject1).setTextColor(i);
        paramJSONObject = paramJSONObject.optString("topic_msg");
        if (paramJSONObject != null) {
          paramafpz.jdField_d_of_type_AndroidWidgetTextView.setText(paramJSONObject);
        }
        paramafpz.jdField_c_of_type_JavaLangString = paramJSONObject;
        if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramafpz.jdField_a_of_type_Long))) {
          a(paramString, "0X800AA94", paramafpz.jdField_b_of_type_JavaLangString, paramJSONObject);
        }
        label1220:
        paramString = paramafpz.e;
        if (!paramBoolean2) {
          break label1764;
        }
        paramJSONObject = a(20, 435549946);
      }
      for (;;)
      {
        paramString.setBackgroundDrawable(paramJSONObject);
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramafpz.jdField_a_of_type_Long));
        return;
        if (paramBoolean3)
        {
          i = -657670;
          break;
        }
        i = -1;
        break;
        label1282:
        localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
        break label102;
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692470);
        break label186;
        label1318:
        localObject2 = (String)localObject1 + " " + (String)localObject2;
        break label216;
        label1348:
        i = Color.parseColor("#33FF80BF");
        break label240;
        label1359:
        j = Color.parseColor("#FF80BF");
        break label253;
        label1370:
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844640);
        break label273;
        label1388:
        if (j == 1)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131699261);
          break label559;
        }
        if (i > 1)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131699319);
          paramafpz.jdField_b_of_type_JavaLangString = paramJSONObject.optString("matchTagName");
          break label559;
        }
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131699320);
        break label559;
        label1456:
        i = 0;
        break label660;
        label1462:
        j = -7894119;
        break label775;
        label1470:
        i = 2130844700;
        break label815;
        label1478:
        i = -7894119;
        break label838;
        label1486:
        paramafpz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramafpz.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label845;
        label1507:
        i = 8;
        break label1007;
        label1514:
        paramafpz.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label1014;
        label1526:
        paramafpz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label1014;
        label1538:
        paramafpz.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramafpz.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label1014;
        label1559:
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramafpz.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new baig(bjwp.d(a((String)localObject2)), 3, 24));
          break label1066;
        }
        paramafpz.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
        break label1066;
        label1608:
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
          break label1101;
        }
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(3);
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl((String)localObject1);
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
        paramafpz.jdField_a_of_type_JavaLangString = ((String)localObject1);
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setTag(paramafpz);
        paramafpz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(i);
        if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramafpz.jdField_a_of_type_Long))) {
          break label1101;
        }
        a("", "0X800AA97", "", "");
        break label1101;
        label1725:
        if (paramBoolean3)
        {
          i = -657670;
          break label1128;
        }
        i = -1;
        break label1128;
        label1744:
        i = -7894119;
        break label1157;
        label1752:
        paramafpz.jdField_d_of_type_AndroidViewView.setVisibility(8);
        break label1220;
        label1764:
        if (paramBoolean3) {
          paramJSONObject = a(20, -1);
        } else {
          paramJSONObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839141);
        }
      }
      label1797:
      localObject1 = null;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString1, "qq_kuolie", paramString2, 0, 0, "", "", paramString3, paramString4);
  }
  
  protected aekx a()
  {
    return new afpz();
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    boolean bool3 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    Object localObject = (MessageForLimitChatTopic)paramMessageRecord;
    String str = ((MessageForLimitChatTopic)localObject).getExtInfoFromExtStr("match_chat_msg_data_key");
    paramLinearLayout = null;
    paramaeov = null;
    if (TextUtils.isEmpty(str))
    {
      paramLinearLayout = paramaeov;
      if ((paramaekx instanceof afpz)) {
        paramLinearLayout = (afpz)paramaekx;
      }
      if ((paramView != null) && (paramLinearLayout != null)) {
        break label785;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559235, null);
      paramLinearLayout = new afpz();
      paramView.setTag(paramLinearLayout);
    }
    label785:
    for (;;)
    {
      paramView.findViewById(2131370430).setVisibility(8);
      paramView.findViewById(2131370431).setVisibility(8);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView = ((TopicTextView)paramView.findViewById(2131378985));
      paramLinearLayout.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363179);
      paramLinearLayout.jdField_a_of_type_Long = paramMessageRecord.uniseq;
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView.setTopicText(((MessageForLimitChatTopic)localObject).msg);
      paramLinearLayout.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (bool3) {}
      for (int i = Color.rgb(34, 34, 34);; i = -1)
      {
        paramMessageRecord = a(8, i);
        paramLinearLayout.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
        if (e)
        {
          paramaekx.b.append(((MessageForLimitChatTopic)localObject).msg);
          paramView.setContentDescription(paramaekx.b.toString());
        }
        return paramView;
      }
      try
      {
        paramaeov = new JSONObject(str);
        if (paramaeov == null) {
          return new View(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      catch (JSONException paramaeov)
      {
        for (;;)
        {
          QLog.d("LimitChatTopicItemBuilder", 2, paramaeov, new Object[0]);
          paramaeov = null;
        }
        if ((paramaekx instanceof afpz)) {
          paramLinearLayout = (afpz)paramaekx;
        }
        if (paramView != null)
        {
          paramaekx = paramLinearLayout;
          if (paramLinearLayout != null) {}
        }
        else
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559235, null);
          paramaekx = new afpz();
          paramView.setTag(paramaekx);
        }
        boolean bool1 = false;
        if (paramaeov.optInt("matchTagId") <= 1) {
          bool1 = false;
        }
        boolean bool2;
        do
        {
          paramaekx.jdField_a_of_type_Long = paramMessageRecord.uniseq;
          paramaekx.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370430);
          paramaekx.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370431);
          paramaekx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370083));
          paramaekx.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368889));
          paramaekx.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378925));
          paramaekx.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131379076));
          paramaekx.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369099));
          paramaekx.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369100));
          paramaekx.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378131));
          paramaekx.e = ((TextView)paramView.findViewById(2131378130));
          paramaekx.e.setTag(paramaekx);
          paramaekx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362983));
          paramaekx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131380006));
          paramaekx.e.setOnClickListener(this);
          paramaekx.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          paramView.findViewById(2131363179).setVisibility(8);
          bool2 = "2971".equals(ThemeUtil.getCurrentThemeId());
          a(paramaekx, bool1, paramaeov, paramMessageRecord.frienduin, bool3, bool2);
          return paramView;
          localObject = ((apwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a(paramMessageRecord.frienduin, false);
        } while (localObject == null);
        if (!TextUtils.isEmpty(((ExtendFriendUserInfo)localObject).miniProfileMsg)) {}
        for (;;)
        {
          for (;;)
          {
            try
            {
              paramLinearLayout = new JSONObject(((ExtendFriendUserInfo)localObject).miniProfileMsg);
              bool1 = paramLinearLayout.optBoolean("send_topic" + paramMessageRecord.uniseq, false);
              if (!bool1) {
                bool1 = true;
              }
            }
            catch (JSONException paramLinearLayout)
            {
              bool2 = false;
            }
            try
            {
              paramaekx.jdField_a_of_type_OrgJsonJSONObject = paramLinearLayout;
              paramaekx.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = ((ExtendFriendUserInfo)localObject);
            }
            catch (JSONException paramLinearLayout)
            {
              for (;;)
              {
                bool2 = bool1;
              }
            }
          }
          bool1 = false;
          continue;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("LimitChatTopicItemBuilder", 2, "" + paramLinearLayout);
            bool1 = bool2;
            continue;
            bool1 = false;
          }
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatTopicItemBuilder", 2, "destroy ");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    aqdn.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return new bdlb[0];
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      if (!(localObject instanceof afpz)) {
        continue;
      }
      paramView = (afpz)localObject;
      if (paramView.jdField_d_of_type_AndroidViewView == null) {
        continue;
      }
      paramView.jdField_d_of_type_AndroidViewView.setVisibility(8);
      localObject = paramView.jdField_c_of_type_JavaLangString;
      if (localObject != null) {
        acex.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject);
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (paramView.jdField_a_of_type_OrgJsonJSONObject != null)) {}
      try
      {
        paramView.jdField_a_of_type_OrgJsonJSONObject.put("send_topic" + paramView.jdField_a_of_type_Long, true);
        paramView.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.miniProfileMsg = paramView.jdField_a_of_type_OrgJsonJSONObject.toString();
        label158:
        ThreadManager.getSubThreadHandler().post(new LimitChatTopicItemBuilder.1(this, paramView));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800AA95", paramView.jdField_b_of_type_JavaLangString, (String)localObject);
        return;
        a("", "0X800AA96", "", "");
        paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, paramView, 0, 2);
        return;
        if ((!(paramView instanceof ExtendFriendVoiceView)) || (!(localObject instanceof afpz))) {
          continue;
        }
        localObject = (afpz)localObject;
        paramView = (ExtendFriendVoiceView)paramView;
        if (paramView.b())
        {
          paramView.d();
          aqdn.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).c();
        }
        for (;;)
        {
          a("", "0X800AA98", "", "");
          return;
          if (!TextUtils.isEmpty(((afpz)localObject).jdField_a_of_type_JavaLangString))
          {
            paramView.c();
            aqdn localaqdn = aqdn.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            localaqdn.a(((afpz)localObject).jdField_a_of_type_JavaLangString);
            localObject = localaqdn.a();
            if ((localObject != null) && (localObject != paramView) && (((ExtendFriendVoiceView)localObject).b())) {
              ((ExtendFriendVoiceView)localObject).d();
            }
            localaqdn.a(paramView);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        break label158;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpx
 * JD-Core Version:    0.7.0.1
 */