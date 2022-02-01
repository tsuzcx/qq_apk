package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bea
  extends cvp
{
  public LinkedList<st> FQp;
  public tg GAl;
  public String GAm;
  public String GAn;
  public int GwY;
  public tg Gxa;
  public String Gxb;
  public int Gxc;
  public int Gxd;
  public tp Gxe;
  public int ozR;
  public String ozS;
  public int pjW;
  
  public bea()
  {
    AppMethodBeat.i(215418);
    this.FQp = new LinkedList();
    AppMethodBeat.o(215418);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(215419);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aS(4, this.pjW);
      paramVarArgs.aS(5, this.GwY);
      paramVarArgs.e(6, 8, this.FQp);
      if (this.Gxe != null)
      {
        paramVarArgs.lC(7, this.Gxe.computeSize());
        this.Gxe.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.Gxc);
      paramVarArgs.aS(9, this.Gxd);
      if (this.Gxa != null)
      {
        paramVarArgs.lC(10, this.Gxa.computeSize());
        this.Gxa.writeFields(paramVarArgs);
      }
      if (this.Gxb != null) {
        paramVarArgs.d(11, this.Gxb);
      }
      if (this.GAl != null)
      {
        paramVarArgs.lC(12, this.GAl.computeSize());
        this.GAl.writeFields(paramVarArgs);
      }
      if (this.GAm != null) {
        paramVarArgs.d(13, this.GAm);
      }
      if (this.GAn != null) {
        paramVarArgs.d(14, this.GAn);
      }
      AppMethodBeat.o(215419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.pjW) + f.a.a.b.b.a.bz(5, this.GwY) + f.a.a.a.c(6, 8, this.FQp);
      paramInt = i;
      if (this.Gxe != null) {
        paramInt = i + f.a.a.a.lB(7, this.Gxe.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Gxc) + f.a.a.b.b.a.bz(9, this.Gxd);
      paramInt = i;
      if (this.Gxa != null) {
        paramInt = i + f.a.a.a.lB(10, this.Gxa.computeSize());
      }
      i = paramInt;
      if (this.Gxb != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Gxb);
      }
      paramInt = i;
      if (this.GAl != null) {
        paramInt = i + f.a.a.a.lB(12, this.GAl.computeSize());
      }
      i = paramInt;
      if (this.GAm != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GAm);
      }
      paramInt = i;
      if (this.GAn != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GAn);
      }
      AppMethodBeat.o(215419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FQp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(215419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bea localbea = (bea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215419);
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
            localbea.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215419);
          return 0;
        case 2: 
          localbea.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215419);
          return 0;
        case 3: 
          localbea.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215419);
          return 0;
        case 4: 
          localbea.pjW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215419);
          return 0;
        case 5: 
          localbea.GwY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215419);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new st();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((st)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbea.FQp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215419);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbea.Gxe = ((tp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215419);
          return 0;
        case 8: 
          localbea.Gxc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215419);
          return 0;
        case 9: 
          localbea.Gxd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215419);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbea.Gxa = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215419);
          return 0;
        case 11: 
          localbea.Gxb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215419);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbea.GAl = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215419);
          return 0;
        case 13: 
          localbea.GAm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215419);
          return 0;
        }
        localbea.GAn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215419);
        return 0;
      }
      AppMethodBeat.o(215419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bea
 * JD-Core Version:    0.7.0.1
 */