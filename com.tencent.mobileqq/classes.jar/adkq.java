import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import java.net.MalformedURLException;
import java.net.URL;

public class adkq
  extends acjb
{
  int jdField_a_of_type_Int = 0;
  awur jdField_a_of_type_Awur;
  int c = 0;
  int d = 0;
  
  public adkq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131165236) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131166846));
    this.d = paramContext.getResources().getDimensionPixelSize(2131166845);
    paramQQAppInterface = (acjz)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
  }
  
  private int a(adks paramadks)
  {
    int i = paramadks.c.getBackground().getIntrinsicWidth();
    return paramadks.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, adks paramadks)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493190, null);
      paramadks.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131299132);
      paramadks.c = ((TextView)paramView.findViewById(2131311220));
      paramadks.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311534));
      paramadks.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131297594));
      paramadks.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramadks.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramadks);
      paramadks.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramadks.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramadks.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramadks.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramadks.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
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
  
  protected acjc a()
  {
    return new adks(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramacjc = (adks)paramacjc;
    paramView = a(paramView, paramacjc);
    paramacjc.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramacjc.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramacmv = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(atva.jdField_a_of_type_JavaLangString, new Object[] { paramacmv });
    if (!paramacjc.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramacjc.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramacjc.c.getText().equals(paramLinearLayout.text)) {
      paramacjc.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramacjc.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131306289);
    Object localObject = (Integer)paramacjc.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131306288);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!azzz.a(paramLinearLayout.cover, paramMessageRecord))) {
        break label543;
      }
    }
    label538:
    label543:
    for (int i = 0;; i = 1)
    {
      int k = i;
      if (TextUtils.isEmpty(paramLinearLayout.cover))
      {
        k = i;
        if (j == paramLinearLayout.bgColor) {
          k = 0;
        }
      }
      awur localawur;
      if (k != 0)
      {
        localObject = new awur(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localawur = new awur(0, this.c * 3, this.c * 3, this.c);
        if (TextUtils.isEmpty(paramLinearLayout.cover)) {
          break label538;
        }
      }
      for (;;)
      {
        try
        {
          paramMessageRecord = new URL(paramLinearLayout.cover);
          if (paramMessageRecord != null)
          {
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramacjc), a(paramacjc), localawur, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(azue.s);
            paramacjc.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramacjc.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131306289, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramacjc.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramacjc.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131306288, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Awur == null) {
                this.jdField_a_of_type_Awur = new awur(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramacjc.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Awur);
              if (e)
              {
                paramacjc.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramacjc.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramacjc.jdField_b_of_type_AndroidViewView.setTag(paramacjc);
              paramacjc.jdField_b_of_type_AndroidViewView.setOnClickListener(new adkr(this, paramLinearLayout, paramacmv));
              return paramView;
              j = ((Integer)localObject).intValue();
            }
          }
        }
        catch (MalformedURLException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
          paramMessageRecord = null;
          continue;
          paramacjc.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return new bakj[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkq
 * JD-Core Version:    0.7.0.1
 */