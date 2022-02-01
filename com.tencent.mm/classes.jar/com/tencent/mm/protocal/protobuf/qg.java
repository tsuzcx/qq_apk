package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qg
  extends com.tencent.mm.bw.a
{
  public int EgZ;
  public int Eha;
  public int Ehb;
  public int Ehc;
  public LinkedList<crm> Ehd;
  public String Ehe;
  public SKBuiltinBuffer_t Ehf;
  public int Ehg;
  public int Ehh;
  public LinkedList<crm> Ehi;
  public LinkedList<qh> Ehj;
  public LinkedList<qh> Ehk;
  public int Ehl;
  public int Ehm;
  public int pAs;
  
  public qg()
  {
    AppMethodBeat.i(133162);
    this.Ehd = new LinkedList();
    this.Ehi = new LinkedList();
    this.Ehj = new LinkedList();
    this.Ehk = new LinkedList();
    AppMethodBeat.o(133162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133163);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ehf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.EgZ);
      paramVarArgs.aR(2, this.pAs);
      paramVarArgs.aR(3, this.Eha);
      paramVarArgs.aR(4, this.Ehb);
      paramVarArgs.aR(5, this.Ehc);
      paramVarArgs.e(6, 8, this.Ehd);
      if (this.Ehe != null) {
        paramVarArgs.d(7, this.Ehe);
      }
      if (this.Ehf != null)
      {
        paramVarArgs.ln(8, this.Ehf.computeSize());
        this.Ehf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.Ehg);
      paramVarArgs.aR(10, this.Ehh);
      paramVarArgs.e(11, 8, this.Ehi);
      paramVarArgs.e(12, 8, this.Ehj);
      paramVarArgs.e(13, 8, this.Ehk);
      paramVarArgs.aR(14, this.Ehl);
      paramVarArgs.aR(15, this.Ehm);
      AppMethodBeat.o(133163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EgZ) + 0 + f.a.a.b.b.a.bx(2, this.pAs) + f.a.a.b.b.a.bx(3, this.Eha) + f.a.a.b.b.a.bx(4, this.Ehb) + f.a.a.b.b.a.bx(5, this.Ehc) + f.a.a.a.c(6, 8, this.Ehd);
      paramInt = i;
      if (this.Ehe != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ehe);
      }
      i = paramInt;
      if (this.Ehf != null) {
        i = paramInt + f.a.a.a.lm(8, this.Ehf.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(9, this.Ehg);
      int j = f.a.a.b.b.a.bx(10, this.Ehh);
      int k = f.a.a.a.c(11, 8, this.Ehi);
      int m = f.a.a.a.c(12, 8, this.Ehj);
      int n = f.a.a.a.c(13, 8, this.Ehk);
      int i1 = f.a.a.b.b.a.bx(14, this.Ehl);
      int i2 = f.a.a.b.b.a.bx(15, this.Ehm);
      AppMethodBeat.o(133163);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ehd.clear();
      this.Ehi.clear();
      this.Ehj.clear();
      this.Ehk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.Ehf == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qg localqg = (qg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133163);
        return -1;
      case 1: 
        localqg.EgZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
        return 0;
      case 2: 
        localqg.pAs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
        return 0;
      case 3: 
        localqg.Eha = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
        return 0;
      case 4: 
        localqg.Ehb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
        return 0;
      case 5: 
        localqg.Ehc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
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
          localqg.Ehd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 7: 
        localqg.Ehe = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133163);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqg.Ehf = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 9: 
        localqg.Ehg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
        return 0;
      case 10: 
        localqg.Ehh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqg.Ehi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqg.Ehj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqg.Ehk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 14: 
        localqg.Ehl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(133163);
        return 0;
      }
      localqg.Ehm = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(133163);
      return 0;
    }
    AppMethodBeat.o(133163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qg
 * JD-Core Version:    0.7.0.1
 */