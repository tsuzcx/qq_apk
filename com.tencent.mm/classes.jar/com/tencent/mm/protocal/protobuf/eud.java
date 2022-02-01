package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class eud
  extends com.tencent.mm.bw.a
{
  public int GWf;
  public LinkedList<Integer> NrA;
  public int NrB;
  public LinkedList<Integer> NrC;
  public dmm NrD;
  public dmm Nrx;
  public ahk Nry;
  public int Nrz;
  
  public eud()
  {
    AppMethodBeat.i(115897);
    this.NrA = new LinkedList();
    this.NrC = new LinkedList();
    AppMethodBeat.o(115897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115898);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nrx != null)
      {
        paramVarArgs.ni(1, this.Nrx.computeSize());
        this.Nrx.writeFields(paramVarArgs);
      }
      if (this.Nry != null)
      {
        paramVarArgs.ni(2, this.Nry.computeSize());
        this.Nry.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Nrz);
      paramVarArgs.f(4, 2, this.NrA);
      paramVarArgs.aM(5, this.NrB);
      paramVarArgs.f(6, 2, this.NrC);
      paramVarArgs.aM(7, this.GWf);
      if (this.NrD != null)
      {
        paramVarArgs.ni(8, this.NrD.computeSize());
        this.NrD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nrx == null) {
        break label896;
      }
    }
    label896:
    for (paramInt = g.a.a.a.nh(1, this.Nrx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nry != null) {
        i = paramInt + g.a.a.a.nh(2, this.Nry.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.Nrz) + g.a.a.a.d(4, 2, this.NrA) + g.a.a.b.b.a.bu(5, this.NrB) + g.a.a.a.d(6, 2, this.NrC) + g.a.a.b.b.a.bu(7, this.GWf);
      paramInt = i;
      if (this.NrD != null) {
        paramInt = i + g.a.a.a.nh(8, this.NrD.computeSize());
      }
      AppMethodBeat.o(115898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NrA.clear();
        this.NrC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eud localeud = (eud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115898);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeud.Nrx = ((dmm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeud.Nry = ((ahk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 3: 
          localeud.Nrz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115898);
          return 0;
        case 4: 
          localeud.NrA = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(115898);
          return 0;
        case 5: 
          localeud.NrB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115898);
          return 0;
        case 6: 
          localeud.NrC = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(115898);
          return 0;
        case 7: 
          localeud.GWf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115898);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeud.NrD = ((dmm)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eud
 * JD-Core Version:    0.7.0.1
 */