import com.tencent.mobileqq.emosm.view.DragSortListView;

public class abtm
  extends abto
{
  private float jdField_a_of_type_Float;
  private float b;
  
  public void a()
  {
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f;
    this.b = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.j;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.g != 4)
    {
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f = ((int)(this.b * paramFloat2 + (1.0F - paramFloat2) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.k - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abtm
 * JD-Core Version:    0.7.0.1
 */