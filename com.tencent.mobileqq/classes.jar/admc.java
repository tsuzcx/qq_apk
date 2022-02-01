import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class admc
  implements IMemoryDumpListener
{
  admc(admb paramadmb, adkz paramadkz) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onHprofDumped(@NotNull String paramString)
  {
    this.jdField_a_of_type_Adkz.a();
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.addAll(adlr.b());
    localArrayList.add(adlr.b());
    localArrayList.add(adlr.a());
    localArrayList.add(adlr.a(paramString, l1 - l2));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admc
 * JD-Core Version:    0.7.0.1
 */