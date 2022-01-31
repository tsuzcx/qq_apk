import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class agrs
  extends BaseAdapter
  implements URLDrawableDownListener
{
  Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public LayoutInflater a;
  ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public agrs(NewPhotoListActivity paramNewPhotoListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramNewPhotoListActivity.getLayoutInflater();
    this.jdField_a_of_type_AndroidContentResResources = paramNewPhotoListActivity.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130846926);
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity);
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(bbll.b(30.0F), bbll.b(18.0F));
    localGradientDrawable.setCornerRadii(new float[] { bbll.b(2.0F), bbll.b(2.0F), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public List<LocalMediaInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsa.f) && (bbbx.a((LocalMediaInfo)paramList.get(0)) == 2)) {
      paramList.remove(0);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return bbbx.a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    agrq localagrq = new agrq(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity);
    agrt localagrt;
    if (paramView == null)
    {
      localagrt = new agrt(this);
      switch (getItemViewType(paramInt))
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return paramView;
          localagrt = (agrt)paramView.getTag();
          break;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a == null);
        return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a.a(paramInt, paramView, paramViewGroup, localagrt, localagrq);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a == null);
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a.b(paramInt, paramView, paramViewGroup, localagrt, localagrq);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a == null);
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.jdField_a_of_type_Agsc.a.a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return bbbx.d.size();
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i = paramView.listViewPosition;
    if ((i == -1) || (paramView.visableTime == 0L)) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      l2 = paramView.visableTime;
    } while (!QLog.isColorLevel());
    QLog.d("PhotoListActivity", 2, "onLoadSuccessed,no next ,listViewPositon:" + i + " costTime:" + (l1 - l2) + " imageInfo;" + paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrs
 * JD-Core Version:    0.7.0.1
 */