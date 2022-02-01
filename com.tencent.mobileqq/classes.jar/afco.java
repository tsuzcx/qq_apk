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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class afco
  extends amgy
  implements View.OnClickListener
{
  public afco(TroopGagActivity paramTroopGagActivity)
  {
    super(paramTroopGagActivity, paramTroopGagActivity.app, paramTroopGagActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
  }
  
  protected String a(long paramLong)
  {
    String str = ((bgkf)this.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.a, paramLong);
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
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131559938, paramViewGroup, false);
        localObject1 = new afcp(this, null);
        ((afcp)localObject1).c = ((ImageView)paramView.findViewById(2131361796));
        ((afcp)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371981));
        ((afcp)localObject1).b = ((TextView)paramView.findViewById(2131367487));
        ((afcp)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377740));
        paramView.setTag(localObject1);
        localObject2 = (afcn)getItem(paramInt);
        ((afcp)localObject1).c.setImageBitmap(a(1, ((afcn)localObject2).jdField_a_of_type_JavaLangString));
        if ((TextUtils.isEmpty(((afcn)localObject2).b)) || (((afcn)localObject2).b.equals(((afcn)localObject2).jdField_a_of_type_JavaLangString))) {
          ((afcn)localObject2).b = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.a.jdField_a_of_type_JavaLangString, ((afcn)localObject2).jdField_a_of_type_JavaLangString);
        }
        ((afcp)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((afcn)localObject2).b);
        ((afcp)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
        ((afcp)localObject1).b.setText(a(((afcn)localObject2).jdField_a_of_type_Long));
        ((afcp)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        ((afcp)localObject1).jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        ((afcp)localObject1).jdField_a_of_type_JavaLangString = ((afcn)localObject2).jdField_a_of_type_JavaLangString;
        if ((!TroopGagActivity.a(this.a, this.a.app.getCurrentAccountUin())) && ((TroopGagActivity.b(this.a, ((afcn)localObject2).jdField_a_of_type_JavaLangString)) || (TroopGagActivity.a(this.a, ((afcn)localObject2).jdField_a_of_type_JavaLangString)))) {
          ((afcp)localObject1).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
          break label379;
        }
        paramView.setBackgroundResource(2130839503);
        label347:
        localObject1 = paramView;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (afcp)paramView.getTag();
      break;
      label379:
      paramView.setBackgroundResource(2130839512);
      break label347;
      localObject2 = this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof afcn)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (afcn)localObject;
      String str = ((afcn)localObject).jdField_a_of_type_JavaLangString;
      bgkf localbgkf = (bgkf)this.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      localbgkf.a(this.a.jdField_a_of_type_JavaLangString, str, 0L);
      this.a.jdField_a_of_type_JavaUtilList.remove(localObject);
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("TroopGagActivity", 2, "onClick cancelGag, uin=" + str);
      }
      bdla.b(this.a.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, this.a.jdField_a_of_type_JavaLangString + "", localbgkf.a(this.a.jdField_a_of_type_JavaLangString), "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afco
 * JD-Core Version:    0.7.0.1
 */