import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ajch
  implements View.OnClickListener
{
  ajch(ajbm paramajbm, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ajbm.a(this.jdField_a_of_type_Ajbm) != null)
    {
      paramView = ajbm.a(this.jdField_a_of_type_Ajbm).obtainMessage(1134028);
      ajbm.a(this.jdField_a_of_type_Ajbm).sendMessage(paramView);
    }
    paramView = new Intent();
    paramView.putExtra("bookid", this.jdField_a_of_type_Long);
    paramView.putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(ajbm.a(this.jdField_a_of_type_Ajbm), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    ajbm.a(this.jdField_a_of_type_Ajbm).startActivity(localIntent);
    azmj.a(ajbm.a(this.jdField_a_of_type_Ajbm).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajch
 * JD-Core Version:    0.7.0.1
 */