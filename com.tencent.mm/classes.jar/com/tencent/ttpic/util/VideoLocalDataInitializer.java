package com.tencent.ttpic.util;

import com.tencent.ttpic.model.VideoMaterialMetaData;
import java.util.ArrayList;
import java.util.List;

public class VideoLocalDataInitializer
{
  public static String[] LOCAL_MAKEUP_MATERIAL_IDS = new String[0];
  public static String[] LOCAL_STICKER_MATERIAL_IDS;
  public static String[] ONLINE_MAKEUP_MATERIAL_IDS;
  public static String[] ONLINE_STICKER_MATERIAL_IDS = { "video_3DFace_alalei1", "video_3DFace_wuyifan1", "video_Q520ma", "video_shinecat", "video_tuzichiyuebing", "video_dushumao", "video_xiaofu", "video_deer_cat" };
  
  static
  {
    ONLINE_MAKEUP_MATERIAL_IDS = new String[] { "video_liujinchuncai1", "video_yuansufugu", "video_renyuzhuang" };
    LOCAL_STICKER_MATERIAL_IDS = new String[0];
  }
  
  public static List<VideoMaterialMetaData> buildMakeupVideoMaterials()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoMaterialMetaData(null, "None", null, "assets://none.png"));
    String[] arrayOfString = LOCAL_MAKEUP_MATERIAL_IDS;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      localArrayList.add(new VideoMaterialMetaData(str, "assets://camera/camera_video/CameraVideoAnimal/" + str, "", "assets://camera/camera_video/CameraVideoAnimal/" + str + "/" + str + ".png"));
      i += 1;
    }
    arrayOfString = ONLINE_MAKEUP_MATERIAL_IDS;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      localArrayList.add(new VideoMaterialMetaData(str, "", "http://res.tu.qq.com/materials/" + str + "Android.zip", "http://res.tu.qq.com/materials/" + str + ".png"));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<VideoMaterialMetaData> buildStickerVideoMaterials()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoMaterialMetaData("video_mv_comic3", "assets://camera/camera_video/video_mv_comic3", "", "assets://camera/camera_video/video_mv_comic3/video_mv_comic3.png"));
    localArrayList.add(new VideoMaterialMetaData(null, "None", null, "assets://none.png"));
    String[] arrayOfString = LOCAL_STICKER_MATERIAL_IDS;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      localArrayList.add(new VideoMaterialMetaData(str, "assets://camera/camera_video/CameraVideoAnimal/" + str, "", "assets://camera/camera_video/CameraVideoAnimal/" + str + "/" + str + ".png"));
      i += 1;
    }
    arrayOfString = ONLINE_STICKER_MATERIAL_IDS;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      localArrayList.add(new VideoMaterialMetaData(str, "", "http://res.tu.qq.com/materials/" + str + "Android.zip", "http://res.tu.qq.com/materials/" + str + ".png"));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoLocalDataInitializer
 * JD-Core Version:    0.7.0.1
 */