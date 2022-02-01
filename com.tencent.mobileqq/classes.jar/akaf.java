import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class akaf
  implements IRedPacket.OnGetSkinListener
{
  akaf(akad paramakad) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    akaa localakaa = akac.a(akad.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localakaa != null)
    {
      localList = akad.a(this.a).getList();
      if (QLog.isColorLevel()) {
        QLog.d("HbSkinLogic", 2, "redl iscache = " + akaa.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      }
      if ((akaa.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localakaa))) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HbSkinLogic", 2, "no add in list...");
      }
    }
    label110:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = akad.a();
    }
    localakaa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    if (QLog.isColorLevel()) {
      QLog.d("HbSkinLogic", 2, "redl add to list show!");
    }
    localList.add(localakaa);
    akaa.a(localList);
    akad.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaf
 * JD-Core Version:    0.7.0.1
 */