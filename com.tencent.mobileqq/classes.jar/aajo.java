import com.tencent.mobileqq.ark.API.ArkAppMusicModule;
import com.tencent.mobileqq.music.SongInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class aajo
  implements Runnable
{
  aajo(aajm paramaajm, SongInfo paramSongInfo) {}
  
  public void run()
  {
    Iterator localIterator = ArkAppMusicModule.a.iterator();
    while (localIterator.hasNext())
    {
      ArkAppMusicModule localArkAppMusicModule = (ArkAppMusicModule)((WeakReference)localIterator.next()).get();
      if (localArkAppMusicModule != null) {
        localArkAppMusicModule.a(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajo
 * JD-Core Version:    0.7.0.1
 */