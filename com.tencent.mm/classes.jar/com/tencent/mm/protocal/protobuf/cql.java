package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cql
  extends cvw
{
  public iy Gpj;
  public int Gqn;
  public int Gqo;
  public int HCd;
  public b HCe;
  public b HCf;
  public b HCg;
  public int HCh;
  public cqm HCi;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gpj != null)
      {
        paramVarArgs.lJ(2, this.Gpj.computeSize());
        this.Gpj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HCd);
      if (this.HCe != null) {
        paramVarArgs.c(4, this.HCe);
      }
      if (this.HCf != null) {
        paramVarArgs.c(5, this.HCf);
      }
      if (this.HCg != null) {
        paramVarArgs.c(6, this.HCg);
      }
      paramVarArgs.aS(7, this.Gqo);
      paramVarArgs.aS(8, this.Gqn);
      paramVarArgs.aS(9, this.HCh);
      paramVarArgs.aZ(10, this.timestamp);
      if (this.HCi != null)
      {
        paramVarArgs.lJ(11, this.HCi.computeSize());
        this.HCi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gpj != null) {
        i = paramInt + f.a.a.a.lI(2, this.Gpj.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.HCd);
      paramInt = i;
      if (this.HCe != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HCe);
      }
      i = paramInt;
      if (this.HCf != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.HCf);
      }
      paramInt = i;
      if (this.HCg != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.HCg);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Gqo) + f.a.a.b.b.a.bz(8, this.Gqn) + f.a.a.b.b.a.bz(9, this.HCh) + f.a.a.b.b.a.p(10, this.timestamp);
      paramInt = i;
      if (this.HCi != null) {
        paramInt = i + f.a.a.a.lI(11, this.HCi.computeSize());
      }
      AppMethodBeat.o(91653);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cql localcql = (cql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91653);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcql.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcql.Gpj = ((iy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91653);
          return 0;
        case 3: 
          localcql.HCd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 4: 
          localcql.HCe = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91653);
          return 0;
        case 5: 
          localcql.HCf = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91653);
          return 0;
        case 6: 
          localcql.HCg = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(91653);
          return 0;
        case 7: 
          localcql.Gqo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 8: 
          localcql.Gqn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 9: 
          localcql.HCh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91653);
          return 0;
        case 10: 
          localcql.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcql.HCi = ((cqm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91653);
        return 0;
      }
      AppMethodBeat.o(91653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cql
 * JD-Core Version:    0.7.0.1
 */