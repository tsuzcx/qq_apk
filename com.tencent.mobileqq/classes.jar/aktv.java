import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import java.util.ArrayList;

class aktv
  implements View.OnClickListener
{
  aktv(aktu paramaktu, ArrayList paramArrayList, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString), 120);
    paramView.a();
    tvc.a(this.jdField_a_of_type_Aktu.a.a, paramView.a(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aktv
 * JD-Core Version:    0.7.0.1
 */