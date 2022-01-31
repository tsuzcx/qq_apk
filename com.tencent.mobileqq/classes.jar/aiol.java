import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.Callback;

class aiol
  implements Runnable
{
  aiol(aiok paramaiok, MessageRecord paramMessageRecord, Integer paramInteger) {}
  
  public void run()
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("key_aio_keyword");
    }
    this.jdField_a_of_type_Aiok.a.a(str, this.jdField_a_of_type_JavaLangInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiol
 * JD-Core Version:    0.7.0.1
 */