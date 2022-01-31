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

public class advr
  extends actq
{
  int jdField_a_of_type_Int = 0;
  axut jdField_a_of_type_Axut;
  int c = 0;
  int d = 0;
  
  public advr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296308) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131297936));
    this.d = paramContext.getResources().getDimensionPixelSize(2131297935);
    paramQQAppInterface = (acus)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
  }
  
  private int a(advt paramadvt)
  {
    int i = paramadvt.c.getBackground().getIntrinsicWidth();
    return paramadvt.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, advt paramadvt)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558746, null);
      paramadvt.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364692);
      paramadvt.c = ((TextView)paramView.findViewById(2131377030));
      paramadvt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
      paramadvt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363144));
      paramadvt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramadvt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramadvt);
      paramadvt.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramadvt.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramadvt.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramadvt.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramadvt.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected actr a()
  {
    return new advt(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramactr = (advt)paramactr;
    paramView = a(paramView, paramactr);
    paramactr.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramactr.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramacxn = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(ausy.jdField_a_of_type_JavaLangString, new Object[] { paramacxn });
    if (!paramactr.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramactr.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramactr.c.getText().equals(paramLinearLayout.text)) {
      paramactr.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramactr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131371986);
    Object localObject = (Integer)paramactr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131371985);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bbbd.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      axut localaxut;
      if (k != 0)
      {
        localObject = new axut(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localaxut = new axut(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramactr), a(paramactr), localaxut, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bavi.s);
            paramactr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramactr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131371986, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramactr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramactr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131371985, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Axut == null) {
                this.jdField_a_of_type_Axut = new axut(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramactr.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Axut);
              if (e)
              {
                paramactr.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramactr.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramactr.jdField_b_of_type_AndroidViewView.setTag(paramactr);
              paramactr.jdField_b_of_type_AndroidViewView.setOnClickListener(new advs(this, paramLinearLayout, paramacxn));
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
          paramactr.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bblt[] a(View paramView)
  {
    return new bblt[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advr
 * JD-Core Version:    0.7.0.1
 */