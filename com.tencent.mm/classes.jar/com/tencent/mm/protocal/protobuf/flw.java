package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class flw
  extends com.tencent.mm.cd.a
{
  public flz UKK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110854);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UKK == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110854);
        throw paramVarArgs;
      }
      if (this.UKK != null)
      {
        paramVarArgs.oE(4, this.UKK.computeSize());
        this.UKK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110854);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UKK == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.a.oD(4, this.UKK.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(110854);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UKK == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(110854);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110854);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        flw localflw = (flw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110854);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          flz localflz = new flz();
          if ((localObject != null) && (localObject.length > 0)) {
            localflz.parseFrom((byte[])localObject);
          }
          localflw.UKK = localflz;
          paramInt += 1;
        }
        AppMethodBeat.o(110854);
        return 0;
      }
      AppMethodBeat.o(110854);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flw
 * JD-Core Version:    0.7.0.1
 */