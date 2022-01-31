import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class ahas
  implements IRedPacket.OnGetSkinListener
{
  ahas(ahaq paramahaq) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    ahan localahan = ahap.a(ahaq.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localahan != null)
    {
      localList = ahaq.a(this.a).getList();
      QLog.d("HbSkinLogic", 2, "redl iscache = " + ahan.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      if ((ahan.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localahan))) {
        break label98;
      }
      QLog.d("HbSkinLogic", 2, "no add in list...");
    }
    label98:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = ahaq.a();
    }
    localahan.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    QLog.d("HbSkinLogic", 2, "redl add to list show!");
    localList.add(localahan);
    ahan.a(localList);
    ahaq.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahas
 * JD-Core Version:    0.7.0.1
 */