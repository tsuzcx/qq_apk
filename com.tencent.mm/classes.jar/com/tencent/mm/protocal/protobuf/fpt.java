package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpt
  extends com.tencent.mm.cd.a
{
  public String Md5;
  public int RTb;
  public String UNH;
  public fpn UNq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153344);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNq != null)
      {
        paramVarArgs.oE(1, this.UNq.computeSize());
        this.UNq.writeFields(paramVarArgs);
      }
      if (this.UNH != null) {
        paramVarArgs.f(2, this.UNH);
      }
      paramVarArgs.aY(3, this.RTb);
      if (this.Md5 != null) {
        paramVarArgs.f(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNq == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.UNq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UNH != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UNH);
      }
      i += g.a.a.b.b.a.bM(3, this.RTb);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fpt localfpt = (fpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153344);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fpn localfpn = new fpn();
            if ((localObject != null) && (localObject.length > 0)) {
              localfpn.parseFrom((byte[])localObject);
            }
            localfpt.UNq = localfpn;
            paramInt += 1;
          }
          AppMethodBeat.o(153344);
          return 0;
        case 2: 
          localfpt.UNH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153344);
          return 0;
        case 3: 
          localfpt.RTb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153344);
          return 0;
        }
        localfpt.Md5 = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153344);
        return 0;
      }
      AppMethodBeat.o(153344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpt
 * JD-Core Version:    0.7.0.1
 */