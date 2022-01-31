import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class akim
  implements View.OnClickListener
{
  public akim(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, akjh paramakjh) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.e.get(this.jdField_a_of_type_JavaLangString);
    paramView = (SeekBar)((FrameLayout)localObject2).findViewById(2131364679);
    Object localObject1 = (TextView)((FrameLayout)localObject2).findViewById(2131362354);
    TextView localTextView1 = (TextView)((FrameLayout)localObject2).findViewById(2131362353);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject2).findViewById(2131362355);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject2).findViewById(2131362351);
    TextView localTextView2 = (TextView)((FrameLayout)localObject2).findViewById(2131362352);
    localObject2 = new akin(this, paramView, (TextView)localObject1, localTextView1, localImageView1, localImageView2, localTextView2);
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f) {
      if (((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
      {
        i = 2130845010;
        localImageView1.setImageResource(i);
        localImageView1.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f = true;
        paramView.setVisibility(0);
        ((TextView)localObject1).setVisibility(0);
        localTextView1.setVisibility(0);
        localImageView2.setVisibility(4);
        localTextView2.setVisibility(4);
        if (((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
        {
          this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.postDelayed((Runnable)localObject2, 3000L);
        }
      }
    }
    do
    {
      return;
      i = 2130845291;
      break;
      if (!((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).isPlaying()) {
        break label348;
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).pause();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Boolean = true;
      localImageView1.setImageResource(2130845291);
      localImageView1.setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("HealthBusinessPlugin", 2, "play onclick in video ");
    return;
    label348:
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_Boolean = false;
    paramView = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_c_of_type_AndroidOsHandler.postDelayed((Runnable)localObject2, 3000L);
    paramView = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
    while (paramView.hasNext())
    {
      localObject1 = (String)paramView.next();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(localObject1)).pause();
    }
    ((TVK_IMediaPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).start();
    this.jdField_a_of_type_Akjh.a.setImageResource(2130845010);
    this.jdField_a_of_type_Akjh.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akim
 * JD-Core Version:    0.7.0.1
 */