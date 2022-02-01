package io.flutter.embedding.engine;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterShellArgs
{
  public static final String ARG_CACHE_SKSL = "--cache-sksl";
  public static final String ARG_DART_FLAGS = "--dart-flags";
  public static final String ARG_DISABLE_SERVICE_AUTH_CODES = "--disable-service-auth-codes";
  public static final String ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "--dump-skp-on-shader-compilation";
  public static final String ARG_ENABLE_DART_PROFILING = "--enable-dart-profiling";
  public static final String ARG_ENABLE_SOFTWARE_RENDERING = "--enable-software-rendering";
  public static final String ARG_ENDLESS_TRACE_BUFFER = "--endless-trace-buffer";
  public static final String ARG_KEY_CACHE_SKSL = "cache-sksl";
  public static final String ARG_KEY_DART_FLAGS = "dart-flags";
  public static final String ARG_KEY_DISABLE_SERVICE_AUTH_CODES = "disable-service-auth-codes";
  public static final String ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "dump-skp-on-shader-compilation";
  public static final String ARG_KEY_ENABLE_DART_PROFILING = "enable-dart-profiling";
  public static final String ARG_KEY_ENABLE_SOFTWARE_RENDERING = "enable-software-rendering";
  public static final String ARG_KEY_ENDLESS_TRACE_BUFFER = "endless-trace-buffer";
  public static final String ARG_KEY_OBSERVATORY_PORT = "observatory-port";
  public static final String ARG_KEY_PURGE_PERSISTENT_CACHE = "purge-persistent-cache";
  public static final String ARG_KEY_SKIA_DETERMINISTIC_RENDERING = "skia-deterministic-rendering";
  public static final String ARG_KEY_START_PAUSED = "start-paused";
  public static final String ARG_KEY_TRACE_SKIA = "trace-skia";
  public static final String ARG_KEY_TRACE_STARTUP = "trace-startup";
  public static final String ARG_KEY_TRACE_SYSTRACE = "trace-systrace";
  public static final String ARG_KEY_USE_TEST_FONTS = "use-test-fonts";
  public static final String ARG_KEY_VERBOSE_LOGGING = "verbose-logging";
  public static final String ARG_OBSERVATORY_PORT = "--observatory-port=";
  public static final String ARG_PURGE_PERSISTENT_CACHE = "--purge-persistent-cache";
  public static final String ARG_SKIA_DETERMINISTIC_RENDERING = "--skia-deterministic-rendering";
  public static final String ARG_START_PAUSED = "--start-paused";
  public static final String ARG_TRACE_SKIA = "--trace-skia";
  public static final String ARG_TRACE_STARTUP = "--trace-startup";
  public static final String ARG_TRACE_SYSTRACE = "--trace-systrace";
  public static final String ARG_USE_TEST_FONTS = "--use-test-fonts";
  public static final String ARG_VERBOSE_LOGGING = "--verbose-logging";
  private Set<String> args;
  
  public FlutterShellArgs(List<String> paramList)
  {
    AppMethodBeat.i(10183);
    this.args = new HashSet(paramList);
    AppMethodBeat.o(10183);
  }
  
  public FlutterShellArgs(Set<String> paramSet)
  {
    AppMethodBeat.i(190038);
    this.args = new HashSet(paramSet);
    AppMethodBeat.o(190038);
  }
  
  public FlutterShellArgs(String[] paramArrayOfString)
  {
    AppMethodBeat.i(10182);
    this.args = new HashSet(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(10182);
  }
  
  public static FlutterShellArgs fromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190017);
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.getBooleanExtra("trace-startup", false)) {
      localArrayList.add("--trace-startup");
    }
    if (paramIntent.getBooleanExtra("start-paused", false)) {
      localArrayList.add("--start-paused");
    }
    int i = paramIntent.getIntExtra("observatory-port", 0);
    if (i > 0) {
      localArrayList.add("--observatory-port=" + Integer.toString(i));
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("endless-trace-buffer", false)) {
      localArrayList.add("--endless-trace-buffer");
    }
    if (paramIntent.getBooleanExtra("use-test-fonts", false)) {
      localArrayList.add("--use-test-fonts");
    }
    if (paramIntent.getBooleanExtra("enable-dart-profiling", false)) {
      localArrayList.add("--enable-dart-profiling");
    }
    if (paramIntent.getBooleanExtra("enable-software-rendering", false)) {
      localArrayList.add("--enable-software-rendering");
    }
    if (paramIntent.getBooleanExtra("skia-deterministic-rendering", false)) {
      localArrayList.add("--skia-deterministic-rendering");
    }
    if (paramIntent.getBooleanExtra("trace-skia", false)) {
      localArrayList.add("--trace-skia");
    }
    if (paramIntent.getBooleanExtra("trace-systrace", false)) {
      localArrayList.add("--trace-systrace");
    }
    if (paramIntent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("--dump-skp-on-shader-compilation");
    }
    if (paramIntent.getBooleanExtra("cache-sksl", false)) {
      localArrayList.add("--cache-sksl");
    }
    if (paramIntent.getBooleanExtra("purge-persistent-cache", false)) {
      localArrayList.add("--purge-persistent-cache");
    }
    if (paramIntent.getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    if (paramIntent.hasExtra("dart-flags")) {
      localArrayList.add("--dart-flags=" + paramIntent.getStringExtra("dart-flags"));
    }
    paramIntent = new FlutterShellArgs(localArrayList);
    AppMethodBeat.o(190017);
    return paramIntent;
  }
  
  public void add(String paramString)
  {
    AppMethodBeat.i(190047);
    this.args.add(paramString);
    AppMethodBeat.o(190047);
  }
  
  public void remove(String paramString)
  {
    AppMethodBeat.i(190053);
    this.args.remove(paramString);
    AppMethodBeat.o(190053);
  }
  
  public String[] toArray()
  {
    AppMethodBeat.i(10184);
    String[] arrayOfString = new String[this.args.size()];
    arrayOfString = (String[])this.args.toArray(arrayOfString);
    AppMethodBeat.o(10184);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterShellArgs
 * JD-Core Version:    0.7.0.1
 */