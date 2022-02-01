package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class om
  extends com.tencent.mm.bx.a
{
  public LinkedList<oo> YIB;
  public boolean YRB;
  public String hAP;
  
  public om()
  {
    AppMethodBeat.i(124411);
    this.YIB = new LinkedList();
    AppMethodBeat.o(124411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.YIB);
      paramVarArgs.di(3, this.YRB);
      AppMethodBeat.o(124412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YIB);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(124412);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YIB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        om localom = (om)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124412);
          return -1;
        case 1: 
          localom.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124412);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            oo localoo = new oo();
            if ((localObject != null) && (localObject.length > 0)) {
              localoo.parseFrom((byte[])localObject);
            }
            localom.YIB.add(localoo);
            paramInt += 1;
          }
          AppMethodBeat.o(124412);
          return 0;
        }
        localom.YRB = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(124412);
        return 0;
      }
      AppMethodBeat.o(124412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.om
 * JD-Core Version:    0.7.0.1
 */