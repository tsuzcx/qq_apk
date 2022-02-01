package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends cvc
{
  public String FpH;
  public LinkedList<j> FpL;
  public bb FpM;
  public long FpN;
  public String FpO;
  public String FpP;
  public String FpQ;
  public long FpT;
  public int scene;
  public String title;
  
  public h()
  {
    AppMethodBeat.i(91318);
    this.FpL = new LinkedList();
    AppMethodBeat.o(91318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aY(3, this.FpT);
      paramVarArgs.e(5, 8, this.FpL);
      paramVarArgs.aS(7, this.scene);
      if (this.FpH != null) {
        paramVarArgs.d(8, this.FpH);
      }
      if (this.FpM != null)
      {
        paramVarArgs.lC(9, this.FpM.computeSize());
        this.FpM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.FpN);
      if (this.FpO != null) {
        paramVarArgs.d(11, this.FpO);
      }
      if (this.FpP != null) {
        paramVarArgs.d(12, this.FpP);
      }
      if (this.FpQ != null) {
        paramVarArgs.d(13, this.FpQ);
      }
      AppMethodBeat.o(91319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1054;
      }
    }
    label1054:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i = i + f.a.a.b.b.a.p(3, this.FpT) + f.a.a.a.c(5, 8, this.FpL) + f.a.a.b.b.a.bz(7, this.scene);
      paramInt = i;
      if (this.FpH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FpH);
      }
      i = paramInt;
      if (this.FpM != null) {
        i = paramInt + f.a.a.a.lB(9, this.FpM.computeSize());
      }
      i += f.a.a.b.b.a.p(10, this.FpN);
      paramInt = i;
      if (this.FpO != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FpO);
      }
      i = paramInt;
      if (this.FpP != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FpP);
      }
      paramInt = i;
      if (this.FpQ != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FpQ);
      }
      AppMethodBeat.o(91319);
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
        AppMethodBeat.o(91319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 6: 
        default: 
          AppMethodBeat.o(91319);
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
            localh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 2: 
          localh.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 3: 
          localh.FpT = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91319);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.FpL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 7: 
          localh.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91319);
          return 0;
        case 8: 
          localh.FpH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.FpM = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91319);
          return 0;
        case 10: 
          localh.FpN = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91319);
          return 0;
        case 11: 
          localh.FpO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91319);
          return 0;
        case 12: 
          localh.FpP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91319);
          return 0;
        }
        localh.FpQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91319);
        return 0;
      }
      AppMethodBeat.o(91319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.h
 * JD-Core Version:    0.7.0.1
 */