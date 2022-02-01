package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c.a;
import com.tencent.mm.br.c.b;
import com.tencent.mm.ui.chatting.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b
  implements c.b
{
  private static WeakHashMap<Fragment, HashMap<Integer, c.a>> aeIi;
  private WeakReference<a> aeIj;
  
  static
  {
    AppMethodBeat.i(36442);
    aeIi = new WeakHashMap();
    AppMethodBeat.o(36442);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(36436);
    this.aeIj = new WeakReference(parama);
    AppMethodBeat.o(36436);
  }
  
  private static void a(Fragment paramFragment, int paramInt, c.a parama)
  {
    AppMethodBeat.i(253715);
    HashMap localHashMap2 = (HashMap)aeIi.get(paramFragment);
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      aeIi.put(paramFragment, localHashMap1);
    }
    localHashMap1.put(Integer.valueOf(paramInt), parama);
    AppMethodBeat.o(253715);
  }
  
  public static c.a d(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(253713);
    paramFragment = (HashMap)aeIi.get(paramFragment);
    if (paramFragment != null)
    {
      paramFragment = (c.a)paramFragment.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(253713);
      return paramFragment;
    }
    AppMethodBeat.o(253713);
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
    AppMethodBeat.i(253718);
    Object localObject = (a)this.aeIj.get();
    if (localObject != null)
    {
      localObject = ((a)localObject).aezO;
      AppMethodBeat.o(253718);
      return localObject;
    }
    AppMethodBeat.o(253718);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.b
 * JD-Core Version:    0.7.0.1
 */