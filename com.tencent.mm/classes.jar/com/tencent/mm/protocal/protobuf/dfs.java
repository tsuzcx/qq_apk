package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dfs
  extends dop
{
  public int LsZ;
  public long Lta;
  public long MKf;
  public long MKi;
  public int oTW;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32388);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32388);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xNH != null) {
        paramVarArgs.e(2, this.xNH);
      }
      paramVarArgs.aM(3, this.LsZ);
      paramVarArgs.bb(4, this.Lta);
      paramVarArgs.bb(5, this.MKf);
      paramVarArgs.bb(6, this.MKi);
      paramVarArgs.aM(7, this.oTW);
      AppMethodBeat.o(32388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label667;
      }
    }
    label667:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNH != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xNH);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.LsZ);
      int j = g.a.a.b.b.a.r(4, this.Lta);
      int k = g.a.a.b.b.a.r(5, this.MKf);
      int m = g.a.a.b.b.a.r(6, this.MKi);
      int n = g.a.a.b.b.a.bu(7, this.oTW);
      AppMethodBeat.o(32388);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(32388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfs localdfs = (dfs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32388);
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
            localdfs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32388);
          return 0;
        case 2: 
          localdfs.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32388);
          return 0;
        case 3: 
          localdfs.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32388);
          return 0;
        case 4: 
          localdfs.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32388);
          return 0;
        case 5: 
          localdfs.MKf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32388);
          return 0;
        case 6: 
          localdfs.MKi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32388);
          return 0;
        }
        localdfs.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32388);
        return 0;
      }
      AppMethodBeat.o(32388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfs
 * JD-Core Version:    0.7.0.1
 */