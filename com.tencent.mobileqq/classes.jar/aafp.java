import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.subscribe.comment.EmoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aafp
  implements AdapterView.OnItemClickListener
{
  public aafp(EmoView paramEmoView, int paramInt) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 27)
    {
      if (EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView) != null) {
        bool1 = EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a();
      }
      if (!bool1) {
        EmoView.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i = (this.jdField_a_of_type_Int - 1) * 27 + paramInt;
      if (i < 107)
      {
        String str = aagc.b[aaft.b[i]];
        bool1 = bool2;
        if (EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView) != null) {
          bool1 = EmoView.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a(str);
        }
        if (!bool1) {
          EmoView.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentEmoView).a(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafp
 * JD-Core Version:    0.7.0.1
 */