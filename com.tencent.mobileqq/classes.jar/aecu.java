import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class aecu
  extends BaseAdapter
{
  protected int a;
  protected List<String> a;
  
  public aecu(TroopDisbandActivity paramTroopDisbandActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add("0");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.d))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.d);
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(List<String> paramList)
  {
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      if (i > 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramString);
  }
  
  public void b(List<oidb_0x899.memberlist> paramList)
  {
    int i;
    int j;
    label26:
    Object localObject;
    if (paramList != null)
    {
      i = paramList.size();
      if (i <= 0) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      j = 0;
      if (j >= i) {
        break label113;
      }
      localObject = (oidb_0x899.memberlist)paramList.get(j);
      if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has())) {
        break label71;
      }
    }
    for (;;)
    {
      j += 1;
      break label26;
      i = 0;
      break;
      label71:
      localObject = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if (!this.jdField_a_of_type_JavaUtilList.contains(localObject)) {
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
    }
    label113:
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 6) {
      return 6;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.setAdjustViewBounds(true);
      paramView = paramViewGroup;
      localObject = paramViewGroup;
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramView = (String)getItem(paramInt);
      if ((!TextUtils.isEmpty(paramView)) && (!paramView.equals("0"))) {
        break;
      }
      paramViewGroup.setImageDrawable(bdhj.b());
      return localObject;
      paramViewGroup = (ImageView)paramView;
      localObject = paramViewGroup.getLayoutParams();
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_Int;
        ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_Int;
      }
      localObject = paramView;
    }
    paramViewGroup.setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, paramView, (byte)3));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecu
 * JD-Core Version:    0.7.0.1
 */