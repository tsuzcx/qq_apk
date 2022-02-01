package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dks
  extends cvc
{
  public String Gra;
  public String Grb;
  public String Grc;
  public String Gzq;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91704);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gra != null) {
        paramVarArgs.d(2, this.Gra);
      }
      if (this.Gzq != null) {
        paramVarArgs.d(3, this.Gzq);
      }
      if (this.Grb != null) {
        paramVarArgs.d(4, this.Grb);
      }
      if (this.Grc != null) {
        paramVarArgs.d(5, this.Grc);
      }
      if (this.xbo != null) {
        paramVarArgs.d(6, this.xbo);
      }
      AppMethodBeat.o(91704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gra != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gra);
      }
      i = paramInt;
      if (this.Gzq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gzq);
      }
      paramInt = i;
      if (this.Grb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Grb);
      }
      i = paramInt;
      if (this.Grc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Grc);
      }
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.xbo);
      }
      AppMethodBeat.o(91704);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91704);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dks localdks = (dks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91704);
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
            localdks.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91704);
          return 0;
        case 2: 
          localdks.Gra = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91704);
          return 0;
        case 3: 
          localdks.Gzq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91704);
          return 0;
        case 4: 
          localdks.Grb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91704);
          return 0;
        case 5: 
          localdks.Grc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91704);
          return 0;
        }
        localdks.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91704);
        return 0;
      }
      AppMethodBeat.o(91704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dks
 * JD-Core Version:    0.7.0.1
 */