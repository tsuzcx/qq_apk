import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class adde
  implements IMemoryDumpListener
{
  adde(addd paramaddd, adcb paramadcb) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onHprofDumped(@NotNull String paramString)
  {
    this.jdField_a_of_type_Adcb.a();
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.addAll(adct.b());
    localArrayList.add(adct.b());
    localArrayList.add(adct.a());
    localArrayList.add(adct.a(paramString, l1 - l2));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adde
 * JD-Core Version:    0.7.0.1
 */