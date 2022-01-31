import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder.1;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ahbn
  extends ahbj
{
  public static int a;
  private List<String> jdField_a_of_type_JavaUtilList;
  private Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int b;
  private int c;
  
  public int a()
  {
    return 2;
  }
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    paramahdb = null;
    paramViewGroup = paramahdb;
    if (paramView != null)
    {
      paramViewGroup = paramahdb;
      if ((paramView.getTag() instanceof ahbo)) {
        paramViewGroup = (ahbo)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new ahbo();
      paramView = a(paramContext, 2131496729, paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131302061));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131312826));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303677));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131303675));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131303219));
      paramViewGroup.d = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131311222);
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Ahai != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahai.a());
      }
      this.b = paramContext.getResources().getDisplayMetrics().widthPixels;
      this.c = ((int)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getText().toString()));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramView.setContentDescription(null);
      }
      if ((paramObject instanceof RecentBaseData))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramahdb = null;
        if (paramahbe != null) {
          paramahdb = paramahbe.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramahdb);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
        paramViewGroup.d.setText("");
        paramViewGroup.c.setText("");
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  protected void a(ahbo paramahbo, Context paramContext)
  {
    try
    {
      localObject = paramahbo.c;
      localView = paramahbo.jdField_a_of_type_AndroidViewView;
      paramahbo = paramahbo.jdField_a_of_type_AndroidWidgetTextView;
      if (((TextView)localObject).getVisibility() != 0)
      {
        i = awmc.a(12.0F);
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        paramahbo.setMaxWidth(this.b - this.c - awmc.a(113.0F));
        return;
      }
      paramahbo = ahcw.a().a("000000", 1225168973512L);
      if (!TextUtils.isEmpty(paramahbo)) {
        break label314;
      }
      paramahbo = ahcw.a().a();
    }
    catch (Exception paramahbo)
    {
      Object localObject;
      View localView;
      int i;
      float f;
      int j;
      label288:
      label314:
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentLiveTipItemBuilder", 4, paramahbo.toString());
        return;
        jdField_a_of_type_Int = i;
        continue;
        jdField_a_of_type_Int = (int)(paramContext.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
    }
    if ((!TextUtils.isEmpty(paramahbo)) && (paramahbo.length() != "yyyy-MM-dd".length()))
    {
      i = 1;
      if ((jdField_a_of_type_Int <= 0) || (i != 0))
      {
        f = paramContext.getResources().getDisplayMetrics().density;
        localObject = ((TextView)localObject).getPaint();
        paramContext = (Context)localObject;
        if (localObject == null)
        {
          paramContext = new TextPaint();
          paramContext.setTextSize(f * 12.0F);
        }
        if (i == 0) {
          break label288;
        }
        i = (int)(paramContext.measureText("yyyy-MM-dd") + f * 6.0F);
        j = (int)(paramContext.measureText(paramahbo) + f * 6.0F);
        if (j > i) {
          jdField_a_of_type_Int = j;
        }
      }
      else
      {
        i = localView.getPaddingRight();
        if (i >= jdField_a_of_type_Int) {
          return;
        }
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        return;
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof ahbo)) {}
    for (paramDrawable = (ahbo)localObject1;; paramDrawable = null) {
      for (;;)
      {
        if (paramDrawable == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject1);
          return;
        }
        if (!(paramRecentBaseData instanceof RecentItemNearbyLiveTipData)) {
          break;
        }
        localObject1 = ((RecentItemNearbyLiveTipData)paramRecentBaseData).nearbyLiveTipMsg;
        if (localObject1 == null) {
          break;
        }
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramDrawable.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramDrawable.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = bacm.b();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = bacm.b();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        try
        {
          localObject2 = URLDrawable.getDrawable(((MessageForNearbyLiveTip)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setDecodeHandler(azue.a);
          paramDrawable.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject2);
          paramDrawable.jdField_a_of_type_AndroidWidgetTextView.setText(((MessageForNearbyLiveTip)localObject1).nickName);
          if ((MessageForNearbyLiveTip.isHuayangTip(((MessageForNearbyLiveTip)localObject1).jumpingUrl)) && (!((MessageForNearbyLiveTip)localObject1).isLiving))
          {
            if (!TextUtils.isEmpty(((MessageForNearbyLiveTip)localObject1).c2cMsgWording)) {
              ((MessageForNearbyLiveTip)localObject1).msg = ((MessageForNearbyLiveTip)localObject1).c2cMsgWording;
            }
          }
          else
          {
            paramDrawable.d.setText(((MessageForNearbyLiveTip)localObject1).msg);
            if ((!((MessageForNearbyLiveTip)localObject1).isLiving) || (MessageForNearbyLiveTip.isGroupVideoTip(((MessageForNearbyLiveTip)localObject1).jumpingUrl))) {
              break label588;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            int i;
            int k;
            int j;
            try
            {
              localObject2 = axsk.a("http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
              URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mPlayGifImage = true;
              localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
              paramDrawable.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject2);
              paramDrawable.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              paramDrawable.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
              paramDrawable.c.setVisibility(8);
              a(paramDrawable, paramContext);
              m = paramRecentBaseData.mUnreadNum;
              i = paramRecentBaseData.mUnreadFlag;
              if (m <= 0) {
                break label763;
              }
              if (i != 0) {
                break label632;
              }
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              beih.a(paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              paramView = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(((MessageForNearbyLiveTip)localObject1).senderuin);
              if ((paramView != null) && (paramView.booleanValue())) {
                break;
              }
              this.jdField_a_of_type_JavaUtilMap.put(((MessageForNearbyLiveTip)localObject1).senderuin, Boolean.valueOf(true));
              paramView = ((FragmentActivity)paramContext).app;
              ThreadManagerV2.excute(new RecentLiveTipItemBuilder.1(this, paramView, (MessageForNearbyLiveTip)localObject1, (ascz)paramView.getManager(106)), 32, null, false);
              return;
              localException = localException;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("Q.nearby.tag_nearby_live_tip", 2, "url=" + ((MessageForNearbyLiveTip)localObject1).headUrl);
              continue;
              ((MessageForNearbyLiveTip)localObject1).msg = ((MessageForNearbyLiveTip)localObject1).liveEndWording;
            }
            catch (MalformedURLException localMalformedURLException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.nearby.freshNews", 2, "RecentLiveTipItemBuilder getview get nowBoardcastGif error, " + localMalformedURLException);
              continue;
            }
            label588:
            paramDrawable.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramDrawable.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
            paramDrawable.c.setVisibility(0);
            paramDrawable.c.setText(paramRecentBaseData.mShowTime);
            continue;
            label632:
            if (i == 2)
            {
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              m = 0;
              j = 0;
              i = 1;
            }
            else if (i == 3)
            {
              j = 2130849061;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131101378));
              i = 3;
              k = 99;
            }
            else
            {
              j = 2130849057;
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131101379));
              i = 3;
              k = 99;
              continue;
              label763:
              k = 99;
              m = 0;
              j = 0;
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahbn
 * JD-Core Version:    0.7.0.1
 */