package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends cvc
{
  public String FqD;
  public String FqE;
  public String FqF;
  public LinkedList<dw> FqG;
  public int FqH;
  public String FqI;
  public int FqJ;
  public String FqK;
  public int OpCode;
  public String SSID;
  public String URL;
  
  public ac()
  {
    AppMethodBeat.i(32095);
    this.FqG = new LinkedList();
    AppMethodBeat.o(32095);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      if (this.SSID != null) {
        paramVarArgs.d(3, this.SSID);
      }
      if (this.FqD != null) {
        paramVarArgs.d(4, this.FqD);
      }
      if (this.FqE != null) {
        paramVarArgs.d(5, this.FqE);
      }
      if (this.FqF != null) {
        paramVarArgs.d(6, this.FqF);
      }
      paramVarArgs.aS(7, this.OpCode);
      paramVarArgs.e(8, 8, this.FqG);
      paramVarArgs.aS(9, this.FqH);
      if (this.FqI != null) {
        paramVarArgs.d(10, this.FqI);
      }
      paramVarArgs.aS(11, this.FqJ);
      if (this.FqK != null) {
        paramVarArgs.d(12, this.FqK);
      }
      AppMethodBeat.o(32096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1032;
      }
    }
    label1032:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.URL);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.SSID);
      }
      paramInt = i;
      if (this.FqD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FqD);
      }
      i = paramInt;
      if (this.FqE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FqE);
      }
      paramInt = i;
      if (this.FqF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FqF);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.OpCode) + f.a.a.a.c(8, 8, this.FqG) + f.a.a.b.b.a.bz(9, this.FqH);
      paramInt = i;
      if (this.FqI != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FqI);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.FqJ);
      paramInt = i;
      if (this.FqK != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FqK);
      }
      AppMethodBeat.o(32096);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FqG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32096);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32096);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 2: 
          localac.URL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 3: 
          localac.SSID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 4: 
          localac.FqD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 5: 
          localac.FqE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 6: 
          localac.FqF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 7: 
          localac.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32096);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.FqG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 9: 
          localac.FqH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32096);
          return 0;
        case 10: 
          localac.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 11: 
          localac.FqJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32096);
          return 0;
        }
        localac.FqK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32096);
        return 0;
      }
      AppMethodBeat.o(32096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */