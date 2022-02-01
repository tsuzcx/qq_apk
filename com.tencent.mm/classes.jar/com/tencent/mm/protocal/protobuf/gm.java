package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gm
  extends dyl
{
  public String Igm;
  public String RLy;
  public String fvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Igm != null) {
        paramVarArgs.f(2, this.Igm);
      }
      if (this.fvP != null) {
        paramVarArgs.f(3, this.fvP);
      }
      if (this.RLy != null) {
        paramVarArgs.f(4, this.RLy);
      }
      AppMethodBeat.o(72417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label468;
      }
    }
    label468:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Igm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Igm);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fvP);
      }
      paramInt = i;
      if (this.RLy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RLy);
      }
      AppMethodBeat.o(72417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        gm localgm = (gm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72417);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localgm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72417);
          return 0;
        case 2: 
          localgm.Igm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72417);
          return 0;
        case 3: 
          localgm.fvP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72417);
          return 0;
        }
        localgm.RLy = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72417);
        return 0;
      }
      AppMethodBeat.o(72417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gm
 * JD-Core Version:    0.7.0.1
 */