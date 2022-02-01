package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbj
  extends cpx
{
  public long FKv;
  public int OpCode;
  public int Scene;
  public int ncL;
  public LinkedList<crm> ncM;
  public String tkJ;
  
  public dbj()
  {
    AppMethodBeat.i(125821);
    this.ncM = new LinkedList();
    AppMethodBeat.o(125821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.aO(3, this.FKv);
      if (this.tkJ != null) {
        paramVarArgs.d(4, this.tkJ);
      }
      paramVarArgs.aR(5, this.ncL);
      paramVarArgs.e(6, 8, this.ncM);
      paramVarArgs.aR(7, this.Scene);
      AppMethodBeat.o(125822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.OpCode) + f.a.a.b.b.a.p(3, this.FKv);
      paramInt = i;
      if (this.tkJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tkJ);
      }
      i = f.a.a.b.b.a.bx(5, this.ncL);
      int j = f.a.a.a.c(6, 8, this.ncM);
      int k = f.a.a.b.b.a.bx(7, this.Scene);
      AppMethodBeat.o(125822);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ncM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbj localdbj = (dbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125822);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        case 2: 
          localdbj.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125822);
          return 0;
        case 3: 
          localdbj.FKv = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125822);
          return 0;
        case 4: 
          localdbj.tkJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125822);
          return 0;
        case 5: 
          localdbj.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125822);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbj.ncM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        }
        localdbj.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125822);
        return 0;
      }
      AppMethodBeat.o(125822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbj
 * JD-Core Version:    0.7.0.1
 */