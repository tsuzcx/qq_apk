import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class ahgs
  implements bhai<oidb_0x8e4.RspBody>
{
  ahgs(ahgc paramahgc) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramRspBody == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "startAnotherRound failed! errorCode = " + paramInt);
      }
    }
    do
    {
      QQToast.a(this.a.getActivity(), 1, amtj.a(2131704219), 1).a();
      return;
      while ((!paramRspBody.getBooleanExtra("finishAIO", false)) || (!(this.a.mActivity instanceof ChatActivity)))
      {
        Common.WifiPOIInfo localWifiPOIInfo = paramRspBody.poi_info;
        HotChatInfo localHotChatInfo = HotChatInfo.createHotChat(localWifiPOIInfo, false, 0);
        localHotChatInfo.isGameRoom = true;
        paramRspBody = this.a.app.getHotChatMng(true);
        Object localObject = paramRspBody.a();
        if ((localObject != null) && (!((List)localObject).contains(localHotChatInfo))) {
          ((List)localObject).add(localHotChatInfo);
        }
        paramRspBody.a(localHotChatInfo, 4);
        localObject = this.a.getActivity().getIntent();
        paramRspBody = (oidb_0x8e4.RspBody)localObject;
        if (localObject == null) {
          paramRspBody = new Intent();
        }
        localObject = localWifiPOIInfo.bytes_uid.get().toStringUtf8();
        paramRspBody.putExtra("uin", localHotChatInfo.troopUin + "");
        paramRspBody.putExtra("uintype", 1);
        paramRspBody.putExtra("troop_uin", localHotChatInfo.troopUin + "");
        paramRspBody.putExtra("uinname", localHotChatInfo.name);
        paramRspBody.putExtra("hotnamecode", (String)localObject);
        paramRspBody.putExtra("isNeedShowLoading", false);
        paramRspBody.putExtra("leftViewText", this.a.getActivity().getString(2131690424));
        awka.a(this.a.app.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(bbko.a()));
        paramInt = AIOUtils.openAioToAIOByMT(this.a.app, this.a.mActivity, paramRspBody);
        if (paramInt != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.a.tag, 2, "openAIO by start SplashAct");
        }
        localObject = this.a.a.a();
        if (localObject != null) {
          ((bhaq)localObject).a();
        }
        this.a.mActivity.startActivity(paramRspBody);
      }
      this.a.mActivity.finish();
      return;
    } while (paramInt != 2);
    QLog.e(this.a.tag, 1, "openAIO rediectToAIOWithMt 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgs
 * JD-Core Version:    0.7.0.1
 */