import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiar
  extends aift
{
  public aiar(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  public void W()
  {
    super.W();
    c(true);
    if ((this.f != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      String str = autf.d;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        str = ((autd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(358)).a();
      }
      this.f.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131697753) + str);
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i = ((Integer)paramObject).intValue();
    paramObject = "";
    if (i == 2) {
      paramObject = "206997";
    }
    for (;;)
    {
      bmxq.a().a("0", "1", "176", "969", "96902", paramObject, "", "0", "20", "0");
      return;
      if (i == 3) {
        paramObject = "206996";
      } else if (i == 24) {
        paramObject = "207004";
      } else if (i == 4) {
        paramObject = "207000";
      } else if (i == 5) {
        paramObject = "207005";
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10009)
      {
        Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
        paramString = "2";
        bmxq localbmxq;
        if ((localObject instanceof MessageForText))
        {
          paramString = "2";
          localbmxq = bmxq.a();
          if (!paramBoolean) {
            break label130;
          }
        }
        label130:
        for (localObject = "0";; localObject = "1")
        {
          localbmxq.a("0", "1", "176", "969", "96902", "206999", paramString, "0", "20", (String)localObject);
          return;
          if ((localObject instanceof MessageForPic))
          {
            paramString = "0";
            break;
          }
          if (!(localObject instanceof MessageForPtt)) {
            break;
          }
          paramString = "1";
          break;
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("GameBuddyChatPie", 1, paramString, new Object[0]);
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void o(int paramInt)
  {
    super.o(paramInt);
    bmxq.a().a("0", "1", "176", "969", "96901", "206994", "", "0", "7", "0");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bmxq.a().a("0", "1", "176", "969", "96902", "206998", "", "0", "20", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiar
 * JD-Core Version:    0.7.0.1
 */