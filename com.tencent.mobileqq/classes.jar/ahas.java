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

public class ahas
  extends RecyclerView.Adapter<ahav>
{
  ahan jdField_a_of_type_Ahan;
  ahaw jdField_a_of_type_Ahaw;
  Context jdField_a_of_type_AndroidContentContext;
  List<ahan> jdField_a_of_type_JavaUtilList;
  
  public ahas(Context paramContext, List<ahan> paramList, ahaw paramahaw)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Ahaw = paramahaw;
  }
  
  private void a(ahav paramahav, ahan paramahan)
  {
    paramahav.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramahan.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramahan.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167057);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166908);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramahan.jdField_a_of_type_Boolean) {
      paramahav.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramahav.jdField_a_of_type_AndroidWidgetTextView.setText(paramahan.jdField_a_of_type_JavaLangString);
      paramahav.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramahav.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setUnselectedColor(str);
      paramahav.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelectedColor(paramahan.e);
      paramahav.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelected(paramahan.jdField_a_of_type_Boolean);
      azmj.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramahan.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramahav.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public ahav a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ahav(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559706, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    ahan localahan = (ahan)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localahan.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ahan == null) {
      this.jdField_a_of_type_Ahan = localahan;
    }
    for (;;)
    {
      notifyDataSetChanged();
      azmj.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localahan.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Ahan != localahan)
      {
        this.jdField_a_of_type_Ahan.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Ahan = localahan;
      }
    }
  }
  
  public void a(ahav paramahav, int paramInt)
  {
    a(paramahav, (ahan)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramahav.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setOnClickListener(new ahat(this, paramInt));
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahas
 * JD-Core Version:    0.7.0.1
 */