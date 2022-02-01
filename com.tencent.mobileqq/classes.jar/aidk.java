import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

class aidk
  extends ntf
{
  aidk(aidd paramaidd) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.tag, 2, "errorCode = [" + paramInt + "], bundle = [" + paramBundle + "]");
    }
    boolean bool;
    if (paramInt == 0)
    {
      paramBundle = new NowSummaryCard.NearbyUserFollowRsp();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = paramBundle.ret_code.get();
        paramArrayOfByte = paramBundle.err_msg.get().toStringUtf8();
        QLog.i(this.a.tag, 1, "ret_code: " + paramInt + ", err_msg: " + paramArrayOfByte);
        if (paramInt != 0) {
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            QQToast.a(this.a.mContext, 1, paramArrayOfByte, 0).b(this.a.getTitleBarHeight());
            QLog.d(this.a.tag + "Q.nearby.follow", 2, "sendOperateFollowUser,targetUin:" + this.a.sessionInfo.curFriendUin + ", op:" + "1" + ", errMsg:" + paramArrayOfByte);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          QLog.e(this.a.tag, 1, "pb parse error: " + paramArrayOfByte);
        }
        QQToast.a(this.a.mActivity, 1, anvx.a(2131706728), 1).a();
        bool = false;
      }
    }
    for (;;)
    {
      if (!bool) {
        QQToast.a(this.a.mContext, 1, this.a.mContext.getString(2131694221), 0).b(this.a.getTitleBarHeight());
      }
      if (this.a.h == bool) {
        break;
      }
      this.a.h = bool;
      this.a.updateAddFriendAndShieldView();
      return;
      QQToast.a(this.a.mContext, 2, this.a.mContext.getString(2131694222), 0).b(this.a.getTitleBarHeight());
      bool = true;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidk
 * JD-Core Version:    0.7.0.1
 */