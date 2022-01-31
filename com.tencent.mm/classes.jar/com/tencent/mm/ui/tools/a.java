package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class a
{
  public static void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt)
  {
    AppMethodBeat.i(107596);
    b(paramActivity, paramIntent1, paramIntent2, paramString, paramInt, null);
    AppMethodBeat.o(107596);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt, a.a parama)
  {
    AppMethodBeat.i(107597);
    if ((paramIntent1 == null) || (paramIntent1.getData() == null))
    {
      if (paramIntent1 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.AsyncObtainImage", "param error, %b", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(107597);
        return;
      }
    }
    if (!paramIntent1.getData().toString().startsWith("content://com.google.android.gallery3d"))
    {
      paramIntent1 = i(paramActivity, paramIntent1, paramString);
      ab.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", new Object[] { paramIntent1 });
      if (!bo.isNullOrNil(paramIntent1))
      {
        if (parama != null) {
          paramIntent2.putExtra("CropImage_OutputPath", parama.acd(paramIntent1));
        }
        paramIntent2.putExtra("CropImage_ImgPath", paramIntent1);
        paramActivity.startActivityForResult(paramIntent2, paramInt);
      }
      AppMethodBeat.o(107597);
      return;
    }
    new a.2(paramIntent1, paramActivity, paramString, parama, paramIntent2, paramInt).execute(new Integer[] { Integer.valueOf(0) });
    AppMethodBeat.o(107597);
  }
  
  public static String i(Context paramContext, Intent paramIntent, String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(107598);
    if ((paramContext == null) || (paramIntent == null) || (paramString == null))
    {
      ab.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
      AppMethodBeat.o(107598);
      return null;
    }
    Uri localUri = Uri.parse(paramIntent.toURI());
    Cursor localCursor = paramContext.getContentResolver().query(localUri, null, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      ab.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
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
        paramIntent = v(paramString, d.n(paramIntent.getData()));
        paramContext = paramIntent;
      }
      catch (Exception paramIntent)
      {
        ab.printErrStackTrace("MicroMsg.AsyncObtainImage", paramIntent, "resolve photo error.", new Object[0]);
        continue;
      }
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(107598);
      return paramContext;
      paramContext = localObject2;
      localCursor.moveToFirst();
      paramContext = localObject2;
      paramIntent = localCursor.getString(localCursor.getColumnIndex("_data"));
      paramContext = paramIntent;
      ab.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:".concat(String.valueOf(paramIntent)));
      paramContext = paramIntent;
      continue;
      if (paramIntent.getData() != null)
      {
        paramString = paramIntent.getData().getPath();
        paramContext = paramString;
        if (!bo.isNullOrNil(paramString))
        {
          paramContext = paramString;
          if (!new File(paramString).exists()) {
            paramContext = null;
          }
        }
        ab.i("MicroMsg.AsyncObtainImage", "photo file from data, path:".concat(String.valueOf(paramContext)));
        if (!bo.isNullOrNil(paramContext)) {
          break label396;
        }
        paramContext = paramIntent.getData().getHost();
        if ((bo.isNullOrNil(paramContext)) || (new File(paramContext).exists())) {
          break label393;
        }
        paramContext = localObject1;
      }
      for (;;)
      {
        ab.i("MicroMsg.AsyncObtainImage", "photo file from data, host:".concat(String.valueOf(paramContext)));
        break;
        if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("inline-data")))
        {
          paramContext = v(paramString, (Bitmap)paramIntent.getExtras().get("data"));
          ab.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", new Object[] { paramContext });
          break;
        }
        if (localCursor != null) {
          localCursor.close();
        }
        ab.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
        AppMethodBeat.o(107598);
        return null;
      }
    }
  }
  
  public static String v(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(107599);
    try
    {
      Object localObject = g.w(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg";
      paramString = paramString + (String)localObject;
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = new BufferedOutputStream(new FileOutputStream((File)localObject));
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((BufferedOutputStream)localObject).close();
      ab.i("MicroMsg.AsyncObtainImage", "photo image from data, path:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(107599);
      return paramString;
    }
    catch (IOException paramString)
    {
      ab.printErrStackTrace("MicroMsg.AsyncObtainImage", paramString, "saveBmp Error.", new Object[0]);
      AppMethodBeat.o(107599);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */