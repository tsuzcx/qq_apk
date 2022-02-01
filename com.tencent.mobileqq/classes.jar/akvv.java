import Wallet.SkinInfo;
import java.util.Iterator;
import java.util.List;

public class akvv
{
  public static akvt a(String paramString)
  {
    akvt localakvt = new akvt(anvx.a(2131704911));
    localakvt.jdField_b_of_type_Int = -2;
    localakvt.jdField_a_of_type_WalletSkinInfo.skin_id = -2;
    localakvt.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    localakvt.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
    localakvt.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon = null;
    localakvt.jdField_a_of_type_Int = 0;
    return localakvt;
  }
  
  public static akvt a(List<akvt> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      akvt localakvt = (akvt)paramList.next();
      if (localakvt.jdField_a_of_type_WalletSkinInfo.skin_id == paramInt) {
        return localakvt;
      }
    }
    return null;
  }
  
  public static akvt b(String paramString)
  {
    akvt localakvt = new akvt(anvx.a(2131704913));
    localakvt.jdField_b_of_type_Int = -1;
    localakvt.jdField_a_of_type_WalletSkinInfo.skin_id = 0;
    localakvt.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    localakvt.jdField_a_of_type_WalletSkinInfo.is_hide_title = 0;
    localakvt.jdField_a_of_type_WalletSkinInfo.blessing = anvx.a(2131696541);
    localakvt.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
    localakvt.jdField_a_of_type_Int = -1;
    return localakvt;
  }
  
  public static akvt c(String paramString)
  {
    akvt localakvt = new akvt(anvx.a(2131704912));
    localakvt.jdField_b_of_type_JavaLangString = paramString;
    localakvt.jdField_b_of_type_Int = 1;
    localakvt.jdField_a_of_type_Int = 1000;
    localakvt.jdField_a_of_type_WalletSkinInfo.skin_id = -1;
    localakvt.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    return localakvt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvv
 * JD-Core Version:    0.7.0.1
 */