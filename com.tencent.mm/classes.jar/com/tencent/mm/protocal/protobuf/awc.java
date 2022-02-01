package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awc
  extends com.tencent.mm.bw.a
{
  public int DesignerUin;
  public SKBuiltinBuffer_t EOe;
  public String EOf;
  public int EOg;
  public long EOh;
  public int EwD;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104784);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.OpCode);
      paramVarArgs.aR(2, this.DesignerUin);
      if (this.EOe != null)
      {
        paramVarArgs.ln(3, this.EOe.computeSize());
        this.EOe.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.EwD);
      if (this.EOf != null) {
        paramVarArgs.d(5, this.EOf);
      }
      paramVarArgs.aR(6, this.EOg);
      paramVarArgs.aO(7, this.EOh);
      AppMethodBeat.o(104784);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.OpCode) + 0 + f.a.a.b.b.a.bx(2, this.DesignerUin);
      paramInt = i;
      if (this.EOe != null) {
        paramInt = i + f.a.a.a.lm(3, this.EOe.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.EwD);
      paramInt = i;
      if (this.EOf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EOf);
      }
      i = f.a.a.b.b.a.bx(6, this.EOg);
      int j = f.a.a.b.b.a.p(7, this.EOh);
      AppMethodBeat.o(104784);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(104784);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      awc localawc = (awc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(104784);
        return -1;
      case 1: 
        localawc.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104784);
        return 0;
      case 2: 
        localawc.DesignerUin = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104784);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawc.EOe = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104784);
        return 0;
      case 4: 
        localawc.EwD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104784);
        return 0;
      case 5: 
        localawc.EOf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(104784);
        return 0;
      case 6: 
        localawc.EOg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104784);
        return 0;
      }
      localawc.EOh = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(104784);
      return 0;
    }
    AppMethodBeat.o(104784);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awc
 * JD-Core Version:    0.7.0.1
 */