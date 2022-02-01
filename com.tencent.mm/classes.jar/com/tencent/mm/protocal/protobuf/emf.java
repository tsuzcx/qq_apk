package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emf
  extends com.tencent.mm.bx.a
{
  public ahi abqC;
  public boolean abqD;
  public boolean abqE;
  public boolean abqF;
  public boolean abqG;
  public boolean abqH;
  public boolean abqI;
  public boolean abqJ;
  public boolean abqK;
  public boolean abqL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91659);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abqC != null)
      {
        paramVarArgs.qD(1, this.abqC.computeSize());
        this.abqC.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.abqD);
      paramVarArgs.di(3, this.abqE);
      paramVarArgs.di(4, this.abqF);
      paramVarArgs.di(5, this.abqG);
      paramVarArgs.di(6, this.abqH);
      paramVarArgs.di(7, this.abqI);
      paramVarArgs.di(8, this.abqJ);
      paramVarArgs.di(9, this.abqK);
      paramVarArgs.di(10, this.abqL);
      AppMethodBeat.o(91659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abqC == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = i.a.a.a.qC(1, this.abqC.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      int i1 = i.a.a.b.b.a.ko(7);
      int i2 = i.a.a.b.b.a.ko(8);
      int i3 = i.a.a.b.b.a.ko(9);
      int i4 = i.a.a.b.b.a.ko(10);
      AppMethodBeat.o(91659);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1) + (i3 + 1) + (i4 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        emf localemf = (emf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91659);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ahi localahi = new ahi();
            if ((localObject != null) && (localObject.length > 0)) {
              localahi.parseFrom((byte[])localObject);
            }
            localemf.abqC = localahi;
            paramInt += 1;
          }
          AppMethodBeat.o(91659);
          return 0;
        case 2: 
          localemf.abqD = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        case 3: 
          localemf.abqE = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        case 4: 
          localemf.abqF = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        case 5: 
          localemf.abqG = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        case 6: 
          localemf.abqH = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        case 7: 
          localemf.abqI = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        case 8: 
          localemf.abqJ = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        case 9: 
          localemf.abqK = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91659);
          return 0;
        }
        localemf.abqL = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(91659);
        return 0;
      }
      AppMethodBeat.o(91659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emf
 * JD-Core Version:    0.7.0.1
 */