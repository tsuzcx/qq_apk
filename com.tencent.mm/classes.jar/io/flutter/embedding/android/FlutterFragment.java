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
import io.flutter.embedding.engine.d;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Constructor;

public class FlutterFragment
  extends Fragment
  implements c.a
{
  c KKu;
  
  public FlutterFragment()
  {
    AppMethodBeat.i(10085);
    setArguments(new Bundle());
    AppMethodBeat.o(10085);
  }
  
  public static a aVG(String paramString)
  {
    AppMethodBeat.i(192852);
    paramString = new a(paramString, (byte)0);
    AppMethodBeat.o(192852);
    return paramString;
  }
  
  public static b fMR()
  {
    AppMethodBeat.i(192851);
    b localb = new b();
    AppMethodBeat.o(192851);
    return localb;
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10107);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.plugin.platform.b(getActivity(), parama.KLq);
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
    AppMethodBeat.i(192855);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof e)) {
      ((e)localFragmentActivity).b(parama);
    }
    AppMethodBeat.o(192855);
  }
  
  public final void cHX()
  {
    AppMethodBeat.i(192856);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).cHX();
    }
    AppMethodBeat.o(192856);
  }
  
  public final void cHY()
  {
    AppMethodBeat.i(192857);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof io.flutter.embedding.engine.b.b)) {
      ((io.flutter.embedding.engine.b.b)localFragmentActivity).cHY();
    }
    AppMethodBeat.o(192857);
  }
  
  public final String cWC()
  {
    AppMethodBeat.i(10098);
    String str = getArguments().getString("cached_engine_id", null);
    AppMethodBeat.o(10098);
    return str;
  }
  
  public final String cWD()
  {
    AppMethodBeat.i(10100);
    String str = getArguments().getString("dart_entrypoint", "main");
    AppMethodBeat.o(10100);
    return str;
  }
  
  public final String cWE()
  {
    AppMethodBeat.i(10101);
    String str = getArguments().getString("app_bundle_path", FlutterMain.findAppBundlePath());
    AppMethodBeat.o(10101);
    return str;
  }
  
  public final String cWF()
  {
    AppMethodBeat.i(10102);
    String str = getArguments().getString("initial_route");
    AppMethodBeat.o(10102);
    return str;
  }
  
  public final FlutterView.b cWG()
  {
    AppMethodBeat.i(10103);
    FlutterView.b localb = FlutterView.b.valueOf(getArguments().getString("flutterview_render_mode", FlutterView.b.KLd.name()));
    AppMethodBeat.o(10103);
    return localb;
  }
  
  public final FlutterView.c cWH()
  {
    AppMethodBeat.i(10104);
    FlutterView.c localc = FlutterView.c.valueOf(getArguments().getString("flutterview_transparency_mode", FlutterView.c.KLh.name()));
    AppMethodBeat.o(10104);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a cWI()
  {
    AppMethodBeat.i(10106);
    Object localObject = getActivity();
    if ((localObject instanceof f))
    {
      io.flutter.a.fMF();
      localObject = (f)localObject;
      getContext();
    }
    for (localObject = ((f)localObject).cWI();; localObject = null)
    {
      AppMethodBeat.o(10106);
      return localObject;
    }
  }
  
  public final g cWz()
  {
    AppMethodBeat.i(10105);
    Object localObject = getActivity();
    if ((localObject instanceof h))
    {
      localObject = ((h)localObject).cWz();
      AppMethodBeat.o(10105);
      return localObject;
    }
    AppMethodBeat.o(10105);
    return null;
  }
  
  public final d fMM()
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
  
  public final boolean fMN()
  {
    AppMethodBeat.i(10099);
    boolean bool = getArguments().getBoolean("destroy_engine_with_fragment", false);
    if ((cWC() != null) || (this.KKu.Kvc))
    {
      AppMethodBeat.o(10099);
      return bool;
    }
    bool = getArguments().getBoolean("destroy_engine_with_fragment", true);
    AppMethodBeat.o(10099);
    return bool;
  }
  
  public final boolean fMO()
  {
    AppMethodBeat.i(10109);
    boolean bool = getArguments().getBoolean("should_attach_engine_to_activity");
    AppMethodBeat.o(10109);
    return bool;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(192853);
    super.onActivityCreated(paramBundle);
    this.KKu.fMP();
    AppMethodBeat.o(192853);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10095);
    this.KKu.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(10095);
  }
  
  public void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10086);
    super.onAttach(paramContext);
    this.KKu = new c(this);
    this.KKu.fHF();
    AppMethodBeat.o(10086);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(10087);
    paramLayoutInflater = this.KKu.fHH();
    AppMethodBeat.o(10087);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(10092);
    super.onDestroyView();
    this.KKu.onDestroyView();
    AppMethodBeat.o(10092);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(10093);
    super.onDetach();
    this.KKu.onDetach();
    c localc = this.KKu;
    localc.KKv = null;
    localc.slN = null;
    localc.smb = null;
    localc.Kvb = null;
    this.KKu = null;
    AppMethodBeat.o(10093);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(10096);
    super.onLowMemory();
    c localc = this.KKu;
    io.flutter.a.fMD();
    localc.fHJ();
    localc.slN.KLt.fNH();
    AppMethodBeat.o(10096);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10090);
    super.onPause();
    this.KKu.onPause();
    AppMethodBeat.o(10090);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10094);
    this.KKu.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(10094);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10089);
    super.onResume();
    this.KKu.onResume();
    AppMethodBeat.o(10089);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(192854);
    super.onSaveInstanceState(paramBundle);
    this.KKu.fMQ();
    AppMethodBeat.o(192854);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(10088);
    super.onStart();
    this.KKu.onStart();
    AppMethodBeat.o(10088);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10091);
    super.onStop();
    this.KKu.onStop();
    AppMethodBeat.o(10091);
  }
  
  public static final class a
  {
    private final Class<? extends FlutterFragment> KKC;
    private final String KKD;
    boolean KKE = false;
    FlutterView.c KKF = FlutterView.c.KLh;
    boolean KKG = true;
    FlutterView.b KuI = FlutterView.b.KLd;
    
    private a(Class<? extends FlutterFragment> paramClass, String paramString)
    {
      this.KKC = paramClass;
      this.KKD = paramString;
    }
    
    private a(String paramString)
    {
      this(FlutterFragment.class, paramString);
    }
    
    public final <T extends FlutterFragment> T fMS()
    {
      AppMethodBeat.i(192897);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.KKC.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.KKC.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(192897);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.KKC.getName() + ")", localException);
        AppMethodBeat.o(192897);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("cached_engine_id", this.KKD);
      localBundle.putBoolean("destroy_engine_with_fragment", this.KKE);
      if (this.KuI != null)
      {
        localObject = this.KuI.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.KKF == null) {
          break label221;
        }
      }
      label221:
      for (Object localObject = this.KKF.name();; localObject = FlutterView.c.KLh.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.KKG);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(192897);
        return localFlutterFragment;
        localObject = FlutterView.b.KLd.name();
        break;
      }
    }
  }
  
  public static final class b
  {
    private final Class<? extends FlutterFragment> KKC = FlutterFragment.class;
    FlutterView.c KKF = FlutterView.c.KLh;
    boolean KKG = true;
    String KKH = null;
    d KKI = null;
    String KuG = "main";
    String KuH = "/";
    FlutterView.b KuI = FlutterView.b.KLd;
    
    public final <T extends FlutterFragment> T fMS()
    {
      AppMethodBeat.i(192898);
      FlutterFragment localFlutterFragment;
      try
      {
        localFlutterFragment = (FlutterFragment)this.KKC.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        if (localFlutterFragment == null)
        {
          RuntimeException localRuntimeException = new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.KKC.getCanonicalName() + ") does not match the expected return type.");
          AppMethodBeat.o(192898);
          throw localRuntimeException;
        }
      }
      catch (Exception localException)
      {
        localObject = new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.KKC.getName() + ")", localException);
        AppMethodBeat.o(192898);
        throw ((Throwable)localObject);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("initial_route", this.KuH);
      localBundle.putString("app_bundle_path", this.KKH);
      localBundle.putString("dart_entrypoint", this.KuG);
      if (this.KKI != null) {
        localBundle.putStringArray("initialization_args", this.KKI.fNp());
      }
      if (this.KuI != null)
      {
        localObject = this.KuI.name();
        localBundle.putString("flutterview_render_mode", (String)localObject);
        if (this.KKF == null) {
          break label258;
        }
      }
      label258:
      for (Object localObject = this.KKF.name();; localObject = FlutterView.c.KLh.name())
      {
        localBundle.putString("flutterview_transparency_mode", (String)localObject);
        localBundle.putBoolean("should_attach_engine_to_activity", this.KKG);
        localBundle.putBoolean("destroy_engine_with_fragment", true);
        localFlutterFragment.setArguments(localBundle);
        AppMethodBeat.o(192898);
        return localFlutterFragment;
        localObject = FlutterView.b.KLd.name();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment
 * JD-Core Version:    0.7.0.1
 */