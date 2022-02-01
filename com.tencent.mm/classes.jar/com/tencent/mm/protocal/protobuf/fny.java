package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fny
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b RTT;
  public LinkedList<fnv> RTU;
  public String Txp;
  
  public fny()
  {
    AppMethodBeat.i(123701);
    this.RTU = new LinkedList();
    AppMethodBeat.o(123701);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123702);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Txp == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(123702);
        throw paramVarArgs;
      }
      if (this.Txp != null) {
        paramVarArgs.f(1, this.Txp);
      }
      if (this.RTT != null) {
        paramVarArgs.c(2, this.RTT);
      }
      paramVarArgs.e(3, 8, this.RTU);
      AppMethodBeat.o(123702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Txp == null) {
        break label444;
      }
    }
    label444:
    for (paramInt = g.a.a.b.b.a.g(1, this.Txp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RTT != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RTT);
      }
      paramInt = g.a.a.a.c(3, 8, this.RTU);
      AppMethodBeat.o(123702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RTU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Txp == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(123702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fny localfny = (fny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123702);
          return -1;
        case 1: 
          localfny.Txp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123702);
          return 0;
        case 2: 
          localfny.RTT = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(123702);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fnv localfnv = new fnv();
          if ((localObject != null) && (localObject.length > 0)) {
            localfnv.parseFrom((byte[])localObject);
          }
          localfny.RTU.add(localfnv);
          paramInt += 1;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      AppMethodBeat.o(123702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fny
 * JD-Core Version:    0.7.0.1
 */