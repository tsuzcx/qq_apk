import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ahzv
  extends BaseAdapter
  implements azwh, begh
{
  private int jdField_a_of_type_Int = 0;
  protected ahzz a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnClickListener a;
  private azwg jdField_a_of_type_Azwg;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<DiscussionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ahzx(this);
  private List<atmo> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  
  public ahzv(Context paramContext, ahzz paramahzz, ListView paramListView, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahzy(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      b();
    }
    this.jdField_a_of_type_Azwg = new azwg(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Ahzz = paramahzz;
    paramListView.setOnScrollListener(this);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      if ((localObject == null) || (!(localObject instanceof aiaa))) {
        break label169;
      }
      localObject = (aiaa)localObject;
      if ((paramString == null) && (!TextUtils.isEmpty(((aiaa)localObject).jdField_a_of_type_JavaLangString)))
      {
        paramBitmap = this.jdField_a_of_type_Azwg.a(101, ((aiaa)localObject).jdField_a_of_type_JavaLangString);
        if (paramBitmap != null) {
          ((aiaa)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        }
      }
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_Azwg.a(((aiaa)localObject).jdField_a_of_type_JavaLangString, 101, true);
      continue;
      if (TextUtils.equals(paramString, ((aiaa)localObject).jdField_a_of_type_JavaLangString))
      {
        ((aiaa)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = ((ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
    Object localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131654733);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131625398);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l = 0L;
      String str2 = babh.a(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
      String str3 = ChnToSpell.a(str2, 1);
      if ((str2.matches((String)localObject2)) || (str2.contains(str1))) {
        l = 65536L;
      }
      if ((str3 == null) || (str3.length() == 0)) {
        l |= 0xFFFF;
      }
      for (;;)
      {
        ((HashMap)localObject1).put(localDiscussionInfo.uin, Long.valueOf(l));
        break;
        if (baip.b(str3.charAt(0))) {
          l |= str3.charAt(0);
        } else if (Character.isDigit(str3.charAt(0))) {
          l |= 0xFFFE;
        } else {
          l |= 0xFFFF;
        }
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new ahzw(this, (HashMap)localObject1));
    this.jdField_b_of_type_JavaUtilList.clear();
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      if (((DiscussionInfo)localObject2).hasCollect) {
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = this.jdField_b_of_type_JavaUtilList.size();
      if (i > 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public DiscussionInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (DiscussionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Azwg.d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof DiscussionInfo)) {
      return Long.parseLong(((DiscussionInfo)localObject).uin);
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof Integer)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (getItemViewType(paramInt) == 1)
    {
      String str;
      Object localObject2;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493427, paramViewGroup, false);
        paramViewGroup = new aiaa(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302061));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311221));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311223));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299661));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.setTag(paramViewGroup);
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((Button)paramView.findViewById(2131299654)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = (DiscussionInfo)getItem(paramInt);
        str = ((DiscussionInfo)localObject1).uin;
        localObject2 = babh.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        localObject2 = (ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((ajhh)localObject2).a(str)) }));
        localObject2 = this.jdField_a_of_type_Azwg.a(101, str);
        if (localObject2 != null) {
          break label314;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(bacm.e());
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_Azwg.a(str, 101, false);
        }
        paramViewGroup.jdField_a_of_type_JavaLangString = str;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject1);
        if (!this.jdField_a_of_type_Boolean) {
          break label340;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return paramView;
        paramViewGroup = (aiaa)paramView.getTag();
        break;
        label314:
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentWidgetListView.getResources(), (Bitmap)localObject2));
      }
      label340:
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramView;
    }
    if (paramView == null)
    {
      paramView = new aiaa(null);
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493426, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131299681));
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = "";
      if ((paramInt != 0) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131628793);
      return localObject1;
      paramViewGroup = (aiaa)paramView.getTag();
      localObject1 = paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131628782);
    return localObject1;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void notifyDataSetChanged()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 0)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      a(null, null);
      this.jdField_a_of_type_Azwg.b();
      return;
    }
    this.jdField_a_of_type_Azwg.c();
    this.jdField_a_of_type_Azwg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahzv
 * JD-Core Version:    0.7.0.1
 */