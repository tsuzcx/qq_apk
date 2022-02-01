import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class alcm
  implements IRedPacket.OnGetSkinListener
{
  alcm(alck paramalck) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    alch localalch = alcj.a(alck.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localalch != null)
    {
      localList = alck.a(this.a).getList();
      if (QLog.isColorLevel()) {
        QLog.d("HbSkinLogic", 2, "redl iscache = " + alch.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      }
      if ((alch.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localalch))) {
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
      paramRedPacketInfoBase.title = alck.a();
    }
    localalch.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    if (QLog.isColorLevel()) {
      QLog.d("HbSkinLogic", 2, "redl add to list show!");
    }
    localList.add(localalch);
    alch.a(localList);
    alck.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcm
 * JD-Core Version:    0.7.0.1
 */