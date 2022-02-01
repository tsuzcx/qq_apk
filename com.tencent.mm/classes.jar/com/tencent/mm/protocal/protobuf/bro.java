package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class bro
  extends com.tencent.mm.bx.a
{
  public bux ZZO;
  public LinkedList<bux> ZZP;
  public b ZZQ;
  
  public bro()
  {
    AppMethodBeat.i(257369);
    this.ZZP = new LinkedList();
    AppMethodBeat.o(257369);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257378);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZZO != null)
      {
        paramVarArgs.qD(1, this.ZZO.computeSize());
        this.ZZO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZZP);
      if (this.ZZQ != null) {
        paramVarArgs.d(3, this.ZZQ);
      }
      AppMethodBeat.o(257378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZZO == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.ZZO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZZP);
      paramInt = i;
      if (this.ZZQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZZQ);
      }
      AppMethodBeat.o(257378);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZZP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bro localbro = (bro)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        bux localbux;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257378);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbux = new bux();
            if ((localObject != null) && (localObject.length > 0)) {
              localbux.parseFrom((byte[])localObject);
            }
            localbro.ZZO = localbux;
            paramInt += 1;
          }
          AppMethodBeat.o(257378);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbux = new bux();
            if ((localObject != null) && (localObject.length > 0)) {
              localbux.parseFrom((byte[])localObject);
            }
            localbro.ZZP.add(localbux);
            paramInt += 1;
          }
          AppMethodBeat.o(257378);
          return 0;
        }
        localbro.ZZQ = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257378);
        return 0;
      }
      AppMethodBeat.o(257378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bro
 * JD-Core Version:    0.7.0.1
 */