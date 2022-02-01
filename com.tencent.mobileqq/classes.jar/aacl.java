import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.ArrayList;

public class aacl
  extends aacn
{
  public aacl(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a()
  {
    setDatas(new ArrayList());
    setShareData("share_key_subscribe_user", new aabn(new ExtraTypeInfo()));
    notifyLoadingComplete(true);
  }
  
  public int a()
  {
    return 0;
  }
  
  public aaco a(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(HorizontalRvInnerView paramHorizontalRvInnerView)
  {
    paramHorizontalRvInnerView.setOrientation(1);
  }
  
  protected void handleBlockChange(aabp paramaabp, int paramInt)
  {
    super.handleBlockChange(paramaabp, paramInt);
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
  
  public void onInitBlock(Bundle paramBundle)
  {
    getBlockContainer().setEnableRefresh(true);
    addFloatView(new Button(getContext()));
    getBlockContainer().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacl
 * JD-Core Version:    0.7.0.1
 */