package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bka
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public String Name;
  public String PackName;
  public int Version;
  public int jKn;
  public int nuk;
  public SKBuiltinBuffer_t wpT;
  public SKBuiltinBuffer_t xyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80153);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.nuk);
      paramVarArgs.aO(2, this.Version);
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      paramVarArgs.aO(4, this.jKn);
      if (this.wpT != null)
      {
        paramVarArgs.iQ(5, this.wpT.computeSize());
        this.wpT.writeFields(paramVarArgs);
      }
      if (this.PackName != null) {
        paramVarArgs.e(6, this.PackName);
      }
      if (this.xyz != null)
      {
        paramVarArgs.iQ(7, this.xyz.computeSize());
        this.xyz.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(8, this.Md5);
      }
      AppMethodBeat.o(80153);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.nuk) + 0 + e.a.a.b.b.a.bl(2, this.Version);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Name);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.jKn);
      paramInt = i;
      if (this.wpT != null) {
        paramInt = i + e.a.a.a.iP(5, this.wpT.computeSize());
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.PackName);
      }
      paramInt = i;
      if (this.xyz != null) {
        paramInt = i + e.a.a.a.iP(7, this.xyz.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.Md5);
      }
      AppMethodBeat.o(80153);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(80153);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bka localbka = (bka)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(80153);
        return -1;
      case 1: 
        localbka.nuk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80153);
        return 0;
      case 2: 
        localbka.Version = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80153);
        return 0;
      case 3: 
        localbka.Name = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80153);
        return 0;
      case 4: 
        localbka.jKn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80153);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbka.wpT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80153);
        return 0;
      case 6: 
        localbka.PackName = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80153);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbka.xyz = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80153);
        return 0;
      }
      localbka.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(80153);
      return 0;
    }
    AppMethodBeat.o(80153);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bka
 * JD-Core Version:    0.7.0.1
 */