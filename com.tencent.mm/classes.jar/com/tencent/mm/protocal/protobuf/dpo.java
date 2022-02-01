package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpo
  extends dyl
{
  public int Svu;
  public long Svv;
  public long TVZ;
  public long TWc;
  public String TWw;
  public int TWx;
  public int TWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TWw == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUsername");
        AppMethodBeat.o(32390);
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
      paramVarArgs.bm(5, this.TVZ);
      paramVarArgs.aY(6, this.TWx);
      paramVarArgs.bm(7, this.TWc);
      paramVarArgs.aY(8, this.TWy);
      AppMethodBeat.o(32390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TWw != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TWw);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Svu);
      int j = g.a.a.b.b.a.p(4, this.Svv);
      int k = g.a.a.b.b.a.p(5, this.TVZ);
      int m = g.a.a.b.b.a.bM(6, this.TWx);
      int n = g.a.a.b.b.a.p(7, this.TWc);
      int i1 = g.a.a.b.b.a.bM(8, this.TWy);
      AppMethodBeat.o(32390);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TWw == null)
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dpo localdpo = (dpo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32390);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdpo.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32390);
          return 0;
        case 2: 
          localdpo.TWw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32390);
          return 0;
        case 3: 
          localdpo.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32390);
          return 0;
        case 4: 
          localdpo.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32390);
          return 0;
        case 5: 
          localdpo.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32390);
          return 0;
        case 6: 
          localdpo.TWx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32390);
          return 0;
        case 7: 
          localdpo.TWc = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32390);
          return 0;
        }
        localdpo.TWy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32390);
        return 0;
      }
      AppMethodBeat.o(32390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpo
 * JD-Core Version:    0.7.0.1
 */