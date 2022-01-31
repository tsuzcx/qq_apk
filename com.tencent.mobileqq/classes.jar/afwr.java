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

public class afwr
  extends aepl
{
  int jdField_a_of_type_Int = 0;
  azuy jdField_a_of_type_Azuy;
  int c = 0;
  int d = 0;
  
  public afwr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296314) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131297957));
    this.d = paramContext.getResources().getDimensionPixelSize(2131297956);
    paramQQAppInterface = (aeqn)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 1);
    }
  }
  
  private int a(afwt paramafwt)
  {
    int i = paramafwt.c.getBackground().getIntrinsicWidth();
    return paramafwt.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, afwt paramafwt)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558781, null);
      paramafwt.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364771);
      paramafwt.c = ((TextView)paramView.findViewById(2131377606));
      paramafwt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377938));
      paramafwt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363179));
      paramafwt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramafwt.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramafwt);
      paramafwt.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramafwt.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramafwt.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramafwt.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramafwt.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected aepm a()
  {
    return new afwt(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramaepm = (afwt)paramaepm;
    paramView = a(paramView, paramaepm);
    paramaepm.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramaepm.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramaetk = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    String str = String.format(awov.jdField_a_of_type_JavaLangString, new Object[] { paramaetk });
    if (!paramaepm.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramaepm.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramaepm.c.getText().equals(paramLinearLayout.text)) {
      paramaepm.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramaepm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372323);
    Object localObject = (Integer)paramaepm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372322);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bdeu.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      azuy localazuy;
      if (k != 0)
      {
        localObject = new azuy(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localazuy = new azuy(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramaepm), a(paramaepm), localazuy, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bcyz.s);
            paramaepm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramaepm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372323, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramaepm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramaepm.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372322, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Azuy == null) {
                this.jdField_a_of_type_Azuy = new azuy(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramaepm.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Azuy);
              if (e)
              {
                paramaepm.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramaepm.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramaepm.jdField_b_of_type_AndroidViewView.setTag(paramaepm);
              paramaepm.jdField_b_of_type_AndroidViewView.setOnClickListener(new afws(this, paramLinearLayout, paramaetk));
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
          paramaepm.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdpk[] a(View paramView)
  {
    return new bdpk[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwr
 * JD-Core Version:    0.7.0.1
 */