package com.tencent.smtt.sandbox;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.chromium.base.process_launcher.ICallbackInt;
import org.chromium.base.process_launcher.IChildProcessService.Stub;

class ChildProcessService$1
  extends IChildProcessService.Stub
{
  static
  {
    AppMethodBeat.i(138986);
    if (!ChildProcessService.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(138986);
      return;
    }
  }
  
  ChildProcessService$1(ChildProcessService paramChildProcessService) {}
  
  public boolean bindToCaller()
  {
    AppMethodBeat.i(138983);
    if ((!$assertionsDisabled) && (!ChildProcessService.access$000(this.this$0)))
    {
      ??? = new AssertionError();
      AppMethodBeat.o(138983);
      throw ((Throwable)???);
    }
    if ((!$assertionsDisabled) && (!ChildProcessService.access$100(this.this$0)))
    {
      ??? = new AssertionError();
      AppMethodBeat.o(138983);
      throw ((Throwable)???);
    }
    synchronized (ChildProcessService.access$200(this.this$0))
    {
      int i = Binder.getCallingPid();
      if (ChildProcessService.access$300(this.this$0) == 0) {
        ChildProcessService.access$302(this.this$0, i);
      }
      while (ChildProcessService.access$300(this.this$0) == i)
      {
        AppMethodBeat.o(138983);
        return true;
      }
      Log.e("ChildProcessService", "Service is already bound by pid %d, cannot bind for pid %d", new Object[] { Integer.valueOf(ChildProcessService.access$300(this.this$0)), Integer.valueOf(i) });
      AppMethodBeat.o(138983);
      return false;
    }
  }
  
  public void crashIntentionallyForTesting()
  {
    AppMethodBeat.i(138985);
    if ((!$assertionsDisabled) && (!ChildProcessService.access$100(this.this$0)))
    {
      AssertionError localAssertionError = new AssertionError();
      AppMethodBeat.o(138985);
      throw localAssertionError;
    }
    AppMethodBeat.o(138985);
  }
  
  public void invokeMiscMethod(String paramString, Bundle paramBundle) {}
  
  public void setupConnection(Bundle paramBundle, ICallbackInt paramICallbackInt, List<IBinder> paramList)
  {
    AppMethodBeat.i(138984);
    if ((!$assertionsDisabled) && (!ChildProcessService.access$100(this.this$0)))
    {
      paramBundle = new AssertionError();
      AppMethodBeat.o(138984);
      throw paramBundle;
    }
    synchronized (ChildProcessService.access$200(this.this$0))
    {
      if ((ChildProcessService.access$000(this.this$0)) && (ChildProcessService.access$300(this.this$0) == 0))
      {
        Log.e("ChildProcessService", "Service has not been bound with bindToCaller()", new Object[0]);
        paramICallbackInt.call(-1);
        AppMethodBeat.o(138984);
        return;
      }
      paramICallbackInt.call(Process.myPid());
      ChildProcessService.access$400(this.this$0, paramBundle, paramList);
      AppMethodBeat.o(138984);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ChildProcessService.1
 * JD-Core Version:    0.7.0.1
 */