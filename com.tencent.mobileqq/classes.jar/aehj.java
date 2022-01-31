import android.text.TextUtils;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class aehj
  extends autc
{
  public aehj(VisitorsActivity paramVisitorsActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals("0", paramString)))
    {
      if (this.a.jdField_a_of_type_Aeib != null) {
        this.a.jdField_a_of_type_Aeib.notifyDataSetChanged();
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
          this.a.jdField_a_of_type_Awsp.b(paramString2, paramInt1, false);
          return;
        }
        this.a.jdField_a_of_type_Awsp.a(paramString2, paramInt1, false);
        return;
      }
    } while (paramInt2 != 0);
    this.a.jdField_a_of_type_Awsp.a(Long.parseLong(paramString2));
  }
  
  protected void a(boolean paramBoolean, ArrayList<auro> paramArrayList, int paramInt)
  {
    if ((paramBoolean) && (paramArrayList != null)) {}
    for (;;)
    {
      auro localauro;
      try
      {
        if (paramArrayList.size() > 0)
        {
          paramArrayList = paramArrayList.iterator();
          if (paramArrayList.hasNext())
          {
            localauro = (auro)paramArrayList.next();
            if (paramInt != 511) {
              break label121;
            }
            if (localauro.jdField_a_of_type_Int != 0) {
              continue;
            }
            awsp localawsp = this.a.jdField_a_of_type_Awsp;
            String str = localauro.jdField_a_of_type_Long + "";
            int i = localauro.b;
            localawsp.a(str, localauro.c + i, false);
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
      if (localauro.jdField_a_of_type_Int == 0) {
        this.a.jdField_a_of_type_Awsp.a(localauro.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehj
 * JD-Core Version:    0.7.0.1
 */