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
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Constructor;

public class FlutterFragment
  extends Fragment
  implements c.a
{
  c SMA;
  
  public FlutterFragment()
  {
    AppMethodBeat.i(10085);
    setArguments(new Bundle());
    AppMethodBeat.o(10085);
  }
  
  public static a bsZ(String paramString)
  {
    AppMethodBeat.i(215017);
    paramString = new a(paramString, (byte)0);
    AppMethodBeat.o(215017);
    return paramString;
  }
  
  public static b hwr()
  {
    AppMethodBeat.i(215016);
    b localb = new b();
    AppMethodBeat.o(215016);
    return localb;
  }
  
  public final j KF()
  {
    AppMethodBeat.i(10105);
    Object localObject = getActivity();
    if ((localObject instanceof k))
    {
      localObject = ((k)localObject).KF();
      AppMethodBeat.o(10105);
      return localObject;
    }
    AppMethodBeat.o(10105);
    return null;
  }
  
  public final String KJ()
  {
    AppMethodBeat.i(10098);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(10098);
    return str;
  }
  
  public final String KK()
  {
    AppMethodBeat.i(10100);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(10100);
    return str;
  }
  
  public final String KL()
  {
    AppMethodBeat.i(10101);
    String str = getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
    AppMethodBeat.o(10101);
    return str;
  }
  
  public final String KM()
  {
    AppMethodBeat.i(10102);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(10102);
    return str;
  }
  
  public final io.flutter.embedding.engine.a KP()
  {
    AppMethodBeat.i(10106);
    Object localObject = getActivity();
    if ((localObject instanceof f))
    {
      io.flutter.a.hwd();
      localObject = (f)localObject;
      getContext();
    }
    for (localObject = ((f)localObject).KP();; localObject = null)
    {
      AppMethodBeat.o(10106);
      return localObject;
    }
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10107);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.plugin.platform.b(getActivity(), parama.SOe);
      AppMethodBeat.o(10107);
      return paramActivity;
    }
    AppMethodBeat.o(10107);
    return null;
  }
  
  public final void b(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10108);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof e)) {
      ((e)localFragmentActivity).b(parama);
    }
    AppMethodBeat.o(10108);
  }
  
  public final void c(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(215022);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof e)) {
      ((e)localFragmentActivity).c(parama);
    }
    AppMethodBeat.o(215022);
  }
  
  public final void dLt()
  {
    AppMethodBeat.i(215023);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).dLt();
    }
    AppMethodBeat.o(215023);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(215024);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).dLu();
    }
    AppMethodBeat.o(215024);
  }
  
  public final d hwl()
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
  
  public final boolean hwm()
  {
    AppMethodBeat.i(10099);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((KJ() != null) || (this.SMA.Syd))
    {
      AppMethodBeat.o(10099);
      return bool;
    }
    bool = getArguments().getBoolean("destroy_engine_with_fragment", true);
    AppMethodBeat.o(10099);
    return bool;
  }
  
  public final i hwn()
  {
    AppMethodBeat.i(215020);
    i locali = i.valueOf(getArguments().getString("flutterview_render_mode", i.SNO.name()));
    AppMethodBeat.o(215020);
    return locali;
  }
  
  public final l hwo()
  {
    AppMethodBeat.i(215021);
    l locall = l.valueOf(getArguments().getString("flutterview_transparency_mode", l.SNT.name()));
    AppMethodBeat.o(215021);
    return locall;
  }
  
  public final boolean hwp()
  {
    AppMethodBeat.i(10109);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(10109);
    return bool;
  }
  
  public final boolean hwq()
  {
    AppMethodBeat.i(215025);
    if (getArguments().containsKey("enable_state_restoration"))
    {
      boolean bool = getArguments().getBoolean("enable_state_restoration");
      AppMethodBeat.o(215025);
      return bool;
    }
    if (KJ() != null)
    {
      AppMethodBeat.o(215025);
      return false;
    }
    AppMethodBeat.o(215025);
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(215018);
    super.onActivityCreated(paramBundle);
    this.SMA.onActivityCreated(paramBundle);
    AppMethodBeat.o(215018);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10095);
    this.SMA.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(10095);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10086);
    super.onAttach(paramContext);
    this.SMA = new c(this);
    this.SMA.hrO();
    AppMethodBeat.o(10086);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(10087);
    paramLayoutInflater = this.SMA.hrQ();
    AppMethodBeat.o(10087);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(10092);
    super.onDestroyView();
    this.SMA.onDestroyView();
    AppMethodBeat.o(10092);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(10093);
    super.onDetach();
    this.SMA.onDetach();
    c localc = this.SMA;
    localc.SMB = null;
    localc.wJi = null;
    localc.wKM = null;
    localc.wKN = null;
    this.SMA = null;
    AppMethodBeat.o(10093);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(10096);
    super.onLowMemory();
    c localc = this.SMA;
    io.flutter.a.hwd();
    localc.hrS();
    localc.wJi.SNW.notifyLowMemoryWarning();
    localc.wJi.SOh.hxj();
    AppMethodBeat.o(10096);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10090);
    super.onPause();
    this.SMA.onPause();
    AppMethodBeat.o(10090);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10094);
    this.SMA.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(10094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10089);
    super.onResume();
    this.SMA.onResume();
    AppMethodBeat.o(10089);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(215019);
    super.onSaveInstanceState(paramBundle);
    this.SMA.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(215019);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(10088);
    super.onStart();
    this.SMA.onStart();
    AppMethodBeat.o(10088);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10091);
    super.onStop();
    this.SMA.onStop();
    AppMethodBeat.o(10091);
  }
  
  public static final class a
  {
    private final Class<? extends FlutterFragment> SMI;
    private final String SMJ;
    boolean SMK = false;
    i SML = i.SNO;
    l SMM = l.SNT;
    boolean SMN = true;
    
    private a(Class<? extends FlutterFragment> paramClass, String paramString)
    {
      this.SMI = paramClass;
      this.SMJ = paramString;
    }
    
    private a(String paramString)
    {
      this(FlutterFragment.class, paramString);
    }
    
    public final <T extends FlutterFragment> T hws()
    {
      AppMethodBeat.i(215095);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.SMI.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.SMI.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(215095);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.SMI.getName() + ")", localException);
        AppMethodBeat.o(215095);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("cached_engine_id", this.SMJ);
      localBundle.putBoolean("destroy_engine_with_fragment", this.SMK);
      if (this.SML != null)
      {
        localObject = this.SML.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.SMM == null) {
          break label221;
        }
      }
      label221:
      for (Object localObject = this.SMM.name();; localObject = l.SNT.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.SMN);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(215095);
        return localFlutterFragment;
        localObject = i.SNO.name();
        break;
      }
    }
  }
  
  public static final class b
  {
    private final Class<? extends FlutterFragment> SMI = FlutterFragment.class;
    i SML = i.SNO;
    l SMM = l.SNT;
    boolean SMN = true;
    String SMO = null;
    d SMP = null;
    String SxI = "main";
    String SxJ = "/";
    
    public final <T extends FlutterFragment> T hws()
    {
      AppMethodBeat.i(215100);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.SMI.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.SMI.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(215100);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.SMI.getName() + ")", localException);
        AppMethodBeat.o(215100);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("initial_route", this.SxJ);
      localBundle.putString("app_bundle_path", this.SMO);
      localBundle.putString("dart_entrypoint", this.SxI);
      if (this.SMP != null) {
        localBundle.putStringArray("initialization_args", this.SMP.toArray());
      }
      if (this.SML != null)
      {
        localObject = this.SML.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.SMM == null) {
          break label258;
        }
      }
      label258:
      for (Object localObject = this.SMM.name();; localObject = l.SNT.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.SMN);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(215100);
        return localFlutterFragment;
        localObject = i.SNO.name();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */