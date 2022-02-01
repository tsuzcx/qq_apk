import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.demo.DemoBaseWidgetView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;

public class aacj
  extends aacq
{
  private BaseWidgetView a;
  
  public aacj(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    this.a.setData(null);
    setShareData("share_key_subscribe_user", new aabn(new ExtraTypeInfo()));
    notifyLoadingComplete(true);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.a = new DemoBaseWidgetView(getContext());
    return this.a;
  }
  
  protected void handleBlockChange(aabp paramaabp, int paramInt)
  {
    super.handleBlockChange(paramaabp, paramInt);
  }
  
  public void handleShareDataChange(String paramString, aabn paramaabn)
  {
    super.handleShareDataChange(paramString, paramaabn);
  }
  
  public boolean isEnableRefresh()
  {
    return false;
  }
  
  public void loadData(aabu paramaabu)
  {
    if ((paramaabu.d()) || (paramaabu.c())) {
      a();
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
  }
  
  public boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    ((aacg)getViewModel(aacg.class)).a().observe((QCircleBaseFragment)getParentFragment(), new aack(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacj
 * JD-Core Version:    0.7.0.1
 */