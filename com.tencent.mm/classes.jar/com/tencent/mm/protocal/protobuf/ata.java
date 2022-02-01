package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ata
  extends cvc
{
  public String FDJ;
  public String Gra;
  public String Grb;
  public String Grc;
  public String wDU;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91466);
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
      if (this.FDJ != null) {
        paramVarArgs.d(3, this.FDJ);
      }
      if (this.wDU != null) {
        paramVarArgs.d(4, this.wDU);
      }
      if (this.Grb != null) {
        paramVarArgs.d(5, this.Grb);
      }
      if (this.Grc != null) {
        paramVarArgs.d(6, this.Grc);
      }
      if (this.xbo != null) {
        paramVarArgs.d(7, this.xbo);
      }
      AppMethodBeat.o(91466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gra != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gra);
      }
      i = paramInt;
      if (this.FDJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDJ);
      }
      paramInt = i;
      if (this.wDU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wDU);
      }
      i = paramInt;
      if (this.Grb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Grb);
      }
      paramInt = i;
      if (this.Grc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Grc);
      }
      i = paramInt;
      if (this.xbo != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xbo);
      }
      AppMethodBeat.o(91466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ata localata = (ata)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91466);
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
            localata.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91466);
          return 0;
        case 2: 
          localata.Gra = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 3: 
          localata.FDJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 4: 
          localata.wDU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 5: 
          localata.Grb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 6: 
          localata.Grc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91466);
          return 0;
        }
        localata.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91466);
        return 0;
      }
      AppMethodBeat.o(91466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ata
 * JD-Core Version:    0.7.0.1
 */