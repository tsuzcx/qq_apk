package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azb
  extends cvw
{
  public String FJN;
  public String FJO;
  public int FJP;
  public LinkedList<th> FJS;
  public String GPt;
  public int dJd;
  public String pqK;
  public String prs;
  public String sign;
  
  public azb()
  {
    AppMethodBeat.i(114012);
    this.FJS = new LinkedList();
    AppMethodBeat.o(114012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FJS);
      paramVarArgs.aS(3, this.dJd);
      if (this.prs != null) {
        paramVarArgs.d(4, this.prs);
      }
      if (this.pqK != null) {
        paramVarArgs.d(5, this.pqK);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.FJN != null) {
        paramVarArgs.d(7, this.FJN);
      }
      if (this.FJO != null) {
        paramVarArgs.d(8, this.FJO);
      }
      if (this.GPt != null) {
        paramVarArgs.d(9, this.GPt);
      }
      paramVarArgs.aS(10, this.FJP);
      AppMethodBeat.o(114013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FJS) + f.a.a.b.b.a.bz(3, this.dJd);
      paramInt = i;
      if (this.prs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.prs);
      }
      i = paramInt;
      if (this.pqK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pqK);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.FJN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FJN);
      }
      paramInt = i;
      if (this.FJO != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FJO);
      }
      i = paramInt;
      if (this.GPt != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GPt);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FJP);
      AppMethodBeat.o(114013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azb localazb = (azb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114013);
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
            localazb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new th();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((th)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazb.FJS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 3: 
          localazb.dJd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114013);
          return 0;
        case 4: 
          localazb.prs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 5: 
          localazb.pqK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 6: 
          localazb.sign = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 7: 
          localazb.FJN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 8: 
          localazb.FJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 9: 
          localazb.GPt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114013);
          return 0;
        }
        localazb.FJP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(114013);
        return 0;
      }
      AppMethodBeat.o(114013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azb
 * JD-Core Version:    0.7.0.1
 */