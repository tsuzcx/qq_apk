import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import java.util.List;

public class afic
  implements AdapterView.OnItemClickListener
{
  public afic(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (afii)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
    boolean bool = paramAdapterView.jdField_a_of_type_Boolean;
    if (bool)
    {
      if (EmoticonGroupStoreFragment.b(this.a).contains(paramAdapterView.jdField_a_of_type_JavaLangString)) {
        EmoticonGroupStoreFragment.b(this.a).remove(paramAdapterView.jdField_a_of_type_JavaLangString);
      }
      paramAdapterView = (afii)EmoticonGroupStoreFragment.a(this.a).get(paramInt);
      if (bool) {
        break label126;
      }
    }
    label126:
    for (bool = true;; bool = false)
    {
      paramAdapterView.jdField_a_of_type_Boolean = bool;
      EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
      return;
      EmoticonGroupStoreFragment.b(this.a).add(paramAdapterView.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afic
 * JD-Core Version:    0.7.0.1
 */