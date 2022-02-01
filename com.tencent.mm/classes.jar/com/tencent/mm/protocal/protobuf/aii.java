package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aii
  extends com.tencent.mm.bx.a
{
  public String DkZ;
  public FinderContact contact;
  public boolean diE;
  public int displayFlag;
  public int dtM;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168954);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.kX(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dtM);
      if (this.DkZ != null) {
        paramVarArgs.d(3, this.DkZ);
      }
      paramVarArgs.bg(4, this.diE);
      paramVarArgs.aR(5, this.displayFlag);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      AppMethodBeat.o(168954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.kW(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dtM);
      paramInt = i;
      if (this.DkZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DkZ);
      }
      i = paramInt + (f.a.a.b.b.a.fY(4) + 1) + f.a.a.b.b.a.bA(5, this.displayFlag);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      AppMethodBeat.o(168954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aii localaii = (aii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168954);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaii.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168954);
          return 0;
        case 2: 
          localaii.dtM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168954);
          return 0;
        case 3: 
          localaii.DkZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168954);
          return 0;
        case 4: 
          localaii.diE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(168954);
          return 0;
        case 5: 
          localaii.displayFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168954);
          return 0;
        }
        localaii.username = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(168954);
        return 0;
      }
      AppMethodBeat.o(168954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aii
 * JD-Core Version:    0.7.0.1
 */