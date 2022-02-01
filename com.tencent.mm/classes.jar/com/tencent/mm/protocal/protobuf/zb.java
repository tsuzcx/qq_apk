package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zb
  extends cpx
{
  public String DUp;
  public String Etg;
  public String Eth;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Etg == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.DUp == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.Eth == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientInfo");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.hOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Etg != null) {
        paramVarArgs.d(2, this.Etg);
      }
      if (this.DUp != null) {
        paramVarArgs.d(3, this.DUp);
      }
      if (this.Eth != null) {
        paramVarArgs.d(4, this.Eth);
      }
      if (this.hOf != null) {
        paramVarArgs.d(5, this.hOf);
      }
      AppMethodBeat.o(32172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label761;
      }
    }
    label761:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Etg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Etg);
      }
      i = paramInt;
      if (this.DUp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUp);
      }
      paramInt = i;
      if (this.Eth != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eth);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hOf);
      }
      AppMethodBeat.o(32172);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Etg == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.DUp == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.Eth == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientInfo");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.hOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32172);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zb localzb = (zb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32172);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32172);
          return 0;
        case 2: 
          localzb.Etg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 3: 
          localzb.DUp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 4: 
          localzb.Eth = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32172);
          return 0;
        }
        localzb.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32172);
        return 0;
      }
      AppMethodBeat.o(32172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zb
 * JD-Core Version:    0.7.0.1
 */