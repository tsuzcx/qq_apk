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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.LabelTextView;
import com.tencent.mobileqq.limitchat.TopicTextView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aghq
  extends aexf
  implements View.OnClickListener
{
  private HashSet<Long> a;
  
  public aghq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(10);
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<aghr> paramList)
  {
    paramLinearLayout.removeAllViews();
    int j = ViewUtils.dpToPx(12.0F);
    int k = ViewUtils.dpToPx(1.0F);
    int m = ViewUtils.dpToPx(8.0F);
    int n = ViewUtils.dpToPx(6.0F);
    Object localObject = new Paint();
    ((Paint)localObject).setTextSize(ViewUtils.dpToPx(12));
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i1 = paramList.size();
    int i = 0;
    aghr localaghr;
    if (i < i1)
    {
      localaghr = (aghr)paramList.get(i);
      if (TextUtils.isEmpty(localaghr.jdField_a_of_type_JavaLangCharSequence)) {
        break label307;
      }
      int i2 = (int)(((Paint)localObject).measureText(localaghr.jdField_a_of_type_JavaLangCharSequence.toString()) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(localaghr);
        paramInt = paramInt - i2 - n;
      }
    }
    label307:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localaghr);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (aghr)localArrayList.get(paramInt);
        paramList = new LabelTextView(this.jdField_a_of_type_AndroidContentContext);
        paramList.setParam(((aghr)localObject).jdField_a_of_type_Int, ((aghr)localObject).jdField_b_of_type_Int, j);
        paramList.setTextSize(12);
        paramList.setText(((aghr)localObject).jdField_a_of_type_JavaLangCharSequence);
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
    localGradientDrawable.setCornerRadius(ViewUtils.dip2px(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  @NotNull
  private String a(aghs paramaghs, JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("matchTagId");
    String str = "";
    if (ExtendFriendUserInfo.isTagIdFromSignalBomb(j))
    {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131698248);
      if (TextUtils.isEmpty(paramaghs.jdField_b_of_type_JavaLangString)) {
        paramaghs.jdField_b_of_type_JavaLangString = str;
      }
      return str;
    }
    if (paramaghs.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) {}
    for (int i = paramaghs.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.fromType;; i = 3)
    {
      if (i == 1)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131698142);
        break;
      }
      if (i == 2)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131698145);
        break;
      }
      if (i != 3) {
        break;
      }
      if (j > 1)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131698214);
        paramaghs.jdField_b_of_type_JavaLangString = paramJSONObject.optString("matchTagName");
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131698215);
      break;
    }
  }
  
  private String a(String paramString)
  {
    return paramString.replaceAll("\n", " ").trim();
  }
  
  private void a(aghs paramaghs, String paramString)
  {
    Object localObject;
    Bitmap localBitmap;
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof aezn))
    {
      localObject = ((aezn)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a;
      if (localObject != null)
      {
        localBitmap = ((FaceDecoder)localObject).getBitmapFromCacheFrom(1, paramString, 6);
        if (localBitmap == null)
        {
          if (((FaceDecoder)localObject).isPausing()) {
            break label112;
          }
          ((FaceDecoder)localObject).requestDecodeFace(paramString, 1, true);
          paramString = null;
        }
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = bfvo.b();
      }
      paramaghs.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramaghs.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131691991));
      return;
      paramString = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      continue;
      label112:
      paramString = null;
    }
  }
  
  private void a(aghs paramaghs, ArrayList<aghr> paramArrayList, JSONArray paramJSONArray)
  {
    int i = 0;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      paramArrayList.addAll(arop.a(this.jdField_a_of_type_AndroidContentContext, paramJSONArray));
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      int j = ViewUtils.getScreenWidth() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298179) * 2 - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298180) * 2;
      int k = a(j, paramaghs.jdField_a_of_type_AndroidWidgetLinearLayout, paramArrayList);
      if (k > 0)
      {
        paramaghs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (k < paramArrayList.size())
        {
          j = a(j, paramaghs.jdField_b_of_type_AndroidWidgetLinearLayout, paramArrayList.subList(k, paramArrayList.size()));
          paramaghs = paramaghs.jdField_b_of_type_AndroidWidgetLinearLayout;
          if (j > 0) {}
          for (;;)
          {
            paramaghs.setVisibility(i);
            return;
            i = 8;
          }
        }
        paramaghs.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      paramaghs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    paramaghs.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramaghs.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(aghs paramaghs, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("declaration");
    paramJSONObject = paramJSONObject.optString("signWords");
    if (!TextUtils.isEmpty(str))
    {
      paramaghs.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(a(str)), 3, 24));
      return;
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramaghs.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(a(paramJSONObject)), 3, 24));
      return;
    }
    paramaghs.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
  }
  
  private void a(aghs paramaghs, JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = 0;
    Object localObject2 = null;
    paramJSONObject = paramJSONObject.optJSONArray("shcoolInfos");
    Object localObject1 = localObject2;
    int i = j;
    if (paramJSONObject != null)
    {
      localObject1 = localObject2;
      i = j;
      if (paramJSONObject.length() > 0)
      {
        paramJSONObject = paramJSONObject.optJSONObject(0);
        localObject1 = localObject2;
        i = j;
        if (paramJSONObject != null)
        {
          if (paramJSONObject.optLong("shcool_state") != 2L) {
            break label292;
          }
          i = 1;
          localObject1 = paramJSONObject.optString("shcool_name");
        }
      }
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (paramJSONObject = paramString1 + " | " + paramString3;; paramJSONObject = paramString1)
    {
      if (paramInt >= 0)
      {
        paramString1 = arno.a(paramInt);
        label132:
        if (TextUtils.isEmpty(paramString1)) {
          break label347;
        }
        paramJSONObject = paramJSONObject + " | " + paramString1;
      }
      label265:
      label292:
      label312:
      label320:
      label328:
      label347:
      for (;;)
      {
        paramString1 = paramJSONObject;
        if (!TextUtils.isEmpty(paramString2)) {
          paramString1 = paramJSONObject + " | " + paramString2;
        }
        paramaghs.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
        paramJSONObject = paramaghs.jdField_b_of_type_AndroidWidgetTextView;
        if (paramBoolean)
        {
          paramInt = -1315851;
          label227:
          paramJSONObject.setTextColor(paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label328;
          }
          paramaghs.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          paramJSONObject = paramaghs.jdField_b_of_type_AndroidWidgetImageView;
          if (i == 0) {
            break label312;
          }
          paramInt = 2130845065;
          paramJSONObject.setImageResource(paramInt);
          paramaghs = paramaghs.jdField_c_of_type_AndroidWidgetTextView;
          if (!paramBoolean) {
            break label320;
          }
        }
        for (paramInt = -1315851;; paramInt = -7894119)
        {
          paramaghs.setTextColor(paramInt);
          return;
          i = 0;
          break;
          paramString1 = null;
          break label132;
          paramInt = -7894119;
          break label227;
          paramInt = 2130845066;
          break label265;
        }
        paramaghs.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramaghs.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
    }
  }
  
  private void a(aghs paramaghs, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = paramaghs.jdField_c_of_type_AndroidViewView;
    int i;
    if (paramBoolean2) {
      i = -14474461;
    }
    for (;;)
    {
      ((View)localObject).setBackgroundDrawable(a(16, i));
      localObject = new ArrayList();
      a(paramaghs, paramString);
      a((ArrayList)localObject, paramJSONObject.optString("age"), paramJSONObject.optInt("gender"));
      a((ArrayList)localObject, paramJSONObject.optLong("popular"));
      a(paramaghs, paramJSONObject, paramBoolean2, a(paramaghs, paramJSONObject), paramJSONObject.optString("city"), paramJSONObject.optString("constellation"), paramJSONObject.optInt("distance", -1));
      a(paramaghs, (ArrayList)localObject, paramJSONObject.optJSONArray("personalTags"));
      a(paramaghs, paramJSONObject);
      b(paramaghs, paramJSONObject);
      b(paramaghs, paramBoolean1, paramJSONObject, paramString, paramBoolean2, paramBoolean3);
      return;
      if (paramBoolean3) {
        i = -657670;
      } else {
        i = -1;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString1, "qq_kuolie", paramString2, 0, 0, "", "", paramString3, paramString4);
  }
  
  private void a(ArrayList<aghr> paramArrayList, long paramLong)
  {
    if (paramLong > 0L)
    {
      int i = ViewUtils.dip2px(11.0F);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845013);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131693568);
      localObject1 = new SpannableString(str + " " + paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
      localObject2 = new aghr();
      ((aghr)localObject2).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      ((aghr)localObject2).jdField_a_of_type_Int = Color.parseColor("#338173FF");
      ((aghr)localObject2).jdField_b_of_type_Int = Color.parseColor("#8173FF");
      paramArrayList.add(localObject2);
    }
  }
  
  private void a(ArrayList<aghr> paramArrayList, String paramString, int paramInt)
  {
    String str;
    label55:
    SpannableString localSpannableString;
    int i;
    label78:
    int j;
    if ((paramInt == 1) || (paramInt == 2))
    {
      if (paramInt != 1) {
        break label180;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131693568);
      if (!TextUtils.isEmpty(paramString)) {
        break label195;
      }
      paramString = str + " ";
      localSpannableString = new SpannableString(paramString);
      if (paramInt != 1) {
        break label223;
      }
      i = Color.parseColor("#3300CAFC");
      if (paramInt != 1) {
        break label234;
      }
      j = Color.parseColor("#02B2DD");
      label91:
      if (paramInt != 1) {
        break label245;
      }
    }
    label180:
    label195:
    label223:
    label234:
    label245:
    for (paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845012);; paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845011))
    {
      paramInt = ViewUtils.dip2px(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new aghr();
      paramString.jdField_a_of_type_JavaLangCharSequence = localSpannableString;
      paramString.jdField_a_of_type_Int = i;
      paramString.jdField_b_of_type_Int = j;
      paramArrayList.add(paramString);
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692108);
      break;
      paramString = str + " " + paramString;
      break label55;
      i = Color.parseColor("#33FF80BF");
      break label78;
      j = Color.parseColor("#FF80BF");
      break label91;
    }
  }
  
  private void b(aghs paramaghs, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("voiceUrl");
    int i = paramJSONObject.optInt("voiceDuration");
    if (TextUtils.isEmpty(str)) {
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity));
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(3);
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(str);
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      paramaghs.jdField_a_of_type_JavaLangString = str;
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setTag(paramaghs);
      paramaghs.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(i);
    } while (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramaghs.jdField_a_of_type_Long)));
    a("", "0X800AA97", "", "");
  }
  
  private void b(aghs paramaghs, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramJSONObject = paramJSONObject.optString("topic_msg");
    int i;
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramJSONObject)))
    {
      paramaghs.jdField_d_of_type_AndroidViewView.setVisibility(0);
      Object localObject = paramaghs.jdField_d_of_type_AndroidViewView;
      if (paramBoolean2)
      {
        i = -14474461;
        ((View)localObject).setBackgroundDrawable(a(16, i));
        localObject = paramaghs.jdField_d_of_type_AndroidWidgetTextView;
        if (!paramBoolean2) {
          break label200;
        }
        i = -1712591883;
        label72:
        ((TextView)localObject).setTextColor(i);
        paramaghs.jdField_d_of_type_AndroidWidgetTextView.setText(paramJSONObject);
        paramaghs.jdField_c_of_type_JavaLangString = paramJSONObject;
        label92:
        if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramaghs.jdField_a_of_type_Long)))
        {
          localObject = paramaghs.jdField_b_of_type_JavaLangString;
          if (paramaghs.jdField_b_of_type_Int != 1) {
            break label220;
          }
          paramJSONObject = (JSONObject)localObject;
          label126:
          a(paramString, "0X800AA94", (String)localObject, paramJSONObject);
        }
        paramString = paramaghs.e;
        if (!paramBoolean2) {
          break label238;
        }
        paramJSONObject = a(20, 435549946);
      }
    }
    for (;;)
    {
      paramString.setBackgroundDrawable(paramJSONObject);
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramaghs.jdField_a_of_type_Long));
      return;
      if (paramBoolean3)
      {
        i = -657670;
        break;
      }
      i = -1;
      break;
      label200:
      i = -7894119;
      break label72;
      paramaghs.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break label92;
      label220:
      if (TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramaghs.jdField_b_of_type_JavaLangString;
        break label126;
      }
      break label126;
      label238:
      if (paramBoolean3) {
        paramJSONObject = a(20, -1);
      } else {
        paramJSONObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839360);
      }
    }
  }
  
  protected aexg a()
  {
    return new aghs();
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    boolean bool4 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)paramMessageRecord;
    String str = localMessageForLimitChatTopic.getExtInfoFromExtStr("match_chat_msg_data_key");
    paramLinearLayout = null;
    paramafce = null;
    if (TextUtils.isEmpty(str))
    {
      paramLinearLayout = paramafce;
      if ((paramaexg instanceof aghs)) {
        paramLinearLayout = (aghs)paramaexg;
      }
      if ((paramView != null) && (paramLinearLayout != null)) {
        break label794;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559317, null);
      paramLinearLayout = new aghs();
      paramView.setTag(paramLinearLayout);
    }
    label788:
    label794:
    for (;;)
    {
      paramView.findViewById(2131370960).setVisibility(8);
      paramView.findViewById(2131370961).setVisibility(8);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView = ((TopicTextView)paramView.findViewById(2131379877));
      paramLinearLayout.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363417);
      paramLinearLayout.jdField_a_of_type_Long = paramMessageRecord.uniseq;
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView.setTopicText(localMessageForLimitChatTopic.msg);
      paramLinearLayout.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (bool4) {}
      for (int i = Color.rgb(34, 34, 34);; i = -1)
      {
        paramMessageRecord = a(8, i);
        paramLinearLayout.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
        if (e)
        {
          paramaexg.b.append(localMessageForLimitChatTopic.msg);
          paramView.setContentDescription(paramaexg.b.toString());
        }
        return paramView;
      }
      try
      {
        paramafce = new JSONObject(str);
        if (paramafce == null) {
          return new View(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      catch (JSONException paramafce)
      {
        for (;;)
        {
          QLog.d("LimitChatTopicItemBuilder", 2, paramafce, new Object[0]);
          paramafce = null;
        }
        if ((paramaexg instanceof aghs)) {
          paramLinearLayout = (aghs)paramaexg;
        }
        if (paramView != null)
        {
          paramaexg = paramLinearLayout;
          if (paramLinearLayout != null) {}
        }
        else
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559317, null);
          paramaexg = new aghs();
          paramView.setTag(paramaexg);
        }
        boolean bool3 = false;
        boolean bool2 = false;
        i = paramafce.optInt("matchTagId");
        paramLinearLayout = ((arhi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a(paramMessageRecord.frienduin, false);
        paramaexg.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = paramLinearLayout;
        boolean bool1;
        if (i <= 1) {
          bool1 = false;
        }
        do
        {
          do
          {
            paramaexg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
            paramaexg.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370960);
            paramaexg.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131370961);
            paramaexg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370616));
            paramaexg.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369367));
            paramaexg.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379814));
            paramaexg.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131379974));
            paramaexg.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369589));
            paramaexg.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369590));
            paramaexg.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378967));
            paramaexg.e = ((TextView)paramView.findViewById(2131378966));
            paramaexg.e.setTag(paramaexg);
            paramaexg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363136));
            paramaexg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131380924));
            paramaexg.e.setOnClickListener(this);
            paramaexg.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            paramaexg.jdField_b_of_type_Int = i;
            paramView.findViewById(2131363417).setVisibility(8);
            bool2 = "2971".equals(ThemeUtil.getCurrentThemeId());
            a(paramaexg, bool1, paramafce, paramMessageRecord.frienduin, bool4, bool2);
            return paramView;
            bool1 = bool2;
          } while (paramLinearLayout == null);
          bool1 = bool2;
        } while (TextUtils.isEmpty(paramLinearLayout.miniProfileMsg));
        bool2 = bool3;
        for (;;)
        {
          try
          {
            paramLinearLayout = new JSONObject(paramLinearLayout.miniProfileMsg);
            bool2 = bool3;
            if (paramLinearLayout.optBoolean("send_topic" + paramMessageRecord.uniseq, false)) {
              break label788;
            }
            bool1 = true;
            bool2 = bool1;
            paramaexg.jdField_a_of_type_OrgJsonJSONObject = paramLinearLayout;
          }
          catch (JSONException paramLinearLayout)
          {
            bool1 = bool2;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("LimitChatTopicItemBuilder", 2, "" + paramLinearLayout);
          bool1 = bool2;
          break;
          bool1 = false;
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
    arpe.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bgbb[] a(View paramView)
  {
    return new bgbb[0];
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!(localObject1 instanceof aghs)) {
        continue;
      }
      localObject1 = (aghs)localObject1;
      if (((aghs)localObject1).jdField_d_of_type_AndroidViewView == null) {
        continue;
      }
      ((aghs)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(8);
      Object localObject2 = ((aghs)localObject1).jdField_c_of_type_JavaLangString;
      if (localObject2 != null) {
        acvv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2);
      }
      if ((((aghs)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (((aghs)localObject1).jdField_a_of_type_OrgJsonJSONObject != null)) {}
      try
      {
        ((aghs)localObject1).jdField_a_of_type_OrgJsonJSONObject.put("send_topic" + ((aghs)localObject1).jdField_a_of_type_Long, true);
        ((aghs)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.miniProfileMsg = ((aghs)localObject1).jdField_a_of_type_OrgJsonJSONObject.toString();
        label165:
        ThreadManager.getSubThreadHandler().post(new LimitChatTopicItemBuilder.1(this, (aghs)localObject1));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800AA95", ((aghs)localObject1).jdField_b_of_type_JavaLangString, (String)localObject2);
        continue;
        a("", "0X800AA96", "", "");
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 96);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 0, 2);
        continue;
        if ((!(paramView instanceof ExtendFriendVoiceView)) || (!(localObject1 instanceof aghs))) {
          continue;
        }
        Object localObject3 = (aghs)localObject1;
        localObject1 = (ExtendFriendVoiceView)paramView;
        if (((ExtendFriendVoiceView)localObject1).b())
        {
          ((ExtendFriendVoiceView)localObject1).d();
          arpe.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).c();
        }
        for (;;)
        {
          a("", "0X800AA98", "", "");
          break;
          if (!TextUtils.isEmpty(((aghs)localObject3).jdField_a_of_type_JavaLangString))
          {
            ((ExtendFriendVoiceView)localObject1).c();
            localObject2 = arpe.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            ((arpe)localObject2).a(((aghs)localObject3).jdField_a_of_type_JavaLangString);
            localObject3 = ((arpe)localObject2).a();
            if ((localObject3 != null) && (localObject3 != localObject1) && (((ExtendFriendVoiceView)localObject3).b())) {
              ((ExtendFriendVoiceView)localObject3).d();
            }
            ((arpe)localObject2).a((ExtendFriendVoiceView)localObject1);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        break label165;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghq
 * JD-Core Version:    0.7.0.1
 */