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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;

public class alhj
  extends alhd
{
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new alhk(this);
  protected String a;
  private WeakReference<amia> jdField_a_of_type_JavaLangRefWeakReference;
  
  alhj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentMayKnowFriendItemBuilder", 0, "RecentMayKnowFriendItemBuilder constructed");
    }
  }
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    paramOnLongClickListener = null;
    paramViewGroup = paramOnLongClickListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnLongClickListener;
      if ((paramView.getTag() instanceof alhl)) {
        paramViewGroup = (alhl)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = (RecentItemMayKnowFriendData)paramObject;
      paramView = new alhl();
      paramView.jdField_a_of_type_JavaLangString = paramViewGroup.curUin;
      paramViewGroup = a(paramContext, 2131559006, paramView);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131376355));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramViewGroup.findViewById(2131370820));
      paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(AIOUtils.dp2px(9.0F, paramContext.getResources()));
      paramOnLongClickListener = new amia((Activity)paramContext, paramalgy.a(), paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView, null, 25, 0);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramalje = (amia)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramalje != null) {
          paramalje.d();
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
      a(paramView, (RecentBaseData)paramObject, paramContext, paramalgy.a());
    }
    for (;;)
    {
      a(paramContext, paramView, paramInt, paramObject, paramOnLongClickListener, paramOnClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      paramOnLongClickListener.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      if ((!TextUtils.equals(this.jdField_a_of_type_JavaLangString, ThemeUtil.curThemeId)) && (this.jdField_a_of_type_JavaLangRefWeakReference != null))
      {
        paramOnLongClickListener = (amia)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
        localObject = (amia)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null) {
          ((amia)localObject).d();
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
    if ((localObject instanceof alhl)) {}
    for (paramView = (alhl)localObject;; paramView = null)
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
      paramContext = new amia((Activity)paramContext, paramQQAppInterface, paramView.jdField_a_of_type_ComTencentWidgetHorizontalListView, null, 25, 0);
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        paramQQAppInterface = (amia)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhj
 * JD-Core Version:    0.7.0.1
 */