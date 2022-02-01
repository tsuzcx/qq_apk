import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class aact
  extends anry
{
  aact(aacp paramaacp, aadb paramaadb, QQAppInterface paramQQAppInterface) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aadb.b.setVisibility(8);
      this.jdField_a_of_type_Aadb.a.setVisibility(0);
      if (TextUtils.isEmpty(twi.a().a(paramString)))
      {
        paramString = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
        if (paramString != null) {
          paramString.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aact
 * JD-Core Version:    0.7.0.1
 */