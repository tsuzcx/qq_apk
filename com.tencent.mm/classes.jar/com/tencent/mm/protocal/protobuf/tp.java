package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tp
  extends buy
{
  public int scene;
  public int wMf;
  public String wMg;
  public LinkedList<to> wMh;
  public int wMi;
  public caf wMj;
  public cbg wMk;
  public String woU;
  public String wxM;
  
  public tp()
  {
    AppMethodBeat.i(11737);
    this.wMh = new LinkedList();
    AppMethodBeat.o(11737);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11738);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wMf);
      if (this.wMg != null) {
        paramVarArgs.e(3, this.wMg);
      }
      if (this.wxM != null) {
        paramVarArgs.e(4, this.wxM);
      }
      if (this.woU != null) {
        paramVarArgs.e(5, this.woU);
      }
      paramVarArgs.e(6, 8, this.wMh);
      paramVarArgs.aO(7, this.scene);
      paramVarArgs.aO(8, this.wMi);
      if (this.wMj != null)
      {
        paramVarArgs.iQ(9, this.wMj.computeSize());
        this.wMj.writeFields(paramVarArgs);
      }
      if (this.wMk != null)
      {
        paramVarArgs.iQ(10, this.wMk.computeSize());
        this.wMk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(11738);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wMf);
      paramInt = i;
      if (this.wMg != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wMg);
      }
      i = paramInt;
      if (this.wxM != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wxM);
      }
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.woU);
      }
      i = paramInt + e.a.a.a.c(6, 8, this.wMh) + e.a.a.b.b.a.bl(7, this.scene) + e.a.a.b.b.a.bl(8, this.wMi);
      paramInt = i;
      if (this.wMj != null) {
        paramInt = i + e.a.a.a.iP(9, this.wMj.computeSize());
      }
      i = paramInt;
      if (this.wMk != null) {
        i = paramInt + e.a.a.a.iP(10, this.wMk.computeSize());
      }
      AppMethodBeat.o(11738);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wMh.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11738);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        tp localtp = (tp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11738);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localtp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11738);
          return 0;
        case 2: 
          localtp.wMf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11738);
          return 0;
        case 3: 
          localtp.wMg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11738);
          return 0;
        case 4: 
          localtp.wxM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11738);
          return 0;
        case 5: 
          localtp.woU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11738);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new to();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((to)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localtp.wMh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11738);
          return 0;
        case 7: 
          localtp.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11738);
          return 0;
        case 8: 
          localtp.wMi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11738);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localtp.wMj = ((caf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11738);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localtp.wMk = ((cbg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(11738);
        return 0;
      }
      AppMethodBeat.o(11738);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tp
 * JD-Core Version:    0.7.0.1
 */