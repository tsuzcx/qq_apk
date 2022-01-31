import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class abaw
  extends ajvq
{
  public abaw(EmosmActivity paramEmosmActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1) {
      if (paramBoolean)
      {
        paramObject = (EmoticonResp)paramObject;
        this.a.a(paramObject.delEpId);
        this.a.b();
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.e();
      }
    }
    label119:
    do
    {
      do
      {
        return;
        this.a.a();
        EmosmActivity.a(this.a, (EmoticonResp)paramObject);
        break;
        if (paramInt != 2) {
          break label119;
        }
        if (QLog.isColorLevel()) {
          QLog.i("EmosmActivity", 2, "emoticon fetch:" + paramBoolean);
        }
      } while (!paramBoolean);
      this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
      return;
    } while (paramInt != 17);
    if (paramBoolean)
    {
      paramObject = ((EmoticonResp)paramObject).ids.iterator();
      while (paramObject.hasNext())
      {
        Integer localInteger = (Integer)paramObject.next();
        this.a.a(localInteger.intValue());
      }
    }
    this.a.a();
    EmosmActivity.a(this.a, (EmoticonResp)paramObject);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abaw
 * JD-Core Version:    0.7.0.1
 */