import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class akjr
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private atlg jdField_a_of_type_Atlg;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString = "";
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet(30);
  private List<aozs> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  public akjr(Context paramContext, List<aozs> paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844927);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Atlg != null)
    {
      atkx localatkx = new atkx();
      localatkx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localatkx.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidContentContext;
      localatkx.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = paramRedTouch;
      localatkx.jdField_a_of_type_Long = paramLong;
      localatkx.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Atlg.a(localatkx);
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_").append(paramInt1);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_").append(paramInt2);
      return;
    }
    if ((this.jdField_a_of_type_Atlg != null) && (this.jdField_a_of_type_Atlg.a() != null))
    {
      paramLong = (atlj)this.jdField_a_of_type_Atlg.a().get(paramLong);
      if (paramLong == null) {}
    }
    for (paramLong = Integer.valueOf(paramLong.jdField_a_of_type_Int);; paramLong = null)
    {
      paramStringBuilder = paramStringBuilder.append("_");
      if (paramLong == null) {}
      for (paramInt1 = 0;; paramInt1 = paramLong.intValue())
      {
        paramStringBuilder.append(paramInt1);
        return;
      }
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, Map<Long, Integer> paramMap)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_").append(0);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_").append(0);
      return;
    }
    Integer localInteger = null;
    if (paramMap != null) {
      localInteger = (Integer)paramMap.get(paramLong);
    }
    paramLong = paramStringBuilder.append("_");
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      paramLong.append(i);
      return;
    }
  }
  
  public Map<Long, Integer> a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      aozs localaozs = (aozs)localIterator.next();
      if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (a(localaozs))) {
        break label114;
      }
      localHashMap.put(Long.valueOf(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), Integer.valueOf(i));
      i += 1;
    }
    label114:
    for (;;)
    {
      break;
      return localHashMap;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((View)localObject).getTag(-1) != null) && ((((View)localObject).getTag(-1) instanceof Integer)))
          {
            if (((Integer)((View)localObject).getTag(-1)).intValue() == 0)
            {
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
              }
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10004L))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10004L));
              }
            }
            else
            {
              int j = ((Integer)((View)localObject).getTag(-1)).intValue();
              if ((j == this.jdField_a_of_type_JavaUtilList.size() - 1) && (j >= 0)) {
                localObject = (aozs)this.jdField_a_of_type_JavaUtilList.get(j);
              }
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof akjs)))
          {
            localObject = (akjs)((View)localObject).getTag();
            if ((localObject != null) && (((akjs)localObject).jdField_a_of_type_Aozs != null) && (((akjs)localObject).jdField_a_of_type_Aozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
            {
              long l = ((akjs)localObject).jdField_a_of_type_Aozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      Map localMap = a();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong.longValue() != 10004L) || (paramBoolean))
        {
          localStringBuilder.append(localLong);
          a(localLong, localStringBuilder, localMap);
          a(localLong, localStringBuilder, paramInt1, paramInt2);
          if (localIterator.hasNext()) {
            localStringBuilder.append(";");
          }
        }
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", "", localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(atlg paramatlg)
  {
    this.jdField_a_of_type_Atlg = paramatlg;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List<aozs> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(aozs paramaozs)
  {
    return !TextUtils.isEmpty(paramaozs.jdField_a_of_type_JavaLangString);
  }
  
  public void b()
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return null;
    }
    return (aozs)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    if (TextUtils.isEmpty(((aozs)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (getItem(paramInt) == null)
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    aozs localaozs = (aozs)getItem(paramInt);
    int j = getItemViewType(paramInt);
    label155:
    Object localObject;
    if (j == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.b, null);
        paramViewGroup = new akjs(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369333));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369395));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131369394));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bibv.c);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362824));
        paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).c(36).a();
        paramView.setTag(paramViewGroup);
        if ((localaozs != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166910));
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          break label628;
        }
        if (TextUtils.isEmpty(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL)) {
          break label614;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aepi.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
        label334:
        paramViewGroup.jdField_a_of_type_Aozs = localaozs;
        if ((localaozs != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
        {
          a((RedTouch)paramView, localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
          if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))) {
            this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
          }
        }
        if ((AppSetting.c) && (localaozs != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (!TextUtils.isEmpty(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName))) {
          bczz.a(paramView, localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, Button.class.getName());
        }
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localaozs != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 770L) && (paramViewGroup != null)) {
        paramViewGroup.e();
      }
      paramViewGroup = paramView;
      if (paramInt != 0) {
        break;
      }
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
      }
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10004L))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10004L));
      return paramView;
      paramViewGroup = (akjs)paramView.getTag();
      break label155;
      label614:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label334;
      label628:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label334;
      if (j == 1)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.c, null);
        }
        boolean bool = azmk.b();
        ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        localObject = paramViewGroup.findViewById(2131364771);
        paramView = paramViewGroup;
        if (localObject != null)
        {
          j = aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramView = ((View)localObject).getLayoutParams();
          if (bool) {}
          for (;;)
          {
            paramView.height = i;
            paramView = paramViewGroup;
            break;
            i = j;
          }
        }
      }
      else
      {
        paramView = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!a((aozs)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjr
 * JD-Core Version:    0.7.0.1
 */