import Wallet.SkinInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class akvt
{
  public static boolean a;
  public static int c = 0;
  public int a;
  public SkinInfo a;
  public RedPacketInfoBase a;
  public String a;
  public int b;
  public String b = "";
  
  public akvt(SkinInfo paramSkinInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_a_of_type_JavaLangString = paramSkinInfo.skin_name;
    this.jdField_a_of_type_WalletSkinInfo = paramSkinInfo;
  }
  
  public akvt(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(List<akvt> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      akvt localakvt = (akvt)paramList.next();
      if (c == localakvt.jdField_a_of_type_WalletSkinInfo.skin_id) {
        return localakvt.jdField_a_of_type_WalletSkinInfo.skin_id;
      }
    }
    return -1;
  }
  
  public static void a(List<akvt> paramList)
  {
    Collections.sort(paramList, new akvu());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof akvt)) {
        break;
      }
    } while (this.jdField_a_of_type_WalletSkinInfo.skin_id == ((akvt)paramObject).jdField_a_of_type_WalletSkinInfo.skin_id);
    return false;
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append("background : " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.background + " | ");
    localStringBuffer.append("icon : " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon + " | ");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvt
 * JD-Core Version:    0.7.0.1
 */