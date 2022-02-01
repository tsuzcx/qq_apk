package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cte
  extends cvw
{
  public String CPZ;
  public String Gro;
  public String HyB;
  public String HyC;
  public int Hyx;
  public int uIM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hyx);
      if (this.HyC != null) {
        paramVarArgs.d(3, this.HyC);
      }
      if (this.Gro != null) {
        paramVarArgs.d(4, this.Gro);
      }
      paramVarArgs.aS(5, this.uIM);
      if (this.HyB != null) {
        paramVarArgs.d(6, this.HyB);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hyx);
      paramInt = i;
      if (this.HyC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HyC);
      }
      i = paramInt;
      if (this.Gro != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Gro);
      }
      i += f.a.a.b.b.a.bz(5, this.uIM);
      paramInt = i;
      if (this.HyB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HyB);
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91665);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cte localcte = (cte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91665);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcte.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91665);
          return 0;
        case 2: 
          localcte.Hyx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91665);
          return 0;
        case 3: 
          localcte.HyC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 4: 
          localcte.Gro = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 5: 
          localcte.uIM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91665);
          return 0;
        case 6: 
          localcte.HyB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91665);
          return 0;
        }
        localcte.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91665);
        return 0;
      }
      AppMethodBeat.o(91665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cte
 * JD-Core Version:    0.7.0.1
 */