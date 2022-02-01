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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ambe
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
  bkij jdField_a_of_type_Bkij;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
  
  public ambe(Context paramContext, View.OnClickListener paramOnClickListener, bkij parambkij, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Bkij = parambkij;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.i = bggq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.g = ((this.jdField_a_of_type_Int - this.i * (this.j + 1)) / this.j);
    this.h = (this.g * 176 / 150);
    this.k = (this.g - bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.l = (this.h - bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List<bgwg> paramList, List<bgwe> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramList1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
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
    List localList = akbv.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i1 = 0;
      if (i1 < localList.size())
      {
        Object localObject1 = (akbw)localList.get(i1);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561920, null);
        Object localObject2 = (ImageView)localView.findViewById(2131363116);
        TextView localTextView1 = (TextView)localView.findViewById(2131365612);
        TextView localTextView2 = (TextView)localView.findViewById(2131365610);
        ImageView localImageView = (ImageView)localView.findViewById(2131378112);
        if (!TextUtils.isEmpty(((akbw)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((akbw)localObject1).jdField_a_of_type_JavaLangString));
        }
        localTextView1.setText(((akbw)localObject1).c);
        localTextView2.setText(((akbw)localObject1).d);
        switch (((akbw)localObject1).jdField_b_of_type_Int)
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
          localView.setOnClickListener(new ambf(this, (akbw)localObject1, i1));
          localView.addOnLayoutChangeListener(new ambg(this));
          if (i1 != 0) {
            localView.findViewById(2131377774).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, afur.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
          break;
          localImageView.setImageResource(2130847052);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130847053);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838561);
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
    if ((this.jdField_a_of_type_JavaUtilList.get(paramInt - 1) instanceof bgwg)) {
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
      localObject1 = new ambl(this);
      if (i1 == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561923, paramViewGroup, false);
        localObject2 = paramView.findViewById(2131380190);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).height = this.f;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366052));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380191);
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
      ((ambl)localObject1).jdField_a_of_type_Int = paramInt;
      bgwg localbgwg;
      if (i1 == 1)
      {
        localbgwg = (bgwg)getItem(paramInt);
        ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setTag(localbgwg);
        if (localbgwg.c != null)
        {
          if (localbgwg.c.equals("1"))
          {
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847440));
          }
        }
        else
        {
          label231:
          if (localbgwg.jdField_a_of_type_JavaLangString != null)
          {
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localbgwg.jdField_a_of_type_JavaLangString + "(" + localbgwg.jdField_a_of_type_JavaUtilList.size() + ")");
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localbgwg.jdField_a_of_type_JavaLangString);
          }
          ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbgwg.jdField_b_of_type_Int));
          switch (localbgwg.jdField_b_of_type_Int)
          {
          default: 
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label378:
            if ((localbgwg.e != null) && (localbgwg.e.equals("actLiTpl")))
            {
              if (localbgwg.jdField_a_of_type_JavaLangString == null) {
                break label2130;
              }
              ((ambl)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(localbgwg.jdField_a_of_type_JavaLangString);
              ((ambl)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localbgwg.jdField_a_of_type_JavaLangString);
              ((ambl)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            break;
          }
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (localbgwg.jdField_b_of_type_JavaLangString != null)
        {
          ((ambl)localObject1).d.setText(localbgwg.jdField_b_of_type_JavaLangString);
          ((ambl)localObject1).d.setVisibility(0);
          i1 = i2;
        }
        for (;;)
        {
          if (i1 != 0)
          {
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            ((ambl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((ambj)((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.a()).a(localbgwg);
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localbgwg.jdField_a_of_type_Int));
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbgwg.jdField_a_of_type_Int));
            if ((localbgwg.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localbgwg.e != null) && (!localbgwg.e.equals("")))) {
              break label1990;
            }
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localbgwg.jdField_a_of_type_Boolean) {
              break label1965;
            }
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131694533);
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849761);
            if (paramInt != getCount() - 1) {
              break label2013;
            }
            ((ambl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          for (;;)
          {
            localObject1 = paramView;
            break;
            if (i1 == 1)
            {
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561922, paramViewGroup, false);
              ((ambl)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372267));
              ((ambl)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372271));
              ((ambl)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372273));
              ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372272));
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131372260));
              ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372265));
              ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372264));
              ((ambl)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372251));
              ((ambl)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372253));
              ((ambl)localObject1).d = ((TextView)paramView.findViewById(2131372252));
              ((ambl)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365599);
              localObject2 = new ambj(this);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject2);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bkij);
              ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
              ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramView.setTag(localObject1);
              break label147;
            }
            if (i1 != 2) {
              break label2136;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561917, paramViewGroup, false);
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366195));
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366213));
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366215));
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366214));
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131374732));
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366193));
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366192));
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366169));
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366171));
            ((ambl)localObject1).d = ((TextView)paramView.findViewById(2131366170));
            ((ambl)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365599);
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new ambh(this));
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131699687) + AvatarPendantManager.jdField_a_of_type_Int + ")");
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bkij);
            ((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            break label147;
            localObject1 = (ambl)paramView.getTag();
            break label147;
            if (localbgwg.c.equals("3"))
            {
              ((ambl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              ((ambl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847439));
              break label231;
            }
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label231;
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847053));
            break label378;
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847052));
            break label378;
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847441));
            break label378;
            File localFile = new File(bgks.c + "/free.png");
            if (localFile.exists())
            {
              ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
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
              ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            localFile = new File(bgks.c + "/rare.png");
            if (localFile.exists())
            {
              ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
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
              ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847447));
            break label378;
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847446));
            break label378;
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((ambl)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131716020);
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849764);
            break label645;
            ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            break label645;
            label2013:
            ((ambl)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            continue;
            if (i1 == 2)
            {
              localObject2 = (List)getItem(paramInt);
              ((ambh)((ambl)localObject1).jdField_a_of_type_ComTencentWidgetGridView.a()).a((List)localObject2);
              if (((List)localObject2).size() == 8)
              {
                ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131699674));
              }
              else
              {
                ((ambl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                ((ambl)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
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
 * Qualified Name:     ambe
 * JD-Core Version:    0.7.0.1
 */