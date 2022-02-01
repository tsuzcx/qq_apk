package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsa
  extends com.tencent.mm.bw.a
{
  public String KCM;
  public int MUE;
  public String MUF;
  public String MUG;
  public int MUH;
  public String Title;
  public String oUJ;
  public LinkedList<dsb> xuZ;
  
  public dsa()
  {
    AppMethodBeat.i(187881);
    this.xuZ = new LinkedList();
    AppMethodBeat.o(187881);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187882);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.KCM != null) {
        paramVarArgs.e(2, this.KCM);
      }
      paramVarArgs.aM(3, this.MUE);
      if (this.oUJ != null) {
        paramVarArgs.e(4, this.oUJ);
      }
      if (this.MUF != null) {
        paramVarArgs.e(5, this.MUF);
      }
      if (this.MUG != null) {
        paramVarArgs.e(6, this.MUG);
      }
      paramVarArgs.aM(7, this.MUH);
      paramVarArgs.e(8, 8, this.xuZ);
      AppMethodBeat.o(187882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KCM != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KCM);
      }
      i += g.a.a.b.b.a.bu(3, this.MUE);
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oUJ);
      }
      i = paramInt;
      if (this.MUF != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MUF);
      }
      paramInt = i;
      if (this.MUG != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MUG);
      }
      i = g.a.a.b.b.a.bu(7, this.MUH);
      int j = g.a.a.a.c(8, 8, this.xuZ);
      AppMethodBeat.o(187882);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187882);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsa localdsa = (dsa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187882);
          return -1;
        case 1: 
          localdsa.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(187882);
          return 0;
        case 2: 
          localdsa.KCM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(187882);
          return 0;
        case 3: 
          localdsa.MUE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(187882);
          return 0;
        case 4: 
          localdsa.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(187882);
          return 0;
        case 5: 
          localdsa.MUF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(187882);
          return 0;
        case 6: 
          localdsa.MUG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(187882);
          return 0;
        case 7: 
          localdsa.MUH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(187882);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dsb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dsb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdsa.xuZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(187882);
        return 0;
      }
      AppMethodBeat.o(187882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsa
 * JD-Core Version:    0.7.0.1
 */