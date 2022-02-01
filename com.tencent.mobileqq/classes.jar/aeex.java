import android.text.Editable;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;

public abstract interface aeex
{
  public abstract void afterTextChanged(Editable paramEditable);
  
  public abstract void onEditTextFocusChanged(boolean paramBoolean);
  
  public abstract void onItemDeleted(ResultRecord paramResultRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aeex
 * JD-Core Version:    0.7.0.1
 */