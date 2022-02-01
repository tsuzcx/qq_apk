import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

class alkz
  implements View.OnClickListener
{
  alkz(aljw paramaljw, String paramString) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "20");
      label17:
      Intent localIntent = new Intent(aljw.a(this.jdField_a_of_type_Aljw), VipComicJumpActivity.class);
      localIntent.putExtra("options", localJSONObject.toString());
      aljw.a(this.jdField_a_of_type_Aljw).startActivity(localIntent);
      bmbt.a(aljw.a(this.jdField_a_of_type_Aljw).getAppInterface(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      bdll.a(aljw.a(this.jdField_a_of_type_Aljw).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkz
 * JD-Core Version:    0.7.0.1
 */