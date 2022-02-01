import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.connections.ConnectsExplorationBanner;
import com.tencent.widget.SimpleTextView;

class aidf
  extends bjub
{
  aidf(aidb paramaidb, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, bjua parambjua, View.OnClickListener paramOnClickListener)
  {
    parambjua = super.a(paramInt, paramObject, parambjua, paramOnClickListener);
    if ((parambjua instanceof SimpleTextView)) {
      parambjua.setTag(paramObject);
    }
    return parambjua;
  }
  
  public void a(int paramInt, Object paramObject, bjua[] paramArrayOfbjua)
  {
    int i = 0;
    if ((paramArrayOfbjua == null) || (paramArrayOfbjua.length <= 0)) {}
    for (;;)
    {
      return;
      paramInt = i;
      if (paramArrayOfbjua.length < 0)
      {
        paramInt = i;
        if (!(paramObject instanceof ConnectsExplorationBanner))
        {
          paramArrayOfbjua[0].b = 0;
          paramArrayOfbjua[0].a = 0;
          paramInt = 1;
        }
      }
      while (paramInt < paramArrayOfbjua.length)
      {
        paramArrayOfbjua[paramInt].b = -1;
        paramArrayOfbjua[paramInt].a = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidf
 * JD-Core Version:    0.7.0.1
 */