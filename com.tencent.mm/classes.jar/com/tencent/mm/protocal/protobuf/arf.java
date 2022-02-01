package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arf
  extends dop
{
  public String LCo;
  public String finderUsername;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String sessionBuffer;
  public aov uli;
  public int vkj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LCo != null) {
        paramVarArgs.e(2, this.LCo);
      }
      paramVarArgs.aM(3, this.opType);
      paramVarArgs.bb(4, this.refObjectId);
      if (this.finderUsername != null) {
        paramVarArgs.e(5, this.finderUsername);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.e(6, this.refObjectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(7, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.e(8, this.sessionBuffer);
      }
      paramVarArgs.aM(9, this.vkj);
      AppMethodBeat.o(168964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LCo != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LCo);
      }
      i = i + g.a.a.b.b.a.bu(3, this.opType) + g.a.a.b.b.a.r(4, this.refObjectId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.finderUsername);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.refObjectNonceId);
      }
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(7, this.uli.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.sessionBuffer);
      }
      paramInt = g.a.a.b.b.a.bu(9, this.vkj);
      AppMethodBeat.o(168964);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        arf localarf = (arf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168964);
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
            localarf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 2: 
          localarf.LCo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 3: 
          localarf.opType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168964);
          return 0;
        case 4: 
          localarf.refObjectId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168964);
          return 0;
        case 5: 
          localarf.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 6: 
          localarf.refObjectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localarf.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 8: 
          localarf.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168964);
          return 0;
        }
        localarf.vkj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168964);
        return 0;
      }
      AppMethodBeat.o(168964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arf
 * JD-Core Version:    0.7.0.1
 */