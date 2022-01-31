import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

class ahld
  implements View.OnClickListener
{
  ahld(ahkd paramahkd, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("from", "20");
      label17:
      Intent localIntent = new Intent(ahkd.a(this.jdField_a_of_type_Ahkd), VipComicJumpActivity.class);
      localIntent.putExtra("options", paramView.toString());
      ahkd.a(this.jdField_a_of_type_Ahkd).startActivity(localIntent);
      bghx.a(ahkd.a(this.jdField_a_of_type_Ahkd).getAppInterface(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      axqy.a(ahkd.a(this.jdField_a_of_type_Ahkd).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahld
 * JD-Core Version:    0.7.0.1
 */