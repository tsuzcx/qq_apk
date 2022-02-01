package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gip
  extends com.tencent.mm.bx.a
{
  public gis aceY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110854);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aceY == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(110854);
        throw paramVarArgs;
      }
      if (this.aceY != null)
      {
        paramVarArgs.qD(4, this.aceY.computeSize());
        this.aceY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110854);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aceY == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(4, this.aceY.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(110854);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aceY == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gip localgip = (gip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110854);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gis localgis = new gis();
          if ((localObject != null) && (localObject.length > 0)) {
            localgis.parseFrom((byte[])localObject);
          }
          localgip.aceY = localgis;
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gip
 * JD-Core Version:    0.7.0.1
 */