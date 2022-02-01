package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dof
  extends com.tencent.mm.bw.a
{
  public String GMr;
  public String GaE;
  public int Gqi;
  public int HHc;
  public LinkedList<doe> HVd;
  public boolean HVe;
  public LinkedList<doh> HVf;
  public String HVg;
  public String Md5;
  public int Version;
  public int nJA;
  
  public dof()
  {
    AppMethodBeat.i(6438);
    this.HVd = new LinkedList();
    this.HVf = new LinkedList();
    AppMethodBeat.o(6438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      paramVarArgs.aS(2, this.Version);
      if (this.GaE != null) {
        paramVarArgs.d(3, this.GaE);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aS(5, this.Gqi);
      paramVarArgs.aS(6, this.HHc);
      paramVarArgs.e(7, 8, this.HVd);
      paramVarArgs.bC(8, this.HVe);
      if (this.GMr != null) {
        paramVarArgs.d(9, this.GMr);
      }
      paramVarArgs.e(10, 8, this.HVf);
      if (this.HVg != null) {
        paramVarArgs.d(11, this.HVg);
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nJA) + 0 + f.a.a.b.b.a.bz(2, this.Version);
      paramInt = i;
      if (this.GaE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GaE);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = i + f.a.a.b.b.a.bz(5, this.Gqi) + f.a.a.b.b.a.bz(6, this.HHc) + f.a.a.a.c(7, 8, this.HVd) + f.a.a.b.b.a.amF(8);
      paramInt = i;
      if (this.GMr != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GMr);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.HVf);
      paramInt = i;
      if (this.HVg != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HVg);
      }
      AppMethodBeat.o(6439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HVd.clear();
      this.HVf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dof localdof = (dof)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6439);
        return -1;
      case 1: 
        localdof.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 2: 
        localdof.Version = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 3: 
        localdof.GaE = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 4: 
        localdof.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 5: 
        localdof.Gqi = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 6: 
        localdof.HHc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(6439);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdof.HVd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      case 8: 
        localdof.HVe = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(6439);
        return 0;
      case 9: 
        localdof.GMr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((doh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdof.HVf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      }
      localdof.HVg = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(6439);
      return 0;
    }
    AppMethodBeat.o(6439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dof
 * JD-Core Version:    0.7.0.1
 */