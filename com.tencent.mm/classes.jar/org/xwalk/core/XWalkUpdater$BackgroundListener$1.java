package org.xwalk.core;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;

class XWalkUpdater$BackgroundListener$1
  extends AsyncTask<Void, Void, Integer>
{
  XWalkUpdater$BackgroundListener$1(XWalkUpdater.BackgroundListener paramBackgroundListener) {}
  
  protected Integer doInBackground(Void... paramVarArgs)
  {
    AppMethodBeat.i(85896);
    paramVarArgs = XWalkUpdater.onHandleFile(XWalkUpdater.BackgroundListener.access$100(this.this$1));
    AppMethodBeat.o(85896);
    return paramVarArgs;
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    AppMethodBeat.i(85897);
    if (paramInteger.intValue() != 0)
    {
      XWalkUpdater.access$000(this.this$1.this$0).onXWalkUpdateFailed(paramInteger.intValue());
      AppMethodBeat.o(85897);
      return;
    }
    XWalkUpdater.access$000(this.this$1.this$0).onXWalkUpdateCompleted();
    AppMethodBeat.o(85897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.BackgroundListener.1
 * JD-Core Version:    0.7.0.1
 */