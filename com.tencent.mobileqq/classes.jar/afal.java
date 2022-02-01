import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.widget.ContainerView;

public class afal
  implements aqji
{
  public afal(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    aqjd.a(this.a.app, this.a.e, paramArrayOfHotWordItem);
    paramArrayOfHotWordItem = bhmb.a(this.a.e, this.a.f, 30, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 13);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this.a))
    {
      this.a.jdField_a_of_type_JavaLangCharSequence = paramArrayOfHotWordItem;
      return;
    }
    this.a.jdField_a_of_type_JavaLangCharSequence = null;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramArrayOfHotWordItem);
    this.a.i = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afal
 * JD-Core Version:    0.7.0.1
 */