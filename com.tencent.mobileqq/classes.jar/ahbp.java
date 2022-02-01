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
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

public class ahbp
  extends RecyclerView.Adapter<ahbr>
{
  public ArrayList<LocalMediaInfo> a;
  public WeakReference<PhotoListPanel> a;
  boolean a;
  
  public ahbp(PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramPhotoListPanel);
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1;
    }
    return AlbumUtil.getMediaType(paramString);
  }
  
  public ahbr a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ahbr(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561278, paramViewGroup, false));
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (paramInt != -1)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
          localObject1 = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        }
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
  
  public void a(ahbr paramahbr, int paramInt)
  {
    paramahbr.itemView.setOnClickListener(new ahbq(this, paramInt));
    paramahbr.jdField_a_of_type_Ahbm.a(paramInt);
    paramahbr.jdField_a_of_type_Ahbm.a(paramahbr.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    Object localObject1 = a(paramInt);
    Object localObject2 = paramahbr.jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = new aqww(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).i, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    aqww localaqww = new aqww(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).j, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject3 = AlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject1, "FLOW_THUMB");
    URLDrawable localURLDrawable = paramahbr.jdField_a_of_type_ComTencentImageURLDrawable;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((localObject3 != null) && ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject3))))
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ((LocalMediaInfo)localObject1).thumbWidth;
      localURLDrawableOptions.mRequestHeight = ((LocalMediaInfo)localObject1).thumbHeight;
      if ((((LocalMediaInfo)localObject1).thumbWidth <= 0) || (((LocalMediaInfo)localObject1).thumbHeight <= 0)) {
        break label593;
      }
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
      localURLDrawableOptions.mFailedDrawable = localaqww;
      localObject4 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "PhotoListPanel,adapter getView(), url :" + ((URL)localObject3).toString());
      }
      ((URLDrawable)localObject4).setTag(localObject1);
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
      paramahbr.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
      if (localURLDrawable != null) {
        localURLDrawable.cancelDownload(true);
      }
    }
    localObject2 = paramahbr.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
    localObject3 = paramahbr.b;
    ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
    int i;
    if (((LocalMediaInfo)localObject1).mChecked)
    {
      i = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject1).path);
      if (i >= 0) {
        ((NumberCheckBox)localObject2).setCheckedNumber(i + 1);
      }
      ((ImageView)localObject3).setVisibility(0);
      label349:
      if (this.jdField_a_of_type_Boolean) {
        ((NumberCheckBox)localObject2).setTextColor(-1509949441);
      }
      localObject3 = paramahbr.jdField_a_of_type_AndroidWidgetImageView;
      i = getItemViewType(paramInt);
      if (i != 0) {
        break label647;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramahbr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      label394:
      if ((!bftf.b(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (paramInt != 0)) {
        break label714;
      }
      localObject3 = (amoa)((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(53);
      if (((amoa)localObject3).a(1))
      {
        ((amoa)localObject3).a();
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).c = paramahbr.jdField_a_of_type_AndroidViewView;
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).k = true;
      }
      if (!((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).k) {
        break label703;
      }
      paramahbr.jdField_a_of_type_AndroidViewView.setVisibility(0);
      amoa.a(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidAppActivity, paramahbr.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        localObject3 = PhotoUtils.createContentDescription(i, (LocalMediaInfo)localObject1, paramInt);
        paramahbr.itemView.setContentDescription((CharSequence)localObject3);
        localObject1 = PhotoUtils.createContentDescriptionWithCheckBox(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
        paramahbr.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramahbr, paramInt, getItemId(paramInt));
      return;
      label593:
      localURLDrawableOptions.mLoadingDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Aqww;
      localURLDrawableOptions.mFailedDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Aqww;
      break;
      ((NumberCheckBox)localObject2).setChecked(false);
      ((ImageView)localObject3).setVisibility(4);
      break label349;
      label647:
      if (i == 1)
      {
        ((ImageView)localObject3).setVisibility(0);
        localObject3 = paramahbr.jdField_a_of_type_AndroidWidgetTextView;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(NewPhotoListActivity.formatTimeToString(((LocalMediaInfo)localObject1).mDuration));
        break label394;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramahbr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break label394;
      label703:
      paramahbr.jdField_a_of_type_AndroidViewView.setVisibility(4);
      continue;
      label714:
      paramahbr.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      PhotoListPanel.jdField_b_of_type_Int = 0;
      ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      return;
    }
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(8);
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).i();
    if (!((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.isEmpty())
    {
      String.format(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131717737), new Object[] { Integer.valueOf(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.size()) });
      return;
    }
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131717732);
  }
  
  public void b(List<LocalMediaInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsHandler.post(new PhotoListPanel.PhotoPanelAdapter.2(this, paramList));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return AlbumUtil.getMediaType(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbp
 * JD-Core Version:    0.7.0.1
 */