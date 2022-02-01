package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbs
  extends com.tencent.mm.bx.a
{
  public dbz aaHe;
  public long aaHf;
  public long aaHg;
  public long aaHh;
  public int aaHi;
  public dca aaHj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaHe != null)
      {
        paramVarArgs.qD(1, this.aaHe.computeSize());
        this.aaHe.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaHf);
      paramVarArgs.bv(3, this.aaHg);
      paramVarArgs.bv(4, this.aaHh);
      paramVarArgs.bS(5, this.aaHi);
      if (this.aaHj != null)
      {
        paramVarArgs.qD(6, this.aaHj.computeSize());
        this.aaHj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaHe == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = i.a.a.a.qC(1, this.aaHe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaHf) + i.a.a.b.b.a.q(3, this.aaHg) + i.a.a.b.b.a.q(4, this.aaHh) + i.a.a.b.b.a.cJ(5, this.aaHi);
      paramInt = i;
      if (this.aaHj != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaHj.computeSize());
      }
      AppMethodBeat.o(259455);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dbs localdbs = (dbs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259455);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbz)localObject2).parseFrom((byte[])localObject1);
            }
            localdbs.aaHe = ((dbz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259455);
          return 0;
        case 2: 
          localdbs.aaHf = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259455);
          return 0;
        case 3: 
          localdbs.aaHg = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259455);
          return 0;
        case 4: 
          localdbs.aaHh = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259455);
          return 0;
        case 5: 
          localdbs.aaHi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259455);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dca();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dca)localObject2).parseFrom((byte[])localObject1);
          }
          localdbs.aaHj = ((dca)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259455);
        return 0;
      }
      AppMethodBeat.o(259455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbs
 * JD-Core Version:    0.7.0.1
 */