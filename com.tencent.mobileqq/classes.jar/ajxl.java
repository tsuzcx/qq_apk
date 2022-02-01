import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter;
import com.tencent.widget.SimpleTextView;

public class ajxl
  extends blpy
{
  public ajxl(ContactsTroopAdapter paramContactsTroopAdapter, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, blpx paramblpx, View.OnClickListener paramOnClickListener)
  {
    paramblpx = super.a(paramInt, paramObject, paramblpx, paramOnClickListener);
    if ((paramblpx instanceof SimpleTextView)) {
      paramblpx.setTag(paramObject);
    }
    return paramblpx;
  }
  
  public void a(int paramInt, Object paramObject, blpx[] paramArrayOfblpx)
  {
    this.a.a(paramInt, paramArrayOfblpx, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxl
 * JD-Core Version:    0.7.0.1
 */