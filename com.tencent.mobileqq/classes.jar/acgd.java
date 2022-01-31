import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.EmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter;
import java.util.List;

public class acgd
  implements EmotionPanelDataBuilder.EmotionPanelDataCallback
{
  public acgd(FavoriteEmotionAdapter paramFavoriteEmotionAdapter) {}
  
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
 * Qualified Name:     acgd
 * JD-Core Version:    0.7.0.1
 */