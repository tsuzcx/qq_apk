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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import java.net.MalformedURLException;
import java.net.URL;

public class ahcg
  extends afor
{
  int jdField_a_of_type_Int = 0;
  bdoa jdField_a_of_type_Bdoa;
  int c = 0;
  int d = 0;
  
  public ahcg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296405) * 2);
    this.c = ((int)paramContext.getResources().getDimension(2131298118));
    this.d = paramContext.getResources().getDimensionPixelSize(2131298117);
    paramQQAppInterface = (afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 3);
    }
  }
  
  private int a(ahci paramahci)
  {
    int i = paramahci.c.getBackground().getIntrinsicWidth();
    return paramahci.c.getBackground().getIntrinsicHeight() * this.jdField_a_of_type_Int / i;
  }
  
  private View a(View paramView, ahci paramahci)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558877, null);
      paramahci.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365157);
      paramahci.c = ((TextView)paramView.findViewById(2131378658));
      paramahci.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
      paramahci.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131363486));
      paramahci.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.c);
      paramahci.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
      int i = a(paramahci);
      paramahci.c.getLayoutParams().width = this.jdField_a_of_type_Int;
      paramahci.c.getLayoutParams().height = i;
      localView = paramView;
      if (e)
      {
        paramahci.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramahci.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahci.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected afos a()
  {
    return new ahci(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    paramafos = (ahci)paramafos;
    paramView = a(paramView, paramafos);
    paramafos.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramafos.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramaftk = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, 6);
    String str = String.format(azpf.jdField_a_of_type_JavaLangString, new Object[] { paramaftk });
    if (!paramafos.jdField_b_of_type_AndroidWidgetTextView.getText().equals(str)) {
      paramafos.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    if (!paramafos.c.getText().equals(paramLinearLayout.text)) {
      paramafos.c.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131373209);
    Object localObject = (Integer)paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131373208);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!bhbx.a(paramLinearLayout.cover, paramMessageRecord))) {
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
      bdoa localbdoa;
      if (k != 0)
      {
        localObject = new bdoa(paramLinearLayout.bgColor, this.c * 3, this.c * 3, this.c);
        localbdoa = new bdoa(0, this.c * 3, this.c * 3, this.c);
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
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(paramafos), a(paramafos), localbdoa, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(bgxc.t);
            paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
            paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131373209, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable((Drawable)localObject);
              paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131373208, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.jdField_a_of_type_Bdoa == null) {
                this.jdField_a_of_type_Bdoa = new bdoa(Color.parseColor("#66000000"), this.c * 3, this.c * 3, this.c);
              }
              paramafos.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Bdoa);
              if (e)
              {
                paramafos.jdField_b_of_type_JavaLangStringBuilder.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(paramafos.jdField_b_of_type_JavaLangStringBuilder.toString());
              }
              paramafos.jdField_b_of_type_AndroidViewView.setTag(paramafos);
              paramafos.jdField_b_of_type_AndroidViewView.setOnClickListener(new ahch(this, paramLinearLayout, paramaftk));
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
          paramafos.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcg
 * JD-Core Version:    0.7.0.1
 */