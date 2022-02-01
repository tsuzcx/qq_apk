package io.flutter.embedding.engine.systemchannels;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class LocalizationChannel
{
  private static final String TAG = "LocalizationChannel";
  public final MethodChannel channel;
  
  public LocalizationChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10222);
    this.channel = new MethodChannel(paramDartExecutor, "flutter/localization", JSONMethodCodec.INSTANCE);
    AppMethodBeat.o(10222);
  }
  
  public void sendLocales(List<Locale> paramList)
  {
    AppMethodBeat.i(10223);
    Log.v("LocalizationChannel", "Sending Locales to Flutter.");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Locale localLocale = (Locale)localIterator.next();
      Log.v("LocalizationChannel", "Locale (Language: " + localLocale.getLanguage() + ", Country: " + localLocale.getCountry() + ", Variant: " + localLocale.getVariant() + ")");
      localArrayList.add(localLocale.getLanguage());
      localArrayList.add(localLocale.getCountry());
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramList = localLocale.getScript();; paramList = "")
      {
        localArrayList.add(paramList);
        localArrayList.add(localLocale.getVariant());
        break;
      }
    }
    this.channel.invokeMethod("setLocale", localArrayList);
    AppMethodBeat.o(10223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.LocalizationChannel
 * JD-Core Version:    0.7.0.1
 */