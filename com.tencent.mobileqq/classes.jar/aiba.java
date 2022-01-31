import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.1;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.2;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class aiba
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public QQAppInterface a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  String jdField_a_of_type_JavaLangString = "";
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet(30);
  private List<amnq> jdField_a_of_type_JavaUtilList;
  public int b;
  private HashSet<Long> b;
  private int c;
  private int d;
  private int e;
  
  public aiba(Context paramContext, List<amnq> paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, ListView paramListView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844408);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, long paramLong, String paramString)
  {
    String str = String.valueOf(paramLong);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(str);
    if ((!this.jdField_b_of_type_JavaUtilHashSet.contains(Long.valueOf(paramLong))) && (localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      this.jdField_b_of_type_JavaUtilHashSet.add(Long.valueOf(paramLong));
      ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a((int)paramLong, 30);
    }
    if ((str != null) && (bgnc.jdField_a_of_type_JavaLangString.equals(str)))
    {
      c(paramRedTouch);
      return;
    }
    if (String.valueOf(msg.jdField_a_of_type_Int).equals(str))
    {
      b(paramRedTouch);
      return;
    }
    if (bbfu.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      bbfu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRedTouch);
      return;
    }
    if (7759L == paramLong)
    {
      d(paramRedTouch);
      return;
    }
    if (7719L == paramLong)
    {
      a(paramRedTouch);
      return;
    }
    if (7720L == paramLong)
    {
      b(paramRedTouch, str, paramString);
      return;
    }
    paramRedTouch.a(localAppInfo);
    ThreadManager.post(new LebaListViewAdapter.1(this, paramString, localAppInfo), 2, null, true);
  }
  
  private void a(RedTouch paramRedTouch, String paramString1, String paramString2)
  {
    Object localObject2 = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject2 != null)
    {
      paramString2 = ((auqh)localObject2).a(paramString1);
      if (paramString2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaListViewAdapter", 2, "updateKuolieRedTouch() kuolie appInfo.buffer: " + paramString2.buffer.get());
        }
        Object localObject1 = paramString2.red_display_info.red_type_info.get();
        if (((List)localObject1).size() > 0)
        {
          paramString1 = null;
          localObject2 = ((auqh)localObject2).a(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("LebaListViewAdapter", 2, "updateKuolieRedTouch() kuolie appInfo bufferExtParam: " + localObject2);
          }
          if (localObject2 != null) {
            paramString1 = ((JSONObject)localObject2).optString("_red_ext_uin");
          }
          if (!TextUtils.isEmpty(paramString1))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject1).next();
              if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() == 3) {
                try
                {
                  JSONObject localJSONObject = new JSONObject(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get());
                  localJSONObject.put("uin", paramString1);
                  ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set(localJSONObject.toString());
                }
                catch (Throwable localThrowable)
                {
                  QLog.e("LebaListViewAdapter", 1, "updateKuolieRedTouch()  modify image reddot red_desc JSONException ", localThrowable);
                }
              }
            }
          }
        }
      }
      paramRedTouch.a(paramString2);
    }
  }
  
  private void a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (!paramString.equals("com.tx.xingqubuluo.android"))) {
      return;
    }
    if (!TextUtils.isEmpty(paramAppInfo.icon_url.get())) {}
    for (int i = 1;; i = 2)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "dynamic", "exp_tribe", 0, 0, i + "", "", "", "");
      return;
    }
  }
  
  private void b(RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    Object localObject1 = (mmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70);
    oidb_0x791.RedDotInfo localRedDotInfo = ((mmy)localObject1).a();
    if (localRedDotInfo == null)
    {
      paramRedTouch.b();
      return;
    }
    urp.a("dynamic", "exp_story", 0, ((mmy)localObject1).b(), new String[0]);
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    int i;
    switch (localRedDotInfo.uint32_appid.get())
    {
    default: 
      i = -1;
    case 11: 
    case 37: 
    case 8: 
    case 35: 
      label134:
      while (i != -1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "更新动态红点:" + mmy.a(localRedDotInfo));
        }
        localRedTypeInfo.red_type.set(i);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localRedTypeInfo);
        return;
        localRedTypeInfo.red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8() + "");
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        i = 4;
        continue;
        localObject1 = "New";
        try
        {
          String str2 = new JSONObject(localRedDotInfo.str_custom_buffer.get().toStringUtf8()).getString("red_word");
          localObject1 = str2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            urk.d("LebaListViewAdapter", "tag red dot json parse error , %s", new Object[] { localException.getMessage() });
          }
        }
        localRedTypeInfo.red_content.set((String)localObject1);
        localRedTypeInfo.red_desc.set("{'cn':'#00000000' ,'cr':'#777777'}");
        i = 4;
        continue;
        i = 0;
        continue;
        localObject1 = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label447;
        }
        try
        {
          long l = new JSONObject((String)localObject1).optLong("image_red_display_780", 1L);
          urk.e("LebaListViewAdapter", "updateStoryRedTouch() APPID_STORY_IMG: red display=%d", new Object[] { Long.valueOf(l) });
          if (l != 0L) {
            break label455;
          }
          paramRedTouch.b();
          i = -1;
        }
        catch (JSONException localJSONException)
        {
          urk.c("LebaListViewAdapter", "updateStoryRedTouch() APPID_STORY_IMG: Error parse json: ", localJSONException);
          i = -1;
        }
      }
      label447:
      urk.b("LebaListViewAdapter", "updateStoryRedTouch() APPID_STORY_IMG: str_custom_buffer is null");
      label455:
      i = localRedDotInfo.uint32_cmd_uin_type.get();
      if (i == 0)
      {
        localObject2 = localRedDotInfo.str_face_url.get().toStringUtf8();
        str1 = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { localRedDotInfo.uint64_cmd_uin.get() + "" });
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          str1 = "{'av':1, 'dot':1}";
          localRedTypeInfo.red_content.set((String)localObject2);
        }
        localRedTypeInfo.red_desc.set(str1);
      }
      for (;;)
      {
        i = 3;
        break label134;
        if (i != 1) {
          break;
        }
        str1 = "https://p.qlogo.cn/gh/" + localRedDotInfo.uint64_cmd_uin.get() + "/" + localRedDotInfo.uint64_cmd_uin.get() + "/100?t=" + mmy.c;
        localRedTypeInfo.red_content.set(str1);
        localRedTypeInfo.red_desc.set("{'av':1, 'dot':1}");
      }
    }
    Object localObject2 = localRedTypeInfo.red_content;
    if (localRedDotInfo.uint32_number.get() > 99) {}
    for (String str1 = "99+";; str1 = localRedDotInfo.uint32_number.get() + "")
    {
      ((PBStringField)localObject2).set(str1);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      i = 4;
      break;
    }
  }
  
  private void b(RedTouch paramRedTouch, String paramString1, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new LebaListViewAdapter.2(this, paramRedTouch, paramString1, paramString2));
  }
  
  private void c(RedTouch paramRedTouch)
  {
    Object localObject;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = (ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(96);
      if (localObject != null)
      {
        localRedTypeInfo = ((ReadInJoyManager)localObject).a();
        localAppInfo = ((ReadInJoyManager)localObject).a();
        localObject = ((ReadInJoyManager)localObject).a();
      }
    }
    int i;
    switch (((bgnc)localObject).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      i = ((bgnc)localObject).jdField_b_of_type_Int;
      if (i > 99) {
        localRedTypeInfo.red_content.set("99+");
      }
      for (;;)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localAppInfo);
        return;
        localRedTypeInfo.red_content.set(i + "");
      }
    case 3: 
      localRedTypeInfo.red_type.set(3);
      i = ((bgnc)localObject).c;
      localRedTypeInfo.red_desc.set("{'drawable':" + i + "}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    case 2: 
      localObject = ((bgnc)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set((String)localObject + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#777777'}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set(azvv.a(this.jdField_a_of_type_AndroidContentContext, 3.0F) + "");
      localRedTypeInfo.red_desc.set("");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    case 4: 
      localObject = ((bgnc)localObject).jdField_b_of_type_JavaLangString;
      localRedTypeInfo.red_content.set((String)localObject + "");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#FF0000'}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    }
    paramRedTouch.b();
  }
  
  private void d(RedTouch paramRedTouch)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!alxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "redpoint_leba_show")) {
        break label340;
      }
      localObject = ((alxy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
      if (localObject == null) {
        break label248;
      }
      localObject = ((alxu)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      localRedTypeInfo.red_content.set((String)localObject);
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cn':'#00000000','cr':'#888888'}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
      localAppInfo.red_display_info.red_type_info.add((MessageMicro)localObject);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      try
      {
        paramRedTouch = (TextView)paramRedTouch.findViewById(30);
        localObject = (LinearLayout.LayoutParams)paramRedTouch.getLayoutParams();
        paramRedTouch.setMaxWidth(aciy.a(200.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject).width = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = aciy.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramRedTouch.setEllipsize(TextUtils.TruncateAt.END);
        paramRedTouch.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        label248:
        localObject = "";
      }
      catch (Exception paramRedTouch)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("LebaListViewAdapter", 2, paramRedTouch.getMessage(), paramRedTouch);
        return;
      }
    }
    Object localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
    ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
    ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
    localAppInfo.red_display_info.red_type_info.add((MessageMicro)localObject);
    localAppInfo.iNewFlag.set(1);
    paramRedTouch.a(localAppInfo);
    return;
    label340:
    paramRedTouch.b();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((View)localObject).getTag(-1) != null) && ((((View)localObject).getTag(-1) instanceof Integer)))
          {
            if (((Integer)((View)localObject).getTag(-1)).intValue() == 0)
            {
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
              }
            }
            else
            {
              int j = ((Integer)((View)localObject).getTag(-1)).intValue();
              if ((j == this.jdField_a_of_type_JavaUtilList.size() - 1) && (j >= 0)) {
                localObject = (amnq)this.jdField_a_of_type_JavaUtilList.get(j);
              }
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof aibb)))
          {
            localObject = (aibb)((View)localObject).getTag();
            if ((localObject != null) && (((aibb)localObject).jdField_a_of_type_Amnq != null) && (((aibb)localObject).jdField_a_of_type_Amnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
            {
              long l = ((aibb)localObject).jdField_a_of_type_Amnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
              }
            }
          }
        }
      }
    }
  }
  
  public void a(atay paramatay, RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    this.jdField_b_of_type_Int = paramatay.d;
    this.e = paramatay.c;
    Object localObject;
    switch (paramatay.jdField_a_of_type_Int)
    {
    case 1: 
    case 2: 
    case 4: 
    default: 
      paramRedTouch.a(null);
      return;
    case 3: 
      paramatay = (String)paramatay.jdField_a_of_type_JavaUtilList.get(0);
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(3);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set(paramatay);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("{'av':1, 'dot':1}");
      paramRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      return;
    case 5: 
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(5);
      localObject = paramatay.jdField_b_of_type_Int + "";
      if (paramatay.jdField_b_of_type_Int > 99) {
        localObject = "99+";
      }
      localRedTypeInfo.red_content.set((String)localObject);
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      paramRedTouch.a(localRedTypeInfo);
      return;
    }
    paramatay = new BusinessInfoCheckUpdate.RedTypeInfo();
    paramatay.red_type.set(0);
    paramatay.red_content.set("");
    paramatay.red_desc.set("");
    paramRedTouch.a(paramatay);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(RedTouch paramRedTouch)
  {
    ThreadManager.post(new LebaListViewAdapter.3(this, new Handler(), paramRedTouch), 8, null, true);
  }
  
  public void a(List<amnq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(amnq paramamnq)
  {
    return !TextUtils.isEmpty(paramamnq.jdField_a_of_type_JavaLangString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((Long)localIterator.next());
        if (localIterator.hasNext()) {
          localStringBuilder.append(";");
        }
      }
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", localStringBuilder.toString(), "");
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void c()
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return null;
    }
    return (amnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    if (TextUtils.isEmpty(((amnq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (getItem(paramInt) == null)
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    amnq localamnq = (amnq)getItem(paramInt);
    int j = getItemViewType(paramInt);
    label155:
    Object localObject;
    if (j == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.c, null);
        paramViewGroup = new aibb(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131303416));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303477));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)paramView.findViewById(2131303476));
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(beog.c);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297253));
        paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).c(36).a();
        paramView.setTag(paramViewGroup);
        if ((localamnq != null) && (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101267));
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if ((localamnq == null) || (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (TextUtils.isEmpty(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
          break label612;
        }
        if (TextUtils.isEmpty(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL)) {
          break label598;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aciy.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable((Drawable)localObject);
        label348:
        paramViewGroup.jdField_a_of_type_Amnq = localamnq;
        if ((localamnq != null) && (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null))
        {
          a((RedTouch)paramView, localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName);
          if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId))) {
            this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId));
          }
        }
        if ((AppSetting.c) && (localamnq != null) && (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (!TextUtils.isEmpty(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName))) {
          azve.a(paramView, localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName, Button.class.getName());
        }
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
      }
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localamnq != null) && (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo != null) && (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId == 770L) && (paramViewGroup != null)) {
        paramViewGroup.d();
      }
      paramViewGroup = paramView;
      if (paramInt != 0) {
        break;
      }
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
      return paramView;
      paramViewGroup = (aibb)paramView.getTag();
      break label155;
      label598:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label348;
      label612:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      break label348;
      if (j == 1)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.d, null);
        }
        boolean bool = awnu.b();
        ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        localObject = paramViewGroup.findViewById(2131299132);
        paramView = paramViewGroup;
        if (localObject != null)
        {
          j = aciy.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramView = ((View)localObject).getLayoutParams();
          if (bool) {}
          for (;;)
          {
            paramView.height = i;
            paramView = paramViewGroup;
            break;
            i = j;
          }
        }
      }
      else
      {
        paramView = null;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!a((amnq)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiba
 * JD-Core Version:    0.7.0.1
 */