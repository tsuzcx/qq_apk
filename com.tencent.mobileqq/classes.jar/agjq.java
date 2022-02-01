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

public class agjq
  extends aexf
{
  int jdField_a_of_type_Int = 0;
  bchc jdField_a_of_type_Bchc;
  int c = 0;
  int d = 0;
  
  public agjq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296405) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131298115));
    this.d = paramContext.getResources().getDimensionPixelSize(2131298114);
    paramQQAppInterface = (aezm)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 3);
    }
  }
  
  private int a(agjs paramagjs)
  {
    int i = paramagjs.c.getBackground().getIntrinsicWidth();
    return paramagjs.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, agjs paramagjs)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558852, null);
      paramagjs.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365073);
      paramagjs.c = ((TextView)paramView.findViewById(2131378367));
      paramagjs.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378707));
      paramagjs.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363417));
      paramagjs.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramagjs.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramagjs);
      paramagjs.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramagjs.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramagjs.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramagjs.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramagjs.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected aexg a()
  {
    return new agjs(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramaexg = (agjs)paramaexg;
    paramView = a(paramView, paramaexg);
    paramaexg.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramaexg.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramafce = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, 6);
    String str = String.format(aykk.jdField_a_of_type_JavaLangString, new Object[] { paramafce });
    if (!paramaexg.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramaexg.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramaexg.c.getText().equals(paramLinearLayout.text)) {
      paramaexg.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramaexg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372999);
    Object localObject = (Integer)paramaexg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372998);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bftf.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      bchc localbchc;
      if (k != 0)
      {
        localObject = new bchc(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localbchc = new bchc(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramaexg), a(paramaexg), localbchc, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bfol.t);
            paramaexg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramaexg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372999, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramaexg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramaexg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372998, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Bchc == null) {
                this.jdField_a_of_type_Bchc = new bchc(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramaexg.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Bchc);
              if (e)
              {
                paramaexg.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramaexg.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramaexg.jdField_b_of_type_AndroidViewView.setTag(paramaexg);
              paramaexg.jdField_b_of_type_AndroidViewView.setOnClickListener(new agjr(this, paramLinearLayout, paramafce));
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
          paramaexg.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bgbb[] a(View paramView)
  {
    return new bgbb[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjq
 * JD-Core Version:    0.7.0.1
 */