import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.1;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class alls
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bidc jdField_a_of_type_Bidc;
  private WeakReference<alln> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public alls(Context paramContext, alln paramalln)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramalln);
    long l = Math.min(bdgk.i(), bdgk.j());
    this.jdField_a_of_type_Int = ((int)((float)l - 30.0F * bdgk.a()) / 3);
    this.b = ((int)(9.0D * (this.jdField_a_of_type_Int / 16.0D)));
    QLog.i("GameListAdapter", 1, "screenWidth:" + l + ",itemWidth:" + this.jdField_a_of_type_Int + ",itemHeight:" + this.b);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(ViewGroup paramViewGroup, allv paramallv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameListAdapter", 2, "[showHighLightGame] ");
    }
    if (paramallv.jdField_a_of_type_AndroidViewView != null)
    {
      paramViewGroup.removeView(paramallv.jdField_a_of_type_AndroidViewView);
      paramallv.jdField_a_of_type_AndroidViewView = null;
    }
    paramViewGroup.setClipChildren(true);
    paramViewGroup.setClipToPadding(true);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131368451);
    ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131368451);
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368451);
    ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131368451);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131362616);
    localRelativeLayout.setBackgroundDrawable(null);
    paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    paramallv.jdField_a_of_type_AndroidViewView = localRelativeLayout;
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130838478);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).postDelayed(new ApolloGameViewBinder.GameListAdapter.2(this, (ImageView)localObject, localRelativeLayout, paramViewGroup, paramallv), 400L);
  }
  
  public void a(List<ApolloGameData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bidc != null) {
      this.jdField_a_of_type_Bidc.dismiss();
    }
  }
  
  public int getCount()
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      i = 0;
    }
    int k;
    int j;
    do
    {
      return i;
      k = this.jdField_a_of_type_JavaUtilList.size();
      j = k / 3;
      i = j;
    } while (k % 3 == 0);
    return j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(3);
    int i = paramInt * 3;
    paramInt = i;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i + 3) {
        break;
      }
      localObject = localArrayList;
      if (paramInt < 0) {
        break;
      }
      localObject = localArrayList;
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558636, paramViewGroup, false);
      paramViewGroup = new allv(null);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[0] = ((ViewGroup)paramView.findViewById(2131368444));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0] = ((URLImageView)paramView.findViewById(2131368445));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131368446));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramView.findViewById(2131368447));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[0] = ((ImageView)paramView.findViewById(2131368448));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[1] = ((ViewGroup)paramView.findViewById(2131368450));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1] = ((URLImageView)paramView.findViewById(2131368451));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131368452));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramView.findViewById(2131368453));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[1] = ((ImageView)paramView.findViewById(2131368454));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[2] = ((ViewGroup)paramView.findViewById(2131368456));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2] = ((URLImageView)paramView.findViewById(2131368457));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131368458));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramView.findViewById(2131368459));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[2] = ((ImageView)paramView.findViewById(2131368460));
      paramView.setTag(paramViewGroup);
      localObject1 = (alln)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 == null) {
        break label1569;
      }
      alln.a((alln)localObject1);
    }
    label396:
    label785:
    label1558:
    label1560:
    label1563:
    label1569:
    for (Object localObject1 = alln.a((alln)localObject1);; localObject1 = null)
    {
      ArrayList localArrayList = (ArrayList)getItem(paramInt);
      int i;
      ApolloGameData localApolloGameData;
      Object localObject3;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        i = 0;
        if (i >= 3) {
          break label1558;
        }
        if (i < localArrayList.size())
        {
          localApolloGameData = (ApolloGameData)localArrayList.get(i);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setVisibility(0);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setTag(localApolloGameData);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setOnClickListener(this);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(localApolloGameData.name);
          if (localObject1 == null) {
            break label1563;
          }
          localObject2 = (SparseArray)((SparseArray)localObject1).get(localApolloGameData.gameId);
          if ((localObject2 == null) || (((SparseArray)localObject2).size() <= 0)) {
            break label1563;
          }
          localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1002);
          localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1001);
          localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1005);
        }
      }
      for (Object localObject2 = (ApolloGameRedDot)((SparseArray)localObject2).get(1000);; localObject2 = null)
      {
        label590:
        int j;
        if (localApolloGameData.isGameApp)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageResource(2130838384);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(0);
          int k = 0;
          j = k;
          if (localObject2 != null)
          {
            j = k;
            if (!((ApolloGameRedDot)localObject2).mIsShow) {
              j = 1;
            }
          }
          if (j == 0) {
            break label1417;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849801);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawablePadding(aepi.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawables((Drawable)localObject2, null, null, null);
          label692:
          if (TextUtils.isEmpty(localApolloGameData.listCoverUrl)) {
            break label1445;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Resources)localObject2).getDrawable(2130838453);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Resources)localObject2).getDrawable(2130838453);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.b;
          localObject2 = URLDrawable.getDrawable(localApolloGameData.listCoverUrl, (URLDrawable.URLDrawableOptions)localObject3);
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setImageDrawable((Drawable)localObject2);
          j = paramInt * 3 + i;
          if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (akts.a("aio.city.game", alln.a((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get())) != aktt.d)) {
            break label1560;
          }
          j -= 1;
        }
        for (;;)
        {
          if ((j < ApolloGameUtil.a()) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localApolloGameData.gameId)) && (paramViewGroup.b[i].getVisibility() != 0))
          {
            localObject2 = paramViewGroup.b[i];
            ((ImageView)localObject2).setVisibility(0);
            localObject3 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject2).a(19).a();
            BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            localRedTypeInfo.red_type.set(4);
            localRedTypeInfo.red_content.set(alud.a(2131700729));
            localRedTypeInfo.red_desc.set("{'cn':'#FF0000', 'av':1}");
            ((RedTouch)localObject3).a(localRedTypeInfo);
            ((ImageView)localObject2).setTag(localObject3);
            if (alln.jdField_a_of_type_Long == 0L) {
              alln.jdField_a_of_type_Long = System.currentTimeMillis();
            }
            if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
              VipUtils.a(alln.a((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "beyond_notice", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
            }
            if (alln.jdField_a_of_type_Boolean)
            {
              alln.jdField_a_of_type_Boolean = false;
              localObject3 = ApolloGameUtil.a();
              if (localObject3 != null) {
                ((SharedPreferences)localObject3).edit().putBoolean("sp.aio.show", false).apply();
              }
              if (QLog.isColorLevel()) {
                QLog.d("GameListAdapter", 2, "show guide window");
              }
              ((ImageView)localObject2).postDelayed(new ApolloGameViewBinder.GameListAdapter.1(this, (ImageView)localObject2), 200L);
            }
            label1143:
            if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (alln.a((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()) != null) && (localApolloGameData.gameId == alln.a((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Int))
            {
              a(paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i], paramViewGroup);
              localObject2 = (aknt)alln.a((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(211);
              ((aknt)localObject2).a(-1, -1);
              ((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(((aknt)localObject2).a());
            }
          }
          for (;;)
          {
            i += 1;
            break label396;
            paramViewGroup = (allv)paramView.getTag();
            break;
            if (!TextUtils.isEmpty(localApolloGameData.tagUrl))
            {
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable(aldt.a(String.valueOf(localApolloGameData.tagUrl.hashCode()), null, localApolloGameData.tagUrl, true));
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(0);
              VipUtils.a(alln.a((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "showtag", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId), String.valueOf(paramInt * 3 + i), String.valueOf(localApolloGameData.tagType) });
              break label590;
            }
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(8);
            break label590;
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawablePadding(0);
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawables(null, null, null, null);
            break label692;
            label1445:
            paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setImageResource(2130838453);
            break label785;
            if ((paramViewGroup.b[i].getTag() != null) && ((paramViewGroup.b[i].getTag() instanceof RedTouch))) {
              ((RedTouch)paramViewGroup.b[i].getTag()).d();
            }
            paramViewGroup.b[i].setVisibility(4);
            break label1143;
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i].setVisibility(4);
          }
          paramInt = 0;
          while (paramInt < 3)
          {
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[paramInt].setVisibility(4);
            paramInt += 1;
          }
          return paramView;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ApolloGameData localApolloGameData = (ApolloGameData)paramView.getTag();
    if (localApolloGameData == null)
    {
      QLog.e("GameListAdapter", 1, "[onClick] no game data");
      return;
    }
    alln localalln = (alln)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localalln != null) {
      if (alln.a(localalln) != null) {
        if (paramView.getId() == 2131368444) {
          paramView = paramView.findViewById(2131368448);
        }
      }
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        paramView.setVisibility(8);
        if ((paramView.getTag() != null) && ((paramView.getTag() instanceof RedTouch))) {
          ((RedTouch)paramView.getTag()).d();
        }
        VipUtils.a(alln.a((alln)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "beyond_notice_disappear", 1, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
      }
      paramView = alln.a(localalln);
      label219:
      Object localObject;
      if ((paramView != null) && (paramView.size() > 0))
      {
        Iterator localIterator = paramView.iterator();
        paramView = null;
        if (localIterator.hasNext())
        {
          localObject = (ApolloGameRankData)localIterator.next();
          if ((localObject == null) || (((ApolloGameRankData)localObject).mGameId != localApolloGameData.gameId)) {
            break label402;
          }
          paramView = (View)localObject;
        }
      }
      label402:
      for (;;)
      {
        break label219;
        if (paramView.getId() == 2131368450)
        {
          paramView = paramView.findViewById(2131368454);
          break;
        }
        if (paramView.getId() != 2131368456) {
          break label405;
        }
        paramView = paramView.findViewById(2131368460);
        break;
        localObject = alln.a(localalln);
        if (paramView != null) {}
        try
        {
          paramView.mValidTime = (System.currentTimeMillis() - 1000L);
          ApolloGameUtil.a(alln.a(localalln), paramView);
          alln.a(localalln).remove(paramView);
          if (QLog.isColorLevel()) {
            QLog.d("GameListAdapter", 2, new Object[] { "[onClick] remove red corner for ", Integer.valueOf(localApolloGameData.gameId) });
          }
          alln.c(localalln, localApolloGameData);
          return;
        }
        finally {}
        QLog.e("GameListAdapter", 1, "[onClick] binder null");
        return;
      }
      label405:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alls
 * JD-Core Version:    0.7.0.1
 */