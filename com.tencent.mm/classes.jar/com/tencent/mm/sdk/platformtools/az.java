package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class az
{
  boolean cCv;
  Object lock;
  String name;
  int priority;
  public LinkedBlockingQueue<az.a> ypC;
  private int ypD;
  Vector<az.b> ypE;
  ak ypF;
  
  public az(int paramInt, String paramString)
  {
    this(paramInt, paramString, 1);
  }
  
  public az(int paramInt1, String paramString, int paramInt2)
  {
    this(paramInt1, paramString, paramInt2, Looper.myLooper());
    AppMethodBeat.i(52235);
    AppMethodBeat.o(52235);
  }
  
  public az(int paramInt1, String paramString, int paramInt2, Looper paramLooper)
  {
    AppMethodBeat.i(52236);
    this.ypC = new LinkedBlockingQueue();
    this.cCv = false;
    this.ypD = 1;
    this.priority = 1;
    this.name = "";
    this.lock = new byte[0];
    this.ypE = new Vector();
    this.ypD = paramInt2;
    this.name = paramString;
    this.priority = paramInt1;
    paramString = paramLooper;
    if (paramLooper == null)
    {
      paramString = paramLooper;
      if (Looper.getMainLooper() != null)
      {
        paramString = Looper.getMainLooper();
        ab.i("QueueWorkerThread.QueueWorkerThread", "looper is null use MainLooper!");
      }
    }
    this.ypF = new az.1(this, paramString);
    AppMethodBeat.o(52236);
  }
  
  @Deprecated
  public final boolean dtw()
  {
    AppMethodBeat.i(52238);
    if ((this.ypE == null) || (this.ypE.size() == 0))
    {
      AppMethodBeat.o(52238);
      return true;
    }
    AppMethodBeat.o(52238);
    return false;
  }
  
  public final int e(az.a parama)
  {
    AppMethodBeat.i(52237);
    if (parama == null)
    {
      ab.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      AppMethodBeat.o(52237);
      return -1;
    }
    try
    {
      if (!this.ypC.offer(parama, 1L, TimeUnit.MILLISECONDS))
      {
        ab.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
        AppMethodBeat.o(52237);
        return -2;
      }
    }
    catch (Exception parama)
    {
      ab.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + parama.getMessage());
      ab.printErrStackTrace("QueueWorkerThread.QueueWorkerThread", parama, "", new Object[0]);
      AppMethodBeat.o(52237);
      return -3;
    }
    if ((this.ypE.size() == 0) || ((this.ypC.size() > 0) && (this.ypD > this.ypE.size()))) {
      new az.b(this, (byte)0).start();
    }
    AppMethodBeat.o(52237);
    return 0;
  }
  
  public final void pL(boolean paramBoolean)
  {
    AppMethodBeat.i(52239);
    synchronized (this.lock)
    {
      this.cCv = paramBoolean;
      if (!paramBoolean) {}
      synchronized (this.lock)
      {
        this.lock.notifyAll();
        AppMethodBeat.o(52239);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.az
 * JD-Core Version:    0.7.0.1
 */