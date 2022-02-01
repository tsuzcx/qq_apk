package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfh
  extends com.tencent.mm.cd.a
{
  public bfg SPW;
  public String SPX;
  public String SPY;
  public String SPZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SPW != null)
      {
        paramVarArgs.oE(1, this.SPW.computeSize());
        this.SPW.writeFields(paramVarArgs);
      }
      if (this.SPX != null) {
        paramVarArgs.f(2, this.SPX);
      }
      if (this.SPY != null) {
        paramVarArgs.f(3, this.SPY);
      }
      if (this.SPZ != null) {
        paramVarArgs.f(4, this.SPZ);
      }
      AppMethodBeat.o(199612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SPW == null) {
        break label468;
      }
    }
    label468:
    for (int i = g.a.a.a.oD(1, this.SPW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SPX != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SPX);
      }
      i = paramInt;
      if (this.SPY != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SPY);
      }
      paramInt = i;
      if (this.SPZ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SPZ);
      }
      AppMethodBeat.o(199612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bfh localbfh = (bfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199612);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bfg localbfg = new bfg();
            if ((localObject != null) && (localObject.length > 0)) {
              localbfg.parseFrom((byte[])localObject);
            }
            localbfh.SPW = localbfg;
            paramInt += 1;
          }
          AppMethodBeat.o(199612);
          return 0;
        case 2: 
          localbfh.SPX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(199612);
          return 0;
        case 3: 
          localbfh.SPY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(199612);
          return 0;
        }
        localbfh.SPZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199612);
        return 0;
      }
      AppMethodBeat.o(199612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfh
 * JD-Core Version:    0.7.0.1
 */