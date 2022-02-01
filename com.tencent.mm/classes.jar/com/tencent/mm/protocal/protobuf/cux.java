package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cux
  extends cvw
{
  public b HFA;
  public boolean HFB;
  public boolean HFC;
  public float HFz;
  public float dBu;
  public String dJb;
  public float dzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.y(2, this.dBu);
      paramVarArgs.y(3, this.dzE);
      paramVarArgs.y(4, this.HFz);
      if (this.HFA != null) {
        paramVarArgs.c(5, this.HFA);
      }
      if (this.dJb != null) {
        paramVarArgs.d(6, this.dJb);
      }
      paramVarArgs.bC(7, this.HFB);
      paramVarArgs.bC(8, this.HFC);
      AppMethodBeat.o(114064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label643;
      }
    }
    label643:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amE(2) + f.a.a.b.b.a.amE(3) + f.a.a.b.b.a.amE(4);
      paramInt = i;
      if (this.HFA != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.HFA);
      }
      i = paramInt;
      if (this.dJb != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dJb);
      }
      paramInt = f.a.a.b.b.a.amF(7);
      int j = f.a.a.b.b.a.amF(8);
      AppMethodBeat.o(114064);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cux localcux = (cux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114064);
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
            localcux.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114064);
          return 0;
        case 2: 
          localcux.dBu = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(114064);
          return 0;
        case 3: 
          localcux.dzE = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(114064);
          return 0;
        case 4: 
          localcux.HFz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(114064);
          return 0;
        case 5: 
          localcux.HFA = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(114064);
          return 0;
        case 6: 
          localcux.dJb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114064);
          return 0;
        case 7: 
          localcux.HFB = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(114064);
          return 0;
        }
        localcux.HFC = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(114064);
        return 0;
      }
      AppMethodBeat.o(114064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cux
 * JD-Core Version:    0.7.0.1
 */