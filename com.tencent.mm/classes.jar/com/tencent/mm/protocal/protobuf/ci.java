package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ci
  extends com.tencent.mm.cd.a
{
  public dwf RHX;
  public dwf RHY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RHX != null)
      {
        paramVarArgs.oE(1, this.RHX.computeSize());
        this.RHX.writeFields(paramVarArgs);
      }
      if (this.RHY != null)
      {
        paramVarArgs.oE(2, this.RHY.computeSize());
        this.RHY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RHX == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.RHX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RHY != null) {
        i = paramInt + g.a.a.a.oD(2, this.RHY.computeSize());
      }
      AppMethodBeat.o(125703);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ci localci = (ci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dwf localdwf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125703);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdwf = new dwf();
            if ((localObject != null) && (localObject.length > 0)) {
              localdwf.parseFrom((byte[])localObject);
            }
            localci.RHX = localdwf;
            paramInt += 1;
          }
          AppMethodBeat.o(125703);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdwf = new dwf();
          if ((localObject != null) && (localObject.length > 0)) {
            localdwf.parseFrom((byte[])localObject);
          }
          localci.RHY = localdwf;
          paramInt += 1;
        }
        AppMethodBeat.o(125703);
        return 0;
      }
      AppMethodBeat.o(125703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ci
 * JD-Core Version:    0.7.0.1
 */