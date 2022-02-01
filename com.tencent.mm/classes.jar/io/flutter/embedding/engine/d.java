package io.flutter.embedding.engine;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d
{
  private Set<String> KLS;
  
  private d(List<String> paramList)
  {
    AppMethodBeat.i(10183);
    this.KLS = new HashSet(paramList);
    AppMethodBeat.o(10183);
  }
  
  public d(String[] paramArrayOfString)
  {
    AppMethodBeat.i(10182);
    this.KLS = new HashSet(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(10182);
  }
  
  public static d bw(Intent paramIntent)
  {
    AppMethodBeat.i(192801);
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
    if (paramIntent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("--dump-skp-on-shader-compilation");
    }
    if (paramIntent.getBooleanExtra("cache-sksl", false)) {
      localArrayList.add("--cache-sksl");
    }
    if (paramIntent.getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    if (paramIntent.hasExtra("dart-flags")) {
      localArrayList.add("--dart-flags=" + paramIntent.getStringExtra("dart-flags"));
    }
    paramIntent = new d(localArrayList);
    AppMethodBeat.o(192801);
    return paramIntent;
  }
  
  public final String[] fNp()
  {
    AppMethodBeat.i(10184);
    String[] arrayOfString = new String[this.KLS.size()];
    arrayOfString = (String[])this.KLS.toArray(arrayOfString);
    AppMethodBeat.o(10184);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.d
 * JD-Core Version:    0.7.0.1
 */