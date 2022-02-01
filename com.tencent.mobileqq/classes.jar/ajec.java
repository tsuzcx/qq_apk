import com.tencent.mobileqq.activity.contact.troop.DiscussionView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ajec
  extends antq
{
  private ajec(DiscussionView paramDiscussionView) {}
  
  protected void onAddDiscussionMember(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
    }
  }
  
  protected void onChangeDiscussionName(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
    }
  }
  
  protected void onCollectDiscussion(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
  }
  
  protected void onCreateDiscussion(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
    }
  }
  
  protected void onDelDiscussion()
  {
    this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
  }
  
  protected void onKickoutDiscussionMember(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
  }
  
  protected void onQuitDiscussion(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
    }
  }
  
  protected void onUncollectDiscussion(boolean paramBoolean, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + paramBoolean + " uin:" + paramLong);
    }
    this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
  }
  
  protected void onUpdateAllDiscussionIcon()
  {
    this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
  }
  
  protected void onUpdateDiscussionInteRemark(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
    }
  }
  
  protected void updateDiscussionInfo(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
    }
  }
  
  protected void updateDiscussionList(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.i();
    }
    this.a.jdField_a_of_type_Amgs.notifyDataSetChanged();
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
    this.a.b(2131718993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajec
 * JD-Core Version:    0.7.0.1
 */