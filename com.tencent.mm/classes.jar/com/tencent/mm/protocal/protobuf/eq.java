package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eq
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String Fvn;
  public int Fws;
  public String Fwt;
  public SKBuiltinBuffer_t Fwu;
  public int Fwv;
  public String Fww;
  public String Fwx;
  public String Fwy;
  public int Fwz;
  public String hDa;
  public String iht;
  public int nEf;
  public int tRT;
  public String ufi;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32116);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ukj != null) {
        paramVarArgs.d(1, this.ukj);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      paramVarArgs.aS(3, this.Fws);
      if (this.uki != null) {
        paramVarArgs.d(4, this.uki);
      }
      paramVarArgs.aS(5, this.nEf);
      if (this.hDa != null) {
        paramVarArgs.d(6, this.hDa);
      }
      paramVarArgs.aS(7, this.CreateTime);
      if (this.Fwt != null) {
        paramVarArgs.d(8, this.Fwt);
      }
      if (this.Fwu != null)
      {
        paramVarArgs.lC(9, this.Fwu.computeSize());
        this.Fwu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.tRT);
      paramVarArgs.aS(11, this.Fwv);
      if (this.Fvn != null) {
        paramVarArgs.d(12, this.Fvn);
      }
      if (this.Fww != null) {
        paramVarArgs.d(13, this.Fww);
      }
      if (this.Fwx != null) {
        paramVarArgs.d(14, this.Fwx);
      }
      if (this.Fwy != null) {
        paramVarArgs.d(15, this.Fwy);
      }
      paramVarArgs.aS(16, this.Fwz);
      if (this.ufi != null) {
        paramVarArgs.d(17, this.ufi);
      }
      AppMethodBeat.o(32116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ukj == null) {
        break label1221;
      }
    }
    label1221:
    for (paramInt = f.a.a.b.b.a.e(1, this.ukj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iht);
      }
      i += f.a.a.b.b.a.bz(3, this.Fws);
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uki);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nEf);
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hDa);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.CreateTime);
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fwt);
      }
      i = paramInt;
      if (this.Fwu != null) {
        i = paramInt + f.a.a.a.lB(9, this.Fwu.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(10, this.tRT) + f.a.a.b.b.a.bz(11, this.Fwv);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fvn);
      }
      i = paramInt;
      if (this.Fww != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Fww);
      }
      paramInt = i;
      if (this.Fwx != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Fwx);
      }
      i = paramInt;
      if (this.Fwy != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Fwy);
      }
      i += f.a.a.b.b.a.bz(16, this.Fwz);
      paramInt = i;
      if (this.ufi != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.ufi);
      }
      AppMethodBeat.o(32116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32116);
          return -1;
        case 1: 
          localeq.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 2: 
          localeq.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 3: 
          localeq.Fws = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 4: 
          localeq.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 5: 
          localeq.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 6: 
          localeq.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 7: 
          localeq.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 8: 
          localeq.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeq.Fwu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32116);
          return 0;
        case 10: 
          localeq.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 11: 
          localeq.Fwv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 12: 
          localeq.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 13: 
          localeq.Fww = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 14: 
          localeq.Fwx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 15: 
          localeq.Fwy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 16: 
          localeq.Fwz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32116);
          return 0;
        }
        localeq.ufi = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32116);
        return 0;
      }
      AppMethodBeat.o(32116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */