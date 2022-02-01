package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c.a;
import com.tencent.mm.by.c.b;
import com.tencent.mm.ui.chatting.e.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b
  implements c.b
{
  private static WeakHashMap<Fragment, HashMap<Integer, c.a>> WYI;
  private WeakReference<a> WYJ;
  
  static
  {
    AppMethodBeat.i(36442);
    WYI = new WeakHashMap();
    AppMethodBeat.o(36442);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(36436);
    this.WYJ = new WeakReference(parama);
    AppMethodBeat.o(36436);
  }
  
  private static void a(Fragment paramFragment, int paramInt, c.a parama)
  {
    AppMethodBeat.i(292386);
    HashMap localHashMap2 = (HashMap)WYI.get(paramFragment);
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      WYI.put(paramFragment, localHashMap1);
    }
    localHashMap1.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(292386);
  }
  
  public static c.a d(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(292385);
    paramFragment = (HashMap)WYI.get(paramFragment);
    if (paramFragment != null)
    {
      paramFragment = (c.a)paramFragment.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(292385);
      return paramFragment;
    }
    AppMethodBeat.o(292385);
    return null;
  }
  
  public final void a(Intent paramIntent, int paramInt, c.a parama)
  {
    AppMethodBeat.i(36440);
    Fragment localFragment = getFragment();
    if (localFragment == null)
    {
      AppMethodBeat.o(36440);
      return;
    }
    a(localFragment, paramInt, parama);
    localFragment.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(36440);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(36441);
    FragmentActivity localFragmentActivity = getFragment().getActivity();
    AppMethodBeat.o(36441);
    return localFragmentActivity;
  }
  
  public final Fragment getFragment()
  {
    AppMethodBeat.i(292387);
    Object localObject = (a)this.WYJ.get();
    if (localObject != null)
    {
      localObject = ((a)localObject).WQv;
      AppMethodBeat.o(292387);
      return localObject;
    }
    AppMethodBeat.o(292387);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b
 * JD-Core Version:    0.7.0.1
 */