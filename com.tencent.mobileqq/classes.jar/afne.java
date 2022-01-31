import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class afne
  extends akil
{
  public afne(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1)
  {
    this.a.b = false;
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0))
    {
      this.a.jdField_a_of_type_Int = 0;
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView.isOverscrollHeadVisiable())
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
        ShowExternalTroopListActivity.a(this.a);
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        paramList = new ArrayList();
        this.a.jdField_a_of_type_Aipd.a(paramList);
        paramInt = this.a.getTitleBarHeight();
        bcql.a(this.a, 1, this.a.getString(2131696475), 0).b(paramInt);
        return;
      }
      this.a.a();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.isOverscrollHeadVisiable())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.a);
    }
    this.a.c.setVisibility(0);
    if (this.a.jdField_a_of_type_Aipd != null)
    {
      this.a.jdField_a_of_type_Int = paramList.size();
      this.a.jdField_a_of_type_Aipd.a(paramList);
    }
    this.a.a(paramList1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afne
 * JD-Core Version:    0.7.0.1
 */