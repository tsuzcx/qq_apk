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

public class ahdr
  extends afuu
{
  int jdField_a_of_type_Int = 0;
  bcvy jdField_a_of_type_Bcvy;
  int c = 0;
  int d = 0;
  
  public ahdr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296348) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131298038));
    this.d = paramContext.getResources().getDimensionPixelSize(2131298037);
    paramQQAppInterface = (afwx)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 3);
    }
  }
  
  private int a(ahdt paramahdt)
  {
    int i = paramahdt.c.getBackground().getIntrinsicWidth();
    return paramahdt.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, ahdt paramahdt)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558846, null);
      paramahdt.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364999);
      paramahdt.c = ((TextView)paramView.findViewById(2131378445));
      paramahdt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378776));
      paramahdt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363367));
      paramahdt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramahdt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramahdt);
      paramahdt.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramahdt.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramahdt.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramahdt.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahdt.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected afuv a()
  {
    return new ahdt(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramafuv = (ahdt)paramafuv;
    paramView = a(paramView, paramafuv);
    paramafuv.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramafuv.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramafzq = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(azdi.jdField_a_of_type_JavaLangString, new Object[] { paramafzq });
    if (!paramafuv.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramafuv.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramafuv.c.getText().equals(paramLinearLayout.text)) {
      paramafuv.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramafuv.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372916);
    Object localObject = (Integer)paramafuv.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372915);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bgjw.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      bcvy localbcvy;
      if (k != 0)
      {
        localObject = new bcvy(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localbcvy = new bcvy(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramafuv), a(paramafuv), localbcvy, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bgey.t);
            paramafuv.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramafuv.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372916, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramafuv.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramafuv.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372915, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Bcvy == null) {
                this.jdField_a_of_type_Bcvy = new bcvy(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramafuv.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Bcvy);
              if (e)
              {
                paramafuv.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramafuv.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramafuv.jdField_b_of_type_AndroidViewView.setTag(paramafuv);
              paramafuv.jdField_b_of_type_AndroidViewView.setOnClickListener(new ahds(this, paramLinearLayout, paramafzq));
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
          paramafuv.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdr
 * JD-Core Version:    0.7.0.1
 */