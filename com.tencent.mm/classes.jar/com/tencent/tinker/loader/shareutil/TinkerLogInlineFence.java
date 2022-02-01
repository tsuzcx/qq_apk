package com.tencent.tinker.loader.shareutil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

final class TinkerLogInlineFence
  extends Handler
{
  private static final String TAG = "Tinker.TinkerLogInlineFence";
  private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
  private static final List<Object[]> pendingLogs = new ArrayList();
  
  private static void dummyThrowExceptionMethod()
  {
    if (TinkerLogInlineFence.class.isPrimitive()) {
      throw new RuntimeException();
    }
  }
  
  private void handleMessageImpl(Message paramMessage)
  {
    ??? = ShareTinkerLog.getDefaultImpl();
    ShareTinkerLog.TinkerLogImp localTinkerLogImp = ShareTinkerLog.getImpl();
    switch (paramMessage.what)
    {
    default: 
      localTinkerLogImp.e("Tinker.TinkerLogInlineFence", "[-] Bad msg id: " + paramMessage.what, new Object[0]);
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 4001: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  paramMessage = (Object[])paramMessage.obj;
                  if (localTinkerLogImp != null) {
                    localTinkerLogImp.v((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
                  }
                } while ((localTinkerLogImp != null) && (localTinkerLogImp != ???));
                synchronized (pendingLogs)
                {
                  pendingLogs.add(paramMessage);
                  return;
                }
                paramMessage = (Object[])paramMessage.obj;
                if (localTinkerLogImp != null) {
                  localTinkerLogImp.d((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
                }
              } while ((localTinkerLogImp != null) && (localTinkerLogImp != ???));
              synchronized (pendingLogs)
              {
                pendingLogs.add(paramMessage);
                return;
              }
              paramMessage = (Object[])paramMessage.obj;
              if (localTinkerLogImp != null) {
                localTinkerLogImp.i((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
              }
            } while ((localTinkerLogImp != null) && (localTinkerLogImp != ???));
            synchronized (pendingLogs)
            {
              pendingLogs.add(paramMessage);
              return;
            }
            paramMessage = (Object[])paramMessage.obj;
            if (localTinkerLogImp != null) {
              localTinkerLogImp.w((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
            }
          } while ((localTinkerLogImp != null) && (localTinkerLogImp != ???));
          synchronized (pendingLogs)
          {
            pendingLogs.add(paramMessage);
            return;
          }
          paramMessage = (Object[])paramMessage.obj;
          if (localTinkerLogImp != null) {
            localTinkerLogImp.e((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
          }
        } while ((localTinkerLogImp != null) && (localTinkerLogImp != ???));
        synchronized (pendingLogs)
        {
          pendingLogs.add(paramMessage);
          return;
        }
        paramMessage = (Object[])paramMessage.obj;
        if (localTinkerLogImp != null) {
          localTinkerLogImp.printErrStackTrace((String)paramMessage[2], (Throwable)paramMessage[3], (String)paramMessage[4], (Object[])paramMessage[5]);
        }
      } while ((localTinkerLogImp != null) && (localTinkerLogImp != ???));
      synchronized (pendingLogs)
      {
        pendingLogs.add(paramMessage);
        return;
      }
    }
    printPendingLogs(localTinkerLogImp);
  }
  
  private void handleMessage_$noinline$(Message paramMessage)
  {
    try
    {
      dummyThrowExceptionMethod();
      return;
    }
    finally
    {
      handleMessageImpl(paramMessage);
    }
  }
  
  private static void printPendingLogs(ShareTinkerLog.TinkerLogImp paramTinkerLogImp)
  {
    List localList = pendingLogs;
    if (paramTinkerLogImp != null) {}
    try
    {
      if (pendingLogs.isEmpty()) {
        return;
      }
      new Thread(new Runnable()
      {
        public final void run()
        {
          final SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
          synchronized (TinkerLogInlineFence.pendingLogs)
          {
            Iterator localIterator = TinkerLogInlineFence.pendingLogs.iterator();
            if (localIterator.hasNext())
            {
              final Object[] arrayOfObject = (Object[])localIterator.next();
              TinkerLogInlineFence.mainThreadHandler.post(new Runnable()
              {
                public void run()
                {
                  String str = localSimpleDateFormat.format(new Date(((Long)arrayOfObject[1]).longValue()));
                  str = "[PendingLog @ " + str + "] ";
                  switch (((Integer)arrayOfObject[0]).intValue())
                  {
                  default: 
                    return;
                  case 2: 
                    TinkerLogInlineFence.1.this.val$logImp.v((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                    return;
                  case 3: 
                    TinkerLogInlineFence.1.this.val$logImp.d((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                    return;
                  case 4: 
                    TinkerLogInlineFence.1.this.val$logImp.i((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                    return;
                  case 5: 
                    TinkerLogInlineFence.1.this.val$logImp.w((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                    return;
                  case 6: 
                    TinkerLogInlineFence.1.this.val$logImp.e((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                    return;
                  }
                  TinkerLogInlineFence.1.this.val$logImp.printErrStackTrace((String)arrayOfObject[2], (Throwable)arrayOfObject[3], str + (String)arrayOfObject[4], (Object[])arrayOfObject[5]);
                }
              });
            }
          }
          TinkerLogInlineFence.pendingLogs.clear();
        }
      }, "tinker_log_printer").start();
      return;
    }
    finally {}
  }
  
  public final void handleMessage(Message paramMessage)
  {
    handleMessage_$noinline$(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.TinkerLogInlineFence
 * JD-Core Version:    0.7.0.1
 */