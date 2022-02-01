package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public class foe
  extends com.tencent.mm.bx.a
{
  public LinkedList<aem> Wol;
  public String abOf;
  public String abOg;
  public String abOh;
  public String abOi;
  public long abOj;
  public foh abOk;
  public fcl abOl;
  public boolean abOm;
  public LinkedList<foh> abOn;
  public int abOo;
  public int abOp;
  public String abOq;
  public int abOr;
  public boolean abOs;
  public String hAB;
  public boolean lAj;
  public String mpa;
  public int offset;
  public int scene;
  public String zIO;
  
  public foe()
  {
    AppMethodBeat.i(153006);
    this.Wol = new LinkedList();
    this.abOn = new LinkedList();
    AppMethodBeat.o(153006);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258198);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "relevantVid", this.abOf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevantExpand", this.abOg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevantPreSearchId", this.abOh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevantSharedOpenID", this.abOi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "recCategory", Long.valueOf(this.abOj), false);
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Integer.valueOf(this.scene), false);
      com.tencent.mm.bk.a.a(localJSONObject, "searchId", this.mpa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "keyword", this.hAB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "firstVideoInfo", this.abOk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "clickTag", this.abOl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "extReqParams", this.Wol, false);
      com.tencent.mm.bk.a.a(localJSONObject, "contextId", this.zIO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "offset", Integer.valueOf(this.offset), false);
      com.tencent.mm.bk.a.a(localJSONObject, "enbaleMobileNet", Boolean.valueOf(this.abOm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoList", this.abOn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "currentPlayPosition", Integer.valueOf(this.abOo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "currentPlaySecond", Integer.valueOf(this.abOp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isMute", Boolean.valueOf(this.lAj), false);
      com.tencent.mm.bk.a.a(localJSONObject, "preNetType", this.abOq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "hasCheckMobile", Integer.valueOf(this.abOr), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isSinglePage", Boolean.valueOf(this.abOs), false);
      label271:
      AppMethodBeat.o(258198);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label271;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153007);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abOf != null) {
        paramVarArgs.g(1, this.abOf);
      }
      if (this.abOg != null) {
        paramVarArgs.g(2, this.abOg);
      }
      if (this.abOh != null) {
        paramVarArgs.g(3, this.abOh);
      }
      if (this.abOi != null) {
        paramVarArgs.g(4, this.abOi);
      }
      paramVarArgs.bv(5, this.abOj);
      paramVarArgs.bS(6, this.scene);
      if (this.mpa != null) {
        paramVarArgs.g(7, this.mpa);
      }
      if (this.hAB != null) {
        paramVarArgs.g(8, this.hAB);
      }
      if (this.abOk != null)
      {
        paramVarArgs.qD(9, this.abOk.computeSize());
        this.abOk.writeFields(paramVarArgs);
      }
      if (this.abOl != null)
      {
        paramVarArgs.qD(10, this.abOl.computeSize());
        this.abOl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.Wol);
      if (this.zIO != null) {
        paramVarArgs.g(12, this.zIO);
      }
      paramVarArgs.bS(13, this.offset);
      paramVarArgs.di(14, this.abOm);
      paramVarArgs.e(15, 8, this.abOn);
      paramVarArgs.bS(16, this.abOo);
      paramVarArgs.bS(17, this.abOp);
      paramVarArgs.di(18, this.lAj);
      if (this.abOq != null) {
        paramVarArgs.g(19, this.abOq);
      }
      paramVarArgs.bS(20, this.abOr);
      paramVarArgs.di(21, this.abOs);
      AppMethodBeat.o(153007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abOf == null) {
        break label1546;
      }
    }
    label1546:
    for (int i = i.a.a.b.b.a.h(1, this.abOf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abOg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abOg);
      }
      i = paramInt;
      if (this.abOh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abOh);
      }
      paramInt = i;
      if (this.abOi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abOi);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.abOj) + i.a.a.b.b.a.cJ(6, this.scene);
      paramInt = i;
      if (this.mpa != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.mpa);
      }
      i = paramInt;
      if (this.hAB != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.hAB);
      }
      paramInt = i;
      if (this.abOk != null) {
        paramInt = i + i.a.a.a.qC(9, this.abOk.computeSize());
      }
      i = paramInt;
      if (this.abOl != null) {
        i = paramInt + i.a.a.a.qC(10, this.abOl.computeSize());
      }
      i += i.a.a.a.c(11, 8, this.Wol);
      paramInt = i;
      if (this.zIO != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.zIO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.offset) + (i.a.a.b.b.a.ko(14) + 1) + i.a.a.a.c(15, 8, this.abOn) + i.a.a.b.b.a.cJ(16, this.abOo) + i.a.a.b.b.a.cJ(17, this.abOp) + (i.a.a.b.b.a.ko(18) + 1);
      paramInt = i;
      if (this.abOq != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.abOq);
      }
      i = i.a.a.b.b.a.cJ(20, this.abOr);
      int j = i.a.a.b.b.a.ko(21);
      AppMethodBeat.o(153007);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Wol.clear();
        this.abOn.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        foe localfoe = (foe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153007);
          return -1;
        case 1: 
          localfoe.abOf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 2: 
          localfoe.abOg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 3: 
          localfoe.abOh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 4: 
          localfoe.abOi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 5: 
          localfoe.abOj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153007);
          return 0;
        case 6: 
          localfoe.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153007);
          return 0;
        case 7: 
          localfoe.mpa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 8: 
          localfoe.hAB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 9: 
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
            localfoe.abOk = ((foh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 10: 
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
            localfoe.abOl = ((fcl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 11: 
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
            localfoe.Wol.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 12: 
          localfoe.zIO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 13: 
          localfoe.offset = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153007);
          return 0;
        case 14: 
          localfoe.abOm = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153007);
          return 0;
        case 15: 
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
            localfoe.abOn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 16: 
          localfoe.abOo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153007);
          return 0;
        case 17: 
          localfoe.abOp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153007);
          return 0;
        case 18: 
          localfoe.lAj = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153007);
          return 0;
        case 19: 
          localfoe.abOq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 20: 
          localfoe.abOr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153007);
          return 0;
        }
        localfoe.abOs = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(153007);
        return 0;
      }
      AppMethodBeat.o(153007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foe
 * JD-Core Version:    0.7.0.1
 */