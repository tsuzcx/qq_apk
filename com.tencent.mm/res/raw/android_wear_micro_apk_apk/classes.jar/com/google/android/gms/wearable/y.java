package com.google.android.gms.wearable;

import android.util.Log;
import com.google.android.gms.internal.dh;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dw;
import java.util.List;

public final class y
{
  private final n Uh;
  private final PutDataRequest Ui;
  
  private y(PutDataRequest paramPutDataRequest)
  {
    this.Ui = paramPutDataRequest;
    this.Uh = new n();
  }
  
  public static y v(String paramString)
  {
    return new y(PutDataRequest.w(paramString));
  }
  
  public final n kG()
  {
    return this.Uh;
  }
  
  public final PutDataRequest kL()
  {
    Object localObject = dh.a(this.Uh);
    this.Ui.f(dw.c(((di)localObject).SB));
    int j = ((di)localObject).SC.size();
    int i = 0;
    while (i < j)
    {
      String str1 = Integer.toString(i);
      Asset localAsset = (Asset)((di)localObject).SC.get(i);
      if (str1 == null)
      {
        localObject = String.valueOf(localAsset);
        throw new IllegalStateException(String.valueOf(localObject).length() + 26 + "asset key cannot be null: " + (String)localObject);
      }
      if (localAsset == null)
      {
        localObject = String.valueOf(str1);
        if (((String)localObject).length() != 0) {}
        for (localObject = "asset cannot be null: key=".concat((String)localObject);; localObject = new String("asset cannot be null: key=")) {
          throw new IllegalStateException((String)localObject);
        }
      }
      if (Log.isLoggable("DataMap", 3))
      {
        String str2 = String.valueOf(localAsset);
        Log.d("DataMap", String.valueOf(str1).length() + 33 + String.valueOf(str2).length() + "asPutDataRequest: adding asset: " + str1 + " " + str2);
      }
      this.Ui.b(str1, localAsset);
      i += 1;
    }
    return this.Ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.y
 * JD-Core Version:    0.7.0.1
 */