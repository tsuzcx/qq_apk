import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import java.util.Iterator;
import java.util.List;

public class ahro
  implements View.OnClickListener
{
  public ahro(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.a.iterator();
    while (paramView.hasNext()) {
      ((EmoticonFromGroupEntity)paramView.next()).status = -1;
    }
    this.a.a.clear();
    EmoticonGroupStoreFragment.a(this.a).setVisibility(8);
    EmoticonGroupStoreFragment.b(this.a).setVisibility(0);
    EmoticonGroupStoreFragment.a(this.a).a = false;
    EmoticonGroupStoreFragment.a(this.a).a(false);
    EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
    EmoticonGroupStoreFragment.e(this.a);
    this.a.a(true);
    this.a.resetLeftButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahro
 * JD-Core Version:    0.7.0.1
 */