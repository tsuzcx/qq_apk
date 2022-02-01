package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcl
  extends com.tencent.mm.bw.a
{
  public LinkedList<ehi> MGX;
  public String MHB;
  public String MHC;
  public LinkedList<Integer> MHD;
  public LinkedList<Integer> MHE;
  public String MHF;
  public boolean MHG;
  
  public dcl()
  {
    AppMethodBeat.i(209787);
    this.MGX = new LinkedList();
    this.MHD = new LinkedList();
    this.MHE = new LinkedList();
    AppMethodBeat.o(209787);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209788);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MHB != null) {
        paramVarArgs.e(1, this.MHB);
      }
      if (this.MHC != null) {
        paramVarArgs.e(2, this.MHC);
      }
      paramVarArgs.e(3, 8, this.MGX);
      paramVarArgs.e(4, 2, this.MHD);
      paramVarArgs.e(5, 2, this.MHE);
      if (this.MHF != null) {
        paramVarArgs.e(6, this.MHF);
      }
      paramVarArgs.cc(7, this.MHG);
      AppMethodBeat.o(209788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MHB == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = g.a.a.b.b.a.f(1, this.MHB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MHC != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MHC);
      }
      i = i + g.a.a.a.c(3, 8, this.MGX) + g.a.a.a.c(4, 2, this.MHD) + g.a.a.a.c(5, 2, this.MHE);
      paramInt = i;
      if (this.MHF != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MHF);
      }
      i = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(209788);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MGX.clear();
        this.MHD.clear();
        this.MHE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcl localdcl = (dcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209788);
          return -1;
        case 1: 
          localdcl.MHB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209788);
          return 0;
        case 2: 
          localdcl.MHC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209788);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ehi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdcl.MGX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209788);
          return 0;
        case 4: 
          localdcl.MHD.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(209788);
          return 0;
        case 5: 
          localdcl.MHE.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(209788);
          return 0;
        case 6: 
          localdcl.MHF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209788);
          return 0;
        }
        localdcl.MHG = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(209788);
        return 0;
      }
      AppMethodBeat.o(209788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcl
 * JD-Core Version:    0.7.0.1
 */