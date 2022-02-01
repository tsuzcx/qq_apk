import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajms
  implements AdapterView.OnItemClickListener
{
  public ajms(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ajmy localajmy = (ajmy)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
    boolean bool = localajmy.jdField_a_of_type_Boolean;
    if (bool)
    {
      if (EmoticonGroupStoreFragment.b(this.a).contains(localajmy.jdField_a_of_type_JavaLangString)) {
        EmoticonGroupStoreFragment.b(this.a).remove(localajmy.jdField_a_of_type_JavaLangString);
      }
      localajmy = (ajmy)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
      if (bool) {
        break label144;
      }
    }
    label144:
    for (bool = true;; bool = false)
    {
      localajmy.jdField_a_of_type_Boolean = bool;
      EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      EmoticonGroupStoreFragment.b(this.a).add(localajmy.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajms
 * JD-Core Version:    0.7.0.1
 */