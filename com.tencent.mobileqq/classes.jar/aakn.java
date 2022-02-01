import android.widget.ImageView;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1.1;
import com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1.2;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aakn
  implements bdvw
{
  public aakn(AbsSubscribeShareCardView.2 param2) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.jdField_a_of_type_Int == 0)
    {
      ((ImageView)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.jdField_a_of_type_Int)).setImageBitmap(SafeBitmapFactory.decodeFile(this.a.jdField_a_of_type_JavaLangString));
      AbsSubscribeShareCardView.a(this.a.this$0);
      if (AbsSubscribeShareCardView.b(this.a.this$0) == this.a.b.size()) {
        ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.2.1.1(this));
      }
      return;
    }
    ThreadManager.getUIHandler().post(new AbsSubscribeShareCardView.2.1.2(this));
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakn
 * JD-Core Version:    0.7.0.1
 */