package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gcp
  extends com.tencent.mm.bx.a
{
  public String acah;
  public LinkedList<gcl> acaz;
  
  public gcp()
  {
    AppMethodBeat.i(147803);
    this.acaz = new LinkedList();
    AppMethodBeat.o(147803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147804);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acah != null) {
        paramVarArgs.g(1, this.acah);
      }
      paramVarArgs.e(2, 8, this.acaz);
      AppMethodBeat.o(147804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acah == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.acah) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.acaz);
      AppMethodBeat.o(147804);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acaz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gcp localgcp = (gcp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147804);
          return -1;
        case 1: 
          localgcp.acah = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147804);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gcl localgcl = new gcl();
          if ((localObject != null) && (localObject.length > 0)) {
            localgcl.parseFrom((byte[])localObject);
          }
          localgcp.acaz.add(localgcl);
          paramInt += 1;
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      AppMethodBeat.o(147804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcp
 * JD-Core Version:    0.7.0.1
 */