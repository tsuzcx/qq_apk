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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ailh
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
  bfpc jdField_a_of_type_Bfpc;
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
  
  public ailh(Context paramContext, View.OnClickListener paramOnClickListener, bfpc parambfpc, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Bfpc = parambfpc;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.i = bawz.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.g = ((this.jdField_a_of_type_Int - this.i * (this.j + 1)) / this.j);
    this.h = (this.g * 176 / 150);
    this.k = (this.g - bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.l = (this.h - bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List<bbnp> paramList, List<bbnn> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramList1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
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
    List localList = agij.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i1 = 0;
      if (i1 < localList.size())
      {
        Object localObject1 = (agik)localList.get(i1);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561476, null);
        Object localObject2 = (ImageView)localView.findViewById(2131362967);
        TextView localTextView1 = (TextView)localView.findViewById(2131365289);
        TextView localTextView2 = (TextView)localView.findViewById(2131365287);
        ImageView localImageView = (ImageView)localView.findViewById(2131376734);
        if (!TextUtils.isEmpty(((agik)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((agik)localObject1).jdField_a_of_type_JavaLangString));
        }
        localTextView1.setText(((agik)localObject1).c);
        localTextView2.setText(((agik)localObject1).d);
        switch (((agik)localObject1).jdField_b_of_type_Int)
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
          localView.setOnClickListener(new aili(this, (agik)localObject1, i1));
          localView.addOnLayoutChangeListener(new ailj(this));
          if (i1 != 0) {
            localView.findViewById(2131376407).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, actn.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
          break;
          localImageView.setImageResource(2130846152);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130846153);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838394);
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
    if ((this.jdField_a_of_type_JavaUtilList.get(paramInt - 1) instanceof bbnp)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i2 = 1;
    Object localObject1 = paramView;
    if (paramInt < getCount())
    {
      if (paramInt < 0) {
        localObject1 = paramView;
      }
    }
    else {
      return localObject1;
    }
    int i1 = getItemViewType(paramInt);
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new ailo(this);
      if (i1 == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561479, paramViewGroup, false);
        paramViewGroup = paramView.findViewById(2131378585);
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.f;
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365720));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378586);
        b();
        paramView.setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      bbnp localbbnp;
      if (i1 == 1)
      {
        localbbnp = (bbnp)getItem(paramInt);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.setTag(localbbnp);
        if (localbbnp.c != null)
        {
          if (localbbnp.c.equals("1"))
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846523));
          }
        }
        else
        {
          label216:
          if (localbbnp.jdField_a_of_type_JavaLangString != null)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbbnp.jdField_a_of_type_JavaLangString + "(" + localbbnp.jdField_a_of_type_JavaUtilList.size() + ")");
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localbbnp.jdField_a_of_type_JavaLangString);
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbbnp.jdField_b_of_type_Int));
          switch (localbbnp.jdField_b_of_type_Int)
          {
          default: 
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label357:
            if ((localbbnp.e != null) && (localbbnp.e.equals("actLiTpl")))
            {
              if (localbbnp.jdField_a_of_type_JavaLangString == null) {
                break label2058;
              }
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localbbnp.jdField_a_of_type_JavaLangString);
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localbbnp.jdField_a_of_type_JavaLangString);
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            break;
          }
        }
      }
      label1927:
      label2058:
      for (i1 = 1;; i1 = 0)
      {
        if (localbbnp.jdField_b_of_type_JavaLangString != null)
        {
          paramViewGroup.d.setText(localbbnp.jdField_b_of_type_JavaLangString);
          paramViewGroup.d.setVisibility(0);
          i1 = i2;
        }
        for (;;)
        {
          if (i1 != 0)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            label484:
            ((ailm)paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.a()).a(localbbnp);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localbbnp.jdField_a_of_type_Int));
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbbnp.jdField_a_of_type_Int));
            if ((localbbnp.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localbbnp.e != null) && (!localbbnp.e.equals("")))) {
              break label1927;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localbbnp.jdField_a_of_type_Boolean) {
              break label1904;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131695459);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130848700);
          }
          for (;;)
          {
            if (paramInt != getCount() - 1) {
              break label1948;
            }
            paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
            return paramView;
            if (i1 == 1)
            {
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561478, paramViewGroup, false);
              ((ailo)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371357));
              ((ailo)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371361));
              ((ailo)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371363));
              ((ailo)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371362));
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131371350));
              ((ailo)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371355));
              ((ailo)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371354));
              ((ailo)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371341));
              ((ailo)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371343));
              ((ailo)localObject1).d = ((TextView)paramView.findViewById(2131371342));
              ((ailo)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365276);
              paramViewGroup = new ailm(this);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(paramViewGroup);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bfpc);
              ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
              ((ailo)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ailo)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramView.setTag(localObject1);
              paramViewGroup = (ViewGroup)localObject1;
              break;
            }
            if (i1 != 2) {
              break label2064;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561473, paramViewGroup, false);
            ((ailo)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365856));
            ((ailo)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365874));
            ((ailo)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365876));
            ((ailo)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365875));
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131373505));
            ((ailo)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365854));
            ((ailo)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365853));
            ((ailo)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365829));
            ((ailo)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365831));
            ((ailo)localObject1).d = ((TextView)paramView.findViewById(2131365830));
            ((ailo)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365276);
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new ailk(this));
            ((ailo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131700870) + AvatarPendantManager.jdField_a_of_type_Int + ")");
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bfpc);
            ((ailo)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((ailo)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((ailo)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            paramViewGroup = (ViewGroup)localObject1;
            break;
            paramViewGroup = (ailo)paramView.getTag();
            break;
            if (localbbnp.c.equals("3"))
            {
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846522));
              break label216;
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label216;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846153));
            break label357;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846152));
            break label357;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846524));
            break label357;
            File localFile = new File(bbby.c + "/free.png");
            if (localFile.exists())
            {
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject2 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_free.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_free.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              break label357;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label357;
            localFile = new File(bbby.c + "/rare.png");
            if (localFile.exists())
            {
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject2 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              break label357;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label357;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846530));
            break label357;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846529));
            break label357;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label484;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label484;
            label1904:
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131717412);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130848703);
            continue;
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          label1948:
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          return paramView;
          localObject1 = paramView;
          if (i1 != 2) {
            break;
          }
          localObject1 = (List)getItem(paramInt);
          ((ailk)paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.a()).a((List)localObject1);
          if (((List)localObject1).size() == 8)
          {
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(ajyc.a(2131700857));
            return paramView;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          return paramView;
        }
      }
      label2064:
      paramViewGroup = (ViewGroup)localObject1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailh
 * JD-Core Version:    0.7.0.1
 */