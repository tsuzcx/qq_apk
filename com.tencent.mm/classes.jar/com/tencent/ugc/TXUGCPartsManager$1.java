package com.tencent.ugc;

import android.os.AsyncTask;
import java.io.File;

class TXUGCPartsManager$1
  extends AsyncTask
{
  TXUGCPartsManager$1(TXUGCPartsManager paramTXUGCPartsManager, String paramString) {}
  
  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    paramArrayOfObject = new File(this.a);
    if (paramArrayOfObject.exists()) {
      paramArrayOfObject.delete();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ugc.TXUGCPartsManager.1
 * JD-Core Version:    0.7.0.1
 */