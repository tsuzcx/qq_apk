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
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import org.jetbrains.annotations.Nullable;

public class ahcw
  extends afuu
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  int c = 0;
  int d = -12541697;
  int e;
  
  public ahcw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_e_of_type_Int = -2143248129;
    this.jdField_a_of_type_Int = ((int)paramContext.getResources().getDimension(2131298038));
    this.c = ((int)paramContext.getResources().getDimension(2131298196));
    int i = this.jdField_e_of_type_Int;
    int j = this.d;
    this.jdField_a_of_type_AndroidContentResColorStateList = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { i, j });
    paramQQAppInterface = (afwx)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, ahcy paramahcy)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558838, null);
      paramahcy.c = ((TextView)paramView.findViewById(2131371539));
      paramahcy.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368138));
      paramahcy.d = ((TextView)paramView.findViewById(2131365344));
      paramahcy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378776));
      paramahcy.e = ((TextView)paramView.findViewById(2131378737));
      paramahcy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365092));
      paramahcy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131365093));
    }
    try
    {
      paramahcy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130845394);
      paramahcy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(afur.a(3.0F, paramahcy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getResources()));
      paramahcy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      Object localObject = paramahcy.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      localView = localObject[0];
      localObject = localObject[2];
      localView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramahcy.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
      if (jdField_e_of_type_Boolean)
      {
        localView.setContentDescription(null);
        paramahcy.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahcy.jdField_b_of_type_JavaLangStringBuilder.length(), "");
        paramahcy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(null);
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
          paramahcy.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageResource(2130845394);
        }
        catch (Throwable localThrowable) {}
      }
    }
  }
  
  @Nullable
  private URLDrawable a(String paramString)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.c;
      localURLDrawableOptions.mRequestHeight = this.c;
      localURLDrawableOptions.mLoadingDrawable = bdzx.a;
      localURLDrawableOptions.mFailedDrawable = bdzx.a;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
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
  
  private void a(ahcy paramahcy)
  {
    if (paramahcy.jdField_a_of_type_ComTencentMobileqqDataMessageForMedalNews.myLevel == 0) {}
    for (int i = 0;; i = 8)
    {
      if (paramahcy.e.getVisibility() != i) {
        paramahcy.e.setVisibility(i);
      }
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698067);
      if (!((String)localObject).equalsIgnoreCase(paramahcy.e.getText().toString()))
      {
        localObject = new SpannableString((CharSequence)localObject);
        ((SpannableString)localObject).setSpan(new arlv(new ahcx(this), this.jdField_a_of_type_AndroidContentResColorStateList), 11, 14, 33);
        paramahcy.e.setText((CharSequence)localObject);
        paramahcy.e.setMovementMethod(LinkMovementMethod.getInstance());
      }
      return;
    }
  }
  
  private void a(ahcy paramahcy, int paramInt)
  {
    int j;
    int i;
    switch (paramInt)
    {
    default: 
      j = 2130845406;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166391);
      this.jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
      Object localObject2 = paramahcy.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      Object localObject1 = localObject2[0];
      localObject2 = localObject2[2];
      localObject1.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      ((Drawable)localObject2).setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramahcy.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramahcy.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      paramahcy.c.setTextColor(i);
      paramahcy.d.setTextColor(i);
      if (paramInt <= 3)
      {
        paramahcy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
        paramahcy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      paramahcy.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      return;
      j = 2130845404;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166389);
      break;
      j = 2130845405;
      i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166393);
      break;
      paramahcy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      a(bgjw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1), paramString1);
    }
    String str;
    do
    {
      return;
      str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
      paramString1 = axeg.a(paramString1);
      paramString2 = awix.a(new String[] { paramInt2 + "", paramInt1 + "", paramString1, str });
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
        paramString1 = awix.a(Long.valueOf(1000L * paramLong1)).substring(0, 4);
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
  
  protected afuv a()
  {
    return new ahcy(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramafzq = (MessageForMedalNews)paramMessageRecord;
    paramLinearLayout = (ahcy)paramafuv;
    paramView = a(paramView, paramLinearLayout);
    paramLinearLayout.jdField_a_of_type_Long = paramafzq.uniseq;
    paramLinearLayout.jdField_a_of_type_JavaLangString = paramafzq.frienduin;
    paramLinearLayout.jdField_a_of_type_ComTencentMobileqqDataMessageForMedalNews = paramafzq;
    int n = paramafzq.level;
    paramMessageRecord = paramafzq.name;
    paramafuv = paramafzq.desc;
    paramafzq = paramafzq.icon;
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
        if (paramafzq.equalsIgnoreCase((String)localObject)) {
          k = 0;
        }
      }
    }
    if (j != 0)
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698066, new Object[] { localObject });
      if (!paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText().equals(localObject)) {
        paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.setTag(paramLinearLayout.jdField_a_of_type_JavaLangString);
    }
    if (!paramLinearLayout.c.getText().equals(paramMessageRecord))
    {
      paramLinearLayout.c.setText(paramMessageRecord);
      j = a(paramMessageRecord);
      if ((j & 0x1) != 0) {
        break label556;
      }
      j /= 2;
      if (j > 5) {
        break label567;
      }
      paramLinearLayout.c.setTextSize(1, 20.0F);
    }
    for (;;)
    {
      if (!paramLinearLayout.d.getText().equals(paramafuv)) {
        paramLinearLayout.d.setText(paramafuv);
      }
      if (k != 0)
      {
        paramafuv = a(paramafzq);
        localObject = paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView;
        paramMessageRecord = paramafuv;
        if (paramafuv == null) {
          paramMessageRecord = bdzx.a;
        }
        ((URLImageView)localObject).setImageDrawable(paramMessageRecord);
        paramLinearLayout.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramafzq);
      }
      if (i != 0) {
        a(paramLinearLayout, n);
      }
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(paramLinearLayout);
      paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setOnClickListener(this);
      a(paramLinearLayout);
      if (jdField_e_of_type_Boolean)
      {
        paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.append(paramLinearLayout.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramLinearLayout.c.getText());
        paramView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
        paramLinearLayout.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setContentDescription(paramLinearLayout.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return paramView;
      label556:
      j = j / 2 + 1;
      break;
      label567:
      paramLinearLayout.c.setTextSize(1, 15.0F);
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
  }
  
  public void onClick(View paramView)
  {
    ahcy localahcy = (ahcy)paramView.getTag();
    if (localahcy == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ThreadManager.postImmediately(new MedalNewsItemBuilder.2(this, localahcy.jdField_a_of_type_ComTencentMobileqqDataMessageForMedalNews), null, true);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "4", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcw
 * JD-Core Version:    0.7.0.1
 */