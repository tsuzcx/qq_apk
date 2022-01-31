import android.text.TextUtils;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class aely
  extends auxl
{
  public aely(VisitorsActivity paramVisitorsActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals("0", paramString)))
    {
      if (this.a.jdField_a_of_type_Aemq != null) {
        this.a.jdField_a_of_type_Aemq.notifyDataSetChanged();
      }
      if (this.a.b != null) {
        this.a.b.notifyDataSetChanged();
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramString1.equals(this.a.app.getCurrentAccountUin())) {}
    do
    {
      return;
      if (paramInt2 == 1)
      {
        if (!paramBoolean)
        {
          this.a.jdField_a_of_type_Awwy.b(paramString2, paramInt1, false);
          return;
        }
        this.a.jdField_a_of_type_Awwy.a(paramString2, paramInt1, false);
        return;
      }
    } while (paramInt2 != 0);
    this.a.jdField_a_of_type_Awwy.a(Long.parseLong(paramString2));
  }
  
  protected void a(boolean paramBoolean, ArrayList<auvx> paramArrayList, int paramInt)
  {
    if ((paramBoolean) && (paramArrayList != null)) {}
    for (;;)
    {
      auvx localauvx;
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          if (paramArrayList.hasNext())
          {
            localauvx = (auvx)paramArrayList.next();
            if (paramInt != 511) {
              break label121;
            }
            if (localauvx.jdField_a_of_type_Int != 0) {
              continue;
            }
            awwy localawwy = this.a.jdField_a_of_type_Awwy;
            String str = localauvx.jdField_a_of_type_Long + "";
            int i = localauvx.b;
            localawwy.a(str, localauvx.c + i, false);
            continue;
          }
        }
        return;
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
      }
      label121:
      if (localauvx.jdField_a_of_type_Int == 0) {
        this.a.jdField_a_of_type_Awwy.a(localauvx.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aely
 * JD-Core Version:    0.7.0.1
 */