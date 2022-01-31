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

public class ainr
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private arqd jdField_a_of_type_Arqd;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString = "";
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet(30);
  private List<anec> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  
  public ainr(Context paramContext, List<anec> paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844491);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Arqd != null)
    {
      arpu localarpu = new arpu();
      localarpu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localarpu.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidContentContext;
      localarpu.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = paramRedTouch;
      localarpu.jdField_a_of_type_Long = paramLong;
      localarpu.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Arqd.a(localarpu);
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_").append(paramInt);
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Arqd != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Arqd.a() != null) {
        localObject1 = (Integer)this.jdField_a_of_type_Arqd.a().get(paramLong);
      }
    }
    paramLong = paramStringBuilder.append("_");
    if (localObject1 == null) {}
    for (paramInt = 0;; paramInt = ((Integer)localObject1).intValue())
    {
      paramLong.append(paramInt);
      return;
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
      anec localanec = (anec)localIterator.next();
      if ((localanec == null) || (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (a(localanec))) {
        break label114;
      }
      localHashMap.put(Long.valueOf(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), Integer.valueOf(i));
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
            }
            else
            {
              int j = ((Integer)((View)localObject).getTag(-1)).intValue();
              if ((j == this.jdField_a_of_type_JavaUtilList.size() - 1) && (j >= 0)) {
                localObject = (anec)this.jdField_a_of_type_JavaUtilList.get(j);
              }
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof ains)))
          {
            localObject = (ains)((View)localObject).getTag();
            if ((localObject != null) && (((ains)localObject).jdField_a_of_type_Anec != null) && (((ains)localObject).jdField_a_of_type_Anec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
            {
              long l = ((ains)localObject).jdField_a_of_type_Anec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
              }
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      Map localMap = a();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        localStringBuilder.append(localLong);
        a(localLong, localStringBuilder, localMap);
        a(localLong, localStringBuilder, paramInt);
        if (localIterator.hasNext()) {
          localStringBuilder.append(";");
        }
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", "", localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(arqd paramarqd)
  {
    this.jdField_a_of_type_Arqd = paramarqd;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List<anec> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(anec paramanec)
  {
    return !TextUtils.isEmpty(paramanec.jdField_a_of_type_JavaLangString);
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
    return (anec)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    if (TextUtils.isEmpty(((anec)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) {
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
    anec localanec = (anec)getItem(paramInt);
    int j = getItemViewType(paramInt);
    label155:
    Object localObject;
    if (j == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.b, null);
        paramViewGroup = new ains(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369083));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369145));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131369144));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bfwr.c);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362792));
        paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).c(36).a();
        paramView.setTag(paramViewGroup);
        if ((localanec != null) && (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166861));
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if ((localanec == null) || (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (TextUtils.isEmpty(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
          break label612;
        }
        if (TextUtils.isEmpty(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL)) {
          break label598;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = actj.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
        label348:
        paramViewGroup.jdField_a_of_type_Anec = localanec;
        if ((localanec != null) && (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
        {
          a((RedTouch)paramView, localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
          if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))) {
            this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
          }
        }
        if ((AppSetting.d) && (localanec != null) && (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (!TextUtils.isEmpty(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName))) {
          baww.a(paramView, localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, Button.class.getName());
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
      if ((localanec != null) && (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 770L) && (paramViewGroup != null)) {
        paramViewGroup.d();
      }
      paramViewGroup = paramView;
      if (paramInt != 0) {
        break;
      }
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
      return paramView;
      paramViewGroup = (ains)paramView.getTag();
      break label155;
      label598:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label348;
      label612:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label348;
      if (j == 1)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.c, null);
        }
        boolean bool = axmv.b();
        ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        localObject = paramViewGroup.findViewById(2131364691);
        paramView = paramViewGroup;
        if (localObject != null)
        {
          j = actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
    if (!a((anec)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ainr
 * JD-Core Version:    0.7.0.1
 */