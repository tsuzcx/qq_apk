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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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

public class ahup
  extends RecyclerView.Adapter<ahur>
{
  public ArrayList<LocalMediaInfo> a;
  public WeakReference<PhotoListPanel> a;
  boolean a;
  
  public ahup(PhotoListPanel paramPhotoListPanel)
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
  
  public ahur a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ahur(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561339, paramViewGroup, false));
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
  
  public void a(ahur paramahur, int paramInt)
  {
    paramahur.itemView.setOnClickListener(new ahuq(this, paramInt));
    paramahur.jdField_a_of_type_Ahum.a(paramInt);
    paramahur.jdField_a_of_type_Ahum.a(paramahur.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    Object localObject1 = a(paramInt);
    Object localObject2 = paramahur.jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = new asbg(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).i, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    asbg localasbg = new asbg(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).j, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject3 = AlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject1, "FLOW_THUMB");
    Object localObject5 = paramahur.jdField_a_of_type_ComTencentImageURLDrawable;
    int i;
    if ((localObject3 != null) && ((localObject5 == null) || (!((URLDrawable)localObject5).getURL().equals(localObject3))))
    {
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = ((LocalMediaInfo)localObject1).thumbWidth;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = ((LocalMediaInfo)localObject1).thumbHeight;
      if ((((LocalMediaInfo)localObject1).thumbWidth > 0) && (((LocalMediaInfo)localObject1).thumbHeight > 0))
      {
        ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = localasbg;
        localObject4 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject5);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "PhotoListPanel,adapter getView(), url :" + ((URL)localObject3).toString());
        }
        ((URLDrawable)localObject4).setTag(localObject1);
        ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
        paramahur.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
      }
    }
    else
    {
      localObject2 = paramahur.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
      localObject3 = paramahur.b;
      ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
      if (!((LocalMediaInfo)localObject1).mChecked) {
        break label622;
      }
      i = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject1).path);
      if (i >= 0) {
        ((NumberCheckBox)localObject2).setCheckedNumber(i + 1);
      }
      ((ImageView)localObject3).setVisibility(0);
      label338:
      if (this.jdField_a_of_type_Boolean) {
        ((NumberCheckBox)localObject2).setTextColor(-1509949441);
      }
      localObject3 = paramahur.jdField_a_of_type_AndroidWidgetImageView;
      i = getItemViewType(paramInt);
      if (i != 0) {
        break label637;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramahur.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      label383:
      if ((!bhbx.b(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) || (paramInt != 0)) {
        break label704;
      }
      localObject3 = (anqn)((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (((anqn)localObject3).a(1))
      {
        ((anqn)localObject3).a();
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).c = paramahur.jdField_a_of_type_AndroidViewView;
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).k = true;
      }
      if (!((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).k) {
        break label693;
      }
      paramahur.jdField_a_of_type_AndroidViewView.setVisibility(0);
      anqn.a(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidAppActivity, paramahur.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        localObject3 = PhotoUtils.createContentDescription(i, (LocalMediaInfo)localObject1, paramInt);
        paramahur.itemView.setContentDescription((CharSequence)localObject3);
        localObject1 = PhotoUtils.createContentDescriptionWithCheckBox(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
        paramahur.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramahur, paramInt, getItemId(paramInt));
      return;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Asbg;
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Asbg;
      break;
      label622:
      ((NumberCheckBox)localObject2).setChecked(false);
      ((ImageView)localObject3).setVisibility(4);
      break label338;
      label637:
      if (i == 1)
      {
        ((ImageView)localObject3).setVisibility(0);
        localObject3 = paramahur.jdField_a_of_type_AndroidWidgetTextView;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(NewPhotoListActivity.formatTimeToString(((LocalMediaInfo)localObject1).mDuration));
        break label383;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramahur.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break label383;
      label693:
      paramahur.jdField_a_of_type_AndroidViewView.setVisibility(4);
      continue;
      label704:
      paramahur.jdField_a_of_type_AndroidViewView.setVisibility(4);
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
      String.format(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131718119), new Object[] { Integer.valueOf(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.size()) });
      return;
    }
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131718114);
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
 * Qualified Name:     ahup
 * JD-Core Version:    0.7.0.1
 */