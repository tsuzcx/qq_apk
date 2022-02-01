package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dfu
  extends dop
{
  public int LsZ;
  public long Lta;
  public String MKC;
  public int MKD;
  public int MKE;
  public long MKf;
  public long MKi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUsername");
        AppMethodBeat.o(32390);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MKC != null) {
        paramVarArgs.e(2, this.MKC);
      }
      paramVarArgs.aM(3, this.LsZ);
      paramVarArgs.bb(4, this.Lta);
      paramVarArgs.bb(5, this.MKf);
      paramVarArgs.aM(6, this.MKD);
      paramVarArgs.bb(7, this.MKi);
      paramVarArgs.aM(8, this.MKE);
      AppMethodBeat.o(32390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MKC != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MKC);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.LsZ);
      int j = g.a.a.b.b.a.r(4, this.Lta);
      int k = g.a.a.b.b.a.r(5, this.MKf);
      int m = g.a.a.b.b.a.bu(6, this.MKD);
      int n = g.a.a.b.b.a.r(7, this.MKi);
      int i1 = g.a.a.b.b.a.bu(8, this.MKE);
      AppMethodBeat.o(32390);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUsername");
          AppMethodBeat.o(32390);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32390);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfu localdfu = (dfu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32390);
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
            localdfu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32390);
          return 0;
        case 2: 
          localdfu.MKC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32390);
          return 0;
        case 3: 
          localdfu.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32390);
          return 0;
        case 4: 
          localdfu.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32390);
          return 0;
        case 5: 
          localdfu.MKf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32390);
          return 0;
        case 6: 
          localdfu.MKD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32390);
          return 0;
        case 7: 
          localdfu.MKi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32390);
          return 0;
        }
        localdfu.MKE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32390);
        return 0;
      }
      AppMethodBeat.o(32390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfu
 * JD-Core Version:    0.7.0.1
 */