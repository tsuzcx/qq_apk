import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.ColorNoteListLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class altj
  implements altu, RecyclerView.ItemAnimator.ItemAnimatorFinishedListener, View.OnClickListener
{
  private static int jdField_a_of_type_Int = 2131101551;
  private static int jdField_b_of_type_Int = 2131101537;
  private static int c = 2130838972;
  private alte jdField_a_of_type_Alte;
  private altu jdField_a_of_type_Altu;
  private Context jdField_a_of_type_AndroidContentContext;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ColorNoteListLayout jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public altj(Context paramContext, altu paramaltu)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Altu = paramaltu;
  }
  
  private void c()
  {
    e();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493253, null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout = ((ColorNoteListLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298833));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298837));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(c);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297854));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131298836));
    Object localObject = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new altk(this));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new altl(this));
    localObject = new altm(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131297854).setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.requestFocus();
    this.jdField_b_of_type_Boolean = false;
    localObject = alsq.a();
    if ((localObject != null) && (((alsp)localObject).a())) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void d()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidViewView.hasFocus())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.0F).setDuration(200L).start();
    ViewPropertyAnimator localViewPropertyAnimator = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.animate().setInterpolator(new AccelerateInterpolator(3.0F));
    if (this.jdField_a_of_type_Boolean) {}
    for (float f = -this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth();; f = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getWidth())
    {
      localViewPropertyAnimator.translationX(f).setDuration(180L).setListener(new altr(this)).start();
      return;
    }
  }
  
  private void e()
  {
    if (ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      jdField_a_of_type_Int = 2131099751;
      jdField_b_of_type_Int = 2131099738;
      c = 2130838973;
      return;
    }
    jdField_a_of_type_Int = 2131101551;
    jdField_b_of_type_Int = 2131101537;
    c = 2130838972;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
    this.jdField_a_of_type_Alte = new alte();
    this.jdField_a_of_type_Alte.a(this);
    this.jdField_a_of_type_Alte.a(paramBoolean);
    List localList = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a().a();
    this.jdField_a_of_type_Alte.a(localList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Alte);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(4);
    this.jdField_a_of_type_Alte.a(new altn(this));
    Object localObject;
    if (localList.size() > 0)
    {
      localObject = (ColorNote)localList.get(0);
      if (alsr.b((ColorNote)localObject)) {
        awqx.b(null, "dc00898", "", "", "0X800A8AA", "0X800A8AA", alru.b(alsr.a(((ColorNote)localObject).getServiceType())), 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setAnchor(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListLayout.setHideListener(this);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewView.animate().alpha(0.9F).setDuration(200L).setListener(new altq(this, paramBoolean)).start();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = new ArrayMap();
      localIterator = localList.iterator();
      label266:
      if (!localIterator.hasNext()) {
        break label350;
      }
      paramInt2 = ((ColorNote)localIterator.next()).getServiceType();
      if (!((ArrayMap)localObject).containsValue(Integer.valueOf(paramInt2))) {
        break label345;
      }
    }
    label345:
    for (paramInt1 = ((Integer)((ArrayMap)localObject).valueAt(paramInt2)).intValue() + 1;; paramInt1 = 1)
    {
      ((ArrayMap)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      break label266;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
    }
    label350:
    Iterator localIterator = ((ArrayMap)localObject).keySet().iterator();
    paramInt1 = 0;
    paramInt2 = 0;
    int i;
    if (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      if (((Integer)((ArrayMap)localObject).get(Integer.valueOf(i))).intValue() <= paramInt2) {
        break label519;
      }
      paramInt1 = ((Integer)((ArrayMap)localObject).get(Integer.valueOf(i))).intValue();
    }
    for (paramInt2 = i;; paramInt2 = i)
    {
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break;
      awqx.b(null, "dc00898", "", "", "0X800A6CD", "0X800A6CD", 0, 0, localList.size() + "", alru.a(paramInt1) + "", "", "");
      return;
      label519:
      i = paramInt1;
      paramInt1 = paramInt2;
    }
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(c);
  }
  
  public void onAnimationsFinished()
  {
    if (this.jdField_a_of_type_Alte.getItemCount() == 0) {
      d();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    d();
    awqx.b(null, "dc00898", "", "", "0X800A6CE", "0X800A6CE", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     altj
 * JD-Core Version:    0.7.0.1
 */