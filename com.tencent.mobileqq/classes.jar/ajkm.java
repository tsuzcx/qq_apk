import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.ILayoutSizeHandler;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;

class ajkm
  implements SceneBuilder.ILayoutSizeHandler
{
  ajkm(ajkj paramajkj) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.a.a.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.a.a.a.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkm
 * JD-Core Version:    0.7.0.1
 */