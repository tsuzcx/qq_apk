package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mz
  extends dop
{
  public int KND;
  public long KRC;
  public String KRD;
  public String KRE;
  public long KRi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212227);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.KRC);
      if (this.KRD != null) {
        paramVarArgs.e(4, this.KRD);
      }
      if (this.KRE != null) {
        paramVarArgs.e(5, this.KRE);
      }
      paramVarArgs.bb(18, this.KRi);
      paramVarArgs.aM(22, this.KND);
      AppMethodBeat.o(212227);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KRC);
      paramInt = i;
      if (this.KRD != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KRD);
      }
      i = paramInt;
      if (this.KRE != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KRE);
      }
      paramInt = g.a.a.b.b.a.r(18, this.KRi);
      int j = g.a.a.b.b.a.bu(22, this.KND);
      AppMethodBeat.o(212227);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212227);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mz localmz = (mz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212227);
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
            localmz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212227);
          return 0;
        case 2: 
          localmz.KRC = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212227);
          return 0;
        case 4: 
          localmz.KRD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212227);
          return 0;
        case 5: 
          localmz.KRE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212227);
          return 0;
        case 18: 
          localmz.KRi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212227);
          return 0;
        }
        localmz.KND = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212227);
        return 0;
      }
      AppMethodBeat.o(212227);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mz
 * JD-Core Version:    0.7.0.1
 */