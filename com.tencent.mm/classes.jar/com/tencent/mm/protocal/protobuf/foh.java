package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public class foh
  extends com.tencent.mm.bx.a
{
  public String ELy;
  public String HsD;
  public String ICb;
  public LinkedList<fcl> Idn;
  public String Ido;
  public int Rfk;
  public LinkedList<aem> Wol;
  public String Wpe;
  public String Wpf;
  public String Wpg;
  public String Wph;
  public String Wpi;
  public String aaXP;
  public String abOA;
  public long abOB;
  public long abOC;
  public LinkedList<foj> abOD;
  public int abOE;
  public long abOF;
  public foc abOG;
  public int abOH;
  public int abOI;
  public boolean abOJ;
  public fof abOK;
  public int abOL;
  public foh abOM;
  public int abON;
  public foa abOO;
  public int abOP;
  public long abOw;
  public String abOx;
  public String abOy;
  public int abOz;
  public long beV;
  public String hAw;
  public boolean hBY;
  public String ibx;
  public String oeS;
  public String source;
  public String svG;
  public int thumbHeight;
  public int thumbWidth;
  public long timestamp;
  public String title;
  public String videoUrl;
  public String ytZ;
  
  public foh()
  {
    AppMethodBeat.i(153012);
    this.Idn = new LinkedList();
    this.abOD = new LinkedList();
    this.Wol = new LinkedList();
    AppMethodBeat.o(153012);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258072);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoUrl", this.videoUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "thumbnailUrl", this.oeS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoDurationSec", Integer.valueOf(this.Rfk), false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoId", this.Ido, false);
      com.tencent.mm.bk.a.a(localJSONObject, "thumbWidth", Integer.valueOf(this.thumbWidth), false);
      com.tencent.mm.bk.a.a(localJSONObject, "thumbHeight", Integer.valueOf(this.thumbHeight), false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareUrl", this.ytZ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareTitle", this.svG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareDesc", this.ICb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareImgUrl", this.Wpe, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareString", this.Wpf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareStringUrl", this.Wpg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "source", this.source, false);
      com.tencent.mm.bk.a.a(localJSONObject, "sourceUrl", this.ibx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevantCategory", Long.valueOf(this.abOw), false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareOpenId", this.abOx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "expand", this.abOy, false);
      com.tencent.mm.bk.a.a(localJSONObject, "strPlayCount", this.Wph, false);
      com.tencent.mm.bk.a.a(localJSONObject, "titleUrl", this.Wpi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "itemtype", Integer.valueOf(this.abOz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "itemExpand", this.abOA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "bizIcon", this.aaXP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "tagList", this.Idn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "timestamp", Long.valueOf(this.timestamp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isShow", Boolean.valueOf(this.hBY), false);
      com.tencent.mm.bk.a.a(localJSONObject, "docId", this.HsD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "resultType", Long.valueOf(this.abOB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "type", Long.valueOf(this.beV), false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoSize", Long.valueOf(this.abOC), false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoUrlList", this.abOD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "switchFlag", Integer.valueOf(this.abOE), false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareChannelId", Long.valueOf(this.abOF), false);
      com.tencent.mm.bk.a.a(localJSONObject, "secondVideoInfo", this.abOG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "cdnScene", Integer.valueOf(this.abOH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "cdnSourceType", Integer.valueOf(this.abOI), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isSelfThumb", Boolean.valueOf(this.abOJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "byPass", this.ELy, false);
      com.tencent.mm.bk.a.a(localJSONObject, "feedBackInfo", this.abOK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "vt", Integer.valueOf(this.abOL), false);
      com.tencent.mm.bk.a.a(localJSONObject, "longVideoInfo", this.abOM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "extReqParams", this.Wol, false);
      com.tencent.mm.bk.a.a(localJSONObject, "globalColikeCnt", Integer.valueOf(this.abON), false);
      com.tencent.mm.bk.a.a(localJSONObject, "pointVideoInfo", this.abOO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "bizUserName", this.hAw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "sourceJumpType", Integer.valueOf(this.abOP), false);
      label582:
      AppMethodBeat.o(258072);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label582;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153013);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.videoUrl != null) {
        paramVarArgs.g(2, this.videoUrl);
      }
      if (this.oeS != null) {
        paramVarArgs.g(3, this.oeS);
      }
      paramVarArgs.bS(4, this.Rfk);
      if (this.Ido != null) {
        paramVarArgs.g(5, this.Ido);
      }
      paramVarArgs.bS(6, this.thumbWidth);
      paramVarArgs.bS(7, this.thumbHeight);
      if (this.ytZ != null) {
        paramVarArgs.g(8, this.ytZ);
      }
      if (this.svG != null) {
        paramVarArgs.g(9, this.svG);
      }
      if (this.ICb != null) {
        paramVarArgs.g(10, this.ICb);
      }
      if (this.Wpe != null) {
        paramVarArgs.g(11, this.Wpe);
      }
      if (this.Wpf != null) {
        paramVarArgs.g(12, this.Wpf);
      }
      if (this.Wpg != null) {
        paramVarArgs.g(13, this.Wpg);
      }
      if (this.source != null) {
        paramVarArgs.g(14, this.source);
      }
      if (this.ibx != null) {
        paramVarArgs.g(15, this.ibx);
      }
      paramVarArgs.bv(16, this.abOw);
      if (this.abOx != null) {
        paramVarArgs.g(17, this.abOx);
      }
      if (this.abOy != null) {
        paramVarArgs.g(18, this.abOy);
      }
      if (this.Wph != null) {
        paramVarArgs.g(19, this.Wph);
      }
      if (this.Wpi != null) {
        paramVarArgs.g(20, this.Wpi);
      }
      paramVarArgs.bS(21, this.abOz);
      if (this.abOA != null) {
        paramVarArgs.g(22, this.abOA);
      }
      if (this.aaXP != null) {
        paramVarArgs.g(23, this.aaXP);
      }
      paramVarArgs.e(24, 8, this.Idn);
      paramVarArgs.bv(25, this.timestamp);
      paramVarArgs.di(26, this.hBY);
      if (this.HsD != null) {
        paramVarArgs.g(27, this.HsD);
      }
      paramVarArgs.bv(28, this.abOB);
      paramVarArgs.bv(29, this.beV);
      paramVarArgs.bv(30, this.abOC);
      paramVarArgs.e(31, 8, this.abOD);
      paramVarArgs.bS(32, this.abOE);
      paramVarArgs.bv(33, this.abOF);
      if (this.abOG != null)
      {
        paramVarArgs.qD(34, this.abOG.computeSize());
        this.abOG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(35, this.abOH);
      paramVarArgs.bS(36, this.abOI);
      paramVarArgs.di(37, this.abOJ);
      if (this.ELy != null) {
        paramVarArgs.g(38, this.ELy);
      }
      if (this.abOK != null)
      {
        paramVarArgs.qD(39, this.abOK.computeSize());
        this.abOK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(40, this.abOL);
      if (this.abOM != null)
      {
        paramVarArgs.qD(41, this.abOM.computeSize());
        this.abOM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 8, this.Wol);
      paramVarArgs.bS(43, this.abON);
      if (this.abOO != null)
      {
        paramVarArgs.qD(44, this.abOO.computeSize());
        this.abOO.writeFields(paramVarArgs);
      }
      if (this.hAw != null) {
        paramVarArgs.g(45, this.hAw);
      }
      paramVarArgs.bS(46, this.abOP);
      AppMethodBeat.o(153013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label3196;
      }
    }
    label3196:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.videoUrl);
      }
      i = paramInt;
      if (this.oeS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oeS);
      }
      i += i.a.a.b.b.a.cJ(4, this.Rfk);
      paramInt = i;
      if (this.Ido != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Ido);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.thumbWidth) + i.a.a.b.b.a.cJ(7, this.thumbHeight);
      paramInt = i;
      if (this.ytZ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ytZ);
      }
      i = paramInt;
      if (this.svG != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.svG);
      }
      paramInt = i;
      if (this.ICb != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ICb);
      }
      i = paramInt;
      if (this.Wpe != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Wpe);
      }
      paramInt = i;
      if (this.Wpf != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Wpf);
      }
      i = paramInt;
      if (this.Wpg != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.Wpg);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.source);
      }
      i = paramInt;
      if (this.ibx != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.ibx);
      }
      i += i.a.a.b.b.a.q(16, this.abOw);
      paramInt = i;
      if (this.abOx != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.abOx);
      }
      i = paramInt;
      if (this.abOy != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.abOy);
      }
      paramInt = i;
      if (this.Wph != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.Wph);
      }
      i = paramInt;
      if (this.Wpi != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.Wpi);
      }
      i += i.a.a.b.b.a.cJ(21, this.abOz);
      paramInt = i;
      if (this.abOA != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.abOA);
      }
      i = paramInt;
      if (this.aaXP != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.aaXP);
      }
      i = i + i.a.a.a.c(24, 8, this.Idn) + i.a.a.b.b.a.q(25, this.timestamp) + (i.a.a.b.b.a.ko(26) + 1);
      paramInt = i;
      if (this.HsD != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.HsD);
      }
      i = paramInt + i.a.a.b.b.a.q(28, this.abOB) + i.a.a.b.b.a.q(29, this.beV) + i.a.a.b.b.a.q(30, this.abOC) + i.a.a.a.c(31, 8, this.abOD) + i.a.a.b.b.a.cJ(32, this.abOE) + i.a.a.b.b.a.q(33, this.abOF);
      paramInt = i;
      if (this.abOG != null) {
        paramInt = i + i.a.a.a.qC(34, this.abOG.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(35, this.abOH) + i.a.a.b.b.a.cJ(36, this.abOI) + (i.a.a.b.b.a.ko(37) + 1);
      paramInt = i;
      if (this.ELy != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.ELy);
      }
      i = paramInt;
      if (this.abOK != null) {
        i = paramInt + i.a.a.a.qC(39, this.abOK.computeSize());
      }
      i += i.a.a.b.b.a.cJ(40, this.abOL);
      paramInt = i;
      if (this.abOM != null) {
        paramInt = i + i.a.a.a.qC(41, this.abOM.computeSize());
      }
      i = paramInt + i.a.a.a.c(42, 8, this.Wol) + i.a.a.b.b.a.cJ(43, this.abON);
      paramInt = i;
      if (this.abOO != null) {
        paramInt = i + i.a.a.a.qC(44, this.abOO.computeSize());
      }
      i = paramInt;
      if (this.hAw != null) {
        i = paramInt + i.a.a.b.b.a.h(45, this.hAw);
      }
      paramInt = i.a.a.b.b.a.cJ(46, this.abOP);
      AppMethodBeat.o(153013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Idn.clear();
        this.abOD.clear();
        this.Wol.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        foh localfoh = (foh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153013);
          return -1;
        case 1: 
          localfoh.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 2: 
          localfoh.videoUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 3: 
          localfoh.oeS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 4: 
          localfoh.Rfk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 5: 
          localfoh.Ido = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 6: 
          localfoh.thumbWidth = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 7: 
          localfoh.thumbHeight = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 8: 
          localfoh.ytZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 9: 
          localfoh.svG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 10: 
          localfoh.ICb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 11: 
          localfoh.Wpe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 12: 
          localfoh.Wpf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 13: 
          localfoh.Wpg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 14: 
          localfoh.source = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 15: 
          localfoh.ibx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 16: 
          localfoh.abOw = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153013);
          return 0;
        case 17: 
          localfoh.abOx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 18: 
          localfoh.abOy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 19: 
          localfoh.Wph = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 20: 
          localfoh.Wpi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 21: 
          localfoh.abOz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 22: 
          localfoh.abOA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 23: 
          localfoh.aaXP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcl)localObject2).parseFrom((byte[])localObject1);
            }
            localfoh.Idn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 25: 
          localfoh.timestamp = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153013);
          return 0;
        case 26: 
          localfoh.hBY = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153013);
          return 0;
        case 27: 
          localfoh.HsD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 28: 
          localfoh.abOB = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153013);
          return 0;
        case 29: 
          localfoh.beV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153013);
          return 0;
        case 30: 
          localfoh.abOC = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153013);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foj)localObject2).parseFrom((byte[])localObject1);
            }
            localfoh.abOD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 32: 
          localfoh.abOE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 33: 
          localfoh.abOF = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153013);
          return 0;
        case 34: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foc)localObject2).parseFrom((byte[])localObject1);
            }
            localfoh.abOG = ((foc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 35: 
          localfoh.abOH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 36: 
          localfoh.abOI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 37: 
          localfoh.abOJ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153013);
          return 0;
        case 38: 
          localfoh.ELy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 39: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fof();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fof)localObject2).parseFrom((byte[])localObject1);
            }
            localfoh.abOK = ((fof)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 40: 
          localfoh.abOL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 41: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foh)localObject2).parseFrom((byte[])localObject1);
            }
            localfoh.abOM = ((foh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 42: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aem();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aem)localObject2).parseFrom((byte[])localObject1);
            }
            localfoh.Wol.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 43: 
          localfoh.abON = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153013);
          return 0;
        case 44: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new foa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((foa)localObject2).parseFrom((byte[])localObject1);
            }
            localfoh.abOO = ((foa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 45: 
          localfoh.hAw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153013);
          return 0;
        }
        localfoh.abOP = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(153013);
        return 0;
      }
      AppMethodBeat.o(153013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foh
 * JD-Core Version:    0.7.0.1
 */