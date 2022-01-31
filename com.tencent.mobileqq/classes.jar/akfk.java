import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;

class akfk
  implements View.OnClickListener
{
  akfk(akfj paramakfj, ArrayList paramArrayList, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString), 120);
    paramView.a();
    tij.a(this.jdField_a_of_type_Akfj.a.a, paramView.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfk
 * JD-Core Version:    0.7.0.1
 */