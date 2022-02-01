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

public class akkx
  extends akll
{
  View.OnTouchListener a;
  protected String a;
  
  akkx()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new akky(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, aklg paramaklg, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, aknm paramaknm)
  {
    paramViewGroup = null;
    paramaklg = paramViewGroup;
    if (paramView != null)
    {
      paramaklg = paramViewGroup;
      if ((paramView.getTag() instanceof akkz)) {
        paramaklg = (akkz)paramView.getTag();
      }
    }
    if (paramaklg == null)
    {
      paramaklg = new akkz();
      paramView = a(paramContext, 2131558977, paramaklg);
      paramaklg.a = ((ThemeImageView)paramView.findViewById(2131365078));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramaklg.a.getLayoutParams();
      int i = ybe.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramaklg.a.setLayoutParams(paramViewGroup);
      paramaklg.a.setMaskShape(bjuk.b);
      paramView.setTag(paramaklg);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof avjf)))
        {
          paramObject = (avjf)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramaklg.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(amtj.a(2131712264));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkx
 * JD-Core Version:    0.7.0.1
 */