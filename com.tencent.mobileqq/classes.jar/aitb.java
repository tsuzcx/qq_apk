import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aitb
  implements AdapterView.OnItemClickListener
{
  public aitb(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aith localaith = (aith)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
    boolean bool = localaith.jdField_a_of_type_Boolean;
    if (bool)
    {
      if (EmoticonGroupStoreFragment.b(this.a).contains(localaith.jdField_a_of_type_JavaLangString)) {
        EmoticonGroupStoreFragment.b(this.a).remove(localaith.jdField_a_of_type_JavaLangString);
      }
      localaith = (aith)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
      if (bool) {
        break label144;
      }
    }
    label144:
    for (bool = true;; bool = false)
    {
      localaith.jdField_a_of_type_Boolean = bool;
      EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      EmoticonGroupStoreFragment.b(this.a).add(localaith.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitb
 * JD-Core Version:    0.7.0.1
 */