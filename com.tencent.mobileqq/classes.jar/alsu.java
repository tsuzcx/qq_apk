import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;
import com.tencent.mobileqq.ark.ArkAppCenter;

public final class alsu
  implements ArkEnvironmentManager.LibraryLoader
{
  public boolean Load()
  {
    ArkAppCenter.f();
    return ArkAppCenter.b;
  }
  
  public boolean isLibraryLoad()
  {
    return ArkAppCenter.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsu
 * JD-Core Version:    0.7.0.1
 */