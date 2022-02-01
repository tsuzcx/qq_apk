package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxc
  extends com.tencent.mm.bw.a
{
  public long Gsg;
  public LinkedList<dxx> IcA;
  public long IcB;
  public int IcC;
  public String IcD;
  public String Icy;
  public String Icz;
  
  public dxc()
  {
    AppMethodBeat.i(190844);
    this.IcA = new LinkedList();
    AppMethodBeat.o(190844);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Icy != null) {
        paramVarArgs.d(1, this.Icy);
      }
      paramVarArgs.aZ(2, this.Gsg);
      if (this.Icz != null) {
        paramVarArgs.d(3, this.Icz);
      }
      paramVarArgs.e(4, 8, this.IcA);
      paramVarArgs.aZ(5, this.IcB);
      paramVarArgs.aS(6, this.IcC);
      if (this.IcD != null) {
        paramVarArgs.d(7, this.IcD);
      }
      AppMethodBeat.o(190845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Icy == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = f.a.a.b.b.a.e(1, this.Icy) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gsg);
      paramInt = i;
      if (this.Icz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Icz);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.IcA) + f.a.a.b.b.a.p(5, this.IcB) + f.a.a.b.b.a.bz(6, this.IcC);
      paramInt = i;
      if (this.IcD != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.IcD);
      }
      AppMethodBeat.o(190845);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IcA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(190845);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxc localdxc = (dxc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190845);
          return -1;
        case 1: 
          localdxc.Icy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190845);
          return 0;
        case 2: 
          localdxc.Gsg = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(190845);
          return 0;
        case 3: 
          localdxc.Icz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190845);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dxx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxc.IcA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190845);
          return 0;
        case 5: 
          localdxc.IcB = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(190845);
          return 0;
        case 6: 
          localdxc.IcC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(190845);
          return 0;
        }
        localdxc.IcD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(190845);
        return 0;
      }
      AppMethodBeat.o(190845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxc
 * JD-Core Version:    0.7.0.1
 */