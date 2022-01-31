import Wallet.SkinInfo;
import java.util.Iterator;
import java.util.List;

public class agoc
{
  public static agoa a(String paramString)
  {
    agoa localagoa = new agoa(ajjy.a(2131639642));
    localagoa.jdField_b_of_type_Int = -2;
    localagoa.jdField_a_of_type_WalletSkinInfo.skin_id = -2;
    localagoa.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    localagoa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
    localagoa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon = null;
    localagoa.jdField_a_of_type_Int = 0;
    return localagoa;
  }
  
  public static agoa a(List<agoa> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      agoa localagoa = (agoa)paramList.next();
      if (localagoa.jdField_a_of_type_WalletSkinInfo.skin_id == paramInt) {
        return localagoa;
      }
    }
    return null;
  }
  
  public static agoa b(String paramString)
  {
    agoa localagoa = new agoa(ajjy.a(2131639644));
    localagoa.jdField_b_of_type_Int = -1;
    localagoa.jdField_a_of_type_WalletSkinInfo.skin_id = 0;
    localagoa.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    localagoa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
    localagoa.jdField_a_of_type_Int = -1;
    return localagoa;
  }
  
  public static agoa c(String paramString)
  {
    agoa localagoa = new agoa(ajjy.a(2131639643));
    localagoa.jdField_b_of_type_JavaLangString = paramString;
    localagoa.jdField_b_of_type_Int = 1;
    localagoa.jdField_a_of_type_Int = 1000;
    localagoa.jdField_a_of_type_WalletSkinInfo.skin_id = -1;
    localagoa.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    return localagoa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agoc
 * JD-Core Version:    0.7.0.1
 */