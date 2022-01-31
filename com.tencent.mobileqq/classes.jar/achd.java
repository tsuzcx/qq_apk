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
import java.util.List;

public class achd
  extends aimu
  implements View.OnClickListener
{
  public achd(TroopGagActivity paramTroopGagActivity)
  {
    super(paramTroopGagActivity, paramTroopGagActivity.app, paramTroopGagActivity.jdField_a_of_type_ComTencentWidgetXListView, 1, false);
  }
  
  protected String a(long paramLong)
  {
    String str = ((bakk)this.a.app.getManager(48)).a(this.a, paramLong);
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
    if (paramInt > 0)
    {
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131559689, paramViewGroup, false);
        paramViewGroup = new ache(this, null);
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131361795));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370832));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131366894));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376180));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        achc localachc = (achc)getItem(paramInt);
        paramViewGroup.c.setImageBitmap(a(1, localachc.jdField_a_of_type_JavaLangString));
        if ((TextUtils.isEmpty(localachc.b)) || (localachc.b.equals(localachc.jdField_a_of_type_JavaLangString))) {
          localachc.b = ((TroopManager)this.a.app.getManager(52)).a(this.a.jdField_a_of_type_JavaLangString, localachc.jdField_a_of_type_JavaLangString);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localachc.b);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localachc);
        paramViewGroup.b.setText(a(localachc.jdField_a_of_type_Long));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramViewGroup.jdField_a_of_type_JavaLangString = localachc.jdField_a_of_type_JavaLangString;
        if ((!TroopGagActivity.a(this.a, this.a.app.getCurrentAccountUin())) && ((TroopGagActivity.b(this.a, localachc.jdField_a_of_type_JavaLangString)) || (TroopGagActivity.a(this.a, localachc.jdField_a_of_type_JavaLangString)))) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        if ((paramInt <= 1) && (paramInt != getCount() - 1)) {
          break;
        }
        paramView.setBackgroundResource(2130839176);
        return paramView;
        paramViewGroup = (ache)paramView.getTag();
      }
      paramView.setBackgroundResource(2130839185);
      return paramView;
    }
    return this.a.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if (!(paramView instanceof achc)) {
      return;
    }
    paramView = (achc)paramView;
    String str = paramView.jdField_a_of_type_JavaLangString;
    bakk localbakk = (bakk)this.a.app.getManager(48);
    localbakk.a(this.a.jdField_a_of_type_JavaLangString, str, 0L);
    this.a.jdField_a_of_type_JavaUtilList.remove(paramView);
    notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onClick cancelGag, uin=" + str);
    }
    axqw.b(this.a.app, "P_CliOper", "Grp_manage", "", "silent_mana", "Clk_un", 0, 0, this.a.jdField_a_of_type_JavaLangString + "", localbakk.a(this.a.jdField_a_of_type_JavaLangString), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     achd
 * JD-Core Version:    0.7.0.1
 */