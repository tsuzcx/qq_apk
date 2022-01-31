import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.armap.ARMapActivity;
import java.util.List;

public class aatb
  implements Handler.Callback
{
  public aatb(ARMapActivity paramARMapActivity) {}
  
  @TargetApi(11)
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.a.jdField_c_of_type_Int = paramMessage.arg1;
      if (this.a.jdField_c_of_type_Int == 4)
      {
        int i = paramMessage.arg2;
        this.a.a(i);
        continue;
        float f = ((Float)paramMessage.obj).floatValue();
        this.a.jdField_c_of_type_AndroidWidgetImageView.setRotation(f - 45.0F);
        ARMapActivity.a(this.a, -f);
        continue;
        ARMapActivity.a(this.a, (List)paramMessage.obj);
        continue;
        ARMapActivity.e(this.a);
        continue;
        ARMapActivity.g(this.a, false);
        continue;
        if (this.a.a == null)
        {
          this.a.a = new ProgressDialog(this.a, 2131624515);
          this.a.a.setCanceledOnTouchOutside(false);
          this.a.a.show();
          this.a.a.setContentView(2130969181);
        }
        ((TextView)this.a.a.findViewById(2131363381)).setText("正在加载...");
        if ((!this.a.a.isShowing()) && (!this.a.isFinishing()))
        {
          this.a.a.show();
          continue;
          ARMapActivity.f(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aatb
 * JD-Core Version:    0.7.0.1
 */