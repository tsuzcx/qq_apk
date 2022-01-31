import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher.1;
import com.tencent.mobileqq.addon.DiyPendantFetcher.2;
import com.tencent.mobileqq.addon.DiyPendantFetcher.3;
import com.tencent.mobileqq.addon.DiyPendantFetcher.4;
import com.tencent.mobileqq.addon.DiyPendantFetcher.5;
import com.tencent.mobileqq.addon.DiyPendantFetcher.6;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class akmx
{
  public static volatile long a;
  public static akmx a;
  public static boolean a;
  public final int a;
  public ETEngine a;
  public final LRULinkedHashMap<String, DiyPendantEntity> a;
  public final Runnable a;
  public final CopyOnWriteArrayList<akmy> a;
  public final CopyOnWriteArraySet<String> a;
  AtomicBoolean a;
  public final LRULinkedHashMap<Integer, fw> b;
  public final CopyOnWriteArraySet<String> b;
  public final LRULinkedHashMap<String, Bitmap> c = new LRULinkedHashMap(10);
  
  private akmx()
  {
    this.jdField_a_of_type_Int = 64;
    this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(64);
    this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(16);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangRunnable = new DiyPendantFetcher.1(this);
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForDiyPendant();
  }
  
  public static akmx a()
  {
    if (jdField_a_of_type_Akmx == null) {}
    try
    {
      if (jdField_a_of_type_Akmx == null) {
        jdField_a_of_type_Akmx = new akmx();
      }
      return jdField_a_of_type_Akmx;
    }
    finally {}
  }
  
  private void c(String paramString)
  {
    Object localObject2 = paramString.split("_");
    if (localObject2.length == 3)
    {
      Object localObject1 = localObject2[2];
      localObject2 = localObject2[1];
      if (BaseApplicationImpl.sImageCache.get(paramString) == null)
      {
        localObject1 = new File(bdfp.c((String)localObject1));
        if (((File)localObject1).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.i("DiyPendantFetcher", 2, "decode and put scale bitmap into BaseApplicationImpl.sImageCache, " + ((File)localObject1).getAbsolutePath());
          }
          localObject1 = bdal.a(((File)localObject1).getAbsolutePath());
          if (localObject1 != null)
          {
            BaseApplicationImpl.sImageCache.put(paramString, localObject1);
            this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString);
          }
        }
      }
    }
  }
  
  public Bitmap a(akmu paramakmu, int paramInt)
  {
    if ((paramakmu == null) || (TextUtils.isEmpty(paramakmu.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(paramakmu.jdField_a_of_type_JavaLangString))
    {
      Object localObject = (DiyPendantEntity)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramakmu.jdField_a_of_type_JavaLangString);
      if (((DiyPendantEntity)localObject).getStickerInfoList().size() > paramInt)
      {
        localObject = a((DiyPendantSticker)((DiyPendantEntity)localObject).getStickerInfoList().get(paramInt));
        Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject);
        if (localBitmap != null)
        {
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localObject);
          return localBitmap;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "can not found bitmap cache in BaseApplicationImpl.sImageCache! " + (String)localObject);
        }
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "fetchDiyPaster: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramakmu);
      paramakmu = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramakmu instanceof QQAppInterface)) {
        a((QQAppInterface)paramakmu, 500);
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "can not found cache in DiyPendantCache! " + paramakmu.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramakmu.jdField_a_of_type_JavaLangString);
    }
  }
  
  public Bitmap a(akmy paramakmy, String paramString, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0)) {
      return null;
    }
    String str = paramString + "_" + paramInt1 + "_" + paramInt2 + "_" + paramFloat + "_" + paramInt3 + "_" + paramInt4 + "_" + paramInt5;
    if (this.c.containsKey(str)) {
      return (Bitmap)this.c.get(str);
    }
    synchronized (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        a();
      }
      if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (TextUtils.isEmpty(paramString)))
      {
        QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail EnigeReady = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " text = " + paramString);
        return null;
      }
    }
    Object localObject = bdfp.a(String.valueOf(paramInt1));
    if (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isFontLoaded(paramInt1))
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramakmy);
      if (bdfp.a(String.valueOf(paramInt1)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "found font res but can not load the font, font id = " + paramInt1);
        }
        ThreadManager.executeOnFileThread(new DiyPendantFetcher.3(this, (String)localObject, paramInt1));
      }
      for (;;)
      {
        QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail font not exist!");
        return null;
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "can not found font res! font id = " + paramInt1);
        }
        a(paramInt1, paramInt2);
      }
    }
    paramakmy = new ETFont(paramInt1, (String)localObject, paramFloat);
    paramakmy.setColor(paramInt3);
    try
    {
      localObject = Bitmap.createBitmap(paramInt4, paramInt5, Bitmap.Config.ARGB_8888);
      if (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isPaintableChar(paramString.charAt(0), paramakmy)) {
        break label590;
      }
      for (paramInt1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_spaceMeasureText(paramString, 0, paramString.length(), paramakmy, paramPaint); paramInt1 > paramInt4; paramInt1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_spaceMeasureText(paramString, 0, paramString.length(), paramakmy, paramPaint)) {
        paramakmy.mFontSize -= 1;
      }
      paramInt2 = (paramInt4 - paramInt1) / 2;
    }
    catch (OutOfMemoryError paramakmy)
    {
      QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont Bitmap.createBitmap OutOfMemoryError: " + paramakmy.getMessage());
      return null;
    }
    paramInt1 = 0;
    paramPaint = new Paint.FontMetrics();
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_getFontMetrics(paramPaint, paramakmy))
    {
      paramFloat = paramPaint.bottom;
      float f = paramPaint.top;
      paramInt1 = (int)((paramInt5 - (paramFloat - f)) / 2.0F);
    }
    if (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_drawText(paramString, (Bitmap)localObject, paramInt2, paramInt1, paramakmy))
    {
      QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail font not support: " + paramString.charAt(0));
      return null;
    }
    label590:
    if (localObject != null) {
      this.c.put(str, localObject);
    }
    return localObject;
  }
  
  public Typeface a(akmy paramakmy, int paramInt1, int paramInt2)
  {
    if ((paramakmy == null) || (paramInt1 <= 0)) {
      return null;
    }
    fw localfw = (fw)this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(Integer.valueOf(paramInt1));
    if ((localfw != null) && (localfw.jdField_a_of_type_AndroidGraphicsTypeface != null)) {
      return localfw.jdField_a_of_type_AndroidGraphicsTypeface;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "can not found typeface in the cache! font id = " + paramInt1);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramakmy);
    a(paramInt1, paramInt2);
    return null;
  }
  
  public DiyPendantEntity a(QQAppInterface paramQQAppInterface, String paramString, alpg paramalpg)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      if (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(paramString))
      {
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString));
        if (paramalpg != null) {
          paramalpg.onUpdate(1, true, paramQQAppInterface);
        }
        return (DiyPendantEntity)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
      }
      localObject = (DiyPendantEntity)paramQQAppInterface.getEntityManagerFactory().createEntityManager().a(DiyPendantEntity.class, " uinAndDiyId=? ", new String[] { paramString });
      if (localObject == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "query diy pendant from database, uinAndDiyId: " + paramString);
      }
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString, localObject);
      paramString = new ArrayList();
      paramString.add(localObject);
      paramQQAppInterface = (QQAppInterface)localObject;
    } while (paramalpg == null);
    paramalpg.onUpdate(1, true, paramString);
    return localObject;
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "start request diy id " + paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
    Object localObject = new ArrayList();
    ((List)localObject).add(Long.valueOf(Long.parseLong(paramString.split("_")[0])));
    ((akmz)paramQQAppInterface.a(114)).a((List)localObject, paramalpg);
    return null;
  }
  
  public String a(DiyPendantSticker paramDiyPendantSticker)
  {
    return "DiyPendantFetcher_" + paramDiyPendantSticker.type + "_" + paramDiyPendantSticker.stickerId;
  }
  
  public List<DiyPendantSticker> a(akmu paramakmu)
  {
    if ((paramakmu == null) || (TextUtils.isEmpty(paramakmu.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(paramakmu.jdField_a_of_type_JavaLangString)) {
      return ((DiyPendantEntity)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramakmu.jdField_a_of_type_JavaLangString)).getStickerInfoList();
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "can not found cache in DiyPendantCache! " + paramakmu.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramakmu.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "fetchDiyBaseInfo: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramakmu);
    paramakmu = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramakmu instanceof QQAppInterface)) {
      a((QQAppInterface)paramakmu, 500);
    }
    return null;
  }
  
  void a()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(16, 1048576))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("DiyPendantFetcher", 2, "DIY Pendant init Font Engine time = " + (l2 - l1) + "ms");
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineInited.compareAndSet(false, true)) {
          gf.c();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        QLog.d("DiyPendantFetcher", 1, "vip font not downloaded, start early download.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      QLog.e("DiyPendantFetcher", 1, "initETEngine Exception:" + localThrowable.getMessage());
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    String str = bdfp.a(String.valueOf(paramInt1));
    if (!this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      fw localfw = new fw(paramInt1, str);
      localfw.b = paramInt2;
      this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.put(Integer.valueOf(paramInt1), localfw);
    }
    ThreadManager.executeOnFileThread(new DiyPendantFetcher.4(this, paramInt1, str));
  }
  
  public void a(DiyPendantEntity paramDiyPendantEntity)
  {
    paramDiyPendantEntity = paramDiyPendantEntity.getStickerInfoList().iterator();
    while (paramDiyPendantEntity.hasNext())
    {
      String str = a((DiyPendantSticker)paramDiyPendantEntity.next());
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(str)) {
        c(str);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      b(paramQQAppInterface);
    } while ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()));
    ThreadManager.post(new DiyPendantFetcher.2(this, paramQQAppInterface), 5, null, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()));
      if (paramInt <= 0)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        a(paramQQAppInterface);
        return;
      }
    } while (System.currentTimeMillis() <= jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "postLoadPendantDiy delay:  " + paramInt);
    }
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
    jdField_a_of_type_Long = System.currentTimeMillis() + paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List<DiyPendantEntity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    alto localalto = (alto)paramQQAppInterface.getManager(51);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)paramList.next();
      if (paramBoolean)
      {
        paramQQAppInterface.getEntityManagerFactory().createEntityManager().b(localDiyPendantEntity);
        ExtensionInfo localExtensionInfo = localalto.a(localDiyPendantEntity.uinAndDiyId.split("_")[0]);
        if ((localExtensionInfo != null) && (localExtensionInfo.pendantDiyId != localDiyPendantEntity.diyId))
        {
          localExtensionInfo.pendantDiyId = localDiyPendantEntity.diyId;
          localArrayList.add(localExtensionInfo);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localDiyPendantEntity.uinAndDiyId);
      this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localDiyPendantEntity.uinAndDiyId, localDiyPendantEntity);
      a(localDiyPendantEntity);
    }
    localalto.b(localArrayList);
    d();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "notifyPasterDownloadComplete " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString)) {
        c(paramString);
      }
      d();
    }
  }
  
  public void b()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    VasQuickUpdateManager localVasQuickUpdateManager;
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      c();
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) {
        break label222;
      }
      localVasQuickUpdateManager = (VasQuickUpdateManager)((AppRuntime)localObject1).getManager(184);
      localObject2 = null;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        String[] arrayOfString = ((String)localIterator.next()).split("_");
        if (arrayOfString.length != 3) {
          break label238;
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new String[this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size()];
        }
        localObject2 = arrayOfString[2];
        int j = i + 1;
        localObject1[i] = ("faceAddon.sticker." + (String)localObject2 + ".png");
        i = j;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "now download from VasQuickUpdateManager list: " + TextUtils.join(",", (Object[])localObject2));
        }
        localVasQuickUpdateManager.downloadGatherItem(4L, localObject2[0], (String[])localObject2, "DiyPendantFetcher");
      }
      label222:
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("DiyPendantFetcher", 2, "all paster has decode!");
      return;
      label238:
      localObject1 = localObject2;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ThreadManager.post(new DiyPendantFetcher.5(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "notifyFontDownloadComplete, scid =" + paramString);
    }
    fw localfw;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace("faceAddon.stickerFont.android.", "");
      localfw = (fw)this.jdField_b_of_type_ComTencentUtilLRULinkedHashMap.get(Integer.valueOf(Integer.parseInt(paramString)));
      if (localfw != null)
      {
        if (localfw.b != 1) {
          break label128;
        }
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          a();
        }
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(localfw.jdField_a_of_type_JavaLangString, Integer.parseInt(paramString), true))) {
          d();
        }
      }
    }
    label128:
    while (!new File(localfw.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
    localfw.jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localfw.jdField_a_of_type_JavaLangString);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        c((String)localIterator.next());
      }
      d();
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "mUnCacheDiyId size is 0!");
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
      int j = ((ArrayList)localObject1).size();
      Object localObject2 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      int i = 0;
      while (i < j)
      {
        DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)((awgf)localObject2).a(DiyPendantEntity.class, (String)((ArrayList)localObject1).get(i));
        if (localDiyPendantEntity != null) {
          localArrayList.add(localDiyPendantEntity);
        }
        i += 1;
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DiyPendantEntity)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(((DiyPendantEntity)localObject2).uinAndDiyId);
      }
    } while (localArrayList.isEmpty());
    a(paramQQAppInterface, false, localArrayList);
  }
  
  @TargetApi(11)
  public void d()
  {
    ThreadManager.getUIHandler().post(new DiyPendantFetcher.6(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akmx
 * JD-Core Version:    0.7.0.1
 */