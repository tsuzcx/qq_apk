package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cv
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public cwt Fvi;
  public cwt Fvj;
  public cwt Fvk;
  public int Fvl;
  public SKBuiltinBuffer_t Fvm;
  public String Fvn;
  public String Fvo;
  public int Fvp;
  public int nDG;
  public int ugm;
  public int xbr;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133143);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Fvk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.xbr);
      if (this.Fvi != null)
      {
        paramVarArgs.lC(2, this.Fvi.computeSize());
        this.Fvi.writeFields(paramVarArgs);
      }
      if (this.Fvj != null)
      {
        paramVarArgs.lC(3, this.Fvj.computeSize());
        this.Fvj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.ugm);
      if (this.Fvk != null)
      {
        paramVarArgs.lC(5, this.Fvk.computeSize());
        this.Fvk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.nDG);
      paramVarArgs.aS(7, this.Fvl);
      if (this.Fvm != null)
      {
        paramVarArgs.lC(8, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.CreateTime);
      if (this.Fvn != null) {
        paramVarArgs.d(10, this.Fvn);
      }
      if (this.Fvo != null) {
        paramVarArgs.d(11, this.Fvo);
      }
      paramVarArgs.aY(12, this.xbt);
      paramVarArgs.aS(13, this.Fvp);
      AppMethodBeat.o(133143);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xbr) + 0;
      paramInt = i;
      if (this.Fvi != null) {
        paramInt = i + f.a.a.a.lB(2, this.Fvi.computeSize());
      }
      i = paramInt;
      if (this.Fvj != null) {
        i = paramInt + f.a.a.a.lB(3, this.Fvj.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.ugm);
      paramInt = i;
      if (this.Fvk != null) {
        paramInt = i + f.a.a.a.lB(5, this.Fvk.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.nDG) + f.a.a.b.b.a.bz(7, this.Fvl);
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.a.lB(8, this.Fvm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.CreateTime);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Fvn);
      }
      i = paramInt;
      if (this.Fvo != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Fvo);
      }
      paramInt = f.a.a.b.b.a.p(12, this.xbt);
      int j = f.a.a.b.b.a.bz(13, this.Fvp);
      AppMethodBeat.o(133143);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Fvk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133143);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cv localcv = (cv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133143);
        return -1;
      case 1: 
        localcv.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.Fvi = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.Fvj = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 4: 
        localcv.ugm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.Fvk = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 6: 
        localcv.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 7: 
        localcv.Fvl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcv.Fvm = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 9: 
        localcv.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133143);
        return 0;
      case 10: 
        localcv.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 11: 
        localcv.Fvo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 12: 
        localcv.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(133143);
        return 0;
      }
      localcv.Fvp = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(133143);
      return 0;
    }
    AppMethodBeat.o(133143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cv
 * JD-Core Version:    0.7.0.1
 */