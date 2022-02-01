package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csk
  extends cvc
{
  public String Cyu;
  public String FYP;
  public int HeX;
  public String Hfb;
  public String Hfc;
  public int uxm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HeX);
      if (this.Hfc != null) {
        paramVarArgs.d(3, this.Hfc);
      }
      if (this.FYP != null) {
        paramVarArgs.d(4, this.FYP);
      }
      paramVarArgs.aS(5, this.uxm);
      if (this.Hfb != null) {
        paramVarArgs.d(6, this.Hfb);
      }
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HeX);
      paramInt = i;
      if (this.Hfc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hfc);
      }
      i = paramInt;
      if (this.FYP != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FYP);
      }
      i += f.a.a.b.b.a.bz(5, this.uxm);
      paramInt = i;
      if (this.Hfb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hfb);
      }
      i = paramInt;
      if (this.Cyu != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91665);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csk localcsk = (csk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91665);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91665);
          return 0;
        case 2: 
          localcsk.HeX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91665);
          return 0;
        case 3: 
          localcsk.Hfc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 4: 
          localcsk.FYP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 5: 
          localcsk.uxm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91665);
          return 0;
        case 6: 
          localcsk.Hfb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91665);
          return 0;
        }
        localcsk.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91665);
        return 0;
      }
      AppMethodBeat.o(91665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csk
 * JD-Core Version:    0.7.0.1
 */