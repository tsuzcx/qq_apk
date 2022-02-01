package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cji
  extends com.tencent.mm.bx.a
{
  public String GKh;
  public int Hdg;
  public String Hdh;
  public int Hdi;
  public String Hdj;
  public int Hdk;
  public String Hdl;
  public long Hdm;
  public LinkedList<cix> Hdn;
  public String icg;
  public String wCF;
  public String xZh;
  
  public cji()
  {
    AppMethodBeat.i(91593);
    this.Hdn = new LinkedList();
    AppMethodBeat.o(91593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91594);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hdg);
      if (this.Hdh != null) {
        paramVarArgs.d(2, this.Hdh);
      }
      if (this.GKh != null) {
        paramVarArgs.d(3, this.GKh);
      }
      paramVarArgs.aS(4, this.Hdi);
      if (this.wCF != null) {
        paramVarArgs.d(5, this.wCF);
      }
      if (this.Hdj != null) {
        paramVarArgs.d(6, this.Hdj);
      }
      if (this.xZh != null) {
        paramVarArgs.d(7, this.xZh);
      }
      paramVarArgs.aS(8, this.Hdk);
      if (this.icg != null) {
        paramVarArgs.d(9, this.icg);
      }
      if (this.Hdl != null) {
        paramVarArgs.d(10, this.Hdl);
      }
      paramVarArgs.aY(11, this.Hdm);
      paramVarArgs.e(12, 8, this.Hdn);
      AppMethodBeat.o(91594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hdg) + 0;
      paramInt = i;
      if (this.Hdh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hdh);
      }
      i = paramInt;
      if (this.GKh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GKh);
      }
      i += f.a.a.b.b.a.bz(4, this.Hdi);
      paramInt = i;
      if (this.wCF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wCF);
      }
      i = paramInt;
      if (this.Hdj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hdj);
      }
      paramInt = i;
      if (this.xZh != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.xZh);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.Hdk);
      paramInt = i;
      if (this.icg != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.icg);
      }
      i = paramInt;
      if (this.Hdl != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Hdl);
      }
      paramInt = f.a.a.b.b.a.p(11, this.Hdm);
      int j = f.a.a.a.c(12, 8, this.Hdn);
      AppMethodBeat.o(91594);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hdn.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cji localcji = (cji)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91594);
        return -1;
      case 1: 
        localcji.Hdg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91594);
        return 0;
      case 2: 
        localcji.Hdh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 3: 
        localcji.GKh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 4: 
        localcji.Hdi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91594);
        return 0;
      case 5: 
        localcji.wCF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 6: 
        localcji.Hdj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 7: 
        localcji.xZh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 8: 
        localcji.Hdk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91594);
        return 0;
      case 9: 
        localcji.icg = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 10: 
        localcji.Hdl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 11: 
        localcji.Hdm = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91594);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cix();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcji.Hdn.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    AppMethodBeat.o(91594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cji
 * JD-Core Version:    0.7.0.1
 */