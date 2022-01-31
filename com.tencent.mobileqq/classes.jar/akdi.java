import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.1;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.2;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.3;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager.4;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class akdi
  implements akde, akdf, Manager
{
  private long jdField_a_of_type_Long;
  private adye jdField_a_of_type_Adye;
  private akdb jdField_a_of_type_Akdb;
  private akdg jdField_a_of_type_Akdg;
  private akdj jdField_a_of_type_Akdj;
  public PeakAppInterface a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<akda> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, List<String>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap;
  private ConcurrentHashMap<String, MessageRecord> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  private volatile boolean d;
  
  public akdi()
  {
    c();
  }
  
  private long a(String paramString)
  {
    long l1 = 0L;
    long l3 = l1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label25;
      }
      l3 = l1;
    }
    label25:
    long l2;
    do
    {
      do
      {
        do
        {
          return l3;
          ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Akdb.a();
          Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          l2 = l1;
          if (localObject != null)
          {
            l2 = l1;
            if (((List)localObject).size() > 0)
            {
              localObject = ((List)localObject).iterator();
              for (;;)
              {
                l2 = l1;
                if (!((Iterator)localObject).hasNext()) {
                  break;
                }
                String str = (String)((Iterator)localObject).next();
                akdd localakdd = (akdd)localConcurrentHashMap.get(str);
                l2 = l1;
                if (localakdd != null)
                {
                  l2 = l1 + localakdd.jdField_a_of_type_Long;
                  localakdd.b += 1;
                  this.jdField_a_of_type_Akdb.a(str, localakdd);
                }
                l1 = l2;
              }
            }
          }
          l3 = l2;
        } while (this.jdField_b_of_type_JavaUtilHashMap == null);
        l3 = l2;
      } while (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString));
      l3 = l2;
    } while (((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() <= 0);
    return l2 + ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue() * 200;
  }
  
  private Pair<String, List<String>> a(String paramString, List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return new Pair(paramString, localArrayList);
    }
    Iterator localIterator = paramList.iterator();
    label327:
    label344:
    label345:
    for (;;)
    {
      int i;
      if (localIterator.hasNext())
      {
        paramList = (MessageRecord)localIterator.next();
        i = paramList.msgtype;
        if (akdl.a(i))
        {
          paramList = atmh.a(paramList);
          if ((paramList == null) || (!(paramList instanceof MessageForPic))) {
            break label327;
          }
          paramList = ((MessageForPic)paramList).getBiggestFilePath();
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(paramList)) || (localArrayList.contains(paramList))) {
          break label345;
        }
        localArrayList.add(new File(paramList).getName());
        break;
        if (akdl.b(i))
        {
          paramList = atmh.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForShortVideo)))
          {
            MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramList;
            paramList = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
            if (!TextUtils.isEmpty(paramList)) {
              break label344;
            }
            paramList = ShortVideoUtils.b(localMessageForShortVideo);
          }
        }
        else if (akdl.c(i))
        {
          paramList = atmh.a(paramList);
          if (paramList != null) {
            paramList = apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, paramList);
          }
        }
        else if (akdl.d(i))
        {
          paramList = atmh.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForMixedMsg)))
          {
            b(paramString, ((MessageForMixedMsg)paramList).getPicMsgList());
            paramList = "";
          }
        }
        else if (akdl.e(i))
        {
          paramList = atmh.a(paramList);
          if ((paramList != null) && ((paramList instanceof MessageForStructing)) && (aryb.a((MessageForStructing)paramList))) {
            b(paramString, this.jdField_a_of_type_Akdj.c(MessageRecord.class, "select * from mr_multimessage where msgseq=?", "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramList.uniseq) }));
          }
        }
        paramList = "";
        continue;
        return new Pair(paramString, localArrayList);
      }
    }
  }
  
  private Pair<Integer, List<MessageRecord>> a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof MessageForText)) {
        i += 1;
      }
      for (;;)
      {
        break;
        localArrayList.add(localMessageRecord);
      }
    }
    return new Pair(Integer.valueOf(i), localArrayList);
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    String str1 = "";
    String str2;
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      str2 = "";
      return str2;
    }
    switch (paramMessageRecord.istroop)
    {
    }
    for (;;)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      return paramMessageRecord.frienduin;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin + 0);
      continue;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessageRecord.frienduin + 1);
      continue;
      str1 = this.jdField_a_of_type_Akdj.a(paramMessageRecord.frienduin);
      continue;
      if (this.jdField_a_of_type_Adye != null)
      {
        str1 = this.jdField_a_of_type_Adye.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
        continue;
        str1 = this.jdField_a_of_type_Akdj.a(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_b_of_type_JavaUtilHashMap != null))
    {
      if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        int i = ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).intValue();
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(i + paramInt));
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000) || (paramInt == 1000) || (paramInt == 1004);
  }
  
  private boolean a(akda paramakda)
  {
    if ((paramakda == null) || (this.jdField_a_of_type_Adye == null)) {}
    String str;
    do
    {
      return true;
      str = MessageRecord.getTableName(paramakda.jdField_a_of_type_JavaLangString, paramakda.jdField_a_of_type_Int);
    } while (TextUtils.isEmpty(str));
    b(str);
    if (this.jdField_a_of_type_Adye != null) {
      this.jdField_a_of_type_Adye.b(paramakda.jdField_a_of_type_JavaLangString, paramakda.jdField_a_of_type_Int);
    }
    a(str);
    return true;
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null))
    {
      Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramString = new ArrayList();
        ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_Akdb.a();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          akdd localakdd = (akdd)localConcurrentHashMap.get(str1);
          if (localakdd != null)
          {
            localakdd.b -= 1;
            if (localakdd.b == 0)
            {
              String str2 = this.jdField_a_of_type_Akdb.a(localakdd);
              if (!TextUtils.isEmpty(str2))
              {
                this.jdField_a_of_type_Long += localakdd.jdField_a_of_type_Long;
                paramString.add(str2);
              }
              this.jdField_a_of_type_Akdb.a(str1);
            }
            else
            {
              this.jdField_a_of_type_Akdb.a(str1, localakdd);
            }
          }
        }
        this.jdField_a_of_type_Akdb.a(paramString);
      }
    }
  }
  
  private void b(String paramString, List<MessageRecord> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        paramList = a(paramList);
      } while (paramList == null);
      a(paramString, ((Integer)paramList.first).intValue());
      paramString = a(paramString, (List)paramList.second);
    } while (paramString == null);
    c((String)paramString.first, (List)paramString.second);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Akdb != null) && (this.jdField_a_of_type_Akdb.a());
  }
  
  private void c()
  {
    this.jdField_a_of_type_Akdj = new akdj();
    AppInterface localAppInterface = this.jdField_a_of_type_Akdj.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)localAppInterface);
    }
  }
  
  private void c(String paramString, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        String str = (String)paramList.get(i);
        if (!localList.contains(str)) {
          localList.add(str);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localList);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramList);
  }
  
  private void d()
  {
    this.d = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Akdj.a(this);
    this.jdField_a_of_type_Akdb = new akdb(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Akdj.a(0, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Akdj.b(1, this.jdField_a_of_type_JavaUtilHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadNameList finish");
    }
    h();
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_Akdj.a();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadMessageRecord tableNames is empty");
      }
      this.jdField_b_of_type_Boolean = true;
      h();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      b(str1, this.jdField_a_of_type_Akdj.a(MessageRecord.class, str2, str1, null, null));
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadMessageRecord finish");
    }
    h();
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord");
    }
    Object localObject = this.jdField_a_of_type_Akdj.b();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord tableNames is empty");
      }
      this.c = true;
      h();
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.format("select * from %s", new Object[] { str1 });
      b(str1, this.jdField_a_of_type_Akdj.b(MessageRecord.class, str2, str1, null, null));
    }
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadSlowTableMessageRecord finish");
    }
    h();
  }
  
  private void h()
  {
    if ((a()) && (b()))
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0)) {
        break label283;
      }
      localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localakda = new akda();
        localObject = (MessageRecord)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if ((localObject != null) && (a(((MessageRecord)localObject).istroop)))
        {
          localakda.jdField_a_of_type_JavaLangString = ((MessageRecord)localObject).frienduin;
          localakda.jdField_b_of_type_JavaLangString = a((MessageRecord)localObject);
          localakda.jdField_a_of_type_Int = ((MessageRecord)localObject).istroop;
          localakda.jdField_b_of_type_Long = ((MessageRecord)localObject).time;
          localakda.jdField_a_of_type_Long = a(MessageRecord.getTableName(localakda.jdField_a_of_type_JavaLangString, ((MessageRecord)localObject).istroop));
          if ((localakda.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_JavaUtilList != null))
          {
            localakda.c = akdc.a(localakda.jdField_a_of_type_Long);
            this.jdField_a_of_type_JavaUtilList.add(localakda);
          }
        }
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilHashMap != null) {
        this.jdField_b_of_type_JavaUtilHashMap.clear();
      }
      if (this.jdField_a_of_type_Akdg != null)
      {
        a(1);
        if (QLog.isColorLevel()) {
          QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish");
        }
        this.jdField_a_of_type_Akdg.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    label283:
    while (this.jdField_a_of_type_Akdg == null)
    {
      Iterator localIterator;
      Object localObject;
      akda localakda;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "conformAllData onLoadFinish cleanMessageList is empty");
    }
    this.jdField_a_of_type_Akdg.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void i()
  {
    this.d = true;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap = null;
    }
    if (this.jdField_a_of_type_Akdj != null) {
      this.jdField_a_of_type_Akdj.a();
    }
    if (this.jdField_a_of_type_Akdb != null) {
      this.jdField_a_of_type_Akdb.b();
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public List<akda> a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new akcz(paramInt));
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<akda> a(List<akda> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (this.jdField_a_of_type_Adye == null)) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "deleteMessages");
    }
    ThreadManager.getFileThreadHandler().post(new MessageCleanManager.4(this, paramList));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      akda localakda = (akda)paramList.next();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.remove(localakda);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "onScanFinish");
    }
    h();
  }
  
  public void a(adye paramadye)
  {
    this.jdField_a_of_type_Adye = paramadye;
  }
  
  public void a(akdg paramakdg)
  {
    this.jdField_a_of_type_Akdg = paramakdg;
  }
  
  public void a(String paramString, atmo paramatmo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramatmo == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyLastMsg tableName or entity is null");
      }
    }
    while ((!(paramatmo instanceof MessageRecord)) || (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, (MessageRecord)paramatmo);
  }
  
  public void a(String paramString, List<? extends atmo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "onNotifyMessageData messageRecordList is empty");
      }
    }
    while (!(paramList.get(0) instanceof MessageRecord)) {
      return;
    }
    b(paramString, paramList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("MessageCleanManager", 2, "loadAllMessageRecord");
    }
    if (this.jdField_a_of_type_Akdg != null) {
      this.jdField_a_of_type_Akdg.a();
    }
    i();
    d();
    try
    {
      this.jdField_a_of_type_Akdb.a();
      ThreadManager.getSubThreadHandler().post(new MessageCleanManager.1(this));
      ThreadManager.getFileThreadHandler().post(new MessageCleanManager.2(this));
      ThreadManager.getFileThreadHandler().post(new MessageCleanManager.3(this));
      return;
    }
    catch (Exception localException)
    {
      while (this.jdField_a_of_type_Akdg == null) {}
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord exception = " + localException.getMessage());
      }
      this.jdField_a_of_type_Akdg.a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_Akdg == null) {}
      if (QLog.isColorLevel()) {
        QLog.e("MessageCleanManager", 2, "loadAllMessageRecord OutOfMemoryError");
      }
      this.jdField_a_of_type_Akdg.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void onDestroy()
  {
    i();
    this.jdField_a_of_type_Akdg = null;
    this.jdField_a_of_type_Adye = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akdi
 * JD-Core Version:    0.7.0.1
 */