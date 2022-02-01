package org.xwalk.core;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class XWalkFileChooser
{
  private static final String ALL_AUDIO_TYPES = "audio/*";
  private static final String ALL_IMAGE_TYPES = "image/*";
  private static final String ALL_VIDEO_TYPES = "video/*";
  private static final String ANY_TYPES = "*/*";
  private static final String AUDIO_TYPE = "audio/";
  private static final String IMAGE_TYPE = "image/";
  public static final int INPUT_FILE_REQUEST_CODE = 1;
  private static final String PATH_PREFIX = "file:";
  private static final String SPLIT_EXPRESSION = ",";
  private static final String TAG = "XWalkFileChooser";
  private static final String VIDEO_TYPE = "video/";
  private static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
  private Activity mActivity;
  private String mCameraPhotoPath;
  private ValueCallback<Uri> mFilePathCallback;
  
  public XWalkFileChooser(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private boolean canWriteExternalStorage()
  {
    AppMethodBeat.i(154731);
    try
    {
      boolean bool = Arrays.asList(this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 4096).requestedPermissions).contains("android.permission.WRITE_EXTERNAL_STORAGE");
      AppMethodBeat.o(154731);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(154731);
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label47:
      break label47;
    }
  }
  
  private File createImageFile()
  {
    AppMethodBeat.i(154732);
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      Log.e("XWalkFileChooser", "External storage is not mounted.");
      AppMethodBeat.o(154732);
      return null;
    }
    Object localObject = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    localObject = "JPEG_" + (String)localObject + "_";
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    try
    {
      localObject = File.createTempFile((String)localObject, ".jpg", localFile);
      Log.d("XWalkFileChooser", "Created image file: " + ((File)localObject).getAbsolutePath());
      AppMethodBeat.o(154732);
      return localObject;
    }
    catch (IOException localIOException)
    {
      Log.e("XWalkFileChooser", "Unable to create Image File, please make sure permission 'WRITE_EXTERNAL_STORAGE' was added.");
      AppMethodBeat.o(154732);
    }
    return null;
  }
  
  private boolean deleteImageFile()
  {
    AppMethodBeat.i(154733);
    if ((this.mCameraPhotoPath == null) || (!this.mCameraPhotoPath.contains("file:")))
    {
      AppMethodBeat.o(154733);
      return false;
    }
    String str = this.mCameraPhotoPath.split("file:")[1];
    boolean bool = new File(str).delete();
    Log.d("XWalkFileChooser", "Delete image file: " + str + " result: " + bool);
    AppMethodBeat.o(154733);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(154730);
    if ((paramInt1 == 1) && (this.mFilePathCallback != null))
    {
      Log.d("XWalkFileChooser", "Activity result: ".concat(String.valueOf(paramInt2)));
      if (-1 != paramInt2) {
        break label140;
      }
      if ((paramIntent == null) || ((paramIntent.getAction() == null) && (paramIntent.getData() == null)))
      {
        if (this.mCameraPhotoPath == null) {
          break label149;
        }
        paramIntent = Uri.parse(this.mCameraPhotoPath);
        if (paramIntent != null) {
          Log.d("XWalkFileChooser", "Received file: " + paramIntent.toString());
        }
        this.mFilePathCallback.onReceiveValue(paramIntent);
        this.mFilePathCallback = null;
      }
    }
    else
    {
      AppMethodBeat.o(154730);
      return;
    }
    paramIntent = paramIntent.getDataString();
    if (paramIntent != null) {}
    for (paramIntent = Uri.parse(paramIntent);; paramIntent = null)
    {
      deleteImageFile();
      break;
      label140:
      if (paramInt2 == 0) {
        deleteImageFile();
      }
      label149:
      paramIntent = null;
      break;
    }
  }
  
  public boolean showFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(154729);
    this.mFilePathCallback = paramValueCallback;
    paramValueCallback = new Intent("android.media.action.IMAGE_CAPTURE");
    Object localObject;
    if (paramValueCallback.resolveActivity(this.mActivity.getPackageManager()) != null)
    {
      localObject = createImageFile();
      if (localObject != null)
      {
        this.mCameraPhotoPath = ("file:" + ((File)localObject).getAbsolutePath());
        paramValueCallback.putExtra("PhotoPath", this.mCameraPhotoPath);
        paramValueCallback.putExtra("output", Uri.fromFile((File)localObject));
      }
    }
    for (;;)
    {
      Intent localIntent1 = new Intent("android.media.action.VIDEO_CAPTURE");
      Intent localIntent2 = new Intent("android.provider.MediaStore.RECORD_SOUND");
      localObject = new Intent("android.intent.action.GET_CONTENT");
      ((Intent)localObject).addCategory("android.intent.category.OPENABLE");
      ArrayList localArrayList = new ArrayList();
      if ((!paramString1.contains(",")) && (!paramString1.contains("*/*"))) {
        if (paramString2.equals("true"))
        {
          if (paramString1.startsWith("image/"))
          {
            if (paramValueCallback != null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(paramValueCallback).aYi(), "org/xwalk/core/XWalkFileChooser", "showFileChooser", "(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
              Log.d("XWalkFileChooser", "Started taking picture");
              AppMethodBeat.o(154729);
              return true;
              paramValueCallback = null;
            }
          }
          else
          {
            if (paramString1.startsWith("video/"))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent1).aYi(), "org/xwalk/core/XWalkFileChooser", "showFileChooser", "(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
              Log.d("XWalkFileChooser", "Started camcorder");
              AppMethodBeat.o(154729);
              return true;
            }
            if (paramString1.startsWith("audio/"))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent2).aYi(), "org/xwalk/core/XWalkFileChooser", "showFileChooser", "(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
              Log.d("XWalkFileChooser", "Started sound recorder");
              AppMethodBeat.o(154729);
              return true;
            }
          }
        }
        else
        {
          if (!paramString1.startsWith("image/")) {
            break label583;
          }
          if (paramValueCallback != null) {
            localArrayList.add(paramValueCallback);
          }
          ((Intent)localObject).setType("image/*");
        }
      }
      for (;;)
      {
        if ((localArrayList.isEmpty()) && (canWriteExternalStorage()))
        {
          if (paramValueCallback != null) {
            localArrayList.add(paramValueCallback);
          }
          localArrayList.add(localIntent1);
          localArrayList.add(localIntent2);
          ((Intent)localObject).setType("*/*");
        }
        paramValueCallback = new Intent("android.intent.action.CHOOSER");
        paramValueCallback.putExtra("android.intent.extra.INTENT", (Parcelable)localObject);
        if (!localArrayList.isEmpty()) {
          paramValueCallback.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Intent[0]));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(paramValueCallback).aYi(), "org/xwalk/core/XWalkFileChooser", "showFileChooser", "(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)Z", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        Log.d("XWalkFileChooser", "Started chooser");
        AppMethodBeat.o(154729);
        return true;
        label583:
        if (paramString1.startsWith("video/"))
        {
          localArrayList.add(localIntent1);
          ((Intent)localObject).setType("video/*");
        }
        else if (paramString1.startsWith("audio/"))
        {
          localArrayList.add(localIntent2);
          ((Intent)localObject).setType("audio/*");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.XWalkFileChooser
 * JD-Core Version:    0.7.0.1
 */