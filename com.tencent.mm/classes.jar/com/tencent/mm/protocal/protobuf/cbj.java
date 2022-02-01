package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cbj
  extends com.tencent.mm.bx.a
{
  public cbc aakG;
  public LinkedList<String> aakH;
  
  public cbj()
  {
    AppMethodBeat.i(42644);
    this.aakH = new LinkedList();
    AppMethodBeat.o(42644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42645);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aakG == null)
      {
        paramVarArgs = new b("Not all required fields were included: GameItem");
        AppMethodBeat.o(42645);
        throw paramVarArgs;
      }
      if (this.aakG != null)
      {
        paramVarArgs.qD(1, this.aakG.computeSize());
        this.aakG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.aakH);
      AppMethodBeat.o(42645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aakG == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.a.qC(1, this.aakG.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aakH);
      AppMethodBeat.o(42645);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aakH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aakG == null)
        {
          paramVarArgs = new b("Not all required fields were included: GameItem");
          AppMethodBeat.o(42645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cbj localcbj = (cbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42645);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cbc localcbc = new cbc();
            if ((localObject != null) && (localObject.length > 0)) {
              localcbc.parseFrom((byte[])localObject);
            }
            localcbj.aakG = localcbc;
            paramInt += 1;
          }
          AppMethodBeat.o(42645);
          return 0;
        }
        localcbj.aakH.add(((i.a.a.a.a)localObject).ajGk.readString());
        AppMethodBeat.o(42645);
        return 0;
      }
      AppMethodBeat.o(42645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbj
 * JD-Core Version:    0.7.0.1
 */