import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.widget.BubblePopupWindow;
import mqq.util.WeakReference;

public class aipj
  implements ArkViewImplement.InputCallback
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private WeakReference<ArkAppView> jdField_a_of_type_MqqUtilWeakReference;
  private ImageView b;
  private ImageView c;
  
  public aipj(ArkAppView paramArkAppView)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramArkAppView);
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.setVisibility(8);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.animate().x(paramInt1).y(paramInt2).setDuration(0L).start();
    }
  }
  
  public int a()
  {
    if (this.c != null) {
      return this.c.getHeight();
    }
    return 0;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    ArkAppView localArkAppView = (ArkAppView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localArkAppView == null) {}
    do
    {
      return;
      paramView = (ViewGroup)localArkAppView.getParent();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        paramView = this.jdField_a_of_type_AndroidViewViewGroup;
      }
    } while (paramView == null);
    if (paramBoolean)
    {
      Object localObject2 = localArkAppView.getResources().getDrawable(2130838705);
      Object localObject1 = localArkAppView.getResources().getDrawable(2130838704);
      localArkAppView.setInputSetSelectHolderSize(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localArkAppView.setInputSetCaretHolderSize(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localArkAppView.getContext());
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(-1.0F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localArkAppView);
      }
      if (this.b == null)
      {
        this.b = new ImageView(localArkAppView.getContext());
        this.b.setBackgroundDrawable((Drawable)localObject2);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.b, (ViewGroup.LayoutParams)localObject2);
        this.b.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localArkAppView);
      }
      if (this.c == null)
      {
        this.c = new ImageView(localArkAppView.getContext());
        this.c.setBackgroundDrawable((Drawable)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.c, (ViewGroup.LayoutParams)localObject1);
        this.c.setVisibility(8);
        this.c.setOnTouchListener(localArkAppView);
      }
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    a(this.b);
    a(this.c);
  }
  
  public void onHideMenu(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkAppView localArkAppView = (ArkAppView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localArkAppView == null) {}
    do
    {
      return;
      paramView = (ViewGroup)localArkAppView.getParent();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        paramView = this.jdField_a_of_type_AndroidViewViewGroup;
      }
    } while (paramView == null);
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4)))
    {
      int j = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      int i = j;
      if (j <= 0) {
        i = localArkAppView.getResources().getDrawable(2130838705).getIntrinsicWidth();
      }
      a(this.jdField_a_of_type_AndroidWidgetImageView, localArkAppView.getLeft() + paramInt1 - i, localArkAppView.getTop() + paramInt2);
      if ((paramInt3 <= 0) || (paramInt4 <= 0) || ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4))) {
        break label255;
      }
      a(this.b, localArkAppView.getLeft() + paramInt3, localArkAppView.getTop() + paramInt4);
    }
    for (;;)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
        break label266;
      }
      paramInt2 = this.c.getWidth();
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = localArkAppView.getResources().getDrawable(2130838704).getIntrinsicWidth();
      }
      a(this.c, localArkAppView.getLeft() + paramInt3 - paramInt1 / 2, localArkAppView.getTop() + paramInt4);
      return;
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      break;
      label255:
      a(this.b);
    }
    label266:
    a(this.c);
  }
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkAppView localArkAppView = (ArkAppView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localArkAppView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    bhjq localbhjq = new bhjq();
    if (paramInt4 == 2)
    {
      localbhjq.a(0, anvx.a(2131700149));
      localbhjq.a(1, anvx.a(2131700145));
      localbhjq.a(2, anvx.a(2131700146));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhcw.a(paramView, paramInt1, paramInt2, paramInt3 + localArkAppView.getResources().getDrawable(2130838704).getIntrinsicHeight(), localbhjq, new aipk(this, paramInt4, (ArkViewImplement.ArkViewInterface)paramView));
      return;
      if (paramInt4 == 1)
      {
        localbhjq.a(0, anvx.a(2131700148));
        localbhjq.a(1, anvx.a(2131700144));
        localbhjq.a(2, anvx.a(2131700147));
      }
      else
      {
        localbhjq.a(0, anvx.a(2131700150));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipj
 * JD-Core Version:    0.7.0.1
 */