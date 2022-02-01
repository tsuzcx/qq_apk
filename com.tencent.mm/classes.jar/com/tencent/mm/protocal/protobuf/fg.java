package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class fg
  extends cvp
{
  public dr FxA;
  public LinkedList<bwb> FxB;
  public String FxC;
  public LinkedList<fu> Fxo;
  public int Fxp;
  public String Fxq;
  public int Fxr;
  public int Fxs;
  public int Fxt;
  public er Fxu;
  public dvu Fxv;
  public String Fxw;
  public bxp Fxx;
  public fc Fxy;
  public LinkedList<String> Fxz;
  public String hzm;
  public String url;
  
  public fg()
  {
    AppMethodBeat.i(103195);
    this.Fxo = new LinkedList();
    this.Fxz = new LinkedList();
    this.FxB = new LinkedList();
    AppMethodBeat.o(103195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103196);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Fxo);
      paramVarArgs.aS(3, this.Fxp);
      if (this.Fxq != null) {
        paramVarArgs.d(4, this.Fxq);
      }
      paramVarArgs.aS(5, this.Fxr);
      paramVarArgs.aS(6, this.Fxs);
      paramVarArgs.aS(7, this.Fxt);
      if (this.Fxu != null)
      {
        paramVarArgs.lC(8, this.Fxu.computeSize());
        this.Fxu.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(9, this.url);
      }
      if (this.hzm != null) {
        paramVarArgs.d(10, this.hzm);
      }
      if (this.Fxv != null)
      {
        paramVarArgs.lC(11, this.Fxv.computeSize());
        this.Fxv.writeFields(paramVarArgs);
      }
      if (this.Fxw != null) {
        paramVarArgs.d(12, this.Fxw);
      }
      if (this.Fxx != null)
      {
        paramVarArgs.lC(13, this.Fxx.computeSize());
        this.Fxx.writeFields(paramVarArgs);
      }
      if (this.Fxy != null)
      {
        paramVarArgs.lC(14, this.Fxy.computeSize());
        this.Fxy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 1, this.Fxz);
      if (this.FxA != null)
      {
        paramVarArgs.lC(16, this.FxA.computeSize());
        this.FxA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.FxB);
      if (this.FxC != null) {
        paramVarArgs.d(18, this.FxC);
      }
      AppMethodBeat.o(103196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1962;
      }
    }
    label1962:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Fxo) + f.a.a.b.b.a.bz(3, this.Fxp);
      paramInt = i;
      if (this.Fxq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fxq);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Fxr) + f.a.a.b.b.a.bz(6, this.Fxs) + f.a.a.b.b.a.bz(7, this.Fxt);
      paramInt = i;
      if (this.Fxu != null) {
        paramInt = i + f.a.a.a.lB(8, this.Fxu.computeSize());
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.url);
      }
      paramInt = i;
      if (this.hzm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hzm);
      }
      i = paramInt;
      if (this.Fxv != null) {
        i = paramInt + f.a.a.a.lB(11, this.Fxv.computeSize());
      }
      paramInt = i;
      if (this.Fxw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fxw);
      }
      i = paramInt;
      if (this.Fxx != null) {
        i = paramInt + f.a.a.a.lB(13, this.Fxx.computeSize());
      }
      paramInt = i;
      if (this.Fxy != null) {
        paramInt = i + f.a.a.a.lB(14, this.Fxy.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 1, this.Fxz);
      paramInt = i;
      if (this.FxA != null) {
        paramInt = i + f.a.a.a.lB(16, this.FxA.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.FxB);
      paramInt = i;
      if (this.FxC != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FxC);
      }
      AppMethodBeat.o(103196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fxo.clear();
        this.Fxz.clear();
        this.FxB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103196);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103196);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fg localfg = (fg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103196);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.Fxo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 3: 
          localfg.Fxp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 4: 
          localfg.Fxq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 5: 
          localfg.Fxr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 6: 
          localfg.Fxs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 7: 
          localfg.Fxt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103196);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new er();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((er)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.Fxu = ((er)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 9: 
          localfg.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 10: 
          localfg.hzm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.Fxv = ((dvu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 12: 
          localfg.Fxw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103196);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.Fxx = ((bxp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.Fxy = ((fc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 15: 
          localfg.Fxz.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(103196);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FxA = ((dr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfg.FxB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103196);
          return 0;
        }
        localfg.FxC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(103196);
        return 0;
      }
      AppMethodBeat.o(103196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fg
 * JD-Core Version:    0.7.0.1
 */