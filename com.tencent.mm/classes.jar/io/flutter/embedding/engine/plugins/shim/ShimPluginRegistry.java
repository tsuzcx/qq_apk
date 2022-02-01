package io.flutter.embedding.engine.plugins.shim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShimPluginRegistry
  implements io.flutter.plugin.common.PluginRegistry
{
  private static final String TAG = "ShimPluginRegistry";
  private final FlutterEngine flutterEngine;
  private final Map<String, Object> pluginMap;
  private final ShimRegistrarAggregate shimRegistrarAggregate;
  
  public ShimPluginRegistry(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190312);
    this.pluginMap = new HashMap();
    this.flutterEngine = paramFlutterEngine;
    this.shimRegistrarAggregate = new ShimRegistrarAggregate(null);
    this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
    AppMethodBeat.o(190312);
  }
  
  public boolean hasPlugin(String paramString)
  {
    AppMethodBeat.i(190326);
    boolean bool = this.pluginMap.containsKey(paramString);
    AppMethodBeat.o(190326);
    return bool;
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    AppMethodBeat.i(190320);
    Log.v("ShimPluginRegistry", "Creating plugin Registrar for '" + paramString + "'");
    if (this.pluginMap.containsKey(paramString))
    {
      paramString = new IllegalStateException("Plugin key " + paramString + " is already in use");
      AppMethodBeat.o(190320);
      throw paramString;
    }
    this.pluginMap.put(paramString, null);
    paramString = new ShimRegistrar(paramString, this.pluginMap);
    this.shimRegistrarAggregate.addPlugin(paramString);
    AppMethodBeat.o(190320);
    return paramString;
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    AppMethodBeat.i(190334);
    paramString = this.pluginMap.get(paramString);
    AppMethodBeat.o(190334);
    return paramString;
  }
  
  static class ShimRegistrarAggregate
    implements FlutterPlugin, ActivityAware
  {
    private ActivityPluginBinding activityPluginBinding;
    private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
    private final Set<ShimRegistrar> shimRegistrars;
    
    private ShimRegistrarAggregate()
    {
      AppMethodBeat.i(190313);
      this.shimRegistrars = new HashSet();
      AppMethodBeat.o(190313);
    }
    
    public void addPlugin(ShimRegistrar paramShimRegistrar)
    {
      AppMethodBeat.i(190325);
      this.shimRegistrars.add(paramShimRegistrar);
      if (this.flutterPluginBinding != null) {
        paramShimRegistrar.onAttachedToEngine(this.flutterPluginBinding);
      }
      if (this.activityPluginBinding != null) {
        paramShimRegistrar.onAttachedToActivity(this.activityPluginBinding);
      }
      AppMethodBeat.o(190325);
    }
    
    public void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
    {
      AppMethodBeat.i(190342);
      this.activityPluginBinding = paramActivityPluginBinding;
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onAttachedToActivity(paramActivityPluginBinding);
      }
      AppMethodBeat.o(190342);
    }
    
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
    {
      AppMethodBeat.i(190331);
      this.flutterPluginBinding = paramFlutterPluginBinding;
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onAttachedToEngine(paramFlutterPluginBinding);
      }
      AppMethodBeat.o(190331);
    }
    
    public void onDetachedFromActivity()
    {
      AppMethodBeat.i(190363);
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onDetachedFromActivity();
      }
      this.activityPluginBinding = null;
      AppMethodBeat.o(190363);
    }
    
    public void onDetachedFromActivityForConfigChanges()
    {
      AppMethodBeat.i(190349);
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onDetachedFromActivity();
      }
      this.activityPluginBinding = null;
      AppMethodBeat.o(190349);
    }
    
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
    {
      AppMethodBeat.i(190338);
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onDetachedFromEngine(paramFlutterPluginBinding);
      }
      this.flutterPluginBinding = null;
      this.activityPluginBinding = null;
      AppMethodBeat.o(190338);
    }
    
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
    {
      AppMethodBeat.i(190358);
      this.activityPluginBinding = paramActivityPluginBinding;
      Iterator localIterator = this.shimRegistrars.iterator();
      while (localIterator.hasNext()) {
        ((ShimRegistrar)localIterator.next()).onReattachedToActivityForConfigChanges(paramActivityPluginBinding);
      }
      AppMethodBeat.o(190358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry
 * JD-Core Version:    0.7.0.1
 */