package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsh
  extends cvc
{
  public int HEZ;
  public int HFa;
  public String HFb;
  public int HFc;
  public String HFd;
  public LinkedList<dhz> HFe;
  public int HFf;
  public int HFg;
  public String Hpc;
  public String cUi;
  public int cbX;
  public String dow;
  public String hBg;
  
  public dsh()
  {
    AppMethodBeat.i(116818);
    this.HFe = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cUi != null) {
        paramVarArgs.d(2, this.cUi);
      }
      if (this.dow != null) {
        paramVarArgs.d(3, this.dow);
      }
      paramVarArgs.aS(4, this.HEZ);
      paramVarArgs.aS(5, this.HFa);
      paramVarArgs.aS(6, this.cbX);
      if (this.HFb != null) {
        paramVarArgs.d(7, this.HFb);
      }
      if (this.Hpc != null) {
        paramVarArgs.d(8, this.Hpc);
      }
      if (this.hBg != null) {
        paramVarArgs.d(9, this.hBg);
      }
      paramVarArgs.aS(10, this.HFc);
      if (this.HFd != null) {
        paramVarArgs.d(11, this.HFd);
      }
      paramVarArgs.e(12, 8, this.HFe);
      paramVarArgs.aS(13, this.HFf);
      paramVarArgs.aS(14, this.HFg);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cUi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cUi);
      }
      i = paramInt;
      if (this.dow != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dow);
      }
      i = i + f.a.a.b.b.a.bz(4, this.HEZ) + f.a.a.b.b.a.bz(5, this.HFa) + f.a.a.b.b.a.bz(6, this.cbX);
      paramInt = i;
      if (this.HFb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HFb);
      }
      i = paramInt;
      if (this.Hpc != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hpc);
      }
      paramInt = i;
      if (this.hBg != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hBg);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.HFc);
      paramInt = i;
      if (this.HFd != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HFd);
      }
      i = f.a.a.a.c(12, 8, this.HFe);
      int j = f.a.a.b.b.a.bz(13, this.HFf);
      int k = f.a.a.b.b.a.bz(14, this.HFg);
      AppMethodBeat.o(116819);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HFe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsh localdsh = (dsh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
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
            localdsh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          localdsh.cUi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localdsh.dow = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localdsh.HEZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localdsh.HFa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localdsh.cbX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localdsh.HFb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localdsh.Hpc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          localdsh.hBg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          localdsh.HFc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localdsh.HFd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsh.HFe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 13: 
          localdsh.HFf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(116819);
          return 0;
        }
        localdsh.HFg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsh
 * JD-Core Version:    0.7.0.1
 */