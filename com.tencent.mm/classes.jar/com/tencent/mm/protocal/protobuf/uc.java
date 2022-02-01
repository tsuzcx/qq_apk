package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uc
  extends com.tencent.mm.bx.a
{
  public boolean Rvp;
  public LinkedList<ud> YZN;
  
  public uc()
  {
    AppMethodBeat.i(259245);
    this.YZN = new LinkedList();
    AppMethodBeat.o(259245);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259249);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YZN);
      paramVarArgs.di(2, this.Rvp);
      AppMethodBeat.o(259249);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.YZN);
      i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(259249);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YZN.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259249);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      uc localuc = (uc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259249);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ud localud = new ud();
          if ((localObject != null) && (localObject.length > 0)) {
            localud.parseFrom((byte[])localObject);
          }
          localuc.YZN.add(localud);
          paramInt += 1;
        }
        AppMethodBeat.o(259249);
        return 0;
      }
      localuc.Rvp = ((i.a.a.a.a)localObject).ajGk.aai();
      AppMethodBeat.o(259249);
      return 0;
    }
    AppMethodBeat.o(259249);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uc
 * JD-Core Version:    0.7.0.1
 */