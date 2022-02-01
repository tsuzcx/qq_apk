package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rg
  extends com.tencent.mm.bw.a
{
  public cxk FLp;
  public String FUn;
  public int GfC;
  public bqg GfD;
  public zw GfE;
  public int oGc;
  public int state;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91384);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.state);
      if (this.FLp != null)
      {
        paramVarArgs.lJ(2, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GfC);
      if (this.GfD != null)
      {
        paramVarArgs.lJ(4, this.GfD.computeSize());
        this.GfD.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.d(5, this.text);
      }
      if (this.FUn != null) {
        paramVarArgs.d(6, this.FUn);
      }
      paramVarArgs.aS(7, this.oGc);
      if (this.GfE != null)
      {
        paramVarArgs.lJ(8, this.GfE.computeSize());
        this.GfE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.state) + 0;
      paramInt = i;
      if (this.FLp != null) {
        paramInt = i + f.a.a.a.lI(2, this.FLp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GfC);
      paramInt = i;
      if (this.GfD != null) {
        paramInt = i + f.a.a.a.lI(4, this.GfD.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.text);
      }
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FUn);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.oGc);
      paramInt = i;
      if (this.GfE != null) {
        paramInt = i + f.a.a.a.lI(8, this.GfE.computeSize());
      }
      AppMethodBeat.o(91384);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      rg localrg = (rg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91384);
        return -1;
      case 1: 
        localrg.state = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91384);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrg.FLp = ((cxk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 3: 
        localrg.GfC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91384);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrg.GfD = ((bqg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 5: 
        localrg.text = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 6: 
        localrg.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 7: 
        localrg.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91384);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new zw();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((zw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localrg.GfE = ((zw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    AppMethodBeat.o(91384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rg
 * JD-Core Version:    0.7.0.1
 */