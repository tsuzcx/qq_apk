package com.tencent.mm.ui.component.support;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/ui/component/support/ActivityLifecycleInjector$1$onActivityCreated$1", "Landroidx/lifecycle/LifecycleObserver;", "onPostCreate", "", "onPreDestroy", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ActivityLifecycleInjector$1$onActivityCreated$1
  implements p
{
  ActivityLifecycleInjector$1$onActivityCreated$1(Activity paramActivity, Bundle paramBundle) {}
  
  @z(Ho=j.a.ON_CREATE)
  public final void onPostCreate()
  {
    AppMethodBeat.i(250328);
    a.jxT();
    a.b.onActivityPostCreated(this.rxb, this.afag);
    AppMethodBeat.o(250328);
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onPreDestroy()
  {
    AppMethodBeat.i(250334);
    a.jxT();
    a.b.onActivityPreDestroyed(this.rxb);
    AppMethodBeat.o(250334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.component.support.ActivityLifecycleInjector.1.onActivityCreated.1
 * JD-Core Version:    0.7.0.1
 */