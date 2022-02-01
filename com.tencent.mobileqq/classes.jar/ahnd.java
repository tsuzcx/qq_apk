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

public class ahnd
  extends agem
{
  int jdField_a_of_type_Int = 0;
  bdor jdField_a_of_type_Bdor;
  int c = 0;
  int d = 0;
  
  public ahnd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296352) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131298050));
    this.d = paramContext.getResources().getDimensionPixelSize(2131298049);
    paramQQAppInterface = (aggr)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 3);
    }
  }
  
  private int a(ahnf paramahnf)
  {
    int i = paramahnf.c.getBackground().getIntrinsicWidth();
    return paramahnf.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, ahnf paramahnf)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558844, null);
      paramahnf.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365046);
      paramahnf.c = ((TextView)paramView.findViewById(2131378603));
      paramahnf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378936));
      paramahnf.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363390));
      paramahnf.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramahnf.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramahnf);
      paramahnf.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramahnf.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramahnf.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramahnf.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahnf.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected agen a()
  {
    return new ahnf(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramagen = (ahnf)paramagen;
    paramView = a(paramView, paramagen);
    paramagen.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramagen.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramagjk = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(azvv.jdField_a_of_type_JavaLangString, new Object[] { paramagjk });
    if (!paramagen.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramagen.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramagen.c.getText().equals(paramLinearLayout.text)) {
      paramagen.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131373029);
    Object localObject = (Integer)paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131373028);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bhjx.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      bdor localbdor;
      if (k != 0)
      {
        localObject = new bdor(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localbdor = new bdor(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramagen), a(paramagen), localbdor, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bhez.t);
            paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131373029, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131373028, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Bdor == null) {
                this.jdField_a_of_type_Bdor = new bdor(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramagen.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Bdor);
              if (e)
              {
                paramagen.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramagen.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramagen.jdField_b_of_type_AndroidViewView.setTag(paramagen);
              paramagen.jdField_b_of_type_AndroidViewView.setOnClickListener(new ahne(this, paramLinearLayout, paramagjk));
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
          paramagen.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return new bhum[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahnd
 * JD-Core Version:    0.7.0.1
 */