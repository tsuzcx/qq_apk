package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drp
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public fmp aaXk;
  public LinkedList<esr> aaXl;
  public int type;
  
  public drp()
  {
    AppMethodBeat.i(91548);
    this.aaXl = new LinkedList();
    AppMethodBeat.o(91548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91549);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXk != null)
      {
        paramVarArgs.qD(1, this.aaXk.computeSize());
        this.aaXk.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aaXl);
      paramVarArgs.bS(3, this.type);
      if (this.YMe != null) {
        paramVarArgs.g(4, this.YMe);
      }
      AppMethodBeat.o(91549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXk == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.a.qC(1, this.aaXk.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaXl) + i.a.a.b.b.a.cJ(3, this.type);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YMe);
      }
      AppMethodBeat.o(91549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaXl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        drp localdrp = (drp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91549);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localdrp.aaXk = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esr)localObject2).parseFrom((byte[])localObject1);
            }
            localdrp.aaXl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91549);
          return 0;
        case 3: 
          localdrp.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91549);
          return 0;
        }
        localdrp.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91549);
        return 0;
      }
      AppMethodBeat.o(91549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drp
 * JD-Core Version:    0.7.0.1
 */