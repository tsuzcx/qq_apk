package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgg
  extends cvc
{
  public String FqI;
  public String dmM;
  public String dpf;
  public String tmO;
  public String tmP;
  public String tmQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dmM != null) {
        paramVarArgs.d(2, this.dmM);
      }
      if (this.tmO != null) {
        paramVarArgs.d(3, this.tmO);
      }
      if (this.tmP != null) {
        paramVarArgs.d(4, this.tmP);
      }
      if (this.tmQ != null) {
        paramVarArgs.d(5, this.tmQ);
      }
      if (this.dpf != null) {
        paramVarArgs.d(6, this.dpf);
      }
      if (this.FqI != null) {
        paramVarArgs.d(7, this.FqI);
      }
      AppMethodBeat.o(32262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label687;
      }
    }
    label687:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dmM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dmM);
      }
      i = paramInt;
      if (this.tmO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tmO);
      }
      paramInt = i;
      if (this.tmP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tmP);
      }
      i = paramInt;
      if (this.tmQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tmQ);
      }
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dpf);
      }
      i = paramInt;
      if (this.FqI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FqI);
      }
      AppMethodBeat.o(32262);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgg localbgg = (bgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32262);
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
            localbgg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32262);
          return 0;
        case 2: 
          localbgg.dmM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 3: 
          localbgg.tmO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 4: 
          localbgg.tmP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 5: 
          localbgg.tmQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 6: 
          localbgg.dpf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32262);
          return 0;
        }
        localbgg.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32262);
        return 0;
      }
      AppMethodBeat.o(32262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgg
 * JD-Core Version:    0.7.0.1
 */