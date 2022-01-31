import com.tencent.image.URLImageView;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.QidianProfileCardActivity.PaGroupStruct;
import com.tencent.qidian.data.GroupItem;
import java.util.concurrent.ConcurrentHashMap;

class almy
  implements Runnable
{
  almy(almx paramalmx, GroupItem paramGroupItem, URLImageView paramURLImageView) {}
  
  public void run()
  {
    String str = String.valueOf(this.jdField_a_of_type_ComTencentQidianDataGroupItem.a);
    this.jdField_a_of_type_Almx.a.a.put(str, new QidianProfileCardActivity.PaGroupStruct(this.jdField_a_of_type_ComTencentImageURLImageView, 3, str));
    this.jdField_a_of_type_Almx.a.a(3, this.jdField_a_of_type_ComTencentImageURLImageView, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     almy
 * JD-Core Version:    0.7.0.1
 */