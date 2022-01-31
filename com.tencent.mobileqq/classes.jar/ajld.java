import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.CustomImgView;
import java.util.ArrayList;
import java.util.List;

public class ajld
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public ajld(ajlc paramajlc, Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      int j = i;
      if (i > this.jdField_a_of_type_Int) {
        j = this.jdField_a_of_type_Int;
      }
      return j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0; (paramInt > 0) && (paramInt < i); i = this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560913, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.b, this.b));
    }
    for (;;)
    {
      paramViewGroup = (CustomImgView)paramView;
      MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localMessageRecord != null) && (!TextUtils.isEmpty(localMessageRecord.senderuin)))
      {
        paramViewGroup.setImageDrawable(this.jdField_a_of_type_Ajlc.a.a(localMessageRecord.istroop, localMessageRecord.senderuin));
        paramView.setTag(-1, localMessageRecord.senderuin);
      }
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajld
 * JD-Core Version:    0.7.0.1
 */