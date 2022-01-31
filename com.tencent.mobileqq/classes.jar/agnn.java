import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.HashMap;

public class agnn
  implements bfpc
{
  public agnn(PhotoListActivity paramPhotoListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject2;
    int k;
    int i;
    label559:
    Object localObject3;
    Object localObject4;
    switch (this.a.jdField_a_of_type_Agnv.getItemViewType(paramInt))
    {
    default: 
      return;
    case 0: 
      if (this.a.jdField_j_of_type_Boolean)
      {
        paramAdapterView = this.a.jdField_a_of_type_Agnv.a(paramInt);
        if ((this.a.I) && (paramAdapterView.mediaWidth > 0) && (paramAdapterView.mediaHeight > 0))
        {
          if ((this.a.jdField_a_of_type_Double > 0.0D) && ((paramAdapterView.mediaHeight * 1.0F / paramAdapterView.mediaWidth < this.a.jdField_b_of_type_Double) || (paramAdapterView.mediaHeight * 1.0F / paramAdapterView.mediaWidth > this.a.jdField_a_of_type_Double)))
          {
            bcpw.a(this.a, this.a.getResources().getString(2131695166), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
            return;
          }
          if ((this.a.p > 0) && (paramAdapterView.fileSize > this.a.p))
          {
            bcpw.a(this.a, this.a.getResources().getString(2131695171, new Object[] { Integer.valueOf(this.a.p / 1048576) }), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
            return;
          }
        }
        if ((PhotoListActivity.k(this.a)) && (paramAdapterView.mediaWidth > 0) && (paramAdapterView.mediaHeight > 0) && (this.a.p > 0) && (paramAdapterView.fileSize > this.a.p))
        {
          bcpw.a(this.a, this.a.getResources().getString(2131695171, new Object[] { Integer.valueOf(this.a.p / 1048576) }), 0).b(this.a.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        if (this.a.O)
        {
          this.a.e();
          agmi.a(BaseApplicationImpl.getContext()).a(new agno(this, paramInt), paramAdapterView);
          return;
        }
        this.a.a(paramAdapterView, paramInt);
        return;
      }
      bbbj.a();
      paramAdapterView = this.a.jdField_a_of_type_Agnv.a(paramInt);
      paramView = this.a.getIntent();
      paramView.putExtra("ALBUM_NAME", this.a.jdField_a_of_type_JavaLangString);
      paramView.putExtra("ALBUM_ID", this.a.jdField_b_of_type_JavaLangString);
      paramView.putExtra("PhotoConst.MY_UIN", this.a.e);
      paramView.putExtra("PhotoConst.IS_OVERLOAD", this.a.y);
      if ((PhotoListActivity.d(this.a)) && (!PhotoListActivity.jdField_a_of_type_Boolean) && (PhotoListActivity.jdField_a_of_type_JavaUtilHashMap != null))
      {
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        int j = 0;
        int m = this.a.jdField_b_of_type_JavaUtilArrayList.size();
        k = 0;
        i = paramInt;
        if (k < m)
        {
          localObject3 = (String)this.a.jdField_b_of_type_JavaUtilArrayList.get(k);
          localObject4 = (LocalMediaInfo)PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
          if (bbbj.a((LocalMediaInfo)localObject4) != 0) {
            break label4547;
          }
          ((ArrayList)localObject1).add(localObject3);
          if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.contains(localObject3))) {
            ((ArrayList)localObject2).add(Integer.valueOf(j));
          }
          if (((LocalMediaInfo)localObject4).position.intValue() != paramInt) {
            break label4544;
          }
          i = j;
          label664:
          j += 1;
        }
      }
      break;
    }
    label3481:
    label3516:
    label4544:
    label4547:
    for (;;)
    {
      k += 1;
      break label559;
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject1);
      paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
      paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", (ArrayList)localObject2);
      if (bbbj.a(paramAdapterView) == 0) {
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
      }
      paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.a.m);
      paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
      paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.q);
      paramView.putExtra("PhotoConst.editPathMap", agpm.a(PhotoListActivity.a(this.a)));
      paramView.putExtra("p_e_s_type", 6);
      paramView.putExtra("PasterConstants.paster_id", this.a.jdField_c_of_type_JavaLangString);
      paramView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_d_of_type_JavaLangString);
      PhotoListActivity.n = this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      if ((this.a.T) && (!PhotoListActivity.a(this.a, paramAdapterView))) {
        break;
      }
      if (PhotoListActivity.a(this.a))
      {
        paramView.putExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
        paramView.putExtra("from_qqstory_entrance", this.a.S);
      }
      if (PhotoListActivity.f(this.a))
      {
        paramView.putExtra("key_pic_to_edit_from", 3);
        paramView.putExtra("fromPhotoListPanel", PhotoListActivity.f(this.a));
        axqw.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.a.jdField_c_of_type_JavaUtilArrayList.size() + "", "", "", "");
      }
      if ((PhotoListActivity.f(this.a)) || (PhotoListActivity.e(this.a)) || (PhotoListActivity.d(this.a)) || (PhotoListActivity.h(this.a)) || (PhotoListActivity.a(this.a)))
      {
        if (!this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(paramAdapterView.path)) {
          this.a.jdField_c_of_type_JavaUtilHashMap.put(paramAdapterView.path, paramAdapterView);
        }
        paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.a.jdField_c_of_type_JavaUtilHashMap);
      }
      paramView.putExtra("PasterConstants.pasters_data", this.a.f);
      paramView.setClass(this.a, PhotoPreviewActivity.class);
      paramView.putExtra("from_qzone", PhotoListActivity.c(this.a));
      paramView.addFlags(603979776);
      if (PhotoListActivity.d(this.a)) {
        paramView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", PhotoListActivity.d(this.a));
      }
      if (this.a.X)
      {
        paramView.putExtra("FROM_ARK_CHOOSE_IMAGE", true);
        paramView.putExtra("key_ark_app_res_path", PhotoListActivity.a(this.a));
        paramView.putExtra("key_should_compress", PhotoListActivity.m(this.a));
        paramView.putExtra("key_ark_app_engine_res_dir", PhotoListActivity.b(this.a));
      }
      if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
        axqw.b(null, "CliOper", "", this.a.e, "0X8005674", "0X8005674", 0, this.a.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
      }
      if (this.a.P) {
        this.a.startActivityForResult(paramView, 100010);
      }
      for (;;)
      {
        bbbj.a(this.a, true, true);
        return;
        if (!this.a.y) {
          paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_b_of_type_JavaUtilArrayList);
        }
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
        paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.a.jdField_d_of_type_JavaUtilArrayList);
        if (bbbj.a(paramAdapterView) != 0) {
          break;
        }
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramAdapterView.position);
        break;
        if (this.a.L)
        {
          paramView.putExtra("from_health", true);
          this.a.startActivityForResult(paramView, 100010);
        }
        else if ((PhotoListActivity.n(this.a)) || (PhotoListActivity.o(this.a)) || (PhotoListActivity.p(this.a)))
        {
          PhotoListActivity.a(this.a, paramView);
        }
        else if (PhotoListActivity.q(this.a))
        {
          axqw.b(null, "CliOper", "", "", "0X800A6D9", "0X800A6D9", 0, 0, "", "", "", "");
          paramView.putExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", true);
          this.a.startActivityForResult(paramView, 100015);
        }
        else
        {
          this.a.startActivity(paramView);
          PhotoListActivity.b(this.a);
        }
      }
      if (!bbbd.a())
      {
        bcpw.a(this.a, this.a.getResources().getString(2131719044), 0).a();
        return;
      }
      paramView = this.a.jdField_a_of_type_Agnv.a(paramInt);
      if (paramView == null) {
        break;
      }
      paramAdapterView = this.a.getIntent();
      localObject1 = paramAdapterView.getStringExtra("PhotoConst.PLUGIN_APK");
      localObject2 = paramAdapterView.getStringExtra("video_refer");
      i = 0;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if ((!((String)localObject2).contains("QZonePublishMoodTabActivity")) && (!((String)localObject2).contains("QZoneUploadPhotoRealActivity"))) {
          break label1760;
        }
        i = 1;
      }
      while (i != 0)
      {
        paramLong = paramAdapterView.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", 9223372036854775807L);
        if (paramView.mDuration > paramLong)
        {
          paramAdapterView = ajyc.a(2131708082) + paramLong / 60L / 1000L + ajyc.a(2131708090);
          bcpw.a(this.a, paramAdapterView, 0).b(this.a.e());
          return;
          label1760:
          i = 0;
        }
        else
        {
          paramLong = bgxy.b();
          if (paramView.fileSize > paramLong)
          {
            bcpw.a(this.a, ajyc.a(2131708067) + (float)paramLong / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).b(this.a.e());
            return;
          }
        }
      }
      if (PhotoListActivity.a(this.a)) {
        paramAdapterView.putExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
      }
      if ((!this.a.M) && (i == 0) && (paramView.fileSize > this.a.jdField_b_of_type_Long) && (!this.a.N) && (!PhotoListActivity.g(this.a)) && (!PhotoListActivity.l(this.a)))
      {
        paramAdapterView = bbcv.a(this.a, ajyc.a(2131708114));
        paramAdapterView.setPositiveButton(2131694793, new bbdf());
        paramAdapterView.show();
        if (!this.a.H) {
          break;
        }
        paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        paramView = new Intent("key_video_size_overflow");
        paramView.putExtra("className", paramAdapterView);
        this.a.sendBroadcast(paramView);
        return;
      }
      if (((this.a.I) || (this.a.H)) && (paramView.mDuration - this.a.jdField_c_of_type_Long > 999L))
      {
        paramAdapterView = bbcv.a(this.a, ajyc.a(2131708108));
        paramAdapterView.setPositiveButton(2131694793, new bbdf());
        paramAdapterView.show();
        paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if (!this.a.H) {
          break;
        }
        paramView = new Intent("key_video_time_overflow");
        paramView.putExtra("className", paramAdapterView);
        this.a.sendBroadcast(paramView);
        return;
      }
      localObject3 = bbbj.jdField_c_of_type_JavaUtilHashMap;
      if (!((HashMap)localObject3).containsKey(paramView.path))
      {
        localObject4 = new Pair(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString);
        ((HashMap)localObject3).put(paramView.path, localObject4);
      }
      this.a.b(paramView.path);
      if (("cover_mall_record_video".equals(localObject2)) && (paramView.mDuration / 1000L > this.a.jdField_d_of_type_Long / 1000L))
      {
        paramAdapterView = ajyc.a(2131708120) + this.a.jdField_d_of_type_Long / 1000L + ajyc.a(2131708068);
        bcpw.a(this.a, paramAdapterView, 0).b(this.a.e());
        QLog.i("PhotoListActivity", 1, "QQToast:" + paramAdapterView);
        return;
      }
      if (("QqMiniApp.apk".equals(localObject1)) && (paramView.mDuration > this.a.jdField_c_of_type_Long))
      {
        paramAdapterView = ajyc.a(2131708080) + this.a.jdField_c_of_type_Long / 1000L + ajyc.a(2131708107);
        bcpw.a(this.a, paramAdapterView, 0).b(this.a.e());
        return;
      }
      if (this.a.jdField_b_of_type_Boolean) {
        if ("qzone_plugin.apk".equals(localObject1))
        {
          localObject1 = paramAdapterView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          if ((localObject1 == null) || (((String)localObject1).contains("TrimVideoActivity"))) {
            break label2806;
          }
          if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() > 0))
          {
            bcpw.a(this.a, ajyc.a(2131708100), 0).a();
            this.a.g = false;
            return;
          }
          if (paramView.mDuration >= this.a.jdField_c_of_type_Long) {
            break label2677;
          }
          this.a.g = true;
        }
      }
      while (!this.a.g)
      {
        paramAdapterView.putExtra("file_send_path", paramView.path);
        paramAdapterView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
        paramAdapterView.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
        paramAdapterView.putExtra("file_send_duration", paramView.mDuration);
        paramAdapterView.putExtra("file_width", paramView.mediaWidth);
        paramAdapterView.putExtra("file_height", paramView.mediaHeight);
        paramAdapterView.putExtra("media_info", paramView);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(paramView.path);
        if (this.a.O)
        {
          this.a.e();
          agmi.a(BaseApplicationImpl.getContext()).a(new agnp(this, paramAdapterView, (ArrayList)localObject1), paramView);
          return;
          label2677:
          this.a.g = false;
          paramAdapterView = new StringBuilder();
          paramLong = this.a.jdField_c_of_type_Long / 1000L;
          if (paramLong > 60L)
          {
            paramLong /= 60L;
            if (paramLong > 60L) {
              paramAdapterView.append(paramLong / 60L).append("小时");
            }
          }
          for (;;)
          {
            paramAdapterView.append("以上的视频不可选");
            bcpw.a(this.a, paramAdapterView.toString(), 0).a();
            return;
            paramAdapterView.append(paramLong).append("分钟");
            continue;
            paramAdapterView.append(paramLong).append("秒");
          }
          label2806:
          if (PhotoListActivity.a(this.a))
          {
            this.a.g = true;
          }
          else
          {
            localObject1 = this.a;
            if (paramView.mDuration > this.a.jdField_c_of_type_Long) {}
            for (boolean bool = true;; bool = false)
            {
              ((PhotoListActivity)localObject1).g = bool;
              paramAdapterView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.a.g);
              break;
            }
            if ("qzone_plugin.apk".equals(localObject1))
            {
              localObject1 = paramAdapterView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
              if ((localObject1 != null) && (!((String)localObject1).contains("TrimVideoActivity")))
              {
                if ((this.a.h) || (paramView.mDuration > this.a.jdField_c_of_type_Long) || (PhotoListActivity.e(this.a)) || ((PhotoListActivity.d(this.a)) && (PhotoListActivity.jdField_a_of_type_Boolean)))
                {
                  this.a.g = true;
                }
                else
                {
                  this.a.g = false;
                  paramAdapterView.putExtra("support_record", false);
                  paramAdapterView.putExtra("support_trim", true);
                  paramAdapterView.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
                  paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                  paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
                  paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.q);
                }
              }
              else if (PhotoListActivity.a(this.a))
              {
                this.a.g = true;
              }
              else
              {
                localObject1 = this.a;
                if (paramView.mDuration > this.a.jdField_c_of_type_Long) {}
                for (bool = true;; bool = false)
                {
                  ((PhotoListActivity)localObject1).g = bool;
                  paramAdapterView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.a.g);
                  break;
                }
              }
            }
          }
        }
        else
        {
          if ((PhotoListActivity.r(this.a)) || (this.a.N))
          {
            this.a.e();
            agmi.a(BaseApplicationImpl.getContext()).a(new agnr(this, paramAdapterView, (ArrayList)localObject1), paramView);
            return;
          }
          PhotoUtils.a(this.a, paramAdapterView, (ArrayList)localObject1, 2, false);
          return;
        }
      }
      if (((PhotoListActivity.f(this.a)) || (PhotoListActivity.e(this.a)) || (PhotoListActivity.d(this.a)) || (PhotoListActivity.j(this.a)) || (PhotoListActivity.s(this.a)) || (PhotoListActivity.g(this.a)) || (PhotoListActivity.a(this.a))) && ((this.a.K) || (this.a.jdField_b_of_type_Boolean)))
      {
        paramView = this.a.getIntent();
        paramView.putExtra("ALBUM_NAME", this.a.jdField_a_of_type_JavaLangString);
        paramView.putExtra("ALBUM_ID", this.a.jdField_b_of_type_JavaLangString);
        paramView.putExtra("PhotoConst.IS_OVERLOAD", this.a.y);
        localObject1 = this.a.jdField_a_of_type_Agnv.a(paramInt);
        i = ((LocalMediaInfo)localObject1).position.intValue();
        paramInt = i;
        if (!this.a.y)
        {
          paramInt = i;
          if (!PhotoListActivity.jdField_a_of_type_Boolean)
          {
            paramInt = i;
            if (bbbj.a((LocalMediaInfo)localObject1) == 1)
            {
              if (this.a.jdField_b_of_type_JavaUtilArrayList == null) {
                break label3975;
              }
              this.a.jdField_b_of_type_JavaUtilArrayList.clear();
              this.a.jdField_b_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).path);
              if (this.a.jdField_c_of_type_JavaUtilArrayList == null) {
                break label3992;
              }
              this.a.jdField_c_of_type_JavaUtilArrayList.clear();
              label3445:
              this.a.jdField_c_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject1).path);
              if (this.a.jdField_d_of_type_JavaUtilArrayList == null) {
                break label4009;
              }
              this.a.jdField_d_of_type_JavaUtilArrayList.clear();
              this.a.jdField_d_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
              if (this.a.jdField_c_of_type_JavaUtilHashMap == null) {
                break label4026;
              }
              this.a.jdField_c_of_type_JavaUtilHashMap.clear();
              this.a.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
              paramInt = 0;
              paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
            }
          }
          paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_b_of_type_JavaUtilArrayList);
        }
        else
        {
          paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramInt);
          paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
          paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.a.jdField_d_of_type_JavaUtilArrayList);
          paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
          paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.a.m);
          paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
          paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.q);
          paramView.putExtra("PasterConstants.paster_id", this.a.jdField_c_of_type_JavaLangString);
          paramView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_d_of_type_JavaLangString);
          PhotoListActivity.n = this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          if (!this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(((LocalMediaInfo)localObject1).path)) {
            this.a.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
          }
          paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.a.jdField_c_of_type_JavaUtilHashMap);
          paramView.putExtra("PasterConstants.pasters_data", this.a.f);
          paramView.setClass(this.a, PhotoPreviewActivity.class);
          if (PhotoListActivity.d(this.a)) {
            paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", PhotoListActivity.d(this.a));
          }
          if (PhotoListActivity.f(this.a)) {
            paramView.putExtra("fromPhotoListPanel", PhotoListActivity.f(this.a));
          }
          if (PhotoListActivity.j(this.a)) {
            paramView.putExtra("PhotoConst.IS_FROM_TROOP_FILE_LIST", PhotoListActivity.j(this.a));
          }
          paramView.putExtra("from_qzone", PhotoListActivity.c(this.a));
          paramView.putExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", PhotoListActivity.g(this.a));
          paramView.addFlags(603979776);
          if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
            axqw.b(null, "CliOper", "", this.a.e, "0X8005674", "0X8005674", 0, this.a.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
          }
          if (!PhotoListActivity.a(this.a)) {
            break label4043;
          }
          this.a.startActivityForResult(paramAdapterView, 100010);
        }
        for (;;)
        {
          bbbj.a(this.a, true, true);
          return;
          this.a.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
          break;
          this.a.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
          break label3445;
          this.a.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
          break label3481;
          this.a.jdField_c_of_type_JavaUtilHashMap = new HashMap();
          break label3516;
          label4043:
          this.a.startActivity(paramView);
          PhotoListActivity.c(this.a);
        }
      }
      localObject1 = new Intent(this.a, ShortVideoPreviewActivity.class);
      ((Intent)localObject1).putExtras(paramAdapterView);
      ((Intent)localObject1).putExtra("file_send_path", paramView.path);
      ((Intent)localObject1).putExtra("file_send_size", paramView.fileSize);
      ((Intent)localObject1).putExtra("file_send_duration", paramView.mDuration);
      ((Intent)localObject1).putExtra("file_width", paramView.mediaWidth);
      ((Intent)localObject1).putExtra("file_height", paramView.mediaHeight);
      ((Intent)localObject1).putExtra("uin", this.a.jdField_j_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("uintype", this.a.l);
      ((Intent)localObject1).putExtra("file_source", "album");
      ((Intent)localObject1).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
      ((Intent)localObject1).putExtra("PhotoConst.IS_FROM_TROOP_BAR", this.a.H);
      if (this.a.M)
      {
        ((Intent)localObject1).putExtra("from_health", true);
        paramInt = ((Intent)localObject1).getIntExtra("size_before_compress", 104857600);
        i = ((Intent)localObject1).getIntExtra("duration_max", 180000);
        if ((!PhotoListActivity.c(this.a)) && ((paramView.fileSize > paramInt) || (paramView.mDuration > i)))
        {
          paramAdapterView = ajyc.a(2131708095);
          bcpw.a(this.a, paramAdapterView, 0).b(this.a.e());
          return;
        }
      }
      if (this.a.K)
      {
        ((Intent)localObject1).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
        ((Intent)localObject1).putExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
      }
      if (((PhotoListActivity.e(this.a)) || ((PhotoListActivity.d(this.a)) && (PhotoListActivity.jdField_a_of_type_Boolean) && (!PhotoListActivity.jdField_c_of_type_Boolean))) && (this.a.K)) {
        ((Intent)localObject1).putExtra("preview_only", true);
      }
      this.a.startActivityForResult((Intent)localObject1, 17);
      return;
      if (!bbbd.a())
      {
        bcpw.a(this.a, this.a.getResources().getString(2131719044), 0).a();
        return;
      }
      if (this.a.L)
      {
        paramAdapterView = new Intent();
        paramAdapterView.putStringArrayListExtra("img_list", this.a.jdField_c_of_type_JavaUtilArrayList);
        this.a.setResult(16, paramAdapterView);
        this.a.finish();
        return;
      }
      if ((PhotoListActivity.d(this.a)) || (PhotoListActivity.e(this.a)))
      {
        PhotoListActivity.d(this.a);
        return;
      }
      this.a.i();
      return;
      break label664;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnn
 * JD-Core Version:    0.7.0.1
 */