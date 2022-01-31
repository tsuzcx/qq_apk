import com.tencent.mobileqq.widget.QQToast;

class acfk
  implements Runnable
{
  acfk(acfj paramacfj, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      QQToast.a(this.jdField_a_of_type_Acfj.a, 2, "已取消关注", 1).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Acfj.a, 1, "取消关注失败", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfk
 * JD-Core Version:    0.7.0.1
 */