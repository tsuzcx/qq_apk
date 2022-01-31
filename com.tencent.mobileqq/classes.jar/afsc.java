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

public class afsc
  extends aekw
{
  int jdField_a_of_type_Int = 0;
  azqp jdField_a_of_type_Azqp;
  int c = 0;
  int d = 0;
  
  public afsc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296314) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131297957));
    this.d = paramContext.getResources().getDimensionPixelSize(2131297956);
    paramQQAppInterface = (aely)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
  }
  
  private int a(afse paramafse)
  {
    int i = paramafse.c.getBackground().getIntrinsicWidth();
    return paramafse.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, afse paramafse)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558782, null);
      paramafse.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364770);
      paramafse.c = ((TextView)paramView.findViewById(2131377552));
      paramafse.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377884));
      paramafse.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363179));
      paramafse.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramafse.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramafse);
      paramafse.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramafse.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramafse.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramafse.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramafse.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected aekx a()
  {
    return new afse(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramaekx = (afse)paramaekx;
    paramView = a(paramView, paramaekx);
    paramaekx.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramaekx.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramaeov = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(awkm.jdField_a_of_type_JavaLangString, new Object[] { paramaeov });
    if (!paramaekx.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramaekx.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramaekx.c.getText().equals(paramLinearLayout.text)) {
      paramaekx.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372303);
    Object localObject = (Integer)paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372302);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bdal.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      azqp localazqp;
      if (k != 0)
      {
        localObject = new azqp(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localazqp = new azqp(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramaekx), a(paramaekx), localazqp, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bcuq.s);
            paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372303, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372302, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Azqp == null) {
                this.jdField_a_of_type_Azqp = new azqp(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramaekx.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Azqp);
              if (e)
              {
                paramaekx.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramaekx.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramaekx.jdField_b_of_type_AndroidViewView.setTag(paramaekx);
              paramaekx.jdField_b_of_type_AndroidViewView.setOnClickListener(new afsd(this, paramLinearLayout, paramaeov));
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
          paramaekx.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return new bdlb[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsc
 * JD-Core Version:    0.7.0.1
 */