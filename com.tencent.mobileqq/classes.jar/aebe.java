import android.content.Context;
import android.os.Bundle;
import com.tencent.jungle.videohub.proto.GroupRoomManageProto.GetGameStatusByGroupCodeRsp;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Map;

public final class aebe
  implements awaq
{
  public aebe(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map paramMap) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 1;
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("login: errorCode=").append(paramInt).append(" bundle=");
      if (paramBundle == null) {}
      for (paramBundle = "null";; paramBundle = paramBundle.toString())
      {
        QLog.i("ChatActivityUtils", 2, paramBundle + " data=" + Arrays.toString(paramArrayOfByte));
        ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilMap);
        return;
      }
    }
    paramBundle = new GroupRoomManageProto.GetGameStatusByGroupCodeRsp();
    try
    {
      paramArrayOfByte = (GroupRoomManageProto.GetGameStatusByGroupCodeRsp)paramBundle.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, new Object[] { "MSF.C.NetConnTag", " room_id=" + paramArrayOfByte.room_id.get() + " app_type=" + paramArrayOfByte.app_type.get() + " game_id=" + paramArrayOfByte.game_id.get() + " is_group_member=" + paramArrayOfByte.is_group_member.get() });
      }
      if ((paramArrayOfByte.app_type.get() <= 0) || (paramArrayOfByte.is_group_member.get() != 0))
      {
        bool = true;
        if (this.jdField_a_of_type_JavaUtilMap != null)
        {
          if (!"Panel".equals(this.jdField_a_of_type_JavaUtilMap.get("from"))) {
            break label328;
          }
          paramInt = i;
          new ayxf().a("QQ_chatroom_surface").b("click_entrance").a(paramInt).d(String.valueOf(bool)).a();
        }
        if (bool) {
          break label376;
        }
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = paramBundle;
        continue;
        boolean bool = false;
        continue;
        label328:
        if ("tipBar".equals(this.jdField_a_of_type_JavaUtilMap.get("from")))
        {
          paramInt = 2;
        }
        else if ("itemBuilder".equals(this.jdField_a_of_type_JavaUtilMap.get("from")))
        {
          paramInt = 3;
          continue;
          label376:
          if (paramArrayOfByte.app_type.get() == 2)
          {
            ChatActivityUtils.a(this.jdField_a_of_type_Int, Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue(), paramArrayOfByte.room_id.get(), paramArrayOfByte.game_id.get());
            return;
          }
          ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilMap);
        }
        else
        {
          paramInt = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebe
 * JD-Core Version:    0.7.0.1
 */