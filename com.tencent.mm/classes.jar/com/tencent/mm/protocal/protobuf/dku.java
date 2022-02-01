package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dku
  extends com.tencent.mm.cd.a
{
  public erh RGf;
  public erh RGg;
  public LinkedList<us> SIf;
  public clc TRZ;
  public dcd TSa;
  
  public dku()
  {
    AppMethodBeat.i(91613);
    this.SIf = new LinkedList();
    AppMethodBeat.o(91613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91614);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TRZ != null)
      {
        paramVarArgs.oE(1, this.TRZ.computeSize());
        this.TRZ.writeFields(paramVarArgs);
      }
      if (this.RGf != null)
      {
        paramVarArgs.oE(2, this.RGf.computeSize());
        this.RGf.writeFields(paramVarArgs);
      }
      if (this.RGg != null)
      {
        paramVarArgs.oE(3, this.RGg.computeSize());
        this.RGg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.SIf);
      if (this.TSa != null)
      {
        paramVarArgs.oE(5, this.TSa.computeSize());
        this.TSa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TRZ == null) {
        break label804;
      }
    }
    label804:
    for (int i = g.a.a.a.oD(1, this.TRZ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RGf != null) {
        paramInt = i + g.a.a.a.oD(2, this.RGf.computeSize());
      }
      i = paramInt;
      if (this.RGg != null) {
        i = paramInt + g.a.a.a.oD(3, this.RGg.computeSize());
      }
      i += g.a.a.a.c(4, 8, this.SIf);
      paramInt = i;
      if (this.TSa != null) {
        paramInt = i + g.a.a.a.oD(5, this.TSa.computeSize());
      }
      AppMethodBeat.o(91614);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SIf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dku localdku = (dku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91614);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clc)localObject2).parseFrom((byte[])localObject1);
            }
            localdku.TRZ = ((clc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localdku.RGf = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localdku.RGg = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new us();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((us)localObject2).parseFrom((byte[])localObject1);
            }
            localdku.SIf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91614);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcd)localObject2).parseFrom((byte[])localObject1);
          }
          localdku.TSa = ((dcd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91614);
        return 0;
      }
      AppMethodBeat.o(91614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dku
 * JD-Core Version:    0.7.0.1
 */