import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ahky
  implements View.OnClickListener
{
  ahky(ahkd paramahkd, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ahkd.a(this.jdField_a_of_type_Ahkd) != null)
    {
      paramView = ahkd.a(this.jdField_a_of_type_Ahkd).obtainMessage(1134028);
      ahkd.a(this.jdField_a_of_type_Ahkd).sendMessage(paramView);
    }
    paramView = new Intent();
    paramView.putExtra("bookid", this.jdField_a_of_type_Long);
    paramView.putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(ahkd.a(this.jdField_a_of_type_Ahkd), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    ahkd.a(this.jdField_a_of_type_Ahkd).startActivity(localIntent);
    axqy.a(ahkd.a(this.jdField_a_of_type_Ahkd).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahky
 * JD-Core Version:    0.7.0.1
 */