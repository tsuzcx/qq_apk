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
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class afcy
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afcz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<RecommendTroopItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private View.OnClickListener b = new afda(this);
  
  public afcy(Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener3)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561147, null);
    afdb localafdb = new afdb();
    localafdb.jdField_a_of_type_AndroidViewView = localView;
    localafdb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368718));
    localafdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131378405));
    localafdb.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131363569));
    localafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout = ((TroopActiveLayout)localView.findViewById(2131363053));
    localafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)localView.findViewById(2131363060));
    localafdb.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)localView.findViewById(2131378125));
    localafdb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378123));
    localafdb.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener2);
    localView.setOnClickListener(paramOnClickListener1);
    localView.setTag(localafdb);
    if (paramOnClickListener3 != null)
    {
      localafdb.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener3);
      localafdb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localView.setTag(-3, Integer.valueOf(actj.a(100.0F, paramContext.getResources())));
      return localView;
    }
    localafdb.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    localafdb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localView.setTag(-3, null);
    return localView;
  }
  
  public static void a(afdb paramafdb, RecommendTroopItem paramRecommendTroopItem, Drawable paramDrawable)
  {
    if ((paramafdb == null) || (paramRecommendTroopItem == null))
    {
      QLog.d("RecommendTroop", 1, "viewHolder == null || troopItem == null");
      return;
    }
    paramafdb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    paramafdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecommendTroopItem.name);
    paramafdb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(paramRecommendTroopItem.name);
    if (paramRecommendTroopItem.activity > 0)
    {
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecommendTroopItem.activity);
      paramDrawable = mya.a(paramRecommendTroopItem);
      if ((paramDrawable == null) || (paramDrawable.size() <= 0)) {
        break label274;
      }
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setAutoCreateDistanceTextView(true);
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(paramDrawable);
      label122:
      if ((!paramRecommendTroopItem.isJoined()) && (!paramRecommendTroopItem.hasRequestJoin)) {
        break label298;
      }
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      if (!paramRecommendTroopItem.hasRequestJoin) {
        break label286;
      }
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setText(2131699609);
      label160:
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setMinWidth(bbll.a(60.0F));
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setMinWidth(bbll.a(29.0F));
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setPadding(0, paramafdb.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, paramafdb.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      label215:
      if (!TextUtils.isEmpty(paramRecommendTroopItem.intro)) {
        break label372;
      }
      paramafdb.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
    }
    for (;;)
    {
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setTag(-1, paramRecommendTroopItem);
      paramafdb.jdField_a_of_type_AndroidWidgetTextView.setTag(-1, paramRecommendTroopItem);
      paramafdb.jdField_a_of_type_AndroidViewView.setTag(-1, paramRecommendTroopItem);
      return;
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
      break;
      label274:
      paramafdb.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      break label122;
      label286:
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setText(2131699610);
      break label160;
      label298:
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setText(2131699608);
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
      int i = bbll.a(16.0F);
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setPadding(i, paramafdb.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, paramafdb.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
      paramafdb.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839060);
      break label215;
      label372:
      paramafdb.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new aykk(paramRecommendTroopItem.intro, 11, 16));
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
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView.getTag() instanceof afdb)) {}
    }
    else
    {
      paramViewGroup = a(this.jdField_a_of_type_AndroidContentContext, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
    }
    paramView = (afdb)paramViewGroup.getTag();
    RecommendTroopItem localRecommendTroopItem = a(paramInt);
    a(paramView, localRecommendTroopItem, bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localRecommendTroopItem.uin));
    c(localRecommendTroopItem);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afcy
 * JD-Core Version:    0.7.0.1
 */