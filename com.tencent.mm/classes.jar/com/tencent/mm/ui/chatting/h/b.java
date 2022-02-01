package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.bs.d.b;
import com.tencent.mm.ui.chatting.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b
  implements d.b
{
  private static WeakHashMap<Fragment, HashMap<Integer, d.a>> GFm;
  private WeakReference<a> GFn;
  
  static
  {
    AppMethodBeat.i(36442);
    GFm = new WeakHashMap();
    AppMethodBeat.o(36442);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(36436);
    this.GFn = new WeakReference(parama);
    AppMethodBeat.o(36436);
  }
  
  private static void a(Fragment paramFragment, int paramInt, d.a parama)
  {
    AppMethodBeat.i(36438);
    HashMap localHashMap2 = (HashMap)GFm.get(paramFragment);
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      GFm.put(paramFragment, localHashMap1);
    }
    localHashMap1.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(36438);
  }
  
  public static d.a d(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(36437);
    paramFragment = (HashMap)GFm.get(paramFragment);
    if (paramFragment != null)
    {
      paramFragment = (d.a)paramFragment.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(36437);
      return paramFragment;
    }
    AppMethodBeat.o(36437);
    return null;
  }
  
  public final void a(Intent paramIntent, int paramInt, d.a parama)
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
    AppMethodBeat.i(36439);
    Object localObject = (a)this.GFn.get();
    if (localObject != null)
    {
      localObject = ((a)localObject).GzJ;
      AppMethodBeat.o(36439);
      return localObject;
    }
    AppMethodBeat.o(36439);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.b
 * JD-Core Version:    0.7.0.1
 */