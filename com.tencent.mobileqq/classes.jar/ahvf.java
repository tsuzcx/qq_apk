import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ahvf
  extends RecyclerView.Adapter<ahvg>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ahvd> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ahvf(QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  private BusinessInfoCheckUpdate.AppInfo a(ahvd paramahvd)
  {
    return ((bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(10, String.valueOf(paramahvd.c), paramahvd.f);
  }
  
  private void a(@NonNull ahvg paramahvg, ahvd paramahvd)
  {
    paramahvg.itemView.setContentDescription(paramahvd.jdField_a_of_type_JavaLangString + anvx.a(2131707325));
    paramahvg.itemView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramahvg.itemView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    paramahvg.itemView.setEnabled(true);
    paramahvg.itemView.setTag(paramahvd);
    bgyd.a(paramahvg.itemView, true);
  }
  
  private void b(@NonNull ahvg paramahvg, int paramInt)
  {
    int i = 3;
    int j = XPanelContainer.a;
    int k = XPanelContainer.b;
    if (paramInt <= 3) {}
    for (paramInt = i;; paramInt = 6)
    {
      paramInt = (j - k) / paramInt;
      paramahvg.itemView.setPadding(0, paramInt, 0, 0);
      return;
    }
  }
  
  private void b(@NonNull ahvg paramahvg, ahvd paramahvd)
  {
    ahvg.a(paramahvg).setVisibility(0);
    ahvg.a(paramahvg).setBackgroundDrawable(paramahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if ((paramahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
    {
      paramahvg = (URLDrawable)paramahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramahvg.getStatus() == 2) {
        paramahvg.restartDownload();
      }
    }
  }
  
  private void c(@NonNull ahvg paramahvg, ahvd paramahvd)
  {
    int i = 0;
    ahvg.a(paramahvg).setVisibility(0);
    ahvg.a(paramahvg).d();
    if (!TextUtils.isEmpty(paramahvd.c))
    {
      ahvg.b(paramahvg).setVisibility(8);
      paramahvd = a(paramahvd);
      if (paramahvd != null) {
        ahvg.a(paramahvg).a(paramahvd);
      }
      return;
    }
    paramahvg = ahvg.b(paramahvg);
    if (paramahvd.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      paramahvg.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  @NonNull
  public ahvg a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558903, null);
    paramInt = ViewUtils.dpToPx(15.0F);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(-1, (XPanelContainer.b - paramInt) / 2 + (XPanelContainer.a - XPanelContainer.b) / 2));
    return new ahvg(paramViewGroup);
  }
  
  public void a(@NonNull ahvg paramahvg, int paramInt)
  {
    ahvd localahvd = (ahvd)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    b(paramahvg, paramInt);
    b(paramahvg, localahvd);
    c(paramahvg, localahvd);
    ahvg.a(paramahvg).setText(localahvd.jdField_a_of_type_JavaLangString);
    bgyd.a(ahvg.a(paramahvg), false);
    a(paramahvg, localahvd);
  }
  
  public void a(List<ahvd> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
 * Qualified Name:     ahvf
 * JD-Core Version:    0.7.0.1
 */