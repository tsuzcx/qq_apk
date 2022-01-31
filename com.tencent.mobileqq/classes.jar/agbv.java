import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class agbv
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public agbv(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.j) {}
    Object localObject2;
    int i;
    do
    {
      long l;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "current select count:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.size());
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agbx.a(this.jdField_a_of_type_Int);
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.T) && (!PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2)));
        i = ((LocalMediaInfo)localObject2).selectStatus;
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.J) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.l == 9501) && (i == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.size() >= 1))
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "最多只能选择1张图片", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
          return;
        }
        if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.i)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Long < 1000L);
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.S) {}
      for (i = 0;; i = 1)
      {
        urp.a("pic_choose_toast", "exp_tooMuch", i, 0, new String[] { "0" });
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Long = l;
        PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.l == 9501) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
      {
        l = 0L;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.iterator();
        while (paramView.hasNext()) {
          l += bace.a((String)paramView.next());
        }
        if (l + bace.a(((LocalMediaInfo)localObject2).path) > 52428800L)
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "选择图片总大小不能超过50M", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          return;
        }
      }
      if ((PhotoListActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) && (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) != -1L) && (i != 1))
      {
        if ((baaf.a((LocalMediaInfo)localObject2) == 1) && (((LocalMediaInfo)localObject2).mDuration > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Long))
        {
          bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, ajjy.a(2131642281) + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Long / 1000L / 60L + ajjy.a(2131642293), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o);
          return;
        }
        l = 0L;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.iterator();
        while (paramView.hasNext()) {
          l += bace.a((String)paramView.next());
        }
        if (l + bace.a(((LocalMediaInfo)localObject2).path) > PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) * 1024L * 1024L)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
          localObject2 = new StringBuilder().append(ajjy.a(2131642287));
          if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) < 1024L) {}
          for (paramView = PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) + "MB";; paramView = (float)PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) / 1024.0F + "G")
          {
            bbmy.a((Context)localObject1, paramView + ajjy.a(2131642316), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o);
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            return;
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2)) && (bace.a(((LocalMediaInfo)localObject2).path) > 3145728L))
      {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, ajjy.a(2131642324), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        return;
      }
    } while ((PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) && (!biys.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2)));
    if (i == 1)
    {
      i = 2;
      ((LocalMediaInfo)localObject2).selectStatus = i;
      if (((LocalMediaInfo)localObject2).selectStatus != 1) {
        break label964;
      }
    }
    String str;
    label964:
    for (boolean bool = true;; bool = false)
    {
      str = ((LocalMediaInfo)localObject2).path;
      paramView = PresendPicMgr.a();
      if (!bool) {
        break label1740;
      }
      localObject1 = agaq.a(((LocalMediaInfo)localObject2).mMimeType);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.K) || (localObject1 == null) || (!"video".equals(localObject1[0]))) {
        break label1107;
      }
      if (baaf.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, PhotoListActivity.a(), (LocalMediaInfo)localObject2, PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))) {
        break label970;
      }
      ((LocalMediaInfo)localObject2).selectStatus = 2;
      return;
      i = 1;
      break;
    }
    label970:
    if ((PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) && ((((LocalMediaInfo)localObject2).mDuration > 1200000L) || (((LocalMediaInfo)localObject2).fileSize > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_Long)))
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getString(2131653672), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getDimensionPixelSize(2131167766));
      ((LocalMediaInfo)localObject2).selectStatus = 2;
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(((LocalMediaInfo)localObject2).mChecked);
      return;
    }
    PhotoListActivity localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
    localPhotoListActivity.q += 1;
    PhotoListActivity.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.q == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject2);
    }
    label1107:
    if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)))
    {
      localPhotoListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      localPhotoListActivity.r += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.add(str);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject2).position);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilHashMap.put(str, Integer.valueOf(((LocalMediaInfo)localObject2).panoramaPhotoType));
    if ((PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilHashMap.put(str, localObject2);
    }
    if ((paramView != null) && (localObject1 != null) && (localObject1[0] != null) && (!"video".equals(localObject1[0]))) {
      paramView.a(str, 1007, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent().getIntExtra("entrance", 0));
    }
    ageh.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent(), "param_totalSelNum");
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent();
    if (!paramView.hasExtra("param_initTime")) {
      paramView.putExtra("param_initTime", System.currentTimeMillis());
    }
    Object localObject1 = (LinkedHashMap)baaf.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_JavaLangString);
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = new LinkedHashMap();
      baaf.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_JavaLangString, paramView);
    }
    paramView.put(str, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
    paramView = baaf.jdField_c_of_type_JavaUtilHashMap;
    if (!paramView.containsKey(str)) {
      paramView.put(str, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_JavaLangString));
    }
    label1469:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agcb != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Agcb.a(bool, (LocalMediaInfo)localObject2);
    }
    PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_Int, bool);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.m == 2)
    {
      if ((!PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, ((LocalMediaInfo)localObject2).path) != 1)) {
        break label2056;
      }
      paramView = PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, str);
      if ((paramView != null) && (paramView.fileSize > 104345600L) && (bool))
      {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getString(2131653694), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getDimensionPixelSize(2131167766));
        baaf.d();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g();
      if (!PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
        break;
      }
      if (vhg.a().a().isEmpty())
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(this.jdField_a_of_type_Int - i);
        if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getHeight() - paramView.getY() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.smoothScrollBy(vhg.jdField_a_of_type_Int, 500);
        }
      }
      vhg.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap);
      return;
      label1740:
      localObject1 = agaq.a(((LocalMediaInfo)localObject2).mMimeType);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.K) && (localObject1 != null) && ("video".equals(localObject1[0])))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
        ((PhotoListActivity)localObject1).q -= 1;
        PhotoListActivity.c();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.q == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject2);
        }
        if (PhotoListActivity.a() < 0) {
          PhotoListActivity.a(0);
        }
      }
      if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
        ((PhotoListActivity)localObject1).r -= 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.remove(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilArrayList.remove(((LocalMediaInfo)localObject2).position);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilHashMap.remove(str);
      if ((PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.h(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilHashMap.remove(str);
      }
      if (paramView != null) {
        paramView.b(str, 1013);
      }
      ageh.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent(), "param_cancelSelNum");
      paramView = (HashMap)baaf.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_JavaLangString);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = baaf.jdField_c_of_type_JavaUtilHashMap;
      if (!paramView.containsKey(str)) {
        break label1469;
      }
      paramView.remove(str);
      break label1469;
      label2056:
      if (new File(((LocalMediaInfo)localObject2).path).length() > axwv.a())
      {
        bbmy.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getString(2131629431), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.o);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.m = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agbv
 * JD-Core Version:    0.7.0.1
 */