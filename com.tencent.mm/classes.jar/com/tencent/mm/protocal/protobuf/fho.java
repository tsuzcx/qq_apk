package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fho
  extends com.tencent.mm.cd.a
{
  public String UHx;
  public String UHy;
  public fia UHz;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255830);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UHx != null) {
        paramVarArgs.f(1, this.UHx);
      }
      if (this.UHy != null) {
        paramVarArgs.f(2, this.UHy);
      }
      if (this.UHz != null)
      {
        paramVarArgs.oE(3, this.UHz.computeSize());
        this.UHz.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.type);
      AppMethodBeat.o(255830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UHx == null) {
        break label452;
      }
    }
    label452:
    for (int i = g.a.a.b.b.a.g(1, this.UHx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UHy != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UHy);
      }
      i = paramInt;
      if (this.UHz != null) {
        i = paramInt + g.a.a.a.oD(3, this.UHz.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.type);
      AppMethodBeat.o(255830);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(255830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fho localfho = (fho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255830);
          return -1;
        case 1: 
          localfho.UHx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(255830);
          return 0;
        case 2: 
          localfho.UHy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(255830);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fia localfia = new fia();
            if ((localObject != null) && (localObject.length > 0)) {
              localfia.parseFrom((byte[])localObject);
            }
            localfho.UHz = localfia;
            paramInt += 1;
          }
          AppMethodBeat.o(255830);
          return 0;
        }
        localfho.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(255830);
        return 0;
      }
      AppMethodBeat.o(255830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fho
 * JD-Core Version:    0.7.0.1
 */