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
import com.tencent.mm.a.g;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.x;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class a
{
  public static void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt)
  {
    b(paramActivity, paramIntent1, paramIntent2, paramString, paramInt, null);
  }
  
  public static void b(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt, a.a parama)
  {
    boolean bool;
    if ((paramIntent1 == null) || (paramIntent1.getData() == null)) {
      if (paramIntent1 == null)
      {
        bool = true;
        y.e("MicroMsg.AsyncObtainImage", "param error, %b", new Object[] { Boolean.valueOf(bool) });
      }
    }
    do
    {
      return;
      bool = false;
      break;
      if (paramIntent1.getData().toString().startsWith("content://com.google.android.gallery3d")) {
        break label124;
      }
      paramIntent1 = g(paramActivity, paramIntent1, paramString);
      y.i("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent, filePath:%s", new Object[] { paramIntent1 });
    } while (bk.bl(paramIntent1));
    if (parama != null) {
      paramIntent2.putExtra("CropImage_OutputPath", parama.Pj(paramIntent1));
    }
    paramIntent2.putExtra("CropImage_ImgPath", paramIntent1);
    paramActivity.startActivityForResult(paramIntent2, paramInt);
    return;
    label124:
    new a.2(paramIntent1, paramActivity, paramString, parama, paramIntent2, paramInt).execute(new Integer[] { Integer.valueOf(0) });
  }
  
  public static String g(Context paramContext, Intent paramIntent, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Cursor localCursor = null;
    if ((paramContext == null) || (paramIntent == null) || (paramString == null))
    {
      y.e("MicroMsg.AsyncObtainImage", "resolvePhotoFromIntent fail, invalid argument");
      paramIntent = localCursor;
      return paramIntent;
    }
    Uri localUri = Uri.parse(paramIntent.toURI());
    localCursor = paramContext.getContentResolver().query(localUri, null, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      y.i("MicroMsg.AsyncObtainImage", "resolve photo from cursor");
      paramContext = localObject2;
    }
    label386:
    for (;;)
    {
      try
      {
        if (!localUri.toString().startsWith("content://com.google.android.gallery3d")) {
          continue;
        }
        paramContext = localObject2;
        paramIntent = t(paramString, c.l(paramIntent.getData()));
        paramContext = paramIntent;
      }
      catch (Exception paramIntent)
      {
        y.printErrStackTrace("MicroMsg.AsyncObtainImage", paramIntent, "resolve photo error.", new Object[0]);
        continue;
      }
      paramIntent = paramContext;
      if (localCursor == null) {
        break;
      }
      localCursor.close();
      return paramContext;
      paramContext = localObject2;
      localCursor.moveToFirst();
      paramContext = localObject2;
      paramIntent = localCursor.getString(localCursor.getColumnIndex("_data"));
      paramContext = paramIntent;
      y.i("MicroMsg.AsyncObtainImage", "photo from resolver, path:" + paramIntent);
      paramContext = paramIntent;
      continue;
      if (paramIntent.getData() != null)
      {
        paramString = paramIntent.getData().getPath();
        paramContext = paramString;
        if (!new File(paramString).exists()) {
          paramContext = null;
        }
        y.i("MicroMsg.AsyncObtainImage", "photo file from data, path:" + paramContext);
        if (paramContext != null) {
          break label386;
        }
        paramContext = paramIntent.getData().getHost();
        if (new File(paramContext).exists()) {
          break label383;
        }
        paramContext = localObject1;
      }
      label383:
      for (;;)
      {
        y.i("MicroMsg.AsyncObtainImage", "photo file from data, host:" + paramContext);
        break;
        if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("inline-data")))
        {
          paramContext = t(paramString, (Bitmap)paramIntent.getExtras().get("data"));
          y.i("MicroMsg.AsyncObtainImage", "resolve photo from action-inline-data:%s", new Object[] { paramContext });
          break;
        }
        if (localCursor != null) {
          localCursor.close();
        }
        y.e("MicroMsg.AsyncObtainImage", "resolve photo from intent failed");
        return null;
      }
    }
  }
  
  public static String t(String paramString, Bitmap paramBitmap)
  {
    try
    {
      Object localObject = g.o(DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()).toString().getBytes()) + ".jpg";
      paramString = paramString + (String)localObject;
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = new BufferedOutputStream(new FileOutputStream((File)localObject));
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((BufferedOutputStream)localObject).close();
      y.i("MicroMsg.AsyncObtainImage", "photo image from data, path:" + paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      y.printErrStackTrace("MicroMsg.AsyncObtainImage", paramString, "saveBmp Error.", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a
 * JD-Core Version:    0.7.0.1
 */