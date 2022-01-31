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

public class ahfh
  extends RecyclerView.Adapter<ahfk>
{
  ahfc jdField_a_of_type_Ahfc;
  ahfl jdField_a_of_type_Ahfl;
  Context jdField_a_of_type_AndroidContentContext;
  List<ahfc> jdField_a_of_type_JavaUtilList;
  
  public ahfh(Context paramContext, List<ahfc> paramList, ahfl paramahfl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Ahfl = paramahfl;
  }
  
  private void a(ahfk paramahfk, ahfc paramahfc)
  {
    paramahfk.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramahfc.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramahfc.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167059);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166910);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramahfc.jdField_a_of_type_Boolean) {
      paramahfk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramahfk.jdField_a_of_type_AndroidWidgetTextView.setText(paramahfc.jdField_a_of_type_JavaLangString);
      paramahfk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramahfk.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setUnselectedColor(str);
      paramahfk.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelectedColor(paramahfc.e);
      paramahfk.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelected(paramahfc.jdField_a_of_type_Boolean);
      azqs.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramahfc.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramahfk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public ahfk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ahfk(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559705, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    ahfc localahfc = (ahfc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localahfc.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ahfc == null) {
      this.jdField_a_of_type_Ahfc = localahfc;
    }
    for (;;)
    {
      notifyDataSetChanged();
      azqs.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localahfc.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Ahfc != localahfc)
      {
        this.jdField_a_of_type_Ahfc.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Ahfc = localahfc;
      }
    }
  }
  
  public void a(ahfk paramahfk, int paramInt)
  {
    a(paramahfk, (ahfc)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramahfk.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setOnClickListener(new ahfi(this, paramInt));
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
 * Qualified Name:     ahfh
 * JD-Core Version:    0.7.0.1
 */