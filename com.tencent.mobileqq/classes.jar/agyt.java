import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet;

public class agyt
  implements Runnable
{
  public agyt(ShareActionSheet paramShareActionSheet) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.a.jdField_a_of_type_Int) {
      this.a.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (this.a.b.getWidth() < ShareActionSheet.a(this.a))
    {
      this.a.b.setMove(true);
      return;
      this.a.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.a.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agyt
 * JD-Core Version:    0.7.0.1
 */