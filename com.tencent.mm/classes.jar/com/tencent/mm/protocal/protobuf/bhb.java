package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bhb
  extends dyl
{
  public int SFZ;
  public FinderObjectDesc SRA;
  public long SRB;
  public long SRC;
  public LinkedList<String> SRD;
  public b SRE;
  public String SRF;
  public int SRG;
  public int SRv;
  public float SRx;
  public float SRy;
  public int SRz;
  public apx attachmentList;
  public String clientId;
  public String groupId;
  public float latitude;
  public float longitude;
  public int originalFlag;
  public String refObjectNonceId;
  public LinkedList<String> topics;
  public String username;
  public long xdR;
  public aqe yjp;
  
  public bhb()
  {
    AppMethodBeat.i(169036);
    this.topics = new LinkedList();
    this.SRD = new LinkedList();
    AppMethodBeat.o(169036);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169037);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      if (this.SRA != null)
      {
        paramVarArgs.oE(3, this.SRA.computeSize());
        this.SRA.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.f(4, this.clientId);
      }
      paramVarArgs.bm(5, this.SRB);
      if (this.refObjectNonceId != null) {
        paramVarArgs.f(6, this.refObjectNonceId);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(7, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      paramVarArgs.i(8, this.longitude);
      paramVarArgs.i(9, this.latitude);
      paramVarArgs.i(10, this.SRx);
      paramVarArgs.i(11, this.SRy);
      paramVarArgs.aY(12, this.SRz);
      paramVarArgs.e(13, 1, this.topics);
      paramVarArgs.aY(14, this.originalFlag);
      paramVarArgs.bm(15, this.SRC);
      paramVarArgs.e(16, 1, this.SRD);
      if (this.SRE != null) {
        paramVarArgs.c(17, this.SRE);
      }
      if (this.groupId != null) {
        paramVarArgs.f(18, this.groupId);
      }
      if (this.attachmentList != null)
      {
        paramVarArgs.oE(20, this.attachmentList.computeSize());
        this.attachmentList.writeFields(paramVarArgs);
      }
      if (this.SRF != null) {
        paramVarArgs.f(21, this.SRF);
      }
      paramVarArgs.aY(22, this.SRG);
      paramVarArgs.aY(23, this.SRv);
      paramVarArgs.bm(24, this.xdR);
      paramVarArgs.aY(25, this.SFZ);
      AppMethodBeat.o(169037);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1726;
      }
    }
    label1726:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.username);
      }
      i = paramInt;
      if (this.SRA != null) {
        i = paramInt + g.a.a.a.oD(3, this.SRA.computeSize());
      }
      paramInt = i;
      if (this.clientId != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.clientId);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.SRB);
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.refObjectNonceId);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(7, this.yjp.computeSize());
      }
      i = i + (g.a.a.b.b.a.gL(8) + 4) + (g.a.a.b.b.a.gL(9) + 4) + (g.a.a.b.b.a.gL(10) + 4) + (g.a.a.b.b.a.gL(11) + 4) + g.a.a.b.b.a.bM(12, this.SRz) + g.a.a.a.c(13, 1, this.topics) + g.a.a.b.b.a.bM(14, this.originalFlag) + g.a.a.b.b.a.p(15, this.SRC) + g.a.a.a.c(16, 1, this.SRD);
      paramInt = i;
      if (this.SRE != null) {
        paramInt = i + g.a.a.b.b.a.b(17, this.SRE);
      }
      i = paramInt;
      if (this.groupId != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.groupId);
      }
      paramInt = i;
      if (this.attachmentList != null) {
        paramInt = i + g.a.a.a.oD(20, this.attachmentList.computeSize());
      }
      i = paramInt;
      if (this.SRF != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.SRF);
      }
      paramInt = g.a.a.b.b.a.bM(22, this.SRG);
      int j = g.a.a.b.b.a.bM(23, this.SRv);
      int k = g.a.a.b.b.a.p(24, this.xdR);
      int m = g.a.a.b.b.a.bM(25, this.SFZ);
      AppMethodBeat.o(169037);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.topics.clear();
        this.SRD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169037);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bhb localbhb = (bhb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 19: 
        default: 
          AppMethodBeat.o(169037);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbhb.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 2: 
          localbhb.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObjectDesc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObjectDesc)localObject2).parseFrom((byte[])localObject1);
            }
            localbhb.SRA = ((FinderObjectDesc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 4: 
          localbhb.clientId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 5: 
          localbhb.SRB = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169037);
          return 0;
        case 6: 
          localbhb.refObjectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbhb.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 8: 
          localbhb.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169037);
          return 0;
        case 9: 
          localbhb.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169037);
          return 0;
        case 10: 
          localbhb.SRx = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169037);
          return 0;
        case 11: 
          localbhb.SRy = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(169037);
          return 0;
        case 12: 
          localbhb.SRz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169037);
          return 0;
        case 13: 
          localbhb.topics.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(169037);
          return 0;
        case 14: 
          localbhb.originalFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169037);
          return 0;
        case 15: 
          localbhb.SRC = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169037);
          return 0;
        case 16: 
          localbhb.SRD.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(169037);
          return 0;
        case 17: 
          localbhb.SRE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169037);
          return 0;
        case 18: 
          localbhb.groupId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apx)localObject2).parseFrom((byte[])localObject1);
            }
            localbhb.attachmentList = ((apx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169037);
          return 0;
        case 21: 
          localbhb.SRF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169037);
          return 0;
        case 22: 
          localbhb.SRG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169037);
          return 0;
        case 23: 
          localbhb.SRv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169037);
          return 0;
        case 24: 
          localbhb.xdR = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169037);
          return 0;
        }
        localbhb.SFZ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169037);
        return 0;
      }
      AppMethodBeat.o(169037);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhb
 * JD-Core Version:    0.7.0.1
 */