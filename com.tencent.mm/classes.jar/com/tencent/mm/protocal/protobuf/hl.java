package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hl
  extends com.tencent.mm.bw.a
{
  public int DUM;
  public SKBuiltinBuffer_t DUN;
  public bkh DUO;
  public int DUP;
  public SKBuiltinBuffer_t DUQ;
  public String DUR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUN == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.DUQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.DUM);
      if (this.DUN != null)
      {
        paramVarArgs.ln(2, this.DUN.computeSize());
        this.DUN.writeFields(paramVarArgs);
      }
      if (this.DUO != null)
      {
        paramVarArgs.ln(3, this.DUO.computeSize());
        this.DUO.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.DUP);
      if (this.DUQ != null)
      {
        paramVarArgs.ln(5, this.DUQ.computeSize());
        this.DUQ.writeFields(paramVarArgs);
      }
      if (this.DUR != null) {
        paramVarArgs.d(6, this.DUR);
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.DUM) + 0;
      paramInt = i;
      if (this.DUN != null) {
        paramInt = i + f.a.a.a.lm(2, this.DUN.computeSize());
      }
      i = paramInt;
      if (this.DUO != null) {
        i = paramInt + f.a.a.a.lm(3, this.DUO.computeSize());
      }
      i += f.a.a.b.b.a.bx(4, this.DUP);
      paramInt = i;
      if (this.DUQ != null) {
        paramInt = i + f.a.a.a.lm(5, this.DUQ.computeSize());
      }
      i = paramInt;
      if (this.DUR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DUR);
      }
      AppMethodBeat.o(133152);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DUN == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.DUQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      hl localhl = (hl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133152);
        return -1;
      case 1: 
        localhl.DUM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhl.DUN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhl.DUO = ((bkh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 4: 
        localhl.DUP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133152);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhl.DUQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      }
      localhl.DUR = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(133152);
      return 0;
    }
    AppMethodBeat.o(133152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hl
 * JD-Core Version:    0.7.0.1
 */