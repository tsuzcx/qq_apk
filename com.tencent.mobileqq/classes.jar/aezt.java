import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

public class aezt
  implements NowShortVideoProtoManager.Callback
{
  public aezt(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = new oidb_0xada.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.i("PlayOperationViewModel", 2, "err_msg:   " + paramBundle.err_msg.get() + "  isFollow:" + PlayOperationViewModel.c(this.a));
        }
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new ilive_new_anchor_follow_interface.FollowActionRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.i("PlayOperationViewModel", 2, "ret:   " + paramArrayOfByte.ret.get() + ",msg:     " + paramArrayOfByte.msg.get() + "  isFollow:" + PlayOperationViewModel.c(this.a));
          }
          if (paramArrayOfByte.ret.get() == 0)
          {
            PlayOperationViewModel.c(this.a, true);
            if (PlayOperationViewModel.d(this.a))
            {
              ThreadManager.getUIHandler().post(new aezu(this));
              PlayOperationViewModel.d(this.a, false);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a = true;
            new NowVideoReporter().h("video").i("playpage_focus").b().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
          }
          if (!TextUtils.isEmpty(paramArrayOfByte.msg.get()))
          {
            QQToast.a(BaseApplication.getContext(), 1, paramArrayOfByte.msg.get(), 0).a();
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aezt
 * JD-Core Version:    0.7.0.1
 */