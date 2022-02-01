package io.flutter.embedding.engine.deferredcomponents;

import android.util.SparseArray;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallRequest.Builder;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayStoreDeferredComponentManager
  implements DeferredComponentManager
{
  public static final String aaqU;
  private FlutterJNI aapT;
  private SplitInstallManager aaqV;
  private io.flutter.embedding.engine.b.b aaqW;
  private SparseArray<String> aaqX;
  private Map<String, Integer> aaqY;
  protected SparseArray<String> aaqZ;
  private a aara;
  
  static
  {
    AppMethodBeat.i(253330);
    aaqU = DeferredComponentManager.class.getName() + ".loadingUnitMapping";
    AppMethodBeat.o(253330);
  }
  
  private boolean verifyJNI()
  {
    AppMethodBeat.i(253323);
    if (this.aapT == null)
    {
      io.flutter.b.iAh();
      AppMethodBeat.o(253323);
      return false;
    }
    AppMethodBeat.o(253323);
    return true;
  }
  
  public final void a(io.flutter.embedding.engine.b.b paramb)
  {
    this.aaqW = paramb;
  }
  
  public final void dE(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(253326);
    if (paramString != null) {}
    for (final String str = paramString; str == null; str = (String)this.aaqZ.get(paramInt))
    {
      io.flutter.b.iAh();
      AppMethodBeat.o(253326);
      return;
    }
    SplitInstallRequest localSplitInstallRequest = SplitInstallRequest.newBuilder().addModule(str).build();
    this.aaqV.startInstall(localSplitInstallRequest).addOnSuccessListener(new OnSuccessListener() {}).addOnFailureListener(new OnFailureListener() {});
    AppMethodBeat.o(253326);
  }
  
  public final String dF(int paramInt, String paramString)
  {
    AppMethodBeat.i(253327);
    if (paramString != null) {}
    while (paramString == null)
    {
      io.flutter.b.iAh();
      AppMethodBeat.o(253327);
      return "unknown";
      paramString = (String)this.aaqZ.get(paramInt);
    }
    if (!this.aaqY.containsKey(paramString))
    {
      if (this.aaqV.getInstalledModules().contains(paramString))
      {
        AppMethodBeat.o(253327);
        return "installedPendingLoad";
      }
      AppMethodBeat.o(253327);
      return "unknown";
    }
    paramInt = ((Integer)this.aaqY.get(paramString)).intValue();
    paramString = (String)this.aaqX.get(paramInt);
    AppMethodBeat.o(253327);
    return paramString;
  }
  
  public final boolean dG(int paramInt, String paramString)
  {
    AppMethodBeat.i(253328);
    if (paramString != null) {}
    while (paramString == null)
    {
      io.flutter.b.iAh();
      AppMethodBeat.o(253328);
      return false;
      paramString = (String)this.aaqZ.get(paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    this.aaqV.deferredUninstall(localArrayList);
    if (this.aaqY.get(paramString) != null) {
      this.aaqX.delete(((Integer)this.aaqY.get(paramString)).intValue());
    }
    AppMethodBeat.o(253328);
    return true;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(253329);
    this.aaqV.unregisterListener(this.aara);
    this.aaqW = null;
    this.aapT = null;
    AppMethodBeat.o(253329);
  }
  
  public void setJNI(FlutterJNI paramFlutterJNI)
  {
    this.aapT = paramFlutterJNI;
  }
  
  final class a
    implements SplitInstallStateUpdatedListener
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager
 * JD-Core Version:    0.7.0.1
 */