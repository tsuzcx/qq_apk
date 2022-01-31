import com.tencent.mobileqq.activity.contact.troop.DiscussionView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afmm
  extends ajvj
{
  private afmm(DiscussionView paramDiscussionView) {}
  
  protected void a()
  {
    this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.i();
    }
    this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
    if (this.a.c)
    {
      this.a.c = false;
      if (paramBoolean)
      {
        DiscussionView.a(this.a).a(0);
        this.a.a(100, 800L);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
    this.a.b(2131719799);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
    }
  }
  
  protected void b()
  {
    this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Aimm.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmm
 * JD-Core Version:    0.7.0.1
 */