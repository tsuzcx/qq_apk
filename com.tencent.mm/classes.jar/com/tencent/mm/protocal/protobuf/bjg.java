package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjg
  extends com.tencent.mm.bx.a
{
  public LinkedList<bji> ZST;
  public LinkedList<String> ZSU;
  
  public bjg()
  {
    AppMethodBeat.i(260157);
    this.ZST = new LinkedList();
    this.ZSU = new LinkedList();
    AppMethodBeat.o(260157);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260164);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZST);
      paramVarArgs.e(2, 1, this.ZSU);
      AppMethodBeat.o(260164);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZST);
      i = i.a.a.a.c(2, 1, this.ZSU);
      AppMethodBeat.o(260164);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZST.clear();
      this.ZSU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260164);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bjg localbjg = (bjg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260164);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bji localbji = new bji();
          if ((localObject != null) && (localObject.length > 0)) {
            localbji.parseFrom((byte[])localObject);
          }
          localbjg.ZST.add(localbji);
          paramInt += 1;
        }
        AppMethodBeat.o(260164);
        return 0;
      }
      localbjg.ZSU.add(((i.a.a.a.a)localObject).ajGk.readString());
      AppMethodBeat.o(260164);
      return 0;
    }
    AppMethodBeat.o(260164);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjg
 * JD-Core Version:    0.7.0.1
 */