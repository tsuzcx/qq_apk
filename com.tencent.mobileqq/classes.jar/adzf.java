import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter.2;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class adzf
  extends RecyclerView.Adapter<adzh>
{
  int jdField_a_of_type_Int;
  public ArrayList<LocalMediaInfo> a;
  boolean jdField_a_of_type_Boolean;
  int b;
  int c;
  int d;
  
  public adzf(PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = aciy.a(4.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
    this.b = i;
    this.c = i;
    this.jdField_a_of_type_Int = aciy.a(27.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
    this.d = aciy.a(27.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(paramPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1;
    }
    return baaf.a(paramString);
  }
  
  public adzh a(ViewGroup paramViewGroup, int paramInt)
  {
    return new adzh(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495374, paramViewGroup, false));
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localLocalMediaInfo = (LocalMediaInfo)localIterator.next();
    } while (!localLocalMediaInfo.path.equals(paramString));
    for (paramString = localLocalMediaInfo;; paramString = null) {
      return paramString;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LocalMediaInfo)localIterator.next()).mChecked = false;
    }
  }
  
  public void a(adzh paramadzh, int paramInt)
  {
    paramadzh.itemView.setOnClickListener(new adzg(this, paramInt));
    paramadzh.jdField_a_of_type_Adzc.a(paramInt);
    paramadzh.jdField_a_of_type_Adzc.a(paramadzh.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    Object localObject1 = a(paramInt);
    Object localObject2 = paramadzh.jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = new amym(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.i, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    amym localamym = new amym(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.j, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject3 = baaf.a((LocalMediaInfo)localObject1, "FLOW_THUMB");
    URLDrawable localURLDrawable = paramadzh.jdField_a_of_type_ComTencentImageURLDrawable;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((localObject3 != null) && ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject3))))
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ((LocalMediaInfo)localObject1).thumbWidth;
      localURLDrawableOptions.mRequestHeight = ((LocalMediaInfo)localObject1).thumbHeight;
      if ((((LocalMediaInfo)localObject1).thumbWidth <= 0) || (((LocalMediaInfo)localObject1).thumbHeight <= 0)) {
        break label526;
      }
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
      localURLDrawableOptions.mFailedDrawable = localamym;
      localObject4 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "PhotoListPanel,adapter getView(), url :" + ((URL)localObject3).toString());
      }
      ((URLDrawable)localObject4).setTag(localObject1);
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
      paramadzh.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
      if (localURLDrawable != null) {
        localURLDrawable.cancelDownload(true);
      }
    }
    localObject2 = paramadzh.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
    localObject3 = paramadzh.b;
    ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
    int i;
    if (((LocalMediaInfo)localObject1).mChecked)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject1).path);
      if (i >= 0) {
        ((NumberCheckBox)localObject2).setCheckedNumber(i + 1);
      }
      ((ImageView)localObject3).setVisibility(0);
      label331:
      if (this.jdField_a_of_type_Boolean) {
        ((NumberCheckBox)localObject2).setTextColor(-1509949441);
      }
      localObject3 = paramadzh.jdField_a_of_type_AndroidWidgetImageView;
      i = getItemViewType(paramInt);
      if (i != 0) {
        break label568;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramadzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      label376:
      if ((!azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) || (paramInt != 0)) {
        break label635;
      }
      localObject3 = (ajei)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (((ajei)localObject3).a(1))
      {
        ((ajei)localObject3).a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c = paramadzh.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k = true;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k) {
        break label624;
      }
      paramadzh.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ajei.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, paramadzh.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        localObject3 = PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt);
        paramadzh.itemView.setContentDescription((CharSequence)localObject3);
        localObject1 = PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
        paramadzh.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      return;
      label526:
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Amym;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b;
      break;
      ((NumberCheckBox)localObject2).setChecked(false);
      ((ImageView)localObject3).setVisibility(4);
      break label331;
      label568:
      if (i == 1)
      {
        ((ImageView)localObject3).setVisibility(0);
        localObject3 = paramadzh.jdField_a_of_type_AndroidWidgetTextView;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(PhotoListActivity.a(((LocalMediaInfo)localObject1).mDuration));
        break label376;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramadzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break label376;
      label624:
      paramadzh.jdField_a_of_type_AndroidViewView.setVisibility(4);
      continue;
      label635:
      paramadzh.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      PhotoListPanel.h = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.i();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      String.format(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131652952), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size()) });
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131652947);
  }
  
  public void b(List<LocalMediaInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidOsHandler.post(new PhotoListPanel.PhotoPanelAdapter.2(this, paramList));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return baaf.a(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzf
 * JD-Core Version:    0.7.0.1
 */