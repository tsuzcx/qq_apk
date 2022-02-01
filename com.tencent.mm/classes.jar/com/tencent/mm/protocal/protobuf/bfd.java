package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfd
  extends com.tencent.mm.cd.a
{
  public bfm verifyInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169016);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.verifyInfo != null)
      {
        paramVarArgs.oE(1, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.verifyInfo == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.verifyInfo.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(169016);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169016);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bfd localbfd = (bfd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169016);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bfm localbfm = new bfm();
          if ((localObject != null) && (localObject.length > 0)) {
            localbfm.parseFrom((byte[])localObject);
          }
          localbfd.verifyInfo = localbfm;
          paramInt += 1;
        }
        AppMethodBeat.o(169016);
        return 0;
      }
      AppMethodBeat.o(169016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfd
 * JD-Core Version:    0.7.0.1
 */