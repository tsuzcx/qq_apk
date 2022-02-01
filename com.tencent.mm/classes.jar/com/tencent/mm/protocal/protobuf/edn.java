package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edn
  extends com.tencent.mm.bx.a
{
  public LinkedList<qj> abiG;
  public LinkedList<String> abiH;
  public LinkedList<String> abiI;
  
  public edn()
  {
    AppMethodBeat.i(257328);
    this.abiG = new LinkedList();
    this.abiH = new LinkedList();
    this.abiI = new LinkedList();
    AppMethodBeat.o(257328);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257332);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.abiG);
      paramVarArgs.e(2, 1, this.abiH);
      paramVarArgs.e(3, 1, this.abiI);
      AppMethodBeat.o(257332);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.abiG);
      i = i.a.a.a.c(2, 1, this.abiH);
      int j = i.a.a.a.c(3, 1, this.abiI);
      AppMethodBeat.o(257332);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abiG.clear();
      this.abiH.clear();
      this.abiI.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257332);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      edn localedn = (edn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257332);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          qj localqj = new qj();
          if ((localObject != null) && (localObject.length > 0)) {
            localqj.parseFrom((byte[])localObject);
          }
          localedn.abiG.add(localqj);
          paramInt += 1;
        }
        AppMethodBeat.o(257332);
        return 0;
      case 2: 
        localedn.abiH.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(257332);
        return 0;
      }
      localedn.abiI.add(((i.a.a.a.a)localObject).ajGk.readString());
      AppMethodBeat.o(257332);
      return 0;
    }
    AppMethodBeat.o(257332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edn
 * JD-Core Version:    0.7.0.1
 */