import com.tencent.mobileqq.leba.LebaGridManager;
import com.tencent.mobileqq.leba.model.PluginInfo;
import java.util.Comparator;

public class adzg
  implements Comparator
{
  public adzg(LebaGridManager paramLebaGridManager) {}
  
  public int a(PluginInfo paramPluginInfo1, PluginInfo paramPluginInfo2)
  {
    if (paramPluginInfo1.type < paramPluginInfo2.type) {}
    do
    {
      return 1;
      if (paramPluginInfo1.type > paramPluginInfo2.type) {
        return -1;
      }
    } while (paramPluginInfo1.weight < paramPluginInfo2.weight);
    if (paramPluginInfo1.weight > paramPluginInfo2.weight) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adzg
 * JD-Core Version:    0.7.0.1
 */