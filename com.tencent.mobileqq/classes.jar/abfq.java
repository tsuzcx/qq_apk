import android.text.TextUtils;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler.Info;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;

class abfq
  implements Runnable
{
  abfq(abfp paramabfp, ShopScanCheckHandler.Info paramInfo) {}
  
  public void run()
  {
    Object localObject = new File(ARResUtil.b(this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.b));
    if (localObject == null)
    {
      ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 1, 0);
      return;
    }
    if (!ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, (File)localObject, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.b))
    {
      i = HttpDownloadUtil.a(ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a), this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.a, (File)localObject);
      if (i != 0)
      {
        ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 2, i);
        return;
      }
      if (!ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, (File)localObject, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.b))
      {
        ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 3, 0);
        return;
      }
    }
    localObject = FileUtils.a((File)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 4, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.l = ((String)localObject);
    int i = this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.c.lastIndexOf("/");
    int j = this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.c.indexOf("?md5=");
    if (j != -1) {}
    for (localObject = ARResUtil.b(this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.d) + "_" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.c.substring(i + 1, j);; localObject = ARResUtil.b(this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.d) + "_" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.c.substring(i + 1))
    {
      localObject = new File((String)localObject);
      if (localObject != null) {
        break;
      }
      ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 1, 0);
      return;
    }
    if (!((File)localObject).exists())
    {
      i = HttpDownloadUtil.a(ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a), this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.c, (File)localObject);
      if (i != 0)
      {
        ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 2, i);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.e = ((File)localObject).getAbsolutePath();
    i = this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.f.lastIndexOf("/");
    j = this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.f.indexOf("?md5=");
    if (j != -1) {}
    for (localObject = ARResUtil.b(this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.g) + "_" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.f.substring(i + 1, j);; localObject = ARResUtil.b(this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.g) + "_" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.f.substring(i + 1))
    {
      localObject = new File((String)localObject);
      if (localObject != null) {
        break;
      }
      ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 1, 0);
      return;
    }
    if (!((File)localObject).exists())
    {
      i = HttpDownloadUtil.a(ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a), this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.f, (File)localObject);
      if (i != 0)
      {
        ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 2, i);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info.h = ((File)localObject).getAbsolutePath();
    ShopScanCheckHandler.a(this.jdField_a_of_type_Abfp.a, this.jdField_a_of_type_ComTencentMobileqqArmapConfigShopScanCheckHandler$Info, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfq
 * JD-Core Version:    0.7.0.1
 */