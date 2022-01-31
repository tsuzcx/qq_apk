import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import java.io.File;

public class algj
  implements Runnable
{
  public algj(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    boolean bool1 = false;
    Object localObject2 = null;
    Object localObject1 = new File(AppConstants.aQ);
    ((File)localObject1).mkdirs();
    if (((File)localObject1).canWrite())
    {
      localObject2 = Long.toString(System.currentTimeMillis());
      localObject1 = AppConstants.aQ + "world_cup_share_" + (String)localObject2 + ".mp4";
      File localFile = new File((String)localObject1);
      int i = 2;
      while ((localFile.exists()) && (i < 2147483647))
      {
        localObject1 = AppConstants.aQ + "world_cup_share_" + (String)localObject2 + "(" + i + ").mp4";
        localFile = new File((String)localObject1);
        i += 1;
      }
      boolean bool2 = WorldCupShareFragment.a(this.a, WorldCupShareFragment.a(this.a), (String)localObject1);
      bool1 = bool2;
      localObject2 = localObject1;
      if (!bool2)
      {
        bool1 = bool2;
        localObject2 = localObject1;
        if (localFile.exists())
        {
          localFile.delete();
          localObject2 = localObject1;
          bool1 = bool2;
        }
      }
    }
    if (this.a.getActivity() != null) {
      this.a.getActivity().runOnUiThread(new algk(this, bool1, (String)localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algj
 * JD-Core Version:    0.7.0.1
 */