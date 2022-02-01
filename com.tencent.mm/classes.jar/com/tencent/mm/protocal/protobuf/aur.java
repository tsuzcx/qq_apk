package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aur
  extends cvc
{
  public String FDD;
  public bb FPa;
  public String FWa;
  public String FXe;
  public String FXf;
  public String FXg;
  public String FXh;
  public int FqH;
  public String GsQ;
  public String GsT;
  public String GsU;
  public int GsV;
  public String GsW;
  public int Scene;
  public String iht;
  public String ukw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.FXe != null) {
        paramVarArgs.d(3, this.FXe);
      }
      if (this.FDD != null) {
        paramVarArgs.d(4, this.FDD);
      }
      if (this.FXf != null) {
        paramVarArgs.d(5, this.FXf);
      }
      if (this.FXg != null) {
        paramVarArgs.d(6, this.FXg);
      }
      if (this.FXh != null) {
        paramVarArgs.d(7, this.FXh);
      }
      if (this.FWa != null) {
        paramVarArgs.d(8, this.FWa);
      }
      if (this.GsQ != null) {
        paramVarArgs.d(9, this.GsQ);
      }
      paramVarArgs.aS(10, this.FqH);
      if (this.ukw != null) {
        paramVarArgs.d(11, this.ukw);
      }
      if (this.GsT != null) {
        paramVarArgs.d(12, this.GsT);
      }
      if (this.GsU != null) {
        paramVarArgs.d(13, this.GsU);
      }
      if (this.FPa != null)
      {
        paramVarArgs.lC(14, this.FPa.computeSize());
        this.FPa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.Scene);
      paramVarArgs.aS(16, this.GsV);
      if (this.GsW != null) {
        paramVarArgs.d(17, this.GsW);
      }
      AppMethodBeat.o(91473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1338;
      }
    }
    label1338:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.FXe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FXe);
      }
      paramInt = i;
      if (this.FDD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDD);
      }
      i = paramInt;
      if (this.FXf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FXf);
      }
      paramInt = i;
      if (this.FXg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FXg);
      }
      i = paramInt;
      if (this.FXh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FXh);
      }
      paramInt = i;
      if (this.FWa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FWa);
      }
      i = paramInt;
      if (this.GsQ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GsQ);
      }
      i += f.a.a.b.b.a.bz(10, this.FqH);
      paramInt = i;
      if (this.ukw != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ukw);
      }
      i = paramInt;
      if (this.GsT != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GsT);
      }
      paramInt = i;
      if (this.GsU != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GsU);
      }
      i = paramInt;
      if (this.FPa != null) {
        i = paramInt + f.a.a.a.lB(14, this.FPa.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(15, this.Scene) + f.a.a.b.b.a.bz(16, this.GsV);
      paramInt = i;
      if (this.GsW != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GsW);
      }
      AppMethodBeat.o(91473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aur localaur = (aur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91473);
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
            localaur.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 2: 
          localaur.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 3: 
          localaur.FXe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 4: 
          localaur.FDD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 5: 
          localaur.FXf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 6: 
          localaur.FXg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 7: 
          localaur.FXh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 8: 
          localaur.FWa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 9: 
          localaur.GsQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 10: 
          localaur.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91473);
          return 0;
        case 11: 
          localaur.ukw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 12: 
          localaur.GsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 13: 
          localaur.GsU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaur.FPa = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 15: 
          localaur.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91473);
          return 0;
        case 16: 
          localaur.GsV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91473);
          return 0;
        }
        localaur.GsW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91473);
        return 0;
      }
      AppMethodBeat.o(91473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aur
 * JD-Core Version:    0.7.0.1
 */