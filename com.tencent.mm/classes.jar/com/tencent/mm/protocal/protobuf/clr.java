package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class clr
  extends com.tencent.mm.bw.a
{
  public crm Fzd;
  public crm Fze;
  public crm Fzf;
  public crm Fzg;
  public crm Fzh;
  public crm Fzi;
  public crm Fzj;
  public crm Fzk;
  public crm Fzl;
  public int id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fze == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzf == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzg == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzh == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzi == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzj == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzk == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.id);
      if (this.Fzd != null)
      {
        paramVarArgs.ln(2, this.Fzd.computeSize());
        this.Fzd.writeFields(paramVarArgs);
      }
      if (this.Fze != null)
      {
        paramVarArgs.ln(3, this.Fze.computeSize());
        this.Fze.writeFields(paramVarArgs);
      }
      if (this.Fzf != null)
      {
        paramVarArgs.ln(4, this.Fzf.computeSize());
        this.Fzf.writeFields(paramVarArgs);
      }
      if (this.Fzg != null)
      {
        paramVarArgs.ln(5, this.Fzg.computeSize());
        this.Fzg.writeFields(paramVarArgs);
      }
      if (this.Fzh != null)
      {
        paramVarArgs.ln(6, this.Fzh.computeSize());
        this.Fzh.writeFields(paramVarArgs);
      }
      if (this.Fzi != null)
      {
        paramVarArgs.ln(7, this.Fzi.computeSize());
        this.Fzi.writeFields(paramVarArgs);
      }
      if (this.Fzj != null)
      {
        paramVarArgs.ln(8, this.Fzj.computeSize());
        this.Fzj.writeFields(paramVarArgs);
      }
      if (this.Fzk != null)
      {
        paramVarArgs.ln(9, this.Fzk.computeSize());
        this.Fzk.writeFields(paramVarArgs);
      }
      if (this.Fzl != null)
      {
        paramVarArgs.ln(10, this.Fzl.computeSize());
        this.Fzl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.id) + 0;
      paramInt = i;
      if (this.Fzd != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fzd.computeSize());
      }
      i = paramInt;
      if (this.Fze != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fze.computeSize());
      }
      paramInt = i;
      if (this.Fzf != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fzf.computeSize());
      }
      i = paramInt;
      if (this.Fzg != null) {
        i = paramInt + f.a.a.a.lm(5, this.Fzg.computeSize());
      }
      paramInt = i;
      if (this.Fzh != null) {
        paramInt = i + f.a.a.a.lm(6, this.Fzh.computeSize());
      }
      i = paramInt;
      if (this.Fzi != null) {
        i = paramInt + f.a.a.a.lm(7, this.Fzi.computeSize());
      }
      paramInt = i;
      if (this.Fzj != null) {
        paramInt = i + f.a.a.a.lm(8, this.Fzj.computeSize());
      }
      i = paramInt;
      if (this.Fzk != null) {
        i = paramInt + f.a.a.a.lm(9, this.Fzk.computeSize());
      }
      paramInt = i;
      if (this.Fzl != null) {
        paramInt = i + f.a.a.a.lm(10, this.Fzl.computeSize());
      }
      AppMethodBeat.o(32402);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Fze == null)
      {
        paramVarArgs = new b("Not all required fields were included: province");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzf == null)
      {
        paramVarArgs = new b("Not all required fields were included: city");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzg == null)
      {
        paramVarArgs = new b("Not all required fields were included: district");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzh == null)
      {
        paramVarArgs = new b("Not all required fields were included: zipcode");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzi == null)
      {
        paramVarArgs = new b("Not all required fields were included: detail");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzj == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      if (this.Fzk == null)
      {
        paramVarArgs = new b("Not all required fields were included: phone");
        AppMethodBeat.o(32402);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clr localclr = (clr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32402);
        return -1;
      case 1: 
        localclr.id = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32402);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fzd = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fze = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fzf = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fzg = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fzh = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fzi = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fzj = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclr.Fzk = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32402);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new crm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localclr.Fzl = ((crm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32402);
      return 0;
    }
    AppMethodBeat.o(32402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clr
 * JD-Core Version:    0.7.0.1
 */