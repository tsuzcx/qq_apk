package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ckw
  extends com.tencent.mm.bx.a
{
  public int BSu;
  public int COp;
  public int DEB;
  public int DYI;
  public int Dus;
  public ckz Egn;
  public cky Ego;
  public int Egp;
  public String Egq;
  public int Egr;
  public int Egs;
  public int Egt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Egq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.DYI);
      if (this.Egn != null)
      {
        paramVarArgs.kX(2, this.Egn.computeSize());
        this.Egn.writeFields(paramVarArgs);
      }
      if (this.Ego != null)
      {
        paramVarArgs.kX(3, this.Ego.computeSize());
        this.Ego.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Dus);
      paramVarArgs.aR(5, this.Egp);
      if (this.Egq != null) {
        paramVarArgs.d(6, this.Egq);
      }
      paramVarArgs.aR(7, this.COp);
      paramVarArgs.aR(8, this.Egr);
      paramVarArgs.aR(9, this.BSu);
      paramVarArgs.aR(10, this.Egs);
      paramVarArgs.aR(11, this.Egt);
      paramVarArgs.aR(12, this.DEB);
      AppMethodBeat.o(152668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DYI) + 0;
      paramInt = i;
      if (this.Egn != null) {
        paramInt = i + f.a.a.a.kW(2, this.Egn.computeSize());
      }
      i = paramInt;
      if (this.Ego != null) {
        i = paramInt + f.a.a.a.kW(3, this.Ego.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(4, this.Dus) + f.a.a.b.b.a.bA(5, this.Egp);
      paramInt = i;
      if (this.Egq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Egq);
      }
      i = f.a.a.b.b.a.bA(7, this.COp);
      int j = f.a.a.b.b.a.bA(8, this.Egr);
      int k = f.a.a.b.b.a.bA(9, this.BSu);
      int m = f.a.a.b.b.a.bA(10, this.Egs);
      int n = f.a.a.b.b.a.bA(11, this.Egt);
      int i1 = f.a.a.b.b.a.bA(12, this.DEB);
      AppMethodBeat.o(152668);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Egq == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(152668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ckw localckw = (ckw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152668);
        return -1;
      case 1: 
        localckw.DYI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckw.Egn = ((ckz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cky();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localckw.Ego = ((cky)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152668);
        return 0;
      case 4: 
        localckw.Dus = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      case 5: 
        localckw.Egp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      case 6: 
        localckw.Egq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152668);
        return 0;
      case 7: 
        localckw.COp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      case 8: 
        localckw.Egr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      case 9: 
        localckw.BSu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      case 10: 
        localckw.Egs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      case 11: 
        localckw.Egt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152668);
        return 0;
      }
      localckw.DEB = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(152668);
      return 0;
    }
    AppMethodBeat.o(152668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckw
 * JD-Core Version:    0.7.0.1
 */