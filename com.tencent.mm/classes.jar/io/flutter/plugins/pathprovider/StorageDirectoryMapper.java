package io.flutter.plugins.pathprovider;

import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;

class StorageDirectoryMapper
{
  static String androidType(Integer paramInteger)
  {
    AppMethodBeat.i(189699);
    if (paramInteger == null)
    {
      AppMethodBeat.o(189699);
      return null;
    }
    switch (paramInteger.intValue())
    {
    default: 
      paramInteger = new IllegalArgumentException("Unknown index: ".concat(String.valueOf(paramInteger)));
      AppMethodBeat.o(189699);
      throw paramInteger;
    case 0: 
      paramInteger = Environment.DIRECTORY_MUSIC;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 1: 
      paramInteger = Environment.DIRECTORY_PODCASTS;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 2: 
      paramInteger = Environment.DIRECTORY_RINGTONES;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 3: 
      paramInteger = Environment.DIRECTORY_ALARMS;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 4: 
      paramInteger = Environment.DIRECTORY_NOTIFICATIONS;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 5: 
      paramInteger = Environment.DIRECTORY_PICTURES;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 6: 
      paramInteger = Environment.DIRECTORY_MOVIES;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 7: 
      paramInteger = Environment.DIRECTORY_DOWNLOADS;
      AppMethodBeat.o(189699);
      return paramInteger;
    case 8: 
      paramInteger = Environment.DIRECTORY_DCIM;
      AppMethodBeat.o(189699);
      return paramInteger;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramInteger = Environment.DIRECTORY_DOCUMENTS;
      AppMethodBeat.o(189699);
      return paramInteger;
    }
    paramInteger = new IllegalArgumentException("Documents directory is unsupported.");
    AppMethodBeat.o(189699);
    throw paramInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.plugins.pathprovider.StorageDirectoryMapper
 * JD-Core Version:    0.7.0.1
 */