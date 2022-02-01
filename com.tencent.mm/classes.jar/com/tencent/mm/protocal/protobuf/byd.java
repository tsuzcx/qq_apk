package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byd
  extends cvc
{
  public int FOx;
  public int FOy;
  public int GAB;
  public String GRY;
  public String GRZ;
  public String GSa;
  public int GSb;
  public SKBuiltinBuffer_t GSc;
  public int GSd;
  public int GSe;
  public int GSf;
  public int GSg;
  public SKBuiltinBuffer_t GSh;
  public int GSi;
  public int GSj;
  public int GSk;
  public int GSl;
  public int GSm;
  public String GSn;
  public String GSo;
  public String ThumbUrl;
  public int ugm;
  public String uht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GSc == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.GSh == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GRY != null) {
        paramVarArgs.d(2, this.GRY);
      }
      if (this.GRZ != null) {
        paramVarArgs.d(3, this.GRZ);
      }
      if (this.GSa != null) {
        paramVarArgs.d(4, this.GSa);
      }
      paramVarArgs.aS(5, this.ugm);
      paramVarArgs.aS(6, this.GSb);
      if (this.GSc != null)
      {
        paramVarArgs.lC(7, this.GSc.computeSize());
        this.GSc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GSd);
      paramVarArgs.aS(9, this.GSe);
      paramVarArgs.aS(10, this.GSf);
      paramVarArgs.aS(11, this.GSg);
      if (this.GSh != null)
      {
        paramVarArgs.lC(12, this.GSh.computeSize());
        this.GSh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.GSi);
      paramVarArgs.aS(14, this.GSj);
      paramVarArgs.aS(15, this.GSk);
      paramVarArgs.aS(16, this.GSl);
      paramVarArgs.aS(17, this.GAB);
      paramVarArgs.aS(18, this.GSm);
      if (this.uht != null) {
        paramVarArgs.d(19, this.uht);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(20, this.ThumbUrl);
      }
      paramVarArgs.aS(21, this.FOy);
      paramVarArgs.aS(22, this.FOx);
      if (this.GSn != null) {
        paramVarArgs.d(23, this.GSn);
      }
      if (this.GSo != null) {
        paramVarArgs.d(24, this.GSo);
      }
      AppMethodBeat.o(32345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1804;
      }
    }
    label1804:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GRY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GRY);
      }
      i = paramInt;
      if (this.GRZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GRZ);
      }
      paramInt = i;
      if (this.GSa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GSa);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.ugm) + f.a.a.b.b.a.bz(6, this.GSb);
      paramInt = i;
      if (this.GSc != null) {
        paramInt = i + f.a.a.a.lB(7, this.GSc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GSd) + f.a.a.b.b.a.bz(9, this.GSe) + f.a.a.b.b.a.bz(10, this.GSf) + f.a.a.b.b.a.bz(11, this.GSg);
      paramInt = i;
      if (this.GSh != null) {
        paramInt = i + f.a.a.a.lB(12, this.GSh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.GSi) + f.a.a.b.b.a.bz(14, this.GSj) + f.a.a.b.b.a.bz(15, this.GSk) + f.a.a.b.b.a.bz(16, this.GSl) + f.a.a.b.b.a.bz(17, this.GAB) + f.a.a.b.b.a.bz(18, this.GSm);
      paramInt = i;
      if (this.uht != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.uht);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bz(21, this.FOy) + f.a.a.b.b.a.bz(22, this.FOx);
      paramInt = i;
      if (this.GSn != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.GSn);
      }
      i = paramInt;
      if (this.GSo != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.GSo);
      }
      AppMethodBeat.o(32345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GSc == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        if (this.GSh == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byd localbyd = (byd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32345);
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
            localbyd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 2: 
          localbyd.GRY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 3: 
          localbyd.GRZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 4: 
          localbyd.GSa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 5: 
          localbyd.ugm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 6: 
          localbyd.GSb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyd.GSc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 8: 
          localbyd.GSd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 9: 
          localbyd.GSe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 10: 
          localbyd.GSf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 11: 
          localbyd.GSg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyd.GSh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 13: 
          localbyd.GSi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 14: 
          localbyd.GSj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 15: 
          localbyd.GSk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 16: 
          localbyd.GSl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 17: 
          localbyd.GAB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 18: 
          localbyd.GSm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 19: 
          localbyd.uht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 20: 
          localbyd.ThumbUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 21: 
          localbyd.FOy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 22: 
          localbyd.FOx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 23: 
          localbyd.GSn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32345);
          return 0;
        }
        localbyd.GSo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32345);
        return 0;
      }
      AppMethodBeat.o(32345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byd
 * JD-Core Version:    0.7.0.1
 */