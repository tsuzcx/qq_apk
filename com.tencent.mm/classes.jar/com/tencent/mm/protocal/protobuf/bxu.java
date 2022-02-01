package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxu
  extends com.tencent.mm.bx.a
{
  public awx ZHN;
  public LinkedList<fol> lPK;
  
  public bxu()
  {
    AppMethodBeat.i(258162);
    this.lPK = new LinkedList();
    AppMethodBeat.o(258162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258168);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.lPK);
      if (this.ZHN != null)
      {
        paramVarArgs.qD(19, this.ZHN.computeSize());
        this.ZHN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258168);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.lPK) + 0;
      paramInt = i;
      if (this.ZHN != null) {
        paramInt = i + i.a.a.a.qC(19, this.ZHN.computeSize());
      }
      AppMethodBeat.o(258168);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lPK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258168);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bxu localbxu = (bxu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258168);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fol)localObject2).parseFrom((byte[])localObject1);
          }
          localbxu.lPK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258168);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new awx();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((awx)localObject2).parseFrom((byte[])localObject1);
        }
        localbxu.ZHN = ((awx)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258168);
      return 0;
    }
    AppMethodBeat.o(258168);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxu
 * JD-Core Version:    0.7.0.1
 */