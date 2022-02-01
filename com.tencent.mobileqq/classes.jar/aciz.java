import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class aciz
  implements IMemoryDumpListener
{
  aciz(aciy paramaciy, acht paramacht) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onFinishDump " + paramBoolean + " " + paramString1 + " " + paramString2);
  }
  
  public void onHprofDumped(@NotNull String paramString)
  {
    if (this.jdField_a_of_type_Acht != null) {
      this.jdField_a_of_type_Acht.a();
    }
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onPrepareDump " + paramString);
    paramString = new ArrayList(4);
    paramString.addAll(acik.a());
    paramString.addAll(acik.b());
    paramString.add(acik.b());
    paramString.add(acik.a());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aciz
 * JD-Core Version:    0.7.0.1
 */