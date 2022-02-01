import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ajcw
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajcx(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener b = new ajcy(this);
  
  public ajcw(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561569, null);
    ajcz localajcz = new ajcz();
    localajcz.jdField_a_of_type_AndroidViewView = localView;
    localajcz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369578));
    if ((localajcz.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)localajcz.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
    }
    localajcz.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131380241));
    localajcz.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363938));
    localajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)localView.findViewById(2131363397));
    localajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)localView.findViewById(2131363404));
    localajcz.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)localView.findViewById(2131379870));
    localajcz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379868));
    localajcz.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener2);
    localView.setOnClickListener(paramOnClickListener1);
    localView.setTag(localajcz);
    if (paramOnClickListener3 != null)
    {
      localajcz.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener3);
      localajcz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.setTag(-3, Integer.valueOf(AIOUtils.dp2px(100.0F, paramContext.getResources())));
      return localView;
    }
    localajcz.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    localajcz.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localView.setTag(-3, null);
    return localView;
  }
  
  public static void a(ajcz paramajcz, RecommendTroopItem paramRecommendTroopItem, Drawable paramDrawable)
  {
    if ((paramajcz == null) || (paramRecommendTroopItem == null))
    {
      QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
      return;
    }
    paramajcz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    paramajcz.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecommendTroopItem.name);
    paramajcz.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecommendTroopItem.name);
    if (paramRecommendTroopItem.activity > 0)
    {
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecommendTroopItem.activity);
      paramDrawable = ntx.a(paramRecommendTroopItem);
      if ((paramDrawable == null) || (paramDrawable.size() <= 0)) {
        break label274;
      }
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setAutoCreateDistanceTextView(true);
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramDrawable);
      label122:
      if ((!paramRecommendTroopItem.isJoined()) && (!paramRecommendTroopItem.hasRequestJoin)) {
        break label298;
      }
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      if (!paramRecommendTroopItem.hasRequestJoin) {
        break label286;
      }
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setText(2131699037);
      label160:
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.dip2px(60.0F));
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.dip2px(29.0F));
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setPadding(0, paramajcz.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, paramajcz.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      label215:
      if (!TextUtils.isEmpty(paramRecommendTroopItem.intro)) {
        break label375;
      }
      paramajcz.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
    }
    for (;;)
    {
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setTag(-1, paramRecommendTroopItem);
      paramajcz.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, paramRecommendTroopItem);
      paramajcz.jdField_a_of_type_AndroidViewView.setTag(-1, paramRecommendTroopItem);
      return;
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
      break;
      label274:
      paramajcz.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      break label122;
      label286:
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setText(2131699038);
      break label160;
      label298:
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setText(2131699036);
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
      int i = ViewUtils.dip2px(16.0F);
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setPadding(i, paramajcz.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, paramajcz.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramajcz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
      break label215;
      label375:
      paramajcz.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramRecommendTroopItem.intro, 11, 16));
    }
  }
  
  protected abstract int a();
  
  public RecommendTroopItem a(int paramInt)
  {
    return (RecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  protected void a(RecommendTroopItem paramRecommendTroopItem) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    RecommendTroopItem localRecommendTroopItem;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
    } while (!paramString.equals(localRecommendTroopItem.uin));
    localRecommendTroopItem.hasRequestJoin = true;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroop", 2, "updateJoinStatus, troopUin: " + paramString);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  protected abstract int b();
  
  protected void b(RecommendTroopItem paramRecommendTroopItem) {}
  
  protected abstract int c();
  
  protected void c(RecommendTroopItem paramRecommendTroopItem) {}
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof ajcz))) {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
    }
    for (;;)
    {
      ajcz localajcz = (ajcz)paramView.getTag();
      RecommendTroopItem localRecommendTroopItem = a(paramInt);
      a(localajcz, localRecommendTroopItem, FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localRecommendTroopItem.uin));
      c(localRecommendTroopItem);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcw
 * JD-Core Version:    0.7.0.1
 */