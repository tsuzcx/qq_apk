package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bjw
  extends dyy
{
  public com.tencent.mm.cd.b SGh;
  public bbl SHr;
  public String SUH;
  public String SUI;
  public int SUJ;
  public int SUK;
  public int SUL;
  public arh SUM;
  public int SUN;
  public bks SUO;
  public aqk SUP;
  public String SUQ;
  public bju SUR;
  public String Sns;
  public com.tencent.mm.cd.b lastBuffer;
  public LinkedList<FinderObject> liveObjects;
  public LinkedList<FinderObject> object;
  public bhh preloadInfo;
  public int xFH;
  public bjt xFN;
  public biv xcZ;
  
  public bjw()
  {
    AppMethodBeat.i(169057);
    this.object = new LinkedList();
    this.liveObjects = new LinkedList();
    AppMethodBeat.o(169057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169058);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(169058);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.SUH != null) {
        paramVarArgs.f(4, this.SUH);
      }
      if (this.SUI != null) {
        paramVarArgs.f(5, this.SUI);
      }
      paramVarArgs.aY(6, this.xFH);
      paramVarArgs.aY(7, this.SUJ);
      paramVarArgs.aY(8, this.SUK);
      paramVarArgs.aY(9, this.SUL);
      if (this.preloadInfo != null)
      {
        paramVarArgs.oE(10, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.SUM != null)
      {
        paramVarArgs.oE(11, this.SUM.computeSize());
        this.SUM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(12, this.SUN);
      paramVarArgs.e(13, 8, this.liveObjects);
      if (this.SUO != null)
      {
        paramVarArgs.oE(14, this.SUO.computeSize());
        this.SUO.writeFields(paramVarArgs);
      }
      if (this.SUP != null)
      {
        paramVarArgs.oE(15, this.SUP.computeSize());
        this.SUP.writeFields(paramVarArgs);
      }
      if (this.SUQ != null) {
        paramVarArgs.f(16, this.SUQ);
      }
      if (this.xcZ != null)
      {
        paramVarArgs.oE(17, this.xcZ.computeSize());
        this.xcZ.writeFields(paramVarArgs);
      }
      if (this.SUR != null)
      {
        paramVarArgs.oE(18, this.SUR.computeSize());
        this.SUR.writeFields(paramVarArgs);
      }
      if (this.xFN != null)
      {
        paramVarArgs.oE(19, this.xFN.computeSize());
        this.xFN.writeFields(paramVarArgs);
      }
      if (this.Sns != null) {
        paramVarArgs.f(20, this.Sns);
      }
      if (this.SHr != null)
      {
        paramVarArgs.oE(21, this.SHr.computeSize());
        this.SHr.writeFields(paramVarArgs);
      }
      if (this.SGh != null) {
        paramVarArgs.c(22, this.SGh);
      }
      AppMethodBeat.o(169058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2236;
      }
    }
    label2236:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.SUH != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SUH);
      }
      paramInt = i;
      if (this.SUI != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SUI);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.xFH) + g.a.a.b.b.a.bM(7, this.SUJ) + g.a.a.b.b.a.bM(8, this.SUK) + g.a.a.b.b.a.bM(9, this.SUL);
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + g.a.a.a.oD(10, this.preloadInfo.computeSize());
      }
      i = paramInt;
      if (this.SUM != null) {
        i = paramInt + g.a.a.a.oD(11, this.SUM.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(12, this.SUN) + g.a.a.a.c(13, 8, this.liveObjects);
      paramInt = i;
      if (this.SUO != null) {
        paramInt = i + g.a.a.a.oD(14, this.SUO.computeSize());
      }
      i = paramInt;
      if (this.SUP != null) {
        i = paramInt + g.a.a.a.oD(15, this.SUP.computeSize());
      }
      paramInt = i;
      if (this.SUQ != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.SUQ);
      }
      i = paramInt;
      if (this.xcZ != null) {
        i = paramInt + g.a.a.a.oD(17, this.xcZ.computeSize());
      }
      paramInt = i;
      if (this.SUR != null) {
        paramInt = i + g.a.a.a.oD(18, this.SUR.computeSize());
      }
      i = paramInt;
      if (this.xFN != null) {
        i = paramInt + g.a.a.a.oD(19, this.xFN.computeSize());
      }
      paramInt = i;
      if (this.Sns != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.Sns);
      }
      i = paramInt;
      if (this.SHr != null) {
        i = paramInt + g.a.a.a.oD(21, this.SHr.computeSize());
      }
      paramInt = i;
      if (this.SGh != null) {
        paramInt = i + g.a.a.b.b.a.b(22, this.SGh);
      }
      AppMethodBeat.o(169058);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.liveObjects.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(169058);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjw localbjw = (bjw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169058);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 3: 
          localbjw.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169058);
          return 0;
        case 4: 
          localbjw.SUH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 5: 
          localbjw.SUI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 6: 
          localbjw.xFH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169058);
          return 0;
        case 7: 
          localbjw.SUJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169058);
          return 0;
        case 8: 
          localbjw.SUK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169058);
          return 0;
        case 9: 
          localbjw.SUL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169058);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bhh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bhh)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.preloadInfo = ((bhh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arh)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.SUM = ((arh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 12: 
          localbjw.SUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169058);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.liveObjects.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bks();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bks)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.SUO = ((bks)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqk)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.SUP = ((aqk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 16: 
          localbjw.SUQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new biv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((biv)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.xcZ = ((biv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bju();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bju)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.SUR = ((bju)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjt)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.xFN = ((bjt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        case 20: 
          localbjw.Sns = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169058);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bbl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bbl)localObject2).parseFrom((byte[])localObject1);
            }
            localbjw.SHr = ((bbl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169058);
          return 0;
        }
        localbjw.SGh = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(169058);
        return 0;
      }
      AppMethodBeat.o(169058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjw
 * JD-Core Version:    0.7.0.1
 */