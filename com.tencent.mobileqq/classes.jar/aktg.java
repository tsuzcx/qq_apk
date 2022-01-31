import android.content.Context;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppDialog;

public class aktg
  implements Runnable
{
  public aktg(MyAppDialog paramMyAppDialog, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 100;
    int i = this.jdField_a_of_type_Int;
    LogUtility.c("MyAppApi", "updateView--progress--" + i + " state = " + this.b);
    Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.getContext().getResources();
    switch (this.b)
    {
    default: 
      localObject = null;
      if (i < 0)
      {
        j = 0;
        label124:
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a.getVisibility() != 0)
        {
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a.setVisibility(0);
          this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.e.setVisibility(0);
        }
        if (this.b != 3) {
          break label298;
        }
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.c.setText(null);
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a.setProgress(j);
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.e.setText((CharSequence)localObject);
      return;
      localObject = ((Resources)localObject).getString(2131428538, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131428539);
      break;
      localObject = ((Resources)localObject).getString(2131428540, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131428541);
      i = 100;
      break;
      localObject = ((Resources)localObject).getString(2131428540);
      break;
      if (i > 100) {
        break label124;
      }
      j = i;
      break label124;
      label298:
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aktg
 * JD-Core Version:    0.7.0.1
 */