package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zn
  extends dyl
{
  public String SlM;
  public LinkedList<ehn> SlN;
  public LinkedList<ehp> SlO;
  public LinkedList<ehm> SlP;
  public LinkedList<ehl> SlQ;
  public LinkedList<eho> SlR;
  public int rWu;
  
  public zn()
  {
    AppMethodBeat.i(32163);
    this.SlN = new LinkedList();
    this.SlO = new LinkedList();
    this.SlP = new LinkedList();
    this.SlQ = new LinkedList();
    this.SlR = new LinkedList();
    AppMethodBeat.o(32163);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32164);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWu);
      if (this.SlM != null) {
        paramVarArgs.f(3, this.SlM);
      }
      paramVarArgs.e(4, 8, this.SlN);
      paramVarArgs.e(5, 8, this.SlO);
      paramVarArgs.e(6, 8, this.SlP);
      paramVarArgs.e(7, 8, this.SlQ);
      paramVarArgs.e(8, 8, this.SlR);
      AppMethodBeat.o(32164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1008;
      }
    }
    label1008:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu);
      paramInt = i;
      if (this.SlM != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SlM);
      }
      i = g.a.a.a.c(4, 8, this.SlN);
      int j = g.a.a.a.c(5, 8, this.SlO);
      int k = g.a.a.a.c(6, 8, this.SlP);
      int m = g.a.a.a.c(7, 8, this.SlQ);
      int n = g.a.a.a.c(8, 8, this.SlR);
      AppMethodBeat.o(32164);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SlN.clear();
        this.SlO.clear();
        this.SlP.clear();
        this.SlQ.clear();
        this.SlR.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zn localzn = (zn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32164);
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
            localzn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 2: 
          localzn.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32164);
          return 0;
        case 3: 
          localzn.SlM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32164);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehn)localObject2).parseFrom((byte[])localObject1);
            }
            localzn.SlN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehp)localObject2).parseFrom((byte[])localObject1);
            }
            localzn.SlO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehm)localObject2).parseFrom((byte[])localObject1);
            }
            localzn.SlP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehl)localObject2).parseFrom((byte[])localObject1);
            }
            localzn.SlQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eho();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eho)localObject2).parseFrom((byte[])localObject1);
          }
          localzn.SlR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      AppMethodBeat.o(32164);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zn
 * JD-Core Version:    0.7.0.1
 */