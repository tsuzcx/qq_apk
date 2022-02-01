package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cha
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t Fwu;
  public SKBuiltinBuffer_t HaC;
  public String Md5;
  public String Name;
  public String PackName;
  public int Version;
  public int nEa;
  public int ukh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ukh);
      paramVarArgs.aS(2, this.Version);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      paramVarArgs.aS(4, this.nEa);
      if (this.Fwu != null)
      {
        paramVarArgs.lC(5, this.Fwu.computeSize());
        this.Fwu.writeFields(paramVarArgs);
      }
      if (this.PackName != null) {
        paramVarArgs.d(6, this.PackName);
      }
      if (this.HaC != null)
      {
        paramVarArgs.lC(7, this.HaC.computeSize());
        this.HaC.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ukh) + 0 + f.a.a.b.b.a.bz(2, this.Version);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.nEa);
      paramInt = i;
      if (this.Fwu != null) {
        paramInt = i + f.a.a.a.lB(5, this.Fwu.computeSize());
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.PackName);
      }
      paramInt = i;
      if (this.HaC != null) {
        paramInt = i + f.a.a.a.lB(7, this.HaC.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cha localcha = (cha)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152659);
        return -1;
      case 1: 
        localcha.ukh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152659);
        return 0;
      case 2: 
        localcha.Version = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152659);
        return 0;
      case 3: 
        localcha.Name = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 4: 
        localcha.nEa = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152659);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcha.Fwu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      case 6: 
        localcha.PackName = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152659);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcha.HaC = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      }
      localcha.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(152659);
      return 0;
    }
    AppMethodBeat.o(152659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cha
 * JD-Core Version:    0.7.0.1
 */