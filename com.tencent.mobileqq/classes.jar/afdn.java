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

public class afdn
  extends RecyclerView.Adapter<afdq>
{
  afdi jdField_a_of_type_Afdi;
  afdr jdField_a_of_type_Afdr;
  Context jdField_a_of_type_AndroidContentContext;
  List<afdi> jdField_a_of_type_JavaUtilList;
  
  public afdn(Context paramContext, List<afdi> paramList, afdr paramafdr)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Afdr = paramafdr;
  }
  
  private void a(afdq paramafdq, afdi paramafdi)
  {
    paramafdq.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramafdi.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramafdi.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167006);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166861);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramafdi.jdField_a_of_type_Boolean) {
      paramafdq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramafdq.jdField_a_of_type_AndroidWidgetTextView.setText(paramafdi.jdField_a_of_type_JavaLangString);
      paramafdq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramafdq.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setUnselectedColor(str);
      paramafdq.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelectedColor(paramafdi.e);
      paramafdq.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelected(paramafdi.jdField_a_of_type_Boolean);
      axqy.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramafdi.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramafdq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public afdq a(ViewGroup paramViewGroup, int paramInt)
  {
    return new afdq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559654, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    afdi localafdi = (afdi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localafdi.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Afdi == null) {
      this.jdField_a_of_type_Afdi = localafdi;
    }
    for (;;)
    {
      notifyDataSetChanged();
      axqy.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localafdi.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Afdi != localafdi)
      {
        this.jdField_a_of_type_Afdi.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Afdi = localafdi;
      }
    }
  }
  
  public void a(afdq paramafdq, int paramInt)
  {
    a(paramafdq, (afdi)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramafdq.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setOnClickListener(new afdo(this, paramInt));
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
 * Qualified Name:     afdn
 * JD-Core Version:    0.7.0.1
 */