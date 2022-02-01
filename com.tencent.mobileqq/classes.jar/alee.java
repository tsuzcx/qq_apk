import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alee
  implements View.OnClickListener
{
  alee(aldh paramaldh, long paramLong, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (aldh.a(this.jdField_a_of_type_Aldh) != null)
    {
      localObject = aldh.a(this.jdField_a_of_type_Aldh).obtainMessage(1134028);
      aldh.a(this.jdField_a_of_type_Aldh).sendMessage((Message)localObject);
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("bookid", this.jdField_a_of_type_Long);
    ((Intent)localObject).putExtra("chapterid", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("is_from_conversation", true);
    Intent localIntent = new Intent();
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(aldh.a(this.jdField_a_of_type_Aldh), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    aldh.a(this.jdField_a_of_type_Aldh).startActivity(localIntent);
    bdla.a(aldh.a(this.jdField_a_of_type_Aldh).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 1, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alee
 * JD-Core Version:    0.7.0.1
 */