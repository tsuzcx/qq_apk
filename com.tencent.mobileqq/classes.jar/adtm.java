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
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
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

public class adtm
  extends actq
  implements View.OnClickListener
{
  private HashSet<Long> a;
  
  public adtm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(10);
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<adtn> paramList)
  {
    paramLinearLayout.removeAllViews();
    int j = bbkx.b(12.0F);
    int k = bbkx.b(3.0F);
    int m = bbkx.b(8.0F);
    int n = bbkx.b(12.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(bbkx.b(12));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    adtn localadtn;
    if (i < i1)
    {
      localadtn = (adtn)paramList.get(i);
      if (TextUtils.isEmpty(localadtn.jdField_a_of_type_JavaLangString)) {
        break label303;
      }
      int i2 = (int)(((Paint)localObject).measureText(localadtn.jdField_a_of_type_JavaLangString) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(localadtn);
        paramInt = paramInt - i2 - n;
      }
    }
    label303:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localadtn);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (adtn)localArrayList.get(paramInt);
        paramList = new LabelTextView(this.jdField_a_of_type_AndroidContentContext);
        paramList.setParam(((adtn)localObject).jdField_a_of_type_Int, ((adtn)localObject).b, j);
        paramList.setTextSize(12);
        paramList.setText(((adtn)localObject).jdField_a_of_type_JavaLangString);
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
    localGradientDrawable.setCornerRadius(bbkx.a(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  private String a(String paramString)
  {
    return paramString.replaceAll("\n", " ").trim();
  }
  
  private void a(adto paramadto, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = paramadto.jdField_c_of_type_AndroidViewView;
    int i;
    Object localObject2;
    if (paramBoolean2)
    {
      i = -14474461;
      ((View)localObject1).setBackgroundDrawable(a(16, i));
      if (!(this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof acut)) {
        break label2081;
      }
      localObject1 = ((acut)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a;
      if (localObject1 == null) {
        break label2081;
      }
      localObject2 = ((baxk)localObject1).b(1, paramString, 6);
      if (localObject2 != null) {
        break label827;
      }
      if (((baxk)localObject1).a()) {
        break label2081;
      }
      ((baxk)localObject1).a(paramString, 1, true);
    }
    label1053:
    label2081:
    for (localObject1 = null;; localObject1 = null)
    {
      for (;;)
      {
        label93:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bbdr.b();
        }
        paramadto.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        paramadto.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692267));
        localObject2 = paramJSONObject.optString("age");
        i = paramJSONObject.optInt("gender");
        label177:
        label207:
        Object localObject3;
        label250:
        int j;
        label336:
        Object localObject4;
        if ((i == 1) || (i == 2)) {
          if (i == 1)
          {
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131694073);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label863;
            }
            localObject2 = (String)localObject1 + " ";
            localObject3 = new SpannableString((CharSequence)localObject2);
            if (i != 1) {
              break label888;
            }
            i = Color.rgb(0, 202, 252);
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845020);
            j = (int)(paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.getTextSize() * 0.8D + 0.5D);
            ((Drawable)localObject2).setBounds(0, 0, j, j);
            ((SpannableString)localObject3).setSpan(new ImageSpan((Drawable)localObject2, 1), 0, ((String)localObject1).length(), 17);
            paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.setText((CharSequence)localObject3);
            paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.setParam(i, -1, bbkx.a(8.0F));
            paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.setVisibility(0);
            if (paramJSONObject.optInt("matchTagId") <= 1) {
              break label932;
            }
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131698984);
            localObject3 = paramJSONObject.optString("matchTagName");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject1 = (String)localObject2 + ":" + (String)localObject3;
            }
            paramadto.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.setText((CharSequence)localObject1);
            paramadto.jdField_b_of_type_JavaLangString = ((String)localObject3);
            label423:
            paramadto.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.setParam(Color.rgb(129, 115, 255), -1, bbkx.a(8.0F));
            String str = paramJSONObject.optString("city");
            localObject4 = paramJSONObject.optString("school");
            localObject1 = paramJSONObject.optString("company");
            localObject3 = paramJSONObject.optString("constellation");
            localObject2 = "";
            if (!TextUtils.isEmpty(str)) {
              localObject2 = "" + str + " • ";
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label952;
            }
            localObject1 = (String)localObject2 + (String)localObject1 + " • ";
            label562:
            localObject2 = localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = (String)localObject1 + (String)localObject3 + " • ";
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label995;
            }
            paramadto.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            label619:
            localObject1 = paramadto.jdField_b_of_type_AndroidWidgetTextView;
            if (!paramBoolean2) {
              break label1053;
            }
            i = -1315851;
            label635:
            ((TextView)localObject1).setTextColor(i);
            localObject3 = paramJSONObject.optJSONArray("personalTags");
            localObject2 = null;
            localObject1 = localObject2;
            if (localObject3 == null) {
              break label1095;
            }
            localObject1 = localObject2;
            if (((JSONArray)localObject3).length() <= 0) {
              break label1095;
            }
            localObject1 = new ArrayList(((JSONArray)localObject3).length());
            if (!paramBoolean2) {
              break label1061;
            }
            i = 687208186;
            label699:
            if (!paramBoolean2) {
              break label1080;
            }
            j = -1;
          }
        }
        try
        {
          label707:
          int n = ((JSONArray)localObject3).length();
          int k = 0;
          label717:
          if (k < n)
          {
            localObject2 = ((JSONArray)localObject3).getJSONObject(k);
            if (localObject2 != null)
            {
              localObject4 = new adtn();
              ((adtn)localObject4).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("tagName");
              if (!((JSONObject)localObject2).optBoolean("tagSame", false)) {
                break label1088;
              }
            }
            for (int m = 671140604;; m = i)
            {
              ((adtn)localObject4).jdField_a_of_type_Int = m;
              ((adtn)localObject4).b = j;
              ((ArrayList)localObject1).add(localObject4);
              k += 1;
              break label717;
              if (paramBoolean3)
              {
                i = -657670;
                break;
              }
              i = -1;
              break;
              localObject1 = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
              break label93;
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692394);
              break label177;
              label863:
              localObject2 = (String)localObject1 + (String)localObject2;
              break label207;
              label888:
              i = Color.rgb(255, 128, 191);
              localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845018);
              break label250;
              paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.setVisibility(8);
              break label336;
              paramadto.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698985));
              break label423;
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label562;
              }
              localObject1 = (String)localObject2 + (String)localObject4 + " • ";
              break label562;
              label995:
              localObject1 = localObject2;
              if (((String)localObject2).length() > " • ".length()) {
                localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - " • ".length());
              }
              paramadto.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              paramadto.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              break label619;
              i = -7894119;
              break label635;
              if (paramBoolean3)
              {
                i = -1;
                break label699;
              }
              i = -657670;
              break label699;
              j = -14013910;
              break label707;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            label827:
            label1088:
            label1095:
            continue;
            label932:
            label952:
            i = 8;
            label1061:
            label1080:
            continue;
            paramadto.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            paramadto.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            paramadto.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramadto.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            i = -7894119;
            continue;
            if (paramBoolean3)
            {
              i = 134416410;
            }
            else
            {
              i = -1315339;
              continue;
              i = -16578534;
              continue;
              if (!TextUtils.isEmpty(localJSONException))
              {
                paramadto.jdField_e_of_type_AndroidViewView.setVisibility(0);
                paramadto.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698992));
                paramadto.jdField_d_of_type_AndroidWidgetTextView.setText(a(localJSONException));
              }
              else
              {
                paramadto.jdField_e_of_type_AndroidViewView.setVisibility(8);
                continue;
                if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
                {
                  localObject4 = (ViewGroup.MarginLayoutParams)paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.getLayoutParams();
                  if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(localJSONException)))
                  {
                    paramadto.jdField_e_of_type_AndroidViewView.setVisibility(0);
                    paramadto.jdField_e_of_type_AndroidViewView.setBackgroundDrawable(null);
                    paramadto.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                    paramadto.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                    ((ViewGroup.MarginLayoutParams)localObject4).bottomMargin = 0;
                    paramadto.jdField_e_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
                  }
                  for (;;)
                  {
                    paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
                    paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(3);
                    paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl((String)localObject3);
                    paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
                    paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
                    paramadto.jdField_a_of_type_JavaLangString = ((String)localObject3);
                    paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setTag(paramadto);
                    i = paramJSONObject.optInt("voiceDuration");
                    paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(i);
                    if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramadto.jdField_a_of_type_Long))) {
                      break;
                    }
                    a("", "0X800AA97", "", "");
                    break;
                    ((ViewGroup.MarginLayoutParams)localObject4).bottomMargin = bbkx.a(12.0F);
                  }
                  if (paramBoolean3)
                  {
                    i = -657670;
                  }
                  else
                  {
                    i = -1;
                    continue;
                    i = -7894119;
                    continue;
                    paramadto.jdField_d_of_type_AndroidViewView.setVisibility(8);
                    continue;
                    if (paramBoolean3) {
                      paramJSONObject = a(20, -1);
                    } else {
                      paramJSONObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839060);
                    }
                  }
                }
              }
            }
          }
        }
      }
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        i = bbkx.a() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298000) * 2 - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298001) * 2;
        j = a(i, paramadto.jdField_a_of_type_AndroidWidgetLinearLayout, (List)localObject1);
        if (j > 0)
        {
          paramadto.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (j < ((ArrayList)localObject1).size())
          {
            i = a(i, paramadto.jdField_b_of_type_AndroidWidgetLinearLayout, ((ArrayList)localObject1).subList(j, ((ArrayList)localObject1).size()));
            localObject1 = paramadto.jdField_b_of_type_AndroidWidgetLinearLayout;
            if (i > 0)
            {
              i = 0;
              ((LinearLayout)localObject1).setVisibility(i);
              localObject1 = paramJSONObject.optString("declaration");
              localObject2 = paramadto.jdField_c_of_type_AndroidWidgetTextView;
              if (!paramBoolean2) {
                continue;
              }
              i = -1712591883;
              ((TextView)localObject2).setTextColor(i);
              localObject2 = paramadto.jdField_e_of_type_AndroidViewView;
              if (!paramBoolean2) {
                continue;
              }
              i = -16777216;
              ((View)localObject2).setBackgroundDrawable(a(6, i));
              i = bbkx.a(12.0F);
              paramadto.jdField_e_of_type_AndroidViewView.setPadding(i, 0, i, 0);
              localObject2 = paramadto.jdField_d_of_type_AndroidWidgetTextView;
              if (!paramBoolean2) {
                continue;
              }
              i = -1;
              ((TextView)localObject2).setTextColor(i);
              paramadto.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              paramadto.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
              localObject2 = paramJSONObject.optString("signWords");
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              paramadto.jdField_e_of_type_AndroidViewView.setVisibility(0);
              paramadto.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131698990));
              paramadto.jdField_d_of_type_AndroidWidgetTextView.setText(a((String)localObject1));
              localObject3 = paramJSONObject.optString("voiceUrl");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                continue;
              }
              paramadto.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
              if (!paramBoolean1) {
                continue;
              }
              paramadto.jdField_d_of_type_AndroidViewView.setVisibility(0);
              localObject1 = paramadto.jdField_d_of_type_AndroidViewView;
              if (!paramBoolean2) {
                continue;
              }
              i = -14474461;
              ((View)localObject1).setBackgroundDrawable(a(16, i));
              localObject1 = paramadto.jdField_e_of_type_AndroidWidgetTextView;
              if (!paramBoolean2) {
                continue;
              }
              i = -1712591883;
              ((TextView)localObject1).setTextColor(i);
              paramJSONObject = paramJSONObject.optString("topic_msg");
              if (paramJSONObject != null) {
                paramadto.jdField_e_of_type_AndroidWidgetTextView.setText(paramJSONObject);
              }
              paramadto.jdField_c_of_type_JavaLangString = paramJSONObject;
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramadto.jdField_a_of_type_Long))) {
                a(paramString, "0X800AA94", paramadto.jdField_b_of_type_JavaLangString, paramJSONObject);
              }
              paramString = paramadto.f;
              if (!paramBoolean2) {
                continue;
              }
              paramJSONObject = a(20, 435549946);
              paramString.setBackgroundDrawable(paramJSONObject);
              if ((paramadto.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) && (paramadto.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0) && (paramadto.jdField_e_of_type_AndroidViewView.getVisibility() != 0))
              {
                paramadto.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramadto.jdField_b_of_type_AndroidWidgetTextView.setText(2131698991);
              }
              this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramadto.jdField_a_of_type_Long));
              return;
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString1, "qq_kuolie", paramString2, 0, 0, "", "", paramString3, paramString4);
  }
  
  protected actr a()
  {
    return new adto();
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    boolean bool3 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    Object localObject = (MessageForLimitChatTopic)paramMessageRecord;
    String str = ((MessageForLimitChatTopic)localObject).getExtInfoFromExtStr("match_chat_msg_data_key");
    paramLinearLayout = null;
    paramacxn = null;
    if (TextUtils.isEmpty(str))
    {
      paramLinearLayout = paramacxn;
      if ((paramactr instanceof adto)) {
        paramLinearLayout = (adto)paramactr;
      }
      if ((paramView != null) && (paramLinearLayout != null)) {
        break label810;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559192, null);
      paramLinearLayout = new adto();
      paramView.setTag(paramLinearLayout);
    }
    label810:
    for (;;)
    {
      paramView.findViewById(2131370165).setVisibility(8);
      paramView.findViewById(2131370166).setVisibility(8);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView = ((TopicTextView)paramView.findViewById(2131378378));
      paramLinearLayout.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363144);
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
          paramactr.b.append(((MessageForLimitChatTopic)localObject).msg);
          paramView.setContentDescription(paramactr.b.toString());
        }
        return paramView;
      }
      try
      {
        paramacxn = new JSONObject(str);
        if (paramacxn == null) {
          return new View(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      catch (JSONException paramacxn)
      {
        for (;;)
        {
          QLog.d("LimitChatTopicItemBuilder", 2, paramacxn, new Object[0]);
          paramacxn = null;
        }
        if ((paramactr instanceof adto)) {
          paramLinearLayout = (adto)paramactr;
        }
        if (paramView != null)
        {
          paramactr = paramLinearLayout;
          if (paramLinearLayout != null) {}
        }
        else
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559192, null);
          paramactr = new adto();
          paramView.setTag(paramactr);
        }
        boolean bool1 = false;
        if (paramacxn.optInt("matchTagId") <= 1) {
          bool1 = false;
        }
        boolean bool2;
        do
        {
          paramactr.jdField_a_of_type_Long = paramMessageRecord.uniseq;
          paramactr.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370165);
          paramactr.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370166);
          paramactr.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView = ((LabelTextView)paramView.findViewById(2131362190));
          paramactr.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetLabelTextView = ((LabelTextView)paramView.findViewById(2131369820));
          paramactr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371967));
          paramactr.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368870));
          paramactr.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131368871));
          paramactr.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377594));
          paramactr.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131364958);
          paramactr.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364959));
          paramactr.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364957));
          paramactr.f = ((TextView)paramView.findViewById(2131377593));
          paramactr.f.setTag(paramactr);
          paramactr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362949));
          paramactr.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131379300));
          paramactr.f.setOnClickListener(this);
          paramactr.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          paramView.findViewById(2131363144).setVisibility(8);
          bool2 = "2971".equals(ThemeUtil.getCurrentThemeId());
          a(paramactr, bool1, paramacxn, paramMessageRecord.frienduin, bool3, bool2);
          return paramView;
          localObject = ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a(paramMessageRecord.frienduin, false);
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
              paramactr.jdField_a_of_type_OrgJsonJSONObject = paramLinearLayout;
              paramactr.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = ((ExtendFriendUserInfo)localObject);
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
    aokq.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bblt[] a(View paramView)
  {
    return new bblt[0];
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
      if (!(localObject instanceof adto)) {
        continue;
      }
      paramView = (adto)localObject;
      if (paramView.jdField_d_of_type_AndroidViewView == null) {
        continue;
      }
      paramView.jdField_d_of_type_AndroidViewView.setVisibility(8);
      localObject = paramView.jdField_c_of_type_JavaLangString;
      if (localObject != null) {
        aaod.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject);
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
        if ((!(paramView instanceof ExtendFriendVoiceView)) || (!(localObject instanceof adto))) {
          continue;
        }
        localObject = (adto)localObject;
        paramView = (ExtendFriendVoiceView)paramView;
        if (paramView.b())
        {
          paramView.d();
          aokq.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).c();
        }
        for (;;)
        {
          a("", "0X800AA98", "", "");
          return;
          if (!TextUtils.isEmpty(((adto)localObject).jdField_a_of_type_JavaLangString))
          {
            paramView.c();
            aokq localaokq = aokq.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            localaokq.a(((adto)localObject).jdField_a_of_type_JavaLangString);
            localObject = localaokq.a();
            if ((localObject != null) && (localObject != paramView) && (((ExtendFriendVoiceView)localObject).b())) {
              ((ExtendFriendVoiceView)localObject).d();
            }
            localaokq.a(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtm
 * JD-Core Version:    0.7.0.1
 */