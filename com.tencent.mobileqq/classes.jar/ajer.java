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

public class ajer
  extends ajff
{
  View.OnTouchListener a;
  protected String a;
  
  ajer()
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ajes(this);
    if (QLog.isColorLevel()) {
      QLog.d("RecentContactsGuideItemBuilder", 0, "RecentContactsGuideItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    paramViewGroup = null;
    paramajfa = paramViewGroup;
    if (paramView != null)
    {
      paramajfa = paramViewGroup;
      if ((paramView.getTag() instanceof ajet)) {
        paramajfa = (ajet)paramView.getTag();
      }
    }
    if (paramajfa == null)
    {
      paramajfa = new ajet();
      paramView = a(paramContext, 2131558905, paramajfa);
      paramajfa.a = ((ThemeImageView)paramView.findViewById(2131364775));
      paramView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramViewGroup = paramajfa.a.getLayoutParams();
      int i = wyg.a(BaseApplicationImpl.getApplication().getResources());
      int j = (int)(i * 0.5D + 0.5D);
      paramViewGroup.width = i;
      paramViewGroup.height = j;
      paramajfa.a.setLayoutParams(paramViewGroup);
      paramajfa.a.setMaskShape(bhxo.b);
      paramView.setTag(paramajfa);
    }
    for (;;)
    {
      if ((paramObject instanceof RecentItemContactsGuideData))
      {
        paramObject = (RecentItemContactsGuideData)paramObject;
        if ((paramObject.mUser != null) && ((paramObject.mUser.extraInfo instanceof atro)))
        {
          paramObject = (atro)paramObject.mUser.extraInfo;
          if (paramObject.a != null)
          {
            paramajfa.a.setImageDrawable(paramObject.a);
            paramObject.a.setURLDrawableListener(null);
          }
          LoginWelcomeManager.a += 1;
        }
      }
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(alpo.a(2131713532));
      }
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajer
 * JD-Core Version:    0.7.0.1
 */