package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class mh
  extends cvc
{
  public int FBz;
  public b FEU;
  public long FFa;
  public GoodsObject FFd;
  public mc FFg;
  public mj FFu;
  public long FFv;
  public String FFw;
  public String FFx;
  public int mode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FEU != null) {
        paramVarArgs.c(2, this.FEU);
      }
      paramVarArgs.aS(12, this.mode);
      paramVarArgs.aY(18, this.FFa);
      if (this.FFd != null)
      {
        paramVarArgs.lC(21, this.FFd.computeSize());
        this.FFd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.FBz);
      if (this.FFu != null)
      {
        paramVarArgs.lC(23, this.FFu.computeSize());
        this.FFu.writeFields(paramVarArgs);
      }
      if (this.FFg != null)
      {
        paramVarArgs.lC(26, this.FFg.computeSize());
        this.FFg.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(27, this.FFv);
      if (this.FFw != null) {
        paramVarArgs.d(28, this.FFw);
      }
      if (this.FFx != null) {
        paramVarArgs.d(29, this.FFx);
      }
      AppMethodBeat.o(207219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FEU != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FEU);
      }
      i = i + f.a.a.b.b.a.bz(12, this.mode) + f.a.a.b.b.a.p(18, this.FFa);
      paramInt = i;
      if (this.FFd != null) {
        paramInt = i + f.a.a.a.lB(21, this.FFd.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.FBz);
      paramInt = i;
      if (this.FFu != null) {
        paramInt = i + f.a.a.a.lB(23, this.FFu.computeSize());
      }
      i = paramInt;
      if (this.FFg != null) {
        i = paramInt + f.a.a.a.lB(26, this.FFg.computeSize());
      }
      i += f.a.a.b.b.a.p(27, this.FFv);
      paramInt = i;
      if (this.FFw != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.FFw);
      }
      i = paramInt;
      if (this.FFx != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.FFx);
      }
      AppMethodBeat.o(207219);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207219);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207219);
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
            localmh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207219);
          return 0;
        case 2: 
          localmh.FEU = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(207219);
          return 0;
        case 12: 
          localmh.mode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207219);
          return 0;
        case 18: 
          localmh.FFa = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(207219);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmh.FFd = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207219);
          return 0;
        case 22: 
          localmh.FBz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207219);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmh.FFu = ((mj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207219);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmh.FFg = ((mc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207219);
          return 0;
        case 27: 
          localmh.FFv = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(207219);
          return 0;
        case 28: 
          localmh.FFw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207219);
          return 0;
        }
        localmh.FFx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207219);
        return 0;
      }
      AppMethodBeat.o(207219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */