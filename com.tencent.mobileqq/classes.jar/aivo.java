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
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aivo
  extends RecyclerView.Adapter<aivr>
{
  aivj jdField_a_of_type_Aivj;
  aivs jdField_a_of_type_Aivs;
  Context jdField_a_of_type_AndroidContentContext;
  List<aivj> jdField_a_of_type_JavaUtilList;
  
  public aivo(Context paramContext, List<aivj> paramList, aivs paramaivs)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aivs = paramaivs;
  }
  
  private void a(aivr paramaivr, aivj paramaivj)
  {
    paramaivr.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramaivj.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramaivj.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167190);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramaivj.jdField_a_of_type_Boolean) {
      paramaivr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramaivr.jdField_a_of_type_AndroidWidgetTextView.setText(paramaivj.jdField_a_of_type_JavaLangString);
      paramaivr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramaivr.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setUnselectedColor(str);
      paramaivr.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelectedColor(paramaivj.e);
      paramaivr.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(paramaivj.jdField_a_of_type_Boolean);
      bdla.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramaivj.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramaivr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public aivr a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aivr(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559894, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    aivj localaivj = (aivj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localaivj.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aivj == null) {
      this.jdField_a_of_type_Aivj = localaivj;
    }
    for (;;)
    {
      notifyDataSetChanged();
      bdla.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localaivj.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Aivj != localaivj)
      {
        this.jdField_a_of_type_Aivj.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aivj = localaivj;
      }
    }
  }
  
  public void a(aivr paramaivr, int paramInt)
  {
    a(paramaivr, (aivj)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramaivr.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setOnClickListener(new aivp(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaivr, paramInt, getItemId(paramInt));
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
 * Qualified Name:     aivo
 * JD-Core Version:    0.7.0.1
 */