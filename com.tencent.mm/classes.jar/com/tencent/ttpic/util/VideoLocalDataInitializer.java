package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterialMetaData;
import java.util.ArrayList;
import java.util.List;

public class VideoLocalDataInitializer
{
  private static String[] LOCAL_MATERIAL_IDS = { "video_fireburning_db", "video_fengkuangdacall_audio", "video_dangdangdang", "video_jmskull2", "video_mv_gun", "video_yinxingchibang", "video_expression_level1", "video_voice_text_mouth", "video_pikachu", "video_money_1", "video_bubble", "video_mv_comic3", "video_egaoshuangwanzi", "video_newyearlucky_suiji", "video_filters_chazi", "video_filters_hanfeng", "video_filters_hongkong", "video_filters_jiazhou", "video_animalword" };
  public static String[] ONLINE_MATERIAL_IDS = { "video_3DFace_santaglass", "video_bluecat", "video_huzi_white", "video_nihongshu", "video_Qmaozi", "video_wawaji", "video_nonono", "video_rainbow", "video_mv_fenbimao", "video_baby_agetest", "video_mjdance", "video_astronaut", "video_mv_wing", "video_liuhai", "video_mv_dongwuyuan", "video_handsomeGuy", "video_qixi", "video_guifeiface", "video_huaxianzi", "video_particle_cherryblossom", "video_heart_lips", "video_yinjiuzui", "video_huzi_black", "video_xinniang", "video_xiaobian", "video_mojing_yangyang" };
  
  public static List<VideoMaterialMetaData> buildVideoMaterials()
  {
    int j = 0;
    AppMethodBeat.i(84043);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoMaterialMetaData(null, "None", null, "assets://none.png"));
    String[] arrayOfString = LOCAL_MATERIAL_IDS;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      localArrayList.add(new VideoMaterialMetaData(str, "assets://camera/camera_video/CameraVideoAnimal/".concat(String.valueOf(str)), "", "assets://camera/camera_video/CameraVideoAnimal/" + str + "/" + str + ".png"));
      i += 1;
    }
    arrayOfString = ONLINE_MATERIAL_IDS;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      localArrayList.add(new VideoMaterialMetaData(str, "", "http://res.tu.qq.com/materials/" + str + "Android.zip", "http://res.tu.qq.com/materials/" + str + ".png"));
      i += 1;
    }
    localArrayList.add(new VideoMaterialMetaData("video_3DFace_fashionglass1", "", "http://st1.xiangji.qq.com/pitu/materials/video_3DFace_fashionglass1Android.zip", "http://st1.xiangji.qq.com/pitu/materials/video_3DFace_fashionglass1.png"));
    AppMethodBeat.o(84043);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoLocalDataInitializer
 * JD-Core Version:    0.7.0.1
 */