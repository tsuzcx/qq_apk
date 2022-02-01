import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupDynamicEntrancePicture;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class afrv
  extends nko
{
  public afrv(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAssistantActivity", 2, TroopAssistantActivity.jdField_a_of_type_JavaLangString + " get error:" + paramInt);
      }
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      try
      {
        qqstory_group.RspGetGroupDynamicEntrancePicture localRspGetGroupDynamicEntrancePicture = new qqstory_group.RspGetGroupDynamicEntrancePicture();
        localRspGetGroupDynamicEntrancePicture.mergeFrom(paramArrayOfByte);
        paramBundle = (qqstory_struct.ErrorInfo)localRspGetGroupDynamicEntrancePicture.result.get();
        paramArrayOfByte = paramBundle;
        if (localRspGetGroupDynamicEntrancePicture.cover_url.has())
        {
          paramArrayOfByte = localRspGetGroupDynamicEntrancePicture.cover_url.get().toStringUtf8();
          if (TextUtils.isEmpty(paramArrayOfByte))
          {
            if (QLog.isColorLevel()) {
              QLog.i("TroopAssistantActivity", 2, TroopAssistantActivity.jdField_a_of_type_JavaLangString + ": picUrl is Empty");
            }
          }
          else
          {
            this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            zps.a(this.a.jdField_a_of_type_AndroidWidgetImageView, paramArrayOfByte, 68, 68, 4, zps.b, "TroopStorySnap");
            return paramBundle;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAssistantActivity", 2, TroopAssistantActivity.jdField_a_of_type_JavaLangString + " get exception:" + paramArrayOfByte.getMessage());
        }
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrv
 * JD-Core Version:    0.7.0.1
 */