import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajyb
  implements AdapterView.OnItemClickListener
{
  public ajyb(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ajyh localajyh = (ajyh)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
    boolean bool = localajyh.jdField_a_of_type_Boolean;
    if (bool)
    {
      if (EmoticonGroupStoreFragment.b(this.a).contains(localajyh.jdField_a_of_type_JavaLangString)) {
        EmoticonGroupStoreFragment.b(this.a).remove(localajyh.jdField_a_of_type_JavaLangString);
      }
      localajyh = (ajyh)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
      if (bool) {
        break label144;
      }
    }
    label144:
    for (bool = true;; bool = false)
    {
      localajyh.jdField_a_of_type_Boolean = bool;
      EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      EmoticonGroupStoreFragment.b(this.a).add(localajyh.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyb
 * JD-Core Version:    0.7.0.1
 */