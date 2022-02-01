import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class akrb
  implements IRedPacket.OnGetSkinListener
{
  akrb(akqz paramakqz) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    akqw localakqw = akqy.a(akqz.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localakqw != null)
    {
      localList = akqz.a(this.a).getList();
      QLog.d("HbSkinLogic", 2, "redl iscache = " + akqw.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      if ((akqw.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localakqw))) {
        break label98;
      }
      QLog.d("HbSkinLogic", 2, "no add in list...");
    }
    label98:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = akqz.a();
    }
    localakqw.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    QLog.d("HbSkinLogic", 2, "redl add to list show!");
    localList.add(localakqw);
    akqw.a(localList);
    akqz.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrb
 * JD-Core Version:    0.7.0.1
 */