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
import java.util.Locale;

public class ahbx
  extends agem
{
  public ahbx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahbz();
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)paramMessageRecord;
    ahbz localahbz = (ahbz)paramagen;
    paramLinearLayout = paramView;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558830, null);
      localahbz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131378936));
      localahbz.c = ((TextView)paramLinearLayout.findViewById(2131365078));
      localahbz.d = ((TextView)paramLinearLayout.findViewById(2131378163));
      localahbz.jdField_b_of_type_AndroidViewView = paramLinearLayout.findViewById(2131365046);
      localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363390));
      localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setPressMask(true);
      localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnClickListener(new ahby(this));
    }
    localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(localMessageForConfessNews);
    localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setBgType(localMessageForConfessNews.nBGType);
    localahbz.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localahbz.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
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
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { anzj.a(2131701318) });
      localahbz.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      str2 = localMessageForConfessNews.strConfessorDesc;
      float f = aqzc.a(str2);
      paramView = localMessageForConfessNews.strConfessorNick;
      if (bool1) {
        paramView = anzj.a(2131701317);
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
      paramView = anzj.a(2131701322);
      label335:
      localStringBuilder.append(String.format(Locale.getDefault(), anzj.a(2131701321), new Object[] { Integer.valueOf(localMessageForConfessNews.nConfessNum), paramView }));
      label371:
      localahbz.d.setText(localStringBuilder.toString());
      if (f <= 8.0F) {
        break label792;
      }
      localahbz.c.setTextSize(1, 21.0F);
      localahbz.c.setLineSpacing(0.0F, 1.2F);
      if ((f > 12.0F) || (!aqzc.a(str2))) {
        break label814;
      }
      i = (int)(f * 0.7D);
    }
    label792:
    label814:
    for (paramView = str2.substring(0, i) + "\n" + str2.substring(i, str2.length());; paramView = str2)
    {
      localahbz.c.setText(paramView);
      if (e)
      {
        paramagen.b.append((String)localObject).append(paramView).append(",").append(localStringBuilder.toString());
        paramLinearLayout.setContentDescription(paramagen.b.toString());
      }
      localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(paramMessageRecord);
      localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnTouchListener(paramagjk);
      localahbz.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnLongClickListener(paramagjk);
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
          str1 = bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForConfessNews.strGroupUin, localMessageForConfessNews.strRecUin);
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
          localObject = aqyz.a(paramView, 7.0F);
        }
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { localObject });
      break label251;
      label692:
      str1 = bhsw.a(localMessageForConfessNews.confessTime * 1000L, true, "");
      break label306;
      label712:
      if (localMessageForConfessNews.nGetConfessSex == 1)
      {
        paramView = anzj.a(2131701319);
        break label335;
      }
      paramView = anzj.a(2131701320);
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
      localahbz.c.setTextSize(1, 24.0F);
      localahbz.c.setLineSpacing(0.0F, 1.0F);
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbx
 * JD-Core Version:    0.7.0.1
 */