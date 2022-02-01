package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcf
  extends dyl
{
  public long SoR;
  public String UBS;
  public String UBT;
  public LinkedList<fcn> UCh;
  public fcn UCi;
  public LinkedList<fch> UCj;
  
  public fcf()
  {
    AppMethodBeat.i(198029);
    this.UCj = new LinkedList();
    this.UCh = new LinkedList();
    AppMethodBeat.o(198029);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198063);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UBS != null) {
        paramVarArgs.f(2, this.UBS);
      }
      if (this.UCi != null)
      {
        paramVarArgs.oE(3, this.UCi.computeSize());
        this.UCi.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(4, this.SoR);
      if (this.UBT != null) {
        paramVarArgs.f(5, this.UBT);
      }
      paramVarArgs.e(6, 8, this.UCj);
      paramVarArgs.e(7, 8, this.UCh);
      AppMethodBeat.o(198063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UBS != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UBS);
      }
      i = paramInt;
      if (this.UCi != null) {
        i = paramInt + g.a.a.a.oD(3, this.UCi.computeSize());
      }
      i += g.a.a.b.b.a.p(4, this.SoR);
      paramInt = i;
      if (this.UBT != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UBT);
      }
      i = g.a.a.a.c(6, 8, this.UCj);
      int j = g.a.a.a.c(7, 8, this.UCh);
      AppMethodBeat.o(198063);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCj.clear();
        this.UCh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcf localfcf = (fcf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198063);
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
            localfcf.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198063);
          return 0;
        case 2: 
          localfcf.UBS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(198063);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcn)localObject2).parseFrom((byte[])localObject1);
            }
            localfcf.UCi = ((fcn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198063);
          return 0;
        case 4: 
          localfcf.SoR = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(198063);
          return 0;
        case 5: 
          localfcf.UBT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(198063);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fch();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fch)localObject2).parseFrom((byte[])localObject1);
            }
            localfcf.UCj.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(198063);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fcn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fcn)localObject2).parseFrom((byte[])localObject1);
          }
          localfcf.UCh.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198063);
        return 0;
      }
      AppMethodBeat.o(198063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcf
 * JD-Core Version:    0.7.0.1
 */