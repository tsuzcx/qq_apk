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

public class aiux
  extends RecyclerView.Adapter<aiva>
{
  aius jdField_a_of_type_Aius;
  aivb jdField_a_of_type_Aivb;
  Context jdField_a_of_type_AndroidContentContext;
  List<aius> jdField_a_of_type_JavaUtilList;
  
  public aiux(Context paramContext, List<aius> paramList, aivb paramaivb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Aivb = paramaivb;
  }
  
  private void a(aiva paramaiva, aius paramaius)
  {
    paramaiva.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramaius.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramaius.b, null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus()))
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
    String str = "#F5F6FA";
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167143);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166993);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
      str = "#282828";
    }
    if (paramaius.jdField_a_of_type_Boolean) {
      paramaiva.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramaiva.jdField_a_of_type_AndroidWidgetTextView.setText(paramaius.jdField_a_of_type_JavaLangString);
      paramaiva.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramaiva.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setUnselectedColor(str);
      paramaiva.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelectedColor(paramaius.e);
      paramaiva.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(paramaius.jdField_a_of_type_Boolean);
      bcst.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramaius.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramaiva.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public aiva a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aiva(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559842, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    aius localaius = (aius)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localaius.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Aius == null) {
      this.jdField_a_of_type_Aius = localaius;
    }
    for (;;)
    {
      notifyDataSetChanged();
      bcst.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localaius.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Aius != localaius)
      {
        this.jdField_a_of_type_Aius.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Aius = localaius;
      }
    }
  }
  
  public void a(aiva paramaiva, int paramInt)
  {
    a(paramaiva, (aius)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramaiva.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setOnClickListener(new aiuy(this, paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaiva, paramInt, getItemId(paramInt));
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
 * Qualified Name:     aiux
 * JD-Core Version:    0.7.0.1
 */