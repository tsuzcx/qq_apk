import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class ajgo
  implements CompoundButton.OnCheckedChangeListener
{
  ajgo(ajgn paramajgn, ajgr paramajgr) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Ajgr.a).troopuin.equals(ajgn.a(this.jdField_a_of_type_Ajgn)))) {
      this.jdField_a_of_type_Ajgr.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgo
 * JD-Core Version:    0.7.0.1
 */