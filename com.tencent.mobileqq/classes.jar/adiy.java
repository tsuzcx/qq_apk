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

public class adiy
  implements adih
{
  private int jdField_a_of_type_Int;
  private agvz jdField_a_of_type_Agvz;
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
  
  public adiy(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_Agvz = ((agvz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125));
  }
  
  private Object[] a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (!mye.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
        for (arrayOfObject = this.jdField_a_of_type_Agvz.a(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString, paramInt); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt))
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
    while ((!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aerv)) || (!"3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      try
      {
        if ((this.jdField_a_of_type_Agvz != null) && (this.jdField_a_of_type_Agvz.a) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004))) {
          this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        float f;
        while (paramInt != 11) {}
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364165));
            this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364167));
            f = this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(ajyc.a(2131711420));
            this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(f * 9.0F + 0.5F));
            this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364058);
            this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c.findViewById(2131364166));
            if (((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof aerv)) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
            try
            {
              bctn.a(BaseApplicationImpl.getContext(), false, 54);
              return;
            }
            catch (Throwable localThrowable3)
            {
              QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable3, new Object[0]);
              return;
            }
            localThrowable1 = localThrowable1;
            QLog.e("QWalletAIOLifeCycleHelper", 1, "fetchNewestIdomRedbagWordWhenFirstEnterAIO throw an exception: " + localThrowable1);
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QLog.e("QWalletAIOLifeCycleHelper", 1, "init ui throw an exception: " + localThrowable2);
          }
        }
      }
    }
    try
    {
      bctn.a(BaseApplicationImpl.getContext(), true, 54);
      return;
    }
    catch (Throwable localThrowable4)
    {
      QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable4, new Object[0]);
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
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!bbjw.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      a();
    }
  }
  
  public void a(String paramString, aaok paramaaok, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramaaok.f = ((Integer)paramString[0]).intValue();
      paramaaok.jdField_d_of_type_Long = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (agvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramaaok.c = ((String)paramString[2]);
        paramaaok.jdField_d_of_type_JavaLangString = ((String)paramString[3]);
        this.jdField_a_of_type_Agvz = ((agvz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125));
        paramaaok.e = this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaaok.c, paramaaok.jdField_d_of_type_JavaLangString).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(paramaaok.jdField_d_of_type_Long), Integer.valueOf(paramaaok.f), Boolean.valueOf(paramaaok.e), paramaaok.c, paramaaok.jdField_d_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (!bbjw.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString1)))
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
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new adiz(this, paramString1, paramString2));
    }
    ((aneu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(19)).a();
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
  
  public void b(String paramString1, String paramString2, String paramString3)
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
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new adja(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      ((aneu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(19)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adiy
 * JD-Core Version:    0.7.0.1
 */