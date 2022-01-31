import android.content.Context;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.OCRScanEntryView;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.ar.view.ScanEntryProviderView;
import java.util.ArrayList;

public class alnd
{
  private int jdField_a_of_type_Int;
  private ArrayList<alne> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131373405, 2131371000, 2131362709 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { ajya.a(2131713517), ajya.a(2131718908), "AR" };
  public boolean b;
  private final int[] b;
  public boolean c;
  private final int[] c;
  private final int[] d = { 2130844054, 2130844055, 2130844056, 2130844057, 2130844058, 2130844059, 2130844060, 2130844061 };
  
  public alnd(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2130844062, 2130844063, 2130844064, 2130844065, 2130844066, 2130844067, 2130844068, 2130844069 };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2130844037, 2130844038, 2130844039, 2130844040, 2130844041, 2130844042, 2130844043, 2130844044 };
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_ArrayOfInt.length;
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    while (paramInt == 2) {
      return i;
    }
    return 2;
  }
  
  public alne a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b())) {
      return (alne)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, almy paramalmy)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new QRScanEntryView(paramContext, paramalmy);
    case 3: 
      return new ARScanEntryView(paramContext, paramalmy);
    }
    return new OCRScanEntryView(paramContext, paramalmy);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new alne(1, ajya.a(2131713518)));
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new alne(2, "OCR"));
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new alne(3, "AR"));
      }
    }
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_b_of_type_ArrayOfInt;
    }
    if (paramInt == 1) {
      return this.d;
    }
    if (paramInt == 2) {
      return this.jdField_c_of_type_ArrayOfInt;
    }
    return null;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alnd
 * JD-Core Version:    0.7.0.1
 */