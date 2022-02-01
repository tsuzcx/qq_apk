package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aju
  extends com.tencent.mm.cd.a
{
  public akh Tej;
  public ajv Tel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104768);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tej == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerSummary");
        AppMethodBeat.o(104768);
        throw paramVarArgs;
      }
      if (this.Tel == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(104768);
        throw paramVarArgs;
      }
      if (this.Tej != null)
      {
        paramVarArgs.oE(1, this.Tej.computeSize());
        this.Tej.writeFields(paramVarArgs);
      }
      if (this.Tel != null)
      {
        paramVarArgs.oE(2, this.Tel.computeSize());
        this.Tel.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tej == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.oD(1, this.Tej.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tel != null) {
        i = paramInt + g.a.a.a.oD(2, this.Tel.computeSize());
      }
      AppMethodBeat.o(104768);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Tej == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerSummary");
          AppMethodBeat.o(104768);
          throw paramVarArgs;
        }
        if (this.Tel == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerImg");
          AppMethodBeat.o(104768);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aju localaju = (aju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104768);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akh)localObject2).parseFrom((byte[])localObject1);
            }
            localaju.Tej = ((akh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104768);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ajv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ajv)localObject2).parseFrom((byte[])localObject1);
          }
          localaju.Tel = ((ajv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104768);
        return 0;
      }
      AppMethodBeat.o(104768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aju
 * JD-Core Version:    0.7.0.1
 */