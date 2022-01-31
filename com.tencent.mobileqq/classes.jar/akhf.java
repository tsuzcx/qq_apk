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

public class akhf
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
  bhuw jdField_a_of_type_Bhuw;
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
  
  public akhf(Context paramContext, View.OnClickListener paramOnClickListener, bhuw parambhuw, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Bhuw = parambhuw;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.i = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.g = ((this.jdField_a_of_type_Int - this.i * (this.j + 1)) / this.j);
    this.h = (this.g * 176 / 150);
    this.k = (this.g - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.l = (this.h - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List<bdrg> paramList, List<bdre> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramList1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
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
    List localList = ailb.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i1 = 0;
      if (i1 < localList.size())
      {
        Object localObject1 = (ailc)localList.get(i1);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561683, null);
        Object localObject2 = (ImageView)localView.findViewById(2131363002);
        TextView localTextView1 = (TextView)localView.findViewById(2131365375);
        TextView localTextView2 = (TextView)localView.findViewById(2131365373);
        ImageView localImageView = (ImageView)localView.findViewById(2131377301);
        if (!TextUtils.isEmpty(((ailc)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((ailc)localObject1).jdField_a_of_type_JavaLangString));
        }
        localTextView1.setText(((ailc)localObject1).c);
        localTextView2.setText(((ailc)localObject1).d);
        switch (((ailc)localObject1).jdField_b_of_type_Int)
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
          localView.setOnClickListener(new akhg(this, (ailc)localObject1, i1));
          localView.addOnLayoutChangeListener(new akhh(this));
          if (i1 != 0) {
            localView.findViewById(2131376968).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, aepi.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
          break;
          localImageView.setImageResource(2130846610);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130846611);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838455);
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
    if ((this.jdField_a_of_type_JavaUtilList.get(paramInt - 1) instanceof bdrg)) {
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
      localObject1 = new akhm(this);
      if (i1 == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561686, paramViewGroup, false);
        paramViewGroup = paramView.findViewById(2131379263);
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).height = this.f;
        paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365805));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379264);
        b();
        paramView.setTag(localObject1);
        paramViewGroup = (ViewGroup)localObject1;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      bdrg localbdrg;
      if (i1 == 1)
      {
        localbdrg = (bdrg)getItem(paramInt);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.setTag(localbdrg);
        if (localbdrg.c != null)
        {
          if (localbdrg.c.equals("1"))
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846983));
          }
        }
        else
        {
          label216:
          if (localbdrg.jdField_a_of_type_JavaLangString != null)
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbdrg.jdField_a_of_type_JavaLangString + "(" + localbdrg.jdField_a_of_type_JavaUtilList.size() + ")");
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localbdrg.jdField_a_of_type_JavaLangString);
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbdrg.jdField_b_of_type_Int));
          switch (localbdrg.jdField_b_of_type_Int)
          {
          default: 
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label357:
            if ((localbdrg.e != null) && (localbdrg.e.equals("actLiTpl")))
            {
              if (localbdrg.jdField_a_of_type_JavaLangString == null) {
                break label2058;
              }
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(localbdrg.jdField_a_of_type_JavaLangString);
              paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localbdrg.jdField_a_of_type_JavaLangString);
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
        if (localbdrg.jdField_b_of_type_JavaLangString != null)
        {
          paramViewGroup.d.setText(localbdrg.jdField_b_of_type_JavaLangString);
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
            ((akhk)paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.a()).a(localbdrg);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localbdrg.jdField_a_of_type_Int));
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbdrg.jdField_a_of_type_Int));
            if ((localbdrg.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localbdrg.e != null) && (!localbdrg.e.equals("")))) {
              break label1927;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localbdrg.jdField_a_of_type_Boolean) {
              break label1904;
            }
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131695620);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849210);
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
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561685, paramViewGroup, false);
              ((akhm)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371693));
              ((akhm)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371697));
              ((akhm)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371699));
              ((akhm)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371698));
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131371686));
              ((akhm)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371691));
              ((akhm)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371690));
              ((akhm)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371677));
              ((akhm)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371679));
              ((akhm)localObject1).d = ((TextView)paramView.findViewById(2131371678));
              ((akhm)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365362);
              paramViewGroup = new akhk(this);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(paramViewGroup);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bhuw);
              ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
              ((akhm)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((akhm)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramView.setTag(localObject1);
              paramViewGroup = (ViewGroup)localObject1;
              break;
            }
            if (i1 != 2) {
              break label2064;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561680, paramViewGroup, false);
            ((akhm)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365944));
            ((akhm)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365962));
            ((akhm)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365964));
            ((akhm)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365963));
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131374011));
            ((akhm)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365942));
            ((akhm)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365941));
            ((akhm)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365917));
            ((akhm)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365919));
            ((akhm)localObject1).d = ((TextView)paramView.findViewById(2131365918));
            ((akhm)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365362);
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new akhi(this));
            ((akhm)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131701262) + AvatarPendantManager.jdField_a_of_type_Int + ")");
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bhuw);
            ((akhm)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((akhm)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((akhm)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            paramViewGroup = (ViewGroup)localObject1;
            break;
            paramViewGroup = (akhm)paramView.getTag();
            break;
            if (localbdrg.c.equals("3"))
            {
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846982));
              break label216;
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label216;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846611));
            break label357;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846610));
            break label357;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846984));
            break label357;
            File localFile = new File(bdfp.c + "/free.png");
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
            localFile = new File(bdfp.c + "/rare.png");
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
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846990));
            break label357;
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846989));
            break label357;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label484;
            paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label484;
            label1904:
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131717807);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849213);
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
          ((akhi)paramViewGroup.jdField_a_of_type_ComTencentWidgetGridView.a()).a((List)localObject1);
          if (((List)localObject1).size() == 8)
          {
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131701249));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhf
 * JD-Core Version:    0.7.0.1
 */