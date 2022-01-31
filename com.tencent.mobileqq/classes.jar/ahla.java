import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ahla
  implements View.OnClickListener
{
  ahla(ahkf paramahkf, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ahkf.a(this.jdField_a_of_type_Ahkf) != null)
    {
      paramView = ahkf.a(this.jdField_a_of_type_Ahkf).obtainMessage(1134028);
      ahkf.a(this.jdField_a_of_type_Ahkf).sendMessage(paramView);
    }
    paramView = new Intent();
    paramView.putExtra("bookid", this.jdField_a_of_type_Long);
    paramView.putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(ahkf.a(this.jdField_a_of_type_Ahkf), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    ahkf.a(this.jdField_a_of_type_Ahkf).startActivity(localIntent);
    axqw.a(ahkf.a(this.jdField_a_of_type_Ahkf).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahla
 * JD-Core Version:    0.7.0.1
 */