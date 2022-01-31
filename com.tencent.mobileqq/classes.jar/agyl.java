import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.os.MqqHandler;

class agyl
  implements View.OnClickListener
{
  agyl(agxq paramagxq, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (agxq.a(this.jdField_a_of_type_Agxq) != null)
    {
      paramView = agxq.a(this.jdField_a_of_type_Agxq).obtainMessage(1134028);
      agxq.a(this.jdField_a_of_type_Agxq).sendMessage(paramView);
    }
    paramView = new Intent();
    paramView.putExtra("bookid", this.jdField_a_of_type_Long);
    paramView.putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(agxq.a(this.jdField_a_of_type_Agxq), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    agxq.a(this.jdField_a_of_type_Agxq).startActivity(localIntent);
    awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyl
 * JD-Core Version:    0.7.0.1
 */