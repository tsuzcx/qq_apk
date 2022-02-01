import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class alhs
  extends BaseAdapter
{
  static LRULinkedHashMap<String, URLDrawable> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(15);
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  String jdField_a_of_type_JavaLangString;
  List<Object> jdField_a_of_type_JavaUtilList;
  public boolean a;
  final int b;
  final int c = 1;
  final int d = 2;
  final int e = 3;
  int f;
  int g;
  int h;
  int i;
  int j = 4;
  int k;
  int l;
  int m;
  int n;
  
  public alhs(Context paramContext, View.OnClickListener paramOnClickListener, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.i = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.g = ((this.jdField_a_of_type_Int - this.i * (this.j + 1)) / this.j);
    this.h = (this.g * 176 / 150);
    this.k = (this.g - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.l = (this.h - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List<bgcu> paramList, List<bgcs> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramList1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
    if (paramList != null)
    {
      this.jdField_a_of_type_Long = paramList.pendantId;
      this.m = paramList.faceId;
    }
    super.notifyDataSetChanged();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    List localList = ajlf.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i1 = 0;
      if (i1 < localList.size())
      {
        Object localObject1 = (ajlg)localList.get(i1);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561837, null);
        Object localObject2 = (ImageView)localView.findViewById(2131363153);
        TextView localTextView1 = (TextView)localView.findViewById(2131365688);
        TextView localTextView2 = (TextView)localView.findViewById(2131365686);
        ImageView localImageView = (ImageView)localView.findViewById(2131378038);
        if (!TextUtils.isEmpty(((ajlg)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((ajlg)localObject1).jdField_a_of_type_JavaLangString));
        }
        localTextView1.setText(((ajlg)localObject1).c);
        localTextView2.setText(((ajlg)localObject1).d);
        switch (((ajlg)localObject1).jdField_b_of_type_Int)
        {
        case 1: 
        case 2: 
        case 3: 
        default: 
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          if (localImageView.getVisibility() == 0)
          {
            localObject2 = localImageView.getDrawable();
            if (localObject2 != null) {
              localImageView.setLayoutParams(new LinearLayout.LayoutParams(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight()));
            }
          }
          localView.setOnClickListener(new alht(this, (ajlg)localObject1, i1));
          localView.addOnLayoutChangeListener(new alhu(this));
          if (i1 != 0) {
            localView.findViewById(2131377691).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, AIOUtils.dp2px(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
          break;
          localImageView.setImageResource(2130846977);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130846978);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838599);
          localImageView.setVisibility(0);
          continue;
          localImageView.setVisibility(8);
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if ((this.jdField_a_of_type_JavaUtilList.get(paramInt - 1) instanceof bgcu)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i2 = 1;
    Object localObject1;
    if ((paramInt >= getCount()) || (paramInt < 0))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    int i1 = getItemViewType(paramInt);
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new alhz(this);
      if (i1 == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561840, paramViewGroup, false);
        localObject2 = paramView.findViewById(2131380101);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).height = this.f;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366127));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380102);
        b();
        paramView.setTag(localObject1);
      }
    }
    label147:
    label1965:
    label1990:
    label2130:
    label2136:
    for (;;)
    {
      ((alhz)localObject1).jdField_a_of_type_Int = paramInt;
      bgcu localbgcu;
      if (i1 == 1)
      {
        localbgcu = (bgcu)getItem(paramInt);
        ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setTag(localbgcu);
        if (localbgcu.c != null)
        {
          if (localbgcu.c.equals("1"))
          {
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847366));
          }
        }
        else
        {
          label231:
          if (localbgcu.jdField_a_of_type_JavaLangString != null)
          {
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localbgcu.jdField_a_of_type_JavaLangString + "(" + localbgcu.jdField_a_of_type_JavaUtilList.size() + ")");
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localbgcu.jdField_a_of_type_JavaLangString);
          }
          ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbgcu.jdField_b_of_type_Int));
          switch (localbgcu.jdField_b_of_type_Int)
          {
          default: 
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label378:
            if ((localbgcu.e != null) && (localbgcu.e.equals("actLiTpl")))
            {
              if (localbgcu.jdField_a_of_type_JavaLangString == null) {
                break label2130;
              }
              ((alhz)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(localbgcu.jdField_a_of_type_JavaLangString);
              ((alhz)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localbgcu.jdField_a_of_type_JavaLangString);
              ((alhz)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            break;
          }
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (localbgcu.jdField_b_of_type_JavaLangString != null)
        {
          ((alhz)localObject1).d.setText(localbgcu.jdField_b_of_type_JavaLangString);
          ((alhz)localObject1).d.setVisibility(0);
          i1 = i2;
        }
        for (;;)
        {
          if (i1 != 0)
          {
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            ((alhz)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((alhx)((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a(localbgcu);
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localbgcu.jdField_a_of_type_Int));
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbgcu.jdField_a_of_type_Int));
            if ((localbgcu.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localbgcu.e != null) && (!localbgcu.e.equals("")))) {
              break label1990;
            }
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localbgcu.jdField_a_of_type_Boolean) {
              break label1965;
            }
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131694691);
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849689);
            if (paramInt != getCount() - 1) {
              break label2013;
            }
            ((alhz)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          for (;;)
          {
            localObject1 = paramView;
            break;
            if (i1 == 1)
            {
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561839, paramViewGroup, false);
              ((alhz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372346));
              ((alhz)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372350));
              ((alhz)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372352));
              ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372351));
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131372339));
              ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372344));
              ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372343));
              ((alhz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372330));
              ((alhz)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372332));
              ((alhz)localObject1).d = ((TextView)paramView.findViewById(2131372331));
              ((alhz)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365675);
              localObject2 = new alhx(this);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject2);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
              ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
              ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramView.setTag(localObject1);
              break label147;
            }
            if (i1 != 2) {
              break label2136;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561834, paramViewGroup, false);
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366271));
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366289));
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366291));
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366290));
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131374634));
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366269));
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366268));
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366246));
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366248));
            ((alhz)localObject1).d = ((TextView)paramView.findViewById(2131366247));
            ((alhz)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365675);
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new alhv(this));
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131700029) + AvatarPendantManager.jdField_a_of_type_Int + ")");
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
            ((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            break label147;
            localObject1 = (alhz)paramView.getTag();
            break label147;
            if (localbgcu.c.equals("3"))
            {
              ((alhz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              ((alhz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847365));
              break label231;
            }
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label231;
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846978));
            break label378;
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846977));
            break label378;
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847367));
            break label378;
            File localFile = new File(bfua.c + "/free.png");
            if (localFile.exists())
            {
              ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_free.png");
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject3;
                if (((URLDrawable)localObject3).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_free.png", localObject3);
                  localObject2 = localObject3;
                }
              }
              ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            localFile = new File(bfua.c + "/rare.png");
            if (localFile.exists())
            {
              ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject3;
                if (((URLDrawable)localObject3).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject3);
                  localObject2 = localObject3;
                }
              }
              ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847373));
            break label378;
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847372));
            break label378;
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((alhz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131716363);
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849692);
            break label645;
            ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            break label645;
            label2013:
            ((alhz)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            continue;
            if (i1 == 2)
            {
              localObject2 = (List)getItem(paramInt);
              ((alhv)((alhz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a((List)localObject2);
              if (((List)localObject2).size() == 8)
              {
                ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131700016));
              }
              else
              {
                ((alhz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                ((alhz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhs
 * JD-Core Version:    0.7.0.1
 */