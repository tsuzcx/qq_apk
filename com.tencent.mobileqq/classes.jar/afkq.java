import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import org.json.JSONObject;

class afkq
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  afkq(afkp paramafkp) {}
  
  public void onClick(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    long l = SystemClock.uptimeMillis();
    if (l - this.jdField_a_of_type_Long >= 500L)
    {
      this.jdField_a_of_type_Long = l;
      if ((paramView.getTag() != null) && ((paramView.getTag() instanceof JSONObject))) {
        break label49;
      }
    }
    label49:
    String str;
    Context localContext;
    do
    {
      do
      {
        return;
        localObject2 = (JSONObject)paramView.getTag();
        try
        {
          localObject1 = ((JSONObject)localObject2).getString("url");
          str = ((JSONObject)localObject2).getString("name");
          localContext = paramView.getContext();
          if (this.jdField_a_of_type_Afkp.a != null) {
            MediaPlayerManager.a(this.jdField_a_of_type_Afkp.a).a(true);
          }
          if (!QQPlayerService.a(this.jdField_a_of_type_Afkp)) {
            break;
          }
          QQPlayerService.c(localContext);
          paramView.setContentDescription(localResources.getString(2131690325));
          return;
        }
        catch (Exception paramView) {}
      } while (!QLog.isColorLevel());
      QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(paramView));
      return;
      if ((this.jdField_a_of_type_Afkp.a == null) || (!this.jdField_a_of_type_Afkp.a.c())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("CommonHobbyForAIOShowItemBuilder", 0, "Video Chatting is going on, don't play music.");
    return;
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
    localSongInfo.jdField_b_of_type_Int = 4;
    QQPlayerService.a(new Intent(localContext, MusicPlayerActivity.class));
    Object localObject2 = QQPlayerService.a();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new Bundle();
      QQPlayerService.a((Bundle)localObject1);
    }
    ((Bundle)localObject1).putString("KEY_SOURCE_NAME", str);
    QQPlayerService.a(this.jdField_a_of_type_Afkp);
    QQPlayerService.a(localContext, this.jdField_a_of_type_Afkp.getToken(), localSongInfo);
    paramView.setContentDescription(localResources.getString(2131690323));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkq
 * JD-Core Version:    0.7.0.1
 */