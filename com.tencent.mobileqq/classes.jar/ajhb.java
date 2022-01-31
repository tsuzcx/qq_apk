import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

class ajhb
  implements View.OnClickListener
{
  ajhb(ajgb paramajgb, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("from", "20");
      label17:
      Intent localIntent = new Intent(ajgb.a(this.jdField_a_of_type_Ajgb), VipComicJumpActivity.class);
      localIntent.putExtra("options", paramView.toString());
      ajgb.a(this.jdField_a_of_type_Ajgb).startActivity(localIntent);
      binc.a(ajgb.a(this.jdField_a_of_type_Ajgb).getAppInterface(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      azqs.a(ajgb.a(this.jdField_a_of_type_Ajgb).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhb
 * JD-Core Version:    0.7.0.1
 */