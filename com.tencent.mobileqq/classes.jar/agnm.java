import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

class agnm
  implements agmh
{
  agnm(agnl paramagnl, int paramInt) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (bkpv.a(this.jdField_a_of_type_Agnl.a, paramLocalMediaInfo))
    {
      if (PhotoListActivity.l(this.jdField_a_of_type_Agnl.a))
      {
        PhotoListActivity.a(this.jdField_a_of_type_Agnl.a, paramLocalMediaInfo);
        xhb.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
        return;
      }
      this.jdField_a_of_type_Agnl.a.f();
      this.jdField_a_of_type_Agnl.a.a(paramLocalMediaInfo, this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Agnl.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnm
 * JD-Core Version:    0.7.0.1
 */