package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fex
  extends dyl
{
  public int Svu;
  public long Svv;
  public String TWw;
  public long UCJ;
  public ffd UDE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115911);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UDE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115911);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWw != null) {
        paramVarArgs.f(2, this.TWw);
      }
      paramVarArgs.aY(3, this.Svu);
      paramVarArgs.bm(4, this.Svv);
      if (this.UDE != null)
      {
        paramVarArgs.oE(5, this.UDE.computeSize());
        this.UDE.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.UCJ);
      AppMethodBeat.o(115911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TWw != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TWw);
      }
      i = i + g.a.a.b.b.a.bM(3, this.Svu) + g.a.a.b.b.a.p(4, this.Svv);
      paramInt = i;
      if (this.UDE != null) {
        paramInt = i + g.a.a.a.oD(5, this.UDE.computeSize());
      }
      i = g.a.a.b.b.a.p(6, this.UCJ);
      AppMethodBeat.o(115911);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UDE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fex localfex = (fex)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115911);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfex.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        case 2: 
          localfex.TWw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115911);
          return 0;
        case 3: 
          localfex.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115911);
          return 0;
        case 4: 
          localfex.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115911);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffd)localObject2).parseFrom((byte[])localObject1);
            }
            localfex.UDE = ((ffd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115911);
          return 0;
        }
        localfex.UCJ = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(115911);
        return 0;
      }
      AppMethodBeat.o(115911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fex
 * JD-Core Version:    0.7.0.1
 */