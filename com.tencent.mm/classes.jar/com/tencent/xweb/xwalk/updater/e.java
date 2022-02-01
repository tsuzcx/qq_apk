package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class e
{
  static boolean SJm = false;
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(207357);
    Log.i("XWalkCleaner", "XWalkCleaner busy == " + SJm);
    boolean bool = SJm;
    AppMethodBeat.o(207357);
    return bool;
  }
  
  public static void lJ(Context paramContext)
  {
    AppMethodBeat.i(207358);
    new a(paramContext).execute(new String[0]);
    SJm = true;
    AppMethodBeat.o(207358);
  }
  
  static final class a
    extends AsyncTask<String, Integer, String>
  {
    Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    protected final void onPreExecute()
    {
      AppMethodBeat.i(207355);
      super.onPreExecute();
      AppMethodBeat.o(207355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.e
 * JD-Core Version:    0.7.0.1
 */