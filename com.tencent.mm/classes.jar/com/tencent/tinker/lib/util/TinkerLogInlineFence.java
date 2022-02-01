package com.tencent.tinker.lib.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog.TinkerLogImp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Keep
public final class TinkerLogInlineFence
  extends Handler
{
  private static final String TAG = "Tinker.TinkerLogInlineFence";
  private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
  private static final List<Object[]> pendingLogs = Collections.synchronizedList(new ArrayList());
  
  private static void dummyThrowExceptionMethod()
  {
    if (TinkerLogInlineFence.class.isPrimitive()) {
      throw new RuntimeException();
    }
  }
  
  private void handleMessageImpl(Message paramMessage)
  {
    ShareTinkerLog.TinkerLogImp localTinkerLogImp1 = ShareTinkerLog.getDefaultImpl();
    ShareTinkerLog.TinkerLogImp localTinkerLogImp2 = ShareTinkerLog.getImpl();
    switch (paramMessage.what)
    {
    default: 
      localTinkerLogImp2.e("Tinker.TinkerLogInlineFence", "[-] Bad msg id: " + paramMessage.what, new Object[0]);
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
                  if (localTinkerLogImp2 != null) {
                    localTinkerLogImp2.v((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
                  }
                } while ((localTinkerLogImp2 != null) && (localTinkerLogImp2 != localTinkerLogImp1));
                pendingLogs.add(paramMessage);
                return;
                paramMessage = (Object[])paramMessage.obj;
                if (localTinkerLogImp2 != null) {
                  localTinkerLogImp2.d((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
                }
              } while ((localTinkerLogImp2 != null) && (localTinkerLogImp2 != localTinkerLogImp1));
              pendingLogs.add(paramMessage);
              return;
              paramMessage = (Object[])paramMessage.obj;
              if (localTinkerLogImp2 != null) {
                localTinkerLogImp2.i((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
              }
            } while ((localTinkerLogImp2 != null) && (localTinkerLogImp2 != localTinkerLogImp1));
            pendingLogs.add(paramMessage);
            return;
            paramMessage = (Object[])paramMessage.obj;
            if (localTinkerLogImp2 != null) {
              localTinkerLogImp2.w((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
            }
          } while ((localTinkerLogImp2 != null) && (localTinkerLogImp2 != localTinkerLogImp1));
          pendingLogs.add(paramMessage);
          return;
          paramMessage = (Object[])paramMessage.obj;
          if (localTinkerLogImp2 != null) {
            localTinkerLogImp2.e((String)paramMessage[2], (String)paramMessage[3], (Object[])paramMessage[4]);
          }
        } while ((localTinkerLogImp2 != null) && (localTinkerLogImp2 != localTinkerLogImp1));
        pendingLogs.add(paramMessage);
        return;
        paramMessage = (Object[])paramMessage.obj;
        if (localTinkerLogImp2 != null) {
          localTinkerLogImp2.printErrStackTrace((String)paramMessage[2], (Throwable)paramMessage[3], (String)paramMessage[4], (Object[])paramMessage[5]);
        }
      } while ((localTinkerLogImp2 != null) && (localTinkerLogImp2 != localTinkerLogImp1));
      pendingLogs.add(paramMessage);
      return;
    }
    printPendingLogs(localTinkerLogImp2);
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
    if ((paramTinkerLogImp == null) || (pendingLogs.isEmpty())) {
      return;
    }
    new Thread(new Runnable()
    {
      public final void run()
      {
        final SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        Iterator localIterator = TinkerLogInlineFence.pendingLogs.iterator();
        while (localIterator.hasNext())
        {
          final Object[] arrayOfObject = (Object[])localIterator.next();
          TinkerLogInlineFence.mainThreadHandler.post(new Runnable()
          {
            public final void run()
            {
              String str = localSimpleDateFormat.format(new Date(((Long)arrayOfObject[1]).longValue()));
              str = "[PendingLog @ " + str + "] ";
              switch (((Integer)arrayOfObject[0]).intValue())
              {
              default: 
                return;
              case 2: 
                TinkerLogInlineFence.1.this.Krr.v((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                return;
              case 3: 
                TinkerLogInlineFence.1.this.Krr.d((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                return;
              case 4: 
                TinkerLogInlineFence.1.this.Krr.i((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                return;
              case 5: 
                TinkerLogInlineFence.1.this.Krr.w((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                return;
              case 6: 
                TinkerLogInlineFence.1.this.Krr.e((String)arrayOfObject[2], str + (String)arrayOfObject[3], (Object[])arrayOfObject[4]);
                return;
              }
              TinkerLogInlineFence.1.this.Krr.printErrStackTrace((String)arrayOfObject[2], (Throwable)arrayOfObject[3], str + (String)arrayOfObject[4], (Object[])arrayOfObject[5]);
            }
          });
        }
        TinkerLogInlineFence.pendingLogs.clear();
      }
    }, "tinker_log_printer").start();
  }
  
  public final void handleMessage(Message paramMessage)
  {
    handleMessage_$noinline$(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.util.TinkerLogInlineFence
 * JD-Core Version:    0.7.0.1
 */