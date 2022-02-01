package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgh
  extends com.tencent.mm.cd.a
{
  public fgd UGB;
  public fft UGC;
  public String UGD;
  public String UGE;
  public String UGF;
  public int UGG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UGB != null)
      {
        paramVarArgs.oE(1, this.UGB.computeSize());
        this.UGB.writeFields(paramVarArgs);
      }
      if (this.UGC != null)
      {
        paramVarArgs.oE(2, this.UGC.computeSize());
        this.UGC.writeFields(paramVarArgs);
      }
      if (this.UGD != null) {
        paramVarArgs.f(3, this.UGD);
      }
      if (this.UGE != null) {
        paramVarArgs.f(4, this.UGE);
      }
      if (this.UGF != null) {
        paramVarArgs.f(5, this.UGF);
      }
      paramVarArgs.aY(6, this.UGG);
      AppMethodBeat.o(147809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UGB == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.a.oD(1, this.UGB.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UGC != null) {
        paramInt = i + g.a.a.a.oD(2, this.UGC.computeSize());
      }
      i = paramInt;
      if (this.UGD != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UGD);
      }
      paramInt = i;
      if (this.UGE != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UGE);
      }
      i = paramInt;
      if (this.UGF != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UGF);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.UGG);
      AppMethodBeat.o(147809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(147809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fgh localfgh = (fgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147809);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fgd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fgd)localObject2).parseFrom((byte[])localObject1);
            }
            localfgh.UGB = ((fgd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fft();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fft)localObject2).parseFrom((byte[])localObject1);
            }
            localfgh.UGC = ((fft)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 3: 
          localfgh.UGD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 4: 
          localfgh.UGE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 5: 
          localfgh.UGF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(147809);
          return 0;
        }
        localfgh.UGG = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(147809);
        return 0;
      }
      AppMethodBeat.o(147809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgh
 * JD-Core Version:    0.7.0.1
 */