package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class a
{
  public static void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt)
  {
    AppMethodBeat.i(143034);
    b(paramActivity, paramIntent1, paramIntent2, paramString, paramInt, null);
    AppMethodBeat.o(143034);
  }
  
  public static void b(final Activity paramActivity, Intent paramIntent1, final Intent paramIntent2, final String paramString, final int paramInt, final a parama)
  {
    AppMethodBeat.i(143035);
    if ((paramIntent1 == null) || (paramIntent1.getData() == null))
    {
      if (paramIntent1 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.e("MicroMsg.AsyncObtainImage", "param error, %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(143035);
        return;
      }
    }
    if (!paramIntent1.getData().toString().startsWith("content://com.google.android.gallery3d"))
    {
      paramIntent1 = i(paramActivity, paramIntent1, paramString);
      ad.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", new Object[] { paramIntent1 });
      if (!bt.isNullOrNil(paramIntent1))
      {
        if (parama != null) {
          paramIntent2.putExtra("CropImage_OutputPath", parama.aqv(paramIntent1));
        }
        paramIntent2.putExtra("CropImage_ImgPath", paramIntent1);
        paramActivity.startActivityForResult(paramIntent2, paramInt);
      }
      AppMethodBeat.o(143035);
      return;
    }
    new AsyncTask()
    {
      private ProgressDialog Hmj;
      private boolean Hmk;
      private String filePath;
      private Uri uri;
      
      private Integer fdF()
      {
        AppMethodBeat.i(143031);
        try
        {
          Object localObject = this.uri;
          if (localObject == null)
          {
            AppMethodBeat.o(143031);
            return null;
          }
          localObject = f.y(this.uri);
          this.filePath = a.y(paramString, (Bitmap)localObject);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.AsyncObtainImage", localException, "doInBackground", new Object[0]);
          }
        }
        AppMethodBeat.o(143031);
        return null;
      }
      
      protected final void onPreExecute()
      {
        AppMethodBeat.i(143030);
        try
        {
          this.uri = this.val$data.getData();
          this.Hmk = false;
          Activity localActivity = paramActivity;
          paramActivity.getString(2131755906);
          this.Hmj = h.b(localActivity, paramActivity.getString(2131755787), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(143029);
              a.2.a(a.2.this);
              AppMethodBeat.o(143029);
            }
          });
          AppMethodBeat.o(143030);
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.AsyncObtainImage", localException, "onPreExecute", new Object[0]);
          AppMethodBeat.o(143030);
        }
      }
    }.execute(new Integer[] { Integer.valueOf(0) });
    AppMethodBeat.o(143035);
  }
  
  public static String i(Context paramContext, Intent paramIntent, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(143036);
    if ((paramContext == null) || (paramIntent == null) || (paramString == null))
    {
      ad.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
      AppMethodBeat.o(143036);
      return null;
    }
    Uri localUri = Uri.parse(paramIntent.toURI());
    Cursor localCursor = paramContext.getContentResolver().query(localUri, null, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      ad.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
      paramContext = localObject2;
    }
    label393:
    label396:
    for (;;)
    {
      try
      {
        if (!localUri.toString().startsWith("content://com.google.android.gallery3d")) {
          continue;
        }
        paramContext = localObject2;
        paramIntent = y(paramString, f.y(paramIntent.getData()));
        paramContext = paramIntent;
      }
      catch (Exception paramIntent)
      {
        ad.printErrStackTrace("MicroMsg.AsyncObtainImage", paramIntent, "resolve photo error.", new Object[0]);
        continue;
      }
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(143036);
      return paramContext;
      paramContext = localObject2;
      localCursor.moveToFirst();
      paramContext = localObject2;
      paramIntent = localCursor.getString(localCursor.getColumnIndex("_data"));
      paramContext = paramIntent;
      ad.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:".concat(String.valueOf(paramIntent)));
      paramContext = paramIntent;
      continue;
      if (paramIntent.getData() != null)
      {
        paramString = paramIntent.getData().getPath();
        paramContext = paramString;
        if (!bt.isNullOrNil(paramString))
        {
          paramContext = paramString;
          if (!new e(paramString).exists()) {
            paramContext = null;
          }
        }
        ad.i("MicroMsg.AsyncObtainImage", "photo file from data, path:".concat(String.valueOf(paramContext)));
        if (!bt.isNullOrNil(paramContext)) {
          break label396;
        }
        paramContext = paramIntent.getData().getHost();
        if ((bt.isNullOrNil(paramContext)) || (new e(paramContext).exists())) {
          break label393;
        }
        paramContext = localObject1;
      }
      for (;;)
      {
        ad.i("MicroMsg.AsyncObtainImage", "photo file from data, host:".concat(String.valueOf(paramContext)));
        break;
        if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("inline-data")))
        {
          paramContext = y(paramString, (Bitmap)paramIntent.getExtras().get("data"));
          ad.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", new Object[] { paramContext });
          break;
        }
        if (localCursor != null) {
          localCursor.close();
        }
        ad.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
        AppMethodBeat.o(143036);
        return null;
      }
    }
  }
  
  public static String y(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(143037);
    try
    {
      Object localObject = g.getMessageDigest(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg";
      paramString = paramString + (String)localObject;
      localObject = new e(paramString);
      if (!((e)localObject).exists()) {
        ((e)localObject).createNewFile();
      }
      localObject = new BufferedOutputStream(i.ai((e)localObject));
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((BufferedOutputStream)localObject).close();
      ad.i("MicroMsg.AsyncObtainImage", "photo image from data, path:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(143037);
      return paramString;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("MicroMsg.AsyncObtainImage", paramString, "saveBmp Error.", new Object[0]);
      AppMethodBeat.o(143037);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract String aqv(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */