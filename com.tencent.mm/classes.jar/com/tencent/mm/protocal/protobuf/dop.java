package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dop
  extends com.tencent.mm.bx.a
{
  public String EEF;
  public dnp EEK;
  public String EEV;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147812);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EEK == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147812);
        throw paramVarArgs;
      }
      if (this.EEK != null)
      {
        paramVarArgs.kX(1, this.EEK.computeSize());
        this.EEK.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.EEF != null) {
        paramVarArgs.d(3, this.EEF);
      }
      if (this.EEV != null) {
        paramVarArgs.d(4, this.EEV);
      }
      AppMethodBeat.o(147812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EEK == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.a.kW(1, this.EEK.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.EEF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EEF);
      }
      paramInt = i;
      if (this.EEV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EEV);
      }
      AppMethodBeat.o(147812);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EEK == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dop localdop = (dop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147812);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dnp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdop.EEK = ((dnp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147812);
          return 0;
        case 2: 
          localdop.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147812);
          return 0;
        case 3: 
          localdop.EEF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147812);
          return 0;
        }
        localdop.EEV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(147812);
        return 0;
      }
      AppMethodBeat.o(147812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dop
 * JD-Core Version:    0.7.0.1
 */