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

public class ahni
  extends ahnw
{
  View.OnTouchListener a;
  protected String a;
  
  ahni()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ahnj(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, ahnr paramahnr, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpo paramahpo)
  {
    paramViewGroup = null;
    paramahnr = paramViewGroup;
    if (paramView != null)
    {
      paramahnr = paramViewGroup;
      if ((paramView.getTag() instanceof ahnk)) {
        paramahnr = (ahnk)paramView.getTag();
      }
    }
    if (paramahnr == null)
    {
      paramahnr = new ahnk();
      paramView = a(paramContext, 2131558868, paramahnr);
      paramahnr.a = ((ThemeImageView)paramView.findViewById(2131364696));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramahnr.a.getLayoutParams();
      int i = vjo.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramahnr.a.setLayoutParams(paramViewGroup);
      paramahnr.a.setMaskShape(bfwr.b);
      paramView.setTag(paramahnr);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof asao)))
        {
          paramObject = (asao)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramahnr.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.d) {
        paramView.setContentDescription(ajya.a(2131713160));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahni
 * JD-Core Version:    0.7.0.1
 */