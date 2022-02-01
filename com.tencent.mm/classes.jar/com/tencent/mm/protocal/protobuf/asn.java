package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class asn
  extends dop
{
  public String LAt;
  public apc LAv;
  public long LDu;
  public int dLS;
  public b lastBuffer;
  public String tvp;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168985);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LDu);
      if (this.LAt != null) {
        paramVarArgs.e(3, this.LAt);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(5, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      if (this.tvp != null) {
        paramVarArgs.e(6, this.tvp);
      }
      paramVarArgs.aM(7, this.dLS);
      if (this.LAv != null)
      {
        paramVarArgs.ni(8, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LDu);
      paramInt = i;
      if (this.LAt != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LAt);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(5, this.uli.computeSize());
      }
      i = paramInt;
      if (this.tvp != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.tvp);
      }
      i += g.a.a.b.b.a.bu(7, this.dLS);
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(8, this.LAv.computeSize());
      }
      AppMethodBeat.o(168985);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        asn localasn = (asn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168985);
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
            localasn.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 2: 
          localasn.LDu = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168985);
          return 0;
        case 3: 
          localasn.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 4: 
          localasn.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168985);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localasn.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 6: 
          localasn.tvp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 7: 
          localasn.dLS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168985);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localasn.LAv = ((apc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      AppMethodBeat.o(168985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asn
 * JD-Core Version:    0.7.0.1
 */