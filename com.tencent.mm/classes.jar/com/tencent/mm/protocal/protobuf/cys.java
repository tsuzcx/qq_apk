package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cys
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b aaDu;
  public int aaDv;
  public LinkedList<cyu> aaDw;
  public LinkedList<Integer> aaDx;
  
  public cys()
  {
    AppMethodBeat.i(115842);
    this.aaDw = new LinkedList();
    this.aaDx = new LinkedList();
    AppMethodBeat.o(115842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115843);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaDu == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(115843);
        throw paramVarArgs;
      }
      if (this.aaDu != null) {
        paramVarArgs.d(1, this.aaDu);
      }
      paramVarArgs.bS(2, this.aaDv);
      paramVarArgs.e(3, 8, this.aaDw);
      paramVarArgs.e(4, 2, this.aaDx);
      AppMethodBeat.o(115843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaDu == null) {
        break label487;
      }
    }
    label487:
    for (paramInt = i.a.a.b.b.a.c(1, this.aaDu) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaDv);
      int j = i.a.a.a.c(3, 8, this.aaDw);
      int k = i.a.a.a.c(4, 2, this.aaDx);
      AppMethodBeat.o(115843);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaDw.clear();
        this.aaDx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaDu == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: RawBuf");
          AppMethodBeat.o(115843);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cys localcys = (cys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115843);
          return -1;
        case 1: 
          localcys.aaDu = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(115843);
          return 0;
        case 2: 
          localcys.aaDv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(115843);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cyu localcyu = new cyu();
            if ((localObject != null) && (localObject.length > 0)) {
              localcyu.parseFrom((byte[])localObject);
            }
            localcys.aaDw.add(localcyu);
            paramInt += 1;
          }
          AppMethodBeat.o(115843);
          return 0;
        }
        localcys.aaDx.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
        AppMethodBeat.o(115843);
        return 0;
      }
      AppMethodBeat.o(115843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cys
 * JD-Core Version:    0.7.0.1
 */