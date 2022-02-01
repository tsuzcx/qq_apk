package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baq
  extends com.tencent.mm.bw.a
{
  public int DesignerUin;
  public SKBuiltinBuffer_t GQI;
  public String GQJ;
  public int GQK;
  public long GQL;
  public int GwN;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104784);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.OpCode);
      paramVarArgs.aS(2, this.DesignerUin);
      if (this.GQI != null)
      {
        paramVarArgs.lJ(3, this.GQI.computeSize());
        this.GQI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GwN);
      if (this.GQJ != null) {
        paramVarArgs.d(5, this.GQJ);
      }
      paramVarArgs.aS(6, this.GQK);
      paramVarArgs.aZ(7, this.GQL);
      AppMethodBeat.o(104784);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.OpCode) + 0 + f.a.a.b.b.a.bz(2, this.DesignerUin);
      paramInt = i;
      if (this.GQI != null) {
        paramInt = i + f.a.a.a.lI(3, this.GQI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GwN);
      paramInt = i;
      if (this.GQJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GQJ);
      }
      i = f.a.a.b.b.a.bz(6, this.GQK);
      int j = f.a.a.b.b.a.p(7, this.GQL);
      AppMethodBeat.o(104784);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(104784);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      baq localbaq = (baq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104784);
        return -1;
      case 1: 
        localbaq.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104784);
        return 0;
      case 2: 
        localbaq.DesignerUin = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104784);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbaq.GQI = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104784);
        return 0;
      case 4: 
        localbaq.GwN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104784);
        return 0;
      case 5: 
        localbaq.GQJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(104784);
        return 0;
      case 6: 
        localbaq.GQK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104784);
        return 0;
      }
      localbaq.GQL = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(104784);
      return 0;
    }
    AppMethodBeat.o(104784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baq
 * JD-Core Version:    0.7.0.1
 */