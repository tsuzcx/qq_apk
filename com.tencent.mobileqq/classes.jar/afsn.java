import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afsn
  extends amoe
  implements View.OnClickListener
{
  public afsn(TroopGagActivity paramTroopGagActivity)
  {
    super(paramTroopGagActivity, paramTroopGagActivity.app, paramTroopGagActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
  }
  
  protected String a(long paramLong)
  {
    String str = ((bgsl)this.a.app.getManager(48)).a(this.a, paramLong);
    if (!TextUtils.isEmpty(str)) {
      return "" + str;
    }
    return "";
  }
  
  public int getCount()
  {
    int j = this.a.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.a.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt > 0) {
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131559892, paramViewGroup, false);
        localObject1 = new afso(this, null);
        ((afso)localObject1).c = ((ImageView)paramView.findViewById(2131361795));
        ((afso)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371827));
        ((afso)localObject1).b = ((TextView)paramView.findViewById(2131367339));
        ((afso)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377699));
        paramView.setTag(localObject1);
        localObject2 = (afsm)getItem(paramInt);
        ((afso)localObject1).c.setImageBitmap(a(1, ((afsm)localObject2).jdField_a_of_type_JavaLangString));
        if ((TextUtils.isEmpty(((afsm)localObject2).b)) || (((afsm)localObject2).b.equals(((afsm)localObject2).jdField_a_of_type_JavaLangString))) {
          ((afsm)localObject2).b = ((TroopManager)this.a.app.getManager(52)).a(this.a.jdField_a_of_type_JavaLangString, ((afsm)localObject2).jdField_a_of_type_JavaLangString);
        }
        ((afso)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((afsm)localObject2).b);
        ((afso)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
        ((afso)localObject1).b.setText(a(((afsm)localObject2).jdField_a_of_type_Long));
        ((afso)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        ((afso)localObject1).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        ((afso)localObject1).jdField_a_of_type_JavaLangString = ((afsm)localObject2).jdField_a_of_type_JavaLangString;
        if ((!TroopGagActivity.a(this.a, this.a.app.getCurrentAccountUin())) && ((TroopGagActivity.b(this.a, ((afsm)localObject2).jdField_a_of_type_JavaLangString)) || (TroopGagActivity.a(this.a, ((afsm)localObject2).jdField_a_of_type_JavaLangString)))) {
          ((afso)localObject1).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
          break label378;
        }
        paramView.setBackgroundResource(2130839447);
        label346:
        localObject1 = paramView;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (afso)paramView.getTag();
      break;
      label378:
      paramView.setBackgroundResource(2130839456);
      break label346;
      localObject2 = this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof afsm)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (afsm)localObject;
      String str = ((afsm)localObject).jdField_a_of_type_JavaLangString;
      bgsl localbgsl = (bgsl)this.a.app.getManager(48);
      localbgsl.a(this.a.jdField_a_of_type_JavaLangString, str, 0L);
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject);
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("TroopGagActivity", 2, "onClick cancelGag, uin=" + str);
      }
      bdll.b(this.a.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, this.a.jdField_a_of_type_JavaLangString + "", localbgsl.a(this.a.jdField_a_of_type_JavaLangString), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsn
 * JD-Core Version:    0.7.0.1
 */