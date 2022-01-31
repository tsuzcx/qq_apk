import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;

public class abbe
  implements Runnable
{
  public abbe(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, String paramString, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder) {}
  
  public void run()
  {
    String str = ArkAppCenter.b(this.jdField_a_of_type_JavaLangString);
    ArkAppCenter.a().postToMainThread(new abbf(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbe
 * JD-Core Version:    0.7.0.1
 */