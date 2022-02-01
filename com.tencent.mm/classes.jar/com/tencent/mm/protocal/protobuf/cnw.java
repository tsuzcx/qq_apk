package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cnw
  extends dop
{
  public String LOd;
  public long MtO;
  public cnh Mul;
  public b lastBuffer;
  public long twG;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209752);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Mul != null)
      {
        paramVarArgs.ni(2, this.Mul.computeSize());
        this.Mul.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(3, this.twG);
      paramVarArgs.bb(4, this.MtO);
      if (this.username != null) {
        paramVarArgs.e(5, this.username);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(6, this.lastBuffer);
      }
      if (this.LOd != null) {
        paramVarArgs.e(7, this.LOd);
      }
      AppMethodBeat.o(209752);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mul != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mul.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.twG) + g.a.a.b.b.a.r(4, this.MtO);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.username);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.lastBuffer);
      }
      paramInt = i;
      if (this.LOd != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LOd);
      }
      AppMethodBeat.o(209752);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209752);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnw localcnw = (cnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209752);
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
            localcnw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209752);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnw.Mul = ((cnh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209752);
          return 0;
        case 3: 
          localcnw.twG = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209752);
          return 0;
        case 4: 
          localcnw.MtO = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209752);
          return 0;
        case 5: 
          localcnw.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209752);
          return 0;
        case 6: 
          localcnw.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209752);
          return 0;
        }
        localcnw.LOd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209752);
        return 0;
      }
      AppMethodBeat.o(209752);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnw
 * JD-Core Version:    0.7.0.1
 */