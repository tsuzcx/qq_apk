package com.tencent.rtmp.sharp.jni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

class TraeAudioManager$e
{
  HashMap<String, TraeAudioManager.e.a> a = new HashMap();
  String b = "DEVICE_NONE";
  String c = "DEVICE_NONE";
  String d = "DEVICE_NONE";
  ReentrantLock e = new ReentrantLock();
  boolean f = false;
  String g = "unknow";
  
  public TraeAudioManager$e(TraeAudioManager paramTraeAudioManager) {}
  
  public String a(int paramInt)
  {
    this.e.lock();
    Object localObject = this.a.entrySet().iterator();
    int i = 0;
    Map.Entry localEntry;
    if (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (i != paramInt) {}
    }
    for (localObject = (TraeAudioManager.e.a)localEntry.getValue();; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = ((TraeAudioManager.e.a)localObject).a();; localObject = "DEVICE_NONE")
      {
        this.e.unlock();
        return localObject;
        i += 1;
        break;
      }
    }
  }
  
  public void a()
  {
    this.e.lock();
    this.a.clear();
    this.b = "DEVICE_NONE";
    this.c = "DEVICE_NONE";
    this.d = "DEVICE_NONE";
    this.e.unlock();
  }
  
  public boolean a(String paramString)
  {
    AudioDeviceInterface.LogTraceEntry(" strConfigs:" + paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {}
    do
    {
      String str;
      do
      {
        return false;
        str = paramString.replace("\n", "").replace("\r", "");
      } while ((str == null) || (str.length() <= 0));
      paramString = str;
      if (str.indexOf(";") < 0) {
        paramString = str + ";";
      }
      paramString = paramString.split(";");
    } while ((paramString == null) || (1 > paramString.length));
    this.e.lock();
    int i = 0;
    while (i < paramString.length)
    {
      a(paramString[i], i);
      i += 1;
    }
    this.e.unlock();
    this.h.printDevices();
    return true;
  }
  
  boolean a(String paramString, int paramInt)
  {
    AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
    TraeAudioManager.e.a locala = new TraeAudioManager.e.a(this);
    if (locala.a(paramString, paramInt)) {
      if (this.a.containsKey(paramString)) {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "err dev exist!");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return false;
      this.a.put(paramString, locala);
      this.f = true;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " n" + e() + " 0:" + a(0));
      }
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    QLog.e("TRAE", 2, " err dev init!");
    return false;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    this.e.lock();
    Object localObject = (TraeAudioManager.e.a)this.a.get(paramString);
    if ((localObject != null) && (((TraeAudioManager.e.a)localObject).b() != paramBoolean))
    {
      ((TraeAudioManager.e.a)localObject).a(paramBoolean);
      this.f = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(" ++setVisible:").append(paramString);
        if (!paramBoolean) {
          break label93;
        }
        paramString = " Y";
        QLog.w("TRAE", 2, paramString);
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.e.unlock();
      return paramBoolean;
      label93:
      paramString = " N";
      break;
    }
  }
  
  public void b(String paramString)
  {
    if (paramString == null)
    {
      this.g = "unknow";
      return;
    }
    if (paramString.isEmpty())
    {
      this.g = "unknow";
      return;
    }
    this.g = paramString;
  }
  
  public boolean b()
  {
    this.e.lock();
    boolean bool = this.f;
    this.e.unlock();
    return bool;
  }
  
  public void c()
  {
    this.e.lock();
    this.f = false;
    this.e.unlock();
  }
  
  public boolean c(String paramString)
  {
    this.e.lock();
    paramString = (TraeAudioManager.e.a)this.a.get(paramString);
    if (paramString != null) {}
    for (boolean bool = paramString.b();; bool = false)
    {
      this.e.unlock();
      return bool;
    }
  }
  
  public int d(String paramString)
  {
    this.e.lock();
    paramString = (TraeAudioManager.e.a)this.a.get(paramString);
    if (paramString != null) {}
    for (int i = paramString.c();; i = -1)
    {
      this.e.unlock();
      return i;
    }
  }
  
  public String d()
  {
    return this.g;
  }
  
  public int e()
  {
    this.e.lock();
    int i = this.a.size();
    this.e.unlock();
    return i;
  }
  
  public String e(String paramString)
  {
    this.e.lock();
    Iterator localIterator = this.a.entrySet().iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      localObject2 = (TraeAudioManager.e.a)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (((TraeAudioManager.e.a)localObject2).b()) && (!((TraeAudioManager.e.a)localObject2).a().equals(paramString))) {
        if (localObject1 == null)
        {
          localObject1 = localObject2;
        }
        else
        {
          if (((TraeAudioManager.e.a)localObject2).c() < localObject1.c()) {
            break label134;
          }
          localObject1 = localObject2;
        }
      }
    }
    label134:
    for (;;)
    {
      break;
      this.e.unlock();
      if (localObject1 != null) {
        return localObject1.a();
      }
      return "DEVICE_SPEAKERPHONE";
    }
  }
  
  public String f()
  {
    this.e.lock();
    Iterator localIterator = this.a.entrySet().iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      localObject2 = (TraeAudioManager.e.a)((Map.Entry)localObject2).getValue();
      if ((localObject2 != null) && (((TraeAudioManager.e.a)localObject2).b())) {
        if (localObject1 == null)
        {
          localObject1 = localObject2;
        }
        else
        {
          if (((TraeAudioManager.e.a)localObject2).c() < localObject1.c()) {
            break label120;
          }
          localObject1 = localObject2;
        }
      }
    }
    label120:
    for (;;)
    {
      break;
      this.e.unlock();
      if (localObject1 != null) {
        return localObject1.a();
      }
      return "DEVICE_SPEAKERPHONE";
    }
  }
  
  public boolean f(String paramString)
  {
    this.e.lock();
    TraeAudioManager.e.a locala = (TraeAudioManager.e.a)this.a.get(paramString);
    if ((locala != null) && (locala.b())) {
      this.d = paramString;
    }
    for (boolean bool = true;; bool = false)
    {
      this.e.unlock();
      return bool;
    }
  }
  
  public String g()
  {
    this.e.lock();
    Object localObject = (TraeAudioManager.e.a)this.a.get(this.d);
    if ((localObject != null) && (((TraeAudioManager.e.a)localObject).b())) {}
    for (localObject = this.d;; localObject = null)
    {
      this.e.unlock();
      return localObject;
    }
  }
  
  public boolean g(String paramString)
  {
    this.e.lock();
    TraeAudioManager.e.a locala = (TraeAudioManager.e.a)this.a.get(paramString);
    if ((locala != null) && (locala.b()))
    {
      if ((this.c != null) && (!this.c.equals(paramString))) {
        this.b = this.c;
      }
      this.c = paramString;
      this.d = "";
    }
    for (boolean bool = true;; bool = false)
    {
      this.e.unlock();
      return bool;
    }
  }
  
  public String h()
  {
    this.e.lock();
    String str = m();
    this.e.unlock();
    return str;
  }
  
  public String i()
  {
    this.e.lock();
    String str = n();
    this.e.unlock();
    return str;
  }
  
  public HashMap<String, Object> j()
  {
    HashMap localHashMap = new HashMap();
    this.e.lock();
    localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", l());
    localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", m());
    localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", n());
    this.e.unlock();
    return localHashMap;
  }
  
  public ArrayList<String> k()
  {
    new ArrayList();
    this.e.lock();
    ArrayList localArrayList = l();
    this.e.unlock();
    return localArrayList;
  }
  
  ArrayList<String> l()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TraeAudioManager.e.a locala = (TraeAudioManager.e.a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.b())) {
        localArrayList.add(locala.a());
      }
    }
    return localArrayList;
  }
  
  String m()
  {
    TraeAudioManager.e.a locala = (TraeAudioManager.e.a)this.a.get(this.c);
    if ((locala != null) && (locala.b())) {
      return this.c;
    }
    return "DEVICE_NONE";
  }
  
  String n()
  {
    TraeAudioManager.e.a locala = (TraeAudioManager.e.a)this.a.get(this.b);
    if ((locala != null) && (locala.b())) {
      return this.b;
    }
    return "DEVICE_NONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.e
 * JD-Core Version:    0.7.0.1
 */