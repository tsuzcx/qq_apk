import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.armap.map.ARGridMapViewDialog;

class abgh
  implements DialogInterface.OnClickListener
{
  abgh(abgg paramabgg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = String.format("https://mma.qq.com/poi_feedback/index.html?_wv=1&poiid=%s", new Object[] { String.valueOf(this.a.jdField_a_of_type_Long) });
    Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramDialogInterface);
    this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARGridMapViewDialog.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgh
 * JD-Core Version:    0.7.0.1
 */