import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.BubbleLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aest
  extends RecyclerView.Adapter<aesw>
{
  aeso jdField_a_of_type_Aeso;
  aesx jdField_a_of_type_Aesx;
  Context jdField_a_of_type_AndroidContentContext;
  List<aeso> jdField_a_of_type_JavaUtilList;
  
  public aest(Context paramContext, List<aeso> paramList, aesx paramaesx)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aesx = paramaesx;
  }
  
  private void a(aesw paramaesw, aeso paramaeso)
  {
    paramaesw.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramaeso.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramaeso.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101411);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101267);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramaeso.jdField_a_of_type_Boolean) {
      paramaesw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramaesw.jdField_a_of_type_AndroidWidgetTextView.setText(paramaeso.jdField_a_of_type_JavaLangString);
      paramaesw.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramaesw.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setUnselectedColor(str);
      paramaesw.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelectedColor(paramaeso.e);
      paramaesw.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelected(paramaeso.jdField_a_of_type_Boolean);
      awqx.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramaeso.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramaesw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public aesw a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aesw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494082, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    aeso localaeso = (aeso)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localaeso.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aeso == null) {
      this.jdField_a_of_type_Aeso = localaeso;
    }
    for (;;)
    {
      notifyDataSetChanged();
      awqx.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localaeso.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Aeso != localaeso)
      {
        this.jdField_a_of_type_Aeso.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aeso = localaeso;
      }
    }
  }
  
  public void a(aesw paramaesw, int paramInt)
  {
    a(paramaesw, (aeso)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramaesw.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setOnClickListener(new aesu(this, paramInt));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aest
 * JD-Core Version:    0.7.0.1
 */