import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class adto
{
  private adtr jdField_a_of_type_Adtr;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private GeneralSettingActivity jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity;
  private boolean jdField_a_of_type_Boolean = true;
  
  private void a(URLImageView paramURLImageView, adtq paramadtq)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(paramadtq.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    boolean bool = a((URLDrawable)localObject);
    if (paramURLImageView != null)
    {
      paramURLImageView.setImageDrawable(null);
      paramURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "onBindViewHolder loadPic colorDrawable=" + localObject + " bReady=" + bool + " checked=" + paramadtq.jdField_a_of_type_Boolean);
    }
    paramadtq.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
    if (!bool)
    {
      ((URLDrawable)localObject).setURLDrawableListener(this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity);
      ((URLDrawable)localObject).startDownload();
    }
  }
  
  private boolean a(URLDrawable paramURLDrawable)
  {
    return (paramURLDrawable != null) && ((paramURLDrawable.getStatus() == 1) || (paramURLDrawable.getStatus() == 4));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "updateSimpleUIChoice bpref=" + paramInt + " needChangeTheme=" + paramBoolean);
    }
    if ((paramInt >= 0) && (this.jdField_a_of_type_Adtr != null))
    {
      adtq localadtq = this.jdField_a_of_type_Adtr.a(paramInt);
      localadtq.jdField_b_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_Adtr.a(localadtq, paramInt, true)) && (paramBoolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity.a(localadtq.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
    }
  }
  
  public void a(View paramView, GeneralSettingActivity paramGeneralSettingActivity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = azib.c();
    int i = 0;
    while (i < azhw.a.length)
    {
      adtq localadtq = new adtq(this, azhw.b[i], azhw.a[i], i);
      if (i == j) {
        localadtq.jdField_a_of_type_Boolean = true;
      }
      a(null, localadtq);
      localArrayList.add(localadtq);
      i += 1;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131364434));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemViewCacheSize(7);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramGeneralSettingActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity = paramGeneralSettingActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new adtw(this, 8));
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Adtr = new adtr(this, localArrayList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Adtr);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {}
    float f;
    do
    {
      return true;
      f = paramMotionEvent.getY();
      paramMotionEvent = new int[2];
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLocationOnScreen(paramMotionEvent);
    } while ((f <= paramMotionEvent[1]) || (f >= paramMotionEvent[1] + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getHeight()));
    return false;
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "selectSimpleUIChoice bpref=" + paramInt + " isLoading=" + paramBoolean);
    }
    if ((paramInt >= 0) && (this.jdField_a_of_type_Adtr != null))
    {
      adtq localadtq = this.jdField_a_of_type_Adtr.a(paramInt);
      localadtq.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Adtr.a(localadtq, paramInt, true);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adto
 * JD-Core Version:    0.7.0.1
 */