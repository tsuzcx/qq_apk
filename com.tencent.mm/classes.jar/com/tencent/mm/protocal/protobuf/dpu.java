package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dpu
  extends com.tencent.mm.bx.a
{
  public int DeleteFlag;
  public etl ZqL;
  public int aaWv;
  public int aaWw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32351);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32351);
        throw paramVarArgs;
      }
      if (this.ZqL != null)
      {
        paramVarArgs.qD(1, this.ZqL.computeSize());
        this.ZqL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaWv);
      paramVarArgs.bS(3, this.aaWw);
      paramVarArgs.bS(4, this.DeleteFlag);
      AppMethodBeat.o(32351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqL == null) {
        break label482;
      }
    }
    label482:
    for (paramInt = i.a.a.a.qC(1, this.ZqL.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaWv);
      int j = i.a.a.b.b.a.cJ(3, this.aaWw);
      int k = i.a.a.b.b.a.cJ(4, this.DeleteFlag);
      AppMethodBeat.o(32351);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZqL == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32351);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dpu localdpu = (dpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32351);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            etl localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localdpu.ZqL = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(32351);
          return 0;
        case 2: 
          localdpu.aaWv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32351);
          return 0;
        case 3: 
          localdpu.aaWw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32351);
          return 0;
        }
        localdpu.DeleteFlag = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32351);
        return 0;
      }
      AppMethodBeat.o(32351);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpu
 * JD-Core Version:    0.7.0.1
 */