package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vi
  extends com.tencent.mm.bx.a
{
  public bjt Avj;
  public bjt Avk;
  public String CMB;
  public String CXu;
  public int CXv;
  public String doh;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.Avj != null)
      {
        paramVarArgs.kX(3, this.Avj.computeSize());
        this.Avj.writeFields(paramVarArgs);
      }
      if (this.Avk != null)
      {
        paramVarArgs.kX(4, this.Avk.computeSize());
        this.Avk.writeFields(paramVarArgs);
      }
      if (this.CXu != null) {
        paramVarArgs.d(5, this.CXu);
      }
      if (this.CMB != null) {
        paramVarArgs.d(6, this.CMB);
      }
      paramVarArgs.aR(7, this.CXv);
      AppMethodBeat.o(177332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label754;
      }
    }
    label754:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.Avj != null) {
        i = paramInt + f.a.a.a.kW(3, this.Avj.computeSize());
      }
      paramInt = i;
      if (this.Avk != null) {
        paramInt = i + f.a.a.a.kW(4, this.Avk.computeSize());
      }
      i = paramInt;
      if (this.CXu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CXu);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CMB);
      }
      i = f.a.a.b.b.a.bA(7, this.CXv);
      AppMethodBeat.o(177332);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(177332);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vi localvi = (vi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(177332);
          return -1;
        case 1: 
          localvi.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 2: 
          localvi.doh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvi.Avj = ((bjt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvi.Avk = ((bjt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 5: 
          localvi.CXu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 6: 
          localvi.CMB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(177332);
          return 0;
        }
        localvi.CXv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(177332);
        return 0;
      }
      AppMethodBeat.o(177332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vi
 * JD-Core Version:    0.7.0.1
 */