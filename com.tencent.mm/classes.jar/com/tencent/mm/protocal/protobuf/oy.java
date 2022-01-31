package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oy
  extends com.tencent.mm.bv.a
{
  public String wFE;
  public String wFF;
  public String wFG;
  public int wFH;
  public String wFI;
  public ou wFJ;
  public String wFK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89038);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wFE != null) {
        paramVarArgs.e(1, this.wFE);
      }
      if (this.wFF != null) {
        paramVarArgs.e(2, this.wFF);
      }
      if (this.wFG != null) {
        paramVarArgs.e(3, this.wFG);
      }
      paramVarArgs.aO(4, this.wFH);
      if (this.wFI != null) {
        paramVarArgs.e(5, this.wFI);
      }
      if (this.wFJ != null)
      {
        paramVarArgs.iQ(6, this.wFJ.computeSize());
        this.wFJ.writeFields(paramVarArgs);
      }
      if (this.wFK != null) {
        paramVarArgs.e(7, this.wFK);
      }
      AppMethodBeat.o(89038);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wFE == null) {
        break label658;
      }
    }
    label658:
    for (int i = e.a.a.b.b.a.f(1, this.wFE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wFF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wFF);
      }
      i = paramInt;
      if (this.wFG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wFG);
      }
      i += e.a.a.b.b.a.bl(4, this.wFH);
      paramInt = i;
      if (this.wFI != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wFI);
      }
      i = paramInt;
      if (this.wFJ != null) {
        i = paramInt + e.a.a.a.iP(6, this.wFJ.computeSize());
      }
      paramInt = i;
      if (this.wFK != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wFK);
      }
      AppMethodBeat.o(89038);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89038);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        oy localoy = (oy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89038);
          return -1;
        case 1: 
          localoy.wFE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89038);
          return 0;
        case 2: 
          localoy.wFF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89038);
          return 0;
        case 3: 
          localoy.wFG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89038);
          return 0;
        case 4: 
          localoy.wFH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89038);
          return 0;
        case 5: 
          localoy.wFI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89038);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ou();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localoy.wFJ = ((ou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89038);
          return 0;
        }
        localoy.wFK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89038);
        return 0;
      }
      AppMethodBeat.o(89038);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oy
 * JD-Core Version:    0.7.0.1
 */