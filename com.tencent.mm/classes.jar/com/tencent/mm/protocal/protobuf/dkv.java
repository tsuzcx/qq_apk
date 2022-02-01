package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dkv
  extends cvc
{
  public b Buffer;
  public String FGE;
  public int FGO;
  public int FJz;
  public int Hzl;
  public int Hzq;
  public String Hzr;
  public clb Hzs;
  public int Scene;
  public String iht;
  public LinkedList<dku> ugO;
  
  public dkv()
  {
    AppMethodBeat.i(152704);
    this.ugO = new LinkedList();
    AppMethodBeat.o(152704);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FGE != null) {
        paramVarArgs.d(2, this.FGE);
      }
      paramVarArgs.aS(3, this.FJz);
      paramVarArgs.e(4, 8, this.ugO);
      paramVarArgs.aS(5, this.Hzq);
      if (this.iht != null) {
        paramVarArgs.d(6, this.iht);
      }
      paramVarArgs.aS(7, this.FGO);
      paramVarArgs.aS(8, this.Hzl);
      if (this.Hzr != null) {
        paramVarArgs.d(9, this.Hzr);
      }
      if (this.Buffer != null) {
        paramVarArgs.c(10, this.Buffer);
      }
      if (this.Hzs != null)
      {
        paramVarArgs.lC(11, this.Hzs.computeSize());
        this.Hzs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.Scene);
      AppMethodBeat.o(152705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FGE != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FGE);
      }
      i = i + f.a.a.b.b.a.bz(3, this.FJz) + f.a.a.a.c(4, 8, this.ugO) + f.a.a.b.b.a.bz(5, this.Hzq);
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iht);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FGO) + f.a.a.b.b.a.bz(8, this.Hzl);
      paramInt = i;
      if (this.Hzr != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hzr);
      }
      i = paramInt;
      if (this.Buffer != null) {
        i = paramInt + f.a.a.b.b.a.b(10, this.Buffer);
      }
      paramInt = i;
      if (this.Hzs != null) {
        paramInt = i + f.a.a.a.lB(11, this.Hzs.computeSize());
      }
      i = f.a.a.b.b.a.bz(12, this.Scene);
      AppMethodBeat.o(152705);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ugO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkv localdkv = (dkv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152705);
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
            localdkv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 2: 
          localdkv.FGE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 3: 
          localdkv.FJz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dku();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dku)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkv.ugO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        case 5: 
          localdkv.Hzq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 6: 
          localdkv.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 7: 
          localdkv.FGO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 8: 
          localdkv.Hzl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152705);
          return 0;
        case 9: 
          localdkv.Hzr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152705);
          return 0;
        case 10: 
          localdkv.Buffer = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(152705);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkv.Hzs = ((clb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152705);
          return 0;
        }
        localdkv.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152705);
        return 0;
      }
      AppMethodBeat.o(152705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkv
 * JD-Core Version:    0.7.0.1
 */