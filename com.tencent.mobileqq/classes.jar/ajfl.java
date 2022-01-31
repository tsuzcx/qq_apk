import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;

public class ajfl
  extends ajff
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ajfm(this);
  protected String a;
  private WeakReference<akfe> jdField_a_of_type_JavaLangRefWeakReference;
  
  ajfl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentMayKnowFriendItemBuilder", 0, "RecentMayKnowFriendItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    paramOnLongClickListener = null;
    paramViewGroup = paramOnLongClickListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnLongClickListener;
      if ((paramView.getTag() instanceof ajfn)) {
        paramViewGroup = (ajfn)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = (RecentItemMayKnowFriendData)paramObject;
      paramView = new ajfn();
      paramView.jdField_a_of_type_JavaLangString = paramViewGroup.curUin;
      paramViewGroup = a(paramContext, 2131558907, paramView);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131375426));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramViewGroup.findViewById(2131370105));
      paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(aekt.a(9.0F, paramContext.getResources()));
      paramOnLongClickListener = new akfe((Activity)paramContext, paramajfa.a(), paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView, null, 25, 0);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramajgx = (akfe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramajgx != null) {
          paramajgx.d();
        }
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnLongClickListener);
      paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramOnLongClickListener);
      paramViewGroup.setTag(paramView);
      paramOnLongClickListener = paramView;
      paramView = paramViewGroup;
      this.jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
      if (AppSetting.c) {
        paramView.setContentDescription(null);
      }
      if ((paramOnLongClickListener == null) || (!(paramObject instanceof RecentBaseData))) {
        break label379;
      }
      a(paramView, (RecentBaseData)paramObject, paramContext, paramajfa.a());
    }
    for (;;)
    {
      a(paramContext, paramView, paramInt, paramObject, paramOnLongClickListener, paramOnClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      paramOnLongClickListener.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      if ((!TextUtils.equals(this.jdField_a_of_type_JavaLangString, ThemeUtil.curThemeId)) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        paramOnLongClickListener = (akfe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramOnLongClickListener != null) {
          paramOnLongClickListener.notifyDataSetChanged();
        }
      }
      paramOnLongClickListener = paramViewGroup;
      break;
      label379:
      if (paramOnLongClickListener == null) {}
    }
  }
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("destroy : ");
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("RecentMayKnowFriendItemBuilder", 0, bool);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        localObject = (akfe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((akfe)localObject).d();
        }
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
      return;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof ajfn)) {}
    for (paramView = (ajfn)localObject;; paramView = null)
    {
      if (paramView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView|holder is null, tag = " + localObject);
        return;
      }
      if (!(paramRecentBaseData instanceof RecentItemMayKnowFriendData)) {
        break;
      }
      paramRecentBaseData = (RecentItemMayKnowFriendData)paramRecentBaseData;
      if (QLog.isColorLevel()) {
        QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView");
      }
      if ((TextUtils.isEmpty(paramRecentBaseData.curUin)) || (paramRecentBaseData.curUin.equals(paramView.jdField_a_of_type_JavaLangString))) {
        break;
      }
      paramContext = new akfe((Activity)paramContext, paramQQAppInterface, paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView, null, 25, 0);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramQQAppInterface = (akfe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramQQAppInterface != null) {
          paramQQAppInterface.d();
        }
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
      paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramContext);
      paramView.jdField_a_of_type_JavaLangString = paramRecentBaseData.curUin;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("RecentMayKnowFriendItemBuilder", 0, "updateView1");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfl
 * JD-Core Version:    0.7.0.1
 */