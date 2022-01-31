import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.EmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter;
import java.util.List;

public class acoe
  implements EmotionPanelDataBuilder.EmotionPanelDataCallback
{
  public acoe(FavoriteEmotionAdapter paramFavoriteEmotionAdapter) {}
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.a.a(paramList);
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acoe
 * JD-Core Version:    0.7.0.1
 */