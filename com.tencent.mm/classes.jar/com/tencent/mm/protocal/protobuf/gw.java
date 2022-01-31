package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class gw
  extends com.tencent.mm.bv.a
  implements ccv
{
  public String ID;
  public int Ret;
  public SKBuiltinBuffer_t wsu;
  public String wtf;
  public SKBuiltinBuffer_t wtg;
  public String wth;
  public int wti;
  public String wtj;
  public String wtk;
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28332);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wtg == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(28332);
        throw paramVarArgs;
      }
      if (this.wsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(28332);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.Ret);
      if (this.wtg != null)
      {
        paramVarArgs.iQ(2, this.wtg.computeSize());
        this.wtg.writeFields(paramVarArgs);
      }
      if (this.wth != null) {
        paramVarArgs.e(3, this.wth);
      }
      if (this.wsu != null)
      {
        paramVarArgs.iQ(4, this.wsu.computeSize());
        this.wsu.writeFields(paramVarArgs);
      }
      if (this.wtj != null) {
        paramVarArgs.e(5, this.wtj);
      }
      if (this.wtk != null) {
        paramVarArgs.e(6, this.wtk);
      }
      paramVarArgs.aO(7, this.wti);
      if (this.ID != null) {
        paramVarArgs.e(8, this.ID);
      }
      if (this.wtf != null) {
        paramVarArgs.e(9, this.wtf);
      }
      AppMethodBeat.o(28332);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.wtg != null) {
        paramInt = i + e.a.a.a.iP(2, this.wtg.computeSize());
      }
      i = paramInt;
      if (this.wth != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wth);
      }
      paramInt = i;
      if (this.wsu != null) {
        paramInt = i + e.a.a.a.iP(4, this.wsu.computeSize());
      }
      i = paramInt;
      if (this.wtj != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wtj);
      }
      paramInt = i;
      if (this.wtk != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wtk);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.wti);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ID);
      }
      i = paramInt;
      if (this.wtf != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wtf);
      }
      AppMethodBeat.o(28332);
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
      if (this.wtg == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(28332);
        throw paramVarArgs;
      }
      if (this.wsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(28332);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28332);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      gw localgw = (gw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28332);
        return -1;
      case 1: 
        localgw.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28332);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgw.wtg = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28332);
        return 0;
      case 3: 
        localgw.wth = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28332);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgw.wsu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28332);
        return 0;
      case 5: 
        localgw.wtj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28332);
        return 0;
      case 6: 
        localgw.wtk = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28332);
        return 0;
      case 7: 
        localgw.wti = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28332);
        return 0;
      case 8: 
        localgw.ID = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28332);
        return 0;
      }
      localgw.wtf = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(28332);
      return 0;
    }
    AppMethodBeat.o(28332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gw
 * JD-Core Version:    0.7.0.1
 */