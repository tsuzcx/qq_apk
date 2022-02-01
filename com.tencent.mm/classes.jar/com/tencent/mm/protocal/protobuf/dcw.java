package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcw
  extends com.tencent.mm.bw.a
{
  public lo FMx;
  public doq FMy;
  public cbz FMz;
  public String objectNonceId;
  public long qXP;
  public String rfC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169091);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.qXP);
      if (this.FMx != null)
      {
        paramVarArgs.ln(2, this.FMx.computeSize());
        this.FMx.writeFields(paramVarArgs);
      }
      if (this.FMy != null)
      {
        paramVarArgs.ln(3, this.FMy.computeSize());
        this.FMy.writeFields(paramVarArgs);
      }
      if (this.FMz != null)
      {
        paramVarArgs.ln(4, this.FMz.computeSize());
        this.FMz.writeFields(paramVarArgs);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      if (this.rfC != null) {
        paramVarArgs.d(6, this.rfC);
      }
      AppMethodBeat.o(169091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.qXP) + 0;
      paramInt = i;
      if (this.FMx != null) {
        paramInt = i + f.a.a.a.lm(2, this.FMx.computeSize());
      }
      i = paramInt;
      if (this.FMy != null) {
        i = paramInt + f.a.a.a.lm(3, this.FMy.computeSize());
      }
      paramInt = i;
      if (this.FMz != null) {
        paramInt = i + f.a.a.a.lm(4, this.FMz.computeSize());
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      paramInt = i;
      if (this.rfC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rfC);
      }
      AppMethodBeat.o(169091);
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
      AppMethodBeat.o(169091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dcw localdcw = (dcw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169091);
        return -1;
      case 1: 
        localdcw.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169091);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcw.FMx = ((lo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcw.FMy = ((doq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcw.FMz = ((cbz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 5: 
        localdcw.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169091);
        return 0;
      }
      localdcw.rfC = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(169091);
      return 0;
    }
    AppMethodBeat.o(169091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcw
 * JD-Core Version:    0.7.0.1
 */