import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler.StateMachine;
import com.tencent.qphone.base.util.QLog;

public class ajyx
  implements SwiftBrowserStateMachineScheduler.StateMachine
{
  public ajyx(WebViewFragment paramWebViewFragment) {}
  
  public int a(Bundle paramBundle)
  {
    int j = this.a.m;
    int i = -1;
    long l = System.currentTimeMillis();
    switch (this.a.m)
    {
    }
    for (;;)
    {
      QLog.i("WebLog_WebViewFragment", 1, "CreateLoop:step[" + j + "] -> step[" + this.a.m + "] cost" + (System.currentTimeMillis() - l) + " ms.");
      return i;
      i = this.a.f(paramBundle);
      continue;
      i = this.a.g(paramBundle);
      continue;
      i = this.a.h(paramBundle);
      continue;
      i = this.a.d(paramBundle);
      continue;
      i = this.a.i(paramBundle);
      continue;
      i = this.a.e(paramBundle);
      continue;
      i = this.a.c(paramBundle);
      continue;
      i = this.a.b(paramBundle);
      continue;
      i = this.a.a(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajyx
 * JD-Core Version:    0.7.0.1
 */