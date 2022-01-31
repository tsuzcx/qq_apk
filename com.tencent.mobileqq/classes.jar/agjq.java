import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.qphone.base.util.QLog;

public class agjq
  extends agjr
{
  private int a;
  public String a;
  public String b;
  private boolean b;
  public String c;
  private boolean c;
  String d = "";
  String e = "";
  public String f = "";
  
  public agjq()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = true;
  }
  
  void a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("PromotionID");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("PromotionWords");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("PromotionIconUrl");
    this.d = paramBundle.getString("PromotionUserFrom");
    this.e = paramBundle.getString("PromotionUserTo");
    this.f = paramBundle.getString("PromotionUserShareId");
    if (!TextUtils.isEmpty(this.g))
    {
      com.tencent.mobileqq.arcard.ARCardUtils.jdField_c_of_type_JavaLangString = this.g;
      if (TextUtils.equals(this.g, "1")) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    try
    {
      this.d = NearbyURLSafeUtil.b(this.d);
      this.e = NearbyURLSafeUtil.b(this.e);
      label116:
      if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.e)))
      {
        if (this.e.equals(paramAppInterface.getCurrentAccountUin()))
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_Int = 1;
        }
        if (this.d.equals(paramAppInterface.getCurrentAccountUin()))
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_Int = 2;
        }
      }
      QLog.w("ScanTorchActivity", 1, "ARRelationShipPromotion, mPromotionId[" + this.jdField_a_of_type_JavaLangString + "], mPromotionWords[" + this.jdField_b_of_type_JavaLangString + "], mPromotionIconUrl[" + this.jdField_c_of_type_JavaLangString + "], mRecoglizeMask[" + this.jdField_a_of_type_Long + "], isMasterState[" + this.jdField_c_of_type_Boolean + "]");
      return;
    }
    catch (Exception paramBundle)
    {
      break label116;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjq
 * JD-Core Version:    0.7.0.1
 */