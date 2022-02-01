package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ie
  extends com.tencent.mm.bw.a
  implements dfi
{
  public String FSY;
  public SKBuiltinBuffer_t FSZ;
  public SKBuiltinBuffer_t FSl;
  public String FTa;
  public int FTb;
  public String FTc;
  public String FTd;
  public String ID;
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.FSl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Ret);
      if (this.FSZ != null)
      {
        paramVarArgs.lJ(2, this.FSZ.computeSize());
        this.FSZ.writeFields(paramVarArgs);
      }
      if (this.FTa != null) {
        paramVarArgs.d(3, this.FTa);
      }
      if (this.FSl != null)
      {
        paramVarArgs.lJ(4, this.FSl.computeSize());
        this.FSl.writeFields(paramVarArgs);
      }
      if (this.FTc != null) {
        paramVarArgs.d(5, this.FTc);
      }
      if (this.FTd != null) {
        paramVarArgs.d(6, this.FTd);
      }
      paramVarArgs.aS(7, this.FTb);
      if (this.ID != null) {
        paramVarArgs.d(8, this.ID);
      }
      if (this.FSY != null) {
        paramVarArgs.d(9, this.FSY);
      }
      AppMethodBeat.o(32136);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FSZ != null) {
        paramInt = i + f.a.a.a.lI(2, this.FSZ.computeSize());
      }
      i = paramInt;
      if (this.FTa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FTa);
      }
      paramInt = i;
      if (this.FSl != null) {
        paramInt = i + f.a.a.a.lI(4, this.FSl.computeSize());
      }
      i = paramInt;
      if (this.FTc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FTc);
      }
      paramInt = i;
      if (this.FTd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FTd);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FTb);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ID);
      }
      i = paramInt;
      if (this.FSY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FSY);
      }
      AppMethodBeat.o(32136);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FSZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCodeBuffer");
        AppMethodBeat.o(32136);
        throw paramVarArgs;
      }
      if (this.FSl == null)
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
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ie localie = (ie)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32136);
        return -1;
      case 1: 
        localie.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32136);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localie.FSZ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 3: 
        localie.FTa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localie.FSl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32136);
        return 0;
      case 5: 
        localie.FTc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 6: 
        localie.FTd = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32136);
        return 0;
      case 7: 
        localie.FTb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32136);
        return 0;
      case 8: 
        localie.ID = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32136);
        return 0;
      }
      localie.FSY = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(32136);
      return 0;
    }
    AppMethodBeat.o(32136);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ie
 * JD-Core Version:    0.7.0.1
 */