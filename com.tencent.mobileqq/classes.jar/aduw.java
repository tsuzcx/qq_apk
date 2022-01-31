import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class aduw
  extends actq
{
  int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  int c = 0;
  int d = -12541697;
  int e;
  
  public aduw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_e_of_type_Int = -2143248129;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131297936));
    this.c = ((int)paramContext.getResources().getDimension(2131298091));
    paramBaseAdapter = new int[] { 16842919 };
    int i = this.jdField_e_of_type_Int;
    int j = this.d;
    this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(new int[][] { paramBaseAdapter, new int[0] }, new int[] { i, j });
    paramQQAppInterface = (acus)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 4);
    }
  }
  
  public static int a(String paramString)
  {
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      int k = paramString.codePointAt(j);
      if ((k >= 32) && (k <= 126)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (k >= 65535)
        {
          i += 2;
          j += 1;
        }
        else
        {
          i += 2;
        }
      }
    }
    return i;
  }
  
  private View a(View paramView, aduz paramaduz)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558738, null);
      paramaduz.c = ((TextView)paramView.findViewById(2131370647));
      paramaduz.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367679));
      paramaduz.d = ((TextView)paramView.findViewById(2131365018));
      paramaduz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
      paramaduz.e = ((TextView)paramView.findViewById(2131377315));
      paramaduz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364780));
      paramaduz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131364781));
    }
    try
    {
      paramaduz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130844559);
      paramaduz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(actn.a(3.0F, paramaduz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getResources()));
      paramaduz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      Object localObject = paramaduz.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      localView = localObject[0];
      localObject = localObject[2];
      localView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramaduz.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
      if (jdField_e_of_type_Boolean)
      {
        localView.setContentDescription(null);
        paramaduz.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramaduz.jdField_b_of_type_JavaLangStringBuilder.length(), "");
        paramaduz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(null);
      }
      return localView;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        try
        {
          System.gc();
          paramaduz.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130844559);
        }
        catch (Throwable localThrowable) {}
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int k;
      if (j < paramString.length())
      {
        k = paramString.codePointAt(j);
        if ((k < 32) || (k > 126)) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        if (i <= paramInt) {
          localStringBuilder.appendCodePoint(k);
        }
        if (i < paramInt) {
          break;
        }
        if (localStringBuilder.length() < paramString.length()) {
          localStringBuilder.append("...");
        }
        return localStringBuilder.toString();
        label90:
        if (k >= 65535)
        {
          i += 1;
          j += 1;
        }
        else
        {
          i += 2;
        }
      }
      j += 1;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      a(bbbd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1), paramString1);
    }
    String str;
    do
    {
      return;
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      paramString1 = atbn.a(paramString1);
      paramString2 = asgc.a(new String[] { paramInt2 + "", paramInt1 + "", paramString1, str });
      localObject = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250);
    } while (localObject == null);
    Object localObject = new StringBuilder(((MedalWallMng)localObject).a());
    ((StringBuilder)localObject).append("&uincode=").append(paramString1);
    ((StringBuilder)localObject).append("&id=").append(paramInt2);
    ((StringBuilder)localObject).append("&level=").append(paramInt1);
    ((StringBuilder)localObject).append("&nick=").append(URLEncoder.encode(str));
    ((StringBuilder)localObject).append("&en=").append(paramString2);
    ((StringBuilder)localObject).append("&fromId=").append(1);
    if (paramInt2 == 0) {
      paramString2 = "0";
    }
    for (;;)
    {
      try
      {
        paramString1 = asgc.a(Long.valueOf(1000L * paramLong1)).substring(0, 4);
        ((StringBuilder)localObject).append("&year=").append(paramString1);
        ((StringBuilder)localObject).append("&seq=").append(paramLong2);
        if (QLog.isColorLevel()) {
          QLog.i("MedalNewsItemBuilder", 4, "goto medal share:" + ((StringBuilder)localObject).toString());
        }
        paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        paramString1.putExtra("url", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString1);
        return;
      }
      catch (Exception localException)
      {
        paramString1 = paramString2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ShareHelper", 2, localException.getMessage(), localException);
        paramString1 = paramString2;
        continue;
      }
      ((StringBuilder)localObject).append("&time=").append(paramLong1);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    MedalWallMng localMedalWallMng = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    if (paramBoolean) {}
    for (int i = MedalWallMng.f;; i = MedalWallMng.jdField_e_of_type_Int)
    {
      localIntent.putExtra("url", localMedalWallMng.a(paramBoolean, paramString, i));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (paramBoolean) {
        ThreadManager.post(new MedalNewsItemBuilder.3(this), 0, null, false);
      }
      return;
    }
  }
  
  protected actr a()
  {
    return new aduz(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramacxn = (MessageForMedalNews)paramMessageRecord;
    paramLinearLayout = (aduz)paramactr;
    paramView = a(paramView, paramLinearLayout);
    paramLinearLayout.jdField_a_of_type_Long = paramacxn.uniseq;
    paramLinearLayout.jdField_a_of_type_JavaLangString = paramacxn.frienduin;
    int n = paramacxn.level;
    paramMessageRecord = paramacxn.name;
    paramactr = paramacxn.desc;
    String str = paramacxn.icon;
    int i = 1;
    int k = 1;
    int m = 1;
    Object localObject = paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getTag();
    int j = i;
    if (localObject != null)
    {
      j = i;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        j = i;
        if (paramLinearLayout.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject)) {
          j = 0;
        }
      }
    }
    localObject = paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.getTag();
    i = k;
    if (localObject != null)
    {
      i = k;
      if ((localObject instanceof Integer))
      {
        i = k;
        if (n == ((Integer)localObject).intValue()) {
          i = 0;
        }
      }
    }
    localObject = paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView.getTag();
    k = m;
    if (localObject != null)
    {
      k = m;
      if ((localObject instanceof String))
      {
        k = m;
        if (str.equalsIgnoreCase((String)localObject)) {
          k = 0;
        }
      }
    }
    if (j != 0)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699112, new Object[] { localObject });
      if (!paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText().equals(localObject)) {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTag(paramLinearLayout.jdField_a_of_type_JavaLangString);
    }
    if (!paramLinearLayout.c.getText().equals(paramMessageRecord))
    {
      paramLinearLayout.c.setText(paramMessageRecord);
      j = a(paramMessageRecord);
      if ((j & 0x1) == 0)
      {
        j /= 2;
        if (j > 5) {
          break label894;
        }
        paramLinearLayout.c.setTextSize(1, 20.0F);
      }
    }
    else
    {
      label378:
      if (!paramLinearLayout.d.getText().equals(paramactr)) {
        paramLinearLayout.d.setText(paramactr);
      }
      if (k != 0) {
        paramMessageRecord = null;
      }
    }
    label452:
    label968:
    try
    {
      paramactr = URLDrawable.URLDrawableOptions.obtain();
      paramactr.mRequestWidth = this.c;
      paramactr.mRequestHeight = this.c;
      paramactr.mLoadingDrawable = aywk.a;
      paramactr.mFailedDrawable = aywk.a;
      paramactr = URLDrawable.getDrawable(str, paramactr);
      paramMessageRecord = paramactr;
    }
    catch (Exception paramactr)
    {
      label894:
      break label452;
    }
    localObject = paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView;
    paramactr = paramMessageRecord;
    if (paramMessageRecord == null) {
      paramactr = aywk.a;
    }
    ((URLImageView)localObject).setImageDrawable(paramactr);
    paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView.setTag(str);
    if (i != 0) {}
    switch (n)
    {
    default: 
      j = 2130844571;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166271);
      label536:
      this.jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
      paramactr = paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      paramMessageRecord = paramactr[0];
      paramactr = paramactr[2];
      paramMessageRecord.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramactr.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      paramLinearLayout.c.setTextColor(i);
      paramLinearLayout.d.setTextColor(i);
      if (n <= 3)
      {
        paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
        paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        label652:
        paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(n));
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(paramLinearLayout);
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setOnClickListener(new adux(this, paramacxn));
        if (paramacxn.myLevel != 0) {
          break label968;
        }
      }
      break;
    }
    for (i = 0;; i = 8)
    {
      if (paramLinearLayout.e.getVisibility() != i) {
        paramLinearLayout.e.setVisibility(i);
      }
      paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131699113);
      if (!paramMessageRecord.equalsIgnoreCase(paramLinearLayout.e.getText().toString()))
      {
        paramMessageRecord = new SpannableString(paramMessageRecord);
        paramMessageRecord.setSpan(new annf(new aduy(this), this.jdField_a_of_type_AndroidContentResColorStateList), 11, 14, 33);
        paramLinearLayout.e.setText(paramMessageRecord);
        paramLinearLayout.e.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (jdField_e_of_type_Boolean)
      {
        paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.append(paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramLinearLayout.c.getText());
        paramView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return paramView;
      j = j / 2 + 1;
      break;
      paramLinearLayout.c.setTextSize(1, 15.0F);
      break label378;
      j = 2130844569;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166269);
      break label536;
      j = 2130844570;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166273);
      break label536;
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label652;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bblt[] a(View paramView)
  {
    return new bblt[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aduw
 * JD-Core Version:    0.7.0.1
 */