package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmf
  extends com.tencent.mm.bw.a
{
  public int DesignerUin;
  public SKBuiltinBuffer_t LUY;
  public String LUZ;
  public int LVa;
  public long LVb;
  public int Lst;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104784);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.OpCode);
      paramVarArgs.aM(2, this.DesignerUin);
      if (this.LUY != null)
      {
        paramVarArgs.ni(3, this.LUY.computeSize());
        this.LUY.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.Lst);
      if (this.LUZ != null) {
        paramVarArgs.e(5, this.LUZ);
      }
      paramVarArgs.aM(6, this.LVa);
      paramVarArgs.bb(7, this.LVb);
      AppMethodBeat.o(104784);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.OpCode) + 0 + g.a.a.b.b.a.bu(2, this.DesignerUin);
      paramInt = i;
      if (this.LUY != null) {
        paramInt = i + g.a.a.a.nh(3, this.LUY.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Lst);
      paramInt = i;
      if (this.LUZ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LUZ);
      }
      i = g.a.a.b.b.a.bu(6, this.LVa);
      int j = g.a.a.b.b.a.r(7, this.LVb);
      AppMethodBeat.o(104784);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104784);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bmf localbmf = (bmf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104784);
        return -1;
      case 1: 
        localbmf.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104784);
        return 0;
      case 2: 
        localbmf.DesignerUin = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104784);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbmf.LUY = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104784);
        return 0;
      case 4: 
        localbmf.Lst = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104784);
        return 0;
      case 5: 
        localbmf.LUZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(104784);
        return 0;
      case 6: 
        localbmf.LVa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(104784);
        return 0;
      }
      localbmf.LVb = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(104784);
      return 0;
    }
    AppMethodBeat.o(104784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmf
 * JD-Core Version:    0.7.0.1
 */