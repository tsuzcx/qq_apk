package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eta
  extends dop
{
  public int Llx;
  public long MKf;
  public int MKg;
  public String Nqu;
  public com.tencent.mm.bw.b Nqv;
  public com.tencent.mm.bw.b Nqw;
  public String Nqx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nqu == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ToBizUserName");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.Nqw == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MKg);
      if (this.Nqu != null) {
        paramVarArgs.e(3, this.Nqu);
      }
      paramVarArgs.aM(4, this.Llx);
      if (this.Nqv != null) {
        paramVarArgs.c(5, this.Nqv);
      }
      if (this.Nqw != null) {
        paramVarArgs.c(6, this.Nqw);
      }
      paramVarArgs.bb(7, this.MKf);
      if (this.Nqx != null) {
        paramVarArgs.e(8, this.Nqx);
      }
      AppMethodBeat.o(125498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MKg);
      paramInt = i;
      if (this.Nqu != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Nqu);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Llx);
      paramInt = i;
      if (this.Nqv != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.Nqv);
      }
      i = paramInt;
      if (this.Nqw != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.Nqw);
      }
      i += g.a.a.b.b.a.r(7, this.MKf);
      paramInt = i;
      if (this.Nqx != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Nqx);
      }
      AppMethodBeat.o(125498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Nqu == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: ToBizUserName");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        if (this.Nqw == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eta localeta = (eta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125498);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeta.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125498);
          return 0;
        case 2: 
          localeta.MKg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125498);
          return 0;
        case 3: 
          localeta.Nqu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125498);
          return 0;
        case 4: 
          localeta.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125498);
          return 0;
        case 5: 
          localeta.Nqv = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(125498);
          return 0;
        case 6: 
          localeta.Nqw = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(125498);
          return 0;
        case 7: 
          localeta.MKf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125498);
          return 0;
        }
        localeta.Nqx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(125498);
        return 0;
      }
      AppMethodBeat.o(125498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eta
 * JD-Core Version:    0.7.0.1
 */