package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ghm
  extends com.tencent.mm.bx.a
{
  public int abot;
  public String acdA;
  public int acdB;
  public String acdC;
  public boolean acdD;
  public boolean acdE;
  public String acdF;
  public String acdG;
  public int acdH;
  public int acdI;
  public int acdJ;
  public int acdK;
  public String acdL;
  public int acdM;
  public int acdN;
  public long acdO;
  public int acdP;
  public long acdQ;
  public String acdR;
  public String acdS;
  public boolean acdT;
  public String acdU;
  public String coverUrl;
  public String iaa;
  public String iab;
  public String id;
  public String idu;
  public int mode;
  public String title;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258893);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "id", this.id, false);
      com.tencent.mm.bk.a.a(localJSONObject, "rawUrl", this.idu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "handoff_shareUrl", this.acdA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BizVideoPlayTime", Integer.valueOf(this.acdB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, false);
      com.tencent.mm.bk.a.a(localJSONObject, "webpageTitle", this.acdC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "hide_option_menu", Boolean.valueOf(this.acdD), false);
      com.tencent.mm.bk.a.a(localJSONObject, "translate_webview", Boolean.valueOf(this.acdE), false);
      com.tencent.mm.bk.a.a(localJSONObject, "srcUsername", this.iaa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "srcDisplayname", this.iab, false);
      com.tencent.mm.bk.a.a(localJSONObject, "mode", Integer.valueOf(this.mode), false);
      com.tencent.mm.bk.a.a(localJSONObject, "KTemplateId", this.acdF, false);
      com.tencent.mm.bk.a.a(localJSONObject, "KPublisherId", this.acdG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "k_tmpl_scene", Integer.valueOf(this.acdH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "k_tmpl_sub_scene", Integer.valueOf(this.acdI), false);
      com.tencent.mm.bk.a.a(localJSONObject, "pay_channel", Integer.valueOf(this.abot), false);
      com.tencent.mm.bk.a.a(localJSONObject, "key_download_restrict", Integer.valueOf(this.acdJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "key_wallet_region", Integer.valueOf(this.acdK), false);
      com.tencent.mm.bk.a.a(localJSONObject, "key_function_id", this.acdL, false);
      com.tencent.mm.bk.a.a(localJSONObject, "k_tmpl_item_show_type", Integer.valueOf(this.acdM), false);
      com.tencent.mm.bk.a.a(localJSONObject, "geta8key_scene", Integer.valueOf(this.acdN), false);
      com.tencent.mm.bk.a.a(localJSONObject, "biz_video_msg_id", Long.valueOf(this.acdO), false);
      com.tencent.mm.bk.a.a(localJSONObject, "biz_video_msg_index", Integer.valueOf(this.acdP), false);
      com.tencent.mm.bk.a.a(localJSONObject, "biz_video_msg_svr_id", Long.valueOf(this.acdQ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "biz_mp_msg_info", this.acdR, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ad_ux_info_for_jsapi_pay", this.acdS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "key_menu_hide_expose", Boolean.valueOf(this.acdT), false);
      com.tencent.mm.bk.a.a(localJSONObject, "webviewCurrentProcess", this.acdU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "coverUrl", this.coverUrl, false);
      label377:
      AppMethodBeat.o(258893);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label377;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258901);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.idu != null) {
        paramVarArgs.g(2, this.idu);
      }
      if (this.acdA != null) {
        paramVarArgs.g(3, this.acdA);
      }
      paramVarArgs.bS(4, this.acdB);
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      if (this.acdC != null) {
        paramVarArgs.g(6, this.acdC);
      }
      paramVarArgs.di(7, this.acdD);
      paramVarArgs.di(8, this.acdE);
      if (this.iaa != null) {
        paramVarArgs.g(9, this.iaa);
      }
      if (this.iab != null) {
        paramVarArgs.g(10, this.iab);
      }
      paramVarArgs.bS(11, this.mode);
      if (this.acdF != null) {
        paramVarArgs.g(12, this.acdF);
      }
      if (this.acdG != null) {
        paramVarArgs.g(13, this.acdG);
      }
      paramVarArgs.bS(14, this.acdH);
      paramVarArgs.bS(15, this.acdI);
      paramVarArgs.bS(16, this.abot);
      paramVarArgs.bS(17, this.acdJ);
      paramVarArgs.bS(18, this.acdK);
      if (this.acdL != null) {
        paramVarArgs.g(19, this.acdL);
      }
      paramVarArgs.bS(20, this.acdM);
      paramVarArgs.bS(21, this.acdN);
      paramVarArgs.bv(22, this.acdO);
      paramVarArgs.bS(23, this.acdP);
      paramVarArgs.bv(24, this.acdQ);
      if (this.acdR != null) {
        paramVarArgs.g(25, this.acdR);
      }
      if (this.acdS != null) {
        paramVarArgs.g(26, this.acdS);
      }
      paramVarArgs.di(27, this.acdT);
      if (this.acdU != null) {
        paramVarArgs.g(28, this.acdU);
      }
      if (this.coverUrl != null) {
        paramVarArgs.g(29, this.coverUrl);
      }
      AppMethodBeat.o(258901);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1674;
      }
    }
    label1674:
    for (int i = i.a.a.b.b.a.h(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.idu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.idu);
      }
      i = paramInt;
      if (this.acdA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acdA);
      }
      i += i.a.a.b.b.a.cJ(4, this.acdB);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.title);
      }
      i = paramInt;
      if (this.acdC != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.acdC);
      }
      i = i + (i.a.a.b.b.a.ko(7) + 1) + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.iaa != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.iaa);
      }
      i = paramInt;
      if (this.iab != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.iab);
      }
      i += i.a.a.b.b.a.cJ(11, this.mode);
      paramInt = i;
      if (this.acdF != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.acdF);
      }
      i = paramInt;
      if (this.acdG != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.acdG);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.acdH) + i.a.a.b.b.a.cJ(15, this.acdI) + i.a.a.b.b.a.cJ(16, this.abot) + i.a.a.b.b.a.cJ(17, this.acdJ) + i.a.a.b.b.a.cJ(18, this.acdK);
      paramInt = i;
      if (this.acdL != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.acdL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.acdM) + i.a.a.b.b.a.cJ(21, this.acdN) + i.a.a.b.b.a.q(22, this.acdO) + i.a.a.b.b.a.cJ(23, this.acdP) + i.a.a.b.b.a.q(24, this.acdQ);
      paramInt = i;
      if (this.acdR != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.acdR);
      }
      i = paramInt;
      if (this.acdS != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.acdS);
      }
      i += i.a.a.b.b.a.ko(27) + 1;
      paramInt = i;
      if (this.acdU != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.acdU);
      }
      i = paramInt;
      if (this.coverUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.coverUrl);
      }
      AppMethodBeat.o(258901);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258901);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ghm localghm = (ghm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258901);
          return -1;
        case 1: 
          localghm.id = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 2: 
          localghm.idu = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 3: 
          localghm.acdA = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 4: 
          localghm.acdB = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 5: 
          localghm.title = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 6: 
          localghm.acdC = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 7: 
          localghm.acdD = locala.ajGk.aai();
          AppMethodBeat.o(258901);
          return 0;
        case 8: 
          localghm.acdE = locala.ajGk.aai();
          AppMethodBeat.o(258901);
          return 0;
        case 9: 
          localghm.iaa = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 10: 
          localghm.iab = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 11: 
          localghm.mode = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 12: 
          localghm.acdF = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 13: 
          localghm.acdG = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 14: 
          localghm.acdH = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 15: 
          localghm.acdI = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 16: 
          localghm.abot = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 17: 
          localghm.acdJ = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 18: 
          localghm.acdK = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 19: 
          localghm.acdL = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 20: 
          localghm.acdM = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 21: 
          localghm.acdN = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 22: 
          localghm.acdO = locala.ajGk.aaw();
          AppMethodBeat.o(258901);
          return 0;
        case 23: 
          localghm.acdP = locala.ajGk.aar();
          AppMethodBeat.o(258901);
          return 0;
        case 24: 
          localghm.acdQ = locala.ajGk.aaw();
          AppMethodBeat.o(258901);
          return 0;
        case 25: 
          localghm.acdR = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 26: 
          localghm.acdS = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        case 27: 
          localghm.acdT = locala.ajGk.aai();
          AppMethodBeat.o(258901);
          return 0;
        case 28: 
          localghm.acdU = locala.ajGk.readString();
          AppMethodBeat.o(258901);
          return 0;
        }
        localghm.coverUrl = locala.ajGk.readString();
        AppMethodBeat.o(258901);
        return 0;
      }
      AppMethodBeat.o(258901);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghm
 * JD-Core Version:    0.7.0.1
 */