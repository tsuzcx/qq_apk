package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class qz
  extends dop
{
  public String CpJ;
  public String KHM;
  public String KHN;
  public String KHO;
  public int KHQ;
  public b KXS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91365);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KHM != null) {
        paramVarArgs.e(2, this.KHM);
      }
      if (this.KHN != null) {
        paramVarArgs.e(3, this.KHN);
      }
      if (this.CpJ != null) {
        paramVarArgs.e(4, this.CpJ);
      }
      paramVarArgs.aM(5, this.KHQ);
      if (this.KXS != null) {
        paramVarArgs.c(6, this.KXS);
      }
      if (this.KHO != null) {
        paramVarArgs.e(7, this.KHO);
      }
      AppMethodBeat.o(91365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KHM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KHM);
      }
      i = paramInt;
      if (this.KHN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KHN);
      }
      paramInt = i;
      if (this.CpJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.CpJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KHQ);
      paramInt = i;
      if (this.KXS != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.KXS);
      }
      i = paramInt;
      if (this.KHO != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KHO);
      }
      AppMethodBeat.o(91365);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        qz localqz = (qz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91365);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91365);
          return 0;
        case 2: 
          localqz.KHM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 3: 
          localqz.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 4: 
          localqz.CpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 5: 
          localqz.KHQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91365);
          return 0;
        case 6: 
          localqz.KXS = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91365);
          return 0;
        }
        localqz.KHO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91365);
        return 0;
      }
      AppMethodBeat.o(91365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qz
 * JD-Core Version:    0.7.0.1
 */