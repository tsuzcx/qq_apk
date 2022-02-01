import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Locale;

public class agqz
  extends afor
{
  public agqz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new agrb();
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)paramMessageRecord;
    agrb localagrb = (agrb)paramafos;
    paramLinearLayout = paramView;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558863, null);
      localagrb.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131379001));
      localagrb.c = ((TextView)paramLinearLayout.findViewById(2131365190));
      localagrb.d = ((TextView)paramLinearLayout.findViewById(2131378221));
      localagrb.jdField_b_of_type_AndroidViewView = paramLinearLayout.findViewById(2131365157);
      localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363486));
      localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setPressMask(true);
      localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnClickListener(new agra(this));
    }
    localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(localMessageForConfessNews);
    localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setBgType(localMessageForConfessNews.nBGType);
    localagrb.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localagrb.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    int i;
    boolean bool1;
    Object localObject;
    label251:
    String str2;
    String str1;
    label306:
    StringBuilder localStringBuilder;
    if ((paramMessageRecord.istroop != 0) || (paramMessageRecord.istroop == 1))
    {
      i = 1;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForConfessNews.strConfessorUin);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localMessageForConfessNews.strRecUin);
      if (!bool2) {
        break label574;
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { anvx.a(2131701904) });
      localagrb.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      str2 = localMessageForConfessNews.strConfessorDesc;
      float f = aqvq.a(str2);
      paramView = localMessageForConfessNews.strConfessorNick;
      if (bool1) {
        paramView = anvx.a(2131701903);
      }
      if (localMessageForConfessNews.confessTime > 0L) {
        break label692;
      }
      str1 = "";
      localStringBuilder = new StringBuilder();
      if (localMessageForConfessNews.nBizType != 1) {
        break label741;
      }
      if (!bool2) {
        break label712;
      }
      paramView = anvx.a(2131701908);
      label335:
      localStringBuilder.append(String.format(Locale.getDefault(), anvx.a(2131701907), new Object[] { Integer.valueOf(localMessageForConfessNews.nConfessNum), paramView }));
      label371:
      localagrb.d.setText(localStringBuilder.toString());
      if (f <= 8.0F) {
        break label792;
      }
      localagrb.c.setTextSize(1, 21.0F);
      localagrb.c.setLineSpacing(0.0F, 1.2F);
      if ((f > 12.0F) || (!aqvq.a(str2))) {
        break label814;
      }
      i = (int)(f * 0.7D);
    }
    label792:
    label814:
    for (paramView = str2.substring(0, i) + "\n" + str2.substring(i, str2.length());; paramView = str2)
    {
      localagrb.c.setText(paramView);
      if (e)
      {
        paramafos.b.append((String)localObject).append(paramView).append(",").append(localStringBuilder.toString());
        paramLinearLayout.setContentDescription(paramafos.b.toString());
      }
      localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(paramMessageRecord);
      localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnTouchListener(paramaftk);
      localagrb.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnLongClickListener(paramaftk);
      return paramLinearLayout;
      i = 0;
      break;
      label574:
      localObject = localMessageForConfessNews.strRecNick;
      paramView = (View)localObject;
      if (i != 0) {
        if (localMessageForConfessNews.nRecNickType != 1)
        {
          paramView = (View)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        }
        else
        {
          str1 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForConfessNews.strGroupUin, localMessageForConfessNews.strRecUin);
          paramView = (View)localObject;
          if (!TextUtils.isEmpty(str1)) {
            paramView = str1;
          }
        }
      }
      localObject = paramView;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.length() > 7) {
          localObject = aqvn.a(paramView, 7.0F);
        }
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { localObject });
      break label251;
      label692:
      str1 = bhid.a(localMessageForConfessNews.confessTime * 1000L, true, "");
      break label306;
      label712:
      if (localMessageForConfessNews.nGetConfessSex == 1)
      {
        paramView = anvx.a(2131701905);
        break label335;
      }
      paramView = anvx.a(2131701906);
      break label335;
      label741:
      localStringBuilder.append("来自");
      if ((i != 0) && (!bool1)) {}
      localStringBuilder.append(paramView);
      if (TextUtils.isEmpty(str1)) {
        break label371;
      }
      localStringBuilder.append(" | ").append(str1);
      break label371;
      localagrb.c.setTextSize(1, 24.0F);
      localagrb.c.setLineSpacing(0.0F, 1.0F);
    }
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqz
 * JD-Core Version:    0.7.0.1
 */