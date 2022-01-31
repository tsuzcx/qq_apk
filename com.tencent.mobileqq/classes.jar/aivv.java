import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.troop.homework.recite.utils.ReciteDetectManager;
import com.tencent.mobileqq.troop.homework.recite.utils.ReciteDetectManager.ReciteDetectListener;
import java.util.List;

public class aivv
  extends Handler
{
  public aivv(ReciteDetectManager paramReciteDetectManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (ReciteDetectManager.a(this.a) == null) {}
    List localList;
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          paramMessage = (WordInfo)paramMessage.obj;
          ReciteDetectManager.a(this.a).a(paramMessage);
          ReciteDetectManager.a(this.a, paramMessage);
        }
      } while ((!paramMessage.isDetected) || (paramMessage.paragraphPos != this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size() - 1));
      localList = ((ParagraphInfo)this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(paramMessage.paragraphPos)).generateOrGetWordInfoList(paramMessage.paragraphPos);
    } while (paramMessage.wordPos != localList.size() - 2);
    this.a.a();
    return;
    ReciteDetectManager.a(this.a).f();
    return;
    ReciteDetectManager.a(this.a).a(this.a.jdField_a_of_type_Int, this.a.b, this.a.c);
    this.a.jdField_a_of_type_Int = 0;
    this.a.c = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aivv
 * JD-Core Version:    0.7.0.1
 */