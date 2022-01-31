import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Map;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.RspBody;

class akag
  extends mmn
{
  akag(akaf paramakaf, boolean paramBoolean, aylt paramaylt, long paramLong1, long paramLong2, RecentUser paramRecentUser, String paramString, MessageRecord paramMessageRecord, Map paramMap)
  {
    super(paramBoolean);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    for (;;)
    {
      return;
      try
      {
        paramBundle = new oidb_cmd0x6ef.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.is_create.get() == 1) || (paramBundle.is_join.get() == 1))
        {
          this.jdField_a_of_type_Aylt.m.a(this.jdField_a_of_type_Long, this.b);
          if (21 >= this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msgType)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msgType = 21;
            this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg = aylt.a(this.jdField_a_of_type_Akaf.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aylt, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, true);
            this.jdField_a_of_type_JavaUtilMap.put(akbm.a(this.jdField_a_of_type_JavaLangString, 1), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akag
 * JD-Core Version:    0.7.0.1
 */