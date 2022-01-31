import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;

public class afdz
  implements RadioGroup.OnCheckedChangeListener
{
  public afdz(AddContactsActivity paramAddContactsActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((paramInt == 2131376802) && (AddContactsActivity.a(this.a).isChecked()))
    {
      AddContactsActivity.a(this.a);
      axqy.b(this.a.app, "CliOper", "", "", "0X8004BE9", "0X8004BE9", 0, 0, "", "", "", "");
      AddContactsActivity.a(this.a).setSelected(true);
      AddContactsActivity.b(this.a).setSelected(false);
      AddContactsActivity.c(this.a).setSelected(false);
      AddContactsActivity.a(this.a).setVisibility(8);
    }
    do
    {
      return;
      if ((paramInt == 2131376804) && (AddContactsActivity.b(this.a).isChecked()))
      {
        AddContactsActivity.b(this.a);
        axqy.b(this.a.app, "CliOper", "", "", "0X8004BEA", "0X8004BEA", 0, 0, "", "", "", "");
        axqy.b(this.a.app, "P_CliOper", "Grp_find", "", "grptab", "exp", 0, 0, "", "", "", "");
        AddContactsActivity.b(this.a).setSelected(true);
        AddContactsActivity.a(this.a).setSelected(false);
        AddContactsActivity.c(this.a).setSelected(false);
        paramRadioGroup = AddContactsActivity.a(this.a);
        if (AddContactsActivity.a(this.a)) {}
        for (paramInt = 0;; paramInt = 8)
        {
          paramRadioGroup.setVisibility(paramInt);
          return;
        }
      }
    } while ((paramInt != 2131376803) || (!AddContactsActivity.c(this.a).isChecked()));
    AddContactsActivity.c(this.a);
    axqy.b(this.a.app, "CliOper", "", "", "0X8004BEB", "0X8004BEB", 0, 0, "", "", "", "");
    AddContactsActivity.c(this.a).setSelected(true);
    AddContactsActivity.a(this.a).setSelected(false);
    AddContactsActivity.b(this.a).setSelected(false);
    AddContactsActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afdz
 * JD-Core Version:    0.7.0.1
 */