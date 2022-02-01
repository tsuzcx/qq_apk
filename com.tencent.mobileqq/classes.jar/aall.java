import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class aall
  extends aacq
{
  public aall(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    return SubscribePersonalDetailFragment.a(this.a);
  }
  
  public void loadData(aabu paramaabu)
  {
    if ((paramaabu.c()) || (paramaabu.d()))
    {
      if ((SubscribePersonalDetailFragment.a(this.a) != null) && (SubscribePersonalDetailFragment.a(this.a).a() == 1))
      {
        SubDraftChangeEvent localSubDraftChangeEvent = new SubDraftChangeEvent();
        aaak.a().a(localSubDraftChangeEvent);
      }
      SubscribePersonalDetailFragment.a(this.a, paramaabu);
    }
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aall
 * JD-Core Version:    0.7.0.1
 */