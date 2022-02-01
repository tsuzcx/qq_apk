package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aym
  extends ckq
{
  public String DwS;
  public String DwT;
  public int Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DwS != null) {
        paramVarArgs.d(2, this.DwS);
      }
      paramVarArgs.aR(3, this.Version);
      if (this.DwT != null) {
        paramVarArgs.d(4, this.DwT);
      }
      AppMethodBeat.o(91504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DwS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DwS);
      }
      i += f.a.a.b.b.a.bA(3, this.Version);
      paramInt = i;
      if (this.DwT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DwT);
      }
      AppMethodBeat.o(91504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aym localaym = (aym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91504);
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
            localaym.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91504);
          return 0;
        case 2: 
          localaym.DwS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91504);
          return 0;
        case 3: 
          localaym.Version = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91504);
          return 0;
        }
        localaym.DwT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91504);
        return 0;
      }
      AppMethodBeat.o(91504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aym
 * JD-Core Version:    0.7.0.1
 */