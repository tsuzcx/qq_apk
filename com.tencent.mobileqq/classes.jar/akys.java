import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;

class akys
  implements Runnable
{
  akys(akyr paramakyr, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Akyr.a.getActivity() == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Akyr.a.getActivity().sendBroadcast(localIntent);
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_Akyr.a.getString(2131439376), 1).b(this.jdField_a_of_type_Akyr.a.getActivity().getTitleBarHeight());
      WorldCupShareFragment.c(this.jdField_a_of_type_Akyr.a, this.jdField_a_of_type_JavaLangString);
      WorldCupShareFragment.a("0X800931C");
    }
    for (;;)
    {
      this.jdField_a_of_type_Akyr.a.jdField_a_of_type_Boolean = true;
      return;
      QRUtils.a(1, 2131430002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akys
 * JD-Core Version:    0.7.0.1
 */