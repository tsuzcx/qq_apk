import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public class achl
  implements View.OnClickListener
{
  public achl(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getTag();
    Object localObject1 = null;
    if ((localObject2 instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)) {
      localObject1 = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag()).jdField_a_of_type_JavaLangObject;
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.a.c((FileInfo)localObject1);
      }
      return;
      if ((localObject2 instanceof ImageHolder))
      {
        localObject2 = (ImageHolder)paramView.getTag();
        paramView = (FileInfo)((ImageHolder)localObject2).jdField_a_of_type_JavaLangObject;
        if (!this.a.a.g())
        {
          localObject1 = paramView;
          if (!this.a.a.h()) {}
        }
        else
        {
          localObject1 = this.a.a.getSharedPreferences("LAST_CHOOSE_", 0).edit();
          ((SharedPreferences.Editor)localObject1).putInt("GROUP", ((ImageHolder)localObject2).b);
          ((SharedPreferences.Editor)localObject1).putInt("CHILD", (((ImageHolder)localObject2).jdField_a_of_type_Int + 1) / 4);
          ((SharedPreferences.Editor)localObject1).commit();
          localObject1 = paramView;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achl
 * JD-Core Version:    0.7.0.1
 */