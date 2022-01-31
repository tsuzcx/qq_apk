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
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

public class agli
  extends RecyclerView.Adapter<aglk>
{
  public ArrayList<LocalMediaInfo> a;
  public WeakReference<PhotoListPanel> a;
  boolean a;
  
  public agli(PhotoListPanel paramPhotoListPanel)
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
    return bdfa.getMediaType(paramString);
  }
  
  public aglk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aglk(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561153, paramViewGroup, false));
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
  
  public void a(aglk paramaglk, int paramInt)
  {
    paramaglk.itemView.setOnClickListener(new aglj(this, paramInt));
    paramaglk.jdField_a_of_type_Aglf.a(paramInt);
    paramaglk.jdField_a_of_type_Aglf.a(paramaglk.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    Object localObject1 = a(paramInt);
    Object localObject2 = paramaglk.jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = new apkp(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).i, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    apkp localapkp = new apkp(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).j, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject3 = bdfa.generateAlbumThumbURL((LocalMediaInfo)localObject1, "FLOW_THUMB");
    URLDrawable localURLDrawable = paramaglk.jdField_a_of_type_ComTencentImageURLDrawable;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((localObject3 != null) && ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject3))))
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = ((LocalMediaInfo)localObject1).thumbWidth;
      localURLDrawableOptions.mRequestHeight = ((LocalMediaInfo)localObject1).thumbHeight;
      if ((((LocalMediaInfo)localObject1).thumbWidth <= 0) || (((LocalMediaInfo)localObject1).thumbHeight <= 0)) {
        break label580;
      }
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
      localURLDrawableOptions.mFailedDrawable = localapkp;
      localObject4 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "PhotoListPanel,adapter getView(), url :" + ((URL)localObject3).toString());
      }
      ((URLDrawable)localObject4).setTag(localObject1);
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
      paramaglk.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
      if (localURLDrawable != null) {
        localURLDrawable.cancelDownload(true);
      }
    }
    localObject2 = paramaglk.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
    localObject3 = paramaglk.b;
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
      localObject3 = paramaglk.jdField_a_of_type_AndroidWidgetImageView;
      i = getItemViewType(paramInt);
      if (i != 0) {
        break label634;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramaglk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      label394:
      if ((!bdeu.b(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) || (paramInt != 0)) {
        break label701;
      }
      localObject3 = (alok)((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (((alok)localObject3).a(1))
      {
        ((alok)localObject3).a();
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).c = paramaglk.jdField_a_of_type_AndroidViewView;
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).k = true;
      }
      if (!((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).k) {
        break label690;
      }
      paramaglk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      alok.a(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidAppActivity, paramaglk.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        localObject3 = PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt);
        paramaglk.itemView.setContentDescription((CharSequence)localObject3);
        localObject1 = PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
        paramaglk.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      return;
      label580:
      localURLDrawableOptions.mLoadingDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Apkp;
      localURLDrawableOptions.mFailedDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_Apkp;
      break;
      ((NumberCheckBox)localObject2).setChecked(false);
      ((ImageView)localObject3).setVisibility(4);
      break label349;
      label634:
      if (i == 1)
      {
        ((ImageView)localObject3).setVisibility(0);
        localObject3 = paramaglk.jdField_a_of_type_AndroidWidgetTextView;
        ((TextView)localObject3).setVisibility(0);
        ((TextView)localObject3).setText(NewPhotoListActivity.formatTimeToString(((LocalMediaInfo)localObject1).mDuration));
        break label394;
      }
      ((ImageView)localObject3).setVisibility(4);
      paramaglk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break label394;
      label690:
      paramaglk.jdField_a_of_type_AndroidViewView.setVisibility(4);
      continue;
      label701:
      paramaglk.jdField_a_of_type_AndroidViewView.setVisibility(4);
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
      String.format(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719274), new Object[] { Integer.valueOf(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.size()) });
      return;
    }
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719269);
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
    return bdfa.getMediaType(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agli
 * JD-Core Version:    0.7.0.1
 */