package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class emx
  extends dpc
{
  public int LUb;
  public int LUc;
  public int LUd;
  public int LUe;
  public String LUf;
  public int LUg;
  public String Mvl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101834);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101834);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mvl != null) {
        paramVarArgs.e(2, this.Mvl);
      }
      if (this.LUf != null) {
        paramVarArgs.e(3, this.LUf);
      }
      paramVarArgs.aM(4, this.LUe);
      paramVarArgs.aM(5, this.LUb);
      paramVarArgs.aM(6, this.LUc);
      paramVarArgs.aM(7, this.LUd);
      paramVarArgs.aM(8, this.LUg);
      AppMethodBeat.o(101834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mvl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mvl);
      }
      i = paramInt;
      if (this.LUf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LUf);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.LUe);
      int j = g.a.a.b.b.a.bu(5, this.LUb);
      int k = g.a.a.b.b.a.bu(6, this.LUc);
      int m = g.a.a.b.b.a.bu(7, this.LUd);
      int n = g.a.a.b.b.a.bu(8, this.LUg);
      AppMethodBeat.o(101834);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101834);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101834);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        emx localemx = (emx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101834);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localemx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101834);
          return 0;
        case 2: 
          localemx.Mvl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 3: 
          localemx.LUf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 4: 
          localemx.LUe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101834);
          return 0;
        case 5: 
          localemx.LUb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101834);
          return 0;
        case 6: 
          localemx.LUc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101834);
          return 0;
        case 7: 
          localemx.LUd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101834);
          return 0;
        }
        localemx.LUg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(101834);
        return 0;
      }
      AppMethodBeat.o(101834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emx
 * JD-Core Version:    0.7.0.1
 */