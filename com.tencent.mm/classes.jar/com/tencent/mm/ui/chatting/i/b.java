package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d.a;
import com.tencent.mm.br.d.b;
import com.tencent.mm.ui.chatting.e.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b
  implements d.b
{
  private static WeakHashMap<Fragment, HashMap<Integer, d.a>> KrN;
  private WeakReference<a> KrO;
  
  static
  {
    AppMethodBeat.i(36442);
    KrN = new WeakHashMap();
    AppMethodBeat.o(36442);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(36436);
    this.KrO = new WeakReference(parama);
    AppMethodBeat.o(36436);
  }
  
  private static void a(Fragment paramFragment, int paramInt, d.a parama)
  {
    AppMethodBeat.i(36438);
    HashMap localHashMap2 = (HashMap)KrN.get(paramFragment);
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      KrN.put(paramFragment, localHashMap1);
    }
    localHashMap1.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(36438);
  }
  
  public static d.a d(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(36437);
    paramFragment = (HashMap)KrN.get(paramFragment);
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
    Object localObject = (a)this.KrO.get();
    if (localObject != null)
    {
      localObject = ((a)localObject).Kkd;
      AppMethodBeat.o(36439);
      return localObject;
    }
    AppMethodBeat.o(36439);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.b
 * JD-Core Version:    0.7.0.1
 */