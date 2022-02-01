package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ve
  extends cvc
{
  public String FUC;
  public String FUD;
  public int FUE;
  public String FUF;
  public String FUG;
  public String FUH;
  public String FUI;
  public int FUJ;
  public String FUw;
  public int channel;
  public int vls;
  public String xYV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUC == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(72437);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FUC != null) {
        paramVarArgs.d(2, this.FUC);
      }
      paramVarArgs.aS(3, this.vls);
      if (this.FUD != null) {
        paramVarArgs.d(4, this.FUD);
      }
      if (this.xYV != null) {
        paramVarArgs.d(5, this.xYV);
      }
      paramVarArgs.aS(6, this.FUE);
      paramVarArgs.aS(7, this.channel);
      if (this.FUF != null) {
        paramVarArgs.d(8, this.FUF);
      }
      if (this.FUw != null) {
        paramVarArgs.d(9, this.FUw);
      }
      if (this.FUG != null) {
        paramVarArgs.d(10, this.FUG);
      }
      if (this.FUH != null) {
        paramVarArgs.d(11, this.FUH);
      }
      if (this.FUI != null) {
        paramVarArgs.d(12, this.FUI);
      }
      paramVarArgs.aS(13, this.FUJ);
      AppMethodBeat.o(72437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FUC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FUC);
      }
      i += f.a.a.b.b.a.bz(3, this.vls);
      paramInt = i;
      if (this.FUD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUD);
      }
      i = paramInt;
      if (this.xYV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.xYV);
      }
      i = i + f.a.a.b.b.a.bz(6, this.FUE) + f.a.a.b.b.a.bz(7, this.channel);
      paramInt = i;
      if (this.FUF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FUF);
      }
      i = paramInt;
      if (this.FUw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FUw);
      }
      paramInt = i;
      if (this.FUG != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FUG);
      }
      i = paramInt;
      if (this.FUH != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FUH);
      }
      paramInt = i;
      if (this.FUI != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FUI);
      }
      i = f.a.a.b.b.a.bz(13, this.FUJ);
      AppMethodBeat.o(72437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FUC == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_name");
          AppMethodBeat.o(72437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ve localve = (ve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72437);
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
            localve.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72437);
          return 0;
        case 2: 
          localve.FUC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 3: 
          localve.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72437);
          return 0;
        case 4: 
          localve.FUD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 5: 
          localve.xYV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 6: 
          localve.FUE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72437);
          return 0;
        case 7: 
          localve.channel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72437);
          return 0;
        case 8: 
          localve.FUF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 9: 
          localve.FUw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 10: 
          localve.FUG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 11: 
          localve.FUH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 12: 
          localve.FUI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72437);
          return 0;
        }
        localve.FUJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72437);
        return 0;
      }
      AppMethodBeat.o(72437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ve
 * JD-Core Version:    0.7.0.1
 */