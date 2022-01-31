import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aeys
  implements aeyv
{
  private aeyx jdField_a_of_type_Aeyx;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  private String b;
  private String c;
  
  public aeys(QQAppInterface paramQQAppInterface, aeyx paramaeyx, Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aeyx = paramaeyx;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public int a()
  {
    return 30;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558589, null);
    paramVarArgs.setOnClickListener(new aeyt(this));
    ((TextView)paramVarArgs.findViewById(2131362407)).setText(this.jdField_a_of_type_JavaLangString);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ReaderTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
          }
          paramVarArgs = this.jdField_a_of_type_AndroidContentIntent.getExtras();
          if (paramVarArgs != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ReaderTipsBar", 2, "data == null");
        return;
        str = paramVarArgs.getString("bookname");
        if (!TextUtils.isEmpty(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ReaderTipsBar", 2, "onAIOEvent() : bookName is empty");
      return;
      this.jdField_a_of_type_JavaLangString = String.format(ajyc.a(2131712700), new Object[] { str });
      this.b = paramVarArgs.getString("bookid");
      this.c = paramVarArgs.getString("book_new_id");
      this.jdField_a_of_type_Aeyx.a(this, new Object[0]);
    } while (!QLog.isColorLevel());
    QLog.d("ReaderTipsBar", 2, "onAIOEvent() : show ReaderTipBar, bookName : " + str);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeys
 * JD-Core Version:    0.7.0.1
 */