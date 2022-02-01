package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class asy
  extends com.tencent.mm.bx.a
{
  public long Ysz;
  public boolean ZDd;
  public String ZDe;
  public String ZDf;
  public long ZDg;
  public boolean ZDh;
  public String ZDi;
  public String ZDj;
  public String ZDk;
  public int ZDl;
  public String ZDm;
  public String ZDn;
  public String ZDo;
  public String ZDp;
  public String ZDq;
  public int ZDr;
  public String ZDs;
  public int ZDt;
  public String ZDu;
  public long ZDv;
  public String ZDw;
  public String ZDx;
  public long ZDy;
  public String appId;
  public String filePath;
  public String lPJ;
  public String processName;
  public boolean rvh;
  public int scene;
  public int wQW;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258491);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ifAppAttachDownloadUI", Boolean.valueOf(this.ZDd), false);
      com.tencent.mm.bk.a.a(localJSONObject, "filePath", this.filePath, false);
      com.tencent.mm.bk.a.a(localJSONObject, "fileExt", this.lPJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "appId", this.appId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "processName", this.processName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "sence", Integer.valueOf(this.wQW), false);
      com.tencent.mm.bk.a.a(localJSONObject, "showMenu", Boolean.valueOf(this.rvh), false);
      com.tencent.mm.bk.a.a(localJSONObject, "fileLen", Long.valueOf(this.Ysz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "app_type", this.ZDe, false);
      com.tencent.mm.bk.a.a(localJSONObject, "app_media_id", this.ZDf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "app_msg_id", Long.valueOf(this.ZDg), false);
      com.tencent.mm.bk.a.a(localJSONObject, "app_show_share", Boolean.valueOf(this.ZDh), false);
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Integer.valueOf(this.scene), false);
      com.tencent.mm.bk.a.a(localJSONObject, "choose_way", this.ZDi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "msg_type", this.ZDj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_md5", this.ZDk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_source", Integer.valueOf(this.ZDl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_svrId", this.ZDm, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_extId", this.ZDn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_cdnUrl", this.ZDo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_aesKey", this.ZDp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_authKey", this.ZDq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_fileStatus", Integer.valueOf(this.ZDr), false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_appId", this.ZDs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_sdkVersion", Integer.valueOf(this.ZDt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_mediaId", this.ZDu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_uploadedSize", Long.valueOf(this.ZDv), false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_from", this.ZDw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_to", this.ZDx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_size", Long.valueOf(this.ZDy), false);
      label379:
      AppMethodBeat.o(258491);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label379;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258498);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.ZDd);
      if (this.filePath != null) {
        paramVarArgs.g(2, this.filePath);
      }
      if (this.lPJ != null) {
        paramVarArgs.g(3, this.lPJ);
      }
      if (this.appId != null) {
        paramVarArgs.g(4, this.appId);
      }
      if (this.processName != null) {
        paramVarArgs.g(5, this.processName);
      }
      paramVarArgs.bS(6, this.wQW);
      paramVarArgs.di(7, this.rvh);
      paramVarArgs.bv(8, this.Ysz);
      if (this.ZDe != null) {
        paramVarArgs.g(9, this.ZDe);
      }
      if (this.ZDf != null) {
        paramVarArgs.g(10, this.ZDf);
      }
      paramVarArgs.bv(11, this.ZDg);
      paramVarArgs.di(12, this.ZDh);
      paramVarArgs.bS(13, this.scene);
      if (this.ZDi != null) {
        paramVarArgs.g(14, this.ZDi);
      }
      if (this.ZDj != null) {
        paramVarArgs.g(15, this.ZDj);
      }
      if (this.ZDk != null) {
        paramVarArgs.g(16, this.ZDk);
      }
      paramVarArgs.bS(17, this.ZDl);
      if (this.ZDm != null) {
        paramVarArgs.g(18, this.ZDm);
      }
      if (this.ZDn != null) {
        paramVarArgs.g(19, this.ZDn);
      }
      if (this.ZDo != null) {
        paramVarArgs.g(20, this.ZDo);
      }
      if (this.ZDp != null) {
        paramVarArgs.g(21, this.ZDp);
      }
      if (this.ZDq != null) {
        paramVarArgs.g(22, this.ZDq);
      }
      paramVarArgs.bS(23, this.ZDr);
      if (this.ZDs != null) {
        paramVarArgs.g(24, this.ZDs);
      }
      paramVarArgs.bS(25, this.ZDt);
      if (this.ZDu != null) {
        paramVarArgs.g(26, this.ZDu);
      }
      paramVarArgs.bv(27, this.ZDv);
      if (this.ZDw != null) {
        paramVarArgs.g(28, this.ZDw);
      }
      if (this.ZDx != null) {
        paramVarArgs.g(29, this.ZDx);
      }
      paramVarArgs.bv(30, this.ZDy);
      AppMethodBeat.o(258498);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.filePath != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.filePath);
      }
      i = paramInt;
      if (this.lPJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.lPJ);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.appId);
      }
      i = paramInt;
      if (this.processName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.processName);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.wQW) + (i.a.a.b.b.a.ko(7) + 1) + i.a.a.b.b.a.q(8, this.Ysz);
      paramInt = i;
      if (this.ZDe != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZDe);
      }
      i = paramInt;
      if (this.ZDf != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZDf);
      }
      i = i + i.a.a.b.b.a.q(11, this.ZDg) + (i.a.a.b.b.a.ko(12) + 1) + i.a.a.b.b.a.cJ(13, this.scene);
      paramInt = i;
      if (this.ZDi != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ZDi);
      }
      i = paramInt;
      if (this.ZDj != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.ZDj);
      }
      paramInt = i;
      if (this.ZDk != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.ZDk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.ZDl);
      paramInt = i;
      if (this.ZDm != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.ZDm);
      }
      i = paramInt;
      if (this.ZDn != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.ZDn);
      }
      paramInt = i;
      if (this.ZDo != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.ZDo);
      }
      i = paramInt;
      if (this.ZDp != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.ZDp);
      }
      paramInt = i;
      if (this.ZDq != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.ZDq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(23, this.ZDr);
      paramInt = i;
      if (this.ZDs != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.ZDs);
      }
      i = paramInt + i.a.a.b.b.a.cJ(25, this.ZDt);
      paramInt = i;
      if (this.ZDu != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.ZDu);
      }
      i = paramInt + i.a.a.b.b.a.q(27, this.ZDv);
      paramInt = i;
      if (this.ZDw != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.ZDw);
      }
      i = paramInt;
      if (this.ZDx != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.ZDx);
      }
      paramInt = i.a.a.b.b.a.q(30, this.ZDy);
      AppMethodBeat.o(258498);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258498);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      asy localasy = (asy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258498);
        return -1;
      case 1: 
        localasy.ZDd = locala.ajGk.aai();
        AppMethodBeat.o(258498);
        return 0;
      case 2: 
        localasy.filePath = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 3: 
        localasy.lPJ = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 4: 
        localasy.appId = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 5: 
        localasy.processName = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 6: 
        localasy.wQW = locala.ajGk.aar();
        AppMethodBeat.o(258498);
        return 0;
      case 7: 
        localasy.rvh = locala.ajGk.aai();
        AppMethodBeat.o(258498);
        return 0;
      case 8: 
        localasy.Ysz = locala.ajGk.aaw();
        AppMethodBeat.o(258498);
        return 0;
      case 9: 
        localasy.ZDe = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 10: 
        localasy.ZDf = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 11: 
        localasy.ZDg = locala.ajGk.aaw();
        AppMethodBeat.o(258498);
        return 0;
      case 12: 
        localasy.ZDh = locala.ajGk.aai();
        AppMethodBeat.o(258498);
        return 0;
      case 13: 
        localasy.scene = locala.ajGk.aar();
        AppMethodBeat.o(258498);
        return 0;
      case 14: 
        localasy.ZDi = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 15: 
        localasy.ZDj = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 16: 
        localasy.ZDk = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 17: 
        localasy.ZDl = locala.ajGk.aar();
        AppMethodBeat.o(258498);
        return 0;
      case 18: 
        localasy.ZDm = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 19: 
        localasy.ZDn = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 20: 
        localasy.ZDo = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 21: 
        localasy.ZDp = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 22: 
        localasy.ZDq = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 23: 
        localasy.ZDr = locala.ajGk.aar();
        AppMethodBeat.o(258498);
        return 0;
      case 24: 
        localasy.ZDs = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 25: 
        localasy.ZDt = locala.ajGk.aar();
        AppMethodBeat.o(258498);
        return 0;
      case 26: 
        localasy.ZDu = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 27: 
        localasy.ZDv = locala.ajGk.aaw();
        AppMethodBeat.o(258498);
        return 0;
      case 28: 
        localasy.ZDw = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      case 29: 
        localasy.ZDx = locala.ajGk.readString();
        AppMethodBeat.o(258498);
        return 0;
      }
      localasy.ZDy = locala.ajGk.aaw();
      AppMethodBeat.o(258498);
      return 0;
    }
    AppMethodBeat.o(258498);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asy
 * JD-Core Version:    0.7.0.1
 */