import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.util.FaceDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class akbs
  implements Runnable
{
  private final WeakReference a;
  
  public akbs(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void run()
  {
    int i = 6;
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {}
    Object localObject1;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = TroopMoreDetailView.a(localTroopMoreDetailView);
        } while (localObject1 == null);
        localQQAppInterface = TroopMoreDetailView.a(localTroopMoreDetailView);
      } while ((localQQAppInterface == null) || (localTroopMoreDetailView.jdField_a_of_type_ArrayOfAndroidViewView == null));
      localObject3 = localTroopMoreDetailView.jdField_a_of_type_ArrayOfAndroidViewView[6];
    } while (localObject3 == null);
    int k = localTroopMoreDetailView.jdField_a_of_type_JavaUtilArrayList.size();
    if (k == 0)
    {
      ((View)localObject3).setVisibility(8);
      return;
    }
    ((LinearLayout)((View)localObject3).findViewById(2131371579)).setVisibility(0);
    Object localObject2 = (TextView)((View)localObject3).findViewById(2131371580);
    ((TextView)localObject2).setText("共" + k + "人");
    Object localObject3 = (TextView)((View)localObject3).findViewById(2131365887);
    int j = (localTroopMoreDetailView.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels - ((TextView)localObject3).getMeasuredWidth() - UIUtils.a((Context)localObject1, 27.0F) - ((TextView)localObject2).getMeasuredWidth() - UIUtils.a((Context)localObject1, 24.0F)) / UIUtils.a((Context)localObject1, 52.0F);
    if (j > 6) {}
    for (;;)
    {
      j = 0;
      label209:
      if (j < i - 1)
      {
        localObject1 = (ImageView)localTroopMoreDetailView.jdField_a_of_type_JavaUtilList.get(j);
        if (j >= k) {
          break label338;
        }
        localObject2 = (String)localTroopMoreDetailView.jdField_a_of_type_JavaUtilArrayList.get(j);
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject1).setBackgroundDrawable(FaceDrawable.a(localQQAppInterface, 1, (String)localObject2, 3));
        ((ImageView)localObject1).setTag(localObject2);
        ((ImageView)localObject1).setOnClickListener(new akbt(this, localTroopMoreDetailView));
        if (AppSetting.b)
        {
          ((ImageView)localObject1).setContentDescription("图片" + (j + 1));
          ViewCompat.setImportantForAccessibility((View)localObject1, 1);
        }
      }
      for (;;)
      {
        j += 1;
        break label209;
        break;
        label338:
        ((ImageView)localObject1).setVisibility(8);
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbs
 * JD-Core Version:    0.7.0.1
 */