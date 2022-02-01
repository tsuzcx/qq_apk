package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eaz
  extends dop
{
  public long Nar;
  public int OpCode;
  public int Scene;
  public LinkedList<dqi> oTA;
  public int oTz;
  public String xMo;
  
  public eaz()
  {
    AppMethodBeat.i(125821);
    this.oTA = new LinkedList();
    AppMethodBeat.o(125821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125822);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.OpCode);
      paramVarArgs.bb(3, this.Nar);
      if (this.xMo != null) {
        paramVarArgs.e(4, this.xMo);
      }
      paramVarArgs.aM(5, this.oTz);
      paramVarArgs.e(6, 8, this.oTA);
      paramVarArgs.aM(7, this.Scene);
      AppMethodBeat.o(125822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.OpCode) + g.a.a.b.b.a.r(3, this.Nar);
      paramInt = i;
      if (this.xMo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xMo);
      }
      i = g.a.a.b.b.a.bu(5, this.oTz);
      int j = g.a.a.a.c(6, 8, this.oTA);
      int k = g.a.a.b.b.a.bu(7, this.Scene);
      AppMethodBeat.o(125822);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.oTA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eaz localeaz = (eaz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125822);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeaz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        case 2: 
          localeaz.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125822);
          return 0;
        case 3: 
          localeaz.Nar = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125822);
          return 0;
        case 4: 
          localeaz.xMo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125822);
          return 0;
        case 5: 
          localeaz.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125822);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeaz.oTA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        }
        localeaz.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125822);
        return 0;
      }
      AppMethodBeat.o(125822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaz
 * JD-Core Version:    0.7.0.1
 */