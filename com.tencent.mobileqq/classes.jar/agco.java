import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SubscribeResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;

class agco
  implements BusinessObserver
{
  agco(agcn paramagcn, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.SubscribeResponse localSubscribeResponse = new mobileqq_mp.SubscribeResponse();
          localSubscribeResponse.mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)localSubscribeResponse.ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            i = 1;
            paramInt = 1;
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramInt = 0;
      }
      try
      {
        StructingMsgItemBuilder.a(this.jdField_a_of_type_Agcn.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, this.jdField_a_of_type_Agcn.jdField_a_of_type_AndroidAppActivity);
        azqs.b(this.jdField_a_of_type_Agcn.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a, "dc00899", "Pb_account_lifeservice", "", "0X8006513", "0X8006513", 0, 0, "" + paramInt, "" + this.jdField_a_of_type_JavaLangString, "", "");
        return;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramInt = i;
        }
      }
      StructingMsgItemBuilder.b(this.jdField_a_of_type_Agcn.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, this.jdField_a_of_type_Agcn.jdField_a_of_type_AndroidAppActivity);
      break label236;
      StructingMsgItemBuilder.b(this.jdField_a_of_type_Agcn.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, this.jdField_a_of_type_Agcn.jdField_a_of_type_AndroidAppActivity);
      break label236;
      StructingMsgItemBuilder.b(this.jdField_a_of_type_Agcn.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, this.jdField_a_of_type_Agcn.jdField_a_of_type_AndroidAppActivity);
      continue;
      StructingMsgItemBuilder.b(this.jdField_a_of_type_Agcn.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, this.jdField_a_of_type_Agcn.jdField_a_of_type_AndroidAppActivity);
      label236:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agco
 * JD-Core Version:    0.7.0.1
 */