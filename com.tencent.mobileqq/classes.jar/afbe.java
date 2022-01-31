import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afbe
  implements afal
{
  private int jdField_a_of_type_Int;
  private aipw jdField_a_of_type_Aipw;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView c;
  
  public afbe(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Aipw = ((aipw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125));
  }
  
  private Object[] a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (!nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
        for (arrayOfObject = this.jdField_a_of_type_Aipw.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, paramInt); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt))
        {
          this.jdField_a_of_type_JavaLangString = "";
          this.jdField_b_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().sendEmptyMessage(12);
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString.charAt(0));
          localStringBuilder.append("|");
          localStringBuilder.append(paramString.length());
          QLog.d("PasswdRedBagManager", 2, "passwdredbags result[0]=" + arrayOfObject[0] + ",result[1]=" + arrayOfObject[1] + ",send str=" + localStringBuilder.toString());
          return arrayOfObject;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont search passwdredbags");
    return null;
    return arrayOfObject;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 6) {}
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Aipw != null) && (this.jdField_a_of_type_Aipw.a) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004))) {
          this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        float f;
        if (paramInt != 11) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364226));
          this.c = new TextView(this.jdField_a_of_type_AndroidContentContext);
          this.c.setTextColor(-16777216);
          this.c.setTextSize(1, 12.0F);
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364228));
          f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(alpo.a(2131711803));
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(f * 9.0F + 0.5F));
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364119);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364227));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.c);
          this.c.getLayoutParams().width = -2;
          this.c.getLayoutParams().height = -2;
          if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agot)) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
          try
          {
            betl.a(BaseApplicationImpl.getContext(), false, 54);
            return;
          }
          catch (Throwable localThrowable3)
          {
            QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable3, new Object[0]);
            return;
          }
          localThrowable1 = localThrowable1;
          QLog.e("QWalletAIOLifeCycleHelper", 1, "fetchNewestIdomRedbagWordWhenFirstEnterAIO throw an exception: " + localThrowable1);
          continue;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("QWalletAIOLifeCycleHelper", 1, "init ui throw an exception: " + localThrowable2);
          continue;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agot)) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
      try
      {
        betl.a(BaseApplicationImpl.getContext(), true, 54);
        try
        {
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.c == null)) {
            continue;
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.c);
          this.c = null;
          return;
        }
        catch (Throwable localThrowable4)
        {
          QLog.e("QWalletAIOLifeCycleHelper", 1, QLog.getStackTraceString(localThrowable4));
          return;
        }
      }
      catch (Throwable localThrowable5)
      {
        for (;;)
        {
          QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable5, new Object[0]);
        }
      }
    }
  }
  
  public void a(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.toString().equals(this.jdField_b_of_type_JavaLangString))) {
      a();
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!bdje.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      a();
    }
  }
  
  public void a(String paramString, acfe paramacfe, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramacfe.f = ((Integer)paramString[0]).intValue();
      paramacfe.jdField_d_of_type_Long = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (aipw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramacfe.c = ((String)paramString[2]);
        paramacfe.jdField_d_of_type_JavaLangString = ((String)paramString[3]);
        this.jdField_a_of_type_Aipw = ((aipw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125));
        paramacfe.e = this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramacfe.c, paramacfe.jdField_d_of_type_JavaLangString).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(paramacfe.jdField_d_of_type_Long), Integer.valueOf(paramacfe.f), Boolean.valueOf(paramacfe.e), paramacfe.c, paramacfe.jdField_d_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!bdje.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
    }
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new afbf(this, paramString1, paramString2));
    }
    ((aowg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(19)).a();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString3);
    }
    if (this.c != null)
    {
      this.c.setVisibility(0);
      if (paramInt != 0) {
        break label188;
      }
      this.c.setText(alpo.a(2131721447));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new afbg(this));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
        ((aowg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(19)).a();
      }
      return;
      label188:
      if (paramInt == 1) {
        this.c.setText(alpo.a(2131721443));
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0);
  }
  
  public int[] a()
  {
    return new int[] { 6, 11 };
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("0"))) {
      a();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Int - paramInt > 5)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbe
 * JD-Core Version:    0.7.0.1
 */