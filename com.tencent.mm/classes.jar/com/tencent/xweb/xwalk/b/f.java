package com.tencent.xweb.xwalk.b;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class f
{
  static boolean aale = false;
  
  public static boolean isBusy()
  {
    AppMethodBeat.i(206353);
    Log.i("XWalkCleaner", "XWalkCleaner busy == " + aale);
    boolean bool = aale;
    AppMethodBeat.o(206353);
    return bool;
  }
  
  public static void mG(Context paramContext)
  {
    AppMethodBeat.i(206355);
    new a(paramContext).execute(new String[0]);
    aale = true;
    AppMethodBeat.o(206355);
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
      AppMethodBeat.i(205712);
      super.onPreExecute();
      AppMethodBeat.o(205712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.f
 * JD-Core Version:    0.7.0.1
 */