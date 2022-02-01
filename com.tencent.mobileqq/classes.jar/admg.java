import com.tencent.qapmsdk.base.listener.IMemoryDumpListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class admg
  implements IMemoryDumpListener
{
  admg(admf paramadmf, adkz paramadkz) {}
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onFinishDump " + paramBoolean + " " + paramString1 + " " + paramString2);
  }
  
  public void onHprofDumped(@NotNull String paramString)
  {
    if (this.jdField_a_of_type_Adkz != null) {
      this.jdField_a_of_type_Adkz.a();
    }
  }
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    QLog.i("MagnifierSDK.QAPM.QAPMLeakWrapper", 1, "onPrepareDump " + paramString);
    paramString = new ArrayList(4);
    paramString.addAll(adlr.a());
    paramString.addAll(adlr.b());
    paramString.add(adlr.b());
    paramString.add(adlr.a());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admg
 * JD-Core Version:    0.7.0.1
 */