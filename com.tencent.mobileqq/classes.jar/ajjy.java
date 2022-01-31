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

public class ajjy
  extends ajju
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
  
  public View a(int paramInt, Object paramObject, ajjp paramajjp, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajlm paramajlm)
  {
    paramajlm = null;
    paramViewGroup = paramajlm;
    if (paramView != null)
    {
      paramViewGroup = paramajlm;
      if ((paramView.getTag() instanceof ajjz)) {
        paramViewGroup = (ajjz)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new ajjz();
      paramView = a(paramContext, 2131562551, paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131367819));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379331));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369602));
      paramViewGroup.jdField_b_of_type_ComTencentWidgetURLThemeImageView = ((URLThemeImageView)paramView.findViewById(2131369600));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131369133));
      paramViewGroup.d = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377608);
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Ajit != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ajit.a());
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
        paramajlm = null;
        if (paramajjp != null) {
          paramajlm = paramajjp.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramajlm);
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
  
  protected void a(ajjz paramajjz, Context paramContext)
  {
    try
    {
      localObject = paramajjz.c;
      localView = paramajjz.jdField_a_of_type_AndroidViewView;
      paramajjz = paramajjz.jdField_a_of_type_AndroidWidgetTextView;
      if (((TextView)localObject).getVisibility() != 0)
      {
        i = azkz.a(12.0F);
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        paramajjz.setMaxWidth(this.b - this.c - azkz.a(113.0F));
        return;
      }
      paramajjz = ajlh.a().a("000000", 1225168973512L);
      if (!TextUtils.isEmpty(paramajjz)) {
        break label314;
      }
      paramajjz = ajlh.a().a();
    }
    catch (Exception paramajjz)
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
        QLog.i("RecentLiveTipItemBuilder", 4, paramajjz.toString());
        return;
        jdField_a_of_type_Int = i;
        continue;
        jdField_a_of_type_Int = (int)(paramContext.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
    }
    if ((!TextUtils.isEmpty(paramajjz)) && (paramajjz.length() != "yyyy-MM-dd".length()))
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
        j = (int)(paramContext.measureText(paramajjz) + f * 6.0F);
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
    Object localObject = paramView.getTag();
    if ((localObject instanceof ajjz)) {}
    for (paramDrawable = (ajjz)localObject;; paramDrawable = null) {
      for (;;)
      {
        if (paramDrawable == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        if (!(paramRecentBaseData instanceof RecentItemNearbyLiveTipData)) {
          break;
        }
        MessageForNearbyLiveTip localMessageForNearbyLiveTip = ((RecentItemNearbyLiveTipData)paramRecentBaseData).nearbyLiveTipMsg;
        if (localMessageForNearbyLiveTip == null) {
          break;
        }
        if (abti.h(localMessageForNearbyLiveTip.senderuin))
        {
          if (paramRecentBaseData.b() < 1)
          {
            localObject = "0";
            label131:
            azqs.b(null, "dc00899", "grp_lbs", "", "msg_box", "assist_exp", 0, 0, "", "", "", (String)localObject);
          }
        }
        else
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramDrawable.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getHeight();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramDrawable.jdField_a_of_type_ComTencentWidgetURLThemeImageView.getWidth();
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bdhj.b();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bdhj.b();
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        }
        try
        {
          localObject = URLDrawable.getDrawable(localMessageForNearbyLiveTip.headUrl, (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).setDecodeHandler(bcyz.a);
          paramDrawable.jdField_a_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject);
          paramDrawable.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForNearbyLiveTip.nickName);
          if ((MessageForNearbyLiveTip.isHuayangTip(localMessageForNearbyLiveTip.jumpingUrl)) && (!localMessageForNearbyLiveTip.isLiving))
          {
            if (!TextUtils.isEmpty(localMessageForNearbyLiveTip.c2cMsgWording)) {
              localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.c2cMsgWording;
            }
          }
          else
          {
            paramDrawable.d.setText(localMessageForNearbyLiveTip.msg);
            if (localMessageForNearbyLiveTip.senderuin.equals(String.valueOf(1822701914L + alof.l))) {
              localMessageForNearbyLiveTip.isLiving = false;
            }
            if ((!localMessageForNearbyLiveTip.isLiving) || (MessageForNearbyLiveTip.isGroupVideoTip(localMessageForNearbyLiveTip.jumpingUrl))) {
              break label678;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            int j;
            int i;
            int k;
            try
            {
              localObject = bauz.a("http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
              URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mPlayGifImage = true;
              localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
              paramDrawable.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setImageDrawable((Drawable)localObject);
              paramDrawable.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              paramDrawable.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(0);
              paramDrawable.c.setVisibility(8);
              a(paramDrawable, paramContext);
              m = paramRecentBaseData.mUnreadNum;
              j = 0;
              i = paramRecentBaseData.mUnreadFlag;
              if (m <= 0) {
                break label853;
              }
              if (i != 0) {
                break label722;
              }
              i = 0;
              j = 0;
              m = 0;
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              bhvv.a(paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              paramView = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(localMessageForNearbyLiveTip.senderuin);
              if ((paramView != null) && (paramView.booleanValue())) {
                break;
              }
              this.jdField_a_of_type_JavaUtilMap.put(localMessageForNearbyLiveTip.senderuin, Boolean.valueOf(true));
              paramView = ((FragmentActivity)paramContext).app;
              ThreadManagerV2.excute(new RecentLiveTipItemBuilder.1(this, paramView, localMessageForNearbyLiveTip, (auul)paramView.getManager(106)), 32, null, false);
              return;
              localObject = "1";
              break label131;
              localException = localException;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("Q.nearby.tag_nearby_live_tip", 2, "url=" + localMessageForNearbyLiveTip.headUrl);
              continue;
              localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.liveEndWording;
            }
            catch (MalformedURLException localMalformedURLException)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.nearby.freshNews", 2, "RecentLiveTipItemBuilder getview get nowBoardcastGif error, " + localMalformedURLException);
              continue;
            }
            label678:
            paramDrawable.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramDrawable.jdField_b_of_type_ComTencentWidgetURLThemeImageView.setVisibility(8);
            paramDrawable.c.setVisibility(0);
            paramDrawable.c.setText(paramRecentBaseData.mShowTime);
            continue;
            label722:
            if (i == 2)
            {
              i = 1;
              j = 0;
              m = 0;
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
            }
            else if (i == 3)
            {
              i = 3;
              j = 2130849809;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167026));
              k = 99;
            }
            else
            {
              i = 3;
              j = 2130849805;
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              paramDrawable.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167027));
              k = 99;
              continue;
              label853:
              m = 0;
              i = 0;
              k = 99;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjy
 * JD-Core Version:    0.7.0.1
 */