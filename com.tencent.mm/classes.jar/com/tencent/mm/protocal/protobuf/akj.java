package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class akj
  extends com.tencent.mm.bx.a
{
  public LinkedList<akk> YCW;
  public int eQp;
  public String tNT;
  
  public akj()
  {
    AppMethodBeat.i(258256);
    this.YCW = new LinkedList();
    AppMethodBeat.o(258256);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258263);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YCW);
      if (this.tNT != null) {
        paramVarArgs.g(2, this.tNT);
      }
      paramVarArgs.bS(3, this.eQp);
      AppMethodBeat.o(258263);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.YCW) + 0;
      paramInt = i;
      if (this.tNT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.tNT);
      }
      i = i.a.a.b.b.a.cJ(3, this.eQp);
      AppMethodBeat.o(258263);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YCW.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258263);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      akj localakj = (akj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258263);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          akk localakk = new akk();
          if ((localObject != null) && (localObject.length > 0)) {
            localakk.parseFrom((byte[])localObject);
          }
          localakj.YCW.add(localakk);
          paramInt += 1;
        }
        AppMethodBeat.o(258263);
        return 0;
      case 2: 
        localakj.tNT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258263);
        return 0;
      }
      localakj.eQp = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258263);
      return 0;
    }
    AppMethodBeat.o(258263);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akj
 * JD-Core Version:    0.7.0.1
 */