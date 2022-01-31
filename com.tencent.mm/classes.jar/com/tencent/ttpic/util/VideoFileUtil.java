package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoFileUtil
{
  private static final String PIC_POSTFIX_JPEG = ".jpg";
  private static final String PIC_POSTFIX_PNG = ".png";
  private static final String PIC_POSTFIX_WEBP = ".webp";
  public static final VideoFileUtil.AssetFileComparator SIMPLE_ASSET_COMPARATOR = new VideoFileUtil.2();
  private static final String TAG = VideoFileUtil.class.getSimpleName();
  
  /* Error */
  public static String checkAssetsPhoto(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 54	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore_0
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_2
    //   21: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   24: aload_1
    //   25: areturn
    //   26: astore_2
    //   27: aconst_null
    //   28: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   31: aload_1
    //   32: ldc 68
    //   34: invokevirtual 74	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   37: iconst_m1
    //   38: if_icmpeq +68 -> 106
    //   41: new 76	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   48: aload_1
    //   49: iconst_0
    //   50: aload_1
    //   51: bipush 46
    //   53: invokevirtual 80	java/lang/String:lastIndexOf	(I)I
    //   56: iconst_1
    //   57: iadd
    //   58: invokevirtual 84	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 90
    //   66: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   83: aload_1
    //   84: areturn
    //   85: astore_0
    //   86: aconst_null
    //   87: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: aconst_null
    //   94: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aconst_null
    //   101: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   104: aload_0
    //   105: athrow
    //   106: new 76	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   113: aload_1
    //   114: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 10
    //   119: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_2
    //   126: aload_0
    //   127: aload_2
    //   128: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore_3
    //   132: aload_3
    //   133: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aload_2
    //   137: areturn
    //   138: astore_2
    //   139: aconst_null
    //   140: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   143: new 76	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   150: aload_1
    //   151: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc 16
    //   156: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_2
    //   163: aload_0
    //   164: aload_2
    //   165: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   168: astore_3
    //   169: aload_3
    //   170: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   173: aload_2
    //   174: areturn
    //   175: astore_0
    //   176: aconst_null
    //   177: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   180: aload_0
    //   181: athrow
    //   182: astore_2
    //   183: aconst_null
    //   184: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   187: new 76	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   194: aload_1
    //   195: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 13
    //   200: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore_1
    //   207: aload_0
    //   208: aload_1
    //   209: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   212: astore_0
    //   213: aload_0
    //   214: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   217: aload_1
    //   218: areturn
    //   219: astore_0
    //   220: aconst_null
    //   221: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   224: aload_0
    //   225: athrow
    //   226: astore_0
    //   227: aconst_null
    //   228: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   231: aconst_null
    //   232: areturn
    //   233: astore_0
    //   234: aconst_null
    //   235: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   238: aload_0
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	Context
    //   0	240	1	paramString	String
    //   19	2	2	localInputStream1	java.io.InputStream
    //   26	1	2	localIOException1	IOException
    //   125	12	2	str1	String
    //   138	1	2	localIOException2	IOException
    //   162	12	2	str2	String
    //   182	1	2	localIOException3	IOException
    //   131	39	3	localInputStream2	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   14	20	26	java/io/IOException
    //   14	20	85	finally
    //   73	79	92	java/io/IOException
    //   73	79	99	finally
    //   126	132	138	java/io/IOException
    //   126	132	175	finally
    //   163	169	182	java/io/IOException
    //   163	169	219	finally
    //   207	213	226	java/io/IOException
    //   207	213	233	finally
  }
  
  public static String checkPhoto(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = null;
    }
    String str2;
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = paramString;
        } while (new File(paramString).exists());
        str1 = paramString;
      } while (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") != -1);
      str1 = paramString + ".jpg";
      if (new File(str1).exists()) {
        return str1;
      }
      str2 = paramString + ".png";
      str1 = paramString;
    } while (!new File(str2).exists());
    return str2;
  }
  
  private static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2)
  {
    return copyAssets(paramContext, paramString1, paramString2, SIMPLE_ASSET_COMPARATOR);
  }
  
  public static boolean copyAssets(Context paramContext, String paramString1, String paramString2, VideoFileUtil.AssetFileComparator paramAssetFileComparator)
  {
    return performCopyAssetsFile(paramContext, paramString1, paramString2, paramAssetFileComparator);
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void deleteFiles(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1).listFiles(new VideoFileUtil.1(paramString2));
      if (paramString1 != null)
      {
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          paramString1[i].delete();
          i += 1;
        }
      }
    }
  }
  
  public static void deleteFilesStartWithGivenString(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (paramString1.getParentFile().exists())
    {
      paramString1 = paramString1.getParentFile().listFiles();
      if (paramString1 != null) {
        break label32;
      }
    }
    for (;;)
    {
      return;
      label32:
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if (localObject.getName().startsWith(paramString2)) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean exists(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("assets://")) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  public static List<String> getAllPngFileNames(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null) {}
    for (;;)
    {
      return localArrayList;
      if (paramString.startsWith("assets://")) {}
      try
      {
        paramString = VideoGlobalContext.getContext().getAssets().list(VideoUtil.getRealPath(paramString));
        if (paramString != null)
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramString[i];
            if (localObject.endsWith(".png")) {
              localArrayList.add(localObject);
            }
            i += 1;
          }
          paramString = new File(paramString).list(VideoMaterialUtil.mPngFilter);
          if (paramString != null)
          {
            localArrayList.addAll(Arrays.asList(paramString));
            return localArrayList;
          }
        }
      }
      catch (IOException paramString) {}
    }
    return localArrayList;
  }
  
  /* Error */
  public static long getAssetLength(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 54	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: astore 5
    //   6: aload 5
    //   8: aload_1
    //   9: invokevirtual 218	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   12: invokevirtual 224	android/content/res/AssetFileDescriptor:getLength	()J
    //   15: lstore_3
    //   16: lload_3
    //   17: lreturn
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_0
    //   21: aload 5
    //   23: aload_1
    //   24: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 230	java/io/InputStream:available	()I
    //   34: istore_2
    //   35: iload_2
    //   36: i2l
    //   37: lstore_3
    //   38: aload_0
    //   39: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   42: lload_3
    //   43: lreturn
    //   44: astore_1
    //   45: aload_0
    //   46: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   49: ldc2_w 233
    //   52: lreturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_0
    //   56: aload_0
    //   57: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: goto -7 -> 56
    //   66: astore_1
    //   67: goto -22 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramContext	Context
    //   0	70	1	paramString	String
    //   34	2	2	i	int
    //   15	28	3	l	long
    //   4	18	5	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   6	16	18	java/io/IOException
    //   21	28	44	java/io/IOException
    //   21	28	53	finally
    //   30	35	62	finally
    //   30	35	66	java/io/IOException
  }
  
  /* Error */
  public static String load(File paramFile)
  {
    // Byte code:
    //   0: new 242	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_0
    //   12: invokevirtual 247	java/io/File:length	()J
    //   15: l2i
    //   16: newarray byte
    //   18: astore_0
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 251	java/io/InputStream:read	([B)I
    //   26: pop
    //   27: aload_2
    //   28: astore_1
    //   29: new 70	java/lang/String
    //   32: dup
    //   33: aload_0
    //   34: ldc 253
    //   36: invokespecial 256	java/lang/String:<init>	([BLjava/lang/String;)V
    //   39: astore_0
    //   40: aload_2
    //   41: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_0
    //   50: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: invokevirtual 257	java/lang/Exception:toString	()Ljava/lang/String;
    //   64: pop
    //   65: aload_2
    //   66: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   69: goto -16 -> 53
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic 66	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   79: aload_0
    //   80: athrow
    //   81: astore_0
    //   82: goto -7 -> 75
    //   85: astore_0
    //   86: goto -28 -> 58
    //   89: astore_0
    //   90: aload_2
    //   91: astore_0
    //   92: goto -43 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramFile	File
    //   10	66	1	localFileInputStream1	java.io.FileInputStream
    //   8	83	2	localFileInputStream2	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	9	46	java/io/FileNotFoundException
    //   0	9	55	java/lang/Exception
    //   0	9	72	finally
    //   11	19	81	finally
    //   21	27	81	finally
    //   29	40	81	finally
    //   60	65	81	finally
    //   11	19	85	java/lang/Exception
    //   21	27	85	java/lang/Exception
    //   29	40	85	java/lang/Exception
    //   11	19	89	java/io/FileNotFoundException
    //   21	27	89	java/io/FileNotFoundException
    //   29	40	89	java/io/FileNotFoundException
  }
  
  public static String load(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    if (paramString1.startsWith("assets://")) {
      return loadAssetsString(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString1) + File.separator + paramString2);
    }
    return load(new File(paramString1 + File.separator + paramString2));
  }
  
  public static String loadAssetsString(Context paramContext, String paramString)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramContext = new BufferedReader(new InputStreamReader(paramContext.getAssets().open(paramString), "UTF-8"));
      for (;;)
      {
        paramString = paramContext.readLine();
        if (paramString == null) {
          break;
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramContext)
    {
      paramContext = paramContext;
      return localStringBuilder.toString();
      paramContext.close();
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public static void loadImageView(ImageView paramImageView, String paramString)
  {
    if ((paramImageView == null) || (paramString == null)) {}
    do
    {
      return;
      if (paramString.startsWith("assets://")) {
        try
        {
          paramImageView.setImageDrawable(Drawable.createFromStream(VideoGlobalContext.getContext().getAssets().open(VideoUtil.getRealPath(paramString)), null));
          return;
        }
        catch (IOException paramImageView)
        {
          return;
        }
      }
      paramString = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString), 2147483647, 2147483647);
    } while (!VideoBitmapUtil.isLegal(paramString));
    paramImageView.setImageBitmap(paramString);
  }
  
  public static String loadResourceString(String paramString)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramString = new BufferedReader(new InputStreamReader(VideoFileUtil.class.getResourceAsStream(paramString), "UTF-8"));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramString)
    {
      paramString = paramString;
      return localStringBuilder.toString();
      paramString.close();
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  public static boolean needCopy(VideoFilterBase paramVideoFilterBase)
  {
    if (paramVideoFilterBase == null) {}
    do
    {
      return false;
      if ((paramVideoFilterBase instanceof NormalVideoFilter)) {
        return ((NormalVideoFilter)paramVideoFilterBase).needCopyTex();
      }
    } while (!(paramVideoFilterBase instanceof FaceOffFilter));
    return true;
  }
  
  /* Error */
  private static boolean performCopyAssetsFile(Context paramContext, String paramString1, String paramString2, VideoFileUtil.AssetFileComparator paramAssetFileComparator)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_1
    //   7: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_2
    //   14: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +5 -> 22
    //   20: iconst_0
    //   21: ireturn
    //   22: aload_0
    //   23: invokevirtual 54	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   26: astore 9
    //   28: new 97	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 8
    //   38: aload 8
    //   40: invokevirtual 104	java/io/File:exists	()Z
    //   43: ifeq +47 -> 90
    //   46: aload_3
    //   47: ifnull +30 -> 77
    //   50: aload_3
    //   51: aload_0
    //   52: aload_1
    //   53: aload 8
    //   55: invokeinterface 330 4 0
    //   60: istore 6
    //   62: iload 6
    //   64: ifeq +13 -> 77
    //   67: aconst_null
    //   68: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   71: aconst_null
    //   72: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload 8
    //   79: invokevirtual 333	java/io/File:isDirectory	()Z
    //   82: ifeq +8 -> 90
    //   85: aload 8
    //   87: invokestatic 335	com/tencent/ttpic/util/VideoFileUtil:delete	(Ljava/io/File;)V
    //   90: aload 8
    //   92: invokevirtual 153	java/io/File:getParentFile	()Ljava/io/File;
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 134	java/io/File:isFile	()Z
    //   100: ifeq +7 -> 107
    //   103: aload_0
    //   104: invokestatic 335	com/tencent/ttpic/util/VideoFileUtil:delete	(Ljava/io/File;)V
    //   107: aload_0
    //   108: invokevirtual 104	java/io/File:exists	()Z
    //   111: ifne +24 -> 135
    //   114: aload_0
    //   115: invokevirtual 338	java/io/File:mkdirs	()Z
    //   118: istore 6
    //   120: iload 6
    //   122: ifne +13 -> 135
    //   125: aconst_null
    //   126: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   129: aconst_null
    //   130: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 9
    //   137: aload_1
    //   138: invokevirtual 60	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 230	java/io/InputStream:available	()I
    //   146: istore 4
    //   148: iload 4
    //   150: ifgt +17 -> 167
    //   153: aload 7
    //   155: astore_1
    //   156: aload_0
    //   157: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   160: aload_1
    //   161: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   164: iload 5
    //   166: ireturn
    //   167: new 340	java/io/BufferedOutputStream
    //   170: dup
    //   171: new 342	java/io/FileOutputStream
    //   174: dup
    //   175: aload 8
    //   177: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   180: invokespecial 346	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   183: astore_2
    //   184: sipush 1024
    //   187: newarray byte
    //   189: astore_1
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 251	java/io/InputStream:read	([B)I
    //   195: istore 4
    //   197: iload 4
    //   199: ifle +34 -> 233
    //   202: aload_2
    //   203: aload_1
    //   204: iconst_0
    //   205: iload 4
    //   207: invokevirtual 352	java/io/OutputStream:write	([BII)V
    //   210: goto -20 -> 190
    //   213: astore_1
    //   214: aload_0
    //   215: astore_1
    //   216: aload_2
    //   217: astore_0
    //   218: aload 8
    //   220: invokestatic 335	com/tencent/ttpic/util/VideoFileUtil:delete	(Ljava/io/File;)V
    //   223: aload_1
    //   224: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   227: aload_0
    //   228: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   231: iconst_0
    //   232: ireturn
    //   233: aload_2
    //   234: astore_1
    //   235: iconst_1
    //   236: istore 5
    //   238: goto -82 -> 156
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_2
    //   246: aload_2
    //   247: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   250: aload_0
    //   251: invokestatic 232	com/tencent/ttpic/util/VideoFileUtil:closeSilently	(Ljava/io/Closeable;)V
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: aconst_null
    //   258: astore_3
    //   259: aload_0
    //   260: astore_2
    //   261: aload_3
    //   262: astore_0
    //   263: goto -17 -> 246
    //   266: astore_1
    //   267: aload_2
    //   268: astore_3
    //   269: aload_0
    //   270: astore_2
    //   271: aload_3
    //   272: astore_0
    //   273: goto -27 -> 246
    //   276: astore_2
    //   277: aload_1
    //   278: astore_3
    //   279: aload_2
    //   280: astore_1
    //   281: aload_3
    //   282: astore_2
    //   283: goto -37 -> 246
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_1
    //   291: goto -73 -> 218
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_0
    //   298: astore_1
    //   299: aload_2
    //   300: astore_0
    //   301: goto -83 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramContext	Context
    //   0	304	1	paramString1	String
    //   0	304	2	paramString2	String
    //   0	304	3	paramAssetFileComparator	VideoFileUtil.AssetFileComparator
    //   146	60	4	i	int
    //   1	236	5	bool1	boolean
    //   60	61	6	bool2	boolean
    //   4	150	7	localObject	Object
    //   36	183	8	localFile	File
    //   26	110	9	localAssetManager	AssetManager
    // Exception table:
    //   from	to	target	type
    //   184	190	213	java/lang/Throwable
    //   190	197	213	java/lang/Throwable
    //   202	210	213	java/lang/Throwable
    //   38	46	241	finally
    //   50	62	241	finally
    //   77	90	241	finally
    //   90	107	241	finally
    //   107	120	241	finally
    //   135	142	241	finally
    //   142	148	256	finally
    //   167	184	256	finally
    //   184	190	266	finally
    //   190	197	266	finally
    //   202	210	266	finally
    //   218	223	276	finally
    //   38	46	286	java/lang/Throwable
    //   50	62	286	java/lang/Throwable
    //   77	90	286	java/lang/Throwable
    //   90	107	286	java/lang/Throwable
    //   107	120	286	java/lang/Throwable
    //   135	142	286	java/lang/Throwable
    //   142	148	294	java/lang/Throwable
    //   167	184	294	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFileUtil
 * JD-Core Version:    0.7.0.1
 */