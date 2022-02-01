import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.troop.VideoCombineHelper.CombineTask.3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class aafm
  extends aafz
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  List<String> jdField_a_of_type_JavaUtilList;
  String b;
  
  public aafm(aaga paramaaga, String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    super(paramaaga, paramString1, paramList);
    this.jdField_a_of_type_JavaLangString = paramString3;
    Object localObject;
    this.b = localObject;
    this.jdField_a_of_type_JavaUtilList = paramString2;
    this.jdField_a_of_type_Aafz = new aafx(paramaaga, paramString1, paramList);
  }
  
  public File a(File paramFile, String paramString, aafj paramaafj)
  {
    Object localObject = new MediaMetadataRetriever();
    ((MediaMetadataRetriever)localObject).setDataSource(paramFile.getAbsolutePath());
    String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(18);
    String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
    ((MediaMetadataRetriever)localObject).release();
    localObject = paramFile.getParent() + File.separator + "wording.png";
    String str3 = paramFile.getParent() + File.separator + "vmw.mp4";
    try
    {
      int i = Integer.parseInt(str1);
      int j = Integer.parseInt(str2);
      long l = System.currentTimeMillis();
      a(i, j, paramString, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.trace_video_combine", 2, "createWatermarkPng time = " + (System.currentTimeMillis() - l));
      }
      a().c.add(new File((String)localObject));
      this.jdField_a_of_type_Aafb.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.watermark((String)localObject, paramFile.getAbsolutePath(), str3, i, j, new aaft(this, paramaafj, str3));
    }
    catch (Exception paramFile)
    {
      for (;;)
      {
        QLog.e(".troop.VideoCombineHelper", 2, "combineWording failed!", paramFile);
      }
    }
    return null;
  }
  
  public void a()
  {
    String str;
    aafl localaafl;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      str = a() + File.separator + "v.ts";
      localaafl = a();
      if (localaafl.b) {
        this.jdField_a_of_type_Aaga.b(this);
      }
    }
    else
    {
      return;
    }
    a(this.jdField_a_of_type_JavaUtilList, str, new aafn(this, localaafl));
  }
  
  public void a(List<String> paramList, String paramString, aafj paramaafj)
  {
    if ((paramList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      paramaafj.a("", false, "videoFiles empty!");
      return;
    }
    if (paramList.size() == 1)
    {
      paramaafj.a((String)this.jdField_a_of_type_JavaUtilList.get(0), true, "combineVideos Success size = 1");
      return;
    }
    try
    {
      long l = System.currentTimeMillis();
      paramList = new File(paramString);
      a(this.jdField_a_of_type_JavaUtilList, paramList.getAbsolutePath(), new aafr(this, l, paramaafj, paramList));
      return;
    }
    catch (Exception paramList)
    {
      QLog.e(".troop.VideoCombineHelper", 2, "combineVideos failed", paramList);
    }
  }
  
  public void a(List<String> paramList, String paramString, aafw paramaafw)
  {
    Object localObject1 = new File(paramString);
    if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
    {
      paramaafw.a(true);
      return;
    }
    localObject1 = new ArrayList();
    this.jdField_a_of_type_Aafb.jdField_a_of_type_Long = System.currentTimeMillis();
    StringBuffer localStringBuffer = new StringBuffer("concat:");
    int i = 0;
    if (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      Object localObject3 = new File((String)localObject2);
      Object localObject4 = ((File)localObject3).getName().split("\\.");
      localObject3 = ((File)localObject3).getAbsoluteFile().getParent() + File.separator + localObject4[0] + ".ts";
      localStringBuffer.append((String)localObject3);
      if (i != paramList.size() - 1) {
        localStringBuffer.append("|");
      }
      localObject4 = new File((String)localObject3);
      if ((((File)localObject4).exists()) && (((File)localObject4).length() > 0L)) {}
      for (;;)
      {
        i += 1;
        break;
        if (!((File)localObject4).getParentFile().exists()) {
          ((File)localObject4).getParentFile().mkdirs();
        }
        localObject4 = new FFmpegCommandUnit();
        ((FFmpegCommandUnit)localObject4).cmdType = 5;
        ((FFmpegCommandUnit)localObject4).arguments = new VideoCombineHelper.CombineTask.3(this, (String)localObject2, (String)localObject3);
        ((FFmpegCommandUnit)localObject4).callback = new aafs(this, paramaafw);
        ((ArrayList)localObject1).add(localObject4);
      }
    }
    paramList = new File(paramString);
    paramString = paramList.getName().split("\\.");
    paramList = paramList.getParent() + File.separator + paramString[0] + ".ts";
    paramString = new FFmpegCommandUnit();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add("-y");
    ((ArrayList)localObject2).add("-i");
    ((ArrayList)localObject2).add(localStringBuffer.toString());
    ((ArrayList)localObject2).add("-c");
    ((ArrayList)localObject2).add("copy");
    ((ArrayList)localObject2).add(paramList);
    paramString.cmd = ((String[])((ArrayList)localObject2).toArray(new String[0]));
    paramString.callback = paramaafw;
    ((ArrayList)localObject1).add(paramString);
    if (this.jdField_a_of_type_Aafb.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.isFFmpegCommandRunning()) {
      try
      {
        this.jdField_a_of_type_Aafb.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.insertFFmpegQueue((ArrayList)localObject1);
        return;
      }
      catch (FFmpegCommandAlreadyRunningException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      catch (IOException paramList)
      {
        paramList.printStackTrace();
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_Aafb.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.cmdFFmpegQueue((ArrayList)localObject1);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    boolean bool = false;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint1 = new Paint();
      localPaint1.setColor(-1);
      localPaint1.setTextSize(30.0F);
      localPaint1.setTextAlign(Paint.Align.CENTER);
      Rect localRect = new Rect();
      localPaint1.getTextBounds(paramString1, 0, paramString1.length(), localRect);
      Paint localPaint2 = new Paint();
      localPaint2.setColor(-16777216);
      RectF localRectF = new RectF();
      localRectF.top = (paramInt2 - localRect.height() - 15 - 15);
      localRectF.left = ((paramInt1 - localRect.width()) / 2 - 15);
      localRectF.bottom = (localRectF.top + localRect.height() + 15);
      localRectF.right = (localRectF.left + localRect.width() + 30);
      localCanvas.drawRoundRect(localRectF, 8.0F, 8.0F, localPaint2);
      localCanvas.drawText(paramString1, paramInt1 / 2, paramInt2 - 15 - localRect.height() / 2, localPaint1);
      zdr.a(localBitmap, Bitmap.CompressFormat.PNG, 100, paramString2);
      zdr.a(localBitmap);
      bool = true;
    }
    catch (Throwable paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(".troop.VideoCombineHelper", 2, "createWatermarkByWording", paramString1);
    }
    return bool;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafm
 * JD-Core Version:    0.7.0.1
 */