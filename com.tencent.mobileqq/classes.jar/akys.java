import android.content.Context;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.OCRScanEntryView;
import com.tencent.mobileqq.ar.view.QRScanEntryView;
import com.tencent.mobileqq.ar.view.ScanEntryProviderView;
import java.util.ArrayList;

public class akys
{
  private int jdField_a_of_type_Int;
  private ArrayList<akyt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131307690, 2131297170, 2131305325 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { ajjy.a(2131647718), "AR", ajjy.a(2131647721) };
  public boolean b;
  private final int[] b;
  public boolean c;
  private final int[] c;
  private final int[] d = { 2130843973, 2130843974, 2130843975, 2130843976, 2130843977, 2130843978, 2130843979, 2130843980 };
  
  public akys(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfInt = new int[] { 2130843981, 2130843982, 2130843983, 2130843984, 2130843985, 2130843986, 2130843987, 2130843988 };
    this.jdField_c_of_type_ArrayOfInt = new int[] { 2130843955, 2130843956, 2130843957, 2130843958, 2130843959, 2130843960, 2130843961, 2130843962 };
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
  
  public akyt a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b())) {
      return (akyt)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public ScanEntryProviderView a(int paramInt, Context paramContext, akyn paramakyn)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new QRScanEntryView(paramContext, paramakyn);
    case 2: 
      return new ARScanEntryView(paramContext, paramakyn);
    }
    return new OCRScanEntryView(paramContext, paramakyn);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new akyt(1, ajjy.a(2131647719)));
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new akyt(2, "AR"));
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new akyt(3, "OCR"));
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
      return this.jdField_c_of_type_ArrayOfInt;
    }
    if (paramInt == 2) {
      return this.d;
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
 * Qualified Name:     akys
 * JD-Core Version:    0.7.0.1
 */