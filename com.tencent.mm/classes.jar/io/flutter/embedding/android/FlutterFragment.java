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
  c MBi;
  
  public FlutterFragment()
  {
    AppMethodBeat.i(10085);
    setArguments(new Bundle());
    AppMethodBeat.o(10085);
  }
  
  public static a bbJ(String paramString)
  {
    AppMethodBeat.i(213301);
    paramString = new a(paramString, (byte)0);
    AppMethodBeat.o(213301);
    return paramString;
  }
  
  public static b geq()
  {
    AppMethodBeat.i(213300);
    b localb = new b();
    AppMethodBeat.o(213300);
    return localb;
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10107);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.plugin.platform.b(getActivity(), parama.MCn);
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
    AppMethodBeat.i(213306);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof e)) {
      ((e)localFragmentActivity).b(parama);
    }
    AppMethodBeat.o(213306);
  }
  
  public final void cQm()
  {
    AppMethodBeat.i(213307);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).cQm();
    }
    AppMethodBeat.o(213307);
  }
  
  public final void cQn()
  {
    AppMethodBeat.i(213308);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).cQn();
    }
    AppMethodBeat.o(213308);
  }
  
  public final h dfL()
  {
    AppMethodBeat.i(10105);
    Object localObject = getActivity();
    if ((localObject instanceof i))
    {
      localObject = ((i)localObject).dfL();
      AppMethodBeat.o(10105);
      return localObject;
    }
    AppMethodBeat.o(10105);
    return null;
  }
  
  public final String dfO()
  {
    AppMethodBeat.i(10098);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(10098);
    return str;
  }
  
  public final String dfP()
  {
    AppMethodBeat.i(10100);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(10100);
    return str;
  }
  
  public final String dfQ()
  {
    AppMethodBeat.i(10101);
    String str = getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
    AppMethodBeat.o(10101);
    return str;
  }
  
  public final String dfR()
  {
    AppMethodBeat.i(10102);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(10102);
    return str;
  }
  
  public final io.flutter.embedding.engine.a dfU()
  {
    AppMethodBeat.i(10106);
    Object localObject = getActivity();
    if ((localObject instanceof f))
    {
      io.flutter.a.gea();
      localObject = (f)localObject;
      getContext();
    }
    for (localObject = ((f)localObject).dfU();; localObject = null)
    {
      AppMethodBeat.o(10106);
      return localObject;
    }
  }
  
  public final d gej()
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
  
  public final boolean gek()
  {
    AppMethodBeat.i(10099);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((dfO() != null) || (this.MBi.Mld))
    {
      AppMethodBeat.o(10099);
      return bool;
    }
    bool = getArguments().getBoolean("destroy_engine_with_fragment", true);
    AppMethodBeat.o(10099);
    return bool;
  }
  
  public final g gel()
  {
    AppMethodBeat.i(213304);
    g localg = g.valueOf(getArguments().getString("flutterview_render_mode", g.MCa.name()));
    AppMethodBeat.o(213304);
    return localg;
  }
  
  public final j gem()
  {
    AppMethodBeat.i(213305);
    j localj = j.valueOf(getArguments().getString("flutterview_transparency_mode", j.MCe.name()));
    AppMethodBeat.o(213305);
    return localj;
  }
  
  public final boolean gen()
  {
    AppMethodBeat.i(10109);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(10109);
    return bool;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(213302);
    super.onActivityCreated(paramBundle);
    this.MBi.geo();
    AppMethodBeat.o(213302);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10095);
    this.MBi.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(10095);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10086);
    super.onAttach(paramContext);
    this.MBi = new c(this);
    this.MBi.fYW();
    AppMethodBeat.o(10086);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(10087);
    paramLayoutInflater = this.MBi.fYY();
    AppMethodBeat.o(10087);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(10092);
    super.onDestroyView();
    this.MBi.onDestroyView();
    AppMethodBeat.o(10092);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(10093);
    super.onDetach();
    this.MBi.onDetach();
    c localc = this.MBi;
    localc.MBj = null;
    localc.tiq = null;
    localc.tiF = null;
    localc.Mlc = null;
    this.MBi = null;
    AppMethodBeat.o(10093);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(10096);
    super.onLowMemory();
    c localc = this.MBi;
    io.flutter.a.gea();
    localc.fZa();
    localc.tiq.MCq.gfg();
    AppMethodBeat.o(10096);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10090);
    super.onPause();
    this.MBi.onPause();
    AppMethodBeat.o(10090);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10094);
    this.MBi.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(10094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10089);
    super.onResume();
    this.MBi.onResume();
    AppMethodBeat.o(10089);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(213303);
    super.onSaveInstanceState(paramBundle);
    this.MBi.gep();
    AppMethodBeat.o(213303);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(10088);
    super.onStart();
    this.MBi.onStart();
    AppMethodBeat.o(10088);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10091);
    super.onStop();
    this.MBi.onStop();
    AppMethodBeat.o(10091);
  }
  
  public static final class a
  {
    private final Class<? extends FlutterFragment> MBq;
    private final String MBr;
    boolean MBs = false;
    g MBt = g.MCa;
    j MBu = j.MCe;
    boolean MBv = true;
    
    private a(Class<? extends FlutterFragment> paramClass, String paramString)
    {
      this.MBq = paramClass;
      this.MBr = paramString;
    }
    
    private a(String paramString)
    {
      this(FlutterFragment.class, paramString);
    }
    
    public final <T extends FlutterFragment> T ger()
    {
      AppMethodBeat.i(213362);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.MBq.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.MBq.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(213362);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.MBq.getName() + ")", localException);
        AppMethodBeat.o(213362);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("cached_engine_id", this.MBr);
      localBundle.putBoolean("destroy_engine_with_fragment", this.MBs);
      if (this.MBt != null)
      {
        localObject = this.MBt.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.MBu == null) {
          break label221;
        }
      }
      label221:
      for (Object localObject = this.MBu.name();; localObject = j.MCe.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.MBv);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(213362);
        return localFlutterFragment;
        localObject = g.MCa.name();
        break;
      }
    }
  }
  
  public static final class b
  {
    private final Class<? extends FlutterFragment> MBq = FlutterFragment.class;
    g MBt = g.MCa;
    j MBu = j.MCe;
    boolean MBv = true;
    String MBw = null;
    d MBx = null;
    String MkH = "main";
    String MkI = "/";
    
    public final <T extends FlutterFragment> T ger()
    {
      AppMethodBeat.i(213363);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.MBq.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.MBq.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(213363);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.MBq.getName() + ")", localException);
        AppMethodBeat.o(213363);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("initial_route", this.MkI);
      localBundle.putString("app_bundle_path", this.MBw);
      localBundle.putString("dart_entrypoint", this.MkH);
      if (this.MBx != null) {
        localBundle.putStringArray("initialization_args", this.MBx.toArray());
      }
      if (this.MBt != null)
      {
        localObject = this.MBt.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.MBu == null) {
          break label258;
        }
      }
      label258:
      for (Object localObject = this.MBu.name();; localObject = j.MCe.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.MBv);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(213363);
        return localFlutterFragment;
        localObject = g.MCa.name();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */