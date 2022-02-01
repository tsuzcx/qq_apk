package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjl
  extends ckq
{
  public String DTs;
  public String EeE;
  public int dvJ;
  public String sZn;
  public String tdE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sZn != null) {
        paramVarArgs.d(2, this.sZn);
      }
      if (this.DTs != null) {
        paramVarArgs.d(3, this.DTs);
      }
      paramVarArgs.aR(4, this.dvJ);
      if (this.tdE != null) {
        paramVarArgs.d(5, this.tdE);
      }
      if (this.EeE != null) {
        paramVarArgs.d(6, this.EeE);
      }
      AppMethodBeat.o(116341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sZn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sZn);
      }
      i = paramInt;
      if (this.DTs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DTs);
      }
      i += f.a.a.b.b.a.bA(4, this.dvJ);
      paramInt = i;
      if (this.tdE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tdE);
      }
      i = paramInt;
      if (this.EeE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EeE);
      }
      AppMethodBeat.o(116341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjl localcjl = (cjl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116341);
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
            localcjl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116341);
          return 0;
        case 2: 
          localcjl.sZn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 3: 
          localcjl.DTs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 4: 
          localcjl.dvJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(116341);
          return 0;
        case 5: 
          localcjl.tdE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(116341);
          return 0;
        }
        localcjl.EeE = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(116341);
        return 0;
      }
      AppMethodBeat.o(116341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjl
 * JD-Core Version:    0.7.0.1
 */