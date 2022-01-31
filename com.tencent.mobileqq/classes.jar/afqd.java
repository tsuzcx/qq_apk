import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;

class afqd
  extends afqe
{
  afqd(afqb paramafqb)
  {
    super(paramafqb);
  }
  
  public void a(int paramInt)
  {
    Fragment localFragment = afqb.b(this.a);
    if ((afqb.b(this.a) == afqb.a(this.a)) && (paramInt == 1)) {
      return;
    }
    String str;
    Drawable localDrawable;
    if (afqb.c(this.a) == null)
    {
      afqb.a(this.a, bfsz.a(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.qzone.feed.ui.activity.QQLebaExtendFeedFragment"));
      if (afqb.a(this.a) == null) {
        afqb.a(this.a, (TextView)afqb.a(this.a).findViewById(2131302847));
      }
      if (afqb.b(this.a) != afqb.c(this.a)) {
        break label450;
      }
      afqb.b(this.a, afqb.a(this.a));
      ((bftc)afqb.a(this.a)).setTitleAlphaAndGetLastValue(afqb.a(this.a));
      str = "动态";
      localDrawable = null;
      if (afqb.b(this.a) != null)
      {
        afqb.b(this.a).onAttach(this.a.a());
        afqb.b(this.a).onCreate(null);
        if (afqb.b(this.a).getView() == null)
        {
          afqb.b(this.a).onCreateView(LayoutInflater.from(this.a.a()), null, null);
          afqb.b(this.a).onActivityCreated(null);
        }
      }
      if ((afqb.b(this.a) == afqb.c(this.a)) && ((afqb.c(this.a) instanceof bftc)))
      {
        if (!afqb.a(this.a)) {
          break label567;
        }
        afqb.a(this.a, false);
      }
      label296:
      localFragment.onPause();
      localFragment.onStop();
      afqb.b(this.a).onStart();
      afqb.b(this.a).onResume();
      afqb.b(this.a).removeView(localFragment.getView());
      afqb.b(this.a).addView(afqb.b(this.a).getView());
      if (Build.VERSION.SDK_INT <= 15) {
        break label585;
      }
      afqb.b(this.a).setBackground(localDrawable);
    }
    for (;;)
    {
      afqb.a(this.a).setText(str);
      if (afqb.b(this.a) != afqb.a(this.a)) {
        break label599;
      }
      ((bftc)afqb.a(this.a)).setRightButtonType(afqb.jdField_a_of_type_Int);
      return;
      if ((afqb.b(this.a) != afqb.c(this.a)) || (paramInt != 2)) {
        break;
      }
      return;
      label450:
      afqb.b(this.a, afqb.c(this.a));
      if (afqb.a(this.a) == null)
      {
        if (Build.VERSION.SDK_INT <= 20) {
          break label541;
        }
        afqb.a(this.a, this.a.a().getDrawable(2130844196));
      }
      for (;;)
      {
        afqb.a(this.a, ((bftc)afqb.a(this.a)).setTitleAlphaAndGetLastValue(0));
        localDrawable = afqb.a(this.a);
        str = "暖说说";
        break;
        label541:
        afqb.a(this.a, this.a.a().getResources().getDrawable(2130844196));
      }
      label567:
      ((bftc)afqb.c(this.a)).forceRefresh();
      break label296;
      label585:
      afqb.b(this.a).setBackgroundDrawable(localDrawable);
    }
    label599:
    ((bftc)afqb.a(this.a)).setRightButtonType(afqb.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqd
 * JD-Core Version:    0.7.0.1
 */