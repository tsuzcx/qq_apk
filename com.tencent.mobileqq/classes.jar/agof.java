import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class agof
  implements IRedPacket.OnGetSkinListener
{
  agof(agod paramagod) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    agoa localagoa = agoc.a(agod.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localagoa != null)
    {
      localList = agod.a(this.a).getList();
      QLog.d("HbSkinLogic", 2, "redl iscache = " + agoa.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      if ((agoa.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localagoa))) {
        break label98;
      }
      QLog.d("HbSkinLogic", 2, "no add in list...");
    }
    label98:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = agod.a();
    }
    localagoa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    QLog.d("HbSkinLogic", 2, "redl add to list show!");
    localList.add(localagoa);
    agoa.a(localList);
    agod.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agof
 * JD-Core Version:    0.7.0.1
 */