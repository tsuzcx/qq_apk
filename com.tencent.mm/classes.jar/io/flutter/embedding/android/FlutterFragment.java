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
import io.flutter.embedding.engine.d;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Constructor;

public class FlutterFragment
  extends Fragment
  implements c.a
{
  c MYn;
  
  public FlutterFragment()
  {
    AppMethodBeat.i(10085);
    setArguments(new Bundle());
    AppMethodBeat.o(10085);
  }
  
  public static a bdn(String paramString)
  {
    AppMethodBeat.i(197883);
    paramString = new a(paramString, (byte)0);
    AppMethodBeat.o(197883);
    return paramString;
  }
  
  public static b giT()
  {
    AppMethodBeat.i(197882);
    b localb = new b();
    AppMethodBeat.o(197882);
    return localb;
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10107);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.plugin.platform.b(getActivity(), parama.MZs);
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
    if ((localFragmentActivity instanceof e)) {
      ((e)localFragmentActivity).a(parama);
    }
    AppMethodBeat.o(10108);
  }
  
  public final void b(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(197888);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof e)) {
      ((e)localFragmentActivity).b(parama);
    }
    AppMethodBeat.o(197888);
  }
  
  public final void cSR()
  {
    AppMethodBeat.i(197889);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).cSR();
    }
    AppMethodBeat.o(197889);
  }
  
  public final void cSS()
  {
    AppMethodBeat.i(197890);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).cSS();
    }
    AppMethodBeat.o(197890);
  }
  
  public final String diI()
  {
    AppMethodBeat.i(10098);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(10098);
    return str;
  }
  
  public final String diJ()
  {
    AppMethodBeat.i(10100);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(10100);
    return str;
  }
  
  public final String diK()
  {
    AppMethodBeat.i(10101);
    String str = getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
    AppMethodBeat.o(10101);
    return str;
  }
  
  public final String diL()
  {
    AppMethodBeat.i(10102);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(10102);
    return str;
  }
  
  public final io.flutter.embedding.engine.a diO()
  {
    AppMethodBeat.i(10106);
    Object localObject = getActivity();
    if ((localObject instanceof f))
    {
      io.flutter.a.giD();
      localObject = (f)localObject;
      getContext();
    }
    for (localObject = ((f)localObject).diO();; localObject = null)
    {
      AppMethodBeat.o(10106);
      return localObject;
    }
  }
  
  public final h diP()
  {
    AppMethodBeat.i(10105);
    Object localObject = getActivity();
    if ((localObject instanceof i))
    {
      localObject = ((i)localObject).diP();
      AppMethodBeat.o(10105);
      return localObject;
    }
    AppMethodBeat.o(10105);
    return null;
  }
  
  public final d giM()
  {
    AppMethodBeat.i(10097);
    Object localObject = getArguments().getStringArray("initialization_args");
    if (localObject != null) {}
    for (;;)
    {
      localObject = new d((String[])localObject);
      AppMethodBeat.o(10097);
      return localObject;
      localObject = new String[0];
    }
  }
  
  public final boolean giN()
  {
    AppMethodBeat.i(10099);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((diI() != null) || (this.MYn.MIa))
    {
      AppMethodBeat.o(10099);
      return bool;
    }
    bool = getArguments().getBoolean("destroy_engine_with_fragment", true);
    AppMethodBeat.o(10099);
    return bool;
  }
  
  public final g giO()
  {
    AppMethodBeat.i(197886);
    g localg = g.valueOf(getArguments().getString("flutterview_render_mode", g.MZf.name()));
    AppMethodBeat.o(197886);
    return localg;
  }
  
  public final j giP()
  {
    AppMethodBeat.i(197887);
    j localj = j.valueOf(getArguments().getString("flutterview_transparency_mode", j.MZj.name()));
    AppMethodBeat.o(197887);
    return localj;
  }
  
  public final boolean giQ()
  {
    AppMethodBeat.i(10109);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(10109);
    return bool;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(197884);
    super.onActivityCreated(paramBundle);
    this.MYn.giR();
    AppMethodBeat.o(197884);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10095);
    this.MYn.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(10095);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10086);
    super.onAttach(paramContext);
    this.MYn = new c(this);
    this.MYn.gdx();
    AppMethodBeat.o(10086);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(10087);
    paramLayoutInflater = this.MYn.gdz();
    AppMethodBeat.o(10087);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(10092);
    super.onDestroyView();
    this.MYn.onDestroyView();
    AppMethodBeat.o(10092);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(10093);
    super.onDetach();
    this.MYn.onDetach();
    c localc = this.MYn;
    localc.MYo = null;
    localc.tti = null;
    localc.ttx = null;
    localc.MHZ = null;
    this.MYn = null;
    AppMethodBeat.o(10093);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(10096);
    super.onLowMemory();
    c localc = this.MYn;
    io.flutter.a.giD();
    localc.gdB();
    localc.tti.MZv.gjI();
    AppMethodBeat.o(10096);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10090);
    super.onPause();
    this.MYn.onPause();
    AppMethodBeat.o(10090);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10094);
    this.MYn.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(10094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10089);
    super.onResume();
    this.MYn.onResume();
    AppMethodBeat.o(10089);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(197885);
    super.onSaveInstanceState(paramBundle);
    this.MYn.giS();
    AppMethodBeat.o(197885);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(10088);
    super.onStart();
    this.MYn.onStart();
    AppMethodBeat.o(10088);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10091);
    super.onStop();
    this.MYn.onStop();
    AppMethodBeat.o(10091);
  }
  
  public static final class a
  {
    boolean MYA = true;
    private final Class<? extends FlutterFragment> MYv;
    private final String MYw;
    boolean MYx = false;
    g MYy = g.MZf;
    j MYz = j.MZj;
    
    private a(Class<? extends FlutterFragment> paramClass, String paramString)
    {
      this.MYv = paramClass;
      this.MYw = paramString;
    }
    
    private a(String paramString)
    {
      this(FlutterFragment.class, paramString);
    }
    
    public final <T extends FlutterFragment> T giU()
    {
      AppMethodBeat.i(197944);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.MYv.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.MYv.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(197944);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.MYv.getName() + ")", localException);
        AppMethodBeat.o(197944);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("cached_engine_id", this.MYw);
      localBundle.putBoolean("destroy_engine_with_fragment", this.MYx);
      if (this.MYy != null)
      {
        localObject = this.MYy.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.MYz == null) {
          break label221;
        }
      }
      label221:
      for (Object localObject = this.MYz.name();; localObject = j.MZj.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.MYA);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(197944);
        return localFlutterFragment;
        localObject = g.MZf.name();
        break;
      }
    }
  }
  
  public static final class b
  {
    String MHF = "main";
    String MHG = "/";
    boolean MYA = true;
    String MYB = null;
    d MYC = null;
    private final Class<? extends FlutterFragment> MYv = FlutterFragment.class;
    g MYy = g.MZf;
    j MYz = j.MZj;
    
    public final <T extends FlutterFragment> T giU()
    {
      AppMethodBeat.i(197945);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.MYv.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.MYv.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(197945);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.MYv.getName() + ")", localException);
        AppMethodBeat.o(197945);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("initial_route", this.MHG);
      localBundle.putString("app_bundle_path", this.MYB);
      localBundle.putString("dart_entrypoint", this.MHF);
      if (this.MYC != null) {
        localBundle.putStringArray("initialization_args", this.MYC.toArray());
      }
      if (this.MYy != null)
      {
        localObject = this.MYy.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.MYz == null) {
          break label258;
        }
      }
      label258:
      for (Object localObject = this.MYz.name();; localObject = j.MZj.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.MYA);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(197945);
        return localFlutterFragment;
        localObject = g.MZf.name();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */