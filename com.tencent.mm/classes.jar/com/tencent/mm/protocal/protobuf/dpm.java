package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpm
  extends dyl
{
  public String CRR;
  public int Svu;
  public long Svv;
  public long TVZ;
  public long TWc;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32388);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRR == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32388);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CRR != null) {
        paramVarArgs.f(2, this.CRR);
      }
      paramVarArgs.aY(3, this.Svu);
      paramVarArgs.bm(4, this.Svv);
      paramVarArgs.bm(5, this.TVZ);
      paramVarArgs.bm(6, this.TWc);
      paramVarArgs.aY(7, this.rVU);
      AppMethodBeat.o(32388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CRR != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CRR);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Svu);
      int j = g.a.a.b.b.a.p(4, this.Svv);
      int k = g.a.a.b.b.a.p(5, this.TVZ);
      int m = g.a.a.b.b.a.p(6, this.TWc);
      int n = g.a.a.b.b.a.bM(7, this.rVU);
      AppMethodBeat.o(32388);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CRR == null)
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dpm localdpm = (dpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32388);
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
            localdpm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32388);
          return 0;
        case 2: 
          localdpm.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32388);
          return 0;
        case 3: 
          localdpm.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32388);
          return 0;
        case 4: 
          localdpm.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32388);
          return 0;
        case 5: 
          localdpm.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32388);
          return 0;
        case 6: 
          localdpm.TWc = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32388);
          return 0;
        }
        localdpm.rVU = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32388);
        return 0;
      }
      AppMethodBeat.o(32388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpm
 * JD-Core Version:    0.7.0.1
 */