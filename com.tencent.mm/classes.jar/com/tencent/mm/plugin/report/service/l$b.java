package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/service/UserDataOperationReporter$DataType;", "", "()V", "ADDRESS", "", "AVATAR", "BIND_MOBILE", "DEVICE_NAME", "DEVICE_TYPR", "FINDER_AUTH", "FINDER_AVATAR", "FINDER_BIND", "FINDER_BIND_WEWORK", "FINDER_BLACKLIST", "FINDER_COVER", "FINDER_GENDER", "FINDER_INTRO", "FINDER_NAME", "FINDER_REGION", "GAME_ALBUM", "GAME_AVATAR", "GAME_BIRTH", "GAME_GENDER", "GAME_NICKNAME", "GAME_REGION", "GAME_SIGNATURE", "GAME_WELFARE_GAME", "GAME_WELFARE_PHONE_NO", "GAME_WELFARE_REGION", "GENDER", "IMAGE", "LOCATION", "NICK_NAME", "RECOMMEND_CONTACTS", "REGION", "SIGNATURE", "STEP", "toString", "", "type", "DataTypeDef", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l$b
{
  public static final b OBa;
  
  static
  {
    AppMethodBeat.i(261718);
    OBa = new b();
    AppMethodBeat.o(261718);
  }
  
  public static String toString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 1: 
      return "微信昵称";
    case 2: 
      return "微信头像";
    case 3: 
      return "微信绑定手机号";
    case 4: 
      return "微信个人资料性别";
    case 5: 
      return "微信个人资料地区";
    case 6: 
      return "微信个性签名";
    case 7: 
      return "微信个人资料地址";
    case 8: 
      return "设备名称";
    case 9: 
      return "设备类型";
    case 10: 
      return "位置信息";
    case 11: 
      return "图片信息";
    case 12: 
      return "微信运动步数";
    case 13: 
      return "视频号名字";
    case 14: 
      return "视频号头像";
    case 15: 
      return "视频号性别";
    case 16: 
      return "视频号地区";
    case 17: 
      return "视频号简介";
    case 18: 
      return "视频号封面";
    case 19: 
      return "视频号认证信息";
    case 20: 
      return "视频号黑名单";
    case 21: 
      return "视频号绑定的公众号（H5）";
    case 22: 
      return "视频号绑定的企业微信（H5）";
    case 23: 
      return "微信游戏头像";
    case 24: 
      return "微信游戏昵称";
    case 25: 
      return "微信游戏生活照";
    case 26: 
      return "微信游戏签名";
    case 27: 
      return "微信游戏性别";
    case 28: 
      return "微信游戏生日";
    case 29: 
      return "微信游戏地区";
    case 30: 
      return "微信游戏领取福利姓名";
    case 31: 
      return "微信游戏领取福利手机号";
    case 32: 
      return "微信游戏领取福利地址";
    }
    return "推荐通讯录朋友(手机联系人)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.l.b
 * JD-Core Version:    0.7.0.1
 */