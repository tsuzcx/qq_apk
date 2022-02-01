package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.j;
import io.flutter.view.FlutterMain;

public class FlutterFragment
  extends Fragment
  implements c.a
{
  private c IXk;
  private final io.flutter.embedding.engine.b.b rdC;
  
  public FlutterFragment()
  {
    AppMethodBeat.i(10085);
    this.rdC = new io.flutter.embedding.engine.b.b()
    {
      public final void onFirstFrameRendered()
      {
        AppMethodBeat.i(10009);
        FlutterFragment.this.onFirstFrameRendered();
        FragmentActivity localFragmentActivity = FlutterFragment.this.getActivity();
        if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
          ((io.flutter.embedding.engine.b.b)localFragmentActivity).onFirstFrameRendered();
        }
        AppMethodBeat.o(10009);
      }
    };
    setArguments(new Bundle());
    AppMethodBeat.o(10085);
  }
  
  public final io.flutter.a.c.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10107);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.a.c.b(getActivity(), parama.IYm);
      AppMethodBeat.o(10107);
      return paramActivity;
    }
    AppMethodBeat.o(10107);
    return null;
  }
  
  public final void a(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10108);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof d)) {
      ((d)localFragmentActivity).a(parama);
    }
    AppMethodBeat.o(10108);
  }
  
  public final f fua()
  {
    AppMethodBeat.i(10105);
    Object localObject = getActivity();
    if ((localObject instanceof g))
    {
      localObject = ((g)localObject).fua();
      AppMethodBeat.o(10105);
      return localObject;
    }
    AppMethodBeat.o(10105);
    return null;
  }
  
  public final io.flutter.embedding.engine.e fuc()
  {
    AppMethodBeat.i(10097);
    Object localObject = getArguments().getStringArray("initialization_args");
    if (localObject != null) {}
    for (;;)
    {
      localObject = new io.flutter.embedding.engine.e((String[])localObject);
      AppMethodBeat.o(10097);
      return localObject;
      localObject = new String[0];
    }
  }
  
  public final String fud()
  {
    AppMethodBeat.i(10098);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(10098);
    return str;
  }
  
  public final boolean fue()
  {
    AppMethodBeat.i(10099);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    AppMethodBeat.o(10099);
    return bool;
  }
  
  public final String fuf()
  {
    AppMethodBeat.i(10100);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(10100);
    return str;
  }
  
  public final String fug()
  {
    AppMethodBeat.i(10102);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(10102);
    return str;
  }
  
  public final String fuh()
  {
    AppMethodBeat.i(10101);
    String str = getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
    AppMethodBeat.o(10101);
    return str;
  }
  
  public final FlutterView.b fui()
  {
    AppMethodBeat.i(10103);
    FlutterView.b localb = FlutterView.b.valueOf(getArguments().getString("flutterview_render_mode", FlutterView.b.IXX.name()));
    AppMethodBeat.o(10103);
    return localb;
  }
  
  public final FlutterView.c fuj()
  {
    AppMethodBeat.i(10104);
    FlutterView.c localc = FlutterView.c.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.c.IYb.name()));
    AppMethodBeat.o(10104);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a ful()
  {
    AppMethodBeat.i(10106);
    Object localObject = getActivity();
    if ((localObject instanceof e))
    {
      io.flutter.a.ftT();
      localObject = (e)localObject;
      getContext();
    }
    for (localObject = ((e)localObject).ful();; localObject = null)
    {
      AppMethodBeat.o(10106);
      return localObject;
    }
  }
  
  public final boolean fum()
  {
    AppMethodBeat.i(10109);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(10109);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10095);
    this.IXk.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(10095);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10086);
    super.onAttach(paramContext);
    this.IXk = new c(this);
    this.IXk.onAttach(paramContext);
    AppMethodBeat.o(10086);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(10087);
    paramLayoutInflater = this.IXk.fuo();
    AppMethodBeat.o(10087);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(10092);
    super.onDestroyView();
    this.IXk.onDestroyView();
    AppMethodBeat.o(10092);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(10093);
    super.onDetach();
    this.IXk.onDetach();
    c localc = this.IXk;
    localc.IXp = null;
    localc.rdu = null;
    localc.rdJ = null;
    localc.IXr = null;
    this.IXk = null;
    AppMethodBeat.o(10093);
  }
  
  public final void onFirstFrameRendered()
  {
    AppMethodBeat.i(10110);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).onFirstFrameRendered();
    }
    AppMethodBeat.o(10110);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(10096);
    super.onLowMemory();
    c localc = this.IXk;
    io.flutter.a.ftS();
    localc.fup();
    localc.rdu.IYo.fvb();
    AppMethodBeat.o(10096);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10090);
    super.onPause();
    this.IXk.onPause();
    AppMethodBeat.o(10090);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10094);
    this.IXk.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(10094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10089);
    super.onResume();
    this.IXk.onResume();
    AppMethodBeat.o(10089);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(10088);
    super.onStart();
    this.IXk.onStart();
    AppMethodBeat.o(10088);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10091);
    super.onStop();
    this.IXk.onStop();
    AppMethodBeat.o(10091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */