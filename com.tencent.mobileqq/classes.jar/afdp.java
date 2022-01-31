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

public class afdp
  extends RecyclerView.Adapter<afds>
{
  afdk jdField_a_of_type_Afdk;
  afdt jdField_a_of_type_Afdt;
  Context jdField_a_of_type_AndroidContentContext;
  List<afdk> jdField_a_of_type_JavaUtilList;
  
  public afdp(Context paramContext, List<afdk> paramList, afdt paramafdt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Afdt = paramafdt;
  }
  
  private void a(afds paramafds, afdk paramafdk)
  {
    paramafds.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = URLDrawable.getDrawable(paramafdk.c, null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus()))
    {
      ((URLDrawable)localObject).setAutoDownload(true);
      ((URLDrawable)localObject).startDownload(true);
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramafdk.b, null);
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
    if (paramafdk.jdField_a_of_type_Boolean) {
      paramafds.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
    for (;;)
    {
      paramafds.jdField_a_of_type_AndroidWidgetTextView.setText(paramafdk.jdField_a_of_type_JavaLangString);
      paramafds.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramafds.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setUnselectedColor(str);
      paramafds.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelectedColor(paramafdk.e);
      paramafds.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setSelected(paramafdk.jdField_a_of_type_Boolean);
      axqw.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_exp", 0, 0, "", paramafdk.jdField_a_of_type_JavaLangString, "", "");
      return;
      paramafds.jdField_a_of_type_AndroidWidgetTextView.setTextColor(j);
      localObject = localURLDrawable;
    }
  }
  
  public afds a(ViewGroup paramViewGroup, int paramInt)
  {
    return new afds(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559654, null));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactTroopClassifyAdapter", 2, "bubbleLayout  clicked  position = " + paramInt);
    }
    afdk localafdk = (afdk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localafdk.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Afdk == null) {
      this.jdField_a_of_type_Afdk = localafdk;
    }
    for (;;)
    {
      notifyDataSetChanged();
      axqw.b(null, "dc00899", "Grp_find_new", "", "grptab", "main_tag_clk", 0, 0, "", localafdk.jdField_a_of_type_JavaLangString, "", "");
      return;
      if (this.jdField_a_of_type_Afdk != localafdk)
      {
        this.jdField_a_of_type_Afdk.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Afdk = localafdk;
      }
    }
  }
  
  public void a(afds paramafds, int paramInt)
  {
    a(paramafds, (afdk)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    paramafds.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactBubbleLayout.setOnClickListener(new afdq(this, paramInt));
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
 * Qualified Name:     afdp
 * JD-Core Version:    0.7.0.1
 */