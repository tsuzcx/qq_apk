package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d.a;
import com.tencent.mm.bq.d.b;
import com.tencent.mm.ui.chatting.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b
  implements d.b
{
  private static WeakHashMap<Fragment, HashMap<Integer, d.a>> zOQ;
  private WeakReference<a> zOR;
  
  static
  {
    AppMethodBeat.i(32501);
    zOQ = new WeakHashMap();
    AppMethodBeat.o(32501);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(32495);
    this.zOR = new WeakReference(parama);
    AppMethodBeat.o(32495);
  }
  
  private static void a(Fragment paramFragment, int paramInt, d.a parama)
  {
    AppMethodBeat.i(32497);
    HashMap localHashMap2 = (HashMap)zOQ.get(paramFragment);
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      zOQ.put(paramFragment, localHashMap1);
    }
    localHashMap1.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(32497);
  }
  
  public static d.a c(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(32496);
    paramFragment = (HashMap)zOQ.get(paramFragment);
    if (paramFragment != null)
    {
      paramFragment = (d.a)paramFragment.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(32496);
      return paramFragment;
    }
    AppMethodBeat.o(32496);
    return null;
  }
  
  public final void a(Intent paramIntent, int paramInt, d.a parama)
  {
    AppMethodBeat.i(32499);
    Fragment localFragment = getFragment();
    if (localFragment == null)
    {
      AppMethodBeat.o(32499);
      return;
    }
    a(localFragment, paramInt, parama);
    localFragment.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(32499);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(32500);
    FragmentActivity localFragmentActivity = getFragment().getActivity();
    AppMethodBeat.o(32500);
    return localFragmentActivity;
  }
  
  public final Fragment getFragment()
  {
    AppMethodBeat.i(32498);
    Object localObject = (a)this.zOR.get();
    if (localObject != null)
    {
      localObject = ((a)localObject).zJz;
      AppMethodBeat.o(32498);
      return localObject;
    }
    AppMethodBeat.o(32498);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.b
 * JD-Core Version:    0.7.0.1
 */