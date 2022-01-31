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

public class ahnk
  extends ahny
{
  View.OnTouchListener a;
  protected String a;
  
  ahnk()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ahnl(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    paramViewGroup = null;
    paramahnt = paramViewGroup;
    if (paramView != null)
    {
      paramahnt = paramViewGroup;
      if ((paramView.getTag() instanceof ahnm)) {
        paramahnt = (ahnm)paramView.getTag();
      }
    }
    if (paramahnt == null)
    {
      paramahnt = new ahnm();
      paramView = a(paramContext, 2131558868, paramahnt);
      paramahnt.a = ((ThemeImageView)paramView.findViewById(2131364697));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramahnt.a.getLayoutParams();
      int i = vjr.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramahnt.a.setLayoutParams(paramViewGroup);
      paramahnt.a.setMaskShape(bfwa.b);
      paramView.setTag(paramahnt);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof asam)))
        {
          paramObject = (asam)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramahnt.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.d) {
        paramView.setContentDescription(ajyc.a(2131713149));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnk
 * JD-Core Version:    0.7.0.1
 */