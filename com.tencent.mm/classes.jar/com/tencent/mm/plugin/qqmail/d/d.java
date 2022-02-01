package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class d
  extends cvc
{
  public int xbl;
  public String xbm;
  public String xbn;
  public String xbo;
  public String xbp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xbl);
      if (this.xbm != null) {
        paramVarArgs.d(3, this.xbm);
      }
      if (this.xbn != null) {
        paramVarArgs.d(4, this.xbn);
      }
      if (this.xbo != null) {
        paramVarArgs.d(5, this.xbo);
      }
      if (this.xbp != null) {
        paramVarArgs.d(6, this.xbp);
      }
      AppMethodBeat.o(215194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xbl);
      paramInt = i;
      if (this.xbm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.xbm);
      }
      i = paramInt;
      if (this.xbn != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.xbn);
      }
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xbo);
      }
      i = paramInt;
      if (this.xbp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.xbp);
      }
      AppMethodBeat.o(215194);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215194);
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
            locald.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215194);
          return 0;
        case 2: 
          locald.xbl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215194);
          return 0;
        case 3: 
          locald.xbm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215194);
          return 0;
        case 4: 
          locald.xbn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215194);
          return 0;
        case 5: 
          locald.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215194);
          return 0;
        }
        locald.xbp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(215194);
        return 0;
      }
      AppMethodBeat.o(215194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.d
 * JD-Core Version:    0.7.0.1
 */