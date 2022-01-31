import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;
import com.tencent.mobileqq.ark.ArkAppCenter;

final class alvv
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
 * Qualified Name:     alvv
 * JD-Core Version:    0.7.0.1
 */