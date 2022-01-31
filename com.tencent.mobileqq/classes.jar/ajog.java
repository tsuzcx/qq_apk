import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.opengl.GLES20;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ajog
{
  private static ajog jdField_a_of_type_Ajog;
  public static final String a;
  public static final String b;
  private static boolean jdField_b_of_type_Boolean;
  public static final String c;
  private static final String d = ajni.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "beauty" + File.separator;
  private static final String e = d + "SKINCOLOR" + File.separator;
  private int jdField_a_of_type_Int;
  private ajok jdField_a_of_type_Ajok;
  private FilterRender jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private ArrayList<FilterDesc> jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = { -1 };
  private int jdField_b_of_type_Int;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajni.jdField_a_of_type_JavaLangString + "/qsvf" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "res" + File.separator;
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "artfilter" + File.separator;
  }
  
  private ajog()
  {
    this.jdField_c_of_type_Int = -1;
    GraphicRenderMgr.loadSo();
    String str = bdcb.h() + " " + bdcb.d();
    QLog.i("VideoFilterTools", 2, "DeviceInfo " + str);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_version", 0);
    if ((j > 0) && (!new File(jdField_a_of_type_JavaLangString + "filter_config.xml").exists())) {
      lek.c("VideoFilterTools", "getQQShortVideoFilterConfigVersion config file don't exist!");
    }
    for (;;)
    {
      lek.c("VideoFilterTools", "getQQShortVideoFilterConfigVersion:" + i);
      return i;
      i = j;
    }
  }
  
  public static ajog a()
  {
    if (jdField_a_of_type_Ajog == null) {
      jdField_a_of_type_Ajog = new ajog();
    }
    return jdField_a_of_type_Ajog;
  }
  
  private static ajol a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      lek.c("VideoFilterTools", "parseConfig|content is empty.");
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      }
      catch (JSONException localJSONException3)
      {
        JSONObject localJSONObject;
        int i;
        String str1;
        String str2;
        localajol = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        localajol = new ajol(i, str1, str2);
        try
        {
          lek.c("VideoFilterTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return localajol;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        localajol = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        lek.c("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
        return localajol;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        lek.c("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
        return localajol;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "filter_config.xml");
      lek.c("VideoFilterTools", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "filter_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return bdcs.b(localFile);
      }
      a(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_first_launch", 1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    lek.c("VideoFilterTools", "setQQShortVideoFilterConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_video_filter_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null)
    {
      lek.c("VideoFilterTools", "updateQQShortVideoFilterConfig error ");
      return;
    }
    a(paramContext, paramString, a(paramContext));
    bdcs.a(jdField_a_of_type_JavaLangString, "filter_config.xml", paramString);
    a(paramContext, paramInt);
  }
  
  static void a(Context paramContext, String paramString1, String paramString2)
  {
    Iterator localIterator = null;
    long l1 = System.currentTimeMillis();
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      paramContext = new ArrayList();
      a(paramString1, paramContext);
    }
    for (;;)
    {
      if ((paramString2 != null) && (!paramString2.equals("")))
      {
        paramString1 = new ArrayList();
        a(paramString2, paramString1);
        if (paramContext != null) {
          break label136;
        }
        bdcs.a(jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        long l2 = System.currentTimeMillis();
        lek.c("VideoFilterTools", "compareContent :" + (l2 - l1));
        return;
        paramString1 = localIterator;
        if (!new File(jdField_b_of_type_JavaLangString).exists()) {
          break;
        }
        bdcs.a(jdField_b_of_type_JavaLangString);
        paramString1 = localIterator;
        break;
        label136:
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (FilterDesc)paramString1.next();
            localIterator = paramContext.iterator();
            while (localIterator.hasNext())
            {
              FilterDesc localFilterDesc = (FilterDesc)localIterator.next();
              if ((localFilterDesc.name != null) && (localFilterDesc.name.equals(paramString2.name)))
              {
                lek.c("VideoFilterTools", "compareContent res:" + localFilterDesc.name + "|" + localFilterDesc.resMD5 + "|" + paramString2.resMD5);
                if ((localFilterDesc.resMD5 != null) && (!localFilterDesc.resMD5.equals(paramString2.resMD5))) {
                  bdcs.a(paramString2.getResFold(jdField_b_of_type_JavaLangString));
                }
                lek.c("VideoFilterTools", "compareContent iconMD5:" + localFilterDesc.name + "|" + localFilterDesc.iconMD5 + "|" + paramString2.iconMD5);
                if ((localFilterDesc.iconMD5 != null) && (!localFilterDesc.iconMD5.equals(paramString2.iconMD5))) {
                  bdcs.d(paramString2.getIconFile(jdField_b_of_type_JavaLangString));
                }
              }
            }
          }
        }
      }
      paramContext = null;
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      lek.c("VideoFilterTools", "handleQQSvCommonConfig empty content!");
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = new JSONObject(paramString).getJSONObject("CommonConfig");
          if (paramString.getJSONObject("SvArtFilter") != null)
          {
            QmcfManager.getInstance().updateQmcfMainSwitch(paramString.getJSONObject("SvArtFilter"));
            return;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterTools", 2, "handleQQSvCommonConfig error!", paramString);
  }
  
  static void a(String paramString, List<FilterDesc> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      lek.c("VideoFilterTools", "parseConfig|content is empty.");
    }
    for (;;)
    {
      return;
      paramList.clear();
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("content");
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          try
          {
            int j = Integer.valueOf(localJSONObject.getString("type")).intValue();
            int k = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
            int m = Integer.valueOf(localJSONObject.getString("subid")).intValue();
            int n = Integer.valueOf(localJSONObject.getString("predownload")).intValue();
            String str5 = localJSONObject.getString("resurl");
            String str1 = localJSONObject.getString("md5");
            String str4 = localJSONObject.getString("iconurl");
            String str2 = localJSONObject.getString("iconmd5");
            String str3 = localJSONObject.getString("name");
            str5 = amsl.a(str5);
            str4 = amsl.a(str4);
            paramList.add(new FilterDesc(k, m, n, str5, str1, str4, str2, str3, j));
            lek.c("VideoFilterTools", "parseConfig:" + k + "|" + m + "|" + n + "|" + str5 + "|" + str1 + "|" + str4 + "|" + str2 + "|" + str3);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              lek.c("VideoFilterTools", "parseConfig failed. info = " + localJSONObject);
            }
          }
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
        lek.c("VideoFilterTools", "parseConfig|parse failed.context = " + paramString);
      }
    }
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = bdcb.a();
    if (i < paramInt2)
    {
      lek.c("VideoFilterTools", "isSupportOfDevice error OSversion: " + i);
      return false;
    }
    paramInt2 = lnz.e();
    if (paramInt2 < paramInt1)
    {
      lek.c("VideoFilterTools", "isSupportOfDevice error cpucount: " + paramInt2);
      return false;
    }
    long l = lnz.d();
    if (l < paramLong1)
    {
      lek.c("VideoFilterTools", "isSupportOfDevice error cpuFrequency: " + l);
      return false;
    }
    paramLong1 = bdcb.d();
    if (paramLong1 < paramLong2)
    {
      lek.c("VideoFilterTools", "isSupportOfDevice error memory: " + paramLong1);
      return false;
    }
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    if (jdField_b_of_type_Boolean) {
      return true;
    }
    if (!a(4, 1350000L, 1073741824L, 17)) {
      return false;
    }
    if ((paramContext != null) && (TextUtils.isEmpty(a(paramContext)))) {
      return false;
    }
    jdField_b_of_type_Boolean = true;
    return jdField_b_of_type_Boolean;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      File localFile = new File(d + "beauty_config.json");
      lek.c("VideoFilterTools", "getVideoEffectBeautyConfig:" + d + "beauty_config.json" + "|" + localFile.exists());
      if (localFile.exists()) {
        return bdcs.b(localFile);
      }
      b(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void b(Context paramContext)
  {
    try
    {
      if (b(paramContext))
      {
        a(paramContext);
        if (new File(e).exists()) {
          bdcs.a(e);
        }
      }
      paramContext = a(b(paramContext));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(e + "params.json");
        lek.c("VideoFilterTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new baps();
          ((baps)localObject).jdField_a_of_type_Bapx = new ajoi();
          ((baps)localObject).jdField_a_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
          ((baps)localObject).jdField_a_of_type_Int = 0;
          ((baps)localObject).jdField_c_of_type_JavaLangString = (d + "skin_color.zip");
          ((baps)localObject).a(paramContext);
          lel.a().a((baqv)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    lek.c("VideoFilterTools", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean b()
  {
    return (new File(e + "params.json").exists()) && (new File(d + "beauty_config.json").exists());
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_video_filter_config_first_launch", 0);
    lek.c("VideoFilterTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public FilterRender a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Int != paramInt1) || (this.jdField_b_of_type_Int != paramInt2))
    {
      lek.c("VideoFilterTools", "getFilter|init texture.");
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (this.jdField_c_of_type_Int != -1) {
        this.jdField_c_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_ArrayOfInt[0] != -1) {
        this.jdField_a_of_type_ArrayOfInt[0] = -1;
      }
      GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
      this.jdField_c_of_type_Int = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_a_of_type_ArrayOfInt[0]);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      lek.c("VideoFilterTools", "getFilterRender|destroy current filterRender.");
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = new FilterRender(BaseApplicationImpl.getContext());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.setFilterPath(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.getResFold(jdField_b_of_type_JavaLangString));
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender;
  }
  
  public List<FilterDesc> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject3;
    String str1;
    boolean bool;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FilterDesc)((Iterator)localObject2).next();
        str1 = ((FilterDesc)localObject3).getIconFile(jdField_b_of_type_JavaLangString);
        bool = new File(str1).exists();
        lek.c("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
        if (bool)
        {
          str1 = ((FilterDesc)localObject3).getResFold(jdField_b_of_type_JavaLangString);
          String str2 = str1 + "params.json";
          bool = new File(str2).exists();
          lek.c("VideoFilterTools", "getFilterDescs " + str2 + " exist: " + bool);
          if ((TextUtils.isEmpty(str1)) || ((str1 != null) && (bool))) {
            localArrayList.add(localObject3);
          }
        }
      }
    }
    ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (FilterDesc)((Iterator)???).next();
      localObject3 = ((FilterDesc)localObject2).getIconFile(jdField_b_of_type_JavaLangString);
      bool = new File((String)localObject3).exists();
      lek.c("VideoFilterTools", "getFilterDescs " + (String)localObject3 + " exist: " + bool);
      if (bool)
      {
        localObject3 = ((FilterDesc)localObject2).getResFold(jdField_b_of_type_JavaLangString);
        str1 = (String)localObject3 + "params.json";
        bool = new File(str1).exists();
        lek.c("VideoFilterTools", "getFilterDescs " + str1 + " exist: " + bool);
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || ((localObject3 != null) && (bool))) {
          localList.add(localObject2);
        }
      }
    }
    return localList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ajok = null;
    if (this.jdField_c_of_type_Int != -1) {
      this.jdField_c_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_ArrayOfInt[0] != -1) {
      this.jdField_a_of_type_ArrayOfInt[0] = -1;
    }
  }
  
  public void a(Context paramContext, ajok arg2)
  {
    if (QLog.isColorLevel()) {
      com.tencent.av.video.effect.QavVideoEffect.DEBUG_MODE = true;
    }
    lek.c("VideoFilterTools", "init");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_Ajok = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      a(a(paramContext), this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_a_of_type_JavaUtilArrayList);
      lek.c("VideoFilterTools", "filter list size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = ((FilterDesc)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
      return;
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    Object localObject2 = null;
    if (paramFilterDesc != null) {
      new StringBuilder().append(paramFilterDesc.id).append("").toString();
    }
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      localStringBuilder = new StringBuilder().append("setCurrentId, id[");
      if (paramFilterDesc != null) {
        break label107;
      }
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append("->");
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
        break label118;
      }
    }
    label107:
    label118:
    for (Object localObject1 = localObject2;; localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.id))
    {
      QLog.w("VideoFilterTools", 1, localObject1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      return;
      localObject1 = Integer.valueOf(paramFilterDesc.id);
      break;
    }
  }
  
  public void a(ArrayList<FilterDesc> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (((FilterDesc)paramArrayList.next()).id == 9) {
        paramArrayList.remove();
      }
    }
  }
  
  void a(List<FilterDesc> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      lek.c("VideoFilterTools", "preDownloadResource list is empty!");
    }
    do
    {
      return;
      lek.c("VideoFilterTools", "preDownloadResource list size: " + paramList.size());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        lek.c("VideoFilterTools", "preDownloadResource predownload: " + localFilterDesc.predownload + ", iconurl: " + localFilterDesc.iconurl + ", resurl:" + localFilterDesc.resurl);
        if (localFilterDesc.predownload == 1)
        {
          Object localObject2;
          if (!TextUtils.isEmpty(localFilterDesc.iconurl))
          {
            localObject1 = localFilterDesc.getIconFile(jdField_b_of_type_JavaLangString);
            localObject2 = new File((String)localObject1);
            lek.c("VideoFilterTools", "preDownloadResource " + (String)localObject1 + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject2 = new baps();
              ((baps)localObject2).jdField_a_of_type_Bapx = new ajoj(this);
              ((baps)localObject2).jdField_a_of_type_JavaLangString = localFilterDesc.iconurl;
              ((baps)localObject2).jdField_a_of_type_Int = 0;
              ((baps)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
              ((baps)localObject2).a(localFilterDesc);
              lel.a().a((baqv)localObject2);
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
            }
          }
          Object localObject1 = localFilterDesc.getResFold(jdField_b_of_type_JavaLangString);
          if ((!TextUtils.isEmpty(localFilterDesc.resurl)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new File((String)localObject1 + "params.json");
            lek.c("VideoFilterTools", "preDownloadResource " + (String)localObject1 + "params.json" + " exist: " + ((File)localObject2).exists());
            if (!((File)localObject2).exists())
            {
              localObject1 = new baps();
              ((baps)localObject1).jdField_a_of_type_Bapx = new ajoh(this);
              ((baps)localObject1).jdField_a_of_type_JavaLangString = localFilterDesc.resurl;
              ((baps)localObject1).jdField_a_of_type_Int = 0;
              ((baps)localObject1).jdField_c_of_type_JavaLangString = (jdField_b_of_type_JavaLangString + localFilterDesc.name + ".zip");
              ((baps)localObject1).a(localFilterDesc);
              lel.a().a((baqv)localObject1);
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
            }
          }
        }
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) || (this.jdField_a_of_type_Ajok == null));
    this.jdField_a_of_type_Ajok.a(false);
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    return (i > 1) || ((i == 1) && (!((FilterDesc)this.jdField_a_of_type_JavaUtilArrayList.get(0)).isEmptyFilter()));
  }
  
  public void b()
  {
    lek.c("VideoFilterTools", "destroy");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    lek.c("VideoFilterTools", "destroy");
    if (this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectFilterFilterRender = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(Context paramContext)
  {
    if (new File(d + "beauty_config.json").exists())
    {
      if (!new File(e + "params.json").exists())
      {
        lek.c("VideoFilterTools", "!JasonFile.exists()");
        b(paramContext);
      }
      return;
    }
    lek.c("VideoFilterTools", "BEAUTY_CONFIG  is not exsit");
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.type == 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajog
 * JD-Core Version:    0.7.0.1
 */