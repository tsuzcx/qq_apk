import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alku
  implements View.OnClickListener
{
  alku(aljw paramaljw, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (aljw.a(this.jdField_a_of_type_Aljw) != null)
    {
      localObject = aljw.a(this.jdField_a_of_type_Aljw).obtainMessage(1134028);
      aljw.a(this.jdField_a_of_type_Aljw).sendMessage((Message)localObject);
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("bookid", this.jdField_a_of_type_Long);
    ((Intent)localObject).putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(aljw.a(this.jdField_a_of_type_Aljw), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    aljw.a(this.jdField_a_of_type_Aljw).startActivity(localIntent);
    bdll.a(aljw.a(this.jdField_a_of_type_Aljw).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alku
 * JD-Core Version:    0.7.0.1
 */