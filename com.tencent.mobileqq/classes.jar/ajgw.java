import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class ajgw
  implements View.OnClickListener
{
  ajgw(ajgb paramajgb, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ajgb.a(this.jdField_a_of_type_Ajgb) != null)
    {
      paramView = ajgb.a(this.jdField_a_of_type_Ajgb).obtainMessage(1134028);
      ajgb.a(this.jdField_a_of_type_Ajgb).sendMessage(paramView);
    }
    paramView = new Intent();
    paramView.putExtra("bookid", this.jdField_a_of_type_Long);
    paramView.putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(ajgb.a(this.jdField_a_of_type_Ajgb), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    ajgb.a(this.jdField_a_of_type_Ajgb).startActivity(localIntent);
    azqs.a(ajgb.a(this.jdField_a_of_type_Ajgb).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgw
 * JD-Core Version:    0.7.0.1
 */