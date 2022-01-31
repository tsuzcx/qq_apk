import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public final class aclc
  implements beac
{
  public aclc(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void callback(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "showDlgWithCuOpenCheck type = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.a.onClick(null, 0);
      return;
    }
    this.b.onClick(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclc
 * JD-Core Version:    0.7.0.1
 */