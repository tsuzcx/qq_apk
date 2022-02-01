import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.widget.SimpleTextView;

public class ajnx
  extends blfn
{
  public ajnx(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, blfm paramblfm, View.OnClickListener paramOnClickListener)
  {
    paramblfm = super.a(paramInt, paramObject, paramblfm, paramOnClickListener);
    if ((paramblfm instanceof SimpleTextView)) {
      paramblfm.setTag(paramObject);
    }
    return paramblfm;
  }
  
  public void a(int paramInt, Object paramObject, blfm[] paramArrayOfblfm)
  {
    this.a.a(paramInt, paramArrayOfblfm, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnx
 * JD-Core Version:    0.7.0.1
 */