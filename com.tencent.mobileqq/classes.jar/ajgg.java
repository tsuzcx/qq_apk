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

public class ajgg
  extends RecyclerView.Adapter<ajgj>
{
  ajgb jdField_a_of_type_Ajgb;
  ajgk jdField_a_of_type_Ajgk;
  Context jdField_a_of_type_AndroidContentContext;
  List<ajgb> jdField_a_of_type_JavaUtilList;
  
  public ajgg(Context paramContext, List<ajgb> paramList, ajgk paramajgk)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Ajgk = paramajgk;
  }
  
  private void a(ajgj paramajgj, ajgb paramajgb)
  {
    paramajgj.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramajgb.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramajgb.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167153);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166997);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramajgb.jdField_a_of_type_Boolean) {
      paramajgj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramajgj.jdField_a_of_type_AndroidWidgetTextView.setText(paramajgb.jdField_a_of_type_JavaLangString);
      paramajgj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramajgj.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setUnselectedColor(str);
      paramajgj.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelectedColor(paramajgb.e);
      paramajgj.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(paramajgb.jdField_a_of_type_Boolean);
      bdll.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramajgb.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramajgj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public ajgj a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ajgj(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559848, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    ajgb localajgb = (ajgb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localajgb.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ajgb == null) {
      this.jdField_a_of_type_Ajgb = localajgb;
    }
    for (;;)
    {
      notifyDataSetChanged();
      bdll.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localajgb.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Ajgb != localajgb)
      {
        this.jdField_a_of_type_Ajgb.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Ajgb = localajgb;
      }
    }
  }
  
  public void a(ajgj paramajgj, int paramInt)
  {
    a(paramajgj, (ajgb)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramajgj.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setOnClickListener(new ajgh(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramajgj, paramInt, getItemId(paramInt));
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
 * Qualified Name:     ajgg
 * JD-Core Version:    0.7.0.1
 */