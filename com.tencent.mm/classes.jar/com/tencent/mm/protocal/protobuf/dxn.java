package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dxn
  extends com.tencent.mm.bw.a
{
  public String GrK;
  public long Gsg;
  public String IcL;
  public b IcM;
  public LinkedList<dxw> IcN;
  public String Icy;
  public String Icz;
  
  public dxn()
  {
    AppMethodBeat.i(190861);
    this.IcN = new LinkedList();
    AppMethodBeat.o(190861);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190862);
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
      if (this.IcL != null) {
        paramVarArgs.d(4, this.IcL);
      }
      if (this.GrK != null) {
        paramVarArgs.d(5, this.GrK);
      }
      if (this.IcM != null) {
        paramVarArgs.c(6, this.IcM);
      }
      paramVarArgs.e(7, 8, this.IcN);
      AppMethodBeat.o(190862);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Icy == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.b.b.a.e(1, this.Icy) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gsg);
      paramInt = i;
      if (this.Icz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Icz);
      }
      i = paramInt;
      if (this.IcL != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.IcL);
      }
      paramInt = i;
      if (this.GrK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GrK);
      }
      i = paramInt;
      if (this.IcM != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.IcM);
      }
      paramInt = f.a.a.a.c(7, 8, this.IcN);
      AppMethodBeat.o(190862);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IcN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(190862);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxn localdxn = (dxn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190862);
          return -1;
        case 1: 
          localdxn.Icy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190862);
          return 0;
        case 2: 
          localdxn.Gsg = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(190862);
          return 0;
        case 3: 
          localdxn.Icz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190862);
          return 0;
        case 4: 
          localdxn.IcL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190862);
          return 0;
        case 5: 
          localdxn.GrK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(190862);
          return 0;
        case 6: 
          localdxn.IcM = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(190862);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dxw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxn.IcN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(190862);
        return 0;
      }
      AppMethodBeat.o(190862);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxn
 * JD-Core Version:    0.7.0.1
 */