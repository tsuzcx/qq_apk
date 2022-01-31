import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.EmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.MagicFaceAdapter;
import java.util.List;

public class acgi
  implements EmotionPanelDataBuilder.EmotionPanelDataCallback
{
  public acgi(MagicFaceAdapter paramMagicFaceAdapter) {}
  
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
 * Qualified Name:     acgi
 * JD-Core Version:    0.7.0.1
 */