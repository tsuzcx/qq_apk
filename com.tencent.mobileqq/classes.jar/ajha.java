import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;

public class ajha
  implements DialogInterface.OnClickListener
{
  public ajha(ApolloGameActivity paramApolloGameActivity, Intent paramIntent, String paramString, Bitmap paramBitmap, ajob paramajob, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, new ajhb(this));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajha
 * JD-Core Version:    0.7.0.1
 */