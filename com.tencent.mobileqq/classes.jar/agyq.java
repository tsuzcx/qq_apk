import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

class agyq
  implements View.OnClickListener
{
  agyq(agxq paramagxq, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("from", "20");
      label17:
      Intent localIntent = new Intent(agxq.a(this.jdField_a_of_type_Agxq), VipComicJumpActivity.class);
      localIntent.putExtra("options", paramView.toString());
      agxq.a(this.jdField_a_of_type_Agxq).startActivity(localIntent);
      bezp.a(agxq.a(this.jdField_a_of_type_Agxq).getAppInterface(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agyq
 * JD-Core Version:    0.7.0.1
 */