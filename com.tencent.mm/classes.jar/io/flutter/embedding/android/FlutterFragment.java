package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.dart.DartExecutor;

public class FlutterFragment
  extends Fragment
  implements d.a
{
  d aaoB;
  
  public FlutterFragment()
  {
    AppMethodBeat.i(10085);
    setArguments(new Bundle());
    AppMethodBeat.o(10085);
  }
  
  public static FlutterFragment.a bGb(String paramString)
  {
    AppMethodBeat.i(253584);
    paramString = new FlutterFragment.a(paramString, (byte)0);
    AppMethodBeat.o(253584);
    return paramString;
  }
  
  public static FlutterFragment.b iAw()
  {
    AppMethodBeat.i(253583);
    FlutterFragment.b localb = new FlutterFragment.b();
    AppMethodBeat.o(253583);
    return localb;
  }
  
  public final j NC()
  {
    AppMethodBeat.i(10105);
    Object localObject = getActivity();
    if ((localObject instanceof k))
    {
      localObject = ((k)localObject).NC();
      AppMethodBeat.o(10105);
      return localObject;
    }
    AppMethodBeat.o(10105);
    return null;
  }
  
  public final a ND()
  {
    AppMethodBeat.i(10106);
    Object localObject = getActivity();
    if ((localObject instanceof g))
    {
      io.flutter.b.iAd();
      localObject = (g)localObject;
      getContext();
    }
    for (localObject = ((g)localObject).ND();; localObject = null)
    {
      AppMethodBeat.o(10106);
      return localObject;
    }
  }
  
  public final String Nw()
  {
    AppMethodBeat.i(10098);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(10098);
    return str;
  }
  
  public final String Nx()
  {
    AppMethodBeat.i(10100);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(10100);
    return str;
  }
  
  public final String Ny()
  {
    AppMethodBeat.i(10101);
    String str = getArguments().getString("app_bundle_path");
    AppMethodBeat.o(10101);
    return str;
  }
  
  public final String Nz()
  {
    AppMethodBeat.i(10102);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(10102);
    return str;
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(10107);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.plugin.platform.b(getActivity(), parama.aaqd, this);
      AppMethodBeat.o(10107);
      return paramActivity;
    }
    AppMethodBeat.o(10107);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10108);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof f)) {
      ((f)localFragmentActivity).a(parama);
    }
    AppMethodBeat.o(10108);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(253625);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof f)) {
      ((f)localFragmentActivity).b(parama);
    }
    AppMethodBeat.o(253625);
  }
  
  final boolean bGa(String paramString)
  {
    AppMethodBeat.i(253636);
    if (this.aaoB == null)
    {
      new StringBuilder("FlutterFragment ").append(hashCode()).append(" ").append(paramString).append(" called after release.");
      io.flutter.b.iAd();
      AppMethodBeat.o(253636);
      return false;
    }
    AppMethodBeat.o(253636);
    return true;
  }
  
  public final void epX()
  {
    AppMethodBeat.i(253629);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.renderer.b)) {
      ((io.flutter.embedding.engine.renderer.b)localFragmentActivity).epX();
    }
    AppMethodBeat.o(253629);
  }
  
  public final void epY()
  {
    AppMethodBeat.i(253631);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.renderer.b)) {
      ((io.flutter.embedding.engine.renderer.b)localFragmentActivity).epY();
    }
    AppMethodBeat.o(253631);
  }
  
  public final void iAm()
  {
    AppMethodBeat.i(253602);
    new StringBuilder("FlutterFragment ").append(this).append(" connection to the engine ").append(this.aaoB.BCx).append(" evicted by another attaching activity");
    io.flutter.b.iAd();
    this.aaoB.onDestroyView();
    this.aaoB.onDetach();
    this.aaoB.release();
    this.aaoB = null;
    AppMethodBeat.o(253602);
  }
  
  public final io.flutter.embedding.engine.d iAo()
  {
    AppMethodBeat.i(10097);
    Object localObject = getArguments().getStringArray("initialization_args");
    if (localObject != null) {}
    for (;;)
    {
      localObject = new io.flutter.embedding.engine.d((String[])localObject);
      AppMethodBeat.o(10097);
      return localObject;
      localObject = new String[0];
    }
  }
  
  public final boolean iAp()
  {
    AppMethodBeat.i(10099);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((Nw() != null) || (this.aaoB.ZZk))
    {
      AppMethodBeat.o(10099);
      return bool;
    }
    bool = getArguments().getBoolean("destroy_engine_with_fragment", true);
    AppMethodBeat.o(10099);
    return bool;
  }
  
  public final i iAq()
  {
    AppMethodBeat.i(253621);
    i locali = i.valueOf(getArguments().getString("flutterview_render_mode", i.aapM.name()));
    AppMethodBeat.o(253621);
    return locali;
  }
  
  public final l iAr()
  {
    AppMethodBeat.i(253622);
    l locall = l.valueOf(getArguments().getString("flutterview_transparency_mode", l.aapR.name()));
    AppMethodBeat.o(253622);
    return locall;
  }
  
  public final boolean iAt()
  {
    AppMethodBeat.i(10109);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(10109);
    return bool;
  }
  
  public final boolean iAu()
  {
    AppMethodBeat.i(253628);
    boolean bool = getArguments().getBoolean("handle_deeplinking");
    AppMethodBeat.o(253628);
    return bool;
  }
  
  public final boolean iAv()
  {
    AppMethodBeat.i(253634);
    if (getArguments().containsKey("enable_state_restoration"))
    {
      boolean bool = getArguments().getBoolean("enable_state_restoration");
      AppMethodBeat.o(253634);
      return bool;
    }
    if (Nw() != null)
    {
      AppMethodBeat.o(253634);
      return false;
    }
    AppMethodBeat.o(253634);
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10095);
    if (bGa("onActivityResult")) {
      this.aaoB.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(10095);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10086);
    super.onAttach(paramContext);
    this.aaoB = new d(this);
    this.aaoB.ivA();
    AppMethodBeat.o(10086);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253588);
    super.onCreate(paramBundle);
    this.aaoB.onRestoreInstanceState(paramBundle);
    AppMethodBeat.o(253588);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(10087);
    paramLayoutInflater = this.aaoB.ivC();
    AppMethodBeat.o(10087);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(10092);
    super.onDestroyView();
    if (bGa("onDestroyView")) {
      this.aaoB.onDestroyView();
    }
    AppMethodBeat.o(10092);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(10093);
    super.onDetach();
    if (this.aaoB != null)
    {
      this.aaoB.onDetach();
      this.aaoB.release();
      this.aaoB = null;
      AppMethodBeat.o(10093);
      return;
    }
    new StringBuilder("FlutterFragment ").append(this).append(" onDetach called after release.");
    io.flutter.b.iAd();
    AppMethodBeat.o(10093);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(10096);
    super.onLowMemory();
    if (bGa("onLowMemory"))
    {
      d locald = this.aaoB;
      io.flutter.b.iAd();
      locald.ivE();
      locald.BCx.aapU.notifyLowMemoryWarning();
      locald.BCx.aaqf.iBl();
    }
    AppMethodBeat.o(10096);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10090);
    super.onPause();
    this.aaoB.onPause();
    AppMethodBeat.o(10090);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10094);
    if (bGa("onRequestPermissionsResult")) {
      this.aaoB.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(10094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10089);
    super.onResume();
    this.aaoB.onResume();
    AppMethodBeat.o(10089);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(253599);
    super.onSaveInstanceState(paramBundle);
    if (bGa("onSaveInstanceState")) {
      this.aaoB.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(253599);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(10088);
    super.onStart();
    this.aaoB.onStart();
    AppMethodBeat.o(10088);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10091);
    super.onStop();
    if (bGa("onStop")) {
      this.aaoB.onStop();
    }
    AppMethodBeat.o(10091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */