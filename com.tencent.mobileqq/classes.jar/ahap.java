import Wallet.SkinInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ahap
{
  public static boolean a;
  public static int c = 0;
  public int a;
  public SkinInfo a;
  public RedPacketInfoBase a;
  public String a;
  public int b;
  public String b = "";
  
  public ahap(SkinInfo paramSkinInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_a_of_type_JavaLangString = paramSkinInfo.skin_name;
    this.jdField_a_of_type_WalletSkinInfo = paramSkinInfo;
  }
  
  public ahap(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(List<ahap> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ahap localahap = (ahap)paramList.next();
      if (c == localahap.jdField_a_of_type_WalletSkinInfo.skin_id) {
        return localahap.jdField_a_of_type_WalletSkinInfo.skin_id;
      }
    }
    return -1;
  }
  
  public static void a(List<ahap> paramList)
  {
    Collections.sort(paramList, new ahaq());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ahap)) {
        break;
      }
    } while (this.jdField_a_of_type_WalletSkinInfo.skin_id == ((ahap)paramObject).jdField_a_of_type_WalletSkinInfo.skin_id);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahap
 * JD-Core Version:    0.7.0.1
 */