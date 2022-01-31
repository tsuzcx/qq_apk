import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class aizj
  implements IRedPacket.OnGetSkinListener
{
  aizj(aizh paramaizh) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    aize localaize = aizg.a(aizh.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localaize != null)
    {
      localList = aizh.a(this.a).getList();
      QLog.d("HbSkinLogic", 2, "redl iscache = " + aize.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      if ((aize.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localaize))) {
        break label98;
      }
      QLog.d("HbSkinLogic", 2, "no add in list...");
    }
    label98:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = aizh.a();
    }
    localaize.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    QLog.d("HbSkinLogic", 2, "redl add to list show!");
    localList.add(localaize);
    aize.a(localList);
    aizh.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizj
 * JD-Core Version:    0.7.0.1
 */