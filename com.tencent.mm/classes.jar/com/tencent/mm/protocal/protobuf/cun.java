package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cun
  extends cvc
{
  public zb GCQ;
  public LinkedList<ahj> Hmj;
  public int Hmk;
  public int Hml;
  public LinkedList<yx> Hmm;
  public int Hmn;
  public long cbe;
  
  public cun()
  {
    AppMethodBeat.i(50105);
    this.Hmj = new LinkedList();
    this.Hmm = new LinkedList();
    AppMethodBeat.o(50105);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50106);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.cbe);
      paramVarArgs.e(3, 8, this.Hmj);
      paramVarArgs.aS(5, this.Hmk);
      paramVarArgs.aS(6, this.Hml);
      if (this.GCQ != null)
      {
        paramVarArgs.lC(7, this.GCQ.computeSize());
        this.GCQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.Hmm);
      paramVarArgs.aS(9, this.Hmn);
      AppMethodBeat.o(50106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.cbe) + f.a.a.a.c(3, 8, this.Hmj) + f.a.a.b.b.a.bz(5, this.Hmk) + f.a.a.b.b.a.bz(6, this.Hml);
      paramInt = i;
      if (this.GCQ != null) {
        paramInt = i + f.a.a.a.lB(7, this.GCQ.computeSize());
      }
      i = f.a.a.a.c(8, 8, this.Hmm);
      int j = f.a.a.b.b.a.bz(9, this.Hmn);
      AppMethodBeat.o(50106);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hmj.clear();
        this.Hmm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(50106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cun localcun = (cun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(50106);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcun.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 2: 
          localcun.cbe = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(50106);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcun.Hmj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 5: 
          localcun.Hmk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(50106);
          return 0;
        case 6: 
          localcun.Hml = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(50106);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcun.GCQ = ((zb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcun.Hmm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        }
        localcun.Hmn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(50106);
        return 0;
      }
      AppMethodBeat.o(50106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cun
 * JD-Core Version:    0.7.0.1
 */