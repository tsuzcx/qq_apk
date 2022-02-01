package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class epz
  extends com.tencent.mm.cd.a
{
  public String Txp;
  public String Uhg;
  public fpp Usx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153307);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Txp == null)
      {
        paramVarArgs = new b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(153307);
        throw paramVarArgs;
      }
      if (this.Txp != null) {
        paramVarArgs.f(1, this.Txp);
      }
      if (this.Usx != null)
      {
        paramVarArgs.oE(2, this.Usx.computeSize());
        this.Usx.writeFields(paramVarArgs);
      }
      if (this.Uhg != null) {
        paramVarArgs.f(3, this.Uhg);
      }
      AppMethodBeat.o(153307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Txp == null) {
        break label456;
      }
    }
    label456:
    for (int i = g.a.a.b.b.a.g(1, this.Txp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Usx != null) {
        paramInt = i + g.a.a.a.oD(2, this.Usx.computeSize());
      }
      i = paramInt;
      if (this.Uhg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uhg);
      }
      AppMethodBeat.o(153307);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Txp == null)
        {
          paramVarArgs = new b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(153307);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        epz localepz = (epz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153307);
          return -1;
        case 1: 
          localepz.Txp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153307);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fpp localfpp = new fpp();
            if ((localObject != null) && (localObject.length > 0)) {
              localfpp.parseFrom((byte[])localObject);
            }
            localepz.Usx = localfpp;
            paramInt += 1;
          }
          AppMethodBeat.o(153307);
          return 0;
        }
        localepz.Uhg = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153307);
        return 0;
      }
      AppMethodBeat.o(153307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epz
 * JD-Core Version:    0.7.0.1
 */