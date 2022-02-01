package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class feo
  extends com.tencent.mm.cd.a
{
  public int NMs;
  public dwd UEA;
  public dwd UEu;
  public ahv UEv;
  public int UEw;
  public LinkedList<Integer> UEx;
  public int UEy;
  public LinkedList<Integer> UEz;
  
  public feo()
  {
    AppMethodBeat.i(115897);
    this.UEx = new LinkedList();
    this.UEz = new LinkedList();
    AppMethodBeat.o(115897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115898);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UEu != null)
      {
        paramVarArgs.oE(1, this.UEu.computeSize());
        this.UEu.writeFields(paramVarArgs);
      }
      if (this.UEv != null)
      {
        paramVarArgs.oE(2, this.UEv.computeSize());
        this.UEv.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.UEw);
      paramVarArgs.f(4, 2, this.UEx);
      paramVarArgs.aY(5, this.UEy);
      paramVarArgs.f(6, 2, this.UEz);
      paramVarArgs.aY(7, this.NMs);
      if (this.UEA != null)
      {
        paramVarArgs.oE(8, this.UEA.computeSize());
        this.UEA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UEu == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = g.a.a.a.oD(1, this.UEu.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UEv != null) {
        i = paramInt + g.a.a.a.oD(2, this.UEv.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.UEw) + g.a.a.a.d(4, 2, this.UEx) + g.a.a.b.b.a.bM(5, this.UEy) + g.a.a.a.d(6, 2, this.UEz) + g.a.a.b.b.a.bM(7, this.NMs);
      paramInt = i;
      if (this.UEA != null) {
        paramInt = i + g.a.a.a.oD(8, this.UEA.computeSize());
      }
      AppMethodBeat.o(115898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UEx.clear();
        this.UEz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        feo localfeo = (feo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115898);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwd)localObject2).parseFrom((byte[])localObject1);
            }
            localfeo.UEu = ((dwd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahv)localObject2).parseFrom((byte[])localObject1);
            }
            localfeo.UEv = ((ahv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 3: 
          localfeo.UEw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115898);
          return 0;
        case 4: 
          localfeo.UEx = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(115898);
          return 0;
        case 5: 
          localfeo.UEy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115898);
          return 0;
        case 6: 
          localfeo.UEz = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(115898);
          return 0;
        case 7: 
          localfeo.NMs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115898);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dwd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dwd)localObject2).parseFrom((byte[])localObject1);
          }
          localfeo.UEA = ((dwd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      AppMethodBeat.o(115898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feo
 * JD-Core Version:    0.7.0.1
 */