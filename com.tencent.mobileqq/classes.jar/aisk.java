import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.data.TroopInfo;

class aisk
  implements CompoundButton.OnCheckedChangeListener
{
  aisk(aisj paramaisj, aisn paramaisn) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton.isEnabled()) && (!((TroopInfo)this.jdField_a_of_type_Aisn.a).troopuin.equals(aisj.a(this.jdField_a_of_type_Aisj)))) {
      this.jdField_a_of_type_Aisn.b = Boolean.valueOf(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aisk
 * JD-Core Version:    0.7.0.1
 */