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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ajno
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajnp(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener b = new ajnq(this);
  
  public ajno(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561627, null);
    ajnr localajnr = new ajnr();
    localajnr.jdField_a_of_type_AndroidViewView = localView;
    localajnr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369423));
    if ((localajnr.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)localajnr.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
    }
    localajnr.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131380170));
    localajnr.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363840));
    localajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)localView.findViewById(2131363302));
    localajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)localView.findViewById(2131363309));
    localajnr.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)localView.findViewById(2131379776));
    localajnr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379773));
    localajnr.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener2);
    localView.setOnClickListener(paramOnClickListener1);
    localView.setTag(localajnr);
    if (paramOnClickListener3 != null)
    {
      localajnr.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener3);
      localajnr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.setTag(-3, Integer.valueOf(agej.a(100.0F, paramContext.getResources())));
      return localView;
    }
    localajnr.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    localajnr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localView.setTag(-3, null);
    return localView;
  }
  
  public static void a(ajnr paramajnr, RecommendTroopItem paramRecommendTroopItem, Drawable paramDrawable)
  {
    if ((paramajnr == null) || (paramRecommendTroopItem == null))
    {
      QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
      return;
    }
    paramajnr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    paramajnr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecommendTroopItem.name);
    paramajnr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecommendTroopItem.name);
    if (paramRecommendTroopItem.activity > 0)
    {
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecommendTroopItem.activity);
      paramDrawable = nli.a(paramRecommendTroopItem);
      if ((paramDrawable == null) || (paramDrawable.size() <= 0)) {
        break label274;
      }
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setAutoCreateDistanceTextView(true);
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramDrawable);
      label122:
      if ((!paramRecommendTroopItem.isJoined()) && (!paramRecommendTroopItem.hasRequestJoin)) {
        break label298;
      }
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      if (!paramRecommendTroopItem.hasRequestJoin) {
        break label286;
      }
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setText(2131698507);
      label160:
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setMinWidth(bhtq.a(60.0F));
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setMinWidth(bhtq.a(29.0F));
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setPadding(0, paramajnr.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, paramajnr.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      label215:
      if (!TextUtils.isEmpty(paramRecommendTroopItem.intro)) {
        break label374;
      }
      paramajnr.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
    }
    for (;;)
    {
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setTag(-1, paramRecommendTroopItem);
      paramajnr.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, paramRecommendTroopItem);
      paramajnr.jdField_a_of_type_AndroidViewView.setTag(-1, paramRecommendTroopItem);
      return;
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
      break;
      label274:
      paramajnr.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      break label122;
      label286:
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setText(2131698508);
      break label160;
      label298:
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setText(2131698506);
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
      int i = bhtq.a(16.0F);
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setPadding(i, paramajnr.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, paramajnr.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramajnr.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
      break label215;
      label374:
      paramajnr.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new begp(paramRecommendTroopItem.intro, 11, 16));
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
    if ((paramView == null) || (!(paramView.getTag() instanceof ajnr))) {
      paramView = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
    }
    for (;;)
    {
      ajnr localajnr = (ajnr)paramView.getTag();
      RecommendTroopItem localRecommendTroopItem = a(paramInt);
      a(localajnr, localRecommendTroopItem, aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localRecommendTroopItem.uin));
      c(localRecommendTroopItem);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajno
 * JD-Core Version:    0.7.0.1
 */