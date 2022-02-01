import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;

public class aauu
  extends BaseAdapter
  implements blih
{
  private int jdField_a_of_type_Int;
  private int b;
  
  private aauu(MoveFileActivity paramMoveFileActivity) {}
  
  public int getCount()
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).size();
  }
  
  public Object getItem(int paramInt)
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aauv localaauv;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getLayoutInflater().inflate(2131560612, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity), false);
      localaauv = new aauv(null);
      localaauv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366942));
      localaauv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366941));
      localaauv.b = ((TextView)paramView.findViewById(2131364497));
      paramView.setTag(localaauv);
    }
    for (;;)
    {
      localaauv = (aauv)paramView.getTag();
      bfrs localbfrs = (bfrs)MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
      if (localbfrs != null)
      {
        if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, paramInt)) {
          break label183;
        }
        localaauv.jdField_a_of_type_AndroidWidgetTextView.setText(localbfrs.c);
        localaauv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843692);
        if (paramInt != MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity)) {
          break label209;
        }
        localaauv.b.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        label183:
        localaauv.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131705788));
        localaauv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843694);
        break;
        label209:
        localaauv.b.setVisibility(4);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      QLog.e("IphoneTitleBarActivity", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      if (this.jdField_a_of_type_Int == this.b - 2)
      {
        if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity)) {
          break label44;
        }
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(true);
      }
    }
    label44:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(false);
    } while (bgsk.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a) == 0);
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauu
 * JD-Core Version:    0.7.0.1
 */