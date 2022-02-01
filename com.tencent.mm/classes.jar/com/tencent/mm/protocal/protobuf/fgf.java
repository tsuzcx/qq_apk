package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fgf
  extends com.tencent.mm.cd.a
{
  public LinkedList<ffs> UGn;
  public ffj UGw;
  public int UGx;
  
  public fgf()
  {
    AppMethodBeat.i(147806);
    this.UGn = new LinkedList();
    AppMethodBeat.o(147806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147807);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UGw == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147807);
        throw paramVarArgs;
      }
      if (this.UGw != null)
      {
        paramVarArgs.oE(1, this.UGw.computeSize());
        this.UGw.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.UGn);
      paramVarArgs.aY(3, this.UGx);
      AppMethodBeat.o(147807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UGw == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = g.a.a.a.oD(1, this.UGw.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.UGn);
      int j = g.a.a.b.b.a.bM(3, this.UGx);
      AppMethodBeat.o(147807);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UGn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UGw == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fgf localfgf = (fgf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147807);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffj)localObject2).parseFrom((byte[])localObject1);
            }
            localfgf.UGw = ((ffj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147807);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffs)localObject2).parseFrom((byte[])localObject1);
            }
            localfgf.UGn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147807);
          return 0;
        }
        localfgf.UGx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(147807);
        return 0;
      }
      AppMethodBeat.o(147807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgf
 * JD-Core Version:    0.7.0.1
 */