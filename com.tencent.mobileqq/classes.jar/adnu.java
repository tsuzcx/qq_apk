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

public class adnu
  extends actm
{
  public adnu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new adnw();
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)paramMessageRecord;
    adnw localadnw = (adnw)paramactn;
    paramLinearLayout = paramView;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558731, null);
      localadnw.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131377350));
      localadnw.c = ((TextView)paramLinearLayout.findViewById(2131364720));
      localadnw.d = ((TextView)paramLinearLayout.findViewById(2131376633));
      localadnw.jdField_b_of_type_AndroidViewView = paramLinearLayout.findViewById(2131364691);
      localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363143));
      localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setPressMask(true);
      localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnClickListener(new adnv(this));
    }
    localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(localMessageForConfessNews);
    localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setBgType(localMessageForConfessNews.nBGType);
    localadnw.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    localadnw.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
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
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { ajya.a(2131702407) });
      localadnw.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      str2 = localMessageForConfessNews.strConfessorDesc;
      float f = amoa.a(str2);
      paramView = localMessageForConfessNews.strConfessorNick;
      if (bool1) {
        paramView = ajya.a(2131702406);
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
      paramView = ajya.a(2131702411);
      label335:
      localStringBuilder.append(String.format(Locale.getDefault(), ajya.a(2131702410), new Object[] { Integer.valueOf(localMessageForConfessNews.nConfessNum), paramView }));
      label371:
      localadnw.d.setText(localStringBuilder.toString());
      if (f <= 8.0F) {
        break label792;
      }
      localadnw.c.setTextSize(1, 21.0F);
      localadnw.c.setLineSpacing(0.0F, 1.2F);
      if ((f > 12.0F) || (!amoa.a(str2))) {
        break label814;
      }
      i = (int)(f * 0.7D);
    }
    label792:
    label814:
    for (paramView = str2.substring(0, i) + "\n" + str2.substring(i, str2.length());; paramView = str2)
    {
      localadnw.c.setText(paramView);
      if (e)
      {
        paramactn.b.append((String)localObject).append(paramView).append(",").append(localStringBuilder.toString());
        paramLinearLayout.setContentDescription(paramactn.b.toString());
      }
      localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setTag(paramMessageRecord);
      localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnTouchListener(paramacxj);
      localadnw.jdField_a_of_type_ComTencentMobileqqConfessConfessNewsBgView.setOnLongClickListener(paramacxj);
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
          str1 = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForConfessNews.strGroupUin, localMessageForConfessNews.strRecUin);
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
          localObject = amnx.a(paramView, 7.0F);
        }
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { localObject });
      break label251;
      label692:
      str1 = bbkp.a(localMessageForConfessNews.confessTime * 1000L, true, "");
      break label306;
      label712:
      if (localMessageForConfessNews.nGetConfessSex == 1)
      {
        paramView = ajya.a(2131702408);
        break label335;
      }
      paramView = ajya.a(2131702409);
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
      localadnw.c.setTextSize(1, 24.0F);
      localadnw.c.setLineSpacing(0.0F, 1.0F);
    }
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = new bbmf();
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnu
 * JD-Core Version:    0.7.0.1
 */