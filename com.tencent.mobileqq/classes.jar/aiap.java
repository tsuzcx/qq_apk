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

public class aiap
  extends RecyclerView.Adapter<aias>
{
  aiak jdField_a_of_type_Aiak;
  aiat jdField_a_of_type_Aiat;
  Context jdField_a_of_type_AndroidContentContext;
  List<aiak> jdField_a_of_type_JavaUtilList;
  
  public aiap(Context paramContext, List<aiak> paramList, aiat paramaiat)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aiat = paramaiat;
  }
  
  private void a(aias paramaias, aiak paramaiak)
  {
    paramaias.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramaiak.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramaiak.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167176);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167019);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramaiak.jdField_a_of_type_Boolean) {
      paramaias.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramaias.jdField_a_of_type_AndroidWidgetTextView.setText(paramaiak.jdField_a_of_type_JavaLangString);
      paramaias.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramaias.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setUnselectedColor(str);
      paramaias.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelectedColor(paramaiak.e);
      paramaias.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(paramaiak.jdField_a_of_type_Boolean);
      bcef.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramaiak.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramaias.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public aias a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aias(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559850, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    aiak localaiak = (aiak)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localaiak.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aiak == null) {
      this.jdField_a_of_type_Aiak = localaiak;
    }
    for (;;)
    {
      notifyDataSetChanged();
      bcef.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localaiak.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Aiak != localaiak)
      {
        this.jdField_a_of_type_Aiak.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aiak = localaiak;
      }
    }
  }
  
  public void a(aias paramaias, int paramInt)
  {
    a(paramaias, (aiak)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramaias.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setOnClickListener(new aiaq(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaias, paramInt, getItemId(paramInt));
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
 * Qualified Name:     aiap
 * JD-Core Version:    0.7.0.1
 */