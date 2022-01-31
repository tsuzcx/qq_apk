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

public class advp
  extends actm
{
  int jdField_a_of_type_Int = 0;
  axuv jdField_a_of_type_Axuv;
  int c = 0;
  int d = 0;
  
  public advp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296308) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131297936));
    this.d = paramContext.getResources().getDimensionPixelSize(2131297935);
    paramQQAppInterface = (acuo)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
  }
  
  private int a(advr paramadvr)
  {
    int i = paramadvr.c.getBackground().getIntrinsicWidth();
    return paramadvr.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, advr paramadvr)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558746, null);
      paramadvr.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364691);
      paramadvr.c = ((TextView)paramView.findViewById(2131377032));
      paramadvr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377350));
      paramadvr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363143));
      paramadvr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramadvr.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramadvr);
      paramadvr.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramadvr.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramadvr.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramadvr.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramadvr.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected actn a()
  {
    return new advr(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramactn = (advr)paramactn;
    paramView = a(paramView, paramactn);
    paramactn.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramactn.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramacxj = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(auta.jdField_a_of_type_JavaLangString, new Object[] { paramacxj });
    if (!paramactn.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramactn.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramactn.c.getText().equals(paramLinearLayout.text)) {
      paramactn.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131371986);
    Object localObject = (Integer)paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131371985);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bbbr.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      axuv localaxuv;
      if (k != 0)
      {
        localObject = new axuv(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localaxuv = new axuv(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramactn), a(paramactn), localaxuv, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bavw.s);
            paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131371986, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131371985, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Axuv == null) {
                this.jdField_a_of_type_Axuv = new axuv(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramactn.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Axuv);
              if (e)
              {
                paramactn.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramactn.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramactn.jdField_b_of_type_AndroidViewView.setTag(paramactn);
              paramactn.jdField_b_of_type_AndroidViewView.setOnClickListener(new advq(this, paramLinearLayout, paramacxj));
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
          paramactn.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return new bbmh[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advp
 * JD-Core Version:    0.7.0.1
 */