import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class advt
  implements mxt
{
  public advt(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void a(Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "ratingScore : " + paramInt);
    }
    this.a.e = paramInt;
    if (paramInt <= 3) {}
    for (;;)
    {
      try
      {
        if (mum.a("qav_score_bad.jpg")) {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), mum.b() + "qav_score_bad.jpg"));
        }
        ScoreQAVFragment.a(this.a).setVisibility(0);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.b.setText(2131696310);
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0))
        {
          ScoreQAVFragment.a(this.a).setAdapter(ScoreQAVFragment.a(this.a));
          if (paramInt <= 0) {
            break label398;
          }
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFF"));
          this.a.jdField_a_of_type_JavaUtilArrayList.clear();
          return;
        }
      }
      catch (OutOfMemoryError paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("ScoreActivity", 2, "mIcon OOM: " + paramObject);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ScoreActivity", 2, "mDatas is invalid!");
        continue;
      }
      if (paramInt > 3)
      {
        ScoreQAVFragment.a(this.a).setVisibility(8);
        try
        {
          if (mum.a("qav_score_good.jpg")) {
            this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.a.getResources(), mum.b() + "qav_score_good.jpg"));
          }
          this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          this.a.b.setText(2131696310);
        }
        catch (OutOfMemoryError paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("ScoreActivity", 2, "mIcon OOM: " + paramObject);
            }
          }
        }
        label398:
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advt
 * JD-Core Version:    0.7.0.1
 */