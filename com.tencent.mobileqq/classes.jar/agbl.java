import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class agbl
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final ChatHistoryBaseFragment jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  @NonNull
  private List<Object> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<TroopLinkElement> b;
  
  public agbl(QQAppInterface paramQQAppInterface, Context paramContext, ChatHistoryBaseFragment paramChatHistoryBaseFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseFragment = paramChatHistoryBaseFragment;
    this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
    this.b = new ArrayList();
  }
  
  private void a(agbn paramagbn, TroopLinkElement paramTroopLinkElement)
  {
    if (!TextUtils.isEmpty(paramTroopLinkElement.iconUrl))
    {
      a(agbn.a(paramagbn), paramTroopLinkElement.iconUrl);
      if (TextUtils.isEmpty(paramTroopLinkElement.title)) {
        break label245;
      }
      agbn.a(paramagbn).setText(paramTroopLinkElement.title);
    }
    for (;;)
    {
      Object localObject = new Date(Long.parseLong(paramTroopLinkElement.timeSecond) * 1000L);
      localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
      agbn.b(paramagbn).setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseFragment.a(), paramTroopLinkElement.uin);
      agbn.c(paramagbn).setText((CharSequence)localObject);
      agbn.a(paramagbn).setOnClickListener(new agbm(this, paramTroopLinkElement, paramagbn));
      if (!this.jdField_a_of_type_Boolean) {
        break label259;
      }
      agbn.a(paramagbn).setVisibility(0);
      boolean bool = this.b.contains(paramTroopLinkElement);
      agbn.a(paramagbn).setChecked(bool);
      paramTroopLinkElement = (LinearLayout.LayoutParams)agbn.a(paramagbn).getLayoutParams();
      paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, vzo.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), paramTroopLinkElement.bottomMargin);
      agbn.a(paramagbn).setLayoutParams(paramTroopLinkElement);
      return;
      agbn.a(paramagbn).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849345));
      break;
      label245:
      agbn.a(paramagbn).setText(paramTroopLinkElement.url);
    }
    label259:
    agbn.a(paramagbn).setVisibility(8);
    paramTroopLinkElement = (LinearLayout.LayoutParams)agbn.a(paramagbn).getLayoutParams();
    paramTroopLinkElement.setMargins(paramTroopLinkElement.leftMargin, paramTroopLinkElement.topMargin, vzo.a(this.jdField_a_of_type_AndroidContentContext, 50.0F), paramTroopLinkElement.bottomMargin);
    agbn.a(paramagbn).setLayoutParams(paramTroopLinkElement);
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Drawable localDrawable = localBaseApplication.getResources().getDrawable(2130838492);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localURLDrawableOptions.mRequestHeight = localLayoutParams.height;
    localURLDrawableOptions.mRequestWidth = localLayoutParams.width;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bavi.b(localLayoutParams.width, localLayoutParams.height, vzo.a(localBaseApplication, 6.0F)));
      paramString.setDecodeHandler(bavi.i);
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramImageView.setImageDrawable(localDrawable);
    }
  }
  
  public List<TroopLinkElement> a()
  {
    return this.b;
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(List<Object> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if ((localObject2 instanceof TroopLinkElement))
    {
      localObject1 = (TroopLinkElement)localObject2;
      if ((paramView != null) && ((paramView.getTag() instanceof agbn)))
      {
        paramViewGroup = (agbn)paramView.getTag();
        a(paramViewGroup, (TroopLinkElement)localObject1);
        paramViewGroup = paramView;
      }
    }
    do
    {
      return paramViewGroup;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558724, null);
      paramViewGroup = new agbn(paramView);
      paramView.setTag(paramViewGroup);
      break;
      paramViewGroup = paramView;
    } while (!(localObject2 instanceof String));
    if ((paramView != null) && ((paramView.getTag() instanceof TextView)))
    {
      localObject1 = (TextView)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      paramView.setText((String)localObject2);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558723, null);
      paramView = (TextView)paramViewGroup.findViewById(2131377043);
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbl
 * JD-Core Version:    0.7.0.1
 */