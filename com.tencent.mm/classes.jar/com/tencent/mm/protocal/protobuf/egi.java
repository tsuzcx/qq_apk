package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egi
  extends com.tencent.mm.bx.a
{
  public boolean HQZ;
  public boolean HRb;
  public boolean HRc;
  public String HRr;
  public ddu HRs;
  public dnl HRt;
  public String Hsm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153317);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HRr != null) {
        paramVarArgs.d(1, this.HRr);
      }
      if (this.Hsm != null) {
        paramVarArgs.d(2, this.Hsm);
      }
      if (this.HRs != null)
      {
        paramVarArgs.lC(3, this.HRs.computeSize());
        this.HRs.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(4, this.HQZ);
      paramVarArgs.bt(5, this.HRb);
      if (this.HRt != null)
      {
        paramVarArgs.lC(6, this.HRt.computeSize());
        this.HRt.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(7, this.HRc);
      AppMethodBeat.o(153317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HRr == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.HRr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hsm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hsm);
      }
      i = paramInt;
      if (this.HRs != null) {
        i = paramInt + f.a.a.a.lB(3, this.HRs.computeSize());
      }
      i = i + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.alV(5);
      paramInt = i;
      if (this.HRt != null) {
        paramInt = i + f.a.a.a.lB(6, this.HRt.computeSize());
      }
      i = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(153317);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        egi localegi = (egi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153317);
          return -1;
        case 1: 
          localegi.HRr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 2: 
          localegi.Hsm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localegi.HRs = ((ddu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 4: 
          localegi.HQZ = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153317);
          return 0;
        case 5: 
          localegi.HRb = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153317);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localegi.HRt = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        }
        localegi.HRc = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(153317);
        return 0;
      }
      AppMethodBeat.o(153317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egi
 * JD-Core Version:    0.7.0.1
 */