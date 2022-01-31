import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.MusicPendantView;

public class alcr
  implements View.OnClickListener
{
  public alcr(MusicPendantView paramMusicPendantView, String paramString, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramView.getContext().startActivity(localIntent);
    ReportController.b(MusicPendantManager.a().a(), "dc00899", "NOW", "", "qq_zlk", "logo_click", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alcr
 * JD-Core Version:    0.7.0.1
 */