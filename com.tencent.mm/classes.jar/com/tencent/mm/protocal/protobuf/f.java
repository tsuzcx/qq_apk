package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends cvc
{
  public String FpH;
  public int FpJ;
  public long FpK;
  public LinkedList<String> FpL;
  public bb FpM;
  public long FpN;
  public String FpO;
  public String FpP;
  public String FpQ;
  public int scene;
  public String title;
  
  public f()
  {
    AppMethodBeat.i(91315);
    this.FpL = new LinkedList();
    AppMethodBeat.o(91315);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91316);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FpJ);
      paramVarArgs.aY(3, this.FpK);
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      paramVarArgs.e(5, 1, this.FpL);
      paramVarArgs.aS(6, this.scene);
      if (this.FpH != null) {
        paramVarArgs.d(7, this.FpH);
      }
      if (this.FpM != null)
      {
        paramVarArgs.lC(8, this.FpM.computeSize());
        this.FpM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.FpN);
      if (this.FpO != null) {
        paramVarArgs.d(10, this.FpO);
      }
      if (this.FpP != null) {
        paramVarArgs.d(11, this.FpP);
      }
      if (this.FpQ != null) {
        paramVarArgs.d(12, this.FpQ);
      }
      AppMethodBeat.o(91316);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FpJ) + f.a.a.b.b.a.p(3, this.FpK);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt + f.a.a.a.c(5, 1, this.FpL) + f.a.a.b.b.a.bz(6, this.scene);
      paramInt = i;
      if (this.FpH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FpH);
      }
      i = paramInt;
      if (this.FpM != null) {
        i = paramInt + f.a.a.a.lB(8, this.FpM.computeSize());
      }
      i += f.a.a.b.b.a.p(9, this.FpN);
      paramInt = i;
      if (this.FpO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FpO);
      }
      i = paramInt;
      if (this.FpP != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FpP);
      }
      paramInt = i;
      if (this.FpQ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FpQ);
      }
      AppMethodBeat.o(91316);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FpL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91316);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91316);
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
            localf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 2: 
          localf.FpJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91316);
          return 0;
        case 3: 
          localf.FpK = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91316);
          return 0;
        case 4: 
          localf.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 5: 
          localf.FpL.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91316);
          return 0;
        case 6: 
          localf.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91316);
          return 0;
        case 7: 
          localf.FpH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.FpM = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91316);
          return 0;
        case 9: 
          localf.FpN = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91316);
          return 0;
        case 10: 
          localf.FpO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91316);
          return 0;
        case 11: 
          localf.FpP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91316);
          return 0;
        }
        localf.FpQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91316);
        return 0;
      }
      AppMethodBeat.o(91316);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.f
 * JD-Core Version:    0.7.0.1
 */