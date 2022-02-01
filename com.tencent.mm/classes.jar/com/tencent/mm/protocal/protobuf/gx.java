package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gx
  extends com.tencent.mm.bx.a
{
  public String Fsp;
  public afp FyS;
  public SKBuiltinBuffer_t FyT;
  public SKBuiltinBuffer_t FyU;
  public int FyV;
  public SKBuiltinBuffer_t FyW;
  public eat FyX;
  public efs FyY;
  public SKBuiltinBuffer_t FyZ;
  public SKBuiltinBuffer_t Fza;
  public String Fzb;
  public SKBuiltinBuffer_t Fzc;
  public String Fzd;
  public deh Fze;
  public String Fzf;
  public int Fzg;
  public int Fzh;
  public int Fzi;
  public int Fzj;
  public int Fzk;
  public SKBuiltinBuffer_t Fzl;
  public SKBuiltinBuffer_t Fzm;
  public int Fzn;
  public int qdX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133145);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FyS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FyT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FyU == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.Fzl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.Fzm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.qdX);
      if (this.FyS != null)
      {
        paramVarArgs.lC(2, this.FyS.computeSize());
        this.FyS.writeFields(paramVarArgs);
      }
      if (this.FyT != null)
      {
        paramVarArgs.lC(3, this.FyT.computeSize());
        this.FyT.writeFields(paramVarArgs);
      }
      if (this.FyU != null)
      {
        paramVarArgs.lC(4, this.FyU.computeSize());
        this.FyU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.FyV);
      if (this.FyW != null)
      {
        paramVarArgs.lC(6, this.FyW.computeSize());
        this.FyW.writeFields(paramVarArgs);
      }
      if (this.FyX != null)
      {
        paramVarArgs.lC(7, this.FyX.computeSize());
        this.FyX.writeFields(paramVarArgs);
      }
      if (this.FyY != null)
      {
        paramVarArgs.lC(8, this.FyY.computeSize());
        this.FyY.writeFields(paramVarArgs);
      }
      if (this.FyZ != null)
      {
        paramVarArgs.lC(9, this.FyZ.computeSize());
        this.FyZ.writeFields(paramVarArgs);
      }
      if (this.Fza != null)
      {
        paramVarArgs.lC(10, this.Fza.computeSize());
        this.Fza.writeFields(paramVarArgs);
      }
      if (this.Fzb != null) {
        paramVarArgs.d(11, this.Fzb);
      }
      if (this.Fzc != null)
      {
        paramVarArgs.lC(12, this.Fzc.computeSize());
        this.Fzc.writeFields(paramVarArgs);
      }
      if (this.Fzd != null) {
        paramVarArgs.d(14, this.Fzd);
      }
      if (this.Fze != null)
      {
        paramVarArgs.lC(15, this.Fze.computeSize());
        this.Fze.writeFields(paramVarArgs);
      }
      if (this.Fzf != null) {
        paramVarArgs.d(16, this.Fzf);
      }
      paramVarArgs.aS(17, this.Fzg);
      paramVarArgs.aS(18, this.Fzh);
      paramVarArgs.aS(19, this.Fzi);
      if (this.Fsp != null) {
        paramVarArgs.d(20, this.Fsp);
      }
      paramVarArgs.aS(21, this.Fzj);
      paramVarArgs.aS(22, this.Fzk);
      if (this.Fzl != null)
      {
        paramVarArgs.lC(23, this.Fzl.computeSize());
        this.Fzl.writeFields(paramVarArgs);
      }
      if (this.Fzm != null)
      {
        paramVarArgs.lC(24, this.Fzm.computeSize());
        this.Fzm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(25, this.Fzn);
      AppMethodBeat.o(133145);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.qdX) + 0;
      paramInt = i;
      if (this.FyS != null) {
        paramInt = i + f.a.a.a.lB(2, this.FyS.computeSize());
      }
      i = paramInt;
      if (this.FyT != null) {
        i = paramInt + f.a.a.a.lB(3, this.FyT.computeSize());
      }
      paramInt = i;
      if (this.FyU != null) {
        paramInt = i + f.a.a.a.lB(4, this.FyU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FyV);
      paramInt = i;
      if (this.FyW != null) {
        paramInt = i + f.a.a.a.lB(6, this.FyW.computeSize());
      }
      i = paramInt;
      if (this.FyX != null) {
        i = paramInt + f.a.a.a.lB(7, this.FyX.computeSize());
      }
      paramInt = i;
      if (this.FyY != null) {
        paramInt = i + f.a.a.a.lB(8, this.FyY.computeSize());
      }
      i = paramInt;
      if (this.FyZ != null) {
        i = paramInt + f.a.a.a.lB(9, this.FyZ.computeSize());
      }
      paramInt = i;
      if (this.Fza != null) {
        paramInt = i + f.a.a.a.lB(10, this.Fza.computeSize());
      }
      i = paramInt;
      if (this.Fzb != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Fzb);
      }
      paramInt = i;
      if (this.Fzc != null) {
        paramInt = i + f.a.a.a.lB(12, this.Fzc.computeSize());
      }
      i = paramInt;
      if (this.Fzd != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Fzd);
      }
      paramInt = i;
      if (this.Fze != null) {
        paramInt = i + f.a.a.a.lB(15, this.Fze.computeSize());
      }
      i = paramInt;
      if (this.Fzf != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Fzf);
      }
      i = i + f.a.a.b.b.a.bz(17, this.Fzg) + f.a.a.b.b.a.bz(18, this.Fzh) + f.a.a.b.b.a.bz(19, this.Fzi);
      paramInt = i;
      if (this.Fsp != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.Fsp);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.Fzj) + f.a.a.b.b.a.bz(22, this.Fzk);
      paramInt = i;
      if (this.Fzl != null) {
        paramInt = i + f.a.a.a.lB(23, this.Fzl.computeSize());
      }
      i = paramInt;
      if (this.Fzm != null) {
        i = paramInt + f.a.a.a.lB(24, this.Fzm.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(25, this.Fzn);
      AppMethodBeat.o(133145);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FyS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SvrPubECDHKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FyT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.FyU == null)
      {
        paramVarArgs = new b("Not all required fields were included: AutoAuthKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.Fzl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      if (this.Fzm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerSessionKey");
        AppMethodBeat.o(133145);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133145);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      gx localgx = (gx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(133145);
        return -1;
      case 1: 
        localgx.qdX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FyS = ((afp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FyT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FyU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 5: 
        localgx.FyV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FyW = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eat();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FyX = ((eat)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new efs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((efs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FyY = ((efs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.FyZ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.Fza = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 11: 
        localgx.Fzb = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133145);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.Fzc = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 14: 
        localgx.Fzd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new deh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((deh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.Fze = ((deh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 16: 
        localgx.Fzf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 17: 
        localgx.Fzg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 18: 
        localgx.Fzh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 19: 
        localgx.Fzi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 20: 
        localgx.Fsp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133145);
        return 0;
      case 21: 
        localgx.Fzj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 22: 
        localgx.Fzk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133145);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.Fzl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgx.Fzm = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133145);
        return 0;
      }
      localgx.Fzn = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(133145);
      return 0;
    }
    AppMethodBeat.o(133145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gx
 * JD-Core Version:    0.7.0.1
 */