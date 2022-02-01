import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ThemeImageView;

public class algp
  extends alhd
{
  View.OnTouchListener a;
  protected String a;
  
  algp()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new algq(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    paramViewGroup = null;
    paramalgy = paramViewGroup;
    if (paramView != null)
    {
      paramalgy = paramViewGroup;
      if ((paramView.getTag() instanceof algr)) {
        paramalgy = (algr)paramView.getTag();
      }
    }
    if (paramalgy == null)
    {
      paramalgy = new algr();
      paramView = a(paramContext, 2131559004, paramalgy);
      paramalgy.a = ((ThemeImageView)paramView.findViewById(2131365162));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramalgy.a.getLayoutParams();
      int i = ypx.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramalgy.a.setLayoutParams(paramViewGroup);
      paramalgy.a.setMaskShape(blfw.b);
      paramView.setTag(paramalgy);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof awpi)))
        {
          paramObject = (awpi)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramalgy.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(anvx.a(2131712611));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algp
 * JD-Core Version:    0.7.0.1
 */