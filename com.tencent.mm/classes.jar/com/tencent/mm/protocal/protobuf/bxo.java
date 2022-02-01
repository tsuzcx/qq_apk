package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxo
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t CyG;
  public SKBuiltinBuffer_t DUf;
  public String Md5;
  public String Name;
  public String PackName;
  public int Version;
  public int mBC;
  public int sdO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.sdO);
      paramVarArgs.aR(2, this.Version);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      paramVarArgs.aR(4, this.mBC);
      if (this.CyG != null)
      {
        paramVarArgs.kX(5, this.CyG.computeSize());
        this.CyG.writeFields(paramVarArgs);
      }
      if (this.PackName != null) {
        paramVarArgs.d(6, this.PackName);
      }
      if (this.DUf != null)
      {
        paramVarArgs.kX(7, this.DUf.computeSize());
        this.DUf.writeFields(paramVarArgs);
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
      i = f.a.a.b.b.a.bA(1, this.sdO) + 0 + f.a.a.b.b.a.bA(2, this.Version);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.mBC);
      paramInt = i;
      if (this.CyG != null) {
        paramInt = i + f.a.a.a.kW(5, this.CyG.computeSize());
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.PackName);
      }
      paramInt = i;
      if (this.DUf != null) {
        paramInt = i + f.a.a.a.kW(7, this.DUf.computeSize());
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
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bxo localbxo = (bxo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152659);
        return -1;
      case 1: 
        localbxo.sdO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152659);
        return 0;
      case 2: 
        localbxo.Version = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152659);
        return 0;
      case 3: 
        localbxo.Name = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 4: 
        localbxo.mBC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152659);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxo.CyG = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      case 6: 
        localbxo.PackName = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxo.DUf = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      }
      localbxo.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(152659);
      return 0;
    }
    AppMethodBeat.o(152659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxo
 * JD-Core Version:    0.7.0.1
 */