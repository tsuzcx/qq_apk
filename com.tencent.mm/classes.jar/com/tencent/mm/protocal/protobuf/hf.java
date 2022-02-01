package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hf
  extends com.tencent.mm.cd.a
{
  public String RMA;
  public ebb RMB;
  public hm RMC;
  public he RMw;
  public bpi RMx;
  public String RMy;
  public String RMz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RMw != null)
      {
        paramVarArgs.oE(1, this.RMw.computeSize());
        this.RMw.writeFields(paramVarArgs);
      }
      if (this.RMx != null)
      {
        paramVarArgs.oE(2, this.RMx.computeSize());
        this.RMx.writeFields(paramVarArgs);
      }
      if (this.RMy != null) {
        paramVarArgs.f(3, this.RMy);
      }
      if (this.RMz != null) {
        paramVarArgs.f(4, this.RMz);
      }
      if (this.RMA != null) {
        paramVarArgs.f(5, this.RMA);
      }
      if (this.RMB != null)
      {
        paramVarArgs.oE(6, this.RMB.computeSize());
        this.RMB.writeFields(paramVarArgs);
      }
      if (this.RMC != null)
      {
        paramVarArgs.oE(7, this.RMC.computeSize());
        this.RMC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RMw == null) {
        break label870;
      }
    }
    label870:
    for (int i = g.a.a.a.oD(1, this.RMw.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RMx != null) {
        paramInt = i + g.a.a.a.oD(2, this.RMx.computeSize());
      }
      i = paramInt;
      if (this.RMy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RMy);
      }
      paramInt = i;
      if (this.RMz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RMz);
      }
      i = paramInt;
      if (this.RMA != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RMA);
      }
      paramInt = i;
      if (this.RMB != null) {
        paramInt = i + g.a.a.a.oD(6, this.RMB.computeSize());
      }
      i = paramInt;
      if (this.RMC != null) {
        i = paramInt + g.a.a.a.oD(7, this.RMC.computeSize());
      }
      AppMethodBeat.o(123544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hf localhf = (hf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123544);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new he();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((he)localObject2).parseFrom((byte[])localObject1);
            }
            localhf.RMw = ((he)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpi)localObject2).parseFrom((byte[])localObject1);
            }
            localhf.RMx = ((bpi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 3: 
          localhf.RMy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 4: 
          localhf.RMz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 5: 
          localhf.RMA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebb)localObject2).parseFrom((byte[])localObject1);
            }
            localhf.RMB = ((ebb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((hm)localObject2).parseFrom((byte[])localObject1);
          }
          localhf.RMC = ((hm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      AppMethodBeat.o(123544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hf
 * JD-Core Version:    0.7.0.1
 */