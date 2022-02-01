package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ln
  extends com.tencent.mm.bw.a
{
  public qg DZh;
  public qg DZi;
  public qg DZj;
  public SKBuiltinBuffer_t DZk;
  public SKBuiltinBuffer_t DZl;
  public qg DZm;
  public int DZn;
  public qf DZo;
  public qf DZp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DZh != null)
      {
        paramVarArgs.ln(1, this.DZh.computeSize());
        this.DZh.writeFields(paramVarArgs);
      }
      if (this.DZi != null)
      {
        paramVarArgs.ln(2, this.DZi.computeSize());
        this.DZi.writeFields(paramVarArgs);
      }
      if (this.DZj != null)
      {
        paramVarArgs.ln(4, this.DZj.computeSize());
        this.DZj.writeFields(paramVarArgs);
      }
      if (this.DZk != null)
      {
        paramVarArgs.ln(5, this.DZk.computeSize());
        this.DZk.writeFields(paramVarArgs);
      }
      if (this.DZl != null)
      {
        paramVarArgs.ln(6, this.DZl.computeSize());
        this.DZl.writeFields(paramVarArgs);
      }
      if (this.DZm != null)
      {
        paramVarArgs.ln(7, this.DZm.computeSize());
        this.DZm.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.DZn);
      if (this.DZo != null)
      {
        paramVarArgs.ln(9, this.DZo.computeSize());
        this.DZo.writeFields(paramVarArgs);
      }
      if (this.DZp != null)
      {
        paramVarArgs.ln(10, this.DZp.computeSize());
        this.DZp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DZh == null) {
        break label1446;
      }
    }
    label1446:
    for (int i = f.a.a.a.lm(1, this.DZh.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DZi != null) {
        paramInt = i + f.a.a.a.lm(2, this.DZi.computeSize());
      }
      i = paramInt;
      if (this.DZj != null) {
        i = paramInt + f.a.a.a.lm(4, this.DZj.computeSize());
      }
      paramInt = i;
      if (this.DZk != null) {
        paramInt = i + f.a.a.a.lm(5, this.DZk.computeSize());
      }
      i = paramInt;
      if (this.DZl != null) {
        i = paramInt + f.a.a.a.lm(6, this.DZl.computeSize());
      }
      paramInt = i;
      if (this.DZm != null) {
        paramInt = i + f.a.a.a.lm(7, this.DZm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.DZn);
      paramInt = i;
      if (this.DZo != null) {
        paramInt = i + f.a.a.a.lm(9, this.DZo.computeSize());
      }
      i = paramInt;
      if (this.DZp != null) {
        i = paramInt + f.a.a.a.lm(10, this.DZp.computeSize());
      }
      AppMethodBeat.o(104359);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ln localln = (ln)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(104359);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localln.DZh = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localln.DZi = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localln.DZj = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
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
            localln.DZk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localln.DZl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localln.DZm = ((qg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 8: 
          localln.DZn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104359);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localln.DZo = ((qf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localln.DZp = ((qf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      AppMethodBeat.o(104359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ln
 * JD-Core Version:    0.7.0.1
 */