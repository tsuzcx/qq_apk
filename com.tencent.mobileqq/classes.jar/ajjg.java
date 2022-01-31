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

public class ajjg
  extends ajju
{
  View.OnTouchListener a;
  protected String a;
  
  ajjg()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ajjh(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    paramViewGroup = null;
    paramajjp = paramViewGroup;
    if (paramView != null)
    {
      paramajjp = paramViewGroup;
      if ((paramView.getTag() instanceof ajji)) {
        paramajjp = (ajji)paramView.getTag();
      }
    }
    if (paramajjp == null)
    {
      paramajjp = new ajji();
      paramView = a(paramContext, 2131558904, paramajjp);
      paramajjp.a = ((ThemeImageView)paramView.findViewById(2131364776));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramajjp.a.getLayoutParams();
      int i = xcp.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramajjp.a.setLayoutParams(paramViewGroup);
      paramajjp.a.setMaskShape(bibv.b);
      paramView.setTag(paramajjp);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof atvx)))
        {
          paramObject = (atvx)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramajjp.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(alud.a(2131713544));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjg
 * JD-Core Version:    0.7.0.1
 */