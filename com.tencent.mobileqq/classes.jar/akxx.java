import com.tencent.qidian.controller.QidianPubAccountBigDataHandler;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import java.util.Map;

public class akxx
  implements Runnable
{
  public akxx(QidianPubAccountBigDataHandler paramQidianPubAccountBigDataHandler, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentQidianControllerQidianPubAccountBigDataHandler.a(this.jdField_a_of_type_Long);
    PubAccountNavigationMenu localPubAccountNavigationMenu = (PubAccountNavigationMenu)this.jdField_a_of_type_ComTencentQidianControllerQidianPubAccountBigDataHandler.a.get(Long.valueOf(this.jdField_a_of_type_Long));
    if (localPubAccountNavigationMenu == null)
    {
      localPubAccountNavigationMenu = new PubAccountNavigationMenu();
      localPubAccountNavigationMenu.version = 0;
      localPubAccountNavigationMenu.puin = this.jdField_a_of_type_Long;
      localPubAccountNavigationMenu.xml = "";
    }
    for (;;)
    {
      QidianPubAccountBigDataHandler.a(this.jdField_a_of_type_ComTencentQidianControllerQidianPubAccountBigDataHandler, this.jdField_a_of_type_Long, localPubAccountNavigationMenu, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akxx
 * JD-Core Version:    0.7.0.1
 */