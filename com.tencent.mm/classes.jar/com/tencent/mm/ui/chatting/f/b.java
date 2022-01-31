package com.tencent.mm.ui.chatting.f;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.br.d.a;
import com.tencent.mm.br.d.b;
import com.tencent.mm.ui.chatting.c.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public final class b
  implements d.b
{
  private static WeakHashMap<Fragment, HashMap<Integer, d.a>> vyu = new WeakHashMap();
  private WeakReference<a> vyv;
  
  public b(a parama)
  {
    this.vyv = new WeakReference(parama);
  }
  
  public static d.a b(Fragment paramFragment, int paramInt)
  {
    paramFragment = (HashMap)vyu.get(paramFragment);
    if (paramFragment != null) {
      return (d.a)paramFragment.remove(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public final void a(Intent paramIntent, int paramInt, d.a parama)
  {
    Fragment localFragment = cGN();
    if (localFragment == null) {
      return;
    }
    HashMap localHashMap2 = (HashMap)vyu.get(localFragment);
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      vyu.put(localFragment, localHashMap1);
    }
    localHashMap1.put(Integer.valueOf(paramInt), parama);
    localFragment.startActivityForResult(paramIntent, paramInt);
  }
  
  public final Fragment cGN()
  {
    a locala = (a)this.vyv.get();
    if (locala != null) {
      return locala.vtz;
    }
    return null;
  }
  
  public final Context getContext()
  {
    return cGN().getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.b
 * JD-Core Version:    0.7.0.1
 */