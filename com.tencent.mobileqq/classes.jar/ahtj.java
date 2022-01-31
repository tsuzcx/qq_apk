import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.OnTipClickListener;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ahtj
  implements ReadInJoySearchTipsContainer.OnTipClickListener
{
  public ahtj(HotWordsForSubBussFragment paramHotWordsForSubBussFragment) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      FragmentActivity localFragmentActivity = this.a.getActivity();
      if ((localFragmentActivity instanceof ActiveEntitySearchActivity))
      {
        ((ActiveEntitySearchActivity)localFragmentActivity).a(paramString);
        if (this.a.a != null) {
          SearchUtils.a("sub_result", "clk_hot", new String[] { paramString, SearchUtils.a(this.a.a) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahtj
 * JD-Core Version:    0.7.0.1
 */