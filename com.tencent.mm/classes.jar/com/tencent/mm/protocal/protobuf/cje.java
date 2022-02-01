package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cje
  extends cvc
{
  public String FDD;
  public String FWa;
  public String FXe;
  public String FXf;
  public String FXg;
  public String FXh;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.FXe != null) {
        paramVarArgs.d(3, this.FXe);
      }
      if (this.FDD != null) {
        paramVarArgs.d(4, this.FDD);
      }
      if (this.FXf != null) {
        paramVarArgs.d(5, this.FXf);
      }
      if (this.FXg != null) {
        paramVarArgs.d(6, this.FXg);
      }
      if (this.FXh != null) {
        paramVarArgs.d(7, this.FXh);
      }
      if (this.FWa != null) {
        paramVarArgs.d(8, this.FWa);
      }
      AppMethodBeat.o(91590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.FXe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FXe);
      }
      paramInt = i;
      if (this.FDD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDD);
      }
      i = paramInt;
      if (this.FXf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FXf);
      }
      paramInt = i;
      if (this.FXg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FXg);
      }
      i = paramInt;
      if (this.FXh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FXh);
      }
      paramInt = i;
      if (this.FWa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FWa);
      }
      AppMethodBeat.o(91590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cje localcje = (cje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91590);
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
            localcje.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91590);
          return 0;
        case 2: 
          localcje.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 3: 
          localcje.FXe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 4: 
          localcje.FDD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 5: 
          localcje.FXf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 6: 
          localcje.FXg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 7: 
          localcje.FXh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91590);
          return 0;
        }
        localcje.FWa = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91590);
        return 0;
      }
      AppMethodBeat.o(91590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cje
 * JD-Core Version:    0.7.0.1
 */