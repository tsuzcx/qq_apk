import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class aiuu
  implements IRedPacket.OnGetSkinListener
{
  aiuu(aius paramaius) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    aiup localaiup = aiur.a(aius.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localaiup != null)
    {
      localList = aius.a(this.a).getList();
      QLog.d("HbSkinLogic", 2, "redl iscache = " + aiup.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      if ((aiup.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localaiup))) {
        break label98;
      }
      QLog.d("HbSkinLogic", 2, "no add in list...");
    }
    label98:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = aius.a();
    }
    localaiup.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    QLog.d("HbSkinLogic", 2, "redl add to list show!");
    localList.add(localaiup);
    aiup.a(localList);
    aius.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuu
 * JD-Core Version:    0.7.0.1
 */