package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class avs
  extends dyy
{
  public String SDh;
  public bbl SHr;
  public LinkedList<bjp> SIf;
  public LinkedList<bjy> SIg;
  public bjt SIh;
  public aqc SIi;
  public int continueFlag;
  public b lastBuffer;
  public LinkedList<FinderObject> object;
  public bhh preloadInfo;
  public b xff;
  
  public avs()
  {
    AppMethodBeat.i(198241);
    this.object = new LinkedList();
    this.SIf = new LinkedList();
    this.SIg = new LinkedList();
    AppMethodBeat.o(198241);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198265);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.continueFlag);
      if (this.xff != null) {
        paramVarArgs.c(5, this.xff);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.oE(6, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.SDh != null) {
        paramVarArgs.f(7, this.SDh);
      }
      paramVarArgs.e(8, 8, this.SIf);
      paramVarArgs.e(9, 8, this.SIg);
      if (this.SHr != null)
      {
        paramVarArgs.oE(10, this.SHr.computeSize());
        this.SHr.writeFields(paramVarArgs);
      }
      if (this.SIh != null)
      {
        paramVarArgs.oE(11, this.SIh.computeSize());
        this.SIh.writeFields(paramVarArgs);
      }
      if (this.SIi != null)
      {
        paramVarArgs.oE(12, this.SIi.computeSize());
        this.SIi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(198265);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1406;
      }
    }
    label1406:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.continueFlag);
      paramInt = i;
      if (this.xff != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.xff);
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + g.a.a.a.oD(6, this.preloadInfo.computeSize());
      }
      paramInt = i;
      if (this.SDh != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SDh);
      }
      i = paramInt + g.a.a.a.c(8, 8, this.SIf) + g.a.a.a.c(9, 8, this.SIg);
      paramInt = i;
      if (this.SHr != null) {
        paramInt = i + g.a.a.a.oD(10, this.SHr.computeSize());
      }
      i = paramInt;
      if (this.SIh != null) {
        i = paramInt + g.a.a.a.oD(11, this.SIh.computeSize());
      }
      paramInt = i;
      if (this.SIi != null) {
        paramInt = i + g.a.a.a.oD(12, this.SIi.computeSize());
      }
      AppMethodBeat.o(198265);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.SIf.clear();
        this.SIg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198265);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avs localavs = (avs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198265);
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
            localavs.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198265);
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
            localavs.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198265);
          return 0;
        case 3: 
          localavs.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(198265);
          return 0;
        case 4: 
          localavs.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(198265);
          return 0;
        case 5: 
          localavs.xff = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(198265);
          return 0;
        case 6: 
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
            localavs.preloadInfo = ((bhh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198265);
          return 0;
        case 7: 
          localavs.SDh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(198265);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjp)localObject2).parseFrom((byte[])localObject1);
            }
            localavs.SIf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198265);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjy)localObject2).parseFrom((byte[])localObject1);
            }
            localavs.SIg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198265);
          return 0;
        case 10: 
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
            localavs.SHr = ((bbl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198265);
          return 0;
        case 11: 
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
            localavs.SIh = ((bjt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198265);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aqc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aqc)localObject2).parseFrom((byte[])localObject1);
          }
          localavs.SIi = ((aqc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198265);
        return 0;
      }
      AppMethodBeat.o(198265);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avs
 * JD-Core Version:    0.7.0.1
 */