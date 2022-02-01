import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicJumpActivity;
import org.json.JSONObject;

class akir
  implements View.OnClickListener
{
  akir(akho paramakho, String paramString) {}
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "20");
      label17:
      Intent localIntent = new Intent(akho.a(this.jdField_a_of_type_Akho), VipComicJumpActivity.class);
      localIntent.putExtra("options", localJSONObject.toString());
      akho.a(this.jdField_a_of_type_Akho).startActivity(localIntent);
      bkfq.a(akho.a(this.jdField_a_of_type_Akho).getAppInterface(), "100007", "2", "40040", this.jdField_a_of_type_JavaLangString, new String[0]);
      bcef.a(akho.a(this.jdField_a_of_type_Akho).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 2, 0, "", "", "", "");
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
 * Qualified Name:     akir
 * JD-Core Version:    0.7.0.1
 */