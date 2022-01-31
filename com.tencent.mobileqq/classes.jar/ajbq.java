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
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajbq
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bepn jdField_a_of_type_Bepn;
  private WeakReference<ajbl> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloGameData> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public ajbq(Context paramContext, ajbl paramajbl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajbl);
    long l = Math.min(babp.i(), babp.j());
    this.jdField_a_of_type_Int = ((int)((float)l - 30.0F * babp.a()) / 3);
    this.b = ((int)(9.0D * (this.jdField_a_of_type_Int / 16.0D)));
    QLog.i("GameListAdapter", 1, "screenWidth:" + l + ",itemWidth:" + this.jdField_a_of_type_Int + ",itemHeight:" + this.b);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(ViewGroup paramViewGroup, ajbt paramajbt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameListAdapter", 2, "[showHighLightGame] ");
    }
    if (paramajbt.jdField_a_of_type_AndroidViewView != null)
    {
      paramViewGroup.removeView(paramajbt.jdField_a_of_type_AndroidViewView);
      paramajbt.jdField_a_of_type_AndroidViewView = null;
    }
    paramViewGroup.setClipChildren(true);
    paramViewGroup.setClipToPadding(true);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131302672);
    ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131302672);
    ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131302672);
    ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131302672);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131297050);
    localRelativeLayout.setBackgroundDrawable(null);
    paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    paramajbt.jdField_a_of_type_AndroidViewView = localRelativeLayout;
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130838408);
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    localRelativeLayout.addView((View)localObject, new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
    ((ImageView)localObject).setVisibility(8);
    ((ImageView)localObject).postDelayed(new ApolloGameViewBinder.GameListAdapter.2(this, (ImageView)localObject, localRelativeLayout, paramViewGroup, paramajbt), 400L);
  }
  
  public void a(List<ApolloGameData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bepn != null) {
      this.jdField_a_of_type_Bepn.dismiss();
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493051, paramViewGroup, false);
      paramViewGroup = new ajbt(null);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[0] = ((ViewGroup)paramView.findViewById(2131302665));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0] = ((URLImageView)paramView.findViewById(2131302666));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131302667));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramView.findViewById(2131302668));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[0] = ((ImageView)paramView.findViewById(2131302669));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[1] = ((ViewGroup)paramView.findViewById(2131302671));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1] = ((URLImageView)paramView.findViewById(2131302672));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131302673));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramView.findViewById(2131302674));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[1] = ((ImageView)paramView.findViewById(2131302675));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[2] = ((ViewGroup)paramView.findViewById(2131302677));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2] = ((URLImageView)paramView.findViewById(2131302678));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131302679));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramView.findViewById(2131302680));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[2] = ((ImageView)paramView.findViewById(2131302681));
      paramView.setTag(paramViewGroup);
      localObject1 = (ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 == null) {
        break label1569;
      }
      ajbl.a((ajbl)localObject1);
    }
    label396:
    label785:
    label1558:
    label1560:
    label1563:
    label1569:
    for (Object localObject1 = ajbl.a((ajbl)localObject1);; localObject1 = null)
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
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageResource(2130838315);
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
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849053);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawablePadding(aciy.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawables((Drawable)localObject2, null, null, null);
          label692:
          if (TextUtils.isEmpty(localApolloGameData.listCoverUrl)) {
            break label1445;
          }
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Resources)localObject2).getDrawable(2130838384);
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Resources)localObject2).getDrawable(2130838384);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.b;
          localObject2 = URLDrawable.getDrawable(localApolloGameData.listCoverUrl, (URLDrawable.URLDrawableOptions)localObject3);
          paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setImageDrawable((Drawable)localObject2);
          j = paramInt * 3 + i;
          if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (aila.a("aio.city.game", ajbl.a((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get())) != ailb.d)) {
            break label1560;
          }
          j -= 1;
        }
        for (;;)
        {
          if ((j < ApolloGameUtil.a()) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localApolloGameData.gameId)) && (paramViewGroup.b[i].getVisibility() != 0))
          {
            localObject2 = paramViewGroup.b[i];
            ((ImageView)localObject2).setVisibility(0);
            localObject3 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject2).a(19).a();
            BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            localRedTypeInfo.red_type.set(4);
            localRedTypeInfo.red_content.set(ajjy.a(2131634549));
            localRedTypeInfo.red_desc.set("{'cn':'#FF0000', 'av':1}");
            ((RedTouch)localObject3).a(localRedTypeInfo);
            ((ImageView)localObject2).setTag(localObject3);
            if (ajbl.jdField_a_of_type_Long == 0L) {
              ajbl.jdField_a_of_type_Long = System.currentTimeMillis();
            }
            if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
              bajr.a(ajbl.a((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "beyond_notice", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
            }
            if (ajbl.jdField_a_of_type_Boolean)
            {
              ajbl.jdField_a_of_type_Boolean = false;
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
            if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (ajbl.a((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()) != null) && (localApolloGameData.gameId == ajbl.a((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_Int))
            {
              a(paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i], paramViewGroup);
              localObject2 = (aifc)ajbl.a((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getManager(211);
              ((aifc)localObject2).a(-1, -1);
              ((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(((aifc)localObject2).a());
            }
          }
          for (;;)
          {
            i += 1;
            break label396;
            paramViewGroup = (ajbt)paramView.getTag();
            break;
            if (!TextUtils.isEmpty(localApolloGameData.tagUrl))
            {
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable(aitu.a(String.valueOf(localApolloGameData.tagUrl.hashCode()), null, localApolloGameData.tagUrl, true));
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(0);
              bajr.a(ajbl.a((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "showtag", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId), String.valueOf(paramInt * 3 + i), String.valueOf(localApolloGameData.tagType) });
              break label590;
            }
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setVisibility(8);
            break label590;
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawablePadding(0);
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setCompoundDrawables(null, null, null, null);
            break label692;
            label1445:
            paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i].setImageResource(2130838384);
            break label785;
            if ((paramViewGroup.b[i].getTag() != null) && ((paramViewGroup.b[i].getTag() instanceof RedTouch))) {
              ((RedTouch)paramViewGroup.b[i].getTag()).b();
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
    ajbl localajbl = (ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajbl != null) {
      if (ajbl.a(localajbl) != null) {
        if (paramView.getId() == 2131302665) {
          paramView = paramView.findViewById(2131302669);
        }
      }
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        paramView.setVisibility(8);
        if ((paramView.getTag() != null) && ((paramView.getTag() instanceof RedTouch))) {
          ((RedTouch)paramView.getTag()).b();
        }
        bajr.a(ajbl.a((ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "beyond_notice_disappear", 1, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
      }
      paramView = ajbl.a(localajbl);
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
        if (paramView.getId() == 2131302671)
        {
          paramView = paramView.findViewById(2131302675);
          break;
        }
        if (paramView.getId() != 2131302677) {
          break label405;
        }
        paramView = paramView.findViewById(2131302681);
        break;
        localObject = ajbl.a(localajbl);
        if (paramView != null) {}
        try
        {
          paramView.mValidTime = (System.currentTimeMillis() - 1000L);
          ApolloGameUtil.a(ajbl.a(localajbl), paramView);
          ajbl.a(localajbl).remove(paramView);
          if (QLog.isColorLevel()) {
            QLog.d("GameListAdapter", 2, new Object[] { "[onClick] remove red corner for ", Integer.valueOf(localApolloGameData.gameId) });
          }
          ajbl.c(localajbl, localApolloGameData);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajbq
 * JD-Core Version:    0.7.0.1
 */