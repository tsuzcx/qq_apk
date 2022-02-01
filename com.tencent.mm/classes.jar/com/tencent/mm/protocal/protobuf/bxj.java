package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bxj
  extends dop
{
  public SKBuiltinBuffer_t KPW;
  public dqi Lqk;
  public dqi Mdi;
  public dqi Mdj;
  public SKBuiltinBuffer_t Mdk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155420);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.Mdi == null)
      {
        paramVarArgs = new b("Not all required fields were included: Pwd");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lqk != null)
      {
        paramVarArgs.ni(2, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      if (this.Mdi != null)
      {
        paramVarArgs.ni(3, this.Mdi.computeSize());
        this.Mdi.writeFields(paramVarArgs);
      }
      if (this.Mdj != null)
      {
        paramVarArgs.ni(4, this.Mdj.computeSize());
        this.Mdj.writeFields(paramVarArgs);
      }
      if (this.KPW != null)
      {
        paramVarArgs.ni(5, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      if (this.Mdk != null)
      {
        paramVarArgs.ni(6, this.Mdk.computeSize());
        this.Mdk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1178;
      }
    }
    label1178:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lqk != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lqk.computeSize());
      }
      i = paramInt;
      if (this.Mdi != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mdi.computeSize());
      }
      paramInt = i;
      if (this.Mdj != null) {
        paramInt = i + g.a.a.a.nh(4, this.Mdj.computeSize());
      }
      i = paramInt;
      if (this.KPW != null) {
        i = paramInt + g.a.a.a.nh(5, this.KPW.computeSize());
      }
      paramInt = i;
      if (this.Mdk != null) {
        paramInt = i + g.a.a.a.nh(6, this.Mdk.computeSize());
      }
      AppMethodBeat.o(155420);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        if (this.Mdi == null)
        {
          paramVarArgs = new b("Not all required fields were included: Pwd");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxj localbxj = (bxj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155420);
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
            localbxj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxj.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxj.Mdi = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxj.Mdj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxj.KPW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbxj.Mdk = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      AppMethodBeat.o(155420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxj
 * JD-Core Version:    0.7.0.1
 */