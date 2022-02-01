package com.tencent.mm.ui.vas;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.vas.b.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isVASActivity", "", "Landroid/content/Intent;", "libmmui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final boolean isVASActivity(Intent paramIntent)
  {
    AppMethodBeat.i(249919);
    s.u(paramIntent, "<this>");
    Object localObject = VASActivity.Companion;
    if (!VASActivity.a.jEi())
    {
      AppMethodBeat.o(249919);
      return false;
    }
    try
    {
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null)
      {
        paramIntent = "";
        localObject = VASActivity.Companion;
        if (VASActivity.a.jEh().aVy(paramIntent)) {
          break label88;
        }
        AppMethodBeat.o(249919);
        return false;
      }
    }
    finally {}
    for (;;)
    {
      AppMethodBeat.o(249919);
      return false;
      localObject = paramIntent.getClassName();
      paramIntent = (Intent)localObject;
      if (localObject != null) {
        break;
      }
      paramIntent = "";
      break;
      label88:
      for (paramIntent = Class.forName(paramIntent); paramIntent.getSuperclass() != null; paramIntent = paramIntent.getSuperclass()) {
        if (s.p(paramIntent.getSuperclass(), VASActivity.class))
        {
          AppMethodBeat.o(249919);
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.c
 * JD-Core Version:    0.7.0.1
 */