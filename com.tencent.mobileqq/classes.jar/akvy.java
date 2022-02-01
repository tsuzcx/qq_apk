import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class akvy
  implements IRedPacket.OnGetSkinListener
{
  akvy(akvw paramakvw) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    akvt localakvt = akvv.a(akvw.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localakvt != null)
    {
      localList = akvw.a(this.a).getList();
      if (QLog.isColorLevel()) {
        QLog.d("HbSkinLogic", 2, "redl iscache = " + akvt.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      }
      if ((akvt.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localakvt))) {
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
      paramRedPacketInfoBase.title = akvw.a();
    }
    localakvt.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    if (QLog.isColorLevel()) {
      QLog.d("HbSkinLogic", 2, "redl add to list show!");
    }
    localList.add(localakvt);
    akvt.a(localList);
    akvw.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvy
 * JD-Core Version:    0.7.0.1
 */