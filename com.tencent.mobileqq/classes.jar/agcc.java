import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class agcc
  extends agcd
{
  public agcc(QzoneFrame paramQzoneFrame)
  {
    super(paramQzoneFrame);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QzoneFrame", 1, "onSwitch: " + paramInt);
    Fragment localFragment = QzoneFrame.b(this.a);
    if ((QzoneFrame.b(this.a) == QzoneFrame.a(this.a)) && (paramInt == 1)) {
      return;
    }
    String str;
    Drawable localDrawable;
    if (QzoneFrame.c(this.a) == null)
    {
      QzoneFrame.a(this.a, bhbh.a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.qzone.feed.ui.activity.QQLebaExtendFeedFragment"));
      if (QzoneFrame.a(this.a) == null) {
        QzoneFrame.a(this.a, (TextView)QzoneFrame.a(this.a).findViewById(2131368472));
      }
      if (QzoneFrame.b(this.a) != QzoneFrame.c(this.a)) {
        break label490;
      }
      QzoneFrame.b(this.a, QzoneFrame.a(this.a));
      ((bhbl)QzoneFrame.a(this.a)).setTitleAlphaAndGetLastValue(QzoneFrame.a(this.a));
      str = "动态";
      localDrawable = null;
      if (QzoneFrame.b(this.a) != null)
      {
        QzoneFrame.b(this.a).onAttach(this.a.a());
        QzoneFrame.b(this.a).onCreate(null);
        if (QzoneFrame.b(this.a).getView() == null)
        {
          QzoneFrame.b(this.a).onCreateView(LayoutInflater.from(this.a.a()), null, null);
          QzoneFrame.b(this.a).onActivityCreated(null);
        }
      }
      if ((QzoneFrame.b(this.a) == QzoneFrame.c(this.a)) && ((QzoneFrame.c(this.a) instanceof bhbl)))
      {
        if (!QzoneFrame.a(this.a)) {
          break label607;
        }
        QzoneFrame.a(this.a, false);
      }
      label321:
      localFragment.onPause();
      localFragment.onStop();
      QzoneFrame.b(this.a).onStart();
      ((bhbl)QzoneFrame.b(this.a)).resetReportFlag();
      QzoneFrame.b(this.a).onResume();
      QzoneFrame.b(this.a).removeView(localFragment.getView());
      QzoneFrame.b(this.a).addView(QzoneFrame.b(this.a).getView());
      if (Build.VERSION.SDK_INT <= 15) {
        break label625;
      }
      QzoneFrame.b(this.a).setBackground(localDrawable);
    }
    for (;;)
    {
      QzoneFrame.a(this.a).setText(str);
      if (QzoneFrame.b(this.a) != QzoneFrame.a(this.a)) {
        break label639;
      }
      ((bhbl)QzoneFrame.a(this.a)).setRightButtonType(QzoneFrame.jdField_a_of_type_Int);
      return;
      if ((QzoneFrame.b(this.a) != QzoneFrame.c(this.a)) || (paramInt != 2)) {
        break;
      }
      return;
      label490:
      QzoneFrame.b(this.a, QzoneFrame.c(this.a));
      if (QzoneFrame.a(this.a) == null)
      {
        if (Build.VERSION.SDK_INT <= 20) {
          break label581;
        }
        QzoneFrame.a(this.a, this.a.a().getDrawable(2130844274));
      }
      for (;;)
      {
        QzoneFrame.a(this.a, ((bhbl)QzoneFrame.a(this.a)).setTitleAlphaAndGetLastValue(0));
        localDrawable = QzoneFrame.a(this.a);
        str = "暖说说";
        break;
        label581:
        QzoneFrame.a(this.a, this.a.a().getResources().getDrawable(2130844274));
      }
      label607:
      ((bhbl)QzoneFrame.c(this.a)).forceRefresh();
      break label321;
      label625:
      QzoneFrame.b(this.a).setBackgroundDrawable(localDrawable);
    }
    label639:
    ((bhbl)QzoneFrame.a(this.a)).setRightButtonType(QzoneFrame.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcc
 * JD-Core Version:    0.7.0.1
 */