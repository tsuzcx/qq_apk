import QC.GetConciseThemeReq;
import QC.GetConciseThemeRsp;
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
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

public class aexr
{
  private static final List<aexu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private aexv jdField_a_of_type_Aexv;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private GeneralSettingActivity jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity;
  private boolean jdField_a_of_type_Boolean = true;
  
  private void a(URLImageView paramURLImageView, aexu paramaexu)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(paramaexu.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
    boolean bool = a((URLDrawable)localObject);
    if (paramURLImageView != null)
    {
      paramURLImageView.setImageDrawable(null);
      paramURLImageView.setImageDrawable((Drawable)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "onBindViewHolder loadPic colorDrawable=" + localObject + " bReady=" + bool + " checked=" + paramaexu.jdField_a_of_type_Boolean);
    }
    paramaexu.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
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
  
  public void a()
  {
    new bhyv("QC.HomepageLogicServer.HomepageLogicObj", "QcHomePageLogic.GetConciseThemeReq", "stReq", "stRsp").a("GetConciseTheme", new GetConciseThemeReq(bhyv.a()), new GetConciseThemeRsp(), new aexs(this), false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "updateSimpleUIChoice bpref=" + paramInt + " needChangeTheme=" + paramBoolean);
    }
    if ((paramInt >= 0) && (this.jdField_a_of_type_Aexv != null))
    {
      aexu localaexu = this.jdField_a_of_type_Aexv.a(paramInt);
      if (localaexu != null)
      {
        localaexu.jdField_b_of_type_Boolean = paramBoolean;
        if ((this.jdField_a_of_type_Aexv.a(localaexu, paramInt, true)) && (paramBoolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity.c(localaexu.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
      }
    }
  }
  
  public void a(View paramView, GeneralSettingActivity paramGeneralSettingActivity)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131364806));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemViewCacheSize(7);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramGeneralSettingActivity);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity = paramGeneralSettingActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new aeya(this, 8));
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Aexv = new aexv(this, jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aexv);
    int j = bdfk.c();
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilList.size())
    {
      MobileReportManager.getInstance().reportAction(((aexu)jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString, "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityGeneralSettingActivity.app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(((aexu)jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString).intValue(), 0, "", "", "", "");
      ((aexu)jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Boolean = false;
      i += 1;
    }
    if ((jdField_a_of_type_JavaUtilList.size() > j) && (j >= 0)) {
      ((aexu)jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Boolean = true;
    }
    if (jdField_a_of_type_JavaUtilList.size() == 0) {
      a();
    }
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
  
  public void b()
  {
    jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Aexv != null) {
      this.jdField_a_of_type_Aexv.a();
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 2, "selectSimpleUIChoice bpref=" + paramInt + " isLoading=" + paramBoolean);
    }
    if ((paramInt >= 0) && (this.jdField_a_of_type_Aexv != null))
    {
      aexu localaexu = this.jdField_a_of_type_Aexv.a(paramInt);
      if (localaexu != null)
      {
        localaexu.jdField_b_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_Aexv.a(localaexu, paramInt, true);
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexr
 * JD-Core Version:    0.7.0.1
 */