import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class ahau
  implements IRedPacket.OnGetSkinListener
{
  ahau(ahas paramahas) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    ahap localahap = ahar.a(ahas.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localahap != null)
    {
      localList = ahas.a(this.a).getList();
      QLog.d("HbSkinLogic", 2, "redl iscache = " + ahap.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      if ((ahap.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localahap))) {
        break label98;
      }
      QLog.d("HbSkinLogic", 2, "no add in list...");
    }
    label98:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = ahas.a();
    }
    localahap.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    QLog.d("HbSkinLogic", 2, "redl add to list show!");
    localList.add(localahap);
    ahap.a(localList);
    ahas.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahau
 * JD-Core Version:    0.7.0.1
 */