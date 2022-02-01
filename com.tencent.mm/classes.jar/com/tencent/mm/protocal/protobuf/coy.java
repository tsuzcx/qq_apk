package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coy
  extends ckq
{
  public int DIk;
  public String EiR;
  public String gKr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74669);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EiR != null) {
        paramVarArgs.d(2, this.EiR);
      }
      if (this.gKr != null) {
        paramVarArgs.d(3, this.gKr);
      }
      paramVarArgs.aR(4, this.DIk);
      AppMethodBeat.o(74669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EiR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EiR);
      }
      i = paramInt;
      if (this.gKr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKr);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.DIk);
      AppMethodBeat.o(74669);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(74669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coy localcoy = (coy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74669);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoy.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74669);
          return 0;
        case 2: 
          localcoy.EiR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(74669);
          return 0;
        case 3: 
          localcoy.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(74669);
          return 0;
        }
        localcoy.DIk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(74669);
        return 0;
      }
      AppMethodBeat.o(74669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coy
 * JD-Core Version:    0.7.0.1
 */