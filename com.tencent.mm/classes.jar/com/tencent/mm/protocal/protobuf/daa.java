package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class daa
  extends cvc
{
  public String Fwt;
  public String Hgt;
  public String Hqt;
  public String Hqu;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hgt != null) {
        paramVarArgs.d(2, this.Hgt);
      }
      if (this.Hqt != null) {
        paramVarArgs.d(3, this.Hqt);
      }
      if (this.Hqu != null) {
        paramVarArgs.d(4, this.Hqu);
      }
      if (this.Fwt != null) {
        paramVarArgs.d(5, this.Fwt);
      }
      paramVarArgs.aS(6, this.Scene);
      AppMethodBeat.o(215759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hgt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hgt);
      }
      i = paramInt;
      if (this.Hqt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hqt);
      }
      paramInt = i;
      if (this.Hqu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hqu);
      }
      i = paramInt;
      if (this.Fwt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fwt);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Scene);
      AppMethodBeat.o(215759);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        daa localdaa = (daa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215759);
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
            localdaa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215759);
          return 0;
        case 2: 
          localdaa.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215759);
          return 0;
        case 3: 
          localdaa.Hqt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215759);
          return 0;
        case 4: 
          localdaa.Hqu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215759);
          return 0;
        case 5: 
          localdaa.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215759);
          return 0;
        }
        localdaa.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(215759);
        return 0;
      }
      AppMethodBeat.o(215759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daa
 * JD-Core Version:    0.7.0.1
 */