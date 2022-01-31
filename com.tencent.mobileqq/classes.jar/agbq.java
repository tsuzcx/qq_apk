import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

class agbq
  implements agal
{
  agbq(agbp paramagbp, int paramInt) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (biys.a(this.jdField_a_of_type_Agbp.a, paramLocalMediaInfo))
    {
      if (PhotoListActivity.l(this.jdField_a_of_type_Agbp.a))
      {
        PhotoListActivity.a(this.jdField_a_of_type_Agbp.a, paramLocalMediaInfo);
        wye.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
        return;
      }
      this.jdField_a_of_type_Agbp.a.f();
      this.jdField_a_of_type_Agbp.a.a(paramLocalMediaInfo, this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Agbp.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbq
 * JD-Core Version:    0.7.0.1
 */