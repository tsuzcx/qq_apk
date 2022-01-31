import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

class ahlf
  implements View.OnClickListener
{
  ahlf(ahkf paramahkf, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("from", "20");
      label17:
      Intent localIntent = new Intent(ahkf.a(this.jdField_a_of_type_Ahkf), VipComicJumpActivity.class);
      localIntent.putExtra("options", paramView.toString());
      ahkf.a(this.jdField_a_of_type_Ahkf).startActivity(localIntent);
      bghg.a(ahkf.a(this.jdField_a_of_type_Ahkf).getAppInterface(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      axqw.a(ahkf.a(this.jdField_a_of_type_Ahkf).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlf
 * JD-Core Version:    0.7.0.1
 */