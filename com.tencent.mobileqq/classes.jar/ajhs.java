import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.Callback;

class ajhs
  implements Runnable
{
  ajhs(ajhr paramajhr, MessageRecord paramMessageRecord, Integer paramInteger) {}
  
  public void run()
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword");
    }
    this.jdField_a_of_type_Ajhr.a.a(str, this.jdField_a_of_type_JavaLangInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhs
 * JD-Core Version:    0.7.0.1
 */