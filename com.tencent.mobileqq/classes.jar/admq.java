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

public class admq
  implements ArkViewImplement.InputCallback
{
  public admq(ArkAppView paramArkAppView) {}
  
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
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    paramView = (ViewGroup)this.a.getParent();
    if (ArkAppView.a(this.a) != null) {
      paramView = ArkAppView.a(this.a);
    }
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      Object localObject2 = this.a.getResources().getDrawable(2130838480);
      Object localObject1 = this.a.getResources().getDrawable(2130838479);
      int i = ((Drawable)localObject2).getIntrinsicWidth();
      int j = ((Drawable)localObject2).getIntrinsicHeight();
      this.a.setInputSetSelectHolderSize(i, j);
      this.a.setInputSetCaretHolderSize(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (ArkAppView.a(this.a) == null)
      {
        ArkAppView.a(this.a, new ImageView(this.a.getContext()));
        ArkAppView.a(this.a).setBackgroundDrawable((Drawable)localObject2);
        ArkAppView.a(this.a).setScaleX(-1.0F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(ArkAppView.a(this.a), localLayoutParams);
        ArkAppView.a(this.a).setVisibility(8);
        ArkAppView.a(this.a).setOnTouchListener(this.a);
      }
      if (ArkAppView.b(this.a) == null)
      {
        ArkAppView.b(this.a, new ImageView(this.a.getContext()));
        ArkAppView.b(this.a).setBackgroundDrawable((Drawable)localObject2);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(ArkAppView.b(this.a), (ViewGroup.LayoutParams)localObject2);
        ArkAppView.b(this.a).setVisibility(8);
        ArkAppView.a(this.a).setOnTouchListener(this.a);
      }
      if (ArkAppView.c(this.a) == null)
      {
        ArkAppView.c(this.a, new ImageView(this.a.getContext()));
        ArkAppView.c(this.a).setBackgroundDrawable((Drawable)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(ArkAppView.c(this.a), (ViewGroup.LayoutParams)localObject1);
        ArkAppView.c(this.a).setVisibility(8);
        ArkAppView.c(this.a).setOnTouchListener(this.a);
      }
    }
    a(ArkAppView.a(this.a));
    a(ArkAppView.b(this.a));
    a(ArkAppView.c(this.a));
  }
  
  public void onHideMenu(View paramView)
  {
    if (ArkAppView.a(this.a) != null)
    {
      ArkAppView.a(this.a).b();
      ArkAppView.a(this.a, null);
    }
  }
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView = (ViewGroup)this.a.getParent();
    if (ArkAppView.a(this.a) != null) {
      paramView = ArkAppView.a(this.a);
    }
    if (paramView == null) {
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4)))
    {
      int j = ArkAppView.a(this.a).getWidth();
      int i = j;
      if (j <= 0) {
        i = this.a.getResources().getDrawable(2130838480).getIntrinsicWidth();
      }
      a(ArkAppView.a(this.a), this.a.getLeft() + paramInt1 - i, this.a.getTop() + paramInt2);
      if ((paramInt3 <= 0) || (paramInt4 <= 0) || ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4))) {
        break label280;
      }
      a(ArkAppView.b(this.a), this.a.getLeft() + paramInt3, this.a.getTop() + paramInt4);
    }
    for (;;)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
        break label294;
      }
      paramInt2 = ArkAppView.c(this.a).getWidth();
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = this.a.getResources().getDrawable(2130838479).getIntrinsicWidth();
      }
      a(ArkAppView.c(this.a), this.a.getLeft() + paramInt3 - paramInt1 / 2, this.a.getTop() + paramInt4);
      return;
      a(ArkAppView.a(this.a));
      break;
      label280:
      a(ArkAppView.b(this.a));
    }
    label294:
    a(ArkAppView.c(this.a));
  }
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (ArkAppView.a(this.a) != null)
    {
      ArkAppView.a(this.a).b();
      ArkAppView.a(this.a, null);
    }
    bbmf localbbmf = new bbmf();
    if (paramInt4 == 2)
    {
      localbbmf.a(0, ajya.a(2131700650));
      localbbmf.a(1, ajya.a(2131700646));
      localbbmf.a(2, ajya.a(2131700647));
    }
    for (;;)
    {
      int i = this.a.getResources().getDrawable(2130838479).getIntrinsicHeight();
      ArkViewImplement.ArkViewInterface localArkViewInterface = (ArkViewImplement.ArkViewInterface)paramView;
      ArkAppView.a(this.a, bbcq.a(paramView, paramInt1, paramInt2, paramInt3 + i, localbbmf, new admr(this, paramInt4, localArkViewInterface)));
      return;
      if (paramInt4 == 1)
      {
        localbbmf.a(0, ajya.a(2131700649));
        localbbmf.a(1, ajya.a(2131700645));
        localbbmf.a(2, ajya.a(2131700648));
      }
      else
      {
        localbbmf.a(0, ajya.a(2131700651));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admq
 * JD-Core Version:    0.7.0.1
 */