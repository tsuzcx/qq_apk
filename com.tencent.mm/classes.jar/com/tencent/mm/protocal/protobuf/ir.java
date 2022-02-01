package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ir
  extends com.tencent.mm.bw.a
  implements dyp
{
  public String ID;
  public SKBuiltinBuffer_t KLU;
  public String KMH;
  public SKBuiltinBuffer_t KMI;
  public String KMJ;
  public int KMK;
  public String KML;
  public String KMM;
  public int Ret;
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32136);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMI == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.KLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Ret);
      if (this.KMI != null)
      {
        paramVarArgs.ni(2, this.KMI.computeSize());
        this.KMI.writeFields(paramVarArgs);
      }
      if (this.KMJ != null) {
        paramVarArgs.e(3, this.KMJ);
      }
      if (this.KLU != null)
      {
        paramVarArgs.ni(4, this.KLU.computeSize());
        this.KLU.writeFields(paramVarArgs);
      }
      if (this.KML != null) {
        paramVarArgs.e(5, this.KML);
      }
      if (this.KMM != null) {
        paramVarArgs.e(6, this.KMM);
      }
      paramVarArgs.aM(7, this.KMK);
      if (this.ID != null) {
        paramVarArgs.e(8, this.ID);
      }
      if (this.KMH != null) {
        paramVarArgs.e(9, this.KMH);
      }
      AppMethodBeat.o(32136);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.KMI != null) {
        paramInt = i + g.a.a.a.nh(2, this.KMI.computeSize());
      }
      i = paramInt;
      if (this.KMJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KMJ);
      }
      paramInt = i;
      if (this.KLU != null) {
        paramInt = i + g.a.a.a.nh(4, this.KLU.computeSize());
      }
      i = paramInt;
      if (this.KML != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KML);
      }
      paramInt = i;
      if (this.KMM != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KMM);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.KMK);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.ID);
      }
      i = paramInt;
      if (this.KMH != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KMH);
      }
      AppMethodBeat.o(32136);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KMI == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.KLU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32136);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ir localir = (ir)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32136);
        return -1;
      case 1: 
        localir.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32136);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localir.KMI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 3: 
        localir.KMJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localir.KLU = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 5: 
        localir.KML = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 6: 
        localir.KMM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 7: 
        localir.KMK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32136);
        return 0;
      case 8: 
        localir.ID = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32136);
        return 0;
      }
      localir.KMH = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(32136);
      return 0;
    }
    AppMethodBeat.o(32136);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ir
 * JD-Core Version:    0.7.0.1
 */