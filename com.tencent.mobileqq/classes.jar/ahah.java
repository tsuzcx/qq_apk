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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class ahah
  extends afor
  implements View.OnClickListener
{
  private HashSet<Long> a;
  
  public ahah(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet(10);
  }
  
  private int a(int paramInt, LinearLayout paramLinearLayout, List<ahai> paramList)
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
    ahai localahai;
    if (i < i1)
    {
      localahai = (ahai)paramList.get(i);
      if (TextUtils.isEmpty(localahai.jdField_a_of_type_JavaLangCharSequence)) {
        break label307;
      }
      int i2 = (int)(((Paint)localObject).measureText(localahai.jdField_a_of_type_JavaLangCharSequence.toString()) + m * 2);
      if (paramInt >= i2 + n)
      {
        localArrayList.add(localahai);
        paramInt = paramInt - i2 - n;
      }
    }
    label307:
    for (;;)
    {
      i += 1;
      break;
      if (i == 0) {
        localArrayList.add(localahai);
      }
      i = localArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (ahai)localArrayList.get(paramInt);
        paramList = new LabelTextView(this.jdField_a_of_type_AndroidContentContext);
        paramList.setParam(((ahai)localObject).jdField_a_of_type_Int, ((ahai)localObject).jdField_b_of_type_Int, j);
        paramList.setTextSize(12);
        paramList.setText(((ahai)localObject).jdField_a_of_type_JavaLangCharSequence);
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
  private String a(ahaj paramahaj, JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("matchTagId");
    String str = "";
    if (ExtendFriendUserInfo.isTagIdFromSignalBomb(j))
    {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131698534);
      if (TextUtils.isEmpty(paramahaj.jdField_b_of_type_JavaLangString)) {
        paramahaj.jdField_b_of_type_JavaLangString = str;
      }
      return str;
    }
    if (paramahaj.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) {}
    for (int i = paramahaj.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.fromType;; i = 3)
    {
      if (i == 1)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131698428);
        break;
      }
      if (i == 2)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131698431);
        break;
      }
      if (i != 3) {
        break;
      }
      if (j > 1)
      {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131698500);
        paramahaj.jdField_b_of_type_JavaLangString = paramJSONObject.optString("matchTagName");
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131698501);
      break;
    }
  }
  
  private String a(String paramString)
  {
    return paramString.replaceAll("\n", " ").trim();
  }
  
  private void a(ahaj paramahaj, String paramString)
  {
    Object localObject;
    Bitmap localBitmap;
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof afqz))
    {
      localObject = ((afqz)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a;
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
        localObject = bheg.b();
      }
      paramahaj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramahaj.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692081));
      return;
      paramString = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      continue;
      label112:
      paramString = null;
    }
  }
  
  private void a(ahaj paramahaj, ArrayList<ahai> paramArrayList, JSONArray paramJSONArray)
  {
    int i = 0;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0)) {
      paramArrayList.addAll(assv.a(this.jdField_a_of_type_AndroidContentContext, paramJSONArray));
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      int j = ViewUtils.getScreenWidth() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298182) * 2 - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298183) * 2;
      int k = a(j, paramahaj.jdField_a_of_type_AndroidWidgetLinearLayout, paramArrayList);
      if (k > 0)
      {
        paramahaj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (k < paramArrayList.size())
        {
          j = a(j, paramahaj.jdField_b_of_type_AndroidWidgetLinearLayout, paramArrayList.subList(k, paramArrayList.size()));
          paramahaj = paramahaj.jdField_b_of_type_AndroidWidgetLinearLayout;
          if (j > 0) {}
          for (;;)
          {
            paramahaj.setVisibility(i);
            return;
            i = 8;
          }
        }
        paramahaj.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      paramahaj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    paramahaj.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramahaj.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void a(ahaj paramahaj, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("declaration");
    paramJSONObject = paramJSONObject.optString("signWords");
    if (!TextUtils.isEmpty(str))
    {
      paramahaj.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(a(str)), 3, 24));
      return;
    }
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramahaj.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(a(paramJSONObject)), 3, 24));
      return;
    }
    paramahaj.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
  }
  
  private void a(ahaj paramahaj, JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
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
        paramString1 = asru.a(paramInt);
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
        paramahaj.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
        paramJSONObject = paramahaj.jdField_b_of_type_AndroidWidgetTextView;
        if (paramBoolean)
        {
          paramInt = -1315851;
          label227:
          paramJSONObject.setTextColor(paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label328;
          }
          paramahaj.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          paramJSONObject = paramahaj.jdField_b_of_type_AndroidWidgetImageView;
          if (i == 0) {
            break label312;
          }
          paramInt = 2130845139;
          paramJSONObject.setImageResource(paramInt);
          paramahaj = paramahaj.jdField_c_of_type_AndroidWidgetTextView;
          if (!paramBoolean) {
            break label320;
          }
        }
        for (paramInt = -1315851;; paramInt = -7894119)
        {
          paramahaj.setTextColor(paramInt);
          return;
          i = 0;
          break;
          paramString1 = null;
          break label132;
          paramInt = -7894119;
          break label227;
          paramInt = 2130845140;
          break label265;
        }
        paramahaj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramahaj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        return;
      }
    }
  }
  
  private void a(ahaj paramahaj, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = paramahaj.jdField_c_of_type_AndroidViewView;
    int i;
    if (paramBoolean2) {
      i = -14474461;
    }
    for (;;)
    {
      ((View)localObject).setBackgroundDrawable(a(16, i));
      localObject = new ArrayList();
      a(paramahaj, paramString);
      a((ArrayList)localObject, paramJSONObject.optString("age"), paramJSONObject.optInt("gender"));
      a((ArrayList)localObject, paramJSONObject.optLong("popular"));
      a(paramahaj, paramJSONObject, paramBoolean2, a(paramahaj, paramJSONObject), paramJSONObject.optString("city"), paramJSONObject.optString("constellation"), paramJSONObject.optInt("distance", -1));
      a(paramahaj, (ArrayList)localObject, paramJSONObject.optJSONArray("personalTags"));
      a(paramahaj, paramJSONObject);
      b(paramahaj, paramJSONObject);
      b(paramahaj, paramBoolean1, paramJSONObject, paramString, paramBoolean2, paramBoolean3);
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
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", paramString1, "qq_kuolie", paramString2, 0, 0, "", "", paramString3, paramString4);
  }
  
  private void a(ArrayList<ahai> paramArrayList, long paramLong)
  {
    if (paramLong > 0L)
    {
      int i = ViewUtils.dip2px(11.0F);
      Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845087);
      ((Drawable)localObject1).setBounds(0, 0, i, i);
      Object localObject2 = new ImageSpan((Drawable)localObject1, 1);
      String str = this.jdField_a_of_type_AndroidContentContext.getString(2131693752);
      localObject1 = new SpannableString(str + " " + paramLong);
      ((SpannableString)localObject1).setSpan(localObject2, 0, str.length(), 17);
      localObject2 = new ahai();
      ((ahai)localObject2).jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      ((ahai)localObject2).jdField_a_of_type_Int = Color.parseColor("#338173FF");
      ((ahai)localObject2).jdField_b_of_type_Int = Color.parseColor("#8173FF");
      paramArrayList.add(localObject2);
    }
  }
  
  private void a(ArrayList<ahai> paramArrayList, String paramString, int paramInt)
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
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131693752);
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
    for (paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845086);; paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845085))
    {
      paramInt = ViewUtils.dip2px(11.0F);
      paramString.setBounds(0, 0, paramInt, paramInt);
      localSpannableString.setSpan(new ImageSpan(paramString, 1), 0, str.length(), 17);
      paramString = new ahai();
      paramString.jdField_a_of_type_JavaLangCharSequence = localSpannableString;
      paramString.jdField_a_of_type_Int = i;
      paramString.jdField_b_of_type_Int = j;
      paramArrayList.add(paramString);
      return;
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692198);
      break;
      paramString = str + " " + paramString;
      break label55;
      i = Color.parseColor("#33FF80BF");
      break label78;
      j = Color.parseColor("#FF80BF");
      break label91;
    }
  }
  
  private void b(ahaj paramahaj, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("voiceUrl");
    int i = paramJSONObject.optInt("voiceDuration");
    if (TextUtils.isEmpty(str)) {
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
    }
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity));
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(3);
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(str);
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      paramahaj.jdField_a_of_type_JavaLangString = str;
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setTag(paramahaj);
      paramahaj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(i);
    } while (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramahaj.jdField_a_of_type_Long)));
    a("", "0X800AA97", "", "");
  }
  
  private void b(ahaj paramahaj, boolean paramBoolean1, JSONObject paramJSONObject, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramJSONObject = paramJSONObject.optString("topic_msg");
    int i;
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramJSONObject)))
    {
      paramahaj.jdField_d_of_type_AndroidViewView.setVisibility(0);
      Object localObject = paramahaj.jdField_d_of_type_AndroidViewView;
      if (paramBoolean2)
      {
        i = -14474461;
        ((View)localObject).setBackgroundDrawable(a(16, i));
        localObject = paramahaj.jdField_d_of_type_AndroidWidgetTextView;
        if (!paramBoolean2) {
          break label200;
        }
        i = -1712591883;
        label72:
        ((TextView)localObject).setTextColor(i);
        paramahaj.jdField_d_of_type_AndroidWidgetTextView.setText(paramJSONObject);
        paramahaj.jdField_c_of_type_JavaLangString = paramJSONObject;
        label92:
        if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramahaj.jdField_a_of_type_Long)))
        {
          localObject = paramahaj.jdField_b_of_type_JavaLangString;
          if (paramahaj.jdField_b_of_type_Int != 1) {
            break label220;
          }
          paramJSONObject = (JSONObject)localObject;
          label126:
          a(paramString, "0X800AA94", (String)localObject, paramJSONObject);
        }
        paramString = paramahaj.e;
        if (!paramBoolean2) {
          break label238;
        }
        paramJSONObject = a(20, 435549946);
      }
    }
    for (;;)
    {
      paramString.setBackgroundDrawable(paramJSONObject);
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramahaj.jdField_a_of_type_Long));
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
      paramahaj.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break label92;
      label220:
      if (TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramahaj.jdField_b_of_type_JavaLangString;
        break label126;
      }
      break label126;
      label238:
      if (paramBoolean3) {
        paramJSONObject = a(20, -1);
      } else {
        paramJSONObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839381);
      }
    }
  }
  
  protected afos a()
  {
    return new ahaj();
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    boolean bool4 = ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)paramMessageRecord;
    String str = localMessageForLimitChatTopic.getExtInfoFromExtStr("match_chat_msg_data_key");
    paramLinearLayout = null;
    paramaftk = null;
    if (TextUtils.isEmpty(str))
    {
      paramLinearLayout = paramaftk;
      if ((paramafos instanceof ahaj)) {
        paramLinearLayout = (ahaj)paramafos;
      }
      if ((paramView != null) && (paramLinearLayout != null)) {
        break label794;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559367, null);
      paramLinearLayout = new ahaj();
      paramView.setTag(paramLinearLayout);
    }
    label788:
    label794:
    for (;;)
    {
      paramView.findViewById(2131371145).setVisibility(8);
      paramView.findViewById(2131371146).setVisibility(8);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqLimitchatTopicTextView = ((TopicTextView)paramView.findViewById(2131380210));
      paramLinearLayout.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363486);
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
          paramafos.b.append(localMessageForLimitChatTopic.msg);
          paramView.setContentDescription(paramafos.b.toString());
        }
        return paramView;
      }
      try
      {
        paramaftk = new JSONObject(str);
        if (paramaftk == null) {
          return new View(this.jdField_a_of_type_AndroidContentContext);
        }
      }
      catch (JSONException paramaftk)
      {
        for (;;)
        {
          QLog.d("LimitChatTopicItemBuilder", 2, paramaftk, new Object[0]);
          paramaftk = null;
        }
        if ((paramafos instanceof ahaj)) {
          paramLinearLayout = (ahaj)paramafos;
        }
        if (paramView != null)
        {
          paramafos = paramLinearLayout;
          if (paramLinearLayout != null) {}
        }
        else
        {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559367, null);
          paramafos = new ahaj();
          paramView.setTag(paramafos);
        }
        boolean bool3 = false;
        boolean bool2 = false;
        i = paramaftk.optInt("matchTagId");
        paramLinearLayout = ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramMessageRecord.frienduin, false);
        paramafos.jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo = paramLinearLayout;
        boolean bool1;
        if (i <= 1) {
          bool1 = false;
        }
        do
        {
          do
          {
            paramafos.jdField_a_of_type_Long = paramMessageRecord.uniseq;
            paramafos.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131371145);
            paramafos.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371146);
            paramafos.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370799));
            paramafos.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369533));
            paramafos.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380140));
            paramafos.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131380313));
            paramafos.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369758));
            paramafos.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369759));
            paramafos.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379261));
            paramafos.e = ((TextView)paramView.findViewById(2131379260));
            paramafos.e.setTag(paramafos);
            paramafos.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363155));
            paramafos.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131381276));
            paramafos.e.setOnClickListener(this);
            paramafos.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            paramafos.jdField_b_of_type_Int = i;
            paramView.findViewById(2131363486).setVisibility(8);
            bool2 = "2971".equals(ThemeUtil.getCurrentThemeId());
            a(paramafos, bool1, paramaftk, paramMessageRecord.frienduin, bool4, bool2);
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
            paramafos.jdField_a_of_type_OrgJsonJSONObject = paramLinearLayout;
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
    astk.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
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
      if (!(localObject1 instanceof ahaj)) {
        continue;
      }
      localObject1 = (ahaj)localObject1;
      if (((ahaj)localObject1).jdField_d_of_type_AndroidViewView == null) {
        continue;
      }
      ((ahaj)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(8);
      Object localObject2 = ((ahaj)localObject1).jdField_c_of_type_JavaLangString;
      if (localObject2 != null) {
        admh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2);
      }
      if ((((ahaj)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo != null) && (((ahaj)localObject1).jdField_a_of_type_OrgJsonJSONObject != null)) {}
      try
      {
        ((ahaj)localObject1).jdField_a_of_type_OrgJsonJSONObject.put("send_topic" + ((ahaj)localObject1).jdField_a_of_type_Long, true);
        ((ahaj)localObject1).jdField_a_of_type_ComTencentMobileqqDataExtendFriendUserInfo.miniProfileMsg = ((ahaj)localObject1).jdField_a_of_type_OrgJsonJSONObject.toString();
        label165:
        ThreadManager.getSubThreadHandler().post(new LimitChatTopicItemBuilder.1(this, (ahaj)localObject1));
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800AA95", ((ahaj)localObject1).jdField_b_of_type_JavaLangString, (String)localObject2);
        continue;
        a("", "0X800AA96", "", "");
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 96);
        ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1, 0, 2);
        continue;
        if ((!(paramView instanceof ExtendFriendVoiceView)) || (!(localObject1 instanceof ahaj))) {
          continue;
        }
        Object localObject3 = (ahaj)localObject1;
        localObject1 = (ExtendFriendVoiceView)paramView;
        if (((ExtendFriendVoiceView)localObject1).b())
        {
          ((ExtendFriendVoiceView)localObject1).d();
          astk.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).c();
        }
        for (;;)
        {
          a("", "0X800AA98", "", "");
          break;
          if (!TextUtils.isEmpty(((ahaj)localObject3).jdField_a_of_type_JavaLangString))
          {
            ((ExtendFriendVoiceView)localObject1).c();
            localObject2 = astk.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            ((astk)localObject2).a(((ahaj)localObject3).jdField_a_of_type_JavaLangString);
            localObject3 = ((astk)localObject2).a();
            if ((localObject3 != null) && (localObject3 != localObject1) && (((ExtendFriendVoiceView)localObject3).b())) {
              ((ExtendFriendVoiceView)localObject3).d();
            }
            ((astk)localObject2).a((ExtendFriendVoiceView)localObject1);
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
 * Qualified Name:     ahah
 * JD-Core Version:    0.7.0.1
 */